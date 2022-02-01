package com.tencent.rtmp;

public abstract interface TXLivePusher$VideoCustomProcessListener
{
  public abstract void onDetectFacePoints(float[] paramArrayOfFloat);
  
  public abstract int onTextureCustomProcess(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void onTextureDestoryed();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePusher.VideoCustomProcessListener
 * JD-Core Version:    0.7.0.1
 */