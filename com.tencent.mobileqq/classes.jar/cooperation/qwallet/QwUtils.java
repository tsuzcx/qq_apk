package cooperation.qwallet;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;

public class QwUtils
{
  private static long jdField_a_of_type_Long;
  private static DecimalFormat jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("#0.00");
  
  static
  {
    jdField_a_of_type_JavaTextDecimalFormat.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));
  }
  
  public static float a(String paramString)
  {
    try
    {
      float f = Float.parseFloat(paramString);
      return f;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0.0F;
  }
  
  public static int a(Object paramObject, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramObject);
    localStringBuilder.append("");
    paramObject = localStringBuilder.toString();
    if (!TextUtils.isEmpty(paramObject)) {
      try
      {
        int i = Integer.valueOf(paramObject).intValue();
        return i;
      }
      catch (Exception paramObject)
      {
        paramObject.printStackTrace();
      }
    }
    return paramInt;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = Long.toString(Double.valueOf(a(paramString, "100")).doubleValue());
      return paramString;
    }
    catch (NumberFormatException paramString) {}
    return null;
  }
  
  public static String a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0) {
      try
      {
        String str = a(paramString, "100", 2, paramBoolean);
        return str;
      }
      catch (Exception localException) {}
    }
    try
    {
      localException.printStackTrace();
      try
      {
        paramString = b(paramString);
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return "0";
      }
      if (paramInt == 1) {
        return new DecimalFormat("#0.00").format(paramString);
      }
      return "";
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new BigDecimal(paramString1);
      paramString2 = new BigDecimal(paramString2);
      paramString1 = jdField_a_of_type_JavaTextDecimalFormat.format(paramString1.multiply(paramString2).doubleValue());
      return paramString1;
    }
    catch (Exception paramString1)
    {
      label35:
      break label35;
    }
    return "0";
  }
  
  public static String a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (paramInt < 0) {
      return "0";
    }
    paramString1 = new BigDecimal(paramString1);
    paramString2 = new BigDecimal(paramString2);
    if (paramBoolean) {
      return new DecimalFormat("#0.00").format(paramString1.divide(paramString2, paramInt, 4).doubleValue());
    }
    return new DecimalFormat("#0.##").format(paramString1.divide(paramString2, paramInt, 4).doubleValue());
  }
  
  public static String a(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
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
        QLog.i("QwUtils", 2, paramString.toString());
      }
      paramString = str1;
      if (paramBoolean) {}
      try
      {
        paramString = URLEncoder.encode(str1);
      }
      catch (Exception paramString)
      {
        label122:
        break label122;
      }
      paramString = new StringBuilder();
      paramString.append("error encode key: ");
      paramString.append(str2);
      paramString.append(" value: ");
      paramString.append(str1);
      QLog.i("QwUtils", 2, paramString.toString());
      paramString = str1;
      localStringBuffer.append("&");
      localStringBuffer.append(String.format("%s=%s", new Object[] { str2, paramString }));
    }
    return localStringBuffer.toString();
  }
  
  public static String a(AppRuntime paramAppRuntime, String paramString, WtTicketPromise paramWtTicketPromise)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    paramWtTicketPromise = "";
    if (bool) {
      return "";
    }
    TicketManager localTicketManager = (TicketManager)paramAppRuntime.getManager(2);
    if (localTicketManager != null) {
      paramWtTicketPromise = localTicketManager.getPskey(paramAppRuntime.getCurrentAccountUin(), paramString);
    }
    return paramWtTicketPromise;
  }
  
  public static String a(Ticket paramTicket, String paramString)
  {
    if ((paramTicket != null) && (paramTicket._pskey_map != null) && (paramTicket._pskey_map.get(paramString) != null))
    {
      QLog.i("QwUtils", 2, "preGetKey. PSk Done. psk!=null");
      return new String((byte[])paramTicket._pskey_map.get(paramString));
    }
    QLog.i("QwUtils", 2, "preGetKey error from ticket");
    return null;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startQQBrowserActivity url=");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("QwUtils", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("url", paramString);
    ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
    ((Intent)localObject).putExtra("hide_operation_bar", true);
    ((Intent)localObject).putExtra("hide_more_button", true);
    RouteUtils.a(paramContext, (Intent)localObject, "/base/browser");
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString, QwUtils.AnsyListener paramAnsyListener)
  {
    paramAppRuntime = a(paramAppRuntime, paramString, new QwUtils.1(paramAnsyListener, paramString));
    if (!StringUtil.a(paramAppRuntime))
    {
      if (paramAnsyListener != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QWalletUtils", 2, "get pskey syn success!");
        }
        paramAnsyListener.a(0, new String[] { paramAppRuntime });
      }
    }
    else {
      QLog.e("QWalletUtils", 1, "get pskey syn. PSk is empty!");
    }
  }
  
  public static boolean a()
  {
    long l = System.currentTimeMillis();
    if (jdField_a_of_type_Long + 1000L > l) {
      return true;
    }
    jdField_a_of_type_Long = l;
    return false;
  }
  
  public static String b(String paramString)
  {
    if ((paramString != null) && (paramString.matches("\\-?[0-9]+")))
    {
      int i;
      if (paramString.charAt(0) == '-')
      {
        paramString = paramString.substring(1);
        i = 1;
      }
      else
      {
        i = 0;
      }
      while ((paramString.startsWith("0")) && (paramString.length() > 1)) {
        paramString = paramString.substring(1);
      }
      StringBuffer localStringBuffer = new StringBuffer();
      if (paramString.length() == 1)
      {
        localStringBuffer.append("0.0");
        localStringBuffer.append(paramString);
      }
      else if (paramString.length() == 2)
      {
        localStringBuffer.append("0.");
        localStringBuffer.append(paramString);
      }
      else
      {
        localStringBuffer.append(paramString.substring(0, paramString.length() - 2));
        localStringBuffer.append(".");
        localStringBuffer.append(paramString.substring(paramString.length() - 2));
      }
      if (i == 1)
      {
        paramString = new StringBuilder();
        paramString.append("-");
        paramString.append(localStringBuffer.toString());
        return paramString.toString();
      }
      return localStringBuffer.toString();
    }
    paramString = new Exception("金额格式有误");
    for (;;)
    {
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qwallet.QwUtils
 * JD-Core Version:    0.7.0.1
 */