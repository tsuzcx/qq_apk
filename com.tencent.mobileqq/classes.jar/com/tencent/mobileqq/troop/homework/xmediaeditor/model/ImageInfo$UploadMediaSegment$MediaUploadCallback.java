package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.TroopHomeworkHelper.UploadCallback;
import mqq.os.MqqHandler;

class ImageInfo$UploadMediaSegment$MediaUploadCallback
  implements TroopHomeworkHelper.UploadCallback
{
  private int b;
  private float c = 1.0F;
  private long d;
  
  public ImageInfo$UploadMediaSegment$MediaUploadCallback(ImageInfo.UploadMediaSegment paramUploadMediaSegment)
  {
    int i = ImageInfo.UploadMediaSegment.a(paramUploadMediaSegment);
    if (i != 1)
    {
      if (i != 2)
      {
        this.b = 0;
        this.c = 1.0F;
        return;
      }
      this.b = 95;
      this.c = 0.05F;
      return;
    }
    this.b = 10;
    this.c = 0.85F;
  }
  
  public void a(int paramInt)
  {
    if (this.a.isCanceled())
    {
      if (QLog.isColorLevel()) {
        QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onProgress cancel. progress=", Integer.valueOf(paramInt) });
      }
      this.a.onCancel();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onProgress. mediaType=", Integer.valueOf(ImageInfo.UploadMediaSegment.a(this.a)), ", info hash=", Integer.valueOf(ImageInfo.UploadMediaSegment.b(this.a).hashCode()), ", info status=", Integer.valueOf(ImageInfo.UploadMediaSegment.b(this.a).o), ", progress=", Integer.valueOf(paramInt) });
    }
    long l = System.currentTimeMillis();
    paramInt = this.b + (int)(this.c * paramInt);
    if ((paramInt < 100) && (l - this.d > 500L))
    {
      this.d = l;
      ThreadManager.getUIHandler().post(new ImageInfo.UploadMediaSegment.MediaUploadCallback.2(this, paramInt));
    }
  }
  
  public void a(String paramString)
  {
    if (this.a.isCanceled())
    {
      this.a.onCancel();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UploadMediaSegment", 2, new Object[] { "MediaUploadCallback onComplete. mediaType=", Integer.valueOf(ImageInfo.UploadMediaSegment.a(this.a)), ", info hash=", Integer.valueOf(ImageInfo.UploadMediaSegment.b(this.a).hashCode()), ", info status=", Integer.valueOf(ImageInfo.UploadMediaSegment.b(this.a).o) });
    }
    int i = ImageInfo.UploadMediaSegment.a(this.a);
    if (i != 0) {
      if (i != 1)
      {
        if (i != 2) {
          break label166;
        }
      }
      else
      {
        VideoInfo localVideoInfo = (VideoInfo)ImageInfo.UploadMediaSegment.b(this.a);
        localVideoInfo.q = paramString;
        ThreadManager.getUIHandler().post(new ImageInfo.UploadMediaSegment.MediaUploadCallback.1(this, localVideoInfo));
        break label166;
      }
    }
    ImageInfo.UploadMediaSegment.b(this.a).b = paramString;
    label166:
    if (!this.a.isCanceled())
    {
      paramString = this.a;
      ImageInfo.UploadMediaSegment.a(paramString, ImageInfo.UploadMediaSegment.b(paramString));
      return;
    }
    this.a.onCancel();
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e(getClass().getSimpleName(), 2, new Object[] { "upload onError. errorCode=", Integer.valueOf(paramInt), ", info type=", Integer.valueOf(ImageInfo.UploadMediaSegment.b(this.a).b()), ", mediaType=", Integer.valueOf(ImageInfo.UploadMediaSegment.a(this.a)) });
    }
    if (ImageInfo.UploadMediaSegment.a(this.a) == 2)
    {
      ImageInfo.UploadMediaSegment localUploadMediaSegment = this.a;
      ImageInfo.UploadMediaSegment.b(localUploadMediaSegment, ImageInfo.UploadMediaSegment.b(localUploadMediaSegment));
      return;
    }
    ImageInfo.UploadMediaSegment.a(this.a, new Error("-3"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment.MediaUploadCallback
 * JD-Core Version:    0.7.0.1
 */