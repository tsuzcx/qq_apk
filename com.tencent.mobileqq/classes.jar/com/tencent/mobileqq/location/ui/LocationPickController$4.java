package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LocationPickController$4
  implements View.OnClickListener
{
  LocationPickController$4(LocationPickController paramLocationPickController, Activity paramActivity, EditText paramEditText) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "myBtn onClick: invoked. set my btn black");
    }
    LocationPickController.e(this.c).setClickable(false);
    LocationPickController.e(this.c).setImageDrawable(this.a.getResources().getDrawable(2130841403));
    LocationPickController.c(this.c).a(true);
    LocationPickController localLocationPickController = this.c;
    LocationPickController.a(localLocationPickController, LocationPickController.c(localLocationPickController).getSelfLatlng());
    if (this.b.getText().length() > 0) {
      this.b.setText("");
    } else {
      this.c.a("");
    }
    ReportController.b(null, "CliOper", "", "", "0X800A771", "0X800A771", 0, 0, "", "0", "0", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickController.4
 * JD-Core Version:    0.7.0.1
 */