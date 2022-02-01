package com.tencent.mobileqq.now.netchannel.websso;

import android.util.Log;
import aywi;
import aywl;

public class ChannelCenter$2
  implements Runnable
{
  public ChannelCenter$2(aywi paramaywi, int paramInt, aywl paramaywl, String paramString) {}
  
  public void run()
  {
    Log.d("ChannelCenter", "WebServiceSSO--onException final cmd=" + this.jdField_a_of_type_Int);
    if (aywi.a(this.this$0))
    {
      Log.d("ChannelCenter", "now live quit.");
      return;
    }
    this.jdField_a_of_type_Aywl.a(1000002, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.netchannel.websso.ChannelCenter.2
 * JD-Core Version:    0.7.0.1
 */