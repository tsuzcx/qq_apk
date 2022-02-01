package com.tencent.mobileqq.vip;

import com.tencent.mobileqq.app.ThreadManager;
import dualsim.common.IKingCardInterface;
import dualsim.common.OrderCheckResult;
import mqq.os.MqqHandler;
import tmsdk.common.KcSdkShellManager;

class KCWraperV2$2
  implements Runnable
{
  KCWraperV2$2(KCWraperV2 paramKCWraperV2, TMSManager.Callback paramCallback, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = KcSdkShellManager.getInstance().getKingCardInterface();
    boolean bool2 = false;
    boolean bool1 = false;
    int i;
    if (localObject == null)
    {
      this.this$0.a("no KingCardInterface");
      i = 0;
      bool1 = bool2;
    }
    else
    {
      localObject = ((IKingCardInterface)localObject).getResult();
      if (((OrderCheckResult)localObject).kingcard > 0) {
        bool1 = true;
      }
      i = ((OrderCheckResult)localObject).product;
      KCWraperV2.a(this.this$0, (OrderCheckResult)localObject);
    }
    localObject = this.a;
    if (localObject != null)
    {
      if (this.b)
      {
        ThreadManager.getUIHandler().post(new KCWraperV2.2.1(this, bool1, i));
        return;
      }
      ((TMSManager.Callback)localObject).a(true, bool1, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.KCWraperV2.2
 * JD-Core Version:    0.7.0.1
 */