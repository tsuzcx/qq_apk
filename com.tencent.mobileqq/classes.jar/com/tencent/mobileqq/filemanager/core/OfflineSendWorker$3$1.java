package com.tencent.mobileqq.filemanager.core;

import aowf;
import aoze;
import aozg;
import aozx;
import apar;
import apax;
import apay;
import apei;
import apgt;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class OfflineSendWorker$3$1
  implements Runnable
{
  public OfflineSendWorker$3$1(apay paramapay, aowf paramaowf, boolean paramBoolean, String paramString, List paramList1, List paramList2, int paramInt) {}
  
  public void run()
  {
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] onUpdateSendOfflineFile,retCode[" + String.valueOf(this.jdField_a_of_type_Aowf.jdField_a_of_type_Int) + "] bUseHttps:" + this.jdField_a_of_type_Boolean + " httpsDomain:" + this.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_Aowf.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Aowf.jdField_a_of_type_JavaLangString.length() > 0))
    {
      QLog.e("OfflineSendWorker<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] will show taost, retCode[" + String.valueOf(this.jdField_a_of_type_Aowf.jdField_a_of_type_Int) + "], retMsg:" + this.jdField_a_of_type_Aowf.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 4, null, this.jdField_a_of_type_Aowf.jdField_a_of_type_Int, this.jdField_a_of_type_Aowf.jdField_a_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_Aowf.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_Aowf.jdField_a_of_type_ArrayOfByte.length > 0))
    {
      this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = new String(this.jdField_a_of_type_Aowf.jdField_a_of_type_ArrayOfByte);
      if ((!this.jdField_a_of_type_Aowf.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Aowf.jdField_c_of_type_Long > 104857600L)) {
        break label404;
      }
      this.jdField_a_of_type_Apay.a.b = true;
      apax.a(this.jdField_a_of_type_Apay.a);
    }
    label404:
    do
    {
      return;
      QLog.e("OfflineSendWorker<FileAssistant>", 1, "=_= ^! nSessionID[" + String.valueOf(this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]!!!!!Server Return the UUID is null!!!!!");
      break;
      this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "已收到CS包,准备开始上传任务,nSessionID[" + String.valueOf(this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]");
      }
      if ((apei.b) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.add(0, "14.17.29.27:" + this.jdField_a_of_type_Aowf.jdField_a_of_type_Short);
      }
      String str = HexUtil.bytes2HexStr(this.jdField_a_of_type_Aowf.b);
      if (this.jdField_a_of_type_Apay.a.d())
      {
        QLog.i("OfflineSendWorker<FileAssistant>", 1, "^_^ nSessionID[" + String.valueOf(this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] upload file use comstom uploader");
        this.jdField_a_of_type_Apay.a.jdField_a_of_type_Apar = this.jdField_a_of_type_Apay.a.a(this.jdField_a_of_type_Aowf, this.b, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Apay.a.jdField_a_of_type_Apar != null)
        {
          apax.a(this.jdField_a_of_type_Apay.a, false);
          this.jdField_a_of_type_Apay.a.jdField_a_of_type_Apar.a(this.jdField_a_of_type_Apay.a);
          if (!this.jdField_a_of_type_Apay.a.jdField_a_of_type_Apar.a(0L))
          {
            apax.a(this.jdField_a_of_type_Apay.a, 1005);
            this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, 0, "");
            apax.a(this.jdField_a_of_type_Apay.a, this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 9045, "sendFile error");
            apax.b(this.jdField_a_of_type_Apay.a, this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 9045, "sendFile error");
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("OfflineSendWorker<FileAssistant>", 2, "=_= ^! nSessionID[" + this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "],sendFile return false");
            return;
            if (1 == this.jdField_a_of_type_Aowf.d)
            {
              str = "/?ver=2&ukey=" + str + "&filekey=" + apax.a(this.jdField_a_of_type_Apay.a) + "&filesize=" + this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
              this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath = ("http://" + (String)this.jdField_a_of_type_JavaUtilList.get(0) + str);
              this.jdField_a_of_type_Apay.a.jdField_a_of_type_Apar = aozx.a(this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 0, this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), this.jdField_a_of_type_JavaUtilList, str);
              continue;
            }
            if (2 == this.jdField_a_of_type_Aowf.d)
            {
              if (this.jdField_a_of_type_Boolean)
              {
                this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath = ("https://" + (String)this.jdField_a_of_type_JavaUtilList.get(0) + "/ftn_handler");
                this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.httpsDomain = this.jdField_a_of_type_JavaLangString;
              }
              for (;;)
              {
                this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bombData = str.getBytes();
                if (this.jdField_a_of_type_Aowf.jdField_c_of_type_ArrayOfByte != null)
                {
                  this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSHA = apgt.a(this.jdField_a_of_type_Aowf.jdField_c_of_type_ArrayOfByte);
                  this.jdField_a_of_type_Apay.a.j();
                }
                this.jdField_a_of_type_Apay.a.jdField_a_of_type_Apar = aozx.a(this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 0, this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), str, this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSHA, this.jdField_a_of_type_JavaUtilList, "/ftn_handler", this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString);
                break;
                this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath = ("http://" + (String)this.jdField_a_of_type_JavaUtilList.get(0) + "/ftn_handler");
              }
            }
            QLog.w("OfflineSendWorker<FileAssistant>", 1, "onUpdateSendOfflineFile httpsvrApiVer[" + this.jdField_a_of_type_Aowf.d + "] not recognized");
            continue;
          }
          this.jdField_a_of_type_Apay.a.b(System.currentTimeMillis());
          return;
        }
      }
      apax.a(this.jdField_a_of_type_Apay.a, 1005);
      this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, this.jdField_a_of_type_Aowf.jdField_a_of_type_Int, this.jdField_a_of_type_Aowf.jdField_a_of_type_JavaLangString);
      apax.a(this.jdField_a_of_type_Apay.a, this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 9045, "upload param error");
      apax.b(this.jdField_a_of_type_Apay.a, this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 9045, "upload param error");
    } while (!QLog.isColorLevel());
    QLog.e("OfflineSendWorker<FileAssistant>", 2, "=_= ^! nSessionID[" + this.jdField_a_of_type_Apay.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "],retCode[" + this.jdField_a_of_type_Aowf.jdField_a_of_type_Int + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OfflineSendWorker.3.1
 * JD-Core Version:    0.7.0.1
 */