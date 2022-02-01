package com.tencent.mobileqq.kandian.biz.flutter;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.flutter.api.IQFlutterRouterService;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.flutter.offline.MxFlutterResourceLoadListener;
import com.tencent.mobileqq.kandian.biz.flutter.offline.MxFlutterResourceLoader;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/flutter/RIJFlutterUtils$jumpToMxFlutterPage$1", "Lcom/tencent/mobileqq/kandian/biz/flutter/offline/MxFlutterResourceLoadListener;", "jumpToDefaultUrl", "", "onLoadFailed", "errorMsg", "", "onLoadProcess", "process", "", "onLoadSuccess", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJFlutterUtils$jumpToMxFlutterPage$1
  implements MxFlutterResourceLoadListener
{
  RIJFlutterUtils$jumpToMxFlutterPage$1(Activity paramActivity, HashMap paramHashMap, String paramString) {}
  
  private final void b()
  {
    Object localObject2 = this.b.get("defaultUrlToJump");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("#jumpToDefaultUrl: begin defaultUrl=");
    ((StringBuilder)localObject1).append(localObject2);
    localObject1 = ((StringBuilder)localObject1).toString();
    int i = 1;
    QLog.d("RIJFlutterUtils", 1, (String)localObject1);
    localObject1 = this.a;
    if (localObject1 == null) {
      localObject1 = (Activity)QBaseActivity.sTopActivity;
    }
    if ((localObject2 instanceof String))
    {
      if (((CharSequence)localObject2).length() <= 0) {
        i = 0;
      }
      if (i != 0) {
        ReadInJoyUtils.b((Context)localObject1, (String)localObject2);
      }
    }
  }
  
  public void a()
  {
    QLog.d("RIJFlutterUtils", 1, "#jumpToMxFlutterPage: resource load success");
    Object localObject = this.a;
    int j = 0;
    int i = j;
    if (localObject != null)
    {
      RIJFlutterUtils.a(RIJFlutterUtils.a, this.b, "nativeCopyAppBundle", Boolean.valueOf(MxFlutterResourceLoader.a.a()));
      AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
      i = j;
      if (localAppRuntime != null)
      {
        ((IQFlutterRouterService)localAppRuntime.getRuntimeService(IQFlutterRouterService.class, "all")).openPage((Activity)localObject, "qqKandianWidget", this.c, (Map)this.b);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("#jumpToMxFlutterPage: open mxflutter page, data=");
        ((StringBuilder)localObject).append(this.b);
        QLog.d("RIJFlutterUtils", 1, ((StringBuilder)localObject).toString());
        i = 1;
      }
    }
    if (i == 0) {
      b();
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errorMsg");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("#jumpToMxFlutterPage: resource load fail, error=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" page=");
    localStringBuilder.append(this.c);
    QLog.d("RIJFlutterUtils", 1, localStringBuilder.toString());
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.flutter.RIJFlutterUtils.jumpToMxFlutterPage.1
 * JD-Core Version:    0.7.0.1
 */