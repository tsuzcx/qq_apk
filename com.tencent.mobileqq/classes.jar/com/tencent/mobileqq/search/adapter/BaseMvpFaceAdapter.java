package com.tencent.mobileqq.search.adapter;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.search.model.IFaceModel;
import com.tencent.mobileqq.search.presenter.IFacePresenter;
import com.tencent.mobileqq.search.view.IFaceView;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;

public abstract class BaseMvpFaceAdapter<M extends IFaceModel, V extends IFaceView>
  extends BaseMvpAdapter<M, V>
  implements DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  protected int a;
  protected IFaceDecoder a;
  private ListView a;
  
  public BaseMvpFaceAdapter(ListView paramListView, IFaceDecoder paramIFaceDecoder)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = paramIFaceDecoder;
    paramIFaceDecoder.setDecodeTaskCompletionListener(this);
    paramListView.setOnScrollListener(this);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1)))
    {
      int i = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        IFaceModel localIFaceModel = (IFaceModel)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag(2131381651);
        if ((localIFaceModel != null) && (localIFaceModel.c() == paramInt2) && (paramString.equals(localIFaceModel.b())))
        {
          IFacePresenter localIFacePresenter = (IFacePresenter)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag(2131381653);
          IFaceView localIFaceView = (IFaceView)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag(2131381656);
          if ((localIFacePresenter != null) && (localIFaceView != null)) {
            localIFacePresenter.a(localIFaceModel, localIFaceView, paramBitmap);
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetListView == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Int = paramInt;
      if ((paramInt != 0) && (paramInt != 1)) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.resume();
      }
      int i = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        IFaceModel localIFaceModel = (IFaceModel)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt).getTag(2131381651);
        IFacePresenter localIFacePresenter = (IFacePresenter)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt).getTag(2131381653);
        IFaceView localIFaceView = (IFaceView)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt).getTag(2131381656);
        if ((localIFacePresenter != null) && (localIFaceModel != null) && (paramAbsListView != null)) {
          localIFacePresenter.a(localIFaceModel, localIFaceView);
        }
        paramInt += 1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.cancelPendingRequests();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.adapter.BaseMvpFaceAdapter
 * JD-Core Version:    0.7.0.1
 */