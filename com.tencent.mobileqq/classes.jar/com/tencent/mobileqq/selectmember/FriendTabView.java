package com.tencent.mobileqq.selectmember;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PinnedFooterExpandableListView;

public class FriendTabView
  extends TroopDiscussionBaseV
  implements View.OnClickListener
{
  boolean a = false;
  boolean b = false;
  private PinnedFooterExpandableListView c;
  private SelectMemberBuddyListAdapter i;
  
  public FriendTabView(SelectMemberActivity paramSelectMemberActivity)
  {
    super(paramSelectMemberActivity);
    this.d = paramSelectMemberActivity;
  }
  
  public void a()
  {
    super.a();
    if ((this.b) && (this.f != null))
    {
      IPhoneContactService localIPhoneContactService = (IPhoneContactService)this.f.getRuntimeService(IPhoneContactService.class, "");
      if (localIPhoneContactService != null)
      {
        int j = localIPhoneContactService.getSelfBindState();
        if ((j == 8) || (j == 9)) {
          try
          {
            this.g.a(0);
            return;
          }
          finally
          {
            this.b = false;
          }
        }
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2131626501);
    this.c = ((PinnedFooterExpandableListView)findViewById(2131432646));
    this.a = false;
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("firstUserClicked is ");
      paramBundle.append(this.a);
      QLog.d("FriendTabView", 2, paramBundle.toString());
    }
    if (!this.a) {
      this.c.setFooterEnable(true);
    } else {
      this.c.setFooterEnable(false);
    }
    this.c.setListener(new FriendTabView.1(this));
    paramBundle = (LinearLayout)this.d.getLayoutInflater().inflate(2131629571, null);
    this.c.addHeaderView(paramBundle);
    paramBundle.findViewById(2131430062).setOnClickListener(new FriendTabView.2(this));
    QLog.d("FriendTabView", 2, "----->onCreate");
    this.i = new SelectMemberBuddyListAdapter(this.d, this.f, this.c, new FriendTabView.3(this), true);
    this.c.setAdapter(this.i);
    this.c.setSelector(2131168376);
    this.c.setGroupIndicator(this.d.getResources().getDrawable(2130839673));
    this.c.setOnScrollListener(this.i);
    paramBundle = (IPhoneContactService)this.f.getRuntimeService(IPhoneContactService.class, "");
    if ((paramBundle != null) && (!paramBundle.isBindContactOk())) {
      paramBundle.getSelfBindState();
    }
  }
  
  public void b()
  {
    super.b();
    SelectMemberBuddyListAdapter localSelectMemberBuddyListAdapter = this.i;
    if (localSelectMemberBuddyListAdapter != null) {
      localSelectMemberBuddyListAdapter.b();
    }
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    c();
  }
  
  public void c()
  {
    SelectMemberBuddyListAdapter localSelectMemberBuddyListAdapter = this.i;
    if (localSelectMemberBuddyListAdapter != null) {
      localSelectMemberBuddyListAdapter.a();
    }
  }
  
  public String getGroupUin()
  {
    return null;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.FriendTabView
 * JD-Core Version:    0.7.0.1
 */