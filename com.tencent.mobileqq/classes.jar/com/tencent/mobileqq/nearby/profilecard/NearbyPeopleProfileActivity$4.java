package com.tencent.mobileqq.nearby.profilecard;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.util.ProfilePerformanceReport;

class NearbyPeopleProfileActivity$4
  extends Handler
{
  NearbyPeopleProfileActivity$4(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 101: 
    case 100: 
      do
      {
        do
        {
          return;
          this.a.b();
          ProfilePerformanceReport localProfilePerformanceReport = ProfilePerformanceReport.a;
          if ((localProfilePerformanceReport != null) && (localProfilePerformanceReport.a())) {
            localProfilePerformanceReport.b(5);
          }
        } while (paramMessage.obj == null);
        paramMessage = (NearbyPeopleCard)paramMessage.obj;
        this.a.b = true;
        this.a.a(paramMessage, true, false);
        return;
      } while (NearbyPeopleProfileActivity.a(this.a) == null);
      NearbyPeopleProfileActivity.a(this.a).b();
      return;
    case 102: 
      NearbyPeopleProfileActivity.a(this.a).b(paramMessage.arg1, paramMessage.arg2);
      return;
    case 202: 
      NearbyPeopleProfileActivity.a(this.a).a(true);
      this.a.a.sendEmptyMessageDelayed(203, 1500L);
      return;
    case 203: 
      NearbyPeopleProfileActivity.a(this.a).a(false);
      return;
    case 204: 
      this.a.a(this.a.getString(2131694444));
      return;
    case 207: 
      this.a.a(HardCodeUtil.a(2131707252));
      return;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.4
 * JD-Core Version:    0.7.0.1
 */