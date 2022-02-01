package com.tencent.mobileqq.jsp;

import auws;
import auwt;
import bgxh;
import bgxw;
import bgxx;
import com.tencent.smtt.sdk.WebView;

public class X5ApiPlugin$1
  implements Runnable
{
  public X5ApiPlugin$1(auws paramauws, auwt paramauwt, WebView paramWebView) {}
  
  public void run()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (bgxw.a(this.jdField_a_of_type_Auwt.a))
    {
      bgxx localbgxx = bgxw.a(this.jdField_a_of_type_Auwt.a);
      localObject1 = localObject2;
      if (localbgxx != null) {
        localObject1 = localbgxx.b;
      }
    }
    bgxh.a(this.jdField_a_of_type_ComTencentSmttSdkWebView, this.jdField_a_of_type_Auwt.a, (String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.X5ApiPlugin.1
 * JD-Core Version:    0.7.0.1
 */