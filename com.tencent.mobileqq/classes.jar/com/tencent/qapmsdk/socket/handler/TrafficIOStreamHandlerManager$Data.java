package com.tencent.qapmsdk.socket.handler;

import com.tencent.qapmsdk.socket.model.SocketInfo;
import java.io.ByteArrayOutputStream;

class TrafficIOStreamHandlerManager$Data
{
  ByteArrayOutputStream baos = new ByteArrayOutputStream();
  boolean isCompleted;
  boolean isOutput;
  int offset;
  SocketInfo socketInfo;
  
  TrafficIOStreamHandlerManager$Data(boolean paramBoolean, SocketInfo paramSocketInfo)
  {
    this.isOutput = paramBoolean;
    this.socketInfo = paramSocketInfo;
  }
  
  byte[] readBytes(byte[] paramArrayOfByte, int paramInt)
  {
    paramInt = Math.min(paramArrayOfByte.length - this.offset, paramInt);
    byte[] arrayOfByte = new byte[paramInt];
    System.arraycopy(paramArrayOfByte, this.offset, arrayOfByte, 0, paramInt);
    this.offset = (paramInt + this.offset);
    return arrayOfByte;
  }
  
  String readLine(byte[] paramArrayOfByte)
  {
    int i = this.offset;
    while (i < paramArrayOfByte.length)
    {
      if (paramArrayOfByte[i] == 10)
      {
        int m = this.offset;
        int k = i - m;
        int n = i - 1;
        int j = k;
        if (n >= 0)
        {
          j = k;
          if (paramArrayOfByte[n] == 13) {
            j = k - 1;
          }
        }
        byte[] arrayOfByte = new byte[j];
        System.arraycopy(paramArrayOfByte, m, arrayOfByte, 0, j);
        this.offset = (i + 1);
        return new String(arrayOfByte);
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.handler.TrafficIOStreamHandlerManager.Data
 * JD-Core Version:    0.7.0.1
 */