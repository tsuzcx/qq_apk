package com.tencent.mobileqq.vas;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngSoLoader;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.URLDrawableHandler.Adapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.util.VasSoUtils;
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
  private static VasApngIPCModule jdField_a_of_type_ComTencentMobileqqVasVasApngIPCModule;
  public static String a = "action_download_apng_so";
  private CopyOnWriteArrayList<Integer> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private boolean jdField_a_of_type_Boolean;
  private CopyOnWriteArrayList<URLDrawableHandler> b = new CopyOnWriteArrayList();
  
  private VasApngIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static VasApngIPCModule a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqVasVasApngIPCModule == null) {
        jdField_a_of_type_ComTencentMobileqqVasVasApngIPCModule = new VasApngIPCModule("VasApngIPCModule");
      }
      VasApngIPCModule localVasApngIPCModule = jdField_a_of_type_ComTencentMobileqqVasVasApngIPCModule;
      return localVasApngIPCModule;
    }
    finally {}
  }
  
  private boolean a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (IVasQuickUpdateService)paramQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "");
    if (paramQQAppInterface != null)
    {
      QLog.e("VasApngUtil.IPCModule", 1, "start download so");
      paramQQAppInterface.downloadItem(1004L, "libAPNG_845", "VasApngUtil.IPCModule");
      return true;
    }
    QLog.d("VasApngUtil.IPCModule", 1, "load fail no manager");
    return false;
  }
  
  private void b(int paramInt)
  {
    callbackResult(paramInt, EIPCResult.createResult(0, null));
  }
  
  public void a()
  {
    a(new URLDrawableHandler.Adapter(), true);
  }
  
  public void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDownloadCompleted: errCode=");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("VasApngUtil.IPCModule", 1, ((StringBuilder)localObject).toString());
    if (paramInt == 0)
    {
      String str = VasSoUtils.a();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(BaseApplicationImpl.getContext().getFilesDir());
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("apng.zip");
      localObject = ((StringBuilder)localObject).toString();
      if (VasSoUtils.a((String)localObject, str, "libAPNG_release_845.so"))
      {
        QLog.d("VasApngUtil.IPCModule", 1, "unzip apng zip success");
        b();
        VasUpdateUtil.a(new File((String)localObject));
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unzip error, libDir=");
        localStringBuilder.append(str);
        str = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(" zipPath=");
        localStringBuilder.append((String)localObject);
        QLog.e("VasApngUtil.IPCModule", 1, new Object[] { str, localStringBuilder.toString() });
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("apng download error: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.e("VasApngUtil.IPCModule", 1, ((StringBuilder)localObject).toString());
    }
    b();
  }
  
  public void a(URLDrawableHandler paramURLDrawableHandler, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.e("VasApngUtil.IPCModule", 1, "load by others");
      paramURLDrawableHandler.onFileDownloadSucceed(0L);
      return;
    }
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject == null)
    {
      QLog.e("VasApngUtil.IPCModule", 1, "load fail null application");
      paramURLDrawableHandler.onFileDownloadFailed(10000);
      return;
    }
    if (b())
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
    if (DeviceInfoUtil.e())
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
    if ((localObject instanceof QQAppInterface))
    {
      this.b.add(paramURLDrawableHandler);
      if (!a((QQAppInterface)localObject))
      {
        this.b.remove(paramURLDrawableHandler);
        paramURLDrawableHandler.onFileDownloadFailed(10003);
      }
    }
    else
    {
      QLog.e("VasApngUtil.IPCModule", 1, "child progress callServer to load");
      QIPCClientHelper.getInstance().callServer("VasApngIPCModule", jdField_a_of_type_JavaLangString, null, new VasApngIPCModule.1(this, paramURLDrawableHandler));
    }
  }
  
  public boolean a()
  {
    String str = VasSoUtils.a();
    if (!TextUtils.isEmpty(str))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("libAPNG_release_845.so");
      if (new File(localStringBuilder.toString()).exists()) {
        return true;
      }
    }
    return false;
  }
  
  void b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.b.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (URLDrawableHandler)localIterator.next();
      a((URLDrawableHandler)localObject, false);
      localArrayList.add(localObject);
    }
    this.b.removeAll(localArrayList);
    localArrayList = new ArrayList();
    localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext())
    {
      localObject = (Integer)localIterator.next();
      b(((Integer)localObject).intValue());
      localArrayList.add(localObject);
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.removeAll(localArrayList);
  }
  
  public boolean b()
  {
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VasApngUtil.IPCModule", 2, "loadSoLib: already loaded");
        }
        return true;
      }
      String str = VasSoUtils.a();
      if (!TextUtils.isEmpty(str))
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append(str);
        localStringBuilder1.append("libAPNG_release_845.so");
        str = localStringBuilder1.toString();
        if (new File(str).exists())
        {
          QLog.d("VasApngUtil.IPCModule", 1, "loadSoLib: libAPNG_release_845.so");
          try
          {
            System.load(str);
            this.jdField_a_of_type_Boolean = true;
            QLog.d("VasApngUtil.IPCModule", 1, "libAPNG.so load success.");
            return true;
          }
          catch (Throwable localThrowable)
          {
            QLog.d("VasApngUtil.IPCModule", 1, "libAPNG.so load failed. :", localThrowable);
            VasUpdateUtil.a(new File(str));
            ReportController.b(null, "CliOper", "", "", "Font_Mall", "0X80073FE", 0, 0, "101", "", "", "");
          }
        }
        else
        {
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("loadSoLib not exists: ");
          localStringBuilder2.append(str);
          QLog.e("VasApngUtil.IPCModule", 1, localStringBuilder2.toString());
        }
      }
      return false;
    }
    finally {}
  }
  
  public boolean isLoaded()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void load(URLDrawableHandler paramURLDrawableHandler)
  {
    a(paramURLDrawableHandler, true);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onCall action = ");
      paramBundle.append(paramString);
      QLog.d("VasApngUtil.IPCModule", 2, paramBundle.toString());
    }
    if (jdField_a_of_type_JavaLangString.equals(paramString))
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(Integer.valueOf(paramInt));
      paramBundle = BaseApplicationImpl.getApplication();
      if (paramBundle == null) {
        paramString = null;
      } else {
        paramString = paramBundle.getRuntime();
      }
      if ((paramBundle != null) && ((paramString instanceof QQAppInterface)) && (a((QQAppInterface)paramString))) {
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("download fail to start, application:");
      localStringBuilder.append(paramBundle);
      localStringBuilder.append(" runtime:");
      localStringBuilder.append(paramString);
      QLog.e("VasApngUtil.IPCModule", 1, localStringBuilder.toString());
      b(paramInt);
      try
      {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramInt);
        return null;
      }
      catch (Exception paramString)
      {
        paramBundle = new StringBuilder();
        paramBundle.append("callbacks.remove error : ");
        paramBundle.append(paramString.getMessage());
        QLog.e("VasApngUtil.IPCModule", 1, paramBundle.toString());
        return null;
      }
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onCall action = ");
      paramBundle.append(paramString);
      QLog.d("VasApngUtil.IPCModule", 2, paramBundle.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasApngIPCModule
 * JD-Core Version:    0.7.0.1
 */