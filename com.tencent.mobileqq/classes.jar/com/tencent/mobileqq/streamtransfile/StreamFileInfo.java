package com.tencent.mobileqq.streamtransfile;

import com.tencent.mobileqq.pttlogic.api.IPttBuffer;
import com.tencent.mobileqq.pttlogic.api.IStreamParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.NetworkCenter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class StreamFileInfo
{
  boolean a = false;
  public long b;
  public long c;
  public final int d;
  private int e;
  private List<StreamDataInfo> f = new ArrayList();
  private String g;
  private int h;
  private long i;
  private short j = 0;
  private short k = 0;
  private short l = 1;
  
  public StreamFileInfo(AppRuntime paramAppRuntime, int paramInt1, String paramString, int paramInt2)
  {
    this.g = paramString;
    this.e = paramInt2;
    paramInt2 = NetworkCenter.getInstance().getNetType();
    this.d = ((IStreamParams)QRoute.api(IStreamParams.class)).getSliceSize(paramAppRuntime, paramInt1, paramInt2);
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).createBufferTask(paramString);
  }
  
  public int a()
  {
    return this.e;
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.i = paramLong;
  }
  
  public void a(short paramShort)
  {
    this.k = paramShort;
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      ((IPttBuffer)QRoute.api(IPttBuffer.class)).flush(this.g);
      return;
    }
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).cancelBufferTask(this.g);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).appendBuffer(this.g, paramArrayOfByte, paramInt);
  }
  
  public List<StreamDataInfo> b()
  {
    return this.f;
  }
  
  public void b(short paramShort)
  {
    this.l = paramShort;
  }
  
  public File c()
  {
    return new File(this.g);
  }
  
  public void c(short paramShort)
  {
    this.j = paramShort;
  }
  
  public short d()
  {
    return this.k;
  }
  
  public int e()
  {
    return this.h;
  }
  
  public short f()
  {
    return this.l;
  }
  
  public short g()
  {
    return this.j;
  }
  
  public void h()
  {
    this.j = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.streamtransfile.StreamFileInfo
 * JD-Core Version:    0.7.0.1
 */