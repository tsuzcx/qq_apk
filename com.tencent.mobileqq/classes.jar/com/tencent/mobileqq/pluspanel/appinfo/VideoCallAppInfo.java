package com.tencent.mobileqq.pluspanel.appinfo;

import afcm;
import agwt;
import amuu;
import aquj;
import ayfu;
import bcef;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class VideoCallAppInfo
  extends PlusPanelAppInfo
{
  public VideoCallAppInfo() {}
  
  public VideoCallAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130839210;
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
    return BaseApplicationImpl.getContext().getString(2131698053);
  }
  
  public void onPlusPanelAppClick(ayfu paramayfu, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.app;
    if (localQQAppInterface.getAVNotifyCenter().a(paramBaseChatPie.getActivity(), 2, paramSessionInfo.curType, paramSessionInfo.curFriendUin)) {}
    long l;
    do
    {
      return;
      if (paramSessionInfo.curType == 1)
      {
        showSelGAudioChatEntryActionSheet(paramBaseChatPie, paramSessionInfo, 10, true, null);
        return;
      }
      if (paramSessionInfo.curType != 3000) {
        break;
      }
      paramayfu.a("chat_tool_gaudio", localQQAppInterface.getCurrentAccountUin());
      showSelGAudioChatEntryActionSheet(paramBaseChatPie, paramSessionInfo, 1, true, null);
      paramayfu.b(paramBaseChatPie);
      paramBaseChatPie.getActivity().setCanLock(false);
      l = Long.parseLong(paramSessionInfo.curFriendUin);
    } while (localQQAppInterface.getAVNotifyCenter().b() == l);
    bcef.b(localQQAppInterface, "CliOper", "", "", "0X8005676", "0X8005676", 0, 0, "", "", "", "");
    return;
    if ((paramSessionInfo.curType == 1001) || (paramSessionInfo.curType == 10002))
    {
      bcef.b(localQQAppInterface, "CliOper", "", "", "0X8005153", "0X8005153", 0, 0, "", "", "", "");
      if (!amuu.a(localQQAppInterface, paramSessionInfo.curFriendUin))
      {
        paramBaseChatPie.showNearPeopleOperDialog(BaseApplicationImpl.getContext().getString(2131694043));
        bcef.b(localQQAppInterface, "CliOper", "", "", "0X8005155", "0X8005155", 0, 0, "", "", "", "");
        bcef.b(localQQAppInterface, "CliOper", "", "", "0X8005155", "0X8005155", 0, 0, "", "", "", "");
        if (paramSessionInfo.curType == 1001) {}
        for (paramayfu = "0";; paramayfu = "1")
        {
          bcef.b(localQQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "tip_annoy", 0, 0, paramayfu, "1", "", "");
          return;
        }
      }
    }
    else if ((paramSessionInfo.curType == 1010) && (!aquj.a(localQQAppInterface, paramSessionInfo.curFriendUin)))
    {
      paramBaseChatPie.showNearPeopleOperDialog(BaseApplicationImpl.getContext().getString(2131694043));
      return;
    }
    paramBaseChatPie.onEnterCamera();
    afcm.a(localQQAppInterface, paramBaseChatPie.getActivity(), paramSessionInfo, false, null, null);
    paramBaseChatPie.hidePanel();
    paramBaseChatPie.getActivity().setCanLock(false);
    agwt.a(localQQAppInterface, "0X8004086", paramSessionInfo.curType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.VideoCallAppInfo
 * JD-Core Version:    0.7.0.1
 */