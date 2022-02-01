package com.tencent.mobileqq.ocr.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.ocr.OCRObserver;
import com.tencent.mobileqq.ocr.api.IOCRService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqperf.opt.threadpriority.ThreadPriorityManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class OCRTextSearchActivity
  extends QBaseActivity
  implements View.OnClickListener
{
  OCRTextSearchActivity.MyFlingGestureHandler a;
  RelativeLayout b;
  EditText c;
  ImageButton d;
  ImageView e;
  View f;
  LinearLayout g;
  RelativeLayout h;
  View i;
  FragmentManager j;
  SearchResultFragment k = null;
  String l;
  String m;
  String n;
  OCRObserver o = new OCRTextSearchActivity.1(this);
  InputMethodManager p = null;
  public BaseOCRTextSearchFragment.SearchActivityInterface q = new OCRTextSearchActivity.3(this);
  private OCRTextSearchActivity.SearchTextWatcher r = new OCRTextSearchActivity.SearchTextWatcher(this, null);
  private int s = 0;
  
  public static void a(QBaseActivity paramQBaseActivity, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Intent localIntent = new Intent(paramQBaseActivity, OCRTextSearchActivity.class);
    localIntent.putExtra("keyWord", paramString);
    paramQBaseActivity.startActivity(localIntent);
    paramQBaseActivity.overridePendingTransition(0, 0);
    ThreadPriorityManager.a(false);
  }
  
  private void c()
  {
    if (this.c.getText() != null) {
      str1 = this.c.getText().toString();
    } else {
      str1 = "";
    }
    String str2 = str1;
    if (TextUtils.isEmpty(str1)) {
      str2 = this.c.getHint().toString();
    }
    String str1 = str2.trim();
    if (TextUtils.isEmpty(str1)) {
      return;
    }
    this.l = null;
    c(str1);
    a(true);
    ReportController.b(null, "dc00898", "", "", "0X80082EE", "0X80082EE", 0, 0, "", "", "", "");
  }
  
  protected void a()
  {
    this.c.addTextChangedListener(this.r);
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localAppRuntime instanceof AppInterface)) {
      ((AppInterface)localAppRuntime).addObserver(this.o);
    }
  }
  
  protected void a(int paramInt)
  {
    if (isFinishing()) {
      return;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      c(1);
      this.s = 1;
      return;
    }
    d(1);
    this.s = 0;
    SearchResultFragment localSearchResultFragment = this.k;
    if (localSearchResultFragment != null) {
      localSearchResultFragment.a();
    }
  }
  
  protected void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.d.setVisibility(0);
    this.c.removeTextChangedListener(this.r);
    this.c.setText(paramString);
    paramString = this.c;
    paramString.setSelection(paramString.getText().length());
    this.c.addTextChangedListener(this.r);
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.c.clearFocus();
      this.c.setCursorVisible(false);
      a(0);
      this.g.setVisibility(0);
      this.d.setEnabled(false);
      this.c.setEnabled(false);
      return;
    }
    this.g.setVisibility(8);
    this.d.setEnabled(true);
    this.c.setEnabled(true);
  }
  
  @TargetApi(14)
  protected void b()
  {
    this.h = ((RelativeLayout)super.findViewById(2131445159));
    this.h.setOnClickListener(this);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      this.h.setFitsSystemWindows(true);
    }
    this.b = ((RelativeLayout)super.findViewById(2131445390));
    this.c = ((EditText)this.b.findViewById(2131432634));
    this.c.setHintTextColor(-1431918938);
    this.c.setEllipsize(TextUtils.TruncateAt.END);
    this.d = ((ImageButton)this.b.findViewById(2131435215));
    AccessibilityUtil.a(this.c, getString(2131888115));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
    localLayoutParams.width = ((int)DisplayUtils.a(this, 22.0F));
    localLayoutParams.height = ((int)DisplayUtils.a(this, 22.0F));
    this.d.setLayoutParams(localLayoutParams);
    ((Button)this.b.findViewById(2131429816)).setVisibility(8);
    this.e = ((ImageView)this.b.findViewById(2131436275));
    this.e.setVisibility(0);
    this.g = ((LinearLayout)super.findViewById(2131445448));
    this.f = super.findViewById(2131444724);
    if (this.p == null) {
      this.p = ((InputMethodManager)super.getSystemService("input_method"));
    }
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.c.setImeOptions(3);
    this.c.setSingleLine(true);
    this.c.setOnEditorActionListener(new OCRTextSearchActivity.2(this));
    this.c.setOnClickListener(this);
    this.i = findViewById(2131437976);
    if ("1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"))) {
      this.i.setVisibility(0);
    }
  }
  
  void b(int paramInt)
  {
    if (paramInt != 1) {
      return;
    }
    if (this.k == null)
    {
      this.k = new SearchResultFragment();
      FragmentTransaction localFragmentTransaction = this.j.beginTransaction();
      localFragmentTransaction.add(2131444724, this.k, "search_result");
      localFragmentTransaction.commitAllowingStateLoss();
    }
  }
  
  protected void b(String paramString)
  {
    if (paramString.equals(""))
    {
      this.d.setVisibility(8);
      return;
    }
    this.d.setVisibility(0);
  }
  
  void c(int paramInt)
  {
    if (paramInt != 1) {
      return;
    }
    this.f.setVisibility(0);
    if (this.j.findFragmentByTag("search_result") == null) {
      b(paramInt);
    }
    FragmentTransaction localFragmentTransaction = this.j.beginTransaction();
    localFragmentTransaction.show(this.k);
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  public void c(String paramString)
  {
    IOCRService localIOCRService = (IOCRService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IOCRService.class, "");
    this.n = localIOCRService.generateTextSearchSessionID();
    localIOCRService.doSougouSearch(this.n, paramString, SystemClock.elapsedRealtime());
    this.m = paramString;
  }
  
  void d(int paramInt)
  {
    if (paramInt != 1) {
      return;
    }
    this.f.setVisibility(8);
    if (this.j.findFragmentByTag("search_result") == null) {
      b(paramInt);
    }
    FragmentTransaction localFragmentTransaction = this.j.beginTransaction();
    localFragmentTransaction.hide(this.k);
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnBackPressed()
  {
    finish();
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    OCRTextSearchActivity.MyFlingGestureHandler localMyFlingGestureHandler = this.a;
    if (localMyFlingGestureHandler != null) {
      localMyFlingGestureHandler.onConfigurationChanged(paramConfiguration);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.j = getSupportFragmentManager();
    setContentView(2131627616);
    b();
    Object localObject = getIntent();
    if (localObject == null)
    {
      finish();
      return true;
    }
    a();
    a(this.s);
    localObject = ((Intent)localObject).getStringExtra("keyWord");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      a((String)localObject);
      c((String)localObject);
      a(true);
      this.s = 1;
    }
    this.a = new OCRTextSearchActivity.MyFlingGestureHandler(this);
    this.a.a(false);
    if (paramBundle != null) {
      this.k = ((SearchResultFragment)this.j.findFragmentByTag("search_result"));
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localAppRuntime instanceof AppInterface)) {
      ((AppInterface)localAppRuntime).removeObserver(this.o);
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    paramIntent = paramIntent.getStringExtra("keyWord");
    if (!TextUtils.isEmpty(paramIntent))
    {
      a(paramIntent);
      c(paramIntent);
      a(true);
      this.s = 1;
    }
  }
  
  @TargetApi(9)
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.s == 0)
    {
      super.getWindow().setSoftInputMode(36);
      this.c.setCursorVisible(true);
      return;
    }
    super.getWindow().setSoftInputMode(34);
    this.c.setCursorVisible(false);
  }
  
  protected void doOnStart()
  {
    this.a.onStart();
  }
  
  public void finish()
  {
    EditText localEditText = this.c;
    if (localEditText != null) {
      this.p.hideSoftInputFromWindow(localEditText.getWindowToken(), 0);
    }
    setResult(-1);
    super.finish();
    overridePendingTransition(0, 2130772006);
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131435215)
    {
      this.c.setText("");
      this.c.setCursorVisible(true);
      this.p.showSoftInput(this.c, 0);
    }
    else if (i1 == 2131445159)
    {
      this.p.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      this.c.clearFocus();
      this.c.setCursorVisible(false);
    }
    else if (i1 == 2131432634)
    {
      this.c.setCursorVisible(true);
    }
    else if (i1 == 2131436275)
    {
      finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.OCRTextSearchActivity
 * JD-Core Version:    0.7.0.1
 */