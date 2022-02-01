package com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.kandian.biz.pts.view.polymeric.ProteusRecycleView;
import com.tencent.mobileqq.kandian.biz.pts.view.polymeric.ProteusRecycleView.OnDispatchTouchEventListener;
import com.tencent.widget.pull2refresh.PagerSnapHelper;
import com.tencent.widget.pull2refresh.RecyclerViewCompat;

public class ProteusPagerSnapHelper
  extends PagerSnapHelper
  implements ProteusRecycleView.OnDispatchTouchEventListener
{
  private int jdField_a_of_type_Int = 3000;
  private ProteusRecycleView jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView;
  Runnable jdField_a_of_type_JavaLangRunnable = new ProteusPagerSnapHelper.1(this);
  private boolean jdField_a_of_type_Boolean = false;
  private int b = 1000;
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @Nullable
  public View a(LinearLayoutManager paramLinearLayoutManager)
  {
    int i = paramLinearLayoutManager.getChildCount();
    if (i == 0) {
      return null;
    }
    OrientationHelper localOrientationHelper = a(paramLinearLayoutManager);
    View localView = paramLinearLayoutManager.getChildAt(0);
    if (Math.abs(localOrientationHelper.getDecoratedStart(localView)) < 20) {
      return localView;
    }
    if (i > 1)
    {
      localView = paramLinearLayoutManager.getChildAt(i - 1);
      i = localOrientationHelper.getDecoratedEnd(localView);
      if (Math.abs(localOrientationHelper.getTotalSpace() - i) < 20) {
        return localView;
      }
    }
    return super.a(paramLinearLayoutManager);
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_Int);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramLong);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView.b(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView.a(this);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i != 1) && (i != 3)) {
        return;
      }
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.jdField_a_of_type_Int);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void a(@Nullable RecyclerViewCompat paramRecyclerViewCompat)
  {
    super.a(paramRecyclerViewCompat);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView = ((ProteusRecycleView)paramRecyclerViewCompat);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPolymericProteusRecycleView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.polymeric.helper.ProteusPagerSnapHelper
 * JD-Core Version:    0.7.0.1
 */