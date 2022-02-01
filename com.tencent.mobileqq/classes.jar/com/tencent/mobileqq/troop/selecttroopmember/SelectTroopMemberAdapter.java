package com.tencent.mobileqq.troop.selecttroopmember;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.adapter.BaseFacePreloadExpandableListAdapter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi;
import com.tencent.mobileqq.troop.troopmemberlevel.TroopMemberRankItem;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.troop.widget.troopmemberlevel.TroopMemberNewLevelView;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SelectTroopMemberAdapter
  extends BaseFacePreloadExpandableListAdapter
  implements View.OnClickListener
{
  private Context a;
  private QQAppInterface b;
  private int c;
  private SelectTroopMemberAdapter.AdapterCallBack d;
  private TroopInfo e;
  private String f;
  private boolean g;
  private ArrayList<Integer> h = new ArrayList();
  private SparseArray<List<SelectTroopMemberAdapter.TroopMemInfoData>> i = new SparseArray();
  private SparseArray<List<String>> j = new SparseArray();
  private SelectTroopMemberAdapter.TroopMemberFaceUtil k;
  private HashMap<String, Long> l = new HashMap();
  
  public SelectTroopMemberAdapter(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt, ExpandableListView paramExpandableListView, SelectTroopMemberAdapter.AdapterCallBack paramAdapterCallBack)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.a = paramContext;
    this.b = paramQQAppInterface;
    this.f = paramString;
    this.c = paramInt;
    this.d = paramAdapterCallBack;
    this.k = new SelectTroopMemberAdapter.TroopMemberFaceUtil(this, paramContext, paramQQAppInterface);
    b();
  }
  
  private SelectTroopMemberAdapter.TroopMemInfoData a(TroopMemberInfo paramTroopMemberInfo, TroopInfo paramTroopInfo)
  {
    SelectTroopMemberAdapter.TroopMemInfoData localTroopMemInfoData = new SelectTroopMemberAdapter.TroopMemInfoData(null);
    if (paramTroopMemberInfo != null)
    {
      localTroopMemInfoData.a = paramTroopMemberInfo.troopuin;
      localTroopMemInfoData.c = paramTroopMemberInfo.displayedNamePinyinFirst;
      localTroopMemInfoData.b = paramTroopMemberInfo.memberuin;
      localTroopMemInfoData.d = paramTroopMemberInfo.newRealLevel;
      localTroopMemInfoData.e = paramTroopMemberInfo.realLevel;
      localTroopMemInfoData.f = paramTroopMemberInfo.level;
      localTroopMemInfoData.g = paramTroopMemberInfo.mUniqueTitle;
      localTroopMemInfoData.h = b(paramTroopMemberInfo, paramTroopInfo);
      localTroopMemInfoData.i = paramTroopMemberInfo.mHonorRichFlag;
    }
    return localTroopMemInfoData;
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    Object localObject = (SelectTroopMemberAdapter.GroupViewHolder)paramView.getTag();
    ((SelectTroopMemberAdapter.GroupViewHolder)localObject).e.setChecked(this.n.isGroupExpanded(((SelectTroopMemberAdapter.GroupViewHolder)localObject).a));
    TextView localTextView2 = ((SelectTroopMemberAdapter.GroupViewHolder)localObject).c;
    TextView localTextView1 = ((SelectTroopMemberAdapter.GroupViewHolder)localObject).d;
    int m = ((SelectTroopMemberAdapter.GroupViewHolder)localObject).b;
    localTextView2.setText(b(m));
    localObject = (List)this.j.get(m);
    boolean bool;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localTextView1.setText(String.format(this.a.getString(2131897531), new Object[] { String.valueOf(((List)localObject).size()) }));
      bool = false;
    }
    else
    {
      localTextView1.setText(2131897543);
      bool = true;
    }
    localTextView1.setOnClickListener(this);
    localTextView1.setTag(new Object[] { Integer.valueOf(m), Boolean.valueOf(bool) });
    paramView.setFocusable(true);
  }
  
  private void a(View paramView, int paramInt, SelectTroopMemberAdapter.TroopMemInfoData paramTroopMemInfoData)
  {
    if (paramView != null)
    {
      if (paramTroopMemInfoData == null) {
        return;
      }
      SelectTroopMemberAdapter.ChildViewHolder localChildViewHolder = (SelectTroopMemberAdapter.ChildViewHolder)paramView.getTag();
      if (!paramTroopMemInfoData.h)
      {
        localChildViewHolder.g.setVisibility(8);
        paramView.setOnClickListener(null);
      }
      else
      {
        localObject1 = (List)this.j.get(paramInt);
        boolean bool;
        if ((localObject1 != null) && (((List)localObject1).contains(paramTroopMemInfoData.b))) {
          bool = true;
        } else {
          bool = false;
        }
        localChildViewHolder.g.setChecked(bool);
        localChildViewHolder.g.setVisibility(0);
        paramView.setOnClickListener(this);
      }
      localChildViewHolder.b.setVisibility(0);
      Object localObject1 = this.k;
      if (localObject1 != null) {
        a(localChildViewHolder, ((SelectTroopMemberAdapter.TroopMemberFaceUtil)localObject1).a(paramTroopMemInfoData));
      }
      localObject1 = ContactUtils.b(this.b, paramTroopMemInfoData.a, paramTroopMemInfoData.b);
      localChildViewHolder.e.setText((CharSequence)localObject1);
      localChildViewHolder.y = paramTroopMemInfoData.b;
      if (localChildViewHolder.f != null) {
        if (RobotUtils.a(this.b, paramTroopMemInfoData.b)) {
          localChildViewHolder.f.setVisibility(0);
        } else {
          localChildViewHolder.f.setVisibility(8);
        }
      }
      if (!((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).isNewRealLevelGrayTroop(paramTroopMemInfoData.a))
      {
        localChildViewHolder.d.setVisibility(8);
        if (this.g) {
          localChildViewHolder.c.setVisibility(8);
        }
      }
      else
      {
        int m = paramTroopMemInfoData.d;
        paramInt = m;
        if (m == 0) {
          paramInt = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).convertOldLevelToNewLevel(paramTroopMemInfoData.e);
        }
        Object localObject2 = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getTroopMemberRankItem(this.e, paramTroopMemInfoData.b, paramInt, paramTroopMemInfoData.f, paramTroopMemInfoData.g, paramTroopMemInfoData.i);
        if (localObject2 != null) {
          localChildViewHolder.d.setTroopMemberNewLevel((TroopMemberRankItem)localObject2);
        }
        if (this.g)
        {
          localChildViewHolder.c.setVisibility(8);
          localObject2 = this.e;
          if ((localObject2 != null) && (((TroopInfo)localObject2).isTroopOwner(paramTroopMemInfoData.b)))
          {
            paramTroopMemInfoData = new TroopMemberRankItem();
            paramTroopMemInfoData.g = true;
            paramTroopMemInfoData.f = false;
            paramTroopMemInfoData.a = 300;
            paramTroopMemInfoData.d = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(paramTroopMemInfoData.a);
            paramTroopMemInfoData.c = HardCodeUtil.a(2131912986);
            localChildViewHolder.c.setTroopMemberNewLevel(paramTroopMemInfoData);
          }
          else
          {
            localObject2 = this.e;
            if ((localObject2 != null) && (((TroopInfo)localObject2).isTroopAdmin(paramTroopMemInfoData.b)))
            {
              paramTroopMemInfoData = new TroopMemberRankItem();
              paramTroopMemInfoData.g = true;
              paramTroopMemInfoData.f = false;
              paramTroopMemInfoData.a = 301;
              paramTroopMemInfoData.d = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(paramTroopMemInfoData.a);
              paramTroopMemInfoData.c = HardCodeUtil.a(2131912975);
              localChildViewHolder.c.setTroopMemberNewLevel(paramTroopMemInfoData);
            }
          }
        }
      }
      if ((AppSetting.e) && (localChildViewHolder.g.isEnabled()))
      {
        if (localChildViewHolder.g.isChecked())
        {
          paramTroopMemInfoData = new StringBuilder();
          paramTroopMemInfoData.append((String)localObject1);
          paramTroopMemInfoData.append(HardCodeUtil.a(2131912806));
          paramView.setContentDescription(paramTroopMemInfoData.toString());
          return;
        }
        paramTroopMemInfoData = new StringBuilder();
        paramTroopMemInfoData.append((String)localObject1);
        paramTroopMemInfoData.append(HardCodeUtil.a(2131912829));
        paramView.setContentDescription(paramTroopMemInfoData.toString());
      }
    }
  }
  
  private String b(int paramInt)
  {
    Object localObject = (List)this.i.get(paramInt);
    if (localObject != null) {
      localObject = String.valueOf(((List)localObject).size());
    } else {
      localObject = String.valueOf(0);
    }
    if (paramInt == 1) {
      return String.format(this.a.getString(2131897538), new Object[] { localObject });
    }
    if (paramInt == 2) {
      return String.format(this.a.getString(2131897539), new Object[] { localObject });
    }
    if (paramInt == 3) {
      return String.format(this.a.getString(2131897540), new Object[] { localObject });
    }
    if (paramInt == 4) {
      return String.format(this.a.getString(2131897541), new Object[] { localObject });
    }
    if (paramInt == 5) {
      return String.format(this.a.getString(2131897542), new Object[] { localObject });
    }
    return localObject;
  }
  
  private void b(View paramView)
  {
    paramView = (SelectTroopMemberAdapter.GroupViewHolder)paramView.getTag();
    if (this.n.isGroupExpanded(paramView.a))
    {
      this.n.collapseGroup(paramView.a);
      return;
    }
    this.n.expandGroup(paramView.a);
  }
  
  private boolean b(TroopMemberInfo paramTroopMemberInfo, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramTroopMemberInfo != null)
    {
      if (paramTroopInfo == null) {
        return false;
      }
      boolean bool3 = this.b.getCurrentAccountUin().equals(paramTroopMemberInfo.memberuin);
      boolean bool4 = paramTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
      boolean bool5 = paramTroopInfo.isTroopAdmin(paramTroopMemberInfo.memberuin);
      boolean bool6 = paramTroopInfo.isTroopOwner(this.b.getCurrentAccountUin());
      bool1 = bool2;
      if (!bool4) {
        if (!bool6)
        {
          bool1 = bool2;
          if (bool5) {}
        }
        else
        {
          bool1 = bool2;
          if (!bool3) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private void c(View paramView)
  {
    paramView = (Object[])paramView.getTag();
    if (paramView != null)
    {
      if (paramView.length != 2) {
        return;
      }
      int m = ((Integer)paramView[0]).intValue();
      if (((Boolean)paramView[1]).booleanValue())
      {
        Object localObject = (List)this.i.get(m);
        if (localObject != null)
        {
          paramView = new ArrayList();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            SelectTroopMemberAdapter.TroopMemInfoData localTroopMemInfoData = (SelectTroopMemberAdapter.TroopMemInfoData)((Iterator)localObject).next();
            if (localTroopMemInfoData.h) {
              paramView.add(localTroopMemInfoData.b);
            }
          }
          this.j.put(m, paramView);
        }
        new ReportTask(this.b).a("dc00899").b("Grp_mber").c("del_mber").d("sel_clk").a(this.c).a(new String[] { this.f }).a();
      }
      else
      {
        paramView = (List)this.j.get(m);
        if (paramView != null) {
          paramView.clear();
        }
        new ReportTask(this.b).a("dc00899").b("Grp_mber").c("del_mber").d("sel_cancel").a(this.c).a(new String[] { this.f }).a();
      }
      paramView = this.d;
      if (paramView != null) {
        paramView.a();
      }
      notifyDataSetChanged();
    }
  }
  
  private void d(View paramView)
  {
    paramView = (SelectTroopMemberAdapter.ChildViewHolder)paramView.getTag();
    if (paramView.g.getVisibility() == 8) {
      return;
    }
    int m = paramView.a;
    boolean bool = paramView.g.isChecked() ^ true;
    paramView.g.setChecked(bool);
    if ((List)this.j.get(m) == null) {
      this.j.put(m, new ArrayList());
    }
    if (bool)
    {
      ((List)this.j.get(m)).add(paramView.y);
      new ReportTask(this.b).a("dc00899").b("Grp_mber").c("del_mber").d("sel_pic").a(this.c).a(new String[] { this.f }).a();
    }
    else
    {
      ((List)this.j.get(m)).remove(paramView.y);
      new ReportTask(this.b).a("dc00899").b("Grp_mber").c("del_mber").d("sel_pic_cel").a(this.c).a(new String[] { this.f }).a();
    }
    paramView = this.d;
    if (paramView != null) {
      paramView.a();
    }
    notifyDataSetChanged();
  }
  
  public SelectTroopMemberAdapter.TroopMemInfoData a(int paramInt1, int paramInt2)
  {
    List localList = (List)this.i.get(a(paramInt1).intValue());
    if (localList != null) {
      return (SelectTroopMemberAdapter.TroopMemInfoData)localList.get(paramInt2);
    }
    return null;
  }
  
  public Integer a(int paramInt)
  {
    return (Integer)this.h.get(paramInt);
  }
  
  public void a()
  {
    int m = 0;
    while (m < this.i.size())
    {
      int n = this.i.keyAt(m);
      List localList = (List)this.i.get(n);
      if ((localList != null) && (localList.size() > 0)) {
        break label59;
      }
      m += 1;
    }
    m = -1;
    label59:
    if ((m != -1) && (this.n != null) && (!this.n.isGroupExpanded(m))) {
      this.n.expandGroup(m);
    }
  }
  
  protected void a(List<TroopMemberInfo> paramList)
  {
    b();
    if (paramList == null) {
      return;
    }
    this.e = ((TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER)).f(this.f);
    Object localObject = this.e;
    int n = 0;
    boolean bool;
    if ((localObject != null) && (((TroopInfo)localObject).isHomeworkTroop())) {
      bool = true;
    } else {
      bool = false;
    }
    this.g = bool;
    localObject = Calendar.getInstance();
    long l3 = NetConnInfoCenter.getServerTime();
    ((Calendar)localObject).setTimeInMillis(l3 * 1000L);
    Calendar localCalendar = Calendar.getInstance();
    paramList = paramList.iterator();
    int m;
    for (;;)
    {
      m = n;
      if (!paramList.hasNext()) {
        break;
      }
      TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)paramList.next();
      long l2 = localTroopMemberInfo.last_active_time;
      long l1 = l2;
      if (l2 == 0L) {
        l1 = localTroopMemberInfo.join_time;
      }
      localCalendar.setTimeInMillis(l1 * 1000L);
      m = (((Calendar)localObject).get(1) - localCalendar.get(1)) * 365 + ((Calendar)localObject).get(6) - localCalendar.get(6);
      Long localLong = (Long)this.l.get(localTroopMemberInfo.memberuin);
      if ((localLong != null) && (localLong.longValue() > l3)) {
        ((List)this.i.get(1)).add(a(localTroopMemberInfo, this.e));
      } else if (m >= 180) {
        ((List)this.i.get(2)).add(a(localTroopMemberInfo, this.e));
      } else if (m >= 60) {
        ((List)this.i.get(3)).add(a(localTroopMemberInfo, this.e));
      } else if (m >= 30) {
        ((List)this.i.get(4)).add(a(localTroopMemberInfo, this.e));
      } else {
        ((List)this.i.get(5)).add(a(localTroopMemberInfo, this.e));
      }
    }
    while (m < this.i.size())
    {
      n = this.i.keyAt(m);
      paramList = (List)this.i.get(n);
      if (paramList != null) {
        Collections.sort(paramList, new SelectTroopMemberAdapter.TroopCompator());
      }
      m += 1;
    }
  }
  
  public void a(List<TroopMemberInfo> paramList, HashMap<String, Long> paramHashMap)
  {
    if (paramList == null) {
      return;
    }
    this.l.clear();
    if (paramHashMap != null) {
      this.l.putAll(paramHashMap);
    }
    a(paramList);
    notifyDataSetChanged();
  }
  
  protected void b()
  {
    this.h.clear();
    this.h.add(Integer.valueOf(1));
    this.h.add(Integer.valueOf(2));
    this.h.add(Integer.valueOf(3));
    this.h.add(Integer.valueOf(4));
    this.h.add(Integer.valueOf(5));
    this.i.clear();
    this.i.put(1, new ArrayList());
    this.i.put(2, new ArrayList());
    this.i.put(3, new ArrayList());
    this.i.put(4, new ArrayList());
    this.i.put(5, new ArrayList());
  }
  
  public void c()
  {
    SelectTroopMemberAdapter.TroopMemberFaceUtil localTroopMemberFaceUtil = this.k;
    if (localTroopMemberFaceUtil != null)
    {
      localTroopMemberFaceUtil.a();
      this.k = null;
    }
    super.c();
  }
  
  public SparseArray<List<String>> d()
  {
    return this.j;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return 0L;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = null;
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131626507, null);
      paramView = new SelectTroopMemberAdapter.ChildViewHolder();
      localView.setTag(paramView);
      paramView.b = ((RelativeLayout)localView.findViewById(2131444983));
      paramView.g = ((CheckBox)localView.findViewById(2131430688));
      paramView.A = ((ImageView)localView.findViewById(2131435219));
      paramView.e = ((TextView)localView.findViewById(2131439121));
      paramView.f = localView.findViewById(2131448716);
      paramView.c = ((TroopMemberNewLevelView)localView.findViewById(2131448038));
      paramView.d = ((TroopMemberNewLevelView)localView.findViewById(2131448037));
    }
    paramViewGroup = (SelectTroopMemberAdapter.ChildViewHolder)localView.getTag();
    paramViewGroup.a = a(paramInt1).intValue();
    List localList = (List)this.i.get(paramViewGroup.a);
    paramView = localObject;
    if (localList != null) {
      paramView = (SelectTroopMemberAdapter.TroopMemInfoData)localList.get(paramInt2);
    }
    a(localView, paramViewGroup.a, paramView);
    return localView;
  }
  
  public int getChildrenCount(int paramInt)
  {
    List localList = (List)this.i.get(a(paramInt).intValue());
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public int getGroupCount()
  {
    return this.h.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return 0L;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131626508, null);
      paramView = new SelectTroopMemberAdapter.GroupViewHolder();
      paramView.e = ((CheckBox)localView.findViewById(2131436369));
      paramView.c = ((TextView)localView.findViewById(2131434435));
      paramView.d = ((TextView)localView.findViewById(2131445560));
      localView.setTag(paramView);
    }
    paramView = (SelectTroopMemberAdapter.GroupViewHolder)localView.getTag();
    paramView.b = a(paramInt).intValue();
    paramView.a = paramInt;
    localView.setOnClickListener(this);
    a(localView);
    return localView;
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    if (m == 2131434427) {
      b(paramView);
    } else if (m == 2131445560) {
      c(paramView);
    } else if (m == 2131445533) {
      d(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.selecttroopmember.SelectTroopMemberAdapter
 * JD-Core Version:    0.7.0.1
 */