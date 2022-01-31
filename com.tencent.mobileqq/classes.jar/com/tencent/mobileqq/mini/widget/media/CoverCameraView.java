package com.tencent.mobileqq.mini.widget.media;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.widget.CoverView;

public class CoverCameraView
  extends CoverView
{
  private MiniAppCamera cameraView;
  
  public CoverCameraView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public CoverCameraView(@NonNull Context paramContext, WebviewContainer paramWebviewContainer)
  {
    super(paramContext);
    this.cameraView = new MiniAppCamera(paramContext, paramWebviewContainer);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    addView(this.cameraView, paramContext);
  }
  
  public void closeCamera()
  {
    this.cameraView.closeCamera();
  }
  
  public void openCamera(String paramString)
  {
    this.cameraView.openCamera(paramString);
  }
  
  public void setCameraHeight(int paramInt)
  {
    MiniAppCamera localMiniAppCamera = this.cameraView;
    MiniAppCamera.cameraHeight = paramInt;
  }
  
  public void setCameraId(int paramInt)
  {
    this.cameraView.setCameraId(paramInt);
  }
  
  public void setCameraSurfaceCallBack(CameraSurfaceView.CameraSurfaceViewCallBack paramCameraSurfaceViewCallBack)
  {
    this.cameraView.setCameraSurfaceCallBack(paramCameraSurfaceViewCallBack);
  }
  
  public void setCameraWidth(int paramInt)
  {
    MiniAppCamera localMiniAppCamera = this.cameraView;
    MiniAppCamera.cameraWidth = paramInt;
  }
  
  public void setFlashMode(String paramString)
  {
    this.cameraView.setFlashMode(paramString);
  }
  
  public void setMode(String paramString)
  {
    this.cameraView.setMode(paramString);
  }
  
  public void startRecord(WebviewContainer paramWebviewContainer, String paramString, int paramInt)
  {
    this.cameraView.startRecord(paramWebviewContainer, paramString, paramInt);
  }
  
  public void stopRecord(WebviewContainer paramWebviewContainer, String paramString, int paramInt)
  {
    this.cameraView.stopRecord(paramWebviewContainer, paramString, paramInt);
  }
  
  public void switchCamera(WebviewContainer paramWebviewContainer, boolean paramBoolean, String paramString)
  {
    this.cameraView.switchCamera(paramWebviewContainer, paramBoolean, paramString);
  }
  
  public void takePhoto(WebviewContainer paramWebviewContainer, String paramString1, int paramInt, String paramString2)
  {
    this.cameraView.takePhoto(paramWebviewContainer, paramString1, paramInt, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.CoverCameraView
 * JD-Core Version:    0.7.0.1
 */