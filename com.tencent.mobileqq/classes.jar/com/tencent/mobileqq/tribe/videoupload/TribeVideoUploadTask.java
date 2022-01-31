package com.tencent.mobileqq.tribe.videoupload;

import aitd;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.videoupload.task.BasePublishTask;
import com.tencent.biz.qqstory.base.videoupload.task.BaseTaskInfo;
import com.tencent.biz.qqstory.base.videoupload.task.OnPublishTaskListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

public class TribeVideoUploadTask
  extends BasePublishTask
  implements OnPublishTaskListener
{
  protected Handler a;
  protected WeakReference a;
  
  public TribeVideoUploadTask(BaseActivity paramBaseActivity, Handler paramHandler, TribeVideoTaskInfo paramTribeVideoTaskInfo)
  {
    super(paramTribeVideoTaskInfo);
    paramTribeVideoTaskInfo.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    TribeVideoFileObject localTribeVideoFileObject = new TribeVideoFileObject(paramTribeVideoTaskInfo.jdField_a_of_type_JavaLangString);
    localTribeVideoFileObject.a(new aitd(this, paramTribeVideoTaskInfo));
    paramTribeVideoTaskInfo.jdField_a_of_type_JavaUtilList.add(localTribeVideoFileObject);
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
    a(this);
  }
  
  private void a(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    for (Object localObject = null; (localObject == null) || (((BaseActivity)localObject).isFinishing()); localObject = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("tribe_publish_VideoUploadTask", 2, "TribeVideoUploadTask finish but activity is null!");
      }
      return;
    }
    localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(paramInt);
    if (paramObject != null) {
      ((Message)localObject).obj = paramObject;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
  }
  
  public void a(BasePublishTask paramBasePublishTask, ErrorMessage paramErrorMessage)
  {
    QLog.i("tribe_publish_tribe_publish_VideoUploadTask", 1, "upload finish status:" + paramBasePublishTask.a().a);
    paramBasePublishTask = (TribeVideoTaskInfo)paramBasePublishTask.a();
    if (paramBasePublishTask.b())
    {
      QLog.i("tribe_publish_tribe_publish_VideoUploadTask", 1, "uploadVideo succ " + paramBasePublishTask.c);
      a(1011, paramBasePublishTask);
    }
    while (!paramBasePublishTask.a()) {
      return;
    }
    QLog.i("tribe_publish_tribe_publish_VideoUploadTask", 1, "uploadVideo failed:" + paramBasePublishTask.toString() + " error:" + paramErrorMessage);
    a(1010, paramBasePublishTask);
  }
  
  protected void c()
  {
    a(5, new ErrorMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.videoupload.TribeVideoUploadTask
 * JD-Core Version:    0.7.0.1
 */