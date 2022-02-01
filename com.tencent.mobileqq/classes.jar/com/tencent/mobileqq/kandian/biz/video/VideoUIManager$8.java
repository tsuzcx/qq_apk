package com.tencent.mobileqq.kandian.biz.video;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.mobileqq.kandian.base.video.VideoPlayUtils;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.qphone.base.util.QLog;

class VideoUIManager$8
  implements SeekBar.OnSeekBarChangeListener
{
  VideoUIManager$8(VideoUIManager paramVideoUIManager) {}
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    int i = paramSeekBar.getProgress();
    int j = VideoUIManager.h(this.a).j();
    if (QLog.isColorLevel())
    {
      paramSeekBar = new StringBuilder();
      paramSeekBar.append("onStopTrackingTouch(): progress=");
      paramSeekBar.append(i);
      paramSeekBar.append(", playState=");
      paramSeekBar.append(VideoPlayUtils.a(j));
      QLog.d("Q.readinjoy.videoVideoUIManager", 2, paramSeekBar.toString());
    }
    if (j == 3)
    {
      VideoUIManager.h(this.a).a(i * 1000, VideoUIManager.s(this.a));
      return;
    }
    if (j == 5) {
      VideoUIManager.h(this.a).b(i * 1000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoUIManager.8
 * JD-Core Version:    0.7.0.1
 */