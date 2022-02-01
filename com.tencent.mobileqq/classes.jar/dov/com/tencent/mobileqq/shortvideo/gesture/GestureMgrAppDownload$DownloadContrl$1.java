package dov.com.tencent.mobileqq.shortvideo.gesture;

import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class GestureMgrAppDownload$DownloadContrl$1
  implements INetEngineListener
{
  GestureMgrAppDownload$DownloadContrl$1(GestureMgrAppDownload.DownloadContrl paramDownloadContrl, String paramString, DownloadInfo paramDownloadInfo, int paramInt1, int paramInt2) {}
  
  public void onResp(NetResp paramNetResp)
  {
    HttpNetReq localHttpNetReq = (HttpNetReq)paramNetResp.mReq;
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoGestureGestureMgrAppDownload$DownloadContrl.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq == localHttpNetReq) {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoGestureGestureMgrAppDownload$DownloadContrl.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QavGesture", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localHttpNetReq.mReqUrl, Integer.valueOf(paramNetResp.mResult), Integer.valueOf(paramNetResp.mHttpCode), this.jdField_a_of_type_JavaLangString }));
    }
    int i;
    if (paramNetResp.mResult == 0)
    {
      paramNetResp = new File(localHttpNetReq.mOutPath);
      if (paramNetResp.exists())
      {
        try
        {
          String str = paramNetResp.getParent();
          FileUtils.a(localHttpNetReq.mOutPath, str, false);
          GestureMgrAppDownload.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoGestureDownloadInfo, this.jdField_a_of_type_Int);
          i = 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            i = 0;
          }
          GestureMgrAppDownload.a(-1);
          return;
        }
        paramNetResp.delete();
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        GestureMgrAppDownload.a(100 / this.jdField_a_of_type_DovComTencentMobileqqShortvideoGestureGestureMgrAppDownload$DownloadContrl.jdField_a_of_type_Int + this.jdField_a_of_type_DovComTencentMobileqqShortvideoGestureGestureMgrAppDownload$DownloadContrl.b);
        paramNetResp = this.jdField_a_of_type_DovComTencentMobileqqShortvideoGestureGestureMgrAppDownload$DownloadContrl;
        paramNetResp.b += 100 / this.jdField_a_of_type_DovComTencentMobileqqShortvideoGestureGestureMgrAppDownload$DownloadContrl.jdField_a_of_type_Int;
        if (!this.jdField_a_of_type_DovComTencentMobileqqShortvideoGestureGestureMgrAppDownload$DownloadContrl.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoGestureDownloadInfo, this.b - 1)) {
          this.jdField_a_of_type_DovComTencentMobileqqShortvideoGestureGestureMgrAppDownload$DownloadContrl.jdField_a_of_type_Boolean = false;
        }
        return;
      }
      i = 0;
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 == 0L) {
      i = 0;
    }
    for (;;)
    {
      GestureMgrAppDownload.a(i / this.jdField_a_of_type_DovComTencentMobileqqShortvideoGestureGestureMgrAppDownload$DownloadContrl.jdField_a_of_type_Int + this.jdField_a_of_type_DovComTencentMobileqqShortvideoGestureGestureMgrAppDownload$DownloadContrl.b);
      return;
      if (paramLong1 >= paramLong2) {
        i = 99;
      } else {
        i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.gesture.GestureMgrAppDownload.DownloadContrl.1
 * JD-Core Version:    0.7.0.1
 */