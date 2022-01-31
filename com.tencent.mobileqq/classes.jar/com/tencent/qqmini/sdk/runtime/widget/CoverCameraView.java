package com.tencent.qqmini.sdk.runtime.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.FrameLayout.LayoutParams;
import bglu;
import bgok;
import bhke;
import com.tencent.qqmini.sdk.core.widget.CoverView;
import com.tencent.qqmini.sdk.runtime.widget.camera.MiniAppCamera;

public class CoverCameraView
  extends CoverView
{
  private MiniAppCamera a;
  
  public CoverCameraView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public CoverCameraView(@NonNull Context paramContext, bglu parambglu)
  {
    super(paramContext);
    this.a = new MiniAppCamera(paramContext, parambglu);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    addView(this.a, paramContext);
  }
  
  public void a()
  {
    this.a.f();
  }
  
  public void a(bgok parambgok)
  {
    this.a.a(parambgok);
  }
  
  public void a(bgok parambgok, String paramString)
  {
    this.a.a(parambgok, paramString);
  }
  
  public void a(String paramString)
  {
    this.a.a(paramString);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    this.a.a(paramBoolean, paramString);
  }
  
  public void b(bgok parambgok)
  {
    this.a.b(parambgok);
  }
  
  public void setCameraHeight(int paramInt)
  {
    MiniAppCamera localMiniAppCamera = this.a;
    MiniAppCamera.b = paramInt;
  }
  
  public void setCameraId(int paramInt)
  {
    this.a.setCameraId(paramInt);
  }
  
  public void setCameraSurfaceCallBack(bhke parambhke)
  {
    this.a.setCameraSurfaceCallBack(parambhke);
  }
  
  public void setCameraWidth(int paramInt)
  {
    MiniAppCamera localMiniAppCamera = this.a;
    MiniAppCamera.a = paramInt;
  }
  
  public void setFlashMode(String paramString)
  {
    this.a.setFlashMode(paramString);
  }
  
  public void setMode(String paramString)
  {
    this.a.setMode(paramString);
  }
  
  public void setWebviewId(int paramInt)
  {
    this.a.setWebviewId(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.widget.CoverCameraView
 * JD-Core Version:    0.7.0.1
 */