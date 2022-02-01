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
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
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
  private static final SelectMemberBuddyListAdapter.MyComparator p = new SelectMemberBuddyListAdapter.MyComparator(null);
  protected SelectMemberActivity a;
  SelectMemberBuddyListAdapter.TroopMemberFaceUtil b;
  ArrayList<Entity> c;
  private final Context d;
  private final AppInterface e;
  private final ArrayList<Groups> f = new ArrayList();
  private final SparseArray<ArrayList<Entity>> g = new SparseArray();
  private AbsListView.OnScrollListener h;
  private final View.OnClickListener i;
  private ExpandableListView j;
  private IToPayManager k;
  private IPhoneContactService l = null;
  private boolean m;
  private final boolean o;
  private boolean q;
  private RelationFriendsTroopViewHelper r;
  private final int s;
  private final int t;
  private final View.OnClickListener u;
  
  public SelectMemberBuddyListAdapter(Context paramContext, AppInterface paramAppInterface, ExpandableListView paramExpandableListView, View.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    super(paramContext, paramAppInterface, paramExpandableListView);
    boolean bool = true;
    this.m = true;
    this.b = null;
    this.u = new SelectMemberBuddyListAdapter.3(this);
    this.a = ((SelectMemberActivity)paramContext);
    this.k = ((IToPayManager)QRoute.api(IToPayManager.class));
    this.d = paramContext;
    this.e = paramAppInterface;
    this.i = paramOnClickListener;
    this.l = ((IPhoneContactService)paramAppInterface.getRuntimeService(IPhoneContactService.class, ""));
    this.m = paramBoolean;
    this.j = paramExpandableListView;
    paramContext = this.j;
    if (paramContext != null) {
      paramContext.post(new SelectMemberBuddyListAdapter.1(this));
    }
    if (!this.a.mDonotNeedContacts) {
      this.l.addListener(this);
    }
    this.s = ((int)DisplayUtils.a(this.d, 12.0F));
    this.t = ((int)DisplayUtils.a(this.d, 9.0F));
    if ((Build.MODEL.equals("Lenovo A366t")) && (Build.VERSION.SDK_INT == 10)) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    }
    this.o = paramBoolean;
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
      paramViewGroup = new SelectBuddyChildTag();
      paramViewGroup.A = ((ImageView)paramView.findViewById(2131435219));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131439121));
      paramViewGroup.g = ((CheckBox)paramView.findViewById(2131430688));
      paramViewGroup.a = paramView.findViewById(2131448716);
      localObject1 = this.i;
      if (localObject1 != null) {
        paramView.setOnClickListener((View.OnClickListener)localObject1);
      }
      paramView.findViewById(2131448537).setVisibility(8);
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (SelectBuddyChildTag)paramView.getTag();
      paramViewGroup.e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
    Object localObject1 = getChild(paramInt1, paramInt2);
    paramViewGroup.h = localObject1;
    paramViewGroup.b = getGroupId(paramInt1);
    Object localObject2;
    if ((localObject1 instanceof TroopMemberInfo))
    {
      localObject2 = (TroopMemberInfo)localObject1;
      if (this.b == null) {
        this.b = new SelectMemberBuddyListAdapter.TroopMemberFaceUtil(this, this.a, this.e);
      }
      paramViewGroup.y = ((TroopMemberInfo)localObject2).memberuin;
      localObject1 = CommonUtils.a(this.e, ((TroopMemberInfo)localObject2).troopuin, ((TroopMemberInfo)localObject2).memberuin);
      a(paramViewGroup, this.b.a((TroopMemberInfo)localObject2));
    }
    else
    {
      localObject2 = (Friends)localObject1;
      localObject1 = CommonUtils.a((Friends)localObject2);
      paramViewGroup.y = ((Friends)localObject2).uin;
      a(paramViewGroup, null);
    }
    if (paramViewGroup.a != null) {
      if (CommonUtils.c(this.e, paramViewGroup.y)) {
        paramViewGroup.a.setVisibility(0);
      } else {
        paramViewGroup.a.setVisibility(8);
      }
    }
    paramViewGroup.A.setImageDrawable(null);
    paramViewGroup.e.setText((CharSequence)localObject1);
    if (this.a.isResultListContainFriend(paramViewGroup.y)) {
      paramViewGroup.g.setChecked(true);
    } else {
      paramViewGroup.g.setChecked(false);
    }
    if ((this.a.mUinsSelectedDefault != null) && (this.a.mUinsSelectedDefault.contains(paramViewGroup.y))) {
      paramViewGroup.g.setEnabled(false);
    } else {
      paramViewGroup.g.setEnabled(true);
    }
    if ((AppSetting.e) && (paramViewGroup.g.isEnabled()))
    {
      if (paramViewGroup.g.isChecked())
      {
        paramViewGroup = new StringBuilder();
        paramViewGroup.append((String)localObject1);
        paramViewGroup.append(HardCodeUtil.a(2131911199));
        paramView.setContentDescription(paramViewGroup.toString());
        return paramView;
      }
      paramViewGroup = new StringBuilder();
      paramViewGroup.append((String)localObject1);
      paramViewGroup.append(HardCodeUtil.a(2131911176));
      paramView.setContentDescription(paramViewGroup.toString());
    }
    return paramView;
  }
  
  private void a(List<SelectMemberBuddyListAdapter.FriendHolder> paramList)
  {
    try
    {
      Collections.sort(paramList, p);
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
      paramView = LayoutInflater.from(this.d).inflate(2131626500, paramViewGroup, false);
      paramViewGroup = new SelectBuddyChildTag();
      paramViewGroup.A = ((ImageView)paramView.findViewById(2131435219));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131439121));
      paramViewGroup.g = ((CheckBox)paramView.findViewById(2131430688));
      paramViewGroup.a = paramView.findViewById(2131448716);
      localObject1 = this.i;
      if (localObject1 != null) {
        paramView.setOnClickListener((View.OnClickListener)localObject1);
      }
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (SelectBuddyChildTag)paramView.getTag();
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
    if (this.a.isResultListContainFriend(paramViewGroup.y)) {
      paramViewGroup.g.setChecked(true);
    } else {
      paramViewGroup.g.setChecked(false);
    }
    if ((this.a.mUinsSelectedDefault != null) && (!"0".equals(((PhoneContact)localObject1).uin)) && (this.a.mUinsSelectedDefault.contains(((PhoneContact)localObject1).uin))) {
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
        paramViewGroup.append(HardCodeUtil.a(2131911191));
        paramView.setContentDescription(paramViewGroup.toString());
        return paramView;
      }
      paramViewGroup = new StringBuilder();
      paramViewGroup.append(((PhoneContact)localObject1).name);
      paramViewGroup.append(HardCodeUtil.a(2131911205));
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
      paramViewGroup.e.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
    else
    {
      localObject1 = LayoutInflater.from(this.d).inflate(2131625644, paramViewGroup, false);
      localObject2 = new SelectMemberBuddyListAdapter.PublicAccountChildTag();
      ((SelectMemberBuddyListAdapter.PublicAccountChildTag)localObject2).A = ((ImageView)((View)localObject1).findViewById(2131435219));
      ((SelectMemberBuddyListAdapter.PublicAccountChildTag)localObject2).a = ((ImageView)((View)localObject1).findViewById(2131433312));
      ((SelectMemberBuddyListAdapter.PublicAccountChildTag)localObject2).e = ((TextView)((View)localObject1).findViewById(2131447063));
      ((SelectMemberBuddyListAdapter.PublicAccountChildTag)localObject2).b = ((TextView)((View)localObject1).findViewById(2131440828));
      ((SelectMemberBuddyListAdapter.PublicAccountChildTag)localObject2).d = ((TextView)((View)localObject1).findViewById(2131440811));
      ((SelectMemberBuddyListAdapter.PublicAccountChildTag)localObject2).c = ((TextView)((View)localObject1).findViewById(2131440838));
      ((SelectMemberBuddyListAdapter.PublicAccountChildTag)localObject2).f = ((TextView)((View)localObject1).findViewById(2131447065));
      ((View)localObject1).setTag(localObject2);
      View.OnClickListener localOnClickListener = this.i;
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
    paramViewGroup.h = localObject2;
    paramViewGroup.y = Long.toString(((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).getPublicAccountInfoUin(localObject2));
    paramViewGroup.e.setTextColor(this.d.getResources().getColorStateList(2131167993));
    if (((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).isPublicAccountInfoLooker(localObject2))
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
      localObject1 = ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).getPublicAccountInfoName(localObject2);
      long l1 = ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).getPublicAccountInfoCertifiedGrade(localObject2);
      localObject2 = ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).getPublicAccountInfoSummary(localObject2);
      paramViewGroup.e.setText((CharSequence)localObject1);
      if (l1 > 0L)
      {
        paramViewGroup.a.setVisibility(0);
        paramViewGroup.a.setBackgroundResource(2130842755);
      }
      else
      {
        paramViewGroup.a.setVisibility(8);
      }
      paramViewGroup.f.setText((CharSequence)localObject2);
      a(paramViewGroup, null);
      paramViewGroup.b.setVisibility(8);
      paramViewGroup.c.setVisibility(8);
    }
    if (AppSetting.e) {
      paramView.setContentDescription(paramViewGroup.e.getText());
    }
    return paramView;
  }
  
  private void c()
  {
    boolean bool2 = this.q;
    boolean bool1 = true;
    if (!bool2) {
      this.q = true;
    } else {
      bool1 = false;
    }
    Object localObject2 = this.k.getTopayList(this, bool1, 0, 0);
    Object localObject1 = this.k;
    Object localObject3 = ((HashMap)localObject2).get("recommend");
    localObject1 = null;
    if (localObject3 != null) {
      localObject1 = (ArrayList)localObject3;
    }
    localObject3 = this.k;
    localObject2 = ((HashMap)localObject2).get("tips");
    if (localObject2 != null) {
      this.a.mTopayTips = ((ArrayList)localObject2);
    }
    if (localObject1 != null)
    {
      localObject3 = this.e.getCurrentAccountUin();
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
          if ((((PfaFriend)localObject4).uin == null) || (((PfaFriend)localObject4).uin.equals(localObject3)) || (this.a.mUinsToHide.contains(((PfaFriend)localObject4).uin))) {
            continue;
          }
          localObject4 = SearchUtils.d(this.e, ((PfaFriend)localObject4).uin);
          if ((localObject4 == null) || (!((Friends)localObject4).isFriend()) || (CommonUtils.a(this.e, ((Friends)localObject4).uin))) {
            continue;
          }
          ((ArrayList)localObject2).add(localObject4);
        }
        catch (Exception localException) {}
        if (!((ArrayList)localObject2).isEmpty())
        {
          localObject1 = new Groups();
          ((Groups)localObject1).group_id = 1003;
          ((Groups)localObject1).group_name = this.d.getString(2131889676);
          ((Groups)localObject1).group_friend_count = ((ArrayList)localObject2).size();
          ((Groups)localObject1).seqid = 0;
          this.f.add(localObject1);
          this.g.put(((Groups)localObject1).group_id, localObject2);
        }
        return;
      }
    }
  }
  
  private void d()
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
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (RecentUser)((Iterator)localObject3).next();
        if (localObject4 == null) {}
      }
      else
      {
        try
        {
          if ((((RecentUser)localObject4).getType() != 0) || (Long.parseLong(((RecentUser)localObject4).uin) < 10000L) || (((RecentUser)localObject4).uin.equals(localObject2)) || (this.a.mUinsToHide.contains(((RecentUser)localObject4).uin)) || (Utils.c(((RecentUser)localObject4).uin)) || ((this.a.mFilterRobot) && (CommonUtils.c(this.e, ((RecentUser)localObject4).uin)))) {
            continue;
          }
          localObject4 = SearchUtils.d(this.e, ((RecentUser)localObject4).uin);
          if ((localObject4 == null) || (!((Friends)localObject4).isFriend()) || (CommonUtils.a(this.e, ((Friends)localObject4).uin))) {
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
  }
  
  private void e()
  {
    Object localObject = ((IQCircleFollowApi)QRoute.api(IQCircleFollowApi.class)).getCircleFriendMap();
    if (localObject != null)
    {
      if (((Map)localObject).isEmpty()) {
        return;
      }
      int n = 1100;
      Iterator localIterator = ((Map)localObject).entrySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (Map.Entry)localIterator.next();
        if (n >= 1150)
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
          localGroups.group_id = n;
          int i1 = 0;
          localGroups.seqid = 0;
          if (localList != null) {
            i1 = ((ArrayList)localObject).size();
          }
          localGroups.group_friend_count = i1;
          this.f.add(localGroups);
          this.g.put(localGroups.group_id, localObject);
          n += 1;
        }
      }
      f();
    }
  }
  
  private void f()
  {
    HashMap localHashMap = new HashMap();
    if (this.a.mEntrance == 42) {
      localHashMap.put("ext1", "2");
    } else {
      localHashMap.put("ext1", "1");
    }
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).report5504(new QCircleLpReportDc05504DataBuilder().setActionType(41).setSubActionType(1).setThrActionType(1).setExtras(localHashMap));
  }
  
  private void g()
  {
    if (this.c == null) {
      this.c = new ArrayList();
    }
    Object localObject = this.a.mIntent.getStringExtra("group_name");
    Groups localGroups = new Groups();
    localGroups.group_id = 1006;
    localGroups.group_name = ((String)localObject);
    localGroups.group_friend_count = this.c.size();
    localGroups.seqid = 0;
    this.f.add(localGroups);
    this.g.put(localGroups.group_id, this.c);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addCurGroup, mGroupmembers[");
      ((StringBuilder)localObject).append(this.c.size());
      ((StringBuilder)localObject).append("]");
      QLog.w("FriendTeamListInnerFrameBuddyListAdapter", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private void h()
  {
    if (this.a.mDonotNeedContacts) {
      return;
    }
    int n = this.l.getSelfBindState();
    if ((this.l.isBindContactOk()) || (n == 8))
    {
      Object localObject = this.l.getBindNonfriendList();
      if (localObject != null)
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll((Collection)localObject);
        if (!localArrayList.isEmpty())
        {
          localObject = new Groups();
          ((Groups)localObject).group_id = 1002;
          ((Groups)localObject).group_name = this.d.getString(2131892489);
          ((Groups)localObject).group_friend_count = 1;
          ((Groups)localObject).seqid = 0;
          this.f.add(localObject);
          this.g.put(((Groups)localObject).group_id, localArrayList);
        }
      }
    }
  }
  
  private void i()
  {
    this.f.clear();
    this.g.clear();
    this.r.a(this.f, this.g);
    if ((this.a.mEntrance == 11) && (this.a.mType == 1)) {
      g();
    }
    if (this.a.mEntrance == 33) {
      c();
    } else {
      d();
    }
    if ((this.a.mEntrance == 42) || (this.a.mEntrance == 41)) {
      e();
    }
    h();
    ArrayList localArrayList = (ArrayList)((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).asyncGetGroupListForUI(this.e);
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
      int n = 0;
      if (!bool) {
        break;
      }
      Groups localGroups = (Groups)((Iterator)localObject2).next();
      this.f.add(localGroups);
      localArrayList = SearchUtils.a(this.e, String.valueOf(localGroups.group_id));
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
      while (n < localArrayList.size())
      {
        localObject4 = (Friends)localArrayList.get(n);
        if ((!((Friends)localObject4).uin.equals(this.e.getCurrentAccountUin())) && (!this.a.mUinsToHide.contains(((Friends)localObject4).uin)) && (!Utils.c(((Friends)localObject4).uin)) && (!CommonUtils.a(this.e, ((Friends)localObject4).uin)) && ((!this.a.mFilterRobot) || (!CommonUtils.c(this.e, ((Friends)localObject4).uin)))) {
          ((ArrayList)localObject3).add(localArrayList.get(n));
        }
        n += 1;
      }
      this.g.put(localGroups.group_id, localObject3);
    }
    if ((this.j != null) && (!((List)localObject1).isEmpty()) && (this.m)) {
      this.j.expandGroup(0);
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
    this.r = paramRelationFriendsTroopViewHelper;
  }
  
  public void a(ArrayList<Entity> paramArrayList)
  {
    this.c = paramArrayList;
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
  
  public Groups b(long paramLong)
  {
    int n = 0;
    while (n < this.f.size())
    {
      Groups localGroups = (Groups)this.f.get(n);
      if (localGroups.group_id == paramLong) {
        return localGroups;
      }
      n += 1;
    }
    return null;
  }
  
  public void b()
  {
    if (!this.a.mDonotNeedContacts) {
      this.l.removeListener(this);
    }
    if (this.a.mEntrance == 33) {
      this.k.removeObserver(this.e);
    }
    SelectMemberBuddyListAdapter.TroopMemberFaceUtil localTroopMemberFaceUtil = this.b;
    if (localTroopMemberFaceUtil != null)
    {
      localTroopMemberFaceUtil.a();
      this.b = null;
    }
    this.j = null;
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
      paramView.findViewById(2131436369).setVisibility(0);
      ((SelectMemberBuddyListAdapter.GroupTag)localObject1).b = ((TextView)paramView.findViewById(2131434435));
      paramView.setTag(localObject1);
    }
    localObject2 = (Groups)getGroup(paramInt);
    ((SelectMemberBuddyListAdapter.GroupTag)localObject1).b.setText(((Groups)localObject2).group_name);
    if (this.j != null) {
      ((CheckBox)paramView.findViewById(2131436369)).setChecked(this.j.isGroupExpanded(paramInt));
    }
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    int n = ((Groups)this.f.get(paramInt1)).group_id;
    ArrayList localArrayList = (ArrayList)this.g.get(n);
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
        l1 = this.r.a(localRelationTroopEntity.troopInfo.troopuin).longValue();
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
      paramView = this.r.b(paramInt1, paramInt2, paramView, paramViewGroup, this.a, this.i, localRelationTroopEntity);
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
      paramViewGroup = (SelectMemberBuddyListAdapter.GroupTag)paramView.getTag();
    }
    else
    {
      paramView = LayoutInflater.from(this.d).inflate(2131626499, paramViewGroup, false);
      paramViewGroup = new SelectMemberBuddyListAdapter.GroupTag();
      paramViewGroup.b = ((TextView)paramView.findViewById(2131434435));
      paramView.setTag(paramViewGroup);
      paramView.setOnClickListener(this);
    }
    Groups localGroups = (Groups)getGroup(paramInt);
    paramViewGroup.a = paramInt;
    paramViewGroup.b.setText(localGroups.group_name);
    if (AppSetting.e) {
      if (paramBoolean)
      {
        paramViewGroup = new StringBuilder();
        paramViewGroup.append(localGroups.group_name);
        paramViewGroup.append(HardCodeUtil.a(2131911195));
        paramView.setContentDescription(paramViewGroup.toString());
      }
      else
      {
        paramViewGroup = new StringBuilder();
        paramViewGroup.append(localGroups.group_name);
        paramViewGroup.append(HardCodeUtil.a(2131911186));
        paramView.setContentDescription(paramViewGroup.toString());
      }
    }
    paramView.setOnLongClickListener(this);
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
    i();
    super.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    Object localObject = (SelectMemberBuddyListAdapter.GroupTag)paramView.getTag();
    if (this.n.isGroupExpanded(((SelectMemberBuddyListAdapter.GroupTag)localObject).a)) {
      this.n.collapseGroup(((SelectMemberBuddyListAdapter.GroupTag)localObject).a);
    }
    try
    {
      this.n.expandGroup(((SelectMemberBuddyListAdapter.GroupTag)localObject).a);
      localObject = (Groups)getGroup(((SelectMemberBuddyListAdapter.GroupTag)localObject).a);
      if (((Groups)localObject).group_id == 1003)
      {
        if (this.a.mSubType == 0) {
          ReportController.b(this.e, "CliOper", "", "", "0X8005442", "0X8005442", 1, 0, "", "", "", "");
        } else {
          ReportController.b(this.e, "CliOper", "", "", "0X8005442", "0X8005442", 2, 0, "", "", "", "");
        }
      }
      else if (((Groups)localObject).group_id == 1002)
      {
        if (this.a.mSubType == 0) {
          ReportController.b(this.e, "CliOper", "", "", "0X8005444", "0X8005444", 1, 0, "", "", "", "");
        } else {
          ReportController.b(this.e, "CliOper", "", "", "0X8005444", "0X8005444", 2, 0, "", "", "", "");
        }
      }
      else if (((Groups)localObject).group_id == 0)
      {
        if (this.a.mSubType == 0) {
          ReportController.b(this.e, "CliOper", "", "", "0X8005443", "0X8005443", 1, 0, "", "", "", "");
        } else {
          ReportController.b(this.e, "CliOper", "", "", "0X8005443", "0X8005443", 2, 0, "", "", "", "");
        }
      }
      else if (this.a.mSubType == 0) {
        ReportController.b(this.e, "CliOper", "", "", "0X8005445", "0X8005445", 1, 0, "", "", "", "");
      } else {
        ReportController.b(this.e, "CliOper", "", "", "0X8005445", "0X8005445", 2, 0, "", "", "", "");
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
    localQQCustomMenu.a(0, this.d.getResources().getString(2131890205));
    ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).showAsDropDown(paramView, localQQCustomMenu, this.u, new SelectMemberBuddyListAdapter.2(this));
    return true;
  }
  
  public void onRefreshTopayList(boolean paramBoolean)
  {
    SelectMemberActivity localSelectMemberActivity = this.a;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectMemberBuddyListAdapter
 * JD-Core Version:    0.7.0.1
 */