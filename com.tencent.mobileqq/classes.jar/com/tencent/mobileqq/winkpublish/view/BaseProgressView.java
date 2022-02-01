package com.tencent.mobileqq.winkpublish.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.winkpublish.IPublishQueueListener;

public abstract class BaseProgressView
  extends FrameLayout
  implements IPublishQueueListener
{
  public BaseProgressView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BaseProgressView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseProgressView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext);
  }
  
  private void initView(Context paramContext)
  {
    if (onGetLayoutId() != 0) {
      LayoutInflater.from(paramContext).inflate(onGetLayoutId(), this, true);
    }
    onInitView(paramContext, this);
  }
  
  public abstract int onGetLayoutId();
  
  protected abstract void onInitView(Context paramContext, View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.view.BaseProgressView
 * JD-Core Version:    0.7.0.1
 */