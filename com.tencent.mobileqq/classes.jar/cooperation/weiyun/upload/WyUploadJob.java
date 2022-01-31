package cooperation.weiyun.upload;

import bgwa;
import bgwc;
import com.tencent.weiyun.uploader.IReporter;
import com.tencent.weiyun.uploader.IUploader;
import com.tencent.weiyun.uploader.IUploader.IUploadListener;
import com.tencent.weiyun.uploader.UploadRequest;
import com.tencent.weiyun.uploader.UploadResponse;
import com.tencent.weiyun.uploader.UploadResponse.Builder;
import com.tencent.weiyun.uploader.xplatform.UploadNative.CanceledFlag;
import java.io.File;

public class WyUploadJob
  implements IUploader, Runnable
{
  private volatile int jdField_a_of_type_Int;
  private IUploader.IUploadListener jdField_a_of_type_ComTencentWeiyunUploaderIUploader$IUploadListener;
  protected UploadRequest a;
  protected File a;
  protected volatile boolean a;
  protected volatile boolean b;
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  bgwa a(UploadRequest paramUploadRequest)
  {
    return new bgwc(paramUploadRequest, this);
  }
  
  UploadResponse a(int paramInt)
  {
    UploadResponse.Builder localBuilder = new UploadResponse.Builder();
    localBuilder.request(this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest);
    localBuilder.code(paramInt);
    return localBuilder.build();
  }
  
  void a()
  {
    this.jdField_a_of_type_ComTencentWeiyunUploaderIUploader$IUploadListener.onUploadCanceled(this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest);
  }
  
  protected void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    double d = paramLong1 / paramLong2;
    this.jdField_a_of_type_ComTencentWeiyunUploaderIUploader$IUploadListener.onUploadProgress(this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest, paramLong2, (float)d, 0L, 0L, 0L);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    UploadResponse localUploadResponse = a(paramInt);
    this.jdField_a_of_type_ComTencentWeiyunUploaderIUploader$IUploadListener.onUploadFinished(this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest, paramBoolean, localUploadResponse);
  }
  
  public boolean a()
  {
    return (!this.jdField_a_of_type_Boolean) && (!this.b);
  }
  
  boolean b()
  {
    if (!a()) {}
    while (!c()) {
      return false;
    }
    return true;
  }
  
  boolean c()
  {
    int i = a(this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest).a();
    a(i);
    return (i == 1810002) || (i == 0);
  }
  
  public String[] calSliceSha1(String paramString, UploadNative.CanceledFlag paramCanceledFlag)
  {
    return null;
  }
  
  public void cancel(UploadRequest paramUploadRequest)
  {
    if ((paramUploadRequest == null) || (this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest == null) || (this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest.requestKey() == null)) {}
    while (!this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest.requestKey().equals(paramUploadRequest.requestKey())) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void cancelAll()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void reportError(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, boolean paramBoolean1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean2, int paramInt2) {}
  
  public void run()
  {
    try
    {
      if (b() == true)
      {
        a(true, 0);
        return;
      }
      if ((!Thread.interrupted()) && (a())) {
        break label74;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        a();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      if (a() == 0) {
        a(1810014);
      }
      a(false, a());
      return;
    }
    a(false, a());
    return;
    label74:
    a(false, a());
  }
  
  public void setHttpProxy(String paramString1, int paramInt, String paramString2, String paramString3) {}
  
  public void setIpConfig(String paramString1, String paramString2) {}
  
  public void setNetType(int paramInt) {}
  
  public void setReporter(IReporter paramIReporter) {}
  
  public void speedDown() {}
  
  public void trialSpeedUp(int paramInt) {}
  
  public boolean upload(UploadRequest paramUploadRequest)
  {
    if (paramUploadRequest == null) {
      return false;
    }
    this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest = paramUploadRequest;
    this.jdField_a_of_type_JavaIoFile = new File(this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest.path());
    this.jdField_a_of_type_ComTencentWeiyunUploaderIUploader$IUploadListener = this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest.listener();
    new Thread(this).start();
    return true;
  }
  
  public void vipSpeedUp() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.weiyun.upload.WyUploadJob
 * JD-Core Version:    0.7.0.1
 */