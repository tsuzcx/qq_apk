package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"addNewItem", "", "content", "", "titleId", "", "invoke"}, k=3, mv={1, 1, 16})
final class NewNearbyProfileFragment$setJobCompanySchoolInfo$1
  extends Lambda
  implements Function2<String, Integer, Unit>
{
  NewNearbyProfileFragment$setJobCompanySchoolInfo$1(NewNearbyProfileFragment paramNewNearbyProfileFragment, Ref.BooleanRef paramBooleanRef, Context paramContext, ViewGroup paramViewGroup)
  {
    super(2);
  }
  
  public final void invoke(@Nullable String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    paramString = StringsKt.trim((CharSequence)paramString).toString();
    int i;
    if (((CharSequence)paramString).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return;
    }
    NewNearbyProfileFragment.a(this.this$0, false);
    this.$addItem.element = true;
    Object localObject = this.$context;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    localObject = new NearbyProfileInfoView((Context)localObject, null, 0, 6, null);
    ((NearbyProfileInfoView)localObject).setTitle(this.$context.getString(paramInt));
    ((NearbyProfileInfoView)localObject).setContent(paramString);
    this.$personInfoContainer.addView((View)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NewNearbyProfileFragment.setJobCompanySchoolInfo.1
 * JD-Core Version:    0.7.0.1
 */