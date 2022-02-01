package com.tencent.mobileqq.nearby.profilecard;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/nearby/profilecard/NewLabelDisplayCtrl;", "Lcom/tencent/mobileqq/nearby/profilecard/LabelDisplayCtrl;", "()V", "fillTagContainer", "", "tagIdx", "", "tagsContainer", "Lcom/tencent/mobileqq/nearby/profilecard/LabelContainer;", "tagInfos", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/nearby/interestTag/InterestTagInfo;", "getItemLayoutId", "initItem", "itemView", "Landroid/view/View;", "tag", "Lcom/tencent/mobileqq/nearby/interestTag/InterestTag;", "itemCount", "isContainerVisible", "", "qqnearby_impl_release"}, k=1, mv={1, 1, 16})
public final class NewLabelDisplayCtrl
  extends LabelDisplayCtrl
{
  @NotNull
  protected LabelContainer a(@NotNull View paramView, int paramInt1, @Nullable InterestTag paramInterestTag, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "itemView");
    paramInterestTag = (TextView)paramView.findViewById(1946419231);
    if (paramInt1 == 7)
    {
      paramInterestTag.setVisibility(8);
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(LabelBaseCtrl.i[paramInt1]);
      localStringBuilder.append(65306);
      paramInterestTag.setText((CharSequence)localStringBuilder.toString());
    }
    paramInterestTag = this.a;
    Intrinsics.checkExpressionValueIsNotNull(paramInterestTag, "mContainer");
    if (paramInterestTag.getChildCount() != 0)
    {
      paramInterestTag = paramView.getLayoutParams();
      if (paramInterestTag != null)
      {
        paramInterestTag = (LinearLayout.LayoutParams)paramInterestTag;
        paramInterestTag.topMargin = DisplayUtil.a(this.b, 16.0F);
        paramView.setLayoutParams((ViewGroup.LayoutParams)paramInterestTag);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
      }
    }
    paramInt1 = DisplayUtil.a(this.b, 7.0F);
    paramInt2 = DisplayUtil.a(this.b, 7.0F);
    paramView = paramView.findViewById(1946419205);
    if (paramView != null)
    {
      paramView = (LabelContainer)paramView;
      paramView.setSpace(paramInt1, paramInt2);
      return paramView;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.nearby.profilecard.LabelContainer");
  }
  
  protected void a(int paramInt, @NotNull LabelContainer paramLabelContainer, @Nullable ArrayList<InterestTagInfo> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramLabelContainer, "tagsContainer");
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      int i = DisplayUtil.a(this.b, 3.0F);
      int j = DisplayUtil.a(this.b, 0.0F);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        InterestTagInfo localInterestTagInfo = (InterestTagInfo)paramArrayList.next();
        TextView localTextView = new TextView(this.b);
        paramInt = 0;
        localTextView.setIncludeFontPadding(false);
        localTextView.setTextSize(1, 14.0F);
        localTextView.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
        localTextView.setTextColor(-16777216);
        Object localObject = this.d;
        if (localObject != null)
        {
          ArrayList localArrayList = ((InterestTag)localObject).b;
          Intrinsics.checkExpressionValueIsNotNull(localArrayList, "it.tagInfos");
          int k = ((Collection)localArrayList).size();
          while (paramInt < k)
          {
            if (Intrinsics.areEqual(((InterestTagInfo)((InterestTag)localObject).b.get(paramInt)).tagName, localInterestTagInfo.tagName))
            {
              localTextView.setTextColor(Color.parseColor(LabelDisplayCtrl.h[7]));
              localTextView.setBackgroundColor(Color.parseColor(LabelDisplayCtrl.g[7]));
              ((InterestTag)localObject).b.remove(paramInt);
            }
            paramInt += 1;
          }
        }
        localObject = localInterestTagInfo.tagName;
        if (localObject != null) {
          if (localObject != null) {
            localInterestTagInfo.tagName = StringsKt.trim((CharSequence)localObject).toString();
          } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
          }
        }
        localTextView.setText((CharSequence)localInterestTagInfo.tagName);
        localTextView.setPadding(i, j, i, j);
        localTextView.setGravity(17);
        paramLabelContainer.addView((View)localTextView);
      }
    }
  }
  
  protected int b()
  {
    return 1946484737;
  }
  
  public final boolean c()
  {
    LinearLayout localLinearLayout = this.a;
    return (localLinearLayout != null) && (localLinearLayout.getVisibility() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NewLabelDisplayCtrl
 * JD-Core Version:    0.7.0.1
 */