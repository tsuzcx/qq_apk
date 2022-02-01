package com.tencent.mobileqq.nearby.profilecard;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ProfilePerformanceReport;

class NearbyPeopleProfileActivity$2
  implements Runnable
{
  NearbyPeopleProfileActivity$2(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity, ProfilePerformanceReport paramProfilePerformanceReport) {}
  
  public void run()
  {
    Object localObject1 = this.a;
    if ((localObject1 != null) && (((ProfilePerformanceReport)localObject1).a()))
    {
      this.a.b(4);
      this.a.a(5);
      this.a.a(8);
    }
    Object localObject4 = this.this$0.app.getEntityManagerFactory().createEntityManager();
    Object localObject3 = null;
    long l;
    if (localObject4 != null)
    {
      if (NearbyPeopleProfileActivity.access$000(this.this$0) == 0)
      {
        if (this.this$0.mTinyId > 0L) {
          localObject2 = (NearbyPeopleCard)((EntityManager)localObject4).find(NearbyPeopleCard.class, "tinyId=?", new String[] { String.valueOf(this.this$0.mTinyId) });
        } else {
          localObject2 = null;
        }
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!StringUtil.isEmpty(this.this$0.allinone.uin)) {
            localObject1 = (NearbyPeopleCard)((EntityManager)localObject4).find(NearbyPeopleCard.class, "uin=?", new String[] { this.this$0.allinone.uin });
          }
        }
      }
      else if (NearbyPeopleProfileActivity.access$100(this.this$0) > 0L)
      {
        localObject1 = (NearbyPeopleCard)((EntityManager)localObject4).find(NearbyPeopleCard.class, "nowId=?", new String[] { String.valueOf(NearbyPeopleProfileActivity.access$100(this.this$0)) });
      }
      else
      {
        localObject1 = null;
      }
      ((EntityManager)localObject4).close();
      if (localObject1 != null)
      {
        localObject2 = ((NearbyPeopleCard)localObject1).vSeed;
        l = ((NearbyPeopleCard)localObject1).feedPreviewTime;
        bool1 = true;
      }
      else
      {
        l = 0L;
        bool1 = false;
        localObject2 = localObject3;
      }
      if (this.this$0.mMode != 1)
      {
        localObject3 = localObject1;
        if (localObject1 == null)
        {
          localObject3 = new NearbyPeopleCard();
          ((NearbyPeopleCard)localObject3).tinyId = this.this$0.mTinyId;
          ((NearbyPeopleCard)localObject3).uin = this.this$0.allinone.uin;
        }
        if ((!TextUtils.isEmpty(this.this$0.allinone.nickname)) && (TextUtils.isEmpty(((NearbyPeopleCard)localObject3).nickname))) {
          ((NearbyPeopleCard)localObject3).nickname = this.this$0.allinone.nickname;
        }
        if (NearbyPeopleProfileActivity.isFromTribe(this.this$0.from))
        {
          if (this.this$0.allinone.age != -1) {
            ((NearbyPeopleCard)localObject3).age = this.this$0.allinone.age;
          }
          if (this.this$0.allinone.gender != -1) {
            ((NearbyPeopleCard)localObject3).gender = this.this$0.allinone.gender;
          }
          if (this.this$0.allinone.constellation != 0) {
            ((NearbyPeopleCard)localObject3).constellation = this.this$0.allinone.constellation;
          }
        }
        if (this.this$0.allinone.maritalStatus != 0) {
          ((NearbyPeopleCard)localObject3).maritalStatus = this.this$0.allinone.maritalStatus;
        }
        if (this.this$0.allinone.professionId != 0) {
          ((NearbyPeopleCard)localObject3).job = this.this$0.allinone.professionId;
        }
        if (!TextUtils.isEmpty(this.this$0.allinone.distanceTime)) {
          ((NearbyPeopleCard)localObject3).aioDistanceAndTime = this.this$0.allinone.distanceTime;
        }
        this.this$0.mUin = ((NearbyPeopleCard)localObject3).uin;
        localObject1 = (INearbyCardManager)this.this$0.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
        localObject4 = this.this$0.app.getCurrentAccountUin();
        boolean bool3 = this.this$0.mIsFromWeb;
        if (this.this$0.from == -1) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        boolean bool2 = ((INearbyCardManager)localObject1).a(localObject3, (String)localObject4, bool3, bool2, this.this$0.fetchFromType, bool1);
        localObject1 = this.this$0.getIntent();
        bool1 = bool2;
        if (localObject1 != null)
        {
          bool1 = bool2;
          if (((Intent)localObject1).getIntExtra("refresh_flag", 0) == 1) {
            bool1 = true;
          }
        }
        if (!bool1) {
          this.this$0.mHandler.obtainMessage(101, localObject3).sendToTarget();
        }
        if (QLog.isDevelopLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("isNeedUpdateNearbyCard tinyid is: ");
          ((StringBuilder)localObject1).append(((NearbyPeopleCard)localObject3).tinyId);
          ((StringBuilder)localObject1).append(" uin is: ");
          ((StringBuilder)localObject1).append(((NearbyPeopleCard)localObject3).uin);
          ((StringBuilder)localObject1).append(" ");
          ((StringBuilder)localObject1).append(bool1);
          QLog.i("NearbyPeopleProfileActivity", 4, ((StringBuilder)localObject1).toString());
        }
        localObject1 = localObject2;
        break label818;
      }
      localObject1 = localObject2;
    }
    else
    {
      localObject1 = null;
      l = 0L;
    }
    boolean bool1 = true;
    label818:
    if ((!NetworkUtil.isNetSupport(BaseApplication.getContext())) && (bool1))
    {
      this.this$0.runOnUiThread(new NearbyPeopleProfileActivity.2.1(this));
      return;
    }
    Object localObject2 = this.a;
    if ((localObject2 != null) && (((ProfilePerformanceReport)localObject2).a()))
    {
      this.a.a(6);
      this.a.a(9);
    }
    int i = (int)this.this$0.allinone.likeSource;
    if (this.this$0.allinone.likeSource == 1L) {
      i = 6;
    }
    if (this.this$0.mMode != 1)
    {
      if (bool1)
      {
        if (this.this$0.mTinyId > 0L) {
          NearbyProfileUtil.a(this.this$0.mCardHandler, this.this$0.app, this.this$0.mTinyId, null, this.this$0.fetchFromType, (byte[])localObject1, l, false, i, NearbyPeopleProfileActivity.isFromTribe(this.this$0.from), NearbyPeopleProfileActivity.access$100(this.this$0), NearbyPeopleProfileActivity.access$000(this.this$0));
        } else {
          NearbyProfileUtil.a(this.this$0.mCardHandler, this.this$0.app, 0L, this.this$0.allinone.uin, this.this$0.fetchFromType, (byte[])localObject1, l, false, i, NearbyPeopleProfileActivity.isFromTribe(this.this$0.from), NearbyPeopleProfileActivity.access$100(this.this$0), NearbyPeopleProfileActivity.access$000(this.this$0));
        }
        NearbyPeopleProfileActivity.access$200(this.this$0);
      }
    }
    else {
      NearbyProfileUtil.a(this.this$0.mCardHandler, this.this$0.app, 0L, this.this$0.app.getCurrentAccountUin(), this.this$0.fetchFromType, (byte[])localObject1, l, false, i, NearbyPeopleProfileActivity.isFromTribe(this.this$0.from), NearbyPeopleProfileActivity.access$100(this.this$0), NearbyPeopleProfileActivity.access$000(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.2
 * JD-Core Version:    0.7.0.1
 */