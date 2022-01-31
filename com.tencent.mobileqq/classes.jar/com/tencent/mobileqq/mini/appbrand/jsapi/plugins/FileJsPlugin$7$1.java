package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.Intent;
import android.os.Bundle;
import aqwa;
import arni;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;

class FileJsPlugin$7$1
  implements ValueCallback<String>
{
  FileJsPlugin$7$1(FileJsPlugin.7 param7) {}
  
  public void onReceiveValue(String paramString)
  {
    QLog.d("[mini] FileJsPlugin", 1, "openFileReader callback  : " + paramString);
    if ((paramString != null) && (paramString.startsWith("http")))
    {
      if (aqwa.a().a() == null)
      {
        paramString = new Bundle();
        paramString.putString("_filename_from_dlg", this.this$1.this$0.jsPluginEngine.getActivityContext().getString(2131694943));
        paramString.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_jc_file");
        Intent localIntent = new Intent("com.tencent.mobileqq.qfile_unifromdownload");
        localIntent.putExtra("param", paramString);
        localIntent.putExtra("url", "http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10386");
        this.this$1.this$0.jsPluginEngine.getActivityContext().sendBroadcast(localIntent);
      }
    }
    else {
      return;
    }
    arni.b(this.this$1.this$0.jsPluginEngine.getActivityContext(), "http://appchannel.html5.qq.com/directdown?app=qqbrowser&channel=10386");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.7.1
 * JD-Core Version:    0.7.0.1
 */