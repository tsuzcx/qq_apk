package com.tencent.mobileqq.flashshow.view.message;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.flashshow.list.presenter.FSBaseMessagePresenter;
import com.tencent.mobileqq.flashshow.widgets.FSBaseWidgetView;
import feedcloud.FeedCloudMeta.StNotice;

public abstract class FSBaseMessageItemView
  extends FSBaseWidgetView<FeedCloudMeta.StNotice>
{
  protected FSBaseMessagePresenter a;
  
  public FSBaseMessageItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public FSBaseMessageItemView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FSBaseMessageItemView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public FSBaseMessageItemView(@NonNull Context paramContext, Integer paramInteger)
  {
    super(paramContext, paramInteger);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    FSBaseMessagePresenter localFSBaseMessagePresenter = this.a;
    if (localFSBaseMessagePresenter != null) {
      localFSBaseMessagePresenter.g();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    FSBaseMessagePresenter localFSBaseMessagePresenter = this.a;
    if (localFSBaseMessagePresenter != null) {
      localFSBaseMessagePresenter.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.view.message.FSBaseMessageItemView
 * JD-Core Version:    0.7.0.1
 */