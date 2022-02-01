import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

public class nwo
{
  public static final String a(int paramInt)
  {
    String str = "";
    if (paramInt == 0) {
      str = "contact";
    }
    do
    {
      return str;
      if (paramInt == 1) {
        return "group";
      }
    } while (paramInt != 3000);
    return "discussions";
  }
  
  public static String a(InputStream paramInputStream)
  {
    try
    {
      paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
      StringBuilder localStringBuilder = new StringBuilder();
      for (;;)
      {
        String str = paramInputStream.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str);
      }
      paramInputStream = localStringBuilder.toString();
    }
    catch (Exception paramInputStream)
    {
      paramInputStream.printStackTrace();
      return null;
    }
    return paramInputStream;
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("\"");
    int j = paramString.length();
    int i = 0;
    if (i < j)
    {
      char c = paramString.charAt(i);
      switch (c)
      {
      default: 
        if (c <= '\037') {
          localStringBuilder.append(String.format("\\u%04x", new Object[] { Integer.valueOf(c) }));
        }
        break;
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append('\\').append(c);
        continue;
        localStringBuilder.append("\\t");
        continue;
        localStringBuilder.append("\\b");
        continue;
        localStringBuilder.append("\\n");
        continue;
        localStringBuilder.append("\\r");
        continue;
        localStringBuilder.append("\\f");
        continue;
        localStringBuilder.append(c);
      }
    }
    localStringBuilder.append("\"");
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString, int paramInt)
  {
    str2 = "";
    Object localObject1 = str2;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = str2;
      if (paramInt <= 0) {}
    }
    try
    {
      Object localObject2 = Uri.parse(paramString);
      localObject1 = str2;
      if (((Uri)localObject2).isHierarchical())
      {
        localObject2 = ((Uri)localObject2).getHost();
        localObject1 = str2;
        if (localObject2 != null)
        {
          localObject2 = ((String)localObject2).split("\\.");
          localObject1 = str2;
          if (localObject2.length > 0)
          {
            int i = Math.max(0, localObject2.length - (paramInt + 1));
            localObject1 = new StringBuilder(256);
            ((StringBuilder)localObject1).append(localObject2[i]);
            i += 1;
            while (i < localObject2.length)
            {
              ((StringBuilder)localObject1).append('.').append(localObject2[i]);
              i += 1;
            }
            localObject1 = ((StringBuilder)localObject1).toString();
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        String str1 = str2;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QLog", 2, "Get " + paramInt + " level domain= " + (String)localObject1 + " from " + paramString);
    }
    return localObject1;
  }
  
  public static String a(String paramString, String... paramVarArgs)
  {
    String str;
    if (TextUtils.isEmpty(paramString))
    {
      str = paramString;
      return str;
    }
    paramString = paramString.replaceAll("(?<=\\?|#|&)((?i)sid|3g_sid|uin|sec_sig|MOBINFO|originuin)=[^&#]*&", "").replaceAll("[\\?#&]((?i)sid|3g_sid|uin|sec_sig|MOBINFO|originuin)=[^&#]*(?=#|$)", "").replaceAll("(?<=\\?|#|&)((?i)from)=androidqq&", "").replaceAll("[\\?#&]((?i)from)=androidqq(?=#|$)", "");
    int j = paramVarArgs.length;
    int i = 0;
    for (;;)
    {
      str = paramString;
      if (i >= j) {
        break;
      }
      paramString = paramString.replace(paramVarArgs[i], "");
      i += 1;
    }
  }
  
  public static void a(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", paramInt);
    localIntent.putExtra("key_error_msg", paramString1);
    localIntent.putExtra("key_error_detail", paramString2);
    localIntent.putExtra("key_response", "");
    ((Activity)paramContext).setResult(-1, localIntent);
  }
  
  public static final void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3)
  {
    a(paramQQAppInterface, paramString1, "connect_share2qq", paramString2, paramLong1, paramLong2, paramString3);
  }
  
  public static final void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, String paramString4)
  {
    if (paramString4 == null) {
      paramString4 = "";
    }
    for (;;)
    {
      if (paramString1 == null) {
        paramString1 = "";
      }
      for (;;)
      {
        String str1 = "";
        if (paramLong2 > 0L) {
          str1 = String.valueOf(paramLong2);
        }
        String str2 = "";
        if (paramLong1 > 0L) {
          str2 = String.valueOf(paramLong1);
        }
        bdla.b(paramQQAppInterface, "P_CliOper", "qqconnect", paramString1, paramString2, paramString3, 0, 0, str2, str1, paramString4, "");
        return;
      }
    }
  }
  
  public static void a(String paramString)
  {
    if (paramString != null) {}
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    File[] arrayOfFile;
    do
    {
      do
      {
        return false;
        str = paramString;
        if (!paramString.endsWith(File.separator)) {
          str = paramString + File.separator;
        }
        paramString = new File(str);
      } while ((paramString == null) || (!paramString.exists()) || (!paramString.isDirectory()));
      arrayOfFile = paramString.listFiles();
    } while (arrayOfFile == null);
    int i = 0;
    if (i < arrayOfFile.length)
    {
      if (arrayOfFile[i] == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (arrayOfFile[i].isFile()) {
          b(arrayOfFile[i].getAbsolutePath());
        } else {
          a(arrayOfFile[i].getAbsolutePath());
        }
      }
    }
    paramString.delete();
    if (QLog.isColorLevel()) {
      QLog.d("Util", 2, new Object[] { "deleteDirectory dirPath:", str });
    }
    return true;
  }
  
  public static String b(String paramString)
  {
    return a(paramString, 1);
  }
  
  public static String b(String paramString, String... paramVarArgs)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return paramString.replaceAll("((?i)sid|uin|sec_sig|MOBINFO)=[^&#]+", "$1=****");
  }
  
  public static void b(String paramString)
  {
    if (paramString != null) {}
  }
  
  public static boolean b(String paramString)
  {
    boolean bool2 = false;
    paramString = new File(paramString);
    boolean bool1 = bool2;
    if (paramString.isFile())
    {
      bool1 = bool2;
      if (!paramString.exists()) {}
    }
    try
    {
      paramString.delete();
      bool1 = true;
      return bool1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public static String c(String paramString)
  {
    paramString = paramString.toCharArray();
    int i = 0;
    if (i < paramString.length)
    {
      if (paramString[i] == '　') {
        paramString[i] = 32;
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramString[i] > 65280) && (paramString[i] < 65375)) {
          paramString[i] = ((char)(paramString[i] - 65248));
        }
      }
    }
    return new String(paramString);
  }
  
  public static String c(String paramString, String... paramVarArgs)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
        break label39;
      }
    }
    for (paramVarArgs = "(?<=(a1|a2|key|token|uin|sid|sig|stwxweb)=\\S)[^; ]+(?=[^;$])";; paramVarArgs = String.format("(?<=(a1|a2|key|token|uin|sid|sig|stwxweb%s)=\\S)[^; ]+(?=[^;$])", new Object[] { ((StringBuilder)localObject).toString() }))
    {
      localObject = paramString.toLowerCase().replaceAll(paramVarArgs, "*");
      return localObject;
      label39:
      localObject = new StringBuilder("");
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        String str = paramVarArgs[i];
        if (!TextUtils.isEmpty(str)) {
          ((StringBuilder)localObject).append("|").append(str);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nwo
 * JD-Core Version:    0.7.0.1
 */