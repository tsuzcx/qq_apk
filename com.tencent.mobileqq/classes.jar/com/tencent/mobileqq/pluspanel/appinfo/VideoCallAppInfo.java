package com.tencent.mobileqq.pluspanel.appinfo;

import com.tencent.av.gaudio.AVNotifyCenter;
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
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;

public class VideoCallAppInfo
  extends PlusPanelAppInfo
{
  VideoCallAppInfo() {}
  
  public VideoCallAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130839300;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 202;
    }
    return 1106658188;
  }
  
  public int getManageConfigID()
  {
    if (isC2C()) {
      return 503;
    }
    return 0;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 130202;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131698619);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.a;
    if (localQQAppInterface.getAVNotifyCenter().a(paramBaseChatPie.a(), 2, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.jdField_a_of_type_JavaLangString)) {}
    long l;
    do
    {
      return;
      if (paramSessionInfo.jdField_a_of_type_Int == 1)
      {
        showSelGAudioChatEntryActionSheet(paramBaseChatPie, paramSessionInfo, 10, true, null);
        return;
      }
      if (paramSessionInfo.jdField_a_of_type_Int != 3000) {
        break;
      }
      paramPlusPanelViewModel.a("chat_tool_gaudio", localQQAppInterface.getCurrentAccountUin());
      showSelGAudioChatEntryActionSheet(paramBaseChatPie, paramSessionInfo, 1, true, null);
      paramPlusPanelViewModel.b(paramBaseChatPie);
      paramBaseChatPie.a().setCanLock(false);
      l = Long.parseLong(paramSessionInfo.jdField_a_of_type_JavaLangString);
    } while (localQQAppInterface.getAVNotifyCenter().b() == l);
    ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8005676", "0X8005676", 0, 0, "", "", "", "");
    return;
    if ((paramSessionInfo.jdField_a_of_type_Int == 1001) || (paramSessionInfo.jdField_a_of_type_Int == 10002))
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8005153", "0X8005153", 0, 0, "", "", "", "");
      if (!LBSHandler.a(localQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString))
      {
        paramBaseChatPie.g(BaseApplicationImpl.getContext().getString(2131694438));
        ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8005155", "0X8005155", 0, 0, "", "", "", "");
        ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8005155", "0X8005155", 0, 0, "", "", "", "");
        if (paramSessionInfo.jdField_a_of_type_Int == 1001) {}
        for (paramPlusPanelViewModel = "0";; paramPlusPanelViewModel = "1")
        {
          ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "tip_annoy", 0, 0, paramPlusPanelViewModel, "1", "", "");
          return;
        }
      }
    }
    else if ((paramSessionInfo.jdField_a_of_type_Int == 1010) && (!DatingUtil.a(localQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      paramBaseChatPie.g(BaseApplicationImpl.getContext().getString(2131694438));
      return;
    }
    PlusPanelUtils.a(localQQAppInterface, paramBaseChatPie.a(), paramSessionInfo, false, null, null);
    paramBaseChatPie.an();
    paramBaseChatPie.a().setCanLock(false);
    AIOPanelUtiles.a(localQQAppInterface, "0X8004086", paramSessionInfo.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.VideoCallAppInfo
 * JD-Core Version:    0.7.0.1
 */