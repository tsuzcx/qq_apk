package com.tencent.mobileqq.listentogether;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.media_relation.media_relation.MediaRelationInfo;

public class ListenTogetherAIOStatusHelper
{
  public static String a = "ListenTogetherAIOStatusHelper";
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setIsGroupListenTogetherOpen, app = ");
      localStringBuilder.append(paramQQAppInterface);
      localStringBuilder.append(" troopuin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" isOpen:");
      localStringBuilder.append(paramBoolean);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (paramQQAppInterface != null)
      {
        paramString = paramQQAppInterface.f(paramString);
        if (paramString != null)
        {
          paramString.setIsListenTogether(paramBoolean);
          paramQQAppInterface.b(paramString);
          if (QLog.isColorLevel()) {
            QLog.i(a, 2, "setIsGroupListenTogetherOpen troopinfo saved");
          }
        }
      }
    }
  }
  
  public static boolean a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      media_relation.MediaRelationInfo localMediaRelationInfo = new media_relation.MediaRelationInfo();
      try
      {
        localMediaRelationInfo.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = localMediaRelationInfo;
      }
      catch (Exception localException)
      {
        paramArrayOfByte = null;
        localException.printStackTrace();
      }
      if ((paramArrayOfByte != null) && (paramArrayOfByte.create_time.has()))
      {
        int i = paramArrayOfByte.create_time.get();
        long l = NetConnInfoCenter.getServerTime();
        return i >= l - 604800L;
      }
    }
    return false;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("setIsC2CListenTogetherOpen, app = ");
      ((StringBuilder)localObject2).append(paramQQAppInterface);
      ((StringBuilder)localObject2).append(" frienduin:");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(" isOpen:");
      ((StringBuilder)localObject2).append(paramBoolean);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (paramQQAppInterface != null)
    {
      FriendsManager localFriendsManager = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localFriendsManager != null)
      {
        Friends localFriends = localFriendsManager.m(paramString);
        if ((localFriends == null) || (!localFriends.isFriend())) {
          paramBoolean = false;
        }
        localObject2 = localFriendsManager.x(paramString);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new ExtensionInfo();
          ((ExtensionInfo)localObject1).uin = paramString;
        }
        boolean bool = ((ExtensionInfo)localObject1).isListenTogetherOpen;
        if (bool != paramBoolean)
        {
          ((ExtensionInfo)localObject1).isListenTogetherOpen = paramBoolean;
          localFriendsManager.a((ExtensionInfo)localObject1);
          ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(3, true, paramString);
        }
        if (QLog.isColorLevel())
        {
          paramString = a;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("setIsC2CListenTogetherOpen extensionInfo saved, old=");
          ((StringBuilder)localObject1).append(bool);
          ((StringBuilder)localObject1).append(" new:");
          ((StringBuilder)localObject1).append(paramBoolean);
          ((StringBuilder)localObject1).append(" friend:");
          if (localFriends != null) {
            paramQQAppInterface = Boolean.valueOf(localFriends.isFriend());
          } else {
            paramQQAppInterface = "null";
          }
          ((StringBuilder)localObject1).append(paramQQAppInterface);
          QLog.i(paramString, 2, ((StringBuilder)localObject1).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherAIOStatusHelper
 * JD-Core Version:    0.7.0.1
 */