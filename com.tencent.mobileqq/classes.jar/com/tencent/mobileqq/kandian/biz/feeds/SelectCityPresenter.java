package com.tencent.mobileqq.kandian.biz.feeds;

import android.os.Handler;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.CityData;
import com.tencent.mobileqq.kandian.repo.feeds.SelectPositionModule;
import com.tencent.mobileqq.kandian.repo.feeds.SelectPositionModule.IPositionOrCityListChangedListener;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PositionData;
import com.tencent.qav.thread.ThreadManager;
import java.util.List;
import mqq.util.WeakReference;

public class SelectCityPresenter
  implements SelectPositionModule.IPositionOrCityListChangedListener
{
  private SelectPositionModule jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsSelectPositionModule = ReadInJoyLogicEngine.a().a();
  private WeakReference<SelectCityPresenter.IView> jdField_a_of_type_MqqUtilWeakReference;
  
  public SelectCityPresenter(SelectCityPresenter.IView paramIView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsSelectPositionModule.a(this);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramIView);
  }
  
  private void b(List<CityData> paramList)
  {
    SelectCityPresenter.IView localIView = (SelectCityPresenter.IView)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if ((localIView != null) && (paramList != null)) {
      localIView.a(paramList);
    }
  }
  
  public void a()
  {
    SelectPositionModule localSelectPositionModule = ReadInJoyLogicEngine.a().a();
    if (localSelectPositionModule != null) {
      b(localSelectPositionModule.a());
    }
  }
  
  public void a(PositionData paramPositionData)
  {
    ThreadManager.a().post(new SelectCityPresenter.2(this, paramPositionData));
  }
  
  public void a(List<CityData> paramList)
  {
    ThreadManager.a().post(new SelectCityPresenter.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.SelectCityPresenter
 * JD-Core Version:    0.7.0.1
 */