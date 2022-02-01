package com.tencent.mobileqq.newfriend.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.newfriend.api.INewFriendVerificationService;
import com.tencent.mobileqq.newfriend.data.AddFriendBlockedInfo;
import com.tencent.mobileqq.newfriend.handler.NewFriendVerificationHandler;
import com.tencent.mobileqq.profilecommon.observer.ProfileCommonObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class NewFriendVerificationServiceImpl
  implements INewFriendVerificationService
{
  private static final String ADD_FRIEND_BLOCKED_CONFIG_SP = "add_friend_blocked_cfg_sp";
  private static final String ADD_FRIEND_BLOCKED_SHOW_ENTRANCE = "add_friend_blocked_show_entrance";
  private static final String ADD_FRIEND_BLOCKED_SHOW_RED_POINT = "add_friend_blocked_show_red_point";
  private static final String ADD_FRIEND_BLOCKED_SHOW_RED_POINT_AT_NEW_FRIEND_BANNER = "add_friend_blocked_show_red_point_at_new_friend_banner";
  public static final int ENTRANCE_TYPE_BLOCKED = 3;
  public static final int ENTRANCE_TYPE_NONE = 0;
  private static final int REQ_NUM = 500;
  public static final String TAG = "NEW_FRD.NewFriendVerificationServiceImpl";
  private static int mUiBuilderExposeCnt;
  public List<AddFriendBlockedInfo> addFriendBlockedInfoList = new ArrayList();
  private ProfileCommonObserver commonObserver = new NewFriendVerificationServiceImpl.1(this);
  private FriendObserver friendObserver = new NewFriendVerificationServiceImpl.2(this);
  public boolean isClearAddFriendBlockedListSuccess;
  public boolean isReportAddFriendBlockedSuccess;
  public boolean isShowAddFriendBlockedEntrance;
  public boolean isShowRedPoint;
  public boolean isShowRedPointAtNewFriendBanner;
  AppInterface mApp;
  
  private boolean checkIsSetAddFriendAnswer()
  {
    return checkIsSetAddFriendAnswer(MobileQQ.sMobileQQ.getSharedPreferences(this.mApp.getCurrentAccountUin(), 0).getInt("e_add_friend_setting", 101));
  }
  
  private boolean checkIsSetAddFriendAnswer(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 4);
  }
  
  public static NewFriendVerificationServiceImpl getService(AppRuntime paramAppRuntime)
  {
    return (NewFriendVerificationServiceImpl)paramAppRuntime.getRuntimeService(INewFriendVerificationService.class, "all");
  }
  
  public static int getUiBuilderExposeCnt()
  {
    return mUiBuilderExposeCnt;
  }
  
  private void initConfigFromSp(AppInterface paramAppInterface, String paramString)
  {
    MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAppInterface.getCurrentUin());
    localStringBuilder.append("add_friend_blocked_cfg_sp");
    paramAppInterface = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 4);
    if ("add_friend_blocked_show_entrance".equals(paramString))
    {
      this.isShowAddFriendBlockedEntrance = paramAppInterface.getBoolean(paramString, false);
      return;
    }
    if ("add_friend_blocked_show_red_point".equals(paramString))
    {
      this.isShowRedPoint = paramAppInterface.getBoolean(paramString, false);
      return;
    }
    if ("add_friend_blocked_show_red_point_at_new_friend_banner".equals(paramString)) {
      this.isShowRedPointAtNewFriendBanner = paramAppInterface.getBoolean(paramString, false);
    }
  }
  
  private void innerReportAddFriend(boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("innerReportAddFriend() isSuccess:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("NEW_FRD.NewFriendVerificationServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    if ((!paramBoolean) && (checkIsSetAddFriendAnswer(paramBundle.getInt("friend_setting"))))
    {
      localObject = paramBundle.getString("uin");
      int i = paramBundle.getInt("source_id");
      int j = paramBundle.getInt("sub_source_id");
      paramBundle = paramBundle.getString("troop_uin");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("innerReportAddFriend  friendUin = ");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" troopUin = ");
        localStringBuilder.append(paramBundle);
        QLog.d("NEW_FRD.NewFriendVerificationServiceImpl", 2, localStringBuilder.toString());
      }
      getHandler().a(this.mApp.getCurrentUin(), (String)localObject, i, j, paramBundle);
    }
  }
  
  private boolean saveConfigToSp(String paramString, Object paramObject)
  {
    Object localObject = MobileQQ.sMobileQQ;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mApp.getCurrentUin());
    localStringBuilder.append("add_friend_blocked_cfg_sp");
    localObject = ((MobileQQ)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit();
    if (("add_friend_blocked_show_entrance".equals(paramString)) || ("add_friend_blocked_show_red_point".equals(paramString)) || ("add_friend_blocked_show_red_point_at_new_friend_banner".equals(paramString))) {
      ((SharedPreferences.Editor)localObject).putBoolean(paramString, ((Boolean)paramObject).booleanValue());
    }
    return ((SharedPreferences.Editor)localObject).commit();
  }
  
  public static void setUiBuilderExposeCnt(int paramInt)
  {
    mUiBuilderExposeCnt = paramInt;
  }
  
  public void clearAddFriendBlockedList(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" start-> clearAddFriendBlockedList() uin = ");
      localStringBuilder.append(paramString);
      QLog.d("NEW_FRD.NewFriendVerificationServiceImpl", 2, localStringBuilder.toString());
    }
    getHandler().a(paramString);
  }
  
  public void clearRedPointAtNewFriendBanner()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NEW_FRD.NewFriendVerificationServiceImpl", 2, "clearRedPointAtNewFriendBanner()");
    }
    setShowRedPointAtNewFriendBanner(false);
  }
  
  public void getAddFriendBlockedList(String paramString)
  {
    if (checkIsSetAddFriendAnswer())
    {
      if (QLog.isColorLevel()) {
        QLog.d("NEW_FRD.NewFriendVerificationServiceImpl", 2, "start -> getAddFriendBlockedList()");
      }
      if (this.addFriendBlockedInfoList == null) {
        this.addFriendBlockedInfoList = new ArrayList();
      }
      getHandler().a(paramString, 500, "");
    }
  }
  
  public void getAddFriendBlockedRedPoint(String paramString)
  {
    if (checkIsSetAddFriendAnswer())
    {
      if (QLog.isColorLevel()) {
        QLog.d("NEW_FRD.NewFriendVerificationServiceImpl", 2, "start -> getAddFriendBlockedRedPoint() ");
      }
      getHandler().b(paramString);
      return;
    }
    onGetAddFriendBlockedRedPoint(true, false, false, "", false);
  }
  
  public int getEntranceType()
  {
    int i;
    if (this.isShowAddFriendBlockedEntrance) {
      i = 3;
    } else {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getEntranceType, type=");
      localStringBuilder.append(i);
      localStringBuilder.append(", entrance=");
      localStringBuilder.append(this.isShowAddFriendBlockedEntrance);
      QLog.d("NEW_FRD.NewFriendVerificationServiceImpl", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  public NewFriendVerificationHandler getHandler()
  {
    return (NewFriendVerificationHandler)this.mApp.getBusinessHandler(NewFriendVerificationHandler.class.getName());
  }
  
  public boolean isShowRedPoint()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isShowRedPoint, isShowRedPoint:");
      localStringBuilder.append(this.isShowRedPoint);
      QLog.d("NEW_FRD.NewFriendVerificationServiceImpl", 2, localStringBuilder.toString());
    }
    return this.isShowRedPoint;
  }
  
  public boolean isShowRedPointAtNewFriendBanner()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isShowRedPointAtNewFriendBanner, isShowRedPointAtNewFriendBanner:");
      localStringBuilder.append(this.isShowRedPointAtNewFriendBanner);
      QLog.d("NEW_FRD.NewFriendVerificationServiceImpl", 2, localStringBuilder.toString());
    }
    return this.isShowRedPointAtNewFriendBanner;
  }
  
  public void leaveNewFriend()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NEW_FRD.NewFriendVerificationServiceImpl", 2, "leaveNewFriend()");
    }
    setShowRedPoint(false);
    if (getUiBuilderExposeCnt() > 0) {
      ReportController.b(null, "dc00898", "", "", "0X800A3A3", "0X800A3A3", 0, getUiBuilderExposeCnt(), 0, "", "", "", "");
    }
    setUiBuilderExposeCnt(0);
  }
  
  public void onClearAddFriendBlockedList(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" onClearAddFriendBlockedList()-->  success=  ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("NEW_FRD.NewFriendVerificationServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.addFriendBlockedInfoList;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    this.isClearAddFriendBlockedListSuccess = paramBoolean;
    getHandler().notifyUI(1, paramBoolean, null);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = ((AppInterface)paramAppRuntime);
    initConfigFromSp(this.mApp, "add_friend_blocked_show_entrance");
    initConfigFromSp(this.mApp, "add_friend_blocked_show_red_point");
    initConfigFromSp(this.mApp, "add_friend_blocked_show_red_point_at_new_friend_banner");
    this.mApp.addObserver(this.commonObserver);
    this.mApp.addObserver(this.friendObserver);
  }
  
  public void onDestroy()
  {
    Object localObject = this.addFriendBlockedInfoList;
    if (localObject != null) {
      ((List)localObject).clear();
    }
    localObject = this.mApp;
    if (localObject != null)
    {
      ((AppInterface)localObject).removeObserver(this.commonObserver);
      this.commonObserver = null;
      this.mApp.removeObserver(this.friendObserver);
      this.friendObserver = null;
      this.mApp = null;
    }
  }
  
  public void onGetAddFriendBlockedList(boolean paramBoolean, List<AddFriendBlockedInfo> paramList, String paramString)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" onGetAddFriendBlockedList()--> blockedInfos =  ");
        int i;
        if (paramList != null) {
          i = paramList.size();
        } else {
          i = 0;
        }
        localStringBuilder.append(i);
        QLog.d("NEW_FRD.NewFriendVerificationServiceImpl", 2, localStringBuilder.toString());
      }
      this.addFriendBlockedInfoList.clear();
      this.addFriendBlockedInfoList.addAll(paramList);
    }
    getHandler().notifyUI(4, paramBoolean, new Object[] { paramList, paramString });
  }
  
  public void onGetAddFriendBlockedRedPoint(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, boolean paramBoolean4)
  {
    setShowAddFriendBlockedEntrance(paramBoolean2);
    setShowRedPoint(paramBoolean3);
    setShowRedPointAtNewFriendBanner(paramBoolean4);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" onGetAddFriendBlockedRedPoint() --> isShowAddFriendBlockedEntrance = ");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(" isShowRedPoint = ");
      localStringBuilder.append(paramBoolean3);
      localStringBuilder.append(" blockedUin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" isShowRedPointAtNewFriendBanner = ");
      localStringBuilder.append(paramBoolean4);
      QLog.d("NEW_FRD.NewFriendVerificationServiceImpl", 2, localStringBuilder.toString());
    }
    getHandler().notifyUI(3, paramBoolean1, new Object[] { Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), paramString, Boolean.valueOf(paramBoolean4) });
  }
  
  public void onReportAddFriendBlocked(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" onReportAddFriendBlocked()-->  success=  ");
      localStringBuilder.append(paramBoolean);
      QLog.d("NEW_FRD.NewFriendVerificationServiceImpl", 2, localStringBuilder.toString());
    }
    this.isReportAddFriendBlockedSuccess = paramBoolean;
    getHandler().notifyUI(2, paramBoolean, null);
  }
  
  public void reportAddFriendBlocked(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start --> reportAddFriendBlocked() friendUin :");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" friendSetting=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" troopUin = ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("NEW_FRD.NewFriendVerificationServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("friend_setting", paramInt1);
    ((Bundle)localObject).putString("uin", paramString1);
    ((Bundle)localObject).putInt("source_id", paramInt2);
    ((Bundle)localObject).putInt("sub_source_id", paramInt3);
    ((Bundle)localObject).putString("troop_uin", paramString2);
    innerReportAddFriend(false, (Bundle)localObject);
  }
  
  public void setBlockInfoHasRead()
  {
    Object localObject = this.addFriendBlockedInfoList;
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return;
      }
      localObject = this.addFriendBlockedInfoList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AddFriendBlockedInfo)((Iterator)localObject).next()).a = true;
      }
    }
  }
  
  public void setShowAddFriendBlockedEntrance(boolean paramBoolean)
  {
    this.isShowAddFriendBlockedEntrance = paramBoolean;
    saveConfigToSp("add_friend_blocked_show_entrance", Boolean.valueOf(this.isShowAddFriendBlockedEntrance));
  }
  
  public void setShowRedPoint(boolean paramBoolean)
  {
    this.isShowRedPoint = paramBoolean;
    saveConfigToSp("add_friend_blocked_show_red_point", Boolean.valueOf(this.isShowRedPoint));
  }
  
  public void setShowRedPointAtNewFriendBanner(boolean paramBoolean)
  {
    this.isShowRedPointAtNewFriendBanner = paramBoolean;
    saveConfigToSp("add_friend_blocked_show_red_point_at_new_friend_banner", Boolean.valueOf(this.isShowRedPointAtNewFriendBanner));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.api.impl.NewFriendVerificationServiceImpl
 * JD-Core Version:    0.7.0.1
 */