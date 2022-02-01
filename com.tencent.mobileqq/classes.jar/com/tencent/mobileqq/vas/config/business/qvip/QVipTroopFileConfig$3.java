package com.tencent.mobileqq.vas.config.business.qvip;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.vas.api.IVasH5PayUtil;

class QVipTroopFileConfig$3
  implements DialogInterface.OnClickListener
{
  QVipTroopFileConfig$3(QVipTroopFileConfig paramQVipTroopFileConfig, Context paramContext, boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject2 = (IVasH5PayUtil)QRoute.api(IVasH5PayUtil.class);
    Context localContext = this.a;
    Object localObject1;
    if (this.b) {
      localObject1 = this.e.h;
    } else {
      localObject1 = this.e.i;
    }
    ((IVasH5PayUtil)localObject2).openH5PayByURL(localContext, ((QVipTroopFileConfig.Info)localObject1).a(this.c));
    paramDialogInterface.dismiss();
    if (this.b) {
      paramDialogInterface = "0X800AE6A";
    } else {
      paramDialogInterface = "0X800AE64";
    }
    localObject2 = this.c;
    if (this.d) {
      localObject1 = "size";
    } else {
      localObject1 = "full";
    }
    QVipTroopFileConfig.a(paramDialogInterface, (String)localObject2, (String)localObject1);
    localObject2 = (IMobileReportManager)QRoute.api(IMobileReportManager.class);
    if (this.b) {
      paramDialogInterface = "2";
    } else {
      paramDialogInterface = "3";
    }
    if (this.b) {
      localObject1 = "2";
    } else {
      localObject1 = "1";
    }
    ((IMobileReportManager)localObject2).reportAction("Open", "4", "platform898", paramDialogInterface, (String)localObject1, 102, 1, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipTroopFileConfig.3
 * JD-Core Version:    0.7.0.1
 */