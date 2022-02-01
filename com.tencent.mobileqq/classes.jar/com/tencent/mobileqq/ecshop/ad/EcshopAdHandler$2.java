package com.tencent.mobileqq.ecshop.ad;

import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.statistics.GdtImpressionPolicy.ReportListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

final class EcshopAdHandler$2
  implements GdtImpressionPolicy.ReportListener
{
  EcshopAdHandler$2(AppInterface paramAppInterface) {}
  
  public void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Ecshop_EcshopAdHandler", 1, "--> reportImpression");
    }
    if (paramView == null) {
      return;
    }
    paramView = paramView.getTag(2131430591);
    if (paramView != null) {
      ThreadManagerV2.executeOnSubThread(new EcshopAdHandler.2.1(this, paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.ad.EcshopAdHandler.2
 * JD-Core Version:    0.7.0.1
 */