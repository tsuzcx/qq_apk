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
  private WeakReference<XMediaEditor> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public VideoInfo$CompressVideoSegment(XMediaEditor paramXMediaEditor)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramXMediaEditor);
  }
  
  protected void a(JobContext paramJobContext, ImageInfo paramImageInfo)
  {
    VideoInfo localVideoInfo = (VideoInfo)paramImageInfo;
    if (QLog.isColorLevel()) {
      QLog.d("CompressVideoSegment", 2, new Object[] { "CompressVideoSegment start. info status=", Integer.valueOf(localVideoInfo.jdField_f_of_type_Int) });
    }
    String str = ImageInfo.b();
    try
    {
      localXMediaEditor = (XMediaEditor)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localXMediaEditor == null) {
        break label367;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CompressVideoSegment", 2, new Object[] { "CompressVideoSegment sourceVideoPath=", localVideoInfo.jdField_f_of_type_JavaLangString });
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(localVideoInfo.jdField_f_of_type_JavaLangString.substring(localVideoInfo.jdField_f_of_type_JavaLangString.lastIndexOf("/") + 1, localVideoInfo.jdField_f_of_type_JavaLangString.lastIndexOf(".")));
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append(FileUtil.a(localVideoInfo.jdField_f_of_type_JavaLangString));
      str = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
      i = TroopHomeworkHelper.a(localXMediaEditor.getContext(), localVideoInfo.jdField_f_of_type_JavaLangString, str);
      if (QLog.isColorLevel()) {
        QLog.d("CompressVideoSegment", 2, new Object[] { "CompressVideo ret:", Integer.valueOf(i) });
      }
      if (i != 1) {
        break label433;
      }
      str = localVideoInfo.jdField_f_of_type_JavaLangString;
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
      if (FileUtil.a(str) > 104857600L)
      {
        notifyError(new Error("200"));
        return;
      }
      localVideoInfo.g = str;
      ThreadManager.getUIHandler().post(new VideoInfo.CompressVideoSegment.1(this, localVideoInfo, localXMediaEditor));
      if (!isCanceled())
      {
        if (QLog.isColorLevel()) {
          QLog.d("CompressVideoSegment", 2, new Object[] { "CompressVideoSegment notifyResult. mVideoCompressedPath=", localVideoInfo.g, ", info status=", Integer.valueOf(localVideoInfo.jdField_f_of_type_Int) });
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
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo.CompressVideoSegment
 * JD-Core Version:    0.7.0.1
 */