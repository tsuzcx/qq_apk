package com.tencent.tkd.topicsdk.widget.videocrop;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class VideoCropPage$initFinishView$1
  implements View.OnClickListener
{
  VideoCropPage$initFinishView$1(VideoCropPage paramVideoCropPage) {}
  
  public final void onClick(View paramView)
  {
    if (!VideoCropPage.a(this.a).b())
    {
      paramView = this.a;
      paramView.a(VideoCropPage.b(paramView).g(), "");
      return;
    }
    VideoCropPage.b(this.a).e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.videocrop.VideoCropPage.initFinishView.1
 * JD-Core Version:    0.7.0.1
 */