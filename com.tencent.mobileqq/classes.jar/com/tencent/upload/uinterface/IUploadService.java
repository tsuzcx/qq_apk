package com.tencent.upload.uinterface;

import android.content.Context;
import com.tencent.upload.b.f;

public abstract interface IUploadService
{
  public static final String DOMAIN_PARSER_THREAD_NAME = "domainParser";
  public static final String UPLOAD_HANDLE_THREAD_NAME = "uploadHandle";
  
  public abstract boolean cancel(AbstractUploadTask paramAbstractUploadTask);
  
  public abstract boolean clearCacheWhenIdle(Context paramContext);
  
  public abstract boolean commit(AbstractUploadTask paramAbstractUploadTask);
  
  public abstract void init(Context paramContext, IUploadConfig paramIUploadConfig, IUploadLog paramIUploadLog, IUploadReport paramIUploadReport, IUploadEnv paramIUploadEnv);
  
  public abstract boolean isInitialized();
  
  public abstract void keepImageTmpFile(boolean paramBoolean);
  
  public abstract void pauseAllTask();
  
  public abstract void prepare(TaskTypeConfig paramTaskTypeConfig);
  
  public abstract void setBackgroundMode(boolean paramBoolean);
  
  public abstract void setTestServer(Utility.TestServerCategory paramTestServerCategory);
  
  public abstract boolean setUploadV2Config(V2Config paramV2Config);
  
  public abstract boolean upload(AbstractUploadTask paramAbstractUploadTask);
  
  public static final class UploadServiceCreator
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.uinterface.IUploadService
 * JD-Core Version:    0.7.0.1
 */