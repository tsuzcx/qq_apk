package com.tencent.mobileqq.profilecard.vas.view;

import aymg;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Card;
import java.util.List;

class VasProfileTagView$2
  implements Runnable
{
  VasProfileTagView$2(VasProfileTagView paramVasProfileTagView, aymg paramaymg) {}
  
  public void run()
  {
    List localList = this.a.a.getLabelList();
    VasProfileTagView.a(this.this$0).runOnUiThread(new VasProfileTagView.2.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView.2
 * JD-Core Version:    0.7.0.1
 */