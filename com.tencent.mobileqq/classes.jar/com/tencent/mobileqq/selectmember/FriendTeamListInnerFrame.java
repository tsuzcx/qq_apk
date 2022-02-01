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
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private IFriendObserver jdField_a_of_type_ComTencentMobileqqFriendObserverIFriendObserver;
  private SelectMemberBuddyListAdapter jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberBuddyListAdapter;
  TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new FriendTeamListInnerFrame.5(this);
  RelationFriendsTroopViewHelper jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiRelationFriendsTroopViewHelper;
  private PinnedFooterExpandableListView jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView;
  private String jdField_a_of_type_JavaLangString;
  List<Entity> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  private Button jdField_b_of_type_AndroidWidgetButton;
  boolean jdField_b_of_type_Boolean = false;
  private Button c;
  private Button d;
  private Button e;
  private Button f;
  
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
  
  public ContactSearchFragment a()
  {
    int k = this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mInnerFrameManager.a();
    int i = 1;
    int j = 1;
    if (k == 0)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setFooterEnable(false);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mOnlyFriends)
    {
      i = j;
      if (!this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mDonotNeedDiscussion) {
        i = 5;
      }
      j = i;
      if (!this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mDonotNeedContacts) {
        j = i | 0x100;
      }
      i = j;
      if (!this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mDonotNeedTroop) {
        i = j | 0x400000;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mEntrance != 42)
    {
      j = i;
      if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mEntrance != 41) {}
    }
    else
    {
      j = 0x1000000 | 0x800000 | i;
    }
    return ContactSearchFragment.a(-1, j, null, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsToHide, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity);
  }
  
  public String a()
  {
    return null;
  }
  
  public void a()
  {
    super.a();
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null))
    {
      IPhoneContactService localIPhoneContactService = (IPhoneContactService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPhoneContactService.class, "");
      if (localIPhoneContactService != null)
      {
        int i = localIPhoneContactService.getSelfBindState();
        if ((i == 8) || (i == 9)) {
          try
          {
            this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(1);
            return;
          }
          finally
          {
            this.jdField_b_of_type_Boolean = false;
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
    paramBundle = a();
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView = ((PinnedFooterExpandableListView)paramBundle.getLayoutInflater().inflate(2131560456, null));
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("firstUserClicked is ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      QLog.d("FriendTeamListInnerFrameNew", 2, ((StringBuilder)localObject).toString());
    }
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setFooterEnable(true);
    } else {
      this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setFooterEnable(false);
    }
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setListener(new FriendTeamListInnerFrame.1(this));
    Object localObject = (LinearLayout)this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getLayoutInflater().inflate(2131560458, null);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.addHeaderView((View)localObject);
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, SearchUtils.a(12.0F, getResources()));
    View localView = new View(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity);
    localView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.addHeaderView(localView);
    QLog.d("FriendTeamListInnerFrameNew", 2, "----->onCreate");
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getIntent().getBooleanExtra("isExpandFirst", true);
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberBuddyListAdapter = new SelectMemberBuddyListAdapter(paramBundle, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView, new FriendTeamListInnerFrame.2(this), bool);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberBuddyListAdapter);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setSelector(2131167333);
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setGroupIndicator(a().getResources().getDrawable(2130839483));
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView.setOnScrollListener(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberBuddyListAdapter);
    setContentView(this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiRelationFriendsTroopViewHelper = new RelationFriendsTroopViewHelper(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView, new FriendTeamListInnerFrame.3(this));
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberBuddyListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiRelationFriendsTroopViewHelper);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((LinearLayout)localObject).findViewById(2131364196));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)((LinearLayout)localObject).findViewById(2131363898));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((LinearLayout)localObject).findViewById(2131378502));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((LinearLayout)localObject).findViewById(2131363899));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)((LinearLayout)localObject).findViewById(2131363941));
    this.c = ((Button)((LinearLayout)localObject).findViewById(2131363945));
    this.f = ((Button)((LinearLayout)localObject).findViewById(2131363940));
    paramBundle = (IPhoneContactService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPhoneContactService.class, "");
    if ((paramBundle != null) && (!paramBundle.isBindContactOk())) {
      paramBundle.getSelfBindState();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mOnlyFriends)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.isSupportSelectFriendGroup)
      {
        this.f.setVisibility(0);
        this.f.setOnClickListener(this);
      }
      else
      {
        this.f.setVisibility(8);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mDonotNeedContacts) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      } else if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getSharedPreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 0).getInt("select_member_contacts_flag", 0) == 1) {
        this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      } else {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.c.setOnClickListener(this);
    }
    if (AppSetting.d)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(2131689686));
      this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(2131689687));
    }
    this.d = ((Button)((LinearLayout)localObject).findViewById(2131363902));
    this.d.setOnClickListener(this);
    this.d.setText(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(2131689682));
    this.d.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(2131689682));
    if (!this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getIntent().getBooleanExtra("multi_chat", false))
    {
      this.d.setVisibility(8);
      this.c.setVisibility(8);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mDonotNeedTroop) && (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mDonotNeedDiscussion)) {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqFriendObserverIFriendObserver = new FriendTeamListInnerFrame.4(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverIFriendObserver);
    bool = this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getIntent().getBooleanExtra("param_face_to_face_invite", false);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getIntent().getStringExtra("group_uin");
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mGroupCode;
    }
    if (bool)
    {
      this.e = ((Button)((LinearLayout)localObject).findViewById(2131363901));
      this.e.setVisibility(0);
      this.e.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(2131689681));
      this.e.setOnClickListener(this);
    }
  }
  
  public void a(ResultRecord paramResultRecord, int paramInt)
  {
    super.a(paramResultRecord, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiRelationFriendsTroopViewHelper.a(paramResultRecord, paramInt);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.setupTitleBar(false, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(2131718706), this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mTitleString);
    f();
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    if ((this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mEntrance == 11) && (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mType == 1))
    {
      paramBundle = ((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMemberListHandlerName();
      paramBundle = (ITroopMemberListHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(paramBundle);
      String str = this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getIntent().getStringExtra("group_uin");
      paramBundle.a(true, str, CommonUtils.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, str).troopcode, true, 7, System.currentTimeMillis(), ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).getSCENE_TYPE_DEFAULT_Value());
    }
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
  }
  
  public void d()
  {
    super.d();
    SelectMemberBuddyListAdapter localSelectMemberBuddyListAdapter = this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberBuddyListAdapter;
    if (localSelectMemberBuddyListAdapter != null) {
      localSelectMemberBuddyListAdapter.b();
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverIFriendObserver);
  }
  
  public void f()
  {
    System.out.println("----->notifyDataSetChanged");
    SelectMemberBuddyListAdapter localSelectMemberBuddyListAdapter = this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberBuddyListAdapter;
    if (localSelectMemberBuddyListAdapter != null) {
      localSelectMemberBuddyListAdapter.a();
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetButton;
    int j = 0;
    int i = 0;
    if (paramView == localObject)
    {
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(1);
      this.jdField_b_of_type_Boolean = false;
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "Friends_select", "Fs_tab_clk", 0, 0, "1", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mEntrance == 11) {
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X8005525", "0X8005525", 0, 0, "", "", "", "");
      }
    }
    else
    {
      String str;
      if (paramView == this.jdField_b_of_type_AndroidWidgetButton)
      {
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(3);
        if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mSubType == 0) {
          ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X8005441", "0X8005441", 1, 0, "", "", "", "");
        } else {
          ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X8005441", "0X8005441", 2, 0, "", "", "", "");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mEntrance == 12)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X8005A16", "0X8005A16", 0, 0, "", "", "", "");
          ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X8006663", "0X8006663", 0, 0, "", "", "", "");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mSubType == 1)
        {
          localObject = CommonUtils.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString);
          if (localObject != null)
          {
            str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin();
            if (!((TroopInfo)localObject).isTroopOwner(str)) {
              if (((TroopInfo)localObject).isTroopAdmin(str)) {
                i = 1;
              } else {
                i = 2;
              }
            }
            ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00899", "invite_friend", "", "friend_list", "clk_fromgrp", 0, 0, this.jdField_a_of_type_JavaLangString, String.valueOf(i), "", "");
          }
        }
      }
      else if (paramView == this.c)
      {
        TroopCreateUtils.a(getContext());
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00899", "Grp_create", "", "msg_page", "clk_creategrp", 0, 0, "", "", "", "");
      }
      else if (paramView == this.d)
      {
        ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).startCreateFaceToFaceDiscussionActivity(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity);
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X8005440", "0X8005440", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mEntrance == 12) {
          ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X8006662", "0X8006662", 0, 0, "", "", "", "");
        }
      }
      else if (paramView == this.f)
      {
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(8);
      }
      else if (paramView == this.e)
      {
        ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).startCreateCreateFaceToFaceInviteActivity(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, this.jdField_a_of_type_JavaLangString);
        if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mSubType == 1)
        {
          localObject = CommonUtils.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_JavaLangString);
          if (localObject != null)
          {
            str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin();
            if (((TroopInfo)localObject).isTroopOwner(str)) {
              i = j;
            } else if (((TroopInfo)localObject).isTroopAdmin(str)) {
              i = 1;
            } else {
              i = 2;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00899", "invite_friend", "", "friend_list", "clk_near_invite", 0, 0, this.jdField_a_of_type_JavaLangString, String.valueOf(i), "", "");
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.FriendTeamListInnerFrame
 * JD-Core Version:    0.7.0.1
 */