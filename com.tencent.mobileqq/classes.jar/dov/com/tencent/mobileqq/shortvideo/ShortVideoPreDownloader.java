package dov.com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.Manager;

public class ShortVideoPreDownloader
  implements Manager
{
  public static long a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  UiCallBack jdField_a_of_type_DovComTencentMobileqqShortvideoUiCallBack;
  List<ShortVideoReq> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
  public Map<String, Integer> a;
  Timer jdField_a_of_type_JavaUtilTimer;
  PriorityBlockingQueue<ShortVideoReq> jdField_a_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  public AtomicInteger a;
  List<ShortVideoReq> b;
  public PriorityBlockingQueue<ShortVideoReq> b;
  public AtomicInteger b;
  List<ShortVideoReq> c = Collections.synchronizedList(new LinkedList());
  List<ShortVideoReq> d = Collections.synchronizedList(new LinkedList());
  
  static
  {
    jdField_a_of_type_Long = 86400000L;
  }
  
  public ShortVideoPreDownloader(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
    this.jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_b_of_type_JavaUtilConcurrentPriorityBlockingQueue = new PriorityBlockingQueue();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoUiCallBack = new ShortVideoPreDownloader.1(this);
  }
  
  static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      QLog.d("ShortVideoPreDownloader", 2, paramString1 + "(): " + str);
    }
  }
  
  protected void a(ShortVideoReq paramShortVideoReq)
  {
    ShortVideoBusiManager.a(paramShortVideoReq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "launchRequest:" + paramShortVideoReq.a.busiType);
    }
  }
  
  public void onDestroy()
  {
    a("onDestroy", null);
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer.purge();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.ShortVideoPreDownloader
 * JD-Core Version:    0.7.0.1
 */