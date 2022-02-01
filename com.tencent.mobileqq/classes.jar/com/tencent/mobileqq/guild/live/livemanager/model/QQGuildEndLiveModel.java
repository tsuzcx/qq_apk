package com.tencent.mobileqq.guild.live.livemanager.model;

import android.annotation.SuppressLint;
import java.util.Objects;

public class QQGuildEndLiveModel
{
  private long a;
  private long b;
  private long c;
  private long d;
  private long e;
  private long f;
  
  public static QQGuildEndLiveModel.Builder a()
  {
    return new QQGuildEndLiveModel.Builder(null);
  }
  
  public long b()
  {
    return this.c;
  }
  
  public long c()
  {
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (QQGuildEndLiveModel)paramObject;
      return (this.a == paramObject.a) && (this.b == paramObject.b) && (this.c == paramObject.c) && (this.d == paramObject.d) && (this.e == paramObject.e) && (this.f == paramObject.f);
    }
    return false;
  }
  
  @SuppressLint({"NewApi"})
  public int hashCode()
  {
    return Objects.hash(new Object[] { Long.valueOf(this.a), Long.valueOf(this.b), Long.valueOf(this.c), Long.valueOf(this.d), Long.valueOf(this.e), Long.valueOf(this.f) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQGuildEndLiveModel{roomId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", anchorId=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", totalLiveTime=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", cumulativeUv=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", currentUv=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", totalLikeNum=");
    localStringBuilder.append(this.f);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.livemanager.model.QQGuildEndLiveModel
 * JD-Core Version:    0.7.0.1
 */