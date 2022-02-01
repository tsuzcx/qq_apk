package com.tencent.mobileqq.qqlive.filter.download;

import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.transfile.NetResp;

public abstract interface QQLiveBaseDownloader$DownloadListener
{
  public abstract void a(@IntRange(from=0L, to=100L) int paramInt);
  
  public abstract void a(@Nullable NetResp paramNetResp);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.filter.download.QQLiveBaseDownloader.DownloadListener
 * JD-Core Version:    0.7.0.1
 */