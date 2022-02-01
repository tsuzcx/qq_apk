package com.tencent.mobileqq.tribe.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import beto;

class TribeVideoListPlayerFragment$26
  implements Runnable
{
  TribeVideoListPlayerFragment$26(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public void run()
  {
    beto localbeto = (beto)((View)this.this$0.a).getTag();
    if (localbeto == null) {
      return;
    }
    switch (TribeVideoListPlayerFragment.a(this.this$0).a)
    {
    default: 
      return;
    case 0: 
      localbeto.j.setVisibility(0);
      localbeto.i.setVisibility(8);
      localbeto.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    case 1: 
      localbeto.f.setVisibility(0);
      localbeto.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      localbeto.a.setVisibility(8);
      return;
    }
    localbeto.h.setVisibility(0);
    localbeto.g.setVisibility(8);
    localbeto.d.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.26
 * JD-Core Version:    0.7.0.1
 */