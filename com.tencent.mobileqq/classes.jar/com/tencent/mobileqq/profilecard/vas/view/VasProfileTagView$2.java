package com.tencent.mobileqq.profilecard.vas.view;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import java.util.List;

class VasProfileTagView$2
  implements Runnable
{
  VasProfileTagView$2(VasProfileTagView paramVasProfileTagView, ProfileCardInfo paramProfileCardInfo) {}
  
  public void run()
  {
    List localList = this.val$cardInfo.a.getLabelList();
    VasProfileTagView.access$1000(this.this$0).runOnUiThread(new VasProfileTagView.2.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView.2
 * JD-Core Version:    0.7.0.1
 */