package com.tencent.mobileqq.selectmember;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.friend.observer.IFriendObserver;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.selectmember.util.CommonUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.troopcreate.TroopCreateUtils;
import com.tencent.mobileqq.troop.troopcreate.ui.RelationFriendsTroopViewHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.PinnedFooterExpandableListView;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class FriendTeamListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener
{
  List<Entity> a = new ArrayList();
  boolean b = false;
  boolean c = false;
  RelationFriendsTroopViewHelper d;
  TroopObserver e = new FriendTeamListInnerFrame.5(this);
  private PinnedFooterExpandableListView j;
  private SelectMemberBuddyListAdapter k;
  private LinearLayout l;
  private RelativeLayout m;
  private Button n;
  private TextView o;
  private Button p;
  private Button q;
  private Button r;
  private Button s;
  private Button t;
  private String u;
  private IFriendObserver v;
  
  public FriendTeamListInnerFrame(Context paramContext)
  {
    super(paramContext);
  }
  
  public FriendTeamListInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FriendTeamListInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    super.a();
    if ((this.c) && (this.h != null))
    {
      IPhoneContactService localIPhoneContactService = (IPhoneContactService)this.h.getRuntimeService(IPhoneContactService.class, "");
      if (localIPhoneContactService != null)
      {
        int i = localIPhoneContactService.getSelfBindState();
        if ((i == 8) || (i == 9)) {
          try
          {
            this.g.a(1);
            return;
          }
          finally
          {
            this.c = false;
          }
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle = getActivity();
    this.j = ((PinnedFooterExpandableListView)paramBundle.getLayoutInflater().inflate(2131626501, null));
    this.b = false;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("firstUserClicked is ");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("FriendTeamListInnerFrameNew", 2, ((StringBuilder)localObject).toString());
    }
    if (!this.b) {
      this.j.setFooterEnable(true);
    } else {
      this.j.setFooterEnable(false);
    }
    this.j.setListener(new FriendTeamListInnerFrame.1(this));
    Object localObject = (LinearLayout)this.f.getLayoutInflater().inflate(2131626503, null);
    this.j.addHeaderView((View)localObject);
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, SearchUtils.a(12.0F, getResources()));
    View localView = new View(this.f);
    localView.setLayoutParams(localLayoutParams);
    this.j.addHeaderView(localView);
    QLog.d("FriendTeamListInnerFrameNew", 2, "----->onCreate");
    boolean bool = this.f.getIntent().getBooleanExtra("isExpandFirst", true);
    this.k = new SelectMemberBuddyListAdapter(paramBundle, this.h, this.j, new FriendTeamListInnerFrame.2(this), bool);
    this.j.setAdapter(this.k);
    this.j.setSelector(2131168376);
    this.j.setGroupIndicator(getActivity().getResources().getDrawable(2130839673));
    this.j.setOnScrollListener(this.k);
    setContentView(this.j);
    this.d = new RelationFriendsTroopViewHelper(this.h, this.j, new FriendTeamListInnerFrame.3(this));
    this.k.a(this.d);
    this.l = ((LinearLayout)((LinearLayout)localObject).findViewById(2131430199));
    this.n = ((Button)((LinearLayout)localObject).findViewById(2131429848));
    this.o = ((TextView)((LinearLayout)localObject).findViewById(2131447118));
    this.m = ((RelativeLayout)((LinearLayout)localObject).findViewById(2131429849));
    this.p = ((Button)((LinearLayout)localObject).findViewById(2131429896));
    this.q = ((Button)((LinearLayout)localObject).findViewById(2131429901));
    this.t = ((Button)((LinearLayout)localObject).findViewById(2131429895));
    paramBundle = (IPhoneContactService)this.h.getRuntimeService(IPhoneContactService.class, "");
    if ((paramBundle != null) && (!paramBundle.isBindContactOk())) {
      paramBundle.getSelfBindState();
    }
    if (this.f.mOnlyFriends)
    {
      this.l.setVisibility(8);
      if (this.f.isSupportSelectFriendGroup)
      {
        this.t.setVisibility(0);
        this.t.setOnClickListener(this);
      }
      else
      {
        this.t.setVisibility(8);
      }
    }
    else
    {
      if (this.f.mDonotNeedContacts) {
        this.m.setVisibility(8);
      } else if (this.f.getSharedPreferences(this.h.getCurrentAccountUin(), 0).getInt("select_member_contacts_flag", 0) == 1) {
        this.n.setOnClickListener(this);
      } else {
        this.m.setVisibility(8);
      }
      this.p.setOnClickListener(this);
      this.q.setOnClickListener(this);
    }
    if (AppSetting.e)
    {
      this.n.setContentDescription(this.f.getString(2131886298));
      this.p.setContentDescription(this.f.getString(2131886299));
    }
    this.r = ((Button)((LinearLayout)localObject).findViewById(2131429853));
    this.r.setOnClickListener(this);
    this.r.setText(this.f.getString(2131886294));
    this.r.setContentDescription(this.f.getString(2131886294));
    if (!this.f.getIntent().getBooleanExtra("multi_chat", false))
    {
      this.r.setVisibility(8);
      this.q.setVisibility(8);
    }
    if ((this.f.mDonotNeedTroop) && (this.f.mDonotNeedDiscussion)) {
      this.p.setVisibility(8);
    }
    this.v = new FriendTeamListInnerFrame.4(this);
    this.h.addObserver(this.v);
    bool = this.f.getIntent().getBooleanExtra("param_face_to_face_invite", false);
    this.u = this.f.getIntent().getStringExtra("group_uin");
    if (TextUtils.isEmpty(this.u)) {
      this.u = this.f.mGroupCode;
    }
    if (bool)
    {
      this.s = ((Button)((LinearLayout)localObject).findViewById(2131429852));
      this.s.setVisibility(0);
      this.s.setContentDescription(this.f.getString(2131886293));
      this.s.setOnClickListener(this);
    }
  }
  
  public void a(ResultRecord paramResultRecord, int paramInt)
  {
    super.a(paramResultRecord, paramInt);
    this.d.a(paramResultRecord, paramInt);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.f.setupTitleBar(false, this.f.getString(2131916208), this.f.mTitleString);
    f();
    this.f.addObserver(this.e);
    if ((this.f.mEntrance == 11) && (this.f.mType == 1))
    {
      paramBundle = ((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMemberListHandlerName();
      paramBundle = (ITroopMemberListHandler)this.h.getBusinessHandler(paramBundle);
      String str = this.f.getIntent().getStringExtra("group_uin");
      paramBundle.a(true, str, CommonUtils.e(this.h, str).troopcode, true, 7, System.currentTimeMillis(), ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).getSCENE_TYPE_DEFAULT_Value());
    }
  }
  
  public void c()
  {
    super.c();
    this.f.removeObserver(this.e);
  }
  
  public void d()
  {
    super.d();
    SelectMemberBuddyListAdapter localSelectMemberBuddyListAdapter = this.k;
    if (localSelectMemberBuddyListAdapter != null) {
      localSelectMemberBuddyListAdapter.b();
    }
    this.h.removeObserver(this.v);
  }
  
  public void f()
  {
    System.out.println("----->notifyDataSetChanged");
    SelectMemberBuddyListAdapter localSelectMemberBuddyListAdapter = this.k;
    if (localSelectMemberBuddyListAdapter != null) {
      localSelectMemberBuddyListAdapter.a();
    }
  }
  
  public ContactSearchFragment getContactSearchFragment()
  {
    int i2 = this.f.mInnerFrameManager.getCurrentPage();
    int i = 1;
    int i1 = 1;
    if (i2 == 0)
    {
      this.b = true;
      this.j.setFooterEnable(false);
    }
    if (!this.f.mOnlyFriends)
    {
      i = i1;
      if (!this.f.mDonotNeedDiscussion) {
        i = 5;
      }
      i1 = i;
      if (!this.f.mDonotNeedContacts) {
        i1 = i | 0x100;
      }
      i = i1;
      if (!this.f.mDonotNeedTroop) {
        i = i1 | 0x400000;
      }
    }
    if (this.f.mEntrance != 42)
    {
      i1 = i;
      if (this.f.mEntrance != 41) {}
    }
    else
    {
      i1 = 0x1000000 | 0x800000 | i;
    }
    return ContactSearchFragment.a(-1, i1, null, this.f.mUinsToHide, this.f);
  }
  
  public String getGroupUin()
  {
    return null;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = this.n;
    int i1 = 0;
    int i = 0;
    if (paramView == localObject)
    {
      this.g.a(1);
      this.c = false;
      ReportController.b(this.h, "CliOper", "", "", "Friends_select", "Fs_tab_clk", 0, 0, "1", "", "", "");
      if (this.f.mEntrance == 11) {
        ReportController.b(this.h, "CliOper", "", "", "0X8005525", "0X8005525", 0, 0, "", "", "", "");
      }
    }
    else
    {
      String str;
      if (paramView == this.p)
      {
        this.g.a(3);
        if (this.f.mSubType == 0) {
          ReportController.b(this.h, "CliOper", "", "", "0X8005441", "0X8005441", 1, 0, "", "", "", "");
        } else {
          ReportController.b(this.h, "CliOper", "", "", "0X8005441", "0X8005441", 2, 0, "", "", "", "");
        }
        if (this.f.mEntrance == 12)
        {
          ReportController.b(this.h, "CliOper", "", "", "0X8005A16", "0X8005A16", 0, 0, "", "", "", "");
          ReportController.b(this.h, "CliOper", "", "", "0X8006663", "0X8006663", 0, 0, "", "", "", "");
        }
        if (this.f.mSubType == 1)
        {
          localObject = CommonUtils.e(this.h, this.u);
          if (localObject != null)
          {
            str = this.h.getCurrentUin();
            if (!((TroopInfo)localObject).isTroopOwner(str)) {
              if (((TroopInfo)localObject).isTroopAdmin(str)) {
                i = 1;
              } else {
                i = 2;
              }
            }
            ReportController.b(this.h, "dc00899", "invite_friend", "", "friend_list", "clk_fromgrp", 0, 0, this.u, String.valueOf(i), "", "");
          }
        }
      }
      else if (paramView == this.q)
      {
        TroopCreateUtils.a(getContext());
        ReportController.b(this.h, "dc00899", "Grp_create", "", "msg_page", "clk_creategrp", 0, 0, "", "", "", "");
      }
      else if (paramView == this.r)
      {
        ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).startCreateFaceToFaceDiscussionActivity(this.f);
        ReportController.b(this.h, "CliOper", "", "", "0X8005440", "0X8005440", 0, 0, "", "", "", "");
        if (this.f.mEntrance == 12) {
          ReportController.b(this.h, "CliOper", "", "", "0X8006662", "0X8006662", 0, 0, "", "", "", "");
        }
      }
      else if (paramView == this.t)
      {
        this.g.a(8);
      }
      else if (paramView == this.s)
      {
        ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).startCreateCreateFaceToFaceInviteActivity(this.f, this.u);
        if (this.f.mSubType == 1)
        {
          localObject = CommonUtils.e(this.h, this.u);
          if (localObject != null)
          {
            str = this.h.getCurrentUin();
            if (((TroopInfo)localObject).isTroopOwner(str)) {
              i = i1;
            } else if (((TroopInfo)localObject).isTroopAdmin(str)) {
              i = 1;
            } else {
              i = 2;
            }
            ReportController.b(this.h, "dc00899", "invite_friend", "", "friend_list", "clk_near_invite", 0, 0, this.u, String.valueOf(i), "", "");
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.FriendTeamListInnerFrame
 * JD-Core Version:    0.7.0.1
 */