package com.tencent.mobileqq.kandian.biz.daily;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

public class ReadInJoyDailyPullToZoomHeaderXListView
  extends ReadInJoyDailyXListView
{
  private ImageView a;
  private int i;
  private int j;
  
  public ReadInJoyDailyPullToZoomHeaderXListView(Context paramContext)
  {
    this(paramContext, null);
    k();
  }
  
  public ReadInJoyDailyPullToZoomHeaderXListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    k();
  }
  
  public ReadInJoyDailyPullToZoomHeaderXListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    k();
  }
  
  private void k()
  {
    this.i = ((int)(getResources().getDisplayMetrics().density * 200.0F));
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDailyPullToZoo", 2, String.format("init mMaxOverScrollY=%s", new Object[] { Integer.valueOf(this.i) }));
    }
  }
  
  private void l()
  {
    if ((this.a != null) && (this.j > 0))
    {
      int m = getScrollY();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDailyPullToZoo", 2, String.format("updateHeaderImage scrollY=%s", new Object[] { Integer.valueOf(m) }));
      }
      int n = this.a.getLeft();
      int i1 = this.a.getTop();
      int i2 = this.a.getRight();
      int i3 = this.a.getBottom();
      int k = m;
      if (m >= 0) {
        k = 0;
      }
      if (k != i1) {
        this.a.layout(n, k, i2, i3);
      }
    }
  }
  
  public void computeScroll()
  {
    l();
    super.computeScroll();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject1 = this.a;
    if ((localObject1 != null) && (this.j == 0))
    {
      this.j = ((ImageView)localObject1).getHeight();
      localObject1 = (ViewGroup)this.a.getParent();
      while (localObject1 != null)
      {
        ((ViewGroup)localObject1).setClipChildren(false);
        ((ViewGroup)localObject1).setClipToPadding(false);
        if (localObject1 == this) {
          return;
        }
        try
        {
          localObject1 = (ViewGroup)((ViewGroup)localObject1).getParent();
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyDailyPullToZoo", 2, "onLayout setClipChildren fail!", localException);
          }
          Object localObject2 = null;
        }
      }
    }
  }
  
  protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, this.i, paramBoolean);
  }
  
  public void setHeaderImage(ImageView paramImageView)
  {
    this.a = paramImageView;
    this.j = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyPullToZoomHeaderXListView
 * JD-Core Version:    0.7.0.1
 */