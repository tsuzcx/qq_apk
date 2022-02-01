package com.tencent.mobileqq.kandian.biz.flutter;

import android.app.Activity;
import com.tencent.mobileqq.flutter.api.IQFlutterRouterService;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.flutter.offline.MxFlutterResourceLoadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/flutter/RIJFlutterUtils$jumpToMxFlutterPage$1", "Lcom/tencent/mobileqq/kandian/biz/flutter/offline/MxFlutterResourceLoadListener;", "onLoadFailed", "", "errorMsg", "", "onLoadProcess", "process", "", "onLoadSuccess", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJFlutterUtils$jumpToMxFlutterPage$1
  implements MxFlutterResourceLoadListener
{
  RIJFlutterUtils$jumpToMxFlutterPage$1(Activity paramActivity, HashMap paramHashMap, String paramString) {}
  
  public void a()
  {
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    if (localActivity != null)
    {
      RIJFlutterUtils.a(RIJFlutterUtils.a, this.jdField_a_of_type_JavaUtilHashMap);
      AppRuntime localAppRuntime = ReadInJoyUtils.a();
      if (localAppRuntime != null) {
        ((IQFlutterRouterService)localAppRuntime.getRuntimeService(IQFlutterRouterService.class, "all")).openPage(localActivity, "qqKandianWidget", this.jdField_a_of_type_JavaLangString, (Map)this.jdField_a_of_type_JavaUtilHashMap);
      }
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("jumpToMxFlutterPage error:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" page:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    QLog.d("RIJFlutterUtils", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.flutter.RIJFlutterUtils.jumpToMxFlutterPage.1
 * JD-Core Version:    0.7.0.1
 */