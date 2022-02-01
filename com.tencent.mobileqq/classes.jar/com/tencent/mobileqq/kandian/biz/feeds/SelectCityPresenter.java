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
  private SelectPositionModule a = ReadInJoyLogicEngine.a().j();
  private WeakReference<SelectCityPresenter.IView> b;
  
  public SelectCityPresenter(SelectCityPresenter.IView paramIView)
  {
    this.a.a(this);
    this.b = new WeakReference(paramIView);
  }
  
  private void b(List<CityData> paramList)
  {
    SelectCityPresenter.IView localIView = (SelectCityPresenter.IView)this.b.get();
    if ((localIView != null) && (paramList != null)) {
      localIView.a(paramList);
    }
  }
  
  public void a()
  {
    SelectPositionModule localSelectPositionModule = ReadInJoyLogicEngine.a().j();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.SelectCityPresenter
 * JD-Core Version:    0.7.0.1
 */