package com.tencent.mobileqq.startup.step;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import aznp;
import azpf;
import biby;
import com.tencent.qphone.base.util.QLog;

public class Step
  implements Runnable
{
  public static final int STEP_BROADCAST_REPORT_REGISTER = 44;
  public static final int STEP_DO_LOAD_DEX = 4;
  public static final int STEP_GDT_INITIALIZE_ON_TOOL_PROCESS = 48;
  public static final int STEP_GROUP = 0;
  public static final int STEP_HACK_ALL_VM = 43;
  public static final int STEP_HACK_AVM = 42;
  public static final int STEP_HACK_DVM = 41;
  public static final int STEP_HUAYANG_PLUGIN_CONTAINER = 37;
  public static final int STEP_INIT_HOOK = 29;
  public static final int STEP_INIT_MAGNIFIERSDK = 15;
  public static final int STEP_INIT_SKIN = 10;
  public static final int STEP_INJECT_BITMAP_PATCH = 32;
  public static final int STEP_INSTALL_OPTIMZIED_PLUGINS = 36;
  public static final int STEP_LOAD_DATA = 6;
  public static final int STEP_LOAD_OTHER = 17;
  public static final int STEP_LOAD_UI = 16;
  public static final int STEP_MANAGE_THREAD = 14;
  public static final int STEP_MEMORY_CACHE = 7;
  public static final int STEP_MIGRATE_SUBSCRIBE_DB = 33;
  public static final int STEP_MONITOR_QZONE_STARTUP = 39;
  public static final int STEP_MORE_DATA = 18;
  public static final int STEP_NEW_RUNTIME = 5;
  public static final int STEP_NOW_LIVE_CONTAINER = 46;
  public static final int STEP_OLD_ONCREATE = 8;
  public static final int STEP_OPEN_THRED_CREATE_HOOK = 40;
  public static final int STEP_PRE_INIT_VALUES = 31;
  public static final int STEP_QQLIVE_AND_STUDY_ROOM_PLUGIN = 47;
  public static final int STEP_QZONE_HOOK_THREAD = 38;
  public static final int STEP_QZONE_PERFORMANCE_TRACER = 19;
  public static final int STEP_RDM = 13;
  public static final int STEP_RECORD_REPORT_REGISTER = 45;
  public static final int STEP_SET_PERMISSION = 3;
  public static final int STEP_SET_PLUGIN = 26;
  public static final int STEP_SET_SPLASH = 2;
  public static final int STEP_START_SERVICE = 9;
  public static final int STEP_START_SERVICE_LITE = 20;
  public static final int STEP_START_SERVICE_LITE_CMP = 21;
  public static final int STEP_TRY_LOAD_DEX = 1;
  public static final int STEP_UPDATE = 12;
  public static final int STEP_UPDATE_ARKSO = 24;
  public static final int STEP_UPDATE_AVSO = 23;
  public static final int STEP_UPDATE_BUBBLE = 22;
  public static final int STEP_UPDATE_PATCH_CONFIG = 34;
  public static final int STEP_UPDATE_PLUGIN_VERSION = 27;
  public static final int STEP_UPDATE_RMSO = 25;
  public static final int STEP_UPDATE_SECURE_FILE_STRATEGY = 35;
  public static final int STEP_UPGRAD_DB = 30;
  public static final int STEP_URL_DRAWABLE = 11;
  public static final int STEP_WEBP = 28;
  public aznp mDirector;
  private Handler mHandler;
  public int mId;
  protected String mName;
  private int mResultMessage;
  private int[] mStepIds;
  
  protected boolean doStep()
  {
    if (this.mId == 0)
    {
      int[] arrayOfInt = this.mStepIds;
      int j = arrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        if (!azpf.b(arrayOfInt[i], this.mDirector, null).step()) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  public void run()
  {
    step();
  }
  
  public void setResultListener(Handler paramHandler, int paramInt)
  {
    this.mHandler = paramHandler;
    this.mResultMessage = paramInt;
  }
  
  public boolean step()
  {
    long l = 0L;
    int i = 5;
    Thread localThread = null;
    if (this.mHandler != null)
    {
      localThread = Thread.currentThread();
      i = localThread.getPriority();
      localThread.setPriority(10);
    }
    if (aznp.a)
    {
      l = SystemClock.uptimeMillis();
      if (Looper.myLooper() != Looper.getMainLooper()) {
        break label170;
      }
      biby.a(this.mName);
    }
    for (;;)
    {
      boolean bool1 = false;
      try
      {
        boolean bool2 = doStep();
        bool1 = bool2;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("AutoMonitor", 1, "", localThrowable);
          continue;
          biby.b(4096L, this.mName, Process.myTid());
        }
      }
      if (aznp.a)
      {
        if (Looper.myLooper() != Looper.getMainLooper()) {
          break;
        }
        biby.a();
        Log.i("AutoMonitor", this.mName + ", cost=" + (SystemClock.uptimeMillis() - l) + " results: " + bool1);
      }
      if (this.mHandler != null)
      {
        this.mHandler.obtainMessage(this.mResultMessage, Boolean.valueOf(bool1)).sendToTarget();
        localThread.setPriority(i);
      }
      return bool1;
      label170:
      biby.a(4096L, this.mName, Process.myTid());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.Step
 * JD-Core Version:    0.7.0.1
 */