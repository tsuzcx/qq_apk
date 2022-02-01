package com.tencent.mobileqq.mini.reuse;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.concurrent.atomic.AtomicBoolean;

class MiniAppTransferModule$3
  extends CardObserver
{
  MiniAppTransferModule$3(MiniAppTransferModule paramMiniAppTransferModule) {}
  
  protected void onSetNotDisturb(boolean paramBoolean, String paramString1, String paramString2)
  {
    super.onSetNotDisturb(paramBoolean, paramString1, paramString2);
    if (!"not_disturb_from_miniapp".equals(paramString2))
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("onSetNotDisturb NOT FROM THIS");
        paramString1.append(paramString2);
        QLog.d("MiniAppTransferModule", 4, paramString1.toString());
      }
      return;
    }
    MiniAppTransferModule.access$000(this.this$0).set(false);
    if (!paramBoolean)
    {
      QLog.d("MiniAppTransferModule", 1, "Request failed, return.");
      if (MiniAppTransferModule.access$100(this.this$0) != -1)
      {
        paramString1 = new Bundle();
        paramString1.putString("errMsg", "Request failed");
        paramString2 = this.this$0;
        paramString2.callbackResult(MiniAppTransferModule.access$100(paramString2), EIPCResult.createResult(-102, paramString1));
      }
    }
    else
    {
      paramString1 = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getHandler(Conversation.class);
      if (paramString1 != null) {
        Conversation.a(paramString1, BaseApplicationImpl.getContext());
      }
      if (MiniAppTransferModule.access$100(this.this$0) != -1)
      {
        paramString1 = new Bundle();
        paramString1.putString("errMsg", "ok");
        paramString2 = this.this$0;
        paramString2.callbackResult(MiniAppTransferModule.access$100(paramString2), EIPCResult.createResult(0, paramString1));
      }
    }
    MiniAppTransferModule.access$102(this.this$0, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.reuse.MiniAppTransferModule.3
 * JD-Core Version:    0.7.0.1
 */