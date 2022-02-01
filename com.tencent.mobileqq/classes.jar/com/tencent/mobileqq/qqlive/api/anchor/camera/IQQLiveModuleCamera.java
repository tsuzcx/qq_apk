package com.tencent.mobileqq.qqlive.api.anchor.camera;

import android.content.Context;
import com.tencent.mobileqq.qqlive.callback.anchor.QQLiveCameraFilterLoaderListener;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveCameraBeautyInfo;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveCameraFilterInfo;
import java.util.List;

public abstract interface IQQLiveModuleCamera
{
  public abstract void changeAnchorCameraBeauty(QQLiveCameraBeautyInfo paramQQLiveCameraBeautyInfo);
  
  public abstract void changeAnchorCameraFilter(QQLiveCameraFilterInfo paramQQLiveCameraFilterInfo, QQLiveCameraFilterLoaderListener paramQQLiveCameraFilterLoaderListener);
  
  public abstract List<QQLiveCameraBeautyInfo> getAnchorCameraBeautyInfo(Context paramContext);
  
  public abstract List<QQLiveCameraFilterInfo> getAnchorCameraFilterInfo(Context paramContext);
  
  public abstract boolean isCameraMirror();
  
  public abstract void setCameraMirror(boolean paramBoolean);
  
  public abstract void switchAnchorCamera();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.anchor.camera.IQQLiveModuleCamera
 * JD-Core Version:    0.7.0.1
 */