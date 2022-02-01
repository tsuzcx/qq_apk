package com.yolo.esports.download.zip;

import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.utils.ZipFileUtils;
import com.yolo.esports.download.cb.ZipFileDownloadListener;
import com.yolo.esports.download.util.FileUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class ZipFileDownloadWrapper
{
  private static volatile ZipFileDownloadWrapper a;
  private final ReentrantLock b = new ReentrantLock();
  private Map<String, ZipFileDownloadWrapper.ZipDownloadListenerStruct> c = new HashMap();
  private final Object d = new Object();
  private List<String> e = new LinkedList();
  
  private void a(ZipFileDownInfo paramZipFileDownInfo, List<ZipFileDownloadListener> paramList)
  {
    String str1 = paramZipFileDownInfo.z;
    ??? = new StringBuilder();
    ((StringBuilder)???).append(paramZipFileDownInfo.e);
    ((StringBuilder)???).append("_");
    ((StringBuilder)???).append(str1);
    String str2 = ((StringBuilder)???).toString();
    if ((!paramZipFileDownInfo.A) && (!FileUtil.a(str1)))
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("forceUnZip is false and unZipTargetDir has sub files. zipFileDownInfo=");
      ((StringBuilder)???).append(paramZipFileDownInfo);
      ((StringBuilder)???).append(", unZipTargetDir=");
      ((StringBuilder)???).append(str1);
      QLog.e("ZipFileDownloadUtils_", 1, ((StringBuilder)???).toString());
    }
    int i;
    synchronized (this.d)
    {
      if ((this.e.contains(str2)) && (!FileUtil.a(str1)))
      {
        i = 1;
        StringBuilder localStringBuilder;
        if (i == 0)
        {
          ZipFileUtils.a(paramZipFileDownInfo.e, str1);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("unzip finished:");
          localStringBuilder.append(str2);
          QLog.e("ZipFileDownloadUtils_", 1, localStringBuilder.toString());
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("skip unzip:");
          localStringBuilder.append(str2);
          QLog.e("ZipFileDownloadUtils_", 1, localStringBuilder.toString());
        }
        this.e.add(str2);
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          ??? = (ZipFileDownloadListener)paramList.next();
          if (??? != null) {
            try
            {
              ((ZipFileDownloadListener)???).a(paramZipFileDownInfo, paramZipFileDownInfo.e, str1);
            }
            catch (Exception localException)
            {
              QLog.e("ZipFileDownloadUtils_", 1, "onUnZipCompleted callback error", localException);
            }
          }
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.yolo.esports.download.zip.ZipFileDownloadWrapper
 * JD-Core Version:    0.7.0.1
 */