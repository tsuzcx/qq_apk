import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;

public class lox
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
  private lkz jdField_a_of_type_Lkz;
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
  
  public lox(lkz paramlkz)
  {
    if ((paramlkz != null) && (!paramlkz.a()) && (paramlkz.a().contains(jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_Int = 2;
    }
    this.jdField_a_of_type_Lkz = paramlkz;
    if (this.jdField_a_of_type_Int == 2) {}
    for (paramlkz = c;; paramlkz = b)
    {
      this.aq = paramlkz;
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
  
  public static int a(lco paramlco)
  {
    if (Build.VERSION.SDK_INT < 16) {}
    while ((paramlco == null) || (Build.VERSION.SDK_INT < paramlco.c) || (!a(paramlco.jdField_a_of_type_JavaLangString, null)) || (mqp.a(paramlco.jdField_a_of_type_JavaUtilArrayList, Integer.valueOf(Build.VERSION.SDK_INT)))) {
      return 0;
    }
    if ((paramlco.d != 0) && (Build.VERSION.SDK_INT >= 21) && (Build.VERSION.SDK_INT >= paramlco.d)) {
      return 2;
    }
    return 1;
  }
  
  static boolean a(String paramString, String[] paramArrayOfString)
  {
    int i2 = muc.b();
    if (muc.a(paramString) > i2) {
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
        if (muc.a(paramArrayOfString[i1]) == i2) {
          break;
        }
        i1 += 1;
      }
    }
    label51:
    return true;
  }
  
  public lot a()
  {
    int i2 = 0;
    if (this.jdField_a_of_type_Lkz == null) {}
    for (;;)
    {
      return null;
      if (Build.VERSION.SDK_INT >= 16)
      {
        lot locallot = new lot(4, true);
        try
        {
          Object localObject = a(this.jdField_a_of_type_Lkz, this.W);
          if ((localObject != null) && (Build.VERSION.SDK_INT >= localObject[0]) && (a(this.jdField_a_of_type_Lkz, this.X, this.ac)))
          {
            localObject = a(this.jdField_a_of_type_Lkz, this.ab);
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
            localObject = a(this.jdField_a_of_type_Lkz, this.Y);
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
            localObject = a(this.jdField_a_of_type_Lkz, this.Z);
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
            localObject = a(this.jdField_a_of_type_Lkz, this.aa);
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
            localObject = a(this.jdField_a_of_type_Lkz, this.ad);
            if ((localObject != null) && (localObject[0] > 0)) {
              locallot.b = localObject[0];
            }
            localObject = a(this.jdField_a_of_type_Lkz, this.ae);
            if ((localObject != null) && (localObject[0] > 0)) {
              locallot.c = localObject[0];
            }
            return locallot;
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
    if (this.jdField_a_of_type_Lkz == null) {}
    for (;;)
    {
      return false;
      try
      {
        int[] arrayOfInt = a(this.jdField_a_of_type_Lkz, this.ao);
        if ((arrayOfInt != null) && (Build.VERSION.SDK_INT >= 21) && (Build.VERSION.SDK_INT >= arrayOfInt[0]))
        {
          arrayOfInt = a(this.jdField_a_of_type_Lkz, this.ap);
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
  
  boolean a(lkz paramlkz, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Int != 2) {}
    for (;;)
    {
      return true;
      int i2 = muc.b();
      if (muc.a(paramlkz.a(paramString1, "")) > i2) {
        return false;
      }
      if (paramString2 != null)
      {
        paramlkz = paramlkz.a(paramString2);
        if (paramlkz != null)
        {
          int i3 = paramlkz.length;
          int i1 = 0;
          while (i1 < i3)
          {
            if (muc.a(paramlkz[i1]) == i2) {
              return false;
            }
            i1 += 1;
          }
        }
      }
    }
  }
  
  int[] a(lkz paramlkz, String paramString)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return null;
    }
    return paramlkz.a(paramString);
  }
  
  String[] a(lkz paramlkz, String paramString)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return null;
    }
    return paramlkz.a(paramString);
  }
  
  public lot b()
  {
    int i2 = 0;
    if (this.jdField_a_of_type_Lkz == null) {
      return null;
    }
    if (Build.VERSION.SDK_INT < 19)
    {
      QLog.e("CodecConfigParser", 1, "getHevcEncoderAbility failed. Build.VERSION.SDK_INT < 19.");
      return null;
    }
    lot locallot = new lot(8, true);
    try
    {
      localObject = a(this.jdField_a_of_type_Lkz, this.af);
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
    if (!a(this.jdField_a_of_type_Lkz, this.ag, this.al))
    {
      QLog.e("CodecConfigParser", 1, "getHevcEncoderAbility failed. checkQQVer failed.");
      return null;
    }
    Object localObject = a(this.jdField_a_of_type_Lkz, this.ak);
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
    localObject = a(this.jdField_a_of_type_Lkz, this.ah);
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
    localObject = a(this.jdField_a_of_type_Lkz, this.ai);
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
    localObject = a(this.jdField_a_of_type_Lkz, this.aj);
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
        localObject = a(this.jdField_a_of_type_Lkz, this.am);
        if ((localObject != null) && (localObject[0] > 0)) {
          localException.b = localObject[0];
        }
        localObject = a(this.jdField_a_of_type_Lkz, this.an);
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
  
  public lot c()
  {
    int i2 = 0;
    if (this.jdField_a_of_type_Lkz == null) {}
    for (;;)
    {
      return null;
      if (Build.VERSION.SDK_INT >= 16)
      {
        lot locallot = new lot(1, true);
        try
        {
          Object localObject = a(this.jdField_a_of_type_Lkz, this.E);
          if ((localObject != null) && (Build.VERSION.SDK_INT >= localObject[0]) && (a(this.jdField_a_of_type_Lkz, this.F, this.K)))
          {
            localObject = a(this.jdField_a_of_type_Lkz, this.J);
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
            localObject = a(this.jdField_a_of_type_Lkz, this.G);
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
            localObject = a(this.jdField_a_of_type_Lkz, this.H);
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
            localObject = a(this.jdField_a_of_type_Lkz, this.I);
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
            localObject = a(this.jdField_a_of_type_Lkz, this.L);
            if ((localObject != null) && (localObject[0] > 0)) {
              locallot.b = localObject[0];
            }
            localObject = a(this.jdField_a_of_type_Lkz, this.M);
            if ((localObject != null) && (localObject[0] > 0)) {
              locallot.c = localObject[0];
            }
            return locallot;
          }
        }
        catch (Exception localException) {}
      }
    }
    return null;
  }
  
  public lot d()
  {
    int i2 = 0;
    if (this.jdField_a_of_type_Lkz == null) {}
    for (;;)
    {
      return null;
      if (Build.VERSION.SDK_INT >= 19)
      {
        lot locallot = new lot(2, true);
        try
        {
          Object localObject = a(this.jdField_a_of_type_Lkz, this.N);
          if ((localObject != null) && (Build.VERSION.SDK_INT >= localObject[0]) && (a(this.jdField_a_of_type_Lkz, this.O, this.T)))
          {
            localObject = a(this.jdField_a_of_type_Lkz, this.S);
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
            localObject = a(this.jdField_a_of_type_Lkz, this.P);
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
            localObject = a(this.jdField_a_of_type_Lkz, this.Q);
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
            localObject = a(this.jdField_a_of_type_Lkz, this.R);
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
            localObject = a(this.jdField_a_of_type_Lkz, this.U);
            if ((localObject != null) && (localObject[0] > 0)) {
              locallot.b = localObject[0];
            }
            localObject = a(this.jdField_a_of_type_Lkz, this.V);
            if ((localObject != null) && (localObject[0] > 0)) {
              locallot.c = localObject[0];
            }
            return locallot;
          }
        }
        catch (Exception localException) {}
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lox
 * JD-Core Version:    0.7.0.1
 */