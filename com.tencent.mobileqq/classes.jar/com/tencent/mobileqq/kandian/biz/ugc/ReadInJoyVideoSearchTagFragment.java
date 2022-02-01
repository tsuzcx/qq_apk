package com.tencent.mobileqq.kandian.biz.ugc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtReportHelper;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.handler.TagInfo;
import java.util.ArrayList;

public class ReadInJoyVideoSearchTagFragment
  extends QPublicBaseFragment
{
  ReadInJoyObserver a = new ReadInJoyVideoSearchTagFragment.1(this);
  private EditText b;
  private ArrayAdapter<TagInfo> c;
  private TextWatcher d = new ReadInJoyVideoSearchTagFragment.2(this);
  
  private void a()
  {
    getView().setOnClickListener(new ReadInJoyVideoSearchTagFragment.3(this));
  }
  
  private void b()
  {
    getView().findViewById(2131430135).setOnClickListener(new ReadInJoyVideoSearchTagFragment.4(this));
  }
  
  private void c()
  {
    ListView localListView = (ListView)getView().findViewById(2131437339);
    View localView = new View(getQBaseActivity());
    localView.setBackgroundColor(Color.argb(102, 0, 0, 0));
    localListView.setEmptyView(localView);
    this.c = new ArrayAdapter(getQBaseActivity(), 2131626351, new ArrayList());
    localListView.setAdapter(this.c);
    localListView.setOnItemClickListener(new ReadInJoyVideoSearchTagFragment.5(this, getQBaseActivity().getIntent().getBooleanExtra("EXTRA_SELECTION_REACH_MAXIMUM_NUMBER", false)));
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void d()
  {
    this.b = ((EditText)getView().findViewById(2131446823));
    this.b.setOnTouchListener(new ReadInJoyVideoSearchTagFragment.6(this));
    this.b.addTextChangedListener(this.d);
    this.b.requestFocus();
  }
  
  private void e()
  {
    this.b.setText("");
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    paramActivity.getWindow().requestFeature(1);
    paramActivity.getWindow().setSoftInputMode(4);
    paramActivity.overridePendingTransition(2130772090, 0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    RIJDtReportHelper.a.a(getQBaseActivity());
    return paramLayoutInflater.inflate(2131626350, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.a);
  }
  
  public void onFinish()
  {
    getQBaseActivity().overridePendingTransition(0, 2130772092);
    super.onFinish();
  }
  
  public void onResume()
  {
    super.onResume();
    Utils.a(this);
    d();
    c();
    b();
    a();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyVideoSearchTagFragment
 * JD-Core Version:    0.7.0.1
 */