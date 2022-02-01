package com.tencent.mobileqq.guild.util;

import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.Comparator;

final class QQGuildUtil$1
  implements Comparator<IGProUserInfo>
{
  public int a(IGProUserInfo paramIGProUserInfo1, IGProUserInfo paramIGProUserInfo2)
  {
    if (paramIGProUserInfo1.d() > paramIGProUserInfo2.d()) {
      return -1;
    }
    if (paramIGProUserInfo1.d() == paramIGProUserInfo2.d())
    {
      if (paramIGProUserInfo1.e() > paramIGProUserInfo2.e()) {
        return -1;
      }
      if (paramIGProUserInfo1.e() < paramIGProUserInfo2.e()) {
        return 1;
      }
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.QQGuildUtil.1
 * JD-Core Version:    0.7.0.1
 */