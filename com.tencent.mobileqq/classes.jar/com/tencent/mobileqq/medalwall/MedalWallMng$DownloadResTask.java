package com.tencent.mobileqq.medalwall;

import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import aubj;
import bhtd;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class MedalWallMng$DownloadResTask
  implements Runnable
{
  final aubj a;
  
  public MedalWallMng$DownloadResTask(MedalWallMng paramMedalWallMng, aubj paramaubj)
  {
    this.a = paramaubj;
  }
  
  public void run()
  {
    long l3 = SystemClock.elapsedRealtime();
    long l2 = 0L;
    if (TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString))
    {
      this.a.jdField_a_of_type_Int = 2;
      this.a.jdField_b_of_type_Int = 1000;
    }
    for (;;)
    {
      Object localObject = Message.obtain();
      ((Message)localObject).what = 2;
      ((Message)localObject).arg1 = ((int)l2);
      ((Message)localObject).obj = this.a;
      this.this$0.jdField_a_of_type_Bhtd.sendMessage((Message)localObject);
      return;
      long l1 = l2;
      try
      {
        localObject = new File(this.a.jdField_b_of_type_JavaLangString);
        l1 = l2;
        this.a.jdField_b_of_type_Int = HttpDownloadUtil.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_JavaLangString, (File)localObject, 2);
        l1 = l2;
        l2 = SystemClock.elapsedRealtime() - l3;
        l1 = l2;
        if (this.a.jdField_b_of_type_Int != 0) {
          break label208;
        }
        l1 = l2;
        this.a.jdField_a_of_type_Int = 1;
      }
      catch (Throwable localThrowable)
      {
        this.a.jdField_a_of_type_Int = 2;
        this.a.jdField_b_of_type_Int = 2000;
        localThrowable.printStackTrace();
        l2 = l1;
      }
      if (QLog.isColorLevel())
      {
        QLog.i("MedalWallMng", 2, "DownloadResTask", localThrowable);
        l2 = l1;
        continue;
        label208:
        l1 = l2;
        this.a.jdField_a_of_type_Int = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.medalwall.MedalWallMng.DownloadResTask
 * JD-Core Version:    0.7.0.1
 */