package com.tencent.mobileqq.intimate;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mutualmark.MutualMarkUtils;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;

public class IntimateQIPCModule
  extends QIPCModule
{
  private static volatile IntimateQIPCModule a;
  
  public IntimateQIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static IntimateQIPCModule a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new IntimateQIPCModule("IntimateQIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localObject instanceof QQAppInterface)) {
      return null;
    }
    localObject = (QQAppInterface)localObject;
    boolean bool;
    if ("key_web_change_switch_request".equals(paramString))
    {
      bool = paramBundle.getBoolean("key_web_mutual_mark_switch_status");
      if (QLog.isColorLevel()) {
        QLog.d("IntimateQIPCModule", 2, "onCall KEY_WEB_CHANGE_SWITCH_REQUEST ,status = " + bool);
      }
      if (bool)
      {
        paramInt = 1;
        ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X8007021", "0X8007021", 0, 0, String.valueOf(paramInt), "", "", "");
        paramString = (CardHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        if (bool) {
          break label141;
        }
        bool = true;
        label128:
        paramString.j(bool);
      }
    }
    for (;;)
    {
      return null;
      paramInt = 0;
      break;
      label141:
      bool = false;
      break label128;
      if ("key_web_jump_show_reactive_request".equals(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("IntimateQIPCModule", 2, "onCall KEY_WEB_JUMP_SHOW_REACTIVE_REQUEST");
        }
        paramInt = paramBundle.getInt("key_web_jump_show_reactive_entry_value");
        MutualMarkUtils.a((QQAppInterface)localObject, ((QQAppInterface)localObject).getApp(), paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intimate.IntimateQIPCModule
 * JD-Core Version:    0.7.0.1
 */