package com.tencent.mobileqq.kandian.repo.feeds;

import java.net.URL;

public class WaterFallPic
{
  public URL a;
  public int b;
  public int c;
  public int d;
  public int e;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WaterFallPic]--> url=");
    Object localObject = this.a;
    if (localObject != null) {
      localObject = ((URL)localObject).toString();
    } else {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(",originWidth =");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",originHeight =");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",calcHeight =");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",scaleHeight =");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.WaterFallPic
 * JD-Core Version:    0.7.0.1
 */