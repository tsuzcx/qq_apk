package com.tencent.mobileqq.guild.live.fragment;

import androidx.lifecycle.Observer;

class QQGuildLiveRoomFragment$1
  implements Observer<Boolean>
{
  QQGuildLiveRoomFragment$1(QQGuildLiveRoomFragment paramQQGuildLiveRoomFragment) {}
  
  public void a(Boolean paramBoolean)
  {
    if (!QQGuildLiveRoomFragment.a(this.a))
    {
      QQGuildLiveRoomFragment localQQGuildLiveRoomFragment = this.a;
      Boolean localBoolean = Boolean.TRUE;
      boolean bool2 = true;
      boolean bool1;
      if (paramBoolean == localBoolean) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      QQGuildLiveRoomFragment.a(localQQGuildLiveRoomFragment, bool1);
      localQQGuildLiveRoomFragment = this.a;
      if (paramBoolean != Boolean.TRUE) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      QQGuildLiveRoomFragment.b(localQQGuildLiveRoomFragment, bool1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.QQGuildLiveRoomFragment.1
 * JD-Core Version:    0.7.0.1
 */