package com.tencent.mobileqq.transfile.predownload;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class RunnableTask
  extends AbsPreDownloadTask
  implements Handler.Callback
{
  private long jdField_a_of_type_Long;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private Handler b;
  
  public RunnableTask(QQAppInterface paramQQAppInterface, String paramString, Runnable paramRunnable, long paramLong)
  {
    super(paramQQAppInterface, paramString);
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
    this.jdField_a_of_type_Long = paramLong;
    this.b = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  protected void a()
  {
    this.b.post(this.jdField_a_of_type_JavaLangRunnable);
    this.b.sendEmptyMessageDelayed(0, this.jdField_a_of_type_Long);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      this.jdField_a_of_type_ComTencentMobileqqTransfilePredownloadPreDownloadController.a(this);
    }
    return true;
  }
  
  public String toString()
  {
    return super.toString() + "[" + this.jdField_a_of_type_JavaLangRunnable + ", " + this.jdField_a_of_type_Long + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.predownload.RunnableTask
 * JD-Core Version:    0.7.0.1
 */