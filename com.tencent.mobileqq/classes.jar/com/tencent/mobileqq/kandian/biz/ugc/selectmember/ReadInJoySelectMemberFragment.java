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
  private SelectedMemberListViewAdapter a;
  private HybridSearchFragment b;
  private FollowingListFragment c;
  protected ObservableArrayList<ResultRecord> d = new ObservableArrayList();
  protected SelectMemberLimit e = new SelectMemberLimit();
  private View f;
  private EditText g;
  private FriendListFragment h;
  private HorizontalListView i;
  private View.OnClickListener j = new ReadInJoySelectMemberFragment.4(this);
  
  private void a()
  {
    ReadInJoyLogicEngine.a().V();
  }
  
  private void a(Bundle paramBundle)
  {
    if (this.mContentView.findViewById(2131433669) != null)
    {
      if (paramBundle != null) {
        return;
      }
      g();
      this.h = new FriendListFragment();
      this.h.b(this.j);
      this.h.a(this);
      this.h.a(this.d);
      this.h.a(this.e);
      this.c = new FollowingListFragment();
      this.c.a(this.j);
      this.c.a(this.d);
      this.c.a(this.e);
      getChildFragmentManager().beginTransaction().add(2131433669, this.h).commit();
    }
    this.d.addOnListChangedCallback(this);
    j();
  }
  
  private static List<String> b(@NonNull ObservableArrayList<ResultRecord> paramObservableArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramObservableArrayList = paramObservableArrayList.iterator();
    while (paramObservableArrayList.hasNext()) {
      localArrayList.add(((ResultRecord)paramObservableArrayList.next()).a());
    }
    return localArrayList;
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
      this.e.a(((Bundle)localObject).getInt("opentype", 0));
      this.e.b(((Bundle)localObject).getInt("maxSelect", 10));
      this.e.c(((Bundle)localObject).getInt("maxCount", 30));
      this.e.b(((Bundle)localObject).getString("rowkey", ""));
      this.e.a(((Bundle)localObject).getString("callback", ""));
      if (((Bundle)localObject).containsKey("filterUins"))
      {
        localObject = ((Bundle)localObject).getString("filterUins", "");
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).length() > 0)) {
          this.e.a(Arrays.asList(((String)localObject).split(",")));
        }
      }
    }
  }
  
  private void h()
  {
    this.b = HybridSearchFragment.f();
    this.b.a(this);
    this.f = this.mContentView.findViewById(2131445381);
    this.g = ((EditText)this.mContentView.findViewById(2131445437));
    this.g.setOnKeyListener(new ReadInJoySelectMemberFragment.1(this));
    this.g.addTextChangedListener(new ReadInJoySelectMemberFragment.2(this));
  }
  
  private void i()
  {
    TextView localTextView = (TextView)getRightTextView();
    int m = this.d.size();
    int k;
    if (m > 4) {
      k = 1;
    } else {
      k = 0;
    }
    if (m > 0)
    {
      this.f.setVisibility(8);
      setRightViewTextDisable(1);
      if (this.e.a() == 1) {
        localTextView.setText(MessageFormat.format(getString(2131915509), new Object[] { Integer.valueOf(m) }));
      } else {
        localTextView.setText(MessageFormat.format(getString(2131916216), new Object[] { Integer.valueOf(m) }));
      }
    }
    else
    {
      this.f.setVisibility(0);
      if (this.e.a() == 1) {
        localTextView.setText(2131915506);
      } else {
        localTextView.setText(2131916215);
      }
      setRightViewTextDisable(0);
    }
    if (k != 0)
    {
      this.i.getLayoutParams().width = AIOUtils.b(200.0F, getResources());
      this.i.requestLayout();
      this.i.smoothScrollToPosition(m - 1);
      return;
    }
    this.i.getLayoutParams().width = -2;
    this.i.requestLayout();
  }
  
  private void j()
  {
    Resources localResources = getResources();
    if (this.e.a() == 1)
    {
      setTitle(localResources.getString(2131915504));
      setRightButton(2131915506, this);
    }
    else
    {
      setTitle(localResources.getString(2131916202));
      setRightButton(2131916215, this);
    }
    setRightViewTextDisable(0);
  }
  
  private void k()
  {
    if (getChildFragmentManager().getBackStackEntryCount() > 0) {
      this.g.setText("");
    }
  }
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList) {}
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2) {}
  
  public void a(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(ISearchResultModel paramISearchResultModel)
  {
    ResultRecord localResultRecord = ResultRecord.a(paramISearchResultModel.c(), paramISearchResultModel.d().toString());
    if ((paramISearchResultModel instanceof FollowingSearchResultModel)) {
      localResultRecord.a(2);
    } else {
      localResultRecord.a(1);
    }
    if (!this.d.contains(localResultRecord))
    {
      if ((this.e.a() == 1) && (!TextUtils.isEmpty(paramISearchResultModel.c())) && (this.e.c() != null))
      {
        if (this.d.size() >= this.e.b())
        {
          paramISearchResultModel = getBaseActivity().getResources().getString(2131915511, new Object[] { String.valueOf(this.e.d()) });
          QQToast.makeText(getBaseActivity(), paramISearchResultModel, 0).show();
          return;
        }
        if (this.e.c().contains(paramISearchResultModel.c()))
        {
          QQToast.makeText(getBaseActivity(), getBaseActivity().getResources().getString(2131915505), 0).show();
          return;
        }
      }
      this.d.add(localResultRecord);
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
    this.b.b_(b(paramObservableArrayList));
    if (paramObservableArrayList.size() > this.e.b())
    {
      String str = String.format(getString(2131892365), new Object[] { Integer.valueOf(this.e.b()) });
      if (this.e.a() == 1) {
        str = getString(2131915511, new Object[] { String.valueOf(this.e.d()) });
      }
      paramObservableArrayList.subList(paramInt1, paramInt2 + paramInt1).clear();
      QQToast.makeText(getBaseActivity(), str, 0).show();
      return;
    }
    i();
  }
  
  protected void c()
  {
    if (this.d.size() > 0)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("result_set", this.d);
      getBaseActivity().setResult(-1, localIntent);
    }
  }
  
  public void c(ObservableArrayList<ResultRecord> paramObservableArrayList, int paramInt1, int paramInt2)
  {
    this.b.b_(b(paramObservableArrayList));
    i();
  }
  
  protected void d()
  {
    this.i = ((HorizontalListView)this.mContentView.findViewById(2131445558));
    this.a = new SelectedMemberListViewAdapter(this.d);
    this.i.setAdapter(this.a);
    this.i.setOverScrollMode(2);
    this.i.setOnItemClickListener(new ReadInJoySelectMemberFragment.3(this));
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
    if ((getBaseActivity() != null) && (this.g != null)) {
      try
      {
        InputMethodManager localInputMethodManager = (InputMethodManager)getBaseActivity().getSystemService("input_method");
        if (localInputMethodManager.isActive())
        {
          localInputMethodManager.hideSoftInputFromWindow(this.g.getWindowToken(), 2);
          this.g.clearFocus();
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
    return 2131626319;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    paramActivity.overridePendingTransition(2130772014, 2130772007);
  }
  
  public boolean onBackEvent()
  {
    if (getChildFragmentManager().getBackStackEntryCount() > 0)
    {
      e();
      this.g.setText("");
      this.g.clearFocus();
      return true;
    }
    c();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int k = paramView.getId();
    if (k != 2131430009)
    {
      if (k != 2131436211) {
        return;
      }
      b();
      return;
    }
    e();
    getChildFragmentManager().beginTransaction().setCustomAnimations(2130772108, 2130772109, 2130772102, 2130772103).hide(this.h).add(2131433669, this.c).addToBackStack(FollowingListFragment.class.getName()).commit();
  }
  
  public void onFinish()
  {
    super.onFinish();
    getBaseActivity().overridePendingTransition(2130772007, 2130771995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectmember.ReadInJoySelectMemberFragment
 * JD-Core Version:    0.7.0.1
 */