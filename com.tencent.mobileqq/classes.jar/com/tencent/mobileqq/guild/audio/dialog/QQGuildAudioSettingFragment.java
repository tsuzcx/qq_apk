package com.tencent.mobileqq.guild.audio.dialog;

import android.app.Activity;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.guild.channel.QQGuildChannelInfoSettingFragment;

public class QQGuildAudioSettingFragment
  extends QQGuildChannelInfoSettingFragment
{
  protected void a()
  {
    super.a();
    this.a.setVisibility(8);
    this.d.setVisibility(0);
    this.d.setText(2131890246);
    this.d.setOnClickListener(new QQGuildAudioSettingFragment.1(this));
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(2130771996, 2130772007);
  }
  
  public void onFinish()
  {
    super.onFinish();
    getActivity().overridePendingTransition(2130772007, 2130771995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.dialog.QQGuildAudioSettingFragment
 * JD-Core Version:    0.7.0.1
 */