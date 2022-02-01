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
  protected final long b;
  protected long c = 0L;
  protected boolean d = false;
  
  public UFTCalcHashOp(AppRuntime paramAppRuntime, UFTBaseTaskInfo paramUFTBaseTaskInfo, UFTTransferKey paramUFTTransferKey, String paramString, long paramLong, UFTBaseOp.UFTOpCallback paramUFTOpCallback)
  {
    super(paramAppRuntime, paramUFTBaseTaskInfo, paramUFTTransferKey, paramUFTOpCallback);
    this.a = paramString;
    this.b = paramLong;
  }
  
  private boolean a(long paramLong)
  {
    Object localObject;
    if ((1L & paramLong) != 0L)
    {
      localObject = this.h.r().b();
      if ((localObject == null) || (localObject.length == 0))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("TId[");
        ((StringBuilder)localObject).append(i());
        ((StringBuilder)localObject).append("] no 10m md5 calc result");
        UFTLog.d("[UFTTransfer] UFTCalcHashOp", 1, ((StringBuilder)localObject).toString());
        return false;
      }
    }
    if ((0x2 & paramLong) != 0L)
    {
      localObject = this.h.r().c();
      if ((localObject == null) || (localObject.length == 0))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("TId[");
        ((StringBuilder)localObject).append(i());
        ((StringBuilder)localObject).append("] no md5 calc result");
        UFTLog.d("[UFTTransfer] UFTCalcHashOp", 1, ((StringBuilder)localObject).toString());
        return false;
      }
    }
    if ((this.d) && ((0x4 & paramLong) != 0L))
    {
      localObject = this.h.r().d();
      if ((localObject == null) || (localObject.length == 0))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("TId[");
        ((StringBuilder)localObject).append(i());
        ((StringBuilder)localObject).append("] no sha3 calc result");
        UFTLog.d("[UFTTransfer] UFTCalcHashOp", 1, ((StringBuilder)localObject).toString());
        return false;
      }
    }
    if ((paramLong & 0x8) != 0L)
    {
      localObject = this.h.r().e();
      if ((localObject == null) || (localObject.length == 0))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("TId[");
        ((StringBuilder)localObject).append(i());
        ((StringBuilder)localObject).append("] no sha calc result");
        UFTLog.d("[UFTTransfer] UFTCalcHashOp", 1, ((StringBuilder)localObject).toString());
        return false;
      }
    }
    return true;
  }
  
  public void a(long paramLong, int paramInt, UFTHashCalculator.IHashCalcResult paramIHashCalcResult)
  {
    if (this.j) {
      return;
    }
    UFTBaseOp.OpRetData localOpRetData = new UFTBaseOp.OpRetData();
    if (paramInt != 0)
    {
      paramIHashCalcResult = new StringBuilder();
      paramIHashCalcResult.append("TId[");
      paramIHashCalcResult.append(i());
      paramIHashCalcResult.append("] on calc hash fail. errCode:");
      paramIHashCalcResult.append(paramInt);
      UFTLog.d("[UFTTransfer] UFTCalcHashOp", 1, paramIHashCalcResult.toString());
      localOpRetData.a(paramInt);
      a(localOpRetData);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(i());
    localStringBuilder.append("] on calc hash suc:");
    UFTLog.b("[UFTTransfer] UFTCalcHashOp", 1, localStringBuilder.toString());
    if ((paramIHashCalcResult.a() > 0L) && (this.h.r().a() == 0L)) {
      this.h.r().a(paramIHashCalcResult.a());
    }
    if ((paramIHashCalcResult.b() != null) && (paramIHashCalcResult.b().length > 0)) {
      this.h.r().a(paramIHashCalcResult.b());
    }
    if ((paramIHashCalcResult.c() != null) && (paramIHashCalcResult.c().length > 0)) {
      this.h.r().b(paramIHashCalcResult.c());
    }
    if ((paramIHashCalcResult.e() != null) && (paramIHashCalcResult.e().length > 0)) {
      this.h.r().c(paramIHashCalcResult.e());
    }
    if ((paramIHashCalcResult.d() != null) && (paramIHashCalcResult.d().length > 0)) {
      this.h.r().d(paramIHashCalcResult.d());
    }
    this.h.r().a(paramIHashCalcResult.f());
    this.h.r().b(paramIHashCalcResult.g());
    this.h.r().c(paramIHashCalcResult.h());
    if (a(this.b)) {
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
    this.d = paramBoolean;
  }
  
  protected int c()
  {
    long l;
    if (this.d) {
      l = 0L;
    } else {
      l = 4L;
    }
    this.c = UFTHashCalculator.a().a(this.a, this.b, l, this);
    if (this.c == 0L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("TId[");
      localStringBuilder.append(i());
      localStringBuilder.append("run calc hash fail.");
      UFTLog.d("[UFTTransfer] UFTCalcHashOp", 1, localStringBuilder.toString());
      this.j = false;
      return 6;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TId[");
    localStringBuilder.append(i());
    localStringBuilder.append("] do calc hash op. calcId:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" calcWhat:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" ignoreWhat:");
    localStringBuilder.append(l);
    UFTLog.b("[UFTTransfer] UFTCalcHashOp", 1, localStringBuilder.toString());
    return 0;
  }
  
  public void f()
  {
    if (this.j) {
      return;
    }
    super.f();
    UFTHashCalculator.a().a(this.c);
    this.c = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.commonop.UFTCalcHashOp
 * JD-Core Version:    0.7.0.1
 */