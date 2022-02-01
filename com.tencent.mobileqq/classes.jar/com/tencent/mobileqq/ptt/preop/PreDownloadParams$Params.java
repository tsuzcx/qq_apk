package com.tencent.mobileqq.ptt.preop;

public class PreDownloadParams$Params
{
  public int a = -1;
  public final int[] b = new int[6];
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append(this.a);
    int i = 0;
    while (i < this.b.length)
    {
      localStringBuilder.append('#');
      localStringBuilder.append(i);
      localStringBuilder.append('_');
      localStringBuilder.append(this.b[i]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.preop.PreDownloadParams.Params
 * JD-Core Version:    0.7.0.1
 */