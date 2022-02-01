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
    if ((paramView != null) && (FollowingListFragment.a(this.b) != null) && (FollowingListFragment.a(this.b).a() != null))
    {
      if (FollowingListFragment.a(this.b).a().isEmpty()) {
        return;
      }
      paramView = (CheckBox)paramView.findViewById(2131364613);
      paramView.setBackgroundResource(2130849695);
      if (FollowingListFragment.a(this.b).a().contains(paramResultRecord.a()))
      {
        paramView.setEnabled(false);
        return;
      }
      paramView.setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectmember.FollowingListFragment.ReadInJoyFollowListAQAdapter
 * JD-Core Version:    0.7.0.1
 */