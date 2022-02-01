package com.tencent.mobileqq.search.activity;

import android.app.Activity;
import android.content.Context;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.logcat.LogcatUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.app.SearchWordHistoryManager;
import com.tencent.mobileqq.app.UnifySearchHandler;
import com.tencent.mobileqq.app.UnifySearchObserver;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.config.business.ReadInjoySearchJumpurlConfBean;
import com.tencent.mobileqq.config.business.ReadInjoySearchJumpurlConfProcessor;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.HotWordSearchEntryModel;
import com.tencent.mobileqq.search.LocationInterface;
import com.tencent.mobileqq.search.SearchEntryConfigManager;
import com.tencent.mobileqq.search.SearchInfoInterface;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.AssociateWordClickCallback;
import com.tencent.mobileqq.search.fragment.GroupSearchFragment;
import com.tencent.mobileqq.search.fragment.searchentry.ISearchEntryFragment;
import com.tencent.mobileqq.search.fragment.searchentry.SearchEntryFragmentFactory;
import com.tencent.mobileqq.search.fragment.searchentry.hippy.SearchEntryHippyEngine;
import com.tencent.mobileqq.search.model.CompleteUrlSpan;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.GIFInfo;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.rich.RichNodeController;
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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ThemeImageWrapper;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class UniteSearchActivity
  extends FragmentActivity
  implements TextWatcher, TextView.OnEditorActionListener, LocationInterface, SearchInfoInterface, AssociateSearchWordsFragment.AssociateWordClickCallback, SoftKeyboardStateHelper.SoftKeyboardStateListener
{
  public static double a;
  public static long a;
  private static UniteSearchActivity jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity = null;
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
  protected Handler a;
  protected FragmentManager a;
  View jdField_a_of_type_AndroidViewView;
  protected Button a;
  protected ImageButton a;
  protected ImageView a;
  UnifySearchHandler jdField_a_of_type_ComTencentMobileqqAppUnifySearchHandler;
  public UnifySearchObserver a;
  UniteSearchHandler jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler;
  public UniteSearchObserver a;
  final UniteSearchActivity.AssociateTask jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$AssociateTask = new UniteSearchActivity.AssociateTask(this);
  protected UniteSearchActivity.CancelReceiver a;
  protected AssociateSearchWordsFragment a;
  protected GroupSearchFragment a;
  protected ISearchEntryFragment a;
  SoftKeyboardStateHelper jdField_a_of_type_ComTencentMobileqqSearchUtilSoftKeyboardStateHelper;
  public QuickPinyinEditText a;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  public boolean a;
  byte[] jdField_a_of_type_ArrayOfByte = null;
  final Handler jdField_b_of_type_AndroidOsHandler = new UniteSearchActivity.10(this);
  View jdField_b_of_type_AndroidViewView;
  protected Button b;
  protected ImageView b;
  public int c;
  View c;
  public boolean e;
  public int f;
  public String f;
  public boolean f;
  private int jdField_g_of_type_Int = -1;
  private String jdField_g_of_type_JavaLangString = null;
  private boolean jdField_g_of_type_Boolean = false;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
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
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_f_of_type_Int = 10000;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver = new UniteSearchActivity.1(this);
    this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchObserver = new UniteSearchActivity.2(this);
    this.jdField_f_of_type_Boolean = false;
  }
  
  private String a(String paramString)
  {
    String str = paramString;
    if (QFileAssistantUtils.a(this.app)) {
      if ((!paramString.equals(getResources().getString(2131698222))) && (!paramString.equalsIgnoreCase(getResources().getString(2131698221))))
      {
        str = paramString;
        if (!paramString.equalsIgnoreCase(getResources().getString(2131698220))) {}
      }
      else
      {
        str = getResources().getString(2131698224);
      }
    }
    return str;
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
      localIntent.putExtra("home_gif_info", paramGIFInfo);
      paramActivity.startActivity(localIntent);
      paramActivity.overridePendingTransition(0, 2130772345);
      jdField_a_of_type_Long = System.currentTimeMillis();
      jdField_b_of_type_Boolean = false;
      SearchUtils.a("search", "tab", "searchbar", 0, 0, new String[] { SearchUtils.a(paramInt1) });
      return;
      ReportController.b(null, "CliOper", "", "", "0X8005021", "0X8005021", paramInt1, 0, "1", "", "", "");
    }
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    jdField_d_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("searchUtils", 2, "fromType:" + paramInt);
    }
    if (paramInt == 12) {
      ReportController.b(null, "CliOper", "", "", "0X8006501", "0X8006501", paramInt, 0, "1", "", "", "");
    }
    for (;;)
    {
      Intent localIntent = new Intent(paramContext, UniteSearchActivity.class);
      localIntent.putExtra("keyword", paramString);
      localIntent.putExtra("fromType", paramInt);
      paramContext.startActivity(localIntent);
      jdField_b_of_type_Boolean = false;
      jdField_a_of_type_Long = System.currentTimeMillis();
      SearchUtils.a("search", "tab", "searchbar", 0, 0, new String[] { SearchUtils.a(paramInt) });
      return;
      ReportController.b(null, "CliOper", "", "", "0X8005021", "0X8005021", paramInt, 0, "1", "", "", "");
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
  
  @NotNull
  private String b()
  {
    switch (this.jdField_c_of_type_Int)
    {
    default: 
      return "kSearchMessageTab";
    case 1: 
      return "kSearchMessageTab";
    case 2: 
      return "kSearchContactTab";
    case 21: 
      return "kSearchDynamicTab";
    }
    return "kSearchReadInJoyTab";
  }
  
  public static void b(Activity paramActivity, String paramString, int paramInt1, int paramInt2)
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
      localIntent.putExtra("requestCode", paramInt2);
      paramActivity.startActivityForResult(localIntent, paramInt2);
      paramActivity.overridePendingTransition(0, 2130772345);
      jdField_a_of_type_Long = System.currentTimeMillis();
      jdField_b_of_type_Boolean = false;
      SearchUtils.a("search", "tab", "searchbar", 0, 0, new String[] { SearchUtils.a(paramInt1) });
      return;
      ReportController.b(null, "CliOper", "", "", "0X8005021", "0X8005021", paramInt1, 0, "1", "", "", "");
    }
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
          UniteSearchReportController.a(null, 0, this.jdField_c_of_type_Int, "0X8009D29", 0, 0, null, null);
          break;
        case 4: 
          if (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag("search_entry_layout") != null) {
            break label212;
          }
        }
      }
      finally {}
      b(paramInt);
      label212:
      if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment != null)
      {
        localObject2.show(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment.getFragment());
        localObject2.commitAllowingStateLoss();
      }
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
  
  private boolean c()
  {
    Object localObject1 = a(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString().trim());
    LogcatUtil.a((String)localObject1);
    boolean bool;
    if ("cmd:hippyDebug".equals(localObject1))
    {
      if (!SearchEntryHippyEngine.isHippyDebug())
      {
        bool = true;
        if (!bool) {
          break label67;
        }
        QQToast.a(this, "切换为调试模式成功，请退出重进", 0).a();
      }
      for (;;)
      {
        SearchEntryHippyEngine.setHippyDebug(bool);
        return true;
        bool = false;
        break;
        label67:
        QQToast.a(this, "切换为非调试模式成功，请退出重进", 0).a();
      }
    }
    if ("cmd:hippyOn".equals(localObject1))
    {
      if (!SearchEntryHippyEngine.iscmdHippyOn())
      {
        bool = true;
        if (!bool) {
          break label127;
        }
        QQToast.a(this, "切换为hippy成功，请退出重进", 0).a();
      }
      for (;;)
      {
        SearchEntryHippyEngine.setcmdHippyOn(bool);
        return true;
        bool = false;
        break;
        label127:
        QQToast.a(this, "切换为native成功，请退出重进", 0).a();
      }
    }
    if (Patterns.d.matcher((CharSequence)localObject1).matches())
    {
      this.jdField_f_of_type_JavaLangString = ((String)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.performClick();
    }
    if ((TextUtils.isEmpty((CharSequence)localObject1)) && ((this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getTag() instanceof HotWordSearchEntryDataModel.HotSearchItem)))
    {
      String str = jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.recallWord;
      Object localObject2 = ((HotWordSearchEntryDataModel.HotSearchItem)this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getTag()).jumpUrl;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        if ((this.jdField_c_of_type_Int == 25) || (this.jdField_c_of_type_Int == 26))
        {
          localObject1 = "kandian_tabword";
          localObject1 = SearchConfigUtils.a(str, 6, (String)localObject1);
        }
      }
      else
      {
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label587;
        }
        localObject2 = JumpParser.a(this.app, this, (String)localObject1);
        if (localObject2 == null) {
          break label492;
        }
        ((JumpAction)localObject2).a();
      }
      label587:
      for (;;)
      {
        SearchUtils.a("all_result", "clk_wording", new String[] { str, String.valueOf(c()) });
        UniteSearchReportController.a(this.app, new ReportModelDC02528().module("hot_list").action("clk_default_word").ver2(UniteSearchReportController.a(this.jdField_c_of_type_Int)).ver4(str).ver7("{experiment_id:" + UniteSearchReportController.jdField_b_of_type_JavaLangString + "}"));
        if (((this.jdField_c_of_type_Int == 25) || (this.jdField_c_of_type_Int == 26)) && (this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler != null)) {
          this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler.a(this.app, "clk_default_word", str, UniteSearchReportController.a(this.jdField_c_of_type_Int), null);
        }
        com.tencent.mobileqq.search.SearchUtil.jdField_a_of_type_Boolean = true;
        if ((this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment != null) && ((this.jdField_c_of_type_Int == 25) || (this.jdField_c_of_type_Int == 26)))
        {
          ((SearchWordHistoryManager)((QQAppInterface)ReadInJoyUtils.a()).getManager(QQManagerFactory.SEARCH_WORD_HISTORY_MANAGER)).a(str);
          this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment.refresh();
        }
        return true;
        localObject1 = "hotword";
        break;
        label492:
        if (SearchUtils.d((String)localObject1))
        {
          SearchUtils.a(this, str, (String)localObject1);
        }
        else if ((((String)localObject1).startsWith("http://")) || (((String)localObject1).startsWith("https://")))
        {
          localObject2 = new Intent(this, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", (String)localObject1);
          ((Intent)localObject2).putExtra("search_title", str);
          startActivity((Intent)localObject2);
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
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.jdField_f_of_type_JavaLangString = ((String)localObject1);
      jdField_b_of_type_JavaLangString = (String)localObject1;
      if (a(this.jdField_a_of_type_Int, this.jdField_c_of_type_Int)) {}
      b((String)localObject1, 1);
      UniteSearchReportController.a(null, new ReportModelDC02528().module("all_result").action("clk_search_button").ver1((String)localObject1).ver2(UniteSearchReportController.a(this.jdField_c_of_type_Int)).ver3(jdField_d_of_type_JavaLangString).ver6(jdField_c_of_type_JavaLangString));
    }
    for (;;)
    {
      b();
      return false;
      if ((this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getTag() instanceof HotWordSearchEntryDataModel.HotSearchItem))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getHint().toString();
        this.jdField_f_of_type_JavaLangString = ((String)localObject1);
        jdField_b_of_type_JavaLangString = (String)localObject1;
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText((CharSequence)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(((String)localObject1).length());
      }
    }
  }
  
  private void i()
  {
    this.jdField_a_of_type_ArrayOfByte = null;
    if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(4);
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.d();
  }
  
  private void j()
  {
    if (this.jdField_b_of_type_AndroidWidgetButton != null)
    {
      if ((TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) && (!(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getTag() instanceof HotWordSearchEntryDataModel.HotSearchItem))) {
        this.jdField_b_of_type_AndroidWidgetButton.setAlpha(0.4F);
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetButton.setAlpha(1.0F);
  }
  
  private void k()
  {
    a(SearchEntryConfigManager.a(this.app));
  }
  
  private void l()
  {
    int j = -1;
    Object localObject = Aladdin.getConfig(313);
    if (localObject != null) {
      j = ((AladdinConfig)localObject).getIntegerFromString("SearchBox_SearchStyle", -1);
    }
    if ((j == 1) && ((this.jdField_c_of_type_Int == 25) || (this.jdField_c_of_type_Int == 26)))
    {
      super.findViewById(2131377583).setVisibility(8);
      localObject = super.findViewById(2131377584);
      ((View)localObject).setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText = ((QuickPinyinEditText)super.findViewById(2131366453));
      this.jdField_a_of_type_ComTencentMobileqqSearchUtilSoftKeyboardStateHelper = new SoftKeyboardStateHelper(super.findViewById(2131377356));
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(SearchEntryConfigManager.b());
      k();
      if (Build.VERSION.SDK_INT >= 26) {}
      try
      {
        View.class.getMethod("setImportantForAutofill", new Class[] { Integer.TYPE }).invoke(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText, new Object[] { Integer.valueOf(8) });
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setImeOptions(3);
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setOnEditorActionListener(this);
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
        jdField_d_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqSearchUtilSoftKeyboardStateHelper.a(this);
        this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)super.findViewById(2131368601));
        this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new UniteSearchActivity.4(this));
        this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131364128));
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new UniteSearchActivity.5(this));
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131369581));
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new UniteSearchActivity.6(this));
        if (ThemeImageWrapper.isNightMode())
        {
          ((View)localObject).setAlpha(0.4F);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846333);
        }
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getInputExtras(true).putInt("QUICK_SEARCH", 1);
        return;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          QLog.w("Q.uniteSearch.UniteSearchActivity", 2, "disable auto fill error", localException2);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText = ((QuickPinyinEditText)super.findViewById(2131366452));
    this.jdField_a_of_type_ComTencentMobileqqSearchUtilSoftKeyboardStateHelper = new SoftKeyboardStateHelper(super.findViewById(2131377356));
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(SearchEntryConfigManager.b());
    if ((this.jdField_c_of_type_Int == 25) || (this.jdField_c_of_type_Int == 26)) {
      k();
    }
    if (Build.VERSION.SDK_INT >= 26) {}
    try
    {
      View.class.getMethod("setImportantForAutofill", new Class[] { Integer.TYPE }).invoke(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText, new Object[] { Integer.valueOf(8) });
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setImeOptions(3);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setOnEditorActionListener(this);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
      jdField_d_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqSearchUtilSoftKeyboardStateHelper.a(this);
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)super.findViewById(2131368600));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new UniteSearchActivity.7(this));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131363942));
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131690800);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new UniteSearchActivity.8(this));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131369579));
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new UniteSearchActivity.9(this));
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getInputExtras(true).putInt("QUICK_SEARCH", 1);
      return;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        QLog.w("Q.uniteSearch.UniteSearchActivity", 2, "disable auto fill error", localException1);
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
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    i();
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
      UniteSearchReportController.a(null, new ReportModelDC02528().module("all_result").action("clk_thinkword_list").ver1(a()).ver2(UniteSearchReportController.a(this.jdField_c_of_type_Int)).ver3(jdField_d_of_type_JavaLangString).ver6(jdField_c_of_type_JavaLangString).ver7("{\"clk_index\":" + (paramInt - 1) + ",\"experiment_id\":" + UniteSearchReportController.jdField_b_of_type_JavaLangString + "}").ver4(paramString));
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.removeTextChangedListener(this);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(paramString);
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      j();
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
    this.jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$AssociateTask.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$AssociateTask.jdField_a_of_type_Long = (System.currentTimeMillis() + paramLong);
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
      localSpannableStringBuilder.setSpan(new UniteSearchActivity.11(this), 0, paramString.length(), 33);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setMovementMethod(LinkMovementMethod.getInstance());
      if (paramBoolean1) {
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(localSpannableStringBuilder);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(paramString.length());
        label98:
        if (this.jdField_c_of_type_Int != 26) {
          break;
        }
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new UniteSearchActivity.12(this), 500L);
        return;
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.removeTextChangedListener(this);
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(localSpannableStringBuilder);
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
        j();
        i();
        c(4);
      }
    }
    if (paramBoolean1) {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(paramString);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(paramString.length());
      break label98;
      break;
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.removeTextChangedListener(this);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(paramString);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(2131718908);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.title);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setTag(jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setCursorVisible(true);
    }
    for (;;)
    {
      j();
      return;
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(2131718908);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setTag("");
    }
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
    if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment.afterTextChanged(paramEditable);
    }
    paramEditable = a(a(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText, this.i, this.jdField_a_of_type_JavaLangCharSequence));
    if ((this.i) && (paramEditable.equals(this.jdField_f_of_type_JavaLangString))) {}
    do
    {
      return;
      boolean bool = a(this.jdField_a_of_type_Int, this.jdField_c_of_type_Int);
      if ((!bool) && (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.jdField_c_of_type_Int != 6)) {
        this.jdField_f_of_type_Boolean = true;
      }
      if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.jdField_c_of_type_Int != 6)) {
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
      SearchUtils.a("home_page", "exp_home", new String[] { "" + a(this.jdField_c_of_type_Int) });
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      i();
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.e();
      j();
      if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment != null) {
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.a(null);
      }
      if (jdField_c_of_type_Boolean)
      {
        jdField_c_of_type_Boolean = false;
        if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment != null) {
          this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment.refresh();
        }
      }
      b(true);
    }
    for (;;)
    {
      if (!paramEditable.equals(this.jdField_f_of_type_JavaLangString))
      {
        SearchUtils.jdField_b_of_type_Long = 0L;
        jdField_e_of_type_Int = 2;
      }
      if (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {
        b(TextUtils.isEmpty(paramEditable));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment.a(null);
      return;
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      j();
      if ((this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment != null) && (this.jdField_c_of_type_Int != 25) && (this.jdField_c_of_type_Int != 26))
      {
        a(paramEditable);
        b(false);
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
    return 2131563181;
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
      } while (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment != null);
      String str = b();
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment = SearchEntryFragmentFactory.create(str);
      UniteSearchReportController.a(this.app, new ReportModelDC02528().module("all_result").action("exp_entryweb").ver2(UniteSearchReportController.a(this.jdField_c_of_type_Int)).session_id(this.app.getCurrentAccountUin() + System.currentTimeMillis()));
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment.setApp(this.app);
      Bundle localBundle = new Bundle(9);
      localBundle.putInt("from", this.jdField_c_of_type_Int);
      localBundle.putInt("source", this.jdField_a_of_type_Int);
      localBundle.putString("tabType", str);
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment.setInitData(localBundle);
      localFragmentTransaction.add(2131366399, this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment.getFragment(), "search_entry_layout");
      localFragmentTransaction.commitAllowingStateLoss();
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment == null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment = new AssociateSearchWordsFragment();
    }
    localFragmentTransaction.add(2131363071, this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment, "associated_words");
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  public void b(String paramString, int paramInt)
  {
    String str2 = ReadInjoySearchJumpurlConfProcessor.a().jdField_c_of_type_JavaLangString;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "https://sou.qq.com/kandian/kd.html?_bid=3216&_wv=3&_wwv=1293&_wvSb=0&keyword=$KEYWORD$&from=$FROM$";
    }
    str1 = str1.replace("$KEYWORD$", URLEncoder.encode(this.jdField_f_of_type_JavaLangString));
    if ((this.jdField_c_of_type_Int == 25) || (this.jdField_c_of_type_Int == 26)) {
      if (paramInt == 2)
      {
        str1 = str1.replace("$FROM$", "kandian_thinkword");
        str1 = str1.replace("$SEARCHID$", "" + URLEncoder.encode(jdField_c_of_type_JavaLangString)).replace("$SEQNO$", "" + URLEncoder.encode(jdField_d_of_type_JavaLangString));
        SearchUtils.a(this.app, this, str1, this.jdField_f_of_type_Int);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment != null) && ((TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment.getInitData().getString("tabType"), "kSearchDynamicTab")) || (this.jdField_c_of_type_Int == 25) || (this.jdField_c_of_type_Int == 26)))
      {
        ((SearchWordHistoryManager)((QQAppInterface)ReadInJoyUtils.a()).getManager(QQManagerFactory.SEARCH_WORD_HISTORY_MANAGER)).a(paramString);
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment.refresh();
      }
      return;
      str1 = str1.replace("$FROM$", "kandian_search");
      break;
      i();
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      a(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.b(paramString);
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(null);
      c(1);
    }
  }
  
  void b(boolean paramBoolean)
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
  
  public boolean b()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = false;
    if ((TextUtils.isEmpty(paramCharSequence)) && (paramInt1 == 0) && (paramInt2 == 0) && (this.jdField_h_of_type_Boolean))
    {
      this.jdField_h_of_type_Boolean = false;
      SQLiteFTSUtils.FtsItemClickEvent.a();
      SQLiteFTSUtils.FtsItemClickEvent.c = System.nanoTime();
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
    case 22: 
    case 23: 
    case 24: 
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
      this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler = ((UniteSearchHandler)this.app.getBusinessHandler(BusinessHandlerFactory.UNITE_SEARCH_HANDLER));
      this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchHandler = null;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler = null;
    this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchHandler = ((UnifySearchHandler)this.app.getBusinessHandler(BusinessHandlerFactory.UNIFY_SEARCH_UNITE_HANDLER));
  }
  
  public void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_f_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(paramString);
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      j();
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "onAssociateWordClick keyword = " + paramString);
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(paramString.length());
    }
  }
  
  protected void d()
  {
    int j = b(this.jdField_c_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "getUniteSearchDiscovery use old protocl");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler.a(this.app, j);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchHandler != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "getUniteSearchDiscovery use new protocl");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchHandler.a(this.app, j);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "getUniteSearchDiscovery error");
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_h_of_type_Int = paramInt1;
    if ((this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.jdField_c_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.jdField_c_of_type_JavaUtilList.size() > 0)) {
      b();
    }
    if (paramInt1 == 1300) {
      if ((-1 == paramInt2) && (paramIntent != null))
      {
        paramIntent = paramIntent.getStringExtra("roomId");
        if (paramIntent != null)
        {
          TroopUtils.a(this, paramIntent, true);
          ReportController.b(this.app, "CliOper", "", "", "0X8006360", "0X8006360", 0, 0, "", "", "", "");
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
    if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment.refresh();
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText("");
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    UniteSearchReportController.a(this.app, new ReportModelDC02528().module("all_result").action("return").ver1(a()).ver2(UniteSearchReportController.a(this.jdField_c_of_type_Int)).ver3(jdField_d_of_type_JavaLangString).ver6(jdField_c_of_type_JavaLangString).session_id(this.app.getCurrentAccountUin() + System.currentTimeMillis()));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_c_of_type_Int = super.getIntent().getIntExtra("fromType", -1);
    if (this.jdField_c_of_type_Int != 26)
    {
      if (jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity != null)
      {
        paramBundle = jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity;
        jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity = this;
        paramBundle.finish();
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidOsHandler = new Handler();
      this.jdField_h_of_type_Int = super.getIntent().getIntExtra("requestCode", 0);
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver);
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchObserver);
      jdField_e_of_type_Int = -1;
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = super.getSupportFragmentManager();
      int j = b(this.jdField_c_of_type_Int);
      if (j == -1) {
        break label951;
      }
      jdField_c_of_type_JavaLangString = j + "_" + this.app.getAccount() + "_" + System.currentTimeMillis();
      label166:
      setContentView(b());
      paramBundle = super.findViewById(2131377356);
      if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
        paramBundle.setFitsSystemWindows(true);
      }
    }
    for (;;)
    {
      try
      {
        paramBundle.setBackgroundResource(2130838980);
        this.jdField_a_of_type_Int = super.getIntent().getIntExtra("source", 0);
        c();
        l();
        this.jdField_f_of_type_JavaLangString = super.getIntent().getStringExtra("keyword");
        localObject = (HotWordSearchEntryDataModel.HotSearchItem)super.getIntent().getSerializableExtra("home_hot_word");
        if ((localObject != null) && (!TextUtils.isEmpty(((HotWordSearchEntryDataModel.HotSearchItem)localObject).title)))
        {
          jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem = (HotWordSearchEntryDataModel.HotSearchItem)localObject;
          k();
          SearchUtils.a("home_page", "hot_list", new String[] { jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.title, String.valueOf(c()) });
        }
        localObject = getResources().getDisplayMetrics();
        SearchUtils.a("home_page", "active_search", new String[] { "" + a(this.jdField_c_of_type_Int), ((DisplayMetrics)localObject).widthPixels + "*" + ((DisplayMetrics)localObject).heightPixels });
        localObject = new JSONObject();
      }
      catch (Exception localException)
      {
        try
        {
          ((JSONObject)localObject).put("project", UniteSearchReportController.a());
          ((JSONObject)localObject).put("event_src", "client");
          ((JSONObject)localObject).put("experiment_id", UniteSearchReportController.jdField_b_of_type_JavaLangString);
          UniteSearchReportController.a(this.app, new ReportModelDC02528().module("all_result").action("active_search").ver2(UniteSearchReportController.a(this.jdField_c_of_type_Int)).ver7(((JSONObject)localObject).toString()).session_id(this.app.getCurrentAccountUin() + System.currentTimeMillis()));
          if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
            SearchUtils.a("home_page", "exp_home", new String[] { "" + a(this.jdField_c_of_type_Int) });
          }
          Object localObject = super.getSupportFragmentManager();
          this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment = a();
          ((FragmentManager)localObject).beginTransaction().replace(2131368118, this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment).commit();
          jdField_b_of_type_Long = System.currentTimeMillis();
          if (this.jdField_c_of_type_Int == 12) {
            this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(String.format(getResources().getString(2131696487), new Object[] { ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.app, getApplicationContext()) }));
          }
          this.jdField_g_of_type_JavaLangString = SearchHistoryManager.a(this.app);
          if ((!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) && (this.jdField_c_of_type_Int != 12) && (this.jdField_c_of_type_Int != 14) && (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment != null)) {
            this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment.refresh();
          }
          this.jdField_h_of_type_Boolean = true;
          this.jdField_a_of_type_AndroidViewView = paramBundle.findViewById(2131366399);
          this.jdField_b_of_type_AndroidViewView = paramBundle.findViewById(2131363071);
          this.jdField_c_of_type_AndroidViewView = paramBundle.findViewById(2131368118);
          if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
          {
            c(4);
            j();
            this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.jdField_a_of_type_Int = 50;
            this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(50) });
            this.jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$CancelReceiver = new UniteSearchActivity.CancelReceiver(this);
            paramBundle = new IntentFilter();
            paramBundle.addAction("com.tencent.mobileqq.search.cancel");
            super.registerReceiver(this.jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$CancelReceiver, paramBundle);
            d();
            if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
              break label1075;
            }
            if (this.jdField_f_of_type_JavaLangString.length() > 50) {
              this.jdField_f_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString.substring(0, 50);
            }
            if (QLog.isColorLevel()) {
              QLog.i("Q.uniteSearch.UniteSearchActivity", 2, "自动搜索 isViewCreated:" + this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.jdField_a_of_type_Boolean);
            }
            this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.jdField_g_of_type_Boolean = true;
            if (this.jdField_c_of_type_Int == 4) {
              a(6);
            }
            com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
            AbstractGifImage.resumeAll();
            return true;
            jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity = this;
            break;
            label951:
            jdField_c_of_type_JavaLangString = "";
            break label166;
            localException = localException;
            QLog.e("Q.uniteSearch.UniteSearchActivity", 1, "doOnCreate, e = " + QLog.getStackTraceString(localException));
            try
            {
              paramBundle.setBackgroundResource(2130850432);
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
          c(3);
          continue;
        }
      }
      try
      {
        label1075:
        paramBundle = (HotWordSearchEntryDataModel.GIFInfo)super.getIntent().getSerializableExtra("home_gif_info");
        if ((this.jdField_c_of_type_Int == 25) && (HotWordSearchEntryModel.a(paramBundle))) {
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
    //   0: getstatic 55	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity	Lcom/tencent/mobileqq/search/activity/UniteSearchActivity;
    //   3: aload_0
    //   4: if_acmpne +7 -> 11
    //   7: aconst_null
    //   8: putstatic 55	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity	Lcom/tencent/mobileqq/search/activity/UniteSearchActivity;
    //   11: aload_0
    //   12: getfield 1334	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$CancelReceiver	Lcom/tencent/mobileqq/search/activity/UniteSearchActivity$CancelReceiver;
    //   15: ifnull +16 -> 31
    //   18: aload_0
    //   19: aload_0
    //   20: getfield 1334	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$CancelReceiver	Lcom/tencent/mobileqq/search/activity/UniteSearchActivity$CancelReceiver;
    //   23: invokespecial 1390	android/support/v4/app/FragmentActivity:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   26: aload_0
    //   27: aconst_null
    //   28: putfield 1334	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$CancelReceiver	Lcom/tencent/mobileqq/search/activity/UniteSearchActivity$CancelReceiver;
    //   31: aload_0
    //   32: getfield 117	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   35: bipush 101
    //   37: invokevirtual 890	android/os/Handler:removeMessages	(I)V
    //   40: aload_0
    //   41: getfield 924	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   44: aconst_null
    //   45: invokevirtual 1393	android/os/Handler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   48: aload_0
    //   49: getfield 124	com/tencent/mobileqq/search/activity/UniteSearchActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   52: aload_0
    //   53: getfield 98	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver	Lcom/tencent/mobileqq/app/UniteSearchObserver;
    //   56: invokevirtual 1396	com/tencent/mobileqq/app/QQAppInterface:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   59: aload_0
    //   60: getfield 124	com/tencent/mobileqq/search/activity/UniteSearchActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   63: aload_0
    //   64: getfield 103	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqAppUnifySearchObserver	Lcom/tencent/mobileqq/app/UnifySearchObserver;
    //   67: invokevirtual 1396	com/tencent/mobileqq/app/QQAppInterface:removeObserver	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   70: invokestatic 1401	com/tencent/mobileqq/search/util/PAOfflineSearchManager:a	()Lcom/tencent/mobileqq/search/util/PAOfflineSearchManager;
    //   73: invokevirtual 1402	com/tencent/mobileqq/search/util/PAOfflineSearchManager:a	()V
    //   76: iconst_m1
    //   77: putstatic 61	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_d_of_type_Int	I
    //   80: aload_0
    //   81: invokevirtual 602	com/tencent/mobileqq/search/activity/UniteSearchActivity:b	()V
    //   84: aload_0
    //   85: getfield 373	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText	Lcom/tencent/mobileqq/search/view/QuickPinyinEditText;
    //   88: iconst_0
    //   89: invokevirtual 1405	com/tencent/mobileqq/search/view/QuickPinyinEditText:setFocusable	(Z)V
    //   92: aload_0
    //   93: getfield 373	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText	Lcom/tencent/mobileqq/search/view/QuickPinyinEditText;
    //   96: iconst_0
    //   97: invokevirtual 1408	com/tencent/mobileqq/search/view/QuickPinyinEditText:setFocusableInTouchMode	(Z)V
    //   100: aload_0
    //   101: getfield 373	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText	Lcom/tencent/mobileqq/search/view/QuickPinyinEditText;
    //   104: bipush 8
    //   106: invokevirtual 1409	com/tencent/mobileqq/search/view/QuickPinyinEditText:setVisibility	(I)V
    //   109: aload_0
    //   110: getfield 373	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText	Lcom/tencent/mobileqq/search/view/QuickPinyinEditText;
    //   113: invokevirtual 1413	com/tencent/mobileqq/search/view/QuickPinyinEditText:getParent	()Landroid/view/ViewParent;
    //   116: ifnull +20 -> 136
    //   119: aload_0
    //   120: getfield 373	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText	Lcom/tencent/mobileqq/search/view/QuickPinyinEditText;
    //   123: invokevirtual 1413	com/tencent/mobileqq/search/view/QuickPinyinEditText:getParent	()Landroid/view/ViewParent;
    //   126: checkcast 1415	android/view/ViewGroup
    //   129: aload_0
    //   130: getfield 373	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText	Lcom/tencent/mobileqq/search/view/QuickPinyinEditText;
    //   133: invokevirtual 1418	android/view/ViewGroup:removeView	(Landroid/view/View;)V
    //   136: aload_0
    //   137: getfield 373	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText	Lcom/tencent/mobileqq/search/view/QuickPinyinEditText;
    //   140: aload_0
    //   141: invokevirtual 879	com/tencent/mobileqq/search/view/QuickPinyinEditText:removeTextChangedListener	(Landroid/text/TextWatcher;)V
    //   144: aload_0
    //   145: getfield 373	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText	Lcom/tencent/mobileqq/search/view/QuickPinyinEditText;
    //   148: aconst_null
    //   149: invokevirtual 715	com/tencent/mobileqq/search/view/QuickPinyinEditText:setOnEditorActionListener	(Landroid/widget/TextView$OnEditorActionListener;)V
    //   152: getstatic 685	android/os/Build$VERSION:SDK_INT	I
    //   155: bipush 23
    //   157: if_icmplt +52 -> 209
    //   160: getstatic 1423	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   163: ldc_w 1425
    //   166: invokevirtual 146	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   169: ifeq +40 -> 209
    //   172: aload_0
    //   173: ldc_w 1427
    //   176: invokestatic 1431	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   179: invokevirtual 1434	com/tencent/mobileqq/search/activity/UniteSearchActivity:getSystemService	(Ljava/lang/Class;)Ljava/lang/Object;
    //   182: astore_1
    //   183: aload_1
    //   184: ifnull +75 -> 259
    //   187: aload_1
    //   188: invokevirtual 1438	java/lang/Object:getClass	()Ljava/lang/Class;
    //   191: ldc_w 1440
    //   194: invokevirtual 1444	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   197: astore_2
    //   198: aload_2
    //   199: iconst_1
    //   200: invokevirtual 1449	java/lang/reflect/Field:setAccessible	(Z)V
    //   203: aload_2
    //   204: aload_1
    //   205: aconst_null
    //   206: invokevirtual 1453	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   209: aconst_null
    //   210: putstatic 1456	com/tencent/mobileqq/search/util/SearchUtils:a	Landroid/graphics/Paint;
    //   213: iconst_m1
    //   214: putstatic 71	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_e_of_type_Int	I
    //   217: aload_0
    //   218: getfield 621	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment	Lcom/tencent/mobileqq/search/fragment/GroupSearchFragment;
    //   221: ifnull +10 -> 231
    //   224: aload_0
    //   225: getfield 621	com/tencent/mobileqq/search/activity/UniteSearchActivity:jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment	Lcom/tencent/mobileqq/search/fragment/GroupSearchFragment;
    //   228: invokevirtual 1457	com/tencent/mobileqq/search/fragment/GroupSearchFragment:i	()V
    //   231: aload_0
    //   232: invokevirtual 602	com/tencent/mobileqq/search/activity/UniteSearchActivity:b	()V
    //   235: invokestatic 1458	com/tencent/mobileqq/search/SearchUtil:a	()V
    //   238: aload_0
    //   239: invokespecial 1460	android/support/v4/app/FragmentActivity:doOnDestroy	()V
    //   242: bipush 100
    //   244: putstatic 1358	com/tencent/image/AbstractGifImage$DoAccumulativeRunnable:DELAY	I
    //   247: invokestatic 1463	com/tencent/mobileqq/search/rich/RichNodeController:a	()V
    //   250: return
    //   251: astore_1
    //   252: aload_1
    //   253: invokevirtual 1385	java/lang/Exception:printStackTrace	()V
    //   256: goto -225 -> 31
    //   259: invokestatic 167	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   262: ifeq -53 -> 209
    //   265: ldc_w 276
    //   268: iconst_2
    //   269: ldc_w 1465
    //   272: invokestatic 188	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   275: goto -66 -> 209
    //   278: astore_1
    //   279: invokestatic 167	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq -73 -> 209
    //   285: ldc_w 276
    //   288: iconst_2
    //   289: aload_1
    //   290: invokestatic 1369	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   293: invokestatic 188	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   296: goto -87 -> 209
    //   299: astore_1
    //   300: invokestatic 167	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   303: ifeq -94 -> 209
    //   306: ldc_w 276
    //   309: iconst_2
    //   310: aload_1
    //   311: invokestatic 1369	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   314: invokestatic 188	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   317: goto -108 -> 209
    //   320: astore_1
    //   321: ldc_w 276
    //   324: iconst_1
    //   325: aload_1
    //   326: invokestatic 1369	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   329: invokestatic 312	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   332: goto -90 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	335	0	this	UniteSearchActivity
    //   182	23	1	localObject	Object
    //   251	2	1	localException1	Exception
    //   278	12	1	localException2	Exception
    //   299	12	1	localError1	Error
    //   320	6	1	localError2	Error
    //   197	7	2	localField	java.lang.reflect.Field
    // Exception table:
    //   from	to	target	type
    //   11	31	251	java/lang/Exception
    //   80	136	278	java/lang/Exception
    //   136	183	278	java/lang/Exception
    //   187	209	278	java/lang/Exception
    //   259	275	278	java/lang/Exception
    //   80	136	299	java/lang/Error
    //   136	183	299	java/lang/Error
    //   187	209	299	java/lang/Error
    //   259	275	299	java/lang/Error
    //   238	242	320	java/lang/Error
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    jdField_b_of_type_Long = -1L;
    RichNodeController.c();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    RichNodeController.d();
    if (!this.jdField_a_of_type_Boolean) {
      UniteSearchReportController.a(null, new ReportModelDC02528().module("all_result").action("return").ver2(UniteSearchReportController.a(this.jdField_c_of_type_Int)).ver3(jdField_d_of_type_JavaLangString).ver6(jdField_c_of_type_JavaLangString));
    }
    this.jdField_a_of_type_Boolean = false;
    jdField_d_of_type_JavaLangString = "";
  }
  
  public void doOnStart() {}
  
  public void doOnStop()
  {
    super.doOnStop();
    if ((!SQLiteFTSUtils.FtsItemClickEvent.jdField_a_of_type_Boolean) && (SQLiteFTSUtils.FtsItemClickEvent.jdField_f_of_type_Int != 1))
    {
      SQLiteFTSUtils.FtsItemClickEvent.d += (System.nanoTime() - SQLiteFTSUtils.FtsItemClickEvent.c) / 1000000L;
      SQLiteFTSUtils.FtsItemClickEvent.jdField_f_of_type_Long += (System.nanoTime() - SQLiteFTSUtils.FtsItemClickEvent.e) / 1000000L;
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
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(this.app.getCurrentAccountUin(), "GroupSearchLaunchTime", true, System.currentTimeMillis() - jdField_a_of_type_Long, 0L, null, "", false);
    }
  }
  
  public void e()
  {
    UniteSearchReportController.a(null, new ReportModelDC02528().module("search_box_bt_homepage").action("clk_search_box_bt").ver2("kandian").session_id(this.app.getCurrentAccountUin()));
    new UniteSearchHandler(this.app).b(this.app, "clk_search_box_bt", "search_box_bt_homepage", "kandian", "", "", "");
  }
  
  public void f()
  {
    UniteSearchReportController.a(null, new ReportModelDC02528().module("search_box_back").action("clk_search_box_back").ver2("kandian").session_id(this.app.getCurrentAccountUin()));
    new UniteSearchHandler(this.app).b(this.app, "clk_search_box_back", "search_box_back", "kandian", "", "", "");
  }
  
  public void finish()
  {
    if (jdField_b_of_type_Boolean) {
      ReportController.b(this.app, "CliOper", "", "", "0X8007E2D", "0X8007E2D", 0, jdField_e_of_type_Int, "", "", "", "");
    }
    setResult(-1, getIntent());
    super.finish();
    overridePendingTransition(0, 2130772345);
  }
  
  protected void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("searchUtils", 2, "cancelType-2 ResultModule:" + SearchStatisticsConstants.a());
    }
    if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0)) {
      UniteSearchReportController.a(this.app, 0, this.jdField_c_of_type_Int, "0X8009D2A", 0, 0, null, null);
    }
    for (;;)
    {
      UniteSearchReportController.a(this.app, new ReportModelDC02528().module("all_result").action("cancel").ver1(a()).ver2(UniteSearchReportController.a(this.jdField_c_of_type_Int)).ver3(jdField_d_of_type_JavaLangString).ver6(jdField_c_of_type_JavaLangString).session_id(this.app.getCurrentAccountUin() + System.currentTimeMillis()));
      ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getWindowToken(), 0);
      jdField_e_of_type_Int = 0;
      getIntent().putExtra("keyword", this.jdField_f_of_type_JavaLangString);
      finish();
      return;
      UniteSearchReportController.a(this.app, 0, this.jdField_c_of_type_Int, "0X8009D17", 0, 0, null, null);
    }
  }
  
  protected void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "sendAssociationWordRequest use old protocl");
      }
      if ((this.jdField_c_of_type_Int == 25) || (this.jdField_c_of_type_Int == 26)) {
        this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler.a(this.jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$AssociateTask.jdField_a_of_type_JavaLangString, 1, true);
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler.a(this.jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$AssociateTask.jdField_a_of_type_JavaLangString, 1, false);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchHandler != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "sendAssociationWordRequest use new protocl");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchHandler.a(this.jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$AssociateTask.jdField_a_of_type_JavaLangString);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "sendAssociationWordRequest error");
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 3) || ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66)))
    {
      if ((paramKeyEvent != null) && (paramKeyEvent.getAction() != 1)) {}
      while (!c()) {
        return true;
      }
      return true;
    }
    return false;
  }
  
  protected void onRestart()
  {
    super.onRestart();
    if ((this.jdField_c_of_type_Int == 25) || (this.jdField_c_of_type_Int == 26)) {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText("");
    }
    if ((!SQLiteFTSUtils.FtsItemClickEvent.jdField_a_of_type_Boolean) && (SQLiteFTSUtils.FtsItemClickEvent.jdField_f_of_type_Int != 1))
    {
      SQLiteFTSUtils.FtsItemClickEvent.c = System.nanoTime();
      SQLiteFTSUtils.FtsItemClickEvent.e = System.nanoTime();
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
    if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment.onSoftKeyboardClosed();
    }
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setCursorVisible(true);
    if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment.onSoftKeyboardOpened(paramInt);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.UniteSearchActivity
 * JD-Core Version:    0.7.0.1
 */