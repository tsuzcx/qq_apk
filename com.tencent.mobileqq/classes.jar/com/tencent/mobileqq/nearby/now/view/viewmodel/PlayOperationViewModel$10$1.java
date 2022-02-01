package com.tencent.mobileqq.nearby.now.view.viewmodel;

import android.text.TextUtils;
import axby;
import axlq;
import axop;
import axor;
import bcsy;

public class PlayOperationViewModel$10$1
  implements Runnable
{
  public PlayOperationViewModel$10$1(axor paramaxor, axby paramaxby) {}
  
  public void run()
  {
    bcsy localbcsy = new bcsy(this.jdField_a_of_type_Axor.a.a).a("dc00899").b("grp_lbs").c("video").d("playpage_fw_click").e(axlq.d);
    int i = this.jdField_a_of_type_Axby.b();
    String str2 = axlq.a;
    if (TextUtils.equals(axlq.a, "2")) {}
    for (String str1 = axlq.c;; str1 = "")
    {
      localbcsy.a(new String[] { "", String.valueOf(i), str2, str1 }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.10.1
 * JD-Core Version:    0.7.0.1
 */