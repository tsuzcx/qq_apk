package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import com.tencent.mobileqq.util.DisplayUtil;

public class LabelDisplayCtrl
  extends LabelBaseCtrl
{
  protected View k;
  
  protected LabelContainer a(View paramView, int paramInt1, InterestTag paramInterestTag, int paramInt2)
  {
    paramInterestTag = (ImageView)paramView.findViewById(2131449017);
    if (paramInt1 == 7) {
      paramInterestTag.setVisibility(8);
    } else {
      paramInterestTag.setImageResource(f[paramInt1]);
    }
    if (this.a.getChildCount() != 0)
    {
      paramInterestTag = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      paramInterestTag.topMargin = DisplayUtil.a(this.b, 16.0F);
      paramView.setLayoutParams(paramInterestTag);
    }
    paramInt1 = DisplayUtil.a(this.b, 7.0F);
    paramInt2 = DisplayUtil.a(this.b, 7.0F);
    paramView = (LabelContainer)paramView.findViewById(2131436826);
    paramView.setSpace(paramInt1, paramInt2);
    return paramView;
  }
  
  public void a(Context paramContext, LinearLayout paramLinearLayout, View paramView)
  {
    super.a(paramContext, paramLinearLayout);
    this.k = paramView;
    this.k.setVisibility(8);
  }
  
  public boolean a(InterestTag[] paramArrayOfInterestTag)
  {
    if (super.a(paramArrayOfInterestTag))
    {
      this.a.setVisibility(0);
      this.k.setVisibility(0);
    }
    else
    {
      this.a.setVisibility(8);
      this.k.setVisibility(8);
    }
    return true;
  }
  
  protected int b()
  {
    return 2131627531;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.LabelDisplayCtrl
 * JD-Core Version:    0.7.0.1
 */