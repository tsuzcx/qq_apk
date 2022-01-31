import android.os.Build;
import android.os.Build.VERSION;

public class lek
{
  public static String A = b + h + j;
  public static String B = b + h + k;
  public static String C = b + i + l;
  public static String D = b + i + m;
  public static String E = b + i + n;
  public static String F = b + i + o;
  public static String G = b + i + p;
  public static String H = c + h + j;
  public static String I = c + h + k;
  public static String J = c + i + l;
  public static String K = c + i + m;
  public static String L = c + i + n;
  public static String M = c + i + o;
  public static String N = c + i + p;
  public static String O = d + h + j;
  public static String P = d + h + k;
  public static String Q = d + i + l;
  public static String R = d + i + m;
  public static String S = d + i + n;
  public static String T = d + i + o;
  public static String U = d + i + p;
  public static String V = e + h + j;
  public static String W = e + h + k;
  public static String X = e + i + l;
  public static String Y = e + i + m;
  public static String Z = e + i + n;
  public static String a;
  public static String aa = e + i + o;
  public static String ab = e + i + p;
  public static String ac = jdField_a_of_type_JavaLangString + s + t;
  public static String ad = jdField_a_of_type_JavaLangString + s + u;
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
  @Deprecated
  lao a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "sharp/hwcodec_new/";
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
  
  public lek()
  {
    this.jdField_a_of_type_Lao = null;
  }
  
  public boolean a(lao paramlao)
  {
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      return false;
      try
      {
        Object localObject = a(paramlao, O);
        if ((localObject == null) || (Build.VERSION.SDK_INT < localObject[0])) {
          continue;
        }
        localObject = a(paramlao, T);
        int i1;
        if (localObject != null)
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= localObject.length) {
              break label76;
            }
            if (Build.VERSION.SDK_INT == localObject[i1]) {
              break;
            }
            i1 += 1;
          }
        }
        label76:
        localObject = a(paramlao, Q);
        if (localObject != null)
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= localObject.length) {
              break label120;
            }
            if (Build.MODEL.equalsIgnoreCase(localObject[i1])) {
              break;
            }
            i1 += 1;
          }
        }
        label120:
        localObject = a(paramlao, R);
        if (localObject != null)
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= localObject.length) {
              break label164;
            }
            if (Build.PRODUCT.equalsIgnoreCase(localObject[i1])) {
              break;
            }
            i1 += 1;
          }
        }
        label164:
        paramlao = a(paramlao, S);
        if (paramlao != null)
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= paramlao.length) {
              break label213;
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
      int[] arrayOfInt = a(paramlao, ac);
      if (arrayOfInt == null) {
        return false;
      }
      if ((Build.VERSION.SDK_INT >= 21) && (Build.VERSION.SDK_INT >= arrayOfInt[0]))
      {
        paramlao = a(paramlao, ad);
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
        Object localObject = a(paramlao, V);
        if ((localObject == null) || (Build.VERSION.SDK_INT < localObject[0])) {
          continue;
        }
        localObject = a(paramlao, aa);
        int i1;
        if (localObject != null)
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= localObject.length) {
              break label76;
            }
            if (Build.VERSION.SDK_INT == localObject[i1]) {
              break;
            }
            i1 += 1;
          }
        }
        label76:
        localObject = a(paramlao, X);
        if (localObject != null)
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= localObject.length) {
              break label120;
            }
            if (Build.MODEL.equalsIgnoreCase(localObject[i1])) {
              break;
            }
            i1 += 1;
          }
        }
        label120:
        localObject = a(paramlao, Y);
        if (localObject != null)
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= localObject.length) {
              break label164;
            }
            if (Build.PRODUCT.equalsIgnoreCase(localObject[i1])) {
              break;
            }
            i1 += 1;
          }
        }
        label164:
        paramlao = a(paramlao, Z);
        if (paramlao != null)
        {
          i1 = 0;
          for (;;)
          {
            if (i1 >= paramlao.length) {
              break label213;
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
        Object localObject = a(paramlao, A);
        if ((localObject != null) && (Build.VERSION.SDK_INT >= localObject[0]))
        {
          localObject = a(paramlao, F);
          int i1;
          if (localObject != null)
          {
            i1 = 0;
            for (;;)
            {
              if (i1 >= localObject.length) {
                break label76;
              }
              if (Build.VERSION.SDK_INT == localObject[i1]) {
                break;
              }
              i1 += 1;
            }
          }
          label76:
          localObject = a(paramlao, C);
          if (localObject != null)
          {
            i1 = 0;
            for (;;)
            {
              if (i1 >= localObject.length) {
                break label120;
              }
              if (Build.MODEL.equalsIgnoreCase(localObject[i1])) {
                break;
              }
              i1 += 1;
            }
          }
          label120:
          localObject = a(paramlao, D);
          if (localObject != null)
          {
            i1 = 0;
            for (;;)
            {
              if (i1 >= localObject.length) {
                break label164;
              }
              if (Build.PRODUCT.equalsIgnoreCase(localObject[i1])) {
                break;
              }
              i1 += 1;
            }
          }
          label164:
          paramlao = a(paramlao, E);
          if (paramlao != null)
          {
            i1 = 0;
            for (;;)
            {
              if (i1 >= paramlao.length) {
                break label206;
              }
              boolean bool = Build.PRODUCT.equalsIgnoreCase(paramlao[i1]);
              if (bool) {
                break;
              }
              i1 += 1;
            }
          }
          label206:
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
        Object localObject = a(paramlao, H);
        if ((localObject != null) && (Build.VERSION.SDK_INT >= localObject[0]))
        {
          localObject = a(paramlao, M);
          int i1;
          if (localObject != null)
          {
            i1 = 0;
            for (;;)
            {
              if (i1 >= localObject.length) {
                break label76;
              }
              if (Build.VERSION.SDK_INT == localObject[i1]) {
                break;
              }
              i1 += 1;
            }
          }
          label76:
          localObject = a(paramlao, J);
          if (localObject != null)
          {
            i1 = 0;
            for (;;)
            {
              if (i1 >= localObject.length) {
                break label120;
              }
              if (Build.MODEL.equalsIgnoreCase(localObject[i1])) {
                break;
              }
              i1 += 1;
            }
          }
          label120:
          localObject = a(paramlao, K);
          if (localObject != null)
          {
            i1 = 0;
            for (;;)
            {
              if (i1 >= localObject.length) {
                break label164;
              }
              if (Build.PRODUCT.equalsIgnoreCase(localObject[i1])) {
                break;
              }
              i1 += 1;
            }
          }
          label164:
          paramlao = a(paramlao, L);
          if (paramlao != null)
          {
            i1 = 0;
            for (;;)
            {
              if (i1 >= paramlao.length) {
                break label206;
              }
              boolean bool = Build.PRODUCT.equalsIgnoreCase(paramlao[i1]);
              if (bool) {
                break;
              }
              i1 += 1;
            }
          }
          label206:
          return true;
        }
      }
      catch (Exception paramlao) {}
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lek
 * JD-Core Version:    0.7.0.1
 */