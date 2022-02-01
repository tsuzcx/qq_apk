package com.tencent.open.agent;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.widget.QQToast;
import eipc.EIPCResult;
import mqq.os.MqqHandler;

class QrAgentLoginManager$1
  extends QIPCModule
{
  QrAgentLoginManager$1(QrAgentLoginManager paramQrAgentLoginManager, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("QIPC_SHOW_TOAST_ACTION".equals(paramString))
    {
      if (Looper.getMainLooper() != Looper.myLooper()) {
        break label36;
      }
      QQToast.a(BaseApplicationImpl.context, HardCodeUtil.a(2131711161), 1).a();
    }
    for (;;)
    {
      return null;
      label36:
      ThreadManager.getUIHandler().post(new QrAgentLoginManager.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.QrAgentLoginManager.1
 * JD-Core Version:    0.7.0.1
 */