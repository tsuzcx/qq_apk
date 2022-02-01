package com.tencent.mobileqq.guild.setting;

import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.callback.ISetGuildTopCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.util.WeakReferenceHandler;

class QQGuildMainSettingFragment$4
  implements ISetGuildTopCallback
{
  QQGuildMainSettingFragment$4(QQGuildMainSettingFragment paramQQGuildMainSettingFragment, boolean paramBoolean) {}
  
  public void a(int paramInt, IGProGuildInfo paramIGProGuildInfo, String paramString)
  {
    paramIGProGuildInfo = new StringBuilder();
    paramIGProGuildInfo.append("guild set top onSetGuildTopResult errCode:");
    paramIGProGuildInfo.append(paramInt);
    paramIGProGuildInfo.append(" errMsg:");
    paramIGProGuildInfo.append(paramString);
    QQGuildUtil.b(paramIGProGuildInfo.toString());
    paramIGProGuildInfo = QQGuildMainSettingFragment.e(this.b);
    paramString = QQGuildMainSettingFragment.e(this.b);
    int i;
    if (this.a) {
      i = 0;
    } else {
      i = -1;
    }
    paramIGProGuildInfo.sendMessage(paramString.obtainMessage(255, paramInt, i));
    QQGuildMainSettingFragment.a(this.b, paramInt, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildMainSettingFragment.4
 * JD-Core Version:    0.7.0.1
 */