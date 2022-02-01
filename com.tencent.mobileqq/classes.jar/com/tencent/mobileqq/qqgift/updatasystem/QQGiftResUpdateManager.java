package com.tencent.mobileqq.qqgift.updatasystem;

import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.tencent.mobileqq.qqgift.callback.IQQGiftAnimationResDownloadCallback;
import com.tencent.mobileqq.qqgift.callback.IQQGiftPanelResDownloadCallback;
import com.tencent.mobileqq.qqgift.callback.IQQGiftResDownloadCallback;
import com.tencent.mobileqq.qqgift.updatasystem.data.QQGiftResConfigInfo;
import com.tencent.mobileqq.qqgift.updatasystem.data.ResConfigDetailInfo;
import com.tencent.mobileqq.qqgift.utils.QQGiftResDownloadUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.util.QQVasUpdateBusinessUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.callback.listener.IUpdateListener;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class QQGiftResUpdateManager
{
  private static volatile QQGiftResUpdateManager a;
  private Map<String, HashSet<IQQGiftResDownloadCallback>> b = new HashMap();
  private IUpdateListener c = new QQGiftResUpdateManager.1(this);
  private IUpdateListener d = new QQGiftResUpdateManager.2(this);
  private IUpdateListener e = new QQGiftResUpdateManager.3(this);
  
  @Nullable
  private QQGiftPanelResource a(String paramString)
  {
    QQGiftPanelResource localQQGiftPanelResource = new QQGiftPanelResource();
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("config.json");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[mapResourceData] jsonFile:");
        localStringBuilder.append((String)localObject);
        QLog.d("QQGiftResUpdateManager", 4, localStringBuilder.toString());
      }
      localObject = a(new File((String)localObject));
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[mapResourceData] json:");
        localStringBuilder.append((String)localObject);
        QLog.d("QQGiftResUpdateManager", 4, localStringBuilder.toString());
      }
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[mapResourceData] resDir:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", json:");
        localStringBuilder.append((String)localObject);
        QLog.e("QQGiftResUpdateManager", 1, localStringBuilder.toString());
        return null;
      }
      localObject = (QQGiftResConfigInfo)new Gson().fromJson((String)localObject, QQGiftResConfigInfo.class);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[mapResourceData] configInfo:");
        localStringBuilder.append(localObject);
        QLog.d("QQGiftResUpdateManager", 4, localStringBuilder.toString());
      }
      if (localObject == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[mapResourceData] configInfo is null! resDir:");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("QQGiftResUpdateManager", 1, ((StringBuilder)localObject).toString());
        return localQQGiftPanelResource;
      }
      if (b(((QQGiftResConfigInfo)localObject).thumb.type))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQGiftResUpdateManager", 4, "[mapResourceData] ValidType thumb.type");
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(File.separator);
        localStringBuilder.append(((QQGiftResConfigInfo)localObject).thumb.name);
        localQQGiftPanelResource.b = localStringBuilder.toString();
      }
      else if (!TextUtils.isEmpty(((QQGiftResConfigInfo)localObject).thumb.defaultName))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(File.separator);
        localStringBuilder.append(((QQGiftResConfigInfo)localObject).thumb.defaultName);
        localQQGiftPanelResource.b = localStringBuilder.toString();
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[mapResourceData] resource.thumbPath:");
        localStringBuilder.append(localQQGiftPanelResource.b);
        QLog.d("QQGiftResUpdateManager", 4, localStringBuilder.toString());
      }
      if (b(((QQGiftResConfigInfo)localObject).bg.type))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQGiftResUpdateManager", 4, "[mapResourceData] ValidType bg.type");
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(File.separator);
        localStringBuilder.append(((QQGiftResConfigInfo)localObject).bg.name);
        localQQGiftPanelResource.d = localStringBuilder.toString();
      }
      else if (!TextUtils.isEmpty(((QQGiftResConfigInfo)localObject).bg.defaultName))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(File.separator);
        localStringBuilder.append(((QQGiftResConfigInfo)localObject).bg.defaultName);
        localQQGiftPanelResource.d = localStringBuilder.toString();
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("[mapResourceData] resource.bgPath:");
        paramString.append(localQQGiftPanelResource.d);
        QLog.d("QQGiftResUpdateManager", 4, paramString.toString());
        return localQQGiftPanelResource;
      }
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mapResourceData throw exception:");
      ((StringBuilder)localObject).append(paramString.getMessage());
      QLog.e("QQGiftResUpdateManager", 1, ((StringBuilder)localObject).toString());
    }
    return localQQGiftPanelResource;
  }
  
  public static QQGiftResUpdateManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new QQGiftResUpdateManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  private String a(File paramFile)
  {
    paramFile = FileUtils.fileToBytes(paramFile);
    if (paramFile != null)
    {
      if (paramFile.length <= 0) {
        return null;
      }
      if (Build.VERSION.SDK_INT <= 8) {
        return new String(paramFile);
      }
      try
      {
        paramFile = new String(paramFile, "UTF-8");
        return paramFile;
      }
      catch (UnsupportedEncodingException paramFile)
      {
        QLog.e("QQGiftResUpdateManager", 1, "loadFileContent error, ", paramFile);
      }
    }
    return null;
  }
  
  private HashSet<IQQGiftResDownloadCallback> a(UpdateListenerParams paramUpdateListenerParams, boolean paramBoolean)
  {
    if (this.b == null)
    {
      QLog.e("QQGiftResUpdateManager", 1, "getAndRemoveCallback callbacksMap is null!");
      return null;
    }
    if ((paramUpdateListenerParams != null) && (paramUpdateListenerParams.mBusinessUpdateParams != null))
    {
      paramUpdateListenerParams = paramUpdateListenerParams.mBusinessUpdateParams.mScid;
      localObject = (HashSet)this.b.get(paramUpdateListenerParams);
      if (paramBoolean) {
        this.b.remove(paramUpdateListenerParams);
      }
      return localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getAndRemoveCallback updateListenerParams:");
    ((StringBuilder)localObject).append(paramUpdateListenerParams);
    QLog.e("QQGiftResUpdateManager", 1, ((StringBuilder)localObject).toString());
    return null;
  }
  
  private void a(int paramInt, String paramString, IQQGiftPanelResDownloadCallback paramIQQGiftPanelResDownloadCallback)
  {
    if (paramIQQGiftPanelResDownloadCallback == null)
    {
      QLog.d("QQGiftResUpdateManager", 1, "onPanelResLoadCallbackSuccess callback is null");
      return;
    }
    QQGiftPanelResource localQQGiftPanelResource = a(paramString);
    if (a(localQQGiftPanelResource))
    {
      paramIQQGiftPanelResDownloadCallback.a(paramInt, localQQGiftPanelResource);
      return;
    }
    paramIQQGiftPanelResDownloadCallback.a(paramInt, -1, -1, "dir is exist path is invalid");
    FileUtils.deleteDirectory(paramString);
    paramString = new StringBuilder();
    paramString.append("[downloadAnimationRes] dir is exist path is invalid, panelResource:");
    paramString.append(localQQGiftPanelResource);
    QLog.e("QQGiftResUpdateManager", 1, paramString.toString());
  }
  
  private void a(UpdateListenerParams paramUpdateListenerParams)
  {
    Object localObject = a(paramUpdateListenerParams, true);
    if (localObject == null)
    {
      QLog.e("QQGiftResUpdateManager", 1, "onLoadFail downloadCallback is null!");
      return;
    }
    QQGiftResourceBusiness localQQGiftResourceBusiness = (QQGiftResourceBusiness)QQVasUpdateBusinessUtil.a(QQGiftResourceBusiness.class);
    String str = paramUpdateListenerParams.mBusinessUpdateParams.mScid;
    QQGiftResDownloadUtil.b(str);
    int i = localQQGiftResourceBusiness.a(str, 2);
    localObject = ((HashSet)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IQQGiftResDownloadCallback)((Iterator)localObject).next()).a(i, paramUpdateListenerParams.mErrorCode, paramUpdateListenerParams.mHttpCode, paramUpdateListenerParams.mErrorMessage);
    }
  }
  
  private void a(String paramString, IQQGiftResDownloadCallback paramIQQGiftResDownloadCallback)
  {
    if (paramIQQGiftResDownloadCallback == null)
    {
      QLog.d("QQGiftResUpdateManager", 1, "onPanelResLoadCallbackSuccess callback is null");
      return;
    }
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = (HashSet)((Map)localObject).get(paramString);
      if (localObject == null)
      {
        localObject = new HashSet();
        ((HashSet)localObject).add(paramIQQGiftResDownloadCallback);
        this.b.put(paramString, localObject);
        return;
      }
      ((HashSet)localObject).add(paramIQQGiftResDownloadCallback);
    }
  }
  
  private boolean a(QQGiftPanelResource paramQQGiftPanelResource)
  {
    boolean bool = false;
    if (paramQQGiftPanelResource == null) {
      return false;
    }
    if (!TextUtils.isEmpty(paramQQGiftPanelResource.b)) {
      bool = new File(paramQQGiftPanelResource.b).exists();
    }
    if (!TextUtils.isEmpty(paramQQGiftPanelResource.d)) {
      bool = new File(paramQQGiftPanelResource.d).exists();
    }
    return bool;
  }
  
  private void b(UpdateListenerParams paramUpdateListenerParams)
  {
    Object localObject = a(paramUpdateListenerParams, false);
    if (localObject == null)
    {
      QLog.e("QQGiftResUpdateManager", 1, "onProgress downloadCallback is null!");
      return;
    }
    int i = ((QQGiftResourceBusiness)QQVasUpdateBusinessUtil.a(QQGiftResourceBusiness.class)).a(paramUpdateListenerParams.mBusinessUpdateParams.mScid, 2);
    localObject = ((HashSet)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IQQGiftResDownloadCallback)((Iterator)localObject).next()).a(i, paramUpdateListenerParams.mProgress, paramUpdateListenerParams.mProgressMax, paramUpdateListenerParams.mProgressRate);
    }
  }
  
  private boolean b(String paramString)
  {
    return "png".equals(paramString);
  }
  
  public void a(int paramInt, @NonNull IQQGiftPanelResDownloadCallback paramIQQGiftPanelResDownloadCallback)
  {
    QQGiftResourceBusiness localQQGiftResourceBusiness = (QQGiftResourceBusiness)QQVasUpdateBusinessUtil.a(QQGiftResourceBusiness.class);
    int i = 1;
    String str1 = localQQGiftResourceBusiness.a(paramInt, 1);
    String str2 = localQQGiftResourceBusiness.e(str1);
    boolean bool = QQGiftResDownloadUtil.a(str1);
    if (localQQGiftResourceBusiness.c(str1))
    {
      a(paramInt, str2, paramIQQGiftPanelResDownloadCallback);
      i = bool;
    }
    else
    {
      a(str1, paramIQQGiftPanelResDownloadCallback);
    }
    if (i != 0)
    {
      localQQGiftResourceBusiness.addUpdateListener(this.c);
      localQQGiftResourceBusiness.startDownload(str1);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean, IQQGiftAnimationResDownloadCallback paramIQQGiftAnimationResDownloadCallback)
  {
    QQGiftResourceBusiness localQQGiftResourceBusiness = (QQGiftResourceBusiness)QQVasUpdateBusinessUtil.a(QQGiftResourceBusiness.class);
    String str = localQQGiftResourceBusiness.a(paramInt, 2);
    boolean bool = QQGiftResDownloadUtil.a(str);
    Object localObject1 = localQQGiftResourceBusiness.e(str);
    if (localQQGiftResourceBusiness.c(str))
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[downloadAnimationRes] ");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append(" local exist");
        QLog.i("QQGiftResUpdateManager", 1, ((StringBuilder)localObject2).toString());
      }
      if (paramIQQGiftAnimationResDownloadCallback == null)
      {
        QLog.d("QQGiftResUpdateManager", 1, "onPanelResLoadCallbackSuccess callback is null");
        return;
      }
      if (paramBoolean)
      {
        paramIQQGiftAnimationResDownloadCallback.a(paramInt, (String)localObject1);
      }
      else
      {
        localObject2 = new File((String)localObject1).list(new QQGiftResUpdateManager.4(this));
        if (localObject2.length > 0)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(File.separator);
          localStringBuilder.append(localObject2[0]);
          paramIQQGiftAnimationResDownloadCallback.a(paramInt, localStringBuilder.toString());
        }
        else
        {
          paramIQQGiftAnimationResDownloadCallback.a(paramInt, -1, -1, "dir is exist but is empty");
          FileUtils.deleteDirectory((String)localObject1);
          paramIQQGiftAnimationResDownloadCallback = new StringBuilder();
          paramIQQGiftAnimationResDownloadCallback.append("[downloadAnimationRes] file is exist but is empty, dir:");
          paramIQQGiftAnimationResDownloadCallback.append((String)localObject1);
          QLog.e("QQGiftResUpdateManager", 1, paramIQQGiftAnimationResDownloadCallback.toString());
        }
      }
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[downloadAnimationRes] ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" needDownload");
      QLog.i("QQGiftResUpdateManager", 1, ((StringBuilder)localObject1).toString());
      a(str, paramIQQGiftAnimationResDownloadCallback);
      bool = true;
    }
    if (bool)
    {
      if (paramBoolean) {
        localQQGiftResourceBusiness.addUpdateListener(this.d);
      } else {
        localQQGiftResourceBusiness.addUpdateListener(this.e);
      }
      localQQGiftResourceBusiness.startDownload(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.updatasystem.QQGiftResUpdateManager
 * JD-Core Version:    0.7.0.1
 */