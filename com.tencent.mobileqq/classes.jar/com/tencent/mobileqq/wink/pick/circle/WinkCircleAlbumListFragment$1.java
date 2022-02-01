package com.tencent.mobileqq.wink.pick.circle;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WinkCircleAlbumListFragment$1
  implements View.OnClickListener
{
  WinkCircleAlbumListFragment$1(WinkCircleAlbumListFragment paramWinkCircleAlbumListFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.WinkCircleAlbumListFragment.1
 * JD-Core Version:    0.7.0.1
 */