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
    return 2130839113;
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
    return BaseApplicationImpl.getContext().getString(2131719732);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface1 = paramBaseChatPie.a;
    if (localQQAppInterface1.getAVNotifyCenter().a(paramBaseChatPie.a(), 1, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if (paramSessionInfo.jdField_a_of_type_Int == 1)
    {
      showSelGAudioChatEntryActionSheet(paramBaseChatPie, paramSessionInfo, 10, false, null);
      return;
    }
    if (paramSessionInfo.jdField_a_of_type_Int == 3000)
    {
      paramPlusPanelViewModel.a("chat_tool_gaudio", localQQAppInterface1.getCurrentAccountUin());
      showSelGAudioChatEntryActionSheet(paramBaseChatPie, paramSessionInfo, 1, false, null);
      paramPlusPanelViewModel.b(paramBaseChatPie);
      paramBaseChatPie.a().setCanLock(false);
      long l = Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString);
      if (localQQAppInterface1.getAVNotifyCenter().b() != l) {
        ReportController.b(localQQAppInterface1, "CliOper", "", "", "0X8004085", "0X8004085", 0, 0, "", "", "", "");
      }
    }
    else
    {
      if ((paramSessionInfo.jdField_a_of_type_Int != 1001) && (paramSessionInfo.jdField_a_of_type_Int != 10002))
      {
        if ((paramSessionInfo.jdField_a_of_type_Int == 1010) && (!DatingUtil.a(localQQAppInterface1, paramSessionInfo.jdField_a_of_type_JavaLangString)))
        {
          paramBaseChatPie.b(BaseApplicationImpl.getContext().getString(2131694402));
          ReportController.b(localQQAppInterface1, "CliOper", "", "", "0X80049C8", "0X80049C8", 0, 0, "", "", "", "");
          return;
        }
      }
      else
      {
        QQAppInterface localQQAppInterface2 = localQQAppInterface1;
        ReportController.b(localQQAppInterface1, "CliOper", "", "", "0X8005152", "0X8005152", 0, 0, "", "", "", "");
        if (!LBSHandler.a(localQQAppInterface2, paramSessionInfo.jdField_a_of_type_JavaLangString))
        {
          paramBaseChatPie.b(BaseApplicationImpl.getContext().getString(2131694402));
          ReportController.b(localQQAppInterface2, "CliOper", "", "", "0X8005154", "0X8005154", 0, 0, "", "", "", "");
          if (paramSessionInfo.jdField_a_of_type_Int == 1001) {
            paramPlusPanelViewModel = "0";
          } else {
            paramPlusPanelViewModel = "1";
          }
          ReportController.b(localQQAppInterface2, "dc00899", "grp_lbs", "", "c2c_tmp", "tip_annoy", 0, 0, paramPlusPanelViewModel, "0", "", "");
          return;
        }
      }
      paramPlusPanelViewModel.a("chat_tool_audio", localQQAppInterface1.getCurrentAccountUin());
      paramBaseChatPie.Q();
      paramPlusPanelViewModel.b(paramBaseChatPie);
      if (paramSessionInfo.jdField_a_of_type_Int == 1024)
      {
        if (((QidianManager)localQQAppInterface1.getManager(QQManagerFactory.QIDIAN_MANAGER)).c(paramSessionInfo.jdField_a_of_type_JavaLangString))
        {
          PlusPanelUtils.a(localQQAppInterface1, paramBaseChatPie.a(), paramSessionInfo, true, null, null);
          return;
        }
        if (CrmUtils.a(localQQAppInterface1, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int))
        {
          CrmUtils.a(localQQAppInterface1, paramBaseChatPie.a(), paramSessionInfo, "IvrAIOBottomButtonEngineFalse");
          ReportController.b(localQQAppInterface1, "CliOper", "", "", "0X8004651", "0X8004651", 0, 0, "", "", "", "");
        }
        else
        {
          QQToast.a(BaseApplicationImpl.getContext(), 2131695706, 1).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299168));
          if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "Don't support ivr");
          }
        }
      }
      else
      {
        PlusPanelUtils.a(localQQAppInterface1, paramBaseChatPie.a(), paramSessionInfo, true, null, null);
      }
      paramBaseChatPie.a().setCanLock(false);
      AIOPanelUtiles.a(localQQAppInterface1, "0X800407B", paramSessionInfo.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.AudioCallAppInfo
 * JD-Core Version:    0.7.0.1
 */