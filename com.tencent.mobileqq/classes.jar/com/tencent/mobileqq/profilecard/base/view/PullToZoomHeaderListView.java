package com.tencent.mobileqq.profilecard.base.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;

public class PullToZoomHeaderListView
  extends XListView
{
  private static final int MAX_OVER_SCROLL_Y_DISTANCE = 200;
  private static final String TAG = "PullToZoomHeaderListView";
  private ImageView mHeaderImage;
  private int mHeaderImageHeight;
  private View mHeaderMask;
  private int mMaxOverScrollY;
  private IProfileBaseView mProfileBaseView;
  
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
    init();
  }
  
  private void init()
  {
    this.mMaxOverScrollY = ((int)(getResources().getDisplayMetrics().density * 200.0F));
    if (QLog.isColorLevel()) {
      QLog.d("PullToZoomHeaderListView", 2, String.format("init mMaxOverScrollY=%s", new Object[] { Integer.valueOf(this.mMaxOverScrollY) }));
    }
  }
  
  private void updateHeaderImage()
  {
    if ((this.mHeaderImage != null) && (this.mHeaderImageHeight > 0))
    {
      int j = getScrollY();
      if (QLog.isColorLevel()) {
        QLog.d("PullToZoomHeaderListView", 2, String.format("updateHeaderImage scrollY=%s", new Object[] { Integer.valueOf(j) }));
      }
      int k = this.mHeaderImage.getLeft();
      int m = this.mHeaderImage.getTop();
      int n = this.mHeaderImage.getRight();
      int i1 = this.mHeaderImage.getBottom();
      int i = j;
      if (j >= 0) {
        i = 0;
      }
      if (i != m)
      {
        this.mHeaderImage.layout(k, i, n, i1);
        Object localObject = this.mHeaderMask;
        if (localObject != null) {
          ((View)localObject).layout(k, i, n, i1);
        }
        localObject = this.mProfileBaseView;
        if (localObject != null) {
          ((IProfileBaseView)localObject).updateClipTop(i);
        }
      }
    }
  }
  
  public void computeScroll()
  {
    updateHeaderImage();
    super.computeScroll();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject1 = this.mHeaderImage;
    if ((localObject1 != null) && (this.mHeaderImageHeight == 0))
    {
      this.mHeaderImageHeight = ((ImageView)localObject1).getHeight();
      localObject1 = (ViewGroup)this.mHeaderImage.getParent();
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
            QLog.d("PullToZoomHeaderListView", 2, "onLayout setClipChildren fail!", localException);
          }
          Object localObject2 = null;
        }
      }
    }
  }
  
  protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, this.mMaxOverScrollY, paramBoolean);
  }
  
  public void setHeaderImage(ImageView paramImageView)
  {
    this.mHeaderImage = paramImageView;
    this.mHeaderImageHeight = 0;
  }
  
  public void setHeaderMask(View paramView)
  {
    this.mHeaderMask = paramView;
  }
  
  public void setProfileBaseView(IProfileBaseView paramIProfileBaseView)
  {
    this.mProfileBaseView = paramIProfileBaseView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.PullToZoomHeaderListView
 * JD-Core Version:    0.7.0.1
 */