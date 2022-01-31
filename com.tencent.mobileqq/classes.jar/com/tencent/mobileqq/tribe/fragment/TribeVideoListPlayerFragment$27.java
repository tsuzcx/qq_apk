package com.tencent.mobileqq.tribe.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bazr;

class TribeVideoListPlayerFragment$27
  implements Runnable
{
  TribeVideoListPlayerFragment$27(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public void run()
  {
    bazr localbazr = (bazr)((View)this.this$0.a).getTag();
    if (localbazr == null) {
      return;
    }
    switch (TribeVideoListPlayerFragment.a(this.this$0).a)
    {
    default: 
      return;
    case 0: 
      localbazr.j.setVisibility(0);
      localbazr.i.setVisibility(8);
      localbazr.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    case 1: 
      localbazr.f.setVisibility(0);
      localbazr.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      localbazr.a.setVisibility(8);
      return;
    }
    localbazr.h.setVisibility(0);
    localbazr.g.setVisibility(8);
    localbazr.d.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.27
 * JD-Core Version:    0.7.0.1
 */