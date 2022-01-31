package com.tencent.upload.uinterface;

import android.content.Context;
import com.tencent.upload.b.f;

public class UploadServiceBuilder
{
  public static final IUploadService getInstance()
  {
    return f.a();
  }
  
  public static final IUploadService getMobileLogInstance()
  {
    return f.a();
  }
  
  public static final void init(Context paramContext, IUploadConfig paramIUploadConfig, IUploadLog paramIUploadLog, IUploadReport paramIUploadReport, IUploadEnv paramIUploadEnv)
  {
    f.a().init(paramContext, paramIUploadConfig, paramIUploadLog, paramIUploadReport, paramIUploadEnv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.uinterface.UploadServiceBuilder
 * JD-Core Version:    0.7.0.1
 */