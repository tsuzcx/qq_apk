package com.tencent.mobileqq.guild.privatechannel;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import java.util.ArrayList;

public class GuildSelectMemberLayout$SearchKeyListener
  implements View.OnKeyListener
{
  protected GuildSelectMemberLayout$SearchKeyListener(GuildSelectMemberLayout paramGuildSelectMemberLayout) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0) && (paramInt == 67) && (TextUtils.isEmpty(((EditText)paramView).getText())))
    {
      paramView = this.a.l.a();
      paramView = ((GuildPrivateSearchGridAdapter.GridUIData)paramView.get(paramView.size() - 1)).b;
      this.a.g.a(new String[] { paramView }, false);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.GuildSelectMemberLayout.SearchKeyListener
 * JD-Core Version:    0.7.0.1
 */