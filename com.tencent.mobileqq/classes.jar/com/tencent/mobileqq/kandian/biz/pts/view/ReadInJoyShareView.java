package com.tencent.mobileqq.kandian.biz.pts.view;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeShareView;

public class ReadInJoyShareView
  extends ViewBase
{
  private NativeShareView a;
  
  public ReadInJoyShareView(VafContext paramVafContext)
  {
    super(paramVafContext);
    this.a = new NativeShareView(paramVafContext.getContext());
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.a.setScreenBitmap(paramBitmap);
  }
  
  public void a(Runnable paramRunnable)
  {
    this.a.setInitRunnable(paramRunnable);
  }
  
  public void a(String paramString)
  {
    this.a.setCurrentPath(paramString);
  }
  
  public int getComMeasuredHeight()
  {
    return this.a.getComMeasuredHeight();
  }
  
  public int getComMeasuredWidth()
  {
    return this.a.getComMeasuredWidth();
  }
  
  public View getNativeView()
  {
    return this.a;
  }
  
  public void onComLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.comLayout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onComMeasure(int paramInt1, int paramInt2)
  {
    this.a.measureComponent(paramInt1, paramInt2);
  }
  
  public void onParseValueFinished()
  {
    super.onParseValueFinished();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoyShareView
 * JD-Core Version:    0.7.0.1
 */