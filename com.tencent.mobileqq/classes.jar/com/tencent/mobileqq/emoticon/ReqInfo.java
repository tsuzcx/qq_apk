package com.tencent.mobileqq.emoticon;

public class ReqInfo
{
  public int encryptKeysResultCode = 0;
  public boolean encryptKeysSuccess = false;
  public String strGetKeySeq = null;
  public String timeoutReason;
  
  public int getEncryptKeyResultCode()
  {
    if (this.encryptKeysSuccess) {
      return 0;
    }
    int i = this.encryptKeysResultCode;
    if (i == 1002) {
      return 11023;
    }
    if (i == 11022) {
      return 11022;
    }
    return 11009;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.ReqInfo
 * JD-Core Version:    0.7.0.1
 */