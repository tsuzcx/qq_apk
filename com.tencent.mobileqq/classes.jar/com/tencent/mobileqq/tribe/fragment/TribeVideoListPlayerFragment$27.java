package com.tencent.mobileqq.tribe.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import aybi;

class TribeVideoListPlayerFragment$27
  implements Runnable
{
  TribeVideoListPlayerFragment$27(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public void run()
  {
    aybi localaybi = (aybi)((View)this.this$0.a).getTag();
    if (localaybi == null) {
      return;
    }
    switch (TribeVideoListPlayerFragment.a(this.this$0).a)
    {
    default: 
      return;
    case 0: 
      localaybi.j.setVisibility(0);
      localaybi.i.setVisibility(8);
      localaybi.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    case 1: 
      localaybi.f.setVisibility(0);
      localaybi.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      localaybi.a.setVisibility(8);
      return;
    }
    localaybi.h.setVisibility(0);
    localaybi.g.setVisibility(8);
    localaybi.d.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.27
 * JD-Core Version:    0.7.0.1
 */