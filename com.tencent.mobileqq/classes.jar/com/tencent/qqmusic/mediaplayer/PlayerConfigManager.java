package com.tencent.qqmusic.mediaplayer;

import android.os.Process;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.lang.ref.WeakReference;

public class PlayerConfigManager
{
  private static final int ADD = 1;
  private static final int DTS_COST_THRESHOLD = 40;
  private static boolean ENABLE_CHANGE_THREAD_PRIORITY = false;
  private static final boolean ENABLE_REAL_CHECK = true;
  private static final int MAX_RATIO = 4;
  private static final int MAX_TIMES = 10;
  private static final int MIN_RATIO = 8;
  private static final int NONE = 0;
  private static final int SUB = -1;
  private static final String TAG = "PlayerConfigManager";
  private static PlayerConfigManager mInstance;
  private int[] THREAD_PRIORITY = { 19, 10, -2, -4, -8, -16, -19 };
  private int count = 0;
  private int mAddPriority = 0;
  private int mBufRatio = 4;
  private WeakReference<CorePlayer> mCommonPlayerRef = null;
  private int mCurrPriorityIndex = 0;
  private long mLastDecodeSpeed;
  private long mPlaySpeed = 1L;
  private int mProcessorNumber = Runtime.getRuntime().availableProcessors();
  private long mStartTime = 0L;
  
  private boolean add()
  {
    return this.mAddPriority >= 1;
  }
  
  public static PlayerConfigManager getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new PlayerConfigManager();
      }
      PlayerConfigManager localPlayerConfigManager = mInstance;
      return localPlayerConfigManager;
    }
    finally {}
  }
  
  private boolean sub()
  {
    return this.mAddPriority < -1;
  }
  
  public void calDTSCostEnd()
  {
    if (this.mBufRatio == 8) {
      return;
    }
    if (System.currentTimeMillis() - this.mStartTime > 40L)
    {
      this.count += 1;
      if (this.count > 10)
      {
        this.mBufRatio *= 2;
        this.count = 0;
      }
    }
  }
  
  public void calDTSCostStart()
  {
    if (this.mBufRatio == 8) {
      return;
    }
    this.mStartTime = System.currentTimeMillis();
  }
  
  public void changeDecodeThreadPriority()
  {
    Object localObject = this.mCommonPlayerRef;
    if (localObject != null)
    {
      localObject = (CorePlayer)((WeakReference)localObject).get();
      if (localObject != null) {
        ((CorePlayer)localObject).changePlayThreadPriorityImmediately();
      }
    }
  }
  
  public void changeDecodeThreadPriorityIfNeed()
  {
    for (;;)
    {
      int j;
      int i;
      try
      {
        j = this.mCurrPriorityIndex;
        i = this.THREAD_PRIORITY[(this.THREAD_PRIORITY.length - 1)];
        if ((isSingleCpuOrScreenOff()) && (ENABLE_CHANGE_THREAD_PRIORITY))
        {
          if (add())
          {
            i = j + 1;
          }
          else
          {
            i = j;
            if (sub()) {
              i = j - 1;
            }
          }
          if ((i != this.mCurrPriorityIndex) || (i < 0) || (i >= this.THREAD_PRIORITY.length)) {
            break label183;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("changeDecodeThreadPriorityIfNeed don't change Priority mCurrPriorityIndex = ");
          localStringBuilder.append(this.THREAD_PRIORITY[this.mCurrPriorityIndex]);
          Logger.i("PlayerConfigManager", localStringBuilder.toString());
          return;
          j = i;
          if (i >= this.THREAD_PRIORITY.length) {
            j = this.THREAD_PRIORITY.length - 1;
          }
          this.mCurrPriorityIndex = j;
          i = this.THREAD_PRIORITY[j];
          this.mAddPriority = 0;
        }
        else
        {
          i = this.THREAD_PRIORITY[(this.THREAD_PRIORITY.length - 1)];
        }
        Process.setThreadPriority(0);
        return;
      }
      catch (Throwable localThrowable)
      {
        Logger.e("PlayerConfigManager", localThrowable);
        return;
      }
      label183:
      if (i < 0) {
        j = 0;
      }
    }
  }
  
  public int getBufRatio()
  {
    int i = this.mBufRatio;
    if (i <= 1) {
      this.mBufRatio = 4;
    } else if (i > 8) {
      this.mBufRatio = 8;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getBufRatio = ");
    localStringBuilder.append(this.mBufRatio);
    Logger.i("PlayerConfigManager", localStringBuilder.toString());
    this.count = 0;
    return this.mBufRatio;
  }
  
  public boolean isSingleCpuOrScreenOff()
  {
    this.mProcessorNumber = Runtime.getRuntime().availableProcessors();
    return this.mProcessorNumber <= 1;
  }
  
  public void setCommonPlayerRef(CorePlayer paramCorePlayer)
  {
    if (paramCorePlayer != null)
    {
      this.mCommonPlayerRef = new WeakReference(paramCorePlayer);
      this.mCurrPriorityIndex = 0;
      this.mAddPriority = 0;
      paramCorePlayer = paramCorePlayer.getCurrentAudioInformation();
      if (paramCorePlayer != null)
      {
        this.mPlaySpeed = (((float)(paramCorePlayer.getSampleRate() * 2L * paramCorePlayer.getChannels()) / 1000.0F));
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setCommonPlayerRef info = ");
        localStringBuilder.append(paramCorePlayer);
        localStringBuilder.append(",mPlaySpeed = ");
        localStringBuilder.append(this.mPlaySpeed);
        Logger.i("PlayerConfigManager", localStringBuilder.toString());
      }
    }
  }
  
  public void updateDecodeSpeed(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.PlayerConfigManager
 * JD-Core Version:    0.7.0.1
 */