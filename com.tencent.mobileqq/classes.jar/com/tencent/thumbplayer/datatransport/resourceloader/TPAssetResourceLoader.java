package com.tencent.thumbplayer.datatransport.resourceloader;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoaderListener;
import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingRequest;
import com.tencent.thumbplayer.api.resourceloader.TPAssetResourceLoadingContentInformationRequest;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLFileSystem;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLIOUtil;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class TPAssetResourceLoader
  implements ITPAssetResourceLoader
{
  private static final int MSG_ON_START_READ_DATA = 256;
  private static final int MSG_ON_STOP_READ_DATA = 257;
  private static String TAG = "TPAssetResourceLoader";
  private static final String mCacheDir = "resourceLoader";
  private String mBusinessFilePath = "";
  private TPAssetResourceLoader.EventHandler mCallbackForResourceLoaderHandler;
  private TPAssetResourceLoadingContentInformationRequest mContentInformation;
  private String mContentType = "";
  private Context mContext;
  private String mDataCacheFilePath = "";
  private long mDataTotalSize = 0L;
  private String mFileSuffix = ".mp4";
  private HandlerThread mHandlerThread;
  private ArrayList<TPAssetResourceLoadingRequest> mLoadingRequests;
  private int mRequestNum = 0;
  private ITPAssetResourceLoaderListener mTPAssetResourceLoaderListener;
  private HandlerThread mWriteDataThread;
  
  public TPAssetResourceLoader(Context paramContext, Looper paramLooper)
  {
    this.mContext = paramContext;
    this.mLoadingRequests = new ArrayList();
    paramContext = paramLooper;
    if (paramLooper == null)
    {
      this.mHandlerThread = new HandlerThread("TPAssetResourceLoader-callbackThread");
      this.mHandlerThread.start();
      paramContext = this.mHandlerThread.getLooper();
    }
    this.mCallbackForResourceLoaderHandler = new TPAssetResourceLoader.EventHandler(this, paramContext);
    this.mWriteDataThread = new HandlerThread("TPAssetResourceLoader-dataWriteThread");
    this.mWriteDataThread.start();
  }
  
  private void addRequest(TPAssetResourceLoadingRequest paramTPAssetResourceLoadingRequest)
  {
    try
    {
      if (this.mLoadingRequests != null) {
        this.mLoadingRequests.add(paramTPAssetResourceLoadingRequest);
      }
      return;
    }
    finally
    {
      paramTPAssetResourceLoadingRequest = finally;
      throw paramTPAssetResourceLoadingRequest;
    }
  }
  
  private void clearRequestList()
  {
    try
    {
      if (this.mLoadingRequests != null)
      {
        Iterator localIterator = this.mLoadingRequests.iterator();
        while (localIterator.hasNext())
        {
          ITPAssetResourceLoadingRequest localITPAssetResourceLoadingRequest = (ITPAssetResourceLoadingRequest)localIterator.next();
          ((TPAssetResourceLoadingRequest)localITPAssetResourceLoadingRequest).cancelRequest();
          this.mTPAssetResourceLoaderListener.didCancelLoadingRequest(localITPAssetResourceLoadingRequest);
        }
        this.mLoadingRequests.clear();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  private String getBusinessFilePath()
  {
    return this.mBusinessFilePath;
  }
  
  private String getDataCacheFilePath(Context paramContext, int paramInt)
  {
    if (TextUtils.isEmpty(this.mDataCacheFilePath))
    {
      String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(this.mFileSuffix);
      paramContext = TPDLFileSystem.getExternalCacheFile(paramContext, "resourceLoader", localStringBuilder.toString());
      TPDLIOUtil.createFile(paramContext);
      this.mDataCacheFilePath = paramContext.getAbsolutePath();
    }
    return this.mDataCacheFilePath;
  }
  
  private int getDataReadyLength(long paramLong)
  {
    try
    {
      ArrayList localArrayList = this.mLoadingRequests;
      int i = 0;
      if (localArrayList == null) {
        return 0;
      }
      int j = 0;
      while (i < this.mLoadingRequests.size())
      {
        j = Math.max(j, ((TPAssetResourceLoadingRequest)this.mLoadingRequests.get(i)).getDataReadyLength(paramLong));
        i += 1;
      }
      return j;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  private TPAssetResourceLoadingRequest getLoadingRequestWithNum(int paramInt)
  {
    try
    {
      Object localObject1 = this.mLoadingRequests;
      if (localObject1 == null) {
        return null;
      }
      int i = 0;
      while (i < this.mLoadingRequests.size())
      {
        localObject1 = (TPAssetResourceLoadingRequest)this.mLoadingRequests.get(i);
        int j = ((TPAssetResourceLoadingRequest)localObject1).getLoadingDataRequest().getRequestNum();
        if (j == paramInt) {
          return localObject1;
        }
        i += 1;
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private long getRequestLength(long paramLong1, long paramLong2)
  {
    if (paramLong2 > 0L) {
      return paramLong2 - paramLong1;
    }
    paramLong2 = this.mDataTotalSize;
    if (paramLong2 <= 0L) {
      return 536870912L;
    }
    return paramLong2 - paramLong1;
  }
  
  private void handleResourceLoaderCallback(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    Object localObject = this.mCallbackForResourceLoaderHandler;
    if (localObject != null)
    {
      localObject = ((TPAssetResourceLoader.EventHandler)localObject).obtainMessage();
      ((Message)localObject).what = paramInt1;
      ((Message)localObject).arg1 = paramInt2;
      ((Message)localObject).arg2 = paramInt3;
      ((Message)localObject).obj = paramObject;
      this.mCallbackForResourceLoaderHandler.sendMessage((Message)localObject);
    }
  }
  
  private void handleStopReadData(int paramInt)
  {
    Object localObject1 = getLoadingRequestWithNum(paramInt);
    if (localObject1 == null)
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("TPAssetLoader can't find the request ");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(" with current loading requests");
      TPLogUtil.e((String)localObject1, ((StringBuilder)localObject2).toString());
      return;
    }
    ((TPAssetResourceLoadingRequest)localObject1).cancelRequest();
    Object localObject2 = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleStopReadData, cancel the loading request with id ");
    localStringBuilder.append(paramInt);
    TPLogUtil.i((String)localObject2, localStringBuilder.toString());
    removeRequest((TPAssetResourceLoadingRequest)localObject1);
    this.mTPAssetResourceLoaderListener.didCancelLoadingRequest((ITPAssetResourceLoadingRequest)localObject1);
  }
  
  private void removeRequest(TPAssetResourceLoadingRequest paramTPAssetResourceLoadingRequest)
  {
    try
    {
      if (this.mLoadingRequests != null) {
        this.mLoadingRequests.remove(paramTPAssetResourceLoadingRequest);
      }
      return;
    }
    finally
    {
      paramTPAssetResourceLoadingRequest = finally;
      throw paramTPAssetResourceLoadingRequest;
    }
  }
  
  public void fillInContentInformation()
  {
    if (this.mTPAssetResourceLoaderListener == null)
    {
      TPLogUtil.e(TAG, "listener not set");
      return;
    }
    this.mContentInformation = new TPAssetResourceLoadingContentInformationRequest();
    this.mTPAssetResourceLoaderListener.fillInContentInformation(this.mContentInformation);
    this.mContentType = this.mContentInformation.contentType;
    this.mDataTotalSize = this.mContentInformation.dataTotalSize;
    this.mBusinessFilePath = this.mContentInformation.dataFilePath;
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("proxy start, mDataTotalSize: ");
    localStringBuilder.append(this.mDataTotalSize);
    localStringBuilder.append(" businessPath:");
    localStringBuilder.append(this.mBusinessFilePath);
    TPLogUtil.i(str, localStringBuilder.toString());
  }
  
  public String getContentType(int paramInt, String paramString)
  {
    return this.mContentType;
  }
  
  public String getDataFilePath(int paramInt, String paramString)
  {
    paramString = getBusinessFilePath();
    if (!TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return getDataCacheFilePath(this.mContext, paramInt);
  }
  
  public long getDataTotalSize(int paramInt, String paramString)
  {
    return this.mDataTotalSize;
  }
  
  public int onReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    paramString = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("read data, offset:");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(", length:");
    localStringBuilder.append(paramLong2);
    TPLogUtil.d(paramString, localStringBuilder.toString());
    int i = (int)Math.min(getDataReadyLength(paramLong1), paramLong2);
    if (i <= 0) {
      return -1;
    }
    paramString = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("on read data, fileId: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" readOffset: ");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(" readLength:");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(" readyLength:");
    localStringBuilder.append(i);
    TPLogUtil.d(paramString, localStringBuilder.toString());
    return i;
  }
  
  public int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    if (this.mTPAssetResourceLoaderListener == null)
    {
      TPLogUtil.e(TAG, "listener not set");
      return 0;
    }
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStartReadData, fileId:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", fileKey:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", requestStart:");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(", requestEnd:");
    localStringBuilder.append(paramLong2);
    TPLogUtil.i((String)localObject, localStringBuilder.toString());
    int i = this.mRequestNum + 1;
    localObject = new TPAssetResourceLoader.StartReadDataParams(null);
    ((TPAssetResourceLoader.StartReadDataParams)localObject).requestStart = paramLong1;
    ((TPAssetResourceLoader.StartReadDataParams)localObject).requestEnd = paramLong2;
    ((TPAssetResourceLoader.StartReadDataParams)localObject).fileKey = paramString;
    handleResourceLoaderCallback(256, paramInt, i, localObject);
    this.mRequestNum = i;
    return this.mRequestNum;
  }
  
  public int onStopReadData(int paramInt1, String paramString, int paramInt2)
  {
    if (this.mTPAssetResourceLoaderListener == null)
    {
      TPLogUtil.e(TAG, "listener not set");
      return 0;
    }
    handleResourceLoaderCallback(257, paramInt2, 0, null);
    return 0;
  }
  
  public void release()
  {
    TPLogUtil.i(TAG, "release start");
    reset();
    Object localObject = this.mCallbackForResourceLoaderHandler;
    if (localObject != null)
    {
      ((TPAssetResourceLoader.EventHandler)localObject).removeCallbacksAndMessages(null);
      this.mCallbackForResourceLoaderHandler = null;
    }
    localObject = this.mHandlerThread;
    if (localObject != null)
    {
      ((HandlerThread)localObject).quit();
      this.mHandlerThread = null;
    }
    localObject = this.mWriteDataThread;
    if (localObject != null)
    {
      ((HandlerThread)localObject).quit();
      this.mWriteDataThread = null;
    }
    this.mLoadingRequests = null;
  }
  
  public void reset()
  {
    TPLogUtil.i(TAG, "reset start");
    clearRequestList();
    this.mDataTotalSize = 0L;
    this.mContentType = "";
    this.mBusinessFilePath = "";
    if (!TextUtils.isEmpty(this.mDataCacheFilePath)) {
      try
      {
        new File(this.mDataCacheFilePath).deleteOnExit();
        this.mDataCacheFilePath = "";
      }
      catch (Exception localException)
      {
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reset, delete cache file has exception:");
        localStringBuilder.append(localException.toString());
        TPLogUtil.e(str, localStringBuilder.toString());
      }
    }
    TPAssetResourceLoader.EventHandler localEventHandler = this.mCallbackForResourceLoaderHandler;
    if (localEventHandler != null) {
      localEventHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void setTPAssetResourceLoaderListener(ITPAssetResourceLoaderListener paramITPAssetResourceLoaderListener)
  {
    this.mTPAssetResourceLoaderListener = paramITPAssetResourceLoaderListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.datatransport.resourceloader.TPAssetResourceLoader
 * JD-Core Version:    0.7.0.1
 */