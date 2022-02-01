package com.tencent.mobileqq.minigame.publicaccount;

import com.tencent.mobileqq.minigame.publicaccount.adapter.BaseHeaderAdapter;

class MiniGamePublicAccountWebFragment$2
  implements MiniGamePublicAccountViewPagerIndicator.OnPageSelectedListener
{
  MiniGamePublicAccountWebFragment$2(MiniGamePublicAccountWebFragment paramMiniGamePublicAccountWebFragment) {}
  
  public void onPageSelected(int paramInt)
  {
    this.this$0.pagerAdapter.initArk(paramInt);
    MiniGamePublicAccountWebFragment.access$400(this.this$0, paramInt, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment.2
 * JD-Core Version:    0.7.0.1
 */