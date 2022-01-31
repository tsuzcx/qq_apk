package com.tencent.qapmsdk.socket.hpack;

import java.util.List;
import okio.BufferedSource;

public abstract interface Http2Reader$Handler
{
  public abstract void data(boolean paramBoolean, int paramInt1, BufferedSource paramBufferedSource, int paramInt2);
  
  public abstract void headers(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, List<Header> paramList);
  
  public abstract void priority(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.hpack.Http2Reader.Handler
 * JD-Core Version:    0.7.0.1
 */