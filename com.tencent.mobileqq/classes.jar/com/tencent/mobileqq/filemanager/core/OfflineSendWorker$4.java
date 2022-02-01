package com.tencent.mobileqq.filemanager.core;

import athx;
import atlf;
import atlh;
import atlw;
import atmi;
import atnd;
import atpj;
import atrr;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class OfflineSendWorker$4
  implements Runnable
{
  public OfflineSendWorker$4(atnd paramatnd, athx paramathx, boolean paramBoolean1, String paramString, List paramList1, List paramList2, int paramInt, boolean paramBoolean2) {}
  
  public void run()
  {
    QLog.i("OfflineSendWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] onUpdateSendOfflineFile,retCode[" + String.valueOf(this.jdField_a_of_type_Athx.jdField_a_of_type_Int) + "] bUseHttps:" + this.jdField_a_of_type_Boolean + " httpsDomain:" + this.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_Athx.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_Athx.jdField_a_of_type_JavaLangString.length() > 0))
    {
      QLog.e("OfflineSendWorker<FileAssistant>", 1, "id[" + String.valueOf(this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] will show taost, retCode[" + String.valueOf(this.jdField_a_of_type_Athx.jdField_a_of_type_Int) + "], retMsg:" + this.jdField_a_of_type_Athx.jdField_a_of_type_JavaLangString);
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 4, null, this.jdField_a_of_type_Athx.jdField_a_of_type_Int, this.jdField_a_of_type_Athx.jdField_a_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_Athx.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_Athx.jdField_a_of_type_ArrayOfByte.length > 0))
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = new String(this.jdField_a_of_type_Athx.jdField_a_of_type_ArrayOfByte);
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bUseMediaPlatform = this.jdField_a_of_type_Athx.jdField_b_of_type_Boolean;
      if ((!this.jdField_a_of_type_Athx.jdField_a_of_type_Boolean) || ((!this.jdField_a_of_type_Athx.jdField_b_of_type_Boolean) && (this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize > 104857600L))) {
        break label480;
      }
      this.this$0.jdField_b_of_type_Boolean = true;
      QLog.d("OfflineSendWorker<FileAssistant>", 1, "=_= ^! nSessionID[" + String.valueOf(this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] onUpdateSendOfflineFile: miaochuan bUseMediaPlatform " + this.jdField_a_of_type_Athx.jdField_b_of_type_Boolean);
      if (this.jdField_a_of_type_Athx.jdField_b_of_type_Boolean) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileIdCrc = this.jdField_a_of_type_Athx.f;
      }
      atnd.a(this.this$0);
    }
    label480:
    label1381:
    do
    {
      return;
      QLog.e("OfflineSendWorker<FileAssistant>", 1, "=_= ^! nSessionID[" + String.valueOf(this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]!!!!!Server Return the UUID is null!!!!!");
      break;
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "已收到CS包,准备开始上传任务,nSessionID[" + String.valueOf(this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]");
      }
      if ((atpj.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_a_of_type_JavaUtilList.add(0, "14.17.29.27:" + this.jdField_a_of_type_Athx.jdField_a_of_type_Short);
      }
      String str = HexUtil.bytes2HexStr(this.jdField_a_of_type_Athx.jdField_b_of_type_ArrayOfByte);
      if (this.this$0.d())
      {
        QLog.i("OfflineSendWorker<FileAssistant>", 1, "^_^ nSessionID[" + String.valueOf(this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] upload file use comstom uploader");
        this.this$0.jdField_a_of_type_Atmi = this.this$0.a(this.jdField_a_of_type_Athx, this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString);
      }
      for (;;)
      {
        if (this.this$0.jdField_a_of_type_Atmi != null)
        {
          atnd.a(this.this$0, false);
          this.this$0.jdField_a_of_type_Atmi.a(this.this$0);
          if (!this.this$0.jdField_a_of_type_Atmi.a(0L))
          {
            atnd.a(this.this$0, 1005);
            this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, 0, "");
            atnd.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 9045, "sendFile error");
            atnd.b(this.this$0, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 9045, "sendFile error");
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("OfflineSendWorker<FileAssistant>", 2, "=_= ^! nSessionID[" + this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "],sendFile return false");
            return;
            if (1 == this.jdField_a_of_type_Athx.d)
            {
              str = "/?ver=2&ukey=" + str + "&filekey=" + atnd.a(this.this$0) + "&filesize=" + this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
              this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath = ("http://" + (String)this.jdField_a_of_type_JavaUtilList.get(0) + str);
              this.this$0.jdField_a_of_type_Atmi = atlw.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 0, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), this.jdField_a_of_type_JavaUtilList, str);
              continue;
            }
            if (2 == this.jdField_a_of_type_Athx.d)
            {
              if (this.jdField_a_of_type_Boolean)
              {
                this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath = ("https://" + (String)this.jdField_a_of_type_JavaUtilList.get(0) + "/ftn_handler");
                this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.httpsDomain = this.jdField_a_of_type_JavaLangString;
                if (!this.jdField_b_of_type_Boolean) {
                  break label1381;
                }
              }
              for (this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.svrPathIpType = 2;; this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.svrPathIpType = 1)
              {
                this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bombData = str.getBytes();
                if (this.jdField_a_of_type_Athx.c != null)
                {
                  this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSHA = atrr.a(this.jdField_a_of_type_Athx.c);
                  this.this$0.j();
                }
                this.this$0.jdField_a_of_type_Atmi = atlw.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 0, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), str, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSHA, this.jdField_a_of_type_JavaUtilList, "/ftn_handler", this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangString);
                break;
                this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath = ("http://" + (String)this.jdField_a_of_type_JavaUtilList.get(0) + "/ftn_handler");
                break label1184;
              }
            }
            QLog.w("OfflineSendWorker<FileAssistant>", 1, "onUpdateSendOfflineFile httpsvrApiVer[" + this.jdField_a_of_type_Athx.d + "] not recognized");
            continue;
          }
          this.this$0.b(System.currentTimeMillis());
          return;
        }
      }
      atnd.a(this.this$0, 1005);
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, this.jdField_a_of_type_Athx.jdField_a_of_type_Int, this.jdField_a_of_type_Athx.jdField_a_of_type_JavaLangString);
      atnd.a(this.this$0, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 9045, "upload param error");
      atnd.b(this.this$0, this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 9045, "upload param error");
    } while (!QLog.isColorLevel());
    label1184:
    QLog.e("OfflineSendWorker<FileAssistant>", 2, "=_= ^! nSessionID[" + this.this$0.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "],retCode[" + this.jdField_a_of_type_Athx.jdField_a_of_type_Int + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OfflineSendWorker.4
 * JD-Core Version:    0.7.0.1
 */