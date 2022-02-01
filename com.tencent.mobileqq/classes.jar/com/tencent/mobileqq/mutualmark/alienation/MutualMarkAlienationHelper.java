package com.tencent.mobileqq.mutualmark.alienation;

import android.text.TextUtils;
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
  public static int a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2)
  {
    switch ((int)paramLong1)
    {
    }
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  return 0;
                                } while (VipUtils.a(paramQQAppInterface, paramString, 2) <= 0);
                                if (paramLong2 == 0L) {
                                  return 2130850593;
                                }
                                if (paramLong2 == 1L) {
                                  return 2130850594;
                                }
                              } while (paramLong2 != 2L);
                              return 2130850595;
                              i = VipUtils.a(paramQQAppInterface, paramString, 3);
                              if (i != 1) {
                                break;
                              }
                              if (paramLong2 == 0L) {
                                return 2130840493;
                              }
                              if (paramLong2 == 1L) {
                                return 2130840494;
                              }
                            } while (paramLong2 != 2L);
                            return 2130840495;
                          } while (i != 2);
                          if (paramLong2 == 0L) {
                            return 2130840496;
                          }
                          if (paramLong2 == 1L) {
                            return 2130840497;
                          }
                        } while (paramLong2 != 2L);
                        return 2130840498;
                        i = VipUtils.a(paramQQAppInterface, paramString, 4);
                        if (i != 1) {
                          break;
                        }
                        if (paramLong2 == 0L) {
                          return 2130840499;
                        }
                        if (paramLong2 == 1L) {
                          return 2130840500;
                        }
                      } while (paramLong2 != 2L);
                      return 2130840501;
                    } while (i != 2);
                    if (paramLong2 == 0L) {
                      return 2130840502;
                    }
                    if (paramLong2 == 1L) {
                      return 2130840503;
                    }
                  } while (paramLong2 != 2L);
                  return 2130840504;
                  i = VipUtils.a(paramQQAppInterface, paramString, 0);
                  if (i != 1) {
                    break;
                  }
                  if (paramLong2 == 1L) {
                    return 2130850615;
                  }
                } while (paramLong2 != 2L);
                return 2130850562;
              } while (i != 2);
              if (paramLong2 == 1L) {
                return 2130850616;
              }
            } while (paramLong2 != 2L);
            return 2130850563;
            i = VipUtils.a(paramQQAppInterface, paramString, 1);
            if (i != 1) {
              break;
            }
            if (paramLong2 == 1L) {
              return 2130850619;
            }
          } while (paramLong2 != 2L);
          return 2130850566;
        } while (i != 2);
        if (paramLong2 == 1L) {
          return 2130850620;
        }
      } while (paramLong2 != 2L);
      return 2130850567;
      i = VipUtils.a(paramQQAppInterface, paramString, 5);
      if ((i == 1) && (paramLong2 == 1L)) {
        return 2130850608;
      }
      if ((i == 2) && (paramLong2 == 1L)) {
        return 2130850609;
      }
      if ((i == 3) && (paramLong2 == 1L)) {
        return 2130850610;
      }
    } while ((i != 4) || (paramLong2 != 1L));
    return 2130850607;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, long paramLong1, long paramLong2, long paramLong3, String paramString2)
  {
    int i;
    String str;
    if ((paramLong2 == 6L) && (paramLong3 > 0L))
    {
      i = VipUtils.a(paramQQAppInterface, paramString1, 0);
      str = paramString2;
      if (i > 0) {
        str = RelationVipHelper.a(paramString2, i, false);
      }
    }
    do
    {
      do
      {
        do
        {
          return str;
          str = paramString2;
        } while (paramLong2 <= 0L);
        str = paramString2;
      } while (paramLong1 != 5L);
      i = VipUtils.a(paramQQAppInterface, paramString1, 0);
      str = paramString2;
    } while (i <= 0);
    return RelationVipHelper.a(paramLong1, i, paramLong2, false);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    int i;
    do
    {
      Object localObject;
      MutualMarkConfBean localMutualMarkConfBean;
      do
      {
        do
        {
          return paramString2;
          localObject = paramString2.split("/");
        } while (localObject.length < 2);
        localObject = localObject[(localObject.length - 2)];
        localMutualMarkConfBean = MutualMarkConfProcessor.a();
      } while ((localMutualMarkConfBean == null) || (localMutualMarkConfBean.a((String)localObject) <= 0));
      i = VipUtils.a(paramQQAppInterface, paramString1, 0);
    } while (i <= 0);
    return RelationVipHelper.a(paramString2, i, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, Friends paramFriends, String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if ((paramFriends == null) || (paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {}
    for (;;)
    {
      return;
      if (paramArrayOfByte.length > 1) {}
      for (paramFriends.relationIconFlag = (paramArrayOfByte[1] << 8 | paramArrayOfByte[0]); paramBoolean; paramFriends.relationIconFlag = paramArrayOfByte[0])
      {
        paramFriendsManager.a(paramFriends);
        paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, paramString);
        return;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, String paramString, UniteGrayTipParam paramUniteGrayTipParam, ArrayList<MutualMarkGrayTipsHelper.GrayTipHighlightItemInfo> paramArrayList) {}
  
  public static void a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, ExtSnsRelationChainChangePushInfo paramExtSnsRelationChainChangePushInfo, StringBuilder paramStringBuilder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.alienation.MutualMarkAlienationHelper
 * JD-Core Version:    0.7.0.1
 */