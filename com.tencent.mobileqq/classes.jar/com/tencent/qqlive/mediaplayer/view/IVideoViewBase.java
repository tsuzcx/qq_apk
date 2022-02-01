package com.tencent.qqlive.mediaplayer.view;

import android.view.View;
import java.nio.ByteBuffer;

public abstract interface IVideoViewBase
{
  public static final int VIEW_ID_GLSURFACEVIEW = 3;
  public static final int VIEW_ID_SURFACEVIEW = 1;
  public static final int VIEW_ID_SURFACEVIEW_HW = 2;
  public static final int VIEW_ID_UNKONW = 0;
  
  public abstract void addViewCallBack(IVideoViewBase.IVideoViewCallBack paramIVideoViewCallBack);
  
  public abstract void chooseDisplayView(int paramInt);
  
  public abstract void doCacheSurfaceTexture();
  
  public abstract void doRecoverSurfaceTexture();
  
  public abstract void doRotate(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void drawFrame(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, ByteBuffer paramByteBuffer3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat, boolean paramBoolean);
  
  public abstract void drawFrame(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, boolean paramBoolean, int paramInt5, int paramInt6);
  
  public abstract View getCurrentDisplayView();
  
  public abstract Object getRenderObject();
  
  public abstract String getSeriableNO();
  
  public abstract int getViewHeight();
  
  public abstract int getViewWidth();
  
  public abstract int getXOnScreen();
  
  public abstract int getYOnScreen();
  
  public abstract boolean isSurfaceReady();
  
  public abstract void onResume();
  
  public abstract void removeViewCallBack(IVideoViewBase.IVideoViewCallBack paramIVideoViewCallBack);
  
  public abstract void resetView();
  
  public abstract void setDegree(int paramInt);
  
  public abstract void setEnableAntDis(boolean paramBoolean);
  
  public abstract void setEnableVREyeControl(boolean paramBoolean);
  
  public abstract void setFixedSize(int paramInt1, int paramInt2);
  
  public abstract void setGypSensor(boolean paramBoolean);
  
  public abstract void setLogTag(String paramString);
  
  public abstract void setRadio(int paramInt1, int paramInt2);
  
  public abstract void setScaleParam(int paramInt1, int paramInt2, float paramFloat);
  
  public abstract void setSubtitleString(String paramString);
  
  public abstract void setVREnable(boolean paramBoolean);
  
  public abstract void setVrViewPattern(int paramInt);
  
  public abstract void setXYaxis(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.mediaplayer.view.IVideoViewBase
 * JD-Core Version:    0.7.0.1
 */