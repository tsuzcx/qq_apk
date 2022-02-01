package com.tencent.mobileqq.video;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.api.IShortVideoForwardProcessor;
import com.tencent.mobileqq.shortvideo.api.IShortVideoUploadProcessor;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.ShortVideoDownloadProcessor;
import com.tencent.mobileqq.transfile.api.ITransFileController;

public class AioVideoTransFileController
{
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(paramLong);
      paramString = localStringBuilder.toString();
      paramQQAppInterface = ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(paramString);
      if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof ShortVideoDownloadProcessor)))
      {
        ((ShortVideoDownloadProcessor)paramQQAppInterface).pause();
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    boolean bool = false;
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(paramLong);
      localObject = ((StringBuilder)localObject).toString();
      paramQQAppInterface = (ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class);
      if (paramQQAppInterface.containsProcessor(paramString, paramLong))
      {
        paramQQAppInterface = paramQQAppInterface.findProcessor((String)localObject);
        if (paramQQAppInterface != null) {
          if ((paramQQAppInterface instanceof IShortVideoUploadProcessor)) {
            ((BaseTransProcessor)paramQQAppInterface).pause();
          } else if ((paramQQAppInterface instanceof IShortVideoForwardProcessor)) {
            ((BaseTransProcessor)paramQQAppInterface).pause();
          }
        }
        bool = true;
      }
      return bool;
    }
    finally {}
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    boolean bool2 = false;
    try
    {
      paramQQAppInterface = (ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(paramLong);
      localObject = ((StringBuilder)localObject).toString();
      boolean bool1 = bool2;
      if (paramQQAppInterface.containsProcessor(paramString, paramLong))
      {
        paramQQAppInterface = paramQQAppInterface.findProcessor((String)localObject);
        bool1 = bool2;
        if ((paramQQAppInterface instanceof IShortVideoUploadProcessor))
        {
          bool1 = bool2;
          if (((BaseTransProcessor)paramQQAppInterface).isPause())
          {
            ((BaseTransProcessor)paramQQAppInterface).resume();
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(paramLong);
      localObject = ((StringBuilder)localObject).toString();
      paramQQAppInterface = (ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class);
      if (paramQQAppInterface.containsProcessor(paramString, paramLong))
      {
        paramString = paramQQAppInterface.findProcessor((String)localObject);
        if (paramString != null) {
          if ((paramString instanceof IShortVideoUploadProcessor)) {
            ((BaseTransProcessor)paramString).pause();
          } else if ((paramString instanceof IShortVideoForwardProcessor)) {
            ((BaseTransProcessor)paramString).pause();
          }
        }
        paramQQAppInterface.removeProcessor((String)localObject);
        return true;
      }
      return false;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.video.AioVideoTransFileController
 * JD-Core Version:    0.7.0.1
 */