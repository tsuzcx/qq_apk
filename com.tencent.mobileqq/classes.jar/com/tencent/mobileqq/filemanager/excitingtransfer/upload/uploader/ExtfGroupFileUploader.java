package com.tencent.mobileqq.filemanager.excitingtransfer.upload.uploader;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.excitingtransfer.ExcitingTransferAdapter;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadBizInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp;
import com.tencent.mobileqq.troop.filemanager.upload.ITroopFileUploader;
import com.tencent.mobileqq.troop.filemanager.upload.ITroopFileUploaderSink;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ExtfGroupFileUploader
  extends ExtfBaseFileUploader
  implements ITroopFileUploader
{
  protected ExcitingTransferUploadResultRp a;
  protected ITroopFileUploaderSink a;
  protected String b = "";
  
  private ExtfGroupFileUploader(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, ExtfGroupFileUploader.ExtfGroupFileInfo paramExtfGroupFileInfo, ExtfSvrInfo paramExtfSvrInfo)
  {
    super(paramQQAppInterface, paramLong1, paramLong2, 1, paramExtfGroupFileInfo, paramExtfSvrInfo);
  }
  
  public static ITroopFileUploader a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, ExtfGroupFileUploader.ExtfGroupFileInfo paramExtfGroupFileInfo, ExtfSvrInfo paramExtfSvrInfo)
  {
    if (paramExtfGroupFileInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.e("ExcitingTransfer.TroopFileUploader<FileAssistant>", 2, "getFileUploader fileInfo is null");
      }
    }
    do
    {
      do
      {
        do
        {
          return null;
          if (paramExtfSvrInfo != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("ExcitingTransfer.TroopFileUploader<FileAssistant>", 2, "getFileUploader svrInfo is null");
        return null;
        if (paramExtfGroupFileInfo.a()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("ExcitingTransfer.TroopFileUploader<FileAssistant>", 2, "getFileUploader fileInfo is err");
      return null;
      if (paramExtfSvrInfo.a()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ExcitingTransfer.TroopFileUploader<FileAssistant>", 2, "getFileUploader svrInfo is err");
    return null;
    return new ExtfGroupFileUploader(paramQQAppInterface, paramLong1, paramLong2, paramExtfGroupFileInfo, paramExtfSvrInfo);
  }
  
  private void b(ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp = paramExcitingTransferUploadResultRp;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp != null) {
      return (int)this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.muRetryCount;
    }
    return 0;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.mu64StartSize;
    }
    return 0L;
  }
  
  protected ExcitingTransferUploadChnConfigInfo a()
  {
    return ExcitingTransferAdapter.a().b();
  }
  
  public ExcitingTransferUploadResultRp a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp;
  }
  
  public String a()
  {
    return this.b;
  }
  
  protected List<ExcitingTransferHostInfo> a()
  {
    Object localObject;
    List localList;
    if (FileIPv6StrateyController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3))
    {
      QLog.i("ExcitingTransfer.TroopFileUploader<FileAssistant>", 1, "[IPv6-File] exciting groupfile upload. is config enable IPv6.");
      localObject = ExcitingTransferAdapter.a().a(false);
      localList = FileIPv6StrateyController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 3);
      if (localList != null)
      {
        if (localObject != null) {
          break label162;
        }
        localObject = new ArrayList();
      }
    }
    label162:
    for (;;)
    {
      if (FileIPv6StrateyController.a())
      {
        QLog.d("ExcitingTransfer.TroopFileUploader<FileAssistant>", 1, "[IPv6-File] exciting groupfile upload. debugIsDisableIPv4OnDoubleStack");
        ((List)localObject).clear();
      }
      int i = localList.size() - 1;
      while (i >= 0)
      {
        ((List)localObject).add(0, (ExcitingTransferHostInfo)localList.get(i));
        i -= 1;
      }
      this.jdField_c_of_type_Int = 2;
      QLog.i("ExcitingTransfer.TroopFileUploader<FileAssistant>", 1, "[IPv6-File] exciting groupfile upload. use IPv6. hostlist:" + localObject.toString());
      return localObject;
      this.jdField_c_of_type_Int = 1;
      return localObject;
      return super.a();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    QLog.i("ExcitingTransfer.TroopFileUploader<FileAssistant>", 1, "Id[" + this.d + "] cancelTask");
    b();
    b(null);
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3)
  {
    super.a(paramLong1, paramLong2, paramLong3);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploaderSink != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploaderSink.a(paramLong1);
    }
  }
  
  protected void a(ExcitingTransferUploadBizInfo paramExcitingTransferUploadBizInfo)
  {
    super.a(paramExcitingTransferUploadBizInfo);
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferUploadUploaderExtfFileInfo instanceof ExtfGroupFileUploader.ExtfGroupFileInfo))
    {
      ExtfGroupFileUploader.ExtfGroupFileInfo localExtfGroupFileInfo = (ExtfGroupFileUploader.ExtfGroupFileInfo)this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferUploadUploaderExtfFileInfo;
      paramExcitingTransferUploadBizInfo.groupCode = localExtfGroupFileInfo.jdField_a_of_type_Long;
      paramExcitingTransferUploadBizInfo.bufUuid = localExtfGroupFileInfo.jdField_a_of_type_ArrayOfByte;
      paramExcitingTransferUploadBizInfo.bufUploadKey = localExtfGroupFileInfo.b;
      return;
    }
    QLog.w("ExcitingTransfer.TroopFileUploader<FileAssistant>", 1, "Id[" + this.d + "] onGetOtherSendBusInfo. no other info");
  }
  
  protected void a(ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    super.a(paramExcitingTransferUploadResultRp);
    if (paramExcitingTransferUploadResultRp != null) {}
    for (String str = paramExcitingTransferUploadResultRp.mstrFileUrl;; str = "")
    {
      this.b = str;
      b(paramExcitingTransferUploadResultRp);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploaderSink != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploaderSink.g();
      }
      return;
    }
  }
  
  public void a(ITroopFileUploaderSink paramITroopFileUploaderSink)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploaderSink = paramITroopFileUploaderSink;
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_Boolean = false;
    b(null);
    return b();
  }
  
  public int b()
  {
    return 0;
  }
  
  public String b()
  {
    return "";
  }
  
  protected void b(int paramInt, ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    super.b(paramInt, paramExcitingTransferUploadResultRp);
    if (paramExcitingTransferUploadResultRp != null) {}
    for (String str = paramExcitingTransferUploadResultRp.mstrFileUrl;; str = "")
    {
      this.b = str;
      b(paramExcitingTransferUploadResultRp);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploaderSink != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploaderSink.a(true, this.jdField_c_of_type_Long, paramInt, "", "");
      }
      return;
    }
  }
  
  protected int c()
  {
    return 71;
  }
  
  public boolean c()
  {
    return false;
  }
  
  protected int d()
  {
    return 1;
  }
  
  public boolean d()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferUploadUploaderExtfFileInfo != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.mu64StartSize == this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferUploadUploaderExtfFileInfo.a()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected int e()
  {
    return 102;
  }
  
  public int h()
  {
    return 0;
  }
  
  public void onExcitingSubSenderResult(int paramInt, ExcitingTransferUploaderRp paramExcitingTransferUploaderRp)
  {
    if (paramExcitingTransferUploaderRp != null) {}
    for (String str = paramExcitingTransferUploaderRp.mstrFileUrl;; str = "")
    {
      this.b = str;
      super.onExcitingSubSenderResult(paramInt, paramExcitingTransferUploaderRp);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.upload.uploader.ExtfGroupFileUploader
 * JD-Core Version:    0.7.0.1
 */