package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import android.text.TextUtils;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import cooperation.troop_homework.TroopHomeworkHelper.UploadFileTask;
import java.lang.ref.WeakReference;

public class ImageInfo$UploadMediaSegment
  extends JobSegment<ImageInfo, ImageInfo>
{
  private WeakReference<XMediaEditor> a;
  private int b;
  private String c;
  private TroopHomeworkHelper.UploadFileTask d;
  private ImageInfo e;
  
  public ImageInfo$UploadMediaSegment(int paramInt, XMediaEditor paramXMediaEditor, String paramString)
  {
    this.b = paramInt;
    this.a = new WeakReference(paramXMediaEditor);
    this.c = paramString;
  }
  
  protected void a(JobContext paramJobContext, ImageInfo paramImageInfo)
  {
    if (isCanceled()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UploadMediaSegment", 2, new Object[] { "UploadMediaSegment start. mediaType=", Integer.valueOf(this.b), ", info status=", Integer.valueOf(paramImageInfo.o) });
    }
    this.e = paramImageInfo;
    if (this.b != 1) {
      paramJobContext = paramImageInfo.c;
    } else {
      paramJobContext = ((VideoInfo)paramImageInfo).s;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UploadMediaSegment", 2, new Object[] { "UploadMediaSegment start - getFilePath: ", paramJobContext });
    }
    if (!TextUtils.isEmpty(paramJobContext))
    {
      this.d = paramImageInfo.a(paramJobContext, this.c);
      this.d.a(new ImageInfo.UploadMediaSegment.MediaUploadCallback(this));
      this.d.b();
      return;
    }
    notifyError(new Error("-2"));
  }
  
  protected void onCancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d(getClass().getSimpleName(), 2, new Object[] { "UploadMediaSegment onCancel. mediaType=", Integer.valueOf(this.b) });
    }
    Object localObject = this.d;
    if (localObject != null) {
      ((TroopHomeworkHelper.UploadFileTask)localObject).c();
    }
    int i = this.b;
    if (i != 1)
    {
      if (i != 2) {
        localObject = new Error("c_1001");
      } else {
        localObject = new Error("c_2003");
      }
    }
    else {
      localObject = new Error("c_2002");
    }
    notifyError((Error)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment
 * JD-Core Version:    0.7.0.1
 */