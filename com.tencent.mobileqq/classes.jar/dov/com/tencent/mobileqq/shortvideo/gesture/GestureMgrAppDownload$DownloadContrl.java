package dov.com.tencent.mobileqq.shortvideo.gesture;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class GestureMgrAppDownload$DownloadContrl
{
  int jdField_a_of_type_Int = 0;
  HttpNetReq jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
  DownloadInfo jdField_a_of_type_DovComTencentMobileqqShortvideoGestureDownloadInfo = null;
  boolean jdField_a_of_type_Boolean = false;
  int b = 0;
  int c = 0;
  
  boolean a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    String str2;
    String str1;
    int i;
    if (!GestureUtil.d(paramDownloadInfo))
    {
      str2 = paramDownloadInfo.jdField_a_of_type_JavaLangString;
      str1 = paramDownloadInfo.b;
      i = 1;
    }
    String str3;
    for (;;)
    {
      str3 = GestureUtil.b() + str1;
      if (paramInt >= 0) {
        break label150;
      }
      QLog.d("QavGesture", 1, String.format("downloadRes, 下载死循环了. res_flag[%s], info[%s]", new Object[] { Integer.valueOf(i), paramDownloadInfo }));
      GestureMgrAppDownload.a(-3);
      return false;
      if ((paramDownloadInfo.jdField_a_of_type_Boolean) && (!GestureUtil.c(paramDownloadInfo)))
      {
        str2 = paramDownloadInfo.c;
        str1 = paramDownloadInfo.d;
        i = 2;
      }
      else
      {
        if ((!GestureUtil.a(paramDownloadInfo)) || (GestureUtil.b(paramDownloadInfo))) {
          break;
        }
        str2 = paramDownloadInfo.i;
        str1 = paramDownloadInfo.j;
        i = 3;
      }
    }
    GestureMgrAppDownload.a(100);
    return false;
    label150:
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = new GestureMgrAppDownload.DownloadContrl.1(this, str1, paramDownloadInfo, i, paramInt);
    localHttpNetReq.setUserData(i + "_" + str1);
    localHttpNetReq.mReqUrl = str2;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = new File(str3).getPath();
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.a(NetworkCenter.getInstance().getNetType());
    try
    {
      paramDownloadInfo = BaseApplicationImpl.getApplication().getRuntime();
      if (!(paramDownloadInfo instanceof QQAppInterface)) {
        break label367;
      }
      paramDownloadInfo = (IHttpEngineService)((QQAppInterface)paramDownloadInfo).getRuntimeService(IHttpEngineService.class, "all");
      if (paramDownloadInfo == null) {
        break label367;
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = localHttpNetReq;
      paramDownloadInfo.sendReq(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
      bool = true;
    }
    catch (Exception paramDownloadInfo)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          paramDownloadInfo.printStackTrace();
        }
        boolean bool = false;
      }
    }
    if (!bool) {
      GestureMgrAppDownload.a(-2);
    }
    if (QLog.isColorLevel()) {
      QLog.i("QavGesture", 2, String.format("downloadRes, res_flag[%s], md5[%s], etr[%s]", new Object[] { Integer.valueOf(i), str1, Boolean.valueOf(bool) }));
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.gesture.GestureMgrAppDownload.DownloadContrl
 * JD-Core Version:    0.7.0.1
 */