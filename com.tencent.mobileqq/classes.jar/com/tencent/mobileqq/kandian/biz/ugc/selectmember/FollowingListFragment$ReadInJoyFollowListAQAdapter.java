package com.tencent.mobileqq.kandian.biz.ugc.selectmember;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.mobileqq.kandian.repo.ugc.ResultRecord;
import java.util.List;
import java.util.Map;

class FollowingListFragment$ReadInJoyFollowListAQAdapter
  extends FollowingListFragment.FollowListAdapter
{
  public FollowingListFragment$ReadInJoyFollowListAQAdapter(Context paramContext, List<? extends Map<String, ?>> paramList, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super(paramContext, paramList, paramInt, paramArrayOfString, paramArrayOfInt, arrayOfInt);
  }
  
  protected void a(View paramView, ResultRecord paramResultRecord)
  {
    if ((paramView != null) && (FollowingListFragment.c(this.b) != null) && (FollowingListFragment.c(this.b).c() != null))
    {
      if (FollowingListFragment.c(this.b).c().isEmpty()) {
        return;
      }
      paramView = (CheckBox)paramView.findViewById(2131430688);
      paramView.setBackgroundResource(2130851400);
      if (FollowingListFragment.c(this.b).c().contains(paramResultRecord.a()))
      {
        paramView.setEnabled(false);
        return;
      }
      paramView.setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectmember.FollowingListFragment.ReadInJoyFollowListAQAdapter
 * JD-Core Version:    0.7.0.1
 */