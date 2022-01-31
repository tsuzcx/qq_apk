package com.tencent.upload.c.a;

import SLICE_UPLOAD.CheckType;
import SLICE_UPLOAD.FileUploadReq;
import com.qq.taf.jce.JceStruct;
import com.tencent.upload.common.FileUtils;
import com.tencent.upload.d.a.a;
import java.io.IOException;

public class d
  extends com.tencent.upload.c.b
{
  public long b;
  public long c = 0L;
  private a d;
  private String e;
  private String f;
  private String g;
  private long h;
  private CheckType i;
  private byte[] j;
  private boolean k;
  
  public d(a parama, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, CheckType paramCheckType, boolean paramBoolean)
  {
    this.d = parama;
    this.e = paramString1;
    this.f = paramString2;
    this.g = paramString3;
    this.b = paramLong1;
    this.h = paramLong2;
    this.i = paramCheckType;
    this.k = paramBoolean;
    this.c = this.d.c();
  }
  
  public int d()
  {
    return 2;
  }
  
  public boolean e()
  {
    return true;
  }
  
  protected JceStruct h()
    throws IOException
  {
    FileUploadReq localFileUploadReq = new FileUploadReq();
    localFileUploadReq.uin = this.e;
    localFileUploadReq.appid = this.f;
    localFileUploadReq.offset = this.b;
    localFileUploadReq.session = this.g;
    localFileUploadReq.check_type = 1;
    if (this.k)
    {
      localObject = new byte[(int)this.h];
      this.d.a(this.b, (int)this.h, (byte[])localObject, 0);
      this.j = ((byte[])localObject);
      localFileUploadReq.check_type = this.i.value();
      localFileUploadReq.checksum = FileUtils.getFileSha1(localFileUploadReq.data);
    }
    Object localObject = null;
    for (long l1 = 0L;; l1 = l2)
    {
      try
      {
        arrayOfByte2 = new byte[(int)this.h];
        localObject = arrayOfByte2;
        if (this.j == null) {
          break label210;
        }
        localObject = arrayOfByte2;
        if (this.j.length <= 0) {
          break label210;
        }
        localObject = arrayOfByte2;
        System.arraycopy(this.j, 0, arrayOfByte2, 0, (int)this.h);
        localObject = arrayOfByte2;
        this.j = null;
        l1 = 0L;
        localObject = arrayOfByte2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          byte[] arrayOfByte2;
          long l2;
          com.tencent.upload.common.b.e("FileUploadRequest", "encode request OOM. gc, then retry");
          System.gc();
          arrayOfByte1 = new byte[(int)this.h];
          if ((this.j != null) && (this.j.length > 0))
          {
            System.arraycopy(this.j, 0, arrayOfByte1, 0, (int)this.h);
            this.j = null;
          }
          else
          {
            l1 = this.d.a((int)this.b, (int)this.h, arrayOfByte1, 0);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        label210:
        byte[] arrayOfByte1;
        for (;;)
        {
          com.tencent.upload.common.b.c("FileUploadRequest", "encode exception. reqId=" + c(), localThrowable);
        }
        localFileUploadReq.data = arrayOfByte1;
      }
      if ((localObject != null) && (l1 != 0L)) {
        break label360;
      }
      com.tencent.upload.common.b.e("FileUploadRequest", "encode data == null");
      return null;
      localObject = arrayOfByte2;
      l2 = this.d.a((int)this.b, (int)this.h, arrayOfByte2, 0);
    }
    label360:
    return localFileUploadReq;
  }
  
  public long i()
  {
    return this.h;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("taskId=").append(b()).append(" reqId=").append(c()).append(" cmd=").append(d()).append(" offset=").append(this.b).append(" dataSize=").append(this.h);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.c.a.d
 * JD-Core Version:    0.7.0.1
 */