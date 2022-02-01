package com.tencent.mobileqq.qassistant.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qassistant.audio.VoiceTimeTraceUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VoiceView$1
  implements View.OnClickListener
{
  VoiceView$1(VoiceView paramVoiceView) {}
  
  public void onClick(View paramView)
  {
    VoiceTimeTraceUtil.a().e();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.view.VoiceView.1
 * JD-Core Version:    0.7.0.1
 */