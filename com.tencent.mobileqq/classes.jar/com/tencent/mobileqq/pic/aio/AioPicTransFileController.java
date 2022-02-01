package com.tencent.mobileqq.pic.aio;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor;
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
    if ((paramString == null) || (paramLong == 0L)) {}
    for (;;)
    {
      return;
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
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel pic:" + ((BaseTransProcessor)localObject).mUiRequest.mUniseq);
            }
          }
        }
      }
    }
  }
  
  public static void a(String paramString, TransFileControllerImpl.OnCancelListener paramOnCancelListener)
  {
    if (paramString == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
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
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel pic:" + ((BaseTransProcessor)localObject).mUiRequest.mUniseq);
            }
            if (((BaseTransProcessor)localObject).mUiRequest.mRec != null) {
              localArrayList.add(((BaseTransProcessor)localObject).mUiRequest.mRec);
            }
          }
        }
      }
    } while (paramOnCancelListener == null);
    paramOnCancelListener.onCancel(localArrayList);
  }
  
  private static boolean a(IHttpCommunicatorListener paramIHttpCommunicatorListener)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIHttpCommunicatorListener != null) {
      if (!(paramIHttpCommunicatorListener instanceof C2CPicUploadProcessor))
      {
        bool1 = bool2;
        if (!(paramIHttpCommunicatorListener instanceof GroupPicUploadProcessor)) {}
      }
      else
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
  
  public void a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
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
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "resume pic:" + ((BaseTransProcessor)localObject).mUiRequest.mUniseq);
            }
          }
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    Iterator localIterator = a().entrySet().iterator();
    boolean bool1;
    for (boolean bool2 = false; localIterator.hasNext(); bool2 = bool1)
    {
      Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
      bool1 = bool2;
      if (a((IHttpCommunicatorListener)localObject))
      {
        localObject = (BaseTransProcessor)localObject;
        bool1 = bool2;
        if (paramString.equals(((BaseTransProcessor)localObject).mUiRequest.mPeerUin))
        {
          bool1 = bool2;
          if (!((BaseTransProcessor)localObject).mIsPause)
          {
            ((BaseTransProcessor)localObject).pause();
            bool2 = true;
            bool1 = bool2;
            if (QLog.isColorLevel())
            {
              QLog.d("cancelpic", 2, "pause pic:" + ((BaseTransProcessor)localObject).mUiRequest.mUniseq);
              bool1 = bool2;
            }
          }
        }
      }
    }
    return bool2;
  }
  
  public boolean b(String paramString)
  {
    if (paramString == null) {}
    label88:
    label89:
    for (;;)
    {
      return false;
      Iterator localIterator = a().entrySet().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        IHttpCommunicatorListener localIHttpCommunicatorListener = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
        if ((!a(localIHttpCommunicatorListener)) || (!paramString.equals(((BaseTransProcessor)localIHttpCommunicatorListener).mUiRequest.mPeerUin))) {
          break label88;
        }
        i += 1;
      }
      for (;;)
      {
        break;
        if (i <= 1) {
          break label89;
        }
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.aio.AioPicTransFileController
 * JD-Core Version:    0.7.0.1
 */