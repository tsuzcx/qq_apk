package org.apache.commons.lang.time;

public class StopWatch
{
  private static final int STATE_RUNNING = 1;
  private static final int STATE_SPLIT = 11;
  private static final int STATE_STOPPED = 2;
  private static final int STATE_SUSPENDED = 3;
  private static final int STATE_UNSPLIT = 10;
  private static final int STATE_UNSTARTED = 0;
  private int runningState = 0;
  private int splitState = 10;
  private long startTime = -1L;
  private long stopTime = -1L;
  
  public long getSplitTime()
  {
    if (this.splitState == 11) {
      return this.stopTime - this.startTime;
    }
    throw new IllegalStateException("Stopwatch must be split to get the split time. ");
  }
  
  public long getStartTime()
  {
    if (this.runningState != 0) {
      return this.startTime;
    }
    throw new IllegalStateException("Stopwatch has not been started");
  }
  
  public long getTime()
  {
    int i = this.runningState;
    long l1;
    if ((i != 2) && (i != 3))
    {
      if (i == 0) {
        return 0L;
      }
      if (i == 1) {
        l1 = System.currentTimeMillis();
      }
    }
    for (long l2 = this.startTime;; l2 = this.startTime)
    {
      return l1 - l2;
      throw new RuntimeException("Illegal running state has occured. ");
      l1 = this.stopTime;
    }
  }
  
  public void reset()
  {
    this.runningState = 0;
    this.splitState = 10;
    this.startTime = -1L;
    this.stopTime = -1L;
  }
  
  public void resume()
  {
    if (this.runningState == 3)
    {
      this.startTime += System.currentTimeMillis() - this.stopTime;
      this.stopTime = -1L;
      this.runningState = 1;
      return;
    }
    throw new IllegalStateException("Stopwatch must be suspended to resume. ");
  }
  
  public void split()
  {
    if (this.runningState == 1)
    {
      this.stopTime = System.currentTimeMillis();
      this.splitState = 11;
      return;
    }
    throw new IllegalStateException("Stopwatch is not running. ");
  }
  
  public void start()
  {
    int i = this.runningState;
    if (i != 2)
    {
      if (i == 0)
      {
        this.stopTime = -1L;
        this.startTime = System.currentTimeMillis();
        this.runningState = 1;
        return;
      }
      throw new IllegalStateException("Stopwatch already started. ");
    }
    throw new IllegalStateException("Stopwatch must be reset before being restarted. ");
  }
  
  public void stop()
  {
    int i = this.runningState;
    if ((i != 1) && (i != 3)) {
      throw new IllegalStateException("Stopwatch is not running. ");
    }
    if (this.runningState == 1) {
      this.stopTime = System.currentTimeMillis();
    }
    this.runningState = 2;
  }
  
  public void suspend()
  {
    if (this.runningState == 1)
    {
      this.stopTime = System.currentTimeMillis();
      this.runningState = 3;
      return;
    }
    throw new IllegalStateException("Stopwatch must be running to suspend. ");
  }
  
  public String toSplitString()
  {
    return DurationFormatUtils.formatDurationHMS(getSplitTime());
  }
  
  public String toString()
  {
    return DurationFormatUtils.formatDurationHMS(getTime());
  }
  
  public void unsplit()
  {
    if (this.splitState == 11)
    {
      this.stopTime = -1L;
      this.splitState = 10;
      return;
    }
    throw new IllegalStateException("Stopwatch has not been split. ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.time.StopWatch
 * JD-Core Version:    0.7.0.1
 */