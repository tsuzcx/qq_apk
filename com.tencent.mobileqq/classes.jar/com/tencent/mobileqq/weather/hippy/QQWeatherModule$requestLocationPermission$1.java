package com.tencent.mobileqq.weather.hippy;

import com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener;
import com.tencent.mtt.hippy.modules.Promise;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/weather/hippy/QQWeatherModule$requestLocationPermission$1", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "onAllGranted", "", "onDenied", "permissions", "", "", "results", "", "qq-weather-impl_release"}, k=1, mv={1, 1, 16})
public final class QQWeatherModule$requestLocationPermission$1
  extends QQPermission.BasePermissionsListener
{
  QQWeatherModule$requestLocationPermission$1(Promise paramPromise) {}
  
  public void a()
  {
    super.a();
    this.a.resolve("0");
  }
  
  public void a(@Nullable List<String> paramList, @Nullable List<Integer> paramList1)
  {
    super.a(paramList, paramList1);
    this.a.resolve("2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weather.hippy.QQWeatherModule.requestLocationPermission.1
 * JD-Core Version:    0.7.0.1
 */