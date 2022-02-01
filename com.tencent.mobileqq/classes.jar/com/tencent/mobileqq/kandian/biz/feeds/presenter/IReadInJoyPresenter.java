package com.tencent.mobileqq.kandian.biz.feeds.presenter;

import android.graphics.Bitmap;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;

public abstract interface IReadInJoyPresenter
{
  public abstract void a(ReadInJoyView paramReadInJoyView, IReadInJoyModel paramIReadInJoyModel, int paramInt);
  
  public abstract void a(ReadInJoyView paramReadInJoyView, IReadInJoyModel paramIReadInJoyModel, long paramLong, Bitmap paramBitmap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.presenter.IReadInJoyPresenter
 * JD-Core Version:    0.7.0.1
 */