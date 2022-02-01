package com.tencent.mobileqq.uftransfer.task.commonop;

import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.impl.UFTTransferKey;
import com.tencent.mobileqq.uftransfer.common.UFTHashCalculator;
import com.tencent.mobileqq.uftransfer.common.UFTHashCalculator.IHashCalcPrg;
import com.tencent.mobileqq.uftransfer.common.UFTHashCalculator.IHashCalcResult;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.OpRetData;
import com.tencent.mobileqq.uftransfer.task.UFTBaseOp.UFTOpCallback;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTBaseTaskInfo;
import mqq.app.AppRuntime;

public class UFTCalcHashOp
  extends UFTBaseOp
  implements UFTHashCalculator.IHashCalcPrg
{
  protected final String a;
  protected boolean b = false;
  protected final long c;
  protected long d = 0L;
  
  public UFTCalcHashOp(AppRuntime paramAppRuntime, UFTBaseTaskInfo paramUFTBaseTaskInfo, UFTTransferKey paramUFTTransferKey, String paramString, long paramLong, UFTBaseOp.UFTOpCallback paramUFTOpCallback)
  {
    super(paramAppRuntime, paramUFTBaseTaskInfo, paramUFTTransferKey, paramUFTOpCallback);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.c = paramLong;
  }
  
  private boolean a(long paramLong)
  {
    Object localObject;
    if ((1L & paramLong) != 0L)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a().a();
      if ((localObject == null) || (localObject.length == 0))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("TId[");
        ((StringBuilder)localObject).append(a());
        ((StringBuilder)localObject).append("] no 10m md5 calc result");
        UFTLog.d("[UFTTransfer] UFTCalcHashOp", 1, ((StringBuilder)localObject).toString());
        return false;
      }
    }
    if ((0x2 & paramLong) != 0L)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a().b();
      if ((localObject == null) || (localObject.length == 0))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("TId[");
        ((StringBuilder)localObject).append(a());
        ((StringBuilder)localObject).append("] no md5 calc result");
        UFTLog.d("[UFTTransfer] UFTCalcHashOp", 1, ((StringBuilder)localObject).toString());
        return false;
      }
    }
    if ((this.b) && ((0x4 & paramLong) != 0L))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a().c();
      if ((localObject == null) || (localObject.length == 0))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("TId[");
        ((StringBuilder)localObject).append(a());
        ((StringBuilder)localObject).append("] no sha3 calc result");
        UFTLog.d("[UFTTransfer] UFTCalcHashOp", 1, ((StringBuilder)localObject).toString());
        return false;
      }
    }
    if ((paramLong & 0x8) != 0L)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a().d();
      if ((localObject == null) || (localObject.length == 0))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("TId[");
        ((StringBuilder)localObject).append(a());
        ((StringBuilder)localObject).append("] no sha calc result");
        UFTLog.d("[UFTTransfer] UFTCalcHashOp", 1, ((StringBuilder)localObject).toString());
        return false;
      }
    }
    return true;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    super.a();
    UFTHashCalculator.a().a(this.d);
    this.d = 0L;
  }
  
  public void a(long paramLong, int paramInt, UFTHashCalculator.IHashCalcResult paramIHashCalcResult)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    UFTBaseOp.OpRetData localOpRetData = new UFTBaseOp.OpRetData();
    if (paramInt != 0)
    {
      paramIHashCalcResult = new StringBuilder();
      paramIHashCalcResult.append("TId[");
      paramIHashCalcResult.append(a());
      paramIHashCalcResult.append("] on calc hash fail. errCode:");
      paramIHashCalcResult.append(paramInt);
      UFTLog.d("[UFTTransfer] UFTCalcHashOp", 1, paramIHashCalcResult.toString());
      localOpRetData.a(paramInt);
      a(localOpRetData);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] on calc hash suc:");
    UFTLog.b("[UFTTransfer] UFTCalcHashOp", 1, localStringBuilder.toString());
    if ((paramIHashCalcResult.a() > 0L) && (this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a().a() == 0L)) {
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a().a(paramIHashCalcResult.a());
    }
    if ((paramIHashCalcResult.a() != null) && (paramIHashCalcResult.a().length > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a().a(paramIHashCalcResult.a());
    }
    if ((paramIHashCalcResult.b() != null) && (paramIHashCalcResult.b().length > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a().b(paramIHashCalcResult.b());
    }
    if ((paramIHashCalcResult.d() != null) && (paramIHashCalcResult.d().length > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a().c(paramIHashCalcResult.d());
    }
    if ((paramIHashCalcResult.c() != null) && (paramIHashCalcResult.c().length > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a().d(paramIHashCalcResult.c());
    }
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a().a(paramIHashCalcResult.a());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a().b(paramIHashCalcResult.b());
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo.a().c(paramIHashCalcResult.c());
    if (a(this.c)) {
      localOpRetData.a(0);
    } else {
      localOpRetData.a(7);
    }
    a(localOpRetData);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    b(paramLong2, 0L);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    b(paramLong3, paramLong2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  protected int b()
  {
    long l;
    if (this.b) {
      l = 0L;
    } else {
      l = 4L;
    }
    this.d = UFTHashCalculator.a().a(this.jdField_a_of_type_JavaLangString, this.c, l, this);
    if (this.d == 0L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(a());
      localStringBuilder.append("run calc hash fail.");
      UFTLog.d("[UFTTransfer] UFTCalcHashOp", 1, localStringBuilder.toString());
      this.jdField_a_of_type_Boolean = false;
      return 6;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(a());
    localStringBuilder.append("] do calc hash op. calcId:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" calcWhat:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" ignoreWhat:");
    localStringBuilder.append(l);
    UFTLog.b("[UFTTransfer] UFTCalcHashOp", 1, localStringBuilder.toString());
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.commonop.UFTCalcHashOp
 * JD-Core Version:    0.7.0.1
 */