package org.xwalk.core;

import android.content.Context;
import android.os.AsyncTask;

public class XWalkLibraryLoader
{
  private static final String DEFAULT_DOWNLOAD_FILE_NAME = "xwalk_download.tmp";
  private static final int DOWNLOAD_TYPE_CDN = 2;
  private static final int DOWNLOAD_TYPE_HTTP = 1;
  private static final String DOWNLOAD_WITHOUT_NOTIFICATION = "android.permission.DOWNLOAD_WITHOUT_NOTIFICATION";
  private static final int ERROR_CODE_DOWNLOADER_TIMEOUT = -100;
  private static final int ERROR_CODE_EXCEPTION = -101;
  private static final int ERROR_CODE_FAILED = -1;
  private static final int ERROR_CODE_SUCCESS = 0;
  private static final int ERROR_TYPE_DOWNLOADER = 1;
  private static final int ERROR_TYPE_NONE = 0;
  private static final int ERROR_TYPE_USER = 2;
  private static final String TAG = "XWalkLib";
  private static AsyncTask<Void, Integer, Integer> sActiveTask;
  
  public static boolean cancelHttpDownload()
  {
    AsyncTask localAsyncTask = sActiveTask;
    return (localAsyncTask != null) && ((localAsyncTask instanceof XWalkLibraryLoader.HttpDownloadTask)) && (localAsyncTask.cancel(true));
  }
  
  public static void finishInit(Context paramContext)
  {
    XWalkCoreWrapper.handlePostInit(paramContext.getClass().getName());
  }
  
  public static int getLibraryStatus()
  {
    return XWalkCoreWrapper.getCoreStatus();
  }
  
  public static boolean isDownloading()
  {
    AsyncTask localAsyncTask = sActiveTask;
    return (localAsyncTask != null) && ((localAsyncTask instanceof XWalkLibraryLoader.HttpDownloadTask));
  }
  
  public static boolean isInitializing()
  {
    return false;
  }
  
  public static boolean isLibraryReady()
  {
    return XWalkCoreWrapper.getInstance() != null;
  }
  
  public static boolean isSharedLibrary()
  {
    return XWalkCoreWrapper.getInstance().isSharedMode();
  }
  
  public static void prepareToInit(Context paramContext)
  {
    XWalkEnvironment.init(paramContext);
    XWalkCoreWrapper.handlePreInit(paramContext.getClass().getName());
  }
  
  public static void startHttpDownload(XWalkLibraryLoader.DownloadListener paramDownloadListener, Context paramContext, XWalkUpdater.UpdateConfig paramUpdateConfig)
  {
    paramContext = new XWalkLibraryLoader.WXFileDownloaderTask(true, paramDownloadListener, paramUpdateConfig.downUrl, paramUpdateConfig.getDownloadPath(), paramUpdateConfig.getUpdateBizType());
    if ((paramUpdateConfig.bUseCdn) && (paramContext.isValid()))
    {
      Log.i("XWalkLib", "use wx file downloader");
      paramContext.execute(new Void[0]);
      return;
    }
    Log.i("XWalkLib", "use default file downloader");
    new XWalkLibraryLoader.HttpDownloadTask(true, paramDownloadListener, paramUpdateConfig.downUrl, paramUpdateConfig.getDownloadPath()).execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkLibraryLoader
 * JD-Core Version:    0.7.0.1
 */