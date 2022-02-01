package com.tencent.mobileqq.nearby.api;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.NearbyManagerHelper;
import com.tencent.mobileqq.nearby.ipc.ConnectNearbyProcServiceUtils;
import com.tencent.mobileqq.nearpeople.api.INearbyMineHelper;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;

final class NearbyProxy$9
  implements Runnable
{
  NearbyProxy$9(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject2 = (FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject1 = ((FriendsManager)localObject2).b(this.a.getCurrentAccountUin());
    if ((localObject1 != null) && (((Card)localObject1).iVoteIncrement > 0))
    {
      ((Card)localObject1).iVoteIncrement = 0;
      ((FriendsManager)localObject2).a((Card)localObject1);
    }
    localObject2 = this.a.getEntityManagerFactory().createEntityManager();
    Object localObject3 = (NearbyPeopleCard)((EntityManager)localObject2).find(NearbyPeopleCard.class, "uin=?", new String[] { this.a.getCurrentAccountUin() });
    if ((localObject3 != null) && (((NearbyPeopleCard)localObject3).likeCountInc > 0))
    {
      ((NearbyPeopleCard)localObject3).likeCountInc = 0;
      ((EntityManager)localObject2).update((Entity)localObject3);
    }
    ((EntityManager)localObject2).close();
    localObject2 = (INearbySPUtil)QRoute.api(INearbySPUtil.class);
    localObject3 = this.a.getAccount();
    long l;
    if (localObject1 == null) {
      l = 0L;
    } else {
      l = ((Card)localObject1).lVoteCount;
    }
    ((INearbySPUtil)localObject2).setVoteInfo((String)localObject3, l, 0);
    this.a.getApp().getSharedPreferences(this.a.getCurrentAccountUin(), 0).edit().putInt("profilecard_host_last_newvote_animation_num", 0).commit();
    if (ConnectNearbyProcServiceUtils.a())
    {
      NearbyProxy.a((NearbyProxy)NearbyManagerHelper.a(this.a), 4117);
      return;
    }
    localObject1 = ((INearbyMineHelper)QRoute.api(INearbyMineHelper.class)).readNearbyMyTabCardFromLocal(this.a);
    if (localObject1 != null)
    {
      ((NearbyMyTabCard)localObject1).newLikeNum = 0;
      ((INearbyMineHelper)QRoute.api(INearbyMineHelper.class)).storeNearbyMyTabCard(this.a, (NearbyMyTabCard)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.NearbyProxy.9
 * JD-Core Version:    0.7.0.1
 */