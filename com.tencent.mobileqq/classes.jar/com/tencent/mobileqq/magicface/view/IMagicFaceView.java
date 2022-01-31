package com.tencent.mobileqq.magicface.view;

import com.tencent.mobileqq.magicface.model.MagicfaceDecoder.MagicfaceRenderListener;

public abstract interface IMagicFaceView
  extends MagicfaceDecoder.MagicfaceRenderListener
{
  public abstract boolean a();
  
  public abstract void setIsFullScreen(boolean paramBoolean);
  
  public abstract void setSurfaceCreatelistener(MagicfaceView.SurfaceCreateListener paramSurfaceCreateListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.IMagicFaceView
 * JD-Core Version:    0.7.0.1
 */