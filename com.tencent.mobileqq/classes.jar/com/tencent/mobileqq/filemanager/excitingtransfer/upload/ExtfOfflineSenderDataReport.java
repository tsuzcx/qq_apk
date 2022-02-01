package com.tencent.mobileqq.filemanager.excitingtransfer.upload;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.BaseDataReport;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ExtfOfflineSenderDataReport
  extends BaseDataReport
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  ExcitingTransferUploaderRp jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploaderRp;
  String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long = 0L;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int = 0;
  long jdField_c_of_type_Long = 0L;
  int jdField_d_of_type_Int = 0;
  long jdField_d_of_type_Long = 0L;
  
  public ExtfOfflineSenderDataReport(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public String a(boolean paramBoolean)
  {
    return "actC2CXTFUploadSender";
  }
  
  public HashMap<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_TransferType", String.valueOf(0));
    localHashMap.put("param_Platform", String.valueOf(2));
    localHashMap.put("param_AppType", String.valueOf(0));
    localHashMap.put("param_Result", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("param_FileName", String.valueOf(this.jdField_a_of_type_JavaLangString));
    localHashMap.put("param_Suffix", String.valueOf(this.jdField_b_of_type_JavaLangString));
    localHashMap.put("param_TargetUin", String.valueOf(this.jdField_b_of_type_Long));
    localHashMap.put("param_GroupCode", String.valueOf(this.jdField_c_of_type_Long));
    localHashMap.put("param_FileSize", String.valueOf(this.jdField_d_of_type_Long));
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
      localHashMap.put("param_V6SelectType", String.valueOf(this.jdField_b_of_type_Int));
      localHashMap.put("param_ipAddrType", String.valueOf(this.jdField_c_of_type_Int));
      localHashMap.put("param_stackType", String.valueOf(QFileUtils.b()));
      localHashMap.put("param_loginType", String.valueOf(QFileUtils.c()));
      localHashMap.put("param_ishttps", String.valueOf(this.jdField_d_of_type_Int));
      QLog.d("ExcitingTransfer.OfflineSenderRP<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_Long + "] >>> SenderDataReport:" + localHashMap.toString());
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
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, String paramString2, long paramLong3)
  {
    this.jdField_b_of_type_Long = paramLong1;
    this.jdField_c_of_type_Long = paramLong2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_d_of_type_Long = paramLong3;
  }
  
  public void a(ExcitingTransferUploaderRp paramExcitingTransferUploaderRp)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploaderRp = paramExcitingTransferUploaderRp;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public HashMap<String, String> b()
  {
    return null;
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.jdField_d_of_type_Int = i;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.upload.ExtfOfflineSenderDataReport
 * JD-Core Version:    0.7.0.1
 */