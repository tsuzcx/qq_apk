package com.tencent.mobileqq.data;

import aukm;
import auma;

public class RecommendContact
  extends aukm
{
  public String contactName;
  public boolean isRead;
  @auma
  public String key;
  public String mobileCode;
  public String mobileNo;
  public String nationCode;
  public String nickName;
  public long originBinder;
  public String source;
  public long timeStamp;
  public int type;
  public String uin;
  
  public boolean equals(Object paramObject)
  {
    return this.key.equals(((RecommendContact)paramObject).key);
  }
  
  public int hashCode()
  {
    return this.key.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.RecommendContact
 * JD-Core Version:    0.7.0.1
 */