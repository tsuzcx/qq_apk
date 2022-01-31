package com.tencent.mobileqq.vas;

public class VasQuickUpdateEngine$DownloadTask
  extends VasQuickUpdateEngine.PendingTask
{
  public VasQuickUpdateEngine$DownloadTask(long paramLong, String paramString1, String paramString2)
  {
    this.bid = paramLong;
    this.scid = paramString1;
    this.from = paramString2;
  }
  
  public void run(VasQuickUpdateEngine paramVasQuickUpdateEngine)
  {
    paramVasQuickUpdateEngine.downloadItem(this.bid, this.scid, this.from);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateEngine.DownloadTask
 * JD-Core Version:    0.7.0.1
 */