package com.tencent.mobileqq.profilecard.vas.component.header;

import anvk;
import azri;
import badm;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.persistence.EntityManager;

public class AbsVasProfileHeaderComponent$6
  implements Runnable
{
  public AbsVasProfileHeaderComponent$6(badm parambadm) {}
  
  public void run()
  {
    Object localObject = ((anvk)badm.q(this.this$0).getManager(QQManagerFactory.FRIENDS_MANAGER)).b(badm.r(this.this$0).getCurrentAccountUin());
    if (localObject == null) {
      badm.a(this.this$0, "-1");
    }
    for (;;)
    {
      badm.a(this.this$0, "-1");
      return;
      if (((Card)localObject).lCurrentStyleId == azri.a)
      {
        localObject = (QZoneCover)badm.s(this.this$0).getEntityManagerFactory().createEntityManager().find(QZoneCover.class, badm.t(this.this$0).getCurrentAccountUin());
        if (localObject != null) {
          badm.a(this.this$0, ((QZoneCover)localObject).type);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent.6
 * JD-Core Version:    0.7.0.1
 */