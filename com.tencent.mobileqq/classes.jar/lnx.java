import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;

public class lnx
{
  private static String jdField_a_of_type_JavaLangString = "hwcodec_new2";
  private static String b = "sharp/hwcodec_new/";
  private static String c = "sharp/hwcodec_new2/";
  private static String d = "avc_decoder/";
  private static String e = "avc_encoder/";
  private static String f = "hevc_decoder/";
  private static String g = "hevc_encoder/";
  private static String h = "test/";
  private static String i = "white_list/";
  private static String j = "black_list/";
  private static String k = "min_sdk";
  private static String l = "min_version";
  private static String m = "max_w";
  private static String n = "max_h";
  private static String o = "model";
  private static String p = "product";
  private static String q = "fingerprint";
  private static String r = "sdk";
  private static String s = "version";
  private static String t = "codec";
  private static String u = "disable_sdk";
  private static String v = "async/";
  private static String w = "min_sdk";
  private static String x = "codec";
  private static String y = "async_min_sdk";
  private String A;
  private String B;
  private String C;
  private String D;
  private String E;
  private String F;
  private String G;
  private String H;
  private String I;
  private String J;
  private String K;
  private String L;
  private String M;
  private String N;
  private String O;
  private String P;
  private String Q;
  private String R;
  private String S;
  private String T;
  private String U;
  private String V;
  private String W;
  private String X;
  private String Y;
  private String Z;
  private int jdField_a_of_type_Int = 1;
  private ljz jdField_a_of_type_Ljz;
  private String aa;
  private String ab;
  private String ac;
  private String ad;
  private String ae;
  private String af;
  private String ag;
  private String ah;
  private String ai;
  private String aj;
  private String ak;
  private String al;
  private String am;
  private String an;
  private String ao;
  private String ap;
  private String aq = b;
  private String z;
  
