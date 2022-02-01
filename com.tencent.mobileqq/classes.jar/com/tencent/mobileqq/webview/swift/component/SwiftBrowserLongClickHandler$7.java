package com.tencent.mobileqq.webview.swift.component;

import android.os.Bundle;
import android.util.Base64;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;

class SwiftBrowserLongClickHandler$7
  implements Runnable
{
  SwiftBrowserLongClickHandler$7(SwiftBrowserLongClickHandler paramSwiftBrowserLongClickHandler, String paramString, IX5WebViewExtension paramIX5WebViewExtension) {}
  
  public void run()
  {
    boolean bool = false;
    Object localObject1 = null;
    try
    {
      Object localObject2 = FileUtils.readFile(this.a);
      if (localObject2 != null)
      {
        localObject2 = Base64.encodeToString((byte[])localObject2, 0);
        localObject1 = localObject2;
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("x5QueryImage. FileUtils.readFile returns null, filepath:");
        ((StringBuilder)localObject2).append(this.a);
        QLog.e("SwiftBrowserLongClickHandler", 1, ((StringBuilder)localObject2).toString());
      }
    }
    catch (Exception localException)
    {
      QLog.e("SwiftBrowserLongClickHandler", 1, "x5QueryImage. read from filePath error", localException);
    }
    if (localObject1 != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putCharSequence("imageBase64", (CharSequence)localObject1);
      localObject1 = (Boolean)this.b.invokeMiscMethod("imageQuery", localBundle);
      if (localObject1 != null) {
        bool = ((Boolean)localObject1).booleanValue();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("x5QueryImage. query result:");
      ((StringBuilder)localObject1).append(bool);
      QLog.e("SwiftBrowserLongClickHandler", 1, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.7
 * JD-Core Version:    0.7.0.1
 */