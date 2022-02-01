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
  
  protected void onGetHeadInfo(boolean paramBoolean, Setting paramSetting)
  {
    if ((paramSetting != null) && (NearbyPeopleProfileActivity.access$300(this.a) != null))
    {
      if (!TextUtils.equals(NearbyPeopleProfileActivity.access$300(this.a).uin, paramSetting.uin)) {
        return;
      }
      if ((paramSetting.bFaceFlags & 0x20) != 0) {
        this.a.mHeadSize = 0;
      } else if ((paramSetting.bFaceFlags & 0x10) != 0) {
        this.a.mHeadSize = 640;
      } else if ((paramSetting.bFaceFlags & 0x8) != 0) {
        this.a.mHeadSize = 140;
      } else if ((paramSetting.bFaceFlags & 0x4) != 0) {
        this.a.mHeadSize = 100;
      } else {
        this.a.mHeadSize = 40;
      }
      this.a.mGetHeadUrl = paramSetting.url;
      if (NearbyPeopleProfileActivity.access$500(this.a) != null) {
        NearbyPeopleProfileActivity.access$500(this.a).k();
      }
      if (QLog.isColorLevel())
      {
        paramSetting = new StringBuilder();
        paramSetting.append("onGetHeadInfo mheadSize is: ");
        paramSetting.append(this.a.mHeadSize);
        paramSetting.append(" mGetHeadUrl is: ");
        paramSetting.append(this.a.mGetHeadUrl);
        QLog.i("NearbyPeopleProfileActivity", 2, paramSetting.toString());
      }
    }
  }
  
  protected void onUpdateStrangerHead(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdateStangerHead: ");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append("isStrangerHead: ");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.i("NearbyPeopleProfileActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramBoolean1) && (!TextUtils.isEmpty(paramString)) && (NearbyPeopleProfileActivity.access$300(this.a) != null) && (paramString.equals(NearbyPeopleProfileActivity.access$300(this.a).uin)) && (paramBoolean2) && ((this.a.mHeadSize == 640) || (this.a.mHeadSize == 0)) && (!TextUtils.isEmpty(this.a.mGetHeadUrl)) && (!this.a.mHasNewPhoto))
    {
      localObject = this.a;
      ((NearbyPeopleProfileActivity)localObject).downloadHDAvatar(paramString, ((NearbyPeopleProfileActivity)localObject).mHeadSize, this.a.mGetHeadUrl, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.12
 * JD-Core Version:    0.7.0.1
 */