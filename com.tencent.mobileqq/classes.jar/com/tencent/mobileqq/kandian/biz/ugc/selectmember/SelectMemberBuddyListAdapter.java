package com.tencent.mobileqq.kandian.biz.ugc.selectmember;

import android.content.Context;
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
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.adapter.BaseFacePreloadExpandableListAdapter;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import com.tencent.mobileqq.kandian.biz.ugc.databinding.ObservableArrayList;
import com.tencent.mobileqq.kandian.biz.ugc.databinding.ObservableList.OnListChangedCallback;
import com.tencent.mobileqq.kandian.repo.ugc.ResultRecord;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.listener.IPhoneContactListener;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.TraceUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SelectMemberBuddyListAdapter
  extends BaseFacePreloadExpandableListAdapter
  implements View.OnClickListener, View.OnLongClickListener, ObservableList.OnListChangedCallback<ObservableArrayList<ResultRecord>>, IPhoneContactListener
{
  private static final SelectMemberBuddyListAdapter.MyComparator jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberBuddyListAdapter$MyComparator = new SelectMemberBuddyListAdapter.MyComparator(null);
  private final int jdField_a_of_type_Int;
  protected final Context a;
  private final SparseArray<List<Entity>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected ObservableArrayList<ResultRecord> a;
  private IPhoneContactService jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService = null;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private final ArrayList<Groups> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int;
  private final View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new SelectMemberBuddyListAdapter.1(this);
  private ExpandableListView jdField_b_of_type_ComTencentWidgetExpandableListView;
  private final boolean jdField_b_of_type_Boolean;
  private final View.OnClickListener c;
  
  public SelectMemberBuddyListAdapter(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    boolean bool = true;
    this.jdField_a_of_type_Boolean = true;
    this.c = new SelectMemberBuddyListAdapter.4(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService = ((IPhoneContactService)paramQQAppInterface.getRuntimeService(IPhoneContactService.class));
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_ComTencentWidgetExpandableListView = paramExpandableListView;
    paramExpandableListView.post(new SelectMemberBuddyListAdapter.2(this));
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
    if (((Groups)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).group_id == 1002) {
      return 1;
    }
    return 0;
  }
  
  private void a(List<SelectMemberBuddyListAdapter.FriendHolder> paramList)
  {
    try
    {
      Collections.sort(paramList, jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberBuddyListAdapter$MyComparator);
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
      paramViewGroup = new SelectMemberBuddyListAdapter.SelectBuddyChildTag();
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368343));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131371697));
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131364613));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131379859);
      localObject1 = this.jdField_b_of_type_AndroidViewView$OnClickListener;
      if (localObject1 != null) {
        paramView.setOnClickListener((View.OnClickListener)localObject1);
      }
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (SelectMemberBuddyListAdapter.SelectBuddyChildTag)paramView.getTag();
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
    if ((AppSetting.d) && (paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
    {
      if (paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
      {
        paramViewGroup = new StringBuilder();
        paramViewGroup.append(((PhoneContact)localObject1).name);
        paramViewGroup.append(HardCodeUtil.a(2131713649));
        paramView.setContentDescription(paramViewGroup.toString());
        return paramView;
      }
      paramViewGroup = new StringBuilder();
      paramViewGroup.append(((PhoneContact)localObject1).name);
      paramViewGroup.append(HardCodeUtil.a(2131713663));
      paramView.setContentDescription(paramViewGroup.toString());
    }
    return paramView;
  }
  
  private void b()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    Object localObject3;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject3 = ((RecentUserProxy)localObject1).a(true);
      if (localObject3 != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
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
          if ((((RecentUser)localObject4).getType() != 0) || (Long.parseLong(((RecentUser)localObject4).uin) < 10000L) || (((RecentUser)localObject4).uin.equals(localObject2)) || (Utils.b(((RecentUser)localObject4).uin))) {
            continue;
          }
          localObject4 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(((RecentUser)localObject4).uin);
          if ((localObject4 == null) || (!((Friends)localObject4).isFriend()) || (QidianManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((Friends)localObject4).uin))) {
            continue;
          }
          ((List)localObject1).add(localObject4);
        }
        catch (NumberFormatException localNumberFormatException) {}
        if (!((List)localObject1).isEmpty())
        {
          localObject2 = new Groups();
          ((Groups)localObject2).group_id = 1003;
          ((Groups)localObject2).group_name = this.jdField_a_of_type_AndroidContentContext.getString(2131718136);
          ((Groups)localObject2).group_friend_count = ((List)localObject1).size();
          ((Groups)localObject2).seqid = 0;
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          this.jdField_a_of_type_AndroidUtilSparseArray.put(((Groups)localObject2).group_id, localObject1);
        }
        return;
      }
    }
  }
  
  private View c(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView != null) && (!(paramView.getTag() instanceof SelectMemberBuddyListAdapter.SelectBuddyChildTag)))
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
      View.OnClickListener localOnClickListener = this.jdField_b_of_type_AndroidViewView$OnClickListener;
      paramView = (View)localObject1;
      paramViewGroup = (ViewGroup)localObject2;
      if (localOnClickListener != null)
      {
        ((View)localObject1).setOnClickListener(localOnClickListener);
        paramViewGroup = (ViewGroup)localObject2;
        paramView = (View)localObject1;
      }
    }
    Object localObject1 = getChild(paramInt1, paramInt2);
    Object localObject2 = (PublicAccountInfo)localObject1;
    paramViewGroup.jdField_a_of_type_JavaLangObject = localObject1;
    paramViewGroup.jdField_a_of_type_JavaLangString = Long.toString(((PublicAccountInfo)localObject2).uin);
    paramViewGroup.d.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167056));
    if (PublicAccountInfo.isLooker((PublicAccountInfo)localObject2))
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
      paramViewGroup.d.setText(((PublicAccountInfo)localObject2).name);
      if (((PublicAccountInfo)localObject2).certifiedGrade > 0L)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130841838);
      }
      else
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      paramViewGroup.e.setText(((PublicAccountInfo)localObject2).summary);
      a(paramViewGroup, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramViewGroup.b.setVisibility(8);
    }
    if (AppSetting.d) {
      paramView.setContentDescription(paramViewGroup.d.getText());
    }
    return paramView;
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    b();
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject1;
    if (localFriendsManager != null)
    {
      localObject1 = localFriendsManager.a();
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 2, "FriendManager is null");
      }
      localObject1 = null;
    }
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (((List)localObject1).size() != 0) {}
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("group list is ");
        if (localObject1 == null) {
          localObject2 = "null";
        } else {
          localObject2 = "empty";
        }
        ((StringBuilder)localObject3).append((String)localObject2);
        QLog.d("FriendTeamListInnerFrameBuddyListAdapter", 2, ((StringBuilder)localObject3).toString());
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new ArrayList();
      }
    }
    Object localObject3 = ((List)localObject2).iterator();
    for (;;)
    {
      boolean bool = ((Iterator)localObject3).hasNext();
      int i = 0;
      if (!bool) {
        break;
      }
      Groups localGroups = (Groups)((Iterator)localObject3).next();
      this.jdField_a_of_type_JavaUtilArrayList.add(localGroups);
      localObject1 = localFriendsManager.a(String.valueOf(localGroups.group_id));
      if (localObject1 == null) {
        localObject1 = new ArrayList();
      } else {
        localObject1 = new ArrayList((Collection)localObject1);
      }
      Object localObject4 = new ArrayList();
      Object localObject5 = ((List)localObject1).iterator();
      while (((Iterator)localObject5).hasNext()) {
        ((ArrayList)localObject4).add(new SelectMemberBuddyListAdapter.FriendHolder((Friends)((Iterator)localObject5).next(), -1));
      }
      a((List)localObject4);
      ((List)localObject1).clear();
      localObject4 = ((ArrayList)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((List)localObject1).add(((SelectMemberBuddyListAdapter.FriendHolder)((Iterator)localObject4).next()).a);
      }
      localObject4 = ((List)localObject1).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (Friends)((Iterator)localObject4).next();
        if (OnlineStatusUtils.a(((Friends)localObject5).detalStatusFlag, ((Friends)localObject5).iTermType) == 0) {}
      }
      localObject4 = new ArrayList();
      while (i < ((List)localObject1).size())
      {
        localObject5 = (Friends)((List)localObject1).get(i);
        if ((!((Friends)localObject5).uin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (!Utils.b(((Friends)localObject5).uin)) && (!QidianManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((Friends)localObject5).uin))) {
          ((ArrayList)localObject4).add(((List)localObject1).get(i));
        }
        i += 1;
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(localGroups.group_id, localObject4);
    }
    if ((!((List)localObject2).isEmpty()) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_b_of_type_ComTencentWidgetExpandableListView.expandGroup(0);
    }
  }
  
  protected View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560455, paramViewGroup, false);
      paramViewGroup = new SelectMemberBuddyListAdapter.SelectBuddyChildTag();
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368343));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131371697));
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131364613));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131379859);
      localObject = this.jdField_b_of_type_AndroidViewView$OnClickListener;
      if (localObject != null) {
        paramView.setOnClickListener((View.OnClickListener)localObject);
      }
      paramView.findViewById(2131379732).setVisibility(8);
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (SelectMemberBuddyListAdapter.SelectBuddyChildTag)paramView.getTag();
      paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
    Object localObject = getChild(paramInt1, paramInt2);
    Friends localFriends = (Friends)localObject;
    paramViewGroup.jdField_a_of_type_JavaLangObject = localObject;
    paramViewGroup.jdField_a_of_type_JavaLangString = localFriends.uin;
    a(paramViewGroup, null);
    if (paramViewGroup.jdField_a_of_type_AndroidViewView != null) {
      if (RobotUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramViewGroup.jdField_a_of_type_JavaLangString)) {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      } else {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
    paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
    localObject = ContactUtils.a(localFriends);
    paramViewGroup.d.setText((CharSequence)localObject);
    paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingObservableArrayList.contains(ResultRecord.a(localFriends.uin, localFriends.name)));
    a(paramViewGroup, localFriends);
    if ((AppSetting.d) && (paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
    {
      if (paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
      {
        paramViewGroup = new StringBuilder();
        paramViewGroup.append((String)localObject);
        paramViewGroup.append(HardCodeUtil.a(2131713634));
        paramView.setContentDescription(paramViewGroup.toString());
        return paramView;
      }
      paramViewGroup = new StringBuilder();
      paramViewGroup.append((String)localObject);
      paramViewGroup.append(HardCodeUtil.a(2131713639));
      paramView.setContentDescription(paramViewGroup.toString());
    }
    return paramView;
  }
  
  protected void a() {}
  
  public void a(int paramInt)
  {
    notifyDataSetChanged();
  }
  
  public void a(long paramLong) {}
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList)
  {
    if (paramObservableArrayList != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingObservableArrayList = paramObservableArrayList;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingObservableArrayList.addOnListChangedCallback(this);
    }
  }
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2) {}
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void a(SelectMemberBuddyListAdapter.SelectBuddyChildTag paramSelectBuddyChildTag, Friends paramFriends) {}
  
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
  
  public void b(int paramInt) {}
  
  public void b(ObservableArrayList<ResultRecord> paramObservableArrayList) {}
  
  public void b(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    notifyDataSetChanged();
  }
  
  public void c()
  {
    super.c();
  }
  
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
  
  public void c(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
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
    ((CheckBox)paramView.findViewById(2131369353)).setChecked(this.jdField_b_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(paramInt));
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(((Groups)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).group_id)).get(paramInt2);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    Object localObject = getChild(paramInt1, paramInt2);
    boolean bool = localObject instanceof Friends;
    long l1 = 0L;
    if (bool)
    {
      localObject = (Friends)localObject;
      try
      {
        long l2 = Long.parseLong(((Friends)localObject).uin);
        return l2;
      }
      catch (Throwable localThrowable)
      {
        if (!QLog.isColorLevel()) {
          break label80;
        }
      }
      QLog.i("FriendTeamListInnerFrameBuddyListAdapter", 2, QLog.getStackTraceString(localThrowable));
      return 0L;
    }
    else if ((localThrowable instanceof PublicAccountInfo))
    {
      l1 = ((PublicAccountInfo)localThrowable).uin;
    }
    label80:
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
    if (a(paramInt1, paramInt2) == 0) {
      paramView = a(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
    } else if (a(paramInt1, paramInt2) == 1) {
      paramView = b(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
    } else {
      paramView = c(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
    }
    TraceUtils.traceEnd();
    return paramView;
  }
  
  public int getChildrenCount(int paramInt)
  {
    Groups localGroups = (Groups)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if ((localGroups != null) && (this.jdField_a_of_type_AndroidUtilSparseArray.get(localGroups.group_id) != null)) {
      return ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(((Groups)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).group_id)).size();
    }
    return 0;
  }
  
  public Object getGroup(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public int getGroupCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
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
        paramViewGroup.append(HardCodeUtil.a(2131713666));
        paramView.setContentDescription(paramViewGroup.toString());
      }
      else
      {
        paramViewGroup = new StringBuilder();
        paramViewGroup.append(localGroups.group_name);
        paramViewGroup.append(HardCodeUtil.a(2131713628));
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
    d();
    super.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    paramView = (SelectMemberBuddyListAdapter.GroupTag)paramView.getTag();
    if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(paramView.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.collapseGroup(paramView.jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetExpandableListView.expandGroup(paramView.jdField_a_of_type_Int);
  }
  
  public boolean onLongClick(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(0, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131693091));
    BubbleContextMenu.a(paramView, localQQCustomMenu, this.c, new SelectMemberBuddyListAdapter.3(this));
    return true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectmember.SelectMemberBuddyListAdapter
 * JD-Core Version:    0.7.0.1
 */