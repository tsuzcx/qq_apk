package com.tencent.mobileqq.extendfriend.fragment;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatManager;
import com.tencent.mobileqq.extendfriend.limitchat.SignalBombHelper;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.mobileqq.extendfriend.utils.ColdPalaceHelper;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ExtendFriendFragment$2
  extends ExtendFriendObserver
{
  ExtendFriendFragment$2(ExtendFriendFragment paramExtendFriendFragment) {}
  
  public void onGetColdPalaceData(boolean paramBoolean)
  {
    ColdPalaceHelper localColdPalaceHelper;
    if ((paramBoolean) && (ExtendFriendFragment.a(this.a) != null) && (ExtendFriendFragment.a(this.a) != null) && (!ExtendFriendFragment.a(this.a).isFinishing()))
    {
      localColdPalaceHelper = ColdPalaceHelper.a(ExtendFriendFragment.a(this.a));
      if (!localColdPalaceHelper.c()) {
        break label63;
      }
      this.a.c();
    }
    label63:
    while (!localColdPalaceHelper.b()) {
      return;
    }
    this.a.b();
  }
  
  public void onUpdateCampusCertificateStatus(boolean paramBoolean, int paramInt)
  {
    int i = ExtendFriendFragment.a(this.a).f();
    String str = ExtendFriendFragment.a(this.a).h();
    ExtendFriendFragment.a(this.a).i();
    int j = ExtendFriendFragment.a(this.a).a();
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, "onUpdateCampusCertificateStatus,isSuccess + " + paramBoolean + ",birthday + " + j + ",scene + " + paramInt + ",verifyStatus + " + i + ",serverSuggestSchoolName + " + str);
    }
    if ((paramBoolean) && (paramInt == 1))
    {
      ExtendFriendFragment.a(this.a, j);
      if (TextUtils.isEmpty(ExtendFriendFragment.a(this.a).i())) {
        break label182;
      }
      paramInt = 1;
      if (paramInt == 0) {
        break label187;
      }
    }
    label182:
    label187:
    for (paramInt = 1;; paramInt = 2)
    {
      ReportController.b(null, "dc00898", "", "", "0X800ADD7", "0X800ADD7", paramInt, 0, "", "", "", "");
      return;
      paramInt = 0;
      break;
    }
  }
  
  public void onUpdateExtendFriendCampusSchoolInfo(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, "onUpdateExtendFriendCampusSchoolInfo isSuccess = " + paramBoolean);
    }
    if (paramBoolean) {
      QQToast.a(ExtendFriendFragment.a(this.a), 2, 2131698706, 0).b(ExtendFriendFragment.a(this.a).getTitleBarHeight());
    }
  }
  
  public void onUpdateRedPoint(int paramInt)
  {
    MatchChatMsgUtil.a(ExtendFriendFragment.a(this.a), ExtendFriendFragment.a(this.a).app);
    Intent localIntent = new Intent("match_chat_notify_update");
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
  }
  
  public void onUpdateSignalBombPush(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, "onUpdateSignalBombPush " + paramBoolean + " " + paramString);
    }
    if ((ExtendFriendFragment.a(this.a) != null) && (ExtendFriendFragment.a(this.a).isResume()) && (((ExtendFriendLimitChatManager)ExtendFriendFragment.a(this.a).app.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER)).a() != 2) && (!ExtendFriendFragment.a(this.a))) {
      ExtendFriendFragment.a(this.a, SignalBombHelper.a(ExtendFriendFragment.a(this.a), ExtendFriendFragment.a(this.a).app, ExtendFriendFragment.a(this.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment.2
 * JD-Core Version:    0.7.0.1
 */