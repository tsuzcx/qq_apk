package com.tencent.mobileqq.onlinestatus.olympic.model;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import trpc.qq_onlinestatus.olympic_medal.OlympicMedalEvent.MedalEventInfo;

public class OlympicMedalEventInfo
{
  private boolean a;
  private int b;
  private long c;
  private long d;
  private int e;
  private String f;
  
  public OlympicMedalEventInfo()
  {
    this.a = false;
    this.b = -1;
    this.c = -1L;
    this.d = -1L;
    this.e = -1;
    this.f = null;
  }
  
  public OlympicMedalEventInfo(int paramInt, long paramLong1, long paramLong2, String paramString)
  {
    this.a = true;
    this.b = paramInt;
    this.c = paramLong1;
    this.d = paramLong2;
    this.e = -1;
    this.f = paramString;
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void a(OlympicMedalEventInfo paramOlympicMedalEventInfo)
  {
    this.f = paramOlympicMedalEventInfo.f();
    this.e = paramOlympicMedalEventInfo.e();
    this.b = paramOlympicMedalEventInfo.b();
  }
  
  public void a(OlympicMedalEvent.MedalEventInfo paramMedalEventInfo)
  {
    if (paramMedalEventInfo.event_id.has()) {
      this.b = paramMedalEventInfo.event_id.get();
    }
    if (paramMedalEventInfo.start.has()) {
      this.c = paramMedalEventInfo.start.get();
    }
    if (paramMedalEventInfo.end.has()) {
      this.d = paramMedalEventInfo.end.get();
    }
    if (paramMedalEventInfo.msg.has()) {
      this.f = paramMedalEventInfo.msg.get();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public long c()
  {
    return this.c;
  }
  
  public long d()
  {
    return this.d;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public String f()
  {
    return this.f;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OlympicMedalEventInfo@{isValid=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" eventId=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" start=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" end=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" pullInterval=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" msg=");
    localStringBuilder.append(this.f);
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.olympic.model.OlympicMedalEventInfo
 * JD-Core Version:    0.7.0.1
 */