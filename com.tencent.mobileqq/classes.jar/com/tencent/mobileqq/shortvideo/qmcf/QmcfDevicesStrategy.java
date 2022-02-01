package com.tencent.mobileqq.shortvideo.qmcf;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.aelight.camera.util.api.IMediaCodecDPC;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.opencl.OpenclInfoManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class QmcfDevicesStrategy
{
  private static int jdField_a_of_type_Int;
  public static String a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "snpe", "opencl_mali", "opencl_ocl", "opengl" };
  private static int jdField_b_of_type_Int;
  private static String jdField_b_of_type_JavaLangString = "";
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString = { "NX609J", "NX531J", "vivo X7Plus", "ARS-TL00", "MI 8 Lite", "1807-A01", "ARE-AL00", "MI 4S" };
  private static int jdField_c_of_type_Int;
  private static String jdField_c_of_type_JavaLangString = "";
  private static final String[] jdField_c_of_type_ArrayOfJavaLangString = { "Redmi Note 3" };
  private static int d;
  private static int e;
  private static int f = -1;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_Int = -1;
    jdField_b_of_type_Int = -1;
    jdField_c_of_type_Int = -1;
    d = -1;
    e = 0;
  }
  
  public static int a()
  {
    try
    {
      if (jdField_b_of_type_Int > -1)
      {
        i = jdField_b_of_type_Int;
        return i;
      }
      int i = a(a());
      return i;
    }
    finally {}
  }
  
  public static int a(Context paramContext)
  {
    return paramContext.getSharedPreferences("qmcf_gpu_config", 0).getInt("cfg_version", 0);
  }
  
  public static int a(String paramString)
  {
    int i = jdField_b_of_type_Int;
    if (i > -1) {
      return i;
    }
    if (Build.VERSION.SDK_INT < 21)
    {
      jdField_b_of_type_Int = 0;
      QLog.d("QmcfDevicesStrategy", 1, String.format("not support because of version:%d ", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) }));
      return jdField_b_of_type_Int;
    }
    i = ((IMediaCodecDPC)QRoute.api(IMediaCodecDPC.class)).getQmcfDPCFrameType();
    if (i != -1)
    {
      jdField_b_of_type_Int = i;
      paramString = new StringBuilder();
      paramString.append("DPCInfo:");
      paramString.append(i);
      QLog.d("QmcfDevicesStrategy", 1, paramString.toString());
      return jdField_b_of_type_Int;
    }
    jdField_b_of_type_Int = 0;
    if (Build.MODEL.contains("Pixel"))
    {
      jdField_b_of_type_Int = 4;
      return jdField_b_of_type_Int;
    }
    if (Build.MODEL.contains("Nexus"))
    {
      jdField_b_of_type_Int = 0;
      QLog.d("QmcfDevicesStrategy", 1, "not support because of nexus");
      return jdField_b_of_type_Int;
    }
    Object localObject = jdField_b_of_type_ArrayOfJavaLangString;
    int j = localObject.length;
    i = 0;
    while (i < j)
    {
      String str = localObject[i];
      if (Build.MODEL.equalsIgnoreCase(str))
      {
        jdField_b_of_type_Int = 4;
        QLog.d("QmcfDevicesStrategy", 1, "support because of GLSO rule");
        return jdField_b_of_type_Int;
      }
      i += 1;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      boolean bool1 = new File("/system/vendor/lib/egl/libGLES_mali.so").exists();
      boolean bool2 = new File("/system/lib/egl/libGLES_mali.so").exists();
      if ((bool1) || (bool2))
      {
        jdField_b_of_type_Int = 4;
        QLog.d("QmcfDevicesStrategy", 1, "support because of mali type");
        return jdField_b_of_type_Int;
      }
    }
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      jdField_a_of_type_JavaLangString = new OpenclInfoManager().a();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("GPUInfo:");
      ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
      QLog.d("QmcfDevicesStrategy", 1, ((StringBuilder)localObject).toString());
    }
    if ((TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) || (jdField_a_of_type_JavaLangString.startsWith("err")))
    {
      jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getSharedPreferences("qmcf_gpu_config", 4).getString("gl_renderer", "");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getGLRendererInfo:");
      ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
      QLog.i("QmcfDevicesStrategy", 1, ((StringBuilder)localObject).toString());
      if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
      {
        jdField_b_of_type_Int = -2;
        return jdField_b_of_type_Int;
      }
    }
    jdField_b_of_type_Int = c(paramString);
    i = jdField_b_of_type_Int;
    if (i == 0) {
      QLog.d("QmcfDevicesStrategy", 1, String.format("not support gpu[%s] type[%s]", new Object[] { jdField_a_of_type_JavaLangString, Integer.valueOf(i) }));
    }
    return jdField_b_of_type_Int;
  }
  
  private static String a()
  {
    String str2 = BaseApplicationImpl.getApplication().getSharedPreferences("qmcf_gpu_config", 0).getString("cfg_content", "");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = FileUtils.readStringFromAsset("qmcf_rule_config.xml");
    }
    return str1;
  }
  
  public static void a(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("QmcfConfig", 4).edit();
    paramContext.putInt("qmcf_mobile_support", 1);
    paramContext.commit();
  }
  
  public static void a(String paramString)
  {
    if (f == -1)
    {
      Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("qmcf_gpu_config", 4);
      f = ((SharedPreferences)localObject).getInt("gl_renderer_flag", 0);
      if (f == 0)
      {
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString("gl_renderer", paramString);
        ((SharedPreferences.Editor)localObject).putInt("gl_renderer_flag", 1);
        ((SharedPreferences.Editor)localObject).commit();
        f = 1;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("saveGLRendererInfo:");
        ((StringBuilder)localObject).append(paramString);
        QLog.i("QmcfDevicesStrategy", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private static void a(String paramString1, String paramString2)
  {
    if ("large".equals(paramString1))
    {
      a(paramString2, true);
      return;
    }
    if ("less".equals(paramString1))
    {
      a(paramString2, false);
      return;
    }
    if ("between".equals(paramString1))
    {
      b(paramString2);
      return;
    }
    if ("enum".equals(paramString1)) {
      c(paramString2);
    }
  }
  
  private static void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String[] arrayOfString1 = paramString.split(";");
    for (;;)
    {
      int i;
      try
      {
        boolean bool1 = jdField_a_of_type_JavaLangString.contains("Mali");
        boolean bool2 = false;
        int j;
        String[] arrayOfString2;
        int k;
        int m;
        if (bool1)
        {
          j = arrayOfString1.length;
          i = 0;
          bool1 = bool2;
          if (i < j)
          {
            arrayOfString2 = arrayOfString1[i].split("#");
            if (arrayOfString2.length == 2)
            {
              paramString = arrayOfString2[0];
            }
            else
            {
              bool1 = bool2;
              if (arrayOfString2.length != 3) {
                continue;
              }
              paramString = new StringBuilder();
              paramString.append(arrayOfString2[0]);
              paramString.append(arrayOfString2[1]);
              paramString = paramString.toString();
            }
            if (!jdField_a_of_type_JavaLangString.contains(paramString)) {
              break label413;
            }
            paramString = Pattern.compile("(G|T|\\-)(\\d+)(.+MP(\\d+))?").matcher(jdField_a_of_type_JavaLangString);
            k = arrayOfString2.length;
            bool1 = paramString.find();
            if (!bool1) {
              break label413;
            }
            try
            {
              k = Integer.parseInt(paramString.group((k - 1) * 2));
              m = Integer.parseInt(arrayOfString2[(arrayOfString2.length - 1)]);
              if ((!paramBoolean) || (k < m))
              {
                bool1 = bool2;
                if (!paramBoolean)
                {
                  bool1 = bool2;
                  if (k > m) {}
                }
              }
              else
              {
                bool1 = true;
              }
            }
            catch (Exception paramString)
            {
              paramString.printStackTrace();
              break label413;
            }
          }
        }
        else
        {
          bool1 = bool2;
          if (jdField_a_of_type_JavaLangString.contains("Adreno"))
          {
            j = arrayOfString1.length;
            i = 0;
            bool1 = bool2;
            if (i < j)
            {
              arrayOfString2 = arrayOfString1[i].split("#");
              paramString = "0";
              Matcher localMatcher = Pattern.compile("Adreno.*(\\d{3,4})").matcher(jdField_a_of_type_JavaLangString);
              if (localMatcher.find()) {
                paramString = localMatcher.group(1);
              }
              if ((arrayOfString2.length != 2) || (!paramString.substring(0, 1).equals(arrayOfString2[0])))
              {
                k = arrayOfString2.length;
                if (k != 1) {
                  break label420;
                }
              }
              try
              {
                k = Integer.parseInt(paramString);
                m = Integer.parseInt(arrayOfString2[(arrayOfString2.length - 1)]);
                if ((paramBoolean) && (k >= m)) {
                  continue;
                }
                bool1 = bool2;
                if (!paramBoolean)
                {
                  bool1 = bool2;
                  if (k <= m) {
                    continue;
                  }
                }
                a(bool1);
              }
              catch (Exception paramString)
              {
                paramString.printStackTrace();
              }
            }
          }
        }
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      label413:
      i += 1;
      continue;
      label420:
      i += 1;
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
    if ("white".equals(jdField_b_of_type_JavaLangString))
    {
      if (paramBoolean) {
        jdField_a_of_type_Int = e;
      }
    }
    else if (("black".equals(jdField_b_of_type_JavaLangString)) && (!paramBoolean)) {
      jdField_a_of_type_Int = e;
    }
  }
  
  public static boolean a()
  {
    return EffectsRenderController.a(4, 1200000L, 2147483648L);
  }
  
  public static boolean a(String paramString, int paramInt, Context paramContext)
  {
    try
    {
      a(paramContext);
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QmcfDevicesStrategy", 2, "setQmcfMobileSupport err!", localException);
      }
    }
    paramContext = paramContext.getSharedPreferences("qmcf_gpu_config", 0).edit();
    paramContext.putString("cfg_content", paramString);
    paramContext.putInt("cfg_version", paramInt);
    return paramContext.commit();
  }
  
  public static int b()
  {
    int i = jdField_c_of_type_Int;
    if (i > -1) {
      return i;
    }
    i = Build.VERSION.SDK_INT;
    int j = 0;
    if (i < 21)
    {
      jdField_c_of_type_Int = 0;
      QLog.d("QmcfDevicesStrategy", 1, String.format("not support because of version:%d ", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) }));
      return jdField_c_of_type_Int;
    }
    if (!a())
    {
      jdField_c_of_type_Int = 0;
      QLog.d("QmcfDevicesStrategy", 1, String.format("not support because of low-end devices", new Object[0]));
      return jdField_c_of_type_Int;
    }
    i = ((IMediaCodecDPC)QRoute.api(IMediaCodecDPC.class)).getQmcfDPCFrameType();
    Object localObject;
    if (i != -1)
    {
      jdField_c_of_type_Int = i;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DPCInfo:");
      ((StringBuilder)localObject).append(i);
      QLog.d("QmcfDevicesStrategy", 1, ((StringBuilder)localObject).toString());
      return jdField_c_of_type_Int;
    }
    jdField_c_of_type_Int = 0;
    if ((!Build.MODEL.contains("Pixel")) && (!Build.MODEL.contains("Nexus")))
    {
      localObject = jdField_b_of_type_ArrayOfJavaLangString;
      int k = localObject.length;
      i = 0;
      String str;
      while (i < k)
      {
        str = localObject[i];
        if (Build.MODEL.equalsIgnoreCase(str))
        {
          jdField_c_of_type_Int = 4;
          QLog.d("QmcfDevicesStrategy", 1, "support because of GLSO rule");
          return jdField_c_of_type_Int;
        }
        i += 1;
      }
      localObject = jdField_c_of_type_ArrayOfJavaLangString;
      k = localObject.length;
      i = j;
      while (i < k)
      {
        str = localObject[i];
        if (Build.MODEL.equalsIgnoreCase(str))
        {
          jdField_c_of_type_Int = 4;
          QLog.d("QmcfDevicesStrategy", 1, "support because of GLSO rule loose");
          return jdField_c_of_type_Int;
        }
        i += 1;
      }
      boolean bool1 = new File("/system/vendor/lib/egl/libGLES_mali.so").exists();
      boolean bool2 = new File("/system/lib/egl/libGLES_mali.so").exists();
      if ((!bool1) && (!bool2))
      {
        jdField_c_of_type_Int = 3;
        return jdField_c_of_type_Int;
      }
      jdField_c_of_type_Int = 4;
      QLog.d("QmcfDevicesStrategy", 1, "support because of mali type");
      return jdField_c_of_type_Int;
    }
    jdField_c_of_type_Int = 4;
    return jdField_c_of_type_Int;
  }
  
  public static int b(String paramString)
  {
    int i = d;
    if (i > -1) {
      return i;
    }
    if (Build.VERSION.SDK_INT < 21)
    {
      d = 0;
      QLog.d("QmcfDevicesStrategy", 1, String.format("multiaio not support because of version:%d ", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) }));
      return d;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      boolean bool1 = new File("/system/vendor/lib/egl/libGLES_mali.so").exists();
      boolean bool2 = new File("/system/lib/egl/libGLES_mali.so").exists();
      if ((bool1) || (bool2))
      {
        d = 4;
        QLog.d("QmcfDevicesStrategy", 1, "support because of mali type");
        return d;
      }
    }
    StringBuilder localStringBuilder;
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
    {
      jdField_a_of_type_JavaLangString = new OpenclInfoManager().a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("GPUInfo:");
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      QLog.d("QmcfDevicesStrategy", 1, localStringBuilder.toString());
    }
    if ((TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) || (jdField_a_of_type_JavaLangString.startsWith("err")))
    {
      jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getSharedPreferences("qmcf_gpu_config", 4).getString("gl_renderer", "");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getGLRendererInfo:");
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      QLog.i("QmcfDevicesStrategy", 1, localStringBuilder.toString());
      if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
      {
        d = 4;
        return d;
      }
    }
    d = c(paramString);
    return d;
  }
  
  private static void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String[] arrayOfString = paramString.split(";");
    for (;;)
    {
      int i;
      try
      {
        boolean bool1 = jdField_a_of_type_JavaLangString.contains("Mali");
        boolean bool2 = false;
        int j;
        Object localObject;
        int k;
        int m;
        int n;
        if (bool1)
        {
          j = arrayOfString.length;
          i = 0;
          bool1 = bool2;
          if (i < j)
          {
            paramString = arrayOfString[i].split("#");
            bool1 = bool2;
            if (paramString.length == 4)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(paramString[0]);
              ((StringBuilder)localObject).append(paramString[1]);
              localObject = ((StringBuilder)localObject).toString();
              if (!jdField_a_of_type_JavaLangString.contains((CharSequence)localObject)) {
                break label385;
              }
              localObject = Pattern.compile("(G|T|\\-)(\\d+)(.+MP(\\d+))?").matcher(jdField_a_of_type_JavaLangString);
              bool1 = ((Matcher)localObject).find();
              if (!bool1) {
                break label385;
              }
              try
              {
                k = Integer.parseInt(((Matcher)localObject).group(4));
                m = Integer.parseInt(paramString[2]);
                n = Integer.parseInt(paramString[3]);
                bool1 = bool2;
                if (k > n) {
                  continue;
                }
                bool1 = bool2;
                if (k < m) {
                  continue;
                }
                bool1 = true;
              }
              catch (Exception paramString)
              {
                paramString.printStackTrace();
                break label385;
              }
            }
          }
        }
        else
        {
          bool1 = bool2;
          if (jdField_a_of_type_JavaLangString.contains("Adreno"))
          {
            j = arrayOfString.length;
            i = 0;
            bool1 = bool2;
            if (i < j)
            {
              localObject = arrayOfString[i].split("#");
              paramString = "0";
              Matcher localMatcher = Pattern.compile("Adreno.*(\\d{3,4})").matcher(jdField_a_of_type_JavaLangString);
              if (localMatcher.find()) {
                paramString = localMatcher.group(1);
              }
              if ((localObject.length != 3) || (!paramString.substring(0, 1).equals(localObject[0])))
              {
                k = localObject.length;
                if (k != 2) {
                  break label392;
                }
              }
              try
              {
                k = Integer.parseInt(paramString);
                m = Integer.parseInt(localObject[(localObject.length - 2)]);
                n = Integer.parseInt(localObject[(localObject.length - 1)]);
                bool1 = bool2;
                if (k <= n)
                {
                  bool1 = bool2;
                  if (k >= m) {
                    continue;
                  }
                }
                a(bool1);
              }
              catch (Exception paramString)
              {
                paramString.printStackTrace();
              }
            }
          }
        }
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      label385:
      i += 1;
      continue;
      label392:
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
  
  private static int c(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
      int k = arrayOfString.length;
      int i = 0;
      int j = 0;
      while (i < k)
      {
        Object localObject = arrayOfString[i];
        j += 1;
        if ((!jdField_c_of_type_JavaLangString.contains((CharSequence)localObject)) && (paramString.has((String)localObject)))
        {
          localObject = paramString.getJSONObject((String)localObject);
          e = j;
          a((JSONObject)localObject);
          if (jdField_a_of_type_Int > 0)
          {
            paramString = new StringBuilder();
            paramString.append("support because of config: ");
            paramString.append(jdField_a_of_type_Int);
            QLog.d("QmcfDevicesStrategy", 1, paramString.toString());
            i = jdField_a_of_type_Int;
            return i;
          }
        }
        i += 1;
      }
      return 0;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 4;
  }
  
  private static void c(String paramString)
  {
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
        boolean bool2 = false;
        i = 0;
        boolean bool1 = bool2;
        if (i < j)
        {
          CharSequence localCharSequence = paramString[i];
          if (!jdField_a_of_type_JavaLangString.contains(localCharSequence)) {
            break label64;
          }
          bool1 = true;
        }
        a(bool1);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      label64:
      i += 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.qmcf.QmcfDevicesStrategy
 * JD-Core Version:    0.7.0.1
 */