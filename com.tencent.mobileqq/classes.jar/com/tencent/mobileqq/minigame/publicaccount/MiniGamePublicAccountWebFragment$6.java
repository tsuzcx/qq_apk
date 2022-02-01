package com.tencent.mobileqq.minigame.publicaccount;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import bivu;

class MiniGamePublicAccountWebFragment$6
  implements bivu
{
  MiniGamePublicAccountWebFragment$6(MiniGamePublicAccountWebFragment paramMiniGamePublicAccountWebFragment) {}
  
  public void onItemLonClick(View paramView, int paramInt) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if (paramInt == 5) {
      MiniGamePublicAccountWebFragment.access$1500(this.this$0);
    }
    while (paramInt != 1) {
      return;
    }
    MiniGamePublicAccountWebFragment.access$1600(this.this$0);
    this.this$0.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment.6
 * JD-Core Version:    0.7.0.1
 */