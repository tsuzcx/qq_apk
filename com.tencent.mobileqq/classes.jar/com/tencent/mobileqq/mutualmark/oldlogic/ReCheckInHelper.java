package com.tencent.mobileqq.mutualmark.oldlogic;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.mutualmark.MutualMarkDataCenter;
import com.tencent.mobileqq.mutualmark.info.MutualMarkForDisplayInfo;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class ReCheckInHelper
{
  WeakReference<QQAppInterface> a;
  int b = 1800;
  
  public ReCheckInHelper(QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(paramQQAppInterface);
  }
  
  public long a(String paramString, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    long l = 0L;
    if (localQQAppInterface == null) {
      return 0L;
    }
    String str;
    if (paramBoolean) {
      str = "issend<>0";
    } else {
      str = "issend=0";
    }
    paramString = localQQAppInterface.getMessageFacade().a(paramString, 0, str);
    if (paramString != null) {
      l = paramString.time;
    }
    return l * 1000L;
  }
  
  public void a(String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    if (localQQAppInterface == null) {
      return;
    }
    FriendsManager localFriendsManager = (FriendsManager)localQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    ExtensionInfo localExtensionInfo = localFriendsManager.d(paramString, true);
    if (!localFriendsManager.a(false))
    {
      if (localExtensionInfo == null) {
        return;
      }
      MutualMarkForDisplayInfo localMutualMarkForDisplayInfo1 = MutualMarkDataCenter.a(localQQAppInterface, paramString, 4L, false);
      MutualMarkForDisplayInfo localMutualMarkForDisplayInfo2 = MutualMarkDataCenter.a(localQQAppInterface, paramString, 5L, false);
      if (localMutualMarkForDisplayInfo1 != null) {
        l1 = localMutualMarkForDisplayInfo1.e * 1000L;
      } else {
        l1 = 0L;
      }
      if (localMutualMarkForDisplayInfo2 != null) {
        l2 = localMutualMarkForDisplayInfo2.e * 1000L;
      } else {
        l2 = 0L;
      }
      int j = HotReactiveHelper.b();
      if ((localMutualMarkForDisplayInfo2 != null) && (localMutualMarkForDisplayInfo2.b > 0L) && (HotReactiveHelper.a(j, l2))) {
        i = 1;
      } else {
        i = 0;
      }
      if ((localMutualMarkForDisplayInfo1 != null) && (localMutualMarkForDisplayInfo1.b > 0L) && (HotReactiveHelper.a(j, l1))) {
        j = 1;
      } else {
        j = 0;
      }
      boolean bool1;
      if ((j == 0) && (i == 0)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      if (!bool1) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FriendReactive.ReCheckInHelper", 2, String.format("startCheck bRemind=%b frdshipType=%s fire=%s uin=%s", new Object[] { Boolean.valueOf(bool1), localMutualMarkForDisplayInfo1, localMutualMarkForDisplayInfo2, paramString }));
      }
      long l2 = localExtensionInfo.lastHotReactiveReCheckInTs;
      this.b = BaseApplicationImpl.getContext().getSharedPreferences(localQQAppInterface.getCurrentAccountUin(), 0).getInt("hotreactive_recheckin_interval", 1800);
      long l1 = SystemClock.elapsedRealtime();
      if (l1 - l2 < this.b * 1000) {
        return;
      }
      l2 = localExtensionInfo.localChatSendTs;
      long l3 = localExtensionInfo.localChatRecTs;
      if (TimeFormatterUtils.c(l2) == 2131917319) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool2;
      if (TimeFormatterUtils.c(l3) == 2131917319) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FriendReactive.ReCheckInHelper", 2, String.format("startCheck msg bSendToday=%b bRecToday=%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      }
      j = 1;
      boolean bool3 = bool1;
      if (!bool1)
      {
        l2 = a(paramString, true);
        if (TimeFormatterUtils.c(l2) == 2131917319) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        bool3 = bool1;
        if (bool1)
        {
          localExtensionInfo.localChatSendTs = l2;
          i = 1;
          bool3 = bool1;
          break label472;
        }
      }
      int i = 0;
      label472:
      if (!bool2)
      {
        l2 = a(paramString, false);
        if (TimeFormatterUtils.c(l2) == 2131917319) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        bool2 = bool1;
        if (bool1)
        {
          localExtensionInfo.localChatRecTs = l2;
          i = 1;
          bool2 = bool1;
        }
      }
      if ((bool2) && (bool3) && (AppNetConnInfo.isNetSupport()))
      {
        localExtensionInfo.lastHotReactiveReCheckInTs = l1;
        if (QLog.isColorLevel()) {
          QLog.i("FriendReactive.ReCheckInHelper", 2, "startCheck recheckin");
        }
        ((FriendListHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).reqRecheckInHotReactive(paramString);
        i = j;
      }
      if (i != 0) {
        localFriendsManager.a(localExtensionInfo);
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    if ((QQAppInterface)this.a.get() == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FriendReactive.ReCheckInHelper", 2, String.format("onRecheckInResp isSuc=%b selfUin=%s frdUin=%s interval=%d", new Object[] { Boolean.valueOf(paramBoolean), paramString1, paramString2, Integer.valueOf(paramInt) }));
    }
    if ((paramBoolean) && (paramInt > 0) && (paramInt != this.b)) {
      BaseApplicationImpl.getContext().getSharedPreferences(paramString1, 0).edit().putInt("hotreactive_recheckin_interval", paramInt).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.oldlogic.ReCheckInHelper
 * JD-Core Version:    0.7.0.1
 */