package com.tencent.mobileqq.flashshow.data;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StUser;

public class FSUserStateData
{
  private final String a;
  private int b = -1;
  private int c = -1;
  private int d = -1;
  private int e = -1;
  
  public FSUserStateData(String paramString)
  {
    this.a = paramString;
  }
  
  public FSUserStateData(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramString;
    this.c = paramInt1;
    this.b = paramInt2;
    this.e = paramInt4;
    this.d = paramInt3;
  }
  
  public static FSUserStateData a(FeedCloudMeta.StUser paramStUser)
  {
    FSUserStateData localFSUserStateData = new FSUserStateData(paramStUser.id.get());
    if (paramStUser.followState.has()) {
      localFSUserStateData.a(paramStUser.followState.get());
    }
    return localFSUserStateData;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  public int c()
  {
    return this.b;
  }
  
  public void c(int paramInt)
  {
    this.e = paramInt;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public int e()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.data.FSUserStateData
 * JD-Core Version:    0.7.0.1
 */