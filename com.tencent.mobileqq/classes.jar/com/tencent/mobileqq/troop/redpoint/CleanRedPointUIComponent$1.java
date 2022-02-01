package com.tencent.mobileqq.troop.redpoint;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.redpoint.api.IRedPointUtilsApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CleanRedPointUIComponent$1
  implements View.OnClickListener
{
  CleanRedPointUIComponent$1(CleanRedPointUIComponent paramCleanRedPointUIComponent) {}
  
  public void onClick(View paramView)
  {
    if (CleanRedPointUIComponent.a(this.a) != null) {
      CleanRedPointUIComponent.a(this.a).a();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initClickLogic: onClick  mUin = ");
      localStringBuilder.append(CleanRedPointUIComponent.a(this.a));
      localStringBuilder.append(", mUinType = ");
      localStringBuilder.append(CleanRedPointUIComponent.b(this.a));
      QLog.d("CleanRedPointUIComponent", 2, localStringBuilder.toString());
    }
    ((IRedPointUtilsApi)QRoute.api(IRedPointUtilsApi.class)).cleanRedPointInfoByIds(CleanRedPointUIComponent.a(this.a), CleanRedPointUIComponent.a(this.a), CleanRedPointUIComponent.b(this.a), CleanRedPointUIComponent.a(this.a));
    ((IRedPointUtilsApi)QRoute.api(IRedPointUtilsApi.class)).notifyRedPointViewClick(CleanRedPointUIComponent.a(this.a), CleanRedPointUIComponent.a(this.a), CleanRedPointUIComponent.b(this.a), CleanRedPointUIComponent.a(this.a));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.redpoint.CleanRedPointUIComponent.1
 * JD-Core Version:    0.7.0.1
 */