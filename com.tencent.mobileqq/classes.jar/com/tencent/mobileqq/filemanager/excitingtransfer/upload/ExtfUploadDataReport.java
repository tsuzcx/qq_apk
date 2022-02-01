package com.tencent.mobileqq.filemanager.excitingtransfer.upload;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.BaseDataReport;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public abstract class ExtfUploadDataReport
  extends BaseDataReport
{
  protected String a;
  protected String b;
  protected int d;
  protected long d;
  protected long e = 0L;
  protected long f = 0L;
  protected long g = 0L;
  
  public ExtfUploadDataReport(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_d_of_type_Long = 0L;
    this.jdField_d_of_type_Int = 0;
  }
  
  protected abstract int a();
  
  public HashMap<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_ReportVer", String.valueOf(1));
    localHashMap.put("param_TransferType", String.valueOf(a()));
    localHashMap.put("param_Platform", String.valueOf(2));
    localHashMap.put("param_AppType", String.valueOf(0));
    localHashMap.put("param_Result", String.valueOf(this.jdField_d_of_type_Int));
    localHashMap.put("param_FileName", String.valueOf(this.a));
    localHashMap.put("param_Suffix", String.valueOf(this.b));
    localHashMap.put("param_TargetUin", String.valueOf(this.e));
    localHashMap.put("param_GroupCode", String.valueOf(this.f));
    localHashMap.put("param_FileSize", String.valueOf(this.g));
    return localHashMap;
  }
  
  public void a()
  {
    QLog.e("ExcitingTransfer.UploadDataRP<FileAssistant>", 1, "Id[" + this.jdField_d_of_type_Long + "] reportNetError no implement. please check call");
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, String paramString2, long paramLong3)
  {
    this.e = paramLong1;
    this.f = paramLong2;
    this.a = paramString1;
    this.b = paramString2;
    this.g = paramLong3;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public HashMap<String, String> b()
  {
    QLog.e("ExcitingTransfer.UploadDataRP<FileAssistant>", 1, "Id[" + this.jdField_d_of_type_Long + "] getOldReportData no implement. please check call");
    return null;
  }
  
  public void b()
  {
    QLog.e("ExcitingTransfer.UploadDataRP<FileAssistant>", 1, "Id[" + this.jdField_d_of_type_Long + "] reportUserCancel no implement. please check call");
  }
  
  public void c(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void c(long paramLong)
  {
    this.jdField_d_of_type_Long = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.upload.ExtfUploadDataReport
 * JD-Core Version:    0.7.0.1
 */