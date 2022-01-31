package com.tencent.mobileqq.tribe.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import azbs;

class TribeVideoListPlayerFragment$27
  implements Runnable
{
  TribeVideoListPlayerFragment$27(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public void run()
  {
    azbs localazbs = (azbs)((View)this.this$0.a).getTag();
    if (localazbs == null) {
      return;
    }
    switch (TribeVideoListPlayerFragment.a(this.this$0).a)
    {
    default: 
      return;
    case 0: 
      localazbs.j.setVisibility(0);
      localazbs.i.setVisibility(8);
      localazbs.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    case 1: 
      localazbs.f.setVisibility(0);
      localazbs.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      localazbs.a.setVisibility(8);
      return;
    }
    localazbs.h.setVisibility(0);
    localazbs.g.setVisibility(8);
    localazbs.d.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.27
 * JD-Core Version:    0.7.0.1
 */