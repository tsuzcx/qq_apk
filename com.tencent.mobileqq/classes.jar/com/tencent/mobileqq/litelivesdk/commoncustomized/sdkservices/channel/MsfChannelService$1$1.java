package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.channel;

import com.tencent.falco.base.libapi.channel.ChannelCallback;
import com.tencent.mobileqq.now.msfilivehead.ForwardRsp;

class MsfChannelService$1$1
  implements Runnable
{
  MsfChannelService$1$1(MsfChannelService.1 param1, ForwardRsp paramForwardRsp) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNowMsfiliveheadForwardRsp.d != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesChannelMsfChannelService$1.a.onError(false, this.jdField_a_of_type_ComTencentMobileqqNowMsfiliveheadForwardRsp.d, "");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesChannelMsfChannelService$1.a.onRecv(this.jdField_a_of_type_ComTencentMobileqqNowMsfiliveheadForwardRsp.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.channel.MsfChannelService.1.1
 * JD-Core Version:    0.7.0.1
 */