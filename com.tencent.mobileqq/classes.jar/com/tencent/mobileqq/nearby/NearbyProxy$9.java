package com.tencent.mobileqq.nearby;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import anvk;
import axpp;
import axqc;
import ayob;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.nearby.ipc.ConnectNearbyProcService;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;

public final class NearbyProxy$9
  implements Runnable
{
  public NearbyProxy$9(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject2 = (anvk)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject1 = ((anvk)localObject2).c(this.a.getCurrentAccountUin());
    if ((localObject1 != null) && (((Card)localObject1).iVoteIncrement > 0))
    {
      ((Card)localObject1).iVoteIncrement = 0;
      ((anvk)localObject2).a((Card)localObject1);
    }
    localObject2 = this.a.getEntityManagerFactory().createEntityManager();
    NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)((EntityManager)localObject2).find(NearbyPeopleCard.class, "uin=?", new String[] { this.a.getCurrentAccountUin() });
    if ((localNearbyPeopleCard != null) && (localNearbyPeopleCard.likeCountInc > 0))
    {
      localNearbyPeopleCard.likeCountInc = 0;
      ((EntityManager)localObject2).update(localNearbyPeopleCard);
    }
    ((EntityManager)localObject2).close();
    localObject2 = this.a.getAccount();
    long l;
    if (localObject1 == null)
    {
      l = 0L;
      axqc.a((String)localObject2, l, 0);
      this.a.getApp().getSharedPreferences(this.a.getCurrentAccountUin(), 0).edit().putInt("profilecard_host_last_newvote_animation_num", 0).commit();
      if (!ConnectNearbyProcService.a()) {
        break label212;
      }
      axpp.a(this.a.getNearbyProxy(), 4117);
    }
    label212:
    do
    {
      return;
      l = ((Card)localObject1).lVoteCount;
      break;
      localObject1 = ayob.a(this.a);
    } while (localObject1 == null);
    ((NearbyMyTabCard)localObject1).newLikeNum = 0;
    ayob.a(this.a, (NearbyMyTabCard)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyProxy.9
 * JD-Core Version:    0.7.0.1
 */