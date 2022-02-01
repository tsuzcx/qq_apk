package com.tencent.mobileqq.filemanager.data.search.selector;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.search.ISearchViewBinder;
import com.tencent.mobileqq.filemanager.widget.QFileCustomBottomBarManager;
import com.tencent.mobileqq.filemanager.widget.QFileSendBottomView;
import com.tencent.mobileqq.search.base.adapter.BaseMvpAdapter;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

public class FileSelectorSearchFragment
  extends BaseSearchFragment<ISearchResultModel>
  implements ISearchViewBinder
{
  private int a;
  private Bundle b;
  private FileSelectorSearchEngine c;
  private FileSelectorSearchFragment.FileSelectorSearchAdapter d;
  private QFileCustomBottomBarManager e;
  
  public String a()
  {
    return this.q;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(Bundle paramBundle)
  {
    this.b = paramBundle;
  }
  
  protected BaseMvpAdapter b()
  {
    this.d = new FileSelectorSearchFragment.FileSelectorSearchAdapter(this);
    return this.d;
  }
  
  protected ISearchEngine c()
  {
    this.c = new FileSelectorSearchEngine((QQAppInterface)this.p, getQBaseActivity(), this.a);
    this.c.a(this.b);
    return this.c;
  }
  
  protected String d()
  {
    int i = this.a;
    if (i == 16) {
      return getQBaseActivity().getString(2131889293);
    }
    if (i == 17) {
      return getQBaseActivity().getString(2131889279);
    }
    if (i == 18) {
      return getQBaseActivity().getString(2131889251);
    }
    if (i == 19) {
      return getQBaseActivity().getString(2131889362);
    }
    return "";
  }
  
  protected String e()
  {
    return HardCodeUtil.a(2131899282);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.k.findViewById(2131434940).setVisibility(8);
    paramViewGroup = (RelativeLayout)this.k.findViewById(2131444724);
    paramBundle = new QFileSendBottomView(paramLayoutInflater.getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(12);
    paramViewGroup.addView(paramBundle, localLayoutParams);
    paramBundle.a(this.l);
    this.e = QFileCustomBottomBarManager.a((QQAppInterface)getQBaseActivity().getAppRuntime(), getQBaseActivity(), paramBundle, this.b);
    this.e.a(this.b);
    this.e.b();
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onResume()
  {
    super.onResume();
    QFileCustomBottomBarManager localQFileCustomBottomBarManager = this.e;
    if (localQFileCustomBottomBarManager != null) {
      localQFileCustomBottomBarManager.a();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.e.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchFragment
 * JD-Core Version:    0.7.0.1
 */