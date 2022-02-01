package com.tencent.mobileqq.minigame.publicaccount;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.minigame.publicaccount.view.MiniGamePubViewpager;

class MiniGamePublicAccountWebFragment$9
  implements Runnable
{
  MiniGamePublicAccountWebFragment$9(MiniGamePublicAccountWebFragment paramMiniGamePublicAccountWebFragment, int paramInt) {}
  
  public void run()
  {
    if ((this.this$0.getActivity() != null) && (!this.this$0.getActivity().isFinishing()) && (this.this$0.viewPager != null)) {
      this.this$0.viewPager.setCurrentItem(this.val$pos);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment.9
 * JD-Core Version:    0.7.0.1
 */