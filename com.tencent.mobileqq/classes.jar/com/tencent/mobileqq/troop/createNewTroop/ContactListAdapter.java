package com.tencent.mobileqq.troop.createNewTroop;

import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.TraceUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ContactListAdapter
  extends BaseFacePreloadExpandableListAdapter
  implements View.OnClickListener, View.OnLongClickListener, PhoneContactManager.IPhoneContactListener
{
  private static final ContactListAdapter.MyComparator jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopContactListAdapter$MyComparator = new ContactListAdapter.MyComparator(null);
  private final Context jdField_a_of_type_AndroidContentContext;
  private final SparseArray<ArrayList<Entity>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ContactListAdapter.1(this);
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected NewTroopContactView a;
  RelationFriendsTroopViewHelper jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopRelationFriendsTroopViewHelper;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
  private final ArrayList<Groups> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private final View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new ContactListAdapter.2(this);
  private ExpandableListView jdField_b_of_type_ComTencentWidgetExpandableListView;
  
  public ContactListAdapter(NewTroopContactView paramNewTroopContactView, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, boolean paramBoolean)
  {
    super(paramNewTroopContactView.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity, paramQQAppInterface, paramExpandableListView);
    this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView = paramNewTroopContactView;
    this.jdField_a_of_type_AndroidContentContext = paramNewTroopContactView.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_ComTencentWidgetExpandableListView = paramExpandableListView;
    paramExpandableListView.post(new ContactListAdapter.3(this));
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (((Groups)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).group_id == 1002) {
      return 1;
    }
    if (((Groups)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).group_id == 1008) {
      return 2;
    }
    return 0;
  }
  
  private View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560566, paramViewGroup, false);
      paramViewGroup = new ContactListAdapter.SelectBuddyChildTag();
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368603));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131372115));
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131364726));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131380575);
      if (this.jdField_b_of_type_AndroidViewView$OnClickListener != null) {
        paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      }
      paramView.findViewById(2131380419).setVisibility(8);
      paramView.setTag(paramViewGroup);
      localObject = getChild(paramInt1, paramInt2);
      Friends localFriends = (Friends)localObject;
      paramViewGroup.jdField_a_of_type_Long = getGroupId(paramInt1);
      paramViewGroup.jdField_a_of_type_JavaLangObject = localObject;
      paramViewGroup.jdField_a_of_type_JavaLangString = localFriends.uin;
      a(paramViewGroup, null);
      if (paramViewGroup.jdField_a_of_type_AndroidViewView != null)
      {
        if (!RobotUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramViewGroup.jdField_a_of_type_JavaLangString)) {
          break label375;
        }
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      label204:
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
      localObject = ContactUtils.a(localFriends);
      paramViewGroup.d.setText((CharSequence)localObject);
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.a(paramViewGroup.jdField_a_of_type_JavaLangString)) {
        break label388;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      label254:
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.jdField_a_of_type_JavaUtilArrayList == null) || (!this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.jdField_a_of_type_JavaUtilArrayList.contains(localFriends.uin))) {
        break label400;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
    }
    for (;;)
    {
      if ((AppSetting.d) && (paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
      {
        if (!paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
          break label412;
        }
        paramView.setContentDescription((String)localObject + HardCodeUtil.a(2131702541));
      }
      return paramView;
      paramViewGroup = (ContactListAdapter.SelectBuddyChildTag)paramView.getTag();
      paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break;
      label375:
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      break label204;
      label388:
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      break label254;
      label400:
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
    }
    label412:
    paramView.setContentDescription((String)localObject + HardCodeUtil.a(2131702527));
    return paramView;
  }
  
  private void a(List<ContactListAdapter.FriendHolder> paramList)
  {
    try
    {
      Collections.sort(paramList, jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopContactListAdapter$MyComparator);
      return;
    }
    catch (ArrayIndexOutOfBoundsException paramList)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("createNewTroop.ContactListAdapter", 2, "", paramList);
    }
  }
  
  private View b(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    PhoneContact localPhoneContact;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560566, paramViewGroup, false);
      paramViewGroup = new ContactListAdapter.SelectBuddyChildTag();
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368603));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131372115));
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramView.findViewById(2131364726));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131380575);
      if (this.jdField_b_of_type_AndroidViewView$OnClickListener != null) {
        paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      }
      paramView.setTag(paramViewGroup);
      Object localObject = getChild(paramInt1, paramInt2);
      localPhoneContact = (PhoneContact)localObject;
      paramViewGroup.jdField_a_of_type_JavaLangObject = localObject;
      paramViewGroup.jdField_a_of_type_JavaLangString = localPhoneContact.mobileCode;
      a(paramViewGroup, null);
      if (paramViewGroup.jdField_a_of_type_AndroidViewView != null) {
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
      paramViewGroup.d.setText(localPhoneContact.name);
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.a(paramViewGroup.jdField_a_of_type_JavaLangString)) {
        break label353;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      label214:
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.jdField_a_of_type_JavaUtilArrayList == null) || ("0".equals(localPhoneContact.uin)) || (!this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.jdField_a_of_type_JavaUtilArrayList.contains(localPhoneContact.uin))) {
        break label365;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
    }
    for (;;)
    {
      if ((AppSetting.d) && (paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
      {
        if (!paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
          break label377;
        }
        paramView.setContentDescription(localPhoneContact.name + HardCodeUtil.a(2131702535));
      }
      return paramView;
      paramViewGroup = (ContactListAdapter.SelectBuddyChildTag)paramView.getTag();
      paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break;
      label353:
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      break label214;
      label365:
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
    }
    label377:
    paramView.setContentDescription(localPhoneContact.name + HardCodeUtil.a(2131702540));
    return paramView;
  }
  
  private View c(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) || ((paramView.getTag() instanceof ContactListAdapter.SelectBuddyChildTag)))
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559739, paramViewGroup, false);
      paramViewGroup = new ContactListAdapter.PublicAccountChildTag();
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368603));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367115));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131379092));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373646));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131373629));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131373656));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131379094));
      paramView.setTag(paramViewGroup);
      if (this.jdField_b_of_type_AndroidViewView$OnClickListener == null) {
        break label483;
      }
      paramView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    }
    label483:
    for (;;)
    {
      Object localObject = getChild(paramInt1, paramInt2);
      PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)localObject;
      paramViewGroup.jdField_a_of_type_JavaLangObject = localObject;
      paramViewGroup.jdField_a_of_type_JavaLangString = Long.toString(localPublicAccountInfo.uin);
      paramViewGroup.d.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167033));
      if (PublicAccountInfo.isLooker(localPublicAccountInfo))
      {
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        paramViewGroup.d.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        paramViewGroup.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewGroup.b.setVisibility(8);
        paramViewGroup.e.setVisibility(8);
        if (AppSetting.d) {
          paramView.setContentDescription(paramViewGroup.d.getText());
        }
        return paramView;
        paramViewGroup = (ContactListAdapter.PublicAccountChildTag)paramView.getTag();
        paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      }
      else
      {
        paramViewGroup.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        paramViewGroup.d.setVisibility(0);
        paramViewGroup.e.setVisibility(0);
        paramViewGroup.d.setText(localPublicAccountInfo.name);
        if (localPublicAccountInfo.certifiedGrade > 0L)
        {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130841947);
        }
        for (;;)
        {
          paramViewGroup.e.setText(localPublicAccountInfo.summary);
          a(paramViewGroup, null);
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          paramViewGroup.b.setVisibility(8);
          break;
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
      }
    }
  }
  
  private void c()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    if (localObject1 != null)
    {
      Object localObject3 = ((RecentUserProxy)localObject1).a(true);
      if (localObject3 != null)
      {
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localObject1 = new ArrayList();
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (RecentUser)((Iterator)localObject3).next();
          if (localObject4 != null) {
            try
            {
              if ((((RecentUser)localObject4).getType() == 0) && (Long.parseLong(((RecentUser)localObject4).uin) >= 10000L) && (!((RecentUser)localObject4).uin.equals(localObject2)) && (!this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.b.contains(((RecentUser)localObject4).uin)) && (!Utils.b(((RecentUser)localObject4).uin)) && (!RobotUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((RecentUser)localObject4).uin)))
              {
                localObject4 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(((RecentUser)localObject4).uin);
                if ((localObject4 != null) && (((Friends)localObject4).isFriend()) && (!QidianManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((Friends)localObject4).uin))) {
                  ((ArrayList)localObject1).add(localObject4);
                }
              }
            }
            catch (NumberFormatException localNumberFormatException) {}
          }
        }
        if (!((ArrayList)localObject1).isEmpty())
        {
          localObject2 = new Groups();
          ((Groups)localObject2).group_id = 1003;
          ((Groups)localObject2).group_name = this.jdField_a_of_type_AndroidContentContext.getString(2131718471);
          ((Groups)localObject2).group_friend_count = ((ArrayList)localObject1).size();
          ((Groups)localObject2).seqid = 0;
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          this.jdField_a_of_type_AndroidUtilSparseArray.put(((Groups)localObject2).group_id, localObject1);
        }
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopRelationFriendsTroopViewHelper.a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_AndroidUtilSparseArray);
    c();
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject2 = null;
    Object localObject1;
    Object localObject3;
    if (localFriendsManager != null)
    {
      localObject1 = localFriendsManager.a();
      if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
        break label608;
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder().append("group list is ");
        if (localObject1 != null) {
          break label286;
        }
        localObject2 = "null";
        label105:
        QLog.d("createNewTroop.ContactListAdapter", 2, (String)localObject2);
      }
      if (localObject1 != null) {
        break label608;
      }
      localObject1 = new ArrayList();
    }
    label286:
    label605:
    label608:
    for (;;)
    {
      localObject3 = ((List)localObject1).iterator();
      Groups localGroups;
      Object localObject4;
      Object localObject5;
      int i;
      if (((Iterator)localObject3).hasNext())
      {
        localGroups = (Groups)((Iterator)localObject3).next();
        this.jdField_a_of_type_JavaUtilArrayList.add(localGroups);
        localObject2 = localFriendsManager.a(String.valueOf(localGroups.group_id));
        if (localObject2 == null) {}
        for (localObject2 = new ArrayList();; localObject2 = new ArrayList((Collection)localObject2))
        {
          localObject4 = new ArrayList();
          localObject5 = ((List)localObject2).iterator();
          while (((Iterator)localObject5).hasNext()) {
            ((ArrayList)localObject4).add(new ContactListAdapter.FriendHolder((Friends)((Iterator)localObject5).next(), -1));
          }
          localObject1 = localObject2;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("createNewTroop.ContactListAdapter", 2, "FriendManager is null");
          localObject1 = localObject2;
          break;
          localObject2 = "empty";
          break label105;
        }
        a((List)localObject4);
        ((List)localObject2).clear();
        localObject4 = ((ArrayList)localObject4).iterator();
        while (((Iterator)localObject4).hasNext()) {
          ((List)localObject2).add(((ContactListAdapter.FriendHolder)((Iterator)localObject4).next()).a);
        }
        localObject4 = ((List)localObject2).iterator();
        i = 0;
        label373:
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (Friends)((Iterator)localObject4).next();
          int j = ContactUtils.a(((Friends)localObject5).detalStatusFlag, ((Friends)localObject5).iTermType);
          if ((j == 0) || (j == 6)) {
            break label605;
          }
          i += 1;
        }
      }
      for (;;)
      {
        break label373;
        localObject4 = new ArrayList();
        i = 0;
        while (i < ((List)localObject2).size())
        {
          localObject5 = (Friends)((List)localObject2).get(i);
          if ((!((Friends)localObject5).uin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (!this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView.b.contains(((Friends)localObject5).uin)) && (!Utils.b(((Friends)localObject5).uin)) && (!RobotUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((Friends)localObject5).uin)) && (!QidianManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((Friends)localObject5).uin))) {
            ((ArrayList)localObject4).add(((List)localObject2).get(i));
          }
          i += 1;
        }
        this.jdField_a_of_type_AndroidUtilSparseArray.put(localGroups.group_id, localObject4);
        break;
        if ((!((List)localObject1).isEmpty()) && (this.jdField_a_of_type_Boolean)) {
          this.jdField_b_of_type_ComTencentWidgetExpandableListView.expandGroup(0);
        }
        return;
      }
    }
  }
  
  public Groups a(long paramLong)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      Groups localGroups = (Groups)this.jdField_a_of_type_JavaUtilArrayList.get(i);
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
    this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopRelationFriendsTroopViewHelper = paramRelationFriendsTroopViewHelper;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("createNewTroop.ContactListAdapter", 2, "onRecommendCountChanged count=" + paramInt);
    }
    notifyDataSetChanged();
  }
  
  public void b()
  {
    super.b();
  }
  
  public void b(int paramInt) {}
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("createNewTroop.ContactListAdapter", 2, "onUpdateContactList, " + paramInt);
    }
    notifyDataSetChanged();
  }
  
  public void configHeaderView(View paramView, int paramInt)
  {
    ContactListAdapter.GroupTag localGroupTag = (ContactListAdapter.GroupTag)paramView.getTag();
    if (localGroupTag == null)
    {
      localGroupTag = new ContactListAdapter.GroupTag();
      paramView.findViewById(2131369653).setVisibility(0);
      localGroupTag.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131368102));
      paramView.setTag(localGroupTag);
    }
    for (;;)
    {
      Groups localGroups = (Groups)getGroup(paramInt);
      localGroupTag.jdField_a_of_type_AndroidWidgetTextView.setText(localGroups.group_name);
      ((CheckBox)paramView.findViewById(2131369653)).setChecked(this.jdField_b_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(paramInt));
      return;
    }
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return ((ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(((Groups)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt1)).group_id)).get(paramInt2);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    Object localObject = getChild(paramInt1, paramInt2);
    if ((localObject instanceof Friends))
    {
      localObject = (Friends)localObject;
      try
      {
        long l = Long.parseLong(((Friends)localObject).uin);
        return l;
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.i("createNewTroop.ContactListAdapter", 2, QLog.getStackTraceString(localThrowable));
        }
      }
    }
    do
    {
      return 0L;
      if ((localThrowable instanceof PublicAccountInfo)) {
        return ((PublicAccountInfo)localThrowable).uin;
      }
    } while (!(localThrowable instanceof RelationTroopEntity));
    RelationTroopEntity localRelationTroopEntity = (RelationTroopEntity)localThrowable;
    return this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopRelationFriendsTroopViewHelper.a(localRelationTroopEntity.troopInfo.troopuin).longValue();
  }
  
  public int getChildType(int paramInt1, int paramInt2)
  {
    return a(paramInt1, paramInt2);
  }
  
  public int getChildTypeCount()
  {
    return 3;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    TraceUtils.traceBegin("getChildView");
    if (a(paramInt1, paramInt2) == 0) {
      paramView = a(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
    }
    for (;;)
    {
      TraceUtils.traceEnd();
      return paramView;
      if (a(paramInt1, paramInt2) == 1)
      {
        paramView = b(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
      }
      else if (a(paramInt1, paramInt2) == 2)
      {
        RelationTroopEntity localRelationTroopEntity = (RelationTroopEntity)getChild(paramInt1, paramInt2);
        paramView = this.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopRelationFriendsTroopViewHelper.a(paramInt1, paramInt2, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_AndroidViewView$OnClickListener, localRelationTroopEntity);
      }
      else
      {
        paramView = c(paramInt1, paramInt2, paramBoolean, paramView, paramViewGroup);
      }
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    Groups localGroups = (Groups)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    if ((localGroups == null) || (this.jdField_a_of_type_AndroidUtilSparseArray.get(localGroups.group_id) == null)) {
      return 0;
    }
    return ((ArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(((Groups)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).group_id)).size();
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
    Object localObject;
    if (paramView != null)
    {
      localObject = (ContactListAdapter.GroupTag)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    for (;;)
    {
      localObject = (Groups)getGroup(paramInt);
      paramView.jdField_a_of_type_Int = paramInt;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((Groups)localObject).group_name);
      if (AppSetting.d)
      {
        if (!paramBoolean) {
          break;
        }
        paramViewGroup.setContentDescription(((Groups)localObject).group_name + HardCodeUtil.a(2131702529));
      }
      return paramViewGroup;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560565, paramViewGroup, false);
      paramView = new ContactListAdapter.GroupTag();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131368102));
      paramViewGroup.setTag(paramView);
      paramViewGroup.setOnClickListener(this);
    }
    paramViewGroup.setContentDescription(((Groups)localObject).group_name + HardCodeUtil.a(2131702546));
    return paramViewGroup;
  }
  
  public int getHeaderViewLayoutResourceId()
  {
    return 2131559023;
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
    ContactListAdapter.GroupTag localGroupTag = (ContactListAdapter.GroupTag)paramView.getTag();
    if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(localGroupTag.jdField_a_of_type_Int)) {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.collapseGroup(localGroupTag.jdField_a_of_type_Int);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      try
      {
        this.jdField_a_of_type_ComTencentWidgetExpandableListView.expandGroup(localGroupTag.jdField_a_of_type_Int);
      }
      catch (Throwable localThrowable) {}
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(0, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131693131));
    BubbleContextMenu.a(paramView, localQQCustomMenu, this.jdField_a_of_type_AndroidViewView$OnClickListener, new ContactListAdapter.4(this));
    return true;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener != null) {
      this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.ContactListAdapter
 * JD-Core Version:    0.7.0.1
 */