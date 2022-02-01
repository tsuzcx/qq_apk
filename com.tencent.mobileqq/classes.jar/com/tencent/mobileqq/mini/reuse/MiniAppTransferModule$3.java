package com.tencent.mobileqq.mini.reuse;

import android.os.Bundle;
import anuw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.concurrent.atomic.AtomicBoolean;

class MiniAppTransferModule$3
  extends anuw
{
  MiniAppTransferModule$3(MiniAppTransferModule paramMiniAppTransferModule) {}
  
  public void onSetNotDisturb(boolean paramBoolean, String paramString1, String paramString2)
  {
    super.onSetNotDisturb(paramBoolean, paramString1, paramString2);
    if (!"not_disturb_from_miniapp".equals(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppTransferModule", 4, "onSetNotDisturb NOT FROM THIS" + paramString2);
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
        this.this$0.callbackResult(MiniAppTransferModule.access$100(this.this$0), EIPCResult.createResult(-102, paramString1));
      }
    }
    for (;;)
    {
      MiniAppTransferModule.access$102(this.this$0, -1);
      return;
      paramString1 = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getHandler(Conversation.class);
      if (paramString1 != null) {
        Conversation.a(paramString1, BaseApplicationImpl.getContext());
      }
      if (MiniAppTransferModule.access$100(this.this$0) != -1)
      {
        paramString1 = new Bundle();
        paramString1.putString("errMsg", "ok");
        this.this$0.callbackResult(MiniAppTransferModule.access$100(this.this$0), EIPCResult.createResult(0, paramString1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.reuse.MiniAppTransferModule.3
 * JD-Core Version:    0.7.0.1
 */