package com.tencent.mobileqq.guild.mainframe.joinchannel;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class JoinChannelViewBinder$5
  implements View.OnClickListener
{
  JoinChannelViewBinder$5(JoinChannelViewBinder paramJoinChannelViewBinder) {}
  
  public void onClick(View paramView)
  {
    CharacterCountEditText localCharacterCountEditText = (CharacterCountEditText)JoinChannelViewBinder.c(this.a).findViewById(2131428386);
    JoinChannelViewBinder.d(this.a).a(JoinChannelViewBinder.a(this.a), localCharacterCountEditText.getText().toString());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.joinchannel.JoinChannelViewBinder.5
 * JD-Core Version:    0.7.0.1
 */