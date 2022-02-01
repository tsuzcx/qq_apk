package com.tencent.tkd.topicsdk.mediaselector;

import android.widget.GridView;
import com.tencent.tkd.topicsdk.interfaces.IPermission.ISimpleCallback;
import com.tencent.tkd.topicsdk.widget.AlbumPermissionView;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/mediaselector/MediaSelectorPanel$3", "Lcom/tencent/tkd/topicsdk/interfaces/IPermission$ISimpleCallback;", "onPermissionDenied", "", "onPermissionGranted", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class MediaSelectorPanel$3
  implements IPermission.ISimpleCallback
{
  public void a()
  {
    MediaSelectorPanel.a(this.a).setVisibility(0);
    this.a.a().setVisibility(8);
    this.a.b();
  }
  
  public void b()
  {
    MediaSelectorPanel.a(this.a).setVisibility(8);
    this.a.a().setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.MediaSelectorPanel.3
 * JD-Core Version:    0.7.0.1
 */