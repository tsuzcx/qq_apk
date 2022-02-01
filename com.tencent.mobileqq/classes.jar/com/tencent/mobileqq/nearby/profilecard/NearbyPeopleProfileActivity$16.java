package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.qphone.base.util.QLog;

class NearbyPeopleProfileActivity$16
  extends HotChatObserver
{
  NearbyPeopleProfileActivity$16(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void b(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDismissHotChat.isSuccess=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",groupcode=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",result=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",strError=");
      localStringBuilder.append(paramString2);
      QLog.i("NearbyPeopleProfileActivity", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (paramInt == 0) && (NearbyPeopleProfileActivity.access$300(this.a) != null) && (NearbyPeopleProfileActivity.access$300(this.a).hotInfo != null) && (paramString1 != null) && (paramString1.equals(NearbyPeopleProfileActivity.access$300(this.a).hotInfo.troopUin)) && (NearbyPeopleProfileActivity.access$500(this.a) != null))
    {
      NearbyPeopleProfileActivity.access$300(this.a).strHotChatInfo = "";
      NearbyPeopleProfileActivity.access$300(this.a).hotInfo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.16
 * JD-Core Version:    0.7.0.1
 */