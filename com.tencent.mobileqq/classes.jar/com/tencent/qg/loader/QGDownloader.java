package com.tencent.qg.loader;

import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class QGDownloader
{
  public int a;
  private Map<String, List<QGDownloader.QGDownloadCallback>> a;
  
  private void c(String paramString, boolean paramBoolean)
  {
    paramString = (List)this.jdField_a_of_type_JavaUtilMap.remove(paramString);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        QGDownloader.QGDownloadCallback localQGDownloadCallback = (QGDownloader.QGDownloadCallback)paramString.next();
        if (paramBoolean) {
          localQGDownloadCallback.a();
        } else {
          localQGDownloadCallback.b();
        }
      }
    }
  }
  
  protected void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QGDownloader", 2, "onFail.");
    }
    this.jdField_a_of_type_Int = 1;
    b(paramString, false);
    c(paramString, false);
  }
  
  protected void a(String paramString, int paramInt) {}
  
  protected void a(String paramString, boolean paramBoolean)
  {
    boolean bool = QGLoader.b.get();
    if (QLog.isColorLevel()) {
      QLog.d("QGDownloader", 2, new Object[] { "onSuccess. loadSo=", Boolean.valueOf(paramBoolean), ", soLoaded=", Boolean.valueOf(bool) });
    }
    this.jdField_a_of_type_Int = 0;
    b(paramString, true);
    if (!paramBoolean)
    {
      c(paramString, true);
      return;
    }
    if (!bool)
    {
      ThreadManagerV2.excute(new QGDownloader.1(this, paramString), 16, null, true);
      return;
    }
    c(paramString, false);
  }
  
  protected void b(String paramString, boolean paramBoolean)
  {
    paramString = (List)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    long l;
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      paramString = (QGDownloader.QGDownloadCallback)paramString.get(0);
      l = System.currentTimeMillis() - paramString.a;
    }
    else
    {
      l = 0L;
    }
    if (paramBoolean) {
      paramString = "1";
    } else {
      paramString = "0";
    }
    StoryReportor.b("video_game_tech", "qg_so_download", 0, 0, new String[] { String.valueOf(l), paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qg.loader.QGDownloader
 * JD-Core Version:    0.7.0.1
 */