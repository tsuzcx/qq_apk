package com.tencent.mobileqq.nearby.profilecard;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyTag.ChildDetail;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke", "com/tencent/mobileqq/nearby/profilecard/NearbyInterestsChooseDialog$onCreateView$1$3$1$2$setBgFunc$1", "com/tencent/mobileqq/nearby/profilecard/NearbyInterestsChooseDialog$$special$$inlined$apply$lambda$3", "com/tencent/mobileqq/nearby/profilecard/NearbyInterestsChooseDialog$$special$$inlined$forEach$lambda$3", "com/tencent/mobileqq/nearby/profilecard/NearbyInterestsChooseDialog$$special$$inlined$forEach$lambda$7"}, k=3, mv={1, 1, 16})
final class NearbyInterestsChooseDialog$onCreateView$$inlined$apply$lambda$4
  extends Lambda
  implements Function0<Unit>
{
  NearbyInterestsChooseDialog$onCreateView$$inlined$apply$lambda$4(Button paramButton, String paramString, NowSummaryCard.NearbyTag.ChildDetail paramChildDetail, ViewGroup paramViewGroup1, View paramView, ViewGroup paramViewGroup2, NearbyInterestsChooseDialog paramNearbyInterestsChooseDialog, LayoutInflater paramLayoutInflater)
  {
    super(0);
  }
  
  public final void invoke()
  {
    int i;
    String str;
    if (this.$it$inlined.checked.get())
    {
      i = 1946353669;
      str = "#4935FF";
    }
    else
    {
      i = 1946353668;
      str = "#616161";
    }
    this.$this_apply.setBackgroundResource(i);
    this.$this_apply.setTextColor(Color.parseColor(str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyInterestsChooseDialog.onCreateView..inlined.apply.lambda.4
 * JD-Core Version:    0.7.0.1
 */