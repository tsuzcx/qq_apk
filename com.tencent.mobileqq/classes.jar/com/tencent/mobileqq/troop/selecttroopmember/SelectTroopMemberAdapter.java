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
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberLevelUtils;
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberNewLevelView;
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberRankItem;
import com.tencent.mobileqq.troop.utils.RobotUtils;
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
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<List<SelectTroopMemberAdapter.TroopMemInfoData>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
  private SelectTroopMemberAdapter.AdapterCallBack jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter$AdapterCallBack;
  private SelectTroopMemberAdapter.TroopMemberFaceUtil jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter$TroopMemberFaceUtil;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  private SparseArray<List<String>> b = new SparseArray();
  
  public SelectTroopMemberAdapter(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt, ExpandableListView paramExpandableListView, SelectTroopMemberAdapter.AdapterCallBack paramAdapterCallBack)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter$AdapterCallBack = paramAdapterCallBack;
    this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter$TroopMemberFaceUtil = new SelectTroopMemberAdapter.TroopMemberFaceUtil(this, paramContext, paramQQAppInterface);
    c();
  }
  
  private SelectTroopMemberAdapter.TroopMemInfoData a(TroopMemberInfo paramTroopMemberInfo, TroopInfo paramTroopInfo)
  {
    SelectTroopMemberAdapter.TroopMemInfoData localTroopMemInfoData = new SelectTroopMemberAdapter.TroopMemInfoData(null);
    if (paramTroopMemberInfo != null)
    {
      localTroopMemInfoData.jdField_a_of_type_JavaLangString = paramTroopMemberInfo.troopuin;
      localTroopMemInfoData.jdField_c_of_type_JavaLangString = paramTroopMemberInfo.displayedNamePinyinFirst;
      localTroopMemInfoData.jdField_b_of_type_JavaLangString = paramTroopMemberInfo.memberuin;
      localTroopMemInfoData.jdField_a_of_type_Int = paramTroopMemberInfo.newRealLevel;
      localTroopMemInfoData.jdField_b_of_type_Int = paramTroopMemberInfo.realLevel;
      localTroopMemInfoData.jdField_c_of_type_Int = paramTroopMemberInfo.level;
      localTroopMemInfoData.d = paramTroopMemberInfo.mUniqueTitle;
      localTroopMemInfoData.jdField_a_of_type_Boolean = a(paramTroopMemberInfo, paramTroopInfo);
      localTroopMemInfoData.jdField_a_of_type_Byte = paramTroopMemberInfo.mHonorRichFlag;
    }
    return localTroopMemInfoData;
  }
  
  private String a(int paramInt)
  {
    Object localObject1 = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = String.valueOf(((List)localObject1).size());
      if (paramInt != 1) {
        break label62;
      }
      localObject2 = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131699402), new Object[] { localObject1 });
    }
    label62:
    do
    {
      return localObject2;
      localObject1 = String.valueOf(0);
      break;
      if (paramInt == 2) {
        return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131699403), new Object[] { localObject1 });
      }
      if (paramInt == 3) {
        return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131699404), new Object[] { localObject1 });
      }
      if (paramInt == 4) {
        return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131699405), new Object[] { localObject1 });
      }
      localObject2 = localObject1;
    } while (paramInt != 5);
    return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131699406), new Object[] { localObject1 });
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    Object localObject = (SelectTroopMemberAdapter.GroupViewHolder)paramView.getTag();
    ((SelectTroopMemberAdapter.GroupViewHolder)localObject).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(((SelectTroopMemberAdapter.GroupViewHolder)localObject).jdField_a_of_type_Int));
    TextView localTextView2 = ((SelectTroopMemberAdapter.GroupViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView;
    TextView localTextView1 = ((SelectTroopMemberAdapter.GroupViewHolder)localObject).jdField_b_of_type_AndroidWidgetTextView;
    int i = ((SelectTroopMemberAdapter.GroupViewHolder)localObject).jdField_b_of_type_Int;
    localTextView2.setText(a(i));
    localObject = (List)this.b.get(i);
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      localTextView1.setText(String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131699395), new Object[] { String.valueOf(((List)localObject).size()) }));
    }
    for (boolean bool = false;; bool = true)
    {
      localTextView1.setOnClickListener(this);
      localTextView1.setTag(new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
      paramView.setFocusable(true);
      return;
      localTextView1.setText(2131699407);
    }
  }
  
  private void a(View paramView, int paramInt, SelectTroopMemberAdapter.TroopMemInfoData paramTroopMemInfoData)
  {
    if ((paramView == null) || (paramTroopMemInfoData == null)) {
      return;
    }
    SelectTroopMemberAdapter.ChildViewHolder localChildViewHolder = (SelectTroopMemberAdapter.ChildViewHolder)paramView.getTag();
    label40:
    Object localObject;
    if (!paramTroopMemInfoData.jdField_a_of_type_Boolean)
    {
      localChildViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
      paramView.setOnClickListener(null);
      localChildViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter$TroopMemberFaceUtil != null) {
        a(localChildViewHolder, this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter$TroopMemberFaceUtil.a(paramTroopMemInfoData));
      }
      localObject = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopMemInfoData.jdField_a_of_type_JavaLangString, paramTroopMemInfoData.jdField_b_of_type_JavaLangString);
      localChildViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      localChildViewHolder.jdField_a_of_type_JavaLangString = paramTroopMemInfoData.jdField_b_of_type_JavaLangString;
      if (localChildViewHolder.jdField_a_of_type_AndroidViewView != null)
      {
        if (RobotUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopMemInfoData.jdField_b_of_type_JavaLangString)) {
          localChildViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
      }
      else
      {
        label137:
        if (TroopMemberLevelUtils.a(paramTroopMemInfoData.jdField_a_of_type_JavaLangString)) {
          break label306;
        }
        localChildViewHolder.b.setVisibility(8);
        if (this.jdField_a_of_type_Boolean) {
          localChildViewHolder.jdField_a_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView.setVisibility(8);
        }
        label174:
        if ((!AppSetting.d) || (!localChildViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())) {
          break label542;
        }
        if (!localChildViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
          break label544;
        }
        paramView.setContentDescription((String)localObject + HardCodeUtil.a(2131715404));
      }
    }
    else
    {
      localObject = (List)this.b.get(paramInt);
      if ((localObject == null) || (!((List)localObject).contains(paramTroopMemInfoData.jdField_b_of_type_JavaLangString))) {
        break label573;
      }
    }
    label306:
    label573:
    for (boolean bool = true;; bool = false)
    {
      localChildViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      localChildViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
      paramView.setOnClickListener(this);
      break label40;
      localChildViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
      break label137;
      int i = paramTroopMemInfoData.jdField_a_of_type_Int;
      paramInt = i;
      if (i == 0) {
        paramInt = TroopMemberLevelUtils.b(paramTroopMemInfoData.jdField_b_of_type_Int);
      }
      TroopMemberRankItem localTroopMemberRankItem = TroopMemberLevelUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, paramTroopMemInfoData.jdField_b_of_type_JavaLangString, paramInt, paramTroopMemInfoData.jdField_c_of_type_Int, paramTroopMemInfoData.d, paramTroopMemInfoData.jdField_a_of_type_Byte);
      if (localTroopMemberRankItem != null) {
        localChildViewHolder.b.setTroopMemberNewLevel(localTroopMemberRankItem);
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label174;
      }
      localChildViewHolder.jdField_a_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView.setVisibility(8);
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isTroopOwner(paramTroopMemInfoData.jdField_b_of_type_JavaLangString)))
      {
        paramTroopMemInfoData = new TroopMemberRankItem();
        paramTroopMemInfoData.b = true;
        paramTroopMemInfoData.jdField_a_of_type_Boolean = false;
        paramTroopMemInfoData.jdField_a_of_type_Int = 300;
        paramTroopMemInfoData.jdField_a_of_type_ArrayOfInt = TroopMemberLevelUtils.a(paramTroopMemInfoData.jdField_a_of_type_Int);
        paramTroopMemInfoData.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715589);
        localChildViewHolder.jdField_a_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView.setTroopMemberNewLevel(paramTroopMemInfoData);
        break label174;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isTroopAdmin(paramTroopMemInfoData.jdField_b_of_type_JavaLangString))) {
        break label174;
      }
      paramTroopMemInfoData = new TroopMemberRankItem();
      paramTroopMemInfoData.b = true;
      paramTroopMemInfoData.jdField_a_of_type_Boolean = false;
      paramTroopMemInfoData.jdField_a_of_type_Int = 301;
      paramTroopMemInfoData.jdField_a_of_type_ArrayOfInt = TroopMemberLevelUtils.a(paramTroopMemInfoData.jdField_a_of_type_Int);
      paramTroopMemInfoData.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715578);
      localChildViewHolder.jdField_a_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView.setTroopMemberNewLevel(paramTroopMemInfoData);
      break label174;
      break;
      paramView.setContentDescription((String)localObject + HardCodeUtil.a(2131715428));
      return;
    }
  }
  
  private boolean a(TroopMemberInfo paramTroopMemberInfo, TroopInfo paramTroopInfo)
  {
    if ((paramTroopMemberInfo == null) || (paramTroopInfo == null)) {}
    boolean bool1;
    boolean bool2;
    boolean bool3;
    boolean bool4;
    do
    {
      return false;
      bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramTroopMemberInfo.memberuin);
      bool2 = paramTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
      bool3 = paramTroopInfo.isTroopAdmin(paramTroopMemberInfo.memberuin);
      bool4 = paramTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    } while ((bool2) || ((!bool4) && (bool3)) || (bool1));
    return true;
  }
  
  private void b(View paramView)
  {
    paramView = (SelectTroopMemberAdapter.GroupViewHolder)paramView.getTag();
    if (this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(paramView.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.collapseGroup(paramView.jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetExpandableListView.expandGroup(paramView.jdField_a_of_type_Int);
  }
  
  private void c(View paramView)
  {
    paramView = (Object[])paramView.getTag();
    if ((paramView == null) || (paramView.length != 2)) {
      return;
    }
    int i = ((Integer)paramView[0]).intValue();
    if (((Boolean)paramView[1]).booleanValue())
    {
      Object localObject = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      if (localObject != null)
      {
        paramView = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          SelectTroopMemberAdapter.TroopMemInfoData localTroopMemInfoData = (SelectTroopMemberAdapter.TroopMemInfoData)((Iterator)localObject).next();
          if (localTroopMemInfoData.jdField_a_of_type_Boolean) {
            paramView.add(localTroopMemInfoData.jdField_b_of_type_JavaLangString);
          }
        }
        this.b.put(i, paramView);
      }
      new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_mber").c("del_mber").d("sel_clk").a(this.jdField_a_of_type_Int).a(new String[] { this.jdField_a_of_type_JavaLangString }).a();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter$AdapterCallBack != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter$AdapterCallBack.a();
      }
      notifyDataSetChanged();
      return;
      paramView = (List)this.b.get(i);
      if (paramView != null) {
        paramView.clear();
      }
      new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_mber").c("del_mber").d("sel_cancel").a(this.jdField_a_of_type_Int).a(new String[] { this.jdField_a_of_type_JavaLangString }).a();
    }
  }
  
  private void d(View paramView)
  {
    paramView = (SelectTroopMemberAdapter.ChildViewHolder)paramView.getTag();
    if (paramView.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() == 8) {
      return;
    }
    int i = paramView.jdField_a_of_type_Int;
    boolean bool;
    if (!paramView.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
    {
      bool = true;
      paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
      if ((List)this.b.get(i) == null) {
        this.b.put(i, new ArrayList());
      }
      if (!bool) {
        break label185;
      }
      ((List)this.b.get(i)).add(paramView.jdField_a_of_type_JavaLangString);
      new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_mber").c("del_mber").d("sel_pic").a(this.jdField_a_of_type_Int).a(new String[] { this.jdField_a_of_type_JavaLangString }).a();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter$AdapterCallBack != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter$AdapterCallBack.a();
      }
      notifyDataSetChanged();
      return;
      bool = false;
      break;
      label185:
      ((List)this.b.get(i)).remove(paramView.jdField_a_of_type_JavaLangString);
      new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_mber").c("del_mber").d("sel_pic_cel").a(this.jdField_a_of_type_Int).a(new String[] { this.jdField_a_of_type_JavaLangString }).a();
    }
  }
  
  public SparseArray<List<String>> a()
  {
    return this.b;
  }
  
  public SelectTroopMemberAdapter.TroopMemInfoData a(int paramInt1, int paramInt2)
  {
    List localList = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(a(paramInt1).intValue());
    if (localList != null) {
      return (SelectTroopMemberAdapter.TroopMemInfoData)localList.get(paramInt2);
    }
    return null;
  }
  
  public Integer a(int paramInt)
  {
    return (Integer)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a()
  {
    int i = 0;
    if (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      int j = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
      List localList = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(j);
      if ((localList == null) || (localList.size() <= 0)) {}
    }
    for (;;)
    {
      if ((i != -1) && (this.jdField_a_of_type_ComTencentWidgetExpandableListView != null) && (!this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(i))) {
        this.jdField_a_of_type_ComTencentWidgetExpandableListView.expandGroup(i);
      }
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  protected void a(List<TroopMemberInfo> paramList)
  {
    c();
    if (paramList == null) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_JavaLangString);
      boolean bool;
      Calendar localCalendar1;
      long l3;
      Calendar localCalendar2;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isHomeworkTroop()))
      {
        bool = true;
        this.jdField_a_of_type_Boolean = bool;
        localCalendar1 = Calendar.getInstance();
        l3 = NetConnInfoCenter.getServerTime();
        localCalendar1.setTimeInMillis(1000L * l3);
        localCalendar2 = Calendar.getInstance();
        paramList = paramList.iterator();
      }
      for (;;)
      {
        if (!paramList.hasNext()) {
          break label390;
        }
        TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)paramList.next();
        long l2 = localTroopMemberInfo.last_active_time;
        long l1 = l2;
        if (l2 == 0L) {
          l1 = localTroopMemberInfo.join_time;
        }
        localCalendar2.setTimeInMillis(l1 * 1000L);
        i = (localCalendar1.get(1) - localCalendar2.get(1)) * 365 + localCalendar1.get(6) - localCalendar2.get(6);
        Long localLong = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(localTroopMemberInfo.memberuin);
        if ((localLong != null) && (localLong.longValue() > l3))
        {
          ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(1)).add(a(localTroopMemberInfo, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo));
          continue;
          bool = false;
          break;
        }
        if (i >= 180) {
          ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(2)).add(a(localTroopMemberInfo, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo));
        } else if (i >= 60) {
          ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(3)).add(a(localTroopMemberInfo, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo));
        } else if (i >= 30) {
          ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(4)).add(a(localTroopMemberInfo, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo));
        } else {
          ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(5)).add(a(localTroopMemberInfo, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo));
        }
      }
      label390:
      int i = 0;
      while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        int j = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
        paramList = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(j);
        if (paramList != null) {
          Collections.sort(paramList, new SelectTroopMemberAdapter.TroopCompator());
        }
        i += 1;
      }
    }
  }
  
  public void a(List<TroopMemberInfo> paramList, HashMap<String, Long> paramHashMap)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    if (paramHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.putAll(paramHashMap);
    }
    a(paramList);
    notifyDataSetChanged();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter$TroopMemberFaceUtil != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter$TroopMemberFaceUtil.a();
      this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter$TroopMemberFaceUtil = null;
    }
    super.b();
  }
  
  protected void c()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(1));
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2));
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(3));
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(4));
    this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(5));
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1, new ArrayList());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(2, new ArrayList());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(3, new ArrayList());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(4, new ArrayList());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(5, new ArrayList());
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return 0L;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560573, null);
      paramView = new SelectTroopMemberAdapter.ChildViewHolder();
      localView.setTag(paramView);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131377244));
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131364726));
      paramView.c = ((ImageView)localView.findViewById(2131368603));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131372115));
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131380575);
      paramView.jdField_a_of_type_ComTencentMobileqqTroopTroopMemberLevelTroopMemberNewLevelView = ((TroopMemberNewLevelView)localView.findViewById(2131379972));
      paramView.b = ((TroopMemberNewLevelView)localView.findViewById(2131379971));
    }
    paramViewGroup = (SelectTroopMemberAdapter.ChildViewHolder)localView.getTag();
    paramViewGroup.jdField_a_of_type_Int = a(paramInt1).intValue();
    paramView = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramViewGroup.jdField_a_of_type_Int);
    if (paramView != null) {}
    for (paramView = (SelectTroopMemberAdapter.TroopMemInfoData)paramView.get(paramInt2);; paramView = null)
    {
      a(localView, paramViewGroup.jdField_a_of_type_Int, paramView);
      return localView;
    }
  }
  
  public int getChildrenCount(int paramInt)
  {
    List localList = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(a(paramInt).intValue());
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public int getGroupCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
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
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560574, null);
      paramView = new SelectTroopMemberAdapter.GroupViewHolder();
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131369653));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368102));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377754));
      localView.setTag(paramView);
    }
    paramView = (SelectTroopMemberAdapter.GroupViewHolder)localView.getTag();
    paramView.jdField_b_of_type_Int = a(paramInt).intValue();
    paramView.jdField_a_of_type_Int = paramInt;
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
    int i = paramView.getId();
    if (i == 2131368094) {
      b(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == 2131377754) {
        c(paramView);
      } else if (i == 2131377727) {
        d(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.selecttroopmember.SelectTroopMemberAdapter
 * JD-Core Version:    0.7.0.1
 */