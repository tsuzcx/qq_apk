package dov.com.qq.im.ae.biz.qcircle;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AECircleAlbumListFragment$1
  implements View.OnClickListener
{
  AECircleAlbumListFragment$1(AECircleAlbumListFragment paramAECircleAlbumListFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.AECircleAlbumListFragment.1
 * JD-Core Version:    0.7.0.1
 */