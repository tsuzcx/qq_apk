import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.config.Common;
import com.tencent.av.config.ConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class lno
{
  static byte A = 0;
  static byte jdField_a_of_type_Byte = 0;
  static int jdField_a_of_type_Int;
  static volatile boolean jdField_a_of_type_Boolean;
  static byte jdField_b_of_type_Byte = 0;
  static int jdField_b_of_type_Int;
  static volatile boolean jdField_b_of_type_Boolean;
  static byte jdField_c_of_type_Byte = 0;
  static int jdField_c_of_type_Int;
  static boolean jdField_c_of_type_Boolean;
  static byte d;
  static byte e;
  static byte f;
  static byte g;
  static byte h;
  static byte i;
  static byte j;
  static byte k;
  static byte l;
  static byte m;
  static byte n;
  static byte o;
  static byte p;
  static byte q;
  static byte r;
  static byte s;
  static byte t;
  static byte u;
  static byte v;
  static byte w;
  static byte x;
  static byte y;
  static byte z;
  Context jdField_a_of_type_AndroidContentContext = null;
  String jdField_a_of_type_JavaLangString = null;
  lnd jdField_a_of_type_Lnd = null;
  lnz jdField_a_of_type_Lnz = null;
  byte[] jdField_a_of_type_ArrayOfByte = null;
  
  static
  {
    jdField_d_of_type_Byte = 0;
    e = 0;
    f = 0;
    g = 0;
    h = 0;
    i = 0;
    j = 0;
    jdField_a_of_type_Int = 1;
    l = 0;
    m = 0;
    n = 0;
    o = 0;
    p = 0;
    q = 0;
    r = 0;
    s = 0;
    t = 0;
    u = 0;
    jdField_b_of_type_Int = 1;
    w = 0;
    x = 0;
    y = 1;
    jdField_c_of_type_Int = -1;
    z = 1;
  }
  
  public lno(String paramString, Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Lnz = new lnz();
    lnz.a();
    this.jdField_a_of_type_Lnd = new lnd();
  }
  
  static byte a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, byte paramByte, boolean paramBoolean4)
  {
    if (!jdField_a_of_type_Boolean) {}
    label59:
    label71:
    do
    {
      do
      {
        try
        {
          if (!jdField_a_of_type_Boolean)
          {
            a(paramContext);
            jdField_a_of_type_Boolean = true;
          }
          byte b1 = 0;
          if (!paramBoolean3) {
            break label71;
          }
          if (!paramBoolean2) {
            break label59;
          }
          if (paramBoolean1)
          {
            b1 = l;
            return b1;
          }
        }
        finally {}
        return jdField_a_of_type_Byte;
        if (paramBoolean1) {
          return m;
        }
        return jdField_b_of_type_Byte;
        if (paramBoolean4)
        {
          if (paramBoolean1) {
            return v;
          }
          return k;
        }
        if (!paramBoolean2) {
          break;
        }
        if (paramByte == 0)
        {
          if (paramBoolean1) {
            return n;
          }
          return jdField_c_of_type_Byte;
        }
        if (paramByte == 1)
        {
          if (paramBoolean1) {
            return o;
          }
          return jdField_d_of_type_Byte;
        }
        if (paramByte == 2)
        {
          if (paramBoolean1) {
            return p;
          }
          return e;
        }
      } while (paramByte != 3);
      if (paramBoolean1) {
        return q;
      }
      return f;
      if (paramByte == 0)
      {
        if (paramBoolean1) {
          return r;
        }
        return g;
      }
      if (paramByte == 1)
      {
        if (paramBoolean1) {
          return s;
        }
        return h;
      }
      if (paramByte == 2)
      {
        if (paramBoolean1) {
          return t;
        }
        return i;
      }
    } while (paramByte != 3);
    if (paramBoolean1) {
      return u;
    }
    return j;
  }
  
  public static int a(Context paramContext)
  {
    if (jdField_c_of_type_Int >= 0) {
      return jdField_c_of_type_Int;
    }
    try
    {
      paramContext = muz.a(paramContext, "ro.qq.camera.sensor");
      if (!TextUtils.isEmpty(paramContext)) {
        jdField_c_of_type_Int = Integer.parseInt(paramContext);
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        jdField_c_of_type_Int = 0;
        if (QLog.isColorLevel()) {
          QLog.d("ConfigSystemImpl", 2, "read system sensor property fail", paramContext);
        }
        if (jdField_c_of_type_Int < 0) {
          jdField_c_of_type_Int = 0;
        }
      }
    }
    finally
    {
      if (jdField_c_of_type_Int >= 0) {
        break label89;
      }
      jdField_c_of_type_Int = 0;
    }
    return jdField_c_of_type_Int;
  }
  
  public static int a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, byte paramByte, boolean paramBoolean3)
  {
    int i1 = a(paramContext, true, paramBoolean1, paramBoolean2, paramByte, paramBoolean3);
    if ((!paramBoolean3) || (jdField_b_of_type_Boolean)) {
      return i1;
    }
    return a(paramContext);
  }
  
  public static String a(Context paramContext)
  {
    paramContext = Common.a(paramContext, "VideoConfigInfo");
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystemImpl", 2, "getHWCodecTestPayload not have config file");
      }
      return "";
    }
    lnd locallnd = new lnd();
    if (locallnd.a(paramContext) != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystemImpl", 2, "getHWCodecTestPayload unPack TLV video config err");
      }
      return "";
    }
    paramContext = locallnd.a();
    if (paramContext != null) {
      return paramContext.jdField_b_of_type_JavaLangString;
    }
    return "";
  }
  
  static void a(Context paramContext)
  {
    int i1 = 0;
    Object localObject = lim.a(paramContext);
    if (!((lnc)localObject).a())
    {
      lmp locallmp = new lmp();
      jdField_b_of_type_Boolean = locallmp.b((lnc)localObject);
      if (jdField_b_of_type_Boolean)
      {
        jdField_a_of_type_Byte = locallmp.jdField_a_of_type_Byte;
        jdField_b_of_type_Byte = locallmp.jdField_b_of_type_Byte;
        jdField_c_of_type_Byte = locallmp.jdField_c_of_type_Byte;
        jdField_d_of_type_Byte = locallmp.jdField_d_of_type_Byte;
        e = locallmp.e;
        f = locallmp.f;
        g = locallmp.g;
        h = locallmp.h;
        i = locallmp.i;
        j = locallmp.j;
        k = locallmp.k;
        jdField_a_of_type_Int = locallmp.jdField_b_of_type_Int;
        if (QLog.isColorLevel()) {
          QLog.d("ConfigSystemImpl", 2, "angle_local_front: " + jdField_a_of_type_Byte + ", angle_local_background: " + jdField_b_of_type_Byte + ", angle_remote_front_0: " + jdField_c_of_type_Byte + ", angle_remote_front_90: " + jdField_d_of_type_Byte + ", angle_remote_front_180: " + e + ", angle_remote_front_270: " + f + ", angle_remote_background_0: " + g + ", angle_remote_background_90: " + h + ", angle_remote_background_180: " + i + ", angle_remote_background_270: " + j + ", angle_sensor: " + k + ", angle_mini_sdk:" + jdField_a_of_type_Int);
        }
      }
      boolean bool = locallmp.d((lnc)localObject);
      i1 = bool;
      if (bool)
      {
        l = locallmp.l;
        m = locallmp.m;
        n = locallmp.n;
        o = locallmp.o;
        p = locallmp.p;
        q = locallmp.q;
        r = locallmp.r;
        s = locallmp.s;
        t = locallmp.t;
        u = locallmp.u;
        v = locallmp.v;
        jdField_b_of_type_Int = locallmp.jdField_d_of_type_Int;
        i1 = bool;
        if (QLog.isColorLevel())
        {
          QLog.d("ConfigSystemImpl", 2, "angle_landscape_local_front: " + l + ", angle_landscape_local_back: " + m + ", angle_landscape_remote_front_0: " + n + ", angle_landscape_remote_front_90: " + o + ", angle_landscape_remote_front_180: " + p + ", angle_landscape_remote_front_270: " + q + ", angle_landscape_remote_back_0: " + r + ", angle_landscape_remote_back_90: " + s + ", angle_landscape_remote_back_180: " + t + ", angle_landscape_remote_back_270: " + u + ", angle_landscape_sensor: " + v + ", angle_landscape_mini_sdk:" + jdField_b_of_type_Int);
          i1 = bool;
        }
      }
    }
    if (jdField_b_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystemImpl", 2, "using new camera angle config");
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.d("ConfigSystemImpl", 2, "using old camera angle config");
            }
            if ((i1 != 0) && (QLog.isColorLevel())) {
              QLog.d("ConfigSystemImpl", 2, "using new camera angle landscape config");
            }
            paramContext = Common.a(paramContext, "VideoConfigInfo");
          } while (paramContext == null);
          localObject = new lnd();
        } while (((lnd)localObject).a(paramContext) != 0);
        paramContext = ((lnd)localObject).a();
      } while (paramContext == null);
      jdField_a_of_type_Byte = paramContext.jdField_a_of_type_Lng.jdField_a_of_type_Byte;
      jdField_b_of_type_Byte = paramContext.jdField_a_of_type_Lng.jdField_a_of_type_Byte;
      jdField_c_of_type_Byte = paramContext.jdField_a_of_type_Lng.jdField_c_of_type_Byte;
      jdField_d_of_type_Byte = paramContext.jdField_a_of_type_Lng.e;
      e = paramContext.jdField_a_of_type_Lng.g;
      f = paramContext.jdField_a_of_type_Lng.i;
      g = paramContext.jdField_a_of_type_Lng.jdField_d_of_type_Byte;
      h = paramContext.jdField_a_of_type_Lng.f;
      i = paramContext.jdField_a_of_type_Lng.h;
      j = paramContext.jdField_a_of_type_Lng.j;
      w = paramContext.jdField_a_of_type_Lng.k;
      x = paramContext.jdField_a_of_type_Lng.l;
    } while (!QLog.isColorLevel());
    QLog.d("ConfigSystemImpl", 2, "angle_local_front: " + jdField_a_of_type_Byte + ", angle_local_background: " + jdField_b_of_type_Byte + ", angle_remote_front_0: " + jdField_c_of_type_Byte + ", angle_remote_front_90: " + jdField_d_of_type_Byte + ", angle_remote_front_180: " + e + ", angle_remote_front_270: " + f + ", angle_remote_background_0: " + g + ", angle_remote_background_90: " + h + ", angle_remote_background_180: " + i + ", angle_remote_background_270: " + j);
  }
  
  static void a(Context paramContext, byte[] paramArrayOfByte)
  {
    Object localObject1;
    boolean bool;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("updateAVSwitchTypeTLV, msg[");
      if (paramArrayOfByte != null)
      {
        bool = true;
        QLog.w("ConfigSystemImpl", 1, bool + "]");
      }
    }
    else
    {
      localObject2 = null;
      localObject1 = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        localObject1 = Common.a(paramContext, "VideoConfigInfo");
      }
      if (localObject1 != null) {
        break label191;
      }
      paramContext = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("ConfigSystemImpl", 2, "updateAVSwitchTypeTLV, not config");
        paramContext = localObject2;
      }
      label92:
      if (paramContext == null) {
        break label277;
      }
      y = paramContext.jdField_a_of_type_Byte;
      z = paramContext.h;
      A = paramContext.i;
      jdField_c_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.w("ConfigSystemImpl", 1, "updateAVSwitchTypeTLV, dAudio_enable[" + y + "], dSmallScrren_enable[" + z + "], dAudioHowlingEnable[" + A + "]");
      }
    }
    label191:
    while (!QLog.isColorLevel())
    {
      return;
      bool = false;
      break;
      paramContext = new lnd();
      int i1 = paramContext.a((byte[])localObject1);
      if (i1 != 0)
      {
        paramContext = localObject2;
        if (!QLog.isColorLevel()) {
          break label92;
        }
        QLog.w("ConfigSystemImpl", 1, "updateAVSwitchTypeTLV err, ret[" + i1 + "]");
        paramContext = localObject2;
        break label92;
      }
      paramArrayOfByte = paramContext.a();
      paramContext = localObject2;
      if (paramArrayOfByte == null) {
        break label92;
      }
      paramContext = paramArrayOfByte.jdField_a_of_type_Lnk;
      break label92;
    }
    label277:
    QLog.d("ConfigSystemImpl", 2, "updateAVSwitchTypeTLV info == null");
  }
  
  public static boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfigSystemImpl", 2, "isSupportSmallScreen --> " + z);
    }
    return z == 1;
  }
  
  public static boolean a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfigSystemImpl", 2, "isDAudioEnable:" + y);
    }
    return y == 1;
  }
  
  public static boolean a(String paramString, Context paramContext, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfigSystemImpl", 2, "isNeedStartVideoProcess");
    }
    if (paramArrayOfByte != null)
    {
      paramString = new lno(paramString, paramContext);
      paramString.a(paramArrayOfByte);
      paramString.a();
      return paramString.b();
    }
    return false;
  }
  
  public static byte[] a(long paramLong, String paramString, Context paramContext)
  {
    lyf.a().a("request", -1);
    return new lno(paramString, paramContext).a(paramLong);
  }
  
  public static int[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      lnd locallnd;
      do
      {
        return null;
        locallnd = new lnd();
        if (locallnd.a(paramArrayOfByte) == 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ConfigSystemImpl", 2, "unPack PB err");
      return null;
      paramArrayOfByte = locallnd.a();
    } while ((paramArrayOfByte == null) || (!paramArrayOfByte.jdField_a_of_type_Lni.jdField_a_of_type_Boolean));
    return new int[] { paramArrayOfByte.jdField_a_of_type_Lni.jdField_a_of_type_Int, paramArrayOfByte.jdField_a_of_type_Lni.jdField_b_of_type_Int, paramArrayOfByte.jdField_a_of_type_Lni.jdField_c_of_type_Int, paramArrayOfByte.jdField_a_of_type_Lni.jdField_d_of_type_Int, paramArrayOfByte.jdField_a_of_type_Lni.jdField_e_of_type_Int, paramArrayOfByte.jdField_a_of_type_Lni.f, paramArrayOfByte.jdField_a_of_type_Lni.g, paramArrayOfByte.jdField_a_of_type_Lni.h, paramArrayOfByte.jdField_a_of_type_Lni.i, paramArrayOfByte.jdField_a_of_type_Lni.j, paramArrayOfByte.jdField_a_of_type_Lni.k, paramArrayOfByte.jdField_a_of_type_Lni.l };
  }
  
  public static int b(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, byte paramByte, boolean paramBoolean3)
  {
    int i1 = a(paramContext, false, paramBoolean1, paramBoolean2, paramByte, paramBoolean3);
    if (paramBoolean3)
    {
      if (!jdField_b_of_type_Boolean) {
        break label41;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystemImpl", 2, "server config enabled");
      }
    }
    return i1;
    label41:
    return a(paramContext);
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool = true;
    if (!jdField_c_of_type_Boolean) {
      a(paramContext, null);
    }
    if (QLog.isColorLevel()) {
      QLog.w("ConfigSystemImpl", 1, "isAudioHowlingEnable[" + A + "]");
    }
    if (A == 1) {
      bool = false;
    }
    return bool;
  }
  
  public String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystemImpl", 2, "getSharpConfigPayload not have config file");
      }
      return "";
    }
    lnd locallnd = new lnd();
    if (locallnd.a(paramArrayOfByte) != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystemImpl", 2, "getSharpConfigPayload unPack TLV video config err");
      }
      return "";
    }
    paramArrayOfByte = locallnd.a();
    if (paramArrayOfByte != null)
    {
      QLog.w("ConfigSystemImpl", 1, "getSharpConfigPayload, Content[\n" + paramArrayOfByte.jdField_a_of_type_JavaLangString + "\n], test[\n" + paramArrayOfByte.jdField_b_of_type_JavaLangString + "\n]");
      return paramArrayOfByte.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public void a()
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("WriteConfigInfoToFile begin, configMsg[");
      if (this.jdField_a_of_type_ArrayOfByte != null)
      {
        localObject1 = Integer.valueOf(this.jdField_a_of_type_ArrayOfByte.length);
        QLog.w("ConfigSystemImpl", 1, localObject1 + "]");
      }
    }
    else if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length > 0))
    {
      Common.a(this.jdField_a_of_type_AndroidContentContext, "VideoConfigInfo", this.jdField_a_of_type_ArrayOfByte);
      y = 1;
      a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ArrayOfByte);
      localObject1 = a(this.jdField_a_of_type_ArrayOfByte);
      if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
        break label355;
      }
      localObject2 = ((String)localObject1).substring(0, 1);
      if (QLog.isColorLevel()) {
        QLog.w("ConfigSystemImpl", 1, "WriteConfigInfoToFile, sharpConfigType[" + (String)localObject2 + "]");
      }
      if (!((String)localObject2).equals("0")) {
        break label229;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ConfigSystemImpl", 2, "WriteConfigInfoToFile, SHARP_CONFIG_TYPE_CLEAR");
      }
      Common.a(this.jdField_a_of_type_AndroidContentContext, Common.jdField_b_of_type_JavaLangString, "".getBytes());
      localObject1 = new Intent("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE");
      this.jdField_a_of_type_AndroidContentContext.sendBroadcast((Intent)localObject1);
    }
    label229:
    do
    {
      return;
      localObject1 = null;
      break;
      if (((String)localObject2).equals("1"))
      {
        localObject1 = ((String)localObject1).substring(2);
        if (QLog.isColorLevel()) {
          QLog.w("ConfigSystemImpl", 1, "WriteConfigInfoToFile, FileName[" + Common.jdField_b_of_type_JavaLangString + "], payload[\n" + (String)localObject1 + "\n]");
        }
        Common.a(this.jdField_a_of_type_AndroidContentContext, Common.jdField_b_of_type_JavaLangString, ((String)localObject1).getBytes());
        localObject1 = new Intent("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE");
        this.jdField_a_of_type_AndroidContentContext.sendBroadcast((Intent)localObject1);
        return;
      }
    } while ((!((String)localObject2).equals("2")) || (!QLog.isColorLevel()));
    QLog.d("ConfigSystemImpl", 2, "WriteConfigInfoToFile SharpConfigPayload url");
    return;
    label355:
    if (QLog.isColorLevel()) {
      QLog.d("ConfigSystemImpl", 2, "WriteConfigInfoToFile, sharpConfigPayload为空");
    }
    Common.a(this.jdField_a_of_type_AndroidContentContext, Common.jdField_b_of_type_JavaLangString, "".getBytes());
    Object localObject1 = new Intent("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE");
    this.jdField_a_of_type_AndroidContentContext.sendBroadcast((Intent)localObject1);
  }
  
  void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public byte[] a(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_Lnd;
    localObject.getClass();
    localObject = new lnn((lnd)localObject);
    ((lnn)localObject).jdField_a_of_type_Int = 201;
    ((lnn)localObject).jdField_b_of_type_Int = this.jdField_a_of_type_Lnz.d();
    ((lnn)localObject).jdField_c_of_type_Int = lnz.f();
    ((lnn)localObject).jdField_d_of_type_Int = lnz.e();
    ((lnn)localObject).jdField_e_of_type_Int = ((int)(lnz.d() / 1000L));
    ((lnn)localObject).f = 0;
    ((lnn)localObject).g = 0;
    ((lnn)localObject).h = 0;
    ((lnn)localObject).i = this.jdField_a_of_type_Lnz.g;
    ((lnn)localObject).j = this.jdField_a_of_type_Lnz.h;
    ((lnn)localObject).k = 22;
    ((lnn)localObject).l = ConfigInfo.getSharpConfigVersionFromFile(this.jdField_a_of_type_AndroidContentContext);
    ((lnn)localObject).m = 37;
    ((lnn)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    ((lnn)localObject).jdField_b_of_type_JavaLangString = ("android_" + Build.VERSION.RELEASE);
    ((lnn)localObject).jdField_c_of_type_JavaLangString = lnz.c();
    ((lnn)localObject).jdField_d_of_type_JavaLangString = Build.VERSION.INCREMENTAL;
    ((lnn)localObject).jdField_e_of_type_JavaLangString = Common.a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_Lnd.a(paramLong, (lnn)localObject);
    return this.jdField_a_of_type_Lnd.a();
  }
  
  public boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lno
 * JD-Core Version:    0.7.0.1
 */