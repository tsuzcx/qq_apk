package com.tencent.mobileqq.jsp;

import atki;
import atkj;
import bejc;
import bejv;
import bejw;
import com.tencent.smtt.sdk.WebView;

public class X5ApiPlugin$1
  implements Runnable
{
  public X5ApiPlugin$1(atki paramatki, atkj paramatkj, WebView paramWebView) {}
  
  public void run()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (bejv.a(this.jdField_a_of_type_Atkj.a))
    {
      bejw localbejw = bejv.a(this.jdField_a_of_type_Atkj.a);
      localObject1 = localObject2;
      if (localbejw != null) {
        localObject1 = localbejw.b;
      }
    }
    bejc.a(this.jdField_a_of_type_ComTencentSmttSdkWebView, this.jdField_a_of_type_Atkj.a, (String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.X5ApiPlugin.1
 * JD-Core Version:    0.7.0.1
 */