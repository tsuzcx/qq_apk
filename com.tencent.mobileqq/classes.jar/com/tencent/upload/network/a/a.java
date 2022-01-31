package com.tencent.upload.network.a;

import com.tencent.upload.c.c;
import com.tencent.upload.common.Const.UploadRetCode;
import com.tencent.upload.network.route.UploadRoute;

public abstract interface a
{
  public abstract void a();
  
  public abstract boolean a(com.tencent.upload.c.a parama, a parama1);
  
  public abstract boolean a(UploadRoute paramUploadRoute);
  
  public abstract UploadRoute b();
  
  public abstract String c();
  
  public abstract b d();
  
  public abstract boolean e();
  
  public static abstract interface a
  {
    public abstract void onRequestError(com.tencent.upload.c.a parama, Const.UploadRetCode paramUploadRetCode, a parama1);
    
    public abstract void onRequestSended(com.tencent.upload.c.a parama);
    
    public abstract void onRequestTimeout(com.tencent.upload.c.a parama, a parama1);
    
    public abstract void onResponse(com.tencent.upload.c.a parama, c paramc);
  }
  
  public static enum b
  {
    private int d;
    private String e;
    
    private b(int paramInt, String paramString)
    {
      this.d = paramInt;
      this.e = paramString;
    }
    
    public String toString()
    {
      return "[" + this.d + "," + this.e + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.network.a.a
 * JD-Core Version:    0.7.0.1
 */