package com.tencent.mobileqq.filemanager.fileassistant.aio;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.pluspanel.C2CPlusPanelAppConfigHelper;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.c2c.C2CPlusPanelAppLoader;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.hotpic.HotPicManager;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkManager;

public class NewDataLinePlusPanelAppLoader
  extends C2CPlusPanelAppLoader
{
  public void a(int paramInt1, int paramInt2)
  {
    if (d())
    {
      PlusPanelAppInfo localPlusPanelAppInfo = C2CPlusPanelAppConfigHelper.INSTANCE.getAppInfoByAppID(paramInt2);
      if (localPlusPanelAppInfo != null)
      {
        b(localPlusPanelAppInfo);
        return;
      }
    }
    super.a(paramInt1, paramInt2);
  }
  
  public void b(BaseChatPie paramBaseChatPie)
  {
    QQAppInterface localQQAppInterface = paramBaseChatPie.d;
    ReportController.b(localQQAppInterface, "P_CliOper", "Vip_pay_mywallet", "", "wallet", "transferAIOshow", 0, 0, "", "", "", "");
    if (SimpleUIUtil.e())
    {
      a(paramBaseChatPie.ah.a, 217);
      a(paramBaseChatPie.ah.a, 218);
    }
    if (HotPicManager.a(localQQAppInterface).j()) {
      a(paramBaseChatPie.ah.a, 204);
    }
    a(paramBaseChatPie.ah.a, 205);
    a(paramBaseChatPie.ah.a, 206);
    a(paramBaseChatPie.ah.a, 208);
    if (ScribbleResMgr.e(paramBaseChatPie.e, localQQAppInterface.getCurrentAccountUin())) {
      a(paramBaseChatPie.ah.a, 210);
    }
    a(paramBaseChatPie.ah.a, 212);
    if (((TeamWorkManager)localQQAppInterface.getManager(QQManagerFactory.TEAMWORK_MANAGER)).a().booleanValue())
    {
      a(paramBaseChatPie.ah.a, 214);
      AIOPanelUtiles.a(localQQAppInterface, "0X80093F3", paramBaseChatPie.ah.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.aio.NewDataLinePlusPanelAppLoader
 * JD-Core Version:    0.7.0.1
 */