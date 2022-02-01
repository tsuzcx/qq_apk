package com.tencent.mobileqq.troop.troopnotification.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.troop.troopnotification.config.TroopNotificationEntryConfig;
import com.tencent.mobileqq.troop.utils.RecommendTroopUtils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class TroopNotificationUtils
{
  protected static HashMap<String, structmsg.StructMsg> a;
  
  public static int a(int paramInt)
  {
    if (paramInt != 1)
    {
      if ((paramInt != 2) && (paramInt != 10))
      {
        if ((paramInt == 22) || (paramInt == 60)) {
          break label44;
        }
        if (paramInt != 12)
        {
          if (paramInt == 13) {
            break label44;
          }
          return 0;
        }
      }
      return 1;
    }
    label44:
    return 2;
  }
  
  public static int a(AppInterface paramAppInterface)
  {
    Object localObject = (TroopNotificationEntryConfig)QConfigManager.b().b(691);
    int i = 0;
    if ((localObject == null) || (!((TroopNotificationEntryConfig)localObject).b(paramAppInterface.getCurrentAccountUin())))
    {
      i = 0 + GroupSystemMsgController.a().b(paramAppInterface);
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getTroopNotificationUnreadNum notification count:");
        ((StringBuilder)localObject).append(i);
        QLog.d("TroopNotificationUtils", 4, ((StringBuilder)localObject).toString());
      }
      int j = i + RecommendTroopUtils.b(paramAppInterface);
      i = j;
      if (QLog.isDevelopLevel())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("getTroopNotificationUnreadNum recommend count:");
        paramAppInterface.append(j);
        QLog.d("TroopNotificationUtils", 4, paramAppInterface.toString());
        i = j;
      }
    }
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("getTroopNotificationUnreadNum return count =");
      paramAppInterface.append(i);
      QLog.d("TroopNotificationUtils", 2, paramAppInterface.toString());
    }
    return i;
  }
  
  public static Drawable a(IFaceDecoder paramIFaceDecoder, String paramString, int paramInt)
  {
    if ((paramIFaceDecoder != null) && (paramString != null) && (paramInt != -1))
    {
      if (paramIFaceDecoder.isPausing()) {
        paramIFaceDecoder.resume();
      }
      Bitmap localBitmap2 = paramIFaceDecoder.getBitmapFromCache(paramInt, paramString);
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 == null)
      {
        paramIFaceDecoder.requestDecodeFace(paramString, paramInt, true);
        if (paramInt == 4) {
          localBitmap1 = BaseImageUtil.g();
        } else {
          localBitmap1 = BaseImageUtil.k();
        }
      }
      return new BitmapDrawable(localBitmap1);
    }
    return null;
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationUtils", 2, "clearAccountLoginInfoSp");
    }
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("troop_notification_sp", 0);
    if (localSharedPreferences == null) {
      return;
    }
    localSharedPreferences.edit().clear().commit();
  }
  
  public static final void a(Context paramContext, String paramString1, String paramString2)
  {
    String str = String.format("https://qun.qq.com/qunpay/qunfee/pay.html?gc=%s&source=joingroup&_wv=1031", new Object[] { paramString1 });
    paramString1 = str;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = new StringBuilder();
      paramString1.append(str);
      paramString1.append("&source_id=");
      paramString1.append(paramString2);
      paramString1 = paramString1.toString();
    }
    paramContext = new ActivityURIRequest(paramContext, "/base/browser");
    paramContext.extra().putString("url", paramString1);
    paramContext.extra().putString("big_brother_source_key", "biz_src_location_share");
    QRoute.startUri(paramContext, null);
  }
  
  public static final void a(String paramString, structmsg.StructMsg paramStructMsg)
  {
    if (a == null) {
      a = new HashMap(3);
    }
    a.put(paramString, paramStructMsg);
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = BaseApplication.getContext().getSharedPreferences("troop_notification_sp", 0);
    if (localObject == null) {
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isFirstLogin");
    localStringBuilder.append(paramString);
    ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), paramBoolean).commit();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setIsAccountFirstLogin uin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" firstLogin=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("TroopNotificationUtils", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = BaseApplication.getContext().getSharedPreferences("troop_notification_sp", 0);
    if (localObject == null) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isFirstLogin");
    localStringBuilder.append(paramString);
    boolean bool = ((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), true);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isAccountFirstLogin uin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" result=");
      ((StringBuilder)localObject).append(bool);
      QLog.d("TroopNotificationUtils", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public static final structmsg.StructMsg b(String paramString)
  {
    HashMap localHashMap = a;
    if ((localHashMap != null) && (localHashMap.containsKey(paramString))) {
      return (structmsg.StructMsg)a.get(paramString);
    }
    return null;
  }
  
  public static final void b()
  {
    HashMap localHashMap = a;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public static boolean b(AppInterface paramAppInterface)
  {
    TroopNotificationEntryConfig localTroopNotificationEntryConfig = (TroopNotificationEntryConfig)QConfigManager.b().b(691);
    if ((localTroopNotificationEntryConfig != null) && (localTroopNotificationEntryConfig.b(paramAppInterface.getCurrentAccountUin())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotificationUtils", 2, "isTroopNotificationShowNewEntry return true");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationUtils", 2, "isTroopNotificationShowNewEntry return false");
    }
    return false;
  }
  
  public static void c(AppInterface paramAppInterface)
  {
    paramAppInterface = paramAppInterface.getApp().getSharedPreferences(paramAppInterface.getAccount(), 0);
    int i = paramAppInterface.getInt("share_key_pay2joinTroop_request_num", 0);
    paramAppInterface = paramAppInterface.edit();
    paramAppInterface.putInt("share_key_pay2joinTroop_request_num", i + 1);
    paramAppInterface.commit();
  }
  
  public static void d(AppInterface paramAppInterface)
  {
    paramAppInterface = paramAppInterface.getApp().getSharedPreferences(paramAppInterface.getAccount(), 0).edit();
    paramAppInterface.putInt("share_key_pay2joinTroop_request_num", 0);
    paramAppInterface.commit();
  }
  
  public static int e(AppInterface paramAppInterface)
  {
    return paramAppInterface.getApp().getSharedPreferences(paramAppInterface.getAccount(), 0).getInt("share_key_pay2joinTroop_request_num", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.utils.TroopNotificationUtils
 * JD-Core Version:    0.7.0.1
 */