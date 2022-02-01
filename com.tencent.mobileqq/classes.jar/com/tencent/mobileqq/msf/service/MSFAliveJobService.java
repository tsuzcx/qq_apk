package com.tencent.mobileqq.msf.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.mobileqq.msf.core.x;
import com.tencent.qphone.base.util.QLog;

public class MSFAliveJobService
  extends JobService
{
  private static final int MESSAGE_ID_TASK = 1;
  public static final String TAG = "MSFAliveJobService";
  public final Handler mHandler = new Handler(x.c().getLooper(), new j(this));
  
  public void onCreate()
  {
    super.onCreate();
    QLog.d("MSFAliveJobService", 1, "MSF_Alive_Log MSFAliveJobService onCreate ");
  }
  
  public boolean onStartJob(JobParameters paramJobParameters)
  {
    QLog.d("MSFAliveJobService", 1, "MSF_Alive_Log MSFAliveJobService onStartJob ");
    paramJobParameters = Message.obtain(this.mHandler, 1, paramJobParameters);
    this.mHandler.sendMessage(paramJobParameters);
    return true;
  }
  
  public boolean onStopJob(JobParameters paramJobParameters)
  {
    QLog.d("MSFAliveJobService", 1, "MSF_Alive_Log MSFAliveJobService onStopJob ");
    return false;
  }
  
  public void onTaskRemoved(Intent paramIntent)
  {
    QLog.d("MSFAliveJobService", 1, "MSF_Alive_Log MSFAliveJobService onTaskRemoved");
    super.onTaskRemoved(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.MSFAliveJobService
 * JD-Core Version:    0.7.0.1
 */