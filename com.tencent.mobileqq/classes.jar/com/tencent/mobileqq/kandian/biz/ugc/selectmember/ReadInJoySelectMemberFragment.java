package com.tencent.mobileqq.kandian.biz.ugc.selectmember;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.kandian.biz.ugc.constant.IReadInJoySelectMemberFragmentConst;
import com.tencent.mobileqq.kandian.biz.ugc.databinding.ObservableArrayList;
import com.tencent.mobileqq.kandian.biz.ugc.databinding.ObservableList.OnListChangedCallback;
import com.tencent.mobileqq.kandian.biz.ugc.selectmember.search.FollowingSearchResultModel;
import com.tencent.mobileqq.kandian.biz.ugc.selectmember.search.HybridSearchFragment;
import com.tencent.mobileqq.kandian.biz.ugc.selectmember.search.HybridSearchFragment.OnSearchResultClickListener;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.kandian.repo.ugc.ResultRecord;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ReadInJoySelectMemberFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, IReadInJoySelectMemberFragmentConst, ObservableList.OnListChangedCallback<ObservableArrayList<ResultRecord>>, HybridSearchFragment.OnSearchResultClickListener
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ReadInJoySelectMemberFragment.4(this);
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  protected ObservableArrayList<ResultRecord> a;
  private FollowingListFragment jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberFollowingListFragment;
  private FriendListFragment jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberFriendListFragment;
  protected SelectMemberLimit a;
  private SelectedMemberListViewAdapter jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectedMemberListViewAdapter;
  private HybridSearchFragment jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSearchHybridSearchFragment;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  
  public ReadInJoySelectMemberFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingObservableArrayList = new ObservableArrayList();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit = new SelectMemberLimit();
  }
  
  private static List<String> a(@NonNull ObservableArrayList<ResultRecord> paramObservableArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramObservableArrayList = paramObservableArrayList.iterator();
    while (paramObservableArrayList.hasNext()) {
      localArrayList.add(((ResultRecord)paramObservableArrayList.next()).a());
    }
    return localArrayList;
  }
  
  private void a()
  {
    ReadInJoyLogicEngine.a().q();
  }
  
  private void a(Bundle paramBundle)
  {
    if (this.mContentView.findViewById(2131367213) != null)
    {
      if (paramBundle != null) {
        return;
      }
      g();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberFriendListFragment = new FriendListFragment();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberFriendListFragment.b(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberFriendListFragment.a(this);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberFriendListFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingObservableArrayList);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberFriendListFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberFollowingListFragment = new FollowingListFragment();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberFollowingListFragment.a(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberFollowingListFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingObservableArrayList);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberFollowingListFragment.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit);
      getChildFragmentManager().beginTransaction().add(2131367213, this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberFriendListFragment).commit();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingObservableArrayList.addOnListChangedCallback(this);
    j();
  }
  
  private void f()
  {
    h();
    d();
  }
  
  private void g()
  {
    Object localObject = getArguments();
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit.a(((Bundle)localObject).getInt("opentype", 0));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit.b(((Bundle)localObject).getInt("maxSelect", 10));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit.c(((Bundle)localObject).getInt("maxCount", 30));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit.b(((Bundle)localObject).getString("rowkey", ""));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit.a(((Bundle)localObject).getString("callback", ""));
      if (((Bundle)localObject).containsKey("filterUins"))
      {
        localObject = ((Bundle)localObject).getString("filterUins", "");
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).length() > 0)) {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit.a(Arrays.asList(((String)localObject).split(",")));
        }
      }
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSearchHybridSearchFragment = HybridSearchFragment.a();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSearchHybridSearchFragment.a(this);
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131377017);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.mContentView.findViewById(2131377068));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(new ReadInJoySelectMemberFragment.1(this));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new ReadInJoySelectMemberFragment.2(this));
  }
  
  private void i()
  {
    TextView localTextView = (TextView)getRightTextView();
    int j = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingObservableArrayList.size();
    int i;
    if (j > 4) {
      i = 1;
    } else {
      i = 0;
    }
    if (j > 0)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      setRightViewTextDisable(1);
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit.a() == 1) {
        localTextView.setText(MessageFormat.format(getString(2131718028), new Object[] { Integer.valueOf(j) }));
      } else {
        localTextView.setText(MessageFormat.format(getString(2131718714), new Object[] { Integer.valueOf(j) }));
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit.a() == 1) {
        localTextView.setText(2131718025);
      } else {
        localTextView.setText(2131718713);
      }
      setRightViewTextDisable(0);
    }
    if (i != 0)
    {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLayoutParams().width = AIOUtils.b(200.0F, getResources());
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.requestLayout();
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.smoothScrollToPosition(j - 1);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLayoutParams().width = -2;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.requestLayout();
  }
  
  private void j()
  {
    Resources localResources = getResources();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit.a() == 1)
    {
      setTitle(localResources.getString(2131718023));
      setRightButton(2131718025, this);
    }
    else
    {
      setTitle(localResources.getString(2131718701));
      setRightButton(2131718713, this);
    }
    setRightViewTextDisable(0);
  }
  
  private void k()
  {
    if (getChildFragmentManager().getBackStackEntryCount() > 0) {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    }
  }
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList) {}
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2) {}
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(ISearchResultModel paramISearchResultModel)
  {
    ResultRecord localResultRecord = ResultRecord.a(paramISearchResultModel.a(), paramISearchResultModel.b().toString());
    if ((paramISearchResultModel instanceof FollowingSearchResultModel)) {
      localResultRecord.a(2);
    } else {
      localResultRecord.a(1);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingObservableArrayList.contains(localResultRecord))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit.a() == 1) && (!TextUtils.isEmpty(paramISearchResultModel.a())) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit.a() != null))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingObservableArrayList.size() >= this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit.b())
        {
          paramISearchResultModel = getBaseActivity().getResources().getString(2131718030, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit.c()) });
          QQToast.a(getBaseActivity(), paramISearchResultModel, 0).a();
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit.a().contains(paramISearchResultModel.a()))
        {
          QQToast.a(getBaseActivity(), getBaseActivity().getResources().getString(2131718024), 0).a();
          return;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingObservableArrayList.add(localResultRecord);
      k();
    }
  }
  
  protected void b()
  {
    c();
    if (getBaseActivity() != null) {
      getBaseActivity().finish();
    }
  }
  
  public void b(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSearchHybridSearchFragment.b_(a(paramObservableArrayList));
    if (paramObservableArrayList.size() > this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit.b())
    {
      String str = String.format(getString(2131694673), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit.b()) });
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit.a() == 1) {
        str = getString(2131718030, new Object[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectMemberLimit.c()) });
      }
      paramObservableArrayList.subList(paramInt1, paramInt2 + paramInt1).clear();
      QQToast.a(getBaseActivity(), str, 0).a();
      return;
    }
    i();
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingObservableArrayList.size() > 0)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("result_set", this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingObservableArrayList);
      getBaseActivity().setResult(-1, localIntent);
    }
  }
  
  public void c(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSearchHybridSearchFragment.b_(a(paramObservableArrayList));
    i();
  }
  
  protected void d()
  {
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.mContentView.findViewById(2131377180));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectedMemberListViewAdapter = new SelectedMemberListViewAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcDatabindingObservableArrayList);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberSelectedMemberListViewAdapter);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(new ReadInJoySelectMemberFragment.3(this));
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (this.mContentView == null)
    {
      QLog.e("IphoneTitleBarFragment", 1, "mContentView == null");
      return;
    }
    f();
    a(paramBundle);
    a();
    RIJDtReportHelper.a.a(getBaseActivity());
  }
  
  public void e()
  {
    if ((getBaseActivity() != null) && (this.jdField_a_of_type_AndroidWidgetEditText != null)) {
      try
      {
        InputMethodManager localInputMethodManager = (InputMethodManager)getBaseActivity().getSystemService("input_method");
        if (localInputMethodManager.isActive())
        {
          localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 2);
          this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131560272;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    paramActivity.overridePendingTransition(2130772011, 2130772004);
  }
  
  public boolean onBackEvent()
  {
    if (getChildFragmentManager().getBackStackEntryCount() > 0)
    {
      e();
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      return true;
    }
    c();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131364051)
    {
      if (i != 2131369233) {
        return;
      }
      b();
      return;
    }
    e();
    getChildFragmentManager().beginTransaction().setCustomAnimations(2130772078, 2130772079, 2130772072, 2130772073).hide(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberFriendListFragment).add(2131367213, this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcSelectmemberFollowingListFragment).addToBackStack(FollowingListFragment.class.getName()).commit();
  }
  
  public void onFinish()
  {
    super.onFinish();
    getBaseActivity().overridePendingTransition(2130772004, 2130771992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectmember.ReadInJoySelectMemberFragment
 * JD-Core Version:    0.7.0.1
 */