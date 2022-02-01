package com.tencent.mobileqq.vas.VasResEngine;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.QzoneMainRuntime;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class VasResController
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new VasResController.1(this);
  private DownloaderInterface jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface;
  
  public VasResController(int paramInt, Handler paramHandler)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  private Manager a(AppRuntime paramAppRuntime)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((paramAppRuntime instanceof ToolAppRuntime))
    {
      paramAppRuntime = paramAppRuntime.getAppRuntime("modular_web");
      localObject1 = localObject2;
      if ((paramAppRuntime instanceof BrowserAppInterface)) {
        localObject1 = paramAppRuntime.getManager(QQManagerFactory.DOWNLOADER_FACTORY);
      }
    }
    do
    {
      do
      {
        return localObject1;
        if ((paramAppRuntime instanceof QQAppInterface)) {
          return paramAppRuntime.getManager(QQManagerFactory.DOWNLOADER_FACTORY);
        }
        localObject1 = localObject2;
      } while (!(paramAppRuntime instanceof QzoneMainRuntime));
      paramAppRuntime = BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("qzone_plugin.apk");
      localObject1 = localObject2;
    } while (paramAppRuntime == null);
    return paramAppRuntime.getManager(QQManagerFactory.DOWNLOADER_FACTORY);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    ThreadManager.post(new VasResController.2(this, paramString, paramInt1, paramInt2), 5, null, true);
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface == null) && (localObject != null)) {}
    try
    {
      localObject = a((AppRuntime)localObject);
      if ((localObject instanceof DownloaderFactory)) {
        this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = ((DownloaderFactory)localObject).a(1);
      }
      if (TextUtils.isEmpty(paramString1)) {
        QLog.e("VasResController", 1, "downLoad error url is empty dst =" + paramString2);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.a(paramString1) == null))
      {
        paramString1 = new DownloadTask(paramString1, new File(paramString2));
        this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.a(paramString1, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, paramBundle);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("VasResController", 1, localException.getMessage());
      }
    }
  }
  
  public String[] a(String paramString)
  {
    Object localObject = new File(paramString);
    if ((localObject == null) || (!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
      if (QLog.isColorLevel()) {
        QLog.d("VasResController", 2, "SignatureView DynamicItem png file path error.");
      }
    }
    ArrayList localArrayList;
    do
    {
      return null;
      localArrayList = FileUtils.a(paramString);
    } while (localArrayList.size() <= 0);
    localObject = new String[localArrayList.size()];
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(paramString).append(File.separator);
    if (((String)localArrayList.get(0)).contains(".9.png")) {}
    for (paramString = "%d.9.png";; paramString = "%d.png")
    {
      localStringBuilder2.append(paramString);
      paramString = localStringBuilder1.toString();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localObject[i] = String.format(paramString, new Object[] { Integer.valueOf(i + 1) });
        i += 1;
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasResEngine.VasResController
 * JD-Core Version:    0.7.0.1
 */