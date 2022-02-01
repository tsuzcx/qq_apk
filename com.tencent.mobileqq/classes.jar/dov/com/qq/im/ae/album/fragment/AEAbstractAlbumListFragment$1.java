package dov.com.qq.im.ae.album.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AEAbstractAlbumListFragment$1
  implements View.OnClickListener
{
  AEAbstractAlbumListFragment$1(AEAbstractAlbumListFragment paramAEAbstractAlbumListFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.fragment.AEAbstractAlbumListFragment.1
 * JD-Core Version:    0.7.0.1
 */