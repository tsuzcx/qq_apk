package com.tencent.mobileqq.search.base.adapter;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.search.base.presenter.IFacePresenter;
import com.tencent.mobileqq.search.base.view.IFaceView;
import com.tencent.mobileqq.search.model.IFaceModel;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;

public abstract class BaseMvpFaceAdapter<M extends IFaceModel, V extends IFaceView>
  extends BaseMvpAdapter<M, V>
  implements DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  private ListView a;
  protected IFaceDecoder b;
  protected int c = 0;
  
  public BaseMvpFaceAdapter(ListView paramListView, IFaceDecoder paramIFaceDecoder)
  {
    this.a = paramListView;
    this.b = paramIFaceDecoder;
    paramIFaceDecoder.setDecodeTaskCompletionListener(this);
    paramListView.setOnScrollListener(this);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (!this.b.isPausing())
    {
      paramInt1 = this.c;
      if ((paramInt1 == 0) || (paramInt1 == 1))
      {
        int i = this.a.getChildCount();
        paramInt1 = 0;
        while (paramInt1 < i)
        {
          IFaceModel localIFaceModel = (IFaceModel)this.a.getChildAt(paramInt1).getTag(2131449867);
          if ((localIFaceModel != null) && (localIFaceModel.b() == paramInt2) && (paramString.equals(localIFaceModel.c())))
          {
            IFacePresenter localIFacePresenter = (IFacePresenter)this.a.getChildAt(paramInt1).getTag(2131449869);
            IFaceView localIFaceView = (IFaceView)this.a.getChildAt(paramInt1).getTag(2131449873);
            if ((localIFacePresenter != null) && (localIFaceView != null)) {
              localIFacePresenter.a(localIFaceModel, localIFaceView, paramBitmap);
            }
          }
          paramInt1 += 1;
        }
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.a == null) {
      return;
    }
    this.c = paramInt;
    if ((paramInt != 0) && (paramInt != 1))
    {
      this.b.cancelPendingRequests();
      this.b.pause();
      return;
    }
    if (this.b.isPausing()) {
      this.b.resume();
    }
    int i = this.a.getChildCount();
    paramInt = 0;
    while (paramInt < i)
    {
      IFaceModel localIFaceModel = (IFaceModel)this.a.getChildAt(paramInt).getTag(2131449867);
      IFacePresenter localIFacePresenter = (IFacePresenter)this.a.getChildAt(paramInt).getTag(2131449869);
      IFaceView localIFaceView = (IFaceView)this.a.getChildAt(paramInt).getTag(2131449873);
      if ((localIFacePresenter != null) && (localIFaceModel != null) && (paramAbsListView != null)) {
        localIFacePresenter.a(localIFaceModel, localIFaceView);
      }
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.adapter.BaseMvpFaceAdapter
 * JD-Core Version:    0.7.0.1
 */