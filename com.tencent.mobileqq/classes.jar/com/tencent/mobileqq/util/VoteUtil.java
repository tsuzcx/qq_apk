package com.tencent.mobileqq.util;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class VoteUtil
{
  public static CardProfile a(BaseQQAppInterface paramBaseQQAppInterface, long paramLong, int paramInt)
  {
    paramBaseQQAppInterface = paramBaseQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (paramBaseQQAppInterface != null)
    {
      Object localObject = Long.toString(paramLong);
      String str = Integer.toString(paramInt);
      boolean bool = true;
      localObject = (CardProfile)paramBaseQQAppInterface.find(CardProfile.class, "lEctID=? and type=?", new String[] { localObject, str });
      paramBaseQQAppInterface = (BaseQQAppInterface)localObject;
      if (QLog.isColorLevel())
      {
        paramBaseQQAppInterface = new StringBuilder();
        paramBaseQQAppInterface.append("readFromDb. uin:");
        paramBaseQQAppInterface.append(paramLong);
        paramBaseQQAppInterface.append(" find:");
        if (localObject == null) {
          bool = false;
        }
        paramBaseQQAppInterface.append(bool);
        QLog.i("VoteUtil", 2, paramBaseQQAppInterface.toString());
        return localObject;
      }
    }
    else
    {
      paramBaseQQAppInterface = null;
    }
    return paramBaseQQAppInterface;
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, long paramLong, int paramInt)
  {
    paramBaseQQAppInterface = paramBaseQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (paramBaseQQAppInterface != null)
    {
      Object localObject = Long.toString(paramLong);
      boolean bool = false;
      localObject = (CardProfile)paramBaseQQAppInterface.find(CardProfile.class, "lEctID=? and type=?", new String[] { localObject, Integer.toString(2) });
      long l1;
      long l2;
      if (localObject != null)
      {
        l1 = ((CardProfile)localObject).bAvailableCnt;
        l2 = paramInt;
        ((CardProfile)localObject).bAvailableCnt = (l1 - l2);
        ((CardProfile)localObject).bTodayVotedCnt += l2;
        if (((CardProfile)localObject).getStatus() == 1000) {
          paramBaseQQAppInterface.persistOrReplace((Entity)localObject);
        } else {
          paramBaseQQAppInterface.update((Entity)localObject);
        }
      }
      CardProfile localCardProfile = (CardProfile)paramBaseQQAppInterface.find(CardProfile.class, "lEctID=? and type=?", new String[] { Long.toString(paramLong), Integer.toString(3) });
      if (localCardProfile != null)
      {
        l1 = localCardProfile.bAvailableCnt;
        l2 = paramInt;
        localCardProfile.bAvailableCnt = (l1 - l2);
        localCardProfile.bTodayVotedCnt += l2;
        localCardProfile.bVoteCnt = ((short)(int)localCardProfile.bTodayVotedCnt);
        if (localCardProfile.getStatus() == 1000) {
          paramBaseQQAppInterface.persistOrReplace(localCardProfile);
        } else {
          paramBaseQQAppInterface.update(localCardProfile);
        }
      }
      paramBaseQQAppInterface.close();
      if (QLog.isColorLevel())
      {
        paramBaseQQAppInterface = new StringBuilder();
        paramBaseQQAppInterface.append("updateProfileCardVote. uin:");
        paramBaseQQAppInterface.append(paramLong);
        paramBaseQQAppInterface.append(" find:");
        if (localObject != null) {
          bool = true;
        }
        paramBaseQQAppInterface.append(bool);
        QLog.i("VoteUtil", 2, paramBaseQQAppInterface.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.VoteUtil
 * JD-Core Version:    0.7.0.1
 */