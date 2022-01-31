package com.tencent.mobileqq.richmediabrowser.view;

import android.widget.SeekBar;
import android.widget.TextView;
import axyt;
import axzv;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

public class AIOFileVideoView$3
  implements Runnable
{
  public AIOFileVideoView$3(axzv paramaxzv, float paramFloat, String paramString) {}
  
  public void run()
  {
    AIOFileVideoData localAIOFileVideoData = this.this$0.a.a();
    if (localAIOFileVideoData != null)
    {
      localAIOFileVideoData.i = true;
      localAIOFileVideoData.j = true;
      localAIOFileVideoData.status = 1;
      localAIOFileVideoData.progress = ((int)((float)localAIOFileVideoData.c * this.jdField_a_of_type_Float));
      this.this$0.d.setText(this.jdField_a_of_type_JavaLangString);
      int i = (int)(10000.0F * this.jdField_a_of_type_Float);
      this.this$0.b.setProgress(i);
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "onDownlodProgress progress = " + this.jdField_a_of_type_Float);
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOFileVideoView", 4, "onDownlodProgress pos = " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView.3
 * JD-Core Version:    0.7.0.1
 */