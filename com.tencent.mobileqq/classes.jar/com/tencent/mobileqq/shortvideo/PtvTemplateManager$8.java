package com.tencent.mobileqq.shortvideo;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

class PtvTemplateManager$8
  implements INetEngineListener
{
  public void onResp(NetResp paramNetResp)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResp url: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.resurl);
      ((StringBuilder)localObject).append(" resultcode: ");
      ((StringBuilder)localObject).append(paramNetResp.mHttpCode);
      QLog.i("PtvTemplateManager", 2, ((StringBuilder)localObject).toString());
    }
    paramNetResp = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo;
    paramNetResp.usable = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.a(paramNetResp);
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.businessID == 1)
    {
      paramNetResp = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.e.iterator();
      while (paramNetResp.hasNext())
      {
        localObject = (PtvTemplateManager.PtvTemplateInfo)paramNetResp.next();
        if (((PtvTemplateManager.PtvTemplateInfo)localObject).id.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) {
          ((PtvTemplateManager.PtvTemplateInfo)localObject).usable = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.a((PtvTemplateManager.PtvTemplateInfo)localObject);
        }
      }
    }
    paramNetResp = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (paramNetResp.hasNext())
    {
      localObject = (PtvTemplateManager.PtvTemplateInfo)paramNetResp.next();
      if (((PtvTemplateManager.PtvTemplateInfo)localObject).id.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) {
        ((PtvTemplateManager.PtvTemplateInfo)localObject).usable = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.a((PtvTemplateManager.PtvTemplateInfo)localObject);
      }
    }
    paramNetResp = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.b.iterator();
    while (paramNetResp.hasNext())
    {
      localObject = (PtvTemplateManager.PtvTemplateInfo)paramNetResp.next();
      if (((PtvTemplateManager.PtvTemplateInfo)localObject).id.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.id)) {
        ((PtvTemplateManager.PtvTemplateInfo)localObject).usable = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager.a((PtvTemplateManager.PtvTemplateInfo)localObject);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.usable) {
      try
      {
        ZipUtils.unZipFile(new File(PtvTemplateManager.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.name), PtvTemplateManager.jdField_a_of_type_JavaLangString);
      }
      catch (IOException paramNetResp)
      {
        paramNetResp.printStackTrace();
      }
    }
    paramNetResp = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener;
    if (paramNetResp != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo;
      paramNetResp.a((PtvTemplateManager.PtvTemplateInfo)localObject, ((PtvTemplateManager.PtvTemplateInfo)localObject).usable);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$IPtvTemplateDownloadListener;
    if (paramNetReq != null)
    {
      PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo;
      localPtvTemplateInfo.totalLen = paramLong2;
      paramNetReq.a(localPtvTemplateInfo, (int)(paramLong1 * 100L / paramLong2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.PtvTemplateManager.8
 * JD-Core Version:    0.7.0.1
 */