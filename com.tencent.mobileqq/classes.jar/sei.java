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
import com.tencent.biz.pubaccount.util.OpenWithQQBrowser.1;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.smtt.sdk.stat.MttLoader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class sei
  implements Handler.Callback
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private sej jdField_a_of_type_Sej;
  private boolean jdField_a_of_type_Boolean;
  
  public sei(Activity paramActivity, sej paramsej)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Sej = paramsej;
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      if (this.jdField_a_of_type_Sej != null) {
        this.jdField_a_of_type_Sej.a();
      }
    }
    for (;;)
    {
      try
      {
        new Thread(new OpenWithQQBrowser.1(this, paramString3)).start();
        return;
      }
      catch (Throwable paramContext)
      {
        return;
      }
      if (this.jdField_a_of_type_Sej != null) {
        this.jdField_a_of_type_Sej.b();
      }
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (paramInt < 12)
    {
      try
      {
        localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
        localHttpURLConnection.setDoInput(true);
        localHttpURLConnection.setConnectTimeout(20000);
        localHttpURLConnection.setRequestMethod("GET");
        localHttpURLConnection.connect();
        i = localHttpURLConnection.getResponseCode();
        if ((i != 301) && (i != 302)) {
          break label197;
        }
        paramString = localHttpURLConnection.getHeaderFields().keySet().iterator();
        do
        {
          if (!paramString.hasNext()) {
            break;
          }
          str = (String)paramString.next();
        } while (!"location".equalsIgnoreCase(str));
        paramString = localHttpURLConnection.getHeaderField(str);
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          HttpURLConnection localHttpURLConnection;
          int i;
          String str;
          paramString = null;
          continue;
          paramString = null;
          continue;
          paramString = null;
        }
      }
      if (paramString != null)
      {
        a(MsfSdkUtils.insertMtype("Web", paramString), paramInt + 1);
        return;
      }
      paramString = null;
      str = paramString;
    }
    for (;;)
    {
      try
      {
        localHttpURLConnection.disconnect();
        if (this.jdField_a_of_type_AndroidOsHandler == null) {}
        label197:
        try
        {
          if (this.jdField_a_of_type_AndroidOsHandler == null) {
            this.jdField_a_of_type_AndroidOsHandler = new bfob(Looper.getMainLooper(), this);
          }
          Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 101, paramString).sendToTarget();
          return;
        }
        finally {}
        if (i == 200)
        {
          paramString = new Bundle();
          str = paramString;
          paramString.putLong("_filesize", localHttpURLConnection.getContentLength());
          str = paramString;
          paramString.putString("qb_param_url", localHttpURLConnection.getURL().toString());
          str = paramString;
          paramString.putString("param_content_des", "");
          str = paramString;
          paramString.putString("param_mime_type", localHttpURLConnection.getContentType());
        }
      }
      catch (Throwable paramString)
      {
        paramString = str;
        continue;
      }
      paramString = null;
    }
  }
  
  public boolean a(String paramString)
  {
    return a(paramString, true, "http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10367", 0);
  }
  
  protected boolean a(String paramString1, boolean paramBoolean, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("KEY_PID", String.valueOf(50079));
    ((HashMap)localObject).put("KEY_EUSESTAT", String.valueOf(5));
    ((HashMap)localObject).put("ChannelID", this.jdField_a_of_type_AndroidAppActivity.getApplicationInfo().processName);
    ((HashMap)localObject).put("PosID", Integer.toString(paramInt));
    String str = MttLoader.getValidQBUrl(this.jdField_a_of_type_AndroidAppActivity, paramString1);
    paramInt = MttLoader.loadUrl(this.jdField_a_of_type_AndroidAppActivity, str, (HashMap)localObject, null);
    if (paramBoolean)
    {
      if (4 == paramInt)
      {
        localObject = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131689501);
        a(this.jdField_a_of_type_AndroidAppActivity, paramString1, (String)localObject, 2131689507, paramString2);
      }
    }
    else {
      if (paramInt != 0) {
        break label222;
      }
    }
    label222:
    for (paramBoolean = true;; paramBoolean = false)
    {
      return paramBoolean;
      if (5 == paramInt)
      {
        localObject = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131689500);
        a(this.jdField_a_of_type_AndroidAppActivity, paramString1, (String)localObject, 2131689513, paramString2);
        break;
      }
      if (paramInt == 0) {
        break;
      }
      localObject = this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131689501);
      a(this.jdField_a_of_type_AndroidAppActivity, paramString1, (String)localObject, 2131689507, paramString2);
      break;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())
    {
      paramMessage = (Bundle)paramMessage.obj;
      if (paramMessage != null)
      {
        Object localObject = this.jdField_a_of_type_AndroidAppActivity.getSharedPreferences("qb_info", 0);
        if (localObject != null)
        {
          paramMessage.putString("param_content_memo", ((SharedPreferences)localObject).getString("content_memo", null));
          paramMessage.putString("param_icon_path", ((SharedPreferences)localObject).getString("icon_url", null));
        }
        localObject = paramMessage.getString("qb_param_url");
        if ((localObject != null) && (((String)localObject).length() != 0))
        {
          paramMessage.remove("qb_param_url");
          aoyd.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject, paramMessage);
        }
      }
    }
    if (this.jdField_a_of_type_Sej != null) {
      this.jdField_a_of_type_Sej.a();
    }
    this.jdField_a_of_type_Boolean = false;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sei
 * JD-Core Version:    0.7.0.1
 */