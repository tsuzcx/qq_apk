package com.tencent.mobileqq.webview.swift.component;

import bcfe;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;

public class SwiftBrowserTBSHandler$6
  implements Runnable
{
  public SwiftBrowserTBSHandler$6(bcfe parambcfe) {}
  
  public void run()
  {
    this.this$0.a(MsfSdkUtils.insertMtype("Web", this.this$0.jdField_a_of_type_JavaLangString), 0);
    synchronized (this.this$0.jdField_a_of_type_JavaLangObject)
    {
      this.this$0.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
      this.this$0.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.6
 * JD-Core Version:    0.7.0.1
 */