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
  public static int a = -1000;
  public static long a;
  private FTSDBRuntimeServiceImpl a;
  private long b = 0L;
  private long c = 0L;
  private long d = 0L;
  
  public FTSSyncHandler(Looper paramLooper, AppRuntime paramAppRuntime, FTSDBRuntimeServiceImpl paramFTSDBRuntimeServiceImpl)
  {
    super(paramLooper);
    this.jdField_a_of_type_ComTencentMobileqqFtsApiImplFTSDBRuntimeServiceImpl = paramFTSDBRuntimeServiceImpl;
    this.b = System.currentTimeMillis();
  }
  
  public void a()
  {
    removeCallbacksAndMessages(null);
  }
  
  public void dispatchMessage(Message paramMessage)
  {
    ThreadRegulator.a().b();
    super.dispatchMessage(paramMessage);
  }
  
  public void handleMessage(Message paramMessage)
  {
    jdField_a_of_type_Int = Process.myTid();
    jdField_a_of_type_Long = SystemClock.currentThreadTimeMillis();
    com.tencent.qqperf.monitor.backgroundcpu.BackgroundCpuMonitor.jdField_a_of_type_Int = jdField_a_of_type_Int;
    com.tencent.qqperf.monitor.backgroundcpu.BackgroundCpuMonitor.jdField_a_of_type_Long = jdField_a_of_type_Long;
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
                ((FTSIndexOperator)localObject).g();
                paramMessage = obtainMessage(2, localObject);
                if (!((FTSIndexOperator)localObject).f()) {
                  break label1125;
                }
                l1 = 15000L;
                sendMessageDelayed(paramMessage, l1);
              }
            }
            else
            {
              removeMessages(3, localObject);
              ((FTSIndexOperator)localObject).f();
              bool = this.jdField_a_of_type_ComTencentMobileqqFtsApiImplFTSDBRuntimeServiceImpl.isDestroyed;
              if (bool)
              {
                this.d += SystemClock.currentThreadTimeMillis() - l3;
                this.c += System.currentTimeMillis() - l2;
                if (System.currentTimeMillis() - this.b > 300000L)
                {
                  paramMessage = new StringBuilder(100);
                  paramMessage.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis())));
                  paramMessage.append(" ");
                  paramMessage.append("cpu:");
                  paramMessage.append(this.d);
                  paramMessage.append(" - wall:");
                  paramMessage.append(this.c);
                  paramMessage.append(" ");
                  localObject = this.jdField_a_of_type_ComTencentMobileqqFtsApiImplFTSDBRuntimeServiceImpl.getOperator(1);
                  if (localObject != null) {
                    paramMessage.append(((FTSIndexOperator)localObject).a());
                  }
                  localObject = this.jdField_a_of_type_ComTencentMobileqqFtsApiImplFTSDBRuntimeServiceImpl.getOperator(2);
                  if (localObject != null)
                  {
                    paramMessage.append(((FTSIndexOperator)localObject).a());
                    paramMessage.append("\n");
                  }
                  QLog.d("Q.fts.BgCpu.Total", 1, paramMessage.toString());
                  this.d = 0L;
                  this.c = 0L;
                  this.b = System.currentTimeMillis();
                }
              }
            }
          }
          else
          {
            removeMessages(2, localObject);
            if (((FTSIndexOperator)localObject).d()) {
              ((FTSIndexOperator)localObject).f();
            }
            bool = this.jdField_a_of_type_ComTencentMobileqqFtsApiImplFTSDBRuntimeServiceImpl.isDestroyed;
            if (bool)
            {
              this.d += SystemClock.currentThreadTimeMillis() - l3;
              this.c += System.currentTimeMillis() - l2;
              if (System.currentTimeMillis() - this.b > 300000L)
              {
                paramMessage = new StringBuilder(100);
                paramMessage.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis())));
                paramMessage.append(" ");
                paramMessage.append("cpu:");
                paramMessage.append(this.d);
                paramMessage.append(" - wall:");
                paramMessage.append(this.c);
                paramMessage.append(" ");
                localObject = this.jdField_a_of_type_ComTencentMobileqqFtsApiImplFTSDBRuntimeServiceImpl.getOperator(1);
                if (localObject != null) {
                  paramMessage.append(((FTSIndexOperator)localObject).a());
                }
                localObject = this.jdField_a_of_type_ComTencentMobileqqFtsApiImplFTSDBRuntimeServiceImpl.getOperator(2);
                if (localObject != null)
                {
                  paramMessage.append(((FTSIndexOperator)localObject).a());
                  paramMessage.append("\n");
                }
                QLog.d("Q.fts.BgCpu.Total", 1, paramMessage.toString());
                this.d = 0L;
                this.c = 0L;
                this.b = System.currentTimeMillis();
              }
              return;
            }
            if (((FTSIndexOperator)localObject).g())
            {
              sendMessageDelayed(obtainMessage(4, localObject), 15000L);
            }
            else
            {
              l1 = 15000L;
              paramMessage = obtainMessage(2, localObject);
              if (!((FTSIndexOperator)localObject).f()) {
                break label1132;
              }
              sendMessageDelayed(paramMessage, l1);
            }
          }
        }
        else if (((FTSIndexOperator)localObject).c())
        {
          sendMessageDelayed(obtainMessage(2, localObject), 30000L);
        }
        else if (QLog.isColorLevel())
        {
          QLog.w("Q.fts.sync_worker", 2, "readSyncedCursor is false!!");
        }
        this.d += SystemClock.currentThreadTimeMillis() - l3;
        this.c += System.currentTimeMillis() - l2;
        if (System.currentTimeMillis() - this.b > 300000L)
        {
          paramMessage = new StringBuilder(100);
          paramMessage.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis())));
          paramMessage.append(" ");
          paramMessage.append("cpu:");
          paramMessage.append(this.d);
          paramMessage.append(" - wall:");
          paramMessage.append(this.c);
          paramMessage.append(" ");
          localObject = this.jdField_a_of_type_ComTencentMobileqqFtsApiImplFTSDBRuntimeServiceImpl.getOperator(1);
          if (localObject != null) {
            paramMessage.append(((FTSIndexOperator)localObject).a());
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqFtsApiImplFTSDBRuntimeServiceImpl.getOperator(2);
          if (localObject != null)
          {
            paramMessage.append(((FTSIndexOperator)localObject).a());
            paramMessage.append("\n");
          }
          QLog.d("Q.fts.BgCpu.Total", 1, paramMessage.toString());
          this.d = 0L;
          this.c = 0L;
          this.b = System.currentTimeMillis();
        }
        return;
      }
      finally
      {
        this.d += SystemClock.currentThreadTimeMillis() - l3;
        this.c += System.currentTimeMillis() - l2;
        if (System.currentTimeMillis() - this.b > 300000L)
        {
          localObject = new StringBuilder(100);
          ((StringBuilder)localObject).append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(System.currentTimeMillis())));
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append("cpu:");
          ((StringBuilder)localObject).append(this.d);
          ((StringBuilder)localObject).append(" - wall:");
          ((StringBuilder)localObject).append(this.c);
          ((StringBuilder)localObject).append(" ");
          FTSIndexOperator localFTSIndexOperator = this.jdField_a_of_type_ComTencentMobileqqFtsApiImplFTSDBRuntimeServiceImpl.getOperator(1);
          if (localFTSIndexOperator != null) {
            ((StringBuilder)localObject).append(localFTSIndexOperator.a());
          }
          localFTSIndexOperator = this.jdField_a_of_type_ComTencentMobileqqFtsApiImplFTSDBRuntimeServiceImpl.getOperator(2);
          if (localFTSIndexOperator != null)
          {
            ((StringBuilder)localObject).append(localFTSIndexOperator.a());
            ((StringBuilder)localObject).append("\n");
          }
          QLog.d("Q.fts.BgCpu.Total", 1, ((StringBuilder)localObject).toString());
          this.d = 0L;
          this.c = 0L;
          this.b = System.currentTimeMillis();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.operator.FTSSyncHandler
 * JD-Core Version:    0.7.0.1
 */