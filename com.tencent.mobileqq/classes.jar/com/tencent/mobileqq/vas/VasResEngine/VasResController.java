package com.tencent.mobileqq.vas.VasResEngine;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AppRuntime;

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
    AppRuntime localAppRuntime = VasUtil.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface == null) && (localAppRuntime != null)) {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = ((IVasDepTemp)QRoute.api(IVasDepTemp.class)).getDownloader(localAppRuntime);
      }
      catch (Exception localException)
      {
        QLog.e("VasResController", 1, localException.getMessage());
      }
    }
    if (TextUtils.isEmpty(paramString1))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downLoad error url is empty dst =");
      ((StringBuilder)localObject).append(paramString2);
      QLog.e("VasResController", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface;
    if ((localObject != null) && (((DownloaderInterface)localObject).getTask(paramString1) == null))
    {
      paramString1 = new DownloadTask(paramString1, new File(paramString2));
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface.startDownload(paramString1, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, paramBundle);
    }
  }
  
  public String[] a(String paramString)
  {
    Object localObject = new File(paramString);
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      ArrayList localArrayList = FileUtils.getChildFiles(paramString);
      if (localArrayList.size() <= 0) {
        return null;
      }
      localObject = new String[localArrayList.size()];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(File.separator);
      if (((String)localArrayList.get(0)).contains(".9.png")) {
        paramString = "%d.9.png";
      } else {
        paramString = "%d.png";
      }
      localStringBuilder.append(paramString);
      paramString = localStringBuilder.toString();
      int k = localObject.length;
      int j;
      for (int i = 0; i < k; i = j)
      {
        j = i + 1;
        localObject[i] = String.format(paramString, new Object[] { Integer.valueOf(j) });
      }
      return localObject;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VasResController", 2, "SignatureView DynamicItem png file path error.");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasResEngine.VasResController
 * JD-Core Version:    0.7.0.1
 */