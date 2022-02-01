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
  public int a;
  long jdField_a_of_type_Long = 0L;
  public Activity a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  public View a;
  public ViewGroup a;
  Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  public FrameLayout a;
  public ImageView a;
  public ProgressBar a;
  public TextView a;
  public final SwiftBrowserUIStyle a;
  public SwiftFloatViewUI a;
  public SwiftIphoneTitleBarUI a;
  public WebViewProvider a;
  private SwiftBrowserStatistics jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics = null;
  public WebViewProgressBar a;
  public WebViewProgressBarController a;
  public String a;
  public boolean a;
  public int b;
  public View b;
  public ViewGroup b;
  Animation b;
  public ImageView b;
  public TextView b;
  public boolean b;
  public View c;
  public ViewGroup c;
  public TextView c;
  public boolean c;
  public ViewGroup d;
  public boolean d;
  private boolean e = false;
  
  public SwiftBrowserUIStyleHandler()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle = new SwiftBrowserUIStyle();
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private int a(String paramString)
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
      int i = Color.parseColor(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      label68:
      break label68;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("SwiftBrowserUIStyleHandler", 4, "Illegal getColorIntFromUrlParams");
    }
    return -1;
  }
  
  /* Error */
  private WebViewTitleStyle a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore 12
    //   6: aconst_null
    //   7: astore 13
    //   9: iload 12
    //   11: ifeq +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: aload_1
    //   17: invokestatic 128	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   20: astore 14
    //   22: aload 13
    //   24: astore_1
    //   25: aload 14
    //   27: ifnull +268 -> 295
    //   30: aload 13
    //   32: astore_1
    //   33: aload 14
    //   35: invokevirtual 131	android/net/Uri:isHierarchical	()Z
    //   38: ifeq +257 -> 295
    //   41: aload 14
    //   43: ldc 133
    //   45: invokevirtual 137	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   48: astore_1
    //   49: aload 14
    //   51: ldc 139
    //   53: invokevirtual 137	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   56: astore 15
    //   58: aload 14
    //   60: ldc 141
    //   62: invokevirtual 137	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   65: astore 16
    //   67: aload 14
    //   69: ldc 143
    //   71: invokevirtual 137	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   74: astore 14
    //   76: iconst_0
    //   77: istore 5
    //   79: iconst_0
    //   80: istore_2
    //   81: iconst_m1
    //   82: istore 11
    //   84: aload_1
    //   85: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   88: ifne +15 -> 103
    //   91: aload_0
    //   92: aload_1
    //   93: invokespecial 145	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:a	(Ljava/lang/String;)I
    //   96: istore_2
    //   97: iconst_1
    //   98: istore 5
    //   100: goto +10 -> 110
    //   103: iconst_m1
    //   104: istore_3
    //   105: iload_2
    //   106: istore 5
    //   108: iload_3
    //   109: istore_2
    //   110: aload 15
    //   112: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   115: ifne +16 -> 131
    //   118: aload_0
    //   119: aload 15
    //   121: invokespecial 145	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:a	(Ljava/lang/String;)I
    //   124: istore_3
    //   125: iconst_1
    //   126: istore 5
    //   128: goto +5 -> 133
    //   131: iload_2
    //   132: istore_3
    //   133: aload 16
    //   135: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   138: ifne +17 -> 155
    //   141: aload_0
    //   142: aload 16
    //   144: invokespecial 145	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:a	(Ljava/lang/String;)I
    //   147: istore 4
    //   149: iconst_1
    //   150: istore 5
    //   152: goto +6 -> 158
    //   155: iconst_m1
    //   156: istore 4
    //   158: iload_2
    //   159: istore 10
    //   161: iload_3
    //   162: istore 9
    //   164: iload 4
    //   166: istore 7
    //   168: iload 5
    //   170: istore 6
    //   172: iload 11
    //   174: istore 8
    //   176: aload 14
    //   178: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   181: ifne +74 -> 255
    //   184: aload_0
    //   185: aload 14
    //   187: invokespecial 145	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:a	(Ljava/lang/String;)I
    //   190: istore 8
    //   192: iconst_1
    //   193: istore 6
    //   195: iload_2
    //   196: istore 10
    //   198: iload_3
    //   199: istore 9
    //   201: iload 4
    //   203: istore 7
    //   205: goto +50 -> 255
    //   208: astore_1
    //   209: goto +19 -> 228
    //   212: astore_1
    //   213: goto +12 -> 225
    //   216: astore_1
    //   217: goto +6 -> 223
    //   220: astore_1
    //   221: iconst_m1
    //   222: istore_2
    //   223: iconst_m1
    //   224: istore_3
    //   225: iconst_m1
    //   226: istore 4
    //   228: ldc 114
    //   230: iconst_1
    //   231: ldc 147
    //   233: aload_1
    //   234: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   237: iload 11
    //   239: istore 8
    //   241: iload 5
    //   243: istore 6
    //   245: iload 4
    //   247: istore 7
    //   249: iload_3
    //   250: istore 9
    //   252: iload_2
    //   253: istore 10
    //   255: aload 13
    //   257: astore_1
    //   258: iload 6
    //   260: ifeq +35 -> 295
    //   263: new 152	com/tencent/mobileqq/webview/WebViewTitleStyle
    //   266: dup
    //   267: invokespecial 153	com/tencent/mobileqq/webview/WebViewTitleStyle:<init>	()V
    //   270: astore_1
    //   271: aload_1
    //   272: iload 9
    //   274: putfield 154	com/tencent/mobileqq/webview/WebViewTitleStyle:jdField_b_of_type_Int	I
    //   277: aload_1
    //   278: iload 10
    //   280: putfield 156	com/tencent/mobileqq/webview/WebViewTitleStyle:jdField_c_of_type_Int	I
    //   283: aload_1
    //   284: iload 7
    //   286: putfield 158	com/tencent/mobileqq/webview/WebViewTitleStyle:d	I
    //   289: aload_1
    //   290: iload 8
    //   292: putfield 160	com/tencent/mobileqq/webview/WebViewTitleStyle:e	I
    //   295: aload_1
    //   296: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	this	SwiftBrowserUIStyleHandler
    //   0	297	1	paramString	String
    //   80	173	2	i	int
    //   104	146	3	j	int
    //   147	99	4	k	int
    //   77	165	5	m	int
    //   170	89	6	n	int
    //   166	119	7	i1	int
    //   174	117	8	i2	int
    //   162	111	9	i3	int
    //   159	120	10	i4	int
    //   82	156	11	i5	int
    //   4	6	12	bool	boolean
    //   7	249	13	localObject1	Object
    //   20	166	14	localObject2	Object
    //   56	64	15	str1	String
    //   65	78	16	str2	String
    // Exception table:
    //   from	to	target	type
    //   176	192	208	java/lang/Exception
    //   133	149	212	java/lang/Exception
    //   110	125	216	java/lang/Exception
    //   84	97	220	java/lang/Exception
  }
  
  private void a(Uri paramUri)
  {
    String str = "unknown";
    if (paramUri != null) {}
    try
    {
      str = paramUri.getHost();
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Long & 0x20000) != 0L) {
        ReportController.a(null, "dc00898", "", "", "0X800ADD8", "0X800ADD8", 131072, 0, "", "", str, "");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Long & 0x1000000) != 0L) {
        ReportController.a(null, "dc00898", "", "", "0X800ADD8", "0X800ADD8", 16777216, 0, "", "", str, "");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Long & 0x2) != 0L)
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
  
  private void a(String paramString1, String paramString2, long paramLong)
  {
    try
    {
      long l1 = System.currentTimeMillis();
      if (!"1".equals(AuthorizeConfig.a().a("wv_ctrl_switch", "")))
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("SwiftBrowserUIStyleHandler", 2, "checkWvParamAuthorize disable");
        return;
      }
      boolean bool = AuthorizeConfig.a().a(paramString2, paramString1);
      if ((!bool) && ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Long & paramLong) != 0L))
      {
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle;
        paramString1.jdField_a_of_type_Long &= (paramLong ^ 0xFFFFFFFF);
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
  private WebViewTitleStyle b(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore 12
    //   6: aconst_null
    //   7: astore 13
    //   9: iload 12
    //   11: ifeq +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: aload_1
    //   17: invokestatic 128	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   20: astore 14
    //   22: aload 13
    //   24: astore_1
    //   25: aload 14
    //   27: ifnull +293 -> 320
    //   30: aload 13
    //   32: astore_1
    //   33: aload 14
    //   35: invokevirtual 131	android/net/Uri:isHierarchical	()Z
    //   38: ifeq +282 -> 320
    //   41: aload 14
    //   43: ldc 243
    //   45: invokevirtual 137	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   48: astore_1
    //   49: aload 14
    //   51: ldc 245
    //   53: invokevirtual 137	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   56: astore 15
    //   58: aload 14
    //   60: ldc 247
    //   62: invokevirtual 137	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   65: astore 16
    //   67: aload 14
    //   69: ldc 249
    //   71: invokevirtual 137	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   74: astore 14
    //   76: iconst_0
    //   77: istore_3
    //   78: iconst_m1
    //   79: istore 10
    //   81: iconst_1
    //   82: istore 11
    //   84: aload_1
    //   85: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   88: ifne +15 -> 103
    //   91: aload_0
    //   92: aload_1
    //   93: invokespecial 145	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:a	(Ljava/lang/String;)I
    //   96: istore_2
    //   97: iconst_1
    //   98: istore 5
    //   100: goto +8 -> 108
    //   103: iconst_m1
    //   104: istore_2
    //   105: iconst_0
    //   106: istore 5
    //   108: iload 5
    //   110: istore 6
    //   112: aload 15
    //   114: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   117: ifne +13 -> 130
    //   120: aload_0
    //   121: aload 15
    //   123: invokespecial 145	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:a	(Ljava/lang/String;)I
    //   126: istore_3
    //   127: iconst_1
    //   128: istore 6
    //   130: aload 16
    //   132: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   135: ifne +17 -> 152
    //   138: aload_0
    //   139: aload 16
    //   141: invokespecial 145	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:a	(Ljava/lang/String;)I
    //   144: istore 4
    //   146: iconst_1
    //   147: istore 5
    //   149: goto +10 -> 159
    //   152: iconst_m1
    //   153: istore 4
    //   155: iload 6
    //   157: istore 5
    //   159: iload_2
    //   160: istore 7
    //   162: iload 4
    //   164: istore 6
    //   166: iload_3
    //   167: istore 8
    //   169: iload 5
    //   171: istore 9
    //   173: aload 14
    //   175: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   178: ifne +90 -> 268
    //   181: aload_0
    //   182: aload 14
    //   184: invokespecial 145	com/tencent/mobileqq/webview/swift/component/SwiftBrowserUIStyleHandler:a	(Ljava/lang/String;)I
    //   187: istore 6
    //   189: iload 6
    //   191: istore 5
    //   193: iload 11
    //   195: istore 9
    //   197: goto +85 -> 282
    //   200: astore_1
    //   201: iload_2
    //   202: istore 7
    //   204: iload 5
    //   206: istore_2
    //   207: goto +42 -> 249
    //   210: astore_1
    //   211: iconst_m1
    //   212: istore 4
    //   214: iload_2
    //   215: istore 7
    //   217: iload 6
    //   219: istore_2
    //   220: goto +29 -> 249
    //   223: astore_1
    //   224: iconst_m1
    //   225: istore 4
    //   227: iconst_m1
    //   228: istore_3
    //   229: iload_2
    //   230: istore 7
    //   232: iload 5
    //   234: istore_2
    //   235: goto +14 -> 249
    //   238: astore_1
    //   239: iconst_m1
    //   240: istore 7
    //   242: iconst_m1
    //   243: istore 4
    //   245: iconst_m1
    //   246: istore_3
    //   247: iconst_0
    //   248: istore_2
    //   249: ldc 114
    //   251: iconst_1
    //   252: ldc 147
    //   254: aload_1
    //   255: invokestatic 150	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   258: iload_2
    //   259: istore 9
    //   261: iload_3
    //   262: istore 8
    //   264: iload 4
    //   266: istore 6
    //   268: iload 10
    //   270: istore 5
    //   272: iload 8
    //   274: istore_3
    //   275: iload 6
    //   277: istore 4
    //   279: iload 7
    //   281: istore_2
    //   282: aload 13
    //   284: astore_1
    //   285: iload 9
    //   287: ifeq +33 -> 320
    //   290: new 152	com/tencent/mobileqq/webview/WebViewTitleStyle
    //   293: dup
    //   294: invokespecial 153	com/tencent/mobileqq/webview/WebViewTitleStyle:<init>	()V
    //   297: astore_1
    //   298: aload_1
    //   299: iload_3
    //   300: putfield 154	com/tencent/mobileqq/webview/WebViewTitleStyle:jdField_b_of_type_Int	I
    //   303: aload_1
    //   304: iload_2
    //   305: putfield 156	com/tencent/mobileqq/webview/WebViewTitleStyle:jdField_c_of_type_Int	I
    //   308: aload_1
    //   309: iload 4
    //   311: putfield 158	com/tencent/mobileqq/webview/WebViewTitleStyle:d	I
    //   314: aload_1
    //   315: iload 5
    //   317: putfield 160	com/tencent/mobileqq/webview/WebViewTitleStyle:e	I
    //   320: aload_1
    //   321: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	this	SwiftBrowserUIStyleHandler
    //   0	322	1	paramString	String
    //   96	209	2	i	int
    //   77	223	3	j	int
    //   144	166	4	k	int
    //   98	218	5	m	int
    //   110	166	6	n	int
    //   160	120	7	i1	int
    //   167	106	8	i2	int
    //   171	115	9	i3	int
    //   79	190	10	i4	int
    //   82	112	11	i5	int
    //   4	6	12	bool	boolean
    //   7	276	13	localObject1	Object
    //   20	163	14	localObject2	Object
    //   56	66	15	str1	String
    //   65	75	16	str2	String
    // Exception table:
    //   from	to	target	type
    //   173	189	200	java/lang/Exception
    //   130	146	210	java/lang/Exception
    //   112	127	223	java/lang/Exception
    //   84	97	238	java/lang/Exception
  }
  
  public void Y_()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a() != null)
    {
      WebView localWebView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
      localWebView.setId(2131381075);
      int i = this.jdField_b_of_type_Int;
      if (i != -1) {
        localWebView.setBackgroundColor(i);
      }
      this.jdField_c_of_type_AndroidViewViewGroup.addView(localWebView, 0, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  public TouchWebView a()
  {
    return (TouchWebView)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics = ((SwiftBrowserStatistics)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(-2));
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    super.a(paramInt, paramBundle);
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        TouchWebView localTouchWebView = null;
        ViewGroup localViewGroup = null;
        Object localObject = null;
        if (paramInt != 4)
        {
          if (paramInt != 6)
          {
            if (paramInt != 7) {
              return;
            }
            paramBundle = this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController;
            if (paramBundle != null) {
              paramBundle.a((byte)2);
            }
            this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.D)
            {
              if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
                return;
              }
              paramBundle = this.jdField_c_of_type_AndroidViewView;
              if ((paramBundle != null) && (this.jdField_a_of_type_Int == -1)) {
                paramBundle.setBackgroundResource(2131167391);
              }
              this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
              if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a() == null) {
                return;
              }
              localTouchWebView = (TouchWebView)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
              if (this.jdField_c_of_type_AndroidWidgetTextView != null) {
                if (localTouchWebView.getX5WebViewExtension() != null) {
                  this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
                } else {
                  this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
                }
              }
              localViewGroup = this.jdField_c_of_type_AndroidViewViewGroup;
              paramBundle = (Bundle)localObject;
              if ((localViewGroup instanceof RefreshView)) {
                paramBundle = (RefreshView)localViewGroup;
              }
              if (paramBundle == null) {
                return;
              }
              if (!this.jdField_b_of_type_Boolean) {
                return;
              }
              localTouchWebView.setOnOverScrollHandler(new SwiftBrowserUIStyleHandler.1(this, localTouchWebView, paramBundle));
              localTouchWebView.setOnScrollChangedListener(new SwiftBrowserUIStyleHandler.2(this));
              b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a());
            }
          }
          else
          {
            if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.i)
            {
              localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController;
              if ((localObject != null) && (((WebViewProgressBarController)localObject).b() != 0)) {
                this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a((byte)0);
              }
            }
            this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            if ((paramBundle != null) && (paramBundle.containsKey("url"))) {
              paramBundle = paramBundle.getString("url");
            } else {
              paramBundle = null;
            }
            localObject = localTouchWebView;
            if (!TextUtils.isEmpty(paramBundle)) {
              localObject = Uri.parse(paramBundle);
            }
            if ((localObject != null) && (((Uri)localObject).isHierarchical()) && ("simple".equals(((Uri)localObject).getQueryParameter("style"))))
            {
              this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
              this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.y = true;
            }
            a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a());
          }
        }
        else
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_AndroidViewView != null) && (8 == this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_c_of_type_AndroidViewView.getVisibility())) {
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.a();
          }
          localObject = localViewGroup;
          if (paramBundle.containsKey("Configuration")) {
            localObject = (Configuration)paramBundle.getParcelable("Configuration");
          }
          if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_c_of_type_AndroidViewView != null) && (((Configuration)localObject).orientation == 2) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_c_of_type_AndroidViewView.getVisibility() == 0)) {
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_c_of_type_AndroidViewView.setVisibility(8);
          }
        }
      }
      else
      {
        paramBundle = this.jdField_b_of_type_AndroidViewView;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.getParent();
          if ((paramBundle != null) && ((paramBundle instanceof ViewGroup))) {
            ((ViewGroup)paramBundle).removeView(this.jdField_b_of_type_AndroidViewView);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.g();
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.e();
      }
    }
    else
    {
      Util.a("Web_updateTitleBarUI");
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.s) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.i();
      }
      Util.b("Web_updateTitleBarUI");
    }
  }
  
  public void a(Intent paramIntent)
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Long & 0x20000) == 0L) && (!paramIntent.getBooleanExtra("isFullScreen", false))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Boolean = true;
    }
    SwiftBrowserUIStyle localSwiftBrowserUIStyle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle;
    boolean bool;
    if (((localSwiftBrowserUIStyle.jdField_a_of_type_Long & 0x1000000) == 0L) && (!paramIntent.getBooleanExtra("isTransparentTitle", false))) {
      bool = false;
    } else {
      bool = true;
    }
    localSwiftBrowserUIStyle.jdField_b_of_type_Boolean = bool;
    localSwiftBrowserUIStyle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle;
    if (((localSwiftBrowserUIStyle.jdField_b_of_type_Long & 1L) == 0L) && (!paramIntent.getBooleanExtra("isTransparentTitleAndClickable", false))) {
      bool = false;
    } else {
      bool = true;
    }
    localSwiftBrowserUIStyle.m = bool;
    localSwiftBrowserUIStyle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle;
    if (((localSwiftBrowserUIStyle.jdField_a_of_type_Long & 0x2) == 0L) && (!paramIntent.getBooleanExtra("hide_more_button", false))) {
      bool = false;
    } else {
      bool = true;
    }
    localSwiftBrowserUIStyle.e = bool;
    localSwiftBrowserUIStyle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle;
    if (((localSwiftBrowserUIStyle.jdField_a_of_type_Long & 1L) == 0L) && (!paramIntent.getBooleanExtra("hide_operation_bar", false)) && (!"noBottomBar".equals(paramIntent.getStringExtra("webStyle")))) {
      bool = false;
    } else {
      bool = true;
    }
    localSwiftBrowserUIStyle.f = bool;
    localSwiftBrowserUIStyle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle;
    if ((localSwiftBrowserUIStyle.jdField_b_of_type_Long & 0x100) != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    localSwiftBrowserUIStyle.o = bool;
    if (!TextUtils.isEmpty(paramIntent.getStringExtra("key_params_qq")))
    {
      localSwiftBrowserUIStyle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle;
      localSwiftBrowserUIStyle.e = true;
      localSwiftBrowserUIStyle.f = true;
    }
    int i = paramIntent.getIntExtra("reqType", -1);
    if ((!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.f) && (i == 6)) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.f = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.g = paramIntent.getBooleanExtra("fromOneCLickCLose", false);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.q = paramIntent.getBooleanExtra("rightTopCancel", false);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.r = paramIntent.getBooleanExtra("webViewMoveTop", false);
    if ((!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.e) && ((i == 3) || (i == 1) || (!paramIntent.getBooleanExtra("ba_is_login", true)) || (i == 7))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.e = true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Long & 0x20000) > 0L) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Boolean = true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Long & 0x20000000) != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.s = true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Long & 0x800) > 0L)
    {
      localSwiftBrowserUIStyle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle;
      localSwiftBrowserUIStyle.jdField_d_of_type_Boolean = true;
      localSwiftBrowserUIStyle.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_b_of_type_Long & 0x4) > 0L)
    {
      localSwiftBrowserUIStyle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle;
      localSwiftBrowserUIStyle.jdField_d_of_type_Boolean = false;
      localSwiftBrowserUIStyle.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_b_of_type_Long & 0x2) > 0L) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.h = true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_b_of_type_Long & 0x200) > 0L) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.D = true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_b_of_type_Long & 0x400) > 0L)
    {
      localSwiftBrowserUIStyle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle;
      localSwiftBrowserUIStyle.B = true;
      localSwiftBrowserUIStyle.E = true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_b_of_type_Long & 0x2000) > 0L) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.p = true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_d_of_type_Long & 1L) > 0L) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_b_of_type_Boolean = true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_d_of_type_Long & 0x8) > 0L) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.m = true;
    }
    if (paramIntent.getBooleanExtra("from_single_task", false))
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.H = true;
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Long & 0x80000000) > 0L) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.G = AuthorizeConfig.a().d("aio_authorize_config", paramIntent.getStringExtra("url"));
    }
  }
  
  public void a(Intent paramIntent, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a(paramIntent, paramString);
    a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_OrgJsonJSONObject, false);
    c();
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a(paramView, paramInt1, paramInt2, paramInt3);
  }
  
  public void a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramView == null) {
      return;
    }
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.B) && (!"1000".equals(ThemeUtil.getCurrentThemeId()))) {
      i = 1;
    } else {
      i = 0;
    }
    Drawable localDrawable;
    if (paramBoolean)
    {
      if (i != 0)
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
      if (i != 0)
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
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a(paramTouchWebView);
  }
  
  @TargetApi(14)
  public void a(WebBrowserViewContainer paramWebBrowserViewContainer, Intent paramIntent, TouchWebView paramTouchWebView)
  {
    long l2 = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramWebBrowserViewContainer.findViewById(2131367414));
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_c_of_type_Long != 0L))
    {
      paramWebBrowserViewContainer.b(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.I);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.a(paramWebBrowserViewContainer, this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.a(this.jdField_a_of_type_AndroidAppActivity);
    }
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.t = (l1 - l2);
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar = ((WebViewProgressBar)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131373133));
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController = new WebViewProgressBarController();
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setController(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController);
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a(this.jdField_d_of_type_Boolean ^ true);
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.i)
    {
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController;
      if ((paramIntent != null) && (paramIntent.b() != 0)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a((byte)0);
      }
    }
    Util.a("Web_qqbrowser_initView_WebViewWrapper");
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131381085));
    Util.b("Web_qqbrowser_initView_WebViewWrapper");
    l2 = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.m = (l2 - l1);
    if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.D)
    {
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131363810);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131363811));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131378333));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_b_of_type_Boolean) && ((this.jdField_a_of_type_AndroidAppActivity instanceof QBaseActivity))) {
        ((ViewGroup.MarginLayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams()).topMargin = ((QBaseActivity)this.jdField_a_of_type_AndroidAppActivity).getTitleBarHeight();
      }
    }
    if (!this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131376345));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.C)
    {
      paramIntent = this.jdField_c_of_type_AndroidViewView;
      if (paramIntent != null) {
        paramIntent.setPadding(0, (int)DisplayUtils.a(BaseApplication.getContext(), 30.0F), 0, 0);
      }
    }
    k();
    this.jdField_a_of_type_AndroidAppActivity.getWindow().setBackgroundDrawable(null);
    paramIntent = this.jdField_d_of_type_AndroidViewViewGroup;
    if (paramIntent != null) {
      paramIntent.setBackgroundDrawable(null);
    }
    Y_();
    int i = this.jdField_b_of_type_Int;
    if (i != -1) {
      paramWebBrowserViewContainer.setBackgroundColor(i);
    }
    paramWebBrowserViewContainer = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI;
    if (paramWebBrowserViewContainer != null) {
      paramWebBrowserViewContainer.c();
    }
  }
  
  public void a(WebView paramWebView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.g)
    {
      paramWebView = this.jdField_a_of_type_AndroidWidgetImageView;
      if (paramWebView != null) {
        paramWebView.setEnabled(false);
      }
      paramWebView = this.jdField_b_of_type_AndroidWidgetImageView;
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
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Long = Long.parseLong(str1, 10);
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
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_c_of_type_Long = Long.parseLong(paramString, 10);
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
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_c_of_type_Boolean = false;
      if (paramString != null) {
        try
        {
          if (Long.parseLong(paramString) == 2019L) {
            this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_c_of_type_Boolean = true;
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
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_b_of_type_Long = Long.parseLong(paramString, 10);
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
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_d_of_type_Long = Long.parseLong(str2, 10);
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
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_JavaLangString = URLDecoder.decode(paramString);
      }
      paramString = localUri.getQueryParameter("subIndex");
      if (!TextUtils.isEmpty(paramString)) {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Int = Integer.parseInt(paramString.trim());
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
          this.jdField_b_of_type_Int = ((int)Long.parseLong(paramString, 16));
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
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_b_of_type_Int = Integer.parseInt(paramString.trim());
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
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.I = true;
      } else {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.I = false;
      }
    }
    a(localUri);
  }
  
  public void a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a(paramJSONObject, paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.n == paramBoolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.n = paramBoolean;
    Object localObject = null;
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    if ((localActivity instanceof QIphoneTitleBarActivity)) {
      localObject = ((QIphoneTitleBarActivity)localActivity).getTitleBarView();
    } else if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewProvider != null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup;
    }
    if (localObject != null)
    {
      ((View)localObject).setBackgroundColor(BaseApplication.getContext().getResources().getColor(2131167114));
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
    Object localObject = this.jdField_b_of_type_AndroidViewViewGroup;
    if (localObject == null) {
      return;
    }
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    ((ViewGroup)localObject).setVisibility(i);
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (paramInt == 0) {
      paramInt = 2131693678;
    } else {
      paramInt = 2131693679;
    }
    ((TextView)localObject).setText(paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a() != null)
    {
      localObject = (FrameLayout.LayoutParams)this.jdField_c_of_type_AndroidViewViewGroup.getLayoutParams();
      if (localObject == null) {
        return;
      }
      if (paramBoolean) {
        ((FrameLayout.LayoutParams)localObject).bottomMargin = ((int)(this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().density * 75.0F));
      } else {
        ((FrameLayout.LayoutParams)localObject).bottomMargin = 0;
      }
      this.jdField_c_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2, String paramString1, String paramString2, String paramString3)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a() == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a((TouchWebView)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a(), paramBoolean1, paramInt1, paramInt2, paramInt3, paramBoolean2, paramString1, paramString2, paramString3);
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_OrgJsonJSONObject == null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_OrgJsonJSONObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a(paramString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_OrgJsonJSONObject != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_OrgJsonJSONObject.length() == 0) {
        return false;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_OrgJsonJSONObject.optInt("trans", -1) == 0) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.w = true;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.w) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.w = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a();
      }
      return true;
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI = SwiftWebTitleBuilder.a(this);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI = SwiftFloatViewBuilder.a(this);
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
          paramIntent.jdField_b_of_type_Int = -16777216;
          paramIntent.jdField_c_of_type_Int = -1;
          paramIntent.d = -16777216;
          paramIntent.e = -16777216;
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle = paramIntent;
          return;
        }
        WebViewTitleStyle localWebViewTitleStyle = a((String)localObject);
        if (localWebViewTitleStyle != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle = localWebViewTitleStyle;
          return;
        }
        localObject = b((String)localObject);
        if (localObject != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle = ((WebViewTitleStyle)localObject);
          return;
        }
        paramIntent = (WebViewTitleStyle)paramIntent.getParcelableExtra("titleStyle");
        if (paramIntent != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle = paramIntent;
          return;
        }
        paramIntent = localUri.getHost();
        paramIntent = (WebViewTitleStyle)WebViewTitleStyleHelper.a().a.get(paramIntent);
        if (paramIntent != null) {
          this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_ComTencentMobileqqWebviewWebViewTitleStyle = paramIntent;
        }
      }
    }
  }
  
  public void b(Intent paramIntent, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup == null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.g) {
        return;
      }
      paramIntent = (ViewStub)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131363758);
      if (paramIntent == null) {
        return;
      }
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramIntent.inflate());
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131363334));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131367180));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      float f = (int)(this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().density * 50.0F);
      this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, f, 0.0F);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(300L);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      this.jdField_b_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, f);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(300L);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
    }
  }
  
  public void b(WebView paramWebView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.g)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.k)
      {
        a(paramWebView);
        return;
      }
      boolean bool = paramWebView.canGoBack();
      ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localImageView != null) {
        localImageView.setEnabled(bool);
      }
      localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
      if (localImageView != null) {
        localImageView.setEnabled(paramWebView.canGoForward());
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.g)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Boolean) {
        return;
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
        return;
      }
      if (this.e == paramBoolean) {
        return;
      }
      if (paramBoolean)
      {
        TouchWebView localTouchWebView = (TouchWebView)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
        if ((localTouchWebView != null) && (!localTouchWebView.canGoBack()) && (!localTouchWebView.canGoForward())) {
          return;
        }
        this.e = true;
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        this.jdField_a_of_type_AndroidViewViewGroup.clearAnimation();
        this.jdField_a_of_type_AndroidViewViewGroup.setAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
        this.jdField_a_of_type_AndroidViewAnimationAnimation.start();
        ReportController.a(null, "dc00898", "", "", "0X8009B1E", "0X8009B1E", 0, 0, "", "", "", "");
        return;
      }
      this.e = false;
      g();
      this.jdField_a_of_type_AndroidViewViewGroup.clearAnimation();
      this.jdField_a_of_type_AndroidViewViewGroup.setAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.start();
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a() != null) && (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_Boolean)) {
      a((TouchWebView)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a());
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.a(paramBoolean);
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.r) && (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.w)) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.w = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.l = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a("");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.d();
  }
  
  public void e()
  {
    ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131363713);
    if (localViewStub == null) {
      return;
    }
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localViewStub.inflate());
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131379473));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.q)
    {
      ViewStub localViewStub = (ViewStub)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131366981);
      if (localViewStub == null) {
        return;
      }
      this.jdField_a_of_type_AndroidViewView = localViewStub.inflate();
      this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a() != null) && (this.jdField_a_of_type_AndroidViewViewGroup != null))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_c_of_type_AndroidViewViewGroup.getLayoutParams();
      if (localLayoutParams == null) {
        return;
      }
      if (this.e)
      {
        DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics();
        localLayoutParams.bottomMargin = ((int)(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_c_of_type_Int * localDisplayMetrics.density));
      }
      else
      {
        localLayoutParams.bottomMargin = 0;
      }
      this.jdField_c_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.g != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.g.setVisibility(0);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_AndroidViewView.getVisibility() == 8) || (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_AndroidViewView.getVisibility() == 4))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftFloatViewUI.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.h = true;
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(2);
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.h = true;
    int i = this.jdField_a_of_type_AndroidAppActivity.getResources().getConfiguration().orientation;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--> orientation = ");
      localStringBuilder.append(i);
      QLog.d("restoreOrientationFollowSenSor", 2, localStringBuilder.toString());
    }
    if (i == 1)
    {
      k();
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(2);
    if (QLog.isColorLevel()) {
      QLog.d("restoreOrientationFollowSenSor", 2, "--> orientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR 4");
    }
  }
  
  public void k()
  {
    int i;
    if ((!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_d_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_JavaLangBoolean.booleanValue())) {
      i = 0;
    } else {
      i = 1;
    }
    boolean bool;
    if (i == 0)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.e) && (!this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.h)) {
        bool = true;
      } else {
        bool = false;
      }
    }
    else {
      bool = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_a_of_type_JavaLangBoolean.booleanValue();
    }
    if (bool)
    {
      this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.jdField_d_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(0);
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(-1);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationAnimation)
    {
      paramAnimation = this.jdField_a_of_type_AndroidViewViewGroup;
      if (paramAnimation != null) {
        paramAnimation.setVisibility(0);
      }
      g();
      return;
    }
    if (paramAnimation == this.jdField_b_of_type_AndroidViewAnimationAnimation)
    {
      paramAnimation = this.jdField_a_of_type_AndroidViewViewGroup;
      if (paramAnimation != null) {
        paramAnimation.setVisibility(8);
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_AndroidAppActivity;
    if ((localObject instanceof View.OnClickListener)) {
      ((View.OnClickListener)localObject).onClick(paramView);
    }
    localObject = (TouchWebView)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
    int i = paramView.getId();
    WebViewPluginEngine localWebViewPluginEngine;
    HashMap localHashMap;
    if (i == 2131363334)
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
    else if ((i == 2131367180) && (localObject != null) && (((TouchWebView)localObject).canGoForward()))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler
 * JD-Core Version:    0.7.0.1
 */