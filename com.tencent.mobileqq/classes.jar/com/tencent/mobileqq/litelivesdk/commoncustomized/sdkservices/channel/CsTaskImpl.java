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
  private int b;
  private int c;
  private byte[] d;
  private ChannelCallback e;
  private int f = 0;
  private int g = 10000;
  
  public CsTask callback(ChannelCallback paramChannelCallback)
  {
    this.e = paramChannelCallback;
    return this;
  }
  
  public CsTask cancel()
  {
    this.e = null;
    ThreadCenter.clear(this);
    return this;
  }
  
  public CsTask cmd(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    return this;
  }
  
  public CsTask retryOnError(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public CsTask send(byte[] paramArrayOfByte)
  {
    this.d = paramArrayOfByte;
    a.send(this.b, this.c, paramArrayOfByte, new CsTaskImpl.1(this, paramArrayOfByte));
    ThreadCenter.postDelayedUITask(this, new CsTaskImpl.2(this), this.g);
    return this;
  }
  
  public CsTask timeout(int paramInt)
  {
    this.g = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.channel.CsTaskImpl
 * JD-Core Version:    0.7.0.1
 */