package com.tencent.mobileqq.minigame.publicaccount.hippy;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/minigame/publicaccount/hippy/MiniGamePAHippyFragment$setNavBar$1$1", "Lcom/tencent/mobileqq/widget/navbar/OnItemSelectListener;", "onItemLonClick", "", "v", "Landroid/view/View;", "item", "", "onItemSelect", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class MiniGamePAHippyFragment$setNavBar$$inlined$run$lambda$1
  implements OnItemSelectListener
{
  MiniGamePAHippyFragment$setNavBar$$inlined$run$lambda$1(MiniGamePAHippyFragment paramMiniGamePAHippyFragment) {}
  
  public void onItemLonClick(@Nullable View paramView, int paramInt) {}
  
  public void onItemSelect(@Nullable View paramView, int paramInt)
  {
    if (paramInt == 5)
    {
      MiniGamePAHippyFragment.access$gotoAccountDetail(this.this$0);
      return;
    }
    if (paramInt == 1)
    {
      paramView = this.this$0.getActivity();
      if (paramView == null) {
        Intrinsics.throwNpe();
      }
      paramView.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyFragment.setNavBar..inlined.run.lambda.1
 * JD-Core Version:    0.7.0.1
 */