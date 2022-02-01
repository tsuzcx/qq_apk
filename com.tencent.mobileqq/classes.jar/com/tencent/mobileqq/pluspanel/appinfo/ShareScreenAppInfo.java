package com.tencent.mobileqq.pluspanel.appinfo;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.tencent.av.ReqGroupVideo.ReqScreenShareAsk;
import com.tencent.av.business.handler.MessageHandler;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.screenshare.ScreenShareDialogUtil;
import com.tencent.av.screenshare.ScreenShareReportHelper;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.Locale;

public class ShareScreenAppInfo
  extends PlusPanelAppInfo
{
  ShareScreenAppInfo() {}
  
  public ShareScreenAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  private void a(int paramInt, PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    BaseActivity localBaseActivity = paramBaseChatPie.a();
    if (localBaseActivity != null)
    {
      if (localBaseActivity.isFinishing()) {
        return;
      }
      String str1 = localBaseActivity.getString(2131718564);
      String str2 = localBaseActivity.getString(2131718563);
      String str3 = localBaseActivity.getString(2131695618);
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramBaseChatPie.a.getApp());
      if (!localSharedPreferences.contains("SCREEN_SHARE_NOTICE_DIALOG_IS_SHOWN"))
      {
        ScreenShareDialogUtil.a(localBaseActivity, str1, str2, str3, null, true, 10, new ShareScreenAppInfo.2(this, paramInt, paramPlusPanelViewModel, paramBaseChatPie, paramSessionInfo), null).show();
        localSharedPreferences.edit().putBoolean("SCREEN_SHARE_NOTICE_DIALOG_IS_SHOWN", true).apply();
        return;
      }
      DialogUtil.a(localBaseActivity, 230, str1, str2, null, str3, new ShareScreenAppInfo.3(this, paramInt, paramPlusPanelViewModel, paramBaseChatPie, paramSessionInfo), null).show();
    }
  }
  
  private void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    ShareScreenAppInfo.6 local6 = new ShareScreenAppInfo.6(this);
    ReqGroupVideo.ReqScreenShareAsk localReqScreenShareAsk = new ReqGroupVideo.ReqScreenShareAsk();
    localReqScreenShareAsk.from_uin.set(paramBaseChatPie.a.getLongAccountUin());
    localReqScreenShareAsk.to_uin.set(Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString));
    localReqScreenShareAsk.is_online.set(false);
    MessageHandler.a(QQAudioHelper.b(), paramBaseChatPie.a, "QQRTCSvc.screen_share_ask", localReqScreenShareAsk, local6);
    QLog.d("ShareScreenAppInfo", 1, String.format(Locale.ENGLISH, "shareGAVArkMsg success : from_uin[%d], to_uin[%s], ", new Object[] { Long.valueOf(paramBaseChatPie.a.getLongAccountUin()), paramSessionInfo.jdField_a_of_type_JavaLangString }));
  }
  
  private void a(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    Object localObject = paramBaseChatPie.a();
    if (localObject != null)
    {
      if (((Activity)localObject).isFinishing()) {
        return;
      }
      localObject = ActionSheet.create((Context)localObject);
      ((ActionSheet)localObject).addButton(2131718551, 0);
      if (QAVConfigUtils.l())
      {
        ((ActionSheet)localObject).addButton(2131718550, 0);
        ((ActionSheet)localObject).addCancelButton(2131690728);
        ((ActionSheet)localObject).setOnButtonClickListener(new ShareScreenAppInfo.4(this, paramPlusPanelViewModel, paramBaseChatPie, paramSessionInfo, (ActionSheet)localObject));
        ((ActionSheet)localObject).setOnBottomCancelListener(new ShareScreenAppInfo.5(this, (ActionSheet)localObject));
        ((ActionSheet)localObject).show();
        return;
      }
      b(paramPlusPanelViewModel, paramBaseChatPie, paramSessionInfo);
      ScreenShareReportHelper.a("0X800AD8E", 1);
    }
  }
  
  private void b(int paramInt, PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if (paramInt == 1)
    {
      showSelGAudioChatEntryActionSheet(paramBaseChatPie, paramSessionInfo, 10, false, "AIOShareScreen");
      ScreenShareReportHelper.a("0X800AD8E", 2);
      return;
    }
    if (paramInt == 0)
    {
      a(paramPlusPanelViewModel, paramBaseChatPie, paramSessionInfo);
      ScreenShareReportHelper.a("0X800B89E", 1);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramPlusPanelViewModel = new StringBuilder();
      paramPlusPanelViewModel.append("clickToolShareScreen, not support chat, [");
      paramPlusPanelViewModel.append(paramSessionInfo.jdField_a_of_type_Int);
      paramPlusPanelViewModel.append("]");
      QLog.i("ShareScreenAppInfo", 2, paramPlusPanelViewModel.toString());
    }
  }
  
  private void b(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    BaseActivity localBaseActivity = paramBaseChatPie.a();
    if (localBaseActivity != null)
    {
      if (localBaseActivity.isFinishing()) {
        return;
      }
      paramBaseChatPie.Q();
      paramPlusPanelViewModel.b(paramBaseChatPie);
      PlusPanelUtils.a(paramBaseChatPie.a, localBaseActivity, paramSessionInfo, true, "AIOShareScreen", null);
      localBaseActivity.setCanLock(false);
    }
  }
  
  public int defaultDrawableID()
  {
    return 2130839150;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 221;
    }
    return 101850591;
  }
  
  public int getManageConfigID()
  {
    if (isC2C()) {
      return 600;
    }
    return 0;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 130221;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131698596);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    int i;
    if (Build.VERSION.SDK_INT >= 21) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      try
      {
        paramPlusPanelViewModel = paramBaseChatPie.a();
        if (paramPlusPanelViewModel != null)
        {
          if (paramPlusPanelViewModel.isFinishing()) {
            return;
          }
          paramBaseChatPie = paramPlusPanelViewModel.getResources();
          DialogUtil.a(paramPlusPanelViewModel, 230, paramBaseChatPie.getString(2131691634), paramBaseChatPie.getString(2131695856), 0, 2131695618, new ShareScreenAppInfo.1(this), null).show();
          return;
        }
        return;
      }
      catch (Throwable paramPlusPanelViewModel)
      {
        QLog.i("ShareScreenAppInfo", 1, "clickToolShareScreen", paramPlusPanelViewModel);
        return;
      }
    }
    if (paramBaseChatPie.a.getAVNotifyCenter().a(paramBaseChatPie.a(), 3, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    a(this.uinType, paramPlusPanelViewModel, paramBaseChatPie, paramSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.ShareScreenAppInfo
 * JD-Core Version:    0.7.0.1
 */