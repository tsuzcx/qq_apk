package cooperation.qqcircle.picload;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.utils.FileUtils;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class QCirclePicDownLoader
{
  private static final String LOG_TAG = "QCircleFeedPicLoader";
  private static final long MAX_WAIT_TIME = 30000L;
  private static volatile QCirclePicDownLoader sInstance;
  private ConcurrentHashMap<String, ConcurrentHashMap<Integer, QCirclePicDownLoader.PicDownLoadListener>> mDownLoadListeners = new ConcurrentHashMap();
  
  private void callBackResult(Option paramOption, boolean paramBoolean, int paramInt)
  {
    if (paramOption != null)
    {
      ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.mDownLoadListeners.get(paramOption.getLocalPath());
      if (localConcurrentHashMap != null)
      {
        Iterator localIterator = localConcurrentHashMap.keySet().iterator();
        RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + paramOption.getSeq() + " call back size:" + localConcurrentHashMap.size());
        while (localIterator.hasNext())
        {
          QCirclePicDownLoader.PicDownLoadListener localPicDownLoadListener = (QCirclePicDownLoader.PicDownLoadListener)localConcurrentHashMap.remove((Integer)localIterator.next());
          if (localPicDownLoadListener != null) {
            localPicDownLoadListener.onResult(paramBoolean, paramInt);
          }
        }
        RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + paramOption.getSeq() + " cacheKey = " + paramOption.getCacheKey() + " ifFromPreload:" + paramOption.isFromPreload() + " callBackResult success = " + paramBoolean + " resultCode = " + paramInt);
      }
    }
  }
  
  public static QCirclePicDownLoader g()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new QCirclePicDownLoader();
      }
      return sInstance;
    }
    finally {}
  }
  
  private long getMaxWaitTime(Option paramOption, ConcurrentHashMap<Integer, QCirclePicDownLoader.PicDownLoadListener> paramConcurrentHashMap)
  {
    long l2;
    if ((paramOption != null) && (paramConcurrentHashMap != null) && (paramConcurrentHashMap.size() > 0))
    {
      long l3 = paramOption.mDownLoadStartTime.longValue();
      Iterator localIterator = paramConcurrentHashMap.keySet().iterator();
      long l1 = 0L;
      l2 = l1;
      if (!localIterator.hasNext()) {
        break label170;
      }
      QCirclePicDownLoader.PicDownLoadListener localPicDownLoadListener = (QCirclePicDownLoader.PicDownLoadListener)paramConcurrentHashMap.get((Integer)localIterator.next());
      if ((localPicDownLoadListener == null) || (localPicDownLoadListener.mOption == null)) {
        break label173;
      }
      l2 = l3 - localPicDownLoadListener.mOption.mDownLoadStartTime.longValue();
      RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + paramOption.getSeq() + " old seq = " + localPicDownLoadListener.mOption.getSeq() + " compute WaitTime:" + l2);
      if (l2 <= l1) {
        break label173;
      }
      l1 = l2;
    }
    label170:
    label173:
    for (;;)
    {
      break;
      l2 = 0L;
      return l2;
    }
  }
  
  private void toDownLoad(Option paramOption, QCirclePicDownLoader.PicDownLoadListener paramPicDownLoadListener)
  {
    ConcurrentHashMap localConcurrentHashMap2 = (ConcurrentHashMap)this.mDownLoadListeners.get(paramOption.getLocalPath());
    ConcurrentHashMap localConcurrentHashMap1 = localConcurrentHashMap2;
    if (localConcurrentHashMap2 == null) {
      localConcurrentHashMap1 = new ConcurrentHashMap();
    }
    localConcurrentHashMap1.put(Integer.valueOf(paramPicDownLoadListener.hashCode()), paramPicDownLoadListener);
    this.mDownLoadListeners.put(paramOption.getLocalPath(), localConcurrentHashMap1);
    new QCirclePicDWClient().toDownLoad(paramOption, new QCirclePicDownLoader.1(this));
  }
  
  public void downLoad(Option paramOption, QCirclePicDownLoader.PicDownLoadListener paramPicDownLoadListener)
  {
    if ((paramOption != null) && (paramPicDownLoadListener != null))
    {
      ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.mDownLoadListeners.get(paramOption.getLocalPath());
      if ((localConcurrentHashMap != null) && (localConcurrentHashMap.size() > 0))
      {
        long l = getMaxWaitTime(paramOption, localConcurrentHashMap);
        if (l > 30000L)
        {
          RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + paramOption.getSeq() + " cacheKey = " + paramOption.getCacheKey() + "over max wait time direct to downloadwaitTime:" + l);
          toDownLoad(paramOption, paramPicDownLoadListener);
        }
        do
        {
          return;
          localConcurrentHashMap.put(Integer.valueOf(paramPicDownLoadListener.hashCode()), paramPicDownLoadListener);
          RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + paramOption.getSeq() + " cacheKey = " + paramOption.getCacheKey() + ", is on Downloading ifFromPreload:" + paramOption.isFromPreload());
        } while (localConcurrentHashMap.size() != 1);
        if (FileUtils.a(paramOption.getLocalPath()))
        {
          callBackResult(paramOption, true, 0);
          RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + paramOption.getSeq() + " cacheKey = " + paramOption.getCacheKey() + ",lost callback  return success ifFromPreload:" + paramOption.isFromPreload());
          return;
        }
        toDownLoad(paramOption, paramPicDownLoadListener);
        RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + paramOption.getSeq() + " cacheKey = " + paramOption.getCacheKey() + ",lost callback  reDownload ifFromPreload:" + paramOption.isFromPreload());
        return;
      }
      toDownLoad(paramOption, paramPicDownLoadListener);
      return;
    }
    RFLog.i("QCircleFeedPicLoader", RFLog.USR, "illegal args");
  }
  
  public void release()
  {
    this.mDownLoadListeners.clear();
  }
  
  public void tryGetIp(Option paramOption)
  {
    if (paramOption == null) {
      return;
    }
    String str = QCircleCommonUtil.getUrlHost(paramOption.getUrl());
    if (TextUtils.isEmpty(str))
    {
      RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + paramOption.getSeq() + " cacheKey = " + paramOption.getCacheKey() + " ifFromPreload:" + paramOption.isFromPreload() + " tryGetIp() failed host is np");
      return;
    }
    try
    {
      paramOption.setIP(InetAddress.getByName(str).getHostAddress());
      RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + paramOption.getSeq() + " cacheKey = " + paramOption.getCacheKey() + " ifFromPreload:" + paramOption.isFromPreload() + " tryGetIp() success:" + paramOption.getIP());
      return;
    }
    catch (Exception localException)
    {
      RFLog.i("QCircleFeedPicLoader", RFLog.USR, "seq = " + paramOption.getSeq() + " cacheKey = " + paramOption.getCacheKey() + " ifFromPreload:" + paramOption.isFromPreload() + " tryGetIp() failed exception");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCirclePicDownLoader
 * JD-Core Version:    0.7.0.1
 */