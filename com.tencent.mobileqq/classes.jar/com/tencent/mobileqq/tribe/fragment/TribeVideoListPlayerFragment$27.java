package com.tencent.mobileqq.tribe.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bbea;

class TribeVideoListPlayerFragment$27
  implements Runnable
{
  TribeVideoListPlayerFragment$27(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public void run()
  {
    bbea localbbea = (bbea)((View)this.this$0.a).getTag();
    if (localbbea == null) {
      return;
    }
    switch (TribeVideoListPlayerFragment.a(this.this$0).a)
    {
    default: 
      return;
    case 0: 
      localbbea.j.setVisibility(0);
      localbbea.i.setVisibility(8);
      localbbea.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    case 1: 
      localbbea.f.setVisibility(0);
      localbbea.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      localbbea.a.setVisibility(8);
      return;
    }
    localbbea.h.setVisibility(0);
    localbbea.g.setVisibility(8);
    localbbea.d.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.27
 * JD-Core Version:    0.7.0.1
 */