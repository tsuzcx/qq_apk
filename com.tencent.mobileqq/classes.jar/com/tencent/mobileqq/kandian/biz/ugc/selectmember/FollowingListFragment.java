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
  private List<HashMap<String, Object>> a = new ArrayList();
  private ObservableArrayList<ResultRecord> b;
  private FollowingListFragment.FollowListAdapter c;
  private SelectMemberLimit d;
  private View.OnClickListener e;
  private ReadInJoyObserver f = new FollowingListFragment.1(this);
  
  private void a()
  {
    a(ReadInJoyLogicEngine.a().X());
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "key_checked";
    arrayOfString[1] = "key_head_url";
    arrayOfString[2] = "key_name";
    int[] arrayOfInt = new int[3];
    int[] tmp35_34 = arrayOfInt;
    tmp35_34[0] = 2131430688;
    int[] tmp40_35 = tmp35_34;
    tmp40_35[1] = 2131435219;
    int[] tmp45_40 = tmp40_35;
    tmp45_40[2] = 2131439121;
    tmp45_40;
    SelectMemberLimit localSelectMemberLimit = this.d;
    if ((localSelectMemberLimit != null) && (localSelectMemberLimit.a() == 1))
    {
      this.c = new FollowingListFragment.ReadInJoyFollowListAQAdapter(this, getBaseActivity(), this.a, 2131626318, arrayOfString, arrayOfInt);
      return;
    }
    this.c = new FollowingListFragment.FollowListAdapter(this, getBaseActivity(), this.a, 2131626318, arrayOfString, arrayOfInt);
  }
  
  private void a(List<FollowingMember> paramList)
  {
    this.a.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FollowingMember localFollowingMember = (FollowingMember)paramList.next();
      HashMap localHashMap = new HashMap();
      String str = localFollowingMember.a().toString();
      localHashMap.put("key_uin", str);
      localHashMap.put("key_name", localFollowingMember.b());
      localHashMap.put("key_head_url", localFollowingMember.c());
      ObservableArrayList localObservableArrayList = this.b;
      if ((localObservableArrayList != null) && (localObservableArrayList.contains(ResultRecord.a(str, localFollowingMember.b())))) {
        localHashMap.put("key_checked", Boolean.valueOf(true));
      }
      this.a.add(localHashMap);
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.e = paramOnClickListener;
  }
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList)
  {
    this.b = paramObservableArrayList;
    this.b.addOnListChangedCallback(this);
  }
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2) {}
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(SelectMemberLimit paramSelectMemberLimit)
  {
    this.d = paramSelectMemberLimit;
  }
  
  public void b(ObservableArrayList<ResultRecord> paramObservableArrayList) {}
  
  public void b(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    paramObservableArrayList = this.c;
    if (paramObservableArrayList != null) {
      paramObservableArrayList.notifyDataSetChanged();
    }
  }
  
  public void c(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    paramObservableArrayList = this.c;
    if (paramObservableArrayList != null) {
      paramObservableArrayList.notifyDataSetChanged();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131626317, paramViewGroup, false);
    paramViewGroup = (ListView)paramLayoutInflater.findViewById(2131437333);
    a();
    paramViewGroup.setAdapter(this.c);
    paramViewGroup.setOnItemClickListener(this);
    paramViewGroup.setSelector(2131168376);
    paramViewGroup.setOverScrollMode(0);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.f);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.f);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = (CheckBox)paramView.findViewById(2131430688);
    if (((CheckBox)localObject).isEnabled())
    {
      paramAdapterView = Boolean.valueOf(((CheckBox)localObject).isChecked() ^ true);
      ((CheckBox)localObject).setChecked(paramAdapterView.booleanValue());
      localObject = (Map)this.a.get(paramInt);
      ((Map)localObject).put("key_checked", paramAdapterView);
      localObject = ResultRecord.a((String)((Map)localObject).get("key_uin"), (String)((Map)localObject).get("key_name"), 2);
      if (paramAdapterView.booleanValue()) {
        this.b.add(localObject);
      } else {
        this.b.remove(localObject);
      }
    }
    else
    {
      paramAdapterView = this.d;
      if ((paramAdapterView != null) && (paramAdapterView.a() == 1))
      {
        paramAdapterView = this.b;
        if ((paramAdapterView != null) && (paramAdapterView.size() >= this.d.b()))
        {
          paramAdapterView = getBaseActivity().getResources().getString(2131915511, new Object[] { String.valueOf(this.d.d()) });
          QQToast.makeText(getBaseActivity(), paramAdapterView, 0).show();
          return;
        }
        QQToast.makeText(getBaseActivity(), getBaseActivity().getResources().getString(2131915505), 0).show();
      }
    }
    paramAdapterView = this.e;
    if (paramAdapterView != null) {
      paramAdapterView.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectmember.FollowingListFragment
 * JD-Core Version:    0.7.0.1
 */