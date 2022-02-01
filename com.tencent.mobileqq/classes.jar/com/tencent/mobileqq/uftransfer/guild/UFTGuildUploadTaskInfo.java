package com.tencent.mobileqq.uftransfer.guild;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.file.UFTGuildUploadRsp;
import com.tencent.mobileqq.guild.file.UFTGuildUploadSuccRsp;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTBaseTaskInfo;
import java.io.File;
import java.util.List;
import tencent.im.oidb.cmd0xfc2.oidb_0xfc2.Addr;

public class UFTGuildUploadTaskInfo
  extends UFTBaseTaskInfo
{
  private UFTGuildUploadInfo a;
  private UFTGuildUploadRsp b;
  private UFTGuildUploadSuccRsp c;
  
  private UFTGuildUploadTaskInfo(long paramLong, int paramInt, UFTGuildUploadInfo paramUFTGuildUploadInfo, UFTTransferConfig paramUFTTransferConfig)
  {
    super(paramLong, paramInt, paramUFTTransferConfig, true);
    this.a = paramUFTGuildUploadInfo;
    a(UFTDependFeatureApi.e(paramUFTGuildUploadInfo.a()));
    paramUFTGuildUploadInfo = new File(paramUFTGuildUploadInfo.a());
    if (paramUFTGuildUploadInfo.exists()) {
      a(paramUFTGuildUploadInfo.length());
    }
  }
  
  public static UFTGuildUploadTaskInfo a(long paramLong, int paramInt, UFTGuildUploadInfo paramUFTGuildUploadInfo, UFTTransferConfig paramUFTTransferConfig)
  {
    if (paramUFTGuildUploadInfo == null) {
      return null;
    }
    if ((!TextUtils.isEmpty(paramUFTGuildUploadInfo.h())) && (!TextUtils.isEmpty(paramUFTGuildUploadInfo.i()))) {
      return new UFTGuildUploadTaskInfo(paramLong, paramInt, paramUFTGuildUploadInfo, paramUFTTransferConfig);
    }
    paramUFTGuildUploadInfo = new StringBuilder();
    paramUFTGuildUploadInfo.append("TId[");
    paramUFTGuildUploadInfo.append(paramLong);
    paramUFTGuildUploadInfo.append("] create task info fail.id is null");
    UFTLog.d("[UFTTransfer] UFTGuildUploadTaskInfo", 1, paramUFTGuildUploadInfo.toString());
    return null;
  }
  
  public String a()
  {
    return this.a.a();
  }
  
  public void a(UFTGuildUploadRsp paramUFTGuildUploadRsp)
  {
    this.b = paramUFTGuildUploadRsp;
  }
  
  public void a(UFTGuildUploadSuccRsp paramUFTGuildUploadSuccRsp)
  {
    this.c = paramUFTGuildUploadSuccRsp;
  }
  
  public boolean b()
  {
    return this.a.d();
  }
  
  public String c()
  {
    return this.a.h();
  }
  
  public String d()
  {
    return this.a.i();
  }
  
  public UFTGuildUploadRsp e()
  {
    return this.b;
  }
  
  public boolean f()
  {
    UFTGuildUploadRsp localUFTGuildUploadRsp = this.b;
    return (localUFTGuildUploadRsp != null) && (localUFTGuildUploadRsp.e());
  }
  
  public long g()
  {
    return this.a.g();
  }
  
  public int h()
  {
    return this.a.c();
  }
  
  public String i()
  {
    return this.a.b();
  }
  
  public byte[] j()
  {
    UFTGuildUploadRsp localUFTGuildUploadRsp = this.b;
    if (localUFTGuildUploadRsp != null) {
      return localUFTGuildUploadRsp.d();
    }
    return null;
  }
  
  public List<oidb_0xfc2.Addr> k()
  {
    UFTGuildUploadRsp localUFTGuildUploadRsp = this.b;
    if (localUFTGuildUploadRsp != null) {
      return localUFTGuildUploadRsp.f();
    }
    return null;
  }
  
  public List<oidb_0xfc2.Addr> l()
  {
    UFTGuildUploadRsp localUFTGuildUploadRsp = this.b;
    if (localUFTGuildUploadRsp != null) {
      return localUFTGuildUploadRsp.g();
    }
    return null;
  }
  
  public String m()
  {
    UFTGuildUploadRsp localUFTGuildUploadRsp = this.b;
    if (localUFTGuildUploadRsp != null) {
      return localUFTGuildUploadRsp.b();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.guild.UFTGuildUploadTaskInfo
 * JD-Core Version:    0.7.0.1
 */