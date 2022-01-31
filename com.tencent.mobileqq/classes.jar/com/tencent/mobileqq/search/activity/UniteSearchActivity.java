package com.tencent.mobileqq.search.activity;

import ahwo;
import ahwp;
import ahwq;
import ahwr;
import ahwt;
import ahwu;
import ahwv;
import ahww;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.logcat.LogcatUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.search.LocationInterface;
import com.tencent.mobileqq.search.SearchEntryConfigManager;
import com.tencent.mobileqq.search.SearchInfoInterface;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.fragment.GroupSearchFragment;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.model.CompleteUrlSpan;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.util.PAOfflineSearchManager;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.search.util.SearchConfigUtils;
import com.tencent.mobileqq.search.util.SearchStatisticsConstants;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.SoftKeyboardStateHelper;
import com.tencent.mobileqq.search.util.SoftKeyboardStateHelper.SoftKeyboardStateListener;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.Patterns;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils.FtsItemClickEvent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class UniteSearchActivity
  extends FragmentActivity
  implements TextWatcher, TextView.OnEditorActionListener, LocationInterface, SearchInfoInterface, SoftKeyboardStateHelper.SoftKeyboardStateListener
{
  public static double a;
  public static long a;
  static HotWordSearchEntryDataModel.HotSearchItem jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem;
  public static String a;
  public static boolean a;
  public static double b;
  public static int b;
  public static long b;
  public static String b;
  public static volatile boolean b;
  public static int d;
  public static int e;
  public int a;
  protected Handler a;
  protected FragmentManager a;
  View jdField_a_of_type_AndroidViewView;
  protected Button a;
  protected ImageButton a;
  protected ImageView a;
  UniteSearchHandler jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler;
  public UniteSearchObserver a;
  protected UniteSearchActivity.CancelReceiver a;
  public UniteSearchActivity.CustomFlingGestureHandler a;
  public GroupSearchFragment a;
  public SearchEntryFragment a;
  SoftKeyboardStateHelper jdField_a_of_type_ComTencentMobileqqSearchUtilSoftKeyboardStateHelper;
  public QuickPinyinEditText a;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  public byte[] a;
  public View b;
  protected ImageButton b;
  public int c;
  public String c;
  boolean c;
  private String d;
  public boolean d;
  private boolean e;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean;
  private boolean g;
  
  static
  {
    jdField_b_of_type_Long = -1L;
    jdField_d_of_type_Int = -1;
    jdField_e_of_type_Int = -1;
  }
  
  public UniteSearchActivity()
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver = new ahwo(this);
    this.jdField_c_of_type_Boolean = false;
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt)
  {
    a(paramActivity, paramString, paramInt, 0L, null, 0);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt1, int paramInt2)
  {
    a(paramActivity, paramString, paramInt1, 0L, null, paramInt2);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt1, long paramLong, HotWordSearchEntryDataModel.HotSearchItem paramHotSearchItem, int paramInt2)
  {
    jdField_d_of_type_Int = paramInt1;
    if (QLog.isColorLevel()) {
      QLog.d("searchUtils", 2, "fromType:" + paramInt1);
    }
    if (paramInt1 == 12) {
      ReportController.b(null, "CliOper", "", "", "0X8006501", "0X8006501", paramInt1, 0, "1", "", "", "");
    }
    for (;;)
    {
      Intent localIntent = new Intent(paramActivity, UniteSearchActivity.class);
      localIntent.putExtra("keyword", paramString);
      localIntent.putExtra("fromType", paramInt1);
      localIntent.putExtra("source", paramInt2);
      localIntent.putExtra("searchEngineKey", paramLong);
      localIntent.putExtra("home_hot_word", paramHotSearchItem);
      paramActivity.startActivity(localIntent);
      paramActivity.overridePendingTransition(0, 2131034405);
      jdField_a_of_type_Long = System.currentTimeMillis();
      jdField_a_of_type_Boolean = false;
      return;
      ReportController.b(null, "CliOper", "", "", "0X8005021", "0X8005021", paramInt1, 0, "1", "", "", "");
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, int paramInt1, String paramString2, int paramInt2, boolean paramBoolean, long paramLong)
  {
    jdField_a_of_type_JavaLangString = paramString2;
    jdField_b_of_type_Int = paramInt2;
    a(paramActivity, paramString1, paramInt1, paramLong, null, 0);
    jdField_a_of_type_Boolean = true;
  }
  
  private void d(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "showFragment  fragment=" + paramInt);
        }
        if (this.app == null)
        {
          if (this.app == null)
          {
            localObject1 = getAppRuntime();
            if ((localObject1 instanceof QQAppInterface)) {
              this.app = ((QQAppInterface)localObject1);
            }
          }
          if (this.app == null)
          {
            QLog.e("Q.uniteSearch.UniteSearchActivity", 1, "showFragment() called app == null!");
            finish();
            return;
          }
        }
        if (paramInt == this.jdField_f_of_type_Int) {
          continue;
        }
        this.jdField_f_of_type_Int = paramInt;
        Object localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction();
        switch (paramInt)
        {
        case 1: 
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          break;
        case 4: 
          if (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag("search_entry_layout") != null) {
            break label174;
          }
        }
      }
      finally {}
      c(paramInt);
      label174:
      localObject2.show(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment);
      localObject2.commitAllowingStateLoss();
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_ArrayOfByte = null;
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.d();
  }
  
  private void g()
  {
    if (jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(2131433976);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.title);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setTag(jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setCursorVisible(true);
  }
  
  private void h()
  {
    ThreadManager.post(new ahwr(this), 5, null, true);
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText = ((QuickPinyinEditText)super.findViewById(2131368324));
    this.jdField_a_of_type_ComTencentMobileqqSearchUtilSoftKeyboardStateHelper = new SoftKeyboardStateHelper(super.findViewById(2131362845));
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(SearchEntryConfigManager.b());
    if (Build.VERSION.SDK_INT >= 26) {}
    try
    {
      View.class.getMethod("setImportantForAutofill", new Class[] { Integer.TYPE }).invoke(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText, new Object[] { Integer.valueOf(8) });
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setImeOptions(3);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setOnEditorActionListener(this);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
      this.jdField_a_of_type_ComTencentMobileqqSearchUtilSoftKeyboardStateHelper.a(this);
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)super.findViewById(2131368325));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new ahwt(this));
      this.jdField_b_of_type_AndroidWidgetImageButton = ((ImageButton)super.findViewById(2131370353));
      if (this.jdField_b_of_type_AndroidWidgetImageButton != null) {
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
      }
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131368323));
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131433029);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new ahwu(this));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131371258));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ahwv(this));
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getInputExtras(true).putInt("QUICK_SEARCH", 1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("Q.uniteSearch.UniteSearchActivity", 2, "disable auto fill error", localException);
      }
    }
  }
  
  public double a()
  {
    return jdField_a_of_type_Double;
  }
  
  public int a()
  {
    return 1;
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    }
    return 3;
  }
  
  public Fragment a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment;
  }
  
  protected GroupSearchFragment a()
  {
    try
    {
      long l = getIntent().getLongExtra("searchEngineKey", 0L);
      if (l > 0L)
      {
        GroupSearchFragment localGroupSearchFragment1 = GroupSearchFragment.a(this.jdField_c_of_type_Int, this.jdField_a_of_type_Int, l);
        localGroupSearchFragment1.d(jdField_a_of_type_Boolean);
        return localGroupSearchFragment1;
      }
    }
    catch (Exception localException)
    {
      GroupSearchFragment localGroupSearchFragment2 = GroupSearchFragment.a(this.jdField_c_of_type_Int, this.jdField_a_of_type_Int);
      localGroupSearchFragment2.d(jdField_a_of_type_Boolean);
      return localGroupSearchFragment2;
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString();
  }
  
  public String a(EditText paramEditText, boolean paramBoolean, CharSequence paramCharSequence)
  {
    String str = paramEditText.getText().toString();
    SpannableStringBuilder localSpannableStringBuilder = (SpannableStringBuilder)paramEditText.getText();
    if (localSpannableStringBuilder != null)
    {
      CompleteUrlSpan[] arrayOfCompleteUrlSpan = (CompleteUrlSpan[])localSpannableStringBuilder.getSpans(0, localSpannableStringBuilder.toString().length(), CompleteUrlSpan.class);
      if (arrayOfCompleteUrlSpan.length != 0)
      {
        int i = localSpannableStringBuilder.getSpanStart(arrayOfCompleteUrlSpan[0]);
        localSpannableStringBuilder.getSpanEnd(arrayOfCompleteUrlSpan[0]);
        if (paramBoolean) {}
        for (paramCharSequence = paramCharSequence.toString().substring(0, i + 1);; paramCharSequence = str.toString().substring(0, i))
        {
          paramEditText.removeTextChangedListener(this);
          paramEditText.setText(paramCharSequence);
          paramEditText.setSelection(paramCharSequence.length());
          paramEditText.addTextChangedListener(this);
          return paramCharSequence;
        }
      }
    }
    return paramEditText.getText().toString().trim();
  }
  
  public void a()
  {
    ((InputMethodManager)getSystemService("input_method")).showSoftInput(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText, 0);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setCursorVisible(true);
  }
  
  public void a(String paramString)
  {
    f();
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.b(paramString);
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(null);
    d(1);
  }
  
  public void a(String paramString, int paramInt)
  {
    f();
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    b(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.b(paramString);
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(null);
    d(1);
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramBoolean2)
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString);
      localSpannableStringBuilder.setSpan(new BackgroundColorSpan(858244351), 0, paramString.length(), 33);
      localSpannableStringBuilder.setSpan(new ahww(this), 0, paramString.length(), 33);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setMovementMethod(LinkMovementMethod.getInstance());
      if (paramBoolean1) {
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(localSpannableStringBuilder);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(paramString.length());
        return;
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.removeTextChangedListener(this);
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(localSpannableStringBuilder);
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
        f();
        d(4);
      }
    }
    if (paramBoolean1) {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(paramString);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(paramString.length());
      return;
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.removeTextChangedListener(this);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(paramString);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
    }
  }
  
  void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("searchUtils", 2, "showSearchHistory,  isShow: " + paramBoolean);
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    do
    {
      return;
      if ((paramBoolean) && (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0) && (this.jdField_c_of_type_Int != 12))
      {
        d(4);
        return;
      }
    } while (((paramBoolean) || (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0)) && (this.jdField_c_of_type_Int != 12));
    d(1);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.a();
  }
  
  public long[] a()
  {
    return new long[0];
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = a(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText, this.g, this.jdField_a_of_type_JavaLangCharSequence);
    if ((this.g) && (paramEditable.equals(this.jdField_c_of_type_JavaLangString))) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.g != 6) {
      this.jdField_d_of_type_Boolean = true;
    }
    this.jdField_c_of_type_JavaLangString = paramEditable;
    jdField_b_of_type_JavaLangString = paramEditable;
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.jdField_b_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    if (TextUtils.isEmpty(paramEditable))
    {
      SearchUtils.a("home_page", "exp_home", new String[] { "" + a(this.jdField_c_of_type_Int) });
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      if (SearchConfigManager.a()) {
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
      }
      f();
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.e();
      if (jdField_b_of_type_Boolean)
      {
        jdField_b_of_type_Boolean = false;
        if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment != null) {
          this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment.a();
        }
      }
      a(true);
    }
    for (;;)
    {
      if (!paramEditable.equals(this.jdField_c_of_type_JavaLangString))
      {
        SearchUtils.jdField_b_of_type_Long = 0L;
        jdField_e_of_type_Int = 2;
      }
      if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        break;
      }
      a(TextUtils.isEmpty(paramEditable));
      return;
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
      a(paramEditable);
      a(false);
    }
  }
  
  public double b()
  {
    return jdField_b_of_type_Double;
  }
  
  protected int b()
  {
    return 2130971726;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setCursorVisible(false);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.g = paramInt;
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = false;
    if ((TextUtils.isEmpty(paramCharSequence)) && (paramInt1 == 0) && (paramInt2 == 0) && (this.jdField_f_of_type_Boolean))
    {
      this.jdField_f_of_type_Boolean = false;
      SQLiteFTSUtils.FtsItemClickEvent.a();
      SQLiteFTSUtils.FtsItemClickEvent.c = System.nanoTime();
    }
    if (paramInt3 == 0) {
      bool = true;
    }
    this.g = bool;
    this.jdField_a_of_type_JavaLangCharSequence = ("" + paramCharSequence);
  }
  
  public int c()
  {
    switch (this.jdField_c_of_type_Int)
    {
    default: 
      return this.jdField_c_of_type_Int;
    }
    return 3;
  }
  
  public void c()
  {
    ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getWindowToken(), 0);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.clearFocus();
  }
  
  void c(int paramInt)
  {
    FragmentTransaction localFragmentTransaction = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction();
    switch (paramInt)
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment != null);
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment = new SearchEntryFragment();
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.app;
    String str;
    switch (this.jdField_c_of_type_Int)
    {
    default: 
      str = "kSearchMessageTab";
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment.jdField_a_of_type_JavaLangString = str;
      localFragmentTransaction.add(2131372303, this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment, "search_entry_layout");
      localFragmentTransaction.commitAllowingStateLoss();
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
      str = "kSearchMessageTab";
      continue;
      str = "kSearchContactTab";
      continue;
      str = "kSearchDynamicTab";
    }
  }
  
  protected void d()
  {
    int j = 1;
    int i = j;
    switch (this.jdField_c_of_type_Int)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler.a(this.app, i);
      return;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.jdField_b_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.jdField_b_of_type_JavaUtilList.size() > 0)) {
      c();
    }
    if (paramInt1 == 1300) {
      if ((-1 == paramInt2) && (paramIntent != null))
      {
        paramIntent = paramIntent.getStringExtra("roomId");
        if (paramIntent != null)
        {
          TroopUtils.a(this, paramIntent);
          ReportController.b(this.app, "CliOper", "", "", "0X8006360", "0X8006360", 0, 0, "", "", "", "");
        }
      }
    }
    String str;
    do
    {
      do
      {
        return;
      } while ((paramInt1 != 561253) || (-1 != paramInt2) || (paramIntent == null));
      str = paramIntent.getStringExtra("keyword");
    } while (TextUtils.isEmpty(str));
    jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("vsKey");
    jdField_b_of_type_Int = paramIntent.getIntExtra("vsSource", 1);
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.d(true);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(str);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(str.length());
    a(str);
    c();
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if (this.jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$CustomFlingGestureHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$CustomFlingGestureHandler.onConfigurationChanged(paramConfiguration);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_c_of_type_Int = super.getIntent().getIntExtra("fromType", -1);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver);
    jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = super.getSupportFragmentManager();
    setContentView(b());
    paramBundle = super.findViewById(2131362845);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      paramBundle.setFitsSystemWindows(true);
    }
    paramBundle.setBackgroundResource(2130838219);
    this.jdField_a_of_type_Int = super.getIntent().getIntExtra("source", 0);
    this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler = ((UniteSearchHandler)this.app.a(111));
    h();
    i();
    this.jdField_c_of_type_JavaLangString = super.getIntent().getStringExtra("keyword");
    Object localObject = (HotWordSearchEntryDataModel.HotSearchItem)super.getIntent().getSerializableExtra("home_hot_word");
    if ((localObject != null) && (!TextUtils.isEmpty(((HotWordSearchEntryDataModel.HotSearchItem)localObject).title)))
    {
      jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem = (HotWordSearchEntryDataModel.HotSearchItem)localObject;
      g();
      SearchUtils.a("home_page", "hot_list", new String[] { jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.title, String.valueOf(c()) });
    }
    localObject = getResources().getDisplayMetrics();
    SearchUtils.a("home_page", "active_search", new String[] { "" + a(this.jdField_c_of_type_Int), ((DisplayMetrics)localObject).widthPixels + "*" + ((DisplayMetrics)localObject).heightPixels });
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("project", UniteSearchReportController.a());
      ((JSONObject)localObject).put("event_src", "client");
      UniteSearchReportController.a(this.app, new ReportModelDC02528().module("all_result").action("active_search").ver2(UniteSearchReportController.a(this.jdField_c_of_type_Int)).ver7(((JSONObject)localObject).toString()).session_id(this.app.getCurrentAccountUin() + System.currentTimeMillis()));
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        SearchUtils.a("home_page", "exp_home", new String[] { "" + a(this.jdField_c_of_type_Int) });
      }
      localObject = super.getSupportFragmentManager();
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment = a();
      ((FragmentManager)localObject).beginTransaction().replace(2131375444, this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment).commit();
      this.jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$CustomFlingGestureHandler = new UniteSearchActivity.CustomFlingGestureHandler(this);
      this.jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$CustomFlingGestureHandler.a(false);
      jdField_b_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (this.jdField_c_of_type_Int == 12) {
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(String.format(getResources().getString(2131430101), new Object[] { PublicAccountConfigUtil.a(this.app, getApplicationContext()) }));
      }
      this.jdField_d_of_type_JavaLangString = SearchHistoryManager.a(this.app);
      if ((!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (this.jdField_c_of_type_Int != 12) && (this.jdField_c_of_type_Int != 14) && (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment != null)) {
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment.a();
      }
      this.jdField_f_of_type_Boolean = true;
      if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) || (!SearchConfigManager.a()) || (this.jdField_c_of_type_Int == 21))
      {
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageButton.setOnClickListener(new ahwp(this));
        this.jdField_a_of_type_AndroidViewView = paramBundle.findViewById(2131372303);
        this.jdField_b_of_type_AndroidViewView = paramBundle.findViewById(2131375444);
        d(4);
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.jdField_a_of_type_Int = 50;
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(50) });
        this.jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$CancelReceiver = new UniteSearchActivity.CancelReceiver(this);
        paramBundle = new IntentFilter();
        paramBundle.addAction("com.tencent.mobileqq.search.cancel");
        super.registerReceiver(this.jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$CancelReceiver, paramBundle);
        d();
        if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
          break label910;
        }
        if (this.jdField_c_of_type_JavaLangString.length() > 50) {
          this.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString.substring(0, 50);
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.uniteSearch.UniteSearchActivity", 2, "自动搜索 isViewCreated:" + this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.jdField_e_of_type_Boolean);
        }
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.jdField_f_of_type_Boolean = true;
        if (this.jdField_c_of_type_Int == 4) {
          b(6);
        }
        return true;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("Q.uniteSearch.UniteSearchActivity", 2, "e = " + localJSONException);
        continue;
        this.jdField_b_of_type_AndroidWidgetImageButton.setVisibility(0);
      }
      label910:
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ahwq(this), 500L);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$CancelReceiver != null)
      {
        super.unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$CancelReceiver);
        this.jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$CancelReceiver = null;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver);
      PAOfflineSearchManager.a().a();
      jdField_d_of_type_Int = -1;
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFocusable(false);
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFocusableInTouchMode(false);
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getParent() != null) {
          ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getParent()).removeView(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText);
        }
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.removeTextChangedListener(this);
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setOnEditorActionListener(null);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
      catch (Error localError1)
      {
        for (;;)
        {
          localError1.printStackTrace();
        }
      }
      SearchUtils.a = null;
      jdField_e_of_type_Int = -1;
      if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment != null) {
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.i();
      }
      c();
      SearchUtil.a();
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          super.doOnDestroy();
          return;
        }
        catch (Error localError2)
        {
          QLog.e("Q.uniteSearch.UniteSearchActivity", 1, QLog.getStackTraceString(localError2));
        }
        localException1 = localException1;
        localException1.printStackTrace();
      }
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    jdField_b_of_type_Long = -1L;
  }
  
  protected void doOnStart()
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$CustomFlingGestureHandler.onStart();
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    if ((!SQLiteFTSUtils.FtsItemClickEvent.jdField_a_of_type_Boolean) && (SQLiteFTSUtils.FtsItemClickEvent.jdField_f_of_type_Int != 1))
    {
      SQLiteFTSUtils.FtsItemClickEvent.d += (System.nanoTime() - SQLiteFTSUtils.FtsItemClickEvent.c) / 1000000L;
      SQLiteFTSUtils.FtsItemClickEvent.jdField_f_of_type_Long += (System.nanoTime() - SQLiteFTSUtils.FtsItemClickEvent.e) / 1000000L;
    }
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.jdField_e_of_type_Boolean))
    {
      this.jdField_e_of_type_Boolean = true;
      StatisticCollector.a(BaseApplicationImpl.getApplication()).a(this.app.getCurrentAccountUin(), "GroupSearchLaunchTime", true, System.currentTimeMillis() - jdField_a_of_type_Long, 0L, null, "", false);
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("searchUtils", 2, "cancelType-2 ResultModule:" + SearchStatisticsConstants.a());
    }
    ReportController.b(null, "CliOper", "", "", "0X8005E13", "0X8005E13", 0, 0, "2", "", SearchStatisticsConstants.a(), "");
    ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getWindowToken(), 0);
    jdField_e_of_type_Int = 0;
    finish();
  }
  
  public void finish()
  {
    if (jdField_a_of_type_Boolean) {
      ReportController.b(this.app, "CliOper", "", "", "0X8007E2D", "0X8007E2D", 0, jdField_e_of_type_Int, "", "", "", "");
    }
    setResult(-1);
    super.finish();
    overridePendingTransition(0, 2131034405);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 3) || ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66)))
    {
      if ((paramKeyEvent != null) && (paramKeyEvent.getAction() != 1)) {
        return true;
      }
      paramTextView = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString().trim();
      LogcatUtil.a(paramTextView);
      if (Patterns.d.matcher(paramTextView).matches())
      {
        this.jdField_c_of_type_JavaLangString = paramTextView;
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.performClick();
      }
      if ((TextUtils.isEmpty(paramTextView)) && ((this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getTag() instanceof HotWordSearchEntryDataModel.HotSearchItem)))
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getHint().toString();
        paramKeyEvent = ((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getTag()).jumpUrl;
        paramTextView = paramKeyEvent;
        if (TextUtils.isEmpty(paramKeyEvent)) {
          paramTextView = SearchConfigUtils.a(str, 6, "hotword");
        }
        if (!TextUtils.isEmpty(paramTextView))
        {
          paramKeyEvent = JumpParser.a(this.app, this, paramTextView);
          if (paramKeyEvent != null) {
            paramKeyEvent.b();
          }
        }
        for (;;)
        {
          SearchUtils.a("all_result", "clk_wording", new String[] { str, String.valueOf(c()) });
          SearchUtil.jdField_a_of_type_Boolean = true;
          return true;
          if ((paramTextView.startsWith("http://")) || (paramTextView.startsWith("https://")))
          {
            paramKeyEvent = new Intent(this, QQBrowserActivity.class);
            paramKeyEvent.putExtra("url", paramTextView);
            paramKeyEvent.putExtra("search_title", str);
            startActivity(paramKeyEvent);
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "onEditorAction jumpUrl is illegal");
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "onEditorAction jumpUrl is empty");
            }
          }
        }
      }
      if (!TextUtils.isEmpty(paramTextView))
      {
        this.jdField_c_of_type_JavaLangString = paramTextView;
        jdField_b_of_type_JavaLangString = paramTextView;
        a(paramTextView, 1);
      }
      for (;;)
      {
        c();
        return true;
        if ((this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getTag() instanceof HotWordSearchEntryDataModel.HotSearchItem))
        {
          paramTextView = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getHint().toString();
          this.jdField_c_of_type_JavaLangString = paramTextView;
          jdField_b_of_type_JavaLangString = paramTextView;
          this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(paramTextView);
          this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(paramTextView.length());
        }
      }
    }
    return false;
  }
  
  protected void onRestart()
  {
    super.onRestart();
    if ((!SQLiteFTSUtils.FtsItemClickEvent.jdField_a_of_type_Boolean) && (SQLiteFTSUtils.FtsItemClickEvent.jdField_f_of_type_Int != 1))
    {
      SQLiteFTSUtils.FtsItemClickEvent.c = System.nanoTime();
      SQLiteFTSUtils.FtsItemClickEvent.e = System.nanoTime();
    }
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.removeTextChangedListener(this);
    }
    super.onRestoreInstanceState(paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.UniteSearchActivity
 * JD-Core Version:    0.7.0.1
 */