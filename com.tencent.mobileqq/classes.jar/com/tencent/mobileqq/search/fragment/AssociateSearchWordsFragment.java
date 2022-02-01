package com.tencent.mobileqq.search.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.search.base.api.SearchInfoInterface;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.XListView;
import java.util.List;

public class AssociateSearchWordsFragment
  extends BaseFragment
{
  XListView a;
  boolean b = false;
  protected boolean c = false;
  protected String d;
  View.OnClickListener e = new AssociateSearchWordsFragment.1(this);
  public View.OnTouchListener f = new AssociateSearchWordsFragment.2(this);
  private List<AssociateSearchWordsFragment.AssociateItem> g;
  private AssociateSearchWordsFragment.AssociateWordClickCallback h;
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public void a(List<AssociateSearchWordsFragment.AssociateItem> paramList)
  {
    if (!this.b)
    {
      this.g = paramList;
      return;
    }
    b(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void b(List<AssociateSearchWordsFragment.AssociateItem> paramList)
  {
    if (this.a.getAdapter() == null)
    {
      AssociateSearchWordsFragment.SearchAssociatedWordAdapter localSearchAssociatedWordAdapter = new AssociateSearchWordsFragment.SearchAssociatedWordAdapter(this, paramList);
      this.a.setAdapter(localSearchAssociatedWordAdapter);
      localSearchAssociatedWordAdapter.a(paramList);
    }
    else
    {
      ((AssociateSearchWordsFragment.SearchAssociatedWordAdapter)this.a.getAdapter()).a(paramList);
    }
    paramList = getBaseActivity();
    if ((paramList instanceof SearchInfoInterface)) {
      SearchUtils.a("sub_result", "exp_auto", new String[] { ((SearchInfoInterface)paramList).h(), "", "", "" });
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131625837, null);
    this.a = ((XListView)paramLayoutInflater.findViewById(2131445436));
    this.a.setDivider(null);
    this.a.setOnTouchListener(this.f);
    this.b = true;
    paramViewGroup = this.g;
    if (paramViewGroup != null)
    {
      b(paramViewGroup);
      this.g = null;
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment
 * JD-Core Version:    0.7.0.1
 */