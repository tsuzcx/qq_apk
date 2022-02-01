package com.tencent.mobileqq.kandian.base.image;

import com.tencent.image.DownloadParams;

public class RIJImageDownloadParams
  extends DownloadParams
{
  public boolean a;
  public boolean b;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.url);
    localStringBuilder.append(" urlStr: ");
    localStringBuilder.append(this.urlStr);
    localStringBuilder.append(" retryCount: ");
    localStringBuilder.append(this.retryCount);
    localStringBuilder.append(" supportInnerIp: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" useIpConnect:");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.RIJImageDownloadParams
 * JD-Core Version:    0.7.0.1
 */