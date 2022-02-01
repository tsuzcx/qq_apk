package com.tencent.mobileqq.guild.live.fragment.audience.module.subvideobar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.live.livemanager.anchor.QQGuildLiveAnchorRoomMgr;
import com.tencent.mobileqq.guild.util.GuildLiveToast;
import com.tencent.mobileqq.widget.QQProgressDialog;

class QQGuildSubVideoBarLiveFragment$4
  implements Observer<Boolean>
{
  QQGuildSubVideoBarLiveFragment$4(QQGuildSubVideoBarLiveFragment paramQQGuildSubVideoBarLiveFragment) {}
  
  public void a(Boolean paramBoolean)
  {
    if ((paramBoolean.booleanValue()) && (!QQGuildSubVideoBarLiveFragment.d(this.a)))
    {
      QQGuildLiveAnchorRoomMgr.a().a(this.a.getActivity()).observe(this.a.getViewLifecycleOwner(), new QQGuildSubVideoBarLiveFragment.4.1(this));
      if (QQGuildSubVideoBarLiveFragment.e(this.a) != null) {
        QQGuildSubVideoBarLiveFragment.e(this.a).dismiss();
      }
    }
    else
    {
      GuildLiveToast.a(2131890435);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.audience.module.subvideobar.QQGuildSubVideoBarLiveFragment.4
 * JD-Core Version:    0.7.0.1
 */