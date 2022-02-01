package com.tencent.mobileqq.pluspanel.appinfo;

import android.content.res.Resources;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class AudioCallAppInfo
  extends PlusPanelAppInfo
{
  AudioCallAppInfo() {}
  
  public AudioCallAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130839269;
  }
  
  public int getAppID()
  {
    if (isTroop()) {
      return 1104651886;
    }
    if (isC2C()) {
      return 201;
    }
    if (isDiscussion()) {
      return 1200000007;
    }
    return 0;
  }
  
  public int getManageConfigID()
  {
    if (isC2C()) {
      return 502;
    }
    return 0;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 130201;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131917335);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface1 = paramBaseChatPie.d;
    if (localQQAppInterface1.getAVNotifyCenter().a(paramBaseChatPie.aX(), 1, paramSessionInfo.a, paramSessionInfo.b)) {
      return;
    }
    if (paramSessionInfo.a == 1)
    {
      showSelGAudioChatEntryActionSheet(paramBaseChatPie, paramSessionInfo, 10, false, null);
      return;
    }
    if (paramSessionInfo.a == 3000)
    {
      paramPlusPanelViewModel.a("chat_tool_gaudio", localQQAppInterface1.getCurrentAccountUin());
      showSelGAudioChatEntryActionSheet(paramBaseChatPie, paramSessionInfo, 1, false, null);
      paramPlusPanelViewModel.b(paramBaseChatPie);
      paramBaseChatPie.aX().setCanLock(false);
      long l = Long.parseLong(paramSessionInfo.b);
      if (localQQAppInterface1.getAVNotifyCenter().g() != l) {
        ReportController.b(localQQAppInterface1, "CliOper", "", "", "0X8004085", "0X8004085", 0, 0, "", "", "", "");
      }
    }
    else
    {
      if ((paramSessionInfo.a != 1001) && (paramSessionInfo.a != 10002))
      {
        if ((paramSessionInfo.a == 1010) && (!DatingUtil.a(localQQAppInterface1, paramSessionInfo.b)))
        {
          paramBaseChatPie.c(BaseApplicationImpl.getContext().getString(2131892081));
          ReportController.b(localQQAppInterface1, "CliOper", "", "", "0X80049C8", "0X80049C8", 0, 0, "", "", "", "");
          return;
        }
      }
      else
      {
        QQAppInterface localQQAppInterface2 = localQQAppInterface1;
        ReportController.b(localQQAppInterface1, "CliOper", "", "", "0X8005152", "0X8005152", 0, 0, "", "", "", "");
        if (!LBSHandler.a(localQQAppInterface2, paramSessionInfo.b))
        {
          paramBaseChatPie.c(BaseApplicationImpl.getContext().getString(2131892081));
          ReportController.b(localQQAppInterface2, "CliOper", "", "", "0X8005154", "0X8005154", 0, 0, "", "", "", "");
          if (paramSessionInfo.a == 1001) {
            paramPlusPanelViewModel = "0";
          } else {
            paramPlusPanelViewModel = "1";
          }
          ReportController.b(localQQAppInterface2, "dc00899", "grp_lbs", "", "c2c_tmp", "tip_annoy", 0, 0, paramPlusPanelViewModel, "0", "", "");
          return;
        }
      }
      paramPlusPanelViewModel.a("chat_tool_audio", localQQAppInterface1.getCurrentAccountUin());
      paramBaseChatPie.aw();
      paramPlusPanelViewModel.b(paramBaseChatPie);
      if (paramSessionInfo.a == 1024)
      {
        if (((QidianManager)localQQAppInterface1.getManager(QQManagerFactory.QIDIAN_MANAGER)).g(paramSessionInfo.b))
        {
          PlusPanelUtils.a(localQQAppInterface1, paramBaseChatPie.aX(), paramSessionInfo, true, null, null);
          return;
        }
        if (CrmUtils.a(localQQAppInterface1, paramSessionInfo.b, paramSessionInfo.a))
        {
          CrmUtils.a(localQQAppInterface1, paramBaseChatPie.aX(), paramSessionInfo, "IvrAIOBottomButtonEngineFalse");
          ReportController.b(localQQAppInterface1, "CliOper", "", "", "0X8004651", "0X8004651", 0, 0, "", "", "", "");
        }
        else
        {
          QQToast.makeText(BaseApplicationImpl.getContext(), 2131893465, 1).show(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299920));
          if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "Don't support ivr");
          }
        }
      }
      else
      {
        PlusPanelUtils.a(localQQAppInterface1, paramBaseChatPie.aX(), paramSessionInfo, true, null, null);
      }
      paramBaseChatPie.aX().setCanLock(false);
      AIOPanelUtiles.a(localQQAppInterface1, "0X800407B", paramSessionInfo.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.AudioCallAppInfo
 * JD-Core Version:    0.7.0.1
 */