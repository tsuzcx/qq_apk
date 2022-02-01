package com.tencent.qzonehub.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.mediacodec.ShortVideoCodec;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneVideoCommonUtilsProxy;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneVideoCommonUtils.VideoSupport;
import cooperation.qzone.QZoneVideoDownloadActivity;
import mqq.app.MobileQQ;

public class QZoneVideoCommonUtilsProxyImpl
  implements IQZoneVideoCommonUtilsProxy
{
  private static final String TAG = "QZoneVideoCommonUtils";
  public static final String TRIM_HW_LOCAL_BLACK_LIST = "GT-N7100|";
  
  public void forwardToQCircleEdit(Activity paramActivity, Bundle paramBundle)
  {
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), QZoneVideoDownloadActivity.class);
    localIntent.putExtras(paramBundle);
    localIntent.putExtra("from_qcircle", true);
    paramActivity.startActivity(localIntent);
  }
  
  public QZoneVideoCommonUtils.VideoSupport getTrimHWSupport()
  {
    Object localObject = QzoneConfig.getInstance();
    int i = 1;
    if (((QzoneConfig)localObject).getConfig("MiniVideo", "videoTrimEnableHw", 1) != 1) {
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Build.Model=");
      ((StringBuilder)localObject).append(Build.MODEL);
      QLog.d("QZoneVideoCommonUtils", 2, ((StringBuilder)localObject).toString());
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
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getTrimHWSupport() localSdkVersion=");
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append(" serverSdkVersion=");
        ((StringBuilder)localObject).append(j);
        QLog.i("QZoneVideoCommonUtils", 2, ((StringBuilder)localObject).toString());
      }
      return QZoneVideoCommonUtils.VideoSupport.OSVersionBanned;
    }
    j = ShortVideoCodec.checkSupportMediaCodecFeature(MobileQQ.getContext());
    if (((j & 0x1) <= 0) || ((j & 0x2) <= 0)) {
      i = 0;
    }
    if (i == 0) {
      return QZoneVideoCommonUtils.VideoSupport.CodecFeatureBanned;
    }
    return QZoneVideoCommonUtils.VideoSupport.Available;
  }
  
  public void gotoRecordPreview(Activity paramActivity, int paramInt, String paramString, long paramLong, Bundle paramBundle)
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
  
  public void installVideoActivity(long paramLong, Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QZoneVideoCommonUtils", 2, "installVideoActivity");
    }
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), QZoneVideoDownloadActivity.class);
    localIntent.putExtra("support_record", paramBoolean1);
    localIntent.putExtra("support_trim", paramBoolean2);
    localIntent.putExtra("uin", String.valueOf(paramLong));
    localIntent.putExtra("flow_camera_capture_mode", false);
    localIntent.putExtra("entry_source", 9);
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("video_refer", paramString);
    }
    paramActivity.startActivity(localIntent);
  }
  
  public void installVideoActivity(long paramLong, Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2, String paramString1, boolean paramBoolean3, boolean paramBoolean4, String paramString2, boolean paramBoolean5, String paramString3, String paramString4, Intent paramIntent)
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
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("callback:");
        paramString2.append(paramString3);
        paramString2.append(" id:");
        paramString2.append(paramString4);
        QLog.d("QZoneVideoCommonUtils", 2, paramString2.toString());
      }
      localIntent.putExtra("callback", paramString3);
      localIntent.putExtra("dongxiao_id", paramString4);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      localIntent.putExtra("video_refer", paramString1);
    }
    paramActivity.startActivity(localIntent);
  }
  
  public void installVideoActivity(boolean paramBoolean1, boolean paramBoolean2, Activity paramActivity, String paramString1, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, String paramString2, String paramString3, Intent paramIntent)
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
    localIntent.putExtra("uin", "0");
    localIntent.putExtra("is_qzone_vip", paramBoolean3);
    localIntent.putExtra("enable_edit_video", true);
    localIntent.putExtra("enterPtu", true);
    localIntent.putExtra("enable_local_button", paramBoolean8);
    localIntent.putExtra("enable_edit_button", paramBoolean5);
    localIntent.putExtra("callback", "qzoneOpenDongXiao");
    localIntent.putExtra("dongxiao_id", paramString2);
    localIntent.putExtra("enable_priv_list", false);
    localIntent.putExtra("enable_input_text", paramBoolean4);
    if (paramBoolean4) {
      localIntent.putExtra("enable_sync_qzone", paramBoolean6);
    }
    localIntent.putExtra("enable_origin_video", paramBoolean7);
    localIntent.putExtra("confirm_text", paramString3);
    if (!TextUtils.isEmpty(paramString1)) {
      localIntent.putExtra("video_refer", paramString1);
    }
    paramActivity.startActivity(localIntent);
  }
  
  public void installVideoActivityForOther(long paramLong, Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2, String paramString, Bundle paramBundle)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QZoneVideoCommonUtilsProxyImpl
 * JD-Core Version:    0.7.0.1
 */