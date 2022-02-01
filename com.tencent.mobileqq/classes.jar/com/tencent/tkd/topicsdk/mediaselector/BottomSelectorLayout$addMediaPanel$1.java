package com.tencent.tkd.topicsdk.mediaselector;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.tkd.topicsdk.common.ViewKt;
import com.tencent.tkd.topicsdk.widget.AlbumPermissionView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class BottomSelectorLayout$addMediaPanel$1
  implements Runnable
{
  BottomSelectorLayout$addMediaPanel$1(BottomSelectorLayout paramBottomSelectorLayout, MediaSelectorPanel paramMediaSelectorPanel) {}
  
  public final void run()
  {
    Object localObject1 = this.this$0.getRootView();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "rootView");
    Object localObject2 = new RelativeLayout.LayoutParams(-1, ViewKt.c((View)localObject1));
    localObject1 = this.a.a();
    localObject2 = (ViewGroup.LayoutParams)localObject2;
    ((AlbumPermissionView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    this.a.a().setLayoutParams((ViewGroup.LayoutParams)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.BottomSelectorLayout.addMediaPanel.1
 * JD-Core Version:    0.7.0.1
 */