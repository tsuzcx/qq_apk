package com.tencent.mobileqq.subaccount;

import QQService.BindUin;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.data.RecentItemSubAccount;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.message.AbsSubAccountMessageProcessor;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.automator.api.IAutomatorApi;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.imcore.proxy.utils.ContactUtilsProxy;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountConfigApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService.SubAccountUnReadItem;
import com.tencent.mobileqq.subaccount.api.ISubAccountProtocService;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.api.IContactUtils;
import com.tencent.mobileqq.utils.api.IDBUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;

public class SubAccountControllUtil
{
  public static int a(AppInterface paramAppInterface)
  {
    int k = 0;
    int j = 0;
    int i = k;
    if (paramAppInterface != null)
    {
      i = k;
      if (paramAppInterface.isRunning())
      {
        if (TextUtils.isEmpty(paramAppInterface.getCurrentUin())) {
          return 0;
        }
        Object localObject = (ISubAccountControlService)paramAppInterface.getRuntimeService(ISubAccountControlService.class, "");
        if (localObject != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramAppInterface.getCurrentUin());
          localStringBuilder.append("_all_third_last_msg_time");
          j = ((ISubAccountControlService)localObject).getAssociatedQQCacheInt(localStringBuilder.toString());
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getAllThirdQQMsgUnreadLastTime() lastTime=");
          ((StringBuilder)localObject).append(j);
          QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
        }
        long l = MessageCache.a();
        i = j;
        if (j > l)
        {
          i = (int)l;
          a(paramAppInterface, i);
        }
      }
    }
    return i;
  }
  
  public static int a(AppInterface paramAppInterface, IConversationFacade paramIConversationFacade)
  {
    int k = 0;
    int i = 0;
    int j = k;
    if (paramAppInterface != null)
    {
      j = k;
      if (paramAppInterface.isRunning())
      {
        if (paramIConversationFacade == null) {
          return 0;
        }
        ISubAccountService localISubAccountService = (ISubAccountService)paramAppInterface.getRuntimeService(ISubAccountService.class, "");
        if (localISubAccountService != null)
        {
          Iterator localIterator = localISubAccountService.getAllSubAccountInfo().iterator();
          i = 0;
          while (localIterator.hasNext())
          {
            Object localObject = (SubAccountInfo)localIterator.next();
            if ((localObject != null) && (!TextUtils.isEmpty(((SubAccountInfo)localObject).subuin)) && (localISubAccountService.getStatus(((SubAccountInfo)localObject).subuin) == 1)) {
              j = paramIConversationFacade.getUnreadCount(((SubAccountInfo)localObject).subuin, 7000);
            } else {
              j = 0;
            }
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("getAllSubAccountMsgUnreadNum() subuin=");
              if (localObject == null) {
                localObject = Integer.valueOf(0);
              } else {
                localObject = ((SubAccountInfo)localObject).subuin;
              }
              localStringBuilder.append(localObject);
              localStringBuilder.append(" num=");
              localStringBuilder.append(j);
              QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
            }
            i += j;
          }
        }
        j = i;
        if (QLog.isColorLevel())
        {
          paramIConversationFacade = new StringBuilder();
          paramIConversationFacade.append("getAllSubAccountMsgUnreadNum() currentUin=");
          paramIConversationFacade.append(paramAppInterface.getCurrentUin());
          paramIConversationFacade.append(" allNum=");
          paramIConversationFacade.append(i);
          QLog.d("SUB_ACCOUNT", 2, paramIConversationFacade.toString());
          j = i;
        }
      }
    }
    return j;
  }
  
  public static int a(AppInterface paramAppInterface, String paramString)
  {
    int j = 0;
    int i = j;
    if (paramAppInterface != null)
    {
      i = j;
      if (paramAppInterface.isRunning())
      {
        i = j;
        if (!TextUtils.isEmpty(paramString))
        {
          if (TextUtils.isEmpty(paramAppInterface.getCurrentUin())) {
            return 0;
          }
          Object localObject = (ISubAccountControlService)paramAppInterface.getRuntimeService(ISubAccountControlService.class, "");
          i = j;
          if (localObject != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramAppInterface.getCurrentUin());
            localStringBuilder.append("_");
            localStringBuilder.append(paramString);
            localStringBuilder.append("_msgNum");
            j = ((ISubAccountControlService)localObject).getAssociatedQQCacheInt(localStringBuilder.toString());
            i = j;
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("getLocalThirdUnreadMsgNum() currentUin=");
              ((StringBuilder)localObject).append(paramAppInterface.getCurrentUin());
              ((StringBuilder)localObject).append(" thirdUin=");
              ((StringBuilder)localObject).append(paramString);
              ((StringBuilder)localObject).append(" num=");
              ((StringBuilder)localObject).append(j);
              QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
              i = j;
            }
          }
        }
      }
    }
    return i;
  }
  
  public static int a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    int k = 0;
    int i = 0;
    int j = k;
    if (paramAppInterface != null)
    {
      j = k;
      if (paramAppInterface.isRunning())
      {
        j = k;
        if (!TextUtils.isEmpty(paramString1))
        {
          if (!TextUtils.equals(paramString1, paramAppInterface.getCurrentUin())) {
            return 0;
          }
          paramAppInterface = (ISubAccountControlService)paramAppInterface.getRuntimeService(ISubAccountControlService.class, "");
          if (paramAppInterface != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramString1);
            localStringBuilder.append("_");
            localStringBuilder.append(paramString2);
            localStringBuilder.append("_spcares_sysTime");
            i = paramAppInterface.getAssociatedQQCacheInt(localStringBuilder.toString());
          }
          j = i;
          if (QLog.isColorLevel())
          {
            paramAppInterface = new StringBuilder();
            paramAppInterface.append("getReqSubAccountSpecialCareListSysTime mainUin=");
            paramAppInterface.append(paramString1);
            paramAppInterface.append(" subUin=");
            paramAppInterface.append(paramString2);
            paramAppInterface.append(" sysTime=");
            paramAppInterface.append(i);
            QLog.d("SUB_ACCOUNT", 2, paramAppInterface.toString());
            j = i;
          }
        }
      }
    }
    return j;
  }
  
  public static ISubAccountControlService.SubAccountUnReadItem a(AppInterface paramAppInterface, String paramString)
  {
    ISubAccountControlService.SubAccountUnReadItem localSubAccountUnReadItem = new ISubAccountControlService.SubAccountUnReadItem();
    if (paramAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return localSubAccountUnReadItem;
      }
      paramAppInterface = (ISubAccountService)paramAppInterface.getRuntimeService(ISubAccountService.class, "");
      int i = paramAppInterface.getUnreadAllMsgNum(paramString);
      if (i > 0)
      {
        localSubAccountUnReadItem.jdField_a_of_type_Int = i;
        return localSubAccountUnReadItem;
      }
      if (((ISubAccountConfigApi)QRoute.api(ISubAccountConfigApi.class)).getIsHideSubAccountTroopMsg()) {
        return localSubAccountUnReadItem;
      }
      i = paramAppInterface.getUnreadAllTroopMsgNum(paramString);
      if (i > 0)
      {
        localSubAccountUnReadItem.jdField_a_of_type_Int = i;
        localSubAccountUnReadItem.jdField_a_of_type_Boolean = true;
      }
    }
    return localSubAccountUnReadItem;
  }
  
  public static Pair<Boolean, Boolean> a(AppInterface paramAppInterface, String paramString)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool4 = false;
    Object localObject = Boolean.valueOf(false);
    if ((paramAppInterface != null) && (paramString != null))
    {
      paramAppInterface = paramAppInterface.getApplication().getAllAccounts();
      if ((paramAppInterface != null) && (paramAppInterface.size() != 0))
      {
        int i = 0;
        while (i < paramAppInterface.size())
        {
          localObject = (SimpleAccount)paramAppInterface.get(i);
          if (localObject == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "checkSubAccountLoginStatus() sAccount == null");
            }
          }
          else if (((SimpleAccount)localObject).getUin() == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "checkSubAccountLoginStatus() sAccount.getUin() == null");
            }
          }
          else if (((SimpleAccount)localObject).getUin().equalsIgnoreCase(paramString))
          {
            bool1 = bool3;
            bool2 = bool4;
            if (!((SimpleAccount)localObject).isLogined()) {
              break label172;
            }
            bool2 = true;
            bool1 = bool3;
            break label172;
          }
          i += 1;
        }
        bool1 = false;
        bool2 = bool4;
        label172:
        if (QLog.isColorLevel())
        {
          paramAppInterface = new StringBuilder();
          paramAppInterface.append("checkSubAccountLoginStatus() hasAccount=");
          paramAppInterface.append(bool1);
          paramAppInterface.append(" isLogin=");
          paramAppInterface.append(bool2);
          QLog.d("SUB_ACCOUNT", 2, paramAppInterface.toString());
        }
        return new Pair(Boolean.valueOf(bool1), Boolean.valueOf(bool2));
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("checkSubAccountLoginStatus() app.getAllAccounts() is null? =>");
        if (paramAppInterface != null) {
          bool1 = false;
        }
        paramString.append(bool1);
        QLog.d("SUB_ACCOUNT", 2, paramString.toString());
      }
      return new Pair(localObject, localObject);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkSubAccountLoginStatus() app is null?=>");
      if (paramAppInterface == null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localStringBuilder.append(bool1);
      localStringBuilder.append(" subUin is null?=>");
      if (paramString == null) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      localStringBuilder.append(bool1);
      QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
    }
    return new Pair(localObject, localObject);
  }
  
  public static String a(AppInterface paramAppInterface, SimpleAccount paramSimpleAccount)
  {
    if ((paramAppInterface != null) && (paramAppInterface.isRunning()) && (!TextUtils.isEmpty(paramAppInterface.getCurrentUin())) && (paramSimpleAccount != null))
    {
      String str2 = a(paramAppInterface, paramSimpleAccount.getUin());
      String str1 = str2;
      if (paramSimpleAccount.isLogined()) {
        if (!TextUtils.isEmpty(str2))
        {
          str1 = str2;
          if (!str2.equals(paramSimpleAccount.getUin())) {}
        }
        else
        {
          str1 = b(paramAppInterface, paramSimpleAccount.getUin());
        }
      }
      paramAppInterface = str1;
      if (TextUtils.isEmpty(str1)) {
        paramAppInterface = paramSimpleAccount.getUin();
      }
      if (QLog.isColorLevel())
      {
        paramSimpleAccount = new StringBuilder();
        paramSimpleAccount.append("getShowName() showName=");
        paramSimpleAccount.append(paramAppInterface);
        QLog.d("SUB_ACCOUNT", 2, paramSimpleAccount.toString());
      }
      return paramAppInterface;
    }
    return "";
  }
  
  public static String a(AppInterface paramAppInterface, String paramString)
  {
    if (paramString == null) {
      return null;
    }
    Object localObject = paramAppInterface.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Constants.PropertiesKey.nickName.toString());
    localStringBuilder.append(paramString);
    localObject = ((MobileQQ)localObject).getProperty(localStringBuilder.toString());
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramAppInterface = ((IFriendDataService)paramAppInterface.getRuntimeService(IFriendDataService.class, "")).getFriend(paramString, true);
      if (paramAppInterface != null)
      {
        paramAppInterface = paramAppInterface.name;
        break label86;
      }
    }
    paramAppInterface = (AppInterface)localObject;
    label86:
    localObject = paramAppInterface;
    if (TextUtils.isEmpty(paramAppInterface)) {
      localObject = paramString;
    }
    return localObject;
  }
  
  public static String a(AppInterface paramAppInterface, String paramString1, int paramInt, String paramString2)
  {
    BaseApplication localBaseApplication = paramAppInterface.getApp();
    boolean bool = a(paramInt);
    paramString1 = null;
    Object localObject = null;
    if (bool)
    {
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          paramString1 = localObject;
        }
        break;
      case -1007: 
        paramString1 = localBaseApplication.getString(2131689526);
        break;
      case -1008: 
        paramString1 = localBaseApplication.getString(2131689525);
        break;
      case -1009: 
        paramString1 = localBaseApplication.getString(2131718177);
        break;
      case -1010: 
        paramString1 = localBaseApplication.getString(2131689659);
        break;
      case -1011: 
      case -1006: 
        paramString1 = localBaseApplication.getString(2131689622);
      }
      paramAppInterface = ContactUtilsProxy.a((BaseQQAppInterface)paramAppInterface, paramString2, true);
      if ((paramAppInterface != null) && (paramAppInterface.trim().length() > 0) && (!paramAppInterface.equals(paramString2)))
      {
        paramString2 = new StringBuilder();
        paramString2.append(paramAppInterface);
        paramString2.append(paramString1);
        return paramString2.toString();
      }
      paramAppInterface = new StringBuilder();
      paramAppInterface.append(paramString2);
      paramAppInterface.append(paramString1);
      paramString1 = paramAppInterface.toString();
    }
    return paramString1;
  }
  
  public static ArrayList<String> a(AppInterface paramAppInterface, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramAppInterface != null) && (paramAppInterface.isRunning()) && (!TextUtils.isEmpty(paramAppInterface.getCurrentUin())))
    {
      if (TextUtils.isEmpty(paramString)) {
        return localArrayList;
      }
      paramAppInterface = (ISubAccountControlService)paramAppInterface.getRuntimeService(ISubAccountControlService.class, "");
      if (paramAppInterface != null) {
        paramAppInterface.getSubAccountSpecialCareList(localArrayList, paramString);
      }
      if (QLog.isColorLevel())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("getSubAccountSpecialCareList  list=");
        paramAppInterface.append(localArrayList);
        QLog.d("SUB_ACCOUNT", 2, paramAppInterface.toString());
      }
    }
    return localArrayList;
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    if (paramAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "initAllData() return, app == null");
      }
      return;
    }
    Object localObject2 = (ISubAccountService)paramAppInterface.getRuntimeService(ISubAccountService.class, "");
    if (localObject2 == null) {
      return;
    }
    long l1 = ((IDBUtils)QRoute.api(IDBUtils.class)).getSubAccountVersion(paramAppInterface.getApp());
    long l2 = ApkUtils.a(paramAppInterface.getApp());
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("initAllData()..start, historyVersion=");
      ((StringBuilder)localObject1).append(l1);
      ((StringBuilder)localObject1).append(" thisApkVersion=");
      ((StringBuilder)localObject1).append(l2);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
    }
    boolean bool;
    if (l1 < l2)
    {
      if (l1 == 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "initAllData() need to update (v5.0 or lower) data");
        }
        bool = ((IDBUtils)QRoute.api(IDBUtils.class)).subAccountOldVersionUpdate(paramAppInterface.getApp(), paramAppInterface.getAccount());
        localObject1 = ((ISubAccountService)localObject2).getSubAccountInfo("sub.uin.default");
        if ((localObject1 != null) && (((SubAccountInfo)localObject1).subuin != null))
        {
          ((ISubAccountService)localObject2).updateMsgData2SupportSubUin(((SubAccountInfo)localObject1).subuin);
          i = ((ISubAccountService)localObject2).getUnreadAllMsgNum(((SubAccountInfo)localObject1).subuin);
          localObject3 = (IConversationFacade)paramAppInterface.getRuntimeService(IConversationFacade.class, "");
          i -= ((IConversationFacade)localObject3).getUnreadCount(((SubAccountInfo)localObject1).subuin, 7000);
          if (i != 0)
          {
            ((IConversationFacade)localObject3).increaseUnread(((SubAccountInfo)localObject1).subuin, 7000, i);
            ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).setChangeAndNotify(new String[] { AppConstants.SUBACCOUNT_ASSISTANT_UIN, ((SubAccountInfo)localObject1).subuin });
          }
          if (bool)
          {
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("initAllData(), setTopInRecentList, isTop=");
              ((StringBuilder)localObject3).append(bool);
              QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject3).toString());
            }
            a(paramAppInterface, ((SubAccountInfo)localObject1).subuin, true);
          }
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("SUB_ACCOUNT", 2, "initAllData() (v5.1 or later) update..");
      }
      ((IDBUtils)QRoute.api(IDBUtils.class)).setSubAccountVersion(paramAppInterface.getApp());
    }
    if (!((IDBUtils)QRoute.api(IDBUtils.class)).showSubAccountInRecentList(paramAppInterface.getApp(), paramAppInterface.getAccount()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "initAllData() showedBefore:false, isFirstTime to user SubAccount.");
      }
      ((IDBUtils)QRoute.api(IDBUtils.class)).setShowSubAccountInRecentList(paramAppInterface.getApp(), paramAppInterface.getAccount(), true);
      a(paramAppInterface, 7);
    }
    Object localObject1 = ((IRecentUserProxyService)paramAppInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    Object localObject3 = ((RecentUserProxy)localObject1).b(AppConstants.SUBACCOUNT_ASSISTANT_UIN, 7000);
    if (((ISubAccountService)localObject2).getBindedNumber() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "initAllData() getBindedNumber > 0, go to initAllData");
      }
      localObject4 = ((ISubAccountService)localObject2).getAllSubAccountInfo();
      int k = ((ArrayList)localObject4).size();
      i = 0;
      while (i < k)
      {
        SubAccountInfo localSubAccountInfo = (SubAccountInfo)((ArrayList)localObject4).get(i);
        if (localSubAccountInfo != null)
        {
          if ((localObject3 != null) && (QLog.isColorLevel()))
          {
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("initAllData() onGetKeyBack() delete defaultRU:");
            ((StringBuilder)localObject5).append(((RecentUser)localObject3).uin);
            ((StringBuilder)localObject5).append(" type=");
            ((StringBuilder)localObject5).append(((RecentUser)localObject3).getType());
            QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject5).toString());
          }
          if ((localObject3 != null) && (l1 == 0L))
          {
            a(paramAppInterface, localSubAccountInfo.subuin, 7);
            if (QLog.isColorLevel())
            {
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("initAllData() onGetKeyBack() add RU:");
              ((StringBuilder)localObject5).append(localSubAccountInfo.subuin);
              QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject5).toString());
            }
            localObject5 = (IConversationFacade)paramAppInterface.getRuntimeService(IConversationFacade.class, "");
            int m = ((IConversationFacade)localObject5).getUnreadCount(localSubAccountInfo.subuin, 7000);
            if (localObject2 != null) {
              j = ((ISubAccountService)localObject2).getUnreadAllMsgNum(localSubAccountInfo.subuin);
            } else {
              j = 0;
            }
            int n = j - m;
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("initAllData() onGetKeyBack() setReaded subaccount,old:");
              localStringBuilder.append(m);
              localStringBuilder.append(" target:");
              localStringBuilder.append(j);
              localStringBuilder.append(" increase:");
              localStringBuilder.append(n);
              QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
            }
            if (n != 0)
            {
              ((IConversationFacade)localObject5).increaseUnread(localSubAccountInfo.subuin, 7000, n);
              ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).setChangeAndNotify(new String[] { AppConstants.SUBACCOUNT_ASSISTANT_UIN, localSubAccountInfo.subuin });
            }
          }
          Object localObject5 = a(paramAppInterface, localSubAccountInfo.subuin);
          if (localObject5 != null) {
            bool = ((Boolean)((Pair)localObject5).second).booleanValue();
          } else {
            bool = false;
          }
          if (bool) {
            paramAppInterface.getSubAccountKey(paramAppInterface.getAccount(), localSubAccountInfo.subuin, new SubAccountControllUtil.1(paramAppInterface));
          }
        }
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "initAllData() delete subaccount recentuser, add default subaccount box");
    }
    localObject2 = ((ISubAccountService)localObject2).getAllSubAccountInfo();
    int j = ((ArrayList)localObject2).size();
    int i = 0;
    while (i < j)
    {
      localObject3 = (SubAccountInfo)((ArrayList)localObject2).get(i);
      if ((localObject3 != null) && (!AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(((SubAccountInfo)localObject3).subuin)))
      {
        localObject3 = ((RecentUserProxy)localObject1).b(((SubAccountInfo)localObject3).subuin, 7000);
        if (localObject3 != null) {
          ((RecentUserProxy)localObject1).a((RecentUser)localObject3);
        }
      }
      i += 1;
    }
    localObject2 = ((RecentUserProxy)localObject1).b(AppConstants.SUBACCOUNT_ASSISTANT_UIN, 7000);
    localObject3 = paramAppInterface.getApp().getSharedPreferences("qq_subaccount_associated_cache", 0);
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(paramAppInterface.getAccount());
    ((StringBuilder)localObject4).append("_initDataTimes");
    localObject4 = ((StringBuilder)localObject4).toString();
    i = ((SharedPreferences)localObject3).getInt((String)localObject4, 0);
    if (((localObject2 == null) && (i == 0)) || ((localObject2 != null) && (i < 3)))
    {
      a(paramAppInterface, (RecentUserProxy)localObject1, AppConstants.SUBACCOUNT_ASSISTANT_UIN, 7);
      ((SharedPreferences)localObject3).edit().putInt((String)localObject4, i + 1).commit();
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "initAllData() end");
    }
    ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).refreshConversation();
  }
  
  public static void a(AppInterface paramAppInterface, byte paramByte, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setBindUinStatus() subUin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" cmd=");
      ((StringBuilder)localObject).append(paramByte);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
    }
    if (paramString == null) {
      return;
    }
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(paramString);
    a(paramAppInterface, paramByte, (ArrayList)localObject);
  }
  
  public static void a(AppInterface paramAppInterface, byte paramByte, ArrayList<String> paramArrayList)
  {
    Object localObject1 = "null";
    Object localObject2;
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      if ((paramByte != 0) && (paramByte != 1))
      {
        if (QLog.isColorLevel())
        {
          paramAppInterface = new StringBuilder();
          paramAppInterface.append("setBindUinStatus() return, cmd=");
          paramAppInterface.append(paramByte);
          QLog.d("SUB_ACCOUNT", 2, paramAppInterface.toString());
        }
        return;
      }
      localObject1 = new ArrayList();
      localObject2 = paramArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (String)((Iterator)localObject2).next();
        long l1;
        try
        {
          l1 = Long.parseLong((String)localObject3);
        }
        catch (Exception paramArrayList)
        {
          paramArrayList.printStackTrace();
          l1 = 0L;
        }
        if ((l1 != 0L) && (l1 > 10000L))
        {
          long l2 = 21L;
          if (paramByte == 1)
          {
            paramArrayList = paramAppInterface.getApp();
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(((IAutomatorApi)QRoute.api(IAutomatorApi.class)).getPREFERENCE_NAME());
            ((StringBuilder)localObject4).append((String)localObject3);
            l2 = paramArrayList.getSharedPreferences(((StringBuilder)localObject4).toString(), 0).getLong("getProfileStatusNew", 11L);
          }
          paramArrayList = null;
          Object localObject4 = (ISubAccountService)paramAppInterface.getRuntimeService(ISubAccountService.class, "");
          if (localObject4 != null) {
            paramArrayList = ((ISubAccountService)localObject4).getA2((String)localObject3);
          }
          if (paramArrayList == null) {
            paramArrayList = new byte[0];
          } else {
            paramArrayList = HexUtil.hexStr2Bytes(paramArrayList);
          }
          localObject3 = new BindUin();
          ((BindUin)localObject3).lUin = l1;
          ((BindUin)localObject3).iStatus = ((int)l2);
          ((BindUin)localObject3).sKey = paramArrayList;
          ((ArrayList)localObject1).add(localObject3);
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("setBindUinStatus() add<QQService.BindUin>:lUin=");
            ((StringBuilder)localObject3).append(l1);
            ((StringBuilder)localObject3).append(" cmd=");
            ((StringBuilder)localObject3).append(paramByte);
            ((StringBuilder)localObject3).append(" status=");
            ((StringBuilder)localObject3).append(l2);
            ((StringBuilder)localObject3).append(" sKey=");
            if (paramArrayList == null) {
              paramArrayList = "null";
            } else {
              paramArrayList = Integer.valueOf(paramArrayList.length);
            }
            ((StringBuilder)localObject3).append(paramArrayList);
            QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject3).toString());
          }
        }
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).setBindUinStatus(paramAppInterface, paramByte, (ArrayList)localObject1);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "setBindUinStatus() return, ArrayList<QQService.BindUin> list.size=0");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("setBindUinStatus() return, listSubUin:");
      if (paramArrayList == null) {
        paramAppInterface = (AppInterface)localObject1;
      } else {
        paramAppInterface = "size=0";
      }
      ((StringBuilder)localObject2).append(paramAppInterface);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("unbindAllRecentitem() defAct=");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = ((IRecentUserProxyService)paramAppInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    Object localObject2 = ((RecentUserProxy)localObject1).a(false);
    int i = paramInt;
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      for (;;)
      {
        i = paramInt;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        RecentUser localRecentUser = (RecentUser)((Iterator)localObject2).next();
        if ((localRecentUser != null) && (localRecentUser.getType() == 7000) && (!AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(localRecentUser.uin)))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("RecentUserProxy.deleteRecentUserByType, uin=");
            localStringBuilder.append(localRecentUser.uin);
            localStringBuilder.append(" type=");
            localStringBuilder.append(localRecentUser.getType());
            QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
          }
          ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).setReaded(localRecentUser.uin, localRecentUser.getType());
          ((RecentUserProxy)localObject1).a(localRecentUser);
          paramInt = 7;
        }
      }
    }
    a(paramAppInterface, (RecentUserProxy)localObject1, AppConstants.SUBACCOUNT_ASSISTANT_UIN, i);
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, RecentItemSubAccount paramRecentItemSubAccount, MsgSummary paramMsgSummary)
  {
    String str1;
    ISubAccountService localISubAccountService;
    Object localObject3;
    Object localObject1;
    Object localObject5;
    long l1;
    int i;
    int n;
    Object localObject11;
    Object localObject7;
    Object localObject10;
    int j;
    if ((paramAppInterface != null) && (paramAppInterface.isRunning()) && (paramRecentItemSubAccount != null) && (paramContext != null))
    {
      str1 = "";
      localISubAccountService = (ISubAccountService)paramAppInterface.getRuntimeService(ISubAccountService.class, "");
      if (localISubAccountService == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "setRecentItemSubAccountDescription() subMgr == null");
        }
        return;
      }
      localObject3 = localISubAccountService.getAllSubAccountInfo();
      localObject1 = new ArrayList();
      localObject5 = paramAppInterface.getApplication().getAllAccounts();
      if ((localObject5 != null) && (((List)localObject5).size() > 0)) {
        ((List)localObject1).addAll((Collection)localObject5);
      }
      paramRecentItemSubAccount.mMsgExtroInfo = "";
      if ((((List)localObject3).size() == 0) && (((List)localObject1).size() <= 1))
      {
        paramMsgSummary.strContent = paramContext.getString(2131719326);
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "setRecentItemSubAccountDescription() no sub & other account");
        }
        paramRecentItemSubAccount.showSubUin = null;
        return;
      }
      l1 = 0L;
      localObject1 = ((List)localObject3).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject5 = (SubAccountInfo)((Iterator)localObject1).next();
        if (localObject5 != null)
        {
          long l2 = l1;
          if (l1 < ((SubAccountInfo)localObject5).lasttime) {
            l2 = ((SubAccountInfo)localObject5).lasttime;
          }
          l1 = l2;
        }
      }
      a(paramAppInterface);
      localObject1 = (IConversationFacade)paramAppInterface.getRuntimeService(IConversationFacade.class, "");
      i = a(paramAppInterface, (IConversationFacade)localObject1);
      n = b(paramAppInterface, (IConversationFacade)localObject1);
      if (QLog.isColorLevel())
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("subUnreadNum=");
        ((StringBuilder)localObject5).append(i);
        ((StringBuilder)localObject5).append(" subTroopUnreadNum=");
        ((StringBuilder)localObject5).append(n);
        QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject5).toString());
      }
      localObject11 = str1;
      localObject7 = localObject3;
      localObject10 = localObject1;
      j = i;
    }
    for (;;)
    {
      Object localObject9;
      int m;
      Object localObject8;
      int k;
      try
      {
        Iterator localIterator = ((List)localObject3).iterator();
        localObject6 = null;
        localObject9 = null;
        m = 0;
        localObject8 = null;
        k = 0;
        localObject5 = null;
        localObject11 = str1;
        localObject7 = localObject3;
        localObject10 = localObject1;
        j = i;
        if (!localIterator.hasNext()) {
          break label1673;
        }
        localObject11 = str1;
        localObject7 = localObject3;
        localObject10 = localObject1;
        j = i;
        localSubAccountInfo = (SubAccountInfo)localIterator.next();
        if (localSubAccountInfo == null) {
          break label1670;
        }
        localObject11 = str1;
        localObject7 = localObject3;
        localObject10 = localObject1;
        j = i;
        if (TextUtils.isEmpty(localSubAccountInfo.subuin)) {
          break label1670;
        }
        localObject11 = str1;
        localObject7 = localObject3;
        localObject10 = localObject1;
        j = i;
        if (localISubAccountService.getStatus(localSubAccountInfo.subuin) != 1) {
          break label1670;
        }
        localObject11 = str1;
        localObject7 = localObject3;
        localObject10 = localObject1;
        j = i;
        localObject13 = localISubAccountService.getAllMessage(localSubAccountInfo.subuin);
        if (localObject13 == null) {
          break label1655;
        }
        localObject11 = str1;
        localObject7 = localObject3;
        localObject10 = localObject1;
        j = i;
        if (((List)localObject13).size() <= 0) {
          break label1655;
        }
        localObject11 = str1;
        localObject7 = localObject3;
        localObject10 = localObject1;
        j = i;
        localObject12 = (SubAccountMessage)((List)localObject13).get(0);
        localObject11 = str1;
        localObject7 = localObject3;
        localObject10 = localObject1;
        j = i;
        String str2 = AppConstants.SUBACCOUNT_TROOP_UIN;
        localObject10 = str1;
        boolean bool;
        localObject11 = localObject7;
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          try
          {
            if (str2.equals(((SubAccountMessage)localObject12).senderuin))
            {
              if (((List)localObject13).size() > 1)
              {
                localObject7 = (SubAccountMessage)((List)localObject13).get(1);
                localObject11 = localObject12;
              }
              else
              {
                localObject7 = null;
                localObject11 = localObject12;
              }
            }
            else
            {
              localObject7 = localObject12;
              localObject11 = null;
            }
            if (localObject6 == null) {
              continue;
            }
            if (localObject11 == null) {
              continue;
            }
            localObject12 = localObject3;
          }
          catch (Throwable localThrowable6)
          {
            SubAccountInfo localSubAccountInfo;
            Object localObject13;
            localObject7 = localObject3;
            localObject3 = localObject10;
            continue;
          }
          try
          {
            l1 = ((SubAccountMessage)localObject6).time;
            localObject13 = localObject5;
            try
            {
              if (l1 < ((SubAccountMessage)localObject11).time) {
                continue;
              }
              if (localObject9 == null) {
                continue;
              }
              localObject10 = localObject6;
              localObject11 = localObject9;
              localObject12 = localObject8;
              localObject5 = localObject13;
              if (localObject7 != null)
              {
                localObject10 = localObject6;
                localObject11 = localObject9;
                localObject12 = localObject8;
                localObject5 = localObject13;
                if (((SubAccountMessage)localObject9).time < ((SubAccountMessage)localObject7).time) {
                  continue;
                }
              }
              localObject6 = a(paramAppInterface, localSubAccountInfo.subuin);
              if (((ISubAccountControlService.SubAccountUnReadItem)localObject6).jdField_a_of_type_Boolean)
              {
                k += ((ISubAccountControlService.SubAccountUnReadItem)localObject6).jdField_a_of_type_Int;
                localObject6 = localObject10;
                localObject9 = localObject11;
                localObject8 = localObject12;
              }
              else
              {
                m += ((ISubAccountControlService.SubAccountUnReadItem)localObject6).jdField_a_of_type_Int;
                localObject6 = localObject10;
                localObject9 = localObject11;
                localObject8 = localObject12;
              }
            }
            catch (Throwable localThrowable2)
            {
              localObject10 = localThrowable2;
              localThrowable3 = localThrowable2;
              localObject11 = localObject3;
              localObject7 = str1;
              continue;
            }
            if ((localObject5 != null) && (localObject6 != null))
            {
              paramMsgSummary.strContent = paramContext.getString(2131719288);
              try
              {
                paramRecentItemSubAccount.mUnreadNum = 0;
                paramRecentItemSubAccount.mUnreadFlag = 0;
                paramRecentItemSubAccount.showSubUin = null;
                localObject12 = new SpannableStringBuilder();
                if (!QLog.isColorLevel()) {
                  break label1740;
                }
                localObject8 = new StringBuilder();
                ((StringBuilder)localObject8).append("setRecentItemSubAccountDescription() subUin=");
                ((StringBuilder)localObject8).append(((SubAccountInfo)localObject5).subuin);
                ((StringBuilder)localObject8).append(" mMsgExtroInfo=");
                ((StringBuilder)localObject8).append(paramRecentItemSubAccount.mMsgExtroInfo);
                QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject8).toString());
              }
              catch (Throwable localThrowable2)
              {
                i = j;
                continue;
              }
              if ((k > 0) && (!((ISubAccountConfigApi)QRoute.api(ISubAccountConfigApi.class)).getIsHideSubAccountTroopMsg()))
              {
                paramMsgSummary.strContent = "有新的群消息";
                paramRecentItemSubAccount.showSubUin = ((SubAccountInfo)localObject5).subuin;
                paramRecentItemSubAccount.mUnreadNum = n;
                paramRecentItemSubAccount.mUnreadFlag = 2;
                return;
                localObject9 = ((SubAccountMessage)localObject6).frienduin;
                localObject8 = ((SubAccountMessage)localObject6).sendername;
                bool = TextUtils.isEmpty((CharSequence)localObject8);
                if (bool) {
                  break label1758;
                }
                ((SpannableStringBuilder)localObject12).append((CharSequence)localObject8);
                ((SpannableStringBuilder)localObject12).append(": ");
                continue;
                ((SpannableStringBuilder)localObject12).append((CharSequence)localObject8);
                ((SpannableStringBuilder)localObject12).append(": ");
                if (((((SubAccountMessage)localObject6).mEmoRecentMsg == null) || (((SubAccountMessage)localObject6).mEmoRecentMsg.length() == 0)) && (((SubAccountMessage)localObject6).msg != null)) {
                  ((SubAccountMessage)localObject6).mEmoRecentMsg = new QQText(((SubAccountMessage)localObject6).msg, 3, 16);
                }
                ((SpannableStringBuilder)localObject12).append(((SubAccountMessage)localObject6).mEmoRecentMsg);
                if (!((SubAccountMessage)localObject6).isread)
                {
                  if (a(paramAppInterface, ((SubAccountInfo)localObject5).subuin).contains(((SubAccountMessage)localObject6).senderuin))
                  {
                    localObject6 = new StringBuilder();
                    ((StringBuilder)localObject6).append("[");
                    ((StringBuilder)localObject6).append(paramContext.getString(2131716891));
                    ((StringBuilder)localObject6).append("]");
                    paramRecentItemSubAccount.mMsgExtroInfo = ((StringBuilder)localObject6).toString();
                    paramMsgSummary.strContent = ((CharSequence)localObject12);
                  }
                  else if ("RED_PACKET".equals(((SubAccountMessage)localObject6).subExtr))
                  {
                    paramRecentItemSubAccount.mMsgExtroInfo = ((CharSequence)localObject12);
                  }
                  else
                  {
                    paramMsgSummary.strContent = ((CharSequence)localObject12);
                  }
                }
                else {
                  paramMsgSummary.strContent = ((CharSequence)localObject12);
                }
                paramRecentItemSubAccount.showSubUin = ((SubAccountInfo)localObject5).subuin;
                i = j;
              }
              try
              {
                paramRecentItemSubAccount.mUnreadNum = i;
                paramRecentItemSubAccount.mUnreadFlag = 1;
                return;
              }
              catch (Throwable localThrowable1) {}
            }
            i = j;
          }
          catch (Throwable localThrowable5)
          {
            localObject11 = localObject12;
            localObject7 = localObject10;
          }
        }
        localThrowable4 = localThrowable4;
        localObject3 = localObject11;
        i = j;
        localObject2 = localObject10;
      }
      localObject7 = localObject3;
      localObject10 = localObject2;
      Object localObject2 = localThrowable4;
      QLog.e("SUB_ACCOUNT", 1, (Throwable)localObject2, new Object[0]);
      if ((i > 0) && (localObject10 != null))
      {
        localObject2 = ((List)localObject11).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (SubAccountInfo)((Iterator)localObject2).next();
          if ((localObject3 != null) && (!TextUtils.isEmpty(((SubAccountInfo)localObject3).subuin)))
          {
            i = ((IConversationFacade)localObject10).getUnreadCount(((SubAccountInfo)localObject3).subuin, 7000);
            Object localObject4;
            if (i > 0)
            {
              localObject4 = (IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, (String)localObject7);
              if (localObject4 != null) {
                ((IMessageFacade)localObject4).setReaded(((SubAccountInfo)localObject3).subuin, 7000, true, false);
              }
            }
            if (QLog.isColorLevel())
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("setRecentItemSubAccountContentAndUnread some error clean unread subuin= ");
              ((StringBuilder)localObject4).append(((SubAccountInfo)localObject3).subuin);
              ((StringBuilder)localObject4).append("  num=");
              ((StringBuilder)localObject4).append(i);
              QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject4).toString());
            }
          }
        }
      }
      paramRecentItemSubAccount.showSubUin = null;
      paramRecentItemSubAccount.mUnreadNum = 0;
      paramRecentItemSubAccount.mUnreadFlag = 0;
      paramMsgSummary.strContent = paramContext.getString(2131719288);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "setRecentItemSubAccountDescription() params error");
      }
      return;
      localObject13 = localObject5;
      continue;
      Object localObject6 = localObject11;
      localObject13 = localSubAccountInfo;
      continue;
      Object localObject12 = localSubAccountInfo;
      localObject10 = localObject6;
      localObject11 = localObject7;
      localObject5 = localObject13;
      continue;
      label1655:
      localObject10 = localObject6;
      localObject11 = localObject9;
      localObject12 = localObject8;
      continue;
      label1670:
      continue;
      label1673:
      localObject7 = localThrowable6;
      localObject11 = localObject3;
      localObject10 = localObject2;
      j = i;
      if (m <= 0)
      {
        if ((m == 0) && (k > 0)) {
          continue;
        }
        if ((m != 0) || (k != 0)) {}
      }
      else
      {
        localObject6 = localObject9;
        localObject5 = localObject8;
        continue;
      }
      localObject5 = null;
      localObject6 = null;
      continue;
      label1740:
      if (m <= 0) {
        if ((m == 0) && (k == 0))
        {
          continue;
          label1758:
          localObject8 = localObject9;
          if (localObject9 == null) {
            localObject8 = localObject7;
          }
        }
      }
    }
  }
  
  private static void a(AppInterface paramAppInterface, RecentUserProxy paramRecentUserProxy, String paramString, int paramInt)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateRecentUser() subUin=");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" actionType=");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramString != null) && (paramString.length() != 0) && (paramInt != 0))
    {
      if (paramRecentUserProxy == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "updateRecentUser() return, ruProxy==null");
        }
        return;
      }
      if (!AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(paramString))
      {
        localObject1 = paramRecentUserProxy.b(paramString, 7000);
        if (localObject1 != null) {
          paramRecentUserProxy.a((RecentUser)localObject1);
        }
      }
      Object localObject2 = paramRecentUserProxy.b(AppConstants.SUBACCOUNT_ASSISTANT_UIN, 7000);
      localObject1 = localObject2;
      if (localObject2 == null) {
        if (paramInt != 5)
        {
          if (paramInt == 0) {
            return;
          }
          localObject1 = new RecentUser();
          ((RecentUser)localObject1).setType(7000);
        }
        else
        {
          return;
        }
      }
      ((RecentUser)localObject1).uin = AppConstants.SUBACCOUNT_ASSISTANT_UIN;
      boolean bool = AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(paramString);
      int j = 0;
      int i = 1;
      long l1;
      long l2;
      if (bool)
      {
        paramAppInterface = (ISubAccountService)paramAppInterface.getRuntimeService(ISubAccountService.class, "");
        paramString = paramAppInterface.getAllSubUin().iterator();
        l1 = 0L;
        while (paramString.hasNext())
        {
          l2 = paramAppInterface.getActionTime((String)paramString.next());
          if (l1 < l2) {
            l1 = l2;
          }
        }
        l2 = l1;
        if (l1 <= 0L) {
          l2 = MessageCache.a();
        }
        if ((paramInt != 1) && (paramInt != 2))
        {
          if (paramInt == 4) {
            break label345;
          }
          if (paramInt == 5) {
            break label336;
          }
          if ((paramInt != 6) && (paramInt != 7))
          {
            paramInt = j;
            break label390;
          }
        }
        break label369;
        label336:
        ((RecentUser)localObject1).showUpTime = 0L;
        break label364;
        label345:
        ((RecentUser)localObject1).lastmsgtime = l2;
        ((RecentUser)localObject1).showUpTime = (System.currentTimeMillis() / 1000L);
        for (;;)
        {
          label364:
          paramInt = 1;
          break;
          label369:
          if (paramInt == 7) {
            l2 = MessageCache.a();
          }
          ((RecentUser)localObject1).lastmsgtime = l2;
        }
      }
      else
      {
        label390:
        paramAppInterface = (ISubAccountService)paramAppInterface.getRuntimeService(ISubAccountService.class, "");
        l2 = paramAppInterface.getActionTime(paramString);
        l1 = l2;
        if (l2 <= 0L) {
          l1 = MessageCache.a();
        }
        if ((paramInt != 1) && (paramInt != 2)) {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              if ((paramInt != 6) && (paramInt != 7))
              {
                paramInt = 0;
                break label613;
              }
            }
            else
            {
              if (((RecentUser)localObject1).lastmsgtime < l1) {
                ((RecentUser)localObject1).lastmsgtime = l1;
              }
              ((RecentUser)localObject1).showUpTime = 0L;
              paramInt = i;
              break label613;
            }
          }
          else
          {
            ((RecentUser)localObject1).showUpTime = (System.currentTimeMillis() / 1000L);
            paramInt = i;
            break label613;
          }
        }
        l2 = MessageCache.a();
        localObject2 = (ArrayList)paramAppInterface.getMapSubMsg().get(paramString);
        l1 = l2;
        if (paramInt == 6)
        {
          l1 = l2;
          if (localObject2 != null)
          {
            l1 = l2;
            if (((ArrayList)localObject2).size() != 0) {
              l1 = ((SubAccountMessage)((ArrayList)localObject2).get(0)).time;
            }
          }
        }
        paramAppInterface.setActionTime(paramString, l1);
        paramInt = i;
        if (((RecentUser)localObject1).lastmsgtime < l1)
        {
          ((RecentUser)localObject1).lastmsgtime = l1;
          paramInt = i;
        }
      }
      label613:
      if (paramInt != 0) {
        paramRecentUserProxy.b((RecentUser)localObject1);
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramRecentUserProxy = new StringBuilder();
      paramRecentUserProxy.append("updateRecentUser() return,");
      if (paramString == null)
      {
        paramAppInterface = "subUin==null";
      }
      else
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("subUin.len=0 action=");
        paramAppInterface.append(paramInt);
        paramAppInterface = paramAppInterface.toString();
      }
      paramRecentUserProxy.append(paramAppInterface);
      QLog.d("SUB_ACCOUNT", 2, paramRecentUserProxy.toString());
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clearAllData() subUin=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
    }
    if ("sub.uin.all".equals(paramString))
    {
      paramString = null;
      localObject = (ISubAccountService)paramAppInterface.getRuntimeService(ISubAccountService.class, "");
      if (localObject != null) {
        paramString = ((ISubAccountService)localObject).getAllSubUin();
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("clearAllData() clear all_sub_uin. list=");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
      }
      if (paramString != null)
      {
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          localObject = (String)paramString.next();
          if (!"sub.uin.all".equals(localObject)) {
            a(paramAppInterface, (String)localObject);
          }
        }
      }
      return;
    }
    if (paramAppInterface != null)
    {
      localObject = (ISubAccountService)paramAppInterface.getRuntimeService(ISubAccountService.class, "");
      if (localObject != null)
      {
        ((ISubAccountService)localObject).removeSubAccountInfo(paramString);
        ((ISubAccountService)localObject).removeAllMessage(paramString);
        ((IContactUtils)QRoute.api(IContactUtils.class)).getBuddyNickName(paramAppInterface, paramString, false);
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bindRecentItem() subUin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" actionType=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
    }
    if ((!AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(paramString)) && ((paramString == null) || (paramString.length() < 5)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() return, subUin==null || subUin.length()<5");
      }
      return;
    }
    Object localObject = ((IRecentUserProxyService)paramAppInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    if ((((RecentUserProxy)localObject).b(AppConstants.SUBACCOUNT_ASSISTANT_UIN, 7000) != null) && (QLog.isColorLevel())) {
      QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() bind, delete defaultRU");
    }
    a(paramAppInterface, (RecentUserProxy)localObject, paramString, paramInt);
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("bindRecentItem() bind, add RU:");
      paramAppInterface.append(paramString);
      QLog.d("SUB_ACCOUNT", 2, paramAppInterface.toString());
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramAppInterface != null) && (paramString != null))
    {
      if (AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(paramString))
      {
        if (paramBoolean) {
          a(paramAppInterface, ((IRecentUserProxyService)paramAppInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache(), AppConstants.SUBACCOUNT_ASSISTANT_UIN, 7);
        }
      }
      else
      {
        ((ISubAccountService)paramAppInterface.getRuntimeService(ISubAccountService.class, "")).setRecentListTop(paramString, paramBoolean);
        RecentUserProxy localRecentUserProxy = ((IRecentUserProxyService)paramAppInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
        if (paramBoolean) {
          a(paramAppInterface, localRecentUserProxy, paramString, 4);
        } else {
          a(paramAppInterface, localRecentUserProxy, paramString, 5);
        }
      }
      ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).refreshConversation();
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("setSBTopInRecentList() return, ");
      if (paramAppInterface == null) {
        paramAppInterface = "app==null";
      } else {
        paramAppInterface = "subUin==null";
      }
      paramString.append(paramAppInterface);
      QLog.d("SUB_ACCOUNT", 2, paramString.toString());
    }
  }
  
  public static void a(AppInterface paramAppInterface, ArrayList<String> paramArrayList, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bindRecentItem() list=");
      ((StringBuilder)localObject).append(String.valueOf(paramArrayList));
      ((StringBuilder)localObject).append(" actionType=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      localObject = ((IRecentUserProxyService)paramAppInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
      if ((((RecentUserProxy)localObject).b(AppConstants.SUBACCOUNT_ASSISTANT_UIN, 7000) != null) && (QLog.isColorLevel())) {
        QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() bind, delete defaultRU");
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        a(paramAppInterface, (RecentUserProxy)localObject, str, paramInt);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("bindRecentItem() bind, add RU:");
          localStringBuilder.append(str);
          QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
        }
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bindRecentItem() return, list=");
      if (paramArrayList == null) {
        paramAppInterface = "null";
      } else {
        paramAppInterface = Integer.valueOf(paramArrayList.size());
      }
      ((StringBuilder)localObject).append(paramAppInterface);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static void a(AppInterface paramAppInterface, boolean paramBoolean)
  {
    if ((paramAppInterface != null) && (paramAppInterface.isRunning()))
    {
      if (TextUtils.isEmpty(paramAppInterface.getCurrentUin())) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setDisplayThirdQQChecked checked=");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = (ISubAccountControlService)paramAppInterface.getRuntimeService(ISubAccountControlService.class, "");
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramAppInterface.getCurrentUin());
        localStringBuilder.append("_display_third_qq_checked");
        ((ISubAccountControlService)localObject).putAssociatedQQCache(localStringBuilder.toString(), String.valueOf(paramBoolean));
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, boolean paramBoolean, String paramString)
  {
    if (paramAppInterface != null)
    {
      if (!paramAppInterface.isRunning()) {
        return;
      }
      ISubAccountService localISubAccountService = (ISubAccountService)paramAppInterface.getRuntimeService(ISubAccountService.class, "");
      if (localISubAccountService != null)
      {
        Iterator localIterator = localISubAccountService.getAllSubUin().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!TextUtils.isEmpty(str))
          {
            int i = localISubAccountService.getUnreadAllMsgNum(str);
            localISubAccountService.setAllMessageReaded(str);
            if ((paramBoolean) || (i > 0))
            {
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("cleanAllSubAccountMessageUnread confirmSubAccountMsgNumReaded once subuin=");
                ((StringBuilder)localObject).append(str);
                ((StringBuilder)localObject).append(" needConfirm=");
                ((StringBuilder)localObject).append(paramBoolean);
                QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
              }
              Object localObject = ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).getProcessor(paramAppInterface);
              if (localObject != null) {
                ((AbsSubAccountMessageProcessor)localObject).a(str, paramString);
              }
            }
          }
        }
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramAppInterface != null)
    {
      if (!paramAppInterface.isRunning()) {
        return;
      }
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      Object localObject = (ISubAccountService)paramAppInterface.getRuntimeService(ISubAccountService.class, "");
      if (localObject != null)
      {
        int i = ((ISubAccountService)localObject).getUnreadAllMsgNum(paramString2);
        ((ISubAccountService)localObject).setAllMessageReaded(paramString2);
        if ((paramBoolean) || (i > 0))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("cleanAllSubAccountMessageUnread confirmSubAccountMsgNumReaded once subuin=");
            ((StringBuilder)localObject).append(paramString2);
            ((StringBuilder)localObject).append(" needConfirm=");
            ((StringBuilder)localObject).append(paramBoolean);
            QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
          }
          paramAppInterface = ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).getProcessor(paramAppInterface);
          if (paramAppInterface != null) {
            paramAppInterface.a(paramString2, paramString1);
          }
        }
      }
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, QBaseActivity paramQBaseActivity)
  {
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("showMaxHintDialog() actCaller=");
      if (paramQBaseActivity == null) {
        localObject1 = "null";
      } else {
        localObject1 = paramQBaseActivity.getClass().getSimpleName();
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject2).toString());
    }
    if (paramQBaseActivity == null) {
      return;
    }
    Object localObject1 = paramQBaseActivity.getString(2131719330);
    Object localObject2 = paramQBaseActivity.getString(2131719306, new Object[] { Integer.valueOf(2) });
    localObject1 = DialogUtil.a(paramQBaseActivity, 230).setTitle((String)localObject1).setMessage((CharSequence)localObject2);
    ((QQCustomDialog)localObject1).setOwnerActivity(paramQBaseActivity);
    ((QQCustomDialog)localObject1).setPositiveButton(paramQBaseActivity.getString(2131719318), new SubAccountControllUtil.2(paramAppRuntime, paramQBaseActivity));
    ((QQCustomDialog)localObject1).setCancelable(false);
    ((QQCustomDialog)localObject1).show();
  }
  
  public static boolean a(int paramInt)
  {
    if ((paramInt <= -1006) && (paramInt >= -1010)) {
      return true;
    }
    if (paramInt == -1011) {
      return true;
    }
    return (paramInt >= 187) && (paramInt <= 191);
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    paramAppInterface = (ISubAccountService)paramAppInterface.getRuntimeService(ISubAccountService.class, "");
    if (paramAppInterface != null)
    {
      paramAppInterface = paramAppInterface.getAllSubAccountInfo();
      if (paramAppInterface != null)
      {
        paramAppInterface = paramAppInterface.iterator();
        while (paramAppInterface.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)paramAppInterface.next();
          if ((localSubAccountInfo != null) && (localSubAccountInfo.isTop)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static boolean a(AppInterface paramAppInterface, int paramInt)
  {
    if ((paramAppInterface != null) && (paramAppInterface.isRunning()))
    {
      if (TextUtils.isEmpty(paramAppInterface.getCurrentUin())) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateAllThirdQQMsgUnreadLastTime() lastMsgTime=");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = (ISubAccountControlService)paramAppInterface.getRuntimeService(ISubAccountControlService.class, "");
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramAppInterface.getCurrentUin());
        localStringBuilder.append("_all_third_last_msg_time");
        return ((ISubAccountControlService)localObject).putAssociatedQQCache(localStringBuilder.toString(), Integer.valueOf(paramInt));
      }
    }
    return false;
  }
  
  public static boolean a(AppInterface paramAppInterface, SimpleAccount paramSimpleAccount)
  {
    Integer localInteger = Integer.valueOf(0);
    if ((paramAppInterface != null) && (paramAppInterface.isRunning()) && (!TextUtils.isEmpty(paramAppInterface.getCurrentUin())))
    {
      if (paramSimpleAccount == null) {
        return false;
      }
      ISubAccountControlService localISubAccountControlService = (ISubAccountControlService)paramAppInterface.getRuntimeService(ISubAccountControlService.class, "");
      if (localISubAccountControlService == null) {
        return false;
      }
      paramAppInterface = paramAppInterface.getCurrentUin();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAppInterface);
      localStringBuilder.append("_");
      localStringBuilder.append(paramSimpleAccount.getUin());
      paramAppInterface = localStringBuilder.toString();
      paramSimpleAccount = new StringBuilder();
      paramSimpleAccount.append(paramAppInterface);
      paramSimpleAccount.append("_last_cookie");
      paramSimpleAccount = localISubAccountControlService.getAssociatedQQCacheString(paramSimpleAccount.toString());
      if (!TextUtils.isEmpty(paramSimpleAccount))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramAppInterface);
        localStringBuilder.append("_cookie");
        localISubAccountControlService.putAssociatedQQCache(localStringBuilder.toString(), paramSimpleAccount);
      }
      paramSimpleAccount = new StringBuilder();
      paramSimpleAccount.append(paramAppInterface);
      paramSimpleAccount.append("_msgNum");
      localISubAccountControlService.putAssociatedQQCache(paramSimpleAccount.toString(), localInteger);
      paramSimpleAccount = new StringBuilder();
      paramSimpleAccount.append(paramAppInterface);
      paramSimpleAccount.append("_msgFlag");
      localISubAccountControlService.putAssociatedQQCache(paramSimpleAccount.toString(), localInteger);
      paramSimpleAccount = new StringBuilder();
      paramSimpleAccount.append(paramAppInterface);
      paramSimpleAccount.append("_redBagTime");
      localISubAccountControlService.putAssociatedQQCache(paramSimpleAccount.toString(), localInteger);
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "cleanAllThirdQQUnreadMsgNum()");
      }
      return true;
    }
    return false;
  }
  
  public static boolean a(AppInterface paramAppInterface, String paramString)
  {
    boolean bool2 = false;
    if (paramString == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramAppInterface != null)
    {
      paramAppInterface = (ISubAccountControlService)paramAppInterface.getRuntimeService(ISubAccountControlService.class, "");
      bool1 = bool2;
      if (paramAppInterface != null) {
        bool1 = paramAppInterface.handleListWaittingHint(paramString);
      }
    }
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("needShowHintDialog() subUin=");
      paramAppInterface.append(paramString);
      paramAppInterface.append(" bool=");
      paramAppInterface.append(bool1);
      QLog.d("SUB_ACCOUNT", 2, paramAppInterface.toString());
    }
    return bool1;
  }
  
  public static boolean a(AppInterface paramAppInterface, String paramString, boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getSubAccountMessage() subUin=");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" isFromPush=");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramAppInterface != null) && (paramAppInterface.isRunning()))
    {
      localObject1 = null;
      Object localObject2 = (ISubAccountService)paramAppInterface.getRuntimeService(ISubAccountService.class, "");
      if (localObject2 != null) {
        localObject1 = ((ISubAccountService)localObject2).getA2(paramString);
      }
      localObject2 = (ISubAccountProtocService)paramAppInterface.getRuntimeService(ISubAccountProtocService.class, "");
      if (localObject2 != null)
      {
        paramBoolean = ((ISubAccountProtocService)localObject2).getBindAccountFinish();
        if (!paramBoolean)
        {
          localObject1 = new SubAccountBackProtocData();
          ((SubAccountBackProtocData)localObject1).jdField_a_of_type_JavaLangString = "";
          ((SubAccountBackProtocData)localObject1).b = paramAppInterface.getAccount();
          ((SubAccountBackProtocData)localObject1).c = paramString;
          ((SubAccountBackProtocData)localObject1).jdField_a_of_type_Int = 1009;
          ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).notifyUI(8003, false, localObject1);
          if (QLog.isColorLevel())
          {
            paramAppInterface = new StringBuilder();
            paramAppInterface.append("getSubAccountMessage() return, get bind subaccount isFinish = ");
            paramAppInterface.append(paramBoolean);
            QLog.d("SUB_ACCOUNT", 2, paramAppInterface.toString());
          }
          return false;
        }
      }
      if ((paramString != null) && (paramString.length() != 0) && (localObject1 != null) && (((String)localObject1).length() != 0) && (!((String)localObject1).trim().equals("")))
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getSubAccountMessage() lockMsg later really start get subaccount message account = ");
          ((StringBuilder)localObject2).append(paramAppInterface.getAccount());
          ((StringBuilder)localObject2).append("; sAccount = ");
          ((StringBuilder)localObject2).append(paramString);
          QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject2).toString());
        }
        paramAppInterface = ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).getProcessor(paramAppInterface);
        if (paramAppInterface != null) {
          paramAppInterface.a((byte)3, 0, paramString, (String)localObject1, null);
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getSubAccountMessage() return, subUin=");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(" a2=");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject2).toString());
        }
        localObject1 = new SubAccountBackProtocData();
        ((SubAccountBackProtocData)localObject1).jdField_a_of_type_JavaLangString = "";
        ((SubAccountBackProtocData)localObject1).b = paramAppInterface.getAccount();
        ((SubAccountBackProtocData)localObject1).c = paramString;
        ((SubAccountBackProtocData)localObject1).jdField_a_of_type_Int = 1010;
        ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).notifyUI(8003, false, localObject1);
        return false;
      }
    }
    return true;
  }
  
  public static boolean a(AppInterface paramAppInterface, boolean paramBoolean)
  {
    if (paramAppInterface != null)
    {
      if (!paramAppInterface.isRunning()) {
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "startGetThirdQQUnreadNum()");
      }
      paramAppInterface = (ISubAccountControlService)paramAppInterface.getRuntimeService(ISubAccountControlService.class, "");
      if (paramAppInterface != null) {
        return paramAppInterface.startGetThirdQQUnreadNum(paramBoolean);
      }
    }
    return false;
  }
  
  public static byte[] a(AppInterface paramAppInterface, String paramString)
  {
    if ((paramAppInterface != null) && (paramAppInterface.isRunning()) && (!TextUtils.isEmpty(paramString)))
    {
      if (TextUtils.isEmpty(paramAppInterface.getCurrentUin())) {
        return null;
      }
      ISubAccountControlService localISubAccountControlService = (ISubAccountControlService)paramAppInterface.getRuntimeService(ISubAccountControlService.class, "");
      if (localISubAccountControlService != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramAppInterface.getCurrentUin());
        localStringBuilder.append("_");
        localStringBuilder.append(paramString);
        localStringBuilder.append("_cookie");
        paramAppInterface = localISubAccountControlService.getAssociatedQQCacheString(localStringBuilder.toString());
        if (!TextUtils.isEmpty(paramAppInterface)) {
          return PkgTools.hexToBytes(paramAppInterface);
        }
      }
    }
    return null;
  }
  
  public static int b(AppInterface paramAppInterface, IConversationFacade paramIConversationFacade)
  {
    int k = 0;
    int i = 0;
    int j = k;
    if (paramAppInterface != null)
    {
      j = k;
      if (paramAppInterface.isRunning())
      {
        if (paramIConversationFacade == null) {
          return 0;
        }
        ISubAccountService localISubAccountService = (ISubAccountService)paramAppInterface.getRuntimeService(ISubAccountService.class, "");
        if (localISubAccountService != null)
        {
          Iterator localIterator = localISubAccountService.getAllSubAccountInfo().iterator();
          i = 0;
          while (localIterator.hasNext())
          {
            Object localObject = (SubAccountInfo)localIterator.next();
            if ((localObject != null) && (!TextUtils.isEmpty(((SubAccountInfo)localObject).subuin)) && (localISubAccountService.getStatus(((SubAccountInfo)localObject).subuin) == 1)) {
              j = paramIConversationFacade.getUnreadCountFromExtInt2(((SubAccountInfo)localObject).subuin, 7000);
            } else {
              j = 0;
            }
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("getAllSubAccountTroopMsgUnreadNum() subuin=");
              if (localObject == null) {
                localObject = Integer.valueOf(0);
              } else {
                localObject = ((SubAccountInfo)localObject).subuin;
              }
              localStringBuilder.append(localObject);
              localStringBuilder.append(" num=");
              localStringBuilder.append(j);
              QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
            }
            i += j;
          }
        }
        j = i;
        if (QLog.isColorLevel())
        {
          paramIConversationFacade = new StringBuilder();
          paramIConversationFacade.append("getAllSubAccountTroopMsgUnreadNum() currentUin=");
          paramIConversationFacade.append(paramAppInterface.getCurrentUin());
          paramIConversationFacade.append(" allNum=");
          paramIConversationFacade.append(i);
          QLog.d("SUB_ACCOUNT", 2, paramIConversationFacade.toString());
          j = i;
        }
      }
    }
    return j;
  }
  
  public static String b(AppInterface paramAppInterface, String paramString)
  {
    Object localObject = ((IFriendDataService)paramAppInterface.getRuntimeService(IFriendDataService.class, "")).getFriend(paramString, true);
    if ((localObject != null) && (!TextUtils.isEmpty(((Friends)localObject).name))) {
      return ((Friends)localObject).name;
    }
    localObject = ((IProfileDataService)paramAppInterface.getRuntimeService(IProfileDataService.class, "all")).getProfileCardFromCache(paramString);
    paramAppInterface = paramString;
    if (localObject != null)
    {
      paramAppInterface = paramString;
      if (!TextUtils.isEmpty(((Card)localObject).strNick)) {
        paramAppInterface = ((Card)localObject).strNick;
      }
    }
    return paramAppInterface;
  }
  
  public static void b(AppInterface paramAppInterface)
  {
    if ((paramAppInterface != null) && (paramAppInterface.isRunning()))
    {
      if (TextUtils.isEmpty(paramAppInterface.getCurrentUin())) {
        return;
      }
      Object localObject1 = (ISubAccountService)paramAppInterface.getRuntimeService(ISubAccountService.class, "");
      if (localObject1 != null)
      {
        Object localObject2 = new ArrayList();
        ((List)localObject2).addAll(((ISubAccountService)localObject1).getAllSubAccountInfo());
        localObject1 = paramAppInterface.getApp().getSharedPreferences("qq_subaccount_associated_cache", 0);
        if ((localObject1 != null) && (((List)localObject2).size() > 0))
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (SubAccountInfo)((Iterator)localObject2).next();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(((SubAccountInfo)localObject3).subuin);
            localStringBuilder.append("_");
            localStringBuilder.append(paramAppInterface.getCurrentUin());
            localStringBuilder.append("_spcares_sysTime");
            localObject3 = localStringBuilder.toString();
            ((SharedPreferences)localObject1).edit().putInt((String)localObject3, 0).commit();
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("cleanReqSubAccountSpecialCareListSysTime key=");
              localStringBuilder.append((String)localObject3);
              QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
            }
          }
        }
      }
    }
  }
  
  public static void b(AppInterface paramAppInterface, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      ((ISubAccountControlService)paramAppInterface.getRuntimeService(ISubAccountControlService.class, "")).setDateFormate(paramString);
      paramString = (ISubAccountService)paramAppInterface.getRuntimeService(ISubAccountService.class, "");
      if (paramString != null) {
        paramString.updateMsgTimeStr(((ISubAccountControlService)paramAppInterface.getRuntimeService(ISubAccountControlService.class, "")).getDateFormate());
      }
    }
  }
  
  public static void b(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    if ((paramAppInterface != null) && (paramAppInterface.isRunning()) && (!TextUtils.isEmpty(paramString)))
    {
      if (!TextUtils.equals(paramString, paramAppInterface.getCurrentUin())) {
        return;
      }
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("storeThirdQQUnreadMsgNumInterval mainAccount=");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" interval=");
        localStringBuilder.append(paramInt);
        QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
      }
      paramString = (ISubAccountControlService)paramAppInterface.getRuntimeService(ISubAccountControlService.class, null);
      if (paramString != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramAppInterface.getCurrentUin());
        localStringBuilder.append("_unread_msg_num_interval");
        paramString.putAssociatedQQCache(localStringBuilder.toString(), Integer.valueOf(paramInt));
        paramString.updateThirdQQUnreadDelayTime(paramInt);
      }
    }
  }
  
  public static void b(AppInterface paramAppInterface, boolean paramBoolean, String paramString)
  {
    if (paramAppInterface != null)
    {
      if (!paramAppInterface.isRunning()) {
        return;
      }
      Object localObject1 = (ISubAccountControlService)paramAppInterface.getRuntimeService(ISubAccountControlService.class, "");
      if (localObject1 != null)
      {
        long l1 = System.currentTimeMillis();
        long l2 = (l1 - ((ISubAccountControlService)localObject1).getLastSpecialCareRequestTime()) / 1000L;
        if (l2 < ((ISubAccountControlService)localObject1).getSpecialCareReqAdviseGap())
        {
          if (QLog.isColorLevel())
          {
            paramAppInterface = new StringBuilder();
            paramAppInterface.append("getSubAccountSpecialCareListFromService skip adviseGap=");
            paramAppInterface.append(((ISubAccountControlService)localObject1).getSpecialCareReqAdviseGap());
            paramAppInterface.append("  realGap=");
            paramAppInterface.append(l2);
            QLog.d("SUB_ACCOUNT", 2, paramAppInterface.toString());
          }
          return;
        }
        ((ISubAccountControlService)localObject1).setLastSpecialCareRequestTime(l1);
      }
      localObject1 = (ISubAccountService)paramAppInterface.getRuntimeService(ISubAccountService.class, "");
      if (localObject1 != null)
      {
        Object localObject2 = new ArrayList();
        if (paramBoolean) {
          ((List)localObject2).addAll(((ISubAccountService)localObject1).getAllSubAccountInfo());
        } else {
          ((List)localObject2).add(((ISubAccountService)localObject1).getSubAccountInfo(paramString));
        }
        paramString = ((List)localObject2).iterator();
        while (paramString.hasNext())
        {
          localObject1 = (SubAccountInfo)paramString.next();
          if ((localObject1 != null) && (!TextUtils.isEmpty(((SubAccountInfo)localObject1).subuin)))
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("getSubAccountSpecialCareListFromService uin=");
              ((StringBuilder)localObject2).append(((SubAccountInfo)localObject1).subuin);
              QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject2).toString());
            }
            if (((ISubAccountApi)QRoute.api(ISubAccountApi.class)).getProcessor(paramAppInterface) != null) {
              ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).getProcessor(paramAppInterface).a((SubAccountInfo)localObject1);
            }
          }
        }
      }
    }
  }
  
  public static boolean b(AppInterface paramAppInterface)
  {
    paramAppInterface = (ISubAccountService)paramAppInterface.getRuntimeService(ISubAccountService.class, null);
    boolean bool = false;
    int i;
    if (paramAppInterface != null) {
      i = paramAppInterface.getBindedNumber();
    } else {
      i = 0;
    }
    if (i > 0) {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("checkAccountBind, bindedNum=");
      paramAppInterface.append(i);
      paramAppInterface.append(" ret=");
      paramAppInterface.append(bool);
      QLog.d("SUB_ACCOUNT", 2, paramAppInterface.toString());
    }
    return bool;
  }
  
  public static boolean b(AppInterface paramAppInterface, boolean paramBoolean)
  {
    return true;
  }
  
  public static void c(AppInterface paramAppInterface, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unbindRecentItem subUin=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
    }
    if (paramString != null)
    {
      if (paramString.length() < 4) {
        return;
      }
      ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).setReaded(paramString, 7000);
      localObject = ((IRecentUserProxyService)paramAppInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
      paramString = ((RecentUserProxy)localObject).b(paramString, 7000);
      if (paramString != null)
      {
        ((RecentUserProxy)localObject).a(paramString);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("unbindRecentItem() unbind,delete subUin:");
          localStringBuilder.append(paramString.uin);
          localStringBuilder.append(" type=");
          localStringBuilder.append(paramString.getType());
          QLog.d("SUB_ACCOUNT", 2, localStringBuilder.toString());
        }
      }
      if (((ISubAccountService)paramAppInterface.getRuntimeService(ISubAccountService.class, "")).getBindedNumber() == 0)
      {
        a(paramAppInterface, (RecentUserProxy)localObject, AppConstants.SUBACCOUNT_ASSISTANT_UIN, 7);
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "bindRecentItem() unbind, add default RecentUser");
        }
      }
    }
  }
  
  public static boolean c(AppInterface paramAppInterface)
  {
    Integer localInteger = Integer.valueOf(0);
    if ((paramAppInterface != null) && (paramAppInterface.isRunning()))
    {
      if (TextUtils.isEmpty(paramAppInterface.getCurrentUin())) {
        return false;
      }
      Object localObject1 = (ISubAccountService)paramAppInterface.getRuntimeService(ISubAccountService.class, "");
      ISubAccountControlService localISubAccountControlService = (ISubAccountControlService)paramAppInterface.getRuntimeService(ISubAccountControlService.class, "");
      if (localObject1 != null)
      {
        if (localISubAccountControlService == null) {
          return false;
        }
        localObject1 = ((ISubAccountService)localObject1).getAllSubUin();
        Object localObject2 = new ArrayList();
        Object localObject3 = paramAppInterface.getApplication().getAllAccounts();
        if ((localObject3 != null) && (((List)localObject3).size() > 0)) {
          ((List)localObject2).addAll((Collection)localObject3);
        }
        paramAppInterface = paramAppInterface.getCurrentUin();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (SimpleAccount)((Iterator)localObject2).next();
          if ((localObject3 != null) && (!TextUtils.isEmpty(((SimpleAccount)localObject3).getUin())) && (!((SimpleAccount)localObject3).getUin().equals(paramAppInterface)) && (!((List)localObject1).contains(((SimpleAccount)localObject3).getUin())))
          {
            Object localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(paramAppInterface);
            ((StringBuilder)localObject4).append("_");
            ((StringBuilder)localObject4).append(((SimpleAccount)localObject3).getUin());
            localObject3 = ((StringBuilder)localObject4).toString();
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append((String)localObject3);
            ((StringBuilder)localObject4).append("_last_cookie");
            localObject4 = localISubAccountControlService.getAssociatedQQCacheString(((StringBuilder)localObject4).toString());
            if (!TextUtils.isEmpty((CharSequence)localObject4))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append((String)localObject3);
              localStringBuilder.append("_cookie");
              localISubAccountControlService.putAssociatedQQCache(localStringBuilder.toString(), localObject4);
            }
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append((String)localObject3);
            ((StringBuilder)localObject4).append("_msgNum");
            localISubAccountControlService.putAssociatedQQCache(((StringBuilder)localObject4).toString(), localInteger);
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append((String)localObject3);
            ((StringBuilder)localObject4).append("_msgFlag");
            localISubAccountControlService.putAssociatedQQCache(((StringBuilder)localObject4).toString(), localInteger);
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append((String)localObject3);
            ((StringBuilder)localObject4).append("_redBagTime");
            localISubAccountControlService.putAssociatedQQCache(((StringBuilder)localObject4).toString(), localInteger);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "cleanAllThirdQQUnreadMsgNum()");
        }
        return true;
      }
    }
    return false;
  }
  
  public static boolean c(AppInterface paramAppInterface, boolean paramBoolean)
  {
    if ((paramAppInterface != null) && (paramAppInterface.isRunning()))
    {
      if (TextUtils.isEmpty(paramAppInterface.getCurrentUin())) {
        return false;
      }
      paramAppInterface = (ISubAccountControlService)paramAppInterface.getRuntimeService(ISubAccountControlService.class, "");
      if (paramAppInterface != null) {
        return paramAppInterface.isHeadIconLongClickFunc(paramBoolean);
      }
    }
    return false;
  }
  
  public static boolean d(AppInterface paramAppInterface)
  {
    if ((paramAppInterface != null) && (paramAppInterface.isRunning()))
    {
      if (TextUtils.isEmpty(paramAppInterface.getCurrentUin())) {
        return true;
      }
      ISubAccountControlService localISubAccountControlService = (ISubAccountControlService)paramAppInterface.getRuntimeService(ISubAccountControlService.class, "");
      if (localISubAccountControlService != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramAppInterface.getCurrentUin());
        localStringBuilder.append("_display_third_qq_checked");
        if (TextUtils.equals(localISubAccountControlService.getAssociatedQQCacheString(localStringBuilder.toString()), String.valueOf(false))) {
          return false;
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.SubAccountControllUtil
 * JD-Core Version:    0.7.0.1
 */