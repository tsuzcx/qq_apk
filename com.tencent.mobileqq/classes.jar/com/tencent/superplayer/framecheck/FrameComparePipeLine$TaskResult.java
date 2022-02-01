package com.tencent.superplayer.framecheck;

class FrameComparePipeLine$TaskResult
{
  public static final int BLACK_SCREEN = 2;
  public static final int FRAME_SAME = 3;
  public static final int TASK_PASS = 0;
  public static final int TEXTUREVIEW_NOT_AVAILABLE = 5;
  public static final int TEXTUREVIEW_NULL = 4;
  public static final int TRANS_SCREEN = 1;
  public boolean isBlack;
  public boolean isTransparent;
  public long pHash;
  
  FrameComparePipeLine$TaskResult(FrameComparePipeLine paramFrameComparePipeLine) {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TaskResult{isBlack=");
    localStringBuilder.append(this.isBlack);
    localStringBuilder.append(", isTransparent=");
    localStringBuilder.append(this.isTransparent);
    localStringBuilder.append(", pHash=");
    localStringBuilder.append(this.pHash);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.framecheck.FrameComparePipeLine.TaskResult
 * JD-Core Version:    0.7.0.1
 */