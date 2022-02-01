package com.tencent.mobileqq.uftransfer.task.taskinfo;

import android.text.TextUtils;
import com.tencent.mobileqq.uftransfer.api.UFTC2CUploadInfo;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import java.io.File;

public class UFTC2CUploadTaskInfo
  extends UFTBaseTaskInfo
{
  private final UFTC2CUploadInfo a;
  private UFTUploadSrvBusiProp.C2CUploadSrvBusiProp b;
  
  private UFTC2CUploadTaskInfo(long paramLong, int paramInt, UFTC2CUploadInfo paramUFTC2CUploadInfo, UFTTransferConfig paramUFTTransferConfig)
  {
    super(paramLong, paramInt, paramUFTTransferConfig, true);
    this.a = paramUFTC2CUploadInfo;
    a(UFTDependFeatureApi.e(paramUFTC2CUploadInfo.a()));
    paramUFTC2CUploadInfo = new File(paramUFTC2CUploadInfo.a());
    if (paramUFTC2CUploadInfo.exists()) {
      a(paramUFTC2CUploadInfo.length());
    }
  }
  
  public static UFTC2CUploadTaskInfo a(long paramLong, int paramInt, UFTC2CUploadInfo paramUFTC2CUploadInfo, UFTTransferConfig paramUFTTransferConfig)
  {
    if (paramUFTC2CUploadInfo == null) {
      return null;
    }
    if (TextUtils.isEmpty(paramUFTC2CUploadInfo.b()))
    {
      paramUFTC2CUploadInfo = new StringBuilder();
      paramUFTC2CUploadInfo.append("TId[");
      paramUFTC2CUploadInfo.append(paramLong);
      paramUFTC2CUploadInfo.append("] create task info fail. peer uin is null");
      UFTLog.d("[UFTTransfer] UFTC2CUploadTaskInfo", 1, paramUFTC2CUploadInfo.toString());
      return null;
    }
    return new UFTC2CUploadTaskInfo(paramLong, paramInt, paramUFTC2CUploadInfo, paramUFTTransferConfig);
  }
  
  public String a()
  {
    return this.a.a();
  }
  
  public void a(UFTUploadSrvBusiProp.C2CUploadSrvBusiProp paramC2CUploadSrvBusiProp)
  {
    this.b = paramC2CUploadSrvBusiProp;
  }
  
  public int b()
  {
    return this.a.c();
  }
  
  public String c()
  {
    return this.a.b();
  }
  
  public long d()
  {
    return this.a.g();
  }
  
  public byte[] e()
  {
    return this.a.h();
  }
  
  public String f()
  {
    return this.a.i();
  }
  
  public String g()
  {
    UFTUploadSrvBusiProp.C2CUploadSrvBusiProp localC2CUploadSrvBusiProp = this.b;
    if (localC2CUploadSrvBusiProp != null) {
      return localC2CUploadSrvBusiProp.o();
    }
    return "";
  }
  
  public boolean h()
  {
    UFTUploadSrvBusiProp.C2CUploadSrvBusiProp localC2CUploadSrvBusiProp = this.b;
    if (localC2CUploadSrvBusiProp != null) {
      return localC2CUploadSrvBusiProp.n();
    }
    return false;
  }
  
  public boolean i()
  {
    UFTUploadSrvBusiProp.C2CUploadSrvBusiProp localC2CUploadSrvBusiProp = this.b;
    if (localC2CUploadSrvBusiProp != null) {
      return localC2CUploadSrvBusiProp.g();
    }
    return false;
  }
  
  public String j()
  {
    UFTUploadSrvBusiProp.C2CUploadSrvBusiProp localC2CUploadSrvBusiProp = this.b;
    if (localC2CUploadSrvBusiProp != null) {
      return localC2CUploadSrvBusiProp.r();
    }
    return "";
  }
  
  public boolean k()
  {
    return this.a.d();
  }
  
  public UFTUploadSrvBusiProp.C2CUploadSrvBusiProp l()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.taskinfo.UFTC2CUploadTaskInfo
 * JD-Core Version:    0.7.0.1
 */