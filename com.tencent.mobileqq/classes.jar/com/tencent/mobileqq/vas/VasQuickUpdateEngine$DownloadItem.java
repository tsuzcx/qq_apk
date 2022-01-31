package com.tencent.mobileqq.vas;

public class VasQuickUpdateEngine$DownloadItem
{
  public long bid;
  public String from;
  public String scid;
  
  public VasQuickUpdateEngine$DownloadItem(long paramLong, String paramString1, String paramString2)
  {
    this.bid = paramLong;
    this.scid = paramString1;
    this.from = paramString2;
  }
  
  public boolean equals(DownloadItem paramDownloadItem)
  {
    return (this.bid == paramDownloadItem.bid) && (this.scid.equals(paramDownloadItem.scid));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateEngine.DownloadItem
 * JD-Core Version:    0.7.0.1
 */