package com.tencent.mobileqq.medalwall;

import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;

public class MedalWallMng$DownloadResTask
  implements Runnable
{
  final MedalWallMng.NeedGuideMedal a;
  
  public MedalWallMng$DownloadResTask(MedalWallMng paramMedalWallMng, MedalWallMng.NeedGuideMedal paramNeedGuideMedal)
  {
    this.a = paramNeedGuideMedal;
  }
  
  public void run()
  {
    long l3 = SystemClock.elapsedRealtime();
    boolean bool = TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString);
    long l2 = 0L;
    Object localObject;
    if (bool)
    {
      localObject = this.a;
      ((MedalWallMng.NeedGuideMedal)localObject).jdField_a_of_type_Int = 2;
      ((MedalWallMng.NeedGuideMedal)localObject).jdField_b_of_type_Int = 1000;
    }
    else
    {
      long l1 = l2;
      try
      {
        localObject = new File(this.a.jdField_b_of_type_JavaLangString);
        l1 = l2;
        this.a.jdField_b_of_type_Int = HttpDownloadUtil.downloadData(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_JavaLangString, (File)localObject, 2);
        l1 = l2;
        l2 = SystemClock.elapsedRealtime() - l3;
        l1 = l2;
        if (this.a.jdField_b_of_type_Int == 0)
        {
          l1 = l2;
          this.a.jdField_a_of_type_Int = 1;
        }
        else
        {
          l1 = l2;
          this.a.jdField_a_of_type_Int = 2;
        }
      }
      catch (Throwable localThrowable)
      {
        MedalWallMng.NeedGuideMedal localNeedGuideMedal = this.a;
        localNeedGuideMedal.jdField_a_of_type_Int = 2;
        localNeedGuideMedal.jdField_b_of_type_Int = 2000;
        localThrowable.printStackTrace();
        l2 = l1;
        if (QLog.isColorLevel())
        {
          QLog.i("MedalWallMng", 2, "DownloadResTask", localThrowable);
          l2 = l1;
        }
      }
    }
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.arg1 = ((int)l2);
    localMessage.obj = this.a;
    this.this$0.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.medalwall.MedalWallMng.DownloadResTask
 * JD-Core Version:    0.7.0.1
 */