package com.tencent.mobileqq.ecshop.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ecshop.conf.QQShopFakeUrlHelper;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopMessageApi;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

public class EcshopUtils
{
  public static int a(long paramLong)
  {
    AppRuntime localAppRuntime = AppUtils.a();
    if (localAppRuntime != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("open_minus_view_cnt_");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("_");
      localStringBuilder.append(localAppRuntime.getCurrentAccountUin());
      return SharedPreferencesUtil.b(localStringBuilder.toString());
    }
    return 0;
  }
  
  public static String a()
  {
    AppRuntime localAppRuntime = AppUtils.a();
    if (localAppRuntime != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qgg_msg_summary_");
      localStringBuilder.append(localAppRuntime.getCurrentAccountUin());
      return SharedPreferencesUtil.a(localStringBuilder.toString());
    }
    return "";
  }
  
  public static String a(long paramLong, String paramString)
  {
    try
    {
      paramString = new SimpleDateFormat(paramString, Locale.SIMPLIFIED_CHINESE).format(new Date(paramLong));
      return paramString;
    }
    catch (Exception paramString)
    {
      label25:
      break label25;
    }
    return "";
  }
  
  public static String a(Context paramContext, Date paramDate)
  {
    String str1 = paramContext.getString(2131915930);
    String str2 = paramContext.getString(2131915928);
    String str3 = paramContext.getString(2131915932);
    String str4 = paramContext.getString(2131915933);
    String str5 = paramContext.getString(2131915931);
    String str6 = paramContext.getString(2131915925);
    paramContext = paramContext.getString(2131915929);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    int j = localCalendar.get(7) - 1;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    return new String[] { str1, str2, str3, str4, str5, str6, paramContext }[i];
  }
  
  public static String a(MessageRecord paramMessageRecord)
  {
    paramMessageRecord = g(paramMessageRecord);
    if (paramMessageRecord == null) {
      return "";
    }
    return paramMessageRecord.optString("page_type");
  }
  
