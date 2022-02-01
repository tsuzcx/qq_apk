package com.tencent.mobileqq.nearby;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

final class NearbyCardManager$2
  implements DialogInterface.OnClickListener
{
  NearbyCardManager$2(String paramString, int paramInt, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new StringBuilder();
    paramDialogInterface.append(this.a);
    paramDialogInterface.append("&from=");
    paramDialogInterface.append(this.b);
    paramDialogInterface = paramDialogInterface.toString();
    Object localObject = new Intent(this.c, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramDialogInterface);
    this.c.startActivity((Intent)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("open download page, url=");
      ((StringBuilder)localObject).append(paramDialogInterface);
      QLog.d("Q.nearby.tribeAppDownload", 2, ((StringBuilder)localObject).toString());
    }
    paramInt = this.b;
    if (paramInt == 1)
    {
      ReportController.b(null, "dc00899", "grp_lbs", "", "app_down", "msg_down", 0, 0, "", "", "", "");
      return;
    }
    if (paramInt == 2) {
      ReportController.b(null, "dc00899", "grp_lbs", "", "app_down", "pic_down", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyCardManager.2
 * JD-Core Version:    0.7.0.1
 */