package com.tencent.mobileqq.webview.swift.component;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webview.SwiftWebTitleBuilder;
import com.tencent.mobileqq.webview.WebViewTitleStyle;
import com.tencent.mobileqq.webview.WebViewTitleStyleHelper;
import com.tencent.mobileqq.webview.swift.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.swift.SwiftFloatViewBuilder;
import com.tencent.mobileqq.webview.swift.SwiftFloatViewUI;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.theme.SkinEngine;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class SwiftBrowserUIStyleHandler
  extends SwiftBrowserComponentsProvider.SwiftBrowserComponent
  implements View.OnClickListener, Animation.AnimationListener
{
  public TextView A;
  public ProgressBar B;
  public boolean C = false;
  public View D;
  public int E = -1;
  public int F = -1;
  public String G = "";
  private boolean H = false;
  private SwiftBrowserStatistics I = null;
  private View.OnClickListener a;
  public boolean c = false;
  public boolean d = true;
  long e = 0L;
  public final SwiftBrowserUIStyle f = new SwiftBrowserUIStyle();
  public SwiftIphoneTitleBarUI g;
  public SwiftFloatViewUI h;
  public Activity i;
  public ViewGroup j = null;
  public ImageView k;
  public ImageView l;
  Animation m;
  Animation n;
  public View o;
  public ViewGroup p;
  public TextView q;
  public WebViewProvider r;
  public View s;
  public boolean t = false;
  public ViewGroup u;
  public WebViewProgressBar v;
  public WebViewProgressBarController w;
  public ViewGroup x;
  public FrameLayout y;
  public TextView z;
  
  private void a(Uri paramUri)
  {
    String str = "unknown";
    if (paramUri != null) {}
    try
    {
      str = paramUri.getHost();
      if ((this.f.c & 0x20000) != 0L) {
        ReportController.a(null, "dc00898", "", "", "0X800ADD8", "0X800ADD8", 131072, 0, "", "", str, "");
      }
      if ((this.f.c & 0x1000000) != 0L) {
        ReportController.a(null, "dc00898", "", "", "0X800ADD8", "0X800ADD8", 16777216, 0, "", "", str, "");
      }
      if ((this.f.c & 0x2) != 0L)
      {
        ReportController.a(null, "dc00898", "", "", "0X800ADD8", "0X800ADD8", 2, 0, "", "", str, "");
        return;
      }
    }
    catch (Throwable paramUri)
    {
      QLog.e("SwiftBrowserUIStyleHandler", 1, paramUri, new Object[0]);
    }
  }
  
  private void a(Bundle paramBundle)
  {
    if (!this.I.at)
    {
      localObject = this.w;
      if ((localObject != null) && (((WebViewProgressBarController)localObject).d() != 0)) {
        this.w.a((byte)0);
      }
    }
    this.B.setVisibility(8);
    Object localObject = null;
    if ((paramBundle != null) && (paramBundle.containsKey("url"))) {
      paramBundle = paramBundle.getString("url");
    } else {
      paramBundle = null;
    }
    if (!TextUtils.isEmpty(paramBundle)) {
      localObject = Uri.parse(paramBundle);
    }
    if ((localObject != null) && (((Uri)localObject).isHierarchical()) && ("simple".equals(((Uri)localObject).getQueryParameter("style"))))
    {
      this.g.h.setVisibility(8);
      this.f.J = true;
    }
    a(this.b.a());
  }
  
  private void a(String paramString1, String paramString2, long paramLong)
  {
    try
    {
      long l1 = System.currentTimeMillis();
      if (!"1".equals(AuthorizeConfig.a().c("wv_ctrl_switch", "")))
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("SwiftBrowserUIStyleHandler", 2, "checkWvParamAuthorize disable");
        return;
      }
      boolean bool = AuthorizeConfig.a().a(paramString2, paramString1);
      if ((!bool) && ((this.f.c & paramLong) != 0L))
      {
        paramString1 = this.f;
        paramString1.c &= (paramLong ^ 0xFFFFFFFF);
        if (QLog.isColorLevel()) {
          QLog.d("SwiftBrowserUIStyleHandler", 2, new Object[] { "no authorize for wv param domain:", paramString2, " wv:", Long.valueOf(paramLong) });
        }
      }
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        QLog.d("SwiftBrowserUIStyleHandler", 2, new Object[] { "checkWvParamAuthorize cost:", Long.valueOf(l2 - l1), " domain:", paramString2, " wv:", Long.valueOf(paramLong) });
        return;
      }
    }
    catch (Throwable paramString1)
    {
      QLog.e("SwiftBrowserUIStyleHandler", 1, paramString1, new Object[0]);
    }
    return;
  }
  
  /* Error */
  private WebViewTitleStyle c(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore 12
    //   6: aconst_null
    //   7: astore 13
    //   9: iload 12
    //   11: ifeq +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: aload_1
    //   17: invokestatic 180	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   20: astore 14
    //   22: aload 13
    //   24: astore_1
    //   25: aload 14
    //   27: ifnull +273 -> 300
    //   30: aload 13
    //   32: astore_1
    //   33: aload 14
    //   35: invokevirtual 184	android/net/Uri:isHierarchical	()Z
    //   38: ifeq +262 -> 300
    //   41: aload 14
    //   43: ldc_w 274
    //   46: invokevirtual 191	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   49: astore_1
    //   50: aload 14
    //   52: ldc_w 276
    //   55: invokevirtual 191	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   58: astore 15
    //   60: aload 14
    //   62: ldc_w 278
    //   65: invokevirtual 191	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   68: astore 16
    //   70: aload 14
    //   72: ldc_w 280
    //   75: invokevirtual 191	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   78: astore 14
    //   80: iconst_0
    //   81: istore 5
    //   83: iconst_0
    //   84: istore_2
    //   85: iconst_m1
    //   86: istore 11
    //   88: aload_1
    //   89: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   92: ifne +15 -> 107
    //   95: aload_0
    //   96: aload_1
    //   97: invokespecial 283	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:e	(Ljava/lang/String;)I
    //   100: istore_2
    //   101: iconst_1
    //   102: istore 5
    //   104: goto +10 -> 114
    //   107: iconst_m1
    //   108: istore_3
    //   109: iload_2
    //   110: istore 5
    //   112: iload_3
    //   113: istore_2
    //   114: aload 15
    //   116: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   119: ifne +16 -> 135
    //   122: aload_0
    //   123: aload 15
    //   125: invokespecial 283	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:e	(Ljava/lang/String;)I
    //   128: istore_3
    //   129: iconst_1
    //   130: istore 5
    //   132: goto +5 -> 137
    //   135: iload_2
    //   136: istore_3
    //   137: aload 16
    //   139: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   142: ifne +17 -> 159
    //   145: aload_0
    //   146: aload 16
    //   148: invokespecial 283	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:e	(Ljava/lang/String;)I
    //   151: istore 4
    //   153: iconst_1
    //   154: istore 5
    //   156: goto +6 -> 162
    //   159: iconst_m1
    //   160: istore 4
    //   162: iload_2
    //   163: istore 10
    //   165: iload_3
    //   166: istore 9
    //   168: iload 4
    //   170: istore 7
    //   172: iload 5
    //   174: istore 6
    //   176: iload 11
    //   178: istore 8
    //   180: aload 14
    //   182: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   185: ifne +75 -> 260
    //   188: aload_0
    //   189: aload 14
    //   191: invokespecial 283	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:e	(Ljava/lang/String;)I
    //   194: istore 8
    //   196: iconst_1
    //   197: istore 6
    //   199: iload_2
    //   200: istore 10
    //   202: iload_3
    //   203: istore 9
    //   205: iload 4
    //   207: istore 7
    //   209: goto +51 -> 260
    //   212: astore_1
    //   213: goto +19 -> 232
    //   216: astore_1
    //   217: goto +12 -> 229
    //   220: astore_1
    //   221: goto +6 -> 227
    //   224: astore_1
    //   225: iconst_m1
    //   226: istore_2
    //   227: iconst_m1
    //   228: istore_3
    //   229: iconst_m1
    //   230: istore 4
    //   232: ldc 127
    //   234: iconst_1
    //   235: ldc_w 285
    //   238: aload_1
    //   239: invokestatic 288	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   242: iload 11
    //   244: istore 8
    //   246: iload 5
    //   248: istore 6
    //   250: iload 4
    //   252: istore 7
    //   254: iload_3
    //   255: istore 9
    //   257: iload_2
    //   258: istore 10
    //   260: aload 13
    //   262: astore_1
    //   263: iload 6
    //   265: ifeq +35 -> 300
    //   268: new 290	com/tencent/mobileqq/webview/WebViewTitleStyle
    //   271: dup
    //   272: invokespecial 291	com/tencent/mobileqq/webview/WebViewTitleStyle:<init>	()V
    //   275: astore_1
    //   276: aload_1
    //   277: iload 9
    //   279: putfield 293	com/tencent/mobileqq/webview/WebViewTitleStyle:b	I
    //   282: aload_1
    //   283: iload 10
    //   285: putfield 295	com/tencent/mobileqq/webview/WebViewTitleStyle:c	I
    //   288: aload_1
    //   289: iload 7
    //   291: putfield 297	com/tencent/mobileqq/webview/WebViewTitleStyle:d	I
    //   294: aload_1
    //   295: iload 8
    //   297: putfield 299	com/tencent/mobileqq/webview/WebViewTitleStyle:e	I
    //   300: aload_1
    //   301: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	302	0	this	SwiftBrowserUIStyleHandler
    //   0	302	1	paramString	String
    //   84	174	2	i1	int
    //   108	147	3	i2	int
    //   151	100	4	i3	int
    //   81	166	5	i4	int
    //   174	90	6	i5	int
    //   170	120	7	i6	int
    //   178	118	8	i7	int
    //   166	112	9	i8	int
    //   163	121	10	i9	int
    //   86	157	11	i10	int
    //   4	6	12	bool	boolean
    //   7	254	13	localObject1	Object
    //   20	170	14	localObject2	Object
    //   58	66	15	str1	String
    //   68	79	16	str2	String
    // Exception table:
    //   from	to	target	type
    //   180	196	212	java/lang/Exception
    //   137	153	216	java/lang/Exception
    //   114	129	220	java/lang/Exception
    //   88	101	224	java/lang/Exception
  }
  
  /* Error */
  private WebViewTitleStyle d(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore 12
    //   6: aconst_null
    //   7: astore 13
    //   9: iload 12
    //   11: ifeq +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: aload_1
    //   17: invokestatic 180	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   20: astore 14
    //   22: aload 13
    //   24: astore_1
    //   25: aload 14
    //   27: ifnull +298 -> 325
    //   30: aload 13
    //   32: astore_1
    //   33: aload 14
    //   35: invokevirtual 184	android/net/Uri:isHierarchical	()Z
    //   38: ifeq +287 -> 325
    //   41: aload 14
    //   43: ldc_w 301
    //   46: invokevirtual 191	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   49: astore_1
    //   50: aload 14
    //   52: ldc_w 303
    //   55: invokevirtual 191	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   58: astore 15
    //   60: aload 14
    //   62: ldc_w 305
    //   65: invokevirtual 191	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   68: astore 16
    //   70: aload 14
    //   72: ldc_w 307
    //   75: invokevirtual 191	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   78: astore 14
    //   80: iconst_0
    //   81: istore_3
    //   82: iconst_m1
    //   83: istore 10
    //   85: iconst_1
    //   86: istore 11
    //   88: aload_1
    //   89: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   92: ifne +15 -> 107
    //   95: aload_0
    //   96: aload_1
    //   97: invokespecial 283	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:e	(Ljava/lang/String;)I
    //   100: istore_2
    //   101: iconst_1
    //   102: istore 5
    //   104: goto +8 -> 112
    //   107: iconst_m1
    //   108: istore_2
    //   109: iconst_0
    //   110: istore 5
    //   112: iload 5
    //   114: istore 6
    //   116: aload 15
    //   118: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   121: ifne +13 -> 134
    //   124: aload_0
    //   125: aload 15
    //   127: invokespecial 283	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:e	(Ljava/lang/String;)I
    //   130: istore_3
    //   131: iconst_1
    //   132: istore 6
    //   134: aload 16
    //   136: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   139: ifne +17 -> 156
    //   142: aload_0
    //   143: aload 16
    //   145: invokespecial 283	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:e	(Ljava/lang/String;)I
    //   148: istore 4
    //   150: iconst_1
    //   151: istore 5
    //   153: goto +10 -> 163
    //   156: iconst_m1
    //   157: istore 4
    //   159: iload 6
    //   161: istore 5
    //   163: iload_2
    //   164: istore 7
    //   166: iload 4
    //   168: istore 6
    //   170: iload_3
    //   171: istore 8
    //   173: iload 5
    //   175: istore 9
    //   177: aload 14
    //   179: invokestatic 176	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   182: ifne +91 -> 273
    //   185: aload_0
    //   186: aload 14
    //   188: invokespecial 283	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:e	(Ljava/lang/String;)I
    //   191: istore 6
    //   193: iload 6
    //   195: istore 5
    //   197: iload 11
    //   199: istore 9
    //   201: goto +86 -> 287
    //   204: astore_1
    //   205: iload_2
    //   206: istore 7
    //   208: iload 5
    //   210: istore_2
    //   211: goto +42 -> 253
    //   214: astore_1
    //   215: iconst_m1
    //   216: istore 4
    //   218: iload_2
    //   219: istore 7
    //   221: iload 6
    //   223: istore_2
    //   224: goto +29 -> 253
    //   227: astore_1
    //   228: iconst_m1
    //   229: istore 4
    //   231: iconst_m1
    //   232: istore_3
    //   233: iload_2
    //   234: istore 7
    //   236: iload 5
    //   238: istore_2
    //   239: goto +14 -> 253
    //   242: astore_1
    //   243: iconst_m1
    //   244: istore 7
    //   246: iconst_m1
    //   247: istore 4
    //   249: iconst_m1
    //   250: istore_3
    //   251: iconst_0
    //   252: istore_2
    //   253: ldc 127
    //   255: iconst_1
    //   256: ldc_w 285
    //   259: aload_1
    //   260: invokestatic 288	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   263: iload_2
    //   264: istore 9
    //   266: iload_3
    //   267: istore 8
    //   269: iload 4
    //   271: istore 6
    //   273: iload 10
    //   275: istore 5
    //   277: iload 8
    //   279: istore_3
    //   280: iload 6
    //   282: istore 4
    //   284: iload 7
    //   286: istore_2
    //   287: aload 13
    //   289: astore_1
    //   290: iload 9
    //   292: ifeq +33 -> 325
    //   295: new 290	com/tencent/mobileqq/webview/WebViewTitleStyle
    //   298: dup
    //   299: invokespecial 291	com/tencent/mobileqq/webview/WebViewTitleStyle:<init>	()V
    //   302: astore_1
    //   303: aload_1
    //   304: iload_3
    //   305: putfield 293	com/tencent/mobileqq/webview/WebViewTitleStyle:b	I
    //   308: aload_1
    //   309: iload_2
    //   310: putfield 295	com/tencent/mobileqq/webview/WebViewTitleStyle:c	I
    //   313: aload_1
    //   314: iload 4
    //   316: putfield 297	com/tencent/mobileqq/webview/WebViewTitleStyle:d	I
    //   319: aload_1
    //   320: iload 5
    //   322: putfield 299	com/tencent/mobileqq/webview/WebViewTitleStyle:e	I
    //   325: aload_1
    //   326: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	this	SwiftBrowserUIStyleHandler
    //   0	327	1	paramString	String
    //   100	210	2	i1	int
    //   81	224	3	i2	int
    //   148	167	4	i3	int
    //   102	219	5	i4	int
    //   114	167	6	i5	int
    //   164	121	7	i6	int
    //   171	107	8	i7	int
    //   175	116	9	i8	int
    //   83	191	10	i9	int
    //   86	112	11	i10	int
    //   4	6	12	bool	boolean
    //   7	281	13	localObject1	Object
    //   20	167	14	localObject2	Object
    //   58	68	15	str1	String
    //   68	76	16	str2	String
    // Exception table:
    //   from	to	target	type
    //   177	193	204	java/lang/Exception
    //   134	150	214	java/lang/Exception
    //   116	131	227	java/lang/Exception
    //   88	101	242	java/lang/Exception
  }
  
  private int e(String paramString)
  {
    String str;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (paramString.startsWith("0x")) {
        str = paramString.substring(2);
      }
      paramString = str;
    }
    try
    {
      if (!str.startsWith("#"))
      {
        paramString = new StringBuilder();
        paramString.append("#");
        paramString.append(str);
        paramString = paramString.toString();
      }
      int i1 = Color.parseColor(paramString);
      return i1;
    }
    catch (NumberFormatException paramString)
    {
      label71:
      break label71;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("SwiftBrowserUIStyleHandler", 4, "Illegal getColorIntFromUrlParams");
    }
    return -1;
  }
  
  private void m()
  {
    if ((this.f.d & 0x2000) > 0L) {
      this.f.y = true;
    }
    if ((this.f.g & 1L) > 0L) {
      this.f.b = true;
    }
    if ((this.f.g & 0x8) > 0L) {
      this.f.v = true;
    }
  }
  
  private void n()
  {
    Object localObject = this.w;
    if (localObject != null) {
      ((WebViewProgressBarController)localObject).a((byte)2);
    }
    this.B.setVisibility(8);
    if (!this.f.O)
    {
      if (this.z == null) {
        return;
      }
      localObject = this.D;
      if ((localObject != null) && (this.E == -1)) {
        ((View)localObject).setBackgroundResource(2131168452);
      }
      this.z.setVisibility(0);
      if (this.b.a() != null)
      {
        TouchWebView localTouchWebView = (TouchWebView)this.b.a();
        if (this.A != null) {
          if (localTouchWebView.getX5WebViewExtension() != null) {
            this.A.setVisibility(0);
          } else {
            this.A.setVisibility(8);
          }
        }
        localObject = null;
        ViewGroup localViewGroup = this.u;
        if ((localViewGroup instanceof RefreshView)) {
          localObject = (RefreshView)localViewGroup;
        }
        if (localObject == null) {
          return;
        }
        if (this.d)
        {
          localTouchWebView.setOnOverScrollHandler(new SwiftBrowserUIStyleHandler.1(this, localTouchWebView, (RefreshView)localObject));
          localTouchWebView.setOnScrollChangedListener(new SwiftBrowserUIStyleHandler.2(this));
          b(this.b.a());
        }
      }
    }
  }
  
  public void a()
  {
    super.a();
    this.i = this.b.b();
    this.r = this.b.c();
    this.I = ((SwiftBrowserStatistics)this.b.d().a(-2));
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    super.a(paramInt, paramBundle);
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 6)
          {
            if (paramInt != 7) {
              return;
            }
            n();
            return;
          }
          a(paramBundle);
          return;
        }
        if ((this.h.c != null) && (8 == this.h.e.getVisibility())) {
          this.h.a();
        }
        if (paramBundle.containsKey("Configuration")) {
          paramBundle = (Configuration)paramBundle.getParcelable("Configuration");
        } else {
          paramBundle = null;
        }
        if ((paramBundle != null) && (this.h.e != null) && (paramBundle.orientation == 2) && (this.h.e.getVisibility() == 0)) {
          this.h.e.setVisibility(8);
        }
      }
      else
      {
        paramBundle = this.s;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.getParent();
          if ((paramBundle != null) && ((paramBundle instanceof ViewGroup))) {
            ((ViewGroup)paramBundle).removeView(this.s);
          }
        }
        this.g.i();
        this.g.e();
      }
    }
    else
    {
      Util.f("Web_updateTitleBarUI");
      if (this.f.B) {
        this.g.k();
      }
      Util.g("Web_updateTitleBarUI");
    }
  }
  
  public void a(Intent paramIntent)
  {
    if (((this.f.c & 0x20000) == 0L) && (!paramIntent.getBooleanExtra("isFullScreen", false))) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if (i1 != 0) {
      this.f.a = true;
    }
    SwiftBrowserUIStyle localSwiftBrowserUIStyle = this.f;
    boolean bool;
    if (((localSwiftBrowserUIStyle.c & 0x1000000) == 0L) && (!paramIntent.getBooleanExtra("isTransparentTitle", false))) {
      bool = false;
    } else {
      bool = true;
    }
    localSwiftBrowserUIStyle.b = bool;
    localSwiftBrowserUIStyle = this.f;
    if (((localSwiftBrowserUIStyle.d & 1L) == 0L) && (!paramIntent.getBooleanExtra("isTransparentTitleAndClickable", false))) {
      bool = false;
    } else {
      bool = true;
    }
    localSwiftBrowserUIStyle.v = bool;
    localSwiftBrowserUIStyle = this.f;
    if (((localSwiftBrowserUIStyle.c & 0x2) == 0L) && (!paramIntent.getBooleanExtra("hide_more_button", false))) {
      bool = false;
    } else {
      bool = true;
    }
    localSwiftBrowserUIStyle.l = bool;
    localSwiftBrowserUIStyle = this.f;
    if (((localSwiftBrowserUIStyle.c & 1L) == 0L) && (!paramIntent.getBooleanExtra("hide_operation_bar", false)) && (!"noBottomBar".equals(paramIntent.getStringExtra("webStyle")))) {
      bool = false;
    } else {
      bool = true;
    }
    localSwiftBrowserUIStyle.m = bool;
    localSwiftBrowserUIStyle = this.f;
    if ((localSwiftBrowserUIStyle.d & 0x100) != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    localSwiftBrowserUIStyle.x = bool;
    if (!TextUtils.isEmpty(paramIntent.getStringExtra("key_params_qq")))
    {
      localSwiftBrowserUIStyle = this.f;
      localSwiftBrowserUIStyle.l = true;
      localSwiftBrowserUIStyle.m = true;
    }
    int i1 = paramIntent.getIntExtra("reqType", -1);
    if ((!this.f.m) && (i1 == 6)) {
      this.f.m = true;
    }
    this.f.n = paramIntent.getBooleanExtra("fromOneCLickCLose", false);
    this.f.z = paramIntent.getBooleanExtra("rightTopCancel", false);
    this.f.A = paramIntent.getBooleanExtra("webViewMoveTop", false);
    if ((!this.f.l) && ((i1 == 3) || (i1 == 1) || (!paramIntent.getBooleanExtra("ba_is_login", true)) || (i1 == 7))) {
      this.f.l = true;
    }
    if ((this.f.c & 0x20000) > 0L) {
      this.f.a = true;
    }
    if ((this.f.c & 0x20000000) != 0L) {
      this.f.B = true;
    }
    if ((this.f.c & 0x800) > 0L)
    {
      localSwiftBrowserUIStyle = this.f;
      localSwiftBrowserUIStyle.k = true;
      localSwiftBrowserUIStyle.o = Boolean.valueOf(false);
    }
    if ((this.f.d & 0x4) > 0L)
    {
      localSwiftBrowserUIStyle = this.f;
      localSwiftBrowserUIStyle.k = false;
      localSwiftBrowserUIStyle.o = Boolean.valueOf(true);
    }
    if ((this.f.d & 0x2) > 0L) {
      this.f.p = true;
    }
    if ((this.f.d & 0x200) > 0L) {
      this.f.O = true;
    }
    if ((this.f.d & 0x400) > 0L)
    {
      localSwiftBrowserUIStyle = this.f;
      localSwiftBrowserUIStyle.M = true;
      localSwiftBrowserUIStyle.P = true;
    }
    m();
    if (paramIntent.getBooleanExtra("from_single_task", false))
    {
      this.f.T = true;
      return;
    }
    if ((this.f.c & 0x80000000) > 0L) {
      this.f.S = AuthorizeConfig.a().f("aio_authorize_config", paramIntent.getStringExtra("url"));
    }
  }
  
  public void a(Intent paramIntent, String paramString)
  {
    this.g.a(paramIntent, paramString);
    a(this.f.I, false);
    c();
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.a = paramOnClickListener;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.g.a(paramView, paramInt1, paramInt2, paramInt3);
  }
  
  public void a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramView == null) {
      return;
    }
    int i1;
    if ((this.f.M) && (!"1000".equals(ThemeUtil.getCurrentThemeId()))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    Drawable localDrawable;
    if (paramBoolean)
    {
      if (i1 != 0)
      {
        localDrawable = SkinEngine.getInstances().getDefaultThemeDrawable(paramInt1);
        if (localDrawable != null)
        {
          paramView.setBackgroundDrawable(localDrawable);
          return;
        }
      }
      paramView.setBackgroundResource(paramInt2);
      return;
    }
    if ((paramView instanceof ImageView))
    {
      paramView = (ImageView)paramView;
      if (i1 != 0)
      {
        localDrawable = SkinEngine.getInstances().getDefaultThemeDrawable(paramInt1);
        if (localDrawable != null)
        {
          paramView.setImageDrawable(localDrawable);
          return;
        }
      }
      paramView.setImageResource(paramInt2);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("-->setShowDefaultThemeIcon err! resId=");
      paramView.append(paramInt1);
      QLog.d("AbsBaseWebViewActivity", 2, paramView.toString());
    }
  }
  
  public void a(TouchWebView paramTouchWebView)
  {
    this.g.a(paramTouchWebView);
  }
  
  @TargetApi(14)
  public void a(WebBrowserViewContainer paramWebBrowserViewContainer, Intent paramIntent, TouchWebView paramTouchWebView)
  {
    long l2 = System.currentTimeMillis();
    this.y = ((FrameLayout)paramWebBrowserViewContainer.findViewById(2131433916));
    this.y.setVisibility(0);
    if ((this.f.a) && (this.f.e != 0L))
    {
      paramWebBrowserViewContainer.b(this.f.U);
      this.h.a(paramWebBrowserViewContainer, this.a);
      this.h.a(this.i);
    }
    long l1 = System.currentTimeMillis();
    this.I.w = (l1 - l2);
    this.v = ((WebViewProgressBar)this.y.findViewById(2131440738));
    this.w = new WebViewProgressBarController();
    this.v.setController(this.w);
    this.w.a(this.C ^ true);
    if (this.I.at)
    {
      paramIntent = this.w;
      if ((paramIntent != null) && (paramIntent.d() != 0)) {
        this.w.a((byte)0);
      }
    }
    Util.f("Web_qqbrowser_initView_WebViewWrapper");
    this.u = ((ViewGroup)this.y.findViewById(2131450099));
    Util.g("Web_qqbrowser_initView_WebViewWrapper");
    l2 = System.currentTimeMillis();
    this.I.p = (l2 - l1);
    if (!this.f.O)
    {
      this.D = this.y.findViewById(2131429743);
      this.z = ((TextView)this.y.findViewById(2131429744));
      this.A = ((TextView)this.y.findViewById(2131446856));
      this.z.setVisibility(4);
      this.A.setVisibility(4);
      if ((this.f.b) && ((this.i instanceof QBaseActivity))) {
        ((ViewGroup.MarginLayoutParams)this.z.getLayoutParams()).topMargin = ((QBaseActivity)this.i).getTitleBarHeight();
      }
    }
    if (!this.t) {
      this.B = ((ProgressBar)this.y.findViewById(2131444560));
    }
    if (this.f.N)
    {
      paramIntent = this.D;
      if (paramIntent != null) {
        paramIntent.setPadding(0, (int)DisplayUtils.a(BaseApplication.getContext(), 30.0F), 0, 0);
      }
    }
    k();
    this.i.getWindow().setBackgroundDrawable(null);
    paramIntent = this.x;
    if (paramIntent != null) {
      paramIntent.setBackgroundDrawable(null);
    }
    bI_();
    int i1 = this.F;
    if (i1 != -1) {
      paramWebBrowserViewContainer.setBackgroundColor(i1);
    }
    paramWebBrowserViewContainer = this.g;
    if (paramWebBrowserViewContainer != null) {
      paramWebBrowserViewContainer.c();
    }
  }
  
  public void a(WebView paramWebView)
  {
    if (this.f.n)
    {
      paramWebView = this.k;
      if (paramWebView != null) {
        paramWebView.setEnabled(false);
      }
      paramWebView = this.l;
      if (paramWebView != null) {
        paramWebView.setEnabled(false);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Uri localUri = Uri.parse(paramString);
    if (localUri.isHierarchical())
    {
      String str1 = localUri.getQueryParameter("_wv");
      if (str1 != null)
      {
        try
        {
          this.f.c = Long.parseLong(str1, 10);
        }
        catch (NumberFormatException localNumberFormatException8)
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("parser _wv param(");
          localStringBuilder2.append(str1);
          localStringBuilder2.append(") error:");
          localStringBuilder2.append(localNumberFormatException8.getMessage());
          QLog.e("SwiftBrowserUIStyleHandler", 1, localStringBuilder2.toString());
        }
        a("ui.wvHideActionBtn", paramString, 2L);
        a("ui.wvFullScreen", paramString, 131072L);
        a("ui.wvTransparentTitle", paramString, 16777216L);
      }
      paramString = localUri.getQueryParameter("_fv");
      StringBuilder localStringBuilder1;
      if (paramString != null) {
        try
        {
          this.f.e = Long.parseLong(paramString, 10);
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("parser _fv param(");
          localStringBuilder1.append(paramString);
          localStringBuilder1.append(") error:");
          localStringBuilder1.append(localNumberFormatException1.getMessage());
          QLog.e("SwiftBrowserUIStyleHandler", 1, localStringBuilder1.toString());
        }
      }
      paramString = localUri.getQueryParameter("_fu");
      this.f.f = false;
      if (paramString != null) {
        try
        {
          if (Long.parseLong(paramString) == 2019L) {
            this.f.f = true;
          }
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("parser _fv param(");
          localStringBuilder1.append(paramString);
          localStringBuilder1.append(") error:");
          localStringBuilder1.append(localNumberFormatException2.getMessage());
          QLog.e("SwiftBrowserUIStyleHandler", 1, localStringBuilder1.toString());
        }
      }
      paramString = localUri.getQueryParameter("_wwv");
      if (paramString != null) {
        try
        {
          this.f.d = Long.parseLong(paramString, 10);
        }
        catch (NumberFormatException localNumberFormatException3)
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("parser _wwv param(");
          localStringBuilder1.append(paramString);
          localStringBuilder1.append(") error:");
          localStringBuilder1.append(localNumberFormatException3.getMessage());
          QLog.e("SwiftBrowserUIStyleHandler", 1, localStringBuilder1.toString());
        }
      }
      String str2 = localUri.getQueryParameter("_cwv");
      if (str2 != null) {
        try
        {
          this.f.g = Long.parseLong(str2, 10);
        }
        catch (NumberFormatException localNumberFormatException4)
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("parser _cwv param(");
          localStringBuilder1.append(paramString);
          localStringBuilder1.append(") error:");
          localStringBuilder1.append(localNumberFormatException4.getMessage());
          QLog.e("SwiftBrowserUIStyleHandler", 1, localStringBuilder1.toString());
        }
      }
      paramString = localUri.getQueryParameter("channel");
      if (!TextUtils.isEmpty(paramString)) {
        this.f.h = URLDecoder.decode(paramString);
      }
      paramString = localUri.getQueryParameter("subIndex");
      if (!TextUtils.isEmpty(paramString)) {
        try
        {
          this.f.i = Integer.parseInt(paramString.trim());
        }
        catch (NumberFormatException localNumberFormatException5)
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("parser subIndex param(");
          localStringBuilder1.append(paramString);
          localStringBuilder1.append(") error:");
          localStringBuilder1.append(localNumberFormatException5.getMessage());
          QLog.e("SwiftBrowserUIStyleHandler", 1, localStringBuilder1.toString());
        }
      }
      paramString = localUri.getQueryParameter("bgColor");
      if (!TextUtils.isEmpty(paramString)) {
        try
        {
          this.F = ((int)Long.parseLong(paramString, 16));
        }
        catch (NumberFormatException localNumberFormatException6)
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("parser bgColor param(");
          localStringBuilder1.append(paramString);
          localStringBuilder1.append(") error:");
          localStringBuilder1.append(localNumberFormatException6.getMessage());
          QLog.e("SwiftBrowserUIStyleHandler", 1, localStringBuilder1.toString());
        }
      }
      paramString = localUri.getQueryParameter("titleAlpha");
      if (!TextUtils.isEmpty(paramString)) {
        try
        {
          this.f.j = Integer.parseInt(paramString.trim());
        }
        catch (NumberFormatException localNumberFormatException7)
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("parser titleAlpha param(");
          localStringBuilder1.append(paramString);
          localStringBuilder1.append(") error:");
          localStringBuilder1.append(localNumberFormatException7.getMessage());
          QLog.e("SwiftBrowserUIStyleHandler", 1, localStringBuilder1.toString());
        }
      }
      paramString = localUri.getAuthority();
      if ((!TextUtils.isEmpty(paramString)) && (paramString.endsWith("urlshare.cn"))) {
        this.f.U = true;
      } else {
        this.f.U = false;
      }
    }
    a(localUri);
  }
  
  public void a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    this.g.a(paramJSONObject, paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.f.w == paramBoolean) {
      return;
    }
    this.f.w = paramBoolean;
    Object localObject = null;
    Activity localActivity = this.i;
    if ((localActivity instanceof QIphoneTitleBarActivity)) {
      localObject = ((QIphoneTitleBarActivity)localActivity).getTitleBarView();
    } else if (this.r != null) {
      localObject = this.g.o;
    }
    if (localObject != null)
    {
      ((View)localObject).setBackgroundColor(BaseApplication.getContext().getResources().getColor(2131168092));
      if (paramBoolean)
      {
        a((View)localObject, 255, 0, 200);
        return;
      }
      a((View)localObject, 0, 255, 200);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    Object localObject = this.p;
    if (localObject == null) {
      return;
    }
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((ViewGroup)localObject).setVisibility(i1);
    localObject = this.q;
    if (paramInt == 0) {
      paramInt = 2131891253;
    } else {
      paramInt = 2131891254;
    }
    ((TextView)localObject).setText(paramInt);
    if (this.b.a() != null)
    {
      localObject = (FrameLayout.LayoutParams)this.u.getLayoutParams();
      if (localObject == null) {
        return;
      }
      if (paramBoolean) {
        ((FrameLayout.LayoutParams)localObject).bottomMargin = ((int)(this.i.getResources().getDisplayMetrics().density * 75.0F));
      } else {
        ((FrameLayout.LayoutParams)localObject).bottomMargin = 0;
      }
      this.u.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2, String paramString1, String paramString2, String paramString3)
  {
    if (this.b.a() == null) {
      return;
    }
    this.g.a((TouchWebView)this.b.a(), paramBoolean1, paramInt1, paramInt2, paramInt3, paramBoolean2, paramString1, paramString2, paramString3);
  }
  
  public void b()
  {
    this.g = SwiftWebTitleBuilder.a(this);
    this.h = SwiftFloatViewBuilder.a(this);
  }
  
  public void b(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (TextUtils.isEmpty(paramIntent.getStringExtra("url"))) {
        return;
      }
      Object localObject = paramIntent.getStringExtra("url");
      Uri localUri = Uri.parse((String)localObject);
      if ((localUri != null) && (localUri.isHierarchical()))
      {
        if ("1".equals(localUri.getQueryParameter("_qStyle")))
        {
          paramIntent = new WebViewTitleStyle();
          paramIntent.b = -16777216;
          paramIntent.c = -1;
          paramIntent.d = -16777216;
          paramIntent.e = -16777216;
          this.f.R = paramIntent;
          return;
        }
        WebViewTitleStyle localWebViewTitleStyle = c((String)localObject);
        if (localWebViewTitleStyle != null)
        {
          this.f.R = localWebViewTitleStyle;
          return;
        }
        localObject = d((String)localObject);
        if (localObject != null)
        {
          this.f.R = ((WebViewTitleStyle)localObject);
          return;
        }
        paramIntent = (WebViewTitleStyle)paramIntent.getParcelableExtra("titleStyle");
        if (paramIntent != null)
        {
          this.f.R = paramIntent;
          return;
        }
        paramIntent = localUri.getHost();
        paramIntent = (WebViewTitleStyle)WebViewTitleStyleHelper.a().a.get(paramIntent);
        if (paramIntent != null) {
          this.f.R = paramIntent;
        }
      }
    }
  }
  
  public void b(Intent paramIntent, String paramString)
  {
    if (this.f.a) {
      return;
    }
    if (this.j == null)
    {
      if (!this.f.n) {
        return;
      }
      paramIntent = (ViewStub)this.y.findViewById(2131429682);
      if (paramIntent == null) {
        return;
      }
      this.j = ((ViewGroup)paramIntent.inflate());
      this.k = ((ImageView)this.y.findViewById(2131429208));
      this.k.setOnClickListener(this);
      this.k.setEnabled(false);
      this.l = ((ImageView)this.y.findViewById(2131433636));
      this.l.setOnClickListener(this);
      this.l.setEnabled(false);
      this.j.setVisibility(8);
      float f1 = (int)(this.i.getResources().getDisplayMetrics().density * 50.0F);
      this.m = new TranslateAnimation(0.0F, 0.0F, f1, 0.0F);
      this.m.setDuration(300L);
      this.m.setAnimationListener(this);
      this.n = new TranslateAnimation(0.0F, 0.0F, 0.0F, f1);
      this.n.setDuration(300L);
      this.n.setAnimationListener(this);
    }
  }
  
  public void b(WebView paramWebView)
  {
    if (this.f.n)
    {
      if (this.f.t)
      {
        a(paramWebView);
        return;
      }
      boolean bool = paramWebView.canGoBack();
      ImageView localImageView = this.k;
      if (localImageView != null) {
        localImageView.setEnabled(bool);
      }
      localImageView = this.l;
      if (localImageView != null) {
        localImageView.setEnabled(paramWebView.canGoForward());
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.f.n)
    {
      if (this.f.a) {
        return;
      }
      if (this.j == null) {
        return;
      }
      if (this.H == paramBoolean) {
        return;
      }
      if (paramBoolean)
      {
        TouchWebView localTouchWebView = (TouchWebView)this.b.a();
        if ((localTouchWebView != null) && (!localTouchWebView.canGoBack()) && (!localTouchWebView.canGoForward())) {
          return;
        }
        this.H = true;
        this.j.setVisibility(0);
        this.j.clearAnimation();
        this.j.setAnimation(this.m);
        this.m.start();
        ReportController.a(null, "dc00898", "", "", "0X8009B1E", "0X8009B1E", 0, 0, "", "", "", "");
        return;
      }
      this.H = false;
      g();
      this.j.clearAnimation();
      this.j.setAnimation(this.n);
      this.n.start();
    }
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (this.f.I == null) {
      this.f.I = this.g.d(paramString);
    }
    if (this.f.I != null)
    {
      if (this.f.I.length() == 0) {
        return false;
      }
      if (this.f.I.optInt("trans", -1) == 0) {
        this.f.F = true;
      }
      if (!this.f.F) {
        this.f.F = this.g.f();
      }
      return true;
    }
    return false;
  }
  
  public void bI_()
  {
    if (this.b.a() != null)
    {
      WebView localWebView = this.b.a();
      localWebView.setId(2131450088);
      int i1 = this.F;
      if (i1 != -1) {
        localWebView.setBackgroundColor(i1);
      }
      this.u.addView(localWebView, 0, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  public void c()
  {
    if ((this.b.a() != null) && (!this.f.a)) {
      a((TouchWebView)this.b.a());
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.h.a(paramBoolean);
  }
  
  public void d()
  {
    if ((this.f.A) && (!this.f.F)) {
      this.f.F = this.g.f();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.g.b.u = paramBoolean;
    if (paramBoolean)
    {
      this.g.a("");
      return;
    }
    this.g.d();
  }
  
  public void e()
  {
    ViewStub localViewStub = (ViewStub)this.y.findViewById(2131429636);
    if (localViewStub == null) {
      return;
    }
    this.p = ((ViewGroup)localViewStub.inflate());
    this.q = ((TextView)this.y.findViewById(2131448216));
    this.q.setOnClickListener(this.a);
    this.p.setVisibility(8);
  }
  
  public void f()
  {
    if (this.f.z)
    {
      ViewStub localViewStub = (ViewStub)this.y.findViewById(2131433427);
      if (localViewStub == null) {
        return;
      }
      this.o = localViewStub.inflate();
      this.o.getLayoutParams();
      this.o.setOnClickListener(this.a);
    }
  }
  
  public void g()
  {
    if ((this.b.a() != null) && (this.j != null))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.u.getLayoutParams();
      if (localLayoutParams == null) {
        return;
      }
      if (this.H)
      {
        DisplayMetrics localDisplayMetrics = this.i.getResources().getDisplayMetrics();
        localLayoutParams.bottomMargin = ((int)(this.f.q * localDisplayMetrics.density));
      }
      else
      {
        localLayoutParams.bottomMargin = 0;
      }
      this.u.setLayoutParams(localLayoutParams);
    }
  }
  
  public void h()
  {
    if (this.h.i != null) {
      this.h.i.setVisibility(0);
    }
    if ((this.h.c != null) && ((this.h.c.getVisibility() == 8) || (this.h.c.getVisibility() == 4))) {
      this.h.c.setVisibility(0);
    }
  }
  
  public void i()
  {
    this.f.p = true;
    this.i.setRequestedOrientation(2);
  }
  
  public void j()
  {
    this.f.p = true;
    int i1 = this.i.getResources().getConfiguration().orientation;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--> orientation = ");
      localStringBuilder.append(i1);
      QLog.d("restoreOrientationFollowSenSor", 2, localStringBuilder.toString());
    }
    if (i1 == 1)
    {
      k();
      return;
    }
    this.i.setRequestedOrientation(2);
    if (QLog.isColorLevel()) {
      QLog.d("restoreOrientationFollowSenSor", 2, "--> orientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR 4");
    }
  }
  
  public void k()
  {
    int i1;
    if ((!this.f.k) && (!this.f.o.booleanValue())) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    boolean bool;
    if (i1 == 0)
    {
      if ((this.f.l) && (!this.f.p)) {
        bool = true;
      } else {
        bool = false;
      }
    }
    else {
      bool = this.f.o.booleanValue();
    }
    if (bool)
    {
      this.i.setRequestedOrientation(1);
      return;
    }
    if (this.f.k)
    {
      this.i.setRequestedOrientation(0);
      return;
    }
    this.i.setRequestedOrientation(-1);
  }
  
  public TouchWebView l()
  {
    return (TouchWebView)this.b.a();
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.m)
    {
      paramAnimation = this.j;
      if (paramAnimation != null) {
        paramAnimation.setVisibility(0);
      }
      g();
      return;
    }
    if (paramAnimation == this.n)
    {
      paramAnimation = this.j;
      if (paramAnimation != null) {
        paramAnimation.setVisibility(8);
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.i;
    if ((localObject instanceof View.OnClickListener)) {
      ((View.OnClickListener)localObject).onClick(paramView);
    }
    localObject = (TouchWebView)this.b.a();
    int i1 = paramView.getId();
    WebViewPluginEngine localWebViewPluginEngine;
    HashMap localHashMap;
    if (i1 == 2131429208)
    {
      if ((localObject != null) && (((TouchWebView)localObject).canGoBack()))
      {
        ((TouchWebView)localObject).stopLoading();
        ((TouchWebView)localObject).goBack();
        localWebViewPluginEngine = ((TouchWebView)localObject).getPluginEngine();
        if (localWebViewPluginEngine != null)
        {
          localHashMap = new HashMap(1);
          localHashMap.put("target", Integer.valueOf(3));
          localWebViewPluginEngine.a(((TouchWebView)localObject).getUrl(), 8589934610L, localHashMap);
        }
        b((WebView)localObject);
        ReportController.a(null, "dc00898", "", "", "0X8009B21", "0X8009B21", 0, 0, "", "", "", "");
      }
    }
    else if ((i1 == 2131433636) && (localObject != null) && (((TouchWebView)localObject).canGoForward()))
    {
      ((TouchWebView)localObject).stopLoading();
      ((TouchWebView)localObject).goForward();
      localWebViewPluginEngine = ((TouchWebView)localObject).getPluginEngine();
      if (localWebViewPluginEngine != null)
      {
        localHashMap = new HashMap(1);
        localHashMap.put("target", Integer.valueOf(3));
        localWebViewPluginEngine.a(((TouchWebView)localObject).getUrl(), 8589934602L, localHashMap);
      }
      b((WebView)localObject);
      ReportController.a(null, "dc00898", "", "", "0X8009B20", "0X8009B20", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler
 * JD-Core Version:    0.7.0.1
 */