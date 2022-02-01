package com.tencent.mobileqq.richmediabrowser.model;

import android.content.Context;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView;

class AIOFileVideoModel$1
  implements FMDialogUtil.FMDialogInterface
{
  AIOFileVideoModel$1(AIOFileVideoModel paramAIOFileVideoModel, Context paramContext, AIOFileVideoData paramAIOFileVideoData, AIOFileVideoView paramAIOFileVideoView) {}
  
  public void a()
  {
    if (this.a != null)
    {
      AIOFileVideoData localAIOFileVideoData = this.b;
      if (localAIOFileVideoData != null)
      {
        AIOFileVideoView localAIOFileVideoView = this.c;
        if (localAIOFileVideoView != null)
        {
          localAIOFileVideoData.x = true;
          localAIOFileVideoView.o();
        }
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoModel.1
 * JD-Core Version:    0.7.0.1
 */