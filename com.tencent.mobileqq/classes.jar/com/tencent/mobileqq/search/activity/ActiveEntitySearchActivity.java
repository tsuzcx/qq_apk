package com.tencent.mobileqq.search.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings.Secure;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.UnifySearchHandler;
import com.tencent.mobileqq.app.UnifySearchObserver;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.search.FunctionModuleConfigManager;
import com.tencent.mobileqq.search.LocationInterface;
import com.tencent.mobileqq.search.base.api.SearchInfoInterface;
import com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.AssociateWordClickCallback;
import com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.ReportUtil;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.SoftKeyboardStateHelper;
import com.tencent.mobileqq.search.util.SoftKeyboardStateHelper.SoftKeyboardStateListener;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import tencent.im.oidb.search.DynamicTabSearch.SubHotWord;

public class ActiveEntitySearchActivity
  extends BaseActivity
  implements TextWatcher, TextView.OnEditorActionListener, LocationInterface, SearchInfoInterface, AssociateSearchWordsFragment.AssociateWordClickCallback, SoftKeyboardStateHelper.SoftKeyboardStateListener
{
  public static boolean q = true;
  public static boolean s = false;
  protected QuickPinyinEditText a;
  protected Button b;
  protected ImageButton c;
  protected ImageView d;
  protected FragmentManager e;
  protected ActiveEntitySearchFragment f;
  protected HotWordsForSubBussFragment g;
  protected AssociateSearchWordsFragment h;
  protected UnifySearchHandler i;
  protected UniteSearchHandler j;
  SoftKeyboardStateHelper k;
  public int l;
  View m;
  public long[] n;
  protected String o;
  protected String p;
  public int r = 1;
  UniteSearchObserver t = new ActiveEntitySearchActivity.5(this);
  UnifySearchObserver u = new ActiveEntitySearchActivity.6(this);
  private int v;
  private String w;
  private int x = -1;
  private int y = -1;
  
  public static void a(Context paramContext, String paramString1, String paramString2, long[] paramArrayOfLong)
  {
    boolean bool = paramContext instanceof UniteSearchActivity;
    int i1 = 9;
    if (bool)
    {
      UniteSearchActivity localUniteSearchActivity = (UniteSearchActivity)paramContext;
      if (localUniteSearchActivity.i() == 1)
      {
        i1 = 3;
        break label87;
      }
      if (localUniteSearchActivity.i() == 3)
      {
        i1 = 6;
        break label87;
      }
    }
    else
    {
      if (((paramContext instanceof PublicFragmentActivity)) || (((paramContext instanceof ActiveEntitySearchActivity)) && (((ActiveEntitySearchActivity)paramContext).l == 9))) {
        break label87;
      }
    }
    i1 = 4;
    label87:
    a(paramContext, paramString1, paramString2, paramArrayOfLong, i1);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, long[] paramArrayOfLong, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, ActiveEntitySearchActivity.class);
    localIntent.putExtra("group_name_string", paramString2);
    localIntent.putExtra("keyword", paramString1);
    localIntent.putExtra("fromType", -1);
    localIntent.putExtra("group_mask_long_array", paramArrayOfLong);
    localIntent.putExtra("from_type_for_report", paramInt);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString, long[] paramArrayOfLong, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, ActiveEntitySearchActivity.class);
    localIntent.putExtra("group_name_string", paramString);
    localIntent.putExtra("group_mask_long_array", paramArrayOfLong);
    localIntent.putExtra("fromType", paramInt);
    paramContext.startActivity(localIntent);
  }
  
  private void b(int paramInt)
  {
    try
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("showFragment  fragment=");
        ((StringBuilder)localObject1).append(paramInt);
        QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, ((StringBuilder)localObject1).toString());
      }
      if ((paramInt != this.x) && (!isFinishing()))
      {
        this.x = paramInt;
        localObject1 = this.e.beginTransaction();
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt == 3)
            {
              if (this.e.findFragmentByTag("associated_words") == null) {
                a(paramInt);
              }
              ((FragmentTransaction)localObject1).show(this.h);
              ((FragmentTransaction)localObject1).commitAllowingStateLoss();
              c(2);
              c(1);
            }
          }
          else
          {
            if (this.e.findFragmentByTag("hot_words") == null) {
              a(paramInt);
            }
            ((FragmentTransaction)localObject1).show(this.g);
            ((FragmentTransaction)localObject1).commitAllowingStateLoss();
            c(3);
            c(1);
            SearchUtils.a("sub_result", "exp_home", new String[] { "", SearchUtils.a(this.n), "", "" });
          }
        }
        else
        {
          this.y = this.x;
          if (this.e.findFragmentByTag("search_result") == null) {
            a(paramInt);
          }
          ((FragmentTransaction)localObject1).show(this.f);
          ((FragmentTransaction)localObject1).commitAllowingStateLoss();
          c(3);
          c(2);
        }
        return;
      }
      return;
    }
    finally {}
  }
  
  private void c(int paramInt)
  {
    FragmentTransaction localFragmentTransaction = this.e.beginTransaction();
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        if (this.e.findFragmentByTag("associated_words") != null)
        {
          localFragmentTransaction.hide(this.h);
          localFragmentTransaction.commitAllowingStateLoss();
          this.h.a(null);
        }
      }
      else if (this.e.findFragmentByTag("hot_words") != null)
      {
        localFragmentTransaction.hide(this.g);
        localFragmentTransaction.commitAllowingStateLoss();
      }
    }
    else if (this.e.findFragmentByTag("search_result") != null)
    {
      localFragmentTransaction.hide(this.f);
      localFragmentTransaction.commitAllowingStateLoss();
    }
  }
  
  private void o()
  {
    this.a = ((QuickPinyinEditText)super.findViewById(2131432634));
    this.a.getInputExtras(true).putInt("QUICK_SEARCH", 1);
    String str = (String)FunctionModuleConfigManager.c.get(FunctionModuleConfigManager.a(this.n));
    if (!TextUtils.isEmpty(str)) {
      this.a.setHint(str);
    } else {
      this.a.setHint(HardCodeUtil.a(2131898042));
    }
    this.a.setImeOptions(3);
    if (!TextUtils.isEmpty(this.o))
    {
      if (this.o.length() > 50) {
        this.o = this.o.substring(0, 50);
      }
      this.a.setText(this.o);
      this.a.setSelection(this.o.length());
      q = false;
    }
    this.a.setOnEditorActionListener(this);
    this.a.addTextChangedListener(this);
    this.a.setFilters(new InputFilter[] { new InputFilter.LengthFilter(50) });
    this.a.a = 50;
    this.c = ((ImageButton)super.findViewById(2131435215));
    this.c.setOnClickListener(new ActiveEntitySearchActivity.2(this));
    this.c.setVisibility(8);
    this.b = ((Button)super.findViewById(2131429816));
    this.b.setVisibility(0);
    this.b.setText(2131916089);
    this.b.setOnClickListener(new ActiveEntitySearchActivity.3(this));
    this.d = ((ImageView)super.findViewById(2131436275));
    this.d.setVisibility(0);
    this.d.setOnClickListener(new ActiveEntitySearchActivity.4(this));
    this.k = new SoftKeyboardStateHelper(super.findViewById(2131445137));
    this.k.a(this);
  }
  
  private void p()
  {
    this.o = this.a.getText().toString().trim();
    if (!TextUtils.isEmpty(this.o))
    {
      this.l = 5;
      this.r = 3;
      e();
    }
    else
    {
      QQToast.makeText(getApplicationContext(), HardCodeUtil.a(2131911076), 0).show();
    }
    f();
  }
  
  public double a()
  {
    return UniteSearchActivity.D;
  }
  
  void a(int paramInt)
  {
    FragmentTransaction localFragmentTransaction = this.e.beginTransaction();
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return;
        }
        if (this.h == null) {
          this.h = new AssociateSearchWordsFragment();
        }
        localFragmentTransaction.add(2131445417, this.h, "associated_words");
        localFragmentTransaction.commitAllowingStateLoss();
        return;
      }
      if (this.g == null)
      {
        this.g = new HotWordsForSubBussFragment();
        Bundle localBundle = new Bundle();
        localBundle.putLongArray("group_masks", this.n);
        localBundle.putInt("fromType", this.v);
        this.g.setArguments(localBundle);
        localFragmentTransaction.add(2131445417, this.g, "hot_words");
        localFragmentTransaction.commitAllowingStateLoss();
      }
    }
    else
    {
      if (this.f == null) {
        this.f = d();
      }
      localFragmentTransaction.add(2131445417, this.f, "search_result");
      localFragmentTransaction.commitAllowingStateLoss();
    }
  }
  
  protected void a(String paramString)
  {
    Object localObject = this.j;
    if (localObject != null)
    {
      ((UniteSearchHandler)localObject).a(paramString);
      return;
    }
    localObject = this.i;
    if (localObject != null)
    {
      ((UnifySearchHandler)localObject).a(paramString);
      return;
    }
    QLog.e("Q.uniteSearch.ActiveEntitySearchActivity", 2, "handler unll");
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject = h();
    String str = SearchUtils.a(this.n);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    SearchUtils.a("sub_result", "clk_auto", new String[] { localObject, str, paramString, localStringBuilder.toString() });
    if (!TextUtils.isEmpty(paramString))
    {
      this.o = paramString;
      this.a.removeTextChangedListener(this);
      this.a.setText(paramString);
      this.a.addTextChangedListener(this);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onAssociateWordClick keyword=");
        ((StringBuilder)localObject).append(this.o);
        QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, ((StringBuilder)localObject).toString());
      }
      this.a.setSelection(paramString.length());
      a(false);
      this.l = 2;
      e();
    }
    paramString = new ReportModelDC02528().module("subweb_search").action("clk_thinkword_list").obj1(SearchUtils.a(this.n)).ver1(h()).ver4(paramString);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("{experiment_id:");
    ((StringBuilder)localObject).append(UniteSearchReportController.b);
    ((StringBuilder)localObject).append("}");
    UniteSearchReportController.a(null, paramString.ver7(((StringBuilder)localObject).toString()));
  }
  
  public void a(DynamicTabSearch.SubHotWord paramSubHotWord)
  {
    paramSubHotWord = paramSubHotWord.search_word.get().toStringUtf8();
    if (!TextUtils.isEmpty(paramSubHotWord))
    {
      this.o = paramSubHotWord;
      this.a.removeTextChangedListener(this);
      this.a.setText(paramSubHotWord);
      this.a.addTextChangedListener(this);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onSubHotWordItemClick keyword=");
        localStringBuilder.append(this.o);
        QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, localStringBuilder.toString());
      }
      this.a.setSelection(paramSubHotWord.length());
      a(false);
      this.l = 8;
      this.r = 2;
      e();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.clearFocus();
    }
    ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.a.getWindowToken(), 0);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.a.getText().toString();
    StringBuilder localStringBuilder;
    if (this.a.a())
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("正在输入拼音，不触发文本变动逻辑。 keyword=");
        localStringBuilder.append(paramEditable);
        QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, localStringBuilder.toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("afterTextChanged keyword=");
      localStringBuilder.append(paramEditable);
      QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, localStringBuilder.toString());
    }
    paramEditable = paramEditable.trim();
    this.o = paramEditable;
    this.f.b = paramEditable;
    if (TextUtils.isEmpty(paramEditable))
    {
      b(2);
      this.c.setVisibility(8);
      return;
    }
    this.c.setVisibility(0);
    b(3);
    a(paramEditable);
  }
  
  public double b()
  {
    return UniteSearchActivity.E;
  }
  
  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.o = paramString;
      this.a.removeTextChangedListener(this);
      this.a.setText(paramString);
      this.a.addTextChangedListener(this);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onHotWordClick keyword=");
        localStringBuilder.append(this.o);
        QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, localStringBuilder.toString());
      }
      this.a.setSelection(paramString.length());
      a(false);
      this.l = 1;
      e();
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void c()
  {
    if (this.v == 10)
    {
      this.j = ((UniteSearchHandler)this.app.getBusinessHandler(BusinessHandlerFactory.UNITE_SEARCH_HANDLER));
      addObserver(this.t);
      this.i = null;
      return;
    }
    this.i = ((UnifySearchHandler)this.app.getBusinessHandler(BusinessHandlerFactory.UNIFY_SEARCH_UNITE_HANDLER));
    addObserver(this.u);
    this.j = null;
  }
  
  public void c(String paramString) {}
  
  protected ActiveEntitySearchFragment d()
  {
    return ActiveEntitySearchFragment.a(this.v, this.n, this.w, this.o);
  }
  
  public void d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.a.setHint(paramString);
      return;
    }
    this.a.setHint(HardCodeUtil.a(2131898045));
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if ((Build.MANUFACTURER.equalsIgnoreCase("huawei")) && (Settings.Secure.getInt(getContentResolver(), "display_notch_status", 0) == 1)) {
      this.mActNeedImmersive = false;
    }
    super.doOnCreate(paramBundle);
    QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 1, "doOnCreate start");
    super.setContentView(2131627931);
    View localView = super.findViewById(2131445137);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      localView.setFitsSystemWindows(true);
    }
    this.m = findViewById(2131445417);
    this.v = getIntent().getIntExtra("fromType", -1);
    this.n = getIntent().getLongArrayExtra("group_mask_long_array");
    this.l = getIntent().getIntExtra("from_type_for_report", 4);
    this.w = getIntent().getStringExtra("group_name_string");
    this.o = getIntent().getStringExtra("keyword");
    o();
    c();
    this.e = super.getSupportFragmentManager();
    if (paramBundle != null)
    {
      if (this.e.findFragmentByTag("search_result") != null) {
        this.f = ((ActiveEntitySearchFragment)this.e.findFragmentByTag("search_result"));
      }
      if (this.e.findFragmentByTag("associated_words") != null) {
        this.h = ((AssociateSearchWordsFragment)this.e.findFragmentByTag("associated_words"));
      }
      if (this.e.findFragmentByTag("hot_words") != null) {
        this.g = ((HotWordsForSubBussFragment)this.e.findFragmentByTag("hot_words"));
      }
    }
    if (this.f == null) {
      this.f = d();
    }
    if (!TextUtils.isEmpty(this.o))
    {
      e();
    }
    else
    {
      b(2);
      new Handler(getMainLooper()).postDelayed(new ActiveEntitySearchActivity.1(this), 500L);
    }
    QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 1, "doOnCreate end");
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    QuickPinyinEditText localQuickPinyinEditText = this.a;
    if (localQuickPinyinEditText != null) {
      localQuickPinyinEditText.setOnEditorActionListener(null);
    }
    g();
    QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 1, "doOnDestroy");
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    ReportUtil.a();
    ApngImage.pauseByTag(38);
    QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 1, "doOnPause");
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    ReportUtil.a(this.l, this.n, this.w, this.o);
    ApngImage.playByTag(38);
    QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 1, "doOnResume");
  }
  
  public void e()
  {
    if (this.f == null) {
      this.f = d();
    }
    this.f.f();
    ActiveEntitySearchFragment localActiveEntitySearchFragment = this.f;
    localActiveEntitySearchFragment.o = null;
    localActiveEntitySearchFragment.a(this.o);
    b(1);
    this.p = this.o;
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    this.a.setCursorVisible(false);
    ReportUtil.b(this.l, this.n, this.w, this.o);
  }
  
  public void f()
  {
    a(true);
  }
  
  protected void g()
  {
    if (this.v == 10)
    {
      removeObserver(this.t);
      return;
    }
    removeObserver(this.u);
  }
  
  public String h()
  {
    return this.a.getText().toString();
  }
  
  public int i()
  {
    return 3;
  }
  
  public long[] j()
  {
    return this.f.F;
  }
  
  public boolean k()
  {
    QuickPinyinEditText localQuickPinyinEditText = this.a;
    if (localQuickPinyinEditText == null) {
      return false;
    }
    return localQuickPinyinEditText.a();
  }
  
  public BaseFragment l()
  {
    return this.f;
  }
  
  public boolean m()
  {
    return false;
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
      p();
      bool = true;
    }
    EventCollector.getInstance().onEditorAction(paramTextView, paramInt, paramKeyEvent);
    return bool;
  }
  
  public void onSoftKeyboardClosed()
  {
    if (this.x == 3) {
      return;
    }
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    this.a.setCursorVisible(false);
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    if ((q) && (isResume()))
    {
      if (this.x == 3) {
        return;
      }
      this.a.setCursorVisible(true);
      String str = this.a.getText().toString().trim();
      this.o = str;
      this.f.b = str;
      if (TextUtils.isEmpty(str))
      {
        b(2);
        this.c.setVisibility(8);
        return;
      }
      this.c.setVisibility(0);
      b(3);
      a(str);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramCharSequence = this.a.getText().toString();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTextChanged keyword=");
      localStringBuilder.append(paramCharSequence);
      localStringBuilder.append(" activity keyword=");
      localStringBuilder.append(this.o);
      QLog.d("Q.uniteSearch.ActiveEntitySearchActivity", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity
 * JD-Core Version:    0.7.0.1
 */