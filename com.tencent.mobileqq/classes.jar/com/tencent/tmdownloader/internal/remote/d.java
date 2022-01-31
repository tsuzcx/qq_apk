package com.tencent.tmdownloader.internal.remote;

import com.tencent.tmassistant.st.SDKReportManager2;
import com.tencent.tmassistantbase.util.Settings;
import com.tencent.tmassistantbase.util.ac;
import com.tencent.tmassistantbase.util.t;
import com.tencent.tmdownloader.internal.a.a;

public class d
  extends b
{
  public void a()
  {
    SDKReportManager2.getInstance();
  }
  
  public void a(int paramInt, String paramString)
  {
    ac.c("RemoteOpImpl", "<RemoteOpImpl.postReport> process:" + t.e() + ", type = " + paramInt + ", data = " + paramString);
    SDKReportManager2.getInstance().postReport(paramInt, paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    Settings.getInstance().setInt(paramString, paramInt);
  }
  
  public void a(String paramString, long paramLong)
  {
    Settings.getInstance().setLong(paramString, paramLong);
  }
  
  public void a(String paramString1, String paramString2)
  {
    Settings.getInstance().setString(paramString1, paramString2);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Settings.getInstance().setBoolean(paramString, paramBoolean);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    ac.c("RemoteOpImpl", "<RemoteOpImpl.postReport> process:" + t.e() + ", key = " + paramString + ", valueSize = " + paramArrayOfByte.length);
    Settings.getInstance().setBlob(paramString, paramArrayOfByte);
  }
  
  public byte[] a(String paramString)
  {
    return Settings.getInstance().getBlob(paramString);
  }
  
  public int b(String paramString)
  {
    return Settings.getInstance().getInt(paramString);
  }
  
  public void b()
  {
    a.a().b();
  }
  
  public long c(String paramString)
  {
    return Settings.getInstance().getLong(paramString);
  }
  
  public void c()
  {
    a.a().c();
  }
  
  public String d(String paramString)
  {
    return Settings.getInstance().getString(paramString);
  }
  
  public void d()
  {
    a.a().d();
  }
  
  public boolean e(String paramString)
  {
    return Settings.getInstance().getBoolean(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.remote.d
 * JD-Core Version:    0.7.0.1
 */