package com.tencent.mobileqq.guild.audio.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQGuildAudioSettingFragment$1
  implements View.OnClickListener
{
  QQGuildAudioSettingFragment$1(QQGuildAudioSettingFragment paramQQGuildAudioSettingFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.getActivity() != null) {
      this.a.getActivity().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.dialog.QQGuildAudioSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */