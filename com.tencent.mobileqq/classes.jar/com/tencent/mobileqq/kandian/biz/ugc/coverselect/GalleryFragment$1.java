package com.tencent.mobileqq.kandian.biz.ugc.coverselect;

import android.view.View;
import com.tencent.mobileqq.kandian.base.utils.AlbumUtils;
import com.tencent.mobileqq.kandian.base.utils.AlbumUtils.LocalMediaInfo;
import com.tencent.mobileqq.kandian.biz.ugc.PageLoadManager.QueryProvider;
import java.util.List;

class GalleryFragment$1
  implements PageLoadManager.QueryProvider<AlbumUtils.LocalMediaInfo>
{
  GalleryFragment$1(GalleryFragment paramGalleryFragment) {}
  
  public List<AlbumUtils.LocalMediaInfo> a(int paramInt1, int paramInt2)
  {
    return AlbumUtils.b(paramInt1, paramInt2);
  }
  
  public void a(List<AlbumUtils.LocalMediaInfo> paramList, boolean paramBoolean)
  {
    GalleryFragment.a(this.a).addAll(paramList);
    GalleryFragment.b(this.a).notifyDataSetChanged();
    if (GalleryFragment.a(this.a).isEmpty())
    {
      GalleryFragment.c(this.a).setVisibility(0);
      return;
    }
    GalleryFragment.c(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.GalleryFragment.1
 * JD-Core Version:    0.7.0.1
 */