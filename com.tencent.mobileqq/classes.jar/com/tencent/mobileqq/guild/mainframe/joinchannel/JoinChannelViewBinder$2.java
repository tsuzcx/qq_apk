package com.tencent.mobileqq.guild.mainframe.joinchannel;

import android.content.res.Resources;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.mobileqq.qqguildsdk.data.AddGuildOption;

class JoinChannelViewBinder$2
  implements Observer<AddGuildOption>
{
  JoinChannelViewBinder$2(JoinChannelViewBinder paramJoinChannelViewBinder, TextView paramTextView) {}
  
  public void a(AddGuildOption paramAddGuildOption)
  {
    if (paramAddGuildOption == null) {
      return;
    }
    if (paramAddGuildOption.a == 2)
    {
      this.a.setVisibility(8);
      JoinChannelViewBinder.b(this.b).setHint(JoinChannelViewBinder.a(this.b).getResources().getString(2131890395));
      return;
    }
    this.a.setVisibility(0);
    this.a.setText(JoinChannelViewBinder.a(this.b).getResources().getString(2131890397, new Object[] { paramAddGuildOption.b }));
    JoinChannelViewBinder.b(this.b).setHint(JoinChannelViewBinder.a(this.b).getResources().getString(2131890396));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.joinchannel.JoinChannelViewBinder.2
 * JD-Core Version:    0.7.0.1
 */