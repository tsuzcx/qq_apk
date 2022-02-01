package com.tencent.mobileqq.uftransfer.task.taskinfo;

import android.text.TextUtils;
import com.tencent.mobileqq.uftransfer.api.UFTDiscUploadInfo;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import java.io.File;

public class UFTDiscUploadTaskInfo
  extends UFTBaseTaskInfo
{
  private final UFTDiscUploadInfo a;
  private UFTUploadSrvBusiProp.DiscUploadSrvBusiProp b;
  
  private UFTDiscUploadTaskInfo(long paramLong, int paramInt, UFTDiscUploadInfo paramUFTDiscUploadInfo, UFTTransferConfig paramUFTTransferConfig)
  {
    super(paramLong, paramInt, paramUFTTransferConfig, true);
    this.a = paramUFTDiscUploadInfo;
    a(UFTDependFeatureApi.e(paramUFTDiscUploadInfo.a()));
    paramUFTDiscUploadInfo = new File(paramUFTDiscUploadInfo.a());
    if (paramUFTDiscUploadInfo.exists()) {
      a(paramUFTDiscUploadInfo.length());
    }
  }
  
  public static UFTDiscUploadTaskInfo a(long paramLong, int paramInt, UFTDiscUploadInfo paramUFTDiscUploadInfo, UFTTransferConfig paramUFTTransferConfig)
  {
    if (paramUFTDiscUploadInfo == null) {
      return null;
    }
    if (TextUtils.isEmpty(paramUFTDiscUploadInfo.b()))
    {
      paramUFTDiscUploadInfo = new StringBuilder();
      paramUFTDiscUploadInfo.append("TId[");
      paramUFTDiscUploadInfo.append(paramLong);
      paramUFTDiscUploadInfo.append("] create task info fail. peer uin is null");
      UFTLog.d("[UFTTransfer] UFTDiscUploadTaskInfo", 1, paramUFTDiscUploadInfo.toString());
      return null;
    }
    return new UFTDiscUploadTaskInfo(paramLong, paramInt, paramUFTDiscUploadInfo, paramUFTTransferConfig);
  }
  
  public String a()
  {
    return this.a.a();
  }
  
  public void a(UFTUploadSrvBusiProp.DiscUploadSrvBusiProp paramDiscUploadSrvBusiProp)
  {
    this.b = paramDiscUploadSrvBusiProp;
  }
  
  public int b()
  {
    return this.a.c();
  }
  
  public String c()
  {
    return this.a.b();
  }
  
  public boolean d()
  {
    return this.a.d();
  }
  
  public String e()
  {
    UFTUploadSrvBusiProp.DiscUploadSrvBusiProp localDiscUploadSrvBusiProp = this.b;
    if (localDiscUploadSrvBusiProp != null) {
      return localDiscUploadSrvBusiProp.j();
    }
    return "";
  }
  
  public UFTUploadSrvBusiProp.DiscUploadSrvBusiProp f()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.taskinfo.UFTDiscUploadTaskInfo
 * JD-Core Version:    0.7.0.1
 */