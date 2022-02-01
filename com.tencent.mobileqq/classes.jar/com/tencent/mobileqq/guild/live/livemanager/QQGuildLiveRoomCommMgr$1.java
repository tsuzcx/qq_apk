package com.tencent.mobileqq.guild.live.livemanager;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qqlive.callback.login.IQQLiveLoginCallback;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.qphone.base.util.QLog;

class QQGuildLiveRoomCommMgr$1
  implements IQQLiveLoginCallback
{
  QQGuildLiveRoomCommMgr$1(QQGuildLiveRoomCommMgr paramQQGuildLiveRoomCommMgr) {}
  
  public void onFailed(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("login fail code ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" msg ");
      localStringBuilder.append(paramString);
      QLog.d("QGL.QQGuildLiveRoomCommMgr", 1, localStringBuilder.toString());
    }
    QQGuildLiveRoomCommMgr.a(this.a, false);
    QQGuildLiveRoomCommMgr.b(this.a, false);
    QQGuildLiveRoomCommMgr.a(this.a).postValue(Boolean.valueOf(false));
    QQGuildLiveRoomCommMgr.b(this.a);
  }
  
  public void onSuccess(LoginInfo paramLoginInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("login info ");
      localStringBuilder.append(paramLoginInfo);
      QLog.d("QGL.QQGuildLiveRoomCommMgr", 1, localStringBuilder.toString());
    }
    QQGuildLiveRoomCommMgr.a(this.a, false);
    QQGuildLiveRoomCommMgr.b(this.a, true);
    QQGuildLiveRoomCommMgr.a(this.a).postValue(Boolean.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.livemanager.QQGuildLiveRoomCommMgr.1
 * JD-Core Version:    0.7.0.1
 */