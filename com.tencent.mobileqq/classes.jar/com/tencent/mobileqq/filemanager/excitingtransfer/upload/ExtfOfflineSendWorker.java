package com.tencent.mobileqq.filemanager.excitingtransfer.upload;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler.FileUploadInfo;
import com.tencent.mobileqq.filemanager.core.IFileUploader;
import com.tencent.mobileqq.filemanager.core.OfflineSendWorker;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.upload.uploader.ExtfC2CFileUploader;
import com.tencent.mobileqq.filemanager.excitingtransfer.upload.uploader.ExtfC2CFileUploader.ExtfC2CFileInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.upload.uploader.ExtfSvrInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.upload.uploader.IExtfUploaderSink;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.qphone.base.util.QLog;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExtfOfflineSendWorker
  extends OfflineSendWorker
  implements IExtfUploaderSink
{
  static long g = 0L;
  private boolean d;
  protected long e;
  private boolean e;
  protected long f = 0L;
  
  public ExtfOfflineSendWorker(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    super(paramQQAppInterface, paramFileManagerEntity);
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_e_of_type_Long = 0L;
  }
  
  private IFileUploader a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, ExtfOfflineSendWorker.ExtfFileUploadParam paramExtfFileUploadParam)
  {
    Object localObject2 = this.jdField_c_of_type_ArrayOfByte;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (paramExtfFileUploadParam.jdField_b_of_type_ArrayOfByte != null)
      {
        localObject1 = localObject2;
        if (paramExtfFileUploadParam.jdField_b_of_type_ArrayOfByte.length > 0) {
          localObject1 = paramExtfFileUploadParam.jdField_b_of_type_ArrayOfByte;
        }
      }
    }
    localObject1 = new ExtfC2CFileUploader.ExtfC2CFileInfo(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), null, this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte, this.jdField_d_of_type_ArrayOfByte, (byte[])localObject1, paramExtfFileUploadParam.jdField_d_of_type_ArrayOfByte, paramExtfFileUploadParam.jdField_a_of_type_ArrayOfByte, paramExtfFileUploadParam.jdField_b_of_type_Boolean);
    localObject2 = new ArrayList();
    if (paramExtfFileUploadParam.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = paramExtfFileUploadParam.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!TextUtils.isEmpty(str)) {
          ((List)localObject2).add(new ExcitingTransferHostInfo(str, paramExtfFileUploadParam.jdField_a_of_type_Int));
        }
      }
    }
    return ExtfC2CFileUploader.a(paramQQAppInterface, paramLong1, paramLong2, (ExtfC2CFileUploader.ExtfC2CFileInfo)localObject1, new ExtfSvrInfo((List)localObject2, null, paramExtfFileUploadParam.jdField_a_of_type_Boolean, paramExtfFileUploadParam.jdField_a_of_type_JavaLangString, paramExtfFileUploadParam.jdField_c_of_type_ArrayOfByte));
  }
  
  private void a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramInt == 9037)
    {
      n();
      return;
    }
    int i = e();
    ExtfOfflineDataReport localExtfOfflineDataReport = null;
    Object localObject = localExtfOfflineDataReport;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader != null)
    {
      localObject = localExtfOfflineDataReport;
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader instanceof ExtfC2CFileUploader)) {
        localObject = ((ExtfC2CFileUploader)this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader).a();
      }
    }
    localExtfOfflineDataReport = new ExtfOfflineDataReport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localObject != null)
    {
      paramInt = QFileUtils.b(((ExcitingTransferUploadResultRp)localObject).mstrServerIp);
      if (((ExcitingTransferUploadResultRp)localObject).mnResult == 0L)
      {
        localExtfOfflineDataReport.a((ExcitingTransferUploadResultRp)localObject);
        label106:
        localExtfOfflineDataReport.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
        localObject = FileManagerUtil.g(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
        localExtfOfflineDataReport.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin).longValue(), 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
        localExtfOfflineDataReport.c(this.jdField_b_of_type_Boolean);
        long l = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
        if (l <= 0L) {
          break label316;
        }
        localExtfOfflineDataReport.c(l);
        label199:
        l = this.f - this.jdField_e_of_type_Long;
        if (l <= 0L) {
          break label325;
        }
        localExtfOfflineDataReport.b(l);
      }
    }
    for (;;)
    {
      localExtfOfflineDataReport.b(i);
      localExtfOfflineDataReport.c(paramInt);
      localExtfOfflineDataReport.d(this.jdField_c_of_type_Boolean);
      localExtfOfflineDataReport.a(bool1);
      return;
      bool1 = false;
      break;
      if (paramInt == 0) {
        bool1 = bool2;
      }
      for (;;)
      {
        if (!bool1)
        {
          if (this.jdField_c_of_type_Long == 0L)
          {
            localExtfOfflineDataReport.a(paramInt);
            paramInt = 0;
            break;
            bool1 = false;
            continue;
          }
          localExtfOfflineDataReport.a(17);
          paramInt = 0;
          break;
        }
      }
      localExtfOfflineDataReport.a(0);
      paramInt = 0;
      break label106;
      label316:
      localExtfOfflineDataReport.c(0L);
      break label199;
      label325:
      localExtfOfflineDataReport.b(0L);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    QLog.e("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] setCloseExtfAbility:" + this.jdField_d_of_type_Boolean + "->" + paramBoolean);
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  private int e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader != null) && ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader instanceof ExtfC2CFileUploader))) {
      return ((ExtfC2CFileUploader)this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader).g();
    }
    return 0;
  }
  
  private void n()
  {
    ExtfOfflineDataReport localExtfOfflineDataReport = new ExtfOfflineDataReport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localExtfOfflineDataReport.a(33);
    localExtfOfflineDataReport.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    Object localObject = FileManagerUtil.g(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    localExtfOfflineDataReport.a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin).longValue(), 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, (String)localObject, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
    localExtfOfflineDataReport.c(this.jdField_b_of_type_Boolean);
    long l = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
    if (l > 0L)
    {
      localExtfOfflineDataReport.c(l);
      l = this.f - this.jdField_e_of_type_Long;
      if (l <= 0L) {
        break label184;
      }
      localExtfOfflineDataReport.b(l);
    }
    for (;;)
    {
      localObject = new ExcitingTransferUploadResultRp();
      ((ExcitingTransferUploadResultRp)localObject).mbIsXTFValid = true;
      ((ExcitingTransferUploadResultRp)localObject).mnResult = 33;
      localExtfOfflineDataReport.a((ExcitingTransferUploadResultRp)localObject);
      localExtfOfflineDataReport.b(e());
      localExtfOfflineDataReport.d(this.jdField_c_of_type_Boolean);
      localExtfOfflineDataReport.a(false);
      return;
      localExtfOfflineDataReport.c(0L);
      break;
      label184:
      localExtfOfflineDataReport.b(0L);
    }
  }
  
  public IFileUploader a(FileTransferHandler.FileUploadInfo paramFileUploadInfo, List<String> paramList, int paramInt, boolean paramBoolean, String paramString)
  {
    QLog.i("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "^_^ nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] get ExtfFileUploader. bIsHttps:" + paramBoolean + " strHttpsDomain:" + paramString + " strlanIp:" + paramFileUploadInfo.jdField_e_of_type_JavaLangString);
    paramList = new ExtfOfflineSendWorker.ExtfFileUploadParam(this);
    if ((paramFileUploadInfo.jdField_c_of_type_ArrayOfByte != null) && (paramFileUploadInfo.jdField_c_of_type_ArrayOfByte.length > 0))
    {
      paramList.jdField_b_of_type_ArrayOfByte = paramFileUploadInfo.jdField_c_of_type_ArrayOfByte;
      j();
      a(paramFileUploadInfo.jdField_c_of_type_ArrayOfByte);
    }
    paramList.jdField_a_of_type_Boolean = paramBoolean;
    paramList.jdField_a_of_type_JavaLangString = paramString;
    paramList.jdField_b_of_type_Boolean = paramFileUploadInfo.jdField_b_of_type_Boolean;
    if (paramFileUploadInfo.jdField_b_of_type_Boolean) {}
    for (paramList.jdField_a_of_type_ArrayOfByte = paramFileUploadInfo.f;; paramList.jdField_a_of_type_ArrayOfByte = paramFileUploadInfo.jdField_b_of_type_ArrayOfByte)
    {
      paramList.jdField_a_of_type_Int = paramInt;
      paramList.jdField_c_of_type_ArrayOfByte = paramFileUploadInfo.jdField_e_of_type_ArrayOfByte;
      paramList.jdField_d_of_type_ArrayOfByte = paramFileUploadInfo.jdField_a_of_type_ArrayOfByte;
      paramFileUploadInfo = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin).longValue(), paramList);
      if (paramFileUploadInfo == null) {
        break;
      }
      ((ExtfC2CFileUploader)paramFileUploadInfo).a(this);
      return paramFileUploadInfo;
    }
    QLog.e("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "^_^ nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] get ExtfFileUploader fail.");
    return paramFileUploadInfo;
  }
  
  public void a(int paramInt, ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp) {}
  
  public void a(int paramInt, ExcitingTransferUploaderRp paramExcitingTransferUploaderRp)
  {
    this.jdField_b_of_type_Int = e();
    int i;
    Object localObject;
    if (paramInt != 0)
    {
      i = ExtfC2CFileUploader.a(paramInt);
      b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.a(), i, "subsender_err", "");
      if (paramExcitingTransferUploaderRp == null) {
        break label340;
      }
      localObject = new ExtfOfflineSenderDataReport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ((ExtfOfflineSenderDataReport)localObject).a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      String str = FileManagerUtil.g(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      ((ExtfOfflineSenderDataReport)localObject).a(paramInt);
      ((ExtfOfflineSenderDataReport)localObject).a(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin).longValue(), 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, str, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
      ((ExtfOfflineSenderDataReport)localObject).a(paramExcitingTransferUploaderRp);
      ((ExtfOfflineSenderDataReport)localObject).b(e());
      ((ExtfOfflineSenderDataReport)localObject).c(QFileUtils.b(paramExcitingTransferUploaderRp.mstrServerIp));
      ((ExtfOfflineSenderDataReport)localObject).c(this.jdField_c_of_type_Boolean);
      if (paramInt != 0) {
        break label334;
      }
    }
    label334:
    for (boolean bool = true;; bool = false)
    {
      ((ExtfOfflineSenderDataReport)localObject).a(bool);
      return;
      localObject = new Bundle();
      ((Bundle)localObject).putInt("param_fromType", 1);
      long l = b();
      ((Bundle)localObject).putLong("param_transferTime", l);
      ((Bundle)localObject).putInt("param_V6SelectType", this.jdField_b_of_type_Int);
      ((Bundle)localObject).putInt("param_ipAddrType", d());
      if (this.jdField_c_of_type_Boolean) {}
      for (i = 1;; i = 0)
      {
        ((Bundle)localObject).putInt("param_ishttps", i);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileUpDetail", l, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 1L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.a(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.b(), "", (Bundle)localObject);
        break;
      }
    }
    label340:
    QLog.e("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] onExtfSubUploaderResult datareport fail. no rp");
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (e()) {
      this.jdField_b_of_type_Int = e();
    }
    super.a(paramLong, paramInt, paramString1, paramString2);
    if (e()) {
      a(paramInt);
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    float f1;
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
    {
      if (paramLong3 <= 1048576L) {
        break label82;
      }
      f1 = (float)paramLong3 / 1048576.0F;
      str = new DecimalFormat("0.00").format(f1);
      str = "加速上传 " + str + "MB/s";
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.mExcitingSpeed = str;
      return;
      label82:
      if (paramLong3 > 1024L)
      {
        f1 = (float)paramLong3 / 1024.0F;
        str = new DecimalFormat("0.00").format(f1);
        str = "加速上传 " + str + "KB/s";
      }
      else
      {
        str = "加速上传 " + paramLong3 + "KB/s";
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
    QLog.i("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "setEnableGuardLogic:" + paramBoolean);
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((this.jdField_e_of_type_Boolean) && (paramBoolean) && (e()))
    {
      QLog.e("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "*_* nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] exciting tansfer fail. ftnUploader try again");
      a(paramInt);
      b(true);
      this.jdField_c_of_type_Boolean = false;
      m();
      return;
    }
    super.a(paramBoolean, paramLong, paramInt, paramString1, paramString2);
  }
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.f = System.currentTimeMillis();
      long l1 = this.f;
      long l2 = this.jdField_e_of_type_Long;
      QLog.i("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "^_^ nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] onFullShaCalcDone costTime:" + (l1 - l2) + " bigFile:" + paramBoolean + ". useExtfUploader:" + e());
    } while ((!paramBoolean) || (!e()) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader == null));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader.a(paramArrayOfByte);
  }
  
  public void ar_() {}
  
  public void aw_()
  {
    super.aw_();
  }
  
  public void b(String paramString)
  {
    if (e()) {
      this.jdField_b_of_type_Int = e();
    }
    super.b(paramString);
    if (e()) {
      a(0);
    }
  }
  
  public boolean c()
  {
    return false;
  }
  
  public void d()
  {
    if ((e()) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader != null) && ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader instanceof ExtfC2CFileUploader))) {
      ExtfC2CFileUploader localExtfC2CFileUploader = (ExtfC2CFileUploader)this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader;
    }
    super.d();
  }
  
  public boolean d()
  {
    return false;
  }
  
  public boolean e()
  {
    return !g();
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader instanceof ExtfC2CFileUploader))
    {
      ExcitingTransferUploadResultRp localExcitingTransferUploadResultRp = ((ExtfC2CFileUploader)this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIFileUploader).a();
      if (localExcitingTransferUploadResultRp == null) {
        break label41;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileIdCrc = localExcitingTransferUploadResultRp.mstrFileIdCrc;
    }
    for (;;)
    {
      super.g();
      return;
      label41:
      QLog.e("ExcitingTransfer.OfflineSendWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] onSendSuccess: UploadResultRp is null");
    }
  }
  
  public boolean g()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void k()
  {
    super.k();
    this.jdField_e_of_type_Long = System.currentTimeMillis();
  }
  
  public void l()
  {
    super.l();
    if (e())
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath = "";
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bombData = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.upload.ExtfOfflineSendWorker
 * JD-Core Version:    0.7.0.1
 */