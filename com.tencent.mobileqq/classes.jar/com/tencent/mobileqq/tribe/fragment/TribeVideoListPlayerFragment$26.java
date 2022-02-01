package com.tencent.mobileqq.tribe.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class TribeVideoListPlayerFragment$26
  implements Runnable
{
  TribeVideoListPlayerFragment$26(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public void run()
  {
    TribeVideoListPlayerFragment.VideoViewHolder localVideoViewHolder = (TribeVideoListPlayerFragment.VideoViewHolder)((View)this.this$0.a).getTag();
    if (localVideoViewHolder == null) {
      return;
    }
    switch (TribeVideoListPlayerFragment.a(this.this$0).a)
    {
    default: 
      return;
    case 0: 
      localVideoViewHolder.j.setVisibility(0);
      localVideoViewHolder.i.setVisibility(8);
      localVideoViewHolder.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    case 1: 
      localVideoViewHolder.f.setVisibility(0);
      localVideoViewHolder.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      localVideoViewHolder.a.setVisibility(8);
      return;
    }
    localVideoViewHolder.h.setVisibility(0);
    localVideoViewHolder.g.setVisibility(8);
    localVideoViewHolder.d.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.26
 * JD-Core Version:    0.7.0.1
 */