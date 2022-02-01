package cooperation.gmersdk_warper;

import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class TMG_Downloader$DownloadContrl$1
  implements INetEngineListener
{
  TMG_Downloader$DownloadContrl$1(TMG_Downloader.DownloadContrl paramDownloadContrl, String paramString, TMG_DownloadInfo paramTMG_DownloadInfo) {}
  
  public void onResp(NetResp paramNetResp)
  {
    HttpNetReq localHttpNetReq = (HttpNetReq)paramNetResp.mReq;
    if (this.jdField_a_of_type_CooperationGmersdk_warperTMG_Downloader$DownloadContrl.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq == localHttpNetReq) {
      this.jdField_a_of_type_CooperationGmersdk_warperTMG_Downloader$DownloadContrl.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = null;
    }
    boolean bool = QLog.isColorLevel();
    int i = 1;
    if (bool) {
      QLog.i("TMG_Downloader", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localHttpNetReq.mReqUrl, Integer.valueOf(paramNetResp.mResult), Integer.valueOf(paramNetResp.mHttpCode), this.jdField_a_of_type_JavaLangString }));
    }
    if (paramNetResp.mResult == 0)
    {
      paramNetResp = new File(localHttpNetReq.mOutPath);
      if (paramNetResp.exists()) {
        try
        {
          paramNetResp = paramNetResp.getParent();
          FileUtils.uncompressZip(localHttpNetReq.mOutPath, paramNetResp, false);
          TMG_Downloader.a(this.jdField_a_of_type_CooperationGmersdk_warperTMG_DownloadInfo.b);
        }
        catch (Exception paramNetResp)
        {
          paramNetResp.printStackTrace();
        }
      }
    }
    i = 0;
    if (i != 0)
    {
      if (this.jdField_a_of_type_CooperationGmersdk_warperTMG_Downloader$DownloadContrl.jdField_a_of_type_CooperationGmersdk_warperTMG_Downloader$TMG_Downloader_DownloadEvent != null)
      {
        this.jdField_a_of_type_CooperationGmersdk_warperTMG_Downloader$DownloadContrl.jdField_a_of_type_CooperationGmersdk_warperTMG_Downloader$TMG_Downloader_DownloadEvent.a(100);
        this.jdField_a_of_type_CooperationGmersdk_warperTMG_Downloader$DownloadContrl.jdField_a_of_type_CooperationGmersdk_warperTMG_Downloader$TMG_Downloader_DownloadEvent.a(0, "Download Complete!!!");
      }
      this.jdField_a_of_type_CooperationGmersdk_warperTMG_Downloader$DownloadContrl.jdField_a_of_type_Boolean = false;
      return;
    }
    if (this.jdField_a_of_type_CooperationGmersdk_warperTMG_Downloader$DownloadContrl.jdField_a_of_type_CooperationGmersdk_warperTMG_Downloader$TMG_Downloader_DownloadEvent != null) {
      this.jdField_a_of_type_CooperationGmersdk_warperTMG_Downloader$DownloadContrl.jdField_a_of_type_CooperationGmersdk_warperTMG_Downloader$TMG_Downloader_DownloadEvent.a(2, "");
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 == 0L) {
      i = 0;
    } else if (paramLong1 >= paramLong2) {
      i = 99;
    } else {
      i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    }
    if (this.jdField_a_of_type_CooperationGmersdk_warperTMG_Downloader$DownloadContrl.jdField_a_of_type_CooperationGmersdk_warperTMG_Downloader$TMG_Downloader_DownloadEvent != null) {
      this.jdField_a_of_type_CooperationGmersdk_warperTMG_Downloader$DownloadContrl.jdField_a_of_type_CooperationGmersdk_warperTMG_Downloader$TMG_Downloader_DownloadEvent.a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.gmersdk_warper.TMG_Downloader.DownloadContrl.1
 * JD-Core Version:    0.7.0.1
 */