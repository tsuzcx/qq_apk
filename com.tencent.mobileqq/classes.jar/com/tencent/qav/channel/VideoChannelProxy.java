package com.tencent.qav.channel;

import android.content.Context;
import android.os.Bundle;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.avcore.netchannel.AbstractNetChannel;
import com.tencent.common.config.AppSetting;

public class VideoChannelProxy
  extends AbstractNetChannel
  implements VideoChannelCallback
{
  protected Context a;
  protected VideoChannelInterface a;
  
  public VideoChannelProxy(Context paramContext, VideoChannelInterface paramVideoChannelInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentQavChannelVideoChannelInterface = paramVideoChannelInterface;
    this.jdField_a_of_type_ComTencentQavChannelVideoChannelInterface.a(this);
  }
  
  private byte[] a(Bundle paramBundle)
  {
    return paramBundle.getByteArray("buffer");
  }
  
  public void receiveDeviceMsg(Bundle paramBundle) {}
  
  public void receiveMultiVideoAck(Bundle paramBundle)
  {
    receiveMultiVideoMsg(2, a(paramBundle));
  }
  
  public void receiveMultiVideoMsg(Bundle paramBundle)
  {
    receiveMultiVideoMsg(1, a(paramBundle));
  }
  
  public void receiveMultiVideoOfflineMsg(Bundle paramBundle)
  {
    receiveMultiVideoMsg(3, a(paramBundle));
  }
  
  public void receiveSharpVideoAck(Bundle paramBundle) {}
  
  public void receiveSharpVideoMsg(Bundle paramBundle) {}
  
  public void receiveSharpVideoOfflineMsg(Bundle paramBundle) {}
  
  public void receiveVideoConfig(Bundle paramBundle)
  {
    ConfigSystemImpl.a(String.valueOf(AppSetting.a()), this.jdField_a_of_type_AndroidContentContext, a(paramBundle));
  }
  
  public void sendGetGatewayMsg()
  {
    if (this.jdField_a_of_type_ComTencentQavChannelVideoChannelInterface != null) {
      this.jdField_a_of_type_ComTencentQavChannelVideoChannelInterface.sendGetGatewayMsg();
    }
  }
  
  public void sendGetVideoConfig(byte[] paramArrayOfByte) {}
  
  public void sendMultiVideoMsg(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentQavChannelVideoChannelInterface != null) {
      this.jdField_a_of_type_ComTencentQavChannelVideoChannelInterface.sendMultiVideoMsg(paramLong1, paramLong2, paramArrayOfByte);
    }
  }
  
  public void sendSharpVideoMsg(long paramLong, byte[] paramArrayOfByte) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qav.channel.VideoChannelProxy
 * JD-Core Version:    0.7.0.1
 */