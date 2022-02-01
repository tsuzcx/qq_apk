package org.xwalk.core;

import android.os.AsyncTask;
import com.tencent.xweb.downloader.WXFileDownloaderBridge;
import com.tencent.xweb.downloader.c;

public class XWalkLibraryLoader$WXFileDownloaderTask
  extends AsyncTask<Void, Integer, Integer>
  implements c
{
  private static final int DOWNLOAD_FAILED = -1;
  private static final int DOWNLOAD_SUCCESS = 0;
  private static final int UPDATE_INTERVAL_MS = 500;
  private final Object lockObj = new Object();
  private XWalkLibraryLoader.DownloadInfo mDownloadInfo;
  private XWalkLibraryLoader.DownloadListener mListener;
  private long mProgressUpdateTime = 0L;
  private WXFileDownloaderBridge mWXFileDownloaderBridge = null;
  private boolean mWaitTimeout = false;
  
  public XWalkLibraryLoader$WXFileDownloaderTask(boolean paramBoolean, XWalkLibraryLoader.DownloadListener paramDownloadListener, String paramString1, String paramString2, int paramInt)
  {
    this.mListener = paramDownloadListener;
    this.mDownloadInfo = new XWalkLibraryLoader.DownloadInfo();
    paramDownloadListener = this.mDownloadInfo;
    paramDownloadListener.mErrorType = 0;
    paramDownloadListener.mErrorCode = 0;
    paramDownloadListener.mDownloadType = 2;
    paramDownloadListener.mUrl = paramString1;
    paramDownloadListener.mSavePath = paramString2;
    paramDownloadListener.mIsRuntime = paramBoolean;
    paramDownloadListener.mBizType = paramInt;
    this.mWXFileDownloaderBridge = new WXFileDownloaderBridge();
    this.mWXFileDownloaderBridge.a(this);
  }
  
  protected Integer doInBackground(Void... paramVarArgs)
  {
    this.mListener.onDownloadStarted(this.mDownloadInfo.mDownloadType);
    this.mDownloadInfo.mStartTimestamp = System.currentTimeMillis();
    paramVarArgs = XWalkEnvironment.getApplicationContext();
    this.mDownloadInfo.mNetWorkType = NetworkUtil.getCurrentNetWorkStatus(paramVarArgs);
    ??? = this.mWXFileDownloaderBridge;
    paramVarArgs = Integer.valueOf(-1);
    if ((??? != null) && (((WXFileDownloaderBridge)???).a()))
    {
      if (this.mWXFileDownloaderBridge.a(this.mDownloadInfo.mUrl, this.mDownloadInfo.mSavePath, this.mDownloadInfo.mBizType) != 0)
      {
        ??? = this.mDownloadInfo;
        ((XWalkLibraryLoader.DownloadInfo)???).mErrorType = 1;
        ((XWalkLibraryLoader.DownloadInfo)???).mErrorCode = -1;
        return paramVarArgs;
      }
      try
      {
        synchronized (this.lockObj)
        {
          this.mWaitTimeout = true;
          this.lockObj.wait(600000L);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        this.mWaitTimeout = false;
        this.mDownloadInfo.mErrorType = 2;
        this.mDownloadInfo.mErrorCode = -101;
        localInterruptedException.printStackTrace();
        if (this.mWaitTimeout)
        {
          this.mDownloadInfo.mErrorType = 1;
          this.mDownloadInfo.mErrorCode = -100;
        }
        if ((this.mDownloadInfo.mErrorType == 0) && (this.mDownloadInfo.mErrorCode == 0)) {
          return Integer.valueOf(0);
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("download errortype:");
        localStringBuilder.append(this.mDownloadInfo.mErrorType);
        localStringBuilder.append(", errorcode:");
        localStringBuilder.append(this.mDownloadInfo.mErrorCode);
        localStringBuilder.append(", waitTimeout:");
        localStringBuilder.append(this.mWaitTimeout);
        Log.e("XWalkLib", localStringBuilder.toString());
        return paramVarArgs;
      }
      throw paramVarArgs;
    }
    ??? = this.mDownloadInfo;
    ((XWalkLibraryLoader.DownloadInfo)???).mErrorType = 2;
    ((XWalkLibraryLoader.DownloadInfo)???).mErrorCode = -1;
    return paramVarArgs;
  }
  
  public boolean isValid()
  {
    WXFileDownloaderBridge localWXFileDownloaderBridge = this.mWXFileDownloaderBridge;
    if (localWXFileDownloaderBridge == null) {
      return false;
    }
    return localWXFileDownloaderBridge.a();
  }
  
  protected void onCancelled(Integer paramInteger)
  {
    if (this.mDownloadInfo.mIsRuntime)
    {
      XWalkLibraryLoader.access$002(null);
      paramInteger = new StringBuilder();
      paramInteger.append("WXFileDownloaderTask runtime onCancelled: ");
      paramInteger.append(this.mDownloadInfo.mSavePath);
      Log.i("XWalkLib", paramInteger.toString());
    }
    else
    {
      paramInteger = new StringBuilder();
      paramInteger.append("WXFileDownloaderTask other onCancelled: ");
      paramInteger.append(this.mDownloadInfo.mSavePath);
      Log.i("XWalkLib", paramInteger.toString());
    }
    this.mListener.onDownloadCancelled();
  }
  
  protected void onPostExecute(Integer paramInteger)
  {
    StringBuilder localStringBuilder;
    if (this.mDownloadInfo.mIsRuntime)
    {
      XWalkLibraryLoader.access$002(null);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("WXFileDownloaderTask runtime onPostExecute result ");
      localStringBuilder.append(paramInteger);
      localStringBuilder.append(" ");
      localStringBuilder.append(this.mDownloadInfo.mSavePath);
      Log.i("XWalkLib", localStringBuilder.toString());
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("WXFileDownloaderTask other onPostExecute result ");
      localStringBuilder.append(paramInteger);
      localStringBuilder.append(" ");
      localStringBuilder.append(this.mDownloadInfo.mSavePath);
      Log.i("XWalkLib", localStringBuilder.toString());
    }
    if (paramInteger.intValue() == 0)
    {
      this.mListener.onDownloadCompleted(this.mDownloadInfo);
      return;
    }
    this.mListener.onDownloadFailed(this.mDownloadInfo);
  }
  
  protected void onPreExecute()
  {
    if (this.mDownloadInfo.mIsRuntime)
    {
      XWalkLibraryLoader.access$002(this);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("WXFileDownloaderTask runtime onPreExecute: ");
      localStringBuilder.append(this.mDownloadInfo.mSavePath);
      Log.i("XWalkLib", localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WXFileDownloaderTask other onPreExecute: ");
    localStringBuilder.append(this.mDownloadInfo.mSavePath);
    Log.i("XWalkLib", localStringBuilder.toString());
  }
  
  public void onProgressChange(String paramString, long paramLong1, long paramLong2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("url:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", cur_size:");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(", total_size:");
    localStringBuilder.append(paramLong2);
    Log.d("XWalkLib", localStringBuilder.toString());
    if (this.mDownloadInfo.mFileTotalSize != paramLong2) {
      this.mDownloadInfo.mFileTotalSize = paramLong2;
    }
    publishProgress(new Integer[] { Integer.valueOf((int)paramLong1), Integer.valueOf((int)paramLong2) });
  }
  
  protected void onProgressUpdate(Integer... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WXFileDownloaderTask updated: ");
    int i = 0;
    localStringBuilder.append(paramVarArgs[0]);
    localStringBuilder.append("/");
    localStringBuilder.append(paramVarArgs[1]);
    Log.d("XWalkLib", localStringBuilder.toString());
    if (paramVarArgs[1].intValue() > 0)
    {
      double d1 = paramVarArgs[0].intValue();
      Double.isNaN(d1);
      double d2 = paramVarArgs[1].intValue();
      Double.isNaN(d2);
      i = (int)(d1 * 100.0D / d2);
    }
    this.mListener.onDownloadUpdated(i);
  }
  
  public void onTaskFail(String arg1, int paramInt, boolean paramBoolean)
  {
    synchronized (this.lockObj)
    {
      this.mDownloadInfo.mErrorType = 1;
      this.mDownloadInfo.mErrorCode = paramInt;
      this.mDownloadInfo.mIsDownloadResume = paramBoolean;
      this.mWaitTimeout = false;
      this.lockObj.notify();
      return;
    }
  }
  
  public void onTaskSucc(String arg1, String paramString2, boolean paramBoolean)
  {
    synchronized (this.lockObj)
    {
      this.mDownloadInfo.mIsDownloadResume = paramBoolean;
      this.mWaitTimeout = false;
      this.lockObj.notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkLibraryLoader.WXFileDownloaderTask
 * JD-Core Version:    0.7.0.1
 */