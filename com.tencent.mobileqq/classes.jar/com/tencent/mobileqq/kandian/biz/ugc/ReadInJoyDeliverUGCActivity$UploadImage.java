package com.tencent.mobileqq.kandian.biz.ugc;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ReadInJoyDeliverUGCActivity$UploadImage
{
  private boolean b;
  private String c;
  private int d;
  private long e;
  
  public ReadInJoyDeliverUGCActivity$UploadImage(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity, String paramString, int paramInt)
  {
    this.c = paramString;
    this.d = paramInt;
  }
  
  boolean a()
  {
    return this.b;
  }
  
  public long b()
  {
    return this.e;
  }
  
  public UploadImage c()
  {
    Object localObject = new File(this.c);
    if (!((File)localObject).exists())
    {
      localObject = this.a;
      ((ReadInJoyDeliverUGCActivity)localObject).v = true;
      ((ReadInJoyDeliverUGCActivity)localObject).p();
      localObject = this.a;
      ((ReadInJoyDeliverUGCActivity)localObject).a(1, ((ReadInJoyDeliverUGCActivity)localObject).getString(2131915349));
      this.a.m();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startUploadPic file not exist, path=");
      ((StringBuilder)localObject).append(this.c);
      QLog.d("ReadInJoyDeliverUGCActivity", 2, ((StringBuilder)localObject).toString());
      this.b = true;
      return this;
    }
    this.e = ((File)localObject).length();
    ReadInJoyDeliverUGCActivity.C(this.a).a(this.d, this.e);
    ReadInJoyDeliverUGCActivity.C(this.a).c(this.d, NetConnInfoCenter.getServerTimeMillis());
    this.b = false;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverUGCActivity.UploadImage
 * JD-Core Version:    0.7.0.1
 */