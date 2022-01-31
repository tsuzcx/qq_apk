package com.tencent.mobileqq.nearby.now.view.viewmodel;

import android.text.TextUtils;
import aszf;
import atix;
import atlw;
import atly;
import axrc;

public class PlayOperationViewModel$10$1
  implements Runnable
{
  public PlayOperationViewModel$10$1(atly paramatly, aszf paramaszf) {}
  
  public void run()
  {
    axrc localaxrc = new axrc(this.jdField_a_of_type_Atly.a.a).a("dc00899").b("grp_lbs").c("video").d("playpage_fw_click").e(atix.d);
    int i = this.jdField_a_of_type_Aszf.b();
    String str2 = atix.a;
    if (TextUtils.equals(atix.a, "2")) {}
    for (String str1 = atix.c;; str1 = "")
    {
      localaxrc.a(new String[] { "", String.valueOf(i), str2, str1 }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.10.1
 * JD-Core Version:    0.7.0.1
 */