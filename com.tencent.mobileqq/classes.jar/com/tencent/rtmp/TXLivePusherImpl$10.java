package com.tencent.rtmp;

import com.tencent.liteav.m;

class TXLivePusherImpl$10
  implements m
{
  TXLivePusherImpl$10(TXLivePusherImpl paramTXLivePusherImpl) {}
  
  public void onGLContextCreated() {}
  
  public void onGLContextReadyToDestory()
  {
    if (TXLivePusherImpl.b(this.a) != null) {
      TXLivePusherImpl.b(this.a).onTextureDestoryed();
    }
  }
  
  public int onProcessVideoFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt4 = paramInt1;
    if (TXLivePusherImpl.b(this.a) != null) {
      paramInt4 = TXLivePusherImpl.b(this.a).onTextureCustomProcess(paramInt1, paramInt2, paramInt3);
    }
    return paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePusherImpl.10
 * JD-Core Version:    0.7.0.1
 */