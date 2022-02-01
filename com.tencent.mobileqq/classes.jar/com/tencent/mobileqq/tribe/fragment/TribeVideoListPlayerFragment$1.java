package com.tencent.mobileqq.tribe.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.tribe.playvideo.TribeVideoADItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.superplayer.api.ISuperPlayer;

class TribeVideoListPlayerFragment$1
  implements View.OnClickListener
{
  TribeVideoListPlayerFragment$1(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if ((this.a.jdField_a_of_type_Boolean) || (this.a.b))
    {
      if (!this.a.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isPlaying()) {
        break label132;
      }
      this.a.a(200);
      this.a.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.pause();
      this.a.c = true;
      localObject = (TribeVideoListPlayerFragment.BaseVideoViewHolder)((View)this.a.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag();
      if ((localObject instanceof TribeVideoListPlayerFragment.ADViewHolder))
      {
        localObject = ((TribeVideoListPlayerFragment.ADViewHolder)localObject).a;
        this.a.a((TribeVideoADItem)localObject, this.a.jdField_a_of_type_Long, this.a.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
    return;
    label132:
    if (this.a.b)
    {
      localObject = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent();
      if (localObject != null)
      {
        ((ViewGroup)localObject).removeView(this.a.jdField_a_of_type_AndroidWidgetRelativeLayout);
        this.a.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.stop();
        this.a.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.release();
      }
      localObject = (TribeVideoListPlayerFragment.BaseVideoViewHolder)((View)this.a.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag();
      this.a.a((TribeVideoListPlayerFragment.BaseVideoViewHolder)localObject);
    }
    for (;;)
    {
      this.a.c = false;
      break;
      this.a.b(200);
      this.a.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.start();
      this.a.b((TribeVideoListPlayerFragment.BaseVideoViewHolder)((View)this.a.jdField_a_of_type_ComTencentSuperplayerViewISPlayerVideoView).getTag());
      this.a.jdField_a_of_type_Long = this.a.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.1
 * JD-Core Version:    0.7.0.1
 */