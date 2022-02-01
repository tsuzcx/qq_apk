package com.tencent.mobileqq.uftransfer.task.taskinfo;

import android.text.TextUtils;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig;
import com.tencent.mobileqq.uftransfer.api.UFTTroopUploadInfo;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import java.io.File;

public class UFTTroopUploadTaskInfo
  extends UFTBaseTaskInfo
{
  private int a;
  private UFTTroopUploadInfo b;
  private UFTUploadSrvBusiProp.TroopUploadSrvBusiProp c;
  
  private UFTTroopUploadTaskInfo(long paramLong, int paramInt, UFTTroopUploadInfo paramUFTTroopUploadInfo, UFTTransferConfig paramUFTTransferConfig)
  {
    super(paramLong, paramInt, paramUFTTransferConfig, true);
    this.b = paramUFTTroopUploadInfo;
    a(UFTDependFeatureApi.e(paramUFTTroopUploadInfo.a()));
    paramUFTTransferConfig = new File(paramUFTTroopUploadInfo.a());
    if (paramUFTTransferConfig.exists()) {
      a(paramUFTTransferConfig.length());
    }
    this.a = paramUFTTroopUploadInfo.g();
  }
  
  public static UFTTroopUploadTaskInfo a(long paramLong, int paramInt, UFTTroopUploadInfo paramUFTTroopUploadInfo, UFTTransferConfig paramUFTTransferConfig)
  {
    if (paramUFTTroopUploadInfo == null) {
      return null;
    }
    if (TextUtils.isEmpty(paramUFTTroopUploadInfo.b()))
    {
      paramUFTTroopUploadInfo = new StringBuilder();
      paramUFTTroopUploadInfo.append("TId[");
      paramUFTTroopUploadInfo.append(paramLong);
      paramUFTTroopUploadInfo.append("] create task info fail. peer uin is null");
      UFTLog.d("[UFTTransfer] UFTTroopUploadTaskInfo", 1, paramUFTTroopUploadInfo.toString());
      return null;
    }
    return new UFTTroopUploadTaskInfo(paramLong, paramInt, paramUFTTroopUploadInfo, paramUFTTransferConfig);
  }
  
  public String a()
  {
    return this.b.b();
  }
  
  public void a(UFTUploadSrvBusiProp.TroopUploadSrvBusiProp paramTroopUploadSrvBusiProp)
  {
    this.c = paramTroopUploadSrvBusiProp;
  }
  
  public String b()
  {
    return this.b.a();
  }
  
  public void b(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int c()
  {
    return this.b.c();
  }
  
  public int d()
  {
    return this.a;
  }
  
  public String e()
  {
    return this.b.h();
  }
  
  public int f()
  {
    return this.b.k();
  }
  
  public String g()
  {
    return this.b.j();
  }
  
  public boolean h()
  {
    return this.b.d();
  }
  
  public String i()
  {
    UFTUploadSrvBusiProp.TroopUploadSrvBusiProp localTroopUploadSrvBusiProp = this.c;
    if (localTroopUploadSrvBusiProp != null) {
      return localTroopUploadSrvBusiProp.o();
    }
    return "";
  }
  
  public String j()
  {
    UFTUploadSrvBusiProp.TroopUploadSrvBusiProp localTroopUploadSrvBusiProp = this.c;
    if (localTroopUploadSrvBusiProp != null) {
      return localTroopUploadSrvBusiProp.p();
    }
    return "";
  }
  
  public byte[] k()
  {
    UFTUploadSrvBusiProp.TroopUploadSrvBusiProp localTroopUploadSrvBusiProp = this.c;
    if (localTroopUploadSrvBusiProp != null) {
      return localTroopUploadSrvBusiProp.q();
    }
    return null;
  }
  
  public UFTUploadSrvBusiProp.TroopUploadSrvBusiProp l()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.taskinfo.UFTTroopUploadTaskInfo
 * JD-Core Version:    0.7.0.1
 */