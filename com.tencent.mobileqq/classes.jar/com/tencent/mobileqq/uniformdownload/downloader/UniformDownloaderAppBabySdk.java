package com.tencent.mobileqq.uniformdownload.downloader;

import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderAppBabyListener;
import com.tencent.mobileqq.uniformdownload.util.UDConstants;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UniformDownloaderAppBabySdk
{
  private static UniformDownloaderAppBabySdk jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloaderAppBabySdk;
  public static String a = "UniformDownloaderAppBabySdk";
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private ITMAssistantDownloadClientListener jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener = new UniformDownloaderAppBabySdk.4(this);
  private TMAssistantDownloadClient jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = null;
  private Map<String, UniformDownloaderAppBabySdk.DContext> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  private int a(String paramString, UniformDownloaderAppBabySdk.DContext paramDContext)
  {
    if ((paramDContext != null) && (paramString != null)) {
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
          return -2;
        }
        this.jdField_a_of_type_JavaUtilMap.put(paramString, paramDContext);
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[UniformDL][");
        localStringBuilder.append(paramDContext.jdField_a_of_type_Long);
        localStringBuilder.append("] addDownloadCtx...total:[");
        localStringBuilder.append(this.jdField_a_of_type_JavaUtilMap.size());
        localStringBuilder.append("] add it. url:[ ");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.i(str, 1, localStringBuilder.toString());
        return 0;
      }
    }
    return -1;
  }
  
  private UniformDownloaderAppBabySdk.DContext a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      paramString = (UniformDownloaderAppBabySdk.DContext)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      return paramString;
    }
  }
  
  public static UniformDownloaderAppBabySdk a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloaderAppBabySdk == null) {
        jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloaderAppBabySdk = new UniformDownloaderAppBabySdk();
      }
      UniformDownloaderAppBabySdk localUniformDownloaderAppBabySdk = jdField_a_of_type_ComTencentMobileqqUniformdownloadDownloaderUniformDownloaderAppBabySdk;
      return localUniformDownloaderAppBabySdk;
    }
    finally {}
  }
  
  private void a(UniformDownloaderAppBabySdk.DContext paramDContext, int paramInt, String paramString)
  {
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL] >>>handleDownloadSDKTaskStateFailed. errCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" errStr");
    localStringBuilder.append(paramString);
    QLog.e((String)localObject, 1, localStringBuilder.toString());
    UDConstants.a(2);
    int i;
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      i = 5;
    }
    else
    {
      if (601 == paramInt) {
        paramInt = 38;
      } else if (702 == paramInt) {
        paramInt = 23;
      } else if (600 == paramInt) {
        paramInt = 24;
      } else if (paramInt == 0) {
        paramInt = 25;
      } else if (704 == paramInt) {
        paramInt = 26;
      } else if (706 == paramInt) {
        paramInt = 27;
      } else if (709 == paramInt) {
        paramInt = 28;
      } else if (701 == paramInt) {
        paramInt = 29;
      } else if (707 == paramInt) {
        paramInt = 30;
      } else if (602 == paramInt) {
        paramInt = 31;
      } else if (705 == paramInt) {
        paramInt = 32;
      } else if (604 == paramInt) {
        paramInt = 39;
      } else if (603 == paramInt) {
        paramInt = 34;
      } else if (708 == paramInt) {
        paramInt = 35;
      } else if (700 == paramInt) {
        paramInt = 36;
      } else if (703 == paramInt) {
        paramInt = 37;
      } else {
        paramInt = 2;
      }
      long l;
      if (SystemUtil.a()) {
        l = SystemUtil.a();
      } else {
        l = SystemUtil.b();
      }
      l *= 1024L;
      i = paramInt;
      if (paramDContext != null)
      {
        i = paramInt;
        if (l < paramDContext.jdField_b_of_type_Long - paramDContext.a())
        {
          paramString = jdField_a_of_type_JavaLangString;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[UniformDL][");
          ((StringBuilder)localObject).append(paramDContext.jdField_a_of_type_Long);
          ((StringBuilder)localObject).append("] write file failed.  space is no enough:[");
          ((StringBuilder)localObject).append(paramDContext.jdField_b_of_type_Long);
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(paramDContext.a());
          ((StringBuilder)localObject).append(" ");
          ((StringBuilder)localObject).append(l);
          ((StringBuilder)localObject).append("]");
          QLog.e(paramString, 1, ((StringBuilder)localObject).toString());
          i = 9;
        }
      }
    }
    paramString = UDConstants.a(i);
    if ((paramDContext != null) && (paramDContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener != null))
    {
      localObject = new UniformDownloaderAppBabySdk.RParam(paramDContext.a(), paramDContext.a()).a();
      paramDContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener.a(i, paramString, (Bundle)localObject);
    }
  }
  
  private void a(String paramString)
  {
    e();
    UniformDownloaderAppBabySdk.DContext localDContext = a(paramString);
    Object localObject2;
    if (localDContext == null)
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[UniformDL] inPStartDownload. not found ctx.url:");
      ((StringBuilder)localObject2).append(paramString);
      QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return;
    }
    if (this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPStartDownload.client = null");
      if (localDContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener != null)
      {
        paramString = new UniformDownloaderAppBabySdk.RParam(0L, localDContext.a()).a();
        localDContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener.a(41, UDConstants.a(41), paramString);
      }
      return;
    }
    Object localObject1 = AppNetConnInfo.getRecentNetworkInfo();
    if (localObject1 != null) {
      localDContext.jdField_b_of_type_Int = ((NetworkInfo)localObject1).getType();
    }
    localObject1 = null;
    try
    {
      localObject2 = this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.getDownloadTaskState(paramString);
      localObject1 = localObject2;
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
    StringBuilder localStringBuilder;
    if ((localObject1 != null) && (((TMAssistantDownloadTaskInfo)localObject1).mState == 2))
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL] inPStartDownload.but it is downloading.url = ");
      localStringBuilder.append(paramString);
      QLog.w((String)localObject1, 1, localStringBuilder.toString());
      return;
    }
    int i = 0;
    try
    {
      int j = this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.startDownloadTask(paramString, "application/vnd.android.package-archive");
      i = j;
      localObject1 = jdField_a_of_type_JavaLangString;
      i = j;
      localStringBuilder = new StringBuilder();
      i = j;
      localStringBuilder.append("[UniformDL] inPStartDownload.startDownloadTask. url = ");
      i = j;
      localStringBuilder.append(paramString);
      i = j;
      QLog.i((String)localObject1, 1, localStringBuilder.toString());
      i = j;
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    if (i == 0)
    {
      b(paramString, localDContext);
      return;
    }
    if (4 == i)
    {
      a(paramString, localDContext);
      return;
    }
    a(paramString, localDContext, i);
  }
  
  private void a(String paramString, int paramInt)
  {
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL] inPRunABSdkDownloadCmd.cmd:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" url = ");
    localStringBuilder.append(paramString);
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          paramString = jdField_a_of_type_JavaLangString;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[UniformDL] inPRunABSdkDownloadCmd, errcmd: ");
          ((StringBuilder)localObject).append(paramInt);
          QLog.e(paramString, 1, ((StringBuilder)localObject).toString());
          return;
        }
        c(paramString);
        return;
      }
      b(paramString);
      return;
    }
    a(paramString);
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    Object localObject1 = a(paramString1);
    if (localObject1 == null)
    {
      paramString3 = jdField_a_of_type_JavaLangString;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[UniformDL] inPDownloadSDKTaskStateChanged. not found ctx.  state:[");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append("]errcode:[");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append("] errStr:[");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append("] url:[");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append("]");
      QLog.e(paramString3, 1, ((StringBuilder)localObject1).toString());
      return;
    }
    Object localObject2;
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3)
        {
          if (paramInt1 != 4)
          {
            if (paramInt1 != 5)
            {
              paramString3 = jdField_a_of_type_JavaLangString;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("[UniformDL] inPDownloadSDKTaskStateChanged  unkown state:[");
              ((StringBuilder)localObject1).append(paramInt1);
              ((StringBuilder)localObject1).append("]errcode:[");
              ((StringBuilder)localObject1).append(paramInt2);
              ((StringBuilder)localObject1).append("] errStr:[");
              ((StringBuilder)localObject1).append(paramString2);
              ((StringBuilder)localObject1).append("] url:[");
              ((StringBuilder)localObject1).append(paramString1);
              ((StringBuilder)localObject1).append("]");
              QLog.e(paramString3, 1, ((StringBuilder)localObject1).toString());
              return;
            }
            paramString3 = jdField_a_of_type_JavaLangString;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("[UniformDL] inPDownloadSDKTaskStateChanged  state:[FAILED] errcode:[");
            ((StringBuilder)localObject2).append(paramInt2);
            ((StringBuilder)localObject2).append("] errStr:[");
            ((StringBuilder)localObject2).append(paramString2);
            ((StringBuilder)localObject2).append("] url:[");
            ((StringBuilder)localObject2).append(paramString1);
            ((StringBuilder)localObject2).append("]");
            QLog.i(paramString3, 1, ((StringBuilder)localObject2).toString());
            ((UniformDownloaderAppBabySdk.DContext)localObject1).a(2);
            a((UniformDownloaderAppBabySdk.DContext)localObject1, paramInt2, paramString2);
            return;
          }
          localObject2 = jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[UniformDL] inPDownloadSDKTaskStateChanged  state:[SUCCEED] errcode:[");
          localStringBuilder.append(paramInt2);
          localStringBuilder.append("] errStr:[");
          localStringBuilder.append(paramString2);
          localStringBuilder.append("] url:[");
          localStringBuilder.append(paramString1);
          localStringBuilder.append("]");
          QLog.i((String)localObject2, 1, localStringBuilder.toString());
          ((UniformDownloaderAppBabySdk.DContext)localObject1).a(2);
          d(paramString1);
          if ((localObject1 != null) && (((UniformDownloaderAppBabySdk.DContext)localObject1).jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener != null))
          {
            paramString1 = new UniformDownloaderAppBabySdk.RParam(((UniformDownloaderAppBabySdk.DContext)localObject1).a(), ((UniformDownloaderAppBabySdk.DContext)localObject1).a()).a();
            ((UniformDownloaderAppBabySdk.DContext)localObject1).jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener.a(paramString3, paramString1);
          }
        }
        else
        {
          paramString3 = jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[UniformDL] inPDownloadSDKTaskStateChanged  state:[PAUSED] errcode:[");
          ((StringBuilder)localObject2).append(paramInt2);
          ((StringBuilder)localObject2).append("] errStr:[");
          ((StringBuilder)localObject2).append(paramString2);
          ((StringBuilder)localObject2).append("] url:[");
          ((StringBuilder)localObject2).append(paramString1);
          ((StringBuilder)localObject2).append("]");
          QLog.i(paramString3, 1, ((StringBuilder)localObject2).toString());
          ((UniformDownloaderAppBabySdk.DContext)localObject1).a(2);
          if ((localObject1 != null) && (((UniformDownloaderAppBabySdk.DContext)localObject1).jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener != null)) {
            ((UniformDownloaderAppBabySdk.DContext)localObject1).jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener.b(null);
          }
        }
      }
      else
      {
        paramString3 = jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[UniformDL] inPDownloadSDKTaskStateChanged  state:[DOWNLOADING] errcode:[");
        ((StringBuilder)localObject2).append(paramInt2);
        ((StringBuilder)localObject2).append("] errStr:[");
        ((StringBuilder)localObject2).append(paramString2);
        ((StringBuilder)localObject2).append("] url:[");
        ((StringBuilder)localObject2).append(paramString1);
        ((StringBuilder)localObject2).append("]");
        QLog.i(paramString3, 1, ((StringBuilder)localObject2).toString());
        if ((localObject1 != null) && (((UniformDownloaderAppBabySdk.DContext)localObject1).jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener != null)) {
          ((UniformDownloaderAppBabySdk.DContext)localObject1).jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener.a(null);
        }
      }
    }
    else
    {
      paramString3 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[UniformDL] inPDownloadSDKTaskStateChanged  state:[WAITING] errcode:[");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append("] errStr:[");
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append("] url:[");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append("]");
      QLog.i(paramString3, 1, ((StringBuilder)localObject2).toString());
      if ((localObject1 != null) && (((UniformDownloaderAppBabySdk.DContext)localObject1).jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener != null)) {
        ((UniformDownloaderAppBabySdk.DContext)localObject1).jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener.c(null);
      }
    }
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL] >>>inPPDwonloadSDKErr errcode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" errStr:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" url:");
    localStringBuilder.append(paramString1);
    QLog.e((String)localObject, 1, localStringBuilder.toString());
    localObject = a(paramString1);
    if (localObject == null)
    {
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL] inPDownloadSDKTaskStateFailed. not found ctx.  errcode:[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("] errStr:[");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("] url:[");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("]");
      QLog.e((String)localObject, 1, localStringBuilder.toString());
      return;
    }
    ((UniformDownloaderAppBabySdk.DContext)localObject).a(2);
    if (((UniformDownloaderAppBabySdk.DContext)localObject).jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener != null)
    {
      paramString1 = new UniformDownloaderAppBabySdk.RParam(((UniformDownloaderAppBabySdk.DContext)localObject).a(), ((UniformDownloaderAppBabySdk.DContext)localObject).a()).a();
      ((UniformDownloaderAppBabySdk.DContext)localObject).jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener.a(paramInt, paramString2, paramString1);
    }
  }
  
  private void a(String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 / (float)paramLong2 * 100.0F);
    Object localObject = a(paramString);
    if (localObject != null)
    {
      ((UniformDownloaderAppBabySdk.DContext)localObject).a(paramLong1);
      if (((UniformDownloaderAppBabySdk.DContext)localObject).jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener != null) {
        ((UniformDownloaderAppBabySdk.DContext)localObject).jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener.a(i, null);
      }
    }
    else
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL] inPDownloadSDKTaskProgressChanged. not found ctx, url: ");
      localStringBuilder.append(paramString);
      QLog.e((String)localObject, 1, localStringBuilder.toString());
    }
  }
  
  private void a(String paramString, UniformDownloaderAppBabySdk.DContext paramDContext)
  {
    Object localObject1 = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[UniformDL] inPStartDownload. file existed. sucess dricetly. url = ");
    ((StringBuilder)localObject2).append(paramString);
    QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    paramDContext.a(2);
    try
    {
      localObject2 = this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.getDownloadTaskState(paramString);
      d(paramString);
      paramDContext.a(paramDContext.jdField_b_of_type_Long);
      if (paramDContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener != null)
      {
        localObject1 = new UniformDownloaderAppBabySdk.RParam(0L, paramDContext.a()).a();
        paramDContext = paramDContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener;
        if (localObject2 == null) {
          paramString = null;
        } else {
          paramString = ((TMAssistantDownloadTaskInfo)localObject2).mSavePath;
        }
        paramDContext.a(paramString, (Bundle)localObject1);
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      if (paramDContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener != null)
      {
        paramString = new UniformDownloaderAppBabySdk.RParam(0L, paramDContext.a()).a();
        paramDContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener.a(20, UDConstants.a(20), paramString);
      }
    }
  }
  
  private void a(String paramString, UniformDownloaderAppBabySdk.DContext paramDContext, int paramInt)
  {
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL] inPStartDownload. task failed. result:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(". url = ");
    localStringBuilder.append(paramString);
    QLog.e((String)localObject, 1, localStringBuilder.toString());
    paramDContext.a(2);
    if (5 == paramInt)
    {
      paramInt = 16;
      paramString = "busy";
    }
    else if (1 == paramInt)
    {
      paramInt = 17;
      paramString = "net broken";
    }
    else if (2 == paramInt)
    {
      paramInt = 18;
      paramString = "set only for wifi";
    }
    else if (3 == paramInt)
    {
      paramInt = 19;
      paramString = "param err";
    }
    else
    {
      paramInt = 15;
      paramString = "start failed";
    }
    if (paramDContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener != null)
    {
      localObject = new UniformDownloaderAppBabySdk.RParam(0L, paramDContext.a()).a();
      paramDContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener.a(paramInt, paramString, (Bundle)localObject);
    }
  }
  
  private void b()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
      {
        this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("DL_ABSdkThread");
        this.jdField_a_of_type_AndroidOsHandlerThread.start();
        this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] >>>start thread:DL_ABSdkThread...");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void b(String paramString)
  {
    e();
    UniformDownloaderAppBabySdk.DContext localDContext = a(paramString);
    if (localDContext == null)
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL] inPPauseDownload. not found ctx.url:");
      localStringBuilder.append(paramString);
      QLog.e((String)localObject, 1, localStringBuilder.toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient;
    if (localObject == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPPauseDownload.client = null");
      if ((localDContext != null) && (localDContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener != null))
      {
        paramString = new UniformDownloaderAppBabySdk.RParam(0L, localDContext.a()).a();
        localDContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener.a(41, UDConstants.a(41), paramString);
      }
      return;
    }
    Bundle localBundle;
    try
    {
      localObject = ((TMAssistantDownloadClient)localObject).getDownloadTaskState(paramString);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if ((localDContext != null) && (localDContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener != null))
      {
        localBundle = new UniformDownloaderAppBabySdk.RParam(localDContext.a(), localDContext.a()).a();
        localDContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener.a(20, UDConstants.a(20), localBundle);
      }
      localBundle = null;
    }
    if (localBundle != null)
    {
      try
      {
        this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.pauseDownloadTask(paramString);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        if (localDContext == null) {
          return;
        }
      }
      if (localDContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener != null)
      {
        paramString = new UniformDownloaderAppBabySdk.RParam(localDContext.a(), localDContext.a()).a();
        localDContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener.a(21, UDConstants.a(21), paramString);
      }
    }
    else
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPPauseDownload. no run load");
      if ((localDContext != null) && (localDContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener != null)) {
        localDContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener.b(null);
      }
    }
  }
  
  private void b(String paramString, UniformDownloaderAppBabySdk.DContext paramDContext)
  {
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL] inPStartDownload success.. url = ");
    localStringBuilder.append(paramString);
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    try
    {
      localObject = this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.getDownloadTaskState(paramString);
      if ((paramDContext != null) && (localObject != null))
      {
        long l = ((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen;
        paramDContext.a(l);
        paramDContext = jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[UniformDL] inPStartDownload success. rSize:");
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append(" url = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.i(paramDContext, 1, ((StringBuilder)localObject).toString());
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      if ((paramDContext != null) && (paramDContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener != null))
      {
        paramString = new UniformDownloaderAppBabySdk.RParam(0L, paramDContext.a()).a();
        paramDContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener.a(20, UDConstants.a(20), paramString);
      }
    }
  }
  
  private void c()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
      {
        this.jdField_a_of_type_AndroidOsHandlerThread.getLooper().quit();
        this.jdField_a_of_type_AndroidOsHandlerThread = null;
        this.jdField_a_of_type_AndroidOsHandler = null;
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] >>>stop thread:DL_ABSdkThread...");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void c(String paramString)
  {
    e();
    Object localObject2 = this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient;
    if (localObject2 == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPStopDownload.client = null");
      return;
    }
    Object localObject1 = null;
    try
    {
      localObject2 = ((TMAssistantDownloadClient)localObject2).getDownloadTaskState(paramString);
      localObject1 = localObject2;
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
    }
    if (localObject1 != null) {
      try
      {
        this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.cancelDownloadTask(paramString);
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
    } else {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] inPStopDownload. no run load");
    }
    d(paramString);
  }
  
  private int d(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      UniformDownloaderAppBabySdk.DContext localDContext = (UniformDownloaderAppBabySdk.DContext)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      int i = this.jdField_a_of_type_JavaUtilMap.size();
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL][");
      localStringBuilder.append(localDContext.jdField_a_of_type_Long);
      localStringBuilder.append("] delDownloadCtx...total:[");
      localStringBuilder.append(i);
      localStringBuilder.append("] add it. url:[ ");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.i(str, 1, localStringBuilder.toString());
      return i;
    }
  }
  
  private void d()
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      int i = this.jdField_a_of_type_JavaUtilMap.size();
      if (i == 0)
      {
        c();
        a();
      }
      return;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient == null)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "[UniformDL] >>>create ABSdkClient...");
      this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = TMAssistantDownloadManager.getInstance(BaseApplication.getContext()).getDownloadSDKClient("UF_DL_CLIENT");
      this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.registerDownloadTaskListener(this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener);
    }
  }
  
  private void f()
  {
    QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] >>>inPDwonloadSDKServiceInvalid service invalid ");
    a();
    Object localObject2 = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      Object localObject4 = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((List)localObject2).add((UniformDownloaderAppBabySdk.DContext)((Iterator)localObject4).next());
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
      ??? = ((List)localObject2).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (UniformDownloaderAppBabySdk.DContext)((Iterator)???).next();
        if ((localObject2 != null) && (((UniformDownloaderAppBabySdk.DContext)localObject2).jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener != null))
        {
          localObject4 = new UniformDownloaderAppBabySdk.RParam(((UniformDownloaderAppBabySdk.DContext)localObject2).a(), ((UniformDownloaderAppBabySdk.DContext)localObject2).a()).a();
          ((UniformDownloaderAppBabySdk.DContext)localObject2).jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener.a(10, UDConstants.a(10), (Bundle)localObject4);
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  public int a(long paramLong1, String paramString, long paramLong2, IUniformDownloaderAppBabyListener paramIUniformDownloaderAppBabyListener)
  {
    if (paramString == null)
    {
      paramString = jdField_a_of_type_JavaLangString;
      paramIUniformDownloaderAppBabyListener = new StringBuilder();
      paramIUniformDownloaderAppBabyListener.append("[UniformDL] [");
      paramIUniformDownloaderAppBabyListener.append(paramLong1);
      paramIUniformDownloaderAppBabyListener.append("] initADownload, url = null");
      QLog.e(paramString, 1, paramIUniformDownloaderAppBabyListener.toString());
      return -1;
    }
    UniformDownloaderAppBabySdk.DContext localDContext = new UniformDownloaderAppBabySdk.DContext(this, paramLong1, paramString, paramLong2);
    localDContext.jdField_a_of_type_ComTencentMobileqqUniformdownloadUtilIUniformDownloaderAppBabyListener = paramIUniformDownloaderAppBabyListener;
    int i = a(paramString, localDContext);
    if (i != 0)
    {
      paramString = jdField_a_of_type_JavaLangString;
      paramIUniformDownloaderAppBabyListener = new StringBuilder();
      paramIUniformDownloaderAppBabyListener.append("[UniformDL]  [");
      paramIUniformDownloaderAppBabyListener.append(paramLong1);
      paramIUniformDownloaderAppBabyListener.append("] initADownload failed:");
      paramIUniformDownloaderAppBabyListener.append(i);
      QLog.w(paramString, 1, paramIUniformDownloaderAppBabyListener.toString());
      return -2;
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    Object localObject1 = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[UniformDL] startADownload.url = ");
    ((StringBuilder)localObject2).append(paramString);
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    if (paramString == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] startADownload, url = null");
      return -1;
    }
    localObject1 = a(paramString);
    if (localObject1 == null)
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[UniformDL] startADownload, not exsit download,url = ");
      ((StringBuilder)localObject2).append(paramString);
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return -2;
    }
    ((UniformDownloaderAppBabySdk.DContext)localObject1).a(1);
    b();
    if (!this.jdField_a_of_type_AndroidOsHandler.post(new UniformDownloaderAppBabySdk.1(this, paramString)))
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL] startADownload.post failed url = ");
      localStringBuilder.append(paramString);
      QLog.i((String)localObject2, 1, localStringBuilder.toString());
      ((UniformDownloaderAppBabySdk.DContext)localObject1).a(2);
      return -3;
    }
    return 0;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient != null)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL] >>>release ABSdkClient...");
      this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient.unRegisterDownloadTaskListener(this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener);
      this.jdField_a_of_type_ComTencentTmdownloaderTMAssistantDownloadClient = null;
      TMAssistantDownloadManager.getInstance(BaseApplication.getContext()).releaseDownloadSDKClient("UF_DL_CLIENT");
      return;
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "[UniformDL] releaseABSdkClient. client had be stoped");
  }
  
  public boolean a(String paramString)
  {
    return a(paramString) != null;
  }
  
  public int b(String paramString)
  {
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL] puaseADownload.url = ");
    localStringBuilder.append(paramString);
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    if (paramString == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] puaseADownload, url = null");
      return -1;
    }
    localObject = a(paramString);
    if (localObject == null)
    {
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL] puaseADownload, not exsit download,url = ");
      localStringBuilder.append(paramString);
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      return -2;
    }
    ((UniformDownloaderAppBabySdk.DContext)localObject).a(2);
    b();
    if (!this.jdField_a_of_type_AndroidOsHandler.post(new UniformDownloaderAppBabySdk.2(this, paramString)))
    {
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL] puaseADownload.post failed url = ");
      localStringBuilder.append(paramString);
      QLog.i((String)localObject, 1, localStringBuilder.toString());
      return -3;
    }
    return 0;
  }
  
  public int c(String paramString)
  {
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[UniformDL] stopADownload.url = ");
    localStringBuilder.append(paramString);
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    if (paramString == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[UniformDL] stopADownload, url = null");
      return -1;
    }
    localObject = a(paramString);
    if (localObject == null)
    {
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL] stopADownload, not exsit download,url = ");
      localStringBuilder.append(paramString);
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      return 0;
    }
    ((UniformDownloaderAppBabySdk.DContext)localObject).a(2);
    b();
    if (!this.jdField_a_of_type_AndroidOsHandler.post(new UniformDownloaderAppBabySdk.3(this, paramString)))
    {
      d(paramString);
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[UniformDL] stopADownload, post failed,url = ");
      localStringBuilder.append(paramString);
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.downloader.UniformDownloaderAppBabySdk
 * JD-Core Version:    0.7.0.1
 */