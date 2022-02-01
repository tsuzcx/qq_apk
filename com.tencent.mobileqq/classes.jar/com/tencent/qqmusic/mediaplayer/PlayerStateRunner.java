package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class PlayerStateRunner
{
  private static final String TAG = "StateRunner";
  private WeakReference<AudioTrack> mAudioTrack = new WeakReference(null);
  private final ReadWriteLock mLock = new ReentrantReadWriteLock();
  private Integer mState;
  
  PlayerStateRunner(Integer paramInteger)
  {
    this.mState = paramInteger;
  }
  
  Integer get()
  {
    this.mLock.readLock().lock();
    for (;;)
    {
      try
      {
        i = this.mState.intValue();
        Object localObject1 = (AudioTrack)this.mAudioTrack.get();
        int j = i;
        if (localObject1 != null)
        {
          j = ((AudioTrack)localObject1).getPlayState();
          if (j == 2) {
            break label165;
          }
          if (j == 3) {
            break label160;
          }
          j = i;
          if (!this.mState.equals(Integer.valueOf(i)))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("!mState.equals(state), mstate = ");
            ((StringBuilder)localObject1).append(this.mState.toString());
            ((StringBuilder)localObject1).append("   state = ");
            ((StringBuilder)localObject1).append(i);
            Logger.e("StateRunner", ((StringBuilder)localObject1).toString());
            j = i;
          }
        }
        return Integer.valueOf(j);
      }
      finally
      {
        this.mLock.readLock().unlock();
      }
      label160:
      int i = 4;
      continue;
      label165:
      i = 5;
    }
  }
  
  boolean isEqual(Integer... paramVarArgs)
  {
    this.mLock.readLock().lock();
    try
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        Integer localInteger = paramVarArgs[i];
        boolean bool = this.mState.equals(localInteger);
        if (bool)
        {
          this.mLock.readLock().unlock();
          return true;
        }
        i += 1;
      }
      this.mLock.readLock().unlock();
      return false;
    }
    finally
    {
      this.mLock.readLock().unlock();
    }
    for (;;)
    {
      throw paramVarArgs;
    }
  }
  
  public void setAudioTrack(AudioTrack paramAudioTrack)
  {
    this.mAudioTrack = new WeakReference(paramAudioTrack);
  }
  
  Integer transfer(Integer paramInteger)
  {
    this.mLock.writeLock().lock();
    try
    {
      Integer localInteger = this.mState;
      this.mState = paramInteger;
      paramInteger = new StringBuilder();
      paramInteger.append(localInteger.toString());
      paramInteger.append(" -> ");
      paramInteger.append(this.mState.toString());
      Logger.i("StateRunner", paramInteger.toString());
      return localInteger;
    }
    finally
    {
      this.mLock.writeLock().unlock();
    }
  }
  
  /* Error */
  boolean transfer(Integer paramInteger, Integer... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 25	com/tencent/qqmusic/mediaplayer/PlayerStateRunner:mLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   4: invokeinterface 107 1 0
    //   9: invokeinterface 48 1 0
    //   14: aload_0
    //   15: aload_2
    //   16: invokevirtual 115	com/tencent/qqmusic/mediaplayer/PlayerStateRunner:isEqual	([Ljava/lang/Integer;)Z
    //   19: ifeq +27 -> 46
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 117	com/tencent/qqmusic/mediaplayer/PlayerStateRunner:transfer	(Ljava/lang/Integer;)Ljava/lang/Integer;
    //   27: pop
    //   28: iconst_1
    //   29: istore_3
    //   30: aload_0
    //   31: getfield 25	com/tencent/qqmusic/mediaplayer/PlayerStateRunner:mLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   34: invokeinterface 107 1 0
    //   39: invokeinterface 98 1 0
    //   44: iload_3
    //   45: ireturn
    //   46: iconst_0
    //   47: istore_3
    //   48: goto -18 -> 30
    //   51: astore_1
    //   52: aload_0
    //   53: getfield 25	com/tencent/qqmusic/mediaplayer/PlayerStateRunner:mLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   56: invokeinterface 107 1 0
    //   61: invokeinterface 98 1 0
    //   66: goto +5 -> 71
    //   69: aload_1
    //   70: athrow
    //   71: goto -2 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	PlayerStateRunner
    //   0	74	1	paramInteger	Integer
    //   0	74	2	paramVarArgs	Integer[]
    //   29	19	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   14	28	51	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.PlayerStateRunner
 * JD-Core Version:    0.7.0.1
 */