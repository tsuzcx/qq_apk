package com.tencent.mobileqq.search.activity;

import akgb;
import akgc;
import akix;
import akiy;
import akiz;
import akjb;
import amvk;
import amvl;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import awhx;
import awik;
import awin;
import awip;
import awjw;
import awjx;
import awjy;
import awjz;
import awka;
import awkb;
import awkc;
import awkd;
import awkz;
import awsq;
import awtk;
import awvx;
import awvz;
import awwa;
import awwe;
import awwf;
import axqy;
import axrn;
import banb;
import bbeg;
import bbex;
import bbft;
import bbmp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.logcat.LogcatUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment;
import com.tencent.mobileqq.search.fragment.GroupSearchFragment;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.model.CompleteUrlSpan;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.GIFInfo;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import onh;
import org.json.JSONException;
import org.json.JSONObject;
import sfe;

public class UniteSearchActivity
  extends FragmentActivity
  implements TextWatcher, TextView.OnEditorActionListener, awik, awip, awkz, awwf
{
  public static double a;
  public static long a;
  public static HotWordSearchEntryDataModel.HotSearchItem a;
  public static String a;
  public static double b;
  public static int b;
  public static long b;
  public static String b;
  public static boolean b;
  public static String c;
  public static volatile boolean c;
  public static int d;
  public static String d;
  public static boolean d;
  public static int e;
  public static String e;
  public int a;
  akix jdField_a_of_type_Akix;
  public akiy a;
  akiz jdField_a_of_type_Akiz;
  public akjb a;
  protected Handler a;
  protected FragmentManager a;
  View jdField_a_of_type_AndroidViewView;
  protected Button a;
  protected ImageButton a;
  protected ImageView a;
  final awkd jdField_a_of_type_Awkd = new awkd(this);
  awwe jdField_a_of_type_Awwe;
  protected UniteSearchActivity.CancelReceiver a;
  public AssociateSearchWordsFragment a;
  public GroupSearchFragment a;
  public SearchEntryFragment a;
  public QuickPinyinEditText a;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  public boolean a;
  public byte[] a;
  final Handler jdField_b_of_type_AndroidOsHandler = new awkb(this);
  View jdField_b_of_type_AndroidViewView;
  public int c;
  public View c;
  public boolean e;
  public int f;
  public String f;
  public boolean f;
  private int jdField_g_of_type_Int = -1;
  private String jdField_g_of_type_JavaLangString;
  private boolean jdField_g_of_type_Boolean;
  private boolean h;
  private boolean i;
  
  static
  {
    jdField_b_of_type_Long = -1L;
    jdField_d_of_type_Int = -1;
    jdField_c_of_type_JavaLangString = "";
    jdField_d_of_type_JavaLangString = "";
    jdField_e_of_type_JavaLangString = "";
    jdField_e_of_type_Int = -1;
    jdField_d_of_type_Boolean = true;
  }
  
  public UniteSearchActivity()
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_f_of_type_Int = 10000;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_Akjb = new awjw(this);
    this.jdField_a_of_type_Akiy = new awjx(this);
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
    a(paramActivity, paramString, paramInt1, paramLong, paramHotSearchItem, paramInt2, null);
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt1, long paramLong, HotWordSearchEntryDataModel.HotSearchItem paramHotSearchItem, int paramInt2, HotWordSearchEntryDataModel.GIFInfo paramGIFInfo)
  {
    jdField_d_of_type_Int = paramInt1;
    if (QLog.isColorLevel()) {
      QLog.d("searchUtils", 2, "fromType:" + paramInt1);
    }
    if (paramInt1 == 12) {
      axqy.b(null, "CliOper", "", "", "0X8006501", "0X8006501", paramInt1, 0, "1", "", "", "");
    }
    for (;;)
    {
      Intent localIntent = new Intent(paramActivity, UniteSearchActivity.class);
      localIntent.putExtra("keyword", paramString);
      localIntent.putExtra("fromType", paramInt1);
      localIntent.putExtra("source", paramInt2);
      localIntent.putExtra("searchEngineKey", paramLong);
      localIntent.putExtra("home_hot_word", paramHotSearchItem);
      localIntent.putExtra("home_gif_info", paramGIFInfo);
      paramActivity.startActivity(localIntent);
      paramActivity.overridePendingTransition(0, 2130772307);
      jdField_a_of_type_Long = System.currentTimeMillis();
      jdField_b_of_type_Boolean = false;
      awwa.a("search", "tab", "searchbar", 0, 0, new String[] { awwa.a(paramInt1) });
      return;
      axqy.b(null, "CliOper", "", "", "0X8005021", "0X8005021", paramInt1, 0, "1", "", "", "");
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    jdField_d_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("searchUtils", 2, "fromType:" + paramInt);
    }
    if (paramInt == 12) {
      axqy.b(null, "CliOper", "", "", "0X8006501", "0X8006501", paramInt, 0, "1", "", "", "");
    }
    for (;;)
    {
      Intent localIntent = new Intent(paramContext, UniteSearchActivity.class);
      localIntent.putExtra("keyword", paramString);
      localIntent.putExtra("fromType", paramInt);
      paramContext.startActivity(localIntent);
      jdField_b_of_type_Boolean = false;
      jdField_a_of_type_Long = System.currentTimeMillis();
      awwa.a("search", "tab", "searchbar", 0, 0, new String[] { awwa.a(paramInt) });
      return;
      axqy.b(null, "CliOper", "", "", "0X8005021", "0X8005021", paramInt, 0, "1", "", "", "");
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "useNewProtocol， source:" + paramInt1 + " from:" + paramInt2);
    }
    switch (paramInt2)
    {
    default: 
      return true;
    }
    return false;
  }
  
  private int b(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return 1;
    case 2: 
      return 2;
    case 21: 
      return 3;
    }
    return 10;
  }
  
  private void c(int paramInt)
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
        if (paramInt == this.jdField_g_of_type_Int) {
          continue;
        }
        this.jdField_g_of_type_Int = paramInt;
        Object localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction();
        switch (paramInt)
        {
        case 1: 
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
          awsq.a(null, 0, this.jdField_c_of_type_Int, "0X8009D29", 0, 0, null, null);
          break;
        case 4: 
          if (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag("search_entry_layout") != null) {
            break label208;
          }
        }
      }
      finally {}
      b(paramInt);
      label208:
      localObject2.show(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment);
      localObject2.commitAllowingStateLoss();
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      continue;
      if (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag("associated_words") == null) {
        b(paramInt);
      }
      localObject2.show(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment);
      localObject2.commitAllowingStateLoss();
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ArrayOfByte = null;
    if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(4);
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.d();
  }
  
  private void h()
  {
    if (jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(2131719112);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.title);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setTag(jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setCursorVisible(true);
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText = ((QuickPinyinEditText)super.findViewById(2131365763));
    this.jdField_a_of_type_Awwe = new awwe(super.findViewById(2131375493));
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(awin.b());
    if (Build.VERSION.SDK_INT >= 26) {}
    try
    {
      View.class.getMethod("setImportantForAutofill", new Class[] { Integer.TYPE }).invoke(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText, new Object[] { Integer.valueOf(8) });
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setImeOptions(3);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setOnEditorActionListener(this);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
      jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_Awwe.a(this);
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)super.findViewById(2131367678));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new awjy(this));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131363479));
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131690596);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new awjz(this));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131368507));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new awka(this));
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
        localGroupSearchFragment1.c(jdField_b_of_type_Boolean);
        return localGroupSearchFragment1;
      }
    }
    catch (Exception localException)
    {
      GroupSearchFragment localGroupSearchFragment2 = GroupSearchFragment.a(this.jdField_c_of_type_Int, this.jdField_a_of_type_Int);
      localGroupSearchFragment2.c(jdField_b_of_type_Boolean);
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
        int j = localSpannableStringBuilder.getSpanStart(arrayOfCompleteUrlSpan[0]);
        localSpannableStringBuilder.getSpanEnd(arrayOfCompleteUrlSpan[0]);
        if (paramBoolean) {}
        for (paramCharSequence = paramCharSequence.toString().substring(0, j + 1);; paramCharSequence = str.toString().substring(0, j))
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
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.jdField_g_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    g();
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.b(paramString);
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(null);
    c(1);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_f_of_type_JavaLangString = paramString;
      awsq.a(null, new ReportModelDC02528().module("all_result").action("clk_thinkword_list").ver1(a()).ver2(awsq.a(this.jdField_c_of_type_Int)).ver3(jdField_d_of_type_JavaLangString).ver6(jdField_c_of_type_JavaLangString).ver7("{\"clk_index\":" + (paramInt - 1) + ",\"experiment_id\":" + awsq.jdField_b_of_type_JavaLangString + "}").ver4(paramString));
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.removeTextChangedListener(this);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(paramString);
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "onAssociateWordClick keyword = " + paramString);
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(paramString.length());
      if (a(this.jdField_a_of_type_Int, this.jdField_c_of_type_Int)) {}
      b(paramString, 2);
    }
    b();
  }
  
  public void a(String paramString, long paramLong)
  {
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(101);
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, paramLong);
    this.jdField_a_of_type_Awkd.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Awkd.jdField_a_of_type_Long = (System.currentTimeMillis() + paramLong);
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
      localSpannableStringBuilder.setSpan(new awkc(this), 0, paramString.length(), 33);
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
        g();
        c(4);
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
        c(4);
        return;
      }
    } while (((paramBoolean) || (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0)) && (this.jdField_c_of_type_Int != 12));
    c(1);
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
    if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment.a(paramEditable);
    }
    paramEditable = a(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText, this.i, this.jdField_a_of_type_JavaLangCharSequence);
    if ((this.i) && (paramEditable.equals(this.jdField_f_of_type_JavaLangString))) {}
    do
    {
      return;
      boolean bool = a(this.jdField_a_of_type_Int, this.jdField_c_of_type_Int);
      if ((!bool) && (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.jdField_g_of_type_Int != 6)) {
        this.jdField_f_of_type_Boolean = true;
      }
      if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.jdField_g_of_type_Int != 6)) {
        this.jdField_f_of_type_Boolean = true;
      }
      if (TextUtils.isEmpty(jdField_d_of_type_JavaLangString)) {
        jdField_d_of_type_JavaLangString = this.app.getAccount() + System.currentTimeMillis();
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.a()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "正在输入拼音，不触发文本变动逻辑。 keyword=" + paramEditable);
    return;
    this.jdField_f_of_type_JavaLangString = paramEditable;
    jdField_b_of_type_JavaLangString = paramEditable;
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.jdField_c_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
    if (TextUtils.isEmpty(paramEditable))
    {
      awwa.a("home_page", "exp_home", new String[] { "" + a(this.jdField_c_of_type_Int) });
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      g();
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.e();
      if (jdField_c_of_type_Boolean)
      {
        jdField_c_of_type_Boolean = false;
        if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment != null) {
          this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment.a();
        }
      }
      a(true);
    }
    for (;;)
    {
      if (!paramEditable.equals(this.jdField_f_of_type_JavaLangString))
      {
        awwa.jdField_b_of_type_Long = 0L;
        jdField_e_of_type_Int = 2;
      }
      if (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {
        a(TextUtils.isEmpty(paramEditable));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.a(null);
      return;
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      if ((this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment != null) && (this.jdField_c_of_type_Int != 25))
      {
        a(paramEditable);
        a(false);
      }
      else if (!this.jdField_e_of_type_Boolean)
      {
        jdField_d_of_type_Boolean = true;
        a(paramEditable);
      }
      else
      {
        a(paramEditable, 0L);
      }
    }
  }
  
  public double b()
  {
    return jdField_b_of_type_Double;
  }
  
  protected int b()
  {
    return 2131562578;
  }
  
  public void b()
  {
    ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getWindowToken(), 0);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.clearFocus();
  }
  
  void b(int paramInt)
  {
    FragmentTransaction localFragmentTransaction = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction();
    switch (paramInt)
    {
    default: 
    case 4: 
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment != null);
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment = new SearchEntryFragment();
      awsq.a(this.app, new ReportModelDC02528().module("all_result").action("exp_entryweb").ver2(awsq.a(this.jdField_c_of_type_Int)).session_id(this.app.getCurrentAccountUin() + System.currentTimeMillis()));
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
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment.jdField_b_of_type_Int = this.jdField_c_of_type_Int;
        localFragmentTransaction.add(2131365719, this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment, "search_entry_layout");
        localFragmentTransaction.commitAllowingStateLoss();
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        return;
        str = "kSearchMessageTab";
        continue;
        str = "kSearchContactTab";
        continue;
        str = "kSearchDynamicTab";
        continue;
        str = "kSearchReadInJoyTab";
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment == null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment = new AssociateSearchWordsFragment();
    }
    localFragmentTransaction.add(2131362831, this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment, "associated_words");
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  public void b(String paramString, int paramInt)
  {
    String str2 = amvl.a().jdField_c_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "https://sou.qq.com/kandian/kd.html?_bid=3216&_wv=3&_wwv=1293&_wvSb=0&keyword=$KEYWORD$&from=$FROM$";
    }
    str1 = str1.replace("$KEYWORD$", this.jdField_f_of_type_JavaLangString);
    if (this.jdField_c_of_type_Int == 25) {
      if (paramInt == 2)
      {
        str1 = str1.replace("$FROM$", "kandian_thinkword");
        str1 = str1.replace("$SEARCHID$", "" + URLEncoder.encode(jdField_c_of_type_JavaLangString)).replace("$SEQNO$", "" + URLEncoder.encode(jdField_d_of_type_JavaLangString));
        awwa.a(this.app, this, str1, this.jdField_f_of_type_Int);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment != null) && ((TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment.jdField_a_of_type_JavaLangString, "kSearchDynamicTab")) || (this.jdField_c_of_type_Int == 25)))
      {
        ((akgc)((QQAppInterface)onh.a()).getManager(299)).a(paramString);
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment.a();
      }
      return;
      str1 = str1.replace("$FROM$", "kandian_search");
      break;
      g();
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      a(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.b(paramString);
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(null);
      c(1);
    }
  }
  
  public boolean b()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = false;
    if ((TextUtils.isEmpty(paramCharSequence)) && (paramInt1 == 0) && (paramInt2 == 0) && (this.h))
    {
      this.h = false;
      bbmp.a();
      bbmp.c = System.nanoTime();
    }
    if (paramInt3 == 0) {
      bool = true;
    }
    this.i = bool;
    this.jdField_a_of_type_JavaLangCharSequence = ("" + paramCharSequence);
  }
  
  public int c()
  {
    switch (this.jdField_c_of_type_Int)
    {
    default: 
      return this.jdField_c_of_type_Int;
    case 21: 
      return 3;
    }
    return 10;
  }
  
  protected void c()
  {
    if (!a(this.jdField_a_of_type_Int, this.jdField_c_of_type_Int))
    {
      this.jdField_a_of_type_Akiz = ((akiz)this.app.a(111));
      this.jdField_a_of_type_Akix = null;
      return;
    }
    this.jdField_a_of_type_Akiz = null;
    this.jdField_a_of_type_Akix = ((akix)this.app.a(152));
  }
  
  public void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_f_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(paramString);
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "onAssociateWordClick keyword = " + paramString);
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(paramString.length());
    }
  }
  
  protected void d()
  {
    int j = b(this.jdField_c_of_type_Int);
    if (this.jdField_a_of_type_Akiz != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "getUniteSearchDiscovery use old protocl");
      }
      this.jdField_a_of_type_Akiz.a(this.app, j);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Akix != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "getUniteSearchDiscovery use new protocl");
        }
        this.jdField_a_of_type_Akix.a(this.app, j);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "getUniteSearchDiscovery error");
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.jdField_c_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.jdField_c_of_type_JavaUtilList.size() > 0)) {
      b();
    }
    if (paramInt1 == 1300) {
      if ((-1 == paramInt2) && (paramIntent != null))
      {
        paramIntent = paramIntent.getStringExtra("roomId");
        if (paramIntent != null)
        {
          banb.a(this, paramIntent, true);
          axqy.b(this.app, "CliOper", "", "", "0X8006360", "0X8006360", 0, 0, "", "", "", "");
        }
      }
    }
    do
    {
      String str;
      do
      {
        do
        {
          return;
          if (paramInt1 != 561253) {
            break;
          }
        } while ((-1 != paramInt2) || (paramIntent == null));
        str = paramIntent.getStringExtra("keyword");
      } while (TextUtils.isEmpty(str));
      jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("vsKey");
      jdField_b_of_type_Int = paramIntent.getIntExtra("vsSource", 1);
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.c(true);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(str);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(str.length());
      a(str);
      b();
      return;
    } while (paramInt1 != this.jdField_f_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText("");
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    awsq.a(this.app, new ReportModelDC02528().module("all_result").action("return").ver1(a()).ver2(awsq.a(this.jdField_c_of_type_Int)).ver3(jdField_d_of_type_JavaLangString).ver6(jdField_c_of_type_JavaLangString).session_id(this.app.getCurrentAccountUin() + System.currentTimeMillis()));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_c_of_type_Int = super.getIntent().getIntExtra("fromType", -1);
    this.app.addObserver(this.jdField_a_of_type_Akjb);
    this.app.addObserver(this.jdField_a_of_type_Akiy);
    jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = super.getSupportFragmentManager();
    int j = b(this.jdField_c_of_type_Int);
    if (j != -1)
    {
      jdField_c_of_type_JavaLangString = j + "_" + this.app.getAccount() + "_" + System.currentTimeMillis();
      setContentView(b());
      paramBundle = super.findViewById(2131375493);
      if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
        paramBundle.setFitsSystemWindows(true);
      }
    }
    for (;;)
    {
      try
      {
        paramBundle.setBackgroundResource(2130838515);
        this.jdField_a_of_type_Int = super.getIntent().getIntExtra("source", 0);
        c();
        i();
        this.jdField_f_of_type_JavaLangString = super.getIntent().getStringExtra("keyword");
        localObject = (HotWordSearchEntryDataModel.HotSearchItem)super.getIntent().getSerializableExtra("home_hot_word");
        if ((localObject != null) && (!TextUtils.isEmpty(((HotWordSearchEntryDataModel.HotSearchItem)localObject).title)))
        {
          jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem = (HotWordSearchEntryDataModel.HotSearchItem)localObject;
          h();
          awwa.a("home_page", "hot_list", new String[] { jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.title, String.valueOf(c()) });
        }
        localObject = getResources().getDisplayMetrics();
        awwa.a("home_page", "active_search", new String[] { "" + a(this.jdField_c_of_type_Int), ((DisplayMetrics)localObject).widthPixels + "*" + ((DisplayMetrics)localObject).heightPixels });
        localObject = new JSONObject();
      }
      catch (Exception localException)
      {
        try
        {
          ((JSONObject)localObject).put("project", awsq.a());
          ((JSONObject)localObject).put("event_src", "client");
          ((JSONObject)localObject).put("experiment_id", awsq.jdField_b_of_type_JavaLangString);
          awsq.a(this.app, new ReportModelDC02528().module("all_result").action("active_search").ver2(awsq.a(this.jdField_c_of_type_Int)).ver7(((JSONObject)localObject).toString()).session_id(this.app.getCurrentAccountUin() + System.currentTimeMillis()));
          if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
            awwa.a("home_page", "exp_home", new String[] { "" + a(this.jdField_c_of_type_Int) });
          }
          Object localObject = super.getSupportFragmentManager();
          this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment = a();
          ((FragmentManager)localObject).beginTransaction().replace(2131367225, this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment).commit();
          jdField_b_of_type_Long = System.currentTimeMillis();
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          if (this.jdField_c_of_type_Int == 12) {
            this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(String.format(getResources().getString(2131696793), new Object[] { sfe.a(this.app, getApplicationContext()) }));
          }
          this.jdField_g_of_type_JavaLangString = akgb.a(this.app);
          if ((!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) && (this.jdField_c_of_type_Int != 12) && (this.jdField_c_of_type_Int != 14) && (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment != null)) {
            this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment.a();
          }
          this.h = true;
          this.jdField_a_of_type_AndroidViewView = paramBundle.findViewById(2131365719);
          this.jdField_b_of_type_AndroidViewView = paramBundle.findViewById(2131362831);
          this.jdField_c_of_type_AndroidViewView = paramBundle.findViewById(2131367225);
          c(4);
          this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.jdField_a_of_type_Int = 50;
          this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(50) });
          this.jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$CancelReceiver = new UniteSearchActivity.CancelReceiver(this);
          paramBundle = new IntentFilter();
          paramBundle.addAction("com.tencent.mobileqq.search.cancel");
          super.registerReceiver(this.jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$CancelReceiver, paramBundle);
          d();
          if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
          {
            if (this.jdField_f_of_type_JavaLangString.length() > 50) {
              this.jdField_f_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString.substring(0, 50);
            }
            if (QLog.isColorLevel()) {
              QLog.i("Q.uniteSearch.UniteSearchActivity", 2, "自动搜索 isViewCreated:" + this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.jdField_a_of_type_Boolean);
            }
            this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.jdField_f_of_type_Boolean = true;
            if (this.jdField_c_of_type_Int == 4) {
              a(6);
            }
            com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
            AbstractGifImage.resumeAll();
            return true;
            jdField_c_of_type_JavaLangString = "";
            break;
            localException = localException;
            QLog.e("Q.uniteSearch.UniteSearchActivity", 1, "doOnCreate, e = " + QLog.getStackTraceString(localException));
            try
            {
              paramBundle.setBackgroundResource(2130848957);
            }
            catch (Error localError)
            {
              QLog.e("Q.uniteSearch.UniteSearchActivity", 1, "doOnCreate, e = " + QLog.getStackTraceString(localError));
            }
          }
        }
        catch (JSONException localJSONException)
        {
          QLog.e("Q.uniteSearch.UniteSearchActivity", 2, "e = " + localJSONException);
          continue;
        }
      }
      try
      {
        paramBundle = (HotWordSearchEntryDataModel.GIFInfo)super.getIntent().getSerializableExtra("home_gif_info");
        if ((this.jdField_c_of_type_Int == 25) && (awhx.a(paramBundle))) {
          continue;
        }
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new UniteSearchActivity.3(this), 500L);
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          paramBundle.printStackTrace();
          paramBundle = null;
        }
      }
    }
  }
  
  /* Error */
  public void doOnDestroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 1048	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$CancelReceiver	Lcom/tencent/mobileqq/search/activity/UniteSearchActivity$CancelReceiver;
    //   4: ifnull +16 -> 20
    //   7: aload_0
    //   8: aload_0
    //   9: getfield 1048	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$CancelReceiver	Lcom/tencent/mobileqq/search/activity/UniteSearchActivity$CancelReceiver;
    //   12: invokespecial 1110	android/support/v4/app/FragmentActivity:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   15: aload_0
    //   16: aconst_null
    //   17: putfield 1048	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$CancelReceiver	Lcom/tencent/mobileqq/search/activity/UniteSearchActivity$CancelReceiver;
    //   20: aload_0
    //   21: getfield 108	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   24: bipush 101
    //   26: invokevirtual 624	android/os/Handler:removeMessages	(I)V
    //   29: aload_0
    //   30: getfield 915	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   33: aconst_null
    //   34: invokevirtual 1113	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   37: aload_0
    //   38: getfield 245	com/tencent/mobileqq/search/activity/UniteSearchActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   41: aload_0
    //   42: getfield 93	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_Akjb	Lakjb;
    //   45: invokevirtual 1116	com/tencent/mobileqq/app/QQAppInterface:removeObserver	(Lajte;)V
    //   48: aload_0
    //   49: getfield 245	com/tencent/mobileqq/search/activity/UniteSearchActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   52: aload_0
    //   53: getfield 98	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_Akiy	Lakiy;
    //   56: invokevirtual 1116	com/tencent/mobileqq/app/QQAppInterface:removeObserver	(Lajte;)V
    //   59: invokestatic 1121	awvt:a	()Lawvt;
    //   62: invokevirtual 1122	awvt:a	()V
    //   65: iconst_m1
    //   66: putstatic 58	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_d_of_type_Int	I
    //   69: aload_0
    //   70: invokevirtual 618	com/tencent/mobileqq/search/activity/UniteSearchActivity:b	()V
    //   73: aload_0
    //   74: getfield 326	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText	Lcom/tencent/mobileqq/search/view/QuickPinyinEditText;
    //   77: iconst_0
    //   78: invokevirtual 1125	com/tencent/mobileqq/search/view/QuickPinyinEditText:setFocusable	(Z)V
    //   81: aload_0
    //   82: getfield 326	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText	Lcom/tencent/mobileqq/search/view/QuickPinyinEditText;
    //   85: iconst_0
    //   86: invokevirtual 1128	com/tencent/mobileqq/search/view/QuickPinyinEditText:setFocusableInTouchMode	(Z)V
    //   89: aload_0
    //   90: getfield 326	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText	Lcom/tencent/mobileqq/search/view/QuickPinyinEditText;
    //   93: bipush 8
    //   95: invokevirtual 1129	com/tencent/mobileqq/search/view/QuickPinyinEditText:setVisibility	(I)V
    //   98: aload_0
    //   99: getfield 326	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText	Lcom/tencent/mobileqq/search/view/QuickPinyinEditText;
    //   102: invokevirtual 1133	com/tencent/mobileqq/search/view/QuickPinyinEditText:getParent	()Landroid/view/ViewParent;
    //   105: ifnull +20 -> 125
    //   108: aload_0
    //   109: getfield 326	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText	Lcom/tencent/mobileqq/search/view/QuickPinyinEditText;
    //   112: invokevirtual 1133	com/tencent/mobileqq/search/view/QuickPinyinEditText:getParent	()Landroid/view/ViewParent;
    //   115: checkcast 1135	android/view/ViewGroup
    //   118: aload_0
    //   119: getfield 326	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText	Lcom/tencent/mobileqq/search/view/QuickPinyinEditText;
    //   122: invokevirtual 1138	android/view/ViewGroup:removeView	(Landroid/view/View;)V
    //   125: aload_0
    //   126: getfield 326	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText	Lcom/tencent/mobileqq/search/view/QuickPinyinEditText;
    //   129: aload_0
    //   130: invokevirtual 607	com/tencent/mobileqq/search/view/QuickPinyinEditText:removeTextChangedListener	(Landroid/text/TextWatcher;)V
    //   133: aload_0
    //   134: getfield 326	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText	Lcom/tencent/mobileqq/search/view/QuickPinyinEditText;
    //   137: aconst_null
    //   138: invokevirtual 405	com/tencent/mobileqq/search/view/QuickPinyinEditText:setOnEditorActionListener	(Landroid/widget/TextView$OnEditorActionListener;)V
    //   141: getstatic 372	android/os/Build$VERSION:SDK_INT	I
    //   144: bipush 23
    //   146: if_icmplt +52 -> 198
    //   149: getstatic 1143	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   152: ldc_w 1145
    //   155: invokevirtual 683	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   158: ifeq +40 -> 198
    //   161: aload_0
    //   162: ldc_w 1147
    //   165: invokestatic 1151	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   168: invokevirtual 1154	com/tencent/mobileqq/search/activity/UniteSearchActivity:getSystemService	(Ljava/lang/Class;)Ljava/lang/Object;
    //   171: astore_1
    //   172: aload_1
    //   173: ifnull +75 -> 248
    //   176: aload_1
    //   177: invokevirtual 1158	java/lang/Object:getClass	()Ljava/lang/Class;
    //   180: ldc_w 1160
    //   183: invokevirtual 1164	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   186: astore_2
    //   187: aload_2
    //   188: iconst_1
    //   189: invokevirtual 1169	java/lang/reflect/Field:setAccessible	(Z)V
    //   192: aload_2
    //   193: aload_1
    //   194: aconst_null
    //   195: invokevirtual 1173	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   198: aconst_null
    //   199: putstatic 1176	awwa:a	Landroid/graphics/Paint;
    //   202: iconst_m1
    //   203: putstatic 68	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_e_of_type_Int	I
    //   206: aload_0
    //   207: getfield 318	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment	Lcom/tencent/mobileqq/search/fragment/GroupSearchFragment;
    //   210: ifnull +10 -> 220
    //   213: aload_0
    //   214: getfield 318	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment	Lcom/tencent/mobileqq/search/fragment/GroupSearchFragment;
    //   217: invokevirtual 1177	com/tencent/mobileqq/search/fragment/GroupSearchFragment:i	()V
    //   220: aload_0
    //   221: invokevirtual 618	com/tencent/mobileqq/search/activity/UniteSearchActivity:b	()V
    //   224: invokestatic 1180	awiw:a	()V
    //   227: aload_0
    //   228: invokespecial 1182	android/support/v4/app/FragmentActivity:doOnDestroy	()V
    //   231: bipush 100
    //   233: putstatic 1072	com/tencent/image/AbstractGifImage$DoAccumulativeRunnable:DELAY	I
    //   236: invokestatic 1185	awtk:a	()V
    //   239: return
    //   240: astore_1
    //   241: aload_1
    //   242: invokevirtual 1105	java/lang/Exception:printStackTrace	()V
    //   245: goto -225 -> 20
    //   248: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   251: ifeq -53 -> 198
    //   254: ldc 234
    //   256: iconst_2
    //   257: ldc_w 1187
    //   260: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   263: goto -65 -> 198
    //   266: astore_1
    //   267: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq -72 -> 198
    //   273: ldc 234
    //   275: iconst_2
    //   276: aload_1
    //   277: invokestatic 1083	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   280: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: goto -85 -> 198
    //   286: astore_1
    //   287: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   290: ifeq -92 -> 198
    //   293: ldc 234
    //   295: iconst_2
    //   296: aload_1
    //   297: invokestatic 1083	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   300: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   303: goto -105 -> 198
    //   306: astore_1
    //   307: ldc 234
    //   309: iconst_1
    //   310: aload_1
    //   311: invokestatic 1083	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   314: invokestatic 255	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   317: goto -86 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	this	UniteSearchActivity
    //   171	23	1	localObject	Object
    //   240	2	1	localException1	Exception
    //   266	11	1	localException2	Exception
    //   286	11	1	localError1	Error
    //   306	5	1	localError2	Error
    //   186	7	2	localField	java.lang.reflect.Field
    // Exception table:
    //   from	to	target	type
    //   0	20	240	java/lang/Exception
    //   69	125	266	java/lang/Exception
    //   125	172	266	java/lang/Exception
    //   176	198	266	java/lang/Exception
    //   248	263	266	java/lang/Exception
    //   69	125	286	java/lang/Error
    //   125	172	286	java/lang/Error
    //   176	198	286	java/lang/Error
    //   248	263	286	java/lang/Error
    //   227	231	306	java/lang/Error
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    jdField_b_of_type_Long = -1L;
    awtk.c();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.a(null);
    }
    awtk.d();
    if (!this.jdField_a_of_type_Boolean) {
      awsq.a(null, new ReportModelDC02528().module("all_result").action("return").ver2(awsq.a(this.jdField_c_of_type_Int)).ver3(jdField_d_of_type_JavaLangString).ver6(jdField_c_of_type_JavaLangString));
    }
    this.jdField_a_of_type_Boolean = false;
    jdField_d_of_type_JavaLangString = "";
  }
  
  public void doOnStart() {}
  
  public void doOnStop()
  {
    super.doOnStop();
    if ((!bbmp.jdField_a_of_type_Boolean) && (bbmp.jdField_f_of_type_Int != 1))
    {
      bbmp.d += (System.nanoTime() - bbmp.c) / 1000000L;
      bbmp.jdField_f_of_type_Long += (System.nanoTime() - bbmp.e) / 1000000L;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.clearFocus();
      ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getWindowToken(), 0);
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.jdField_g_of_type_Boolean))
    {
      this.jdField_g_of_type_Boolean = true;
      axrn.a(BaseApplicationImpl.getApplication()).a(this.app.getCurrentAccountUin(), "GroupSearchLaunchTime", true, System.currentTimeMillis() - jdField_a_of_type_Long, 0L, null, "", false);
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("searchUtils", 2, "cancelType-2 ResultModule:" + awvz.a());
    }
    if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0)) {
      awsq.a(this.app, 0, this.jdField_c_of_type_Int, "0X8009D2A", 0, 0, null, null);
    }
    for (;;)
    {
      awsq.a(this.app, new ReportModelDC02528().module("all_result").action("cancel").ver1(a()).ver2(awsq.a(this.jdField_c_of_type_Int)).ver3(jdField_d_of_type_JavaLangString).ver6(jdField_c_of_type_JavaLangString).session_id(this.app.getCurrentAccountUin() + System.currentTimeMillis()));
      ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getWindowToken(), 0);
      jdField_e_of_type_Int = 0;
      finish();
      return;
      awsq.a(this.app, 0, this.jdField_c_of_type_Int, "0X8009D17", 0, 0, null, null);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Akiz != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "sendAssociationWordRequest use old protocl");
      }
      if (this.jdField_c_of_type_Int == 25) {
        this.jdField_a_of_type_Akiz.a(this.jdField_a_of_type_Awkd.jdField_a_of_type_JavaLangString, 1, true);
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Akiz.a(this.jdField_a_of_type_Awkd.jdField_a_of_type_JavaLangString, 1, false);
      return;
      if (this.jdField_a_of_type_Akix != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "sendAssociationWordRequest use new protocl");
        }
        this.jdField_a_of_type_Akix.a(this.jdField_a_of_type_Awkd.jdField_a_of_type_JavaLangString);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "sendAssociationWordRequest error");
  }
  
  public void finish()
  {
    if (jdField_b_of_type_Boolean) {
      axqy.b(this.app, "CliOper", "", "", "0X8007E2D", "0X8007E2D", 0, jdField_e_of_type_Int, "", "", "", "");
    }
    setResult(-1);
    super.finish();
    overridePendingTransition(0, 2130772307);
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
      if (bbft.d.matcher(paramTextView).matches())
      {
        this.jdField_f_of_type_JavaLangString = paramTextView;
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.performClick();
      }
      if ((TextUtils.isEmpty(paramTextView)) && ((this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getTag() instanceof HotWordSearchEntryDataModel.HotSearchItem)))
      {
        String str = jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.title;
        paramKeyEvent = ((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getTag()).jumpUrl;
        paramTextView = paramKeyEvent;
        if (TextUtils.isEmpty(paramKeyEvent))
        {
          if (this.jdField_c_of_type_Int == 25)
          {
            paramTextView = "kandian_tabword";
            paramTextView = awvx.a(str, 6, paramTextView);
          }
        }
        else
        {
          if (TextUtils.isEmpty(paramTextView)) {
            break label446;
          }
          paramKeyEvent = bbex.a(this.app, this, paramTextView);
          if (paramKeyEvent == null) {
            break label369;
          }
          paramKeyEvent.c();
        }
        label446:
        for (;;)
        {
          awwa.a("all_result", "clk_wording", new String[] { str, String.valueOf(c()) });
          awsq.a(this.app, new ReportModelDC02528().module("hot_list").action("clk_default_word").ver2(awsq.a(this.jdField_c_of_type_Int)).ver4(str).ver7("{experiment_id:" + awsq.jdField_b_of_type_JavaLangString + "}"));
          if ((this.jdField_c_of_type_Int == 25) && (this.jdField_a_of_type_Akiz != null)) {
            this.jdField_a_of_type_Akiz.a(this.app, "clk_default_word", str, awsq.a(25), null);
          }
          awiw.jdField_a_of_type_Boolean = true;
          if ((this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment != null) && (this.jdField_c_of_type_Int == 25))
          {
            ((akgc)((QQAppInterface)onh.a()).getManager(299)).a(str);
            this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchEntryFragment.a();
          }
          return true;
          paramTextView = "hotword";
          break;
          label369:
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
        this.jdField_f_of_type_JavaLangString = paramTextView;
        jdField_b_of_type_JavaLangString = paramTextView;
        if (a(this.jdField_a_of_type_Int, this.jdField_c_of_type_Int)) {}
        b(paramTextView, 1);
        awsq.a(null, new ReportModelDC02528().module("all_result").action("clk_search_button").ver1(paramTextView).ver2(awsq.a(this.jdField_c_of_type_Int)).ver3(jdField_d_of_type_JavaLangString).ver6(jdField_c_of_type_JavaLangString));
      }
      for (;;)
      {
        b();
        return true;
        if ((this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getTag() instanceof HotWordSearchEntryDataModel.HotSearchItem))
        {
          paramTextView = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getHint().toString();
          this.jdField_f_of_type_JavaLangString = paramTextView;
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
    if ((!bbmp.jdField_a_of_type_Boolean) && (bbmp.jdField_f_of_type_Int != 1))
    {
      bbmp.c = System.nanoTime();
      bbmp.e = System.nanoTime();
    }
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.removeTextChangedListener(this);
    }
    super.onRestoreInstanceState(paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
    }
  }
  
  public void onSoftKeyboardClosed()
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setCursorVisible(false);
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setCursorVisible(true);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.UniteSearchActivity
 * JD-Core Version:    0.7.0.1
 */