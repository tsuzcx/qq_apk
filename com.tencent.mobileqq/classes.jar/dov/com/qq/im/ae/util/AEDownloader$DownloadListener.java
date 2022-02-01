package dov.com.qq.im.ae.util;

import android.support.annotation.IntRange;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.transfile.NetResp;

public abstract interface AEDownloader$DownloadListener
{
  public abstract void a(@IntRange(from=0L, to=100L) int paramInt);
  
  public abstract void a(@Nullable NetResp paramNetResp);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.util.AEDownloader.DownloadListener
 * JD-Core Version:    0.7.0.1
 */