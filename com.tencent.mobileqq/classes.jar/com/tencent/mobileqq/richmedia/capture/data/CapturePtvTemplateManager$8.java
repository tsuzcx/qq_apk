package com.tencent.mobileqq.richmedia.capture.data;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.IPtvTemplateDownloadListener;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

class CapturePtvTemplateManager$8
  implements INetEngineListener
{
  CapturePtvTemplateManager$8(CapturePtvTemplateManager paramCapturePtvTemplateManager, PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, PtvTemplateManager.IPtvTemplateDownloadListener paramIPtvTemplateDownloadListener) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, "onResp url: " + this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.resurl + " resultcode: " + paramNetResp.mHttpCode);
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo);
    paramNetResp = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager.a.iterator();
    while (paramNetResp.hasNext())
    {
      Object localObject = (TemplateGroupItem)paramNetResp.next();
      if (((TemplateGroupItem)localObject).a != null)
      {
        localObject = ((TemplateGroupItem)localObject).a.iterator();
        while (((Iterator)localObject).hasNext())
        {
          PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)((Iterator)localObject).next();
          if (localPtvTemplateInfo.id.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) {
            localPtvTemplateInfo.usable = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager.a(localPtvTemplateInfo);
          }
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable) {}
    try
    {
      ZipUtils.unZipFile(new File(CapturePtvTemplateManager.b, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.md5), CapturePtvTemplateManager.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.md5));
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable);
      }
      return;
    }
    catch (IOException paramNetResp)
    {
      for (;;)
      {
        paramNetResp.printStackTrace();
      }
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, (int)(100L * paramLong1 / paramLong2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager.8
 * JD-Core Version:    0.7.0.1
 */