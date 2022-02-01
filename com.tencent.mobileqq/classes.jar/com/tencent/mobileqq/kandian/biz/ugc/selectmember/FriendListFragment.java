package com.tencent.mobileqq.kandian.biz.ugc.selectmember;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.ugc.databinding.ObservableArrayList;
import com.tencent.mobileqq.kandian.repo.ugc.ResultRecord;
import com.tencent.widget.PinnedFooterExpandableListView;

public class FriendListFragment
  extends BaseFragment
{
  private View.OnClickListener a;
  private ObservableArrayList<ResultRecord> b;
  private SelectMemberBuddyListAdapter c;
  private PinnedFooterExpandableListView d;
  private SelectMemberLimit e;
  private View.OnClickListener f;
  
  private SelectMemberBuddyListAdapter a()
  {
    SelectMemberLimit localSelectMemberLimit = this.e;
    if ((localSelectMemberLimit != null) && (localSelectMemberLimit.a() == 1)) {
      return new ReadInJoySelectMemberAQAdapter(getBaseActivity(), (QQAppInterface)ReadInJoyUtils.b(), this.d, true, this.e);
    }
    return new SelectMemberBuddyListAdapter(getBaseActivity(), (QQAppInterface)ReadInJoyUtils.b(), this.d, true);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.a = paramOnClickListener;
  }
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList)
  {
    this.b = paramObservableArrayList;
  }
  
  public void a(SelectMemberLimit paramSelectMemberLimit)
  {
    this.e = paramSelectMemberLimit;
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    this.f = paramOnClickListener;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131626320, paramViewGroup, false);
    this.d = ((PinnedFooterExpandableListView)paramViewGroup.findViewById(2131432646));
    paramLayoutInflater = paramLayoutInflater.inflate(2131626321, this.d, false);
    paramLayoutInflater.findViewById(2131430009).setOnClickListener(this.a);
    this.d.addHeaderView(paramLayoutInflater);
    this.c = a();
    this.c.a(this.b);
    this.c.a(this.f);
    this.d.setAdapter(this.c);
    this.d.setSelector(2131168376);
    this.d.setGroupIndicator(getResources().getDrawable(2130839673));
    this.d.setOnScrollListener(this.c);
    this.d.setOnGroupExpandListener(new FriendListFragment.1(this));
    this.d.setOnGroupCollapseListener(new FriendListFragment.2(this));
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    SelectMemberBuddyListAdapter localSelectMemberBuddyListAdapter = this.c;
    if (localSelectMemberBuddyListAdapter != null) {
      localSelectMemberBuddyListAdapter.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectmember.FriendListFragment
 * JD-Core Version:    0.7.0.1
 */