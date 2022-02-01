package com.tencent.mobileqq.vip;

import MQQ.PopupImgInfo;
import MQQ.ToastImgInfo;
import MQQ.TrafficResultInfo;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class CUKingCardHelper
{
  private static final ConcurrentHashMap<String, Boolean> a = new ConcurrentHashMap();
  
  public static int a()
  {
    return CUKingCardUtils.a();
  }
  
  /* Error */
  public static int a(int paramInt, Context paramContext)
  {
    // Byte code:
    //   0: ldc 28
    //   2: invokestatic 34	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   5: astore_3
    //   6: aload_1
    //   7: invokevirtual 40	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore 4
    //   12: aconst_null
    //   13: astore_1
    //   14: aconst_null
    //   15: astore_2
    //   16: aload 4
    //   18: aload_3
    //   19: iconst_2
    //   20: anewarray 42	java/lang/String
    //   23: dup
    //   24: iconst_0
    //   25: ldc 44
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: ldc 46
    //   32: aastore
    //   33: ldc 48
    //   35: iconst_1
    //   36: anewarray 42	java/lang/String
    //   39: dup
    //   40: iconst_0
    //   41: iload_0
    //   42: invokestatic 52	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   45: aastore
    //   46: aconst_null
    //   47: invokevirtual 58	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   50: astore_3
    //   51: aload_3
    //   52: ifnull +47 -> 99
    //   55: aload_3
    //   56: astore_2
    //   57: aload_3
    //   58: astore_1
    //   59: aload_3
    //   60: invokeinterface 64 1 0
    //   65: ifeq +34 -> 99
    //   68: aload_3
    //   69: astore_2
    //   70: aload_3
    //   71: astore_1
    //   72: aload_3
    //   73: aload_3
    //   74: ldc 44
    //   76: invokeinterface 68 2 0
    //   81: invokeinterface 72 2 0
    //   86: istore_0
    //   87: aload_3
    //   88: ifnull +9 -> 97
    //   91: aload_3
    //   92: invokeinterface 75 1 0
    //   97: iload_0
    //   98: ireturn
    //   99: aload_3
    //   100: ifnull +66 -> 166
    //   103: aload_3
    //   104: astore_1
    //   105: goto +55 -> 160
    //   108: astore_1
    //   109: goto +59 -> 168
    //   112: astore_3
    //   113: aload_1
    //   114: astore_2
    //   115: new 77	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   122: astore 4
    //   124: aload_1
    //   125: astore_2
    //   126: aload 4
    //   128: ldc 80
    //   130: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload_1
    //   135: astore_2
    //   136: aload 4
    //   138: aload_3
    //   139: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload_1
    //   144: astore_2
    //   145: ldc 89
    //   147: iconst_1
    //   148: aload 4
    //   150: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: aload_1
    //   157: ifnull +9 -> 166
    //   160: aload_1
    //   161: invokeinterface 75 1 0
    //   166: iconst_m1
    //   167: ireturn
    //   168: aload_2
    //   169: ifnull +9 -> 178
    //   172: aload_2
    //   173: invokeinterface 75 1 0
    //   178: aload_1
    //   179: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	paramInt	int
    //   0	180	1	paramContext	Context
    //   15	158	2	localObject1	Object
    //   5	99	3	localObject2	Object
    //   112	27	3	localException	Exception
    //   10	139	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   16	51	108	finally
    //   59	68	108	finally
    //   72	87	108	finally
    //   115	124	108	finally
    //   126	134	108	finally
    //   136	143	108	finally
    //   145	156	108	finally
    //   16	51	112	java/lang/Exception
    //   59	68	112	java/lang/Exception
    //   72	87	112	java/lang/Exception
  }
  
  public static CUKingCardHelper.CUKingCustomDialogInfo a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    VasWebviewUtil.a("", "wkclub", "P1", paramString, 1, 0, 0, "", "", "");
    Object localObject1 = BaseApplicationImpl.getApplication();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("CUKingCardFile_");
    ((StringBuilder)localObject2).append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localObject1 = ((BaseApplicationImpl)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 4);
    localObject2 = new CUKingCardHelper.CUKingCustomDialogInfo();
    ((CUKingCardHelper.CUKingCustomDialogInfo)localObject2).b = a(paramString);
    if (!((SharedPreferences)localObject1).getBoolean("guideEnable", false))
    {
      QLog.i("CUKingCardHelper", 2, "not in CUKing Card gray uin!");
      ((CUKingCardHelper.CUKingCustomDialogInfo)localObject2).a = 4;
    }
    else if (((SharedPreferences)localObject1).getInt("guideToastOpen", 0) == 1)
    {
      a(paramString, paramBoolean2, (SharedPreferences)localObject1, (CUKingCardHelper.CUKingCustomDialogInfo)localObject2);
    }
    else if (((SharedPreferences)localObject1).getInt("guidePopupOpen", 0) == 1)
    {
      b(paramString, paramBoolean1, (SharedPreferences)localObject1, (CUKingCardHelper.CUKingCustomDialogInfo)localObject2);
    }
    else
    {
      ((CUKingCardHelper.CUKingCustomDialogInfo)localObject2).a = 4;
    }
    a(paramString, (CUKingCardHelper.CUKingCustomDialogInfo)localObject2);
    return localObject2;
  }
  
  private static Object a(int paramInt, String paramString, Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramString = paramContext.getClass().getMethod(paramString, c(paramString));
        if (paramInt >= 0)
        {
          paramString = paramString.invoke(paramContext, new Object[] { Integer.valueOf(paramInt) });
          return paramString;
        }
      }
    }
    catch (Exception paramString)
    {
      paramContext = new StringBuilder();
      paramContext.append("getPhoneInfo e = ");
      paramContext.append(paramString);
      QLog.e("CUKingCardHelper", 1, paramContext.toString());
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    Object localObject1 = BaseApplicationImpl.getApplication();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("CUKingCardFile_");
    ((StringBuilder)localObject2).append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    Object localObject3 = ((BaseApplicationImpl)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 4);
    localObject2 = ((SharedPreferences)localObject3).getString("guideUrl", "");
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "https://mc.vip.qq.com/wkcenter/index?_wv=3&_nav_alpha=0&_wvx=3";
    }
    if ((((SharedPreferences)localObject3).getInt("kingCardSdk", 0) != 1) && (((SharedPreferences)localObject3).getInt("kingCard", 0) != 1) && (((SharedPreferences)localObject3).getInt("kingCard2", 0) != 1)) {
      localObject2 = "open";
    } else {
      localObject2 = "update";
    }
    if (!((String)localObject1).contains("?"))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("?");
      localObject1 = ((StringBuilder)localObject3).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("source=");
      ((StringBuilder)localObject3).append(paramString);
      ((StringBuilder)localObject3).append("&type=");
      ((StringBuilder)localObject3).append((String)localObject2);
      paramString = ((StringBuilder)localObject3).toString();
    }
    else
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("&source=");
      ((StringBuilder)localObject3).append(paramString);
      ((StringBuilder)localObject3).append("&type=");
      ((StringBuilder)localObject3).append((String)localObject2);
      paramString = ((StringBuilder)localObject3).toString();
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("open guide url: ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i("CUKingCardHelper", 2, ((StringBuilder)localObject1).toString());
    }
    return paramString;
  }
  
  public static void a(TrafficResultInfo paramTrafficResultInfo, Bundle paramBundle)
  {
    if (paramTrafficResultInfo == null)
    {
      QLog.e("CUKingCardHelper", 1, "saveCUKingInfo error : trafficInfo = null");
      return;
    }
    if (paramTrafficResultInfo.bUpdate == 0)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("bUpdate=");
      paramBundle.append(paramTrafficResultInfo.bUpdate);
      paramBundle.append(" it do not need to update CUKing info");
      QLog.e("CUKingCardHelper", 1, paramBundle.toString());
      return;
    }
    b(paramTrafficResultInfo, paramBundle);
  }
  
  private static void a(String paramString, CUKingCardHelper.CUKingCustomDialogInfo paramCUKingCustomDialogInfo)
  {
    int i = paramCUKingCustomDialogInfo.a;
    if (i != 1) {
      if (i != 2) {
        if (i != 4) {
          paramCUKingCustomDialogInfo = "P3";
        }
      }
    }
    for (;;)
    {
      break;
      paramCUKingCustomDialogInfo = "P4";
      continue;
      paramCUKingCustomDialogInfo = "P2";
      continue;
      paramCUKingCustomDialogInfo = "P5";
    }
    VasWebviewUtil.a("", "wkclub", paramCUKingCustomDialogInfo, paramString, 1, 0, 0, "", "", "");
  }
  
  private static void a(String paramString, boolean paramBoolean, SharedPreferences paramSharedPreferences, CUKingCardHelper.CUKingCustomDialogInfo paramCUKingCustomDialogInfo)
  {
    if (paramBoolean)
    {
      String str = paramSharedPreferences.getString("toastText", "");
      if (a.containsKey(paramString))
      {
        paramString = paramSharedPreferences.getString("shortToastText", "");
      }
      else
      {
        a.put(paramString, Boolean.TRUE);
        paramString = str;
      }
      int i = paramSharedPreferences.getInt("toastShowTime", 2);
      QQToast.makeText(BaseApplicationImpl.getContext(), 2, paramString, i * 1000).show();
    }
    paramCUKingCustomDialogInfo.a = 1;
  }
  
  public static boolean a(Activity paramActivity, int paramInt, CUKingCardHelper.CUKingDialogListener paramCUKingDialogListener, String paramString)
  {
    if (paramActivity != null)
    {
      if (paramActivity.isFinishing()) {
        return false;
      }
      CUKingCardHelper.CUKingCustomDialogInfo localCUKingCustomDialogInfo = a(paramString, false, true);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("shouldOverrideDialog, popUpType: ");
        localStringBuilder.append(localCUKingCustomDialogInfo.a);
        QLog.i("CUKingCardHelper", 2, localStringBuilder.toString());
      }
      if (localCUKingCustomDialogInfo.a == 4) {
        return true;
      }
      if (localCUKingCustomDialogInfo.a == 1)
      {
        if (paramCUKingDialogListener != null) {
          paramCUKingDialogListener.callback(2);
        }
        return false;
      }
      new CUKingCardDialog(paramActivity, paramCUKingDialogListener, paramInt, paramString, localCUKingCustomDialogInfo.a).show();
    }
    return false;
  }
  
  public static int b(String paramString)
  {
    return CUKingCardUtils.a(paramString);
  }
  
  public static String b(int paramInt, Context paramContext)
  {
    paramContext = (String)a(a(paramInt, paramContext), "getSubscriberId", paramContext);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSubscriberId, imsi = ");
      localStringBuilder.append(paramContext);
      QLog.d("CUKingCardHelper", 2, localStringBuilder.toString());
    }
    return paramContext;
  }
  
  private static void b(TrafficResultInfo paramTrafficResultInfo, Bundle paramBundle)
  {
    boolean bool1 = paramBundle.getBoolean(VipInfoHandler.i);
    boolean bool2 = paramBundle.getBoolean(VipInfoHandler.j);
    String str = paramBundle.getString(VipInfoHandler.k);
    Object localObject1 = paramBundle.getString(VipInfoHandler.l);
    paramBundle = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    Object localObject2 = BaseApplicationImpl.getApplication();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("CUKingCardFile_");
    ((StringBuilder)localObject3).append(paramBundle);
    localObject3 = ((BaseApplicationImpl)localObject2).getSharedPreferences(((StringBuilder)localObject3).toString(), 4);
    localObject2 = ((SharedPreferences)localObject3).edit();
    if (bool1)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("Save CUKing Card Order State, State1: ");
      paramBundle.append(paramTrafficResultInfo.iWkOrderState1);
      QLog.i("CUKingCardHelper", 2, paramBundle.toString());
      ((SharedPreferences.Editor)localObject2).putInt("kingCard", paramTrafficResultInfo.iWkOrderState1);
      if (!TextUtils.isEmpty(str)) {
        paramBundle = str;
      } else {
        paramBundle = "";
      }
      ((SharedPreferences.Editor)localObject2).putString("imsiOne", paramBundle);
      ((SharedPreferences.Editor)localObject2).putLong("kingCardLastRequest", System.currentTimeMillis() / 1000L);
    }
    if (bool2)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("Save CUKing Card Order State, State2: ");
      paramBundle.append(paramTrafficResultInfo.iWkOrderState2);
      QLog.i("CUKingCardHelper", 2, paramBundle.toString());
      ((SharedPreferences.Editor)localObject2).putInt("kingCard2", paramTrafficResultInfo.iWkOrderState2);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        paramBundle = (Bundle)localObject1;
      } else {
        paramBundle = "";
      }
      ((SharedPreferences.Editor)localObject2).putString("imsiTwo", paramBundle);
      ((SharedPreferences.Editor)localObject2).putLong("kingCardLastRequest", System.currentTimeMillis() / 1000L);
    }
    int i = paramTrafficResultInfo.iDrawerEnable;
    bool2 = true;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((SharedPreferences.Editor)localObject2).putBoolean("drawerEnable", bool1);
    if (paramTrafficResultInfo.iGuideEnable == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((SharedPreferences.Editor)localObject2).putBoolean("guideEnable", bool1);
    paramBundle = new StringBuilder();
    paramBundle.append("saveCUKingInfo, is in gray : ");
    if (paramTrafficResultInfo.iGuideEnable == 1) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    paramBundle.append(bool1);
    QLog.i("CUKingCardHelper", 2, paramBundle.toString());
    ((SharedPreferences.Editor)localObject2).putString("drawerText", paramTrafficResultInfo.sDrawerText);
    ((SharedPreferences.Editor)localObject2).putString("drawerTextID", String.valueOf(paramTrafficResultInfo.iDrawerTextId));
    ((SharedPreferences.Editor)localObject2).putString("drawerUrl", paramTrafficResultInfo.sDrawerUrl);
    ((SharedPreferences.Editor)localObject2).putString("guideUrl", paramTrafficResultInfo.sGuideUrl);
    ((SharedPreferences.Editor)localObject2).putString("sDrawerTextRuleID", paramTrafficResultInfo.sDrawerTextRuleID);
    ((SharedPreferences.Editor)localObject2).putInt("kingCardRequestInterval", paramTrafficResultInfo.iImsiInterval);
    if (paramTrafficResultInfo.popInfo != null)
    {
      i = ((SharedPreferences)localObject3).getInt("popup_version_v2", 0);
      paramBundle = paramTrafficResultInfo.popInfo;
      ((SharedPreferences.Editor)localObject2).putInt("guidePopupOpen", paramBundle.iOpen);
      ((SharedPreferences.Editor)localObject2).putInt("popupRate", paramBundle.iRate);
      ((SharedPreferences.Editor)localObject2).putInt("popupRateType", paramBundle.iRateType);
      if (i != paramBundle.iPopupVer)
      {
        ((SharedPreferences.Editor)localObject2).putString("guidePopupText_v2", paramBundle.sPopupText);
        ((SharedPreferences.Editor)localObject2).putString("guideJumpText_v2", paramBundle.sRedirectText);
        ((SharedPreferences.Editor)localObject2).putString("guideContinueText_v2", paramBundle.sContinueText);
        ((SharedPreferences.Editor)localObject2).putString("guidePopupImgUrl_v2", paramBundle.sPopupImgUrl);
        ((SharedPreferences.Editor)localObject2).putInt("popup_version_v2", paramBundle.iPopupVer);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("saveCUKingInfo, popup open : ");
      ((StringBuilder)localObject1).append(paramBundle.iOpen);
      ((StringBuilder)localObject1).append(" ver:");
      ((StringBuilder)localObject1).append(paramBundle.iPopupVer);
      QLog.i("CUKingCardHelper", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramTrafficResultInfo.toasInfo != null)
    {
      i = ((SharedPreferences)localObject3).getInt("toast_version", 0);
      paramTrafficResultInfo = paramTrafficResultInfo.toasInfo;
      ((SharedPreferences.Editor)localObject2).putInt("guideToastOpen", paramTrafficResultInfo.iOpen);
      ((SharedPreferences.Editor)localObject2).putInt("toastShowTime", paramTrafficResultInfo.iShowTime);
      if (i != paramTrafficResultInfo.iToastVer)
      {
        ((SharedPreferences.Editor)localObject2).putString("toastText", paramTrafficResultInfo.sText);
        ((SharedPreferences.Editor)localObject2).putString("shortToastText", paramTrafficResultInfo.sShortText);
        ((SharedPreferences.Editor)localObject2).putInt("toast_version", paramTrafficResultInfo.iToastVer);
      }
      paramBundle = new StringBuilder();
      paramBundle.append("saveCUKingInfo, toast open : ");
      paramBundle.append(paramTrafficResultInfo.iOpen);
      paramBundle.append(" ver:");
      paramBundle.append(paramTrafficResultInfo.iToastVer);
      QLog.i("CUKingCardHelper", 2, paramBundle.toString());
    }
    ((SharedPreferences.Editor)localObject2).commit();
  }
  
  private static void b(String paramString, boolean paramBoolean, SharedPreferences paramSharedPreferences, CUKingCardHelper.CUKingCustomDialogInfo paramCUKingCustomDialogInfo)
  {
    int i = paramSharedPreferences.getInt("popupRateType", 0);
    if ((i != 0) && (i != 1))
    {
      paramCUKingCustomDialogInfo.a = 4;
      return;
    }
    i = paramSharedPreferences.getInt("popupRate", 0);
    if ((paramSharedPreferences.getInt("kingCard", 0) != 1) && (paramSharedPreferences.getInt("kingCard", 0) != 1) && (paramSharedPreferences.getInt("kingCard2", 0) != 1)) {
      paramCUKingCustomDialogInfo.a = 2;
    } else {
      paramCUKingCustomDialogInfo.a = 3;
    }
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    String str;
    if (paramBoolean) {
      str = "lastTipTime_";
    } else {
      str = "lastDialogTime_";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    if (l - paramSharedPreferences.getLong(paramString, 0L) < i * 1000) {
      paramCUKingCustomDialogInfo.a = 4;
    }
    if (paramCUKingCustomDialogInfo.a != 4) {
      paramSharedPreferences.edit().putLong(paramString, l).commit();
    }
  }
  
  private static Class[] c(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    try
    {
      Method[] arrayOfMethod = TelephonyManager.class.getDeclaredMethods();
      int i = 0;
      Object localObject3;
      for (;;)
      {
        localObject1 = localObject2;
        localObject3 = localObject2;
        if (i >= arrayOfMethod.length) {
          break;
        }
        localObject3 = localObject2;
        localObject1 = localObject2;
        if (paramString.equals(arrayOfMethod[i].getName()))
        {
          localObject1 = localObject2;
          localObject2 = arrayOfMethod[i].getParameterTypes();
          localObject3 = localObject2;
          localObject1 = localObject2;
          if (localObject2.length >= 1)
          {
            localObject1 = localObject2;
            paramString = new StringBuilder();
            localObject1 = localObject2;
            paramString.append("");
            localObject1 = localObject2;
            paramString.append(localObject2.length);
            localObject1 = localObject2;
            Log.d("length:", paramString.toString());
            return localObject2;
          }
        }
        i += 1;
        localObject2 = localObject3;
      }
      return localObject3;
    }
    catch (Exception paramString)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getMethodParamTypes e = ");
      ((StringBuilder)localObject2).append(paramString);
      QLog.e("CUKingCardHelper", 1, ((StringBuilder)localObject2).toString());
      localObject3 = localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.CUKingCardHelper
 * JD-Core Version:    0.7.0.1
 */