package com.tencent.tkd.topicsdk.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.tkd.R.id;
import com.tencent.tkd.R.layout;
import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.bean.LocationInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/AddLocationView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "value", "Lcom/tencent/tkd/topicsdk/bean/LocationInfo;", "locationInfo", "getLocationInfo", "()Lcom/tencent/tkd/topicsdk/bean/LocationInfo;", "setLocationInfo", "(Lcom/tencent/tkd/topicsdk/bean/LocationInfo;)V", "locationView", "Landroid/widget/TextView;", "onLocationChangeCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isAdd", "", "getOnLocationChangeCallback", "()Lkotlin/jvm/functions/Function1;", "setOnLocationChangeCallback", "(Lkotlin/jvm/functions/Function1;)V", "callLocationChangeCallback", "oldLocationInfo", "newLocationInfo", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class AddLocationView
  extends LinearLayout
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  @Nullable
  private LocationInfo jdField_a_of_type_ComTencentTkdTopicsdkBeanLocationInfo;
  @Nullable
  private Function1<? super Boolean, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1;
  
  public AddLocationView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(R.layout.v, (ViewGroup)this, true);
    paramContext = findViewById(R.id.bc);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "findViewById(R.id.tv_location)");
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext);
  }
  
  private final void a(LocationInfo paramLocationInfo1, LocationInfo paramLocationInfo2)
  {
    if ((paramLocationInfo1 == null) && (paramLocationInfo2 != null))
    {
      paramLocationInfo1 = this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
      if (paramLocationInfo1 != null) {
        paramLocationInfo1 = (Unit)paramLocationInfo1.invoke(Boolean.valueOf(true));
      }
    }
    else if ((paramLocationInfo1 != null) && (paramLocationInfo2 == null))
    {
      paramLocationInfo1 = this.jdField_a_of_type_KotlinJvmFunctionsFunction1;
      if (paramLocationInfo1 != null) {
        paramLocationInfo1 = (Unit)paramLocationInfo1.invoke(Boolean.valueOf(false));
      }
    }
  }
  
  @Nullable
  public final LocationInfo a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkBeanLocationInfo;
  }
  
  public final void setLocationInfo(@Nullable LocationInfo paramLocationInfo)
  {
    a(this.jdField_a_of_type_ComTencentTkdTopicsdkBeanLocationInfo, paramLocationInfo);
    this.jdField_a_of_type_ComTencentTkdTopicsdkBeanLocationInfo = paramLocationInfo;
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (paramLocationInfo != null)
    {
      paramLocationInfo = paramLocationInfo.getName();
      if (paramLocationInfo != null) {}
    }
    else
    {
      paramLocationInfo = getContext();
      Intrinsics.checkExpressionValueIsNotNull(paramLocationInfo, "context");
      paramLocationInfo = paramLocationInfo.getResources().getString(R.string.a);
    }
    localTextView.setText((CharSequence)paramLocationInfo);
  }
  
  public final void setOnLocationChangeCallback(@Nullable Function1<? super Boolean, Unit> paramFunction1)
  {
    this.jdField_a_of_type_KotlinJvmFunctionsFunction1 = paramFunction1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.AddLocationView
 * JD-Core Version:    0.7.0.1
 */