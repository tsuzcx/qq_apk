package com.tencent.mobileqq.filemanager.core;

import aqtm;
import aqwl;
import aqwn;
import aqxe;
import aqxy;
import aqye;
import aqyf;
import arbp;
import area;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class OfflineSendWorker$3$1
  implements Runnable
{
  public OfflineSendWorker$3$1(aqyf paramaqyf, aqtm paramaqtm, boolean paramBoolean, String paramString, List paramList1, List paramList2, int paramInt) {}
  
  public void run()
  {
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] onUpdateSendOfflineFile,retCode[" + String.valueOf(this.jdField_a_of_type_Aqtm.jdField_a_of_type_Int) + "] bUseHttps:" + this.jdField_a_of_type_Boolean + " httpsDomain:" + this.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_Aqtm.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Aqtm.jdField_a_of_type_JavaLangString.length() > 0))
    {
      QLog.e("OfflineSendWorker<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] will show taost, retCode[" + String.valueOf(this.jdField_a_of_type_Aqtm.jdField_a_of_type_Int) + "], retMsg:" + this.jdField_a_of_type_Aqtm.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 4, null, this.jdField_a_of_type_Aqtm.jdField_a_of_type_Int, this.jdField_a_of_type_Aqtm.jdField_a_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_Aqtm.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_Aqtm.jdField_a_of_type_ArrayOfByte.length > 0))
    {
      this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = new String(this.jdField_a_of_type_Aqtm.jdField_a_of_type_ArrayOfByte);
      if ((!this.jdField_a_of_type_Aqtm.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Aqtm.jdField_c_of_type_Long > 104857600L)) {
        break label404;
      }
      this.jdField_a_of_type_Aqyf.a.b = true;
      aqye.a(this.jdField_a_of_type_Aqyf.a);
    }
    label404:
    do
    {
      return;
      QLog.e("OfflineSendWorker<FileAssistant>", 1, "=_= ^! nSessionID[" + String.valueOf(this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]!!!!!Server Return the UUID is null!!!!!");
      break;
      this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "已收到CS包,准备开始上传任务,nSessionID[" + String.valueOf(this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]");
      }
      if ((arbp.b) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.add(0, "14.17.29.27:" + this.jdField_a_of_type_Aqtm.jdField_a_of_type_Short);
      }
      String str = HexUtil.bytes2HexStr(this.jdField_a_of_type_Aqtm.b);
      if (this.jdField_a_of_type_Aqyf.a.d())
      {
        QLog.i("OfflineSendWorker<FileAssistant>", 1, "^_^ nSessionID[" + String.valueOf(this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] upload file use comstom uploader");
        this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_Aqxy = this.jdField_a_of_type_Aqyf.a.a(this.jdField_a_of_type_Aqtm, this.b, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_Aqxy != null)
        {
          aqye.a(this.jdField_a_of_type_Aqyf.a, false);
          this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_Aqxy.a(this.jdField_a_of_type_Aqyf.a);
          if (!this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_Aqxy.a(0L))
          {
            aqye.a(this.jdField_a_of_type_Aqyf.a, 1005);
            this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, 0, "");
            aqye.a(this.jdField_a_of_type_Aqyf.a, this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 9045, "sendFile error");
            aqye.b(this.jdField_a_of_type_Aqyf.a, this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 9045, "sendFile error");
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("OfflineSendWorker<FileAssistant>", 2, "=_= ^! nSessionID[" + this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "],sendFile return false");
            return;
            if (1 == this.jdField_a_of_type_Aqtm.d)
            {
              str = "/?ver=2&ukey=" + str + "&filekey=" + aqye.a(this.jdField_a_of_type_Aqyf.a) + "&filesize=" + this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
              this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath = ("http://" + (String)this.jdField_a_of_type_JavaUtilList.get(0) + str);
              this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_Aqxy = aqxe.a(this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 0, this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), this.jdField_a_of_type_JavaUtilList, str);
              continue;
            }
            if (2 == this.jdField_a_of_type_Aqtm.d)
            {
              if (this.jdField_a_of_type_Boolean)
              {
                this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath = ("https://" + (String)this.jdField_a_of_type_JavaUtilList.get(0) + "/ftn_handler");
                this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.httpsDomain = this.jdField_a_of_type_JavaLangString;
              }
              for (;;)
              {
                this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bombData = str.getBytes();
                if (this.jdField_a_of_type_Aqtm.jdField_c_of_type_ArrayOfByte != null)
                {
                  this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSHA = area.a(this.jdField_a_of_type_Aqtm.jdField_c_of_type_ArrayOfByte);
                  this.jdField_a_of_type_Aqyf.a.j();
                }
                this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_Aqxy = aqxe.a(this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 0, this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), str, this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSHA, this.jdField_a_of_type_JavaUtilList, "/ftn_handler", this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString);
                break;
                this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath = ("http://" + (String)this.jdField_a_of_type_JavaUtilList.get(0) + "/ftn_handler");
              }
            }
            QLog.w("OfflineSendWorker<FileAssistant>", 1, "onUpdateSendOfflineFile httpsvrApiVer[" + this.jdField_a_of_type_Aqtm.d + "] not recognized");
            continue;
          }
          this.jdField_a_of_type_Aqyf.a.b(System.currentTimeMillis());
          return;
        }
      }
      aqye.a(this.jdField_a_of_type_Aqyf.a, 1005);
      this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, this.jdField_a_of_type_Aqtm.jdField_a_of_type_Int, this.jdField_a_of_type_Aqtm.jdField_a_of_type_JavaLangString);
      aqye.a(this.jdField_a_of_type_Aqyf.a, this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 9045, "upload param error");
      aqye.b(this.jdField_a_of_type_Aqyf.a, this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 9045, "upload param error");
    } while (!QLog.isColorLevel());
    QLog.e("OfflineSendWorker<FileAssistant>", 2, "=_= ^! nSessionID[" + this.jdField_a_of_type_Aqyf.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "],retCode[" + this.jdField_a_of_type_Aqtm.jdField_a_of_type_Int + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OfflineSendWorker.3.1
 * JD-Core Version:    0.7.0.1
 */