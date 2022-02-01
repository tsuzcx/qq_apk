package com.tencent.mobileqq.uftransfer.common.transfer.upload;

import android.text.TextUtils;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;

public class UFTFtnUploader$UperProp
{
  protected int a;
  protected int b;
  protected String c;
  protected String d;
  protected long e;
  protected boolean f;
  protected String g;
  protected String h;
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.e = paramLong;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean a()
  {
    if (TextUtils.isEmpty(this.c))
    {
      UFTLog.d("[UFTTransfer] UFTFtnDataUploader", 1, "strCheckSum is empty");
      return false;
    }
    if (TextUtils.isEmpty(this.d))
    {
      UFTLog.d("[UFTTransfer] UFTFtnDataUploader", 1, "strSHA is empty");
      return false;
    }
    return true;
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void b(String paramString)
  {
    this.d = paramString;
  }
  
  public void c(String paramString)
  {
    this.g = paramString;
  }
  
  public void d(String paramString)
  {
    this.h = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.upload.UFTFtnUploader.UperProp
 * JD-Core Version:    0.7.0.1
 */