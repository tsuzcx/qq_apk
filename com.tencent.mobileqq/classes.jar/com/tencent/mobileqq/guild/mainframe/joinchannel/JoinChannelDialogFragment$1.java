package com.tencent.mobileqq.guild.mainframe.joinchannel;

import androidx.lifecycle.Observer;
import com.tencent.util.InputMethodUtil;

class JoinChannelDialogFragment$1
  implements Observer<Integer>
{
  JoinChannelDialogFragment$1(JoinChannelDialogFragment paramJoinChannelDialogFragment) {}
  
  public void a(Integer paramInteger)
  {
    if ((paramInteger != null) && (paramInteger.intValue() == 2))
    {
      this.a.dismiss();
      InputMethodUtil.a(this.a.getActivity());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.joinchannel.JoinChannelDialogFragment.1
 * JD-Core Version:    0.7.0.1
 */