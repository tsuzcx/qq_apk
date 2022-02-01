package com.tencent.mobileqq.nearby.now.view.viewmodel;

import android.text.TextUtils;
import awhw;
import awrs;
import awur;
import awvu;
import bcek;

public class PlayOperationViewModel$9$1
  implements Runnable
{
  public PlayOperationViewModel$9$1(awvu paramawvu, awhw paramawhw) {}
  
  public void run()
  {
    bcek localbcek = new bcek(this.jdField_a_of_type_Awvu.a.a).a("dc00899").b("grp_lbs").c("video").d("playpage_like_click").e(awrs.d);
    int i = this.jdField_a_of_type_Awhw.b();
    String str2 = awrs.a;
    if (TextUtils.equals(awrs.a, "2")) {}
    for (String str1 = awrs.c;; str1 = "")
    {
      localbcek.a(new String[] { "", String.valueOf(i), str2, str1 }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.9.1
 * JD-Core Version:    0.7.0.1
 */