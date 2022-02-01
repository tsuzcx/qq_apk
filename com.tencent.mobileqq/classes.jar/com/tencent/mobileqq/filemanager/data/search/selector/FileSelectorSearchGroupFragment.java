package com.tencent.mobileqq.filemanager.data.search.selector;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.widget.QFileCustomBottomBarManager;
import com.tencent.mobileqq.filemanager.widget.QFileSendBottomView;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.widget.ListView;

public class FileSelectorSearchGroupFragment
  extends IphoneTitleBarFragment
{
  private static FileSelectorSearchResultModel d;
  private Bundle a;
  private ListView b;
  private View c;
  private FileSelectorSearchGroupFragment.FileSelectorSearchAdapter e;
  private QFileCustomBottomBarManager f;
  
  private String a()
  {
    if (d != null) {
      return String.format(getString(2131889436), new Object[] { Integer.valueOf(d.i()), d.g() });
    }
    return "";
  }
  
  public static void a(FileSelectorSearchResultModel paramFileSelectorSearchResultModel)
  {
    d = paramFileSelectorSearchResultModel;
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = (RelativeLayout)this.mContentView;
    this.b = ((ListView)paramLayoutInflater.findViewById(2131437272));
    this.b.setOnTouchListener(new FileSelectorSearchGroupFragment.1(this));
    this.c = paramLayoutInflater.findViewById(2131434975);
    paramViewGroup = new QFileSendBottomView(paramLayoutInflater.getContext());
    paramBundle = new RelativeLayout.LayoutParams(-1, -2);
    paramBundle.addRule(12);
    paramLayoutInflater.addView(paramViewGroup, paramBundle);
    this.a = getArguments().getBundle("qfile_search_param_ex_params");
    this.f = QFileCustomBottomBarManager.a(getBaseActivity().app, getBaseActivity(), paramViewGroup, this.a);
    this.f.a(this.a);
    this.f.b();
    this.f.a(this.a);
    paramViewGroup.a(this.b);
  }
  
  protected int getContentLayoutId()
  {
    return 2131627081;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    d = null;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    setTitle(d.k());
    super.onViewCreated(paramView, paramBundle);
    ((TextView)this.c.findViewById(2131434940)).setText(a());
    this.e = new FileSelectorSearchGroupFragment.FileSelectorSearchAdapter(this, d);
    this.b.setAdapter(this.e);
    this.f.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchGroupFragment
 * JD-Core Version:    0.7.0.1
 */