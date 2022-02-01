package com.tencent.mobileqq.uftransfer.task.taskinfo;

import android.text.TextUtils;
import com.tencent.mobileqq.uftransfer.api.UFTFileLocalInfo;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig;

public class UFTBaseTaskInfo
{
  private long a;
  private int b;
  private int c;
  private String d;
  private long e;
  private String f;
  private final UFTFileLocalInfo g = new UFTFileLocalInfo();
  private final UFTTransferConfig h;
  
  public UFTBaseTaskInfo(long paramLong, int paramInt, UFTTransferConfig paramUFTTransferConfig, boolean paramBoolean)
  {
    UFTTransferConfig localUFTTransferConfig = paramUFTTransferConfig;
    if (paramUFTTransferConfig == null) {
      localUFTTransferConfig = new UFTTransferConfig(paramBoolean);
    }
    this.a = paramLong;
    this.b = paramInt;
    this.c = 0;
    this.h = localUFTTransferConfig;
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.e = paramLong;
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public void b(String paramString)
  {
    this.f = paramString;
  }
  
  public long n()
  {
    return this.a;
  }
  
  public String o()
  {
    return this.d;
  }
  
  public long p()
  {
    return this.e;
  }
  
  public String q()
  {
    return this.f;
  }
  
  public UFTFileLocalInfo r()
  {
    return this.g;
  }
  
  public UFTTransferConfig s()
  {
    return this.h;
  }
  
  public byte[] t()
  {
    if (!TextUtils.isEmpty(this.f)) {
      return this.f.getBytes();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.taskinfo.UFTBaseTaskInfo
 * JD-Core Version:    0.7.0.1
 */