import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoySSOHandlerThread;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

public class pno
{
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static ReadInJoySSOHandlerThread jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoySSOHandlerThread;
  private static String jdField_a_of_type_JavaLangString;
  private static Queue<Integer> jdField_a_of_type_JavaUtilQueue = new LinkedBlockingQueue(100);
  private static Handler b;
  
  public static Handler a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoySSOHandlerThread == null)
      {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoySSOHandlerThread = new ReadInJoySSOHandlerThread("kandian_network_thread");
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoySSOHandlerThread.start();
        jdField_a_of_type_AndroidOsHandler = new Handler(jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoySSOHandlerThread.getLooper());
      }
      Handler localHandler = jdField_a_of_type_AndroidOsHandler;
      return localHandler;
    }
    finally {}
  }
  
  public static String a()
  {
    if (jdField_a_of_type_JavaLangString == null) {
      return "0";
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  public static List<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (jdField_a_of_type_JavaUtilQueue != null)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilQueue.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((Integer)localIterator.next());
      }
    }
    return localArrayList;
  }
  
  public static void a()
  {
    if (jdField_a_of_type_JavaUtilQueue != null) {
      jdField_a_of_type_JavaUtilQueue.clear();
    }
  }
  
  public static void a(int paramInt)
  {
    if (jdField_a_of_type_JavaUtilQueue == null) {
      jdField_a_of_type_JavaUtilQueue = new LinkedBlockingQueue(100);
    }
    if (!jdField_a_of_type_JavaUtilQueue.offer(Integer.valueOf(paramInt)))
    {
      jdField_a_of_type_JavaUtilQueue.poll();
      jdField_a_of_type_JavaUtilQueue.offer(Integer.valueOf(paramInt));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    
    if (paramQQAppInterface == null) {
      return;
    }
    long l1 = paramQQAppInterface.getLongAccountUin();
    long l2 = System.currentTimeMillis();
    jdField_a_of_type_JavaLangString = l1 + "_" + l2;
  }
  
  public static void a(String paramString, Runnable paramRunnable, ExecutorService paramExecutorService)
  {
    if ((paramExecutorService == null) || (paramExecutorService.isShutdown()))
    {
      QLog.d("RIJThreadHandler", 2, new Object[] { paramString, " runInSubThread failed, executorService is null or shutdown." });
      return;
    }
    paramExecutorService.execute(paramRunnable);
  }
  
  public static boolean a()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  public static Handler b()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new Handler(Looper.getMainLooper());
      }
      return b;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pno
 * JD-Core Version:    0.7.0.1
 */