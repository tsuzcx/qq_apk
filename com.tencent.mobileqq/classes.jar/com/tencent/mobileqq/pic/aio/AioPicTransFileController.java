package com.tencent.mobileqq.pic.aio;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.api.IPicTransFile.IPicUploadPro;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl.OnCancelListener;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public class AioPicTransFileController
{
  static ConcurrentHashMap<String, IHttpCommunicatorListener> a()
  {
    return ((ITransFileController)((QQAppInterface)MobileQQ.sMobileQQ.peekAppRuntime()).getRuntimeService(ITransFileController.class)).getProcessMap();
  }
  
  public static void a(String paramString, long paramLong)
  {
    if (paramString != null)
    {
      if (paramLong == 0L) {
        return;
      }
      Iterator localIterator = a().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
        if (a((IHttpCommunicatorListener)localObject))
        {
          localObject = (BaseTransProcessor)localObject;
          if ((paramString.equals(((BaseTransProcessor)localObject).mUiRequest.mPeerUin)) && (paramLong == ((BaseTransProcessor)localObject).mUiRequest.mUniseq))
          {
            ((BaseTransProcessor)localObject).cancel();
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("cancel pic:");
              localStringBuilder.append(((BaseTransProcessor)localObject).mUiRequest.mUniseq);
              QLog.d("cancelpic", 2, localStringBuilder.toString());
            }
          }
        }
      }
    }
  }
  
  public static void a(String paramString, TransFileControllerImpl.OnCancelListener paramOnCancelListener)
  {
    if (paramString == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = a().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
      if (a((IHttpCommunicatorListener)localObject))
      {
        localObject = (BaseTransProcessor)localObject;
        if ((paramString.equals(((BaseTransProcessor)localObject).mUiRequest.mPeerUin)) && (((BaseTransProcessor)localObject).isPause()))
        {
          ((BaseTransProcessor)localObject).cancel();
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("cancel pic:");
            localStringBuilder.append(((BaseTransProcessor)localObject).mUiRequest.mUniseq);
            QLog.d("cancelpic", 2, localStringBuilder.toString());
          }
          if (((BaseTransProcessor)localObject).mUiRequest.mRec != null) {
            localArrayList.add(((BaseTransProcessor)localObject).mUiRequest.mRec);
          }
        }
      }
    }
    if (paramOnCancelListener != null) {
      paramOnCancelListener.onCancel(localArrayList);
    }
  }
  
  private static boolean a(IHttpCommunicatorListener paramIHttpCommunicatorListener)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIHttpCommunicatorListener != null)
    {
      bool1 = bool2;
      if ((paramIHttpCommunicatorListener instanceof IPicTransFile.IPicUploadPro))
      {
        paramIHttpCommunicatorListener = (BaseTransProcessor)paramIHttpCommunicatorListener;
        bool1 = bool2;
        if (paramIHttpCommunicatorListener.getFileStatus() != 1003L)
        {
          bool1 = bool2;
          if (paramIHttpCommunicatorListener.getLastFileStatus() != 1003L) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean a(String paramString)
  {
    boolean bool1 = false;
    if (paramString == null) {
      return false;
    }
    Iterator localIterator = a().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
      if (a((IHttpCommunicatorListener)localObject))
      {
        localObject = (BaseTransProcessor)localObject;
        if ((paramString.equals(((BaseTransProcessor)localObject).mUiRequest.mPeerUin)) && (!((BaseTransProcessor)localObject).mIsPause))
        {
          ((BaseTransProcessor)localObject).pause();
          boolean bool2 = true;
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("pause pic:");
            localStringBuilder.append(((BaseTransProcessor)localObject).mUiRequest.mUniseq);
            QLog.d("cancelpic", 2, localStringBuilder.toString());
            bool1 = bool2;
          }
        }
      }
    }
    return bool1;
  }
  
  public void b(String paramString)
  {
    if (paramString == null) {
      return;
    }
    Iterator localIterator = a().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
      if (a((IHttpCommunicatorListener)localObject))
      {
        localObject = (BaseTransProcessor)localObject;
        if ((paramString.equals(((BaseTransProcessor)localObject).mUiRequest.mPeerUin)) && (((BaseTransProcessor)localObject).mIsPause))
        {
          ((BaseTransProcessor)localObject).resume();
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("resume pic:");
            localStringBuilder.append(((BaseTransProcessor)localObject).mUiRequest.mUniseq);
            QLog.d("cancelpic", 2, localStringBuilder.toString());
          }
        }
      }
    }
  }
  
  public boolean c(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    Iterator localIterator = a().entrySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      IHttpCommunicatorListener localIHttpCommunicatorListener = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
      if ((a(localIHttpCommunicatorListener)) && (paramString.equals(((BaseTransProcessor)localIHttpCommunicatorListener).mUiRequest.mPeerUin))) {
        i += 1;
      }
    }
    return i > 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.aio.AioPicTransFileController
 * JD-Core Version:    0.7.0.1
 */