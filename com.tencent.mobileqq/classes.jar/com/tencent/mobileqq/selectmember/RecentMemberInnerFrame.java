package com.tencent.mobileqq.selectmember;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecentMemberInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener
{
  private List<RecentUser> a = new ArrayList();
  private XListView b;
  private RecentMemberInnerFrame.RecentMemberAdapter c;
  private EditText d;
  
  public RecentMemberInnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public RecentMemberInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RecentMemberInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void getRecentMembers()
  {
    this.a.clear();
    Object localObject1 = ((IRecentUserProxyService)this.h.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((RecentUserProxy)localObject1).a(true);
      if (localObject2 != null)
      {
        localObject1 = this.h.getCurrentAccountUin();
        localObject2 = ((List)localObject2).iterator();
      }
    }
    for (;;)
    {
      RecentUser localRecentUser;
      if (((Iterator)localObject2).hasNext())
      {
        localRecentUser = (RecentUser)((Iterator)localObject2).next();
        if (localRecentUser == null) {}
      }
      else
      {
        try
        {
          if ((localRecentUser.getType() != 0) || (Long.parseLong(localRecentUser.uin) < 10000L) || (localRecentUser.uin.equals(localObject1)) || (this.f.mUinsToHide.contains(localRecentUser.uin))) {
            continue;
          }
          Friends localFriends = SearchUtils.d(this.h, localRecentUser.uin);
          if ((localFriends == null) || (!localFriends.isFriend())) {
            continue;
          }
          this.a.add(localRecentUser);
        }
        catch (NumberFormatException localNumberFormatException) {}
        return;
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2131629275);
    this.b = ((XListView)findViewById(2131450345));
    this.b.setSelector(2131168376);
    paramBundle = (RelativeLayout)this.f.getLayoutInflater().inflate(2131629215, this.b, false);
    this.d = ((EditText)paramBundle.findViewById(2131432634));
    ((Button)paramBundle.findViewById(2131429816)).setVisibility(8);
    this.b.addHeaderView(paramBundle);
    getRecentMembers();
    this.c = new RecentMemberInnerFrame.RecentMemberAdapter(this);
    this.b.setAdapter(this.c);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.f.setupTitleBar(true, this.f.getString(2131916220), HardCodeUtil.a(2131910688));
    paramBundle = this.c;
    if (paramBundle != null) {
      paramBundle.notifyDataSetChanged();
    }
  }
  
  public void d()
  {
    RecentMemberInnerFrame.RecentMemberAdapter localRecentMemberAdapter = this.c;
    if (localRecentMemberAdapter != null) {
      localRecentMemberAdapter.a();
    }
    super.d();
  }
  
  public void f()
  {
    this.c.notifyDataSetChanged();
  }
  
  public ContactSearchFragment getContactSearchFragment()
  {
    return ((SelectMemberInnerFrame)this.g.getChildAt(1)).getContactSearchFragment();
  }
  
  public String getGroupUin()
  {
    return "-1";
  }
  
  public void onClick(View paramView)
  {
    RecentMemberInnerFrame.ViewHolder localViewHolder = (RecentMemberInnerFrame.ViewHolder)paramView.getTag();
    if ((localViewHolder != null) && (localViewHolder.y != null) && (localViewHolder.a != null) && (localViewHolder.b != null) && (localViewHolder.a.isEnabled()))
    {
      boolean bool = this.f.onListViewItemClick(localViewHolder.y, localViewHolder.b.getText().toString(), 0, "-1");
      localViewHolder.a.setChecked(bool);
      if (AppSetting.e)
      {
        StringBuilder localStringBuilder;
        if (localViewHolder.a.isChecked())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(localViewHolder.b.getText().toString());
          localStringBuilder.append(HardCodeUtil.a(2131910686));
          paramView.setContentDescription(localStringBuilder.toString());
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(localViewHolder.b.getText().toString());
          localStringBuilder.append(HardCodeUtil.a(2131910689));
          paramView.setContentDescription(localStringBuilder.toString());
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.RecentMemberInnerFrame
 * JD-Core Version:    0.7.0.1
 */