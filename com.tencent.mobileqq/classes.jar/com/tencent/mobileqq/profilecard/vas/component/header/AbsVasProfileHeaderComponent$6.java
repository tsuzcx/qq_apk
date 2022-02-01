package com.tencent.mobileqq.profilecard.vas.component.header;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;

class AbsVasProfileHeaderComponent$6
  implements Runnable
{
  AbsVasProfileHeaderComponent$6(AbsVasProfileHeaderComponent paramAbsVasProfileHeaderComponent) {}
  
  public void run()
  {
    Object localObject = ((FriendsManager)AbsVasProfileHeaderComponent.access$3500(this.this$0).getManager(QQManagerFactory.FRIENDS_MANAGER)).f(AbsVasProfileHeaderComponent.access$3600(this.this$0).getCurrentAccountUin());
    if (localObject == null)
    {
      AbsVasProfileHeaderComponent.access$3702(this.this$0, "-1");
    }
    else if (((Card)localObject).lCurrentStyleId == ProfileCardTemplate.DEFAULT_PROFILE_CARD_STYLE_ID)
    {
      localObject = (QZoneCover)AbsVasProfileHeaderComponent.access$3800(this.this$0).getEntityManagerFactory().createEntityManager().find(QZoneCover.class, AbsVasProfileHeaderComponent.access$3900(this.this$0).getCurrentAccountUin());
      if (localObject != null) {
        AbsVasProfileHeaderComponent.access$3702(this.this$0, ((QZoneCover)localObject).type);
      }
    }
    AbsVasProfileHeaderComponent.access$3702(this.this$0, "-1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent.6
 * JD-Core Version:    0.7.0.1
 */