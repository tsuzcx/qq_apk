package com.tencent.mobileqq.minigame.publicaccount;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;

class MiniGamePublicAccountWebFragment$6
  implements OnItemSelectListener
{
  MiniGamePublicAccountWebFragment$6(MiniGamePublicAccountWebFragment paramMiniGamePublicAccountWebFragment) {}
  
  public void onItemLonClick(View paramView, int paramInt) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if (paramInt == 5)
    {
      MiniGamePublicAccountWebFragment.access$600(this.this$0);
      return;
    }
    if (paramInt == 1)
    {
      MiniGamePublicAccountWebFragment.access$700(this.this$0);
      this.this$0.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment.6
 * JD-Core Version:    0.7.0.1
 */