package com.tencent.rtmp;

import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.o;

class a$2
  implements o
{
  a$2(a parama) {}
  
  public void onRenderVideoFrame(String paramString, int paramInt, TXSVideoFrame paramTXSVideoFrame)
  {
    if ((paramTXSVideoFrame != null) && (paramTXSVideoFrame.width > 0))
    {
      if (paramTXSVideoFrame.height <= 0) {
        return;
      }
      paramString = a.e(this.a);
      if (paramString != null)
      {
        TXLivePlayer.TXLiteAVTexture localTXLiteAVTexture = new TXLivePlayer.TXLiteAVTexture();
        localTXLiteAVTexture.textureId = paramTXSVideoFrame.textureId;
        localTXLiteAVTexture.width = paramTXSVideoFrame.width;
        localTXLiteAVTexture.height = paramTXSVideoFrame.height;
        localTXLiteAVTexture.eglContext = paramTXSVideoFrame.eglContext;
        paramString.onRenderVideoFrame(localTXLiteAVTexture);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.a.2
 * JD-Core Version:    0.7.0.1
 */