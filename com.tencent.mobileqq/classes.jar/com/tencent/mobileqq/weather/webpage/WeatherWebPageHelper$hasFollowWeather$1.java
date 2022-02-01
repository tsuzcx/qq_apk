package com.tencent.mobileqq.weather.webpage;

import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.mobileqq.app.ThreadManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref.ObjectRef;
import mqq.os.MqqHandler;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class WeatherWebPageHelper$hasFollowWeather$1
  implements Runnable
{
  WeatherWebPageHelper$hasFollowWeather$1(Ref.ObjectRef paramObjectRef, IPublicAccountDataManager paramIPublicAccountDataManager, Function1 paramFunction1) {}
  
  public final void run()
  {
    this.jdField_a_of_type_KotlinJvmInternalRef$ObjectRef.element = this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountDataManager.findAccountDetailInfo("2658655094");
    ThreadManager.getUIHandler().post((Runnable)new WeatherWebPageHelper.hasFollowWeather.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weather.webpage.WeatherWebPageHelper.hasFollowWeather.1
 * JD-Core Version:    0.7.0.1
 */