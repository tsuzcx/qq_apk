package com.tencent.tkd.topicsdk.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.tkd.topicsdk.common.PermissionUtils;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class AlbumPermissionView$2
  implements View.OnClickListener
{
  AlbumPermissionView$2(AlbumPermissionView paramAlbumPermissionView) {}
  
  public final void onClick(View paramView)
  {
    PermissionUtils.a.a(AlbumPermissionView.a(this.a), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.AlbumPermissionView.2
 * JD-Core Version:    0.7.0.1
 */