package com.tencent.mobileqq.fts.operator;

import com.tencent.mobileqq.fts.api.IFTSDBRuntimeService;
import com.tencent.mobileqq.persistence.fts.FTSDatatbase;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class FTSMsgUpgrader$1
  implements Runnable
{
  FTSMsgUpgrader$1(FTSMsgUpgrader paramFTSMsgUpgrader) {}
  
  public void run()
  {
    Object localObject = (IFTSDBRuntimeService)FTSMsgUpgrader.a(this.this$0).getRuntimeService(IFTSDBRuntimeService.class, "");
    if ((!FTSMsgUpgrader.b(this.this$0)) && (((IFTSDBRuntimeService)localObject).hasInit()))
    {
      if ((FTSMsgUpgrader.c(this.this$0) != null) && (FTSMsgUpgrader.c(this.this$0).a()))
      {
        if (!this.this$0.a) {
          FTSMsgUpgrader.d(this.this$0);
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("upgrade history in handle hasReadNativeCursor = ");
          ((StringBuilder)localObject).append(this.this$0.a);
          ((StringBuilder)localObject).append(" mUpgradeCursor=");
          ((StringBuilder)localObject).append(FTSMsgUpgrader.e(this.this$0));
          ((StringBuilder)localObject).append(" mUpgradeMaxIndex=");
          ((StringBuilder)localObject).append(FTSMsgUpgrader.f(this.this$0));
          QLog.d("Q.fts.FTSMsgUpgrader", 2, ((StringBuilder)localObject).toString());
        }
        if (this.this$0.a) {
          if (FTSMsgUpgrader.e(this.this$0) < FTSMsgUpgrader.f(this.this$0))
          {
            if (FTSMsgUpgrader.g(this.this$0))
            {
              FTSMsgUpgrader.h(this.this$0).postDelayed(this, 20L);
              return;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.fts.FTSMsgUpgrader", 2, "writeNativeIndex failed");
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.fts.FTSMsgUpgrader", 2, "upgrade compeleted in handler");
            }
            FTSMsgUpgrader.i(this.this$0);
            FTSMsgUpgrader.j(this.this$0).h();
          }
        }
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("upgrade history in handle mDatabase = ");
        if (FTSMsgUpgrader.c(this.this$0) == null) {
          localObject = "null";
        } else {
          localObject = "@@@";
        }
        localStringBuilder.append((String)localObject);
        QLog.d("Q.fts.FTSMsgUpgrader", 1, localStringBuilder.toString());
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("upgrade history in handle isDestroy = ");
      ((StringBuilder)localObject).append(FTSMsgUpgrader.b(this.this$0));
      QLog.d("Q.fts.FTSMsgUpgrader", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fts.operator.FTSMsgUpgrader.1
 * JD-Core Version:    0.7.0.1
 */