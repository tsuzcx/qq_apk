package com.tencent.mobileqq.tribe.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import azbq;

class TribeVideoListPlayerFragment$27
  implements Runnable
{
  TribeVideoListPlayerFragment$27(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public void run()
  {
    azbq localazbq = (azbq)((View)this.this$0.a).getTag();
    if (localazbq == null) {
      return;
    }
    switch (TribeVideoListPlayerFragment.a(this.this$0).a)
    {
    default: 
      return;
    case 0: 
      localazbq.j.setVisibility(0);
      localazbq.i.setVisibility(8);
      localazbq.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    case 1: 
      localazbq.f.setVisibility(0);
      localazbq.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      localazbq.a.setVisibility(8);
      return;
    }
    localazbq.h.setVisibility(0);
    localazbq.g.setVisibility(8);
    localazbq.d.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.27
 * JD-Core Version:    0.7.0.1
 */