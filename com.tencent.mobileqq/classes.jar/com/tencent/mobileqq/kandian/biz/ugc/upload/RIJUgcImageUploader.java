package com.tencent.mobileqq.kandian.biz.ugc.upload;

import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.biz.ugc.video.transfer.ImageUploadController;
import com.tencent.qphone.base.util.QLog;

public class RIJUgcImageUploader
  implements IImageUploader
{
  public static String a = "RIJUGC.RIJUgcImageUploader";
  private Context b;
  private QQAppInterface c;
  private IImageUploadListener d;
  private String e;
  private volatile boolean f = false;
  private volatile boolean g = false;
  private ImageUploadController h;
  
  public RIJUgcImageUploader(Context paramContext, QQAppInterface paramQQAppInterface, String paramString)
  {
    this.e = paramString;
    this.b = paramContext;
    this.c = paramQQAppInterface;
  }
  
  public void a()
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("upload, path=");
    localStringBuilder.append(this.e);
    QLog.i(str, 1, localStringBuilder.toString());
    this.g = true;
    ThreadManagerV2.getUIHandlerV2().post(new RIJUgcImageUploader.1(this));
  }
  
  public void a(IImageUploadListener paramIImageUploadListener)
  {
    this.d = paramIImageUploadListener;
  }
  
  public void b()
  {
    if (this.g)
    {
      this.f = true;
      Object localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cancel, path=");
      localStringBuilder.append(this.e);
      QLog.i((String)localObject, 1, localStringBuilder.toString());
      localObject = this.h;
      if (localObject != null)
      {
        ((ImageUploadController)localObject).a();
        this.h.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.upload.RIJUgcImageUploader
 * JD-Core Version:    0.7.0.1
 */