package com.tencent.mobileqq.util;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class VoteUtil
{
  public static CardProfile a(BaseQQAppInterface paramBaseQQAppInterface, long paramLong, int paramInt)
  {
    boolean bool = true;
    CardProfile localCardProfile = null;
    EntityManager localEntityManager = paramBaseQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramBaseQQAppInterface = localCardProfile;
    if (localEntityManager != null)
    {
      localCardProfile = (CardProfile)localEntityManager.find(CardProfile.class, "lEctID=? and type=?", new String[] { Long.toString(paramLong), Integer.toString(paramInt) });
      paramBaseQQAppInterface = localCardProfile;
      if (QLog.isColorLevel())
      {
        paramBaseQQAppInterface = new StringBuilder().append("readFromDb. uin:").append(paramLong).append(" find:");
        if (localCardProfile == null) {
          break label111;
        }
      }
    }
    for (;;)
    {
      QLog.i("VoteUtil", 2, bool);
      paramBaseQQAppInterface = localCardProfile;
      return paramBaseQQAppInterface;
      label111:
      bool = false;
    }
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, long paramLong, int paramInt)
  {
    Object localObject = paramBaseQQAppInterface.getEntityManagerFactory().createEntityManager();
    CardProfile localCardProfile;
    if (localObject != null)
    {
      paramBaseQQAppInterface = (CardProfile)((EntityManager)localObject).find(CardProfile.class, "lEctID=? and type=?", new String[] { Long.toString(paramLong), Integer.toString(2) });
      if (paramBaseQQAppInterface != null)
      {
        paramBaseQQAppInterface.bAvailableCnt -= paramInt;
        paramBaseQQAppInterface.bTodayVotedCnt += paramInt;
        if (paramBaseQQAppInterface.getStatus() != 1000) {
          break label238;
        }
        ((EntityManager)localObject).persistOrReplace(paramBaseQQAppInterface);
      }
      localCardProfile = (CardProfile)((EntityManager)localObject).find(CardProfile.class, "lEctID=? and type=?", new String[] { Long.toString(paramLong), Integer.toString(3) });
      if (localCardProfile != null)
      {
        localCardProfile.bAvailableCnt -= paramInt;
        localCardProfile.bTodayVotedCnt += paramInt;
        localCardProfile.bVoteCnt = ((short)(int)localCardProfile.bTodayVotedCnt);
        if (localCardProfile.getStatus() != 1000) {
          break label248;
        }
        ((EntityManager)localObject).persistOrReplace(localCardProfile);
      }
      label180:
      ((EntityManager)localObject).close();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("updateProfileCardVote. uin:").append(paramLong).append(" find:");
        if (paramBaseQQAppInterface == null) {
          break label259;
        }
      }
    }
    label259:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("VoteUtil", 2, bool);
      return;
      label238:
      ((EntityManager)localObject).update(paramBaseQQAppInterface);
      break;
      label248:
      ((EntityManager)localObject).update(localCardProfile);
      break label180;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.VoteUtil
 * JD-Core Version:    0.7.0.1
 */