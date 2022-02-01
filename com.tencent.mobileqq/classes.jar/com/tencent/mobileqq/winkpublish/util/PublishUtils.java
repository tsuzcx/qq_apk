package com.tencent.mobileqq.winkpublish.util;

import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.biz.qcircleshadow.lib.QCircleHostVideoHelper;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools;
import com.tencent.mobileqq.winkpublish.model.ImageInfo;
import com.tencent.mobileqq.winkpublish.model.MediaWrapper;
import com.tencent.mobileqq.winkpublish.model.ShuoshuoVideoInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class PublishUtils
{
  public static ArrayList<MediaWrapper> a(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (!TextUtils.isEmpty(str))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("wrapperImage2Media, path:");
          localStringBuilder.append(str);
          QLog.e("[upload2] [PublishUtils]", 1, localStringBuilder.toString());
          localArrayList.add(new MediaWrapper(new ImageInfo(str)));
        }
      }
    }
    return localArrayList;
  }
  
  public static boolean a()
  {
    boolean bool;
    if ((QCircleHostVideoHelper.getTrimSupportIsAvailable()) && (b())) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("check VideoCompressEnv: ");
    localStringBuilder.append(bool);
    QLog.i("[upload2] [PublishUtils]", 1, localStringBuilder.toString());
    return bool;
  }
  
  public static boolean a(ShuoshuoVideoInfo paramShuoshuoVideoInfo)
  {
    boolean bool2 = false;
    if (paramShuoshuoVideoInfo == null) {
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("upload2_canUploadWithoutCompress videoPath:");
    ((StringBuilder)localObject).append(paramShuoshuoVideoInfo.b);
    ((StringBuilder)localObject).append(", startTime:");
    ((StringBuilder)localObject).append(paramShuoshuoVideoInfo.o);
    ((StringBuilder)localObject).append(", endTime:");
    ((StringBuilder)localObject).append(paramShuoshuoVideoInfo.p);
    ((StringBuilder)localObject).append(", totalDuration:");
    ((StringBuilder)localObject).append(paramShuoshuoVideoInfo.t);
    QLog.i("[upload2] [PublishUtils]", 1, ((StringBuilder)localObject).toString());
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramShuoshuoVideoInfo.b))
    {
      localObject = new File(paramShuoshuoVideoInfo.b);
      bool1 = bool2;
      if (((File)localObject).exists())
      {
        bool1 = bool2;
        if (!((File)localObject).isDirectory())
        {
          bool1 = bool2;
          if (paramShuoshuoVideoInfo.o == 0L)
          {
            bool1 = bool2;
            if (paramShuoshuoVideoInfo.f == paramShuoshuoVideoInfo.t) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = new File(paramString);
    return (paramString.exists()) && (paramString.isDirectory());
  }
  
  public static int b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    paramString = MimeTypesTools.getMimeType(FSTransUtils.e(), paramString);
    if (TextUtils.isEmpty(paramString)) {
      return -1;
    }
    paramString = HostStaticInvokeHelper.getMimeType(paramString);
    if (paramString == null) {
      return -1;
    }
    return ((Integer)AlbumUtil.a.get(paramString[0])).intValue();
  }
  
  public static boolean b()
  {
    return QCircleHostVideoHelper.checkAndLoadAVCodec();
  }
  
  public static boolean b(ShuoshuoVideoInfo paramShuoshuoVideoInfo)
  {
    if (paramShuoshuoVideoInfo == null)
    {
      QLog.e("[upload2] [PublishUtils]", 1, "isVideoNeedCompress false video info = null");
      return false;
    }
    if (!paramShuoshuoVideoInfo.n)
    {
      QLog.e("[upload2] [PublishUtils]", 1, "isVideoNeedCompress false mNeedProcess = false");
      return false;
    }
    if ((!a()) && (paramShuoshuoVideoInfo.m != 0)) {
      return false;
    }
    QLog.e("[upload2] [PublishUtils]", 1, "videoInfo.mVideoType = 0");
    return true;
  }
  
  public static boolean c(String paramString)
  {
    boolean bool2 = false;
    try
    {
      paramString = new File(paramString);
      boolean bool1 = bool2;
      if (paramString.exists())
      {
        long l = paramString.length();
        bool1 = bool2;
        if (l > 0L) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Throwable paramString)
    {
      QLog.e("[upload2] [PublishUtils]", 1, "checkFile error", paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.util.PublishUtils
 * JD-Core Version:    0.7.0.1
 */