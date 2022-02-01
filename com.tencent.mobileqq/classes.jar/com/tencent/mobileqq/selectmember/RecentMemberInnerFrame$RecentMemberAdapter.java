package com.tencent.mobileqq.selectmember;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.selectmember.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.selectmember.util.CommonUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

class RecentMemberInnerFrame$RecentMemberAdapter
  extends FacePreloadBaseAdapter
{
  public RecentMemberInnerFrame$RecentMemberAdapter(RecentMemberInnerFrame paramRecentMemberInnerFrame)
  {
    super(paramRecentMemberInnerFrame.f, paramRecentMemberInnerFrame.h, RecentMemberInnerFrame.a(paramRecentMemberInnerFrame), 1, true);
  }
  
  public int getCount()
  {
    if (RecentMemberInnerFrame.b(this.a) == null) {
      return 0;
    }
    return RecentMemberInnerFrame.b(this.a).size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < RecentMemberInnerFrame.b(this.a).size())) {
      return RecentMemberInnerFrame.b(this.a).get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject1 = (RecentMemberInnerFrame.ViewHolder)paramView.getTag();
    }
    else
    {
      localObject1 = new RecentMemberInnerFrame.ViewHolder(this.a, null);
      paramView = this.a.f.getLayoutInflater().inflate(2131629265, paramViewGroup, false);
      ((RecentMemberInnerFrame.ViewHolder)localObject1).a = ((CheckBox)paramView.findViewById(2131430688));
      ((RecentMemberInnerFrame.ViewHolder)localObject1).A = ((ImageView)paramView.findViewById(2131435219));
      ((RecentMemberInnerFrame.ViewHolder)localObject1).b = ((TextView)paramView.findViewById(2131439121));
      paramView.setTag(localObject1);
    }
    RecentUser localRecentUser = (RecentUser)getItem(paramInt);
    if (localRecentUser != null)
    {
      if (this.a.f.isResultListContainFriend(localRecentUser.uin)) {
        ((RecentMemberInnerFrame.ViewHolder)localObject1).a.setChecked(true);
      } else {
        ((RecentMemberInnerFrame.ViewHolder)localObject1).a.setChecked(false);
      }
      ((RecentMemberInnerFrame.ViewHolder)localObject1).A.setImageBitmap(a(1, localRecentUser.uin));
      Object localObject2 = SearchUtils.d(this.a.h, localRecentUser.uin);
      if (localObject2 == null) {
        localObject2 = "";
      } else {
        localObject2 = CommonUtils.a((Friends)localObject2);
      }
      ((RecentMemberInnerFrame.ViewHolder)localObject1).b.setText((CharSequence)localObject2);
      ((RecentMemberInnerFrame.ViewHolder)localObject1).y = localRecentUser.uin;
      if ((this.a.f.mUinsSelectedDefault != null) && (this.a.f.mUinsSelectedDefault.contains(localRecentUser.uin))) {
        ((RecentMemberInnerFrame.ViewHolder)localObject1).a.setEnabled(false);
      } else {
        ((RecentMemberInnerFrame.ViewHolder)localObject1).a.setEnabled(true);
      }
      if (AppSetting.e) {
        if ((((RecentMemberInnerFrame.ViewHolder)localObject1).a.isChecked()) && (((RecentMemberInnerFrame.ViewHolder)localObject1).a.isEnabled()))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(HardCodeUtil.a(2131910690));
          paramView.setContentDescription(((StringBuilder)localObject1).toString());
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(HardCodeUtil.a(2131910687));
          paramView.setContentDescription(((StringBuilder)localObject1).toString());
        }
      }
      paramView.setOnClickListener(this.a);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.RecentMemberInnerFrame.RecentMemberAdapter
 * JD-Core Version:    0.7.0.1
 */