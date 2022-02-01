package com.tencent.mobileqq.pluspanel.appinfo;

import aftr;
import ahpt;
import ahvi;
import android.content.res.Resources;
import anxi;
import arxx;
import bdla;
import bjxa;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import nwu;

public class AudioCallAppInfo
  extends PlusPanelAppInfo
{
  public AudioCallAppInfo() {}
  
  public AudioCallAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130839190;
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
    return BaseApplicationImpl.getContext().getString(2131719436);
  }
  
  public void onPlusPanelAppClick(ahvi paramahvi, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.app;
    if (localQQAppInterface.getAVNotifyCenter().a(paramBaseChatPie.getActivity(), 1, paramSessionInfo.curType, paramSessionInfo.curFriendUin)) {}
    long l;
    do
    {
      return;
      if (paramSessionInfo.curType == 1)
      {
        showSelGAudioChatEntryActionSheet(paramBaseChatPie, paramSessionInfo, 10, false, null);
        return;
      }
      if (paramSessionInfo.curType != 3000) {
        break;
      }
      paramahvi.a("chat_tool_gaudio", localQQAppInterface.getCurrentAccountUin());
      showSelGAudioChatEntryActionSheet(paramBaseChatPie, paramSessionInfo, 1, false, null);
      paramahvi.b(paramBaseChatPie);
      paramBaseChatPie.getActivity().setCanLock(false);
      l = Long.parseLong(paramSessionInfo.curFriendUin);
    } while (localQQAppInterface.getAVNotifyCenter().b() == l);
    bdla.b(localQQAppInterface, "CliOper", "", "", "0X8004085", "0X8004085", 0, 0, "", "", "", "");
    return;
    if ((paramSessionInfo.curType == 1001) || (paramSessionInfo.curType == 10002))
    {
      bdla.b(localQQAppInterface, "CliOper", "", "", "0X8005152", "0X8005152", 0, 0, "", "", "", "");
      if (!anxi.a(localQQAppInterface, paramSessionInfo.curFriendUin))
      {
        paramBaseChatPie.showNearPeopleOperDialog(BaseApplicationImpl.getContext().getString(2131694233));
        bdla.b(localQQAppInterface, "CliOper", "", "", "0X8005154", "0X8005154", 0, 0, "", "", "", "");
        if (paramSessionInfo.curType == 1001) {}
        for (paramahvi = "0";; paramahvi = "1")
        {
          bdla.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "tip_annoy", 0, 0, paramahvi, "0", "", "");
          return;
        }
      }
    }
    else if ((paramSessionInfo.curType == 1010) && (!arxx.a(localQQAppInterface, paramSessionInfo.curFriendUin)))
    {
      paramBaseChatPie.showNearPeopleOperDialog(BaseApplicationImpl.getContext().getString(2131694233));
      bdla.b(localQQAppInterface, "CliOper", "", "", "0X80049C8", "0X80049C8", 0, 0, "", "", "", "");
      return;
    }
    paramahvi.a("chat_tool_audio", localQQAppInterface.getCurrentAccountUin());
    paramBaseChatPie.hidePanel();
    paramahvi.b(paramBaseChatPie);
    if (paramSessionInfo.curType == 1024)
    {
      if (((bjxa)localQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).c(paramSessionInfo.curFriendUin))
      {
        aftr.a(localQQAppInterface, paramBaseChatPie.getActivity(), paramSessionInfo, true, null, null);
        return;
      }
      if (nwu.a(localQQAppInterface, paramSessionInfo.curFriendUin, paramSessionInfo.curType))
      {
        nwu.a(localQQAppInterface, paramBaseChatPie.getActivity(), paramSessionInfo, "IvrAIOBottomButtonEngineFalse");
        bdla.b(localQQAppInterface, "CliOper", "", "", "0X8004651", "0X8004651", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      paramBaseChatPie.getActivity().setCanLock(false);
      ahpt.a(localQQAppInterface, "0X800407B", paramSessionInfo.curType);
      return;
      QQToast.a(BaseApplicationImpl.getContext(), 2131695451, 1).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299080));
      if (QLog.isColorLevel())
      {
        QLog.d("AIOAudioPanel", 2, "Don't support ivr");
        continue;
        aftr.a(localQQAppInterface, paramBaseChatPie.getActivity(), paramSessionInfo, true, null, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.AudioCallAppInfo
 * JD-Core Version:    0.7.0.1
 */