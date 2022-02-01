package com.tencent.mobileqq.mutualmark.alienation;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.ExtSnsRelationChainChangePushInfo;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.MutualMarkConfBean;
import com.tencent.mobileqq.config.business.MutualMarkConfProcessor;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.mutualmark.MutualMarkGrayTipsHelper.GrayTipHighlightItemInfo;
import com.tencent.mobileqq.utils.VipUtils;
import java.util.ArrayList;

public class MutualMarkAlienationHelper
{
  public static int a(AppInterface paramAppInterface, String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)paramLong1;
    if (i != 12)
    {
      if (i == 13) {
        break label491;
      }
      if (i != 19) {
        if (i == 26) {
          break label491;
        }
      }
    }
    switch (i)
    {
    default: 
      return 0;
    case 5: 
      i = VipUtils.a(paramAppInterface, paramString, 0);
      if (i == 1)
      {
        if (paramLong2 == 1L) {
          return 2130852337;
        }
        if (paramLong2 == 2L) {
          return 2130852284;
        }
      }
      else if (i == 2)
      {
        if (paramLong2 == 1L) {
          return 2130852338;
        }
        if (paramLong2 == 2L) {
          return 2130852285;
        }
      }
      break;
    case 3: 
      i = VipUtils.a(paramAppInterface, paramString, 4);
      if (i == 1)
      {
        if (paramLong2 == 0L) {
          return 2130841108;
        }
        if (paramLong2 == 1L) {
          return 2130841109;
        }
        if (paramLong2 == 2L) {
          return 2130841110;
        }
      }
      else if (i == 2)
      {
        if (paramLong2 == 0L) {
          return 2130841111;
        }
        if (paramLong2 == 1L) {
          return 2130841112;
        }
        if (paramLong2 == 2L) {
          return 2130841113;
        }
      }
      break;
    case 2: 
      i = VipUtils.a(paramAppInterface, paramString, 3);
      if (i == 1)
      {
        if (paramLong2 == 0L) {
          return 2130841102;
        }
        if (paramLong2 == 1L) {
          return 2130841103;
        }
        if (paramLong2 == 2L) {
          return 2130841104;
        }
      }
      else if (i == 2)
      {
        if (paramLong2 == 0L) {
          return 2130841105;
        }
        if (paramLong2 == 1L) {
          return 2130841106;
        }
        if (paramLong2 == 2L) {
          return 2130841107;
        }
      }
      break;
    case 1: 
      if (VipUtils.a(paramAppInterface, paramString, 2) > 0)
      {
        if (paramLong2 == 0L) {
          return 2130852315;
        }
        if (paramLong2 == 1L) {
          return 2130852316;
        }
        if (paramLong2 == 2L)
        {
          return 2130852317;
          i = VipUtils.a(paramAppInterface, paramString, 5);
          if ((i == 1) && (paramLong2 == 1L)) {
            return 2130852330;
          }
          if ((i == 2) && (paramLong2 == 1L)) {
            return 2130852331;
          }
          if ((i == 3) && (paramLong2 == 1L)) {
            return 2130852332;
          }
          if ((i == 4) && (paramLong2 == 1L))
          {
            return 2130852329;
            i = VipUtils.a(paramAppInterface, paramString, 1);
            if (i == 1)
            {
              if (paramLong2 == 1L) {
                return 2130852341;
              }
              if (paramLong2 == 2L) {
                return 2130852288;
              }
            }
            else if (i == 2)
            {
              if (paramLong2 == 1L) {
                return 2130852342;
              }
              if (paramLong2 == 2L) {
                return 2130852289;
              }
            }
          }
        }
      }
      break;
    }
    label491:
    return 0;
  }
  
  public static String a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return paramString2;
    }
    Object localObject = paramString2.split("/");
    if (localObject.length < 2) {
      return paramString2;
    }
    String str = localObject[(localObject.length - 2)];
    MutualMarkConfBean localMutualMarkConfBean = MutualMarkConfProcessor.a();
    if (localMutualMarkConfBean == null) {
      return paramString2;
    }
    localObject = paramString2;
    if (localMutualMarkConfBean.c(str) > 0)
    {
      int i = VipUtils.a(paramAppInterface, paramString1, 0);
      localObject = paramString2;
      if (i > 0) {
        localObject = RelationVipHelper.a(paramString2, i, false);
      }
    }
    return localObject;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, long paramLong1, long paramLong2, long paramLong3, String paramString2)
  {
    int i = VipUtils.a(paramQQAppInterface, paramString1, 0);
    if (i <= 0) {
      return paramString2;
    }
    if ((paramLong2 != 6L) || (paramLong3 <= 0L))
    {
      paramQQAppInterface = paramString2;
      if (paramLong1 != 5L) {}
    }
    else
    {
      paramQQAppInterface = RelationVipHelper.a(paramString2, i, false);
    }
    if (!TextUtils.isEmpty(paramQQAppInterface)) {
      return paramQQAppInterface;
    }
    paramString1 = paramQQAppInterface;
    if (paramLong2 > 0L)
    {
      paramString1 = paramQQAppInterface;
      if (paramLong1 == 5L) {
        paramString1 = RelationVipHelper.a(paramLong1, i, paramLong2, false);
      }
    }
    return paramString1;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if ((paramFriends != null) && (paramArrayOfByte != null))
    {
      if (paramArrayOfByte.length <= 0) {
        return;
      }
      if (paramArrayOfByte.length > 1)
      {
        int i = paramArrayOfByte[1];
        paramFriends.relationIconFlag = (paramArrayOfByte[0] & 0xFF | i << 8);
      }
      else
      {
        paramFriends.relationIconFlag = paramArrayOfByte[0];
      }
      if (paramBoolean)
      {
        paramFriendsManager.b(paramFriends);
        paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, paramString);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, String paramString, UniteGrayTipParam paramUniteGrayTipParam, ArrayList<MutualMarkGrayTipsHelper.GrayTipHighlightItemInfo> paramArrayList) {}
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, StringBuilder paramStringBuilder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.alienation.MutualMarkAlienationHelper
 * JD-Core Version:    0.7.0.1
 */