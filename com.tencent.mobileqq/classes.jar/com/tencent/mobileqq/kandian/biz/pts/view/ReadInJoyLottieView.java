package com.tencent.mobileqq.kandian.biz.pts.view;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.base.view.ReadInJoyLottieDrawable;
import com.tencent.mobileqq.kandian.biz.common.widget.NativeReadInjoyImageView;
import com.tencent.qphone.base.util.QLog;

public class ReadInJoyLottieView
  extends ViewBase
{
  ViewTreeObserver.OnGlobalLayoutListener a = new ReadInJoyLottieView.1(this);
  private NativeReadInjoyImageView b;
  private ReadInJoyLottieDrawable c;
  private boolean d = false;
  
  public ReadInJoyLottieView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.b = new NativeReadInjoyImageView(paramVafContext.getContext());
    if (this.b.getViewTreeObserver() != null) {
      this.b.getViewTreeObserver().addOnGlobalLayoutListener(this.a);
    }
  }
  
  public void a()
  {
    ReadInJoyLottieDrawable localReadInJoyLottieDrawable = this.c;
    if (localReadInJoyLottieDrawable != null) {
      localReadInJoyLottieDrawable.resumeAnimation();
    }
  }
  
  public void b()
  {
    ReadInJoyLottieDrawable localReadInJoyLottieDrawable = this.c;
    if (localReadInJoyLottieDrawable != null) {
      localReadInJoyLottieDrawable.pauseAnimation();
    }
  }
  
  public int getComMeasuredHeight()
  {
    return this.b.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.b.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.b;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.b.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
    this.b.setBackgroundColor(this.mBackground);
  }
  
  protected boolean setAttribute(int paramInt, String paramString)
  {
    if (paramInt != 1169) {
      return super.setAttribute(paramInt, paramString);
    }
    try
    {
      this.c = ReadInJoyLottieDrawable.a(paramString);
      this.b.setImageDrawable(this.c);
      return true;
    }
    catch (Exception paramString)
    {
      QLog.d("ReadInJoyLottieView", 1, paramString.getMessage());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyLottieView
 * JD-Core Version:    0.7.0.1
 */