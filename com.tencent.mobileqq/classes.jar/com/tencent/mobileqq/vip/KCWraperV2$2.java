package com.tencent.mobileqq.vip;

import bean;
import beaw;
import com.tencent.mobileqq.app.ThreadManager;
import dualsim.common.IKingCardInterface;
import dualsim.common.OrderCheckResult;
import mqq.os.MqqHandler;
import tmsdk.common.KcSdkShellManager;

public class KCWraperV2$2
  implements Runnable
{
  public KCWraperV2$2(bean parambean, beaw parambeaw, boolean paramBoolean) {}
  
  public void run()
  {
    boolean bool = false;
    int i = 0;
    Object localObject = KcSdkShellManager.getInstance().getKingCardInterface();
    if (localObject == null)
    {
      this.this$0.a("no KingCardInterface");
      bool = false;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Beaw != null)
      {
        if (!this.jdField_a_of_type_Boolean) {
          break;
        }
        ThreadManager.getUIHandler().post(new KCWraperV2.2.1(this, bool, i));
      }
      return;
      localObject = ((IKingCardInterface)localObject).getResult();
      if (((OrderCheckResult)localObject).kingcard > 0) {
        bool = true;
      }
      i = ((OrderCheckResult)localObject).product;
      bean.a(this.this$0, (OrderCheckResult)localObject);
    }
    this.jdField_a_of_type_Beaw.a(true, bool, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.KCWraperV2.2
 * JD-Core Version:    0.7.0.1
 */