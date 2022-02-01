package com.tencent.mobileqq.transfile.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TransFileControllerBusHelper
{
  private AppInterface app;
  ArrayList<String> lastPasueKeys = new ArrayList();
  ArrayList<String> lastPasueKeysForShortVideo = new ArrayList();
  
  public TransFileControllerBusHelper(AppInterface paramAppInterface)
  {
    this.app = paramAppInterface;
  }
  
  public static int findProcessorFileStatus(AppInterface paramAppInterface, String paramString1, String paramString2, long paramLong)
  {
    paramString1 = BaseTransFileController.makeKey(paramString1, paramLong);
    paramAppInterface = ((ITransFileController)paramAppInterface.getRuntimeService(ITransFileController.class, "")).findProcessor(paramString1);
    if ((paramAppInterface instanceof BaseTransProcessor)) {
      return (int)((BaseTransProcessor)paramAppInterface).getFileStatus();
    }
    return -1;
  }
  
  private boolean resumeRawSend(String paramString)
  {
    paramString = ((ITransFileController)this.app.getRuntimeService(ITransFileController.class, "")).findProcessor(paramString);
    if ((paramString != null) && ((paramString instanceof BaseTransProcessor)))
    {
      paramString = (BaseTransProcessor)paramString;
      if ((paramString.mIsRawPic) && (paramString.mIsPause))
      {
        paramString.resume();
        if (QLog.isColorLevel()) {
          QLog.d("raw_photo", 2, "resumeRawSend ,key:" + paramString.getKey());
        }
        return true;
      }
    }
    return false;
  }
  
  public boolean pauseAllRawSend()
  {
    boolean bool = false;
    this.lastPasueKeys.clear();
    Iterator localIterator = ((ITransFileController)this.app.getRuntimeService(ITransFileController.class, "")).getProcessMap().entrySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof BaseTransProcessor))) {
        break label189;
      }
      localObject = (BaseTransProcessor)localObject;
      if ((!((BaseTransProcessor)localObject).mIsRawPic) || (((BaseTransProcessor)localObject).mIsPause)) {
        break label189;
      }
      ((BaseTransProcessor)localObject).pause();
      if (((BaseTransProcessor)localObject).getKey() != null) {
        this.lastPasueKeys.add(((BaseTransProcessor)localObject).getKey());
      }
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "pauseAllRawSend key:" + ((BaseTransProcessor)localObject).getKey());
      }
      bool = true;
    }
    label189:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "pauseAllRawSend result:" + bool);
      }
      return bool;
    }
  }
  
  public boolean pauseAllShortVideoReceive()
  {
    boolean bool = false;
    Iterator localIterator = ((ITransFileController)this.app.getRuntimeService(ITransFileController.class, "")).getProcessMap().entrySet().iterator();
    StringBuilder localStringBuilder = new StringBuilder();
    if (localIterator.hasNext())
    {
      Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof BaseTransProcessor))) {
        break label221;
      }
      localObject = (BaseTransProcessor)localObject;
      if ((!((BaseTransProcessor)localObject).mIsShortVideoReceive) || (((BaseTransProcessor)localObject).mIsPause)) {
        break label221;
      }
      ((BaseTransProcessor)localObject).pause();
      if (((BaseTransProcessor)localObject).getKey() != null) {
        this.lastPasueKeysForShortVideo.add(((BaseTransProcessor)localObject).getKey());
      }
      localStringBuilder.append(((BaseTransProcessor)localObject).getKey());
      localStringBuilder.append(",");
      bool = true;
    }
    label221:
    for (;;)
    {
      break;
      if ((localStringBuilder.length() > 0) && (QLog.isColorLevel())) {
        QLog.d("short_video", 2, "pauseAllShortVideoReceive key:" + localStringBuilder);
      }
      if (QLog.isColorLevel()) {
        QLog.d("short_video", 2, "pauseAllShortVideoReceive result:" + bool);
      }
      return bool;
    }
  }
  
  public boolean pauseAllShortVideoSend()
  {
    boolean bool = false;
    Iterator localIterator = ((ITransFileController)this.app.getRuntimeService(ITransFileController.class, "")).getProcessMap().entrySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (IHttpCommunicatorListener)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof BaseTransProcessor))) {
        break label182;
      }
      localObject = (BaseTransProcessor)localObject;
      if ((!((BaseTransProcessor)localObject).mIsShortVideoSend) || (((BaseTransProcessor)localObject).mIsPause)) {
        break label182;
      }
      ((BaseTransProcessor)localObject).pause();
      if (((BaseTransProcessor)localObject).getKey() != null) {
        this.lastPasueKeysForShortVideo.add(((BaseTransProcessor)localObject).getKey());
      }
      if (QLog.isColorLevel()) {
        QLog.d("short_video", 2, "pauseAllShortVideoSend key:" + ((BaseTransProcessor)localObject).getKey());
      }
      bool = true;
    }
    label182:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("short_video", 2, "pauseAllShortVideoSend result:" + bool);
      }
      return bool;
    }
  }
  
  public void resumeLastRawSend()
  {
    if (QLog.isColorLevel()) {
      QLog.d("raw_photo", 2, "resumeLastRawSend keys size:" + this.lastPasueKeys.size());
    }
    Iterator localIterator = this.lastPasueKeys.iterator();
    while (localIterator.hasNext()) {
      resumeRawSend((String)localIterator.next());
    }
  }
  
  public void resumeLastShortVideoTransfer()
  {
    if (QLog.isColorLevel()) {
      QLog.d("short_video", 2, "resumeLastShortVideoSend keys size:" + this.lastPasueKeysForShortVideo.size());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.lastPasueKeysForShortVideo.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = ((ITransFileController)this.app.getRuntimeService(ITransFileController.class, "")).findProcessor((String)localObject);
      if ((localObject != null) && ((localObject instanceof BaseTransProcessor)))
      {
        localObject = (BaseTransProcessor)localObject;
        if (((BaseTransProcessor)localObject).mIsPause)
        {
          ((BaseTransProcessor)localObject).resume();
          localStringBuilder.append(((BaseTransProcessor)localObject).getKey());
          localStringBuilder.append(",");
        }
      }
    }
    if ((localStringBuilder.length() > 0) && (QLog.isColorLevel())) {
      QLog.d("short_video", 2, "resumeLastShortVideoSend , key: " + localStringBuilder);
    }
    this.lastPasueKeysForShortVideo.clear();
  }
  
  public boolean resumeRawSend(String paramString1, String paramString2)
  {
    return resumeRawSend(paramString1 + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.api.TransFileControllerBusHelper
 * JD-Core Version:    0.7.0.1
 */