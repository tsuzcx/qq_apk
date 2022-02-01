package com.tencent.mobileqq.filemanager.app.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.filemanager.app.IQQFavProxy;
import com.tencent.mobileqq.filemanager.app.IQQFavProxy.GetFileListResult;
import com.tencent.mobileqq.filemanager.app.IQQFavProxy.QQFavProxyListener;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.qqfavor.api.IQQFavHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class QQFavProxyImpl
  implements IQQFavProxy
{
  static String FTL = "FavFileS ";
  static String TAG = "QQFavProxy<FileAssistant>";
  private BaseQQAppInterface mApp;
  private HashSet<IQQFavProxy.QQFavProxyListener> mListeners = new HashSet();
  private HashMap<Long, IQQFavProxy.GetFileListResult> mResultCbs = null;
  
  private void handleGettedFileList(long paramLong, List<FavFileInfo> paramList, Bundle paramBundle)
  {
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder().append(FTL).append("onGettedFileList. reqTimeStamp:").append(paramLong).append(" size:");
    int i;
    if (paramList != null)
    {
      i = paramList.size();
      QLog.i((String)localObject, 1, i);
      if (this.mResultCbs != null) {
        if (paramBundle == null) {
          break label257;
        }
      }
    }
    label257:
    for (boolean bool = paramBundle.getBoolean("fecth_operate_end");; bool = true)
    {
      localObject = (IQQFavProxy.GetFileListResult)this.mResultCbs.get(Long.valueOf(paramLong));
      if (localObject == null) {}
      do
      {
        return;
        i = 0;
        break;
        if (((IQQFavProxy.GetFileListResult)localObject).jdField_a_of_type_JavaUtilList == null) {
          ((IQQFavProxy.GetFileListResult)localObject).jdField_a_of_type_JavaUtilList = new ArrayList();
        }
        if (bool)
        {
          this.mResultCbs.remove(Long.valueOf(paramLong));
          if (paramList != null) {
            ((IQQFavProxy.GetFileListResult)localObject).jdField_a_of_type_JavaUtilList.addAll(paramList);
          }
          if (paramBundle != null) {
            ((IQQFavProxy.GetFileListResult)localObject).jdField_a_of_type_Long = paramBundle.getLong("resultTimestamp");
          }
          ((IQQFavProxy.GetFileListResult)localObject).a(0, ((IQQFavProxy.GetFileListResult)localObject).jdField_a_of_type_JavaUtilList, paramBundle);
          return;
        }
        QLog.i(TAG, 1, FTL + "onGettedFileList. fav is getting and waiting");
        if (paramList != null) {
          ((IQQFavProxy.GetFileListResult)localObject).jdField_a_of_type_JavaUtilList.addAll(paramList);
        }
      } while (paramBundle == null);
      ((IQQFavProxy.GetFileListResult)localObject).jdField_a_of_type_Long = paramBundle.getLong("resultTimestamp");
      return;
    }
  }
  
  public void addListener(IQQFavProxy.QQFavProxyListener paramQQFavProxyListener)
  {
    if (paramQQFavProxyListener == null) {
      return;
    }
    this.mListeners.add(paramQQFavProxyListener);
  }
  
  public void cancelGetFileList(long paramLong)
  {
    QLog.i(TAG, 1, FTL + "cancelGetFileList. reqTimeStamp:" + paramLong);
    if (this.mResultCbs != null) {
      this.mResultCbs.remove(Long.valueOf(paramLong));
    }
  }
  
  public void deleteListener(IQQFavProxy.QQFavProxyListener paramQQFavProxyListener)
  {
    if (paramQQFavProxyListener == null) {
      return;
    }
    this.mListeners.remove(paramQQFavProxyListener);
  }
  
  public void downloadThumb(FavFileInfo paramFavFileInfo, int paramInt)
  {
    if (paramInt == 0) {
      paramInt = 64;
    }
    for (;;)
    {
      QLog.i(TAG, 1, FTL + "downloadThumb. favId:" + paramFavFileInfo.jdField_a_of_type_Long + " format:" + paramInt);
      ((IQQFavHelper)this.mApp.getRuntimeService(IQQFavHelper.class)).downloadThumb(this.mApp, paramFavFileInfo, paramInt);
      return;
      if (paramInt == 1) {
        paramInt = 128;
      } else if (paramInt == 2) {
        paramInt = 320;
      } else if (paramInt == 3) {
        paramInt = 640;
      } else if (paramInt == 4) {
        paramInt = 1024;
      } else {
        paramInt = 64;
      }
    }
  }
  
  public void getFileList(long paramLong, boolean paramBoolean, Bundle paramBundle, IQQFavProxy.GetFileListResult paramGetFileListResult)
  {
    QLog.i(TAG, 1, FTL + "getFileList. lastTimestamp:" + paramLong);
    if (this.mResultCbs == null) {
      this.mResultCbs = new HashMap();
    }
    if (paramGetFileListResult != null) {
      this.mResultCbs.put(Long.valueOf(paramLong), paramGetFileListResult);
    }
    ((IQQFavHelper)this.mApp.getRuntimeService(IQQFavHelper.class)).getFavList(this.mApp, paramLong, paramBoolean, paramBundle);
  }
  
  public long getGettedPartList(long paramLong, List<FavFileInfo> paramList)
  {
    if (this.mResultCbs != null)
    {
      IQQFavProxy.GetFileListResult localGetFileListResult = (IQQFavProxy.GetFileListResult)this.mResultCbs.get(Long.valueOf(paramLong));
      if (paramList != null) {
        paramList.addAll(localGetFileListResult.jdField_a_of_type_JavaUtilList);
      }
      if (localGetFileListResult != null) {
        return localGetFileListResult.jdField_a_of_type_Long;
      }
    }
    return 0L;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = ((BaseQQAppInterface)paramAppRuntime);
  }
  
  public void onDestroy() {}
  
  public void onFileDownloaded(long paramLong, String paramString)
  {
    QLog.i(TAG, 1, FTL + "onFileDownloaded. favId:" + paramLong + " strSavePath:" + paramString + "lz:" + this.mListeners.size());
    if (this.mListeners.size() == 0) {}
    for (;;)
    {
      return;
      Object localObject = Looper.getMainLooper();
      if (Thread.currentThread() != ((Looper)localObject).getThread())
      {
        new Handler((Looper)localObject).post(new QQFavProxyImpl.4(this, paramLong, paramString));
        return;
      }
      localObject = this.mListeners.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((IQQFavProxy.QQFavProxyListener)((Iterator)localObject).next()).a(paramLong, paramString);
      }
    }
  }
  
  public void onFileListRefreshed(boolean paramBoolean, Bundle paramBundle)
  {
    String str = "";
    if (paramBundle != null) {
      str = paramBundle.getString("delete_favids");
    }
    QLog.i(TAG, 1, FTL + "onFileListRefreshed. bSuc:" + paramBoolean + " delFavIds:" + str);
    if (this.mListeners.size() == 0) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new QQFavProxyImpl.2(this, paramBoolean, paramBundle));
  }
  
  public void onFileThumbUpdated(long paramLong, String paramString, int paramInt)
  {
    int i = 0;
    QLog.i(TAG, 1, FTL + "onFileThumbUpdated. favId:" + paramLong + " strThumbPath:" + paramString + " format:" + paramInt + " lz:" + this.mListeners.size());
    if (this.mListeners.size() == 0) {}
    for (;;)
    {
      return;
      if (paramInt == 64) {}
      for (;;)
      {
        localObject = Looper.getMainLooper();
        if (Thread.currentThread() == ((Looper)localObject).getThread()) {
          break;
        }
        new Handler((Looper)localObject).post(new QQFavProxyImpl.3(this, paramLong, i, paramString));
        return;
        if (paramInt == 128) {
          i = 1;
        } else if (paramInt == 320) {
          i = 2;
        }
      }
      Object localObject = this.mListeners.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((IQQFavProxy.QQFavProxyListener)((Iterator)localObject).next()).a(paramLong, i, paramString);
      }
    }
  }
  
  public void onGettedFileList(long paramLong, List<FavFileInfo> paramList, Bundle paramBundle)
  {
    new Handler(Looper.getMainLooper()).post(new QQFavProxyImpl.1(this, paramLong, paramList, paramBundle));
  }
  
  public boolean refreshList(Bundle paramBundle)
  {
    QLog.i(TAG, 1, FTL + "refreshList.");
    return ((IQQFavHelper)this.mApp.getRuntimeService(IQQFavHelper.class)).refreshList(this.mApp, paramBundle);
  }
  
  public void sendFavFiles(List<FavFileInfo> paramList, String paramString, int paramInt, Bundle paramBundle)
  {
    QLog.i(TAG, 1, FTL + "sendFavFiles. size:" + paramList.size() + " strToUin:" + paramString + " toUinType:" + paramInt);
    ((IQQFavHelper)this.mApp.getRuntimeService(IQQFavHelper.class)).forwardFavFileList(this.mApp, paramList, paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.impl.QQFavProxyImpl
 * JD-Core Version:    0.7.0.1
 */