package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import cooperation.troop_homework.TroopHomeworkHelper;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class VideoInfo$CompressVideoSegment
  extends JobSegment<ImageInfo, ImageInfo>
{
  private WeakReference<XMediaEditor> a;
  private boolean b;
  
  public VideoInfo$CompressVideoSegment(XMediaEditor paramXMediaEditor)
  {
    this.a = new WeakReference(paramXMediaEditor);
  }
  
  protected void a(JobContext paramJobContext, ImageInfo paramImageInfo)
  {
    VideoInfo localVideoInfo = (VideoInfo)paramImageInfo;
    if (QLog.isColorLevel()) {
      QLog.d("CompressVideoSegment", 2, new Object[] { "CompressVideoSegment start. info status=", Integer.valueOf(localVideoInfo.o) });
    }
    String str = ImageInfo.h();
    try
    {
      localXMediaEditor = (XMediaEditor)this.a.get();
      if (localXMediaEditor == null) {
        break label367;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CompressVideoSegment", 2, new Object[] { "CompressVideoSegment sourceVideoPath=", localVideoInfo.r });
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(localVideoInfo.r.substring(localVideoInfo.r.lastIndexOf("/") + 1, localVideoInfo.r.lastIndexOf(".")));
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append(FileUtil.a(localVideoInfo.r));
      str = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
      i = TroopHomeworkHelper.a(localXMediaEditor.getContext(), localVideoInfo.r, str);
      if (QLog.isColorLevel()) {
        QLog.d("CompressVideoSegment", 2, new Object[] { "CompressVideo ret:", Integer.valueOf(i) });
      }
      if (i != 1) {
        break label433;
      }
      str = localVideoInfo.r;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        XMediaEditor localXMediaEditor;
        int i;
        label367:
        continue;
        if (i != 0) {
          if (i != 1) {}
        }
      }
    }
    if (FileUtils.fileExistsAndNotEmpty(str))
    {
      if (FileUtil.f(str) > 104857600L)
      {
        notifyError(new Error("200"));
        return;
      }
      localVideoInfo.s = str;
      ThreadManager.getUIHandler().post(new VideoInfo.CompressVideoSegment.1(this, localVideoInfo, localXMediaEditor));
      if (!isCanceled())
      {
        if (QLog.isColorLevel()) {
          QLog.d("CompressVideoSegment", 2, new Object[] { "CompressVideoSegment notifyResult. mVideoCompressedPath=", localVideoInfo.s, ", info status=", Integer.valueOf(localVideoInfo.o) });
        }
        notifyResult(localVideoInfo);
      }
    }
    else
    {
      notifyError(new Error("-200"));
      return;
      notifyError(new Error("0"));
      return;
      QLog.e("CompressVideoSegment", 1, "CompressVideoSegment error. OutOfMemoryError");
      URLDrawable.clearMemoryCache();
      System.gc();
      if (!this.b)
      {
        this.b = true;
        a(paramJobContext, paramImageInfo);
        return;
      }
      notifyError(new Error("-1"));
    }
  }
  
  protected void onCancel()
  {
    notifyError(new Error("c_2001"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo.CompressVideoSegment
 * JD-Core Version:    0.7.0.1
 */