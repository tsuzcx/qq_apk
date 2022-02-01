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
import com.tencent.av.utils.QAVConfigUtils.ScreenShareSafeTips;
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
import mqq.util.LogUtil;

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
    BaseActivity localBaseActivity = paramBaseChatPie.aX();
    if (localBaseActivity != null)
    {
      if (localBaseActivity.isFinishing()) {
        return;
      }
      String str1 = localBaseActivity.getString(2131916065);
      Object localObject1 = localBaseActivity.getString(2131916062);
      Object localObject2 = localBaseActivity.getString(2131916063);
      String str4 = localBaseActivity.getString(2131916064);
      String str2 = localBaseActivity.getString(2131893182);
      String str3 = localBaseActivity.getString(2131893168);
      localObject1 = QAVConfigUtils.a((String)localObject1, (String)localObject2, str4);
      localObject1 = ScreenShareDialogUtil.a(localBaseActivity, ((QAVConfigUtils.ScreenShareSafeTips)localObject1).a, ((QAVConfigUtils.ScreenShareSafeTips)localObject1).b, ((QAVConfigUtils.ScreenShareSafeTips)localObject1).c);
      localObject2 = PreferenceManager.getDefaultSharedPreferences(paramBaseChatPie.d.getApp());
      if (!((SharedPreferences)localObject2).contains("SCREEN_SHARE_NOTICE_DIALOG_IS_SHOWN"))
      {
        ScreenShareDialogUtil.a(localBaseActivity, str1, (CharSequence)localObject1, str3, str2, true, 10, new ShareScreenAppInfo.2(this), new ShareScreenAppInfo.3(this, paramInt, paramPlusPanelViewModel, paramBaseChatPie, paramSessionInfo)).show();
        ((SharedPreferences)localObject2).edit().putBoolean("SCREEN_SHARE_NOTICE_DIALOG_IS_SHOWN", true).apply();
        return;
      }
      DialogUtil.a(localBaseActivity, 230, str1, (CharSequence)localObject1, str3, str2, new ShareScreenAppInfo.4(this, paramInt, paramPlusPanelViewModel, paramBaseChatPie, paramSessionInfo), new ShareScreenAppInfo.5(this)).setMessageWithoutAutoLink((CharSequence)localObject1).show();
    }
  }
  
  private void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    ShareScreenAppInfo.8 local8 = new ShareScreenAppInfo.8(this);
    ReqGroupVideo.ReqScreenShareAsk localReqScreenShareAsk = new ReqGroupVideo.ReqScreenShareAsk();
    localReqScreenShareAsk.from_uin.set(paramBaseChatPie.d.getLongAccountUin());
    localReqScreenShareAsk.to_uin.set(Long.parseLong(paramSessionInfo.b));
    localReqScreenShareAsk.is_online.set(false);
    MessageHandler.a(QQAudioHelper.d(), paramBaseChatPie.d, "QQRTCSvc.screen_share_ask", localReqScreenShareAsk, local8);
    QLog.d("ShareScreenAppInfo", 1, String.format(Locale.ENGLISH, "shareGAVArkMsg success : from_uin[%s], to_uin[%s], ", new Object[] { LogUtil.getSafePrintUin(String.valueOf(paramBaseChatPie.d.getLongAccountUin())), LogUtil.getSafePrintUin(paramSessionInfo.b) }));
  }
  
  private void a(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    Object localObject = paramBaseChatPie.aX();
    if (localObject != null)
    {
      if (((Activity)localObject).isFinishing()) {
        return;
      }
      localObject = ActionSheet.create((Context)localObject);
      ((ActionSheet)localObject).addButton(2131916050, 0);
      if (QAVConfigUtils.t())
      {
        ((ActionSheet)localObject).addButton(2131916049, 0);
        ((ActionSheet)localObject).addCancelButton(2131887648);
        ((ActionSheet)localObject).setOnButtonClickListener(new ShareScreenAppInfo.6(this, paramPlusPanelViewModel, paramBaseChatPie, paramSessionInfo, (ActionSheet)localObject));
        ((ActionSheet)localObject).setOnBottomCancelListener(new ShareScreenAppInfo.7(this, (ActionSheet)localObject));
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
      paramPlusPanelViewModel.append(paramSessionInfo.a);
      paramPlusPanelViewModel.append("]");
      QLog.i("ShareScreenAppInfo", 2, paramPlusPanelViewModel.toString());
    }
  }
  
  private void b(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    BaseActivity localBaseActivity = paramBaseChatPie.aX();
    if (localBaseActivity != null)
    {
      if (localBaseActivity.isFinishing()) {
        return;
      }
      paramBaseChatPie.aw();
      paramPlusPanelViewModel.b(paramBaseChatPie);
      PlusPanelUtils.a(paramBaseChatPie.d, localBaseActivity, paramSessionInfo, true, "AIOShareScreen", null);
      localBaseActivity.setCanLock(false);
    }
  }
  
  public int defaultDrawableID()
  {
    return 2130839306;
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
    return BaseApplicationImpl.getContext().getString(2131896543);
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
        paramPlusPanelViewModel = paramBaseChatPie.aX();
        if (paramPlusPanelViewModel != null)
        {
          if (paramPlusPanelViewModel.isFinishing()) {
            return;
          }
          paramBaseChatPie = paramPlusPanelViewModel.getResources();
          DialogUtil.a(paramPlusPanelViewModel, 230, paramBaseChatPie.getString(2131888596), paramBaseChatPie.getString(2131893615), 0, 2131893377, new ShareScreenAppInfo.1(this), null).show();
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
    if (paramBaseChatPie.d.getAVNotifyCenter().a(paramBaseChatPie.aX(), 3, paramSessionInfo.a, paramSessionInfo.b)) {
      return;
    }
    a(this.uinType, paramPlusPanelViewModel, paramBaseChatPie, paramSessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.ShareScreenAppInfo
 * JD-Core Version:    0.7.0.1
 */