package com.vivo.push.model;

public class SubscribeAppInfo
{
  public static final int SUBSCIRBE = 1;
  public static final int SUBSCIRBE_CANCLE = 2;
  private int mActualStatus;
  private String mName;
  private int mTargetStatus;
  
  public SubscribeAppInfo(String paramString, int paramInt1, int paramInt2)
  {
    this.mName = paramString;
    this.mTargetStatus = paramInt1;
    this.mActualStatus = paramInt2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    paramObject = (SubscribeAppInfo)paramObject;
    String str = this.mName;
    if (str == null)
    {
      if (paramObject.mName != null) {
        return false;
      }
    }
    else if (!str.equals(paramObject.mName)) {
      return false;
    }
    return this.mTargetStatus == paramObject.mTargetStatus;
  }
  
  public int getActualStatus()
  {
    return this.mActualStatus;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public int getTargetStatus()
  {
    return this.mTargetStatus;
  }
  
  public int hashCode()
  {
    String str = this.mName;
    int i;
    if (str == null) {
      i = 0;
    } else {
      i = str.hashCode();
    }
    return (i + 31) * 31 + this.mTargetStatus;
  }
  
  public void setActualStatus(int paramInt)
  {
    this.mActualStatus = paramInt;
  }
  
  public void setName(String paramString)
  {
    this.mName = paramString;
  }
  
  public void setTargetStatus(int paramInt)
  {
    this.mTargetStatus = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SubscribeAppInfo [mName=");
    localStringBuilder.append(this.mName);
    localStringBuilder.append(", mTargetStatus=");
    localStringBuilder.append(this.mTargetStatus);
    localStringBuilder.append(", mActualStatus=");
    localStringBuilder.append(this.mActualStatus);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.model.SubscribeAppInfo
 * JD-Core Version:    0.7.0.1
 */