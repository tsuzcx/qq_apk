package com.tencent.upload.uinterface;

import android.content.Context;
import com.tencent.upload.impl.UploadServiceProxy;
import com.tencent.upload.uinterface.token.ITokenEncryptor;
import com.tencent.upload.uinterface.token.TokenProvider;

public class UploadServiceBuilder
{
  public static final IUploadService getInstance()
  {
    return UploadServiceProxy.getInstance();
  }
  
  public static final void init(Context paramContext, IUploadConfig paramIUploadConfig, IUploadLog paramIUploadLog, IUploadReport paramIUploadReport, IUploadEnv paramIUploadEnv, IUploadSoLoader paramIUploadSoLoader, ITokenEncryptor paramITokenEncryptor)
  {
    UploadServiceProxy.getInstance().init(paramContext, paramIUploadConfig, paramIUploadLog, paramIUploadReport, paramIUploadEnv, paramIUploadSoLoader);
    TokenProvider.getInstance().setTokenEncryptor(paramITokenEncryptor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.uinterface.UploadServiceBuilder
 * JD-Core Version:    0.7.0.1
 */