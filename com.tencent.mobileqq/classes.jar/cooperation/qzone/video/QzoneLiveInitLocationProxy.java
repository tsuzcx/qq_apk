package cooperation.qzone.video;

import android.os.Handler;
import java.util.concurrent.ConcurrentHashMap;

public class QzoneLiveInitLocationProxy
  implements QzoneLiveInitLocationInterface
{
  private static final String TAG = "QzoneLiveInitLocationProxy";
  private static ConcurrentHashMap<String, QzoneLiveInitLocationProxy> cache = new ConcurrentHashMap();
  private static Object lock = new Object();
  private String mBusinessId;
  private int mNewLbsInterfaceEnable = -1;
  private QzoneLiveInitLocationInterface mQzoneLiveInitLocationInterface;
  
  private QzoneLiveInitLocationProxy(String paramString)
  {
    this.mBusinessId = paramString;
    this.mQzoneLiveInitLocationInterface = QzoneNewLiveInitLocation.getInstance(this.mBusinessId);
  }
  
  public static QzoneLiveInitLocationProxy getInstance(String paramString)
  {
    Object localObject1 = (QzoneLiveInitLocationProxy)cache.get(paramString);
    if (localObject1 == null) {
      synchronized (lock)
      {
        QzoneLiveInitLocationProxy localQzoneLiveInitLocationProxy = (QzoneLiveInitLocationProxy)cache.get(paramString);
        localObject1 = localQzoneLiveInitLocationProxy;
        if (localQzoneLiveInitLocationProxy == null)
        {
          localObject1 = new QzoneLiveInitLocationProxy(paramString);
          cache.put(paramString, localObject1);
        }
        return localObject1;
      }
    }
    return localObject1;
  }
  
  public void locate(Handler paramHandler)
  {
    this.mQzoneLiveInitLocationInterface.locate(paramHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.video.QzoneLiveInitLocationProxy
 * JD-Core Version:    0.7.0.1
 */