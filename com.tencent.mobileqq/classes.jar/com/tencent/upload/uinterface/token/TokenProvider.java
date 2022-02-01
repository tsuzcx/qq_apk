package com.tencent.upload.uinterface.token;

import SLICE_UPLOAD.AuthToken;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.utils.UploadLog;

public class TokenProvider
{
  private static final String TAG = "TokenProvider";
  private static volatile TokenProvider sInstance;
  private ITokenEncryptor mTokenEncryptor;
  
  public static AuthToken getAuthToken(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte1 = getInstance().getEncryptTokenData(paramArrayOfByte1);
    int i = getInstance().getTokenEncTye();
    AuthToken localAuthToken = new AuthToken(i, paramArrayOfByte1, paramArrayOfByte2, UploadGlobalConfig.getConfig().getAppId(), UploadGlobalConfig.getConfig().getWtAppId());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" vLoginData.size: ");
    if (paramArrayOfByte1 == null) {
      paramArrayOfByte1 = "null";
    } else {
      paramArrayOfByte1 = Integer.valueOf(paramArrayOfByte1.length);
    }
    localStringBuilder.append(paramArrayOfByte1);
    localStringBuilder.append(" vLoginKey.size: ");
    localStringBuilder.append(paramArrayOfByte2.length);
    localStringBuilder.append(" tokenEncType: ");
    localStringBuilder.append(i);
    UploadLog.i("TokenProvider", localStringBuilder.toString());
    return localAuthToken;
  }
  
  public static TokenProvider getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new TokenProvider();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  public byte[] getEncryptTokenData(byte[] paramArrayOfByte)
  {
    ITokenEncryptor localITokenEncryptor = this.mTokenEncryptor;
    if (localITokenEncryptor == null) {
      return paramArrayOfByte;
    }
    return localITokenEncryptor.getTokenData(paramArrayOfByte);
  }
  
  public int getTokenEncTye()
  {
    ITokenEncryptor localITokenEncryptor = this.mTokenEncryptor;
    if (localITokenEncryptor == null) {
      return 2;
    }
    return localITokenEncryptor.getTokenEncTye();
  }
  
  public TokenProvider setTokenEncryptor(ITokenEncryptor paramITokenEncryptor)
  {
    this.mTokenEncryptor = paramITokenEncryptor;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.uinterface.token.TokenProvider
 * JD-Core Version:    0.7.0.1
 */