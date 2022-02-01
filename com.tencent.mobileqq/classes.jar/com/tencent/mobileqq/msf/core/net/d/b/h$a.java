package com.tencent.mobileqq.msf.core.net.d.b;

import com.tencent.qphone.base.util.QLog;
import java.net.DatagramPacket;
import java.util.Arrays;

public class h$a
{
  private byte[] a;
  private int b;
  
  public a a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 65528))
    {
      this.b = paramInt;
      return this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("length invalid: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public a a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length <= 65528))
    {
      this.a = paramArrayOfByte;
      return this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("data invalid: ");
    localStringBuilder.append(Arrays.toString(paramArrayOfByte));
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public h a()
  {
    if ((this.a == null) || (this.b == 0)) {
      QLog.d("UdpRequest", 1, "[create] create empty udp packet.");
    }
    return new h(new DatagramPacket(this.a, this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.d.b.h.a
 * JD-Core Version:    0.7.0.1
 */