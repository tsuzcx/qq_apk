package com.tencent.mobileqq.profilecard.vas.component.header;

import anmw;
import azfl;
import azpu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.persistence.EntityManager;

public class AbsVasProfileHeaderComponent$6
  implements Runnable
{
  public AbsVasProfileHeaderComponent$6(azpu paramazpu) {}
  
  public void run()
  {
    Object localObject = ((anmw)azpu.q(this.this$0).getManager(51)).b(azpu.r(this.this$0).getCurrentAccountUin());
    if (localObject == null) {
      azpu.a(this.this$0, "-1");
    }
    for (;;)
    {
      azpu.a(this.this$0, "-1");
      return;
      if (((Card)localObject).lCurrentStyleId == azfl.a)
      {
        localObject = (QZoneCover)azpu.s(this.this$0).a().createEntityManager().find(QZoneCover.class, azpu.t(this.this$0).getCurrentAccountUin());
        if (localObject != null) {
          azpu.a(this.this$0, ((QZoneCover)localObject).type);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent.6
 * JD-Core Version:    0.7.0.1
 */