package com.tencent.mobileqq.uniformdownload.core;

import android.os.Bundle;

public class DownloadInfoBuilder
{
  private String a;
  private String b;
  private long c;
  private String d;
  private Bundle e;
  private int f;
  private boolean g;
  
  public static DownloadInfoBuilder a(Bundle paramBundle, String paramString)
  {
    Bundle localBundle2 = paramBundle.getBundle("_user_data");
    Bundle localBundle1 = localBundle2;
    if (localBundle2 == null)
    {
      localBundle2 = new Bundle();
      localBundle1 = localBundle2;
      if (paramBundle.containsKey("big_brother_source_key"))
      {
        localBundle2.putString("big_brother_source_key", paramBundle.getString("big_brother_source_key"));
        localBundle1 = localBundle2;
      }
    }
    return new DownloadInfoBuilder().a(paramString).b(paramBundle.getString("_filename_from_dlg")).a(paramBundle.getLong("_filesize_from_dlg")).c(paramBundle.getString("_notify_name_dialog", "")).a(localBundle1).a(-1).a(false);
  }
  
  public DownloadInfoBuilder a(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public DownloadInfoBuilder a(long paramLong)
  {
    this.c = paramLong;
    return this;
  }
  
  public DownloadInfoBuilder a(Bundle paramBundle)
  {
    this.e = paramBundle;
    return this;
  }
  
  public DownloadInfoBuilder a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public DownloadInfoBuilder a(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public DownloadInfoBuilder b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public long c()
  {
    return this.c;
  }
  
  public DownloadInfoBuilder c(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public Bundle e()
  {
    return this.e;
  }
  
  public int f()
  {
    return this.f;
  }
  
  public boolean g()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.core.DownloadInfoBuilder
 * JD-Core Version:    0.7.0.1
 */