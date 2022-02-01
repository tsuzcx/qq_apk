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
    b();
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
    Object localObject = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject != null) {
      localObject = String.valueOf(((List)localObject).size());
    } else {
      localObject = String.valueOf(0);
    }
    if (paramInt == 1) {
      return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131699507), new Object[] { localObject });
    }
    if (paramInt == 2) {
      return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131699508), new Object[] { localObject });
    }
    if (paramInt == 3) {
      return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131699509), new Object[] { localObject });
    }
    if (paramInt == 4) {
      return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131699510), new Object[] { localObject });
    }
    if (paramInt == 5) {
      return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131699511), new Object[] { localObject });
    }
    return localObject;
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
    boolean bool;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localTextView1.setText(String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131699500), new Object[] { String.valueOf(((List)localObject).size()) }));
      bool = false;
    }
    else
    {
      localTextView1.setText(2131699512);
      bool = true;
    }
    localTextView1.setOnClickListener(this);
    localTextView1.setTag(new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
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
      if (!paramTroopMemInfoData.jdField_a_of_type_Boolean)
      {
        localChildViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        paramView.setOnClickListener(null);
      }
      else
      {
        localObject1 = (List)this.b.get(paramInt);
        boolean bool;
        if ((localObject1 != null) && (((List)localObject1).contains(paramTroopMemInfoData.jdField_b_of_type_JavaLangString))) {
          bool = true;
        } else {
          bool = false;
        }
        localChildViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        localChildViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        paramView.setOnClickListener(this);
      }
      localChildViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter$TroopMemberFaceUtil;
      if (localObject1 != null) {
        a(localChildViewHolder, ((SelectTroopMemberAdapter.TroopMemberFaceUtil)localObject1).a(paramTroopMemInfoData));
      }
      localObject1 = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopMemInfoData.jdField_a_of_type_JavaLangString, paramTroopMemInfoData.jdField_b_of_type_JavaLangString);
      localChildViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      localChildViewHolder.jdField_a_of_type_JavaLangString = paramTroopMemInfoData.jdField_b_of_type_JavaLangString;
      if (localChildViewHolder.jdField_a_of_type_AndroidViewView != null) {
        if (RobotUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopMemInfoData.jdField_b_of_type_JavaLangString)) {
          localChildViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        } else {
          localChildViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
      }
      if (!((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).isNewRealLevelGrayTroop(paramTroopMemInfoData.jdField_a_of_type_JavaLangString))
      {
        localChildViewHolder.b.setVisibility(8);
        if (this.jdField_a_of_type_Boolean) {
          localChildViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopmemberlevelTroopMemberNewLevelView.setVisibility(8);
        }
      }
      else
      {
        int i = paramTroopMemInfoData.jdField_a_of_type_Int;
        paramInt = i;
        if (i == 0) {
          paramInt = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).convertOldLevelToNewLevel(paramTroopMemInfoData.jdField_b_of_type_Int);
        }
        Object localObject2 = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getTroopMemberRankItem(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, paramTroopMemInfoData.jdField_b_of_type_JavaLangString, paramInt, paramTroopMemInfoData.jdField_c_of_type_Int, paramTroopMemInfoData.d, paramTroopMemInfoData.jdField_a_of_type_Byte);
        if (localObject2 != null) {
          localChildViewHolder.b.setTroopMemberNewLevel((TroopMemberRankItem)localObject2);
        }
        if (this.jdField_a_of_type_Boolean)
        {
          localChildViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopmemberlevelTroopMemberNewLevelView.setVisibility(8);
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
          if ((localObject2 != null) && (((TroopInfo)localObject2).isTroopOwner(paramTroopMemInfoData.jdField_b_of_type_JavaLangString)))
          {
            paramTroopMemInfoData = new TroopMemberRankItem();
            paramTroopMemInfoData.b = true;
            paramTroopMemInfoData.jdField_a_of_type_Boolean = false;
            paramTroopMemInfoData.jdField_a_of_type_Int = 300;
            paramTroopMemInfoData.jdField_a_of_type_ArrayOfInt = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(paramTroopMemInfoData.jdField_a_of_type_Int);
            paramTroopMemInfoData.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715513);
            localChildViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopmemberlevelTroopMemberNewLevelView.setTroopMemberNewLevel(paramTroopMemInfoData);
          }
          else
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
            if ((localObject2 != null) && (((TroopInfo)localObject2).isTroopAdmin(paramTroopMemInfoData.jdField_b_of_type_JavaLangString)))
            {
              paramTroopMemInfoData = new TroopMemberRankItem();
              paramTroopMemInfoData.b = true;
              paramTroopMemInfoData.jdField_a_of_type_Boolean = false;
              paramTroopMemInfoData.jdField_a_of_type_Int = 301;
              paramTroopMemInfoData.jdField_a_of_type_ArrayOfInt = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(paramTroopMemInfoData.jdField_a_of_type_Int);
              paramTroopMemInfoData.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715502);
              localChildViewHolder.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopmemberlevelTroopMemberNewLevelView.setTroopMemberNewLevel(paramTroopMemInfoData);
            }
          }
        }
      }
      if ((AppSetting.d) && (localChildViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
      {
        if (localChildViewHolder.jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
        {
          paramTroopMemInfoData = new StringBuilder();
          paramTroopMemInfoData.append((String)localObject1);
          paramTroopMemInfoData.append(HardCodeUtil.a(2131715326));
          paramView.setContentDescription(paramTroopMemInfoData.toString());
          return;
        }
        paramTroopMemInfoData = new StringBuilder();
        paramTroopMemInfoData.append((String)localObject1);
        paramTroopMemInfoData.append(HardCodeUtil.a(2131715350));
        paramView.setContentDescription(paramTroopMemInfoData.toString());
      }
    }
  }
  
  private boolean a(TroopMemberInfo paramTroopMemberInfo, TroopInfo paramTroopInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramTroopMemberInfo != null)
    {
      if (paramTroopInfo == null) {
        return false;
      }
      boolean bool3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramTroopMemberInfo.memberuin);
      boolean bool4 = paramTroopInfo.isTroopOwner(paramTroopMemberInfo.memberuin);
      boolean bool5 = paramTroopInfo.isTroopAdmin(paramTroopMemberInfo.memberuin);
      boolean bool6 = paramTroopInfo.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
    if (paramView != null)
    {
      if (paramView.length != 2) {
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
      else
      {
        paramView = (List)this.b.get(i);
        if (paramView != null) {
          paramView.clear();
        }
        new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_mber").c("del_mber").d("sel_cancel").a(this.jdField_a_of_type_Int).a(new String[] { this.jdField_a_of_type_JavaLangString }).a();
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter$AdapterCallBack;
      if (paramView != null) {
        paramView.a();
      }
      notifyDataSetChanged();
    }
  }
  
  private void d(View paramView)
  {
    paramView = (SelectTroopMemberAdapter.ChildViewHolder)paramView.getTag();
    if (paramView.jdField_a_of_type_AndroidWidgetCheckBox.getVisibility() == 8) {
      return;
    }
    int i = paramView.jdField_a_of_type_Int;
    boolean bool = paramView.jdField_a_of_type_AndroidWidgetCheckBox.isChecked() ^ true;
    paramView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
    if ((List)this.b.get(i) == null) {
      this.b.put(i, new ArrayList());
    }
    if (bool)
    {
      ((List)this.b.get(i)).add(paramView.jdField_a_of_type_JavaLangString);
      new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_mber").c("del_mber").d("sel_pic").a(this.jdField_a_of_type_Int).a(new String[] { this.jdField_a_of_type_JavaLangString }).a();
    }
    else
    {
      ((List)this.b.get(i)).remove(paramView.jdField_a_of_type_JavaLangString);
      new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_mber").c("del_mber").d("sel_pic_cel").a(this.jdField_a_of_type_Int).a(new String[] { this.jdField_a_of_type_JavaLangString }).a();
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter$AdapterCallBack;
    if (paramView != null) {
      paramView.a();
    }
    notifyDataSetChanged();
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
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      int j = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
      List localList = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(j);
      if ((localList != null) && (localList.size() > 0)) {
        break label59;
      }
      i += 1;
    }
    i = -1;
    label59:
    if ((i != -1) && (this.jdField_a_of_type_ComTencentWidgetExpandableListView != null) && (!this.jdField_a_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(i))) {
      this.jdField_a_of_type_ComTencentWidgetExpandableListView.expandGroup(i);
    }
  }
  
  protected void a(List<TroopMemberInfo> paramList)
  {
    b();
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_JavaLangString);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    int j = 0;
    boolean bool;
    if ((localObject != null) && (((TroopInfo)localObject).isHomeworkTroop())) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
    localObject = Calendar.getInstance();
    long l3 = NetConnInfoCenter.getServerTime();
    ((Calendar)localObject).setTimeInMillis(l3 * 1000L);
    Calendar localCalendar = Calendar.getInstance();
    paramList = paramList.iterator();
    int i;
    for (;;)
    {
      i = j;
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
      i = (((Calendar)localObject).get(1) - localCalendar.get(1)) * 365 + ((Calendar)localObject).get(6) - localCalendar.get(6);
      Long localLong = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(localTroopMemberInfo.memberuin);
      if ((localLong != null) && (localLong.longValue() > l3)) {
        ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(1)).add(a(localTroopMemberInfo, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo));
      } else if (i >= 180) {
        ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(2)).add(a(localTroopMemberInfo, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo));
      } else if (i >= 60) {
        ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(3)).add(a(localTroopMemberInfo, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo));
      } else if (i >= 30) {
        ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(4)).add(a(localTroopMemberInfo, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo));
      } else {
        ((List)this.jdField_a_of_type_AndroidUtilSparseArray.get(5)).add(a(localTroopMemberInfo, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo));
      }
    }
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      j = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
      paramList = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(j);
      if (paramList != null) {
        Collections.sort(paramList, new SelectTroopMemberAdapter.TroopCompator());
      }
      i += 1;
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
  
  protected void b()
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
  
  public void c()
  {
    SelectTroopMemberAdapter.TroopMemberFaceUtil localTroopMemberFaceUtil = this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter$TroopMemberFaceUtil;
    if (localTroopMemberFaceUtil != null)
    {
      localTroopMemberFaceUtil.a();
      this.jdField_a_of_type_ComTencentMobileqqTroopSelecttroopmemberSelectTroopMemberAdapter$TroopMemberFaceUtil = null;
    }
    super.c();
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
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560462, null);
      paramView = new SelectTroopMemberAdapter.ChildViewHolder();
      localView.setTag(paramView);
      paramView.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131376702));
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131364613));
      paramView.c = ((ImageView)localView.findViewById(2131368343));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371697));
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131379859);
      paramView.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopmemberlevelTroopMemberNewLevelView = ((TroopMemberNewLevelView)localView.findViewById(2131379301));
      paramView.b = ((TroopMemberNewLevelView)localView.findViewById(2131379300));
    }
    paramViewGroup = (SelectTroopMemberAdapter.ChildViewHolder)localView.getTag();
    paramViewGroup.jdField_a_of_type_Int = a(paramInt1).intValue();
    List localList = (List)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramViewGroup.jdField_a_of_type_Int);
    paramView = localObject;
    if (localList != null) {
      paramView = (SelectTroopMemberAdapter.TroopMemInfoData)localList.get(paramInt2);
    }
    a(localView, paramViewGroup.jdField_a_of_type_Int, paramView);
    return localView;
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
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560463, null);
      paramView = new SelectTroopMemberAdapter.GroupViewHolder();
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131369353));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131367855));
      paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377182));
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
    if (i == 2131367847) {
      b(paramView);
    } else if (i == 2131377182) {
      c(paramView);
    } else if (i == 2131377155) {
      d(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.selecttroopmember.SelectTroopMemberAdapter
 * JD-Core Version:    0.7.0.1
 */