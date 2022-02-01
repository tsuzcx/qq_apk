package com.tencent.mobileqq.kandian.biz.feeds.presenter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyView;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.OnLastReadRefreshListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.widget.KandianNegativeWindow;
import com.tencent.widget.ListView;

public class ReadInJoyPresenterImpl
  implements IReadInJoyPresenter
{
  private ReadInJoyView a;
  private IReadInJoyModel b;
  private IReadInJoyPresenter c;
  private IReadInJoyPresenter d;
  private Context e;
  private int f;
  
  public ReadInJoyPresenterImpl(Context paramContext, OnLastReadRefreshListener paramOnLastReadRefreshListener, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, KandianNegativeWindow paramKandianNegativeWindow, ListView paramListView)
  {
    this.e = paramContext;
    this.c = new ReadInJoyHeaderPresenter(this.e, paramIFaceDecoder, paramReadInJoyBaseAdapter, paramListView, paramKandianNegativeWindow);
    this.d = new ReadInJoyFooterPresenter(this.e, paramOnLastReadRefreshListener, paramReadInJoyBaseAdapter);
  }
  
  public void a(ReadInJoyView paramReadInJoyView, IReadInJoyModel paramIReadInJoyModel, int paramInt)
  {
    this.a = paramReadInJoyView;
    this.b = paramIReadInJoyModel;
    this.f = paramInt;
    this.c.a(paramReadInJoyView, paramIReadInJoyModel, paramInt);
    this.d.a(paramReadInJoyView, paramIReadInJoyModel, paramInt);
    if ((paramReadInJoyView != null) && (paramReadInJoyView.j != null))
    {
      if (paramIReadInJoyModel.j())
      {
        paramReadInJoyView.j.setVisibility(8);
        return;
      }
      paramReadInJoyView.j.setVisibility(0);
    }
  }
  
  public void a(ReadInJoyView paramReadInJoyView, IReadInJoyModel paramIReadInJoyModel, long paramLong, Bitmap paramBitmap)
  {
    this.c.a(paramReadInJoyView, paramIReadInJoyModel, paramLong, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.presenter.ReadInJoyPresenterImpl
 * JD-Core Version:    0.7.0.1
 */