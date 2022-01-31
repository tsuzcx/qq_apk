package dov.com.tencent.mobileqq.activity.richmedia;

import aopl;
import aopm;
import com.tencent.av.AVNetEngine;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VideoFilterListDownloader
{
  private static VideoFilterListDownloader jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterListDownloader;
  private aopl jdField_a_of_type_Aopl;
  aopm jdField_a_of_type_Aopm = new aopm(this);
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  
  private int a(int paramInt1, int paramInt2)
  {
    int i = -1;
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      if (this.jdField_a_of_type_Aopl != null)
      {
        this.jdField_a_of_type_Aopl.jdField_a_of_type_Int = (this.jdField_a_of_type_Aopl.jdField_a_of_type_Int - paramInt1 - paramInt2);
        this.jdField_a_of_type_Aopl.b += paramInt1;
        this.jdField_a_of_type_Aopl.c += paramInt2;
        i = this.jdField_a_of_type_Aopl.jdField_a_of_type_Int;
      }
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      QLog.i("VideoFilterListDownloader", 2, "decrementAndGet : " + i);
      return i;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public static VideoFilterListDownloader a()
  {
    if (jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterListDownloader == null) {
      jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterListDownloader = new VideoFilterListDownloader();
    }
    return jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterListDownloader;
  }
  
  private void a()
  {
    QLog.i("VideoFilterListDownloader", 2, "StartDownload");
    if (this.jdField_a_of_type_Aopl == null)
    {
      b();
      if (this.jdField_a_of_type_Aopl != null) {
        if ((aopl.a(this.jdField_a_of_type_Aopl) != null) && (aopl.a(this.jdField_a_of_type_Aopl).size() > 0))
        {
          a(System.currentTimeMillis());
          a(aopl.a(this.jdField_a_of_type_Aopl).size());
          Object localObject = aopl.a(this.jdField_a_of_type_Aopl).iterator();
          int i = 0;
          if (((Iterator)localObject).hasNext())
          {
            FilterDesc localFilterDesc = (FilterDesc)((Iterator)localObject).next();
            boolean bool = a(localFilterDesc);
            if ((bool) && (localFilterDesc.jdField_a_of_type_JavaLangString != null) && (!localFilterDesc.jdField_a_of_type_JavaLangString.equals("")))
            {
              QLog.i("VideoFilterListDownloader", 2, "mHttpMethod download： " + localFilterDesc.jdField_a_of_type_JavaLangString);
              HttpNetReq localHttpNetReq = new HttpNetReq();
              localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this.jdField_a_of_type_Aopm;
              localHttpNetReq.jdField_a_of_type_JavaLangString = localFilterDesc.jdField_a_of_type_JavaLangString;
              localHttpNetReq.jdField_a_of_type_Int = 0;
              localHttpNetReq.c = (CaptureVideoFilterManager.b + localFilterDesc.e + ".zip");
              localHttpNetReq.a(localFilterDesc);
              AVNetEngine.a().a(localHttpNetReq);
              i = 1;
            }
            for (;;)
            {
              break;
              a(1, 0);
              if (!bool) {
                QLog.i("VideoFilterListDownloader", 2, "checkFilterNeedDownload is not need ");
              } else {
                QLog.e("VideoFilterListDownloader", 2, "checkFilterNeedDownload resurl is null ");
              }
            }
          }
          if (i == 0)
          {
            if (aopl.a(this.jdField_a_of_type_Aopl) != null)
            {
              localObject = (VideoFilterListDownloader.downloadListTaskListener)this.jdField_a_of_type_Aopl.jdField_a_of_type_JavaLangRefWeakReference.get();
              if (localObject != null) {
                ((VideoFilterListDownloader.downloadListTaskListener)localObject).a(this.jdField_a_of_type_Aopl.b, this.jdField_a_of_type_Aopl.c);
              }
            }
            c();
            QLog.i("VideoFilterListDownloader", 2, "checkFilterNeedDownload bhttp is false ");
            a();
          }
        }
      }
    }
    do
    {
      return;
      QLog.i("VideoFilterListDownloader", 2, "taskImpling is null and to do list is null ");
      return;
      QLog.i("VideoFilterListDownloader", 2, "taskImpling is doing job ");
    } while ((this.jdField_a_of_type_Aopl.jdField_a_of_type_Long == 0L) || (System.currentTimeMillis() - this.jdField_a_of_type_Aopl.jdField_a_of_type_Long <= 300000L));
    QLog.e("VideoFilterListDownloader", 2, "taskImpling time is above 5 minites ");
    c();
    a();
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      if (this.jdField_a_of_type_Aopl != null) {
        this.jdField_a_of_type_Aopl.jdField_a_of_type_Int = paramInt;
      }
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      QLog.i("VideoFilterListDownloader", 2, "setVal : " + paramInt);
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  private void a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      if (this.jdField_a_of_type_Aopl != null) {
        this.jdField_a_of_type_Aopl.jdField_a_of_type_Long = paramLong;
      }
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      QLog.i("VideoFilterListDownloader", 2, "settime : " + paramLong);
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  /* Error */
  private void a(aopl paramaopl)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 24	dov/com/tencent/mobileqq/activity/richmedia/VideoFilterListDownloader:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 38 1 0
    //   9: aload_0
    //   10: getfield 19	dov/com/tencent/mobileqq/activity/richmedia/VideoFilterListDownloader:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   13: invokevirtual 220	java/util/LinkedList:size	()I
    //   16: bipush 50
    //   18: if_icmple +44 -> 62
    //   21: ldc 56
    //   23: iconst_2
    //   24: new 58	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   31: ldc 222
    //   33: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_0
    //   37: getfield 19	dov/com/tencent/mobileqq/activity/richmedia/VideoFilterListDownloader:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   40: invokevirtual 220	java/util/LinkedList:size	()I
    //   43: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 181	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aload_0
    //   53: getfield 24	dov/com/tencent/mobileqq/activity/richmedia/VideoFilterListDownloader:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   56: invokeinterface 54 1 0
    //   61: return
    //   62: aload_1
    //   63: ifnull -11 -> 52
    //   66: aload_0
    //   67: getfield 19	dov/com/tencent/mobileqq/activity/richmedia/VideoFilterListDownloader:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   70: aload_1
    //   71: invokevirtual 225	java/util/LinkedList:addLast	(Ljava/lang/Object;)V
    //   74: ldc 56
    //   76: iconst_2
    //   77: new 58	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   84: ldc 227
    //   86: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_0
    //   90: getfield 19	dov/com/tencent/mobileqq/activity/richmedia/VideoFilterListDownloader:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   93: invokevirtual 220	java/util/LinkedList:size	()I
    //   96: invokevirtual 68	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 78	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: goto -53 -> 52
    //   108: astore_1
    //   109: aload_0
    //   110: getfield 24	dov/com/tencent/mobileqq/activity/richmedia/VideoFilterListDownloader:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   113: invokeinterface 54 1 0
    //   118: aload_1
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	VideoFilterListDownloader
    //   0	120	1	paramaopl	aopl
    // Exception table:
    //   from	to	target	type
    //   9	52	108	finally
    //   66	105	108	finally
  }
  
  public static boolean a(FilterDesc paramFilterDesc)
  {
    String str = paramFilterDesc.b(CaptureVideoFilterManager.b);
    VideoFilterTools.a();
    File localFile = new File(str + "params.json");
    boolean bool = false;
    if (!localFile.exists()) {
      bool = true;
    }
    if ((!bool) && (paramFilterDesc.g != null) && (!paramFilterDesc.g.equals("")) && (!new File(str + paramFilterDesc.g).exists()))
    {
      QLog.i("VideoFilterListDownloader", 2, "check false respicname file not exists :" + paramFilterDesc.e);
      return true;
    }
    return bool;
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
      {
        this.jdField_a_of_type_Aopl = ((aopl)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst());
        QLog.i("VideoFilterListDownloader", 2, "removeFirst，then size:" + this.jdField_a_of_type_JavaUtilLinkedList.size());
      }
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      if (this.jdField_a_of_type_Aopl != null)
      {
        if (aopl.a(this.jdField_a_of_type_Aopl) != null) {
          aopl.a(this.jdField_a_of_type_Aopl).clear();
        }
        this.jdField_a_of_type_Aopl = null;
      }
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      QLog.i("VideoFilterListDownloader", 2, "cleartaskImpling : ");
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public void a(ArrayList paramArrayList, VideoFilterListDownloader.downloadListTaskListener paramdownloadListTaskListener)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      QLog.e("VideoFilterListDownloader", 2, "DownloadResource list size: null or 0");
      return;
    }
    QLog.i("VideoFilterListDownloader", 2, "DownloadResource list size: " + paramArrayList.size());
    aopl localaopl = new aopl(this);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      FilterDesc localFilterDesc = (FilterDesc)paramArrayList.next();
      aopl.a(localaopl).add(localFilterDesc);
    }
    localaopl.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramdownloadListTaskListener);
    a(localaopl);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.VideoFilterListDownloader
 * JD-Core Version:    0.7.0.1
 */