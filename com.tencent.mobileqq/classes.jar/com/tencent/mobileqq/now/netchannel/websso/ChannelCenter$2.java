package com.tencent.mobileqq.now.netchannel.websso;

import android.util.Log;
import axjq;
import axjt;

public class ChannelCenter$2
  implements Runnable
{
  public ChannelCenter$2(axjq paramaxjq, int paramInt, axjt paramaxjt, String paramString) {}
  
  public void run()
  {
    Log.d("ChannelCenter", "WebServiceSSO--onException final cmd=" + this.jdField_a_of_type_Int);
    if (axjq.a(this.this$0))
    {
      Log.d("ChannelCenter", "now live quit.");
      return;
    }
    this.jdField_a_of_type_Axjt.a(1000002, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.netchannel.websso.ChannelCenter.2
 * JD-Core Version:    0.7.0.1
 */