  public static String a(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    if (StringUtil.isEmpty(paramString)) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer(paramString);
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      String str1 = (String)paramMap.get(str2);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("appendKV2Schema key: ");
        paramString.append(str2);
        paramString.append(" value: ");
        paramString.append(str1);
        QLog.i("Ecshop_EcshopUtils", 2, paramString.toString());
      }
      paramString = str1;
      if (paramBoolean) {}
      try
      {
        paramString = URLEncoder.encode(str1);
      }
      catch (Exception paramString)
      {
        label132:
        break label132;
      }
      paramString = new StringBuilder();
      paramString.append("error encode key: ");
      paramString.append(str2);
      paramString.append(" value: ");
      paramString.append(str1);
      QLog.i("Ecshop_EcshopUtils", 2, paramString.toString());
      paramString = str1;
      if (localStringBuffer.toString().lastIndexOf("?") == -1) {
        localStringBuffer.append("?");
      } else {
        localStringBuffer.append("&");
      }
      localStringBuffer.append(String.format("%s=%s", new Object[] { str2, paramString }));
    }
    return localStringBuffer.toString();
  }
  
  public static void a(MsgSummary paramMsgSummary)
  {
    try
    {
      if ((c()) && (!StringUtil.isEmpty(a())))
      {
        paramMsgSummary.suffix = "";
        paramMsgSummary.strContent = a();
        return;
      }
    }
    catch (Throwable paramMsgSummary)
    {
      QLog.e("Ecshop_EcshopUtils", 2, paramMsgSummary, new Object[0]);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qggSummary: ");
      localStringBuilder.append(paramString1);
      QLog.i("Ecshop_EcshopUtils", 2, localStringBuilder.toString());
    }
    if (!StringUtil.isEmpty(paramString1))
    {
      f(paramString2);
      e(paramString1);
      return;
    }
    e(MobileQQ.sMobileQQ.getString(2131888823));
  }
  
  public static boolean a(String paramString)
  {
    return ((IPublicAccountDataManager)AppUtils.a().getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfo(paramString) != null;
  }
  
  public static String b()
  {
    AppRuntime localAppRuntime = AppUtils.a();
    if (localAppRuntime != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qgg_msg_id_");
      localStringBuilder.append(localAppRuntime.getCurrentAccountUin());
      return SharedPreferencesUtil.a(localStringBuilder.toString());
    }
    return "";
  }
  
  public static String b(MessageRecord paramMessageRecord)
  {
    paramMessageRecord = g(paramMessageRecord);
    if (paramMessageRecord == null) {
      return "";
    }
    return paramMessageRecord.optString("web_ext");
  }
  
  public static void b(long paramLong)
  {
    AppRuntime localAppRuntime = AppUtils.a();
    if (localAppRuntime != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("open_minus_view_cnt_");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("_");
      localStringBuilder.append(localAppRuntime.getCurrentAccountUin());
      SharedPreferencesUtil.c(localStringBuilder.toString());
    }
  }
  
  public static boolean b(String paramString)
  {
    return String.valueOf(1).equals(paramString);
  }
  
  public static int c(String paramString)
  {
    try
    {
      paramString = QQShopFakeUrlHelper.a(paramString, "maxShowCount");
      if (!StringUtil.isEmpty(paramString))
      {
        int i = Integer.parseInt(paramString);
        return i;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("Ecshop_EcshopUtils", 1, paramString, new Object[0]);
    }
    return 1;
  }
  
  @Nullable
  public static JSONObject c(MessageRecord paramMessageRecord)
  {
    paramMessageRecord = g(paramMessageRecord);
    if (paramMessageRecord == null) {
      return null;
    }
    return paramMessageRecord.optJSONObject("native_ext");
  }
  
  public static boolean c()
  {
    boolean bool = false;
    try
    {
      MessageRecord localMessageRecord = ((IMessageFacade)AppUtils.a().getRuntimeService(IMessageFacade.class, "")).getLastMsgForMsgTab("3046055438", 1008);
      if (localMessageRecord == null) {
        return false;
      }
      int i = a(localMessageRecord.uniseq);
      int j = c(QQShopFakeUrlHelper.b(a(localMessageRecord)));
      if (i >= j) {
        bool = true;
      }
      return bool;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public static int d(MessageRecord paramMessageRecord)
  {
    paramMessageRecord = g(paramMessageRecord);
    if (paramMessageRecord == null) {
      return 0;
    }
    return paramMessageRecord.optInt("is_hidden");
  }
  
  public static HashMap<String, String> d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new HashMap();
    }
    Object localObject = JsonUtil.a(paramString);
    if (localObject == null) {
      return new HashMap();
    }
    paramString = new HashMap(((Map)localObject).size());
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if (localEntry != null) {
        try
        {
          paramString.put(localEntry.getKey(), (String)localEntry.getValue());
        }
        catch (Exception localException)
        {
          QLog.e("Ecshop_EcshopUtils", 1, localException, new Object[0]);
        }
      }
    }
    return paramString;
  }
  
  public static int e(MessageRecord paramMessageRecord)
  {
    paramMessageRecord = g(paramMessageRecord);
    if (paramMessageRecord == null) {
      return 0;
    }
    paramMessageRecord = paramMessageRecord.optJSONObject("native_ext");
    if (paramMessageRecord != null) {
      return paramMessageRecord.optInt("hide_tabbar", 0);
    }
    return 0;
  }
  
  private static void e(String paramString)
  {
    AppRuntime localAppRuntime = AppUtils.a();
    if (localAppRuntime != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qgg_msg_summary_");
      localStringBuilder.append(localAppRuntime.getCurrentAccountUin());
      SharedPreferencesUtil.a(localStringBuilder.toString(), paramString);
    }
  }
  
  public static int f(MessageRecord paramMessageRecord)
  {
    paramMessageRecord = g(paramMessageRecord);
    if (paramMessageRecord == null) {
      return 1;
    }
    paramMessageRecord = paramMessageRecord.optJSONObject("native_ext");
    if (paramMessageRecord != null) {
      return paramMessageRecord.optInt("tab_id", 1);
    }
    return 1;
  }
  
  private static void f(String paramString)
  {
    AppRuntime localAppRuntime = AppUtils.a();
    if (localAppRuntime != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qgg_msg_id_");
      localStringBuilder.append(localAppRuntime.getCurrentAccountUin());
      SharedPreferencesUtil.a(localStringBuilder.toString(), paramString);
    }
  }
  
  private static JSONObject g(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    paramMessageRecord = ((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).getLastMsgQggExt(paramMessageRecord);
    if (StringUtil.isEmpty(paramMessageRecord)) {
      return null;
    }
    try
    {
      paramMessageRecord = new JSONObject(paramMessageRecord);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("qggExtJson<<<<<<<");
        localStringBuilder.append(paramMessageRecord);
        QLog.i("Ecshop_EcshopUtils", 2, localStringBuilder.toString());
      }
      return paramMessageRecord;
    }
    catch (JSONException paramMessageRecord)
    {
      QLog.e("Ecshop_EcshopUtils", 2, paramMessageRecord, new Object[0]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.utils.EcshopUtils
 * JD-Core Version:    0.7.0.1
 */