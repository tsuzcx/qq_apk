package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.channel;

import com.tencent.falco.base.libapi.channel.ChannelCallback;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.mobileqq.now.msfilivehead.ForwardRsp;

class MsfChannelService$1
  implements ChannelCallback
{
  MsfChannelService$1(MsfChannelService paramMsfChannelService, ChannelCallback paramChannelCallback) {}
  
  public void onError(boolean paramBoolean, int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentFalcoBaseLibapiChannelChannelCallback != null) {
      this.jdField_a_of_type_ComTencentFalcoBaseLibapiChannelChannelCallback.onError(paramBoolean, paramInt, paramString);
    }
  }
  
  public void onRecv(byte[] paramArrayOfByte)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentFalcoBaseLibapiChannelChannelCallback != null)
      {
        paramArrayOfByte = ForwardRsp.a(paramArrayOfByte);
        ThreadCenter.postUITask(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesChannelMsfChannelService, new MsfChannelService.1.1(this, paramArrayOfByte));
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      this.jdField_a_of_type_ComTencentFalcoBaseLibapiChannelChannelCallback.onError(false, -10000, "请求命令字异常");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.channel.MsfChannelService.1
 * JD-Core Version:    0.7.0.1
 */