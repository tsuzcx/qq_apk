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
    boolean bool = TextUtils.isEmpty(this.a.b);
    long l2 = 0L;
    Object localObject;
    if (bool)
    {
      localObject = this.a;
      ((MedalWallMng.NeedGuideMedal)localObject).f = 2;
      ((MedalWallMng.NeedGuideMedal)localObject).g = 1000;
    }
    else
    {
      long l1 = l2;
      try
      {
        localObject = new File(this.a.c);
        l1 = l2;
        this.a.g = HttpDownloadUtil.downloadData(this.this$0.n, this.a.b, (File)localObject, 2);
        l1 = l2;
        l2 = SystemClock.elapsedRealtime() - l3;
        l1 = l2;
        if (this.a.g == 0)
        {
          l1 = l2;
          this.a.f = 1;
        }
        else
        {
          l1 = l2;
          this.a.f = 2;
        }
      }
      catch (Throwable localThrowable)
      {
        MedalWallMng.NeedGuideMedal localNeedGuideMedal = this.a;
        localNeedGuideMedal.f = 2;
        localNeedGuideMedal.g = 2000;
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
    this.this$0.p.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.medalwall.MedalWallMng.DownloadResTask
 * JD-Core Version:    0.7.0.1
 */