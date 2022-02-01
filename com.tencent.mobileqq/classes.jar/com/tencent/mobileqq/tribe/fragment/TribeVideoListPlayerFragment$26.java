package com.tencent.mobileqq.tribe.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bfdx;

class TribeVideoListPlayerFragment$26
  implements Runnable
{
  TribeVideoListPlayerFragment$26(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public void run()
  {
    bfdx localbfdx = (bfdx)((View)this.this$0.a).getTag();
    if (localbfdx == null) {
      return;
    }
    switch (TribeVideoListPlayerFragment.a(this.this$0).a)
    {
    default: 
      return;
    case 0: 
      localbfdx.j.setVisibility(0);
      localbfdx.i.setVisibility(8);
      localbfdx.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    case 1: 
      localbfdx.f.setVisibility(0);
      localbfdx.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      localbfdx.a.setVisibility(8);
      return;
    }
    localbfdx.h.setVisibility(0);
    localbfdx.g.setVisibility(8);
    localbfdx.d.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.26
 * JD-Core Version:    0.7.0.1
 */