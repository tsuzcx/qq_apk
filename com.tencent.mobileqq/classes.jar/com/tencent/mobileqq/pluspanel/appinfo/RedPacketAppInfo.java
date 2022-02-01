package com.tencent.mobileqq.pluspanel.appinfo;

import afcm;
import ayfu;
import bcef;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.BaseApplication;

public class RedPacketAppInfo
  extends PlusPanelAppInfo
{
  private long mLastClickedTime;
  
  public RedPacketAppInfo() {}
  
  public RedPacketAppInfo(int paramInt)
  {
    this.uinType = paramInt;
  }
  
  public int defaultDrawableID()
  {
    return 2130839187;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 219;
    }
    return 1104864062;
  }
  
  public int getManageConfigID()
  {
    if (isC2C()) {
      return 510;
    }
    return 0;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 130219;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131718117);
  }
  
  public void init()
  {
    super.init();
    this.mLastClickedTime = 0L;
  }
  
  public void onPlusPanelAppClick(ayfu paramayfu, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.mLastClickedTime) < 1000L) {
      return;
    }
    this.mLastClickedTime = l;
    paramayfu.b(paramBaseChatPie);
    paramBaseChatPie.showPlusItemPanel(10);
    afcm.a(0);
    paramayfu = "";
    if ((paramSessionInfo.curType == 0) || (paramSessionInfo.curType == 1000) || (paramSessionInfo.curType == 1004) || (paramSessionInfo.curType == 1001) || (paramSessionInfo.curType == 10002) || (paramSessionInfo.curType == 10004) || (paramSessionInfo.curType == 10008)) {
      paramayfu = "entrance.click.c2c.plus";
    }
    for (;;)
    {
      bcef.b(paramBaseChatPie.app, "P_CliOper", "Vip_pay_mywallet", "", "wallet", paramayfu, 0, 0, "", "", "", "");
      return;
      if (paramSessionInfo.curType == 3000) {
        paramayfu = "entrance.click.group.plus";
      } else if (paramSessionInfo.curType == 1) {
        paramayfu = "entrance.click.chatgroup.plus";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.RedPacketAppInfo
 * JD-Core Version:    0.7.0.1
 */