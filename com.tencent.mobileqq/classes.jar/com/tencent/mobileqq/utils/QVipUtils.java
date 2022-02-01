package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.vas.config.business.qvip.QVIPPrettyTroopProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipDiyTemplateConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipDiyTemplateProcessor;
import com.tencent.mobileqq.vas.config.business.qvip.QVipPrettyTroopConfig;
import com.tencent.mobileqq.vas.vip.QVipConfigManager;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QVipUtils
{
  public static float a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) && (paramInt2 != 0)) {
      return Math.round(paramInt1 * 1.0F / paramInt2 * 100.0F) / 100.0F;
    }
    return 0.0F;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap2 = null;
    if (paramBitmap != null)
    {
      if (paramBitmap.isRecycled()) {
        return null;
      }
      if (a(paramBitmap.getWidth(), paramBitmap.getHeight()) == a(paramInt1, paramInt2)) {
        return paramBitmap;
      }
      Paint localPaint = new Paint();
      localPaint.setStyle(Paint.Style.STROKE);
      localPaint.setAntiAlias(true);
      Bitmap localBitmap1;
      if (paramInt1 >= paramBitmap.getWidth())
      {
        localBitmap1 = paramBitmap;
        if (paramInt2 >= paramBitmap.getHeight()) {}
      }
      else
      {
        int j;
        int i;
        if (a(paramBitmap.getWidth(), paramInt1) >= a(paramBitmap.getHeight(), paramInt2))
        {
          j = (int)(paramBitmap.getHeight() * 1.0F / paramBitmap.getWidth() * paramInt1);
          i = paramInt1;
        }
        else
        {
          i = (int)(paramBitmap.getWidth() * 1.0F / paramBitmap.getHeight() * paramInt2);
          j = paramInt2;
        }
        localBitmap2 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        new Canvas(localBitmap2).drawBitmap(paramBitmap, new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), new Rect(0, 0, localBitmap2.getWidth(), localBitmap2.getHeight()), localPaint);
        localBitmap1 = localBitmap2;
      }
      paramBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(paramBitmap);
      localCanvas.drawBitmap(localBitmap1, new Rect(0, 0, localBitmap1.getWidth() / 3, localBitmap1.getHeight() / 3), new Rect(0, 0, localBitmap1.getWidth() / 3, localBitmap1.getHeight() / 3), localPaint);
      localCanvas.drawBitmap(localBitmap1, new Rect(localBitmap1.getWidth() - localBitmap1.getWidth() / 3, 0, localBitmap1.getWidth(), localBitmap1.getHeight() / 3), new Rect(paramBitmap.getWidth() - localBitmap1.getWidth() / 3, 0, paramBitmap.getWidth(), localBitmap1.getHeight() / 3), localPaint);
      localCanvas.drawBitmap(localBitmap1, new Rect(0, localBitmap1.getHeight() - localBitmap1.getHeight() / 3, localBitmap1.getWidth() / 3, localBitmap1.getHeight()), new Rect(0, paramBitmap.getHeight() - localBitmap1.getHeight() / 3, localBitmap1.getWidth() / 3, paramBitmap.getHeight()), localPaint);
      localCanvas.drawBitmap(localBitmap1, new Rect(localBitmap1.getWidth() - localBitmap1.getWidth() / 3, localBitmap1.getHeight() - localBitmap1.getHeight() / 3, localBitmap1.getWidth(), localBitmap1.getHeight()), new Rect(paramBitmap.getWidth() - localBitmap1.getWidth() / 3, paramBitmap.getHeight() - localBitmap1.getHeight() / 3, paramBitmap.getWidth(), paramBitmap.getHeight()), localPaint);
      localCanvas.drawBitmap(localBitmap1, new Rect(localBitmap1.getWidth() / 3, 0, localBitmap1.getWidth() - localBitmap1.getWidth() / 3, localBitmap1.getHeight() / 3), new Rect(localBitmap1.getWidth() / 3, 0, paramBitmap.getWidth() - localBitmap1.getWidth() / 3, localBitmap1.getHeight() / 3), localPaint);
      localCanvas.drawBitmap(localBitmap1, new Rect(0, localBitmap1.getHeight() / 3, localBitmap1.getWidth() / 3, localBitmap1.getHeight() - localBitmap1.getHeight() / 3), new Rect(0, localBitmap1.getHeight() / 3, localBitmap1.getWidth() / 3, paramBitmap.getHeight() - localBitmap1.getHeight() / 3), localPaint);
      localCanvas.drawBitmap(localBitmap1, new Rect(localBitmap1.getWidth() - localBitmap1.getWidth() / 3, localBitmap1.getHeight() / 3, localBitmap1.getWidth(), localBitmap1.getHeight() - localBitmap1.getHeight() / 3), new Rect(paramBitmap.getWidth() - localBitmap1.getWidth() / 3, localBitmap1.getHeight() / 3, paramBitmap.getWidth(), paramBitmap.getHeight() - localBitmap1.getHeight() / 3), localPaint);
      localCanvas.drawBitmap(localBitmap1, new Rect(localBitmap1.getWidth() / 3, localBitmap1.getHeight() - localBitmap1.getHeight() / 3, localBitmap1.getWidth() - localBitmap1.getWidth() / 3, localBitmap1.getHeight()), new Rect(localBitmap1.getWidth() / 3, paramBitmap.getHeight() - localBitmap1.getHeight() / 3, paramBitmap.getWidth() - localBitmap1.getWidth() / 3, paramBitmap.getHeight()), localPaint);
      localCanvas.drawBitmap(localBitmap1, new Rect(localBitmap1.getWidth() / 3, localBitmap1.getHeight() / 3, localBitmap1.getWidth() - localBitmap1.getWidth() / 3, localBitmap1.getHeight() - localBitmap1.getHeight() / 3), new Rect(localBitmap1.getWidth() / 3, localBitmap1.getHeight() / 3, paramBitmap.getWidth() - localBitmap1.getWidth() / 3, paramBitmap.getHeight() - localBitmap1.getHeight() / 3), localPaint);
      if (localBitmap2 != null) {
        localBitmap2.recycle();
      }
      return paramBitmap;
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      SLog.b("DIYProfileTemplate.QVipUtils", "getDiyTemplateBackground but json is null");
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("bg");
        if (paramString != null) {
          break label132;
        }
        SLog.b("DIYProfileTemplate.QVipUtils", "getDiyTemplateBackground but json bg array is null");
        return null;
      }
      catch (JSONException paramString)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getDiyTemplateBackground but json is illegal:");
        ((StringBuilder)localObject).append(paramString);
        SLog.b("DIYProfileTemplate.QVipUtils", ((StringBuilder)localObject).toString());
      }
      if (i < paramString.length())
      {
        localObject = paramString.getJSONObject(i);
        if (localObject != null)
        {
          if ("image_view".equals(((JSONObject)localObject).optString("type"))) {
            return ((JSONObject)localObject).optString("content");
          }
          SLog.b("DIYProfileTemplate.QVipUtils", "getDiyTemplateBackground but json bg array don't have image view");
        }
        i += 1;
      }
      else
      {
        return null;
        label132:
        i = 0;
      }
    }
  }
  
  private static String a(boolean paramBoolean, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder("https://club.vip.qq.com/profile/custom?_wv=131072&_fv=0");
    if (paramBoolean) {
      localStringBuilder.append("&from=guest");
    }
    localStringBuilder.append("&templateId=");
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext = new ActivityURIRequest(paramContext, "/vas/h5pay");
    paramContext.extra().putString("url", paramString);
    QRoute.startUri(paramContext, null);
  }
  
  public static void a(Card paramCard, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    if (!QVipDiyTemplateProcessor.c().a)
    {
      QQToast.a(paramActivity, 0, HardCodeUtil.a(2131711344), 0).a();
      return;
    }
    paramCard = a(TextUtils.equals(paramQQAppInterface.getCurrentAccountUin(), paramCard.uin) ^ true, paramCard.cardId);
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
    localIntent.putExtra("isShowAd", false);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("has_red_dot", false);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("individuation_url_type", 40203);
    localIntent.putExtra("url", paramCard);
    VasWebviewUtil.b(paramActivity, paramCard, -1L, localIntent, true, 1036);
  }
  
  public static void a(TroopInfo paramTroopInfo, String paramString, Activity paramActivity)
  {
    if (paramTroopInfo == null)
    {
      QLog.e("vip_pretty.", 1, "goToPrettyTroopManagePage error,because troop info is null");
      return;
    }
    if (paramTroopInfo.checkFlagExt4(3))
    {
      QLog.e("vip_pretty.", 1, "goToPrettyTroopManagePage open mine page");
      a(QVIPPrettyTroopProcessor.c().a("troop", paramTroopInfo.troopuin), paramString, paramActivity);
      return;
    }
    QLog.e("vip_pretty.", 1, "goToPrettyTroopManagePage open home page");
    a(QVIPPrettyTroopProcessor.c().a("troop"), paramString, paramActivity);
  }
  
  public static void a(String paramString1, String paramString2, Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("uin", paramString2);
    localIntent.putExtra("isShowAd", false);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("has_red_dot", false);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("individuation_url_type", 40402);
    localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    localIntent.putExtra("url", paramString1);
    VasWebviewUtil.b(paramContext, paramString1, -1L, localIntent, false, 0);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (!QVipConfigManager.a(paramQQAppInterface, "hide_diy_template_guide", false)) {
      return QVipDiyTemplateProcessor.c().a;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QVipUtils
 * JD-Core Version:    0.7.0.1
 */