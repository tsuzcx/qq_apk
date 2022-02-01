package cooperation.weiyun.sdk.download;

import android.text.TextUtils;
import android.util.Log;
import java.io.File;

class WyDownloader$3
  implements WyDownloader.IDownloadListener
{
  WyDownloader$3(WyDownloader paramWyDownloader, WyDownloader.IDownloadStatusListener paramIDownloadStatusListener, int paramInt) {}
  
  public void a(String paramString, long paramLong, float paramFloat)
  {
    DownloadJobContext.StatusInfo localStatusInfo = new DownloadJobContext.StatusInfo();
    localStatusInfo.c = paramString;
    localStatusInfo.jdField_a_of_type_Int = 2;
    localStatusInfo.jdField_b_of_type_Long = (paramFloat);
    localStatusInfo.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_CooperationWeiyunSdkDownloadWyDownloader$IDownloadStatusListener.a(paramString, this.jdField_a_of_type_Int, localStatusInfo, false);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    Log.e("WyDownloader", "download finish:" + paramString1 + " successed:" + paramBoolean + "errorCode:" + paramInt);
    if ((paramBoolean) && (paramString1 != null) && (!TextUtils.isEmpty(paramString2)) && (new File(paramString2).exists())) {}
    DownloadJobContext.StatusInfo localStatusInfo;
    for (int i = 1;; i = 0)
    {
      localStatusInfo = new DownloadJobContext.StatusInfo();
      localStatusInfo.jdField_b_of_type_JavaLangString = paramString2;
      localStatusInfo.c = paramString1;
      localStatusInfo.jdField_b_of_type_Int = paramInt;
      localStatusInfo.jdField_a_of_type_JavaLangString = paramString3;
      if (i == 0) {
        break;
      }
      localStatusInfo.jdField_a_of_type_Int = 4;
      this.jdField_a_of_type_CooperationWeiyunSdkDownloadWyDownloader$IDownloadStatusListener.a(paramString1, this.jdField_a_of_type_Int, localStatusInfo, true);
      return;
    }
    localStatusInfo.jdField_a_of_type_Int = 5;
    this.jdField_a_of_type_CooperationWeiyunSdkDownloadWyDownloader$IDownloadStatusListener.a(paramString1, this.jdField_a_of_type_Int, localStatusInfo, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.weiyun.sdk.download.WyDownloader.3
 * JD-Core Version:    0.7.0.1
 */