package com.tencent.mobileqq.search.base.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.IFTSFetcher;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.base.util.SearchStatisticsConstants;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.MobileQQ;

public abstract class BaseSearchActivity
  extends QBaseActivity
  implements TextWatcher, TextView.OnEditorActionListener
{
  public static int l = -1;
  protected String c;
  protected QuickPinyinEditText d;
  protected Button e;
  protected ImageButton f;
  protected ImageView g;
  protected BaseSearchFragment h;
  protected BaseSearchActivity.CancelReceiver i;
  public int j;
  protected boolean k = false;
  public String m = null;
  public String n = null;
  public boolean o = false;
  public int p;
  
  private void b()
  {
    this.d = ((QuickPinyinEditText)super.findViewById(2131432634));
    this.d.setHint(d());
    this.d.setImeOptions(3);
    this.d.setOnEditorActionListener(this);
    this.d.addTextChangedListener(this);
    if ("1".equals(((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.search_input_type.name(), "0"))) {
      this.d.setInputType(524321);
    } else {
      this.d.setInputType(524289);
    }
    if (this.k) {
      this.d.getInputExtras(true).putInt("QUICK_SEARCH", 1);
    }
    this.f = ((ImageButton)super.findViewById(2131435215));
    this.f.setOnClickListener(new BaseSearchActivity.2(this));
    this.e = ((Button)super.findViewById(2131429816));
    this.e.setVisibility(0);
    this.e.setText(2131887648);
    this.e.setOnClickListener(new BaseSearchActivity.3(this));
    this.g = ((ImageView)super.findViewById(2131436275));
    this.g.setVisibility(0);
    this.g.setOnClickListener(new BaseSearchActivity.4(this));
  }
  
  protected void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cancelType-3 ResultModule:");
      localStringBuilder.append(SearchStatisticsConstants.a());
      QLog.d("searchUtils", 2, localStringBuilder.toString());
    }
    ReportController.b(null, "CliOper", "", "", "0X8005E13", "0X8005E13", 0, 0, "3", "", SearchStatisticsConstants.a(), "");
    a(this, new Intent("com.tencent.mobileqq.search.cancel"));
    l = 0;
    finish();
  }
  
  protected void a(String paramString)
  {
    String str = this.c;
    if ((str != null) && (str.equals(paramString))) {
      return;
    }
    this.c = paramString;
    this.h.a(paramString);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.d.getText().toString();
    if (TextUtils.isEmpty(paramEditable)) {
      this.f.setVisibility(8);
    } else {
      this.f.setVisibility(0);
    }
    paramEditable = paramEditable.trim();
    if (!paramEditable.equals(this.c)) {
      com.tencent.mobileqq.search.util.SearchUtils.e = 0L;
    }
    a(paramEditable);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected abstract BaseSearchFragment c();
  
  protected String d()
  {
    return HardCodeUtil.a(2131899288);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  @TargetApi(14)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    l = -1;
    super.doOnCreate(paramBundle);
    super.setContentView(e());
    paramBundle = super.findViewById(2131445137);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      paramBundle.setFitsSystemWindows(true);
    }
    this.j = super.getIntent().getIntExtra("extra_key_fts_type", 0);
    b();
    this.c = super.getIntent().getStringExtra("keyword");
    paramBundle = super.getSupportFragmentManager();
    this.h = c();
    paramBundle = paramBundle.beginTransaction();
    paramBundle.replace(2131445417, this.h);
    paramBundle.commit();
    if (!TextUtils.isEmpty(this.c))
    {
      this.d.setText(this.c);
      this.d.setSelection(this.c.length());
      this.h.a(this.c);
      f();
    }
    else
    {
      ThreadManager.getUIHandlerV2().postDelayed(new BaseSearchActivity.1(this), 500L);
    }
    this.i = new BaseSearchActivity.CancelReceiver(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.search.cancel");
    super.registerReceiver(this.i, paramBundle);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    try
    {
      if (this.i != null)
      {
        super.unregisterReceiver(this.i);
        this.i = null;
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    try
    {
      this.d.setFocusable(false);
      this.d.setFocusableInTouchMode(false);
      this.d.setVisibility(8);
      if (this.d.getParent() != null) {
        ((ViewGroup)this.d.getParent()).removeView(this.d);
      }
      this.d.removeTextChangedListener(this);
      this.d.setOnEditorActionListener(null);
    }
    catch (Error localError)
    {
      localError.printStackTrace();
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
    com.tencent.mobileqq.search.util.SearchUtils.i = null;
    l = -1;
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
    ((IFTSFetcher)QRoute.api(IFTSFetcher.class)).setIntoFTSMessagePage(false);
  }
  
  protected int e()
  {
    return 2131627777;
  }
  
  protected void f()
  {
    this.d.clearFocus();
    ((InputMethodManager)MobileQQ.sMobileQQ.getSystemService("input_method")).hideSoftInputFromWindow(this.d.getWindowToken(), 0);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    if ((paramInt != 3) && ((paramKeyEvent == null) || (paramKeyEvent.getKeyCode() != 66)))
    {
      bool = false;
    }
    else
    {
      String str = this.d.getText().toString().trim();
      if (!TextUtils.isEmpty(str)) {
        a(str);
      }
      f();
      bool = true;
    }
    EventCollector.getInstance().onEditorAction(paramTextView, paramInt, paramKeyEvent);
    return bool;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.activity.BaseSearchActivity
 * JD-Core Version:    0.7.0.1
 */