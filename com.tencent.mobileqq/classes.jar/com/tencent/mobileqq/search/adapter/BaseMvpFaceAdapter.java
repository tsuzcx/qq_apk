package com.tencent.mobileqq.search.adapter;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.search.model.IFaceModel;
import com.tencent.mobileqq.search.presenter.IFacePresenter;
import com.tencent.mobileqq.search.view.IFaceView;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;

public abstract class BaseMvpFaceAdapter
  extends BaseMvpAdapter
  implements FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  public int a;
  public FaceDecoder a;
  private ListView a;
  
  public BaseMvpFaceAdapter(ListView paramListView, FaceDecoder paramFaceDecoder)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = paramFaceDecoder;
    paramFaceDecoder.a(this);
    paramListView.setOnScrollListener(this);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetListView == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Int = paramInt;
      if ((paramInt != 0) && (paramInt != 1)) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.b();
      }
      int i = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt = 0;
      while (paramInt < i)
      {
        IFaceModel localIFaceModel = (IFaceModel)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt).getTag(2131362079);
        IFacePresenter localIFacePresenter = (IFacePresenter)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt).getTag(2131362077);
        IFaceView localIFaceView = (IFaceView)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt).getTag(2131362078);
        if ((localIFacePresenter != null) && (localIFaceModel != null) && (paramAbsListView != null)) {
          localIFacePresenter.a(localIFaceModel, localIFaceView);
        }
        paramInt += 1;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a();
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.c();
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a()) && ((this.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_Int == 1)))
    {
      int i = this.jdField_a_of_type_ComTencentWidgetListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        IFaceModel localIFaceModel = (IFaceModel)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag(2131362079);
        if ((localIFaceModel != null) && (localIFaceModel.a() == paramInt2) && (paramString.equals(localIFaceModel.a())))
        {
          IFacePresenter localIFacePresenter = (IFacePresenter)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag(2131362077);
          IFaceView localIFaceView = (IFaceView)this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(paramInt1).getTag(2131362078);
          if ((localIFacePresenter != null) && (localIFaceView != null)) {
            localIFacePresenter.a(localIFaceModel, localIFaceView, paramBitmap);
          }
        }
        paramInt1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.adapter.BaseMvpFaceAdapter
 * JD-Core Version:    0.7.0.1
 */