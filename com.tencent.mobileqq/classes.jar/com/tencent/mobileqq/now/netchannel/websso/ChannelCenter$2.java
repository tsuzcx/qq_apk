package com.tencent.mobileqq.now.netchannel.websso;

import android.util.Log;

class ChannelCenter$2
  implements Runnable
{
  ChannelCenter$2(ChannelCenter paramChannelCenter, int paramInt, IChannelListener paramIChannelListener, String paramString) {}
  
  public void run()
  {
    Log.d("ChannelCenter", "WebServiceSSO--onException final cmd=" + this.jdField_a_of_type_Int);
    if (ChannelCenter.a(this.this$0))
    {
      Log.d("ChannelCenter", "now live quit.");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoIChannelListener.a(1000002, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.netchannel.websso.ChannelCenter.2
 * JD-Core Version:    0.7.0.1
 */