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
    Object localObject1 = TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(FTL);
    ((StringBuilder)localObject2).append("onGettedFileList. reqTimeStamp:");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append(" size:");
    int i;
    if (paramList != null) {
      i = paramList.size();
    } else {
      i = 0;
    }
    ((StringBuilder)localObject2).append(i);
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    if (this.mResultCbs != null)
    {
      boolean bool;
      if (paramBundle != null) {
        bool = paramBundle.getBoolean("fecth_operate_end");
      } else {
        bool = true;
      }
      localObject1 = (IQQFavProxy.GetFileListResult)this.mResultCbs.get(Long.valueOf(paramLong));
      if (localObject1 == null) {
        return;
      }
      if (((IQQFavProxy.GetFileListResult)localObject1).d == null) {
        ((IQQFavProxy.GetFileListResult)localObject1).d = new ArrayList();
      }
      if (bool)
      {
        this.mResultCbs.remove(Long.valueOf(paramLong));
        if (paramList != null) {
          ((IQQFavProxy.GetFileListResult)localObject1).d.addAll(paramList);
        }
        if (paramBundle != null) {
          ((IQQFavProxy.GetFileListResult)localObject1).c = paramBundle.getLong("resultTimestamp");
        }
        ((IQQFavProxy.GetFileListResult)localObject1).a(0, ((IQQFavProxy.GetFileListResult)localObject1).d, paramBundle);
        return;
      }
      localObject2 = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(FTL);
      localStringBuilder.append("onGettedFileList. fav is getting and waiting");
      QLog.i((String)localObject2, 1, localStringBuilder.toString());
      if (paramList != null) {
        ((IQQFavProxy.GetFileListResult)localObject1).d.addAll(paramList);
      }
      if (paramBundle != null) {
        ((IQQFavProxy.GetFileListResult)localObject1).c = paramBundle.getLong("resultTimestamp");
      }
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
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FTL);
    localStringBuilder.append("cancelGetFileList. reqTimeStamp:");
    localStringBuilder.append(paramLong);
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    localObject = this.mResultCbs;
    if (localObject != null) {
      ((HashMap)localObject).remove(Long.valueOf(paramLong));
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
    int i = 64;
    if (paramInt != 0) {
      if (paramInt == 1) {
        i = 128;
      } else if (paramInt == 2) {
        i = 320;
      } else if (paramInt == 3) {
        i = 640;
      } else if (paramInt == 4) {
        i = 1024;
      }
    }
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FTL);
    localStringBuilder.append("downloadThumb. favId:");
    localStringBuilder.append(paramFavFileInfo.a);
    localStringBuilder.append(" format:");
    localStringBuilder.append(i);
    QLog.i(str, 1, localStringBuilder.toString());
    ((IQQFavHelper)this.mApp.getRuntimeService(IQQFavHelper.class)).downloadThumb(this.mApp, paramFavFileInfo, i);
  }
  
  public void getFileList(long paramLong, boolean paramBoolean, Bundle paramBundle, IQQFavProxy.GetFileListResult paramGetFileListResult)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FTL);
    localStringBuilder.append("getFileList. lastTimestamp:");
    localStringBuilder.append(paramLong);
    QLog.i(str, 1, localStringBuilder.toString());
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
    Object localObject = this.mResultCbs;
    if (localObject != null)
    {
      localObject = (IQQFavProxy.GetFileListResult)((HashMap)localObject).get(Long.valueOf(paramLong));
      if (paramList != null) {
        paramList.addAll(((IQQFavProxy.GetFileListResult)localObject).d);
      }
      if (localObject != null) {
        return ((IQQFavProxy.GetFileListResult)localObject).c;
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
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FTL);
    localStringBuilder.append("onFileDownloaded. favId:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" strSavePath:");
    localStringBuilder.append(paramString);
    localStringBuilder.append("lz:");
    localStringBuilder.append(this.mListeners.size());
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    if (this.mListeners.size() == 0) {
      return;
    }
    localObject = Looper.getMainLooper();
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
  
  public void onFileListRefreshed(boolean paramBoolean, Bundle paramBundle)
  {
    String str1;
    if (paramBundle != null) {
      str1 = paramBundle.getString("delete_favids");
    } else {
      str1 = "";
    }
    String str2 = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FTL);
    localStringBuilder.append("onFileListRefreshed. bSuc:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" delFavIds:");
    localStringBuilder.append(str1);
    QLog.i(str2, 1, localStringBuilder.toString());
    if (this.mListeners.size() == 0) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new QQFavProxyImpl.2(this, paramBoolean, paramBundle));
  }
  
  public void onFileThumbUpdated(long paramLong, String paramString, int paramInt)
  {
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FTL);
    localStringBuilder.append("onFileThumbUpdated. favId:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" strThumbPath:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" format:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" lz:");
    localStringBuilder.append(this.mListeners.size());
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    if (this.mListeners.size() == 0) {
      return;
    }
    if (paramInt == 64) {}
    do
    {
      paramInt = 0;
      break;
      if (paramInt == 128)
      {
        paramInt = 1;
        break;
      }
    } while (paramInt != 320);
    paramInt = 2;
    localObject = Looper.getMainLooper();
    if (Thread.currentThread() != ((Looper)localObject).getThread())
    {
      new Handler((Looper)localObject).post(new QQFavProxyImpl.3(this, paramLong, paramInt, paramString));
      return;
    }
    localObject = this.mListeners.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IQQFavProxy.QQFavProxyListener)((Iterator)localObject).next()).a(paramLong, paramInt, paramString);
    }
  }
  
  public void onGettedFileList(long paramLong, List<FavFileInfo> paramList, Bundle paramBundle)
  {
    new Handler(Looper.getMainLooper()).post(new QQFavProxyImpl.1(this, paramLong, paramList, paramBundle));
  }
  
  public boolean refreshList(Bundle paramBundle)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FTL);
    localStringBuilder.append("refreshList.");
    QLog.i(str, 1, localStringBuilder.toString());
    return ((IQQFavHelper)this.mApp.getRuntimeService(IQQFavHelper.class)).refreshList(this.mApp, paramBundle);
  }
  
  public void sendFavFiles(List<FavFileInfo> paramList, String paramString, int paramInt, Bundle paramBundle)
  {
    paramBundle = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FTL);
    localStringBuilder.append("sendFavFiles. size:");
    localStringBuilder.append(paramList.size());
    localStringBuilder.append(" strToUin:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" toUinType:");
    localStringBuilder.append(paramInt);
    QLog.i(paramBundle, 1, localStringBuilder.toString());
    ((IQQFavHelper)this.mApp.getRuntimeService(IQQFavHelper.class)).forwardFavFileList(this.mApp, paramList, paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.impl.QQFavProxyImpl
 * JD-Core Version:    0.7.0.1
 */