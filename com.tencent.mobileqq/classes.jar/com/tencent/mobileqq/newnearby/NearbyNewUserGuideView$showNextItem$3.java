package com.tencent.mobileqq.newnearby;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class NearbyNewUserGuideView$showNextItem$3
  implements Runnable
{
  NearbyNewUserGuideView$showNextItem$3(NearbyNewUserGuideView paramNearbyNewUserGuideView, NearbyNewUserGuideView.Config paramConfig) {}
  
  public final void run()
  {
    ViewGroup localViewGroup = NearbyNewUserGuideView.a(this.this$0);
    Object localObject = NearbyNewUserGuideView.a(this.this$0).getLayoutParams();
    if (localObject != null)
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).setMargins(this.a.a() + (this.a.c() - NearbyNewUserGuideView.a(this.this$0).getWidth()) / 2, 0, 0, 0);
      localViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.NearbyNewUserGuideView.showNextItem.3
 * JD-Core Version:    0.7.0.1
 */