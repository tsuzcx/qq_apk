package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

public class PullToZoomHeaderListView
  extends XListView
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private int b;
  
  public PullToZoomHeaderListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PullToZoomHeaderListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PullToZoomHeaderListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Int = ((int)(getResources().getDisplayMetrics().density * 200.0F));
    if (QLog.isColorLevel()) {
      QLog.d("PullToZoomHeaderListView", 2, String.format("init mMaxOverScrollY=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
    }
  }
  
  private void b()
  {
    int i = 0;
    int j;
    int k;
    int m;
    int n;
    int i1;
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.b > 0))
    {
      j = getScrollY();
      if (QLog.isColorLevel()) {
        QLog.d("PullToZoomHeaderListView", 2, String.format("updateHeaderImage scrollY=%s", new Object[] { Integer.valueOf(j) }));
      }
      k = this.jdField_a_of_type_AndroidWidgetImageView.getLeft();
      m = this.jdField_a_of_type_AndroidWidgetImageView.getTop();
      n = this.jdField_a_of_type_AndroidWidgetImageView.getRight();
      i1 = this.jdField_a_of_type_AndroidWidgetImageView.getBottom();
      if (j < 0) {
        break label128;
      }
    }
    for (;;)
    {
      if (i != m)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.layout(k, i, n, i1);
        if (this.jdField_a_of_type_AndroidViewView != null) {
          this.jdField_a_of_type_AndroidViewView.layout(k, i, n, i1);
        }
      }
      return;
      label128:
      i = j;
    }
  }
  
  public void computeScroll()
  {
    b();
    super.computeScroll();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ViewGroup localViewGroup;
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.b == 0))
    {
      this.b = this.jdField_a_of_type_AndroidWidgetImageView.getHeight();
      localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidWidgetImageView.getParent();
    }
    for (;;)
    {
      if (localViewGroup != null)
      {
        localViewGroup.setClipChildren(false);
        localViewGroup.setClipToPadding(false);
        if (localViewGroup != this) {}
      }
      else
      {
        return;
      }
      try
      {
        localViewGroup = (ViewGroup)localViewGroup.getParent();
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PullToZoomHeaderListView", 2, "onLayout setClipChildren fail!", localException);
        }
        Object localObject = null;
      }
    }
  }
  
  protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, this.jdField_a_of_type_Int, paramBoolean);
  }
  
  public void setHeaderImage(ImageView paramImageView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.b = 0;
  }
  
  public void setHeaderMask(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.widget.PullToZoomHeaderListView
 * JD-Core Version:    0.7.0.1
 */