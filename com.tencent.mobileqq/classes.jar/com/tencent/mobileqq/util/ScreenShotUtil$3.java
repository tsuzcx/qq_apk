package com.tencent.mobileqq.util;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.ocr.view.TDProgressDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.atomic.AtomicBoolean;

final class ScreenShotUtil$3
  implements View.OnClickListener
{
  ScreenShotUtil$3(AtomicBoolean paramAtomicBoolean, TDProgressDialog paramTDProgressDialog) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewTDProgressDialog.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.ScreenShotUtil.3
 * JD-Core Version:    0.7.0.1
 */