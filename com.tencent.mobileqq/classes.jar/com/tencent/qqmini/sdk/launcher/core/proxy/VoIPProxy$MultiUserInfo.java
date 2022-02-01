package com.tencent.qqmini.sdk.launcher.core.proxy;

public final class VoIPProxy$MultiUserInfo
{
  public boolean mMicOn;
  public String mOpenId;
  public long mUin;
  
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
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy.MultiUserInfo
 * JD-Core Version:    0.7.0.1
 */