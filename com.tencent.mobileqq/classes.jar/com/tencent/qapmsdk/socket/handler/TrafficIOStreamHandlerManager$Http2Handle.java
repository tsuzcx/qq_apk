package com.tencent.qapmsdk.socket.handler;

import com.tencent.qapmsdk.socket.hpack.Header;
import com.tencent.qapmsdk.socket.hpack.Http2Reader.Handler;
import java.util.List;
import okio.BufferedSource;

class TrafficIOStreamHandlerManager$Http2Handle
  implements Http2Reader.Handler
{
  private TrafficIOStreamHandlerManager.Package http2Package;
  
  public TrafficIOStreamHandlerManager$Http2Handle(TrafficIOStreamHandlerManager.Package paramPackage)
  {
    this.http2Package = paramPackage;
  }
  
  public void data(boolean paramBoolean, int paramInt1, BufferedSource paramBufferedSource, int paramInt2)
  {
    if (paramBoolean) {
      this.http2Package.header.isCompleted = true;
    }
    this.http2Package.body.isCompleted = paramBoolean;
  }
  
  public void headers(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, List<Header> paramList)
  {
    boolean bool2 = true;
    if (paramBoolean1) {
      this.http2Package.body.isCompleted = true;
    }
    TrafficIOStreamHandlerManager.Header localHeader = this.http2Package.header;
    boolean bool1 = bool2;
    if (!paramBoolean1) {
      if (!paramBoolean2) {
        break label63;
      }
    }
    label63:
    for (bool1 = bool2;; bool1 = false)
    {
      localHeader.isCompleted = bool1;
      this.http2Package.header.parse(paramList);
      return;
    }
  }
  
  public void priority(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.handler.TrafficIOStreamHandlerManager.Http2Handle
 * JD-Core Version:    0.7.0.1
 */