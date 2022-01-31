package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import ajkk;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import cooperation.troop_homework.TroopHomeworkHelper;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class VideoInfo$CompressVideoSegment
  extends JobSegment
{
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public VideoInfo$CompressVideoSegment(XMediaEditor paramXMediaEditor)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramXMediaEditor);
  }
  
  protected void a(JobContext paramJobContext, ImageInfo paramImageInfo)
  {
    VideoInfo localVideoInfo = (VideoInfo)paramImageInfo;
    if (QLog.isColorLevel()) {
      QLog.d("CompressVideoSegment", 2, new Object[] { "CompressVideoSegment start. info status=", Integer.valueOf(localVideoInfo.jdField_g_of_type_Int) });
    }
    String str = ImageInfo.b();
    XMediaEditor localXMediaEditor;
    int i;
    for (;;)
    {
      try
      {
        localXMediaEditor = (XMediaEditor)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localXMediaEditor == null) {
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("CompressVideoSegment", 2, new Object[] { "CompressVideoSegment sourceVideoPath=", localVideoInfo.f });
        }
        str = str + localVideoInfo.f.substring(localVideoInfo.f.lastIndexOf("/") + 1, localVideoInfo.f.lastIndexOf(".")) + System.currentTimeMillis() + FileUtil.a(localVideoInfo.f);
        i = TroopHomeworkHelper.a(localXMediaEditor.getContext(), localVideoInfo.f, str);
        if (QLog.isColorLevel()) {
          QLog.d("CompressVideoSegment", 2, new Object[] { "CompressVideo ret:", Integer.valueOf(i) });
        }
        if (i != 1) {
          break label411;
        }
        str = localVideoInfo.f;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        label214:
        QLog.e("CompressVideoSegment", 1, "CompressVideoSegment error. OutOfMemoryError");
        URLDrawable.clearMemoryCache();
        System.gc();
        if (this.jdField_a_of_type_Boolean) {
          continue;
        }
        this.jdField_a_of_type_Boolean = true;
        a(paramJobContext, paramImageInfo);
        return;
        notifyError(new Error("-200"));
        return;
        notifyError(new Error("0"));
        return;
        notifyError(new Error("-1"));
        return;
      }
      if (FileUtil.b(str))
      {
        if (FileUtil.a(str) > 52428800L)
        {
          notifyError(new Error("200"));
          return;
        }
        localVideoInfo.jdField_g_of_type_JavaLangString = str;
        ThreadManager.getUIHandler().post(new ajkk(this, localVideoInfo, localXMediaEditor));
        if (isCanceled()) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("CompressVideoSegment", 2, new Object[] { "CompressVideoSegment notifyResult. mVideoCompressedPath=", localVideoInfo.jdField_g_of_type_JavaLangString, ", info status=", Integer.valueOf(localVideoInfo.jdField_g_of_type_Int) });
        }
        notifyResult(localVideoInfo);
        return;
      }
      label411:
      if (i != 0) {
        if (i != 1) {
          break label214;
        }
      }
    }
  }
  
  protected void onCancel()
  {
    notifyError(new Error("c_2001"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo.CompressVideoSegment
 * JD-Core Version:    0.7.0.1
 */