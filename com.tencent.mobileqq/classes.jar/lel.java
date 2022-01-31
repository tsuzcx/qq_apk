import android.os.Build;
import android.os.Build.VERSION;

public class lel
{
  public static String A = g + k;
  public static String B = b + h + j;
  public static String C = b + h + k;
  public static String D = b + i + l;
  public static String E = b + i + m;
  public static String F = b + i + n;
  public static String G = b + i + o;
  public static String H = b + i + p;
  public static String I = c + h + j;
  public static String J = c + h + k;
  public static String K = c + i + l;
  public static String L = c + i + m;
  public static String M = c + i + n;
  public static String N = c + i + o;
  public static String O = c + i + p;
  public static String P = d + h + j;
  public static String Q = d + h + k;
  public static String R = d + i + l;
  public static String S = d + i + m;
  public static String T = d + i + n;
  public static String U = d + i + o;
  public static String V = d + i + p;
  public static String W = e + h + j;
  public static String X = e + h + k;
  public static String Y = e + i + l;
  public static String Z = e + i + m;
  public static String a;
  public static String aa = e + i + n;
  public static String ab = e + i + o;
  public static String ac = e + i + p;
  public static String ad = jdField_a_of_type_JavaLangString + s + t;
  public static String ae = jdField_a_of_type_JavaLangString + s + u;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  public static String i;
  public static String j;
  public static String k;
  public static String l;
  public static String m;
  public static String n;
  public static String o;
  public static String p;
  public static String q;
  public static String r;
  public static String s;
  public static String t;
  public static String u;
  public static String v;
  public static String w;
  public static String x;
  public static String y;
  public static String z;
  
  static
  {
    jdField_a_of_type_JavaLangString = "sharp/hwcodec_new2/";
    b = jdField_a_of_type_JavaLangString + "avc_decoder/";
    c = jdField_a_of_type_JavaLangString + "avc_encoder/";
    d = jdField_a_of_type_JavaLangString + "hevc_decoder/";
    e = jdField_a_of_type_JavaLangString + "hevc_encoder/";
    f = jdField_a_of_type_JavaLangString + "async/";
    g = jdField_a_of_type_JavaLangString + "test/";
    h = "white_list/";
    i = "black_list/";
    j = "min_sdk";
    k = "min_version";
    l = "model";
    m = "product";
    n = "fingerprint";
    o = "sdk";
    p = "version";
    q = "codec";
    r = "disable_sdk";
    s = "async/";
    t = "min_sdk";
    u = "codec";
    v = "async_min_sdk";
    w = g + j;
    x = g + r;
    y = g + q;
    z = g + v;
  }
  
  public static int a(kse paramkse)
  {
    if (Build.VERSION.SDK_INT < 16) {}
    while ((paramkse == null) || (Build.VERSION.SDK_INT < paramkse.c) || (!a(paramkse.jdField_a_of_type_JavaLangString, null)) || (mft.a(paramkse.jdField_a_of_type_JavaUtilArrayList, Integer.valueOf(Build.VERSION.SDK_INT)))) {
      return 0;
    }
    if ((paramkse.d != 0) && (Build.VERSION.SDK_INT >= 21) && (Build.VERSION.SDK_INT >= paramkse.d)) {
      return 2;
    }
    return 1;
  }
  
  static boolean a(String paramString, String[] paramArrayOfString)
  {
    int i2 = mjg.b();
    if (mjg.a(paramString) > i2) {
      return false;
    }
    if ((paramArrayOfString != null) && (paramArrayOfString != null))
    {
      int i3 = paramArrayOfString.length;
      int i1 = 0;
      for (;;)
      {
        if (i1 >= i3) {
          break label51;
        }
        if (mjg.a(paramArrayOfString[i1]) == i2) {
          break;
        }
        i1 += 1;
      }
    }
    label51:
    return true;
  }
  
