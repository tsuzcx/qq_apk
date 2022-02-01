package com.tencent.mobileqq.mutualmark.oldlogic;

import android.content.res.Resources;
import android.os.Message;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.qzonelover.QzoneLoverService;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.mutualmark.MutualMarkConfigHelper;
import com.tencent.mobileqq.mutualmark.MutualMarkDataCenter;
import com.tencent.mobileqq.mutualmark.MutualMarkIconProxyDrawable;
import com.tencent.mobileqq.mutualmark.MutualMarkUtils;
import com.tencent.mobileqq.mutualmark.info.MutualMarkForDisplayInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class OldMutualMarkLogicHelper
{
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ThreadManager.post(new OldMutualMarkLogicHelper.3(paramQQAppInterface), 5, null, true);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo, MessageForUniteGrayTip paramMessageForUniteGrayTip, MqqHandler paramMqqHandler, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    if (!TextUtils.isEmpty(paramMessageForUniteGrayTip.caidanAnimUrl))
    {
      paramBaseSessionInfo = AioAnimationDetector.a();
      paramMessageForUniteGrayTip = new MutualMarkIconProxyDrawable(BaseApplicationImpl.getContext(), paramMessageForUniteGrayTip.caidanAnimUrl);
      if (paramMessageForUniteGrayTip.a())
      {
        paramBaseSessionInfo.a(paramQQAppInterface, false, true, paramAIOAnimationConatiner, 0, paramMessageForUniteGrayTip, 4);
        return;
      }
      paramMqqHandler.postDelayed(new OldMutualMarkLogicHelper.2(paramMessageForUniteGrayTip, paramBaseSessionInfo, paramQQAppInterface, paramAIOAnimationConatiner), 800L);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo, MessageForUniteGrayTip paramMessageForUniteGrayTip, MqqHandler paramMqqHandler, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt)
  {
    if (a(paramMessageForUniteGrayTip.subType))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendReactive", 2, "new message graytips big ship");
      }
      paramMqqHandler.sendEmptyMessage(70);
      return;
    }
    if (b(paramMessageForUniteGrayTip.subType))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendReactive", 2, "new message graytips friendship");
      }
      paramMqqHandler.sendEmptyMessage(88);
      return;
    }
    if (c(paramMessageForUniteGrayTip.subType))
    {
      paramMqqHandler.obtainMessage(201, new String[] { paramMessageForUniteGrayTip.caidanAnimUrl, paramMessageForUniteGrayTip.caidanAnimUrlMd5 }).sendToTarget();
      return;
    }
    if (d(paramMessageForUniteGrayTip.subType))
    {
      a(paramQQAppInterface, paramBaseSessionInfo, paramMessageForUniteGrayTip, paramMqqHandler, paramAIOAnimationConatiner);
      return;
    }
    paramMessageForUniteGrayTip = AioAnimationDetector.a();
    if (paramInt == 3) {
      paramBaseSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130852336);
    }
    for (;;)
    {
      break;
      if (paramInt == 26)
      {
        paramBaseSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130852337);
      }
      else if (paramInt == 27)
      {
        paramBaseSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130852338);
      }
      else if (paramInt == 4)
      {
        paramBaseSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130852283);
      }
      else if (paramInt == 28)
      {
        paramBaseSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130852284);
      }
      else if (paramInt == 29)
      {
        paramBaseSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130852285);
      }
      else if (paramInt == 1)
      {
        paramBaseSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130852340);
      }
      else if (paramInt == 2)
      {
        paramBaseSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130852287);
      }
      else if (paramInt == 5)
      {
        paramBaseSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130852339);
      }
      else if (paramInt == 30)
      {
        paramBaseSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130852341);
      }
      else if (paramInt == 31)
      {
        paramBaseSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130852342);
      }
      else if (paramInt == 7)
      {
        paramBaseSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130852334);
      }
      else if (paramInt == 8)
      {
        paramBaseSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130852335);
      }
      else
      {
        if (paramInt == 11) {}
        do
        {
          do
          {
            paramBaseSessionInfo = null;
            break;
            if (paramInt == 12)
            {
              paramBaseSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130852304);
              break;
            }
            if (paramInt == 13)
            {
              paramBaseSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130852305);
              break;
            }
            if (paramInt == 14)
            {
              paramBaseSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130852312);
              break;
            }
            if (paramInt == 15)
            {
              paramBaseSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130852313);
              break;
            }
            if (paramInt == 16)
            {
              paramBaseSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130852314);
              break;
            }
            if (paramInt == 17)
            {
              paramBaseSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130852306);
              break;
            }
            if (paramInt == 18)
            {
              paramBaseSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130852307);
              break;
            }
            if (paramInt == 19)
            {
              paramBaseSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130852308);
              break;
            }
            if (paramInt == 20)
            {
              paramBaseSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130852309);
              break;
            }
            if (paramInt == 21)
            {
              paramBaseSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130852310);
              break;
            }
            if (paramInt == 22)
            {
              paramBaseSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130852311);
              break;
            }
            if (paramInt == 23)
            {
              paramBaseSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130852315);
              break;
            }
            if (paramInt == 24)
            {
              paramBaseSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130852316);
              break;
            }
            if (paramInt == 25)
            {
              paramBaseSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(2130852317);
              break;
            }
          } while ((!MutualMarkUtils.a(paramInt)) || (paramBaseSessionInfo == null));
          paramInt = MutualMarkConfigHelper.a(paramQQAppInterface, paramBaseSessionInfo.b, String.valueOf(paramInt));
        } while (paramInt == 0);
        paramBaseSessionInfo = BaseApplicationImpl.getContext().getResources().getDrawable(paramInt);
      }
    }
    if (paramBaseSessionInfo != null) {
      paramMessageForUniteGrayTip.a(paramQQAppInterface, false, true, paramAIOAnimationConatiner, 0, paramBaseSessionInfo, 4);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, FriendChatPie paramFriendChatPie)
  {
    ThreadManager.post(new OldMutualMarkLogicHelper.1(paramQQAppInterface, paramSessionInfo, paramFriendChatPie), 5, null, false);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, List<ChatMessage> paramList, FriendChatPie paramFriendChatPie)
  {
    if ((QzoneLoverService.a().c()) && (a(paramQQAppInterface, paramSessionInfo, paramList)))
    {
      paramFriendChatPie.bp = true;
      QzoneLoverService.a().b();
      if (QLog.isColorLevel()) {
        QLog.i("OldMutualMarkLogicHelper", 2, "checkLightingQzoneLover enter!!!!!!!!");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.i("OldMutualMarkLogicHelper", 2, "checkLightingQzoneLover not enter!!!!!!!!");
    }
  }
  
  public static boolean a(int paramInt)
  {
    if ((paramInt != 6) && (paramInt != 32))
    {
      if (paramInt == 33) {
        return true;
      }
      return paramInt == MutualMarkUtils.b(12L, 2L);
    }
    return true;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, List<ChatMessage> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()) && (paramSessionInfo != null))
    {
      if (paramQQAppInterface == null) {
        return false;
      }
      long l = MessageCache.c();
      Time localTime1 = new Time();
      localTime1.set(l * 1000L);
      Time localTime2 = new Time();
      int i = paramList.size() - 1;
      boolean bool1 = false;
      boolean bool2 = false;
      if (i >= 0) {}
      for (;;)
      {
        try
        {
          ChatMessage localChatMessage = (ChatMessage)paramList.get(i);
          boolean bool4;
          boolean bool3;
          if (localChatMessage == null)
          {
            bool4 = bool2;
            bool3 = bool1;
          }
          else if (Math.abs(localChatMessage.time - l) <= 86400L)
          {
            if (!a(localChatMessage))
            {
              bool4 = bool2;
              bool3 = bool1;
              continue;
            }
            if (!TextUtils.equals(localChatMessage.senderuin, paramSessionInfo.b))
            {
              bool4 = bool2;
              bool3 = bool1;
              if (!TextUtils.equals(localChatMessage.senderuin, paramQQAppInterface.getCurrentAccountUin())) {
                continue;
              }
            }
            localTime2.set(localChatMessage.time * 1000L);
            bool4 = bool2;
            bool3 = bool1;
            if (localTime1.year != localTime2.year) {
              continue;
            }
            bool4 = bool2;
            bool3 = bool1;
            if (localTime1.yearDay != localTime2.yearDay) {
              continue;
            }
            bool3 = TextUtils.equals(localChatMessage.senderuin, paramSessionInfo.b);
            if (bool3) {
              bool2 = true;
            } else {
              bool1 = true;
            }
            bool4 = bool2;
            bool3 = bool1;
            if (!bool1) {
              continue;
            }
            bool4 = bool2;
            bool3 = bool1;
            if (bool2) {
              break label358;
            }
          }
          bool1 = bool3;
          i -= 1;
          bool2 = bool4;
        }
        catch (Throwable paramQQAppInterface)
        {
          paramSessionInfo = new StringBuilder();
          paramSessionInfo.append("hasInteractiveToday error: ");
          paramSessionInfo.append(paramQQAppInterface.getMessage());
          QLog.e("OldMutualMarkLogicHelper", 1, paramSessionInfo.toString());
          bool1 = false;
          bool2 = false;
          break label358;
        }
      }
      label358:
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("hasInteractiveToday selfSend:");
        paramQQAppInterface.append(bool1);
        paramQQAppInterface.append(" friendSend: ");
        paramQQAppInterface.append(bool2);
        QLog.i("OldMutualMarkLogicHelper", 2, paramQQAppInterface.toString());
      }
      return (bool1) && (bool2);
    }
    return false;
  }
  
  private static boolean a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      return false;
    }
    int[] arrayOfInt = new int[19];
    int[] tmp12_11 = arrayOfInt;
    tmp12_11[0] = -1000;
    int[] tmp18_12 = tmp12_11;
    tmp18_12[1] = -1001;
    int[] tmp24_18 = tmp18_12;
    tmp24_18[2] = -2009;
    int[] tmp30_24 = tmp24_18;
    tmp30_24[3] = -2045;
    int[] tmp36_30 = tmp30_24;
    tmp36_30[4] = -2009;
    int[] tmp42_36 = tmp36_30;
    tmp42_36[5] = -2001;
    int[] tmp48_42 = tmp42_36;
    tmp48_42[6] = -2005;
    int[] tmp55_48 = tmp48_42;
    tmp55_48[7] = -2000;
    int[] tmp62_55 = tmp55_48;
    tmp62_55[8] = -2002;
    int[] tmp69_62 = tmp62_55;
    tmp69_62[9] = -2008;
    int[] tmp76_69 = tmp69_62;
    tmp76_69[10] = -2022;
    int[] tmp83_76 = tmp76_69;
    tmp83_76[11] = -30002;
    int[] tmp90_83 = tmp83_76;
    tmp90_83[12] = -2011;
    int[] tmp97_90 = tmp90_83;
    tmp97_90[13] = -2020;
    int[] tmp104_97 = tmp97_90;
    tmp104_97[14] = -2025;
    int[] tmp111_104 = tmp104_97;
    tmp111_104[15] = -2065;
    int[] tmp118_111 = tmp111_104;
    tmp118_111[16] = -2066;
    int[] tmp125_118 = tmp118_111;
    tmp125_118[17] = -3000;
    int[] tmp132_125 = tmp125_118;
    tmp132_125[18] = -1035;
    tmp132_125;
    int i = 0;
    while (i < arrayOfInt.length)
    {
      if (paramChatMessage.msgtype == arrayOfInt[i]) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, FriendChatPie paramFriendChatPie)
  {
    if (paramFriendChatPie.bp) {
      return;
    }
    Object localObject = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    String str = paramSessionInfo.b;
    int j = 0;
    if (((FriendsManager)localObject).d(str, false) == null) {
      return;
    }
    localObject = MutualMarkDataCenter.a(paramQQAppInterface, paramSessionInfo.b, 7L, false);
    int i = j;
    if (localObject != null)
    {
      i = j;
      if (((MutualMarkForDisplayInfo)localObject).b > 0L)
      {
        i = j;
        if (((MutualMarkForDisplayInfo)localObject).a()) {
          i = 1;
        }
      }
    }
    if (i != 0) {
      a(paramQQAppInterface, paramSessionInfo, paramQQAppInterface.getMessageFacade().o(paramSessionInfo.b, paramSessionInfo.a), paramFriendChatPie);
    }
  }
  
  public static boolean b(int paramInt)
  {
    if (paramInt == 13) {
      return true;
    }
    return paramInt == MutualMarkUtils.b(4L, 3L);
  }
  
  public static boolean c(int paramInt)
  {
    return paramInt == 999;
  }
  
  public static boolean d(int paramInt)
  {
    return paramInt == 998;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper
 * JD-Core Version:    0.7.0.1
 */