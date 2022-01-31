package com.tencent.mobileqq.nearby;

import ajxl;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import atav;
import atbi;
import atys;
import aukp;
import aukq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.ipc.ConnectNearbyProcService;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.qphone.base.util.BaseApplication;

public final class NearbyProxy$9
  implements Runnable
{
  public NearbyProxy$9(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject2 = (ajxl)this.a.getManager(51);
    Object localObject1 = ((ajxl)localObject2).c(this.a.getCurrentAccountUin());
    if ((localObject1 != null) && (((Card)localObject1).iVoteIncrement > 0))
    {
      ((Card)localObject1).iVoteIncrement = 0;
      ((ajxl)localObject2).a((Card)localObject1);
    }
    localObject2 = this.a.getEntityManagerFactory().createEntityManager();
    NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)((aukp)localObject2).a(NearbyPeopleCard.class, "uin=?", new String[] { this.a.getCurrentAccountUin() });
    if ((localNearbyPeopleCard != null) && (localNearbyPeopleCard.likeCountInc > 0))
    {
      localNearbyPeopleCard.likeCountInc = 0;
      ((aukp)localObject2).a(localNearbyPeopleCard);
    }
    ((aukp)localObject2).a();
    localObject2 = this.a.getAccount();
    long l;
    if (localObject1 == null)
    {
      l = 0L;
      atbi.a((String)localObject2, l, 0);
      this.a.getApp().getSharedPreferences(this.a.getCurrentAccountUin(), 0).edit().putInt("profilecard_host_last_newvote_animation_num", 0).commit();
      if (!ConnectNearbyProcService.a()) {
        break label211;
      }
      atav.a(this.a.a(), 4117);
    }
    label211:
    do
    {
      return;
      l = ((Card)localObject1).lVoteCount;
      break;
      localObject1 = atys.a(this.a);
    } while (localObject1 == null);
    ((NearbyMyTabCard)localObject1).newLikeNum = 0;
    atys.a(this.a, (NearbyMyTabCard)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyProxy.9
 * JD-Core Version:    0.7.0.1
 */