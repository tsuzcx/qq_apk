package com.tencent.mobileqq.webview.swift.component;

import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;

class SwiftBrowserTBSHandler$5
  implements Runnable
{
  public void run()
  {
    ??? = this.this$0;
    ((SwiftBrowserTBSHandler)???).a(MsfSdkUtils.insertMtype("Web", ((SwiftBrowserTBSHandler)???).jdField_a_of_type_JavaLangString), 0);
    synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
    {
      this.this$0.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
      this.this$0.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.5
 * JD-Core Version:    0.7.0.1
 */