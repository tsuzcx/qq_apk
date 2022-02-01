package com.tencent.mobileqq.shortvideo.qmcf;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.util.MediaCodecDPC;
import com.tencent.av.opengl.effects.EffectCtrlUtils;
import com.tencent.mobileqq.opencl.OpenclInfoManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class QmcfDevicesStrategy
{
  public static String a = "";
  private static final String[] b = { "snpe", "opencl_mali", "opencl_ocl", "opengl" };
  private static final String[] c = { "NX609J", "NX531J", "vivo X7Plus", "ARS-TL00", "MI 8 Lite", "1807-A01", "ARE-AL00", "MI 4S" };
  private static final String[] d = { "Redmi Note 3" };
  private static int e = -1;
  private static int f = -1;
  private static int g = -1;
  private static int h = -1;
  private static int i = 0;
  private static String j = "";
  private static String k = "";
  private static int l = -1;
  
  public static int a()
  {
    try
    {
      if (f > -1)
      {
        m = f;
        return m;
      }
      int m = a(d());
      return m;
    }
    finally {}
  }
  
  public static int a(Context paramContext)
  {
    return paramContext.getSharedPreferences("qmcf_gpu_config", 0).getInt("cfg_version", 0);
  }
  
  public static int a(String paramString)
  {
    int m = f;
    if (m > -1) {
      return m;
    }
    if (Build.VERSION.SDK_INT < 21)
    {
      f = 0;
      QLog.d("QmcfDevicesStrategy", 1, String.format("not support because of version:%d ", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) }));
      return f;
    }
    m = MediaCodecDPC.i();
    if (m != -1)
    {
      f = m;
      paramString = new StringBuilder();
      paramString.append("DPCInfo:");
      paramString.append(m);
      QLog.d("QmcfDevicesStrategy", 1, paramString.toString());
      return f;
    }
    f = 0;
    if (Build.MODEL.contains("Pixel"))
    {
      f = 4;
      return f;
    }
    if (Build.MODEL.contains("Nexus"))
    {
      f = 0;
      QLog.d("QmcfDevicesStrategy", 1, "not support because of nexus");
      return f;
    }
    Object localObject = c;
    int n = localObject.length;
    m = 0;
    while (m < n)
    {
      String str = localObject[m];
      if (Build.MODEL.equalsIgnoreCase(str))
      {
        f = 4;
        QLog.d("QmcfDevicesStrategy", 1, "support because of GLSO rule");
        return f;
      }
      m += 1;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      boolean bool1 = new File("/system/vendor/lib/egl/libGLES_mali.so").exists();
      boolean bool2 = new File("/system/lib/egl/libGLES_mali.so").exists();
      if ((bool1) || (bool2))
      {
        f = 4;
        QLog.d("QmcfDevicesStrategy", 1, "support because of mali type");
        return f;
      }
    }
    if (TextUtils.isEmpty(a))
    {
      a = new OpenclInfoManager().b();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("GPUInfo:");
      ((StringBuilder)localObject).append(a);
      QLog.d("QmcfDevicesStrategy", 1, ((StringBuilder)localObject).toString());
    }
    if ((TextUtils.isEmpty(a)) || (a.startsWith("err")))
    {
      a = MobileQQ.sMobileQQ.getSharedPreferences("qmcf_gpu_config", 4).getString("gl_renderer", "");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getGLRendererInfo:");
      ((StringBuilder)localObject).append(a);
      QLog.i("QmcfDevicesStrategy", 1, ((StringBuilder)localObject).toString());
      if (TextUtils.isEmpty(a))
      {
        f = -2;
        return f;
      }
    }
    f = d(paramString);
    m = f;
    if (m == 0) {
      QLog.d("QmcfDevicesStrategy", 1, String.format("not support gpu[%s] type[%s]", new Object[] { a, Integer.valueOf(m) }));
    }
    return f;
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
      e(paramString2);
      return;
    }
    if ("enum".equals(paramString1)) {
      f(paramString2);
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
      int m;
      try
      {
        boolean bool1 = a.contains("Mali");
        boolean bool2 = false;
        int n;
        String[] arrayOfString2;
        int i1;
        int i2;
        if (bool1)
        {
          n = arrayOfString1.length;
          m = 0;
          bool1 = bool2;
          if (m < n)
          {
            arrayOfString2 = arrayOfString1[m].split("#");
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
            if (!a.contains(paramString)) {
              break label408;
            }
            paramString = Pattern.compile("(G|T|\\-)(\\d+)(.+MP(\\d+))?").matcher(a);
            i1 = arrayOfString2.length;
            bool1 = paramString.find();
            if (!bool1) {
              break label408;
            }
            try
            {
              i1 = Integer.parseInt(paramString.group((i1 - 1) * 2));
              i2 = Integer.parseInt(arrayOfString2[(arrayOfString2.length - 1)]);
              if ((!paramBoolean) || (i1 < i2))
              {
                bool1 = bool2;
                if (!paramBoolean)
                {
                  bool1 = bool2;
                  if (i1 > i2) {}
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
              break label408;
            }
          }
        }
        else
        {
          bool1 = bool2;
          if (a.contains("Adreno"))
          {
            n = arrayOfString1.length;
            m = 0;
            bool1 = bool2;
            if (m < n)
            {
              arrayOfString2 = arrayOfString1[m].split("#");
              paramString = "0";
              Matcher localMatcher = Pattern.compile("Adreno.*(\\d{3,4})").matcher(a);
              if (localMatcher.find()) {
                paramString = localMatcher.group(1);
              }
              if ((arrayOfString2.length != 2) || (!paramString.substring(0, 1).equals(arrayOfString2[0])))
              {
                i1 = arrayOfString2.length;
                if (i1 != 1) {
                  break label415;
                }
              }
              try
              {
                i1 = Integer.parseInt(paramString);
                i2 = Integer.parseInt(arrayOfString2[(arrayOfString2.length - 1)]);
                if ((paramBoolean) && (i1 >= i2)) {
                  continue;
                }
                bool1 = bool2;
                if (!paramBoolean)
                {
                  bool1 = bool2;
                  if (i1 <= i2) {
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
      label408:
      m += 1;
      continue;
      label415:
      m += 1;
    }
  }
  
  private static void a(JSONObject paramJSONObject)
  {
    try
    {
      String[] arrayOfString = paramJSONObject.getString("verdor").split(";");
      int n = arrayOfString.length;
      int m = 0;
      while (m < n)
      {
        String str = arrayOfString[m];
        if (a.contains(str)) {
          b(paramJSONObject.getJSONObject(str));
        }
        m += 1;
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
    if ("white".equals(j))
    {
      if (paramBoolean) {
        e = i;
      }
    }
    else if (("black".equals(j)) && (!paramBoolean)) {
      e = i;
    }
  }
  
  public static boolean a(String paramString, int paramInt, Context paramContext)
  {
    try
    {
      b(paramContext);
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
    int m = g;
    if (m > -1) {
      return m;
    }
    m = Build.VERSION.SDK_INT;
    int n = 0;
    if (m < 21)
    {
      g = 0;
      QLog.d("QmcfDevicesStrategy", 1, String.format("not support because of version:%d ", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) }));
      return g;
    }
    if (!c())
    {
      g = 0;
      QLog.d("QmcfDevicesStrategy", 1, String.format("not support because of low-end devices", new Object[0]));
      return g;
    }
    m = MediaCodecDPC.i();
    Object localObject;
    if (m != -1)
    {
      g = m;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DPCInfo:");
      ((StringBuilder)localObject).append(m);
      QLog.d("QmcfDevicesStrategy", 1, ((StringBuilder)localObject).toString());
      return g;
    }
    g = 0;
    if ((!Build.MODEL.contains("Pixel")) && (!Build.MODEL.contains("Nexus")))
    {
      localObject = c;
      int i1 = localObject.length;
      m = 0;
      String str;
      while (m < i1)
      {
        str = localObject[m];
        if (Build.MODEL.equalsIgnoreCase(str))
        {
          g = 4;
          QLog.d("QmcfDevicesStrategy", 1, "support because of GLSO rule");
          return g;
        }
        m += 1;
      }
      localObject = d;
      i1 = localObject.length;
      m = n;
      while (m < i1)
      {
        str = localObject[m];
        if (Build.MODEL.equalsIgnoreCase(str))
        {
          g = 4;
          QLog.d("QmcfDevicesStrategy", 1, "support because of GLSO rule loose");
          return g;
        }
        m += 1;
      }
      boolean bool1 = new File("/system/vendor/lib/egl/libGLES_mali.so").exists();
      boolean bool2 = new File("/system/lib/egl/libGLES_mali.so").exists();
      if ((!bool1) && (!bool2))
      {
        g = 3;
        return g;
      }
      g = 4;
      QLog.d("QmcfDevicesStrategy", 1, "support because of mali type");
      return g;
    }
    g = 4;
    return g;
  }
  
  public static int b(String paramString)
  {
    int m = h;
    if (m > -1) {
      return m;
    }
    if (Build.VERSION.SDK_INT < 21)
    {
      h = 0;
      QLog.d("QmcfDevicesStrategy", 1, String.format("multiaio not support because of version:%d ", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) }));
      return h;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      boolean bool1 = new File("/system/vendor/lib/egl/libGLES_mali.so").exists();
      boolean bool2 = new File("/system/lib/egl/libGLES_mali.so").exists();
      if ((bool1) || (bool2))
      {
        h = 4;
        QLog.d("QmcfDevicesStrategy", 1, "support because of mali type");
        return h;
      }
    }
    StringBuilder localStringBuilder;
    if (TextUtils.isEmpty(a))
    {
      a = new OpenclInfoManager().b();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("GPUInfo:");
      localStringBuilder.append(a);
      QLog.d("QmcfDevicesStrategy", 1, localStringBuilder.toString());
    }
    if ((TextUtils.isEmpty(a)) || (a.startsWith("err")))
    {
      a = MobileQQ.sMobileQQ.getSharedPreferences("qmcf_gpu_config", 4).getString("gl_renderer", "");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getGLRendererInfo:");
      localStringBuilder.append(a);
      QLog.i("QmcfDevicesStrategy", 1, localStringBuilder.toString());
      if (TextUtils.isEmpty(a))
      {
        h = 4;
        return h;
      }
    }
    h = d(paramString);
    return h;
  }
  
  public static void b(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("QmcfConfig", 4).edit();
    paramContext.putInt("qmcf_mobile_support", 1);
    paramContext.commit();
  }
  
  private static void b(JSONObject paramJSONObject)
  {
    try
    {
      String[] arrayOfString = paramJSONObject.getString("strategy").split(";");
      int n = arrayOfString.length;
      int m = 0;
      while (m < n)
      {
        String str = arrayOfString[m];
        JSONObject localJSONObject = paramJSONObject.getJSONObject(str);
        j = str;
        c(localJSONObject);
        m += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public static void c(String paramString)
  {
    if (l == -1)
    {
      Object localObject = MobileQQ.sMobileQQ.getSharedPreferences("qmcf_gpu_config", 4);
      l = ((SharedPreferences)localObject).getInt("gl_renderer_flag", 0);
      if (l == 0)
      {
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString("gl_renderer", paramString);
        ((SharedPreferences.Editor)localObject).putInt("gl_renderer_flag", 1);
        ((SharedPreferences.Editor)localObject).commit();
        l = 1;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("saveGLRendererInfo:");
        ((StringBuilder)localObject).append(paramString);
        QLog.i("QmcfDevicesStrategy", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private static void c(JSONObject paramJSONObject)
  {
    try
    {
      String[] arrayOfString = paramJSONObject.getString("rule").split(";");
      int n = arrayOfString.length;
      int m = 0;
      while (m < n)
      {
        String str = arrayOfString[m];
        a(str, paramJSONObject.getString(str));
        m += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public static boolean c()
  {
    return EffectCtrlUtils.a(4, 1200000L, 2147483648L);
  }
  
  private static int d(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      String[] arrayOfString = b;
      int i1 = arrayOfString.length;
      int m = 0;
      int n = 0;
      while (m < i1)
      {
        Object localObject = arrayOfString[m];
        n += 1;
        if ((!k.contains((CharSequence)localObject)) && (paramString.has((String)localObject)))
        {
          localObject = paramString.getJSONObject((String)localObject);
          i = n;
          a((JSONObject)localObject);
          if (e > 0)
          {
            paramString = new StringBuilder();
            paramString.append("support because of config: ");
            paramString.append(e);
            QLog.d("QmcfDevicesStrategy", 1, paramString.toString());
            m = e;
            return m;
          }
        }
        m += 1;
      }
      return 0;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 4;
  }
  
  private static String d()
  {
    String str2 = MobileQQ.sMobileQQ.getSharedPreferences("qmcf_gpu_config", 0).getString("cfg_content", "");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = FileUtils.readStringFromAsset("qmcf_rule_config.xml");
    }
    return str1;
  }
  
  private static void e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String[] arrayOfString = paramString.split(";");
    for (;;)
    {
      int m;
      try
      {
        boolean bool1 = a.contains("Mali");
        boolean bool2 = false;
        int n;
        Object localObject;
        int i1;
        int i2;
        int i3;
        if (bool1)
        {
          n = arrayOfString.length;
          m = 0;
          bool1 = bool2;
          if (m < n)
          {
            paramString = arrayOfString[m].split("#");
            bool1 = bool2;
            if (paramString.length == 4)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(paramString[0]);
              ((StringBuilder)localObject).append(paramString[1]);
              localObject = ((StringBuilder)localObject).toString();
              if (!a.contains((CharSequence)localObject)) {
                break label380;
              }
              localObject = Pattern.compile("(G|T|\\-)(\\d+)(.+MP(\\d+))?").matcher(a);
              bool1 = ((Matcher)localObject).find();
              if (!bool1) {
                break label380;
              }
              try
              {
                i1 = Integer.parseInt(((Matcher)localObject).group(4));
                i2 = Integer.parseInt(paramString[2]);
                i3 = Integer.parseInt(paramString[3]);
                bool1 = bool2;
                if (i1 > i3) {
                  continue;
                }
                bool1 = bool2;
                if (i1 < i2) {
                  continue;
                }
                bool1 = true;
              }
              catch (Exception paramString)
              {
                paramString.printStackTrace();
                break label380;
              }
            }
          }
        }
        else
        {
          bool1 = bool2;
          if (a.contains("Adreno"))
          {
            n = arrayOfString.length;
            m = 0;
            bool1 = bool2;
            if (m < n)
            {
              localObject = arrayOfString[m].split("#");
              paramString = "0";
              Matcher localMatcher = Pattern.compile("Adreno.*(\\d{3,4})").matcher(a);
              if (localMatcher.find()) {
                paramString = localMatcher.group(1);
              }
              if ((localObject.length != 3) || (!paramString.substring(0, 1).equals(localObject[0])))
              {
                i1 = localObject.length;
                if (i1 != 2) {
                  break label387;
                }
              }
              try
              {
                i1 = Integer.parseInt(paramString);
                i2 = Integer.parseInt(localObject[(localObject.length - 2)]);
                i3 = Integer.parseInt(localObject[(localObject.length - 1)]);
                bool1 = bool2;
                if (i1 <= i3)
                {
                  bool1 = bool2;
                  if (i1 >= i2) {
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
      label380:
      m += 1;
      continue;
      label387:
      m += 1;
    }
  }
  
  private static void f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = paramString.split(";");
    for (;;)
    {
      int m;
      try
      {
        int n = paramString.length;
        boolean bool2 = false;
        m = 0;
        boolean bool1 = bool2;
        if (m < n)
        {
          CharSequence localCharSequence = paramString[m];
          if (!a.contains(localCharSequence)) {
            break label63;
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
      label63:
      m += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.qmcf.QmcfDevicesStrategy
 * JD-Core Version:    0.7.0.1
 */