package com.tencent.mobileqq.now.netchannel.websso;

import android.util.Log;

class ChannelCenter$1$1
  implements Runnable
{
  ChannelCenter$1$1(ChannelCenter.1 param1, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WebServiceSSO--onSuccess final cmd=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoChannelCenter$1.jdField_a_of_type_Int);
    Log.i("ChannelCenter", localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoChannelCenter$1.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoIChannelListener.a(this.jdField_a_of_type_ArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.netchannel.websso.ChannelCenter.1.1
 * JD-Core Version:    0.7.0.1
 */