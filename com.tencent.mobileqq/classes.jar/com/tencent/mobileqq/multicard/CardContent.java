package com.tencent.mobileqq.multicard;

import com.tencent.mobileqq.activity.aio.intimate.IntimateUtil;
import com.tencent.mobileqq.data.IntimateInfo;

public class CardContent
{
  public int a = -1;
  public IntimateInfo b;
  public String c;
  private long d = 0L;
  
  public CardContent(IntimateInfo paramIntimateInfo)
  {
    this.b = paramIntimateInfo;
    paramIntimateInfo = this.b;
    if (paramIntimateInfo != null) {
      if (!paramIntimateInfo.isFriend) {
        this.a = 1;
      } else {
        this.a = 0;
      }
    }
    this.d = System.currentTimeMillis();
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public long b()
  {
    return this.d;
  }
  
  public String c()
  {
    IntimateInfo localIntimateInfo = this.b;
    if (localIntimateInfo == null) {
      return null;
    }
    return localIntimateInfo.friendUin;
  }
  
  public String d()
  {
    return this.c;
  }
  
  public boolean e()
  {
    IntimateInfo localIntimateInfo = this.b;
    if (localIntimateInfo == null) {
      return false;
    }
    return IntimateUtil.a(localIntimateInfo.maskType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.CardContent
 * JD-Core Version:    0.7.0.1
 */