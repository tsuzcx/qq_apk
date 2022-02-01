package com.tencent.mobileqq.vas;

import android.os.Bundle;
import android.text.TextUtils;
import bcef;
import bgae;
import com.tencent.biz.flatbuffers.FlatBuffersParser;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngSoLoader;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.URLDrawableHandler.Adapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class VasApngIPCModule
  extends QIPCModule
  implements ApngSoLoader
{
  public static String ACTION_DOWNLOAD_APNG_SO = "action_download_apng_so";
  public static final String NAME = "VasApngIPCModule";
  private static final String TAG = "VasApngUtil.IPCModule";
  private static VasApngIPCModule sInstance;
  private CopyOnWriteArrayList<Integer> callbacks = new CopyOnWriteArrayList();
  private CopyOnWriteArrayList<URLDrawableHandler> handlers = new CopyOnWriteArrayList();
  private boolean isLoaded;
  
  private VasApngIPCModule(String paramString)
  {
    super(paramString);
  }
  
  private void callBackToRemote(int paramInt)
  {
    callbackResult(paramInt, EIPCResult.createResult(0, null));
  }
  
  private boolean download(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (VasQuickUpdateManager)paramQQAppInterface.getManager(184);
    if (paramQQAppInterface != null)
    {
      QLog.e("VasApngUtil.IPCModule", 1, "start download so");
      paramQQAppInterface.downloadItem(1004L, "libAPNG_845", "VasApngUtil.IPCModule");
      return true;
    }
    QLog.d("VasApngUtil.IPCModule", 1, "load fail no manager");
    return false;
  }
  
  public static VasApngIPCModule getInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new VasApngIPCModule("VasApngIPCModule");
      }
      VasApngIPCModule localVasApngIPCModule = sInstance;
      return localVasApngIPCModule;
    }
    finally {}
  }
  
  void callBackToAll()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.handlers.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (URLDrawableHandler)localIterator.next();
      load((URLDrawableHandler)localObject, false);
      localArrayList.add(localObject);
    }
    this.handlers.removeAll(localArrayList);
    localArrayList = new ArrayList();
    localIterator = this.callbacks.iterator();
    while (localIterator.hasNext())
    {
      localObject = (Integer)localIterator.next();
      callBackToRemote(((Integer)localObject).intValue());
      localArrayList.add(localObject);
    }
    this.callbacks.removeAll(localArrayList);
  }
  
  public void download()
  {
    load(new URLDrawableHandler.Adapter(), true);
  }
  
  public boolean isLoaded()
  {
    return this.isLoaded;
  }
  
  public boolean isSoExists()
  {
    String str = bgae.a();
    return (!TextUtils.isEmpty(str)) && (new File(str + "libAPNG_release_845.so").exists());
  }
  
  public void load(URLDrawableHandler paramURLDrawableHandler)
  {
    load(paramURLDrawableHandler, true);
  }
  
  public void load(URLDrawableHandler paramURLDrawableHandler, boolean paramBoolean)
  {
    if (this.isLoaded)
    {
      QLog.e("VasApngUtil.IPCModule", 1, "load by others");
      paramURLDrawableHandler.onFileDownloadSucceed(0L);
    }
    Object localObject;
    do
    {
      return;
      localObject = BaseApplicationImpl.getApplication();
      if (localObject == null)
      {
        QLog.e("VasApngUtil.IPCModule", 1, "load fail null application");
        paramURLDrawableHandler.onFileDownloadFailed(10000);
        return;
      }
      if (loadSoLib())
      {
        QLog.e("VasApngUtil.IPCModule", 1, "load exists so success");
        paramURLDrawableHandler.onFileDownloadSucceed(0L);
        return;
      }
      if (!paramBoolean)
      {
        QLog.e("VasApngUtil.IPCModule", 1, "second try so not exists");
        paramURLDrawableHandler.onFileDownloadFailed(10001);
        return;
      }
      if (FlatBuffersParser.c())
      {
        QLog.e("VasApngUtil.IPCModule", 1, "isX86 can't download apng.so");
        paramURLDrawableHandler.onFileDownloadFailed(10004);
        return;
      }
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if (localObject == null)
      {
        QLog.e("VasApngUtil.IPCModule", 1, "load fail null runtime");
        paramURLDrawableHandler.onFileDownloadFailed(10002);
        return;
      }
      if (!(localObject instanceof QQAppInterface)) {
        break;
      }
      this.handlers.add(paramURLDrawableHandler);
    } while (download((QQAppInterface)localObject));
    this.handlers.remove(paramURLDrawableHandler);
    paramURLDrawableHandler.onFileDownloadFailed(10003);
    return;
    QLog.e("VasApngUtil.IPCModule", 1, "child progress callServer to load");
    QIPCClientHelper.getInstance().callServer("VasApngIPCModule", ACTION_DOWNLOAD_APNG_SO, null, new VasApngIPCModule.1(this, paramURLDrawableHandler));
  }
  
  public boolean loadSoLib()
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        if (this.isLoaded)
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("VasApngUtil.IPCModule", 2, "loadSoLib: already loaded");
            bool1 = bool2;
          }
          return bool1;
        }
        String str = bgae.a();
        if (!TextUtils.isEmpty(str))
        {
          str = str + "libAPNG_release_845.so";
          if (new File(str).exists())
          {
            QLog.d("VasApngUtil.IPCModule", 1, "loadSoLib: libAPNG_release_845.so");
            try
            {
              System.load(str);
              this.isLoaded = true;
              QLog.d("VasApngUtil.IPCModule", 1, "libAPNG.so load success.");
              bool1 = bool2;
            }
            catch (Throwable localThrowable)
            {
              QLog.d("VasApngUtil.IPCModule", 1, "libAPNG.so load failed. :", localThrowable);
              VasQuickUpdateEngine.safeDeleteFile(new File(str));
              bcef.b(null, "CliOper", "", "", "Font_Mall", "0X80073FE", 0, 0, "101", "", "", "");
              break label201;
            }
          }
          QLog.e("VasApngUtil.IPCModule", 1, "loadSoLib not exists: " + str);
        }
      }
      finally {}
      label201:
      boolean bool1 = false;
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasApngUtil.IPCModule", 2, "onCall action = " + paramString);
    }
    if (ACTION_DOWNLOAD_APNG_SO.equals(paramString))
    {
      this.callbacks.add(Integer.valueOf(paramInt));
      paramBundle = BaseApplicationImpl.getApplication();
      if (paramBundle == null)
      {
        paramString = null;
        if ((paramBundle == null) || (!(paramString instanceof QQAppInterface)) || (!download((QQAppInterface)paramString))) {
          break label96;
        }
      }
    }
    label96:
    while (!QLog.isColorLevel())
    {
      for (;;)
      {
        return null;
        paramString = paramBundle.getRuntime();
      }
      QLog.e("VasApngUtil.IPCModule", 1, "download fail to start, application:" + paramBundle + " runtime:" + paramString);
      callBackToRemote(paramInt);
      try
      {
        this.callbacks.remove(paramInt);
        return null;
      }
      catch (Exception paramString)
      {
        QLog.e("VasApngUtil.IPCModule", 1, "callbacks.remove error : " + paramString.getMessage());
        return null;
      }
    }
    QLog.d("VasApngUtil.IPCModule", 2, "onCall action = " + paramString);
    return null;
  }
  
  public void onDownloadCompleted(int paramInt)
  {
    QLog.d("VasApngUtil.IPCModule", 1, "onDownloadCompleted: errCode=" + paramInt);
    String str1;
    String str2;
    if (paramInt == 0)
    {
      str1 = bgae.a();
      str2 = BaseApplicationImpl.getContext().getFilesDir() + File.separator + "apng.zip";
      if (bgae.a(str2, str1, "libAPNG_release_845.so"))
      {
        QLog.d("VasApngUtil.IPCModule", 1, "unzip apng zip success");
        loadSoLib();
        VasQuickUpdateEngine.safeDeleteFile(new File(str2));
      }
    }
    for (;;)
    {
      callBackToAll();
      return;
      QLog.e("VasApngUtil.IPCModule", 1, new Object[] { "unzip error, libDir=" + str1, " zipPath=" + str2 });
      continue;
      QLog.e("VasApngUtil.IPCModule", 1, "apng download error: " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasApngIPCModule
 * JD-Core Version:    0.7.0.1
 */