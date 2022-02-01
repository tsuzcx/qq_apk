package com.tencent.mobileqq.wink.editor.music;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import java.io.File;
import mqq.app.MobileQQ;

public class PreloadWebService
  extends Service
{
  private CustomWebView a = null;
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (paramIntent == null) {
      return paramInt1;
    }
    String str = paramIntent.getStringExtra("url");
    Object localObject1;
    if (!TextUtils.isEmpty(str))
    {
      if (this.a == null)
      {
        this.a = new CustomWebView(getBaseContext());
        this.a.setWebViewClient(new PreloadWebService.1(this));
        WebSettings localWebSettings = this.a.getSettings();
        localWebSettings.setJavaScriptEnabled(true);
        localWebSettings.setCacheMode(-1);
        localWebSettings.setDatabaseEnabled(true);
        localObject1 = MobileQQ.getMobileQQ().getQQProcessName();
        if (localObject1 != null)
        {
          int i = ((String)localObject1).lastIndexOf(':');
          if (i > -1)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("_");
            ((StringBuilder)localObject2).append(((String)localObject1).substring(i + 1));
            localObject1 = ((StringBuilder)localObject2).toString();
            break label160;
          }
        }
        localObject1 = "";
        label160:
        Object localObject2 = getApplicationContext();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("database");
        localStringBuilder.append((String)localObject1);
        localWebSettings.setDatabasePath(((Context)localObject2).getDir(localStringBuilder.toString(), 0).getPath());
        localObject2 = getApplicationContext();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("appcache");
        localStringBuilder.append((String)localObject1);
        localWebSettings.setAppCachePath(((Context)localObject2).getDir(localStringBuilder.toString(), 0).getPath());
        localWebSettings.setAppCacheEnabled(true);
      }
      this.a.loadUrl(str);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("preload url:");
      ((StringBuilder)localObject1).append(str);
      QLog.d("PreloadWebService", 2, ((StringBuilder)localObject1).toString());
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.PreloadWebService
 * JD-Core Version:    0.7.0.1
 */