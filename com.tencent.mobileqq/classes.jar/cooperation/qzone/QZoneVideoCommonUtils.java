package cooperation.qzone;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import bbhm;
import com.tencent.mobileqq.shortvideo.mediacodec.ShortVideoCodec;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.util.CpuUtils;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QzoneHardwareRestriction;
import mqq.app.MobileQQ;

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
  private static long mCpuFeature = -1L;
  
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
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "support record=" + localVideoSupport1.isAvailable() + ", support trim=" + localVideoSupport2.isAvailable());
    }
    if ((!localVideoSupport1.isAvailable()) && (!localVideoSupport2.isAvailable()))
    {
      if (localVideoSupport1.isShowTip()) {}
      for (paramString = localVideoSupport1.getTip();; paramString = null)
      {
        if (paramString != null)
        {
          paramBundle = paramString;
          if (paramString.length() != 0) {}
        }
        else
        {
          paramBundle = paramActivity.getString(2131717516);
        }
        if (paramonForwardVideoActivityFailedListener != null) {
          paramonForwardVideoActivityFailedListener.onFail(paramActivity, paramBundle);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("QZoneVideoCommonUtils", 2, "qzone video is not supported, recordSupport tips=" + localVideoSupport1.getTip() + ",trimSupport tips=" + localVideoSupport2.getTip() + ",show tips=" + paramBundle);
        return;
      }
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
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "support record=" + localVideoSupport1.isAvailable() + ", support trim=" + localVideoSupport2.isAvailable());
    }
    if ((!localVideoSupport1.isAvailable()) && (!localVideoSupport2.isAvailable()))
    {
      if (localVideoSupport1.isShowTip()) {}
      for (paramString = localVideoSupport1.getTip();; paramString = null)
      {
        String str;
        if (paramString != null)
        {
          str = paramString;
          if (paramString.length() != 0) {}
        }
        else
        {
          str = paramActivity.getString(2131717516);
        }
        if (paramonForwardVideoActivityFailedListener != null) {
          paramonForwardVideoActivityFailedListener.onFail(paramActivity, str);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("QZoneVideoCommonUtils", 2, "qzone video is not supported, recordSupport tips=" + localVideoSupport1.getTip() + ",trimSupport tips=" + localVideoSupport2.getTip() + ",show tips=" + str);
        return;
      }
    }
    installVideoActivity(paramLong, paramActivity, localVideoSupport1.isAvailable(), localVideoSupport2.isAvailable(), paramString);
    PerfTracer.traceEnd("Video_component_pre_launch");
  }
  
  public static void forwardToQCircleEdit(Activity paramActivity, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), QZoneVideoDownloadActivity.class);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("from_qcircle", true);
    paramActivity.startActivity(localIntent);
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
    return QzoneHardwareRestriction.getCpuMaxFreq() / 1024L;
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
    int j = -1;
    if (QzoneConfig.getInstance().getConfig("MiniVideo", "SupportMiniVideo", -1) == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() severBlackList");
      }
      return QZoneVideoCommonUtils.VideoSupport.BlackListBanned;
    }
    int i = QzoneConfig.getInstance().getConfig("TrimVideo", "NeedLocalBlackList", 1);
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "Build.Model=" + Build.MODEL);
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
      i = QzoneConfig.getInstance().getConfig("MiniVideo", "MinSdkVersion", 21);
      j = Build.VERSION.SDK_INT;
      if (j < i)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() localSdkVersion=" + j + " serverSdkVersion=" + i);
        }
        return QZoneVideoCommonUtils.VideoSupport.OSVersionBanned;
      }
    }
    else
    {
      if (mCpuFamily < 0) {
        getCpuFamily();
      }
      if (mCpuFeature < 0L) {
        mCpuFeature = CpuUtils.getCpuProperty();
      }
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() mCpuFamily=" + mCpuFamily + " mCpuFeature=" + mCpuFeature);
      }
      int k = QzoneConfig.getInstance().getConfig("MiniVideo", "SupportedCpuFamily", 2);
      if (mCpuFamily >= 0) {}
      for (i = 1 << mCpuFamily; (i & k) == 0; i = 1)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() serverCpuFamily=" + k + " mCpuFamily=" + mCpuFamily);
        }
        return QZoneVideoCommonUtils.VideoSupport.OrderSetBanned;
      }
      Object localObject = QzoneConfig.getInstance().getConfig("MiniVideo", "RequiredCpuFeatures", "#101##").split("#", -1);
      if (mCpuFamily >= localObject.length) {
        if (QLog.isColorLevel()) {
          QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() mCpuFamily=" + mCpuFamily + " serverCpuFeatureList.length=" + localObject.length);
        }
      }
      label440:
      label617:
      for (;;)
      {
        if (!QzoneHardwareRestriction.meetHardwareRestriction(0, 1))
        {
          return QZoneVideoCommonUtils.VideoSupport.HardwareLimited;
          localObject = localObject[mCpuFamily];
          i = ((String)localObject).length() - 1;
        }
        for (;;)
        {
          if (i < 0) {
            break label617;
          }
          j += 1;
          if (j > 63)
          {
            if (!QLog.isColorLevel()) {
              break label440;
            }
            QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() longValueIndex>63  serverFeature=" + (String)localObject + " mCpuFeature=" + mCpuFeature);
            break label440;
            break;
          }
          if ((((String)localObject).charAt(i) == '1') && ((mCpuFeature & 1L << j) == 0L))
          {
            if (QLog.isColorLevel()) {
              QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() cpuFeature unsatisfied. bitIndex=" + i + " serverFeature=" + (String)localObject + " mCpuFeature=" + mCpuFeature);
            }
            return QZoneVideoCommonUtils.VideoSupport.OrderSetBanned;
          }
          i -= 1;
        }
      }
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
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getRecordSupport() sdCardFreeSpace=" + l + " STORAGE_LIMIT=" + 62914560L);
      }
      return QZoneVideoCommonUtils.VideoSupport.ExternalSpaceBanned;
    }
    if (!bbhm.a())
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
    int i = 1;
    if (QzoneConfig.getInstance().getConfig("MiniVideo", "videoTrimEnableHw", 1) != 1) {
      return QZoneVideoCommonUtils.VideoSupport.BlackListBanned;
    }
    if (QzoneConfig.getInstance().getConfig("TrimVideo", "SupportTrimVideoHW", -1) == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimHWSupport() severBlackList");
      }
      return QZoneVideoCommonUtils.VideoSupport.BlackListBanned;
    }
    int j = QzoneConfig.getInstance().getConfig("TrimVideo", "NeedLocalBlackList", 1);
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "Build.Model=" + Build.MODEL);
    }
    if ((j > 0) && ("GT-N7100|".contains(Build.MODEL)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimHWSupport() localBlackList");
      }
      return QZoneVideoCommonUtils.VideoSupport.BlackListBanned;
    }
    j = QzoneConfig.getInstance().getConfig("TrimVideo", "MinSdkVersionHw", 18);
    int k = Build.VERSION.SDK_INT;
    if (k < j)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimHWSupport() localSdkVersion=" + k + " serverSdkVersion=" + j);
      }
      return QZoneVideoCommonUtils.VideoSupport.OSVersionBanned;
    }
    j = ShortVideoCodec.checkSupportMediaCodecFeature(MobileQQ.getContext());
    if (((j & 0x1) > 0) && ((j & 0x2) > 0)) {}
    while (i == 0)
    {
      return QZoneVideoCommonUtils.VideoSupport.CodecFeatureBanned;
      i = 0;
    }
    return QZoneVideoCommonUtils.VideoSupport.Available;
  }
  
  public static QZoneVideoCommonUtils.VideoSupport getTrimSupport()
  {
    QZoneVideoCommonUtils.VideoSupport localVideoSupport = getTrimHWSupport();
    if (localVideoSupport.isAvailable()) {
      return localVideoSupport;
    }
    if (QzoneConfig.getInstance().getConfig("TrimVideo", "SupportTrimVideo", -1) == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() severBlackList");
      }
      return QZoneVideoCommonUtils.VideoSupport.BlackListBanned;
    }
    int i = QzoneConfig.getInstance().getConfig("TrimVideo", "NeedLocalBlackList", 1);
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "Build.Model=" + Build.MODEL);
    }
    if ((i > 0) && ("M032|ASUS_T00F".contains(Build.MODEL)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() localBlackList");
      }
      return QZoneVideoCommonUtils.VideoSupport.BlackListBanned;
    }
    int j;
    if (QzoneConfig.getInstance().getConfig("TrimVideo", "IgnoreLocalJudge", -1) == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() severWhiteList");
      }
      i = QzoneConfig.getInstance().getConfig("TrimVideo", "MinSdkVersion", 14);
      j = Build.VERSION.SDK_INT;
      if (j < i)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() localSdkVersion=" + j + " serverSdkVersion=" + i);
        }
        return QZoneVideoCommonUtils.VideoSupport.OSVersionBanned;
      }
    }
    else
    {
      if (mCpuFamily < 0) {
        getCpuFamily();
      }
      if (mCpuFeature < 0L) {}
      for (;;)
      {
        try
        {
          mCpuFeature = CpuUtils.getCpuProperty();
          if (QLog.isColorLevel()) {
            QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() mCpuFamily=" + mCpuFamily + " mCpuFeature=" + mCpuFeature);
          }
          j = QzoneConfig.getInstance().getConfig("TrimVideo", "SupportedCpuFamily", 2);
          if (mCpuFamily >= 0)
          {
            i = mCpuFamily;
            if ((1 << i & j) != 0) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() serverCpuFamily=" + j + " mCpuFamily=" + mCpuFamily);
            }
            return QZoneVideoCommonUtils.VideoSupport.OrderSetBanned;
          }
        }
        catch (Exception localException)
        {
          return QZoneVideoCommonUtils.VideoSupport.OrderSetBanned;
        }
        i = 0;
      }
      Object localObject = QzoneConfig.getInstance().getConfig("TrimVideo", "RequiredCpuFeatures", "#101##").split("#", -1);
      if (mCpuFamily >= localObject.length) {
        if (QLog.isColorLevel()) {
          QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() mCpuFamily=" + mCpuFamily + " serverCpuFeatureList.length=" + localObject.length);
        }
      }
      label643:
      for (;;)
      {
        label464:
        if (!QzoneHardwareRestriction.meetHardwareRestriction(0, 1))
        {
          return QZoneVideoCommonUtils.VideoSupport.HardwareLimited;
          localObject = localObject[mCpuFamily];
          i = ((String)localObject).length() - 1;
          j = -1;
        }
        for (;;)
        {
          if (i < 0) {
            break label643;
          }
          j += 1;
          if (j > 63)
          {
            if (!QLog.isColorLevel()) {
              break label464;
            }
            QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() longValueIndex>63  serverFeature=" + (String)localObject + " mCpuFeature=" + mCpuFeature);
            break label464;
            break;
          }
          if ((((String)localObject).charAt(i) == '1') && ((mCpuFeature & 1L << j) == 0L))
          {
            if (QLog.isColorLevel()) {
              QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() cpuFeature unsatisfied. bitIndex=" + i + " serverFeature=" + (String)localObject + " mCpuFeature=" + mCpuFeature);
            }
            return QZoneVideoCommonUtils.VideoSupport.OrderSetBanned;
          }
          i -= 1;
        }
      }
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
      if (QLog.isColorLevel()) {
        QLog.i("QZoneVideoCommonUtils", 2, "getTrimSupport() sdCardFreeSpace=" + l + " STORAGE_LIMIT=" + 62914560L);
      }
      return QZoneVideoCommonUtils.VideoSupport.ExternalSpaceBanned;
    }
    return QZoneVideoCommonUtils.VideoSupport.Available;
  }
  
  public static void gotoRecordPreview(Activity paramActivity, int paramInt, String paramString, long paramLong, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), QZoneVideoDownloadActivity.class);
    localIntent.putExtra("video_type", paramInt);
    localIntent.putExtra("file_send_path", paramString);
    localIntent.putExtra("preview_video", true);
    localIntent.putExtra("start_time", 0);
    localIntent.putExtra("end_time", paramLong);
    localIntent.putExtra("encode_video_params", paramBundle);
    localIntent.putExtra("video_refer", "QZonePublishMoodTabActivity");
    paramActivity.startActivity(localIntent);
  }
  
  public static void installVideoActivity(long paramLong, Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "installVideoActivity");
    }
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), QZoneVideoDownloadActivity.class);
    localIntent.putExtra("support_record", paramBoolean1);
    localIntent.putExtra("support_trim", paramBoolean2);
    localIntent.putExtra("uin", String.valueOf(paramLong));
    localIntent.putExtra("flow_camera_capture_mode", false);
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("video_refer", paramString);
    }
    paramActivity.startActivity(localIntent);
  }
  
  public static void installVideoActivity(long paramLong, Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2, String paramString1, boolean paramBoolean3, boolean paramBoolean4, String paramString2, boolean paramBoolean5, String paramString3, String paramString4, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "installVideoActivity");
    }
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), QZoneVideoDownloadActivity.class);
    if (paramIntent != null) {
      localIntent.putExtras(paramIntent);
    }
    localIntent.putExtra("support_record", paramBoolean1);
    localIntent.putExtra("support_trim", paramBoolean2);
    localIntent.putExtra("uin", String.valueOf(paramLong));
    localIntent.putExtra("is_qzone_vip", paramBoolean3);
    localIntent.putExtra("enable_edit_video", paramBoolean4);
    localIntent.putExtra("topicId", paramString2);
    localIntent.putExtra("enterPtu", paramBoolean5);
    if (!TextUtils.isEmpty(paramString3))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QZoneVideoCommonUtils", 2, "callback:" + paramString3 + " id:" + paramString4);
      }
      localIntent.putExtra("callback", paramString3);
      localIntent.putExtra("dongxiao_id", paramString4);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      localIntent.putExtra("video_refer", paramString1);
    }
    paramActivity.startActivity(localIntent);
  }
  
  public static void installVideoActivity(Activity paramActivity, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, String paramString2, String paramString3, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "installVideoActivity");
    }
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), QZoneVideoDownloadActivity.class);
    if (paramIntent != null) {
      localIntent.putExtras(paramIntent);
    }
    localIntent.putExtra("support_record", getRecordSupport().isAvailable());
    localIntent.putExtra("support_trim", getTrimSupport().isAvailable());
    localIntent.putExtra("uin", "0");
    localIntent.putExtra("is_qzone_vip", paramBoolean1);
    localIntent.putExtra("enable_edit_video", true);
    localIntent.putExtra("enterPtu", true);
    localIntent.putExtra("enable_local_button", paramBoolean6);
    localIntent.putExtra("enable_edit_button", paramBoolean3);
    localIntent.putExtra("callback", "qzoneOpenDongXiao");
    localIntent.putExtra("dongxiao_id", paramString2);
    localIntent.putExtra("enable_priv_list", false);
    localIntent.putExtra("enable_input_text", paramBoolean2);
    if (paramBoolean2) {
      localIntent.putExtra("enable_sync_qzone", paramBoolean4);
    }
    localIntent.putExtra("enable_origin_video", paramBoolean5);
    localIntent.putExtra("confirm_text", paramString3);
    if (!TextUtils.isEmpty(paramString1)) {
      localIntent.putExtra("video_refer", paramString1);
    }
    paramActivity.startActivity(localIntent);
  }
  
  public static void installVideoActivityForOther(long paramLong, Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2, String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "installVideoActivityForEditVideo");
    }
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), QZoneVideoDownloadActivity.class);
    localIntent.putExtra("uin", String.valueOf(paramLong));
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("video_refer", paramString);
    }
    localIntent.putExtras(paramBundle);
    paramActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneVideoCommonUtils
 * JD-Core Version:    0.7.0.1
 */