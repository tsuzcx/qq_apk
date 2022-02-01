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
  
  CapturePtvTemplateManager$SessionResHttpListener(CapturePtvTemplateManager paramCapturePtvTemplateManager, CapturePtvTemplateManager.DLSession paramDLSession, CapturePtvTemplateManager.DLItem paramDLItem)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLSession = paramDLSession;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLItem = paramDLItem;
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager", 2, String.format("SessionResHttpListener respCode[%s], resName[%s], resUrl[%s]", new Object[] { Integer.valueOf(paramNetResp.mHttpCode), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLItem.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLItem.c }));
    }
    paramNetResp = (CapturePtvTemplateManager.DLItem)paramNetResp.mReq.getUserData();
    if (paramNetResp == null) {}
    label269:
    label286:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (!paramNetResp.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLItem.jdField_a_of_type_JavaLangString)) {
            break label286;
          }
          if (CapturePtvTemplateManager.b(paramNetResp.jdField_a_of_type_JavaLangString, paramNetResp.jdField_b_of_type_JavaLangString, false)) {}
          try
          {
            ZipUtils.unZipFile(new File(CapturePtvTemplateManager.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLItem.jdField_a_of_type_JavaLangString), CapturePtvTemplateManager.jdField_a_of_type_JavaLangString);
            if (paramNetResp.jdField_b_of_type_Boolean) {
              break label269;
            }
            paramNetResp = (CapturePtvTemplateManager.BusinessParam)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLSession.a));
            if (paramNetResp != null)
            {
              paramNetResp = paramNetResp.b.iterator();
              while (paramNetResp.hasNext())
              {
                CapturePtvTemplateManager.DLSession localDLSession = (CapturePtvTemplateManager.DLSession)paramNetResp.next();
                if (CapturePtvTemplateManager.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager, localDLSession, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLItem)) {
                  paramNetResp.remove();
                }
              }
            }
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              localIOException.printStackTrace();
            }
          }
        }
      } while (!QLog.isColorLevel());
      QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[onResp]: BusinessParam=null  kind=" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLSession.a + " mItem.mName=" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLItem.jdField_a_of_type_JavaLangString);
      return;
      CapturePtvTemplateManager.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLSession, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLItem);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[onResp]: download information no match current=" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLItem.jdField_a_of_type_JavaLangString + " callback=" + paramNetResp.jdField_a_of_type_JavaLangString);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = (CapturePtvTemplateManager.DLItem)paramNetReq.getUserData();
    if (paramNetReq == null) {}
    label134:
    label187:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (!paramNetReq.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLItem.jdField_a_of_type_JavaLangString)) {
            break label187;
          }
          Object localObject = (CapturePtvTemplateManager.BusinessParam)this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLSession.a));
          if (localObject == null) {
            break label134;
          }
          if (paramNetReq.jdField_b_of_type_Boolean) {
            break;
          }
          paramNetReq = ((CapturePtvTemplateManager.BusinessParam)localObject).b.iterator();
          while (paramNetReq.hasNext())
          {
            localObject = (CapturePtvTemplateManager.DLSession)paramNetReq.next();
            CapturePtvTemplateManager.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager, (CapturePtvTemplateManager.DLSession)localObject, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLItem, paramLong1, paramLong2);
          }
        }
        CapturePtvTemplateManager.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLSession, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLItem, paramLong1, paramLong2);
        return;
      } while (!QLog.isColorLevel());
      QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[Progress]: BusinessParam=null  kind=" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLSession.a + " mItem.mName=" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLItem.jdField_a_of_type_JavaLangString);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("CapturePtvTemplateManager", 2, "SessionResHttpListener[Progress]: download information no match current=" + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager$DLItem.jdField_a_of_type_JavaLangString + " callback=" + paramNetReq.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager.SessionResHttpListener
 * JD-Core Version:    0.7.0.1
 */