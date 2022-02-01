package com.tencent.mobileqq.webview.swift.component;

import android.os.Bundle;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.open.api.WebViewOpenSdkApi;
import com.tencent.open.downloadnew.DownloadConstants;

class SwiftBrowserTBSHandler$3
  implements Runnable
{
  SwiftBrowserTBSHandler$3(SwiftBrowserTBSHandler paramSwiftBrowserTBSHandler, String paramString1, String paramString2) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    ((SwiftBrowserTBSHandler)localObject).a(MsfSdkUtils.insertMtype("Web", ((SwiftBrowserTBSHandler)localObject).i), 0);
    localObject = new Bundle();
    ((Bundle)localObject).putString(DownloadConstants.b, this.a);
    ((Bundle)localObject).putString(DownloadConstants.j, this.this$0.i);
    ((Bundle)localObject).putInt(DownloadConstants.k, 2);
    ((Bundle)localObject).putString(DownloadConstants.l, this.b);
    ((Bundle)localObject).putBoolean(DownloadConstants.s, false);
    ((Bundle)localObject).putBoolean(DownloadConstants.y, false);
    String str = DownloadConstants.m;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("_");
    localStringBuilder.append(this.a);
    ((Bundle)localObject).putString(str, localStringBuilder.toString());
    WebViewOpenSdkApi.a().a(this.this$0.a, (Bundle)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.3
 * JD-Core Version:    0.7.0.1
 */