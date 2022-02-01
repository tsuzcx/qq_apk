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
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ReadInJoyView jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView;
  private IReadInJoyPresenter jdField_a_of_type_ComTencentMobileqqKandianBizFeedsPresenterIReadInJoyPresenter;
  private IReadInJoyModel jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel;
  private IReadInJoyPresenter b;
  
  public ReadInJoyPresenterImpl(Context paramContext, OnLastReadRefreshListener paramOnLastReadRefreshListener, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, KandianNegativeWindow paramKandianNegativeWindow, ListView paramListView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsPresenterIReadInJoyPresenter = new ReadInJoyHeaderPresenter(this.jdField_a_of_type_AndroidContentContext, paramIFaceDecoder, paramReadInJoyBaseAdapter, paramListView, paramKandianNegativeWindow);
    this.b = new ReadInJoyFooterPresenter(this.jdField_a_of_type_AndroidContentContext, paramOnLastReadRefreshListener, paramReadInJoyBaseAdapter);
  }
  
  public void a(ReadInJoyView paramReadInJoyView, IReadInJoyModel paramIReadInJoyModel, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView = paramReadInJoyView;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel = paramIReadInJoyModel;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsPresenterIReadInJoyPresenter.a(paramReadInJoyView, paramIReadInJoyModel, paramInt);
    this.b.a(paramReadInJoyView, paramIReadInJoyModel, paramInt);
    if ((paramReadInJoyView != null) && (paramReadInJoyView.e != null))
    {
      if (paramIReadInJoyModel.h())
      {
        paramReadInJoyView.e.setVisibility(8);
        return;
      }
      paramReadInJoyView.e.setVisibility(0);
    }
  }
  
  public void a(ReadInJoyView paramReadInJoyView, IReadInJoyModel paramIReadInJoyModel, long paramLong, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsPresenterIReadInJoyPresenter.a(paramReadInJoyView, paramIReadInJoyModel, paramLong, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.presenter.ReadInJoyPresenterImpl
 * JD-Core Version:    0.7.0.1
 */