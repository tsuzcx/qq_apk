package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.channel;

import com.tencent.falco.base.libapi.channel.ChannelCallback;
import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.channel.helper.CsTask;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.falco.utils.ThreadCenter.HandlerKeyable;

public class CsTaskImpl
  implements CsTask, ThreadCenter.HandlerKeyable
{
  public static ChannelInterface a;
  private int jdField_a_of_type_Int;
  private ChannelCallback jdField_a_of_type_ComTencentFalcoBaseLibapiChannelChannelCallback;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int b;
  private int c = 0;
  private int d = 10000;
  
  public CsTask callback(ChannelCallback paramChannelCallback)
  {
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiChannelChannelCallback = paramChannelCallback;
    return this;
  }
  
  public CsTask cancel()
  {
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiChannelChannelCallback = null;
    ThreadCenter.clear(this);
    return this;
  }
  
  public CsTask cmd(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    return this;
  }
  
  public CsTask retryOnError(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public CsTask send(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    jdField_a_of_type_ComTencentFalcoBaseLibapiChannelChannelInterface.send(this.jdField_a_of_type_Int, this.b, paramArrayOfByte, new CsTaskImpl.1(this, paramArrayOfByte));
    ThreadCenter.postDelayedUITask(this, new CsTaskImpl.2(this), this.d);
    return this;
  }
  
  public CsTask timeout(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.channel.CsTaskImpl
 * JD-Core Version:    0.7.0.1
 */