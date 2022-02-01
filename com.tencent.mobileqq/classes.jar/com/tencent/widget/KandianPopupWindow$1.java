package com.tencent.widget;

import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;

class KandianPopupWindow$1
  implements PopupWindow.OnDismissListener
{
  KandianPopupWindow$1(KandianPopupWindow paramKandianPopupWindow) {}
  
  public void onDismiss()
  {
    KandianPopupWindow localKandianPopupWindow = this.a;
    localKandianPopupWindow.jdField_a_of_type_ComTencentWidgetKandianPopupWindow$OnUninterestConfirmListener = null;
    localKandianPopupWindow.jdField_a_of_type_ComTencentWidgetKandianPopupWindow$OnComplainListener = null;
    localKandianPopupWindow.c();
    ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).setIsShowPopup(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.KandianPopupWindow.1
 * JD-Core Version:    0.7.0.1
 */