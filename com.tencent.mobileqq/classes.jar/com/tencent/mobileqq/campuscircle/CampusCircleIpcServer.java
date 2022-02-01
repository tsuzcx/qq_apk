package com.tencent.mobileqq.campuscircle;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.confess.TroopConfessUtil;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.wholepeople.WholePeopleConstant;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Locale;

public class CampusCircleIpcServer
  extends QIPCModule
{
  private static CampusCircleIpcServer a;
  
  private CampusCircleIpcServer(String paramString)
  {
    super(paramString);
  }
  
  public static CampusCircleIpcServer a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new CampusCircleIpcServer("CampusCircleIpcServer_Model");
        }
      }
      finally {}
    }
    return a;
  }
  
  private EIPCResult a(String paramString, Bundle paramBundle)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } else {
      paramString = null;
    }
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleIpcServer", 2, "isInTroopAIO, app is null");
      }
      return null;
    }
    boolean bool = TroopConfessUtil.a(paramString);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("isInTroopAIO, isInAIO ");
      paramString.append(bool);
      QLog.d("MedalWallMng", 2, paramString.toString());
    }
    paramString = new EIPCResult();
    paramString.data = new Bundle();
    paramString.data.putBoolean("isInTroopAIO", bool);
    return paramString;
  }
  
  private EIPCResult a(String paramString, Bundle paramBundle, int paramInt)
  {
    boolean bool = "action_get_red_point".equals(paramString);
    paramString = null;
    if (bool)
    {
      if (paramBundle == null) {
        return null;
      }
      paramBundle = new Bundle();
      EIPCResult localEIPCResult = new EIPCResult();
      localEIPCResult.data = paramBundle;
      if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
        paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      }
      if (paramString == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CampusCircleIpcServer", 2, "getRedPoint, app is null");
        }
        paramBundle.putBoolean("hasRedTouch", false);
        paramBundle.putInt("type", -1);
        paramBundle.putInt("count", 0);
        paramBundle.putLong("seq", -1L);
        paramBundle.putInt("code", -1);
        localEIPCResult.code = -1;
        return localEIPCResult;
      }
      paramString = ((LocalRedTouchManager)paramString.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).a(103421);
      if (paramString != null)
      {
        paramBundle.putBoolean("hasRedTouch", paramString.unReadFlag);
        paramBundle.putInt("type", paramString.redtouchType);
        paramBundle.putInt("count", paramString.count);
        paramBundle.putLong("seq", paramString.curSeq);
        paramBundle.putInt("code", 0);
        localEIPCResult.code = 0;
        return localEIPCResult;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleIpcServer", 2, "getRedPoint, unreadMsg is null");
      }
      paramBundle.putBoolean("hasRedTouch", false);
      paramBundle.putInt("type", -1);
      paramBundle.putInt("count", 0);
      paramBundle.putLong("seq", -1L);
      paramBundle.putInt("code", -1);
      localEIPCResult.code = -1;
      return localEIPCResult;
    }
    return null;
  }
  
  private EIPCResult b(String paramString, Bundle paramBundle)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("CampusCircleIpcServer", 4, String.format(Locale.getDefault(), "updateConfessSwitch action: %s", new Object[] { paramString }));
    }
    if (!"action_confess_update_switch".equals(paramString)) {
      return null;
    }
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } else {
      paramString = null;
    }
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleIpcServer", 2, "updateConfessSwitch, app is null");
      }
      return null;
    }
    int i = paramBundle.getInt("nSwitchValue");
    paramString = (CTEntryMng)paramString.getManager(QQManagerFactory.CTENTRY_MNG);
    paramBundle = paramString.a(1);
    paramString.a(paramBundle, (short)i);
    paramString.a(paramBundle);
    paramString = new EIPCResult();
    paramString.data = new Bundle();
    paramString.data.putInt("ret", 0);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("updateConfessSwitch, nSwitchValue: ");
      paramBundle.append(i);
      QLog.d("CampusCircleIpcServer", 2, paramBundle.toString());
    }
    return paramString;
  }
  
  private EIPCResult b(String paramString, Bundle paramBundle, int paramInt)
  {
    if (("action_report_red_point".equals(paramString)) && (paramBundle != null))
    {
      long l1 = paramBundle.getLong("seq", -1L);
      if (l1 < 0L)
      {
        paramString = new StringBuilder();
        paramString.append("reportRedPoint, webSeq < 0:");
        paramString.append(l1);
        QLog.d("CampusCircleIpcServer", 2, paramString.toString());
      }
      if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
        paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      } else {
        paramString = null;
      }
      if (paramString == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CampusCircleIpcServer", 2, "reportRedPoint, app is null");
        }
        return null;
      }
      Object localObject = (LocalRedTouchManager)paramString.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
      RedTouchItem localRedTouchItem = ((LocalRedTouchManager)localObject).a(103421);
      if (localRedTouchItem == null)
      {
        QLog.d("CampusCircleIpcServer", 2, "reportRedPoint, unReadMsg is null, return");
        paramString = new EIPCResult();
        paramString.data = null;
        paramString.code = -1;
        super.callbackResult(paramInt, paramString);
        return null;
      }
      long l2 = localRedTouchItem.curSeq;
      if (l1 >= l2)
      {
        ((LocalRedTouchManager)localObject).a(103421);
      }
      else
      {
        localRedTouchItem.count = ((int)Math.abs(l2 - l1));
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("unreadmsg.coung set to ");
          localStringBuilder.append(localRedTouchItem.count);
          QLog.d("CampusCircleIpcServer", 2, localStringBuilder.toString());
        }
        ((LocalRedTouchManager)localObject).a(103421, true, l1, true, true);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reportRedPoint, localSeq=");
        ((StringBuilder)localObject).append(l2);
        ((StringBuilder)localObject).append(", webSeq=");
        ((StringBuilder)localObject).append(l1);
        ((StringBuilder)localObject).append(", unreadMsg=");
        ((StringBuilder)localObject).append(localRedTouchItem);
        QLog.d("CampusCircleIpcServer", 2, ((StringBuilder)localObject).toString());
      }
      ((IRedTouchServer)paramString.getRuntimeService(IRedTouchServer.class, "")).notifyRedTouchUpdate(paramString);
      paramString = new EIPCResult();
      paramString.data = paramBundle;
      paramString.code = 0;
      super.callbackResult(paramInt, paramString);
      return null;
    }
    return null;
  }
  
  private EIPCResult c(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "reportMedalRedPoint action: %s", new Object[] { paramString }));
    }
    if (!"action_report_medal_red_point".equals(paramString)) {
      return null;
    }
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } else {
      paramString = null;
    }
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MedalWallMng", 2, "reportMedalRedPoint, app is null");
      }
      return null;
    }
    ((MedalWallMng)paramString.getManager(QQManagerFactory.MEDAL_WALL_MNG)).a(2, null);
    paramString = new EIPCResult();
    paramString.data = paramBundle;
    paramString.code = 0;
    super.callbackResult(paramInt, paramString);
    return null;
  }
  
  private EIPCResult d(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("CampusCircleIpcServer", 4, String.format(Locale.getDefault(), "reportConfessRedPoint action: %s", new Object[] { paramString }));
    }
    if (!"action_confess_clear_red_point".equals(paramString)) {
      return null;
    }
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } else {
      paramString = null;
    }
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MedalWallMng", 2, "reportRedPoint_confess, app is null");
      }
      return null;
    }
    if ("frd_rec_confess".equals(paramBundle.getString("tag"))) {
      ConfessMsgUtil.b(paramString, false);
    }
    paramString = new EIPCResult();
    paramString.data = paramBundle;
    paramString.code = 0;
    super.callbackResult(paramInt, paramString);
    return null;
  }
  
  private EIPCResult e(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("CampusCircleIpcServer", 4, String.format(Locale.getDefault(), "getTroopMembers action: %s", new Object[] { paramString }));
    }
    paramBundle = TroopConfessUtil.a(paramBundle.getString("troopUin"));
    paramString = new EIPCResult();
    paramString.data = new Bundle();
    if ((paramBundle != null) && (paramBundle.length == 3))
    {
      paramString.code = 0;
      boolean bool1 = ((Boolean)paramBundle[0]).booleanValue();
      boolean bool2 = ((Boolean)paramBundle[1]).booleanValue();
      paramBundle = (ArrayList)paramBundle[2];
      if (paramBundle != null) {
        paramString.data.putSerializable("troopUin", paramBundle);
      }
      paramString.data.putBoolean("isAdmin", bool1);
      paramString.data.putBoolean("enableMemInvite", bool2);
      return paramString;
    }
    paramString.code = -1;
    return paramString;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCall, params=");
      localStringBuilder.append(paramBundle);
      localStringBuilder.append(", action=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", callBackId=");
      localStringBuilder.append(paramInt);
      QLog.d("CampusCircleIpcServer", 2, localStringBuilder.toString());
    }
    if (paramBundle == null)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onCall, param is null, action=");
      paramBundle.append(paramString);
      paramBundle.append(", callBackId=");
      paramBundle.append(paramInt);
      QLog.d("CampusCircleIpcServer", 1, paramBundle.toString());
      return null;
    }
    if ("action_get_red_point".equals(paramString)) {
      return a(paramString, paramBundle, paramInt);
    }
    if ("action_report_red_point".equals(paramString)) {
      return b(paramString, paramBundle, paramInt);
    }
    if ("action_report_medal_red_point".equals(paramString)) {
      return c(paramString, paramBundle, paramInt);
    }
    if ("action_allpeoplevote_getredpoint".equals(paramString)) {
      return WholePeopleConstant.b(paramString, paramBundle, paramInt);
    }
    if ("action_allpeoplevote_clearredpoint".equals(paramString)) {
      return WholePeopleConstant.a(paramString, paramBundle, paramInt);
    }
    if ("action_confess_clear_red_point".equals(paramString)) {
      return d(paramString, paramBundle, paramInt);
    }
    if ("action_confess_get_troop_members".equals(paramString)) {
      return e(paramString, paramBundle, paramInt);
    }
    if ("action_confess_is_in_troop_aio".equals(paramString)) {
      return a(paramString, paramBundle);
    }
    if ("action_confess_update_switch".equals(paramString)) {
      return b(paramString, paramBundle);
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onCall, invalid action:");
      paramBundle.append(paramString);
      QLog.d("CampusCircleIpcServer", 1, paramBundle.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.campuscircle.CampusCircleIpcServer
 * JD-Core Version:    0.7.0.1
 */