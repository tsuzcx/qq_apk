package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

class NearbyPeopleProfileActivity$3
  implements Runnable
{
  NearbyPeopleProfileActivity$3(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void run()
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
      return;
    }
    if (NearbyPeopleProfileActivity.access$300(this.this$0) == null) {
      return;
    }
    byte[] arrayOfByte = NearbyPeopleProfileActivity.access$300(this.this$0).vSeed;
    long l = NearbyPeopleProfileActivity.access$300(this.this$0).feedPreviewTime;
    if (NearbyPeopleProfileActivity.access$300(this.this$0).isHostSelf)
    {
      NearbyProfileUtil.a(this.this$0.mCardHandler, this.this$0.app, 0L, this.this$0.allinone.uin, this.this$0.fetchFromType, arrayOfByte, l, true, this.this$0.allinone.likeSource, NearbyPeopleProfileActivity.isFromTribe(this.this$0.from), NearbyPeopleProfileActivity.access$100(this.this$0), NearbyPeopleProfileActivity.access$000(this.this$0));
      return;
    }
    if (this.this$0.mTinyId > 0L) {
      NearbyProfileUtil.a(this.this$0.mCardHandler, this.this$0.app, this.this$0.mTinyId, null, this.this$0.fetchFromType, arrayOfByte, l, true, this.this$0.allinone.likeSource, NearbyPeopleProfileActivity.isFromTribe(this.this$0.from), NearbyPeopleProfileActivity.access$100(this.this$0), NearbyPeopleProfileActivity.access$000(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.3
 * JD-Core Version:    0.7.0.1
 */