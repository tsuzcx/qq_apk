package com.tencent.mobileqq.uniformdownload.downloader;

import android.os.Bundle;

public class UniformDownloaderAppBabySdk$RParam
{
  public long a = 0L;
  public long b = 0L;
  
  public UniformDownloaderAppBabySdk$RParam(long paramLong1, long paramLong2)
  {
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  public static RParam a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    return new RParam(paramBundle.getLong("RPARAM_RECV_SIZE"), paramBundle.getLong("RPARAM_TRANS_SIZE"));
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("RPARAM_RECV_SIZE", this.a);
    localBundle.putLong("RPARAM_TRANS_SIZE", this.b);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.downloader.UniformDownloaderAppBabySdk.RParam
 * JD-Core Version:    0.7.0.1
 */