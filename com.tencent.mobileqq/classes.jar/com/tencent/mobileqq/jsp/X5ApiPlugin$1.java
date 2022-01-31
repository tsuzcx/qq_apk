package com.tencent.mobileqq.jsp;

import arpf;
import arpg;
import bcfs;
import bcgl;
import bcgm;
import com.tencent.smtt.sdk.WebView;

public class X5ApiPlugin$1
  implements Runnable
{
  public X5ApiPlugin$1(arpf paramarpf, arpg paramarpg, WebView paramWebView) {}
  
  public void run()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (bcgl.a(this.jdField_a_of_type_Arpg.a))
    {
      bcgm localbcgm = bcgl.a(this.jdField_a_of_type_Arpg.a);
      localObject1 = localObject2;
      if (localbcgm != null) {
        localObject1 = localbcgm.b;
      }
    }
    bcfs.a(this.jdField_a_of_type_ComTencentSmttSdkWebView, this.jdField_a_of_type_Arpg.a, (String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.X5ApiPlugin.1
 * JD-Core Version:    0.7.0.1
 */