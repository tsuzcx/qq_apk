package cooperation.weiyun.sdk.download.processor;

import cooperation.weiyun.sdk.download.DownloadJobContext;
import cooperation.weiyun.sdk.download.DownloadJobContext.StatusInfo;
import java.util.List;

public abstract interface InfoRecorder$InfoRecorderCallback
{
  public abstract void a(int paramInt, DownloadJobContext paramDownloadJobContext, String paramString);
  
  public abstract void a(long paramLong, boolean paramBoolean1, DownloadJobContext.StatusInfo paramStatusInfo, boolean paramBoolean2);
  
  public abstract void a(long paramLong, boolean paramBoolean, DownloadJobContext paramDownloadJobContext);
  
  public abstract void a(String paramString, List<DownloadJobContext> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.weiyun.sdk.download.processor.InfoRecorder.InfoRecorderCallback
 * JD-Core Version:    0.7.0.1
 */