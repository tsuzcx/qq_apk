package com.tencent.mobileqq.webview.swift.component;

import android.os.Bundle;
import android.util.Base64;
import bdhb;
import beib;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;

public class SwiftBrowserLongClickHandler$7
  implements Runnable
{
  public SwiftBrowserLongClickHandler$7(beib parambeib, String paramString, IX5WebViewExtension paramIX5WebViewExtension) {}
  
  public void run()
  {
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        localObject2 = bdhb.a(this.jdField_a_of_type_JavaLangString);
        if (localObject2 == null) {
          continue;
        }
        localObject2 = Base64.encodeToString((byte[])localObject2, 0);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        Object localObject2;
        QLog.e("SwiftBrowserLongClickHandler", 1, "x5QueryImage. read from filePath error", localException);
        continue;
        boolean bool = false;
        continue;
      }
      if (localObject1 != null)
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putCharSequence("imageBase64", (CharSequence)localObject1);
        localObject1 = (Boolean)this.jdField_a_of_type_ComTencentSmttExportExternalExtensionInterfacesIX5WebViewExtension.invokeMiscMethod("imageQuery", (Bundle)localObject2);
        if (localObject1 == null) {
          continue;
        }
        bool = ((Boolean)localObject1).booleanValue();
        QLog.e("SwiftBrowserLongClickHandler", 1, "x5QueryImage. query result:" + bool);
      }
      return;
      QLog.e("SwiftBrowserLongClickHandler", 1, "x5QueryImage. FileUtils.readFile returns null, filepath:" + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.7
 * JD-Core Version:    0.7.0.1
 */