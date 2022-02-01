package com.tencent.mobileqq.search.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
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
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.logcat.LogcatUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SearchHistoryManager;
import com.tencent.mobileqq.app.SearchWordHistoryManager;
import com.tencent.mobileqq.app.UnifySearchHandler;
import com.tencent.mobileqq.app.UnifySearchObserver;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.kandian.biz.config.IReadInJoySearchJumpUrlConfBean;
import com.tencent.mobileqq.kandian.biz.config.api.IReadInJoySearchJumpUrlConfProcessor;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.HotWordSearchEntryModel;
import com.tencent.mobileqq.search.LocationInterface;
import com.tencent.mobileqq.search.SearchEntryFragmentFactory;
import com.tencent.mobileqq.search.base.api.SearchEntryConfigManager;
import com.tencent.mobileqq.search.base.api.SearchInfoInterface;
import com.tencent.mobileqq.search.base.util.SearchStatisticsConstants;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment;
import com.tencent.mobileqq.search.fragment.AssociateSearchWordsFragment.AssociateWordClickCallback;
import com.tencent.mobileqq.search.fragment.GroupSearchFragment;
import com.tencent.mobileqq.search.fragment.searchentry.ISearchEntryFragment;
import com.tencent.mobileqq.search.fragment.searchentry.hippy.SearchEntryHippyEngine;
import com.tencent.mobileqq.search.model.CompleteUrlSpan;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.GIFInfo;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
import com.tencent.mobileqq.search.rich.RichNodeController;
import com.tencent.mobileqq.search.util.PAOfflineSearchManager;
import com.tencent.mobileqq.search.util.SearchConfigUtils;
import com.tencent.mobileqq.search.util.SearchCostStat;
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
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class UniteSearchActivity
  extends BaseActivity
  implements TextWatcher, TextView.OnEditorActionListener, LocationInterface, SearchInfoInterface, AssociateSearchWordsFragment.AssociateWordClickCallback, SoftKeyboardStateHelper.SoftKeyboardStateListener
{
  public static double a = 0.0D;
  public static long a = 0L;
  private static UniteSearchActivity jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity;
  public static HotWordSearchEntryDataModel.HotSearchItem a;
  public static String a;
  public static double b = 0.0D;
  public static int b = 0;
  public static String b;
  public static boolean b = false;
  public static String c = "";
  public static volatile boolean c = false;
  public static int d = -1;
  public static String d = "";
  public static boolean d = true;
  public static int e = -1;
  public static String e = "";
  public int a;
  protected Handler a;
  View jdField_a_of_type_AndroidViewView;
  protected Button a;
  protected ImageButton a;
  protected ImageView a;
  protected FragmentManager a;
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
  public boolean g;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean = false;
  private boolean i;
  private boolean j;
  
  public UniteSearchActivity()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_f_of_type_Int = 10000;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver = new UniteSearchActivity.1(this);
    this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchObserver = new UniteSearchActivity.2(this);
    this.jdField_g_of_type_Boolean = false;
  }
  
  private String a(String paramString)
  {
    String str = paramString;
    if (QFileAssistantUtils.a(this.app)) {
      if ((!paramString.equals(getResources().getString(2131698286))) && (!paramString.equalsIgnoreCase(getResources().getString(2131698285))))
      {
        str = paramString;
        if (!paramString.equalsIgnoreCase(getResources().getString(2131698284))) {}
      }
      else
      {
        str = getResources().getString(2131698288);
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fromType:");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("searchUtils", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt1 == 12) {
      ReportController.b(null, "CliOper", "", "", "0X8006501", "0X8006501", paramInt1, 0, "1", "", "", "");
    } else {
      ReportController.b(null, "CliOper", "", "", "0X8005021", "0X8005021", paramInt1, 0, "1", "", "", "");
    }
    Object localObject = new Intent(paramActivity, UniteSearchActivity.class);
    ((Intent)localObject).putExtra("keyword", paramString);
    ((Intent)localObject).putExtra("fromType", paramInt1);
    ((Intent)localObject).putExtra("source", paramInt2);
    ((Intent)localObject).putExtra("searchEngineKey", paramLong);
    ((Intent)localObject).putExtra("home_hot_word", paramHotSearchItem);
    ((Intent)localObject).putExtra("home_gif_info", paramGIFInfo);
    paramActivity.startActivity((Intent)localObject);
    paramActivity.overridePendingTransition(0, 2130772377);
    jdField_a_of_type_Long = System.currentTimeMillis();
    jdField_b_of_type_Boolean = false;
    SearchUtils.a("search", "tab", "searchbar", 0, 0, new String[] { SearchUtils.a(paramInt1) });
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    jdField_d_of_type_Int = paramInt;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fromType:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("searchUtils", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == 12) {
      ReportController.b(null, "CliOper", "", "", "0X8006501", "0X8006501", paramInt, 0, "1", "", "", "");
    } else {
      ReportController.b(null, "CliOper", "", "", "0X8005021", "0X8005021", paramInt, 0, "1", "", "", "");
    }
    Object localObject = new Intent(paramContext, UniteSearchActivity.class);
    ((Intent)localObject).putExtra("keyword", paramString);
    ((Intent)localObject).putExtra("fromType", paramInt);
    paramContext.startActivity((Intent)localObject);
    jdField_b_of_type_Boolean = false;
    jdField_a_of_type_Long = System.currentTimeMillis();
    SearchUtils.a("search", "tab", "searchbar", 0, 0, new String[] { SearchUtils.a(paramInt) });
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("useNewProtocol， source:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" from:");
      localStringBuilder.append(paramInt2);
      QLog.d("Q.uniteSearch.UniteSearchActivity", 2, localStringBuilder.toString());
    }
    return (paramInt2 != 14) && (paramInt2 != 25) && (paramInt2 != 26);
  }
  
  private int b(int paramInt)
  {
    int k = 2;
    if (paramInt != 1)
    {
      if (paramInt == 2) {
        return k;
      }
      if (paramInt == 21) {
        break label35;
      }
      if ((paramInt == 25) || (paramInt == 26)) {}
    }
    else
    {
      return 1;
    }
    return 10;
    label35:
    k = 3;
    return k;
  }
  
  @NotNull
  private String b()
  {
    int k = this.jdField_c_of_type_Int;
    String str = "kSearchMessageTab";
    if (k != 1)
    {
      if (k != 2)
      {
        if (k != 21)
        {
          if ((k != 25) && (k != 26)) {
            return "kSearchMessageTab";
          }
          return "kSearchReadInJoyTab";
        }
        return "kSearchDynamicTab";
      }
      str = "kSearchContactTab";
    }
    return str;
  }
  
  public static void b(Activity paramActivity, String paramString, int paramInt1, int paramInt2)
  {
    jdField_d_of_type_Int = paramInt1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fromType:");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("searchUtils", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt1 == 12) {
      ReportController.b(null, "CliOper", "", "", "0X8006501", "0X8006501", paramInt1, 0, "1", "", "", "");
    } else {
      ReportController.b(null, "CliOper", "", "", "0X8005021", "0X8005021", paramInt1, 0, "1", "", "", "");
    }
    Object localObject = new Intent(paramActivity, UniteSearchActivity.class);
    ((Intent)localObject).putExtra("keyword", paramString);
    ((Intent)localObject).putExtra("fromType", paramInt1);
    ((Intent)localObject).putExtra("requestCode", paramInt2);
    paramActivity.startActivityForResult((Intent)localObject, paramInt2);
    paramActivity.overridePendingTransition(0, 2130772377);
    jdField_a_of_type_Long = System.currentTimeMillis();
    jdField_b_of_type_Boolean = false;
    SearchUtils.a("search", "tab", "searchbar", 0, 0, new String[] { SearchUtils.a(paramInt1) });
  }
  
  private void c(int paramInt)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("showFragment  fragment=");
        ((StringBuilder)localObject1).append(paramInt);
        QLog.d("Q.uniteSearch.UniteSearchActivity", 2, ((StringBuilder)localObject1).toString());
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
      int k = this.jdField_g_of_type_Int;
      if (paramInt == k) {
        return;
      }
      this.jdField_g_of_type_Int = paramInt;
      Object localObject1 = this.jdField_a_of_type_AndroidxFragmentAppFragmentManager.beginTransaction();
      if (paramInt != 1)
      {
        if (paramInt != 3)
        {
          if (paramInt == 4)
          {
            if (this.jdField_a_of_type_AndroidxFragmentAppFragmentManager.findFragmentByTag("search_entry_layout") == null) {
              b(paramInt);
            }
            if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment != null)
            {
              ((FragmentTransaction)localObject1).show(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment.getFragment());
              ((FragmentTransaction)localObject1).commitAllowingStateLoss();
            }
            this.jdField_a_of_type_AndroidViewView.setVisibility(0);
            this.jdField_b_of_type_AndroidViewView.setVisibility(8);
            this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          }
        }
        else
        {
          if (this.jdField_a_of_type_AndroidxFragmentAppFragmentManager.findFragmentByTag("associated_words") == null) {
            b(paramInt);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment != null)
          {
            ((FragmentTransaction)localObject1).show(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment);
            ((FragmentTransaction)localObject1).commitAllowingStateLoss();
            this.jdField_a_of_type_AndroidViewView.setVisibility(8);
            this.jdField_b_of_type_AndroidViewView.setVisibility(0);
            this.jdField_c_of_type_AndroidViewView.setVisibility(8);
          }
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        UniteSearchReportController.a(null, 0, this.jdField_c_of_type_Int, "0X8009D29", 0, 0, null, null);
      }
      return;
    }
    finally {}
  }
  
  private boolean c()
  {
    Object localObject1 = a(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getText().toString().trim());
    LogcatUtil.a((String)localObject1);
    boolean bool;
    if ("cmd:hippyDebug".equals(localObject1))
    {
      bool = SearchEntryHippyEngine.isHippyDebug() ^ true;
      if (bool) {
        QQToast.a(this, "切换为调试模式成功，请退出重进", 0).a();
      } else {
        QQToast.a(this, "切换为非调试模式成功，请退出重进", 0).a();
      }
      SearchEntryHippyEngine.setHippyDebug(bool);
      return true;
    }
    if ("cmd:hippyOn".equals(localObject1))
    {
      bool = SearchEntryHippyEngine.iscmdHippyOn() ^ true;
      if (bool) {
        QQToast.a(this, "切换为hippy成功，请退出重进", 0).a();
      } else {
        QQToast.a(this, "切换为native成功，请退出重进", 0).a();
      }
      SearchEntryHippyEngine.setcmdHippyOn(bool);
      return true;
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
        k = this.jdField_c_of_type_Int;
        if ((k != 25) && (k != 26)) {
          localObject1 = "hotword";
        } else {
          localObject1 = "kandian_tabword";
        }
        localObject1 = SearchConfigUtils.a(str, 6, (String)localObject1);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = JumpParser.a(this.app, this, (String)localObject1);
        if (localObject2 != null)
        {
          ((JumpAction)localObject2).a();
        }
        else if (SearchUtils.a((String)localObject1))
        {
          ((IRIJJumpUtils)QRoute.api(IRIJJumpUtils.class)).jumpToNativeSearchResultPage(this, str, (String)localObject1);
        }
        else if ((!((String)localObject1).startsWith("http://")) && (!((String)localObject1).startsWith("https://")))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "onEditorAction jumpUrl is illegal");
          }
        }
        else
        {
          localObject2 = new Intent(this, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", (String)localObject1);
          ((Intent)localObject2).putExtra("search_title", str);
          startActivity((Intent)localObject2);
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "onEditorAction jumpUrl is empty");
      }
      SearchUtils.a("all_result", "clk_wording", new String[] { str, String.valueOf(c()) });
      localObject1 = this.app;
      localObject2 = new ReportModelDC02528().module("hot_list").action("clk_default_word").ver2(UniteSearchReportController.a(this.jdField_c_of_type_Int)).ver4(str);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{experiment_id:");
      localStringBuilder.append(UniteSearchReportController.jdField_b_of_type_JavaLangString);
      localStringBuilder.append("}");
      UniteSearchReportController.a((AppInterface)localObject1, ((ReportModelDC02528)localObject2).ver7(localStringBuilder.toString()));
      int k = this.jdField_c_of_type_Int;
      if ((k == 25) || (k == 26))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler;
        if (localObject1 != null) {
          ((UniteSearchHandler)localObject1).a(this.app, "clk_default_word", str, UniteSearchReportController.a(this.jdField_c_of_type_Int), null);
        }
      }
      com.tencent.mobileqq.search.SearchUtil.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment != null)
      {
        k = this.jdField_c_of_type_Int;
        if ((k == 25) || (k == 26))
        {
          ((SearchWordHistoryManager)((QQAppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime()).getManager(QQManagerFactory.SEARCH_WORD_HISTORY_MANAGER)).a(str);
          this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment.refresh();
        }
      }
      return true;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.jdField_f_of_type_JavaLangString = ((String)localObject1);
      jdField_b_of_type_JavaLangString = (String)localObject1;
      a(this.jdField_a_of_type_Int, this.jdField_c_of_type_Int);
      b((String)localObject1, 1);
      UniteSearchReportController.a(null, new ReportModelDC02528().module("all_result").action("clk_search_button").ver1((String)localObject1).ver2(UniteSearchReportController.a(this.jdField_c_of_type_Int)).ver3(jdField_d_of_type_JavaLangString).ver6(jdField_c_of_type_JavaLangString));
    }
    else if ((this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getTag() instanceof HotWordSearchEntryDataModel.HotSearchItem))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getHint().toString();
      this.jdField_f_of_type_JavaLangString = ((String)localObject1);
      jdField_b_of_type_JavaLangString = (String)localObject1;
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText((CharSequence)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(((String)localObject1).length());
    }
    b();
    return false;
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
      if ((TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) && (!(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getTag() instanceof HotWordSearchEntryDataModel.HotSearchItem)))
      {
        this.jdField_b_of_type_AndroidWidgetButton.setAlpha(0.4F);
        return;
      }
      this.jdField_b_of_type_AndroidWidgetButton.setAlpha(1.0F);
    }
  }
  
  private void k()
  {
    a(SearchEntryConfigManager.a(this.app));
  }
  
  private void l()
  {
    Object localObject = Aladdin.getConfig(313);
    int k = -1;
    if (localObject != null) {
      k = ((AladdinConfig)localObject).getIntegerFromString("SearchBox_SearchStyle", -1);
    }
    if (k == 1)
    {
      k = this.jdField_c_of_type_Int;
      if ((k == 25) || (k == 26))
      {
        super.findViewById(2131377027).setVisibility(8);
        localObject = super.findViewById(2131377028);
        ((View)localObject).setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText = ((QuickPinyinEditText)super.findViewById(2131366334));
        this.jdField_a_of_type_ComTencentMobileqqSearchUtilSoftKeyboardStateHelper = new SoftKeyboardStateHelper(super.findViewById(2131376809));
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(SearchEntryConfigManager.b());
        k();
        if (Build.VERSION.SDK_INT >= 26) {
          try
          {
            View.class.getMethod("setImportantForAutofill", new Class[] { Integer.TYPE }).invoke(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText, new Object[] { Integer.valueOf(8) });
          }
          catch (Exception localException2)
          {
            QLog.w("Q.uniteSearch.UniteSearchActivity", 2, "disable auto fill error", localException2);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setImeOptions(3);
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setOnEditorActionListener(this);
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
        jdField_d_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqSearchUtilSoftKeyboardStateHelper.a(this);
        this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)super.findViewById(2131368341));
        this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new UniteSearchActivity.4(this));
        this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131364050));
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new UniteSearchActivity.5(this));
        this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131369291));
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new UniteSearchActivity.6(this));
        if (ThemeImageWrapper.isNightMode())
        {
          ((View)localObject).setAlpha(0.4F);
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130846206);
        }
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getInputExtras(true).putInt("QUICK_SEARCH", 1);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText = ((QuickPinyinEditText)super.findViewById(2131366333));
    this.jdField_a_of_type_ComTencentMobileqqSearchUtilSoftKeyboardStateHelper = new SoftKeyboardStateHelper(super.findViewById(2131376809));
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(SearchEntryConfigManager.b());
    k = this.jdField_c_of_type_Int;
    if ((k == 25) || (k == 26)) {
      k();
    }
    if (Build.VERSION.SDK_INT >= 26) {
      try
      {
        View.class.getMethod("setImportantForAutofill", new Class[] { Integer.TYPE }).invoke(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText, new Object[] { Integer.valueOf(8) });
      }
      catch (Exception localException1)
      {
        QLog.w("Q.uniteSearch.UniteSearchActivity", 2, "disable auto fill error", localException1);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setImeOptions(3);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setOnEditorActionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
    jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqSearchUtilSoftKeyboardStateHelper.a(this);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)super.findViewById(2131368340));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new UniteSearchActivity.7(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131363868));
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131690728);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new UniteSearchActivity.8(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131369289));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new UniteSearchActivity.9(this));
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getInputExtras(true).putInt("QUICK_SEARCH", 1);
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
    if (paramInt != 21) {
      return paramInt;
    }
    return 3;
  }
  
  public QBaseFragment a()
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
        localGroupSearchFragment = GroupSearchFragment.a(this.jdField_c_of_type_Int, this.jdField_a_of_type_Int, l);
        localGroupSearchFragment.c(jdField_b_of_type_Boolean);
        return localGroupSearchFragment;
      }
    }
    catch (Exception localException)
    {
      GroupSearchFragment localGroupSearchFragment;
      label39:
      break label39;
    }
    localGroupSearchFragment = GroupSearchFragment.a(this.jdField_c_of_type_Int, this.jdField_a_of_type_Int);
    localGroupSearchFragment.c(jdField_b_of_type_Boolean);
    return localGroupSearchFragment;
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
        int k = localSpannableStringBuilder.getSpanStart(arrayOfCompleteUrlSpan[0]);
        localSpannableStringBuilder.getSpanEnd(arrayOfCompleteUrlSpan[0]);
        if (paramBoolean) {
          paramCharSequence = paramCharSequence.toString().substring(0, k + 1);
        } else {
          paramCharSequence = str.toString().substring(0, k);
        }
        paramEditText.removeTextChangedListener(this);
        paramEditText.setText(paramCharSequence);
        paramEditText.setSelection(paramCharSequence.length());
        paramEditText.addTextChangedListener(this);
        return paramCharSequence;
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
      Object localObject = new ReportModelDC02528().module("all_result").action("clk_thinkword_list").ver1(a()).ver2(UniteSearchReportController.a(this.jdField_c_of_type_Int)).ver3(jdField_d_of_type_JavaLangString).ver6(jdField_c_of_type_JavaLangString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{\"clk_index\":");
      localStringBuilder.append(paramInt - 1);
      localStringBuilder.append(",\"experiment_id\":");
      localStringBuilder.append(UniteSearchReportController.jdField_b_of_type_JavaLangString);
      localStringBuilder.append("}");
      UniteSearchReportController.a(null, ((ReportModelDC02528)localObject).ver7(localStringBuilder.toString()).ver4(paramString));
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.removeTextChangedListener(this);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(paramString);
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      j();
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onAssociateWordClick keyword = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("Q.uniteSearch.UniteSearchActivity", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(paramString.length());
      a(this.jdField_a_of_type_Int, this.jdField_c_of_type_Int);
      b(paramString, 2);
    }
    b();
  }
  
  public void a(String paramString, long paramLong)
  {
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(101);
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(101, paramLong);
    UniteSearchActivity.AssociateTask localAssociateTask = this.jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$AssociateTask;
    localAssociateTask.jdField_a_of_type_JavaLangString = paramString;
    localAssociateTask.jdField_a_of_type_Long = (System.currentTimeMillis() + paramLong);
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
      if (paramBoolean1)
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(localSpannableStringBuilder);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.removeTextChangedListener(this);
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(localSpannableStringBuilder);
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
        j();
        i();
        c(4);
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(paramString.length());
    }
    else
    {
      if (paramBoolean1)
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(paramString);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.removeTextChangedListener(this);
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText(paramString);
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.addTextChangedListener(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(paramString.length());
    }
    if (this.jdField_c_of_type_Int == 26) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new UniteSearchActivity.12(this), 500L);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      HotWordSearchEntryDataModel.HotSearchItem localHotSearchItem = jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem;
      if (localHotSearchItem == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(2131718624);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(localHotSearchItem.title);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setTag(jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setCursorVisible(true);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(2131718624);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setTag("");
    }
    j();
  }
  
  public boolean a()
  {
    QuickPinyinEditText localQuickPinyinEditText = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText;
    if (localQuickPinyinEditText == null) {
      return false;
    }
    return localQuickPinyinEditText.a();
  }
  
  public long[] a()
  {
    return new long[0];
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment;
    if (localObject != null) {
      ((ISearchEntryFragment)localObject).afterTextChanged(paramEditable);
    }
    paramEditable = a(a(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText, this.j, this.jdField_a_of_type_JavaLangCharSequence));
    if ((this.j) && (paramEditable.equals(this.jdField_f_of_type_JavaLangString))) {
      return;
    }
    boolean bool = a(this.jdField_a_of_type_Int, this.jdField_c_of_type_Int);
    if ((!bool) && (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.jdField_c_of_type_Int != 6)) {
      this.jdField_g_of_type_Boolean = true;
    }
    if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.jdField_c_of_type_Int != 6)) {
      this.jdField_g_of_type_Boolean = true;
    }
    if (TextUtils.isEmpty(jdField_d_of_type_JavaLangString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.app.getAccount());
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      jdField_d_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.a())
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("正在输入拼音，不触发文本变动逻辑。 keyword=");
        ((StringBuilder)localObject).append(paramEditable);
        QLog.d("Q.uniteSearch.UniteSearchActivity", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    this.jdField_f_of_type_JavaLangString = paramEditable;
    jdField_b_of_type_JavaLangString = paramEditable;
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.jdField_c_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
    if (TextUtils.isEmpty(paramEditable))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(a(this.jdField_c_of_type_Int));
      SearchUtils.a("home_page", "exp_home", new String[] { ((StringBuilder)localObject).toString() });
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      i();
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.e();
      j();
      localObject = this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment;
      if (localObject != null) {
        ((AssociateSearchWordsFragment)localObject).a(null);
      }
      if (jdField_c_of_type_Boolean)
      {
        jdField_c_of_type_Boolean = false;
        localObject = this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment;
        if (localObject != null) {
          ((ISearchEntryFragment)localObject).refresh();
        }
      }
      b(true);
    }
    else
    {
      SearchCostStat.a(paramEditable, this.jdField_c_of_type_Int, this.jdField_f_of_type_Boolean);
      this.jdField_f_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      j();
      if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment != null)
      {
        int k = this.jdField_c_of_type_Int;
        if ((k != 25) && (k != 26))
        {
          a(paramEditable);
          b(false);
          break label462;
        }
      }
      if (!this.jdField_e_of_type_Boolean)
      {
        jdField_d_of_type_Boolean = true;
        a(paramEditable);
      }
      else
      {
        a(paramEditable, 0L);
      }
    }
    label462:
    if (!paramEditable.equals(this.jdField_f_of_type_JavaLangString))
    {
      SearchUtils.c = 0L;
      jdField_e_of_type_Int = 2;
    }
    if (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {
      b(TextUtils.isEmpty(paramEditable));
    }
    paramEditable = this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment;
    if (paramEditable != null) {
      paramEditable.a(null);
    }
  }
  
  public double b()
  {
    return jdField_b_of_type_Double;
  }
  
  protected int b()
  {
    return 2131563006;
  }
  
  public void b()
  {
    ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getWindowToken(), 0);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.clearFocus();
  }
  
  void b(int paramInt)
  {
    FragmentTransaction localFragmentTransaction = this.jdField_a_of_type_AndroidxFragmentAppFragmentManager.beginTransaction();
    if (paramInt != 3)
    {
      if (paramInt != 4) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment == null)
      {
        String str = b();
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment = SearchEntryFragmentFactory.a(str);
        Object localObject = this.app;
        ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("all_result").action("exp_entryweb").ver2(UniteSearchReportController.a(this.jdField_c_of_type_Int));
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.app.getCurrentAccountUin());
        localStringBuilder.append(System.currentTimeMillis());
        UniteSearchReportController.a((AppInterface)localObject, localReportModelDC02528.session_id(localStringBuilder.toString()));
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment.setApp(this.app);
        localObject = new Bundle(9);
        ((Bundle)localObject).putInt("from", this.jdField_c_of_type_Int);
        ((Bundle)localObject).putInt("source", this.jdField_a_of_type_Int);
        ((Bundle)localObject).putString("tabType", str);
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment.setInitData((Bundle)localObject);
        localFragmentTransaction.add(2131366279, this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment.getFragment(), "search_entry_layout");
        localFragmentTransaction.commitAllowingStateLoss();
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment == null) {
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment = new AssociateSearchWordsFragment();
      }
      localFragmentTransaction.add(2131363014, this.jdField_a_of_type_ComTencentMobileqqSearchFragmentAssociateSearchWordsFragment, "associated_words");
      localFragmentTransaction.commitAllowingStateLoss();
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    Object localObject2 = ((IReadInJoySearchJumpUrlConfProcessor)QRoute.api(IReadInJoySearchJumpUrlConfProcessor.class)).getConfig().c();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "https://sou.qq.com/kandian/kd.html?_bid=3216&_wv=3&_wwv=1293&_wvSb=0&keyword=$KEYWORD$&from=$FROM$";
    }
    localObject1 = ((String)localObject1).replace("$KEYWORD$", URLEncoder.encode(this.jdField_f_of_type_JavaLangString));
    int k = this.jdField_c_of_type_Int;
    if ((k != 25) && (k != 26))
    {
      i();
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      a(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.b(paramString);
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.a(null);
      c(1);
    }
    else
    {
      if (paramInt == 2) {
        localObject1 = ((String)localObject1).replace("$FROM$", "kandian_thinkword");
      } else {
        localObject1 = ((String)localObject1).replace("$FROM$", "kandian_search");
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(URLEncoder.encode(jdField_c_of_type_JavaLangString));
      localObject1 = ((String)localObject1).replace("$SEARCHID$", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(URLEncoder.encode(jdField_d_of_type_JavaLangString));
      localObject1 = ((String)localObject1).replace("$SEQNO$", ((StringBuilder)localObject2).toString());
      SearchUtils.a(this.app, this, (String)localObject1, this.jdField_f_of_type_Int);
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment;
    if (localObject1 != null) {
      if (!TextUtils.equals(((ISearchEntryFragment)localObject1).getInitData().getString("tabType"), "kSearchDynamicTab"))
      {
        paramInt = this.jdField_c_of_type_Int;
        if ((paramInt != 25) && (paramInt != 26)) {}
      }
      else
      {
        ((SearchWordHistoryManager)((QQAppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime()).getManager(QQManagerFactory.SEARCH_WORD_HISTORY_MANAGER)).a(paramString);
        this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment.refresh();
      }
    }
  }
  
  void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showSearchHistory,  isShow: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("searchUtils", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      return;
    }
    if ((paramBoolean) && (((View)localObject).getVisibility() != 0) && (this.jdField_c_of_type_Int != 12))
    {
      c(4);
      return;
    }
    if (((!paramBoolean) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) || (this.jdField_c_of_type_Int == 12)) {
      c(1);
    }
  }
  
  public boolean b()
  {
    return this.jdField_g_of_type_Boolean;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = TextUtils.isEmpty(paramCharSequence);
    boolean bool1 = false;
    if ((bool2) && (paramInt1 == 0) && (paramInt2 == 0) && (this.i))
    {
      this.i = false;
      SQLiteFTSUtils.FtsItemClickEvent.a();
      SQLiteFTSUtils.FtsItemClickEvent.c = System.nanoTime();
    }
    if (paramInt3 == 0) {
      bool1 = true;
    }
    this.j = bool1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramCharSequence);
    this.jdField_a_of_type_JavaLangCharSequence = localStringBuilder.toString();
  }
  
  public int c()
  {
    int k = this.jdField_c_of_type_Int;
    if (k != 21)
    {
      if ((k != 25) && (k != 26)) {
        return k;
      }
      return 10;
    }
    return 3;
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onAssociateWordClick keyword = ");
        localStringBuilder.append(paramString);
        QLog.d("Q.uniteSearch.UniteSearchActivity", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(paramString.length());
    }
  }
  
  protected void d()
  {
    int k = b(this.jdField_c_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "getUniteSearchDiscovery use old protocl");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler.a(this.app, k);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchHandler != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "getUniteSearchDiscovery use new protocl");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchHandler.a(this.app, k);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "getUniteSearchDiscovery error");
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_h_of_type_Int = paramInt1;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment;
    if ((localObject != null) && (((GroupSearchFragment)localObject).jdField_c_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.jdField_c_of_type_JavaUtilList.size() > 0)) {
      b();
    }
    if (paramInt1 == 1300)
    {
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
    else if (paramInt1 == 21011)
    {
      if ((-1 == paramInt2) && (paramIntent != null))
      {
        localObject = paramIntent.getStringExtra("keyword");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("vsKey");
          jdField_b_of_type_Int = paramIntent.getIntExtra("vsSource", 1);
          this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.c(true);
          this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText((CharSequence)localObject);
          this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setSelection(((String)localObject).length());
          a((String)localObject);
          b();
        }
      }
    }
    else if (paramInt1 == this.jdField_f_of_type_Int)
    {
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment;
      if (paramIntent != null) {
        paramIntent.refresh();
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText("");
    }
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    QQAppInterface localQQAppInterface = this.app;
    ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("all_result").action("return").ver1(a()).ver2(UniteSearchReportController.a(this.jdField_c_of_type_Int)).ver3(jdField_d_of_type_JavaLangString).ver6(jdField_c_of_type_JavaLangString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.app.getCurrentAccountUin());
    localStringBuilder.append(System.currentTimeMillis());
    UniteSearchReportController.a(localQQAppInterface, localReportModelDC02528.session_id(localStringBuilder.toString()));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_c_of_type_Int = super.getIntent().getIntExtra("fromType", -1);
    if (this.jdField_c_of_type_Int != 26)
    {
      paramBundle = jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity;
      if (paramBundle != null)
      {
        jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity = this;
        paramBundle.finish();
      }
      else
      {
        jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity = this;
      }
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_h_of_type_Int = super.getIntent().getIntExtra("requestCode", 0);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchObserver);
    jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_AndroidxFragmentAppFragmentManager = super.getSupportFragmentManager();
    int k = b(this.jdField_c_of_type_Int);
    if (k != -1)
    {
      paramBundle = new StringBuilder();
      paramBundle.append(k);
      paramBundle.append("_");
      paramBundle.append(this.app.getAccount());
      paramBundle.append("_");
      paramBundle.append(System.currentTimeMillis());
      jdField_c_of_type_JavaLangString = paramBundle.toString();
    }
    else
    {
      jdField_c_of_type_JavaLangString = "";
    }
    setContentView(b());
    paramBundle = super.findViewById(2131376809);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      paramBundle.setFitsSystemWindows(true);
    }
    try
    {
      paramBundle.setBackgroundResource(2130838740);
    }
    catch (Exception localException1)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("doOnCreate, e = ");
      ((StringBuilder)localObject2).append(QLog.getStackTraceString(localException1));
      QLog.e("Q.uniteSearch.UniteSearchActivity", 1, ((StringBuilder)localObject2).toString());
      try
      {
        paramBundle.setBackgroundResource(2130850359);
      }
      catch (Error localError)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("doOnCreate, e = ");
        ((StringBuilder)localObject2).append(QLog.getStackTraceString(localError));
        QLog.e("Q.uniteSearch.UniteSearchActivity", 1, ((StringBuilder)localObject2).toString());
      }
    }
    this.jdField_a_of_type_Int = super.getIntent().getIntExtra("source", 0);
    c();
    l();
    this.jdField_f_of_type_JavaLangString = super.getIntent().getStringExtra("keyword");
    Object localObject1 = (HotWordSearchEntryDataModel.HotSearchItem)super.getIntent().getSerializableExtra("home_hot_word");
    if ((localObject1 != null) && (!TextUtils.isEmpty(((HotWordSearchEntryDataModel.HotSearchItem)localObject1).title)))
    {
      jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem = (HotWordSearchEntryDataModel.HotSearchItem)localObject1;
      k();
      SearchUtils.a("home_page", "hot_list", new String[] { jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel$HotSearchItem.title, String.valueOf(c()) });
    }
    localObject1 = getResources().getDisplayMetrics();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(a(this.jdField_c_of_type_Int));
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((DisplayMetrics)localObject1).widthPixels);
    localStringBuilder.append("*");
    localStringBuilder.append(((DisplayMetrics)localObject1).heightPixels);
    SearchUtils.a("home_page", "active_search", new String[] { localObject2, localStringBuilder.toString() });
    localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("project", UniteSearchReportController.a());
      ((JSONObject)localObject1).put("event_src", "client");
      ((JSONObject)localObject1).put("experiment_id", UniteSearchReportController.jdField_b_of_type_JavaLangString);
    }
    catch (JSONException localJSONException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("e = ");
      localStringBuilder.append(localJSONException);
      QLog.e("Q.uniteSearch.UniteSearchActivity", 2, localStringBuilder.toString());
    }
    QQAppInterface localQQAppInterface = this.app;
    localObject1 = new ReportModelDC02528().module("all_result").action("active_search").ver2(UniteSearchReportController.a(this.jdField_c_of_type_Int)).ver7(((JSONObject)localObject1).toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.app.getCurrentAccountUin());
    localStringBuilder.append(System.currentTimeMillis());
    UniteSearchReportController.a(localQQAppInterface, ((ReportModelDC02528)localObject1).session_id(localStringBuilder.toString()));
    if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(a(this.jdField_c_of_type_Int));
      SearchUtils.a("home_page", "exp_home", new String[] { ((StringBuilder)localObject1).toString() });
    }
    localObject1 = super.getSupportFragmentManager();
    this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment = a();
    ((FragmentManager)localObject1).beginTransaction().replace(2131367871, this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment).commitAllowingStateLoss();
    SearchUtils.b = System.currentTimeMillis();
    if (this.jdField_c_of_type_Int == 12) {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setHint(String.format(getResources().getString(2131696506), new Object[] { ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.app, getApplicationContext()) }));
    }
    this.jdField_g_of_type_JavaLangString = SearchHistoryManager.a(this.app);
    if (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString))
    {
      k = this.jdField_c_of_type_Int;
      if ((k != 12) && (k != 14))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment;
        if (localObject1 != null) {
          ((ISearchEntryFragment)localObject1).refresh();
        }
      }
    }
    this.i = true;
    this.jdField_a_of_type_AndroidViewView = paramBundle.findViewById(2131366279);
    this.jdField_b_of_type_AndroidViewView = paramBundle.findViewById(2131363014);
    this.jdField_c_of_type_AndroidViewView = paramBundle.findViewById(2131367871);
    if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
    {
      c(4);
      j();
    }
    else
    {
      c(3);
    }
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText;
    paramBundle.jdField_a_of_type_Int = 50;
    paramBundle.setFilters(new InputFilter[] { new InputFilter.LengthFilter(50) });
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
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("自动搜索 isViewCreated:");
        paramBundle.append(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.jdField_a_of_type_Boolean);
        QLog.i("Q.uniteSearch.UniteSearchActivity", 2, paramBundle.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment.jdField_g_of_type_Boolean = true;
      if (this.jdField_c_of_type_Int == 4) {
        a(6);
      }
    }
    else
    {
      paramBundle = null;
      try
      {
        localObject1 = (HotWordSearchEntryDataModel.GIFInfo)super.getIntent().getSerializableExtra("home_gif_info");
        paramBundle = (Bundle)localObject1;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
      if ((this.jdField_c_of_type_Int != 25) || (!HotWordSearchEntryModel.a(paramBundle))) {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new UniteSearchActivity.3(this), 500L);
      }
    }
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
    AbstractGifImage.resumeAll();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity == this) {
      jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity = null;
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$CancelReceiver != null)
      {
        super.unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$CancelReceiver);
        this.jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$CancelReceiver = null;
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(101);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchObserver);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchObserver);
    PAOfflineSearchManager.a().a();
    jdField_d_of_type_Int = -1;
    try
    {
      b();
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFocusable(false);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setFocusableInTouchMode(false);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getParent() != null) {
        ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getParent()).removeView(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText);
      }
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.removeTextChangedListener(this);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setOnEditorActionListener(null);
      if ((Build.VERSION.SDK_INT >= 23) && (Build.MANUFACTURER.equals("samsung")))
      {
        Object localObject = getSystemService(Class.forName("com.samsung.android.content.clipboard.SemClipboardManager"));
        if (localObject != null)
        {
          Field localField = localObject.getClass().getDeclaredField("mContext");
          localField.setAccessible(true);
          localField.set(localObject, null);
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "systemService is null");
        }
      }
    }
    catch (Error localError1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.UniteSearchActivity", 2, QLog.getStackTraceString(localError1));
      }
    }
    catch (Exception localException2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.UniteSearchActivity", 2, QLog.getStackTraceString(localException2));
      }
    }
    SearchUtils.a = null;
    jdField_e_of_type_Int = -1;
    GroupSearchFragment localGroupSearchFragment = this.jdField_a_of_type_ComTencentMobileqqSearchFragmentGroupSearchFragment;
    if (localGroupSearchFragment != null) {
      localGroupSearchFragment.k();
    }
    b();
    SearchUtils.b();
    try
    {
      super.doOnDestroy();
    }
    catch (Error localError2)
    {
      QLog.e("Q.uniteSearch.UniteSearchActivity", 1, QLog.getStackTraceString(localError2));
    }
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = 100;
    RichNodeController.a();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    SearchUtils.b = -1L;
    RichNodeController.c();
    ApngImage.pauseByTag(41);
    b();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    RichNodeController.d();
    if (!this.jdField_a_of_type_Boolean) {
      UniteSearchReportController.a(null, new ReportModelDC02528().module("all_result").action("return").ver2(UniteSearchReportController.a(this.jdField_c_of_type_Int)).ver3(jdField_d_of_type_JavaLangString).ver6(jdField_c_of_type_JavaLangString));
    }
    this.jdField_a_of_type_Boolean = false;
    jdField_d_of_type_JavaLangString = "";
    ApngImage.playByTag(41);
  }
  
  protected void doOnStart() {}
  
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
    if ((paramBoolean) && (!this.jdField_h_of_type_Boolean))
    {
      this.jdField_h_of_type_Boolean = true;
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
    overridePendingTransition(0, 2130772377);
  }
  
  protected void g()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cancelType-2 ResultModule:");
      ((StringBuilder)localObject).append(SearchStatisticsConstants.a());
      QLog.d("searchUtils", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_c_of_type_AndroidViewView;
    if ((localObject != null) && (((View)localObject).getVisibility() == 0)) {
      UniteSearchReportController.a(this.app, 0, this.jdField_c_of_type_Int, "0X8009D2A", 0, 0, null, null);
    } else {
      UniteSearchReportController.a(this.app, 0, this.jdField_c_of_type_Int, "0X8009D17", 0, 0, null, null);
    }
    localObject = this.app;
    ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("all_result").action("cancel").ver1(a()).ver2(UniteSearchReportController.a(this.jdField_c_of_type_Int)).ver3(jdField_d_of_type_JavaLangString).ver6(jdField_c_of_type_JavaLangString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.app.getCurrentAccountUin());
    localStringBuilder.append(System.currentTimeMillis());
    UniteSearchReportController.a((AppInterface)localObject, localReportModelDC02528.session_id(localStringBuilder.toString()));
    ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.getWindowToken(), 0);
    jdField_e_of_type_Int = 0;
    getIntent().putExtra("keyword", this.jdField_f_of_type_JavaLangString);
    finish();
  }
  
  protected void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "sendAssociationWordRequest use old protocl");
      }
      int k = this.jdField_c_of_type_Int;
      if ((k != 25) && (k != 26))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler.a(this.jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$AssociateTask.jdField_a_of_type_JavaLangString, 1, false);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppUniteSearchHandler.a(this.jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$AssociateTask.jdField_a_of_type_JavaLangString, 1, true);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchHandler != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "sendAssociationWordRequest use new protocl");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppUnifySearchHandler.a(this.jdField_a_of_type_ComTencentMobileqqSearchActivityUniteSearchActivity$AssociateTask.jdField_a_of_type_JavaLangString);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "sendAssociationWordRequest error");
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt != 3) && ((paramKeyEvent == null) || (paramKeyEvent.getKeyCode() != 66))) {
      return false;
    }
    if ((paramKeyEvent != null) && (paramKeyEvent.getAction() != 1)) {
      return true;
    }
    if (c()) {}
    return true;
  }
  
  protected void onRestart()
  {
    super.onRestart();
    int k = this.jdField_c_of_type_Int;
    if ((k == 25) || (k == 26)) {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setText("");
    }
    if ((!SQLiteFTSUtils.FtsItemClickEvent.jdField_a_of_type_Boolean) && (SQLiteFTSUtils.FtsItemClickEvent.jdField_f_of_type_Int != 1))
    {
      SQLiteFTSUtils.FtsItemClickEvent.c = System.nanoTime();
      SQLiteFTSUtils.FtsItemClickEvent.e = System.nanoTime();
    }
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    QuickPinyinEditText localQuickPinyinEditText = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText;
    if (localQuickPinyinEditText != null) {
      localQuickPinyinEditText.removeTextChangedListener(this);
    }
    super.onRestoreInstanceState(paramBundle);
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText;
    if (paramBundle != null) {
      paramBundle.addTextChangedListener(this);
    }
  }
  
  public void onSoftKeyboardClosed()
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setCursorVisible(false);
    ISearchEntryFragment localISearchEntryFragment = this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment;
    if (localISearchEntryFragment != null) {
      localISearchEntryFragment.onSoftKeyboardClosed();
    }
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqSearchViewQuickPinyinEditText.setCursorVisible(true);
    ISearchEntryFragment localISearchEntryFragment = this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSearchentryISearchEntryFragment;
    if (localISearchEntryFragment != null) {
      localISearchEntryFragment.onSoftKeyboardOpened(paramInt);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.UniteSearchActivity
 * JD-Core Version:    0.7.0.1
 */