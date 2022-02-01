package com.tencent.mobileqq.guild.audio.widget.audiofaceview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FaceAdapter$3
  implements View.OnClickListener
{
  FaceAdapter$3(FaceAdapter paramFaceAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (FaceAdapter.a(this.b) != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick onItemClick ");
      localStringBuilder.append(this.a);
      QLog.i("FaceAdapter", 2, localStringBuilder.toString());
      FaceAdapter.a(this.b).a(this.a, paramView, FaceAdapter.a());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.widget.audiofaceview.FaceAdapter.3
 * JD-Core Version:    0.7.0.1
 */