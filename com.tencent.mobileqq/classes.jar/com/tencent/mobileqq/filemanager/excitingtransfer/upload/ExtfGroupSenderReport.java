package com.tencent.mobileqq.filemanager.excitingtransfer.upload;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ExtfGroupSenderReport
  extends ExtfUploadDataReport
{
  int jdField_a_of_type_Int = 0;
  ExcitingTransferUploaderRp jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploaderRp;
  int b = 0;
  int c = 0;
  
  public ExtfGroupSenderReport(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected int a()
  {
    return 2;
  }
  
  public String a(boolean paramBoolean)
  {
    return "actGroupXTFUploadSender";
  }
  
  public HashMap<String, String> a()
  {
    HashMap localHashMap = super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploaderRp != null)
    {
      localHashMap.put("param_Result", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploaderRp.mnResult));
      localHashMap.put("param_IsBigData", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploaderRp.mbIsBigData));
      localHashMap.put("param_HttpTime", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploaderRp.mu64HttpTime));
      localHashMap.put("param_SrvReturCode", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploaderRp.mnSrvReturCode));
      localHashMap.put("param_TransferSpeed", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploaderRp.mu64TransferSpeed));
      localHashMap.put("param_TransferSize", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploaderRp.mu64TransferSize));
      localHashMap.put("param_ServerIp", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploaderRp.mstrServerIp));
      localHashMap.put("param_ServerPort", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploaderRp.mwServerPort));
      localHashMap.put("param_FileUrl", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploaderRp.mstrFileUrl));
    }
    for (;;)
    {
      localHashMap.put("param_V6SelectType", String.valueOf(this.jdField_a_of_type_Int));
      localHashMap.put("param_ipAddrType", String.valueOf(this.b));
      localHashMap.put("param_stackType", String.valueOf(QFileUtils.b()));
      localHashMap.put("param_loginType", String.valueOf(QFileUtils.c()));
      localHashMap.put("param_ishttps", String.valueOf(this.c));
      QLog.i("ExcitingTransfer.ExtfGroupSenderRP<FileAssistant>", 1, "Id[" + this.d + "] >>> GroupSenderDataReport:act=" + a(false) + localHashMap.toString());
      return localHashMap;
      localHashMap.put("param_IsBigData", String.valueOf(false));
      localHashMap.put("param_HttpTime", String.valueOf(0));
      localHashMap.put("param_SrvReturCode", String.valueOf(0));
      localHashMap.put("param_TransferSpeed", String.valueOf(0));
      localHashMap.put("param_TransferSize", String.valueOf(0));
      localHashMap.put("param_ServerIp", String.valueOf(0));
      localHashMap.put("param_ServerPort", String.valueOf(0));
      localHashMap.put("param_FileUrl", "");
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(ExcitingTransferUploaderRp paramExcitingTransferUploaderRp)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploaderRp = paramExcitingTransferUploaderRp;
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.c = i;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.upload.ExtfGroupSenderReport
 * JD-Core Version:    0.7.0.1
 */