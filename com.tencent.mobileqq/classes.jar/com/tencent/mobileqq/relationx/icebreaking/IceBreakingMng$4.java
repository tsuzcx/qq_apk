package com.tencent.mobileqq.relationx.icebreaking;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class IceBreakingMng$4
  extends TroopObserver
{
  IceBreakingMng$4(IceBreakingMng paramIceBreakingMng) {}
  
  protected void onGetTroopMemberCard(boolean paramBoolean, Object paramObject)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onGetTroopMemberCard: isSuccess ");
        localStringBuilder.append(paramBoolean);
        QLog.i("IceBreak.HotPic", 2, localStringBuilder.toString());
      }
      if (paramBoolean)
      {
        paramObject = (Object[])paramObject;
        long l = ((Long)paramObject[0]).longValue();
        paramObject = (TroopMemberCard)paramObject[2];
        if (String.valueOf(l).equals(IceBreakingMng.c(this.a)))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(" onGetTroopMemberCard last_active_time: ");
          localStringBuilder.append(paramObject.lastSpeak);
          localStringBuilder.append(" join_time: ");
          localStringBuilder.append(paramObject.joinTime);
          QLog.i("IceBreak.HotPic", 1, localStringBuilder.toString());
          if (paramObject.lastSpeak > paramObject.joinTime) {
            return;
          }
          IceBreakingMng.a(this.a, String.valueOf(l));
          return;
        }
      }
    }
    catch (Exception paramObject)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onGetTroopMemberCard:");
        localStringBuilder.append(paramObject.toString());
        QLog.i("IceBreak.HotPic", 2, localStringBuilder.toString());
      }
    }
  }
  
  protected void onGetTroopMemberListBy0x787(String paramString, List<Pair<String, String>> paramList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGetTroopMemberListBy0x787 uin: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" memberList size: ");
    int k = 0;
    int i;
    if (paramList == null) {
      i = 0;
    } else {
      i = paramList.size();
    }
    ((StringBuilder)localObject).append(i);
    QLog.i("IceBreak.HotPic", 2, ((StringBuilder)localObject).toString());
    if ((paramString != null) && (paramList != null))
    {
      if (paramList.size() <= 1) {
        return;
      }
      if (paramString.equals(IceBreakingMng.c(this.a)))
      {
        localObject = (FriendsManager)this.a.d.getManager(QQManagerFactory.FRIENDS_MANAGER);
        String str1 = this.a.d.getCurrentAccountUin();
        int m = paramList.size();
        int j = 0;
        i = k;
        while (i < m)
        {
          String str2 = (String)((Pair)paramList.get(i)).first;
          k = j;
          if (!TextUtils.isEmpty(str2))
          {
            k = j;
            if (!str2.equals(str1))
            {
              k = j;
              if (!((FriendsManager)localObject).n(str2)) {
                k = j + 1;
              }
            }
          }
          i += 1;
          j = k;
        }
        float f = IceBreakingMng.d(this.a) / 100.0F;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("friendCount: ");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(" total count: ");
        ((StringBuilder)localObject).append(paramList.size());
        QLog.i("IceBreak.HotPic", 1, ((StringBuilder)localObject).toString());
        if (j * 1.0F / (paramList.size() - 1) > f) {
          this.a.l(paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng.4
 * JD-Core Version:    0.7.0.1
 */