package com.tencent.mobileqq.guild.mainframe.joinchannel;

import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.app.QBaseActivity;

class JoinChannelViewBinder$1
  implements Observer<Integer>
{
  JoinChannelViewBinder$1(JoinChannelViewBinder paramJoinChannelViewBinder, View paramView1, View paramView2, Button paramButton) {}
  
  public void a(Integer paramInteger)
  {
    if ((paramInteger != null) && (paramInteger.intValue() == 1))
    {
      this.a.setVisibility(0);
      this.b.setVisibility(8);
      this.c.setText(JoinChannelViewBinder.a(this.d).getResources().getString(2131888784));
      this.c.setTag(2131446561, Boolean.valueOf(true));
      this.d.b();
      return;
    }
    if ((paramInteger == null) || (paramInteger.intValue() != 2))
    {
      this.a.setVisibility(8);
      this.b.setVisibility(0);
      this.c.setText(JoinChannelViewBinder.a(this.d).getResources().getString(2131890401));
      this.c.setTag(2131446561, Boolean.valueOf(false));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.joinchannel.JoinChannelViewBinder.1
 * JD-Core Version:    0.7.0.1
 */