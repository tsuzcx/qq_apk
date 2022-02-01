package com.tencent.mobileqq.uftransfer.task;

import com.tencent.mobileqq.uftransfer.UFTLogicThread;
import com.tencent.mobileqq.uftransfer.api.impl.UFTTransferKey;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTBaseTaskInfo;
import mqq.app.AppRuntime;

public abstract class UFTBaseOp
{
  protected long a;
  protected final UFTTransferKey a;
  protected UFTBaseOp.OpRetData a;
  private UFTBaseOp.UFTOpCallback jdField_a_of_type_ComTencentMobileqqUftransferTaskUFTBaseOp$UFTOpCallback;
  protected final UFTBaseTaskInfo a;
  private String jdField_a_of_type_JavaLangString;
  protected final AppRuntime a;
  protected boolean a;
  protected long b = 0L;
  
  public UFTBaseOp(AppRuntime paramAppRuntime, UFTBaseTaskInfo paramUFTBaseTaskInfo, UFTTransferKey paramUFTTransferKey, UFTBaseOp.UFTOpCallback paramUFTOpCallback)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo = paramUFTBaseTaskInfo;
    this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey = paramUFTTransferKey;
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUFTBaseOp$UFTOpCallback = paramUFTOpCallback;
  }
  
  public int a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.b = 0L;
    this.jdField_a_of_type_Boolean = false;
    return b();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey.a();
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.b = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUFTBaseOp$UFTOpCallback = null;
  }
  
  protected final void a(UFTBaseOp.OpRetData paramOpRetData)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.b = System.currentTimeMillis();
    this.jdField_a_of_type_JavaLangString = paramOpRetData.a();
    UFTBaseOp.OpRetData.a(paramOpRetData, this.jdField_a_of_type_Long);
    UFTBaseOp.OpRetData.b(paramOpRetData, this.b);
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUFTBaseOp$OpRetData = paramOpRetData;
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUFTBaseOp$UFTOpCallback == null) {
      return;
    }
    UFTLogicThread.a().a(new UFTBaseOp.1(this, paramOpRetData));
  }
  
  protected abstract int b();
  
  protected final void b(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    UFTBaseOp.UFTOpCallback localUFTOpCallback = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskUFTBaseOp$UFTOpCallback;
    if (localUFTOpCallback != null) {
      localUFTOpCallback.a(paramLong1, paramLong2);
    }
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.UFTBaseOp
 * JD-Core Version:    0.7.0.1
 */