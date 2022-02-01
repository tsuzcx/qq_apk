package com.tencent.mobileqq.util;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.Arrays;

public class PhoneNumQuickLoginManager$AccountInfo
  implements Serializable
{
  private String mImgUrl;
  private String mMaskNick;
  private String mMaskUin;
  private byte[] mUinToken;
  
  public PhoneNumQuickLoginManager$AccountInfo(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3)
  {
    this.mMaskNick = paramString1;
    this.mMaskUin = paramString2;
    this.mUinToken = paramArrayOfByte;
    this.mImgUrl = paramString3;
    if (TextUtils.isEmpty(this.mMaskNick)) {
      this.mMaskNick = this.mMaskUin;
    }
  }
  
  public String getImgUrl()
  {
    return this.mImgUrl;
  }
  
  public String getMaskNick()
  {
    return this.mMaskNick;
  }
  
  public String getMaskUin()
  {
    return this.mMaskUin;
  }
  
  public byte[] getUinToken()
  {
    return this.mUinToken;
  }
  
  public String toString()
  {
    return "AccountInfo{mMaskNick='" + this.mMaskNick + '\'' + ", mMaskUin='" + this.mMaskUin + '\'' + ", mImgUrl='" + this.mImgUrl + '\'' + ", mUinToken='" + Arrays.toString(this.mUinToken) + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.PhoneNumQuickLoginManager.AccountInfo
 * JD-Core Version:    0.7.0.1
 */