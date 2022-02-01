package com.tencent.mobileqq.debug;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class VasAdvDebugFragment$initView$1$3
  implements View.OnClickListener
{
  VasAdvDebugFragment$initView$1$3(View paramView, EditText paramEditText1, EditText paramEditText2) {}
  
  public final void onClick(View paramView)
  {
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetEditText;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "etAdCode");
    localObject1 = ((EditText)localObject1).getText().toString();
    Object localObject2 = this.b;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "etBusiness");
    localObject2 = ((EditText)localObject2).getText().toString();
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
    {
      ((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).openWeatherWebPage(this.jdField_a_of_type_AndroidViewView.getContext(), (String)localObject1, (String)localObject2);
    }
    else
    {
      Context localContext = this.jdField_a_of_type_AndroidViewView.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid adcode=");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(" or businessId=");
      localStringBuilder.append((String)localObject2);
      Toast.makeText(localContext, (CharSequence)localStringBuilder.toString(), 1).show();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.debug.VasAdvDebugFragment.initView.1.3
 * JD-Core Version:    0.7.0.1
 */