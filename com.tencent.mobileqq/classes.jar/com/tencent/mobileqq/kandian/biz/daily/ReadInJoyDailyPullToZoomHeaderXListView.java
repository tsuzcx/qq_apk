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
  private ImageView x;
  private int y;
  private int z;
  
  public ReadInJoyDailyPullToZoomHeaderXListView(Context paramContext)
  {
    this(paramContext, null);
    l();
  }
  
  public ReadInJoyDailyPullToZoomHeaderXListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    l();
  }
  
  public ReadInJoyDailyPullToZoomHeaderXListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    l();
  }
  
  private void l()
  {
    this.y = ((int)(getResources().getDisplayMetrics().density * 200.0F));
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDailyPullToZoo", 2, String.format("init mMaxOverScrollY=%s", new Object[] { Integer.valueOf(this.y) }));
    }
  }
  
  private void m()
  {
    if ((this.x != null) && (this.z > 0))
    {
      int j = getScrollY();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDailyPullToZoo", 2, String.format("updateHeaderImage scrollY=%s", new Object[] { Integer.valueOf(j) }));
      }
      int k = this.x.getLeft();
      int m = this.x.getTop();
      int n = this.x.getRight();
      int i1 = this.x.getBottom();
      int i = j;
      if (j >= 0) {
        i = 0;
      }
      if (i != m) {
        this.x.layout(k, i, n, i1);
      }
    }
  }
  
  public void computeScroll()
  {
    m();
    super.computeScroll();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject1 = this.x;
    if ((localObject1 != null) && (this.z == 0))
    {
      this.z = ((ImageView)localObject1).getHeight();
      localObject1 = (ViewGroup)this.x.getParent();
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
    return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, this.y, paramBoolean);
  }
  
  public void setHeaderImage(ImageView paramImageView)
  {
    this.x = paramImageView;
    this.z = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyPullToZoomHeaderXListView
 * JD-Core Version:    0.7.0.1
 */