package com.tencent.mobileqq.tribe.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import beey;

class TribeVideoListPlayerFragment$26
  implements Runnable
{
  TribeVideoListPlayerFragment$26(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public void run()
  {
    beey localbeey = (beey)((View)this.this$0.a).getTag();
    if (localbeey == null) {
      return;
    }
    switch (TribeVideoListPlayerFragment.a(this.this$0).a)
    {
    default: 
      return;
    case 0: 
      localbeey.j.setVisibility(0);
      localbeey.i.setVisibility(8);
      localbeey.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    case 1: 
      localbeey.f.setVisibility(0);
      localbeey.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      localbeey.a.setVisibility(8);
      return;
    }
    localbeey.h.setVisibility(0);
    localbeey.g.setVisibility(8);
    localbeey.d.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.26
 * JD-Core Version:    0.7.0.1
 */