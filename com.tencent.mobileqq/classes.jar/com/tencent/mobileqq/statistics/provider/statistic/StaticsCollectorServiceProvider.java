package com.tencent.mobileqq.statistics.provider.statistic;

import android.text.TextUtils;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.bridge.statistics.service.IStatisticsCollectorService;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.qqperf.abfactor.AbFactorManger;
import java.util.HashMap;

public class StaticsCollectorServiceProvider
  implements IStatisticsCollectorService, Provider<IStatisticsCollectorService>
{
  private String[] a = { "actC2CPicUploadV1", "actC2CPicUploadV2", "actGroupPicUploadV2", "actDiscussPicUploadV2", "actC2CPicDownloadV1", "actC2CPicSmallDownV1", "actGroupPicUploadV1", "actGroupPicDownloadV1", "actGroupPicSmallDownV1", "actDiscussPicUpload", "actDiscussPicDown", "actDiscussPicSmallDown", "actGrpPttUp", "actGrpPttDown", "actDisscusPttUp", "actDisscusPttDown", "actC2CStreamPttUpload", "actC2CStreamPttDownload", "actC2CPttDownload", "actC2CPttUpload", "actFileDown", "actFileUp", "actFileOf2Of", "actFileOf2Wy", "actFileWy2Of", "actFileWyUp", "actFileWyDown", "actFileUpDetail", "actFileDownDetail", "actFAFileDown", "actFAFileUp", "actShortVideoUpload", "actShortVideoUploadBDH", "actShortVideoDiscussgroupUploadBDH", "actShortVideoForwardBDH", "actShortVideoDownloadVideo", "actShortVideoDownloadThumb", "actShortVideoDiscussgroupUpload", "actShortVideoDiscussgroupDownloadVideo", "actShortVideoDiscussgroupDownloadThumb", "PicStatisticsManagerUploadPic" };
  
  public void a(String paramString, HashMap<String, String> paramHashMap)
  {
    AbFactorManger.a(paramString, paramHashMap);
  }
  
  public boolean a()
  {
    return PrivacyPolicyHelper.d();
  }
  
  public boolean a(String paramString)
  {
    String[] arrayOfString = this.a;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (TextUtils.equals(arrayOfString[i], paramString)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public IStatisticsCollectorService b()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.provider.statistic.StaticsCollectorServiceProvider
 * JD-Core Version:    0.7.0.1
 */