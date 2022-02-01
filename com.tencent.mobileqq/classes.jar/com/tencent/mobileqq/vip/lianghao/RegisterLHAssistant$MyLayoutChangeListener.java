package com.tencent.mobileqq.vip.lianghao;

import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.widget.ScrollView;
import java.lang.ref.WeakReference;

class RegisterLHAssistant$MyLayoutChangeListener
  implements View.OnLayoutChangeListener
{
  final WeakReference<ScrollView> a;
  final int b;
  
  private RegisterLHAssistant$MyLayoutChangeListener(ScrollView paramScrollView, int paramInt)
  {
    this.a = new WeakReference(paramScrollView);
    this.b = paramInt;
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    ScrollView localScrollView = (ScrollView)this.a.get();
    if ((localScrollView != null) && (paramInt4 - paramInt2 > paramInt8 - paramInt6))
    {
      localScrollView.smoothScrollTo(0, this.b);
      paramView.removeOnLayoutChangeListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.RegisterLHAssistant.MyLayoutChangeListener
 * JD-Core Version:    0.7.0.1
 */