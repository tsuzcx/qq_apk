package com.tencent.mobileqq.richmedia.capture.data;

import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class CapturePtvTemplateManager$SessionResHttpListener
  implements INetEngineListener
{
  CapturePtvTemplateManager.DLItem jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLItem;
  CapturePtvTemplateManager.DLSession jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLSession;
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, String.format("SessionResHttpListener respCode[%s], resName[%s], resUrl[%s]", new Object[] { Integer.valueOf(paramNetResp.mHttpCode), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLItem.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLItem.c }));
    }
    paramNetResp = (CapturePtvTemplateManager.DLItem)paramNetResp.mReq.getUserData();
    if (paramNetResp == null) {
      return;
    }
    Object localObject;
    if (paramNetResp.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLItem.jdField_a_of_type_JavaLangString))
    {
      if (CapturePtvTemplateManager.b(paramNetResp.jdField_a_of_type_JavaLangString, paramNetResp.jdField_b_of_type_JavaLangString, false)) {
        try
        {
          ZipUtils.unZipFile(new File(CapturePtvTemplateManager.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLItem.jdField_a_of_type_JavaLangString), CapturePtvTemplateManager.jdField_a_of_type_JavaLangString);
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
        }
      }
      if (!paramNetResp.jdField_b_of_type_Boolean)
      {
        paramNetResp = (CapturePtvTemplateManager.BusinessParam)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLSession.a));
        if (paramNetResp != null)
        {
          paramNetResp = paramNetResp.b.iterator();
          while (paramNetResp.hasNext())
          {
            localObject = (CapturePtvTemplateManager.DLSession)paramNetResp.next();
            if (CapturePtvTemplateManager.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager, (CapturePtvTemplateManager.DLSession)localObject, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLItem)) {
              paramNetResp.remove();
            }
          }
        }
        if (QLog.isColorLevel())
        {
          paramNetResp = new StringBuilder();
          paramNetResp.append("SessionResHttpListener[onResp]: BusinessParam=null  kind=");
          paramNetResp.append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLSession.a);
          paramNetResp.append(" mItem.mName=");
          paramNetResp.append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLItem.jdField_a_of_type_JavaLangString);
          QLog.e("CapturePtvTemplateManager", 2, paramNetResp.toString());
        }
      }
      else
      {
        CapturePtvTemplateManager.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLSession, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLItem);
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SessionResHttpListener[onResp]: download information no match current=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLItem.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(" callback=");
      ((StringBuilder)localObject).append(paramNetResp.jdField_a_of_type_JavaLangString);
      QLog.e("CapturePtvTemplateManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = (CapturePtvTemplateManager.DLItem)paramNetReq.getUserData();
    if (paramNetReq == null) {
      return;
    }
    Object localObject;
    if (paramNetReq.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLItem.jdField_a_of_type_JavaLangString))
    {
      localObject = (CapturePtvTemplateManager.BusinessParam)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLSession.a));
      if (localObject != null)
      {
        if (!paramNetReq.jdField_b_of_type_Boolean)
        {
          paramNetReq = ((CapturePtvTemplateManager.BusinessParam)localObject).b.iterator();
          while (paramNetReq.hasNext())
          {
            localObject = (CapturePtvTemplateManager.DLSession)paramNetReq.next();
            CapturePtvTemplateManager.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager, (CapturePtvTemplateManager.DLSession)localObject, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLItem, paramLong1, paramLong2);
          }
        }
        CapturePtvTemplateManager.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLSession, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLItem, paramLong1, paramLong2);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramNetReq = new StringBuilder();
        paramNetReq.append("SessionResHttpListener[Progress]: BusinessParam=null  kind=");
        paramNetReq.append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLSession.a);
        paramNetReq.append(" mItem.mName=");
        paramNetReq.append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLItem.jdField_a_of_type_JavaLangString);
        QLog.e("CapturePtvTemplateManager", 2, paramNetReq.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SessionResHttpListener[Progress]: download information no match current=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLItem.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(" callback=");
      ((StringBuilder)localObject).append(paramNetReq.jdField_a_of_type_JavaLangString);
      QLog.e("CapturePtvTemplateManager", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager.SessionResHttpListener
 * JD-Core Version:    0.7.0.1
 */