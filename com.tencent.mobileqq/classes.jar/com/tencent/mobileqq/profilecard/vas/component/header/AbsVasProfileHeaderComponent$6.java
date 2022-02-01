package com.tencent.mobileqq.profilecard.vas.component.header;

import amsw;
import aymn;
import ayyb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.persistence.EntityManager;

public class AbsVasProfileHeaderComponent$6
  implements Runnable
{
  public AbsVasProfileHeaderComponent$6(ayyb paramayyb) {}
  
  public void run()
  {
    Object localObject = ((amsw)ayyb.q(this.this$0).getManager(51)).b(ayyb.r(this.this$0).getCurrentAccountUin());
    if (localObject == null) {
      ayyb.a(this.this$0, "-1");
    }
    for (;;)
    {
      ayyb.a(this.this$0, "-1");
      return;
      if (((Card)localObject).lCurrentStyleId == aymn.a)
      {
        localObject = (QZoneCover)ayyb.s(this.this$0).getEntityManagerFactory().createEntityManager().find(QZoneCover.class, ayyb.t(this.this$0).getCurrentAccountUin());
        if (localObject != null) {
          ayyb.a(this.this$0, ((QZoneCover)localObject).type);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent.6
 * JD-Core Version:    0.7.0.1
 */