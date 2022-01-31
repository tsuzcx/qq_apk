package com.tencent.mobileqq.troop.homework.xmediaeditor.model;

import ajkh;
import android.text.TextUtils;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import cooperation.troop_homework.TroopHomeworkHelper.UploadFileTask;
import java.lang.ref.WeakReference;

public class ImageInfo$UploadMediaSegment
  extends JobSegment
{
  private int jdField_a_of_type_Int;
  private ImageInfo jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo;
  private TroopHomeworkHelper.UploadFileTask jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadFileTask;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public ImageInfo$UploadMediaSegment(int paramInt, XMediaEditor paramXMediaEditor, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramXMediaEditor);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected void a(JobContext paramJobContext, ImageInfo paramImageInfo)
  {
    if (isCanceled()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("UploadMediaSegment", 2, new Object[] { "UploadMediaSegment start. mediaType=", Integer.valueOf(this.jdField_a_of_type_Int), ", info status=", Integer.valueOf(paramImageInfo.g) });
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorModelImageInfo = paramImageInfo;
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (paramJobContext = paramImageInfo.c;; paramJobContext = ((VideoInfo)paramImageInfo).g)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UploadMediaSegment", 2, new Object[] { "UploadMediaSegment start - getFilePath: ", paramJobContext });
      }
      if (TextUtils.isEmpty(paramJobContext)) {
        break;
      }
      this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadFileTask = paramImageInfo.a(paramJobContext, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadFileTask.a(new ajkh(this));
      this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadFileTask.b();
      return;
    }
    notifyError(new Error("-2"));
  }
  
  public void onCancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d(getClass().getSimpleName(), 2, new Object[] { "UploadMediaSegment onCancel. mediaType=", Integer.valueOf(this.jdField_a_of_type_Int) });
    }
    if (this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadFileTask != null) {
      this.jdField_a_of_type_CooperationTroop_homeworkTroopHomeworkHelper$UploadFileTask.c();
    }
    Error localError;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      localError = new Error("c_1001");
    }
    for (;;)
    {
      notifyError(localError);
      return;
      localError = new Error("c_2002");
      continue;
      localError = new Error("c_2003");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.model.ImageInfo.UploadMediaSegment
 * JD-Core Version:    0.7.0.1
 */