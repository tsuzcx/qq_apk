package com.tencent.vas.update.business;

import androidx.annotation.NonNull;
import com.tencent.vas.update.callback.listener.IBusinessCallback;
import com.tencent.vas.update.callback.listener.IUpdateListener;
import com.tencent.vas.update.entity.BusinessItemInfo;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.UpdateListenerParams;
import com.tencent.vas.update.module.api.IVasUpdateSystem;
import com.tencent.vas.update.util.FileUtil;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.io.File;
import java.lang.ref.WeakReference;

public abstract class BaseUpdateBusiness
  implements IBusinessCallback
{
  private static final String TAG = "VasUpdate_BaseUpdateBusiness";
  private static WeakReference<IUpdateListener> weakListener;
  
  public void addUpdateListener(IUpdateListener paramIUpdateListener)
  {
    if (paramIUpdateListener != null) {
      weakListener = new WeakReference(paramIUpdateListener);
    }
  }
  
  public void cancelDownload(long paramLong, String paramString)
  {
    VasUpdateWrapper.getVasUpdateSystem().a(paramLong, paramString);
  }
  
  public void cancelDownload(String paramString)
  {
    VasUpdateWrapper.getVasUpdateSystem().a(getBid(), paramString);
  }
  
  public void deleteFile(@NonNull BusinessUpdateParams paramBusinessUpdateParams, BusinessItemInfo paramBusinessItemInfo)
  {
    if (paramBusinessItemInfo == null) {
      return;
    }
    FileUtil.safeDeleteFile(new File(paramBusinessItemInfo.mSavePath), "");
  }
  
  public boolean isFileExist(@NonNull BusinessUpdateParams paramBusinessUpdateParams, BusinessItemInfo paramBusinessItemInfo)
  {
    if (paramBusinessItemInfo == null) {
      return false;
    }
    return new File(paramBusinessItemInfo.mSavePath).exists();
  }
  
  public void onLoadFail(@NonNull UpdateListenerParams paramUpdateListenerParams)
  {
    Object localObject = weakListener;
    if (localObject != null)
    {
      localObject = (IUpdateListener)((WeakReference)localObject).get();
      if (localObject != null) {
        ((IUpdateListener)localObject).onLoadFail(paramUpdateListenerParams);
      }
    }
  }
  
  public void onLoadSuccess(@NonNull UpdateListenerParams paramUpdateListenerParams)
  {
    Object localObject = weakListener;
    if (localObject != null)
    {
      localObject = (IUpdateListener)((WeakReference)localObject).get();
      if (localObject != null) {
        ((IUpdateListener)localObject).onLoadSuccess(paramUpdateListenerParams);
      }
    }
  }
  
  public void onProgress(@NonNull UpdateListenerParams paramUpdateListenerParams)
  {
    Object localObject = weakListener;
    if (localObject != null)
    {
      localObject = (IUpdateListener)((WeakReference)localObject).get();
      if (localObject != null) {
        ((IUpdateListener)localObject).onProgress(paramUpdateListenerParams);
      }
    }
  }
  
  public void removeUpdateListener()
  {
    WeakReference localWeakReference = weakListener;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
  }
  
  public void startDownload(BusinessUpdateParams paramBusinessUpdateParams)
  {
    VasUpdateWrapper.getVasUpdateSystem().a(paramBusinessUpdateParams);
  }
  
  public void startDownload(String paramString)
  {
    paramString = new BusinessUpdateParams(getBid(), paramString, getFrom());
    VasUpdateWrapper.getVasUpdateSystem().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.vas.update.business.BaseUpdateBusiness
 * JD-Core Version:    0.7.0.1
 */