package dov.com.qq.im.ae.album.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogic;

class AEAbstractPhotoListFragment$4
  implements View.OnClickListener
{
  AEAbstractPhotoListFragment$4(AEAbstractPhotoListFragment paramAEAbstractPhotoListFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.a.c();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.fragment.AEAbstractPhotoListFragment.4
 * JD-Core Version:    0.7.0.1
 */