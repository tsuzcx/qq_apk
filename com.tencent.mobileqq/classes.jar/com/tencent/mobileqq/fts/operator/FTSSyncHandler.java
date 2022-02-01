package com.tencent.mobileqq.fts.operator;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.mobileqq.fts.api.impl.FTSDBRuntimeServiceImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.opt.threadpriority.ThreadRegulator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import mqq.app.AppRuntime;

public class FTSSyncHandler
  extends Handler
{
  public static long a = 0L;
  public static int b = -1000;
  private FTSDBRuntimeServiceImpl c;
  private long d = 0L;
  private long e = 0L;
  private long f = 0L;
  
  public FTSSyncHandler(Looper paramLooper, AppRuntime paramAppRuntime, FTSDBRuntimeServiceImpl paramFTSDBRuntimeServiceImpl)
  {
    super(paramLooper);
    this.c = paramFTSDBRuntimeServiceImpl;
    this.d = System.currentTimeMillis();
  }
  
  public void a()
  {
    removeCallbacksAndMessages(null);
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    ThreadRegulator.a().c();
    super.dispatchMessage(paramMessage);
  }
  
  public void handleMessage(Message paramMessage)
  {
    b = Process.myTid();
    a = SystemClock.currentThreadTimeMillis();
    com.tencent.qqperf.monitor.backgroundcpu.BackgroundCpuMonitor.b = b;
    com.tencent.qqperf.monitor.backgroundcpu.BackgroundCpuMonitor.a = a;
    long l2 = System.currentTimeMillis();
    long l3 = SystemClock.currentThreadTimeMillis();
    Object localObject = (FTSIndexOperator)paramMessage.obj;
    for (;;)
    {
      try
      {
        int i = paramMessage.what;
        if (i != 1)
        {
          boolean bool;
          if (i != 2)
          {
            if (i != 3)
            {
              if (i == 4)
              {
                removeMessages(4, localObject);
                ((FTSIndexOperator)localObject).p();
                paramMessage = obtainMessage(2, localObject);
                if (!((FTSIndexOperator)localObject).m()) {
                  break label1125;
                }
                l1 = 15000L;
                sendMessageDelayed(paramMessage, l1);
              }
            }
            else
            {
              removeMessages(3, localObject);
              ((FTSIndexOperator)localObject).k();
              bool = this.c.isDestroyed;
              if (bool)
              {
                this.f += SystemClock.currentThreadTimeMillis() - l3;
                this.e += System.currentTimeMillis() - l2;
                if (System.currentTimeMillis() - this.d > 300000L)
                {
                  paramMessage = new StringBuilder(100);
                  paramMessage.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis())));
                  paramMessage.append(" ");
                  paramMessage.append("cpu:");
                  paramMessage.append(this.f);
                  paramMessage.append(" - wall:");
                  paramMessage.append(this.e);
                  paramMessage.append(" ");
                  localObject = this.c.getOperator(1);
                  if (localObject != null) {
                    paramMessage.append(((FTSIndexOperator)localObject).l());
                  }
                  localObject = this.c.getOperator(2);
                  if (localObject != null)
                  {
                    paramMessage.append(((FTSIndexOperator)localObject).l());
                    paramMessage.append("\n");
                  }
                  QLog.d("Q.fts.BgCpu.Total", 1, paramMessage.toString());
                  this.f = 0L;
                  this.e = 0L;
                  this.d = System.currentTimeMillis();
                }
              }
            }
          }
          else
          {
            removeMessages(2, localObject);
            if (((FTSIndexOperator)localObject).i()) {
              ((FTSIndexOperator)localObject).k();
            }
            bool = this.c.isDestroyed;
            if (bool)
            {
              this.f += SystemClock.currentThreadTimeMillis() - l3;
              this.e += System.currentTimeMillis() - l2;
              if (System.currentTimeMillis() - this.d > 300000L)
              {
                paramMessage = new StringBuilder(100);
                paramMessage.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis())));
                paramMessage.append(" ");
                paramMessage.append("cpu:");
                paramMessage.append(this.f);
                paramMessage.append(" - wall:");
                paramMessage.append(this.e);
                paramMessage.append(" ");
                localObject = this.c.getOperator(1);
                if (localObject != null) {
                  paramMessage.append(((FTSIndexOperator)localObject).l());
                }
                localObject = this.c.getOperator(2);
                if (localObject != null)
                {
                  paramMessage.append(((FTSIndexOperator)localObject).l());
                  paramMessage.append("\n");
                }
                QLog.d("Q.fts.BgCpu.Total", 1, paramMessage.toString());
                this.f = 0L;
                this.e = 0L;
                this.d = System.currentTimeMillis();
              }
              return;
            }
            if (((FTSIndexOperator)localObject).o())
            {
              sendMessageDelayed(obtainMessage(4, localObject), 15000L);
            }
            else
            {
              l1 = 15000L;
              paramMessage = obtainMessage(2, localObject);
              if (!((FTSIndexOperator)localObject).m()) {
                break label1132;
              }
              sendMessageDelayed(paramMessage, l1);
            }
          }
        }
        else if (((FTSIndexOperator)localObject).g())
        {
          sendMessageDelayed(obtainMessage(2, localObject), 30000L);
        }
        else if (QLog.isColorLevel())
        {
          QLog.w("Q.fts.sync_worker", 2, "readSyncedCursor is false!!");
        }
        this.f += SystemClock.currentThreadTimeMillis() - l3;
        this.e += System.currentTimeMillis() - l2;
        if (System.currentTimeMillis() - this.d > 300000L)
        {
          paramMessage = new StringBuilder(100);
          paramMessage.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis())));
          paramMessage.append(" ");
          paramMessage.append("cpu:");
          paramMessage.append(this.f);
          paramMessage.append(" - wall:");
          paramMessage.append(this.e);
          paramMessage.append(" ");
          localObject = this.c.getOperator(1);
          if (localObject != null) {
            paramMessage.append(((FTSIndexOperator)localObject).l());
          }
          localObject = this.c.getOperator(2);
          if (localObject != null)
          {
            paramMessage.append(((FTSIndexOperator)localObject).l());
            paramMessage.append("\n");
          }
          QLog.d("Q.fts.BgCpu.Total", 1, paramMessage.toString());
          this.f = 0L;
          this.e = 0L;
          this.d = System.currentTimeMillis();
        }
        return;
      }
      finally
      {
        this.f += SystemClock.currentThreadTimeMillis() - l3;
        this.e += System.currentTimeMillis() - l2;
        if (System.currentTimeMillis() - this.d > 300000L)
        {
          localObject = new StringBuilder(100);
          ((StringBuilder)localObject).append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis())));
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append("cpu:");
          ((StringBuilder)localObject).append(this.f);
          ((StringBuilder)localObject).append(" - wall:");
          ((StringBuilder)localObject).append(this.e);
          ((StringBuilder)localObject).append(" ");
          FTSIndexOperator localFTSIndexOperator = this.c.getOperator(1);
          if (localFTSIndexOperator != null) {
            ((StringBuilder)localObject).append(localFTSIndexOperator.l());
          }
          localFTSIndexOperator = this.c.getOperator(2);
          if (localFTSIndexOperator != null)
          {
            ((StringBuilder)localObject).append(localFTSIndexOperator.l());
            ((StringBuilder)localObject).append("\n");
          }
          QLog.d("Q.fts.BgCpu.Total", 1, ((StringBuilder)localObject).toString());
          this.f = 0L;
          this.e = 0L;
          this.d = System.currentTimeMillis();
        }
      }
      label1125:
      long l1 = 30000L;
      continue;
      label1132:
      l1 = 30000L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fts.operator.FTSSyncHandler
 * JD-Core Version:    0.7.0.1
 */