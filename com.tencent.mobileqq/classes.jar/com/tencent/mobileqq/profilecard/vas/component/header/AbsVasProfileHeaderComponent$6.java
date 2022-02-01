package com.tencent.mobileqq.profilecard.vas.component.header;

import anyw;
import azxy;
import baik;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.persistence.EntityManager;

public class AbsVasProfileHeaderComponent$6
  implements Runnable
{
  public AbsVasProfileHeaderComponent$6(baik parambaik) {}
  
  public void run()
  {
    Object localObject = ((anyw)baik.q(this.this$0).getManager(51)).b(baik.r(this.this$0).getCurrentAccountUin());
    if (localObject == null) {
      baik.a(this.this$0, "-1");
    }
    for (;;)
    {
      baik.a(this.this$0, "-1");
      return;
      if (((Card)localObject).lCurrentStyleId == azxy.a)
      {
        localObject = (QZoneCover)baik.s(this.this$0).a().createEntityManager().find(QZoneCover.class, baik.t(this.this$0).getCurrentAccountUin());
        if (localObject != null) {
          baik.a(this.this$0, ((QZoneCover)localObject).type);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent.6
 * JD-Core Version:    0.7.0.1
 */