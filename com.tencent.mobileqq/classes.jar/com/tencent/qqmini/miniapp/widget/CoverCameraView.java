package com.tencent.qqmini.miniapp.widget;

import android.support.annotation.NonNull;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.qqmini.miniapp.widget.camera.CameraCallBack;
import com.tencent.qqmini.miniapp.widget.camera.MiniAppCamera;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.widget.CoverView;

public class CoverCameraView
  extends CoverView
{
  private MiniAppCamera cameraView;
  
  public CoverCameraView(@NonNull IMiniAppContext paramIMiniAppContext)
  {
    super(paramIMiniAppContext.getAttachedActivity());
  }
  
  public CoverCameraView(@NonNull IMiniAppContext paramIMiniAppContext, IJsService paramIJsService)
  {
    super(paramIMiniAppContext.getAttachedActivity());
    this.cameraView = new MiniAppCamera(paramIMiniAppContext, paramIJsService);
    paramIMiniAppContext = new FrameLayout.LayoutParams(-1, -1);
    addView(this.cameraView, paramIMiniAppContext);
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
  
  public void setCameraSurfaceCallBack(CameraCallBack paramCameraCallBack)
  {
    this.cameraView.setCameraSurfaceCallBack(paramCameraCallBack);
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
  
  public void setWebviewId(int paramInt)
  {
    this.cameraView.setWebviewId(paramInt);
  }
  
  public void startRecord(RequestEvent paramRequestEvent)
  {
    this.cameraView.startRecord(paramRequestEvent);
  }
  
  public void stopRecord(RequestEvent paramRequestEvent)
  {
    this.cameraView.stopRecord(paramRequestEvent);
  }
  
  public void switchCamera(boolean paramBoolean, String paramString)
  {
    this.cameraView.switchCamera(paramBoolean, paramString);
  }
  
  public void takePhoto(RequestEvent paramRequestEvent, String paramString)
  {
    this.cameraView.takePhoto(paramRequestEvent, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.CoverCameraView
 * JD-Core Version:    0.7.0.1
 */