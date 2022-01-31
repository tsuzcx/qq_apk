package com.tencent.mobileqq.nearby.now.view.viewmodel;

import android.text.TextUtils;
import auqc;
import auzx;
import avcw;
import azmo;

public class PlayOperationViewModel$13
  implements Runnable
{
  public PlayOperationViewModel$13(avcw paramavcw, auqc paramauqc) {}
  
  public void run()
  {
    azmo localazmo = new azmo(this.this$0.a).a("dc00899").b("grp_lbs").c("video").d("playpage_label_click").e(auzx.d);
    int i = this.a.b();
    String str2 = auzx.a;
    if (TextUtils.equals(auzx.a, "2")) {}
    for (String str1 = auzx.c;; str1 = "")
    {
      localazmo.a(new String[] { "", String.valueOf(i), str2, str1 }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.13
 * JD-Core Version:    0.7.0.1
 */