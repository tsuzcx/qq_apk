package com.tencent.mobileqq.jsp;

import arpd;
import arpe;
import bcfe;
import bcfx;
import bcfy;
import com.tencent.smtt.sdk.WebView;

public class X5ApiPlugin$1
  implements Runnable
{
  public X5ApiPlugin$1(arpd paramarpd, arpe paramarpe, WebView paramWebView) {}
  
  public void run()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (bcfx.a(this.jdField_a_of_type_Arpe.a))
    {
      bcfy localbcfy = bcfx.a(this.jdField_a_of_type_Arpe.a);
      localObject1 = localObject2;
      if (localbcfy != null) {
        localObject1 = localbcfy.b;
      }
    }
    bcfe.a(this.jdField_a_of_type_ComTencentSmttSdkWebView, this.jdField_a_of_type_Arpe.a, (String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.X5ApiPlugin.1
 * JD-Core Version:    0.7.0.1
 */