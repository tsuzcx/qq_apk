package com.tencent.mobileqq.jsp;

import awcr;
import awcs;
import bihz;
import biio;
import biip;
import com.tencent.smtt.sdk.WebView;

public class X5ApiPlugin$1
  implements Runnable
{
  public X5ApiPlugin$1(awcr paramawcr, awcs paramawcs, WebView paramWebView) {}
  
  public void run()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (biio.a(this.jdField_a_of_type_Awcs.a))
    {
      biip localbiip = biio.a(this.jdField_a_of_type_Awcs.a);
      localObject1 = localObject2;
      if (localbiip != null) {
        localObject1 = localbiip.b;
      }
    }
    bihz.a(this.jdField_a_of_type_ComTencentSmttSdkWebView, this.jdField_a_of_type_Awcs.a, (String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.X5ApiPlugin.1
 * JD-Core Version:    0.7.0.1
 */