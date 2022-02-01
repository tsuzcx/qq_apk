import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.av.mediacodec.DeviceCheck;
import com.tencent.av.mediacodec.NativeCodec;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"NewApi"})
public class lof
{
  public static int a;
  public static String a;
  protected static Method a;
  protected static boolean a;
  public static final int[] a;
  public static int b;
  public static String b;
  protected static Method b;
  protected static boolean b;
  public static int c;
  public static String c;
  protected static Method c;
  public static boolean c;
  public static int d;
  protected static Method d;
  protected MediaCodec a;
  protected MediaFormat a;
  protected ByteBuffer[] a;
  protected MediaFormat b;
  protected ByteBuffer[] b;
  final String d;
  public boolean d;
  protected int e = jdField_b_of_type_Int;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_a_of_type_JavaLangString = "video/avc";
    jdField_b_of_type_JavaLangString = "video/hevc";
    jdField_c_of_type_JavaLangString = "request-sync";
    jdField_b_of_type_Boolean = true;
    jdField_c_of_type_Int = 33000;
    jdField_a_of_type_ArrayOfInt = new int[] { 1, 2, 4, 8 };
  }
  
  @Deprecated
  public lof()
  {
    this("unknown");
  }
  
  public lof(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = (paramString + "_AndroidCodec");
    a(this.jdField_d_of_type_JavaLangString);
    if ((Build.VERSION.SDK_INT >= 19) && (jdField_d_of_type_JavaLangReflectMethod == null)) {}
    try
    {
      jdField_d_of_type_JavaLangReflectMethod = MediaCodec.class.getMethod("setParameters", new Class[] { Bundle.class });
      return;
    }
    catch (NoSuchMethodException paramString)
    {
      jdField_d_of_type_JavaLangReflectMethod = null;
    }
  }
  
  public static int a()
  {
    return jdField_d_of_type_Int;
  }
  
  public static MediaCodecInfo.CodecCapabilities a(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    Object localObject = null;
    try
    {
      paramMediaCodecInfo = paramMediaCodecInfo.getCapabilitiesForType(paramString);
      return paramMediaCodecInfo;
    }
    catch (Exception localException)
    {
      do
      {
        paramMediaCodecInfo = localObject;
      } while (!QLog.isDevelopLevel());
      QLog.w("AndroidCodec", 1, "getCodecCapabilities, Exception, mime[" + paramString + "]", localException);
    }
    return null;
  }
  
  public static MediaCodecInfo a(String paramString)
  {
    try
    {
      int j = MediaCodecList.getCodecCount();
      int i = 0;
      while (i < j)
      {
        MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
        boolean bool = localMediaCodecInfo.getName().equalsIgnoreCase(paramString);
        if (bool) {
          return localMediaCodecInfo;
        }
        i += 1;
      }
      return null;
    }
    catch (Throwable paramString) {}
  }
  
  public static ArrayList<loh> a(String paramString, Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return null;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      a(paramString);
      if (!jdField_b_of_type_Boolean)
      {
        QLog.w(paramString, 1, "checkSupportHWCodecAbility, 不是API21");
        return null;
      }
    }
    if (!new File(paramContext.getApplicationInfo().nativeLibraryDir + "/libhwcodec.so").exists())
    {
      QLog.w(paramString, 1, "checkSupportHWCodecAbility,  libhwcodec不存在");
      return null;
    }
    Object localObject2;
    if (!jdField_a_of_type_Boolean)
    {
      b();
      if (jdField_a_of_type_Boolean)
      {
        localObject1 = "PRODUCT=" + Build.PRODUCT.toLowerCase() + ";";
        localObject1 = (String)localObject1 + "MODEL=" + Build.MODEL.toLowerCase() + ";";
        localObject1 = (String)localObject1 + "SDK=" + Build.VERSION.SDK_INT + ";";
        localObject1 = (String)localObject1 + "FINGERPRINT=" + Build.FINGERPRINT.toLowerCase() + ";";
        localObject2 = (String)localObject1 + "MANUFACTURER=" + Build.MANUFACTURER.toLowerCase() + ";";
        localObject1 = paramContext.getApplicationInfo();
        localObject2 = (String)localObject2 + "DATADIR=" + ((ApplicationInfo)localObject1).dataDir + ";";
        if (Build.VERSION.SDK_INT < 9) {
          break label358;
        }
      }
    }
    label358:
    for (Object localObject1 = (String)localObject2 + "LIBDIR=" + ((ApplicationInfo)localObject1).nativeLibraryDir + ";";; localObject1 = (String)localObject2 + "LIBDIR=" + ((ApplicationInfo)localObject1).dataDir + "/lib;")
    {
      NativeCodec.set_device_infos((String)localObject1);
      if (jdField_a_of_type_Boolean) {
        break;
      }
      QLog.w(paramString, 1, "checkSupportHWCodecAbility, lib失败");
      return null;
    }
    localObject1 = new ArrayList();
    if (AudioHelper.f()) {
      QLog.e(paramString, 1, "checkSupportHWCodecAbility start");
    }
    if (DeviceCheck.b()) {
      if (DeviceCheck.e())
      {
        ((ArrayList)localObject1).add(new loh(1, true));
        if (AudioHelper.f()) {
          QLog.w(paramString, 1, "checkSupportHWCodecAbility, 白名单, 支持H264解码");
        }
        if (!DeviceCheck.a()) {
          break label770;
        }
        if (!DeviceCheck.f()) {
          break label759;
        }
        ((ArrayList)localObject1).add(new loh(2, true));
        if (AudioHelper.f()) {
          QLog.w(paramString, 1, "checkSupportHWCodecAbility, 白名单, 支持H264编码");
        }
      }
    }
    for (;;)
    {
      paramContext = new ArrayList();
      a(paramString, paramContext);
      paramString = a((ArrayList)localObject1, paramContext);
      jdField_c_of_type_Boolean = a(paramString);
      return paramString;
      QLog.w(paramString, 1, "checkSupportHWCodecAbility, 白名单, 不支持H264解码");
      break;
      localObject2 = new lol(lfo.a(paramContext));
      loh localloh = ((lol)localObject2).c();
      if ((localloh != null) && (localloh.jdField_a_of_type_Boolean)) {
        if (DeviceCheck.e())
        {
          ((ArrayList)localObject1).add(localloh);
          if (AudioHelper.f()) {
            QLog.w(paramString, 1, "checkSupportHWCodecAbility, 支持H264解码. maxW = " + localloh.jdField_b_of_type_Int + ", maxH = " + localloh.jdField_c_of_type_Int);
          }
        }
      }
      for (;;)
      {
        localObject2 = ((lol)localObject2).a();
        if ((localObject2 == null) || (!((loh)localObject2).jdField_a_of_type_Boolean)) {
          break label742;
        }
        if (!DeviceCheck.c()) {
          break label731;
        }
        ((ArrayList)localObject1).add(localObject2);
        if (!AudioHelper.f()) {
          break;
        }
        QLog.w(paramString, 1, "checkSupportHWCodecAbility, 支持H265解码. maxW = " + ((loh)localObject2).jdField_b_of_type_Int + ", maxH = " + ((loh)localObject2).jdField_c_of_type_Int);
        break;
        QLog.w(paramString, 1, "checkSupportHWCodecAbility, 不支持H264解码");
        continue;
        if (QLog.isDevelopLevel()) {
          QLog.w(paramString, 1, "checkSupportHWCodecAbility, 无H264解码配置");
        }
      }
      label731:
      QLog.w(paramString, 1, "checkSupportHWCodecAbility, 不支持H265解码");
      break;
      label742:
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.w(paramString, 1, "checkSupportHWCodecAbility, 无H265解码配置");
      break;
      label759:
      QLog.w(paramString, 1, "checkSupportHWCodecAbility, 白名单, 不支持H264编码");
      continue;
      label770:
      paramContext = new lol(lfo.a(paramContext));
      localObject2 = paramContext.d();
      if ((localObject2 != null) && (((loh)localObject2).jdField_a_of_type_Boolean)) {
        if (DeviceCheck.f())
        {
          ((ArrayList)localObject1).add(localObject2);
          if (AudioHelper.f()) {
            QLog.w(paramString, 1, "checkSupportHWCodecAbility, 支持H264编码. maxW = " + ((loh)localObject2).jdField_b_of_type_Int + ", maxH = " + ((loh)localObject2).jdField_c_of_type_Int);
          }
        }
      }
      for (;;)
      {
        paramContext = paramContext.b();
        if ((paramContext == null) || (!paramContext.jdField_a_of_type_Boolean)) {
          break label974;
        }
        if (!DeviceCheck.d()) {
          break label963;
        }
        ((ArrayList)localObject1).add(paramContext);
        if (!AudioHelper.f()) {
          break;
        }
        QLog.w(paramString, 1, "checkSupportHWCodecAbility, 支持H265编码. maxW = " + paramContext.jdField_b_of_type_Int + ", maxH = " + paramContext.jdField_c_of_type_Int);
        break;
        QLog.w(paramString, 1, "checkSupportHWCodecAbility, 不支持H264编码");
        continue;
        if (QLog.isDevelopLevel()) {
          QLog.w(paramString, 1, "checkSupportHWCodecAbility, 无H264编码配置");
        }
      }
      label963:
      QLog.w(paramString, 1, "checkSupportHWCodecAbility, 不支持H265编码");
      continue;
      label974:
      if (QLog.isDevelopLevel()) {
        QLog.w(paramString, 1, "checkSupportHWCodecAbility, 无H265编码配置");
      }
    }
  }
  
  private static ArrayList<loh> a(ArrayList<loh> paramArrayList1, ArrayList<loh> paramArrayList2)
  {
    if (paramArrayList1.isEmpty()) {
      return paramArrayList2;
    }
    if (paramArrayList2.isEmpty()) {
      return paramArrayList1;
    }
    ArrayList localArrayList = new ArrayList(4);
    int i = 0;
    if (i < 4)
    {
      loh localloh = a(jdField_a_of_type_ArrayOfInt[i], paramArrayList1);
      if (localloh != null) {
        localArrayList.add(localloh);
      }
      for (;;)
      {
        i += 1;
        break;
        localloh = a((int)lkx.a[i], paramArrayList2);
        if (localloh != null) {
          localArrayList.add(localloh);
        }
      }
    }
    return localArrayList;
  }
  
  @SuppressLint({"NewApi"})
  public static List<MediaCodecInfo> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        int k = MediaCodecList.getCodecCount();
        i = 0;
        if (i < k)
        {
          MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
          if ((!localMediaCodecInfo.isEncoder()) && (!localMediaCodecInfo.getName().contains(".sw.")) && (!localMediaCodecInfo.getName().contains(".SW.")) && (!localMediaCodecInfo.getName().contains("google")) && (!localMediaCodecInfo.getName().contains("Google")) && (!localMediaCodecInfo.getName().contains("GOOGLE")))
          {
            String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
            int j = 0;
            if (j < arrayOfString.length)
            {
              if (arrayOfString[j].equalsIgnoreCase(paramString)) {
                localArrayList.add(localMediaCodecInfo);
              }
              j += 1;
              continue;
            }
          }
        }
        else
        {
          return localArrayList;
        }
      }
      catch (Throwable paramString) {}
      i += 1;
    }
  }
  
  private static loh a(int paramInt, ArrayList<loh> paramArrayList)
  {
    if (paramArrayList.isEmpty()) {
      return null;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      loh localloh = (loh)paramArrayList.next();
      if ((paramInt == localloh.jdField_a_of_type_Int) && (localloh.jdField_a_of_type_Boolean)) {
        return localloh;
      }
    }
    return null;
  }
  
  protected static void a()
  {
    a("unknown");
  }
  
  protected static void a(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    try
    {
      if (jdField_a_of_type_JavaLangReflectMethod == null) {
        jdField_a_of_type_JavaLangReflectMethod = MediaCodec.class.getMethod("getInputBuffer", new Class[] { Integer.TYPE });
      }
      if (jdField_b_of_type_JavaLangReflectMethod == null) {
        jdField_b_of_type_JavaLangReflectMethod = MediaCodec.class.getMethod("getOutputBuffer", new Class[] { Integer.TYPE });
      }
      if (jdField_c_of_type_JavaLangReflectMethod == null) {
        jdField_c_of_type_JavaLangReflectMethod = MediaCodec.class.getMethod("getOutputFormat", new Class[] { Integer.TYPE });
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        jdField_a_of_type_JavaLangReflectMethod = null;
        jdField_b_of_type_JavaLangReflectMethod = null;
        jdField_c_of_type_JavaLangReflectMethod = null;
        jdField_b_of_type_Boolean = false;
      }
    }
    if ((QLog.isDevelopLevel()) || (!jdField_b_of_type_Boolean)) {
      QLog.w(paramString, 1, "invoke21Apis, fInvokeAPILevel21[" + jdField_b_of_type_Boolean + "]");
    }
  }
  
  public static void a(String paramString, ArrayList<loh> paramArrayList)
  {
    Object localObject = lfq.a().a();
    if ((localObject == null) || (((lkx)localObject).a().isEmpty()) || (Build.VERSION.SDK_INT < 19)) {}
    for (;;)
    {
      return;
      localObject = ((lkx)localObject).a().iterator();
      while (((Iterator)localObject).hasNext())
      {
        lky locallky = (lky)((Iterator)localObject).next();
        if (locallky.jdField_a_of_type_Boolean)
        {
          loh localloh = new loh();
          if (locallky.jdField_a_of_type_Long == 1L) {
            if (DeviceCheck.f())
            {
              localloh.jdField_a_of_type_Int = 2;
              if (QLog.isDevelopLevel()) {
                QLog.w(paramString, 1, "checkSupportHWCodecAbility getChipHWCodecAbility, 支持H264硬编");
              }
            }
          }
          label331:
          do
          {
            for (;;)
            {
              localloh.jdField_a_of_type_Boolean = true;
              localloh.jdField_c_of_type_Int = locallky.jdField_b_of_type_Int;
              localloh.jdField_b_of_type_Int = locallky.jdField_a_of_type_Int;
              paramArrayList.add(localloh);
              break;
              if (!QLog.isDevelopLevel()) {
                break;
              }
              QLog.w(paramString, 1, "checkSupportHWCodecAbility getChipHWCodecAbility, 不支持H264硬编");
              break;
              if (locallky.jdField_a_of_type_Long == 4L)
              {
                if (DeviceCheck.d())
                {
                  localloh.jdField_a_of_type_Int = 8;
                  if (!QLog.isDevelopLevel()) {
                    continue;
                  }
                  QLog.w(paramString, 1, "checkSupportHWCodecAbility getChipHWCodecAbility, 支持H265硬编");
                  continue;
                }
                if (!QLog.isDevelopLevel()) {
                  break;
                }
                QLog.w(paramString, 1, "checkSupportHWCodecAbility getChipHWCodecAbility, 不支持H265硬编");
                break;
              }
              if (locallky.jdField_a_of_type_Long == 2L)
              {
                if (DeviceCheck.e())
                {
                  localloh.jdField_a_of_type_Int = 1;
                  if (!QLog.isDevelopLevel()) {
                    continue;
                  }
                  QLog.w(paramString, 1, "checkSupportHWCodecAbility getChipHWCodecAbility, 支持H264硬解");
                  continue;
                }
                if (!QLog.isDevelopLevel()) {
                  break;
                }
                QLog.w(paramString, 1, "checkSupportHWCodecAbility getChipHWCodecAbility, 不支持H264硬解");
                break;
              }
              if (locallky.jdField_a_of_type_Long != 8L) {
                break label331;
              }
              if (DeviceCheck.c())
              {
                localloh.jdField_a_of_type_Int = 4;
                if (QLog.isDevelopLevel()) {
                  QLog.w(paramString, 1, "checkSupportHWCodecAbility getChipHWCodecAbility, 支持H265硬解");
                }
              }
              else if (QLog.isDevelopLevel())
              {
                QLog.w(paramString, 1, "checkSupportHWCodecAbility getChipHWCodecAbility, 不支持H265硬解");
              }
            }
          } while (locallky.jdField_a_of_type_Long != 0L);
        }
      }
    }
  }
  
  private static boolean a(ArrayList<loh> paramArrayList)
  {
    boolean bool2 = false;
    int m;
    int k;
    int j;
    int i;
    int i3;
    int i2;
    int i1;
    int n;
    loh localloh;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      m = 0;
      k = 0;
      j = 0;
      i = 0;
      i3 = m;
      i2 = k;
      i1 = j;
      n = i;
      if (!paramArrayList.hasNext()) {
        break label327;
      }
      localloh = (loh)paramArrayList.next();
      if ((localloh.jdField_a_of_type_Int == 1) && (localloh.jdField_a_of_type_Boolean) && (localloh.jdField_b_of_type_Int >= 1920) && (localloh.jdField_c_of_type_Int >= 1080))
      {
        n = m;
        j = k;
        k = 1;
        m = i;
        i = n;
      }
    }
    for (;;)
    {
      n = m;
      i1 = k;
      m = i;
      k = j;
      j = i1;
      i = n;
      break;
      if ((localloh.jdField_a_of_type_Int == 2) && (localloh.jdField_a_of_type_Boolean) && (localloh.jdField_b_of_type_Int >= 1920) && (localloh.jdField_c_of_type_Int >= 1080))
      {
        i = m;
        m = j;
        n = 1;
        j = k;
        k = m;
        m = n;
      }
      else if ((localloh.jdField_a_of_type_Int == 4) && (localloh.jdField_a_of_type_Boolean) && (localloh.jdField_b_of_type_Int >= 1920) && (localloh.jdField_c_of_type_Int >= 1080))
      {
        i1 = 1;
        m = j;
        n = i;
        i = i1;
        j = k;
        k = m;
        m = n;
      }
      else if ((localloh.jdField_a_of_type_Int == 8) && (localloh.jdField_a_of_type_Boolean) && (localloh.jdField_b_of_type_Int >= 1920) && (localloh.jdField_c_of_type_Int >= 1080))
      {
        n = m;
        k = j;
        j = 1;
        m = i;
        i = n;
        continue;
        i3 = 0;
        i2 = 0;
        i1 = 0;
        n = 0;
        label327:
        boolean bool1;
        if ((n == 0) || (i1 == 0))
        {
          bool1 = bool2;
          if (i2 != 0)
          {
            bool1 = bool2;
            if (i3 == 0) {}
          }
        }
        else
        {
          bool1 = true;
        }
        QLog.i("AndroidCodec", 1, "isSupportHwCodec1080P = " + bool1);
        return bool1;
      }
      else
      {
        n = j;
        i1 = i;
        i = m;
        j = k;
        k = n;
        m = i1;
      }
    }
  }
  
  public static List<MediaCodecInfo> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        int k = MediaCodecList.getCodecCount();
        i = 0;
        if (i < k)
        {
          MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
          if ((localMediaCodecInfo.isEncoder()) && (!localMediaCodecInfo.getName().contains(".sw.")) && (!localMediaCodecInfo.getName().contains(".SW.")) && (!localMediaCodecInfo.getName().contains("google")) && (!localMediaCodecInfo.getName().contains("Google")) && (!localMediaCodecInfo.getName().contains("GOOGLE")))
          {
            String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
            int j = 0;
            if (j < arrayOfString.length)
            {
              if (arrayOfString[j].equalsIgnoreCase(paramString)) {
                localArrayList.add(localMediaCodecInfo);
              }
              j += 1;
              continue;
            }
          }
        }
        else
        {
          return localArrayList;
        }
      }
      catch (Throwable paramString) {}
      i += 1;
    }
  }
  
  public static void b()
  {
    if (!jdField_a_of_type_Boolean) {}
    try
    {
      SoLoadUtil.a(BaseApplicationImpl.getContext(), "c++_shared", 0, false);
      System.loadLibrary("hwcodec");
      int i = NativeCodec.getVersion();
      QLog.w("AndroidCodec", 1, "loadCodecLibrarys suc, ver[" + i + "]");
      jdField_a_of_type_Boolean = true;
      if (!jdField_a_of_type_Boolean) {
        QLog.w("AndroidCodec", 1, "loadCodecLibrarys fail");
      }
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
        jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public MediaFormat a(int paramInt)
  {
    try
    {
      MediaFormat localMediaFormat = (MediaFormat)jdField_c_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_AndroidMediaMediaCodec, new Object[] { Integer.valueOf(paramInt) });
      return localMediaFormat;
    }
    catch (Exception localException)
    {
      if (AudioHelper.f()) {
        QLog.e(this.jdField_d_of_type_JavaLangString, 1, "invoke getOutputFormat exception", localException);
      }
    }
    return null;
  }
  
  public ByteBuffer a(int paramInt)
  {
    try
    {
      ByteBuffer localByteBuffer = (ByteBuffer)jdField_a_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_AndroidMediaMediaCodec, new Object[] { Integer.valueOf(paramInt) });
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      if (AudioHelper.f()) {
        QLog.e(this.jdField_d_of_type_JavaLangString, 1, "invoke getInputBuffer exception", localException);
      }
    }
    return null;
  }
  
  /* Error */
  public log a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 494	lof:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 524	log
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 527	log:<init>	(Llof;)V
    //   17: astore_2
    //   18: aload_0
    //   19: getfield 494	lof:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   22: getstatic 41	lof:jdField_c_of_type_Int	I
    //   25: i2l
    //   26: invokevirtual 531	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   29: istore_1
    //   30: iload_1
    //   31: iflt -24 -> 7
    //   34: getstatic 82	android/os/Build$VERSION:SDK_INT	I
    //   37: bipush 20
    //   39: if_icmpgt +29 -> 68
    //   42: aload_0
    //   43: monitorenter
    //   44: aload_2
    //   45: iload_1
    //   46: putfield 532	log:jdField_a_of_type_Int	I
    //   49: aload_2
    //   50: aload_0
    //   51: getfield 534	lof:jdField_a_of_type_ArrayOfJavaNioByteBuffer	[Ljava/nio/ByteBuffer;
    //   54: iload_1
    //   55: aaload
    //   56: putfield 537	log:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_2
    //   62: areturn
    //   63: astore_2
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_2
    //   67: athrow
    //   68: aload_0
    //   69: monitorenter
    //   70: aload_2
    //   71: iload_1
    //   72: putfield 532	log:jdField_a_of_type_Int	I
    //   75: aload_2
    //   76: getstatic 386	lof:jdField_a_of_type_JavaLangReflectMethod	Ljava/lang/reflect/Method;
    //   79: aload_0
    //   80: getfield 494	lof:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   83: iconst_1
    //   84: anewarray 4	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: iload_1
    //   90: invokestatic 498	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   93: aastore
    //   94: invokevirtual 504	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   97: checkcast 513	java/nio/ByteBuffer
    //   100: putfield 537	log:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_2
    //   106: areturn
    //   107: astore_3
    //   108: aload_3
    //   109: invokevirtual 538	java/lang/IllegalAccessException:printStackTrace	()V
    //   112: aload_2
    //   113: iconst_0
    //   114: putfield 539	log:jdField_a_of_type_Boolean	Z
    //   117: goto -14 -> 103
    //   120: astore_2
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_2
    //   124: athrow
    //   125: astore_3
    //   126: aload_3
    //   127: invokevirtual 540	java/lang/IllegalArgumentException:printStackTrace	()V
    //   130: aload_2
    //   131: iconst_0
    //   132: putfield 539	log:jdField_a_of_type_Boolean	Z
    //   135: goto -32 -> 103
    //   138: astore_3
    //   139: aload_3
    //   140: invokevirtual 541	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   143: aload_2
    //   144: iconst_0
    //   145: putfield 539	log:jdField_a_of_type_Boolean	Z
    //   148: goto -45 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	lof
    //   29	61	1	i	int
    //   17	45	2	locallog1	log
    //   63	50	2	locallog2	log
    //   120	24	2	localObject	Object
    //   107	2	3	localIllegalAccessException	IllegalAccessException
    //   125	2	3	localIllegalArgumentException	IllegalArgumentException
    //   138	2	3	localInvocationTargetException	InvocationTargetException
    // Exception table:
    //   from	to	target	type
    //   44	61	63	finally
    //   64	66	63	finally
    //   75	103	107	java/lang/IllegalAccessException
    //   70	75	120	finally
    //   75	103	120	finally
    //   103	105	120	finally
    //   108	117	120	finally
    //   121	123	120	finally
    //   126	135	120	finally
    //   139	148	120	finally
    //   75	103	125	java/lang/IllegalArgumentException
    //   75	103	138	java/lang/reflect/InvocationTargetException
  }
  
  public log a(long paramLong)
  {
    Object localObject5 = null;
    log locallog;
    long l1;
    label100:
    Object localObject3;
    do
    {
      try
      {
        Object localObject1;
        if (this.jdField_a_of_type_AndroidMediaMediaCodec == null)
        {
          localObject1 = localObject5;
          if (AudioHelper.f())
          {
            QLog.e(this.jdField_d_of_type_JavaLangString, 1, "dequeueDecoderOutputBuffer mMediaCodec is null");
            localObject1 = localObject5;
          }
        }
        for (;;)
        {
          return localObject1;
          if (this.e == jdField_b_of_type_Int) {
            break;
          }
          localObject1 = localObject5;
          if (AudioHelper.f())
          {
            QLog.e(this.jdField_d_of_type_JavaLangString, 1, "dequeueDecoderOutputBuffer mCodecType isn't Decoder");
            localObject1 = localObject5;
          }
        }
        locallog = new log(this);
      }
      finally {}
      l1 = 0L;
      localObject3 = localObject5;
    } while (l1 >= paramLong);
    long l2 = System.nanoTime();
    int i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(locallog.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, 3000L);
    l2 = l1 + (System.nanoTime() - l2);
    switch (i)
    {
    }
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          localObject3 = localObject5;
          if (i < 0) {
            break;
          }
          if (Build.VERSION.SDK_INT > 20) {
            break label417;
          }
          locallog.jdField_a_of_type_JavaNioByteBuffer = this.jdField_b_of_type_ArrayOfJavaNioByteBuffer[i];
          locallog.jdField_a_of_type_Int = i;
          locallog.jdField_a_of_type_AndroidMediaMediaFormat = this.jdField_b_of_type_AndroidMediaMediaFormat;
          localObject3 = locallog;
          break;
          if (NativeCodec.canLog()) {
            QLog.e(this.jdField_d_of_type_JavaLangString, 1, "dequeueDecoderOutputBuffer INFO_OUTPUT_BUFFERS_CHANGED");
          }
          this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
          locallog.jdField_a_of_type_Int = -3;
          l1 = l2;
          break label100;
          locallog.jdField_a_of_type_Int = -2;
          this.jdField_b_of_type_AndroidMediaMediaFormat = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
          localObject3 = this.jdField_b_of_type_AndroidMediaMediaFormat;
          l1 = l2;
          if (localObject3 == null) {
            break label100;
          }
          try
          {
            i = this.jdField_b_of_type_AndroidMediaMediaFormat.getInteger("color-format");
            jdField_d_of_type_Int = i;
            l1 = l2;
            if (!NativeCodec.canLog()) {
              break label100;
            }
            QLog.e(this.jdField_d_of_type_JavaLangString, 1, "dequeueDecoderOutputBuffer New color format " + i + "[0x" + Integer.toHexString(i) + "]");
            l1 = l2;
          }
          catch (Exception localException)
          {
            l1 = l2;
          }
        }
        if (!AudioHelper.f()) {
          break label100;
        }
        QLog.e(this.jdField_d_of_type_JavaLangString, 1, "dequeueDecoderOutputBuffer Exception,INFO_OUTPUT_FORMAT_CHANGED");
        l1 = l2;
        break label100;
        locallog.jdField_a_of_type_Int = -1;
        Object localObject4 = locallog;
        break;
        label417:
        locallog.jdField_a_of_type_Int = i;
        try
        {
          locallog.jdField_a_of_type_JavaNioByteBuffer = ((ByteBuffer)jdField_b_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_AndroidMediaMediaCodec, new Object[] { Integer.valueOf(i) }));
          locallog.jdField_a_of_type_AndroidMediaMediaFormat = ((MediaFormat)jdField_c_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_AndroidMediaMediaCodec, new Object[] { Integer.valueOf(i) }));
          localObject4 = locallog;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          for (;;)
          {
            localIllegalAccessException.printStackTrace();
            locallog.jdField_a_of_type_Boolean = false;
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            localIllegalArgumentException.printStackTrace();
            locallog.jdField_a_of_type_Boolean = false;
          }
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          for (;;)
          {
            localInvocationTargetException.printStackTrace();
            locallog.jdField_a_of_type_Boolean = false;
          }
        }
      }
    }
  }
  
  /* Error */
  public void a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 494	lof:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 494	lof:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   18: iload_1
    //   19: iconst_0
    //   20: invokevirtual 596	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   23: goto -12 -> 11
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	lof
    //   0	31	1	paramInt	int
    //   6	2	2	localMediaCodec	MediaCodec
    //   26	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	26	finally
    //   14	23	26	finally
  }
  
  /* Error */
  public void a(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 494	lof:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   6: astore 6
    //   8: aload 6
    //   10: ifnonnull +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield 494	lof:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   20: iload_1
    //   21: iconst_0
    //   22: iload_2
    //   23: lload_3
    //   24: iload 5
    //   26: invokevirtual 601	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   29: goto -16 -> 13
    //   32: astore 6
    //   34: invokestatic 232	com/tencent/mobileqq/utils/AudioHelper:f	()Z
    //   37: ifeq -24 -> 13
    //   40: aload_0
    //   41: getfield 75	lof:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   44: iconst_1
    //   45: new 62	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   52: ldc_w 603
    //   55: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: iload_1
    //   59: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc_w 605
    //   65: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: iload_2
    //   69: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: ldc_w 607
    //   75: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: lload_3
    //   79: invokevirtual 610	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   82: ldc_w 612
    //   85: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: iload 5
    //   90: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   93: ldc 120
    //   95: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: aload 6
    //   103: invokestatic 124	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   106: goto -93 -> 13
    //   109: astore 6
    //   111: aload_0
    //   112: monitorexit
    //   113: aload 6
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	lof
    //   0	116	1	paramInt1	int
    //   0	116	2	paramInt2	int
    //   0	116	3	paramLong	long
    //   0	116	5	paramInt3	int
    //   6	3	6	localMediaCodec	MediaCodec
    //   32	70	6	localException	Exception
    //   109	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	29	32	java/lang/Exception
    //   2	8	109	finally
    //   16	29	109	finally
    //   34	106	109	finally
  }
  
  public void a(Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT < 19) {}
    do
    {
      for (;;)
      {
        return;
        if ((this.jdField_a_of_type_AndroidMediaMediaCodec != null) && (jdField_d_of_type_JavaLangReflectMethod != null)) {
          try
          {
            jdField_d_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_AndroidMediaMediaCodec, new Object[] { paramBundle });
            return;
          }
          catch (IllegalArgumentException paramBundle)
          {
            if (QLog.isDevelopLevel())
            {
              QLog.w(this.jdField_d_of_type_JavaLangString, 1, "setParameters, IllegalArgumentException", paramBundle);
              return;
            }
          }
          catch (IllegalAccessException paramBundle)
          {
            if (QLog.isDevelopLevel())
            {
              QLog.w(this.jdField_d_of_type_JavaLangString, 1, "setParameters, IllegalAccessException", paramBundle);
              return;
            }
          }
          catch (InvocationTargetException paramBundle) {}
        }
      }
    } while (!QLog.isDevelopLevel());
    QLog.w(this.jdField_d_of_type_JavaLangString, 1, "setParameters, InvocationTargetException", paramBundle);
  }
  
  public boolean a()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaCodec != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaCodec.start();
        if (Build.VERSION.SDK_INT <= 20) {
          try
          {
            this.jdField_a_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffers();
            this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
          }
          finally {}
        }
      }
      else
      {
        return false;
      }
    }
    catch (Exception localException) {}
    return true;
  }
  
  boolean a(MediaCodec paramMediaCodec, loj paramloj)
  {
    if ((paramloj != null) && (DeviceCheck.g()))
    {
      DexClassLoader localDexClassLoader = mrt.a();
      Object localObject = mrt.a(localDexClassLoader, "com.tencent.av.mediacodec.MediaCodecWrapper");
      if (localObject != null) {
        try
        {
          Object[] arrayOfObject = new Object[1];
          boolean bool = mrt.a(localDexClassLoader, localObject, "setCallback", new Class[] { MediaCodec.class, loj.class }, new Object[] { paramMediaCodec, paramloj }, arrayOfObject);
          return bool;
        }
        catch (Exception paramMediaCodec)
        {
          if (AudioHelper.f()) {
            QLog.w(this.jdField_d_of_type_JavaLangString, 1, "setMediaCodecCallback, Exception", paramMediaCodec);
          }
        }
      }
    }
    return false;
  }
  
  /* Error */
  public boolean a(MediaFormat paramMediaFormat, int paramInt, loj paramloj)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: aload_1
    //   5: putfield 650	lof:jdField_a_of_type_AndroidMediaMediaFormat	Landroid/media/MediaFormat;
    //   8: iload_2
    //   9: getstatic 58	lof:jdField_b_of_type_Int	I
    //   12: if_icmpne +88 -> 100
    //   15: aload_0
    //   16: aload_0
    //   17: getfield 650	lof:jdField_a_of_type_AndroidMediaMediaFormat	Landroid/media/MediaFormat;
    //   20: ldc_w 652
    //   23: invokevirtual 656	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   26: invokestatic 660	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   29: putfield 494	lof:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   32: aload_0
    //   33: iload_2
    //   34: putfield 60	lof:e	I
    //   37: aload_0
    //   38: getfield 494	lof:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   41: ifnull +39 -> 80
    //   44: iload_2
    //   45: getstatic 24	lof:jdField_a_of_type_Int	I
    //   48: if_icmpne +86 -> 134
    //   51: iconst_1
    //   52: istore_2
    //   53: aload_0
    //   54: aload_0
    //   55: aload_0
    //   56: getfield 494	lof:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   59: aload_3
    //   60: invokevirtual 662	lof:a	(Landroid/media/MediaCodec;Lloj;)Z
    //   63: putfield 664	lof:jdField_d_of_type_Boolean	Z
    //   66: aload_0
    //   67: getfield 494	lof:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   70: aload_0
    //   71: getfield 650	lof:jdField_a_of_type_AndroidMediaMediaFormat	Landroid/media/MediaFormat;
    //   74: aconst_null
    //   75: aconst_null
    //   76: iload_2
    //   77: invokevirtual 668	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   80: aload_0
    //   81: getfield 494	lof:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   84: ifnull +6 -> 90
    //   87: iconst_1
    //   88: istore 4
    //   90: iload 4
    //   92: ireturn
    //   93: astore_1
    //   94: aload_1
    //   95: invokevirtual 669	java/lang/Exception:printStackTrace	()V
    //   98: iconst_0
    //   99: ireturn
    //   100: aload_0
    //   101: aload_0
    //   102: getfield 650	lof:jdField_a_of_type_AndroidMediaMediaFormat	Landroid/media/MediaFormat;
    //   105: ldc_w 652
    //   108: invokevirtual 656	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   111: invokestatic 672	android/media/MediaCodec:createEncoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   114: putfield 494	lof:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   117: goto -85 -> 32
    //   120: astore_1
    //   121: aload_1
    //   122: invokevirtual 669	java/lang/Exception:printStackTrace	()V
    //   125: iconst_0
    //   126: ireturn
    //   127: astore_1
    //   128: aload_1
    //   129: invokevirtual 669	java/lang/Exception:printStackTrace	()V
    //   132: iconst_0
    //   133: ireturn
    //   134: iconst_0
    //   135: istore_2
    //   136: goto -83 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	lof
    //   0	139	1	paramMediaFormat	MediaFormat
    //   0	139	2	paramInt	int
    //   0	139	3	paramloj	loj
    //   1	90	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   15	32	93	java/lang/Exception
    //   100	117	120	java/lang/Exception
    //   37	51	127	java/lang/Exception
    //   53	80	127	java/lang/Exception
  }
  
  public boolean a(MediaFormat paramMediaFormat, String paramString, Surface paramSurface, loj paramloj)
  {
    this.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createByCodecName(paramString);
        paramMediaFormat = a(paramString);
        if ((paramMediaFormat != null) && (paramMediaFormat.isEncoder()))
        {
          this.e = jdField_a_of_type_Int;
          i = 1;
          return false;
        }
      }
      catch (Exception paramMediaFormat)
      {
        try
        {
          if (this.jdField_a_of_type_AndroidMediaMediaCodec != null)
          {
            this.jdField_d_of_type_Boolean = a(this.jdField_a_of_type_AndroidMediaMediaCodec, paramloj);
            this.jdField_a_of_type_AndroidMediaMediaCodec.configure(this.jdField_a_of_type_AndroidMediaMediaFormat, paramSurface, null, i);
          }
          if (this.jdField_a_of_type_AndroidMediaMediaCodec == null) {
            break label98;
          }
          return true;
        }
        catch (Exception paramMediaFormat)
        {
          paramMediaFormat.printStackTrace();
          return false;
        }
        paramMediaFormat = paramMediaFormat;
        paramMediaFormat.printStackTrace();
        return false;
      }
      label98:
      int i = 0;
    }
  }
  
  public boolean a(MediaFormat paramMediaFormat, String paramString, loj paramloj)
  {
    this.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
    paramMediaFormat = a(paramString);
    if ((paramMediaFormat != null) && (paramMediaFormat.isEncoder())) {
      this.e = jdField_a_of_type_Int;
    }
    for (int i = 1;; i = 0) {
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createByCodecName(paramString);
        return false;
      }
      catch (Exception paramMediaFormat)
      {
        try
        {
          if (this.jdField_a_of_type_AndroidMediaMediaCodec != null)
          {
            this.jdField_d_of_type_Boolean = a(this.jdField_a_of_type_AndroidMediaMediaCodec, paramloj);
            this.jdField_a_of_type_AndroidMediaMediaCodec.configure(this.jdField_a_of_type_AndroidMediaMediaFormat, null, null, i);
          }
          if (this.jdField_a_of_type_AndroidMediaMediaCodec == null) {
            continue;
          }
          return true;
        }
        catch (Exception paramMediaFormat)
        {
          paramMediaFormat.printStackTrace();
          return false;
        }
        paramMediaFormat = paramMediaFormat;
        paramMediaFormat.printStackTrace();
        return false;
      }
    }
  }
  
  public ByteBuffer b(int paramInt)
  {
    try
    {
      ByteBuffer localByteBuffer = (ByteBuffer)jdField_b_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_AndroidMediaMediaCodec, new Object[] { Integer.valueOf(paramInt) });
      return localByteBuffer;
    }
    catch (Exception localException)
    {
      if (AudioHelper.f()) {
        QLog.e(this.jdField_d_of_type_JavaLangString, 1, "invoke getOutputBuffer exception", localException);
      }
    }
    return null;
  }
  
  public log b()
  {
    Object localObject4 = null;
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = this.jdField_a_of_type_AndroidMediaMediaCodec;
        if (localObject1 == null)
        {
          localObject1 = localObject4;
          return localObject1;
        }
        log locallog = new log(this);
        i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(locallog.jdField_a_of_type_AndroidMediaMediaCodec$BufferInfo, jdField_c_of_type_Int);
        switch (i)
        {
        case -3: 
          if (NativeCodec.canLog()) {
            QLog.w(this.jdField_d_of_type_JavaLangString, 1, "dequeueOutputBuffer, outIndex[" + i + "]");
          }
          localObject1 = localObject4;
          if (i < 0) {
            continue;
          }
          if (Build.VERSION.SDK_INT > 20) {
            break label461;
          }
          locallog.jdField_a_of_type_JavaNioByteBuffer = this.jdField_b_of_type_ArrayOfJavaNioByteBuffer[i];
          locallog.jdField_a_of_type_Int = i;
          locallog.jdField_a_of_type_AndroidMediaMediaFormat = this.jdField_b_of_type_AndroidMediaMediaFormat;
          localObject1 = locallog;
          continue;
          this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
          locallog.jdField_a_of_type_Int = -3;
          localObject1 = localObject4;
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          QLog.e(this.jdField_d_of_type_JavaLangString, 1, "dequeueOutputBuffer, INFO_OUTPUT_BUFFERS_CHANGED");
          localObject1 = localObject4;
          break;
        case -2: 
          locallog.jdField_a_of_type_Int = -2;
        }
      }
      finally {}
      this.jdField_b_of_type_AndroidMediaMediaFormat = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputFormat();
      Object localObject3;
      if (this.jdField_b_of_type_AndroidMediaMediaFormat != null)
      {
        i = this.e;
        int j = jdField_b_of_type_Int;
        if (i == j)
        {
          try
          {
            i = this.jdField_b_of_type_AndroidMediaMediaFormat.getInteger("color-format");
            localObject3 = localObject4;
            if (!NativeCodec.canLog()) {
              continue;
            }
            QLog.w(this.jdField_d_of_type_JavaLangString, 1, "dequeueOutputBuffer, INFO_OUTPUT_FORMAT_CHANGED, colorformat[" + i + "|0x" + Integer.toHexString(i).toUpperCase() + "]");
            localObject3 = localObject4;
          }
          catch (Exception localException)
          {
            localObject3 = localObject4;
          }
          if (AudioHelper.f())
          {
            QLog.e(this.jdField_d_of_type_JavaLangString, 1, "dequeueOutputBuffer, INFO_OUTPUT_FORMAT_CHANGED, Exception", localException);
            localObject3 = localObject4;
          }
        }
        else
        {
          localObject3 = localObject4;
          if (AudioHelper.f())
          {
            QLog.w(this.jdField_d_of_type_JavaLangString, 1, "dequeueOutputBuffer, INFO_OUTPUT_FORMAT_CHANGED, CodecType[" + this.e + "]");
            localObject3 = localObject4;
          }
        }
      }
      else
      {
        localObject3 = localObject4;
        if (QLog.isDevelopLevel())
        {
          QLog.e(this.jdField_d_of_type_JavaLangString, 1, "dequeueOutputBuffer, INFO_OUTPUT_FORMAT_CHANGED, null");
          localObject3 = localObject4;
          continue;
          if (NativeCodec.canLog()) {
            QLog.e(this.jdField_d_of_type_JavaLangString, 1, "dequeueOutputBuffer, INFO_TRY_AGAIN_LATER");
          }
          localException.jdField_a_of_type_Int = -1;
          localObject3 = localException;
          continue;
          label461:
          localException.jdField_a_of_type_Int = i;
          try
          {
            localException.jdField_a_of_type_JavaNioByteBuffer = ((ByteBuffer)jdField_b_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_AndroidMediaMediaCodec, new Object[] { Integer.valueOf(i) }));
            localException.jdField_a_of_type_AndroidMediaMediaFormat = ((MediaFormat)jdField_c_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_AndroidMediaMediaCodec, new Object[] { Integer.valueOf(i) }));
            localObject3 = localException;
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            for (;;)
            {
              localIllegalAccessException.printStackTrace();
              localException.jdField_a_of_type_Boolean = false;
            }
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            for (;;)
            {
              localIllegalArgumentException.printStackTrace();
              localException.jdField_a_of_type_Boolean = false;
            }
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            for (;;)
            {
              localInvocationTargetException.printStackTrace();
              localException.jdField_a_of_type_Boolean = false;
            }
          }
        }
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaCodec != null) {
      this.jdField_a_of_type_AndroidMediaMediaCodec.stop();
    }
  }
  
  public void d()
  {
    try
    {
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer = null;
      this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = null;
      if (this.jdField_a_of_type_AndroidMediaMediaCodec != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaCodec.release();
        this.jdField_a_of_type_AndroidMediaMediaCodec = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lof
 * JD-Core Version:    0.7.0.1
 */