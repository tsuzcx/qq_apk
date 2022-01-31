package com.tencent.qapmsdk.socket.handler;

import com.tencent.qapmsdk.socket.model.SocketInfo;
import java.io.ByteArrayOutputStream;

class TrafficIOStreamHandlerManager$Package
{
  TrafficIOStreamHandlerManager.Body body;
  TrafficIOStreamHandlerManager.Header header;
  
  TrafficIOStreamHandlerManager$Package(boolean paramBoolean, SocketInfo paramSocketInfo)
  {
    this.header = new TrafficIOStreamHandlerManager.Header(paramBoolean, paramSocketInfo);
    this.body = new TrafficIOStreamHandlerManager.Body(paramBoolean, paramSocketInfo);
  }
  
  void reset()
  {
    this.header.baos.reset();
    this.body.baos.reset();
  }
  
  int size()
  {
    return this.header.baos.size() + this.body.size;
  }
  
  byte[] toByteArray()
  {
    byte[] arrayOfByte1 = this.header.toByteArray();
    byte[] arrayOfByte2 = this.body.toByteArray();
    byte[] arrayOfByte3 = new byte[arrayOfByte1.length + arrayOfByte2.length];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte3, 0, arrayOfByte1.length);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte3, arrayOfByte1.length, arrayOfByte2.length);
    return arrayOfByte3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.handler.TrafficIOStreamHandlerManager.Package
 * JD-Core Version:    0.7.0.1
 */