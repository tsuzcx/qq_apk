package com.tencent.mobileqq.kandian.biz.hippy.tuwen.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class HippyRootLayout
  extends FrameLayout
{
  private static final int EMPTY_HEIGHT = ViewUtils.a(250.0F);
  private static final int ERROR_HEIGHT = ViewUtils.a(250.0F);
  private static final int LOADING_HEIGHT = ViewUtils.a(50.0F);
  private static final int MIN_HEIGHT = LOADING_HEIGHT;
  private static final int STATUS_EMPTY = 2;
  private static final int STATUS_ERROR = 3;
  public static final int STATUS_LOADED = 1;
  private static final int STATUS_LOADING = 0;
  private static final String TAG = "HippyRootLayout";
  private int desiredHeight = LOADING_HEIGHT;
  private int loadedHeight;
  private int maxHeight;
  private int status = 0;
  private final SparseIntArray statusHeightMap = new SparseIntArray(3);
  
  public HippyRootLayout(@NonNull Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public HippyRootLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HippyRootLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    QLog.d("HippyRootLayout", 1, "HippyRootLayout new instance");
    init();
  }
  
  private void doOnEmptyOrError(int paramInt)
  {
    this.loadedHeight = 0;
    setDesiredHeight(this.statusHeightMap.get(paramInt));
  }
  
  private void doOnLoaded(int paramInt)
  {
    paramInt = this.loadedHeight;
    if (paramInt > 0) {
      setDesiredHeight(paramInt);
    }
  }
  
  private void doOnLoading(int paramInt)
  {
    if (this.status != 1)
    {
      this.loadedHeight = 0;
      setDesiredHeight(this.statusHeightMap.get(paramInt));
    }
  }
  
  private void init()
  {
    this.statusHeightMap.put(0, LOADING_HEIGHT);
    this.statusHeightMap.put(2, EMPTY_HEIGHT);
    this.statusHeightMap.put(3, ERROR_HEIGHT);
  }
  
  private void setDesiredHeight(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setDesiredHeight:desiredHeight=");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("HippyRootLayout", 1, ((StringBuilder)localObject).toString());
    int j = MIN_HEIGHT;
    int i = paramInt;
    if (paramInt <= j) {
      i = j;
    }
    if (this.desiredHeight == i) {
      return;
    }
    this.desiredHeight = i;
    localObject = getLayoutParams();
    if (localObject != null)
    {
      ((ViewGroup.LayoutParams)localObject).height = this.desiredHeight;
      forceLayout();
      requestLayout();
    }
  }
  
  public int getDesiredHeight()
  {
    return this.desiredHeight;
  }
  
  public int getMaxHeight()
  {
    return this.maxHeight;
  }
  
  public void setLoadedHeight(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setLoadedHeight: loadedHeight=");
    localStringBuilder.append(paramInt);
    QLog.d("HippyRootLayout", 1, localStringBuilder.toString());
    this.loadedHeight = paramInt;
    if (this.status == 1) {
      setDesiredHeight(paramInt);
    }
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.maxHeight = paramInt;
  }
  
  public void setStatus(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setStatus: newStatus=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", oldStatus=");
    localStringBuilder.append(this.status);
    QLog.d("HippyRootLayout", 1, localStringBuilder.toString());
    if (this.status == paramInt) {
      return;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        doOnEmptyOrError(paramInt);
      } else {
        doOnLoaded(paramInt);
      }
    }
    else {
      doOnLoading(paramInt);
    }
    this.status = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.HippyRootLayout
 * JD-Core Version:    0.7.0.1
 */