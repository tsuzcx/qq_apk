package com.tencent.mobileqq.guild.live.viewmodel;

import androidx.lifecycle.Observer;

class QQGuildLiveRoomVM$2
  implements Observer<Boolean>
{
  QQGuildLiveRoomVM$2(QQGuildLiveRoomVM paramQQGuildLiveRoomVM) {}
  
  public void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      paramBoolean = this.a;
      QQGuildLiveRoomVM.a(paramBoolean, QQGuildLiveRoomVM.a(paramBoolean));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.viewmodel.QQGuildLiveRoomVM.2
 * JD-Core Version:    0.7.0.1
 */