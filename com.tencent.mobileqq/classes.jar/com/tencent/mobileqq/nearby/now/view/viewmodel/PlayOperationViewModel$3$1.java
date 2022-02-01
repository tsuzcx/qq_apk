package com.tencent.mobileqq.nearby.now.view.viewmodel;

import android.text.TextUtils;
import axup;
import ayek;
import ayhj;
import ayif;
import bdlq;

public class PlayOperationViewModel$3$1
  implements Runnable
{
  public PlayOperationViewModel$3$1(ayif paramayif, axup paramaxup) {}
  
  public void run()
  {
    bdlq localbdlq = new bdlq(this.jdField_a_of_type_Ayif.a.a).a("dc00899").b("grp_lbs").c("video").d("playpage_double_click").e(ayek.d);
    int i = this.jdField_a_of_type_Axup.b();
    String str2 = ayek.a;
    if (TextUtils.equals(ayek.a, "2")) {}
    for (String str1 = ayek.c;; str1 = "")
    {
      localbdlq.a(new String[] { "", String.valueOf(i), str2, str1 }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.3.1
 * JD-Core Version:    0.7.0.1
 */