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
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.friend.status.OnlineStatusUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.phonecontact.listener.IPhoneContactListener;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.troopcreate.RelationTroopEntity;
import com.tencent.mobileqq.troop.troopcreate.ui.NewTroopContactView;
import com.tencent.mobileqq.troop.troopcreate.ui.RelationFriendsTroopViewHelper;
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
  implements View.OnClickListener, View.OnLongClickListener, IPhoneContactListener
{
  private static final ContactListAdapter.MyComparator c = new ContactListAdapter.MyComparator(null);
  protected NewTroopContactView a;
  RelationFriendsTroopViewHelper b;
  private final Context d;
  private final QQAppInterface e;
  private final ArrayList<Groups> f = new ArrayList();
  private final SparseArray<ArrayList<Entity>> g = new SparseArray();
  private AbsListView.OnScrollListener h;
  private ExpandableListView i;
  private boolean j = true;
  private final View.OnClickListener k = new ContactListAdapter.1(this);
  private final View.OnClickListener l = new ContactListAdapter.2(this);
  
  public ContactListAdapter(NewTroopContactView paramNewTroopContactView, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, boolean paramBoolean)
  {
    super(paramNewTroopContactView.a, paramQQAppInterface, paramExpandableListView);
    this.a = paramNewTroopContactView;
    this.d = paramNewTroopContactView.a;
    this.e = paramQQAppInterface;
    this.j = paramBoolean;
    this.i = paramExpandableListView;
    paramExpandableListView.post(new ContactListAdapter.3(this));
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (((Groups)this.f.get(paramInt1)).group_id == 1002) {
      return 1;
    }
    if (((Groups)this.f.get(paramInt1)).group_id == 1008) {
      return 2;
    }
    return 0;
  }
  
  private View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.d).inflate(2131626500, paramViewGroup, false);
      paramViewGroup = new ContactListAdapter.SelectBuddyChildTag();
      paramViewGroup.A = ((ImageView)paramView.findViewById(2131435219));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131439121));
      paramViewGroup.g = ((CheckBox)paramView.findViewById(2131430688));
      paramViewGroup.a = paramView.findViewById(2131448716);
      localObject = this.l;
      if (localObject != null) {
        paramView.setOnClickListener((View.OnClickListener)localObject);
      }
      paramView.findViewById(2131448537).setVisibility(8);
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (ContactListAdapter.SelectBuddyChildTag)paramView.getTag();
      paramViewGroup.e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
    Object localObject = getChild(paramInt1, paramInt2);
    Friends localFriends = (Friends)localObject;
    paramViewGroup.b = getGroupId(paramInt1);
    paramViewGroup.h = localObject;
    paramViewGroup.y = localFriends.uin;
    a(paramViewGroup, null);
    if (paramViewGroup.a != null) {
      if (((ITroopRobotService)this.e.getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(paramViewGroup.y)) {
        paramViewGroup.a.setVisibility(0);
      } else {
        paramViewGroup.a.setVisibility(8);
      }
    }
    paramViewGroup.A.setImageDrawable(null);
    localObject = ContactUtils.a(localFriends);
    paramViewGroup.e.setText((CharSequence)localObject);
    if (this.a.a(paramViewGroup.y)) {
      paramViewGroup.g.setChecked(true);
    } else {
      paramViewGroup.g.setChecked(false);
    }
    if ((this.a.c != null) && (this.a.c.contains(localFriends.uin))) {
      paramViewGroup.g.setEnabled(false);
    } else {
      paramViewGroup.g.setEnabled(true);
    }
    if ((AppSetting.e) && (paramViewGroup.g.isEnabled()))
    {
      if (paramViewGroup.g.isChecked())
      {
        paramViewGroup = new StringBuilder();
        paramViewGroup.append((String)localObject);
        paramViewGroup.append(HardCodeUtil.a(2131900663));
        paramView.setContentDescription(paramViewGroup.toString());
        return paramView;
      }
      paramViewGroup = new StringBuilder();
      paramViewGroup.append((String)localObject);
      paramViewGroup.append(HardCodeUtil.a(2131900649));
      paramView.setContentDescription(paramViewGroup.toString());
    }
    return paramView;
  }
  
  private void a(List<ContactListAdapter.FriendHolder> paramList)
  {
    try
    {
      Collections.sort(paramList, c);
      return;
    }
    catch (ArrayIndexOutOfBoundsException paramList)
    {
      if (QLog.isColorLevel()) {
        QLog.d("createNewTroop.ContactListAdapter", 2, "", paramList);
      }
    }
  }
  
  private View b(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.d).inflate(2131626500, paramViewGroup, false);
      paramViewGroup = new ContactListAdapter.SelectBuddyChildTag();
      paramViewGroup.A = ((ImageView)paramView.findViewById(2131435219));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131439121));
      paramViewGroup.g = ((CheckBox)paramView.findViewById(2131430688));
      paramViewGroup.a = paramView.findViewById(2131448716);
      localObject1 = this.l;
      if (localObject1 != null) {
        paramView.setOnClickListener((View.OnClickListener)localObject1);
      }
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (ContactListAdapter.SelectBuddyChildTag)paramView.getTag();
      paramViewGroup.e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
    Object localObject2 = getChild(paramInt1, paramInt2);
    Object localObject1 = (PhoneContact)localObject2;
    paramViewGroup.h = localObject2;
    paramViewGroup.y = ((PhoneContact)localObject1).mobileCode;
    a(paramViewGroup, null);
    if (paramViewGroup.a != null) {
      paramViewGroup.a.setVisibility(8);
    }
    paramViewGroup.A.setImageDrawable(null);
    paramViewGroup.e.setText(((PhoneContact)localObject1).name);
    if (this.a.a(paramViewGroup.y)) {
      paramViewGroup.g.setChecked(true);
    } else {
      paramViewGroup.g.setChecked(false);
    }
    if ((this.a.c != null) && (!"0".equals(((PhoneContact)localObject1).uin)) && (this.a.c.contains(((PhoneContact)localObject1).uin))) {
      paramViewGroup.g.setEnabled(false);
    } else {
      paramViewGroup.g.setEnabled(true);
    }
    if ((AppSetting.e) && (paramViewGroup.g.isEnabled()))
    {
      if (paramViewGroup.g.isChecked())
      {
        paramViewGroup = new StringBuilder();
        paramViewGroup.append(((PhoneContact)localObject1).name);
        paramViewGroup.append(HardCodeUtil.a(2131900657));
        paramView.setContentDescription(paramViewGroup.toString());
        return paramView;
      }
      paramViewGroup = new StringBuilder();
      paramViewGroup.append(((PhoneContact)localObject1).name);
      paramViewGroup.append(HardCodeUtil.a(2131900662));
      paramView.setContentDescription(paramViewGroup.toString());
    }
    return paramView;
  }
  
  private void b()
  {
    Object localObject1 = ((IRecentUserProxyService)this.e.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    Object localObject3;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject3 = ((RecentUserProxy)localObject1).a(true);
      if (localObject3 != null)
      {
        localObject2 = this.e.getCurrentAccountUin();
        localObject1 = new ArrayList();
        localObject3 = ((List)localObject3).iterator();
      }
    }
    for (;;)
    {
      Object localObject4;
      if (((Iterator)localObject3).hasNext()) {
        localObject4 = (RecentUser)((Iterator)localObject3).next();
      }
      try
      {
        ITroopRobotService localITroopRobotService = (ITroopRobotService)this.e.getRuntimeService(ITroopRobotService.class, "all");
        if ((localObject4 == null) || (((RecentUser)localObject4).getType() != 0) || (Long.parseLong(((RecentUser)localObject4).uin) < 10000L) || (((RecentUser)localObject4).uin.equals(localObject2)) || (this.a.d.contains(((RecentUser)localObject4).uin)) || (Utils.c(((RecentUser)localObject4).uin)) || (localITroopRobotService.isRobotUin(((RecentUser)localObject4).uin))) {
          continue;
        }
        localObject4 = ((FriendsManager)this.e.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(((RecentUser)localObject4).uin);
        if ((localObject4 == null) || (!((Friends)localObject4).isFriend()) || (QidianManager.a(this.e, ((Friends)localObject4).uin))) {
          continue;
        }
        ((ArrayList)localObject1).add(localObject4);
      }
      catch (NumberFormatException localNumberFormatException) {}
      if (!((ArrayList)localObject1).isEmpty())
      {
        localObject2 = new Groups();
        ((Groups)localObject2).group_id = 1003;
        ((Groups)localObject2).group_name = this.d.getString(2131915613);
        ((Groups)localObject2).group_friend_count = ((ArrayList)localObject1).size();
        ((Groups)localObject2).seqid = 0;
        this.f.add(localObject2);
        this.g.put(((Groups)localObject2).group_id, localObject1);
      }
      return;
    }
  }
  
  private View c(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView != null) && (!(paramView.getTag() instanceof ContactListAdapter.SelectBuddyChildTag)))
    {
      paramViewGroup = (ContactListAdapter.PublicAccountChildTag)paramView.getTag();
      paramViewGroup.e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
    else
    {
      localObject1 = LayoutInflater.from(this.d).inflate(2131625644, paramViewGroup, false);
      localObject2 = new ContactListAdapter.PublicAccountChildTag();
      ((ContactListAdapter.PublicAccountChildTag)localObject2).A = ((ImageView)((View)localObject1).findViewById(2131435219));
      ((ContactListAdapter.PublicAccountChildTag)localObject2).a = ((ImageView)((View)localObject1).findViewById(2131433312));
      ((ContactListAdapter.PublicAccountChildTag)localObject2).e = ((TextView)((View)localObject1).findViewById(2131447063));
      ((ContactListAdapter.PublicAccountChildTag)localObject2).b = ((TextView)((View)localObject1).findViewById(2131440828));
      ((ContactListAdapter.PublicAccountChildTag)localObject2).d = ((TextView)((View)localObject1).findViewById(2131440811));
      ((ContactListAdapter.PublicAccountChildTag)localObject2).c = ((TextView)((View)localObject1).findViewById(2131440838));
      ((ContactListAdapter.PublicAccountChildTag)localObject2).f = ((TextView)((View)localObject1).findViewById(2131447065));
      ((View)localObject1).setTag(localObject2);
      View.OnClickListener localOnClickListener = this.l;
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
    paramViewGroup.h = localObject1;
    paramViewGroup.y = Long.toString(((PublicAccountInfo)localObject2).uin);
    paramViewGroup.e.setTextColor(this.d.getResources().getColorStateList(2131167993));
    if (PublicAccountInfo.isLooker((PublicAccountInfo)localObject2))
    {
      paramViewGroup.d.setVisibility(0);
      paramViewGroup.e.setVisibility(8);
      paramViewGroup.a.setVisibility(8);
      paramViewGroup.A.setImageDrawable(null);
      paramViewGroup.b.setVisibility(8);
      paramViewGroup.c.setVisibility(8);
      paramViewGroup.f.setVisibility(8);
    }
    else
    {
      paramViewGroup.d.setVisibility(8);
      paramViewGroup.e.setVisibility(0);
      paramViewGroup.f.setVisibility(0);
      paramViewGroup.e.setText(((PublicAccountInfo)localObject2).name);
      if (((PublicAccountInfo)localObject2).certifiedGrade > 0L)
      {
        paramViewGroup.a.setVisibility(0);
        paramViewGroup.a.setBackgroundResource(2130842755);
      }
      else
      {
        paramViewGroup.a.setVisibility(8);
      }
      paramViewGroup.f.setText(((PublicAccountInfo)localObject2).summary);
      a(paramViewGroup, null);
      paramViewGroup.b.setVisibility(8);
      paramViewGroup.c.setVisibility(8);
    }
    if (AppSetting.e) {
      paramView.setContentDescription(paramViewGroup.e.getText());
    }
    return paramView;
  }
  
  private void d()
  {
    this.f.clear();
    this.g.clear();
    this.b.a(this.f, this.g);
    b();
    FriendsManager localFriendsManager = (FriendsManager)this.e.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject1;
    if (localFriendsManager != null)
    {
      localObject1 = localFriendsManager.h();
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("createNewTroop.ContactListAdapter", 2, "FriendManager is null");
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
        QLog.d("createNewTroop.ContactListAdapter", 2, ((StringBuilder)localObject3).toString());
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
      int m = 0;
      if (!bool) {
        break;
      }
      Groups localGroups = (Groups)((Iterator)localObject3).next();
      this.f.add(localGroups);
      localObject1 = localFriendsManager.t(String.valueOf(localGroups.group_id));
      if (localObject1 == null) {
        localObject1 = new ArrayList();
      } else {
        localObject1 = new ArrayList((Collection)localObject1);
      }
      Object localObject4 = new ArrayList();
      Object localObject5 = ((List)localObject1).iterator();
      while (((Iterator)localObject5).hasNext()) {
        ((ArrayList)localObject4).add(new ContactListAdapter.FriendHolder((Friends)((Iterator)localObject5).next(), -1));
      }
      a((List)localObject4);
      ((List)localObject1).clear();
      localObject4 = ((ArrayList)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((List)localObject1).add(((ContactListAdapter.FriendHolder)((Iterator)localObject4).next()).a);
      }
      localObject4 = ((List)localObject1).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (Friends)((Iterator)localObject4).next();
        if (OnlineStatusUtils.a(((Friends)localObject5).detalStatusFlag, ((Friends)localObject5).iTermType) == 0) {}
      }
      localObject4 = new ArrayList();
      while (m < ((List)localObject1).size())
      {
        localObject5 = (Friends)((List)localObject1).get(m);
        ITroopRobotService localITroopRobotService = (ITroopRobotService)this.e.getRuntimeService(ITroopRobotService.class, "all");
        if ((!((Friends)localObject5).uin.equals(this.e.getCurrentAccountUin())) && (!this.a.d.contains(((Friends)localObject5).uin)) && (!Utils.c(((Friends)localObject5).uin)) && (!localITroopRobotService.isRobotUin(((Friends)localObject5).uin)) && (!QidianManager.a(this.e, ((Friends)localObject5).uin))) {
          ((ArrayList)localObject4).add(((List)localObject1).get(m));
        }
        m += 1;
      }
      this.g.put(localGroups.group_id, localObject4);
    }
    if ((!((List)localObject2).isEmpty()) && (this.j)) {
      this.i.expandGroup(0);
    }
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
    this.b = paramRelationFriendsTroopViewHelper;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRecommendCountChanged count=");
      localStringBuilder.append(paramInt);
      QLog.d("createNewTroop.ContactListAdapter", 2, localStringBuilder.toString());
    }
    notifyDataSetChanged();
  }
  
  public Groups b(long paramLong)
  {
    int m = 0;
    while (m < this.f.size())
    {
      Groups localGroups = (Groups)this.f.get(m);
      if (localGroups.group_id == paramLong) {
        return localGroups;
      }
      m += 1;
    }
    return null;
  }
  
  public void b(int paramInt) {}
  
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
      QLog.d("createNewTroop.ContactListAdapter", 2, localStringBuilder.toString());
    }
    notifyDataSetChanged();
  }
  
  public void configHeaderView(View paramView, int paramInt)
  {
    Object localObject2 = (ContactListAdapter.GroupTag)paramView.getTag();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ContactListAdapter.GroupTag();
      paramView.findViewById(2131436369).setVisibility(0);
      ((ContactListAdapter.GroupTag)localObject1).b = ((TextView)paramView.findViewById(2131434435));
      paramView.setTag(localObject1);
    }
    localObject2 = (Groups)getGroup(paramInt);
    ((ContactListAdapter.GroupTag)localObject1).b.setText(((Groups)localObject2).group_name);
    ((CheckBox)paramView.findViewById(2131436369)).setChecked(this.i.isGroupExpanded(paramInt));
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return ((ArrayList)this.g.get(((Groups)this.f.get(paramInt1)).group_id)).get(paramInt2);
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
          break label115;
        }
      }
      QLog.i("createNewTroop.ContactListAdapter", 2, QLog.getStackTraceString(localThrowable));
      return 0L;
    }
    else
    {
      if ((localThrowable instanceof PublicAccountInfo)) {
        return ((PublicAccountInfo)localThrowable).uin;
      }
      if ((localThrowable instanceof RelationTroopEntity))
      {
        RelationTroopEntity localRelationTroopEntity = (RelationTroopEntity)localThrowable;
        l1 = this.b.a(localRelationTroopEntity.troopInfo.troopuin).longValue();
      }
    }
    label115:
    return l1;
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
      paramView = this.b.a(paramInt1, paramInt2, paramView, paramViewGroup, this.d, this.l, localRelationTroopEntity);
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
    Groups localGroups = (Groups)this.f.get(paramInt);
    if ((localGroups != null) && (this.g.get(localGroups.group_id) != null)) {
      return ((ArrayList)this.g.get(((Groups)this.f.get(paramInt)).group_id)).size();
    }
    return 0;
  }
  
  public Object getGroup(int paramInt)
  {
    return this.f.get(paramInt);
  }
  
  public int getGroupCount()
  {
    return this.f.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return ((Groups)getGroup(paramInt)).group_id;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      paramViewGroup = (ContactListAdapter.GroupTag)paramView.getTag();
    }
    else
    {
      paramView = LayoutInflater.from(this.d).inflate(2131626499, paramViewGroup, false);
      paramViewGroup = new ContactListAdapter.GroupTag();
      paramViewGroup.b = ((TextView)paramView.findViewById(2131434435));
      paramView.setTag(paramViewGroup);
      paramView.setOnClickListener(this);
    }
    Groups localGroups = (Groups)getGroup(paramInt);
    paramViewGroup.a = paramInt;
    paramViewGroup.b.setText(localGroups.group_name);
    if (AppSetting.e)
    {
      if (paramBoolean)
      {
        paramViewGroup = new StringBuilder();
        paramViewGroup.append(localGroups.group_name);
        paramViewGroup.append(HardCodeUtil.a(2131900651));
        paramView.setContentDescription(paramViewGroup.toString());
        return paramView;
      }
      paramViewGroup = new StringBuilder();
      paramViewGroup.append(localGroups.group_name);
      paramViewGroup.append(HardCodeUtil.a(2131900668));
      paramView.setContentDescription(paramViewGroup.toString());
    }
    return paramView;
  }
  
  public int getHeaderViewLayoutResourceId()
  {
    return 2131624547;
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
    if (this.n.isGroupExpanded(localGroupTag.a)) {
      this.n.collapseGroup(localGroupTag.a);
    }
    try
    {
      this.n.expandGroup(localGroupTag.a);
      label49:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label49;
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    localQQCustomMenu.a(0, this.d.getResources().getString(2131890205));
    BubbleContextMenu.a(paramView, localQQCustomMenu, this.k, new ContactListAdapter.4(this));
    return true;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    AbsListView.OnScrollListener localOnScrollListener = this.h;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    AbsListView.OnScrollListener localOnScrollListener = this.h;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.ContactListAdapter
 * JD-Core Version:    0.7.0.1
 */