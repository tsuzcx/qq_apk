package com.tencent.upload.c.a;

import SLICE_UPLOAD.AuthToken;
import SLICE_UPLOAD.CheckType;
import SLICE_UPLOAD.FileControlReq;
import SLICE_UPLOAD.UploadModel;
import SLICE_UPLOAD.stEnvironment;
import com.qq.taf.jce.JceStruct;
import com.tencent.upload.c.b;

public class c
  extends b
{
  private String b;
  private String c;
  private AuthToken d;
  private String e;
  private CheckType f;
  private long g;
  private stEnvironment h;
  private UploadModel i;
  private byte[] j;
  private String k;
  private boolean l;
  private boolean m;
  private int n;
  
  public c(String paramString1, String paramString2, AuthToken paramAuthToken, String paramString3, CheckType paramCheckType, long paramLong, stEnvironment paramstEnvironment, UploadModel paramUploadModel, String paramString4, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramAuthToken;
    this.e = paramString3;
    this.f = paramCheckType;
    this.g = paramLong;
    this.h = paramstEnvironment;
    this.i = paramUploadModel;
    this.k = paramString4;
    this.l = paramBoolean1;
    this.m = paramBoolean2;
    this.n = paramInt;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.j = paramArrayOfByte;
  }
  
  public JceStruct h()
  {
    FileControlReq localFileControlReq = new FileControlReq();
    localFileControlReq.uin = this.b;
    localFileControlReq.appid = this.c;
    localFileControlReq.token = this.d;
    localFileControlReq.file_len = this.g;
    localFileControlReq.env = this.h;
    localFileControlReq.model = this.i.value();
    localFileControlReq.biz_req = this.j;
    localFileControlReq.session = this.k;
    localFileControlReq.need_ip_redirect = this.l;
    localFileControlReq.check_type = this.f.value();
    localFileControlReq.checksum = this.e;
    if (this.m) {
      localFileControlReq.check_type = this.f.value();
    }
    localFileControlReq.asy_upload = this.n;
    return localFileControlReq;
  }
  
  public long i()
  {
    return this.g;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("taskId=").append(b()).append(" reqId=").append(c()).append(" cmd=").append(d()).append(" mUin=").append(this.b).append(" mAppid=").append(this.c).append(" mChecksum=").append(this.e).append(" mCheckType=").append(this.f).append(" mFileLength=").append(this.g).append(" mModel=").append(this.i).append(" mSession=").append(this.k).append(" mNeedIpRedirect=").append(this.l);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.c.a.c
 * JD-Core Version:    0.7.0.1
 */