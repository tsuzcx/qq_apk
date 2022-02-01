package com.tencent.mobileqq.guild.audio.widget.audiofaceview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FaceAdapter$2
  implements View.OnClickListener
{
  FaceAdapter$2(FaceAdapter paramFaceAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    VideoReport.reportEvent("clck", paramView, null);
    FaceAdapter.a(this.b).a(this.a, paramView, FaceAdapter.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.audiofaceview.FaceAdapter.2
 * JD-Core Version:    0.7.0.1
 */