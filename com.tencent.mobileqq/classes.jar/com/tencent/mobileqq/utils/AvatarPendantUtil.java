package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public final class AvatarPendantUtil
{
  public static ConcurrentHashMap<Long, Integer> a = new ConcurrentHashMap();
  public static ConcurrentHashMap<Long, Integer> b = new ConcurrentHashMap();
  public static String c = "https://i.gtimg.cn/qqshow/admindata/comdata/AndroidIconZip/icon.zip";
  public static final String d;
  public static String e;
  static final ArrayList<String> f = new ArrayList();
  static volatile boolean g = false;
  public static int h = 5000;
  private static long i = -1L;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("avatarPendantIcons");
    d = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(d);
    localStringBuilder.append("/icon");
    e = localStringBuilder.toString();
  }
  
  public static float a(Paint paramPaint, Rect paramRect, String paramString)
  {
    int j = paramRect.width();
    if (j <= 0) {
      return 0.0F;
    }
    paramPaint = new TextPaint(paramPaint);
    float f1 = paramRect.height();
    paramPaint.setTextSize(f1);
    while (((paramPaint.measureText(paramString) > j) || (Math.ceil(paramPaint.getFontMetrics().descent - paramPaint.getFontMetrics().ascent) > paramRect.height())) && (f1 > 0.0F))
    {
      f1 -= 1.0F;
      paramPaint.setTextSize(f1);
    }
    return f1;
  }
  
  public static String a(long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("pendant.");
    localStringBuilder.append(paramLong);
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 4) {
          localStringBuilder.append(".other.zip");
        } else {
          localStringBuilder.append(".xydata.js");
        }
      }
      else {
        localStringBuilder.append(".other.zip");
      }
    }
    else {
      localStringBuilder.append(".aio_50.png");
    }
    return localStringBuilder.toString();
  }
  
  public static String a(File paramFile)
  {
    String str2 = "";
    String str1 = str2;
    if (paramFile != null)
    {
      str1 = str2;
      if (!paramFile.exists()) {}
    }
    try
    {
      paramFile = new String(FileUtils.fileToBytes(paramFile));
      int j = paramFile.indexOf("\"seriesID\":");
      str1 = str2;
      if (j != -1)
      {
        int k = paramFile.indexOf(",", j + 10);
        str1 = str2;
        if (k != -1) {
          str1 = paramFile.substring(j + 11, k);
        }
      }
      return str1;
    }
    catch (Exception paramFile) {}
    return "";
  }
  
  public static void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject).append("avatarPendantDefaultHead");
    localObject = new File(((StringBuilder)localObject).toString());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdir();
    }
    localObject = new File(AppConstants.SDCARD_PENDANT_ROOT);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdir();
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramContext = paramContext.getSharedPreferences(String.format("sp_pendant_market_open_time_%s", new Object[] { paramString2 }), 0);
      if (paramContext != null) {
        paramContext.edit().putLong(paramString1, paramLong).commit();
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveMarketOpenTime, entrance=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", uin=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", context=");
      localStringBuilder.append(paramContext);
      QLog.d("AvatarPendantUtil", 2, localStringBuilder.toString());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      if (f.size() == 0) {
        return;
      }
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("bulkGetStrangerPendantId, size=");
        localStringBuilder.append(f.size());
        QLog.i("AvatarPendantUtil", 2, localStringBuilder.toString());
      }
      long l = 0L;
      boolean bool1;
      if (f.size() >= 5) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (i != -1L)
      {
        l = System.currentTimeMillis() - i;
        if (l < h)
        {
          bool2 = false;
          break label118;
        }
      }
      boolean bool2 = true;
      label118:
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("bulkGetStrangerPendantId, thresholdReached=");
        localStringBuilder.append(bool1);
        localStringBuilder.append(", intervalReached=");
        localStringBuilder.append(bool2);
        QLog.i("AvatarPendantUtil", 2, localStringBuilder.toString());
      }
      if ((!bool1) && (!bool2) && (g))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AvatarPendantUtil", 2, "bulkGetStrangerPendantId, condition unavailable, abort");
        }
        return;
      }
      paramQQAppInterface = new AvatarPendantUtil.1(paramQQAppInterface);
      if ((!bool1) && (!bool2))
      {
        g = true;
        ThreadManager.getUIHandler().postDelayed(paramQQAppInterface, h - l);
        return;
      }
      ThreadManagerV2.excute(paramQQAppInterface, 128, null, false);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    a(paramQQAppInterface, paramContext, true, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, PreloadProcHitSession paramPreloadProcHitSession)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = (IWebProcessManagerService)paramQQAppInterface.getRuntimeService(IWebProcessManagerService.class, "");
        if (paramQQAppInterface != null)
        {
          long l = paramContext.getSharedPreferences(String.format("sp_pendant_market_open_time_%s", new Object[] { paramString2 }), 0).getLong(paramString1, 0L);
          if (System.currentTimeMillis() - l < 604800000L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AvatarPendantUtil", 2, "preloadWebProcess, startWebProcess");
            }
            paramQQAppInterface.startWebProcess(-1, new AvatarPendantUtil.2(paramPreloadProcHitSession));
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("AvatarPendantUtil", 2, "preloadWebProcess, web process alive aready");
        }
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramPreloadProcHitSession = new StringBuilder();
      paramPreloadProcHitSession.append("preloadWebProcess, entrance=");
      paramPreloadProcHitSession.append(paramString1);
      paramPreloadProcHitSession.append(", uin=");
      paramPreloadProcHitSession.append(paramString2);
      paramPreloadProcHitSession.append(", context=");
      paramPreloadProcHitSession.append(paramContext);
      paramPreloadProcHitSession.append(", app=");
      paramPreloadProcHitSession.append(paramQQAppInterface);
      QLog.d("AvatarPendantUtil", 2, paramPreloadProcHitSession.toString());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, boolean paramBoolean, AllInOne paramAllInOne)
  {
    if (paramQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      Intent localIntent;
      if (paramAllInOne != null)
      {
        localIntent = new Intent(paramContext, AvatarPendantActivity.class);
        localIntent.putExtra("AllInOne", paramAllInOne);
      }
      else
      {
        localIntent = new Intent(paramContext, QQBrowserActivity.class);
      }
      GameCenterManagerImp localGameCenterManagerImp = (GameCenterManagerImp)paramQQAppInterface.getManager(QQManagerFactory.GAMECENTER_MANAGER);
      int j = localGameCenterManagerImp.a("100005.100006");
      if ((j == 1) || (j == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AvatarPendantUtil", 2, "Clear pendant red flag");
        }
        localIntent.putExtra("key_update_flag", true);
        IRedTouchManager localIRedTouchManager = (IRedTouchManager)paramQQAppInterface.getRuntimeService(IRedTouchManager.class, "");
        localIRedTouchManager.onRedTouchItemClick("100005.100006");
        if (localGameCenterManagerImp.a("100005.100003") != -1) {
          j = 1;
        } else {
          j = 0;
        }
        int k;
        if (localGameCenterManagerImp.a("100005.100002") != -1) {
          k = 1;
        } else {
          k = 0;
        }
        int m;
        if (localGameCenterManagerImp.a("100005.100001") != -1) {
          m = 1;
        } else {
          m = 0;
        }
        int n;
        if (localGameCenterManagerImp.a("100005.100018") != -1) {
          n = 1;
        } else {
          n = 0;
        }
        int i1;
        if (localGameCenterManagerImp.a("100005.100020") != -1) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        int i2;
        if (localGameCenterManagerImp.a("100005.100021") != -1) {
          i2 = 1;
        } else {
          i2 = 0;
        }
        int i3;
        if ((((IFontManagerService)paramQQAppInterface.getRuntimeService(IFontManagerService.class, "")).isSupportFont()) && (localGameCenterManagerImp.a("100005.100011") != -1)) {
          i3 = 1;
        } else {
          i3 = 0;
        }
        if ((j == 0) && (k == 0) && (m == 0) && (n == 0) && (i3 == 0) && (i1 == 0) && (i2 == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AvatarPendantUtil", 2, "Clear parent red flag");
          }
          localIRedTouchManager.onRedTouchItemClick("100005");
        }
      }
      if (paramAllInOne == null)
      {
        localIntent.putExtra("hide_left_button", false);
        localIntent.putExtra("show_right_close_button", false);
        localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
        localIntent.putExtra("url", IndividuationUrlHelper.a(paramContext, "pendant", ""));
        localIntent.putExtra("business", 512L);
        if (paramBoolean) {
          j = 40202;
        } else {
          j = 40201;
        }
        localIntent.putExtra("individuation_url_type", j);
        VasWebviewUtil.a(512L, localIntent);
        localIntent.putExtra("isShowAd", false);
      }
      paramContext.startActivity(localIntent);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "PendantMarket", "OtherEntrance", 0, 0, "", "", "", "");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    ((IApolloExtensionHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(new String[] { paramString }, new int[] { 27235 });
  }
  
  public static void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    synchronized (f)
    {
      if (f.contains(paramString)) {
        return;
      }
      f.add(paramString);
      return;
    }
  }
  
  public static boolean a(long paramLong)
  {
    Integer localInteger = (Integer)a.get(Long.valueOf(paramLong));
    if (localInteger == null) {
      return true;
    }
    return localInteger.intValue() == 1;
  }
  
  public static String b(long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PENDANT_ROOT);
    localStringBuilder.append(paramLong);
    localStringBuilder.append(File.separator);
    switch (paramInt)
    {
    default: 
      break;
    case 8: 
      localStringBuilder.append("aio_file");
      break;
    case 7: 
      localStringBuilder.append("market_dynamic_50.gif");
      break;
    case 6: 
      localStringBuilder.append("avatarfit.png");
      break;
    case 5: 
      localStringBuilder.append("preview_50.png");
      break;
    case 4: 
      localStringBuilder.append("config.json");
      break;
    case 3: 
      localStringBuilder.append("thumb_nail_50.png");
      break;
    case 2: 
      localStringBuilder.append("aio_file.zip");
      break;
    case 1: 
      localStringBuilder.append("aio_50.png");
    }
    return localStringBuilder.toString();
  }
  
  public static boolean b(long paramLong)
  {
    Integer localInteger = (Integer)b.get(Long.valueOf(paramLong));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isDiy=");
      localStringBuilder.append(localInteger);
      QLog.d("AvatarPendantUtil", 2, localStringBuilder.toString());
    }
    boolean bool = true;
    if (localInteger == null) {
      return true;
    }
    if (localInteger.intValue() != 1)
    {
      if (localInteger.intValue() == 2) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static boolean b(String paramString)
  {
    return new File(c(paramString)).exists();
  }
  
  public static String c(long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://i.gtimg.cn/qqshow/admindata/comdata/vipFaceAddon_");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(File.separator);
    switch (paramInt)
    {
    default: 
      break;
    case 7: 
      localStringBuilder.append("preview_50.gif");
      break;
    case 6: 
      localStringBuilder.append("avatarfit.png");
      break;
    case 5: 
      localStringBuilder.append("list_50.png");
      break;
    case 4: 
      localStringBuilder.append("xydata.js");
      break;
    case 3: 
      localStringBuilder.append("thumb_nail_50.png");
      break;
    case 2: 
      localStringBuilder.append("aio_file.zip");
      break;
    case 1: 
      localStringBuilder.append("aio_50.png");
    }
    return EmosmUtils.a("VIP_avatar", localStringBuilder.toString());
  }
  
  public static String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PENDANT_ROOT);
    localStringBuilder.append("font_info/");
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append(".ttf");
    return localStringBuilder.toString();
  }
  
  public static String d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PENDANT_ROOT);
    localStringBuilder.append("font_info/");
    localStringBuilder.append(paramString);
    localStringBuilder.append("/");
    return localStringBuilder.toString();
  }
  
  public static boolean e(String paramString)
  {
    paramString = paramString.replace("faceAddon.sticker.", "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PENDANT_ROOT);
    localStringBuilder.append("sticker_info");
    return new File(localStringBuilder.toString(), paramString).exists();
  }
  
  public static String f(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PENDANT_ROOT);
    localStringBuilder.append("sticker_info/");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".png");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AvatarPendantUtil
 * JD-Core Version:    0.7.0.1
 */