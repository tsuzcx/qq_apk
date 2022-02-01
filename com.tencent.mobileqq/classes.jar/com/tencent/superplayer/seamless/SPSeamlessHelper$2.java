package com.tencent.superplayer.seamless;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class SPSeamlessHelper$2
  implements ViewTreeObserver.OnPreDrawListener
{
  SPSeamlessHelper$2(SPSeamlessHelper paramSPSeamlessHelper, ViewGroup paramViewGroup1, View paramView, ViewGroup paramViewGroup2, SPSeamlessParam paramSPSeamlessParam) {}
  
  public boolean onPreDraw()
  {
    this.val$parent.getViewTreeObserver().removeOnPreDrawListener(this);
    SPSeamlessHelper.access$100(this.this$0, this.val$videoView, this.val$decorView, this.val$parent, 250L, this.val$seamlessParam, null);
    SPSeamlessHelper.access$200(this.this$0, this.val$decorView.findViewById(16908290), 0.0F, 1.0F, 250L);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.superplayer.seamless.SPSeamlessHelper.2
 * JD-Core Version:    0.7.0.1
 */