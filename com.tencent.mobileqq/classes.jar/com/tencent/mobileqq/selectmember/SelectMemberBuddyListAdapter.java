package com.tencent.mobileqq.selectmember;

import Wallet.PfaFriend;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.listener.IPhoneContactListener;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qcircle.api.IQCircleFollowApi;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.transaction.IToPayManager;
import com.tencent.mobileqq.qwallet.transaction.IToPayManager.TopayListener;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.selectmember.adapter.BaseFacePreloadExpandableListAdapter;
import com.tencent.mobileqq.selectmember.util.CommonUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.troopcreate.RelationTroopEntity;
import com.tencent.mobileqq.troop.troopcreate.ui.RelationFriendsTroopViewHelper;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.TraceUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SelectMemberBuddyListAdapter
  extends BaseFacePreloadExpandableListAdapter
  implements View.OnClickListener, View.OnLongClickListener, IPhoneContactListener, IToPayManager.TopayListener
{
  private static final SelectMemberBuddyListAdapter.MyComparator jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberBuddyListAdapter$MyComparator = new SelectMemberBuddyListAdapter.MyComparator(null);
  private final int jdField_a_of_type_Int;
  private final Context jdField_a_of_type_AndroidContentContext;
  private final SparseArray<ArrayList<Entity>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private final AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private IPhoneContactService jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService = null;
  private IToPayManager jdField_a_of_type_ComTencentMobileqqQwalletTransactionIToPayManager;
  protected SelectMemberActivity a;
  SelectMemberBuddyListAdapter.TroopMemberFaceUtil jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberBuddyListAdapter$TroopMemberFaceUtil;
  private RelationFriendsTroopViewHelper jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiRelationFriendsTroopViewHelper;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  ArrayList<Entity> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int;
  private final View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  private ExpandableListView jdField_b_of_type_ComTencentWidgetExpandableListView;
  private final ArrayList<Groups> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private final boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public SelectMemberBuddyListAdapter(Context paramContext, AppInterface paramAppInterface, ExpandableListView paramExpandableListView, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    super(paramContext, paramAppInterface, paramExpandableListView);
    boolean bool = true;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberBuddyListAdapter$TroopMemberFaceUtil = null;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new SelectMemberBuddyListAdapter.3(this);
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity = ((SelectMemberActivity)paramContext);
    this.jdField_a_of_type_ComTencentMobileqqQwalletTransactionIToPayManager = ((IToPayManager)QRoute.api(IToPayManager.class));
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService = ((IPhoneContactService)paramAppInterface.getRuntimeService(IPhoneContactService.class, ""));
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_ComTencentWidgetExpandableListView = paramExpandableListView;
    paramContext = this.jdField_b_of_type_ComTencentWidgetExpandableListView;
    if (paramContext != null) {
      paramContext.post(new SelectMemberBuddyListAdapter.1(this));
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mDonotNeedContacts) {
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.addListener(this);
    }
    this.jdField_a_of_type_Int = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 12.0F));
    this.jdField_b_of_type_Int = ((int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 9.0F));
    if ((Build.MODEL.equals("Lenovo A366t")) && (Build.VERSION.SDK_INT == 10)) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (((Groups)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt1)).group_id == 1002) {
      return 1;
    }
    if (((Groups)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt1)).group_id == 1008) {
      return 2;
    }
    return 0;
  }
  
  private View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560455, paramViewGroup, false);
      paramViewGroup = new SelectBuddyChildTag();
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368343));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131371697));
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131364613));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131379859);
      localObject1 = this.jdField_a_of_type_AndroidViewView$OnClickListener;
      if (localObject1 != null) {
        paramView.setOnClickListener((View.OnClickListener)localObject1);
      }
      paramView.findViewById(2131379732).setVisibility(8);
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (SelectBuddyChildTag)paramView.getTag();
      paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
    Object localObject1 = getChild(paramInt1, paramInt2);
    paramViewGroup.jdField_a_of_type_JavaLangObject = localObject1;
    paramViewGroup.jdField_a_of_type_Long = getGroupId(paramInt1);
    Object localObject2;
    if ((localObject1 instanceof TroopMemberInfo))
    {
      localObject2 = (TroopMemberInfo)localObject1;
      if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberBuddyListAdapter$TroopMemberFaceUtil == null) {
        this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberBuddyListAdapter$TroopMemberFaceUtil = new SelectMemberBuddyListAdapter.TroopMemberFaceUtil(this, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      }
      paramViewGroup.jdField_a_of_type_JavaLangString = ((TroopMemberInfo)localObject2).memberuin;
      localObject1 = CommonUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((TroopMemberInfo)localObject2).troopuin, ((TroopMemberInfo)localObject2).memberuin);
      a(paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberBuddyListAdapter$TroopMemberFaceUtil.a((TroopMemberInfo)localObject2));
    }
    else
    {
      localObject2 = (Friends)localObject1;
      localObject1 = CommonUtils.a((Friends)localObject2);
      paramViewGroup.jdField_a_of_type_JavaLangString = ((Friends)localObject2).uin;
      a(paramViewGroup, null);
    }
    if (paramViewGroup.jdField_a_of_type_AndroidViewView != null) {
      if (CommonUtils.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramViewGroup.jdField_a_of_type_JavaLangString)) {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      } else {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
    paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
    paramViewGroup.d.setText((CharSequence)localObject1);
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.isResultListContainFriend(paramViewGroup.jdField_a_of_type_JavaLangString)) {
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
    } else {
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsSelectedDefault != null) && (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsSelectedDefault.contains(paramViewGroup.jdField_a_of_type_JavaLangString))) {
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
    } else {
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
    }
    if ((AppSetting.d) && (paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
    {
      if (paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
      {
        paramViewGroup = new StringBuilder();
        paramViewGroup.append((String)localObject1);
        paramViewGroup.append(HardCodeUtil.a(2131713654));
        paramView.setContentDescription(paramViewGroup.toString());
        return paramView;
      }
      paramViewGroup = new StringBuilder();
      paramViewGroup.append((String)localObject1);
      paramViewGroup.append(HardCodeUtil.a(2131713631));
      paramView.setContentDescription(paramViewGroup.toString());
    }
    return paramView;
  }
  
  private void a(List<SelectMemberBuddyListAdapter.FriendHolder> paramList)
  {
    try
    {
      Collections.sort(paramList, jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberBuddyListAdapter$MyComparator);
      return;
    }
    catch (ArrayIndexOutOfBoundsException paramList)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 2, "", paramList);
      }
    }
  }
  
  private View b(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560455, paramViewGroup, false);
      paramViewGroup = new SelectBuddyChildTag();
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368343));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131371697));
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131364613));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131379859);
      localObject1 = this.jdField_a_of_type_AndroidViewView$OnClickListener;
      if (localObject1 != null) {
        paramView.setOnClickListener((View.OnClickListener)localObject1);
      }
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (SelectBuddyChildTag)paramView.getTag();
      paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
    Object localObject2 = getChild(paramInt1, paramInt2);
    Object localObject1 = (PhoneContact)localObject2;
    paramViewGroup.jdField_a_of_type_JavaLangObject = localObject2;
    paramViewGroup.jdField_a_of_type_JavaLangString = ((PhoneContact)localObject1).mobileCode;
    a(paramViewGroup, null);
    if (paramViewGroup.jdField_a_of_type_AndroidViewView != null) {
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
    paramViewGroup.d.setText(((PhoneContact)localObject1).name);
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.isResultListContainFriend(paramViewGroup.jdField_a_of_type_JavaLangString)) {
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
    } else {
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsSelectedDefault != null) && (!"0".equals(((PhoneContact)localObject1).uin)) && (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsSelectedDefault.contains(((PhoneContact)localObject1).uin))) {
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
    } else {
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
    }
    if ((AppSetting.d) && (paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
    {
      if (paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
      {
        paramViewGroup = new StringBuilder();
        paramViewGroup.append(((PhoneContact)localObject1).name);
        paramViewGroup.append(HardCodeUtil.a(2131713646));
        paramView.setContentDescription(paramViewGroup.toString());
        return paramView;
      }
      paramViewGroup = new StringBuilder();
      paramViewGroup.append(((PhoneContact)localObject1).name);
      paramViewGroup.append(HardCodeUtil.a(2131713660));
      paramView.setContentDescription(paramViewGroup.toString());
    }
    return paramView;
  }
  
  private View c(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if ((paramView != null) && (!(paramView.getTag() instanceof SelectBuddyChildTag)))
    {
      paramViewGroup = (SelectMemberBuddyListAdapter.PublicAccountChildTag)paramView.getTag();
      paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
    else
    {
      localObject1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559615, paramViewGroup, false);
      localObject2 = new SelectMemberBuddyListAdapter.PublicAccountChildTag();
      ((SelectMemberBuddyListAdapter.PublicAccountChildTag)localObject2).jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131368343));
      ((SelectMemberBuddyListAdapter.PublicAccountChildTag)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131366952));
      ((SelectMemberBuddyListAdapter.PublicAccountChildTag)localObject2).d = ((TextView)((View)localObject1).findViewById(2131378461));
      ((SelectMemberBuddyListAdapter.PublicAccountChildTag)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131373219));
      ((SelectMemberBuddyListAdapter.PublicAccountChildTag)localObject2).jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131373202));
      ((SelectMemberBuddyListAdapter.PublicAccountChildTag)localObject2).b = ((TextView)((View)localObject1).findViewById(2131373229));
      ((SelectMemberBuddyListAdapter.PublicAccountChildTag)localObject2).e = ((TextView)((View)localObject1).findViewById(2131378463));
      ((View)localObject1).setTag(localObject2);
      View.OnClickListener localOnClickListener = this.jdField_a_of_type_AndroidViewView$OnClickListener;
      paramView = (View)localObject1;
      paramViewGroup = (ViewGroup)localObject2;
      if (localOnClickListener != null)
      {
        ((View)localObject1).setOnClickListener(localOnClickListener);
        paramViewGroup = (ViewGroup)localObject2;
        paramView = (View)localObject1;
      }
    }
    Object localObject2 = getChild(paramInt1, paramInt2);
    paramViewGroup.jdField_a_of_type_JavaLangObject = localObject2;
    paramViewGroup.jdField_a_of_type_JavaLangString = Long.toString(((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).getPublicAccountInfoUin(localObject2));
    paramViewGroup.d.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167056));
    if (((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).isPublicAccountInfoLooker(localObject2))
    {
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewGroup.d.setVisibility(8);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramViewGroup.b.setVisibility(8);
      paramViewGroup.e.setVisibility(8);
    }
    else
    {
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      paramViewGroup.d.setVisibility(0);
      paramViewGroup.e.setVisibility(0);
      localObject1 = ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).getPublicAccountInfoName(localObject2);
      long l = ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).getPublicAccountInfoCertifiedGrade(localObject2);
      localObject2 = ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).getPublicAccountInfoSummary(localObject2);
      paramViewGroup.d.setText((CharSequence)localObject1);
      if (l > 0L)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130841838);
      }
      else
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      paramViewGroup.e.setText((CharSequence)localObject2);
      a(paramViewGroup, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramViewGroup.b.setVisibility(8);
    }
    if (AppSetting.d) {
      paramView.setContentDescription(paramViewGroup.d.getText());
    }
    return paramView;
  }
  
  private void c()
  {
    boolean bool2 = this.c;
    boolean bool1 = true;
    if (!bool2) {
      this.c = true;
    } else {
      bool1 = false;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqQwalletTransactionIToPayManager.getTopayList(this, bool1, 0, 0);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqQwalletTransactionIToPayManager;
    Object localObject3 = ((HashMap)localObject2).get("recommend");
    localObject1 = null;
    if (localObject3 != null) {
      localObject1 = (ArrayList)localObject3;
    }
    localObject3 = this.jdField_a_of_type_ComTencentMobileqqQwalletTransactionIToPayManager;
    localObject2 = ((HashMap)localObject2).get("tips");
    if (localObject2 != null) {
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mTopayTips = ((ArrayList)localObject2);
    }
    if (localObject1 != null)
    {
      localObject3 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
      localObject2 = new ArrayList();
      localObject1 = ((ArrayList)localObject1).iterator();
    }
    for (;;)
    {
      Object localObject4;
      if (((Iterator)localObject1).hasNext())
      {
        localObject4 = (PfaFriend)((Iterator)localObject1).next();
        if (localObject4 == null) {}
      }
      else
      {
        try
        {
          if ((((PfaFriend)localObject4).uin == null) || (((PfaFriend)localObject4).uin.equals(localObject3)) || (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsToHide.contains(((PfaFriend)localObject4).uin))) {
            continue;
          }
          localObject4 = SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((PfaFriend)localObject4).uin);
          if ((localObject4 == null) || (!((Friends)localObject4).isFriend()) || (CommonUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((Friends)localObject4).uin))) {
            continue;
          }
          ((ArrayList)localObject2).add(localObject4);
        }
        catch (Exception localException) {}
        if (!((ArrayList)localObject2).isEmpty())
        {
          localObject1 = new Groups();
          ((Groups)localObject1).group_id = 1003;
          ((Groups)localObject1).group_name = this.jdField_a_of_type_AndroidContentContext.getString(2131692652);
          ((Groups)localObject1).group_friend_count = ((ArrayList)localObject2).size();
          ((Groups)localObject1).seqid = 0;
          this.jdField_b_of_type_JavaUtilArrayList.add(localObject1);
          this.jdField_a_of_type_AndroidUtilSparseArray.put(((Groups)localObject1).group_id, localObject2);
        }
        return;
      }
    }
  }
  
  private void d()
  {
    Object localObject1 = ((IRecentUserProxyService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    Object localObject3;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject3 = ((RecentUserProxy)localObject1).a(true);
      if (localObject3 != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
        localObject1 = new ArrayList();
        localObject3 = ((List)localObject3).iterator();
      }
    }
    for (;;)
    {
      Object localObject4;
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (RecentUser)((Iterator)localObject3).next();
        if (localObject4 == null) {}
      }
      else
      {
        try
        {
          if ((((RecentUser)localObject4).getType() != 0) || (Long.parseLong(((RecentUser)localObject4).uin) < 10000L) || (((RecentUser)localObject4).uin.equals(localObject2)) || (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsToHide.contains(((RecentUser)localObject4).uin)) || (Utils.b(((RecentUser)localObject4).uin)) || ((this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mFilterRobot) && (CommonUtils.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((RecentUser)localObject4).uin)))) {
            continue;
          }
          localObject4 = SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((RecentUser)localObject4).uin);
          if ((localObject4 == null) || (!((Friends)localObject4).isFriend()) || (CommonUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((Friends)localObject4).uin))) {
            continue;
          }
          ((ArrayList)localObject1).add(localObject4);
        }
        catch (NumberFormatException localNumberFormatException) {}
        if (!((ArrayList)localObject1).isEmpty())
        {
          localObject2 = new Groups();
          ((Groups)localObject2).group_id = 1003;
          ((Groups)localObject2).group_name = this.jdField_a_of_type_AndroidContentContext.getString(2131718136);
          ((Groups)localObject2).group_friend_count = ((ArrayList)localObject1).size();
          ((Groups)localObject2).seqid = 0;
          this.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
          this.jdField_a_of_type_AndroidUtilSparseArray.put(((Groups)localObject2).group_id, localObject1);
        }
        return;
      }
    }
  }
  
  private void e()
  {
    Object localObject = ((IQCircleFollowApi)QRoute.api(IQCircleFollowApi.class)).getCircleFriendMap();
    if (localObject != null)
    {
      if (((Map)localObject).isEmpty()) {
        return;
      }
      int i = 1100;
      Iterator localIterator = ((Map)localObject).entrySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (Map.Entry)localIterator.next();
        if (i >= 1150)
        {
          QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 1, "[addCircleFriendList] current group id is max, not append.");
          break;
        }
        String str = (String)((Map.Entry)localObject).getKey();
        List localList = (List)((Map.Entry)localObject).getValue();
        if ((localList != null) && (!localList.isEmpty()))
        {
          if ((localList instanceof ArrayList)) {
            localObject = (ArrayList)localList;
          } else {
            localObject = new ArrayList(localList);
          }
          Groups localGroups = new Groups();
          localGroups.group_name = str;
          localGroups.group_id = i;
          int j = 0;
          localGroups.seqid = 0;
          if (localList != null) {
            j = ((ArrayList)localObject).size();
          }
          localGroups.group_friend_count = j;
          this.jdField_b_of_type_JavaUtilArrayList.add(localGroups);
          this.jdField_a_of_type_AndroidUtilSparseArray.put(localGroups.group_id, localObject);
          i += 1;
        }
      }
      f();
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mEntrance == 42)
    {
      localHashMap = new HashMap();
      localHashMap.put("ext1", "2");
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 41, 1, 1, localHashMap, null, null);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("ext1", "1");
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504("", 41, 1, 1, localHashMap, null, null);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mIntent.getStringExtra("group_name");
    Groups localGroups = new Groups();
    localGroups.group_id = 1006;
    localGroups.group_name = ((String)localObject);
    localGroups.group_friend_count = this.jdField_a_of_type_JavaUtilArrayList.size();
    localGroups.seqid = 0;
    this.jdField_b_of_type_JavaUtilArrayList.add(localGroups);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(localGroups.group_id, this.jdField_a_of_type_JavaUtilArrayList);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addCurGroup, mGroupmembers[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilArrayList.size());
      ((StringBuilder)localObject).append("]");
      QLog.w("FriendTeamListInnerFrameBuddyListAdapter", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mDonotNeedContacts) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.getSelfBindState();
    if ((this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.isBindContactOk()) || (i == 8))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.getBindNonfriendList();
      if (localObject != null)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll((Collection)localObject);
        if (!localArrayList.isEmpty())
        {
          localObject = new Groups();
          ((Groups)localObject).group_id = 1002;
          ((Groups)localObject).group_name = this.jdField_a_of_type_AndroidContentContext.getString(2131694786);
          ((Groups)localObject).group_friend_count = 1;
          ((Groups)localObject).seqid = 0;
          this.jdField_b_of_type_JavaUtilArrayList.add(localObject);
          this.jdField_a_of_type_AndroidUtilSparseArray.put(((Groups)localObject).group_id, localArrayList);
        }
      }
    }
  }
  
  private void i()
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiRelationFriendsTroopViewHelper.a(this.jdField_b_of_type_JavaUtilArrayList, this.jdField_a_of_type_AndroidUtilSparseArray);
    if ((this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mEntrance == 11) && (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mType == 1)) {
      g();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mEntrance == 33) {
      c();
    } else {
      d();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mEntrance == 42) || (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mEntrance == 41)) {
      e();
    }
    h();
    ArrayList localArrayList = (ArrayList)((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).asyncGetGroupListForUI(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    Object localObject1;
    if (localArrayList != null)
    {
      localObject1 = localArrayList;
      if (localArrayList.size() != 0) {}
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("group list is ");
        if (localArrayList == null) {
          localObject1 = "null";
        } else {
          localObject1 = "empty";
        }
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = localArrayList;
      if (localArrayList == null) {
        localObject1 = new ArrayList();
      }
    }
    Object localObject2 = ((List)localObject1).iterator();
    for (;;)
    {
      boolean bool = ((Iterator)localObject2).hasNext();
      int i = 0;
      if (!bool) {
        break;
      }
      Groups localGroups = (Groups)((Iterator)localObject2).next();
      this.jdField_b_of_type_JavaUtilArrayList.add(localGroups);
      localArrayList = SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, String.valueOf(localGroups.group_id));
      if (localArrayList == null) {
        localArrayList = new ArrayList();
      } else {
        localArrayList = new ArrayList(localArrayList);
      }
      Object localObject3 = new ArrayList();
      Object localObject4 = localArrayList.iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((ArrayList)localObject3).add(new SelectMemberBuddyListAdapter.FriendHolder((Friends)((Iterator)localObject4).next(), -1));
      }
      a((List)localObject3);
      localArrayList.clear();
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        localArrayList.add(((SelectMemberBuddyListAdapter.FriendHolder)((Iterator)localObject3).next()).a);
      }
      localObject3 = localArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Friends)((Iterator)localObject3).next();
        if (OnlineStatusUtils.a(((Friends)localObject4).detalStatusFlag, ((Friends)localObject4).iTermType) == 0) {}
      }
      localObject3 = new ArrayList();
      while (i < localArrayList.size())
      {
        localObject4 = (Friends)localArrayList.get(i);
        if ((!((Friends)localObject4).uin.equals(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin())) && (!this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsToHide.contains(((Friends)localObject4).uin)) && (!Utils.b(((Friends)localObject4).uin)) && (!CommonUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((Friends)localObject4).uin)) && ((!this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mFilterRobot) || (!CommonUtils.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((Friends)localObject4).uin)))) {
          ((ArrayList)localObject3).add(localArrayList.get(i));
        }
        i += 1;
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(localGroups.group_id, localObject3);
    }
    if ((this.jdField_b_of_type_ComTencentWidgetExpandableListView != null) && (!((List)localObject1).isEmpty()) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_b_of_type_ComTencentWidgetExpandableListView.expandGroup(0);
    }
  }
  
  public Groups a(long paramLong)
  {
    int i = 0;
    while (i < this.jdField_b_of_type_JavaUtilArrayList.size())
    {
      Groups localGroups = (Groups)this.jdField_b_of_type_JavaUtilArrayList.get(i);
      if (localGroups.group_id == paramLong) {
        return localGroups;
      }
      i += 1;
    }
    return null;
  }
  
  public void a()
  {
    super.notifyDataSetChanged();
  }
  
  public void a(int paramInt)
  {
    notifyDataSetChanged();
  }
  
  public void a(long paramLong) {}
  
  public void a(RelationFriendsTroopViewHelper paramRelationFriendsTroopViewHelper)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiRelationFriendsTroopViewHelper = paramRelationFriendsTroopViewHelper;
  }
  
  public void a(ArrayList<Entity> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecommendCountChanged count=");
      localStringBuilder.append(paramInt);
      QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 2, localStringBuilder.toString());
    }
    notifyDataSetChanged();
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mDonotNeedContacts) {
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.removeListener(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mEntrance == 33) {
      this.jdField_a_of_type_ComTencentMobileqqQwalletTransactionIToPayManager.removeObserver(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    SelectMemberBuddyListAdapter.TroopMemberFaceUtil localTroopMemberFaceUtil = this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberBuddyListAdapter$TroopMemberFaceUtil;
    if (localTroopMemberFaceUtil != null)
    {
      localTroopMemberFaceUtil.a();
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberBuddyListAdapter$TroopMemberFaceUtil = null;
    }
    this.jdField_b_of_type_ComTencentWidgetExpandableListView = null;
    super.b();
  }
  
  public void b(int paramInt) {}
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateContactList, ");
      localStringBuilder.append(paramInt);
      QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 2, localStringBuilder.toString());
    }
    notifyDataSetChanged();
  }
  
  public void configHeaderView(View paramView, int paramInt)
  {
    Object localObject2 = (SelectMemberBuddyListAdapter.GroupTag)paramView.getTag();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new SelectMemberBuddyListAdapter.GroupTag();
      paramView.findViewById(2131369353).setVisibility(0);
      ((SelectMemberBuddyListAdapter.GroupTag)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367855));
      paramView.setTag(localObject1);
    }
    localObject2 = (Groups)getGroup(paramInt);
    ((SelectMemberBuddyListAdapter.GroupTag)localObject1).jdField_a_of_type_AndroidWidgetTextView.setText(((Groups)localObject2).group_name);
    if (this.jdField_b_of_type_ComTencentWidgetExpandableListView != null) {
      ((CheckBox)paramView.findViewById(2131369353)).setChecked(this.jdField_b_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(paramInt));
    }
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    int i = ((Groups)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt1)).group_id;
    ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    if ((paramInt2 < localArrayList.size()) && (paramInt2 >= 0)) {
      return localArrayList.get(paramInt2);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getChild error,members.size = ");
    localStringBuilder.append(localArrayList.size());
    localStringBuilder.append(",childPositon = ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("，groupPosition = ");
    localStringBuilder.append(paramInt1);
    QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 1, localStringBuilder.toString());
    return null;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    Object localObject = getChild(paramInt1, paramInt2);
    boolean bool = localObject instanceof Friends;
    long l1 = 0L;
    long l2;
    if (bool)
    {
      localObject = (Friends)localObject;
      try
      {
        l2 = Long.parseLong(((Friends)localObject).uin);
        return l2;
      }
      catch (Throwable localThrowable1)
      {
        if (!QLog.isColorLevel()) {
          break label184;
        }
      }
      QLog.i("FriendTeamListInnerFrameBuddyListAdapter", 2, QLog.getStackTraceString(localThrowable1));
      return 0L;
    }
    else
    {
      if (((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).isPublicAccountInfoInstance(localThrowable1)) {
        return ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).getPublicAccountInfoUin(localThrowable1);
      }
      if ((localThrowable1 instanceof TroopMemberInfo))
      {
        TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)localThrowable1;
        try
        {
          l2 = Long.parseLong(localTroopMemberInfo.memberuin);
          return l2;
        }
        catch (Throwable localThrowable2)
        {
          if (!QLog.isColorLevel()) {
            break label184;
          }
        }
        QLog.i("FriendTeamListInnerFrameBuddyListAdapter", 2, QLog.getStackTraceString(localThrowable2));
        return 0L;
      }
      else if ((localThrowable2 instanceof RelationTroopEntity))
      {
        RelationTroopEntity localRelationTroopEntity = (RelationTroopEntity)localThrowable2;
        l1 = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiRelationFriendsTroopViewHelper.a(localRelationTroopEntity.troopInfo.troopuin).longValue();
      }
    }
    label184:
    return l1;
  }
  
  public int getChildType(int paramInt1, int paramInt2)
  {
    return a(paramInt1, paramInt2);
  }
  
  public int getChildTypeCount()
  {
    return 2;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    TraceUtils.traceBegin("getChildView");
    if (a(paramInt1, paramInt2) == 0)
    {
      paramView = a(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
    }
    else if (a(paramInt1, paramInt2) == 1)
    {
      paramView = b(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
    }
    else if (a(paramInt1, paramInt2) == 2)
    {
      RelationTroopEntity localRelationTroopEntity = (RelationTroopEntity)getChild(paramInt1, paramInt2);
      paramView = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiRelationFriendsTroopViewHelper.b(paramInt1, paramInt2, paramView, paramViewGroup, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, this.jdField_a_of_type_AndroidViewView$OnClickListener, localRelationTroopEntity);
    }
    else
    {
      paramView = c(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
    }
    TraceUtils.traceEnd();
    return paramView;
  }
  
  public int getChildrenCount(int paramInt)
  {
    Groups localGroups = (Groups)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
    if ((localGroups != null) && (this.jdField_a_of_type_AndroidUtilSparseArray.get(localGroups.group_id) != null)) {
      return ((ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(((Groups)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt)).group_id)).size();
    }
    return 0;
  }
  
  public Object getGroup(int paramInt)
  {
    return this.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public int getGroupCount()
  {
    return this.jdField_b_of_type_JavaUtilArrayList.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return ((Groups)getGroup(paramInt)).group_id;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      paramViewGroup = (SelectMemberBuddyListAdapter.GroupTag)paramView.getTag();
    }
    else
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560454, paramViewGroup, false);
      paramViewGroup = new SelectMemberBuddyListAdapter.GroupTag();
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367855));
      paramView.setTag(paramViewGroup);
      paramView.setOnClickListener(this);
    }
    Groups localGroups = (Groups)getGroup(paramInt);
    paramViewGroup.jdField_a_of_type_Int = paramInt;
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localGroups.group_name);
    if (AppSetting.d) {
      if (paramBoolean)
      {
        paramViewGroup = new StringBuilder();
        paramViewGroup.append(localGroups.group_name);
        paramViewGroup.append(HardCodeUtil.a(2131713650));
        paramView.setContentDescription(paramViewGroup.toString());
      }
      else
      {
        paramViewGroup = new StringBuilder();
        paramViewGroup.append(localGroups.group_name);
        paramViewGroup.append(HardCodeUtil.a(2131713641));
        paramView.setContentDescription(paramViewGroup.toString());
      }
    }
    paramView.setOnLongClickListener(this);
    return paramView;
  }
  
  public int getHeaderViewLayoutResourceId()
  {
    return 2131558917;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void notifyDataSetChanged()
  {
    i();
    super.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    Object localObject = (SelectMemberBuddyListAdapter.GroupTag)paramView.getTag();
    if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(((SelectMemberBuddyListAdapter.GroupTag)localObject).jdField_a_of_type_Int)) {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.collapseGroup(((SelectMemberBuddyListAdapter.GroupTag)localObject).jdField_a_of_type_Int);
    }
    try
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.expandGroup(((SelectMemberBuddyListAdapter.GroupTag)localObject).jdField_a_of_type_Int);
      localObject = (Groups)getGroup(((SelectMemberBuddyListAdapter.GroupTag)localObject).jdField_a_of_type_Int);
      if (((Groups)localObject).group_id == 1003)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mSubType == 0) {
          ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X8005442", "0X8005442", 1, 0, "", "", "", "");
        } else {
          ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X8005442", "0X8005442", 2, 0, "", "", "", "");
        }
      }
      else if (((Groups)localObject).group_id == 1002)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mSubType == 0) {
          ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X8005444", "0X8005444", 1, 0, "", "", "", "");
        } else {
          ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X8005444", "0X8005444", 2, 0, "", "", "", "");
        }
      }
      else if (((Groups)localObject).group_id == 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mSubType == 0) {
          ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X8005443", "0X8005443", 1, 0, "", "", "", "");
        } else {
          ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X8005443", "0X8005443", 2, 0, "", "", "", "");
        }
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mSubType == 0) {
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X8005445", "0X8005445", 1, 0, "", "", "", "");
      } else {
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X8005445", "0X8005445", 2, 0, "", "", "", "");
      }
    }
    catch (Throwable localThrowable)
    {
      label389:
      break label389;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(0, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131693091));
    ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).showAsDropDown(paramView, localQQCustomMenu, this.jdField_b_of_type_AndroidViewView$OnClickListener, new SelectMemberBuddyListAdapter.2(this));
    return true;
  }
  
  public void onRefreshTopayList(boolean paramBoolean)
  {
    SelectMemberActivity localSelectMemberActivity = this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity;
    if (localSelectMemberActivity != null)
    {
      if (localSelectMemberActivity.isFinishing()) {
        return;
      }
      notifyDataSetChanged();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    AbsListView.OnScrollListener localOnScrollListener = this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    AbsListView.OnScrollListener localOnScrollListener = this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectMemberBuddyListAdapter
 * JD-Core Version:    0.7.0.1
 */