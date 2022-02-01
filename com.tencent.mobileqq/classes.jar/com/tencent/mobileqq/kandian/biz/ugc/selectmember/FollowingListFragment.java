package com.tencent.mobileqq.kandian.biz.ugc.selectmember;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.kandian.biz.ugc.databinding.ObservableArrayList;
import com.tencent.mobileqq.kandian.biz.ugc.databinding.ObservableList.OnListChangedCallback;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.follow.FollowingMember;
import com.tencent.mobileqq.kandian.repo.ugc.ResultRecord;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FollowingListFragment
  extends BaseFragment
  implements ObservableList.OnListChangedCallback<ObservableArrayList<ResultRecord>>, AdapterView.OnItemClickListener
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ObservableArrayList<ResultRecord> jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingObservableArrayList;
  private FollowingListFragment.FollowListAdapter jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberFollowingListFragment$FollowListAdapter;
  private SelectMemberLimit jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit;
  private ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new FollowingListFragment.1(this);
  private List<HashMap<String, Object>> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  private void a()
  {
    a(ReadInJoyLogicEngine.a().c());
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "key_checked";
    arrayOfString[1] = "key_head_url";
    arrayOfString[2] = "key_name";
    int[] arrayOfInt = new int[3];
    int[] tmp35_34 = arrayOfInt;
    tmp35_34[0] = 2131364613;
    int[] tmp40_35 = tmp35_34;
    tmp40_35[1] = 2131368343;
    int[] tmp45_40 = tmp40_35;
    tmp45_40[2] = 2131371697;
    tmp45_40;
    SelectMemberLimit localSelectMemberLimit = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit;
    if ((localSelectMemberLimit != null) && (localSelectMemberLimit.a() == 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberFollowingListFragment$FollowListAdapter = new FollowingListFragment.ReadInJoyFollowListAQAdapter(this, getBaseActivity(), this.jdField_a_of_type_JavaUtilList, 2131560271, arrayOfString, arrayOfInt);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberFollowingListFragment$FollowListAdapter = new FollowingListFragment.FollowListAdapter(this, getBaseActivity(), this.jdField_a_of_type_JavaUtilList, 2131560271, arrayOfString, arrayOfInt);
  }
  
  private void a(List<FollowingMember> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FollowingMember localFollowingMember = (FollowingMember)paramList.next();
      HashMap localHashMap = new HashMap();
      String str = localFollowingMember.a().toString();
      localHashMap.put("key_uin", str);
      localHashMap.put("key_name", localFollowingMember.a());
      localHashMap.put("key_head_url", localFollowingMember.b());
      ObservableArrayList localObservableArrayList = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingObservableArrayList;
      if ((localObservableArrayList != null) && (localObservableArrayList.contains(ResultRecord.a(str, localFollowingMember.a())))) {
        localHashMap.put("key_checked", Boolean.valueOf(true));
      }
      this.jdField_a_of_type_JavaUtilList.add(localHashMap);
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingObservableArrayList = paramObservableArrayList;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingObservableArrayList.addOnListChangedCallback(this);
  }
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2) {}
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(SelectMemberLimit paramSelectMemberLimit)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit = paramSelectMemberLimit;
  }
  
  public void b(ObservableArrayList<ResultRecord> paramObservableArrayList) {}
  
  public void b(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    paramObservableArrayList = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberFollowingListFragment$FollowListAdapter;
    if (paramObservableArrayList != null) {
      paramObservableArrayList.notifyDataSetChanged();
    }
  }
  
  public void c(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    paramObservableArrayList = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberFollowingListFragment$FollowListAdapter;
    if (paramObservableArrayList != null) {
      paramObservableArrayList.notifyDataSetChanged();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560270, paramViewGroup, false);
    paramViewGroup = (ListView)paramLayoutInflater.findViewById(2131370167);
    a();
    paramViewGroup.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberFollowingListFragment$FollowListAdapter);
    paramViewGroup.setOnItemClickListener(this);
    paramViewGroup.setSelector(2131167333);
    paramViewGroup.setOverScrollMode(0);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = (CheckBox)paramView.findViewById(2131364613);
    if (((CheckBox)localObject).isEnabled())
    {
      paramAdapterView = Boolean.valueOf(((CheckBox)localObject).isChecked() ^ true);
      ((CheckBox)localObject).setChecked(paramAdapterView.booleanValue());
      localObject = (Map)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      ((Map)localObject).put("key_checked", paramAdapterView);
      localObject = ResultRecord.a((String)((Map)localObject).get("key_uin"), (String)((Map)localObject).get("key_name"), 2);
      if (paramAdapterView.booleanValue()) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingObservableArrayList.add(localObject);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingObservableArrayList.remove(localObject);
      }
    }
    else
    {
      paramAdapterView = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit;
      if ((paramAdapterView != null) && (paramAdapterView.a() == 1))
      {
        paramAdapterView = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingObservableArrayList;
        if ((paramAdapterView != null) && (paramAdapterView.size() >= this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit.b()))
        {
          paramAdapterView = getBaseActivity().getResources().getString(2131718030, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit.c()) });
          QQToast.a(getBaseActivity(), paramAdapterView, 0).a();
          return;
        }
        QQToast.a(getBaseActivity(), getBaseActivity().getResources().getString(2131718024), 0).a();
      }
    }
    paramAdapterView = this.jdField_a_of_type_AndroidViewView$OnClickListener;
    if (paramAdapterView != null) {
      paramAdapterView.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectmember.FollowingListFragment
 * JD-Core Version:    0.7.0.1
 */