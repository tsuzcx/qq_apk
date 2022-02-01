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
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("resumeRawSend ,key:");
          localStringBuilder.append(paramString.getKey());
          QLog.d("raw_photo", 2, localStringBuilder.toString());
        }
        return true;
      }
    }
    return false;
  }
  
  public boolean pauseAllRawSend()
  {
    this.lastPasueKeys.clear();
    Object localObject1 = ((ITransFileController)this.app.getRuntimeService(ITransFileController.class, "")).getProcessMap().entrySet().iterator();
    for (boolean bool = false; ((Iterator)localObject1).hasNext(); bool = true)
    {
      label37:
      Object localObject2 = (IHttpCommunicatorListener)((Map.Entry)((Iterator)localObject1).next()).getValue();
      if ((localObject2 == null) || (!(localObject2 instanceof BaseTransProcessor))) {
        break label37;
      }
      localObject2 = (BaseTransProcessor)localObject2;
      if ((!((BaseTransProcessor)localObject2).mIsRawPic) || (((BaseTransProcessor)localObject2).mIsPause)) {
        break label37;
      }
      ((BaseTransProcessor)localObject2).pause();
      if (((BaseTransProcessor)localObject2).getKey() != null) {
        this.lastPasueKeys.add(((BaseTransProcessor)localObject2).getKey());
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("pauseAllRawSend key:");
        localStringBuilder.append(((BaseTransProcessor)localObject2).getKey());
        QLog.d("raw_photo", 2, localStringBuilder.toString());
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("pauseAllRawSend result:");
      ((StringBuilder)localObject1).append(bool);
      QLog.d("raw_photo", 2, ((StringBuilder)localObject1).toString());
    }
    return bool;
  }
  
  public boolean pauseAllShortVideoReceive()
  {
    Object localObject1 = ((ITransFileController)this.app.getRuntimeService(ITransFileController.class, "")).getProcessMap().entrySet().iterator();
    StringBuilder localStringBuilder = new StringBuilder();
    for (boolean bool = false; ((Iterator)localObject1).hasNext(); bool = true)
    {
      label38:
      Object localObject2 = (IHttpCommunicatorListener)((Map.Entry)((Iterator)localObject1).next()).getValue();
      if ((localObject2 == null) || (!(localObject2 instanceof BaseTransProcessor))) {
        break label38;
      }
      localObject2 = (BaseTransProcessor)localObject2;
      if ((!((BaseTransProcessor)localObject2).mIsShortVideoReceive) || (((BaseTransProcessor)localObject2).mIsPause)) {
        break label38;
      }
      ((BaseTransProcessor)localObject2).pause();
      if (((BaseTransProcessor)localObject2).getKey() != null) {
        this.lastPasueKeysForShortVideo.add(((BaseTransProcessor)localObject2).getKey());
      }
      localStringBuilder.append(((BaseTransProcessor)localObject2).getKey());
      localStringBuilder.append(",");
    }
    if ((localStringBuilder.length() > 0) && (QLog.isColorLevel()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("pauseAllShortVideoReceive key:");
      ((StringBuilder)localObject1).append(localStringBuilder);
      QLog.d("short_video", 2, ((StringBuilder)localObject1).toString());
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("pauseAllShortVideoReceive result:");
      localStringBuilder.append(bool);
      QLog.d("short_video", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public boolean pauseAllShortVideoSend()
  {
    Object localObject1 = ((ITransFileController)this.app.getRuntimeService(ITransFileController.class, "")).getProcessMap().entrySet().iterator();
    for (boolean bool = false; ((Iterator)localObject1).hasNext(); bool = true)
    {
      label30:
      Object localObject2 = (IHttpCommunicatorListener)((Map.Entry)((Iterator)localObject1).next()).getValue();
      if ((localObject2 == null) || (!(localObject2 instanceof BaseTransProcessor))) {
        break label30;
      }
      localObject2 = (BaseTransProcessor)localObject2;
      if ((!((BaseTransProcessor)localObject2).mIsShortVideoSend) || (((BaseTransProcessor)localObject2).mIsPause)) {
        break label30;
      }
      ((BaseTransProcessor)localObject2).pause();
      if (((BaseTransProcessor)localObject2).getKey() != null) {
        this.lastPasueKeysForShortVideo.add(((BaseTransProcessor)localObject2).getKey());
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("pauseAllShortVideoSend key:");
        localStringBuilder.append(((BaseTransProcessor)localObject2).getKey());
        QLog.d("short_video", 2, localStringBuilder.toString());
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("pauseAllShortVideoSend result:");
      ((StringBuilder)localObject1).append(bool);
      QLog.d("short_video", 2, ((StringBuilder)localObject1).toString());
    }
    return bool;
  }
  
  public void resumeLastRawSend()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("resumeLastRawSend keys size:");
      ((StringBuilder)localObject).append(this.lastPasueKeys.size());
      QLog.d("raw_photo", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.lastPasueKeys.iterator();
    while (((Iterator)localObject).hasNext()) {
      resumeRawSend((String)((Iterator)localObject).next());
    }
  }
  
  public void resumeLastShortVideoTransfer()
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("resumeLastShortVideoSend keys size:");
      localStringBuilder.append(this.lastPasueKeysForShortVideo.size());
      QLog.d("short_video", 2, localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = this.lastPasueKeysForShortVideo.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = ((ITransFileController)this.app.getRuntimeService(ITransFileController.class, "")).findProcessor((String)localObject2);
      if ((localObject2 != null) && ((localObject2 instanceof BaseTransProcessor)))
      {
        localObject2 = (BaseTransProcessor)localObject2;
        if (((BaseTransProcessor)localObject2).mIsPause)
        {
          ((BaseTransProcessor)localObject2).resume();
          localStringBuilder.append(((BaseTransProcessor)localObject2).getKey());
          localStringBuilder.append(",");
        }
      }
    }
    if ((localStringBuilder.length() > 0) && (QLog.isColorLevel()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("resumeLastShortVideoSend , key: ");
      ((StringBuilder)localObject1).append(localStringBuilder);
      QLog.d("short_video", 2, ((StringBuilder)localObject1).toString());
    }
    this.lastPasueKeysForShortVideo.clear();
  }
  
  public boolean resumeRawSend(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    return resumeRawSend(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.api.TransFileControllerBusHelper
 * JD-Core Version:    0.7.0.1
 */