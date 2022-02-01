package com.tencent.mobileqq.nearby.profilecard;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import com.tencent.mobileqq.util.DisplayUtil;

public class LabelEditCtrl
  extends LabelBaseCtrl
  implements View.OnClickListener
{
  public int k = 0;
  
  protected LabelContainer a(View paramView, int paramInt1, InterestTag paramInterestTag, int paramInt2)
  {
    ((TextView)paramView.findViewById(2131449020)).setText(i[paramInt1]);
    paramInt1 = DisplayUtil.a(this.b, 6.0F);
    int i = DisplayUtil.a(this.b, 6.0F);
    LabelContainer localLabelContainer = (LabelContainer)paramView.findViewById(2131436826);
    localLabelContainer.setSpace(paramInt1, i);
    paramView.setTag(paramInterestTag);
    paramView.setOnClickListener(this);
    if (this.a.getChildCount() == paramInt2 - 1)
    {
      paramInt1 = DisplayUtil.a(this.b, 10.0F);
      paramView.setBackgroundResource(2130839629);
      paramView.setPadding(0, paramInt1, 0, paramInt1);
    }
    return localLabelContainer;
  }
  
  protected boolean a()
  {
    return true;
  }
  
  protected int b()
  {
    return 2131627532;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof InterestTag))
    {
      paramView = (InterestTag)paramView.getTag();
      Intent localIntent = new Intent();
      localIntent.putExtra("interest_tag_type", paramView.a);
      localIntent.putExtra("is_from_judge", false);
      localIntent.putExtra("is_from_nearby", true);
      localIntent.putExtra("from_where", "NearbyPeopleProfileActivity");
      localIntent.putParcelableArrayListExtra("choosed_interest_tags", paramView.b);
      RouteUtils.a(this.b, localIntent, "/nearby/choose/interesttag", 11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.LabelEditCtrl
 * JD-Core Version:    0.7.0.1
 */