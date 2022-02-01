package com.tencent.mobileqq.guild.mainframe.joinchannel;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.base.BaseGuildViewModel.ToastEvent;
import com.tencent.mobileqq.guild.util.QQGuildUtil;

class JoinChannelDialogFragment$2
  implements Observer<BaseGuildViewModel.ToastEvent>
{
  JoinChannelDialogFragment$2(JoinChannelDialogFragment paramJoinChannelDialogFragment) {}
  
  public void a(BaseGuildViewModel.ToastEvent paramToastEvent)
  {
    if ((paramToastEvent != null) && (paramToastEvent.b == 0))
    {
      QQGuildUtil.c(this.a.getContext(), paramToastEvent.a);
      return;
    }
    if (paramToastEvent != null) {
      QQGuildUtil.a(this.a.getContext(), paramToastEvent.b, paramToastEvent.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.joinchannel.JoinChannelDialogFragment.2
 * JD-Core Version:    0.7.0.1
 */