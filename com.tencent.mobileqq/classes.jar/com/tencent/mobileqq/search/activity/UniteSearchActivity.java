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
import android.widget.RelativeLayout.LayoutParams;
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
import com.tencent.mobileqq.search.SearchUtil;
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
import com.tencent.mobileqq.search.util.HuichuanConfigManager;
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
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
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
  public static double D = 0.0D;
  public static double E = 0.0D;
  public static boolean I = true;
  private static UniteSearchActivity U;
  public static long a = 0L;
  public static String c;
  public static int d = 0;
  public static int f = -1;
  public static String g;
  public static HotWordSearchEntryDataModel.HotSearchItem h;
  public static String i = "";
  public static String j = "";
  public static String k = "";
  public static boolean m = false;
  public static volatile boolean n = false;
  public static int o = -1;
  byte[] A = null;
  UniteSearchHandler B;
  UnifySearchHandler C;
  public int F = 10000;
  protected FragmentManager G;
  protected Handler H;
  public boolean J = true;
  public boolean K = true;
  protected UniteSearchActivity.CancelReceiver L;
  public UniteSearchObserver M = new UniteSearchActivity.1(this);
  public UnifySearchObserver N = new UniteSearchActivity.2(this);
  View O;
  View P;
  View Q;
  final UniteSearchActivity.AssociateTask R = new UniteSearchActivity.AssociateTask(this);
  final Handler S = new UniteSearchActivity.10(this);
  public boolean T = false;
  private int V = -1;
  private String W = null;
  private boolean X = false;
  private boolean Y;
  private boolean Z;
  private CharSequence aa;
  private int ab;
  public int b = 0;
  public int e = -1;
  public boolean l = true;
  public String p;
  public QuickPinyinEditText q;
  SoftKeyboardStateHelper r;
  protected Button s;
  protected ImageButton t;
  protected Button u;
  protected ImageView v;
  protected ImageView w;
  protected GroupSearchFragment x;
  protected ISearchEntryFragment y;
  protected AssociateSearchWordsFragment z;
  
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
    f = paramInt1;
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
    paramActivity.overridePendingTransition(0, 2130772473);
    a = System.currentTimeMillis();
    m = false;
    SearchUtils.a("search", "tab", "searchbar", 0, 0, new String[] { SearchUtils.a(paramInt1) });
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    f = paramInt;
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
    m = false;
    a = System.currentTimeMillis();
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
  
  private String b(String paramString)
  {
    String str = paramString;
    if (QFileAssistantUtils.a(this.app)) {
      if ((!paramString.equals(getResources().getString(2131896187))) && (!paramString.equalsIgnoreCase(getResources().getString(2131896186))))
      {
        str = paramString;
        if (!paramString.equalsIgnoreCase(getResources().getString(2131896185))) {}
      }
      else
      {
        str = getResources().getString(2131896189);
      }
    }
    return str;
  }
  
  public static void b(Activity paramActivity, String paramString, int paramInt1, int paramInt2)
  {
    f = paramInt1;
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
    paramActivity.overridePendingTransition(0, 2130772473);
    a = System.currentTimeMillis();
    m = false;
    SearchUtils.a("search", "tab", "searchbar", 0, 0, new String[] { SearchUtils.a(paramInt1) });
  }
  
  private int d(int paramInt)
  {
    int i1 = 2;
    if (paramInt != 1)
    {
      if (paramInt == 2) {
        return i1;
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
    i1 = 3;
    return i1;
  }
  
  private void e(int paramInt)
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
      int i1 = this.V;
      if (paramInt == i1) {
        return;
      }
      this.V = paramInt;
      Object localObject1 = this.G.beginTransaction();
      if (paramInt != 1)
      {
        if (paramInt != 3)
        {
          if (paramInt == 4)
          {
            if (this.G.findFragmentByTag("search_entry_layout") == null) {
              b(paramInt);
            }
            if (this.y != null)
            {
              ((FragmentTransaction)localObject1).show(this.y.getFragment());
              ((FragmentTransaction)localObject1).commitAllowingStateLoss();
            }
            this.O.setVisibility(0);
            this.P.setVisibility(8);
            this.Q.setVisibility(8);
          }
        }
        else
        {
          if (this.G.findFragmentByTag("associated_words") == null) {
            b(paramInt);
          }
          if (this.z != null)
          {
            ((FragmentTransaction)localObject1).show(this.z);
            ((FragmentTransaction)localObject1).commitAllowingStateLoss();
            this.O.setVisibility(8);
            this.P.setVisibility(0);
            this.Q.setVisibility(8);
          }
        }
      }
      else
      {
        this.O.setVisibility(8);
        this.P.setVisibility(8);
        this.Q.setVisibility(0);
        UniteSearchReportController.a(null, 0, this.e, "0X8009D29", 0, 0, null, null);
      }
      return;
    }
    finally {}
  }
  
  private void t()
  {
    this.A = null;
    if (TextUtils.isEmpty(this.p)) {
      this.Q.setVisibility(4);
    }
    this.x.f();
  }
  
  private boolean u()
  {
    Object localObject1 = b(this.q.getText().toString().trim());
    LogcatUtil.a((String)localObject1);
    boolean bool;
    if ("cmd:hippyDebug".equals(localObject1))
    {
      bool = SearchEntryHippyEngine.isHippyDebug() ^ true;
      if (bool) {
        QQToast.makeText(this, "切换为调试模式成功，请退出重进", 0).show();
      } else {
        QQToast.makeText(this, "切换为非调试模式成功，请退出重进", 0).show();
      }
      SearchEntryHippyEngine.setHippyDebug(bool);
      return true;
    }
    if ("cmd:hippyOn".equals(localObject1))
    {
      bool = SearchEntryHippyEngine.iscmdHippyOn() ^ true;
      if (bool) {
        QQToast.makeText(this, "切换为hippy成功，请退出重进", 0).show();
      } else {
        QQToast.makeText(this, "切换为native成功，请退出重进", 0).show();
      }
      SearchEntryHippyEngine.setcmdHippyOn(bool);
      return true;
    }
    if (Patterns.d.matcher((CharSequence)localObject1).matches())
    {
      this.p = ((String)localObject1);
      this.q.performClick();
    }
    if ((TextUtils.isEmpty((CharSequence)localObject1)) && ((this.q.getTag() instanceof HotWordSearchEntryDataModel.HotSearchItem)))
    {
      String str = h.recallWord;
      localObject1 = ((HotWordSearchEntryDataModel.HotSearchItem)this.q.getTag()).jumpUrl;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        SearchUtils.a("后台没有配置链接，终端拼接跳转");
        i1 = this.e;
        if ((i1 != 25) && (i1 != 26)) {
          localObject1 = "hotword";
        } else {
          localObject1 = "kandian_tabword";
        }
        localObject1 = SearchConfigUtils.a(str, 6, (String)localObject1);
      }
      else
      {
        SearchUtils.a("后台配置了链接，使用后台链接跳转");
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = JumpParser.a(this.app, this, (String)localObject1);
        if (localObject2 != null)
        {
          ((JumpAction)localObject2).a();
        }
        else if (SearchUtils.c((String)localObject1))
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
      SearchUtils.a("all_result", "clk_wording", new String[] { str, String.valueOf(s()) });
      localObject1 = this.app;
      Object localObject2 = new ReportModelDC02528().module("hot_list").action("clk_default_word").ver2(UniteSearchReportController.a(this.e)).ver4(str);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{experiment_id:");
      localStringBuilder.append(UniteSearchReportController.b);
      localStringBuilder.append("}");
      UniteSearchReportController.a((AppInterface)localObject1, ((ReportModelDC02528)localObject2).ver7(localStringBuilder.toString()));
      int i1 = this.e;
      if ((i1 == 25) || (i1 == 26))
      {
        localObject1 = this.B;
        if (localObject1 != null) {
          ((UniteSearchHandler)localObject1).a(this.app, "clk_default_word", str, UniteSearchReportController.a(this.e), null);
        }
      }
      SearchUtil.a = true;
      if (this.y != null)
      {
        i1 = this.e;
        if ((i1 == 25) || (i1 == 26))
        {
          ((SearchWordHistoryManager)((QQAppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime()).getManager(QQManagerFactory.SEARCH_WORD_HISTORY_MANAGER)).a(str);
          this.y.refresh();
        }
      }
      return true;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      this.p = ((String)localObject1);
      g = (String)localObject1;
      a(this.b, this.e);
      b((String)localObject1, 1);
      UniteSearchReportController.a(null, new ReportModelDC02528().module("all_result").action("clk_search_button").ver1((String)localObject1).ver2(UniteSearchReportController.a(this.e)).ver3(j).ver6(i));
    }
    else if ((this.q.getTag() instanceof HotWordSearchEntryDataModel.HotSearchItem))
    {
      localObject1 = this.q.getHint().toString();
      this.p = ((String)localObject1);
      g = (String)localObject1;
      this.q.setText((CharSequence)localObject1);
      this.q.setSelection(((String)localObject1).length());
    }
    e();
    return false;
  }
  
  private void v()
  {
    if (this.u != null)
    {
      if ((TextUtils.isEmpty(this.p)) && (!(this.q.getTag() instanceof HotWordSearchEntryDataModel.HotSearchItem)))
      {
        this.u.setAlpha(0.4F);
        return;
      }
      this.u.setAlpha(1.0F);
    }
  }
  
  private void w()
  {
    a(SearchEntryConfigManager.a(this.app));
  }
  
  private void x()
  {
    Object localObject = Aladdin.getConfig(313);
    int i1 = -1;
    if (localObject != null) {
      i1 = ((AladdinConfig)localObject).getIntegerFromString("SearchBox_SearchStyle", -1);
    }
    if (i1 == 1)
    {
      i1 = this.e;
      if ((i1 == 25) || (i1 == 26))
      {
        super.findViewById(2131445393).setVisibility(8);
        localObject = super.findViewById(2131445394);
        ((View)localObject).setVisibility(0);
        this.q = ((QuickPinyinEditText)super.findViewById(2131432635));
        this.r = new SoftKeyboardStateHelper(super.findViewById(2131445137));
        this.q.setHint(SearchEntryConfigManager.c());
        w();
        if (Build.VERSION.SDK_INT >= 26) {
          try
          {
            View.class.getMethod("setImportantForAutofill", new Class[] { Integer.TYPE }).invoke(this.q, new Object[] { Integer.valueOf(8) });
          }
          catch (Exception localException2)
          {
            QLog.w("Q.uniteSearch.UniteSearchActivity", 2, "disable auto fill error", localException2);
          }
        }
        this.q.setImeOptions(3);
        this.q.setOnEditorActionListener(this);
        this.q.addTextChangedListener(this);
        I = false;
        this.r.a(this);
        this.t = ((ImageButton)super.findViewById(2131435216));
        this.t.setOnClickListener(new UniteSearchActivity.4(this));
        this.u = ((Button)super.findViewById(2131430008));
        this.u.setOnClickListener(new UniteSearchActivity.5(this));
        this.w = ((ImageView)super.findViewById(2131436277));
        this.w.setVisibility(0);
        this.w.setOnClickListener(new UniteSearchActivity.6(this));
        if (ThemeImageWrapper.isNightMode())
        {
          ((View)localObject).setAlpha(0.4F);
          this.w.setImageResource(2130847676);
        }
        this.q.getInputExtras(true).putInt("QUICK_SEARCH", 1);
        break label639;
      }
    }
    this.q = ((QuickPinyinEditText)super.findViewById(2131432634));
    this.r = new SoftKeyboardStateHelper(super.findViewById(2131445137));
    this.q.setHint(SearchEntryConfigManager.c());
    i1 = this.e;
    if ((i1 == 25) || (i1 == 26)) {
      w();
    }
    if (Build.VERSION.SDK_INT >= 26) {
      try
      {
        View.class.getMethod("setImportantForAutofill", new Class[] { Integer.TYPE }).invoke(this.q, new Object[] { Integer.valueOf(8) });
      }
      catch (Exception localException1)
      {
        QLog.w("Q.uniteSearch.UniteSearchActivity", 2, "disable auto fill error", localException1);
      }
    }
    this.q.setImeOptions(3);
    this.q.setOnEditorActionListener(this);
    this.q.addTextChangedListener(this);
    I = false;
    this.r.a(this);
    this.t = ((ImageButton)super.findViewById(2131435215));
    this.t.setOnClickListener(new UniteSearchActivity.7(this));
    this.s = ((Button)super.findViewById(2131429816));
    this.s.setVisibility(0);
    this.s.setText(2131887648);
    this.s.setOnClickListener(new UniteSearchActivity.8(this));
    this.v = ((ImageView)super.findViewById(2131436275));
    this.v.setVisibility(8);
    this.v.setOnClickListener(new UniteSearchActivity.9(this));
    this.q.getInputExtras(true).putInt("QUICK_SEARCH", 1);
    label639:
    a(this.q);
  }
  
  @NotNull
  private String y()
  {
    int i1 = this.e;
    String str = "kSearchMessageTab";
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 21)
        {
          if ((i1 != 25) && (i1 != 26)) {
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
  
  public double a()
  {
    return D;
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
        int i1 = localSpannableStringBuilder.getSpanStart(arrayOfCompleteUrlSpan[0]);
        localSpannableStringBuilder.getSpanEnd(arrayOfCompleteUrlSpan[0]);
        if (paramBoolean) {
          paramCharSequence = paramCharSequence.toString().substring(0, i1 + 1);
        } else {
          paramCharSequence = str.toString().substring(0, i1);
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
  
  public void a(int paramInt)
  {
    this.x.H = paramInt;
  }
  
  protected void a(TextView paramTextView)
  {
    Context localContext = paramTextView.getContext();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramTextView.getLayoutParams();
    int i1 = ViewUtils.dpToPx(12.0F);
    int i2 = ViewUtils.dpToPx(30.0F);
    int i3 = ViewUtils.dpToPx(5.0F);
    int i4 = ViewUtils.dpToPx(5.0F);
    if (QQTheme.isNowSimpleUI())
    {
      paramTextView.setCompoundDrawablePadding(ViewUtils.dpToPx(4.0F));
      paramTextView.setTextSize(0, ViewUtils.dpToPx(14.0F));
      paramTextView.setTextColor(localContext.getResources().getColor(2131168056));
      paramTextView.setHintTextColor(localContext.getResources().getColor(2131168059));
      paramTextView.setPadding(ViewUtils.dpToPx(16.0F), i3, i2, i4);
      localLayoutParams.rightMargin = ViewUtils.dpToPx(14.0F);
      return;
    }
    paramTextView.setCompoundDrawablePadding(ViewUtils.dpToPx(5.0F));
    paramTextView.setTextSize(0, ViewUtils.dpToPx(16.0F));
    paramTextView.setTextColor(localContext.getResources().getColor(2131168141));
    paramTextView.setHintTextColor(localContext.getResources().getColor(2131168136));
    paramTextView.setPadding(i1, i3, i2, i4);
    localLayoutParams.rightMargin = ViewUtils.dpToPx(12.0F);
  }
  
  public void a(String paramString)
  {
    t();
    this.Q.setVisibility(0);
    this.x.b(paramString);
    this.x.a(null);
    e(1);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.p = paramString;
      Object localObject = new ReportModelDC02528().module("all_result").action("clk_thinkword_list").ver1(h()).ver2(UniteSearchReportController.a(this.e)).ver3(j).ver6(i);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{\"clk_index\":");
      localStringBuilder.append(paramInt - 1);
      localStringBuilder.append(",\"experiment_id\":");
      localStringBuilder.append(UniteSearchReportController.b);
      localStringBuilder.append("}");
      UniteSearchReportController.a(null, ((ReportModelDC02528)localObject).ver7(localStringBuilder.toString()).ver4(paramString));
      this.q.removeTextChangedListener(this);
      this.q.setText(paramString);
      this.t.setVisibility(0);
      v();
      this.q.addTextChangedListener(this);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onAssociateWordClick keyword = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("Q.uniteSearch.UniteSearchActivity", 2, ((StringBuilder)localObject).toString());
      }
      this.q.setSelection(paramString.length());
      a(this.b, this.e);
      b(paramString, 2);
    }
    e();
  }
  
  public void a(String paramString, long paramLong)
  {
    this.S.removeMessages(101);
    this.S.sendEmptyMessageDelayed(101, paramLong);
    UniteSearchActivity.AssociateTask localAssociateTask = this.R;
    localAssociateTask.a = paramString;
    localAssociateTask.b = (System.currentTimeMillis() + paramLong);
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
      this.q.setMovementMethod(LinkMovementMethod.getInstance());
      if (paramBoolean1)
      {
        this.q.setText(localSpannableStringBuilder);
      }
      else
      {
        this.q.removeTextChangedListener(this);
        this.q.setText(localSpannableStringBuilder);
        this.q.addTextChangedListener(this);
        this.t.setVisibility(0);
        v();
        t();
        e(4);
      }
      this.q.setSelection(paramString.length());
    }
    else
    {
      if (paramBoolean1)
      {
        this.q.setText(paramString);
      }
      else
      {
        this.q.removeTextChangedListener(this);
        this.q.setText(paramString);
        this.q.addTextChangedListener(this);
      }
      this.q.setSelection(paramString.length());
    }
    if (this.e == 26) {
      this.H.postDelayed(new UniteSearchActivity.12(this), 500L);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      HotWordSearchEntryDataModel.HotSearchItem localHotSearchItem = h;
      if (localHotSearchItem == null)
      {
        this.q.setHint(2131916125);
        return;
      }
      this.q.setHint(localHotSearchItem.title);
      this.q.setTag(h);
      this.q.setCursorVisible(true);
    }
    else
    {
      this.q.setHint(2131916125);
      this.q.setTag("");
    }
    v();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    Object localObject = this.y;
    if (localObject != null) {
      ((ISearchEntryFragment)localObject).afterTextChanged(paramEditable);
    }
    paramEditable = b(a(this.q, this.Z, this.aa));
    if ((this.Z) && (paramEditable.equals(this.p))) {
      return;
    }
    boolean bool = a(this.b, this.e);
    if ((!bool) && (this.x.H != 6)) {
      this.T = true;
    }
    if ((bool) && (this.x.H != 6)) {
      this.T = true;
    }
    if (TextUtils.isEmpty(j))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.app.getAccount());
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      j = ((StringBuilder)localObject).toString();
    }
    if (this.q.a())
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
    this.p = paramEditable;
    g = paramEditable;
    this.x.q = this.p;
    if (TextUtils.isEmpty(paramEditable))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(c(this.e));
      SearchUtils.a("home_page", "exp_home", new String[] { ((StringBuilder)localObject).toString() });
      this.t.setVisibility(8);
      t();
      this.x.m();
      v();
      localObject = this.z;
      if (localObject != null) {
        ((AssociateSearchWordsFragment)localObject).a(null);
      }
      if (n)
      {
        n = false;
        localObject = this.y;
        if (localObject != null) {
          ((ISearchEntryFragment)localObject).refresh();
        }
      }
      b(true);
    }
    else
    {
      SearchCostStat.a(paramEditable, this.e, this.K);
      this.K = false;
      this.t.setVisibility(0);
      v();
      if (this.y != null)
      {
        int i1 = this.e;
        if ((i1 != 25) && (i1 != 26))
        {
          a(paramEditable);
          b(false);
          break label462;
        }
      }
      if (!this.J)
      {
        I = true;
        a(paramEditable);
      }
      else
      {
        a(paramEditable, 0L);
      }
    }
    label462:
    if (!paramEditable.equals(this.p))
    {
      SearchUtils.e = 0L;
      o = 2;
    }
    if (!TextUtils.isEmpty(this.W)) {
      b(TextUtils.isEmpty(paramEditable));
    }
    paramEditable = this.z;
    if (paramEditable != null) {
      paramEditable.a(null);
    }
  }
  
  public double b()
  {
    return E;
  }
  
  void b(int paramInt)
  {
    FragmentTransaction localFragmentTransaction = this.G.beginTransaction();
    if (paramInt != 3)
    {
      if (paramInt != 4) {
        return;
      }
      if (this.y == null)
      {
        String str = y();
        this.y = SearchEntryFragmentFactory.a(str);
        Object localObject = this.app;
        ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("all_result").action("exp_entryweb").ver2(UniteSearchReportController.a(this.e));
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.app.getCurrentAccountUin());
        localStringBuilder.append(System.currentTimeMillis());
        UniteSearchReportController.a((AppInterface)localObject, localReportModelDC02528.session_id(localStringBuilder.toString()));
        this.y.setApp(this.app);
        localObject = new Bundle(9);
        ((Bundle)localObject).putInt("from", this.e);
        ((Bundle)localObject).putInt("source", this.b);
        ((Bundle)localObject).putString("tabType", str);
        this.y.setInitData((Bundle)localObject);
        localFragmentTransaction.add(2131432582, this.y.getFragment(), "search_entry_layout");
        localFragmentTransaction.commitAllowingStateLoss();
        this.O.setVisibility(0);
      }
    }
    else
    {
      if (this.z == null) {
        this.z = new AssociateSearchWordsFragment();
      }
      localFragmentTransaction.add(2131428818, this.z, "associated_words");
      localFragmentTransaction.commitAllowingStateLoss();
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    Object localObject1 = ((IReadInJoySearchJumpUrlConfProcessor)QRoute.api(IReadInJoySearchJumpUrlConfProcessor.class)).getConfig();
    if (localObject1 == null) {
      localObject1 = "";
    } else {
      localObject1 = ((IReadInJoySearchJumpUrlConfBean)localObject1).c();
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = "https://sou.qq.com/kandian/kd.html?_bid=3216&_wv=3&_wwv=1293&_wvSb=0&keyword=$KEYWORD$&from=$FROM$";
    }
    int i1 = this.e;
    if ((i1 != 25) && (i1 != 26))
    {
      ((String)localObject2).replace("$KEYWORD$", URLEncoder.encode(this.p));
      t();
      this.Q.setVisibility(0);
      a(paramInt);
      this.x.b(paramString);
      this.x.a(null);
      e(1);
    }
    else
    {
      if (!TextUtils.isEmpty(HuichuanConfigManager.a().b())) {
        localObject2 = HuichuanConfigManager.a().b();
      }
      localObject1 = ((String)localObject2).replace("$KEYWORD$", URLEncoder.encode(this.p));
      if (paramInt == 2) {
        localObject1 = ((String)localObject1).replace("$FROM$", "kandian_thinkword");
      } else {
        localObject1 = ((String)localObject1).replace("$FROM$", "kandian_search");
      }
      localObject2 = localObject1;
      if (SearchUtils.f((String)localObject1))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(URLEncoder.encode(i));
        localObject1 = ((String)localObject1).replace("$SEARCHID$", ((StringBuilder)localObject2).toString());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(URLEncoder.encode(j));
        localObject2 = ((String)localObject1).replace("$SEQNO$", ((StringBuilder)localObject2).toString());
      }
      SearchUtils.a(this.app, this, (String)localObject2, this.F);
    }
    localObject1 = this.y;
    if (localObject1 != null) {
      if (!TextUtils.equals(((ISearchEntryFragment)localObject1).getInitData().getString("tabType"), "kSearchDynamicTab"))
      {
        paramInt = this.e;
        if ((paramInt != 25) && (paramInt != 26)) {}
      }
      else
      {
        ((SearchWordHistoryManager)((QQAppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime()).getManager(QQManagerFactory.SEARCH_WORD_HISTORY_MANAGER)).a(paramString);
        this.y.refresh();
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
    Object localObject = this.O;
    if (localObject == null) {
      return;
    }
    if ((paramBoolean) && (((View)localObject).getVisibility() != 0) && (this.e != 12))
    {
      e(4);
      return;
    }
    if (((!paramBoolean) && (this.O.getVisibility() == 0)) || (this.e == 12)) {
      e(1);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = TextUtils.isEmpty(paramCharSequence);
    boolean bool1 = false;
    if ((bool2) && (paramInt1 == 0) && (paramInt2 == 0) && (this.Y))
    {
      this.Y = false;
      SQLiteFTSUtils.FtsItemClickEvent.a();
      SQLiteFTSUtils.FtsItemClickEvent.m = System.nanoTime();
    }
    if (paramInt3 == 0) {
      bool1 = true;
    }
    this.Z = bool1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramCharSequence);
    this.aa = localStringBuilder.toString();
  }
  
  public int c(int paramInt)
  {
    if (paramInt != 21) {
      return paramInt;
    }
    return 3;
  }
  
  protected GroupSearchFragment c()
  {
    try
    {
      long l1 = getIntent().getLongExtra("searchEngineKey", 0L);
      if (l1 > 0L)
      {
        localGroupSearchFragment = GroupSearchFragment.a(this.e, this.b, l1);
        localGroupSearchFragment.c(m);
        return localGroupSearchFragment;
      }
    }
    catch (Exception localException)
    {
      GroupSearchFragment localGroupSearchFragment;
      label39:
      break label39;
    }
    localGroupSearchFragment = GroupSearchFragment.a(this.e, this.b);
    localGroupSearchFragment.c(m);
    return localGroupSearchFragment;
  }
  
  public void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.p = paramString;
      this.q.setText(paramString);
      this.t.setVisibility(0);
      v();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onAssociateWordClick keyword = ");
        localStringBuilder.append(paramString);
        QLog.d("Q.uniteSearch.UniteSearchActivity", 2, localStringBuilder.toString());
      }
      this.q.setSelection(paramString.length());
    }
  }
  
  public void d()
  {
    ((InputMethodManager)getSystemService("input_method")).showSoftInput(this.q, 0);
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
    this.ab = paramInt1;
    Object localObject = this.x;
    if ((localObject != null) && (((GroupSearchFragment)localObject).r != null) && (this.x.r.size() > 0)) {
      e();
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
          c = paramIntent.getStringExtra("vsKey");
          d = paramIntent.getIntExtra("vsSource", 1);
          this.x.c(true);
          this.q.setText((CharSequence)localObject);
          this.q.setSelection(((String)localObject).length());
          a((String)localObject);
          e();
        }
      }
    }
    else if (paramInt1 == this.F)
    {
      paramIntent = this.y;
      if (paramIntent != null) {
        paramIntent.refresh();
      }
      this.q.setText("");
    }
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    QQAppInterface localQQAppInterface = this.app;
    ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("all_result").action("return").ver1(h()).ver2(UniteSearchReportController.a(this.e)).ver3(j).ver6(i);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.app.getCurrentAccountUin());
    localStringBuilder.append(System.currentTimeMillis());
    UniteSearchReportController.a(localQQAppInterface, localReportModelDC02528.session_id(localStringBuilder.toString()));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (TextUtils.isEmpty(HuichuanConfigManager.a().b())) {
      SearchUtils.a("还没拉到汇川配置，再重启一下手Q");
    } else {
      SearchUtils.a("拉到配置了，莽吧");
    }
    SearchUtil.b();
    this.e = super.getIntent().getIntExtra("fromType", -1);
    if (this.e != 26)
    {
      paramBundle = U;
      if (paramBundle != null)
      {
        U = this;
        paramBundle.finish();
      }
      else
      {
        U = this;
      }
    }
    this.H = new Handler();
    this.ab = super.getIntent().getIntExtra("requestCode", 0);
    this.app.addObserver(this.M);
    this.app.addObserver(this.N);
    o = -1;
    this.G = super.getSupportFragmentManager();
    int i1 = d(this.e);
    if (i1 != -1)
    {
      paramBundle = new StringBuilder();
      paramBundle.append(i1);
      paramBundle.append("_");
      paramBundle.append(this.app.getAccount());
      paramBundle.append("_");
      paramBundle.append(System.currentTimeMillis());
      i = paramBundle.toString();
    }
    else
    {
      i = "";
    }
    setContentView(l());
    paramBundle = super.findViewById(2131445137);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      paramBundle.setFitsSystemWindows(true);
    }
    try
    {
      paramBundle.setBackgroundResource(2130838959);
    }
    catch (Exception localException1)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("doOnCreate, e = ");
      ((StringBuilder)localObject2).append(QLog.getStackTraceString(localException1));
      QLog.e("Q.uniteSearch.UniteSearchActivity", 1, ((StringBuilder)localObject2).toString());
      try
      {
        paramBundle.setBackgroundResource(2130852150);
      }
      catch (Error localError)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("doOnCreate, e = ");
        ((StringBuilder)localObject2).append(QLog.getStackTraceString(localError));
        QLog.e("Q.uniteSearch.UniteSearchActivity", 1, ((StringBuilder)localObject2).toString());
      }
    }
    this.b = super.getIntent().getIntExtra("source", 0);
    f();
    x();
    this.p = super.getIntent().getStringExtra("keyword");
    Object localObject1 = (HotWordSearchEntryDataModel.HotSearchItem)super.getIntent().getSerializableExtra("home_hot_word");
    if ((localObject1 != null) && (!TextUtils.isEmpty(((HotWordSearchEntryDataModel.HotSearchItem)localObject1).title)))
    {
      h = (HotWordSearchEntryDataModel.HotSearchItem)localObject1;
      w();
      SearchUtils.a("home_page", "hot_list", new String[] { h.title, String.valueOf(s()) });
    }
    localObject1 = getResources().getDisplayMetrics();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(c(this.e));
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
      ((JSONObject)localObject1).put("experiment_id", UniteSearchReportController.b);
    }
    catch (JSONException localJSONException)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("e = ");
      localStringBuilder.append(localJSONException);
      QLog.e("Q.uniteSearch.UniteSearchActivity", 2, localStringBuilder.toString());
    }
    QQAppInterface localQQAppInterface = this.app;
    localObject1 = new ReportModelDC02528().module("all_result").action("active_search").ver2(UniteSearchReportController.a(this.e)).ver7(((JSONObject)localObject1).toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.app.getCurrentAccountUin());
    localStringBuilder.append(System.currentTimeMillis());
    UniteSearchReportController.a(localQQAppInterface, ((ReportModelDC02528)localObject1).session_id(localStringBuilder.toString()));
    if (TextUtils.isEmpty(this.p))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(c(this.e));
      SearchUtils.a("home_page", "exp_home", new String[] { ((StringBuilder)localObject1).toString() });
    }
    localObject1 = super.getSupportFragmentManager();
    this.x = c();
    ((FragmentManager)localObject1).beginTransaction().replace(2131434451, this.x).commitAllowingStateLoss();
    SearchUtils.d = System.currentTimeMillis();
    if (this.e == 12) {
      this.q.setHint(String.format(getResources().getString(2131894280), new Object[] { ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.app, getApplicationContext()) }));
    }
    this.W = SearchHistoryManager.a(this.app);
    if (!TextUtils.isEmpty(this.W))
    {
      i1 = this.e;
      if ((i1 != 12) && (i1 != 14))
      {
        localObject1 = this.y;
        if (localObject1 != null) {
          ((ISearchEntryFragment)localObject1).refresh();
        }
      }
    }
    this.Y = true;
    this.O = paramBundle.findViewById(2131432582);
    this.P = paramBundle.findViewById(2131428818);
    this.Q = paramBundle.findViewById(2131434451);
    if (TextUtils.isEmpty(this.p))
    {
      e(4);
      v();
    }
    else
    {
      e(3);
    }
    paramBundle = this.q;
    paramBundle.a = 50;
    paramBundle.setFilters(new InputFilter[] { new InputFilter.LengthFilter(50) });
    this.L = new UniteSearchActivity.CancelReceiver(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.search.cancel");
    super.registerReceiver(this.L, paramBundle);
    g();
    if (!TextUtils.isEmpty(this.p))
    {
      if (this.p.length() > 50) {
        this.p = this.p.substring(0, 50);
      }
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("自动搜索 isViewCreated:");
        paramBundle.append(this.x.c);
        QLog.i("Q.uniteSearch.UniteSearchActivity", 2, paramBundle.toString());
      }
      this.x.d = true;
      if (this.e == 4) {
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
      if ((this.e != 25) || (!HotWordSearchEntryModel.a(paramBundle))) {
        this.H.postDelayed(new UniteSearchActivity.3(this), 500L);
      }
    }
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
    AbstractGifImage.resumeAll();
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (U == this) {
      U = null;
    }
    try
    {
      if (this.L != null)
      {
        super.unregisterReceiver(this.L);
        this.L = null;
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    this.S.removeMessages(101);
    this.H.removeCallbacksAndMessages(null);
    this.app.removeObserver(this.M);
    this.app.removeObserver(this.N);
    PAOfflineSearchManager.a().b();
    f = -1;
    try
    {
      e();
      this.q.setFocusable(false);
      this.q.setFocusableInTouchMode(false);
      this.q.setVisibility(8);
      if (this.q.getParent() != null) {
        ((ViewGroup)this.q.getParent()).removeView(this.q);
      }
      this.q.removeTextChangedListener(this);
      this.q.setOnEditorActionListener(null);
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
    SearchUtils.i = null;
    o = -1;
    GroupSearchFragment localGroupSearchFragment = this.x;
    if (localGroupSearchFragment != null) {
      localGroupSearchFragment.s();
    }
    e();
    SearchUtils.e();
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
    SearchUtils.d = -1L;
    RichNodeController.c();
    ApngImage.pauseByTag(41);
    e();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    RichNodeController.d();
    if (!this.l) {
      UniteSearchReportController.a(null, new ReportModelDC02528().module("all_result").action("return").ver2(UniteSearchReportController.a(this.e)).ver3(j).ver6(i));
    }
    this.l = false;
    j = "";
    ApngImage.playByTag(41);
  }
  
  protected void doOnStart() {}
  
  protected void doOnStop()
  {
    super.doOnStop();
    if ((!SQLiteFTSUtils.FtsItemClickEvent.q) && (SQLiteFTSUtils.FtsItemClickEvent.f != 1))
    {
      SQLiteFTSUtils.FtsItemClickEvent.n += (System.nanoTime() - SQLiteFTSUtils.FtsItemClickEvent.m) / 1000000L;
      SQLiteFTSUtils.FtsItemClickEvent.p += (System.nanoTime() - SQLiteFTSUtils.FtsItemClickEvent.o) / 1000000L;
    }
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.X))
    {
      this.X = true;
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(this.app.getCurrentAccountUin(), "GroupSearchLaunchTime", true, System.currentTimeMillis() - a, 0L, null, "", false);
    }
  }
  
  public void e()
  {
    ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.q.getWindowToken(), 0);
    this.q.clearFocus();
  }
  
  protected void f()
  {
    if (!a(this.b, this.e))
    {
      this.B = ((UniteSearchHandler)this.app.getBusinessHandler(BusinessHandlerFactory.UNITE_SEARCH_HANDLER));
      this.C = null;
      return;
    }
    this.B = null;
    this.C = ((UnifySearchHandler)this.app.getBusinessHandler(BusinessHandlerFactory.UNIFY_SEARCH_UNITE_HANDLER));
  }
  
  public void finish()
  {
    if (m) {
      ReportController.b(this.app, "CliOper", "", "", "0X8007E2D", "0X8007E2D", 0, o, "", "", "", "");
    }
    setResult(-1, getIntent());
    super.finish();
    overridePendingTransition(0, 2130772473);
  }
  
  protected void g()
  {
    int i1 = d(this.e);
    if (this.B != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "getUniteSearchDiscovery use old protocl");
      }
      this.B.a(this.app, i1);
      return;
    }
    if (this.C != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "getUniteSearchDiscovery use new protocl");
      }
      this.C.a(this.app, i1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "getUniteSearchDiscovery error");
    }
  }
  
  public String h()
  {
    return this.q.getText().toString();
  }
  
  public int i()
  {
    return 1;
  }
  
  public long[] j()
  {
    return new long[0];
  }
  
  public boolean k()
  {
    QuickPinyinEditText localQuickPinyinEditText = this.q;
    if (localQuickPinyinEditText == null) {
      return false;
    }
    return localQuickPinyinEditText.a();
  }
  
  protected int l()
  {
    return 2131629614;
  }
  
  public boolean m()
  {
    return this.T;
  }
  
  public QBaseFragment n()
  {
    return this.x;
  }
  
  public void o()
  {
    UniteSearchReportController.a(null, new ReportModelDC02528().module("search_box_bt_homepage").action("clk_search_box_bt").ver2("kandian").session_id(this.app.getCurrentAccountUin()));
    new UniteSearchHandler(this.app).b(this.app, "clk_search_box_bt", "search_box_bt_homepage", "kandian", "", "", "");
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if ((paramInt != 3) && ((paramKeyEvent == null) || (paramKeyEvent.getKeyCode() != 66))) {
      bool = false;
    } else if ((paramKeyEvent == null) || (paramKeyEvent.getAction() == 1)) {
      u();
    }
    EventCollector.getInstance().onEditorAction(paramTextView, paramInt, paramKeyEvent);
    return bool;
  }
  
  protected void onRestart()
  {
    super.onRestart();
    int i1 = this.e;
    if ((i1 == 25) || (i1 == 26)) {
      this.q.setText("");
    }
    if ((!SQLiteFTSUtils.FtsItemClickEvent.q) && (SQLiteFTSUtils.FtsItemClickEvent.f != 1))
    {
      SQLiteFTSUtils.FtsItemClickEvent.m = System.nanoTime();
      SQLiteFTSUtils.FtsItemClickEvent.o = System.nanoTime();
    }
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    QuickPinyinEditText localQuickPinyinEditText = this.q;
    if (localQuickPinyinEditText != null) {
      localQuickPinyinEditText.removeTextChangedListener(this);
    }
    super.onRestoreInstanceState(paramBundle);
    paramBundle = this.q;
    if (paramBundle != null) {
      paramBundle.addTextChangedListener(this);
    }
  }
  
  public void onSoftKeyboardClosed()
  {
    this.q.setCursorVisible(false);
    ISearchEntryFragment localISearchEntryFragment = this.y;
    if (localISearchEntryFragment != null) {
      localISearchEntryFragment.onSoftKeyboardClosed();
    }
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    this.q.setCursorVisible(true);
    ISearchEntryFragment localISearchEntryFragment = this.y;
    if (localISearchEntryFragment != null) {
      localISearchEntryFragment.onSoftKeyboardOpened(paramInt);
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void p()
  {
    UniteSearchReportController.a(null, new ReportModelDC02528().module("search_box_back").action("clk_search_box_back").ver2("kandian").session_id(this.app.getCurrentAccountUin()));
    new UniteSearchHandler(this.app).b(this.app, "clk_search_box_back", "search_box_back", "kandian", "", "", "");
  }
  
  protected void q()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cancelType-2 ResultModule:");
      ((StringBuilder)localObject).append(SearchStatisticsConstants.a());
      QLog.d("searchUtils", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.Q;
    if ((localObject != null) && (((View)localObject).getVisibility() == 0)) {
      UniteSearchReportController.a(this.app, 0, this.e, "0X8009D2A", 0, 0, null, null);
    } else {
      UniteSearchReportController.a(this.app, 0, this.e, "0X8009D17", 0, 0, null, null);
    }
    localObject = this.app;
    ReportModelDC02528 localReportModelDC02528 = new ReportModelDC02528().module("all_result").action("cancel").ver1(h()).ver2(UniteSearchReportController.a(this.e)).ver3(j).ver6(i);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.app.getCurrentAccountUin());
    localStringBuilder.append(System.currentTimeMillis());
    UniteSearchReportController.a((AppInterface)localObject, localReportModelDC02528.session_id(localStringBuilder.toString()));
    ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.q.getWindowToken(), 0);
    o = 0;
    getIntent().putExtra("keyword", this.p);
    finish();
  }
  
  protected void r()
  {
    if (this.B != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "sendAssociationWordRequest use old protocl");
      }
      int i1 = this.e;
      if ((i1 != 25) && (i1 != 26))
      {
        this.B.a(this.R.a, 1, false);
        return;
      }
      this.B.a(this.R.a, 1, true);
      return;
    }
    if (this.C != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "sendAssociationWordRequest use new protocl");
      }
      this.C.a(this.R.a);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.UniteSearchActivity", 2, "sendAssociationWordRequest error");
    }
  }
  
  public int s()
  {
    int i1 = this.e;
    if (i1 != 21)
    {
      if ((i1 != 25) && (i1 != 26)) {
        return i1;
      }
      return 10;
    }
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.UniteSearchActivity
 * JD-Core Version:    0.7.0.1
 */