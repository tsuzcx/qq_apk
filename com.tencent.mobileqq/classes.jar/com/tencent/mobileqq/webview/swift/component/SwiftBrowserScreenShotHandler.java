package com.tencent.mobileqq.webview.swift.component;

import akbc;
import akbd;
import akbe;
import akbh;
import akbi;
import akbj;
import akbk;
import akbl;
import akbm;
import akbn;
import akbo;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.pubaccount.util.ScreenshotContentObserver;
import com.tencent.biz.pubaccount.util.ScreenshotContentObserver.Listener;
import com.tencent.biz.qqstory.takevideo.EditPicActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import mqq.app.AppRuntime;
import org.json.JSONArray;

public class SwiftBrowserScreenShotHandler
  extends SwiftBrowserComponentsProvider.SwiftBrowserComponent
  implements Handler.Callback, AdapterView.OnItemClickListener, ScreenshotContentObserver.Listener
{
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int;
  public Activity a;
  public Bitmap a;
  public Handler a;
  public LinearLayout a;
  ScreenshotContentObserver jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver = null;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  ElasticHorScrView jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView;
  public ShareActionSheetBuilder a;
  public WebViewFragment a;
  public QQProgressDialog a;
  public String a;
  JSONArray jdField_a_of_type_OrgJsonJSONArray = null;
  public boolean a;
  public int b;
  public Bitmap b;
  String b;
  public boolean b;
  int jdField_c_of_type_Int = 0;
  String jdField_c_of_type_JavaLangString = "";
  public boolean c;
  int jdField_d_of_type_Int = 0;
  String jdField_d_of_type_JavaLangString = "";
  boolean jdField_d_of_type_Boolean = false;
  int e;
  public String e;
  int f;
  public String f;
  public String g = null;
  public String h;
  private final String i = "https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=openUrl&url=";
  
  public SwiftBrowserScreenShotHandler()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_f_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  }
  
  public Bitmap a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "generateScreenShotImageWithQRCode->begin time:" + System.currentTimeMillis());
    }
    for (;;)
    {
      try
      {
        localResources = BaseApplicationImpl.getContext().getResources();
        paramString = BitmapFactory.decodeFile(paramString);
        m = paramString.getWidth();
        n = paramString.getHeight();
        int i1 = AIOUtils.a(0.5F, localResources);
        int j = AIOUtils.a(90.0F, localResources);
        k = Math.max(this.jdField_c_of_type_Int, m);
        localBitmap = Bitmap.createBitmap(k, n + i1 + j, Bitmap.Config.ARGB_8888);
        localCanvas = new Canvas(localBitmap);
        localPaint = new Paint();
        if (this.jdField_c_of_type_Int > m)
        {
          localPaint.setColor(Color.parseColor("#f7f7f9"));
          localCanvas.drawRect(0.0F, 0.0F, this.jdField_c_of_type_Int, n, localPaint);
        }
        if (m >= this.jdField_c_of_type_Int)
        {
          localCanvas.drawBitmap(paramString, 0.0F, 0.0F, localPaint);
          localPaint.setColor(Color.parseColor("#DEDFE0"));
          localCanvas.drawRect(0.0F, n, k, n + i1, localPaint);
          m = n + i1;
          localPaint.setColor(-1);
          localCanvas.drawRect(0.0F, m, k, m + j, localPaint);
          localCanvas.drawBitmap(BitmapFactory.decodeResource(localResources, 2130839698), AIOUtils.a(13.0F, localResources), AIOUtils.a(25.0F, localResources) + m, localPaint);
          localPaint.setColor(-16777216);
          localPaint.setTextSize(AIOUtils.a(2, 18, localResources));
          localCanvas.drawText("QQ看点", AIOUtils.a(60.0F, localResources), AIOUtils.a(42.0F, localResources) + m, localPaint);
          localPaint.setColor(Color.parseColor("#777777"));
          localPaint.setTextSize(AIOUtils.a(2, 14, localResources));
          localCanvas.drawText(localResources.getString(2131438453), AIOUtils.a(60.0F, localResources), AIOUtils.a(61.0F, localResources) + m, localPaint);
          paramString = "https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=openUrl&url=" + URLEncoder.encode(this.jdField_a_of_type_JavaLangString, "UTF-8");
          localObject = new HashMap();
          ((HashMap)localObject).put("url", paramString);
          str2 = (String)HttpUtil.a((HashMap)localObject).get("url");
          if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserScreenShotHandler", 2, "generateScreenShotImageWithQRCode->shortenUrl:" + str2);
          }
          localObject = new HashMap();
          if ((TextUtils.isEmpty(str2)) || (str2.length() >= paramString.length())) {
            continue;
          }
          ((HashMap)localObject).put("param_errorCode", "0");
          StatisticCollector.a(BaseApplication.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actReadInJoyShortenUrl", true, 0L, 0L, (HashMap)localObject, "");
          paramString = Uri.parse(this.jdField_a_of_type_JavaLangString);
        }
      }
      catch (OutOfMemoryError paramString)
      {
        Resources localResources;
        int m;
        int n;
        int k;
        Bitmap localBitmap;
        Canvas localCanvas;
        Paint localPaint;
        Object localObject;
        String str2;
        String str1;
        paramString = null;
        continue;
      }
      catch (Exception paramString)
      {
        paramString = null;
        continue;
      }
      try
      {
        paramString = paramString.getQueryParameter("_wv");
        if (paramString != null) {
          continue;
        }
        localObject = "";
        paramString = Uri.parse(str2);
      }
      catch (Exception paramString)
      {
        try
        {
          paramString = paramString.getQueryParameter("_wv");
          str1 = paramString;
          if (paramString == null) {
            str1 = "";
          }
          paramString = str2;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            paramString = str2;
            if (TextUtils.isEmpty(str1))
            {
              if (!str2.contains("?")) {
                continue;
              }
              paramString = str2 + "&_wv=" + (String)localObject;
            }
          }
          localObject = paramString;
          if (paramString.startsWith("http://")) {
            localObject = paramString.replaceFirst("http://", "https://");
          }
          if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserScreenShotHandler", 2, "generateScreenShotImageWithQRCode->use new qrCode:" + (String)localObject);
          }
          paramString = TroopShareUtility.a((String)localObject, localResources, AIOUtils.a(80.0F, localResources), 0, false);
          localObject = paramString;
          if (paramString == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("SwiftBrowserScreenShotHandler", 2, "generateScreenShotImageWithQRCode->use old kandian qrCode!");
            }
            localObject = BitmapFactory.decodeResource(localResources, 2130839699);
          }
          localCanvas.drawBitmap((Bitmap)localObject, k - AIOUtils.a(5.0F, localResources) - ((Bitmap)localObject).getWidth(), AIOUtils.a(5.0F, localResources) + m, localPaint);
          this.g = a(localBitmap, "QRCode_");
          paramString = localBitmap;
          if (QLog.isDevelopLevel()) {
            QLog.d("SwiftBrowserScreenShotHandler", 2, "generateScreenShotImageWithQRCode->end time:" + System.currentTimeMillis());
          }
          this.jdField_d_of_type_Boolean = false;
          if ((!TextUtils.isEmpty(this.g)) && (this.jdField_e_of_type_Int > 0)) {}
          switch (this.jdField_e_of_type_Int)
          {
          default: 
            return paramString;
            localCanvas.drawBitmap(paramString, new Rect(0, 0, m, n), new Rect((this.jdField_c_of_type_Int - m) / 2, 0, (m + this.jdField_c_of_type_Int) / 2, n), localPaint);
            continue;
            paramString = paramString;
            paramString.printStackTrace();
            paramString = "";
          }
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          paramString = "";
          continue;
          paramString = str2 + "?_wv=" + (String)localObject;
          continue;
        }
      }
      if (TextUtils.isEmpty(str2))
      {
        ((HashMap)localObject).put("param_errorCode", "1");
        StatisticCollector.a(BaseApplication.getContext()).a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "actReadInJoyShortenUrl", false, 0L, 0L, (HashMap)localObject, "");
        paramString = null;
      }
      else if (str2.equals(paramString))
      {
        ((HashMap)localObject).put("param_errorCode", "2");
      }
      else if (str2.length() >= paramString.length())
      {
        ((HashMap)localObject).put("param_errorCode", "3");
        continue;
        e();
        return paramString;
        this.jdField_a_of_type_AndroidOsHandler.post(new akbo(this));
        return paramString;
        this.jdField_a_of_type_AndroidOsHandler.post(new akbd(this));
        return paramString;
        localObject = paramString;
      }
    }
  }
  
  View a()
  {
    Object localObject = (SwiftBrowserUIStyleHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a().a(2);
    if ((((SwiftBrowserUIStyleHandler)localObject).a.jdField_a_of_type_Boolean) || (((SwiftBrowserUIStyleHandler)localObject).a.jdField_b_of_type_Boolean)) {}
    for (int j = 2131363436;; j = 2131363995)
    {
      View localView = this.jdField_a_of_type_AndroidAppActivity.findViewById(j);
      localObject = localView;
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null)
      {
        localObject = localView;
        if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler != null)
        {
          localObject = localView;
          if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b != null) {
            localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer;
          }
        }
      }
      return localObject;
    }
  }
  
  public String a()
  {
    String str = "分享到";
    try
    {
      if (this.jdField_a_of_type_OrgJsonJSONArray != null)
      {
        int j = this.jdField_a_of_type_OrgJsonJSONArray.length();
        j = new Random().nextInt(j);
        str = this.jdField_a_of_type_OrgJsonJSONArray.getString(j);
      }
      return str;
    }
    catch (Exception localException) {}
    return "分享到";
  }
  
  /* Error */
  public String a(Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: invokestatic 113	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3: ifeq +29 -> 32
    //   6: ldc 115
    //   8: iconst_2
    //   9: new 117	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 473
    //   19: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_2
    //   23: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: ldc 52
    //   34: astore 4
    //   36: new 475	java/io/File
    //   39: dup
    //   40: getstatic 480	com/tencent/mobileqq/app/AppConstants:ch	Ljava/lang/String;
    //   43: invokespecial 483	java/io/File:<init>	(Ljava/lang/String;)V
    //   46: astore 5
    //   48: aload 5
    //   50: invokevirtual 486	java/io/File:exists	()Z
    //   53: ifne +9 -> 62
    //   56: aload 5
    //   58: invokevirtual 489	java/io/File:mkdirs	()Z
    //   61: pop
    //   62: new 491	java/text/SimpleDateFormat
    //   65: dup
    //   66: ldc_w 493
    //   69: invokespecial 494	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   72: new 496	java/util/Date
    //   75: dup
    //   76: invokestatic 130	java/lang/System:currentTimeMillis	()J
    //   79: invokespecial 499	java/util/Date:<init>	(J)V
    //   82: invokevirtual 503	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   85: astore 5
    //   87: new 117	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   94: getstatic 480	com/tencent/mobileqq/app/AppConstants:ch	Ljava/lang/String;
    //   97: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_2
    //   101: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload 5
    //   106: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc_w 505
    //   112: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: astore 6
    //   120: new 475	java/io/File
    //   123: dup
    //   124: aload 6
    //   126: invokespecial 483	java/io/File:<init>	(Ljava/lang/String;)V
    //   129: astore_2
    //   130: aload_2
    //   131: invokevirtual 486	java/io/File:exists	()Z
    //   134: ifne +115 -> 249
    //   137: new 507	java/io/FileOutputStream
    //   140: dup
    //   141: aload_2
    //   142: invokespecial 510	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   145: astore 5
    //   147: aload 5
    //   149: astore_2
    //   150: aload_1
    //   151: getstatic 516	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   154: bipush 100
    //   156: aload 5
    //   158: invokevirtual 520	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   161: istore_3
    //   162: aload 4
    //   164: astore_1
    //   165: iload_3
    //   166: ifeq +6 -> 172
    //   169: aload 6
    //   171: astore_1
    //   172: aload_1
    //   173: astore 4
    //   175: aload 5
    //   177: ifnull +11 -> 188
    //   180: aload 5
    //   182: invokevirtual 523	java/io/FileOutputStream:close	()V
    //   185: aload_1
    //   186: astore 4
    //   188: aload 4
    //   190: areturn
    //   191: astore_2
    //   192: aload_2
    //   193: invokevirtual 384	java/lang/Exception:printStackTrace	()V
    //   196: aload_1
    //   197: areturn
    //   198: astore 6
    //   200: aconst_null
    //   201: astore_1
    //   202: aload_1
    //   203: astore_2
    //   204: aload 6
    //   206: invokevirtual 384	java/lang/Exception:printStackTrace	()V
    //   209: aload_1
    //   210: ifnull -22 -> 188
    //   213: aload_1
    //   214: invokevirtual 523	java/io/FileOutputStream:close	()V
    //   217: ldc 52
    //   219: areturn
    //   220: astore_1
    //   221: aload_1
    //   222: invokevirtual 384	java/lang/Exception:printStackTrace	()V
    //   225: ldc 52
    //   227: areturn
    //   228: astore_1
    //   229: aconst_null
    //   230: astore_2
    //   231: aload_2
    //   232: ifnull +7 -> 239
    //   235: aload_2
    //   236: invokevirtual 523	java/io/FileOutputStream:close	()V
    //   239: aload_1
    //   240: athrow
    //   241: astore_2
    //   242: aload_2
    //   243: invokevirtual 384	java/lang/Exception:printStackTrace	()V
    //   246: goto -7 -> 239
    //   249: aload 6
    //   251: areturn
    //   252: astore_1
    //   253: goto -22 -> 231
    //   256: astore 6
    //   258: aload 5
    //   260: astore_1
    //   261: goto -59 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	SwiftBrowserScreenShotHandler
    //   0	264	1	paramBitmap	Bitmap
    //   0	264	2	paramString	String
    //   161	5	3	bool	boolean
    //   34	155	4	localObject1	Object
    //   46	213	5	localObject2	Object
    //   118	52	6	str	String
    //   198	52	6	localException1	Exception
    //   256	1	6	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   180	185	191	java/lang/Exception
    //   137	147	198	java/lang/Exception
    //   213	217	220	java/lang/Exception
    //   137	147	228	finally
    //   235	239	241	java/lang/Exception
    //   150	162	252	finally
    //   204	209	252	finally
    //   150	162	256	java/lang/Exception
  }
  
  public void a()
  {
    Intent localIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) {
      localIntent = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.a();
    }
    this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("url");
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("key_params_qq");
      if (this.jdField_a_of_type_JavaLangString == null) {
        this.jdField_a_of_type_JavaLangString = "";
      }
    }
    this.jdField_f_of_type_Int = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131558448);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    super.a(paramInt, paramBundle);
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          c();
          if (this.jdField_a_of_type_AndroidOsHandler != null) {
            this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          }
        } while (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null);
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
        return;
      } while (!a());
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "ScreenshotResume!");
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new akbc(this), 1000L);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder != null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.e();
      }
      paramInt = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().widthPixels;
    } while (this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView == null);
    if (paramInt < this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
      return;
    }
    this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
  }
  
  public void a(Uri paramUri, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "onDetectScreenshot->fromType:" + paramInt);
    }
    if ((!(this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) || (!((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).isResume()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "onDetectScreenshot->activity is not resume!");
      }
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "onDetectScreenshot->begin time:" + System.currentTimeMillis());
    }
    paramUri = "";
    paramString = Uri.parse(this.jdField_a_of_type_JavaLangString);
    try
    {
      paramString = paramString.getQueryParameter("article_id");
      paramUri = paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
      paramUri.buildDrawingCache();
      paramString = paramUri.getDrawingCache();
      if (!QLog.isDevelopLevel()) {
        break label281;
      }
      QLog.d("SwiftBrowserScreenShotHandler", 2, "onDetectScreenshot->get screenshot time:" + System.currentTimeMillis());
      j = BaseApplicationImpl.getContext().getResources().getConfiguration().orientation;
      if (paramString == null) {
        break label536;
      }
    }
    paramString = paramUri;
    if (paramUri == null) {
      paramString = "";
    }
    ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A69", "0X8006A69", 0, 0, "", paramString, "", "");
    PublicAccountReportUtils.a("0X8006A69", "", "", paramString, "", "");
    if (QLog.isDevelopLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "onDetectScreenshot->after report time:" + System.currentTimeMillis());
    }
    paramUri = a();
    if (paramUri == null)
    {
      QLog.e("SwiftBrowserScreenShotHandler", 1, "onDetectScreenshot error, root = null");
      return;
    }
    label281:
    int j;
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) && ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 8))) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    try
    {
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        int k;
        if ((this.jdField_a_of_type_AndroidAppActivity.getWindow().getAttributes().flags & 0x400) != 1024) {
          k = ImmersiveUtils.a(BaseApplicationImpl.getContext());
        }
        for (this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramString, 0, k, paramString.getWidth(), paramString.getHeight() - k, null, false);; this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramString, 0, 0, paramString.getWidth(), paramString.getHeight(), null, false))
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("SwiftBrowserScreenShotHandler", 2, "onDetectScreenshot->clip screenshot time:" + System.currentTimeMillis());
          }
          if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
          {
            this.jdField_b_of_type_Int = paramInt;
            if (paramInt != 1) {
              break;
            }
            this.jdField_a_of_type_Boolean = true;
            Message localMessage = Message.obtain();
            localMessage.what = 1;
            localMessage.arg1 = j;
            this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
            if (QLog.isDevelopLevel()) {
              QLog.d("SwiftBrowserScreenShotHandler", 2, "onDetectScreenshot->send msg_show_pad time:" + System.currentTimeMillis());
            }
            ThreadManager.executeOnFileThread(new akbi(this, paramInt));
          }
          paramString.recycle();
          label536:
          paramUri.destroyDrawingCache();
          return;
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
        continue;
        this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramString, 0, 0, paramString.getWidth(), paramString.getHeight(), null, false);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        if (paramInt == 2) {
          QQToast.a(BaseApplicationImpl.getContext(), 0, 2131438451, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131558448));
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    this.jdField_f_of_type_JavaLangString = paramString1;
    if ((!TextUtils.isEmpty(paramString2)) && (!paramString2.contains("ShotCache_"))) {
      this.jdField_b_of_type_Int = 3;
    }
    if ((this.jdField_b_of_type_Int == 0) && (paramInt > 0)) {
      this.jdField_b_of_type_Int = paramInt;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "doOnPhotoPlusActivityEditResult->mScreenshotFromType:" + this.jdField_b_of_type_Int + ", mEditScreenshotPath:" + this.jdField_f_of_type_JavaLangString + ", originImagePath:" + paramString2);
    }
    if (this.jdField_b_of_type_Int == 3)
    {
      g(this.jdField_f_of_type_JavaLangString);
      return;
    }
    d();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "doMultiShare->imgUrl:" + paramString + ", isGif:" + paramBoolean);
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Bundle localBundle = new Bundle();
    Object localObject = CookieManager.getInstance();
    ((CookieManager)localObject).setAcceptCookie(true);
    localObject = ((CookieManager)localObject).getCookie(paramString);
    if (localObject != null) {
      localBundle.putString("Cookie", (String)localObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity, this.jdField_f_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131435466);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    this.h = paramString;
    ThreadManager.executeOnSubThread(new akbe(this, paramString, localBundle, paramBoolean));
  }
  
  public void a(JSONArray paramJSONArray)
  {
    this.jdField_a_of_type_OrgJsonJSONArray = paramJSONArray;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->begin isShow:" + paramBoolean + ", orientation:" + paramInt);
    }
    if (paramBoolean) {
      if (!this.jdField_c_of_type_Boolean) {}
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getTag() instanceof Integer)))
          {
            int j = ((Integer)this.jdField_a_of_type_AndroidWidgetLinearLayout.getTag()).intValue();
            if (j != paramInt)
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->orientation change old:" + j + ", new:" + paramInt);
              }
              localObject = (RelativeLayout)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131363436);
              if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b != null)) {
                this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b.findViewById(2131363436);
              }
              this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
              ((RelativeLayout)localObject).removeView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
              this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
            }
          }
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->pad create time:" + System.currentTimeMillis());
            }
            this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2130969229, null));
            localObject = (RelativeLayout)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131363436);
            if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b != null)) {
              this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b.findViewById(2131363436);
            }
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(11);
            localLayoutParams.addRule(12);
            localLayoutParams.setMargins(0, 0, AIOUtils.a(10.0F, BaseApplicationImpl.getContext().getResources()), AIOUtils.a(65.0F, BaseApplicationImpl.getContext().getResources()));
            ((RelativeLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, localLayoutParams);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(Integer.valueOf(paramInt));
            if (paramInt == 2)
            {
              localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365651).getLayoutParams();
              ((LinearLayout.LayoutParams)localObject).width = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131559335);
              ((LinearLayout.LayoutParams)localObject).height = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131559334);
            }
            this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365651).setOnClickListener(new akbj(this));
          }
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getAnimation() != null)
          {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getAnimation().cancel();
            this.jdField_a_of_type_AndroidWidgetLinearLayout.clearAnimation();
          }
          ((ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131365651)).setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        } while (!QLog.isDevelopLevel());
        QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->pad visible time:" + System.currentTimeMillis());
        return;
        if (QLog.isDevelopLevel())
        {
          QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->begin hide mScreenshotContainer:" + this.jdField_a_of_type_AndroidWidgetLinearLayout);
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
            QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->begin hide mScreenshotContainerVisibility:" + this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility());
          }
        }
      } while ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() != 0));
      Object localObject = new AlphaAnimation(1.0F, 0.0F);
      ((AlphaAnimation)localObject).setDuration(300L);
      ((AlphaAnimation)localObject).setAnimationListener(new akbk(this));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation((Animation)localObject);
    } while (!QLog.isDevelopLevel());
    QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->pad gone time:" + System.currentTimeMillis());
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver != null;
  }
  
  List[] a()
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getString(2131430091);
    localActionSheetItem.jdField_b_of_type_Int = 2130838332;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.jdField_c_of_type_Int = 2;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getString(2131430097);
    localActionSheetItem.jdField_b_of_type_Int = 2130838333;
    localActionSheetItem.jdField_a_of_type_Boolean = true;
    localActionSheetItem.jdField_c_of_type_Int = 3;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getString(2131430109);
    localActionSheetItem.jdField_b_of_type_Int = 2130838336;
    localActionSheetItem.jdField_c_of_type_Int = 9;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getString(2131430110);
    localActionSheetItem.jdField_b_of_type_Int = 2130838330;
    localActionSheetItem.jdField_c_of_type_Int = 10;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getString(2131430115);
    localActionSheetItem.jdField_b_of_type_Int = 2130838335;
    localActionSheetItem.jdField_c_of_type_Int = 12;
    localActionSheetItem.jdField_b_of_type_JavaLangString = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentContext.a();
    a();
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null)
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    }
  }
  
  public void b(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver == null) && (this.jdField_a_of_type_AndroidAppActivity != null))
    {
      Object localObject = new DisplayMetrics();
      this.jdField_a_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      this.jdField_c_of_type_Int = ((DisplayMetrics)localObject).widthPixels;
      this.jdField_d_of_type_Int = ((DisplayMetrics)localObject).heightPixels;
      this.jdField_a_of_type_Float = ((DisplayMetrics)localObject).density;
      this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver = new ScreenshotContentObserver(this.jdField_a_of_type_AndroidAppActivity, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver.a(this);
      localObject = a();
      if (localObject != null)
      {
        ((View)localObject).setDrawingCacheEnabled(true);
        ((View)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new akbh(this, (View)localObject));
      }
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "registerScreenshotObserver->mScreenWidth:" + this.jdField_c_of_type_Int + ", mScreenHeight:" + this.jdField_d_of_type_Int + ", mScreenDensity:" + this.jdField_a_of_type_Float);
      }
    }
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_b_of_type_JavaLangString = paramString.replace("|", "｜");
    }
    while ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_AndroidAppActivity == null)) {
      return;
    }
    this.jdField_b_of_type_JavaLangString = BaseApplicationImpl.getContext().getResources().getString(2131438452);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver.a();
      if (this.jdField_a_of_type_AndroidAppActivity != null)
      {
        View localView = a();
        if (localView != null) {
          localView.setDrawingCacheEnabled(false);
        }
      }
      this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver = null;
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "unregisterScreenshotObserver!");
      }
    }
  }
  
  public void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_b_of_type_JavaLangString = paramString.replace("|", "｜");
    }
  }
  
  public void d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "showShareActionSheet->mEditScreenshotPath:" + this.jdField_f_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder = new ShareActionSheetBuilder(this.jdField_a_of_type_AndroidAppActivity);
    }
    if ((PublicAccountUtil.b(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(a()))) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(a());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(a());
      this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(this);
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a();
        if (QLog.isDevelopLevel()) {
          QLog.d("SwiftBrowserScreenShotHandler", 2, "showShareActionSheet->post runnable generate screenshot with QRcode! time:" + System.currentTimeMillis());
        }
        this.jdField_d_of_type_Boolean = true;
        this.g = null;
        this.jdField_e_of_type_Int = 0;
        if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
        {
          this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
          this.jdField_b_of_type_AndroidGraphicsBitmap = null;
        }
        ThreadManager.executeOnSubThread(new akbl(this));
        return;
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.a(BaseApplicationImpl.getContext().getString(2131433083));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserScreenShotHandler", 2, "actionSheet.show exception=" + localException);
          }
        }
      }
    }
  }
  
  public void d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_c_of_type_JavaLangString = paramString;
    }
  }
  
  void e()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "shareScreenShotToQZone!");
    }
    if ((!this.jdField_d_of_type_Boolean) && (!TextUtils.isEmpty(this.g)))
    {
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
      localUserInfo.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      QZoneHelper.a(this.jdField_a_of_type_AndroidAppActivity, localUserInfo, this.g, BaseApplicationImpl.getContext().getString(2131434885), "", -1);
      return;
    }
    this.jdField_e_of_type_Int = 1;
    QQToast.a(BaseApplicationImpl.getContext(), 0, 2131438451, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131558448));
  }
  
  public void e(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_d_of_type_JavaLangString = paramString;
    }
  }
  
  public void f()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "shareScreenShotToWechat!");
    }
    int j;
    if (!WXShareHelper.a().a()) {
      j = 2131435302;
    }
    for (;;)
    {
      if (j != -1)
      {
        QRUtils.a(0, j);
        return;
        if (!WXShareHelper.a().b()) {
          j = 2131435303;
        }
      }
      else
      {
        try
        {
          if ((!this.jdField_d_of_type_Boolean) && (!TextUtils.isEmpty(this.g)))
          {
            this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.d(new akbm(this));
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
        this.jdField_e_of_type_Int = 2;
        QQToast.a(BaseApplicationImpl.getContext(), 0, 2131438451, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131558448));
        return;
      }
      j = -1;
    }
  }
  
  public void f(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QRUtils.a(1, 2131438455);
      return;
    }
    paramString = EditPicActivity.a(this.jdField_a_of_type_AndroidAppActivity, paramString, true, true, true, true, true, 4);
    paramString.putExtra("EditPicType", this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
  }
  
  public void g()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "shareScreenShotToWechatCircle!");
    }
    int j;
    if (!WXShareHelper.a().a()) {
      j = 2131435302;
    }
    for (;;)
    {
      if (j != -1)
      {
        QRUtils.a(0, j);
        return;
        if (!WXShareHelper.a().b()) {
          j = 2131435303;
        }
      }
      else
      {
        try
        {
          if ((!this.jdField_d_of_type_Boolean) && (!TextUtils.isEmpty(this.g)))
          {
            this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.d(new akbn(this));
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
        this.jdField_e_of_type_Int = 3;
        QQToast.a(BaseApplicationImpl.getContext(), 0, 2131438451, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131558448));
        return;
      }
      j = -1;
    }
  }
  
  public void g(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "shareScreenShotToQQ->imgPath:" + paramString);
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ForwardRecentActivity.class);
    localIntent.putExtra("req_share_id", 1478164480L);
    localIntent.putExtra("image_url", paramString);
    localIntent.putExtra("forward_type", -3);
    String str;
    if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
    {
      paramString = this.jdField_a_of_type_JavaLangString;
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        break label281;
      }
      str = BaseApplicationImpl.getContext().getResources().getString(2131438452);
      label115:
      paramString = "ScreenShotShare|" + paramString + "|" + str;
      if (this.jdField_b_of_type_Int != 3) {
        break label289;
      }
    }
    label281:
    label289:
    for (paramString = paramString.concat("|1");; paramString = paramString.concat("|0"))
    {
      localIntent.putExtra("struct_share_key_content_action_DATA", paramString);
      localIntent.putExtra("pkg_name", "com.tencent.mobileqq");
      localIntent.putExtra("req_type", 5);
      localIntent.putExtra("brief_key", "[图片]");
      localIntent.putExtra("struct_share_key_source_icon", "https://q.url.cn/s/jBJuV");
      localIntent.putExtra("struct_share_key_source_name", "QQ看点");
      localIntent.putExtra("struct_share_key_source_action", "plugin");
      localIntent.putExtra("struct_share_key_source_action_data", "mqqapi://readinjoy/open?src_type=internal&version=1&target=1");
      localIntent.putExtra("stuctmsg_bytes", StructMsgFactory.a(localIntent.getExtras()).getBytes());
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, 1);
      return;
      paramString = this.jdField_d_of_type_JavaLangString;
      break;
      str = this.jdField_b_of_type_JavaLangString;
      break label115;
    }
  }
  
  void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "shareMsgToSina start!");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity, this.jdField_f_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131435466);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    Object localObject = BaseApplicationImpl.getContext().getPackageManager();
    for (;;)
    {
      try
      {
        localApplicationInfo = ((PackageManager)localObject).getApplicationInfo("com.sina.weibo", 8192);
        if (QLog.isColorLevel()) {
          QLog.d("SwiftBrowserScreenShotHandler", 2, "shareMsgToSina installSinaWeibo:true");
        }
        if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
          continue;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        }
        QQToast.a(BaseApplicationImpl.getContext(), 0, 2131435286, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131558448));
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        ApplicationInfo localApplicationInfo;
        Intent localIntent;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SwiftBrowserScreenShotHandler", 2, "shareMsgToSina installSinaWeibo:false");
        if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        QQToast.a(BaseApplicationImpl.getContext(), 0, 2131438456, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131558448));
        continue;
        String str = this.jdField_d_of_type_JavaLangString;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "shareMsgToSina end!");
      }
      return;
      if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
        continue;
      }
      localObject = this.jdField_a_of_type_JavaLangString;
      localIntent = new Intent("android.intent.action.SEND");
      localIntent.setFlags(268435456);
      localIntent.setType("image/*");
      localIntent.putExtra("android.intent.extra.TEXT", this.jdField_c_of_type_JavaLangString + (String)localObject);
      if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {
        localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(this.jdField_f_of_type_JavaLangString)));
      }
      localIntent.setPackage(localApplicationInfo.packageName);
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "shareMsgToSina start weibo!");
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      if (QLog.isDevelopLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "handleMessage->recv msg_show_pad time:" + System.currentTimeMillis());
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      a(true, paramMessage.arg1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, 3000L);
    }
    for (;;)
    {
      return true;
      if (QLog.isDevelopLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "handleMessage->recv msg_hide_pad time:" + System.currentTimeMillis());
      }
      a(false, 0);
      continue;
      f(this.jdField_e_of_type_JavaLangString);
    }
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->begin!");
    }
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->tag null!");
      }
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.b();
        paramInt = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)paramAdapterView).a.jdField_c_of_type_Int;
      } while (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment == null);
      str = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.a().getUrl();
      paramAdapterView = "";
      paramView = Uri.parse(str);
      try
      {
        paramView = paramView.getQueryParameter("article_id");
        paramAdapterView = paramView;
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          paramView.printStackTrace();
        }
        g(this.jdField_f_of_type_JavaLangString);
        ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1F", "0X8006A1F", 0, 0, "1001", paramView, "", "");
        PublicAccountReportUtils.a("0X8006A1F", "", "1001", paramView, "", "");
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->do action friend!");
        continue;
        e();
        ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1F", "0X8006A1F", 0, 0, "1002", paramView, "", "");
        PublicAccountReportUtils.a("0X8006A1F", "", "1002", paramView, "", "");
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->do action qzone!");
        continue;
        f();
        ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1F", "0X8006A1F", 0, 0, "1003", paramView, "", "");
        PublicAccountReportUtils.a("0X8006A1F", "", "1003", paramView, "", "");
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->do action wechat!");
        continue;
        g();
        ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1F", "0X8006A1F", 0, 0, "1004", paramView, "", "");
        PublicAccountReportUtils.a("0X8006A1F", "", "1004", paramView, "", "");
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->do action wechat circle!");
        continue;
        h();
        PublicAccountReportUtils.a(null, "", "0X800787A", "0X800787A", 0, 0, paramView, str, "", "");
        ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1F", "0X8006A1F", 0, 0, "1005", paramView, "", "");
        PublicAccountReportUtils.a("0X8006A1F", "", "1005", paramView, "", "");
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->do action sina weibo!");
        continue;
      }
      paramView = paramAdapterView;
      if (paramAdapterView == null) {
        paramView = "";
      }
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->action:" + paramInt + ", articleId:" + paramView + ", mEditScreenshotPath:" + this.jdField_f_of_type_JavaLangString);
      }
      switch (paramInt)
      {
      }
    } while (!QLog.isColorLevel());
    QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->end!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler
 * JD-Core Version:    0.7.0.1
 */