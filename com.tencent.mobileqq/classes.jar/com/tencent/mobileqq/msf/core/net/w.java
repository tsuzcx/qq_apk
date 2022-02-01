package com.tencent.mobileqq.msf.core.net;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.ac;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;

public class w
  implements d
{
  MsfCore a;
  
  public w(MsfCore paramMsfCore)
  {
    this.a = paramMsfCore;
  }
  
  public void a()
  {
    this.a.sender.k();
  }
  
  public void a(MsfSocketInputBuffer paramMsfSocketInputBuffer, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramMsfSocketInputBuffer.getBufferlen()];
    System.arraycopy(paramMsfSocketInputBuffer.getBuffer(), 0, arrayOfByte, 0, arrayOfByte.length);
    this.a.sender.a(arrayOfByte, paramInt);
  }
  
  public byte[] a(com.tencent.mobileqq.msf.core.d paramd, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.w
 * JD-Core Version:    0.7.0.1
 */