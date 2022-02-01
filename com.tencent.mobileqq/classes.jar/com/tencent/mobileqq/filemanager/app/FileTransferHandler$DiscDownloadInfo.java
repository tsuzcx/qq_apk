package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x3RspBody;

class FileTransferHandler$DiscDownloadInfo
{
  private long b;
  private String c;
  private int d;
  private String e;
  private String f;
  private String g;
  private String h;
  private short i;
  private String j;
  private Bundle k;
  private cmd0x345.RspBody.SubCmd0x3RspBody l;
  
  public FileTransferHandler$DiscDownloadInfo(FileTransferHandler paramFileTransferHandler, long paramLong, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, short paramShort, String paramString6, Bundle paramBundle, cmd0x345.RspBody.SubCmd0x3RspBody paramSubCmd0x3RspBody)
  {
    this.b = paramLong;
    this.c = paramString1;
    this.d = paramInt;
    this.e = paramString2;
    this.f = paramString3;
    this.g = paramString4;
    this.h = paramString5;
    this.i = paramShort;
    this.j = paramString6;
    this.k = paramBundle;
    this.l = paramSubCmd0x3RspBody;
  }
  
  public long a()
  {
    return this.b;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public String d()
  {
    return this.e;
  }
  
  public String e()
  {
    return this.f;
  }
  
  public String f()
  {
    return this.g;
  }
  
  public String g()
  {
    return this.h;
  }
  
  public short h()
  {
    return this.i;
  }
  
  public String i()
  {
    return this.j;
  }
  
  public DiscDownloadInfo j()
  {
    if (this.l.str_host.has()) {
      this.c = this.l.str_host.get();
    }
    if (this.l.uint32_port.has()) {
      this.d = this.l.uint32_port.get();
    }
    if (this.l.str_check_sum.has()) {
      this.e = this.l.str_check_sum.get();
    }
    Object localObject;
    if (this.l.str_cookie.has())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("FTN5K=");
      ((StringBuilder)localObject).append(this.l.str_cookie.get());
      this.f = ((StringBuilder)localObject).toString();
    }
    if (this.l.int32_ret_code.has()) {
      this.b = this.l.int32_ret_code.get();
    }
    if (this.l.str_ret_msg.has()) {
      this.g = this.l.str_ret_msg.get();
    }
    if (this.l.str_suggest_file_name.has())
    {
      this.h = this.l.str_suggest_file_name.get();
      this.h = FileManagerUtil.a(this.h);
    }
    if (this.l.str_https_domain.has())
    {
      localObject = this.l.str_https_domain.get();
      this.k.putString("strHttpsDomain", (String)localObject);
    }
    if (this.l.uint32_https_port.has()) {
      this.i = ((short)this.l.uint32_https_port.get());
    }
    if (this.l.str_dns.has()) {
      this.j = this.l.str_dns.get();
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileTransferHandler.DiscDownloadInfo
 * JD-Core Version:    0.7.0.1
 */