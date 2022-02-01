package com.tencent.mobileqq.guild.live.fragment.audience.module.subvideobar;

import androidx.lifecycle.Observer;
import com.tencent.qphone.base.util.QLog;

class QQGuildSubVideoBarLiveFragment$2
  implements Observer<Boolean>
{
  QQGuildSubVideoBarLiveFragment$2(QQGuildSubVideoBarLiveFragment paramQQGuildSubVideoBarLiveFragment) {}
  
  public void a(Boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getSelfAllowStartLive:");
    ((StringBuilder)localObject).append(paramBoolean);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = true;
    QLog.i("QGL.QQGuildSubVideoBarLiveFragment", 1, (String)localObject);
    localObject = this.a;
    if (paramBoolean != Boolean.TRUE) {
      bool = false;
    }
    QQGuildSubVideoBarLiveFragment.b((QQGuildSubVideoBarLiveFragment)localObject, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.audience.module.subvideobar.QQGuildSubVideoBarLiveFragment.2
 * JD-Core Version:    0.7.0.1
 */