package com.tencent.mobileqq.weiyun.sdk.download;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.weiyun.api.download.IDownloadListener;
import com.tencent.mobileqq.weiyun.api.download.IDownloadStatusListener;
import com.tencent.mobileqq.weiyun.model.WeiyunDownloadStatusInfo;
import java.io.File;

class WyDownloader$3
  implements IDownloadListener
{
  WyDownloader$3(WyDownloader paramWyDownloader, IDownloadStatusListener paramIDownloadStatusListener, int paramInt) {}
  
  public void a(String paramString, long paramLong, float paramFloat)
  {
    WeiyunDownloadStatusInfo localWeiyunDownloadStatusInfo = new WeiyunDownloadStatusInfo();
    localWeiyunDownloadStatusInfo.c = paramString;
    localWeiyunDownloadStatusInfo.jdField_a_of_type_Int = 2;
    localWeiyunDownloadStatusInfo.jdField_b_of_type_Long = (paramFloat);
    localWeiyunDownloadStatusInfo.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqWeiyunApiDownloadIDownloadStatusListener.a(paramString, this.jdField_a_of_type_Int, localWeiyunDownloadStatusInfo, false);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("download finish:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" successed:");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append("errorCode:");
    ((StringBuilder)localObject).append(paramInt);
    Log.e("WyDownloader", ((StringBuilder)localObject).toString());
    int i;
    if ((paramBoolean) && (paramString1 != null) && (!TextUtils.isEmpty(paramString2)) && (new File(paramString2).exists())) {
      i = 1;
    } else {
      i = 0;
    }
    localObject = new WeiyunDownloadStatusInfo();
    ((WeiyunDownloadStatusInfo)localObject).jdField_b_of_type_JavaLangString = paramString2;
    ((WeiyunDownloadStatusInfo)localObject).c = paramString1;
    ((WeiyunDownloadStatusInfo)localObject).jdField_b_of_type_Int = paramInt;
    ((WeiyunDownloadStatusInfo)localObject).jdField_a_of_type_JavaLangString = paramString3;
    if (i != 0)
    {
      ((WeiyunDownloadStatusInfo)localObject).jdField_a_of_type_Int = 4;
      this.jdField_a_of_type_ComTencentMobileqqWeiyunApiDownloadIDownloadStatusListener.a(paramString1, this.jdField_a_of_type_Int, (WeiyunDownloadStatusInfo)localObject, true);
      return;
    }
    ((WeiyunDownloadStatusInfo)localObject).jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_ComTencentMobileqqWeiyunApiDownloadIDownloadStatusListener.a(paramString1, this.jdField_a_of_type_Int, (WeiyunDownloadStatusInfo)localObject, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.sdk.download.WyDownloader.3
 * JD-Core Version:    0.7.0.1
 */