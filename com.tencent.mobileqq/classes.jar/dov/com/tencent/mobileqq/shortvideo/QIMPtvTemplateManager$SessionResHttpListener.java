package dov.com.tencent.mobileqq.shortvideo;

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

class QIMPtvTemplateManager$SessionResHttpListener
  implements INetEngineListener
{
  QIMPtvTemplateManager.DLItem jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager$DLItem;
  QIMPtvTemplateManager.DLSession jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager$DLSession;
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMPtvTemplateManager", 2, String.format("SessionResHttpListener respCode[%s], resName[%s], resUrl[%s]", new Object[] { Integer.valueOf(paramNetResp.mHttpCode), this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager$DLItem.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager$DLItem.c }));
    }
    paramNetResp = (QIMPtvTemplateManager.DLItem)paramNetResp.mReq.getUserData();
    if (paramNetResp == null) {}
    label273:
    label290:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (!paramNetResp.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager$DLItem.jdField_a_of_type_JavaLangString)) {
            break label290;
          }
          if (QIMPtvTemplateManager.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager, paramNetResp.jdField_a_of_type_JavaLangString, paramNetResp.jdField_b_of_type_JavaLangString, false)) {}
          try
          {
            ZipUtils.unZipFile(new File(QIMPtvTemplateManager.a(), this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager$DLItem.jdField_a_of_type_JavaLangString), QIMPtvTemplateManager.jdField_a_of_type_JavaLangString);
            if (paramNetResp.jdField_b_of_type_Boolean) {
              break label273;
            }
            paramNetResp = (QIMPtvTemplateManager.BusinessParam)this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager$DLSession.a));
            if (paramNetResp != null)
            {
              paramNetResp = paramNetResp.b.iterator();
              while (paramNetResp.hasNext())
              {
                QIMPtvTemplateManager.DLSession localDLSession = (QIMPtvTemplateManager.DLSession)paramNetResp.next();
                if (QIMPtvTemplateManager.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager, localDLSession, this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager$DLItem)) {
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
      QLog.e("QIMPtvTemplateManager", 2, "SessionResHttpListener[onResp]: BusinessParam=null  kind=" + this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager$DLSession.a + " mItem.mName=" + this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager$DLItem.jdField_a_of_type_JavaLangString);
      return;
      QIMPtvTemplateManager.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager, this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager$DLSession, this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager$DLItem);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("QIMPtvTemplateManager", 2, "SessionResHttpListener[onResp]: download information no match current=" + this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager$DLItem.jdField_a_of_type_JavaLangString + " callback=" + paramNetResp.jdField_a_of_type_JavaLangString);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = (QIMPtvTemplateManager.DLItem)paramNetReq.getUserData();
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
          if (!paramNetReq.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager$DLItem.jdField_a_of_type_JavaLangString)) {
            break label187;
          }
          Object localObject = (QIMPtvTemplateManager.BusinessParam)this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager$DLSession.a));
          if (localObject == null) {
            break label134;
          }
          if (paramNetReq.jdField_b_of_type_Boolean) {
            break;
          }
          paramNetReq = ((QIMPtvTemplateManager.BusinessParam)localObject).b.iterator();
          while (paramNetReq.hasNext())
          {
            localObject = (QIMPtvTemplateManager.DLSession)paramNetReq.next();
            QIMPtvTemplateManager.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager, (QIMPtvTemplateManager.DLSession)localObject, this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager$DLItem, paramLong1, paramLong2);
          }
        }
        QIMPtvTemplateManager.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager, this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager$DLSession, this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager$DLItem, paramLong1, paramLong2);
        return;
      } while (!QLog.isColorLevel());
      QLog.e("QIMPtvTemplateManager", 2, "SessionResHttpListener[Progress]: BusinessParam=null  kind=" + this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager$DLSession.a + " mItem.mName=" + this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager$DLItem.jdField_a_of_type_JavaLangString);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("QIMPtvTemplateManager", 2, "SessionResHttpListener[Progress]: download information no match current=" + this.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager$DLItem.jdField_a_of_type_JavaLangString + " callback=" + paramNetReq.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager.SessionResHttpListener
 * JD-Core Version:    0.7.0.1
 */