package com.tencent.mobileqq.nearby.profilecard;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.mobileqq.widget.QQToast;

class NearbyProfileDisplayPanel$40
  extends Handler
{
  NearbyProfileDisplayPanel$40(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 6: 
      if (this.a.x != null)
      {
        this.a.x.a();
        return;
      }
      break;
    case 5: 
      QQToast.makeText(this.a.e, 2131897192, 0).show();
      return;
    case 4: 
      if ((this.a.x != null) && (this.a.f != null))
      {
        if (this.a.y != null) {
          this.a.y.setText(2131896715);
        }
        this.a.x.a(this.a.f.uRoomid);
        ReportController.b(this.a.e.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "install_bootstrap", 0, 0, String.valueOf(this.a.f.tinyId), "", "yes", "android");
        return;
      }
      break;
    case 3: 
      if (this.a.y != null)
      {
        this.a.y.setProgress(100);
        return;
      }
      break;
    case 2: 
      if (this.a.y != null)
      {
        this.a.y.setProgress(paramMessage.arg1);
        return;
      }
      break;
    case 1: 
      if (this.a.y != null) {
        this.a.y.setText(2131897195);
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.40
 * JD-Core Version:    0.7.0.1
 */