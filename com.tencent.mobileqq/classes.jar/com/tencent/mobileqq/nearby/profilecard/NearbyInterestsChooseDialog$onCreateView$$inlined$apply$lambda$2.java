package com.tencent.mobileqq.nearby.profilecard;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyTag.ChildDetail;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke", "()Lkotlin/Unit;", "com/tencent/mobileqq/nearby/profilecard/NearbyInterestsChooseDialog$onCreateView$1$3$1$1$setFunc$1", "com/tencent/mobileqq/nearby/profilecard/NearbyInterestsChooseDialog$$special$$inlined$apply$lambda$1", "com/tencent/mobileqq/nearby/profilecard/NearbyInterestsChooseDialog$$special$$inlined$forEach$lambda$1", "com/tencent/mobileqq/nearby/profilecard/NearbyInterestsChooseDialog$$special$$inlined$forEach$lambda$5"}, k=3, mv={1, 1, 16})
final class NearbyInterestsChooseDialog$onCreateView$$inlined$apply$lambda$2
  extends Lambda
  implements Function0<Unit>
{
  NearbyInterestsChooseDialog$onCreateView$$inlined$apply$lambda$2(View paramView1, TextView paramTextView, ImageView paramImageView, String paramString, NowSummaryCard.NearbyTag.ChildDetail paramChildDetail, ViewGroup paramViewGroup1, View paramView2, ViewGroup paramViewGroup2, NearbyInterestsChooseDialog paramNearbyInterestsChooseDialog, LayoutInflater paramLayoutInflater)
  {
    super(0);
  }
  
  @Nullable
  public final Unit invoke()
  {
    if (this.$it$inlined.checked.get())
    {
      i = 1946353669;
      localObject = "#4935FF";
    }
    else
    {
      i = 1946353668;
      localObject = "#616161";
    }
    this.$this_apply.setBackgroundResource(i);
    int i = Color.parseColor((String)localObject);
    this.$text.setTextColor(i);
    Object localObject = this.$image;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "image");
    localObject = ((ImageView)localObject).getDrawable();
    if (localObject != null)
    {
      DrawableCompat.setTint((Drawable)localObject, i);
      return Unit.INSTANCE;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyInterestsChooseDialog.onCreateView..inlined.apply.lambda.2
 * JD-Core Version:    0.7.0.1
 */