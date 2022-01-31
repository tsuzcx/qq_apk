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
    int i;
    if (this == paramPriorityTask) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      j = paramPriorityTask.mPriority - this.mPriority;
      i = j;
    } while (j != 0);
    return (int)(this.mPostTime - paramPriorityTask.mPostTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.utils.pool.PriorityThreadPoolExecutor.PriorityTask
 * JD-Core Version:    0.7.0.1
 */