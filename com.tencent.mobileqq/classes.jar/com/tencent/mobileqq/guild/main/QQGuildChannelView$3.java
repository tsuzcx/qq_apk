package com.tencent.mobileqq.guild.main;

import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchIsLiveChannelOpenCallback;
import com.tencent.qphone.base.util.QLog;

class QQGuildChannelView$3
  implements IFetchIsLiveChannelOpenCallback
{
  QQGuildChannelView$3(QQGuildChannelView paramQQGuildChannelView, String paramString) {}
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fetchLiveChannelSwitch callback, result=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("(");
    localStringBuilder.append(paramString);
    localStringBuilder.append("), open=");
    localStringBuilder.append(paramInt2);
    paramString = localStringBuilder.toString();
    boolean bool = true;
    QLog.i("QQGuildChannelView", 1, paramString);
    if (paramInt2 != 1) {
      bool = false;
    }
    if (paramInt1 == 0)
    {
      if (QQGuildUtil.e(this.a) == bool) {
        return;
      }
      QQGuildUtil.a(this.a, bool);
      this.b.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.QQGuildChannelView.3
 * JD-Core Version:    0.7.0.1
 */