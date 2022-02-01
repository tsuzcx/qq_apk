import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import org.json.JSONObject;

public class opf
{
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      paramQQAppInterface = "";
    }
    for (;;)
    {
      return paramQQAppInterface;
      paramQQAppInterface = a(paramQQAppInterface);
      if (paramQQAppInterface == null) {
        return "";
      }
      paramString = paramQQAppInterface.optString(paramString);
      if (StringUtil.isEmpty(paramString)) {
        return "";
      }
      paramQQAppInterface = paramString;
      try
      {
        if (!"qqshop".equals(Uri.parse(paramString).getScheme())) {
          return "";
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.e("QQShopFakeUrlHelper", 1, paramQQAppInterface, new Object[0]);
      }
    }
    return paramString;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    paramQQAppInterface = a(paramQQAppInterface);
    if (paramQQAppInterface == null) {
      return "";
    }
    try
    {
      Iterator localIterator = paramQQAppInterface.keys();
      while (localIterator.hasNext())
      {
        Uri localUri = Uri.parse(paramQQAppInterface.optString((String)localIterator.next()));
        if ((localUri != null) && (localUri.getHost() != null) && (localUri.getHost().equals(paramString1)))
        {
          paramQQAppInterface = localUri.getQueryParameter(paramString2);
          return paramQQAppInterface;
        }
      }
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("QQShopFakeUrlHelper", 1, paramQQAppInterface, new Object[0]);
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return "";
    }
    try
    {
      paramString = Uri.parse(paramString).getHost();
      return paramString;
    }
    catch (Throwable paramString)
    {
      QLog.e("QQShopFakeUrlHelper", 1, paramString, new Object[0]);
    }
    return "";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (StringUtil.isEmpty(paramString1)) {
      return "";
    }
    try
    {
      paramString1 = Uri.parse(paramString1).getQueryParameter(paramString2);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      QLog.e("QQShopFakeUrlHelper", 1, paramString1, new Object[0]);
    }
    return "";
  }
  
  private static JSONObject a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (aktz)paramQQAppInterface.getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.a("qqshop") != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQShopFakeUrlHelper", 2, " getQQShopConfig: " + paramQQAppInterface.a("qqshop"));
      }
      return paramQQAppInterface.a("qqshop");
    }
    return null;
  }
  
  public static String b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = a(paramQQAppInterface, paramString);
    if (StringUtil.isEmpty(paramQQAppInterface)) {
      return "";
    }
    try
    {
      paramQQAppInterface = Uri.parse(paramQQAppInterface).getHost();
      return paramQQAppInterface;
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("QQShopFakeUrlHelper", 1, paramQQAppInterface, new Object[0]);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     opf
 * JD-Core Version:    0.7.0.1
 */