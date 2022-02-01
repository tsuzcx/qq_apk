package com.tencent.mobileqq.profilecard.vas.component.header;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.profile.ProfileCardTemplate;

class AbsVasProfileHeaderComponent$6
  implements Runnable
{
  AbsVasProfileHeaderComponent$6(AbsVasProfileHeaderComponent paramAbsVasProfileHeaderComponent) {}
  
  public void run()
  {
    Object localObject = ((FriendsManager)AbsVasProfileHeaderComponent.access$6100(this.this$0).getManager(QQManagerFactory.FRIENDS_MANAGER)).a(AbsVasProfileHeaderComponent.access$6200(this.this$0).getCurrentAccountUin());
    if (localObject == null) {
      AbsVasProfileHeaderComponent.access$6302(this.this$0, "-1");
    }
    for (;;)
    {
      AbsVasProfileHeaderComponent.access$6302(this.this$0, "-1");
      return;
      if (((Card)localObject).lCurrentStyleId == ProfileCardTemplate.a)
      {
        localObject = (QZoneCover)AbsVasProfileHeaderComponent.access$6400(this.this$0).getEntityManagerFactory().createEntityManager().find(QZoneCover.class, AbsVasProfileHeaderComponent.access$6500(this.this$0).getCurrentAccountUin());
        if (localObject != null) {
          AbsVasProfileHeaderComponent.access$6302(this.this$0, ((QZoneCover)localObject).type);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent.6
 * JD-Core Version:    0.7.0.1
 */