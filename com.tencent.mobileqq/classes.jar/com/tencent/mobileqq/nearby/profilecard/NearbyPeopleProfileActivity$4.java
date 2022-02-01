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
    int i = paramMessage.what;
    if (i != 207) {
      switch (i)
      {
      default: 
        switch (i)
        {
        default: 
          return;
        case 205: 
          this.a.dismissWaittingDialog();
          return;
        case 204: 
          paramMessage = this.a;
          paramMessage.showWaitingDialog(paramMessage.getString(2131892088));
          return;
        case 203: 
          NearbyPeopleProfileActivity.access$400(this.a).a(false);
          return;
        }
        NearbyPeopleProfileActivity.access$400(this.a).a(true);
        this.a.mHandler.sendEmptyMessageDelayed(203, 1500L);
        return;
      case 102: 
        NearbyPeopleProfileActivity.access$400(this.a).a(paramMessage.arg1, paramMessage.arg2);
        return;
      case 101: 
        this.a.dismissWaittingDialog();
        Object localObject = ProfilePerformanceReport.a;
        if ((localObject != null) && (((ProfilePerformanceReport)localObject).a())) {
          ((ProfilePerformanceReport)localObject).b(5);
        }
        if (paramMessage.obj == null) {
          break;
        }
        paramMessage = (NearbyPeopleCard)paramMessage.obj;
        localObject = this.a;
        ((NearbyPeopleProfileActivity)localObject).mHasFetchedProfile = true;
        ((NearbyPeopleProfileActivity)localObject).handleNearbyProfileCard(paramMessage, true, false);
        return;
      case 100: 
        if (NearbyPeopleProfileActivity.access$300(this.a) == null) {
          break;
        }
        NearbyPeopleProfileActivity.access$300(this.a).e();
        return;
      }
    } else {
      this.a.showWaitingDialog(HardCodeUtil.a(2131905103));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.4
 * JD-Core Version:    0.7.0.1
 */