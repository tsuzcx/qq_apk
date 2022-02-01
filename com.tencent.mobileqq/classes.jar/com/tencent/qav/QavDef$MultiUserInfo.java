package com.tencent.qav;

import java.io.Serializable;

public class QavDef$MultiUserInfo
  implements Serializable
{
  public boolean mMicOn;
  public String mOpenId;
  public long mUin;
  
  public static void copyTo(MultiUserInfo paramMultiUserInfo1, MultiUserInfo paramMultiUserInfo2)
  {
    paramMultiUserInfo2.mUin = paramMultiUserInfo1.mUin;
    paramMultiUserInfo2.mOpenId = paramMultiUserInfo1.mOpenId;
    paramMultiUserInfo2.mMicOn = paramMultiUserInfo1.mMicOn;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MultiUserInfo{mUin=");
    localStringBuilder.append(this.mUin);
    localStringBuilder.append(", mOpenId='");
    localStringBuilder.append(this.mOpenId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mMicOn=");
    localStringBuilder.append(this.mMicOn);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qav.QavDef.MultiUserInfo
 * JD-Core Version:    0.7.0.1
 */