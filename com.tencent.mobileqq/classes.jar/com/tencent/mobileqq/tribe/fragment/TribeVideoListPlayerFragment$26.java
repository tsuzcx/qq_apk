package com.tencent.mobileqq.tribe.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bdml;

class TribeVideoListPlayerFragment$26
  implements Runnable
{
  TribeVideoListPlayerFragment$26(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public void run()
  {
    bdml localbdml = (bdml)((View)this.this$0.a).getTag();
    if (localbdml == null) {
      return;
    }
    switch (TribeVideoListPlayerFragment.a(this.this$0).a)
    {
    default: 
      return;
    case 0: 
      localbdml.j.setVisibility(0);
      localbdml.i.setVisibility(8);
      localbdml.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    case 1: 
      localbdml.f.setVisibility(0);
      localbdml.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      localbdml.a.setVisibility(8);
      return;
    }
    localbdml.h.setVisibility(0);
    localbdml.g.setVisibility(8);
    localbdml.d.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.26
 * JD-Core Version:    0.7.0.1
 */