package com.tencent.mobileqq.shortvideo.qmcf;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.opencl.OpenclInfoManager;
import com.tencent.mobileqq.shortvideo.util.MediaCodecDPC;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class QmcfDevicesStrategy
{
  private static int jdField_a_of_type_Int = -1;
  public static String a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "snpe", "opencl_mali", "opencl_ocl", "opengl" };
  private static int jdField_b_of_type_Int = 0;
  private static String jdField_b_of_type_JavaLangString = "";
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString = { "Nexus 6P", "Nexus 6" };
  private static String c = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
  }
  
  public static int a()
  {
    int i = 0;
    if (jdField_a_of_type_Int > -1) {
      return jdField_a_of_type_Int;
    }
    int j = MediaCodecDPC.a();
    if (j != -1)
    {
      jdField_a_of_type_Int = j;
      QLog.d("QmcfDevicesStrategy", 1, "DPCInfo:" + j);
      return jdField_a_of_type_Int;
    }
    jdField_a_of_type_Int = 0;
    if (Build.MODEL.contains("Pixel"))
    {
      jdField_a_of_type_Int = 4;
      return jdField_a_of_type_Int;
    }
    if (Build.MODEL.contains("Nexus"))
    {
      jdField_a_of_type_Int = 0;
      return jdField_a_of_type_Int;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      boolean bool1 = new File("/system/vendor/lib/egl/libGLES_mali.so").exists();
      boolean bool2 = new File("/system/lib/egl/libGLES_mali.so").exists();
      if ((bool1) || (bool2))
      {
        jdField_a_of_type_Int = 4;
        QLog.d("QmcfDevicesStrategy", 1, "mali type");
        return jdField_a_of_type_Int;
      }
    }
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      jdField_a_of_type_JavaLangString = new OpenclInfoManager().a();
      QLog.d("QmcfDevicesStrategy", 1, "GPUInfo:" + jdField_a_of_type_JavaLangString);
    }
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      return jdField_a_of_type_Int;
    }
    Object localObject1 = a();
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
        int k = arrayOfString.length;
        j = 0;
        if (i < k)
        {
          Object localObject2 = arrayOfString[i];
          j += 1;
          if ((c.contains((CharSequence)localObject2)) || (!((JSONObject)localObject1).has((String)localObject2))) {
            break label326;
          }
          localObject2 = ((JSONObject)localObject1).getJSONObject((String)localObject2);
          jdField_b_of_type_Int = j;
          a((JSONObject)localObject2);
          if (jdField_a_of_type_Int == 0) {
            break label326;
          }
          i = jdField_a_of_type_Int;
          return i;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return jdField_a_of_type_Int;
      label326:
      i += 1;
    }
  }
  
  public static int a(Context paramContext)
  {
    return paramContext.getSharedPreferences("qmcf_gpu_config", 0).getInt("cfg_version", 0);
  }
  
  private static String a()
  {
    String str2 = BaseApplicationImpl.getApplication().getSharedPreferences("qmcf_gpu_config", 0).getString("cfg_content", "");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = FileUtils.c("qmcf_rule_config.xml");
    }
    return str1;
  }
  
  public static void a(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("QmcfConfig", 4).edit();
    paramContext.putInt("qmcf_mobile_support", 1);
    paramContext.commit();
  }
  
  private static void a(String paramString)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String[] arrayOfString = paramString.split(";");
    for (;;)
    {
      int j;
      int i;
      boolean bool1;
      Object localObject;
      int k;
      int m;
      int n;
      try
      {
        if (jdField_a_of_type_JavaLangString.contains("Mali"))
        {
          j = arrayOfString.length;
          i = 0;
          bool1 = bool3;
          if (i < j)
          {
            paramString = arrayOfString[i].split("#");
            bool1 = bool3;
            if (paramString.length == 4)
            {
              localObject = paramString[0] + paramString[1];
              if (!jdField_a_of_type_JavaLangString.contains((CharSequence)localObject)) {
                break label369;
              }
              localObject = Pattern.compile("(G|T|\\-)(\\d+)(.+MP(\\d+))?").matcher(jdField_a_of_type_JavaLangString);
              bool1 = ((Matcher)localObject).find();
              if (!bool1) {
                break label369;
              }
            }
          }
        }
        bool1 = bool3;
      }
      catch (Exception paramString)
      {
        try
        {
          k = Integer.parseInt(((Matcher)localObject).group(4));
          m = Integer.parseInt(paramString[2]);
          n = Integer.parseInt(paramString[3]);
          if ((k > n) || (k < m)) {
            break label363;
          }
          bool1 = bool2;
          a(bool1);
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
        paramString = paramString;
        paramString.printStackTrace();
        return;
      }
      if (jdField_a_of_type_JavaLangString.contains("Adreno"))
      {
        j = arrayOfString.length;
        i = 0;
        for (;;)
        {
          for (;;)
          {
            bool1 = bool3;
            if (i >= j) {
              break;
            }
            localObject = arrayOfString[i].split("#");
            paramString = "0";
            Matcher localMatcher = Pattern.compile("Adreno.*(\\d{3,4})").matcher(jdField_a_of_type_JavaLangString);
            if (localMatcher.find()) {
              paramString = localMatcher.group(1);
            }
            if ((localObject.length != 3) || (!paramString.substring(0, 1).equals(localObject[0])))
            {
              k = localObject.length;
              if (k != 2) {}
            }
            else
            {
              try
              {
                k = Integer.parseInt(paramString);
                m = Integer.parseInt(localObject[(localObject.length - 2)]);
                n = Integer.parseInt(localObject[(localObject.length - 1)]);
                bool1 = bool3;
                if (k > n) {
                  break;
                }
                bool1 = bool3;
                if (k < m) {
                  break;
                }
                bool1 = true;
              }
              catch (Exception paramString)
              {
                paramString.printStackTrace();
              }
            }
          }
          i += 1;
        }
        label363:
        bool1 = false;
        continue;
        label369:
        i += 1;
      }
    }
  }
  
  private static void a(String paramString1, String paramString2)
  {
    if ("large".equals(paramString1)) {
      a(paramString2, true);
    }
    do
    {
      return;
      if ("less".equals(paramString1))
      {
        a(paramString2, false);
        return;
      }
      if ("between".equals(paramString1))
      {
        a(paramString2);
        return;
      }
    } while (!"enum".equals(paramString1));
    b(paramString2);
  }
  
  private static void a(String paramString, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String[] arrayOfString1 = paramString.split(";");
    label399:
    label405:
    for (;;)
    {
      int j;
      int i;
      boolean bool1;
      String[] arrayOfString2;
      int k;
      int m;
      try
      {
        if (!jdField_a_of_type_JavaLangString.contains("Mali")) {
          break label226;
        }
        j = arrayOfString1.length;
        i = 0;
        bool1 = bool3;
        if (i < j)
        {
          arrayOfString2 = arrayOfString1[i].split("#");
          if (arrayOfString2.length != 2) {
            break label179;
          }
          paramString = arrayOfString2[0];
          if (!jdField_a_of_type_JavaLangString.contains(paramString)) {
            break label405;
          }
          paramString = Pattern.compile("(G|T|\\-)(\\d+)(.+MP(\\d+))?").matcher(jdField_a_of_type_JavaLangString);
          k = arrayOfString2.length;
          bool1 = paramString.find();
          if (!bool1) {
            break label405;
          }
        }
        bool1 = bool3;
      }
      catch (Exception paramString)
      {
        try
        {
          k = Integer.parseInt(paramString.group((k - 1) * 2));
          m = Integer.parseInt(arrayOfString2[(arrayOfString2.length - 1)]);
          if (paramBoolean)
          {
            bool1 = bool2;
            if (k >= m) {}
          }
          else
          {
            if ((paramBoolean) || (k > m)) {
              break label399;
            }
            bool1 = bool2;
          }
          a(bool1);
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
        paramString = paramString;
        paramString.printStackTrace();
        return;
      }
      label179:
      if (arrayOfString2.length == 3)
      {
        paramString = arrayOfString2[0] + arrayOfString2[1];
        continue;
        label226:
        bool1 = bool3;
        if (jdField_a_of_type_JavaLangString.contains("Adreno"))
        {
          j = arrayOfString1.length;
          i = 0;
          for (;;)
          {
            for (;;)
            {
              bool1 = bool3;
              if (i >= j) {
                break;
              }
              arrayOfString2 = arrayOfString1[i].split("#");
              paramString = "0";
              Matcher localMatcher = Pattern.compile("Adreno.*(\\d{3,4})").matcher(jdField_a_of_type_JavaLangString);
              if (localMatcher.find()) {
                paramString = localMatcher.group(1);
              }
              if ((arrayOfString2.length != 2) || (!paramString.substring(0, 1).equals(arrayOfString2[0])))
              {
                k = arrayOfString2.length;
                if (k != 1) {}
              }
              else
              {
                try
                {
                  k = Integer.parseInt(paramString);
                  m = Integer.parseInt(arrayOfString2[(arrayOfString2.length - 1)]);
                  if ((!paramBoolean) || (k < m))
                  {
                    bool1 = bool3;
                    if (paramBoolean) {
                      break;
                    }
                    bool1 = bool3;
                    if (k > m) {
                      break;
                    }
                  }
                  bool1 = true;
                }
                catch (Exception paramString)
                {
                  paramString.printStackTrace();
                }
              }
            }
            i += 1;
          }
          bool1 = false;
          continue;
          i += 1;
        }
      }
    }
  }
  
  private static void a(JSONObject paramJSONObject)
  {
    try
    {
      String[] arrayOfString = paramJSONObject.getString("verdor").split(";");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (jdField_a_of_type_JavaLangString.contains(str)) {
          b(paramJSONObject.getJSONObject(str));
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private static void a(boolean paramBoolean)
  {
    if ("white".equals(jdField_b_of_type_JavaLangString)) {
      if (paramBoolean) {
        jdField_a_of_type_Int = jdField_b_of_type_Int;
      }
    }
    while ((!"black".equals(jdField_b_of_type_JavaLangString)) || (paramBoolean)) {
      return;
    }
    jdField_a_of_type_Int = jdField_b_of_type_Int;
  }
  
  public static boolean a(String paramString, int paramInt, Context paramContext)
  {
    try
    {
      a(paramContext);
      paramContext = paramContext.getSharedPreferences("qmcf_gpu_config", 0).edit();
      paramContext.putString("cfg_content", paramString);
      paramContext.putInt("cfg_version", paramInt);
      return paramContext.commit();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QmcfDevicesStrategy", 2, "setQmcfMobileSupport err!", localException);
        }
      }
    }
  }
  
  private static void b(String paramString)
  {
    boolean bool2 = false;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = paramString.split(";");
    for (;;)
    {
      int i;
      try
      {
        int j = paramString.length;
        i = 0;
        boolean bool1 = bool2;
        if (i < j)
        {
          CharSequence localCharSequence = paramString[i];
          if (jdField_a_of_type_JavaLangString.contains(localCharSequence)) {
            bool1 = true;
          }
        }
        else
        {
          a(bool1);
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      i += 1;
    }
  }
  
  private static void b(JSONObject paramJSONObject)
  {
    try
    {
      String[] arrayOfString = paramJSONObject.getString("strategy").split(";");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        JSONObject localJSONObject = paramJSONObject.getJSONObject(str);
        jdField_b_of_type_JavaLangString = str;
        c(localJSONObject);
        i += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private static void c(JSONObject paramJSONObject)
  {
    try
    {
      String[] arrayOfString = paramJSONObject.getString("rule").split(";");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        a(str, paramJSONObject.getString(str));
        i += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.qmcf.QmcfDevicesStrategy
 * JD-Core Version:    0.7.0.1
 */