  public lnx(ljz paramljz)
  {
    if ((paramljz != null) && (!paramljz.a()) && (paramljz.a().contains(jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_Int = 2;
    }
    this.jdField_a_of_type_Ljz = paramljz;
    if (this.jdField_a_of_type_Int == 2) {}
    for (paramljz = c;; paramljz = b)
    {
      this.aq = paramljz;
      QLog.i("CodecConfigParser", 1, "ver = " + this.jdField_a_of_type_Int + ", root = " + this.aq);
      this.z = (this.aq + h + k);
      this.A = (this.aq + h + u);
      this.B = (this.aq + h + t);
      this.C = (this.aq + h + y);
      this.D = (this.aq + h + l);
      this.E = (this.aq + d + i + k);
      this.F = (this.aq + d + i + l);
      this.G = (this.aq + d + j + o);
      this.H = (this.aq + d + j + p);
      this.I = (this.aq + d + j + q);
      this.J = (this.aq + d + j + r);
      this.K = (this.aq + d + j + s);
      this.L = (this.aq + d + i + m);
      this.M = (this.aq + d + i + n);
      this.N = (this.aq + e + i + k);
      this.O = (this.aq + e + i + l);
      this.P = (this.aq + e + j + o);
      this.Q = (this.aq + e + j + p);
      this.R = (this.aq + e + j + q);
      this.S = (this.aq + e + j + r);
      this.T = (this.aq + e + j + s);
      this.U = (this.aq + e + i + m);
      this.V = (this.aq + e + i + n);
      this.W = (this.aq + f + i + k);
      this.X = (this.aq + f + i + l);
      this.Y = (this.aq + f + j + o);
      this.Z = (this.aq + f + j + p);
      this.aa = (this.aq + f + j + q);
      this.ab = (this.aq + f + j + r);
      this.ac = (this.aq + f + j + s);
      this.ad = (this.aq + f + i + m);
      this.ae = (this.aq + f + i + n);
      this.af = (this.aq + g + i + k);
      this.ag = (this.aq + g + i + l);
      this.ah = (this.aq + g + j + o);
      this.ai = (this.aq + g + j + p);
      this.aj = (this.aq + g + j + q);
      this.ak = (this.aq + g + j + r);
      this.al = (this.aq + g + j + s);
      this.am = (this.aq + g + i + m);
      this.an = (this.aq + g + i + n);
      this.ao = (this.aq + v + w);
      this.ap = (this.aq + v + x);
      return;
    }
  }
  
  public static int a(lbl paramlbl)
  {
    if (Build.VERSION.SDK_INT < 16) {}
    while ((paramlbl == null) || (Build.VERSION.SDK_INT < paramlbl.c) || (!a(paramlbl.jdField_a_of_type_JavaLangString, null)) || (mqp.a(paramlbl.jdField_a_of_type_JavaUtilArrayList, Integer.valueOf(Build.VERSION.SDK_INT)))) {
      return 0;
    }
    if ((paramlbl.d != 0) && (Build.VERSION.SDK_INT >= 21) && (Build.VERSION.SDK_INT >= paramlbl.d)) {
      return 2;
    }
    return 1;
  }
  
  static boolean a(String paramString, String[] paramArrayOfString)
  {
    int i2 = mue.b();
    if (mue.a(paramString) > i2) {
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
        if (mue.a(paramArrayOfString[i1]) == i2) {
          break;
        }
        i1 += 1;
      }
    }
    label51:
    return true;
  }
  
  public lnt a()
  {
    int i2 = 0;
    if (this.jdField_a_of_type_Ljz == null) {}
    for (;;)
    {
      return null;
      if (Build.VERSION.SDK_INT >= 16)
      {
        lnt locallnt = new lnt(4, true);
        try
        {
          Object localObject = a(this.jdField_a_of_type_Ljz, this.W);
          if ((localObject != null) && (Build.VERSION.SDK_INT >= localObject[0]) && (a(this.jdField_a_of_type_Ljz, this.X, this.ac)))
          {
            localObject = a(this.jdField_a_of_type_Ljz, this.ab);
            int i1;
            if (localObject != null)
            {
              i1 = 0;
              for (;;)
              {
                if (i1 >= localObject.length) {
                  break label122;
                }
                if (Build.VERSION.SDK_INT == localObject[i1]) {
                  break;
                }
                i1 += 1;
              }
            }
            label122:
            localObject = a(this.jdField_a_of_type_Ljz, this.Y);
            if (localObject != null)
            {
              i1 = 0;
              for (;;)
              {
                if (i1 >= localObject.length) {
                  break label170;
                }
                if (Build.MODEL.equalsIgnoreCase(localObject[i1])) {
                  break;
                }
                i1 += 1;
              }
            }
            label170:
            localObject = a(this.jdField_a_of_type_Ljz, this.Z);
            if (localObject != null)
            {
              i1 = 0;
              for (;;)
              {
                if (i1 >= localObject.length) {
                  break label218;
                }
                if (Build.PRODUCT.equalsIgnoreCase(localObject[i1])) {
                  break;
                }
                i1 += 1;
              }
            }
            label218:
            localObject = a(this.jdField_a_of_type_Ljz, this.aa);
            if (localObject != null)
            {
              i1 = i2;
              for (;;)
              {
                if (i1 >= localObject.length) {
                  break label266;
                }
                if (Build.PRODUCT.equalsIgnoreCase(localObject[i1])) {
                  break;
                }
                i1 += 1;
              }
            }
            label266:
            localObject = a(this.jdField_a_of_type_Ljz, this.ad);
            if ((localObject != null) && (localObject[0] > 0)) {
              locallnt.b = localObject[0];
            }
            localObject = a(this.jdField_a_of_type_Ljz, this.ae);
            if ((localObject != null) && (localObject[0] > 0)) {
              locallnt.c = localObject[0];
            }
            return locallnt;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_Ljz == null) {}
    for (;;)
    {
      return false;
      try
      {
        int[] arrayOfInt = a(this.jdField_a_of_type_Ljz, this.ao);
        if ((arrayOfInt != null) && (Build.VERSION.SDK_INT >= 21) && (Build.VERSION.SDK_INT >= arrayOfInt[0]))
        {
          arrayOfInt = a(this.jdField_a_of_type_Ljz, this.ap);
          if (arrayOfInt != null)
          {
            boolean bool = mqp.a(arrayOfInt, paramInt);
            if (bool) {
              return true;
            }
          }
        }
      }
      catch (Exception localException) {}
    }
    return false;
  }
  
  boolean a(ljz paramljz, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Int != 2) {}
    for (;;)
    {
      return true;
      int i2 = mue.b();
      if (mue.a(paramljz.a(paramString1, "")) > i2) {
        return false;
      }
      if (paramString2 != null)
      {
        paramljz = paramljz.a(paramString2);
        if (paramljz != null)
        {
          int i3 = paramljz.length;
          int i1 = 0;
          while (i1 < i3)
          {
            if (mue.a(paramljz[i1]) == i2) {
              return false;
            }
            i1 += 1;
          }
        }
      }
    }
  }
  
  int[] a(ljz paramljz, String paramString)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return null;
    }
    return paramljz.a(paramString);
  }
  
  String[] a(ljz paramljz, String paramString)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return null;
    }
    return paramljz.a(paramString);
  }
  
  public lnt b()
  {
    int i2 = 0;
    if (this.jdField_a_of_type_Ljz == null) {
      return null;
    }
    if (Build.VERSION.SDK_INT < 19)
    {
      QLog.e("CodecConfigParser", 1, "getHevcEncoderAbility failed. Build.VERSION.SDK_INT < 19.");
      return null;
    }
    lnt locallnt = new lnt(8, true);
    try
    {
      localObject = a(this.jdField_a_of_type_Ljz, this.af);
      if (localObject == null)
      {
        QLog.e("CodecConfigParser", 1, "getHevcEncoderAbility failed. minsdk == null.");
        return null;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("CodecConfigParser", 1, "getHevcEncoderAbility failed. err msg = " + localException.getMessage());
      return null;
    }
    if (Build.VERSION.SDK_INT < localObject[0])
    {
      QLog.e("CodecConfigParser", 1, "getHevcEncoderAbility failed. Build.VERSION.SDK_INT < minsdk[0]. minsdk[0] = " + localObject[0]);
      return null;
    }
    if (!a(this.jdField_a_of_type_Ljz, this.ag, this.al))
    {
      QLog.e("CodecConfigParser", 1, "getHevcEncoderAbility failed. checkQQVer failed.");
      return null;
    }
    Object localObject = a(this.jdField_a_of_type_Ljz, this.ak);
    int i1;
    if (localObject != null)
    {
      i1 = 0;
      if (i1 < localObject.length)
      {
        if (Build.VERSION.SDK_INT != localObject[i1]) {
          break label453;
        }
        QLog.e("CodecConfigParser", 1, "getHevcEncoderAbility failed. Build.VERSION.SDK_INT == disablesdk[i].");
        return null;
      }
    }
    localObject = a(this.jdField_a_of_type_Ljz, this.ah);
    if (localObject != null)
    {
      i1 = 0;
      label248:
      if (i1 < localObject.length)
      {
        if (!Build.MODEL.equalsIgnoreCase(localObject[i1])) {
          break label460;
        }
        QLog.e("CodecConfigParser", 1, "getHevcEncoderAbility failed. Build.MODEL.equalsIgnoreCase(models[i]).");
        return null;
      }
    }
    localObject = a(this.jdField_a_of_type_Ljz, this.ai);
    if (localObject != null)
    {
      i1 = 0;
      label300:
      if (i1 < localObject.length)
      {
        if (!Build.PRODUCT.equalsIgnoreCase(localObject[i1])) {
          break label467;
        }
        QLog.e("CodecConfigParser", 1, "getHevcEncoderAbility failed. Build.PRODUCT.equalsIgnoreCase(products[i]).");
        return null;
      }
    }
    localObject = a(this.jdField_a_of_type_Ljz, this.aj);
    if (localObject != null) {
      i1 = i2;
    }
    for (;;)
    {
      if (i1 < localObject.length)
      {
        if (Build.PRODUCT.equalsIgnoreCase(localObject[i1]))
        {
          QLog.e("CodecConfigParser", 1, "getHevcEncoderAbility failed. Build.PRODUCT.equalsIgnoreCase(fingerprints[i].");
          return null;
        }
      }
      else
      {
        localObject = a(this.jdField_a_of_type_Ljz, this.am);
        if ((localObject != null) && (localObject[0] > 0)) {
          localException.b = localObject[0];
        }
        localObject = a(this.jdField_a_of_type_Ljz, this.an);
        if ((localObject != null) && (localObject[0] > 0)) {
          localException.c = localObject[0];
        }
        return localException;
        label453:
        i1 += 1;
        break;
        label460:
        i1 += 1;
        break label248;
        label467:
        i1 += 1;
        break label300;
      }
      i1 += 1;
    }
  }
  
  public lnt c()
  {
    int i2 = 0;
    if (this.jdField_a_of_type_Ljz == null) {}
    for (;;)
    {
      return null;
      if (Build.VERSION.SDK_INT >= 16)
      {
        lnt locallnt = new lnt(1, true);
        try
        {
          Object localObject = a(this.jdField_a_of_type_Ljz, this.E);
          if ((localObject != null) && (Build.VERSION.SDK_INT >= localObject[0]) && (a(this.jdField_a_of_type_Ljz, this.F, this.K)))
          {
            localObject = a(this.jdField_a_of_type_Ljz, this.J);
            int i1;
            if (localObject != null)
            {
              i1 = 0;
              for (;;)
              {
                if (i1 >= localObject.length) {
                  break label122;
                }
                if (Build.VERSION.SDK_INT == localObject[i1]) {
                  break;
                }
                i1 += 1;
              }
            }
            label122:
            localObject = a(this.jdField_a_of_type_Ljz, this.G);
            if (localObject != null)
            {
              i1 = 0;
              for (;;)
              {
                if (i1 >= localObject.length) {
                  break label170;
                }
                if (Build.MODEL.equalsIgnoreCase(localObject[i1])) {
                  break;
                }
                i1 += 1;
              }
            }
            label170:
            localObject = a(this.jdField_a_of_type_Ljz, this.H);
            if (localObject != null)
            {
              i1 = 0;
              for (;;)
              {
                if (i1 >= localObject.length) {
                  break label218;
                }
                if (Build.PRODUCT.equalsIgnoreCase(localObject[i1])) {
                  break;
                }
                i1 += 1;
              }
            }
            label218:
            localObject = a(this.jdField_a_of_type_Ljz, this.I);
            if (localObject != null)
            {
              i1 = i2;
              for (;;)
              {
                if (i1 >= localObject.length) {
                  break label266;
                }
                if (Build.PRODUCT.equalsIgnoreCase(localObject[i1])) {
                  break;
                }
                i1 += 1;
              }
            }
            label266:
            localObject = a(this.jdField_a_of_type_Ljz, this.L);
            if ((localObject != null) && (localObject[0] > 0)) {
              locallnt.b = localObject[0];
            }
            localObject = a(this.jdField_a_of_type_Ljz, this.M);
            if ((localObject != null) && (localObject[0] > 0)) {
              locallnt.c = localObject[0];
            }
            return locallnt;
          }
        }
        catch (Exception localException) {}
      }
    }
    return null;
  }
  
  public lnt d()
  {
    int i2 = 0;
    if (this.jdField_a_of_type_Ljz == null) {}
    for (;;)
    {
      return null;
      if (Build.VERSION.SDK_INT >= 19)
      {
        lnt locallnt = new lnt(2, true);
        try
        {
          Object localObject = a(this.jdField_a_of_type_Ljz, this.N);
          if ((localObject != null) && (Build.VERSION.SDK_INT >= localObject[0]) && (a(this.jdField_a_of_type_Ljz, this.O, this.T)))
          {
            localObject = a(this.jdField_a_of_type_Ljz, this.S);
            int i1;
            if (localObject != null)
            {
              i1 = 0;
              for (;;)
              {
                if (i1 >= localObject.length) {
                  break label122;
                }
                if (Build.VERSION.SDK_INT == localObject[i1]) {
                  break;
                }
                i1 += 1;
              }
            }
            label122:
            localObject = a(this.jdField_a_of_type_Ljz, this.P);
            if (localObject != null)
            {
              i1 = 0;
              for (;;)
              {
                if (i1 >= localObject.length) {
                  break label170;
                }
                if (Build.MODEL.equalsIgnoreCase(localObject[i1])) {
                  break;
                }
                i1 += 1;
              }
            }
            label170:
            localObject = a(this.jdField_a_of_type_Ljz, this.Q);
            if (localObject != null)
            {
              i1 = 0;
              for (;;)
              {
                if (i1 >= localObject.length) {
                  break label218;
                }
                if (Build.PRODUCT.equalsIgnoreCase(localObject[i1])) {
                  break;
                }
                i1 += 1;
              }
            }
            label218:
            localObject = a(this.jdField_a_of_type_Ljz, this.R);
            if (localObject != null)
            {
              i1 = i2;
              for (;;)
              {
                if (i1 >= localObject.length) {
                  break label266;
                }
                if (Build.PRODUCT.equalsIgnoreCase(localObject[i1])) {
                  break;
                }
                i1 += 1;
              }
            }
            label266:
            localObject = a(this.jdField_a_of_type_Ljz, this.U);
            if ((localObject != null) && (localObject[0] > 0)) {
              locallnt.b = localObject[0];
            }
            localObject = a(this.jdField_a_of_type_Ljz, this.V);
            if ((localObject != null) && (localObject[0] > 0)) {
              locallnt.c = localObject[0];
            }
            return locallnt;
          }
        }
        catch (Exception localException) {}
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lnx
 * JD-Core Version:    0.7.0.1
 */