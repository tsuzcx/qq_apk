package com.tencent.mobileqq.kandian.base.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanageraux.app.UniformDownload;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.util.WeakReferenceHandler;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class OpenWithQQBrowser
  implements Handler.Callback
{
  private Activity a;
  private OpenWithQQBrowser.UiCallback b;
  private boolean c = false;
  private Handler d = null;
  
  public OpenWithQQBrowser(Activity paramActivity, OpenWithQQBrowser.UiCallback paramUiCallback)
  {
    this.a = paramActivity;
    this.b = paramUiCallback;
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (this.c) {
      return;
    }
    this.c = true;
    if (this.a.isFinishing())
    {
      paramContext = this.b;
      if (paramContext != null) {
        paramContext.a();
      }
    }
    else
    {
      paramContext = this.b;
      if (paramContext != null) {
        paramContext.b();
      }
    }
    try
    {
      new Thread(new OpenWithQQBrowser.1(this, paramString3)).start();
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  private void a(String paramString, int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    if (paramInt < 12) {
      localObject1 = localObject2;
    }
    try
    {
      localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      localObject1 = localObject2;
      localHttpURLConnection.setDoInput(true);
      localObject1 = localObject2;
      localHttpURLConnection.setConnectTimeout(20000);
      localObject1 = localObject2;
      localHttpURLConnection.setRequestMethod("GET");
      localObject1 = localObject2;
      localHttpURLConnection.connect();
      localObject1 = localObject2;
      int i = localHttpURLConnection.getResponseCode();
      if ((i != 301) && (i != 302))
      {
        paramString = localObject3;
        if (i != 200) {
          break label285;
        }
        localObject1 = localObject2;
        paramString = new Bundle();
      }
    }
    catch (Throwable paramString)
    {
      HttpURLConnection localHttpURLConnection;
      label174:
      break label299;
    }
    try
    {
      paramString.putLong("_filesize", localHttpURLConnection.getContentLength());
      paramString.putString("qb_param_url", localHttpURLConnection.getURL().toString());
      paramString.putString("param_content_des", "");
      paramString.putString("param_mime_type", localHttpURLConnection.getContentType());
    }
    catch (Throwable localThrowable)
    {
      break label174;
      str = null;
      break label258;
    }
    localObject1 = paramString;
    break label299;
    localObject1 = localObject2;
    paramString = localHttpURLConnection.getHeaderFields().keySet().iterator();
    do
    {
      localObject1 = localObject2;
      if (!paramString.hasNext()) {
        break;
      }
      localObject1 = localObject2;
      str = (String)paramString.next();
      localObject1 = localObject2;
    } while (!"location".equalsIgnoreCase(str));
    localObject1 = localObject2;
    str = localHttpURLConnection.getHeaderField(str);
    label258:
    paramString = localObject3;
    if (str != null)
    {
      localObject1 = localObject2;
      a(MsfSdkUtils.insertMtype("Web", str), paramInt + 1);
      return;
    }
    label285:
    localObject1 = paramString;
    localHttpURLConnection.disconnect();
    localObject1 = paramString;
    label299:
    if (this.d == null) {
      try
      {
        if (this.d == null) {
          this.d = new WeakReferenceHandler(Looper.getMainLooper(), this);
        }
      }
      finally {}
    }
    Message.obtain(this.d, 101, localObject1).sendToTarget();
  }
  
  public boolean a(String paramString)
  {
    return a(paramString, true, "https://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10367", 0);
  }
  
  protected boolean a(String paramString1, boolean paramBoolean, String paramString2, int paramInt)
  {
    boolean bool2 = TextUtils.isEmpty(paramString1);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("KEY_PID", String.valueOf(50079));
    ((HashMap)localObject).put("KEY_EUSESTAT", String.valueOf(5));
    ((HashMap)localObject).put("ChannelID", this.a.getApplicationInfo().processName);
    ((HashMap)localObject).put("PosID", Integer.toString(paramInt));
    String str = MttLoader.getValidQBUrl(this.a, paramString1);
    paramInt = MttLoader.loadUrl(this.a, str, (HashMap)localObject, null);
    if (paramBoolean) {
      if (4 == paramInt)
      {
        localObject = this.a.getResources().getString(2131886085);
        a(this.a, paramString1, (String)localObject, 2131886091, paramString2);
      }
      else if (5 == paramInt)
      {
        localObject = this.a.getResources().getString(2131886084);
        a(this.a, paramString1, (String)localObject, 2131886095, paramString2);
      }
      else if (paramInt != 0)
      {
        localObject = this.a.getResources().getString(2131886085);
        a(this.a, paramString1, (String)localObject, 2131886091, paramString2);
      }
    }
    paramBoolean = bool1;
    if (paramInt == 0) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 101) {
      return false;
    }
    if (!this.a.isFinishing())
    {
      paramMessage = (Bundle)paramMessage.obj;
      if (paramMessage != null)
      {
        Object localObject = this.a.getSharedPreferences("qb_info", 0);
        if (localObject != null)
        {
          paramMessage.putString("param_content_memo", ((SharedPreferences)localObject).getString("content_memo", null));
          paramMessage.putString("param_icon_path", ((SharedPreferences)localObject).getString("icon_url", null));
        }
        localObject = paramMessage.getString("qb_param_url");
        if ((localObject != null) && (((String)localObject).length() != 0))
        {
          paramMessage.remove("qb_param_url");
          UniformDownload.a(this.a, (String)localObject, paramMessage);
        }
      }
    }
    paramMessage = this.b;
    if (paramMessage != null) {
      paramMessage.a();
    }
    this.c = false;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.OpenWithQQBrowser
 * JD-Core Version:    0.7.0.1
 */