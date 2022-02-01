package cooperation.qzone;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneVideoCommonUtilsProxy;
import com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction;
import common.config.service.QzoneConfig;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.util.PerfTracer;

public class QZoneVideoCommonUtils
{
  public static final String RECORD_LOCAL_BLACK_LIST = "GN9000L|ASUS_T00F|H30-T00";
  public static final String REFER_GIF = "refer_gif";
  public static final String REFER_SHORT_VIDEO_FOR_VIDEO_COVER = "cover_mall_record_video";
  public static final String REFER_UPLOAD_VIDEO_FOR_H5 = "ref_h5_record_video";
  public static final long STORAGE_LIMIT = 62914560L;
  private static final String TAG = "QZoneVideoCommonUtils";
  public static final String TRIM_HW_LOCAL_BLACK_LIST = "GT-N7100|";
  public static final String TRIM_LOCAL_BLACK_LIST = "M032|ASUS_T00F";
  private static int mCpuFamily = -1;
  
  public static void forwardInstallAndStartUpOtherActivity(long paramLong, Activity paramActivity, String paramString, QZoneVideoCommonUtils.onForwardVideoActivityFailedListener paramonForwardVideoActivityFailedListener, Bundle paramBundle)
  {
    PerfTracer.traceStart("Video_component_pre_launch");
    if (paramActivity == null)
    {
      QLog.w("QZoneVideoCommonUtils", 2, "forwardInstallAndStartUpVideoActivity activity is null");
      return;
    }
    QZoneVideoCommonUtils.VideoSupport localVideoSupport1 = getRecordSupport();
    QZoneVideoCommonUtils.VideoSupport localVideoSupport2 = getTrimSupport();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("support record=");
      localStringBuilder.append(localVideoSupport1.isAvailable());
      localStringBuilder.append(", support trim=");
      localStringBuilder.append(localVideoSupport2.isAvailable());
      QLog.d("QZoneVideoCommonUtils", 2, localStringBuilder.toString());
    }
    if ((!localVideoSupport1.isAvailable()) && (!localVideoSupport2.isAvailable()))
    {
      if (localVideoSupport1.isShowTip()) {
        paramString = localVideoSupport1.getTip();
      } else {
        paramString = null;
      }
      if (paramString != null)
      {
        paramBundle = paramString;
        if (paramString.length() != 0) {}
      }
      else
      {
        paramBundle = paramActivity.getString(2131915145);
      }
      if (paramonForwardVideoActivityFailedListener != null) {
        paramonForwardVideoActivityFailedListener.onFail(paramActivity, paramBundle);
      }
      if (QLog.isColorLevel())
      {
        paramActivity = new StringBuilder();
        paramActivity.append("qzone video is not supported, recordSupport tips=");
        paramActivity.append(localVideoSupport1.getTip());
        paramActivity.append(",trimSupport tips=");
        paramActivity.append(localVideoSupport2.getTip());
        paramActivity.append(",show tips=");
        paramActivity.append(paramBundle);
        QLog.w("QZoneVideoCommonUtils", 2, paramActivity.toString());
      }
      return;
    }
    installVideoActivityForOther(paramLong, paramActivity, false, false, paramString, paramBundle);
    PerfTracer.traceEnd("Video_component_pre_launch");
  }
  
  public static void forwardInstallAndStartUpVideoActivity(long paramLong, Activity paramActivity, String paramString, QZoneVideoCommonUtils.onForwardVideoActivityFailedListener paramonForwardVideoActivityFailedListener)
  {
    PerfTracer.traceStart("Video_component_pre_launch");
    if (paramActivity == null)
    {
      QLog.w("QZoneVideoCommonUtils", 2, "forwardInstallAndStartUpVideoActivity activity is null");
      return;
    }
    QZoneVideoCommonUtils.VideoSupport localVideoSupport1 = getRecordSupport();
    QZoneVideoCommonUtils.VideoSupport localVideoSupport2 = getTrimSupport();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("support record=");
      ((StringBuilder)localObject).append(localVideoSupport1.isAvailable());
      ((StringBuilder)localObject).append(", support trim=");
      ((StringBuilder)localObject).append(localVideoSupport2.isAvailable());
      QLog.d("QZoneVideoCommonUtils", 2, ((StringBuilder)localObject).toString());
    }
    if ((!localVideoSupport1.isAvailable()) && (!localVideoSupport2.isAvailable()))
    {
      if (localVideoSupport1.isShowTip()) {
        paramString = localVideoSupport1.getTip();
      } else {
        paramString = null;
      }
      if (paramString != null)
      {
        localObject = paramString;
        if (paramString.length() != 0) {}
      }
      else
      {
        localObject = paramActivity.getString(2131915145);
      }
      if (paramonForwardVideoActivityFailedListener != null) {
        paramonForwardVideoActivityFailedListener.onFail(paramActivity, (String)localObject);
      }
      if (QLog.isColorLevel())
      {
        paramActivity = new StringBuilder();
        paramActivity.append("qzone video is not supported, recordSupport tips=");
        paramActivity.append(localVideoSupport1.getTip());
        paramActivity.append(",trimSupport tips=");
        paramActivity.append(localVideoSupport2.getTip());
        paramActivity.append(",show tips=");
        paramActivity.append((String)localObject);
        QLog.w("QZoneVideoCommonUtils", 2, paramActivity.toString());
      }
      return;
    }
    installVideoActivity(paramLong, paramActivity, localVideoSupport1.isAvailable(), localVideoSupport2.isAvailable(), paramString);
    PerfTracer.traceEnd("Video_component_pre_launch");
  }
  
  public static void forwardToQCircleEdit(Activity paramActivity, Bundle paramBundle)
  {
    ((IQZoneVideoCommonUtilsProxy)QRoute.api(IQZoneVideoCommonUtilsProxy.class)).forwardToQCircleEdit(paramActivity, paramBundle);
  }
  
  private static void getCpuFamily()
  {
    if (Build.CPU_ABI.contains("armeabi"))
    {
      mCpuFamily = 1;
      return;
    }
    if (Build.CPU_ABI.contains("x86"))
    {
      mCpuFamily = 2;
      return;
    }
    if (Build.CPU_ABI.contains("mips"))
    {
      mCpuFamily = 3;
      return;
    }
    mCpuFamily = 0;
  }
  
  public static long getCpuFrequency()
  {
    return ((IQzoneHardwareRestriction)QRoute.api(IQzoneHardwareRestriction.class)).getCpuMaxFreq() / 1024L;
  }
  
  private static long getFreeSpace()
  {
    try
    {
      long l = CacheManager.getSDCardRemain();
      return l;
    }
    catch (Exception localException)
    {
      QLog.e("QZoneVideoCommonUtils", 1, "Get Free Space Failed", localException);
    }
    return 0L;
  }
  
  public static QZoneVideoCommonUtils.VideoSupport getRecordSupport()
  {
    if (QzoneConfig.getInstance().getConfig("MiniVideo", "SupportMiniVideo", -1) == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() severBlackList");
      }
      return QZoneVideoCommonUtils.VideoSupport.BlackListBanned;
    }
    int i = QzoneConfig.getInstance().getConfig("TrimVideo", "NeedLocalBlackList", 1);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Build.Model=");
      localStringBuilder.append(Build.MODEL);
      QLog.d("QZoneVideoCommonUtils", 2, localStringBuilder.toString());
    }
    if ((i > 0) && ("GN9000L|ASUS_T00F|H30-T00".contains(Build.MODEL)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() localBlackList");
      }
      return QZoneVideoCommonUtils.VideoSupport.BlackListBanned;
    }
    if (QzoneConfig.getInstance().getConfig("MiniVideo", "IgnoreLocalJudge", -1) == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() severWhiteList");
      }
    }
    else
    {
      if (mCpuFamily < 0) {
        getCpuFamily();
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getRecordSupport() mCpuFamily=");
        localStringBuilder.append(mCpuFamily);
        QLog.i("QZoneVideoCommonUtils", 2, localStringBuilder.toString());
      }
      j = QzoneConfig.getInstance().getConfig("MiniVideo", "SupportedCpuFamily", 2);
      i = mCpuFamily;
      if (i >= 0) {
        i = 1 << i;
      } else {
        i = 1;
      }
      if ((i & j) == 0)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getRecordSupport() serverCpuFamily=");
          localStringBuilder.append(j);
          localStringBuilder.append(" mCpuFamily=");
          localStringBuilder.append(mCpuFamily);
          QLog.i("QZoneVideoCommonUtils", 2, localStringBuilder.toString());
        }
        return QZoneVideoCommonUtils.VideoSupport.OrderSetBanned;
      }
      if (!((IQzoneHardwareRestriction)QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(0, 1)) {
        return QZoneVideoCommonUtils.VideoSupport.HardwareLimited;
      }
    }
    i = QzoneConfig.getInstance().getConfig("MiniVideo", "MinSdkVersion", 21);
    int j = Build.VERSION.SDK_INT;
    if (j < i)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getRecordSupport() localSdkVersion=");
        localStringBuilder.append(j);
        localStringBuilder.append(" serverSdkVersion=");
        localStringBuilder.append(i);
        QLog.i("QZoneVideoCommonUtils", 2, localStringBuilder.toString());
      }
      return QZoneVideoCommonUtils.VideoSupport.OSVersionBanned;
    }
    if (!CacheManager.isExternalAvailable())
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() sdcard !mounted");
      }
      return QZoneVideoCommonUtils.VideoSupport.NoExternalBanned;
    }
    long l = getFreeSpace();
    if (l < 62914560L)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getRecordSupport() sdCardFreeSpace=");
        localStringBuilder.append(l);
        localStringBuilder.append(" STORAGE_LIMIT=");
        localStringBuilder.append(62914560L);
        QLog.i("QZoneVideoCommonUtils", 2, localStringBuilder.toString());
      }
      return QZoneVideoCommonUtils.VideoSupport.ExternalSpaceBanned;
    }
    if (!((ICaptureUtil)QRoute.api(ICaptureUtil.class)).supportCapture())
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "CaptureUtil.supportCapture is false");
      }
      return QZoneVideoCommonUtils.VideoSupport.OSVersionBanned;
    }
    return QZoneVideoCommonUtils.VideoSupport.Available;
  }
  
  public static QZoneVideoCommonUtils.VideoSupport getTrimHWSupport()
  {
    return ((IQZoneVideoCommonUtilsProxy)QRoute.api(IQZoneVideoCommonUtilsProxy.class)).getTrimHWSupport();
  }
  
  public static QZoneVideoCommonUtils.VideoSupport getTrimSupport()
  {
    Object localObject = getTrimHWSupport();
    if (((QZoneVideoCommonUtils.VideoSupport)localObject).isAvailable()) {
      return localObject;
    }
    if (QzoneConfig.getInstance().getConfig("TrimVideo", "SupportTrimVideo", -1) == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() severBlackList");
      }
      return QZoneVideoCommonUtils.VideoSupport.BlackListBanned;
    }
    int i = QzoneConfig.getInstance().getConfig("TrimVideo", "NeedLocalBlackList", 1);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Build.Model=");
      ((StringBuilder)localObject).append(Build.MODEL);
      QLog.d("QZoneVideoCommonUtils", 2, ((StringBuilder)localObject).toString());
    }
    if ((i > 0) && ("M032|ASUS_T00F".contains(Build.MODEL)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() localBlackList");
      }
      return QZoneVideoCommonUtils.VideoSupport.BlackListBanned;
    }
    if (QzoneConfig.getInstance().getConfig("TrimVideo", "IgnoreLocalJudge", -1) == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() severWhiteList");
      }
    }
    else
    {
      if (mCpuFamily < 0) {
        getCpuFamily();
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getTrimSupport() mCpuFamily=");
        ((StringBuilder)localObject).append(mCpuFamily);
        QLog.i("QZoneVideoCommonUtils", 2, ((StringBuilder)localObject).toString());
      }
      j = QzoneConfig.getInstance().getConfig("TrimVideo", "SupportedCpuFamily", 2);
      i = mCpuFamily;
      if (i < 0) {
        i = 0;
      }
      if ((1 << i & j) == 0)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getTrimSupport() serverCpuFamily=");
          ((StringBuilder)localObject).append(j);
          ((StringBuilder)localObject).append(" mCpuFamily=");
          ((StringBuilder)localObject).append(mCpuFamily);
          QLog.i("QZoneVideoCommonUtils", 2, ((StringBuilder)localObject).toString());
        }
        return QZoneVideoCommonUtils.VideoSupport.OrderSetBanned;
      }
      if (!((IQzoneHardwareRestriction)QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(0, 1)) {
        return QZoneVideoCommonUtils.VideoSupport.HardwareLimited;
      }
    }
    i = QzoneConfig.getInstance().getConfig("TrimVideo", "MinSdkVersion", 14);
    int j = Build.VERSION.SDK_INT;
    if (j < i)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getTrimSupport() localSdkVersion=");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(" serverSdkVersion=");
        ((StringBuilder)localObject).append(i);
        QLog.i("QZoneVideoCommonUtils", 2, ((StringBuilder)localObject).toString());
      }
      return QZoneVideoCommonUtils.VideoSupport.OSVersionBanned;
    }
    if (!CacheManager.isExternalAvailable())
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() sdcard !mounted");
      }
      return QZoneVideoCommonUtils.VideoSupport.NoExternalBanned;
    }
    long l = getFreeSpace();
    if (l < 62914560L)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getTrimSupport() sdCardFreeSpace=");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append(" STORAGE_LIMIT=");
        ((StringBuilder)localObject).append(62914560L);
        QLog.i("QZoneVideoCommonUtils", 2, ((StringBuilder)localObject).toString());
      }
      return QZoneVideoCommonUtils.VideoSupport.ExternalSpaceBanned;
    }
    return QZoneVideoCommonUtils.VideoSupport.Available;
  }
  
  public static void gotoRecordPreview(Activity paramActivity, int paramInt, String paramString, long paramLong, Bundle paramBundle)
  {
    ((IQZoneVideoCommonUtilsProxy)QRoute.api(IQZoneVideoCommonUtilsProxy.class)).gotoRecordPreview(paramActivity, paramInt, paramString, paramLong, paramBundle);
  }
  
  public static void installVideoActivity(long paramLong, Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    ((IQZoneVideoCommonUtilsProxy)QRoute.api(IQZoneVideoCommonUtilsProxy.class)).installVideoActivity(paramLong, paramActivity, paramBoolean1, paramBoolean2, paramString);
  }
  
  public static void installVideoActivity(long paramLong, Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2, String paramString1, boolean paramBoolean3, boolean paramBoolean4, String paramString2, boolean paramBoolean5, String paramString3, String paramString4, Intent paramIntent)
  {
    ((IQZoneVideoCommonUtilsProxy)QRoute.api(IQZoneVideoCommonUtilsProxy.class)).installVideoActivity(paramLong, paramActivity, paramBoolean1, paramBoolean2, paramString1, paramBoolean3, paramBoolean4, paramString2, paramBoolean5, paramString3, paramString4, paramIntent);
  }
  
  public static void installVideoActivity(Activity paramActivity, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, String paramString2, String paramString3, Intent paramIntent)
  {
    boolean bool1 = getRecordSupport().isAvailable();
    boolean bool2 = getTrimSupport().isAvailable();
    ((IQZoneVideoCommonUtilsProxy)QRoute.api(IQZoneVideoCommonUtilsProxy.class)).installVideoActivity(bool1, bool2, paramActivity, paramString1, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramBoolean6, paramString2, paramString3, paramIntent);
  }
  
  public static void installVideoActivityForOther(long paramLong, Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2, String paramString, Bundle paramBundle)
  {
    ((IQZoneVideoCommonUtilsProxy)QRoute.api(IQZoneVideoCommonUtilsProxy.class)).installVideoActivityForOther(paramLong, paramActivity, paramBoolean1, paramBoolean2, paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.QZoneVideoCommonUtils
 * JD-Core Version:    0.7.0.1
 */