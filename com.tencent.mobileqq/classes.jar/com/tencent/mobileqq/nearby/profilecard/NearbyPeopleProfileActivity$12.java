package com.tencent.mobileqq.nearby.profilecard;

import android.text.TextUtils;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.Setting;
import com.tencent.qphone.base.util.QLog;

class NearbyPeopleProfileActivity$12
  extends AvatarObserver
{
  NearbyPeopleProfileActivity$12(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void onGetHeadInfo(boolean paramBoolean, Setting paramSetting)
  {
    if ((paramSetting == null) || (NearbyPeopleProfileActivity.a(this.a) == null) || (!TextUtils.equals(NearbyPeopleProfileActivity.a(this.a).uin, paramSetting.uin))) {
      return;
    }
    if ((paramSetting.bFaceFlags & 0x20) != 0) {
      this.a.l = 0;
    }
    for (;;)
    {
      this.a.c = paramSetting.url;
      if (NearbyPeopleProfileActivity.a(this.a) != null) {
        NearbyPeopleProfileActivity.a(this.a).k();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.nearby_people_card.", 2, "onGetHeadInfo mheadSize is: " + this.a.l + " mGetHeadUrl is: " + this.a.c);
      return;
      if ((paramSetting.bFaceFlags & 0x10) != 0) {
        this.a.l = 640;
      } else if ((paramSetting.bFaceFlags & 0x8) != 0) {
        this.a.l = 140;
      } else if ((paramSetting.bFaceFlags & 0x4) != 0) {
        this.a.l = 100;
      } else {
        this.a.l = 40;
      }
    }
  }
  
  public void onUpdateStrangerHead(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "onUpdateStangerHead: " + paramBoolean1 + "isStrangerHead: " + paramBoolean2);
    }
    if ((paramBoolean1) && (!TextUtils.isEmpty(paramString)) && (NearbyPeopleProfileActivity.a(this.a) != null) && (paramString.equals(NearbyPeopleProfileActivity.a(this.a).uin)) && (paramBoolean2) && ((this.a.l == 640) || (this.a.l == 0)) && (!TextUtils.isEmpty(this.a.c)) && (!this.a.h)) {
      this.a.a(paramString, this.a.l, this.a.c, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.12
 * JD-Core Version:    0.7.0.1
 */