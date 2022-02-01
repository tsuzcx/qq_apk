package com.tencent.upload.utils.pool;

class PriorityThreadPoolExecutor$PriorityTask
  implements Comparable<PriorityTask>
{
  protected long mPostTime = System.currentTimeMillis();
  protected int mPriority = 0;
  
  public PriorityThreadPoolExecutor$PriorityTask() {}
  
  public PriorityThreadPoolExecutor$PriorityTask(int paramInt)
  {
    this.mPriority = paramInt;
  }
  
  public int compareTo(PriorityTask paramPriorityTask)
  {
    if (this == paramPriorityTask) {
      return 0;
    }
    int i = paramPriorityTask.mPriority - this.mPriority;
    if (i != 0) {
      return i;
    }
    return (int)(this.mPostTime - paramPriorityTask.mPostTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.utils.pool.PriorityThreadPoolExecutor.PriorityTask
 * JD-Core Version:    0.7.0.1
 */