  public boolean a(lao paramlao)
  {
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      return false;
      try
      {
        Object localObject = a(paramlao, P);
        if ((localObject == null) || (Build.VERSION.SDK_INT < localObject[0]) || (!a(paramlao, Q, V))) {
          continue;
        }
        localObject = a(paramlao, U);
        int i1;
        if (localObject != null)
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= localObject.length) {
              break label90;
            }
            if (Build.VERSION.SDK_INT == localObject[i1]) {
              break;
            }
            i1 += 1;
          }
        }
        label90:
        localObject = a(paramlao, R);
        if (localObject != null)
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= localObject.length) {
              break label134;
            }
            if (Build.MODEL.equalsIgnoreCase(localObject[i1])) {
              break;
            }
            i1 += 1;
          }
        }
        label134:
        localObject = a(paramlao, S);
        if (localObject != null)
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= localObject.length) {
              break label178;
            }
            if (Build.PRODUCT.equalsIgnoreCase(localObject[i1])) {
              break;
            }
            i1 += 1;
          }
        }
        label178:
        paramlao = a(paramlao, T);
        if (paramlao != null)
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= paramlao.length) {
              break label227;
            }
            boolean bool = Build.PRODUCT.equalsIgnoreCase(paramlao[i1]);
            if (bool) {
              break;
            }
            i1 += 1;
          }
        }
        return true;
      }
      catch (Exception paramlao)
      {
        paramlao.printStackTrace();
        return false;
      }
    }
  }
  
  public boolean a(lao paramlao, int paramInt)
  {
    try
    {
      int[] arrayOfInt = a(paramlao, ad);
      if (arrayOfInt == null) {
        return false;
      }
      if ((Build.VERSION.SDK_INT >= 21) && (Build.VERSION.SDK_INT >= arrayOfInt[0]))
      {
        paramlao = a(paramlao, ae);
        if (paramlao != null)
        {
          boolean bool = mft.a(paramlao, paramInt);
          if (bool) {
            return true;
          }
        }
      }
    }
    catch (Exception paramlao) {}
    return false;
  }
  
  boolean a(lao paramlao, String paramString1, String paramString2)
  {
    int i2 = mjg.b();
    if (mjg.a(paramlao.a(paramString1, "")) > i2) {
      return false;
    }
    if (paramString2 != null)
    {
      paramlao = paramlao.a(paramString2);
      if (paramlao != null)
      {
        int i3 = paramlao.length;
        int i1 = 0;
        for (;;)
        {
          if (i1 >= i3) {
            break label72;
          }
          if (mjg.a(paramlao[i1]) == i2) {
            break;
          }
          i1 += 1;
        }
      }
    }
    label72:
    return true;
  }
  
  int[] a(lao paramlao, String paramString)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return null;
    }
    return paramlao.a(paramString);
  }
  
  String[] a(lao paramlao, String paramString)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return null;
    }
    return paramlao.a(paramString);
  }
  
  public boolean b(lao paramlao)
  {
    if (Build.VERSION.SDK_INT < 19) {}
    for (;;)
    {
      return false;
      try
      {
        Object localObject = a(paramlao, W);
        if ((localObject == null) || (Build.VERSION.SDK_INT < localObject[0]) || (!a(paramlao, X, ac))) {
          continue;
        }
        localObject = a(paramlao, ab);
        int i1;
        if (localObject != null)
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= localObject.length) {
              break label90;
            }
            if (Build.VERSION.SDK_INT == localObject[i1]) {
              break;
            }
            i1 += 1;
          }
        }
        label90:
        localObject = a(paramlao, Y);
        if (localObject != null)
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= localObject.length) {
              break label134;
            }
            if (Build.MODEL.equalsIgnoreCase(localObject[i1])) {
              break;
            }
            i1 += 1;
          }
        }
        label134:
        localObject = a(paramlao, Z);
        if (localObject != null)
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= localObject.length) {
              break label178;
            }
            if (Build.PRODUCT.equalsIgnoreCase(localObject[i1])) {
              break;
            }
            i1 += 1;
          }
        }
        label178:
        paramlao = a(paramlao, aa);
        if (paramlao != null)
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= paramlao.length) {
              break label227;
            }
            boolean bool = Build.PRODUCT.equalsIgnoreCase(paramlao[i1]);
            if (bool) {
              break;
            }
            i1 += 1;
          }
        }
        return true;
      }
      catch (Exception paramlao)
      {
        paramlao.printStackTrace();
        return false;
      }
    }
  }
  
  public boolean c(lao paramlao)
  {
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      return false;
      try
      {
        Object localObject = a(paramlao, B);
        if ((localObject != null) && (Build.VERSION.SDK_INT >= localObject[0]) && (a(paramlao, C, H)))
        {
          localObject = a(paramlao, G);
          int i1;
          if (localObject != null)
          {
            i1 = 0;
            for (;;)
            {
              if (i1 >= localObject.length) {
                break label90;
              }
              if (Build.VERSION.SDK_INT == localObject[i1]) {
                break;
              }
              i1 += 1;
            }
          }
          label90:
          localObject = a(paramlao, D);
          if (localObject != null)
          {
            i1 = 0;
            for (;;)
            {
              if (i1 >= localObject.length) {
                break label134;
              }
              if (Build.MODEL.equalsIgnoreCase(localObject[i1])) {
                break;
              }
              i1 += 1;
            }
          }
          label134:
          localObject = a(paramlao, E);
          if (localObject != null)
          {
            i1 = 0;
            for (;;)
            {
              if (i1 >= localObject.length) {
                break label178;
              }
              if (Build.PRODUCT.equalsIgnoreCase(localObject[i1])) {
                break;
              }
              i1 += 1;
            }
          }
          label178:
          paramlao = a(paramlao, F);
          if (paramlao != null)
          {
            i1 = 0;
            for (;;)
            {
              if (i1 >= paramlao.length) {
                break label220;
              }
              boolean bool = Build.PRODUCT.equalsIgnoreCase(paramlao[i1]);
              if (bool) {
                break;
              }
              i1 += 1;
            }
          }
          label220:
          return true;
        }
      }
      catch (Exception paramlao) {}
    }
    return false;
  }
  
  public boolean d(lao paramlao)
  {
    if (Build.VERSION.SDK_INT < 19) {}
    for (;;)
    {
      return false;
      try
      {
        Object localObject = a(paramlao, I);
        if ((localObject != null) && (Build.VERSION.SDK_INT >= localObject[0]) && (a(paramlao, J, O)))
        {
          localObject = a(paramlao, N);
          int i1;
          if (localObject != null)
          {
            i1 = 0;
            for (;;)
            {
              if (i1 >= localObject.length) {
                break label90;
              }
              if (Build.VERSION.SDK_INT == localObject[i1]) {
                break;
              }
              i1 += 1;
            }
          }
          label90:
          localObject = a(paramlao, K);
          if (localObject != null)
          {
            i1 = 0;
            for (;;)
            {
              if (i1 >= localObject.length) {
                break label134;
              }
              if (Build.MODEL.equalsIgnoreCase(localObject[i1])) {
                break;
              }
              i1 += 1;
            }
          }
          label134:
          localObject = a(paramlao, L);
          if (localObject != null)
          {
            i1 = 0;
            for (;;)
            {
              if (i1 >= localObject.length) {
                break label178;
              }
              if (Build.PRODUCT.equalsIgnoreCase(localObject[i1])) {
                break;
              }
              i1 += 1;
            }
          }
          label178:
          paramlao = a(paramlao, M);
          if (paramlao != null)
          {
            i1 = 0;
            for (;;)
            {
              if (i1 >= paramlao.length) {
                break label220;
              }
              boolean bool = Build.PRODUCT.equalsIgnoreCase(paramlao[i1]);
              if (bool) {
                break;
              }
              i1 += 1;
            }
          }
          label220:
          return true;
        }
      }
      catch (Exception paramlao) {}
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lel
 * JD-Core Version:    0.7.0.1
 */