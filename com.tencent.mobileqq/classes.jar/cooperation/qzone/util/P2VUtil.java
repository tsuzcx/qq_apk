package cooperation.qzone.util;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneVideoCommonUtils.VideoSupport;
import cooperation.qzone.cache.CacheManager;

public class P2VUtil
{
  private static int jdField_a_of_type_Int = QzoneConfig.getInstance().getConfig("QZoneSetting", "P2VFunEnable", 1);
  private static P2VUtil jdField_a_of_type_CooperationQzoneUtilP2VUtil;
  private static final String jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("QZoneSetting", "P2VFunBlackList", "MI 3,GT-N7108,vivo Y51A,OPPO R6007,vivo Y31A,CAM-AL00,CAM-UL00,CAM-TL00,M821,SM-A7000,MI 2SC,SM-G6000");
  private static int jdField_b_of_type_Int = -1;
  private static final long jdField_b_of_type_Long = QzoneConfig.getInstance().getConfig("QZoneSetting", "P2VStorageLimt", 62914560L);
  private static long c = -1L;
  private long jdField_a_of_type_Long = -1L;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile String jdField_b_of_type_JavaLangString;
  
  public P2VUtil()
  {
    if (this.jdField_a_of_type_Long == -1L) {
      this.jdField_a_of_type_Long = (QzoneHardwareRestriction.getTotalMem() / 1024L);
    }
  }
  
  private static long a()
  {
    try
    {
      long l = CacheManager.b();
      return l;
    }
    catch (Exception localException)
    {
      QLog.e("P2VUtil", 1, "Get Free Space Failed", localException);
    }
    return 0L;
  }
  
  public static QZoneVideoCommonUtils.VideoSupport a()
  {
    int j = -1;
    if (jdField_b_of_type_Int < 0) {
      a();
    }
    if (c < 0L) {
      c = CpuUtils.a();
    }
    if (QLog.isColorLevel()) {
      QLog.i("P2VUtil", 2, "getP2VSupport() mCpuFamily=" + jdField_b_of_type_Int + " mCpuFeature=" + c);
    }
    int k = QzoneConfig.getInstance().getConfig("QZoneSetting", "P2VSupportedCpuFamily", 2);
    if (jdField_b_of_type_Int >= 0) {}
    for (int i = 1 << jdField_b_of_type_Int; (i & k) == 0; i = 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("P2VUtil", 2, "getP2VSupport() serverCpuFamily=" + k + " mCpuFamily=" + jdField_b_of_type_Int);
      }
      return QZoneVideoCommonUtils.VideoSupport.b;
    }
    Object localObject = QzoneConfig.getInstance().getConfig("MiniVideo", "RequiredCpuFeatures", "#101##").split("#", -1);
    if (jdField_b_of_type_Int >= localObject.length) {
      if (QLog.isColorLevel()) {
        QLog.i("P2VUtil", 2, "getRecordSupport() mCpuFamily=" + jdField_b_of_type_Int + " serverCpuFeatureList.length=" + localObject.length);
      }
    }
    label395:
    while (!QzoneHardwareRestriction.meetHardwareRestriction(0, 1))
    {
      return QZoneVideoCommonUtils.VideoSupport.d;
      localObject = localObject[jdField_b_of_type_Int];
      i = ((String)localObject).length() - 1;
      for (;;)
      {
        if (i < 0) {
          break label395;
        }
        j += 1;
        if (j > 63)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("P2VUtil", 2, "getRecordSupport() longValueIndex>63  serverFeature=" + (String)localObject + " mCpuFeature=" + c);
          break;
        }
        if ((((String)localObject).charAt(i) == '1') && ((c & 1L << j) == 0L))
        {
          if (QLog.isColorLevel()) {
            QLog.i("P2VUtil", 2, "getRecordSupport() cpuFeature unsatisfied. bitIndex=" + i + " serverFeature=" + (String)localObject + " mCpuFeature=" + c);
          }
          return QZoneVideoCommonUtils.VideoSupport.b;
        }
        i -= 1;
      }
    }
    i = QzoneConfig.getInstance().getConfig("MiniVideo", "MinSdkVersion", 14);
    j = Build.VERSION.SDK_INT;
    if (j < i)
    {
      if (QLog.isColorLevel()) {
        QLog.i("P2VUtil", 2, "getRecordSupport() localSdkVersion=" + j + " serverSdkVersion=" + i);
      }
      return QZoneVideoCommonUtils.VideoSupport.e;
    }
    if (!CacheManager.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("P2VUtil", 2, "getRecordSupport() sdcard !mounted");
      }
      return QZoneVideoCommonUtils.VideoSupport.f;
    }
    long l = a();
    if (l < jdField_b_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.i("P2VUtil", 2, "getRecordSupport() sdCardFreeSpace=" + l + " STORAGE_LIMIT=" + jdField_b_of_type_Long);
      }
      return QZoneVideoCommonUtils.VideoSupport.g;
    }
    return QZoneVideoCommonUtils.VideoSupport.a;
  }
  
  public static P2VUtil a()
  {
    if (jdField_a_of_type_CooperationQzoneUtilP2VUtil == null) {}
    try
    {
      if (jdField_a_of_type_CooperationQzoneUtilP2VUtil == null) {
        jdField_a_of_type_CooperationQzoneUtilP2VUtil = new P2VUtil();
      }
      return jdField_a_of_type_CooperationQzoneUtilP2VUtil;
    }
    finally {}
  }
  
  private static void a()
  {
    if (Build.CPU_ABI.contains("armeabi"))
    {
      jdField_b_of_type_Int = 1;
      return;
    }
    if (Build.CPU_ABI.contains("x86"))
    {
      jdField_b_of_type_Int = 2;
      return;
    }
    if (Build.CPU_ABI.contains("mips"))
    {
      jdField_b_of_type_Int = 3;
      return;
    }
    jdField_b_of_type_Int = 0;
  }
  
  private boolean a(String paramString)
  {
    try
    {
      String str = Build.MODEL;
      if ((str == null) || (str.length() == 0))
      {
        QZLog.i("P2VUtil", 1, "buildModel is empty, hide P2V .命中禁止照片合成视频策略");
        return true;
      }
      if (QZLog.isColorLevel()) {
        QZLog.d("P2VUtil", 2, "buildModel is '" + str + "'");
      }
      if ((paramString == null) || (paramString.length() == 0)) {
        break label150;
      }
      str = "," + str + ",";
      if (("," + paramString + ",").contains(str))
      {
        QZLog.i("P2VUtil", 1, "命中禁止照片合成视频黑名单策略");
        return true;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      return false;
    }
    return false;
    label150:
    return false;
  }
  
  public void a(boolean paramBoolean)
  {
    LocalMultiProcConfig.putBool("isNeedCloseP2VFunc", paramBoolean);
  }
  
  public boolean a()
  {
    if (LocalMultiProcConfig.getBool("isNeedCloseP2VFunc", false)) {}
    while (jdField_a_of_type_Int == 0) {
      return false;
    }
    if ((jdField_a_of_type_JavaLangString != null) && (!jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString))) {
      if (a(jdField_a_of_type_JavaLangString)) {
        break label88;
      }
    }
    label88:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString;
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      QZoneVideoCommonUtils.VideoSupport localVideoSupport = a();
      if (localVideoSupport != null) {
        this.jdField_a_of_type_Boolean = localVideoSupport.a();
      }
      return this.jdField_a_of_type_Boolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.util.P2VUtil
 * JD-Core Version:    0.7.0.1
 */