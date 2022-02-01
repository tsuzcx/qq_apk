package com.tencent.viola.core;

import android.view.View;
import android.view.View.OnLayoutChangeListener;

class ViolaInstance$2
  implements View.OnLayoutChangeListener
{
  ViolaInstance$2(ViolaInstance paramViolaInstance) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((paramInt1 != paramInt5) || (paramInt2 != paramInt6) || (paramInt3 != paramInt7) || (paramInt4 != paramInt8)) {
      this.this$0.onLayoutChangeCallBack(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.core.ViolaInstance.2
 * JD-Core Version:    0.7.0.1
 */