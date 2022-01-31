package com.tencent.ttpic.util;

import com.tencent.ttpic.gles.TextureDataPipe;

public abstract interface OnTextureReadyListener
{
  public abstract TextureDataPipe getReadyData();
  
  public abstract boolean needWait();
  
  public abstract void onTextureReady(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.OnTextureReadyListener
 * JD-Core Version:    0.7.0.1
 */