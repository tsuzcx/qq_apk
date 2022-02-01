package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.channel;

import android.os.Bundle;
import com.tencent.falco.base.libapi.channel.ChannelCallback;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class MsfChannelService$2
  implements EIPCResultCallback
{
  MsfChannelService$2(MsfChannelService paramMsfChannelService, ChannelCallback paramChannelCallback) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    paramEIPCResult = paramEIPCResult.data.getByteArray("rspBytes");
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiChannelChannelCallback.onRecv(paramEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.channel.MsfChannelService.2
 * JD-Core Version:    0.7.0.1
 */