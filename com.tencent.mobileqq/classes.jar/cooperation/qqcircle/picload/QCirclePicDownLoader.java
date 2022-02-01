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
      Object localObject1 = (ConcurrentHashMap)this.mDownLoadListeners.get(paramOption.getLocalPath());
      if (localObject1 != null)
      {
        Iterator localIterator = ((ConcurrentHashMap)localObject1).keySet().iterator();
        int i = RFLog.USR;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("seq = ");
        ((StringBuilder)localObject2).append(paramOption.getSeq());
        ((StringBuilder)localObject2).append(" call back size:");
        ((StringBuilder)localObject2).append(((ConcurrentHashMap)localObject1).size());
        RFLog.i("QCircleFeedPicLoader", i, ((StringBuilder)localObject2).toString());
        while (localIterator.hasNext())
        {
          localObject2 = (QCirclePicDownLoader.PicDownLoadListener)((ConcurrentHashMap)localObject1).remove((Integer)localIterator.next());
          if (localObject2 != null) {
            ((QCirclePicDownLoader.PicDownLoadListener)localObject2).onResult(paramBoolean, paramInt);
          }
        }
        i = RFLog.USR;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("seq = ");
        ((StringBuilder)localObject1).append(paramOption.getSeq());
        ((StringBuilder)localObject1).append(" cacheKey = ");
        ((StringBuilder)localObject1).append(paramOption.getCacheKey());
        ((StringBuilder)localObject1).append(" ifFromPreload:");
        ((StringBuilder)localObject1).append(paramOption.isFromPreload());
        ((StringBuilder)localObject1).append(" callBackResult success = ");
        ((StringBuilder)localObject1).append(paramBoolean);
        ((StringBuilder)localObject1).append(" resultCode = ");
        ((StringBuilder)localObject1).append(paramInt);
        RFLog.i("QCircleFeedPicLoader", i, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public static QCirclePicDownLoader g()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new QCirclePicDownLoader();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private long getMaxWaitTime(Option paramOption, ConcurrentHashMap<Integer, QCirclePicDownLoader.PicDownLoadListener> paramConcurrentHashMap)
  {
    long l1 = 0L;
    long l2 = l1;
    if (paramOption != null)
    {
      l2 = l1;
      if (paramConcurrentHashMap != null)
      {
        l2 = l1;
        if (paramConcurrentHashMap.size() > 0)
        {
          long l3 = paramOption.mDownLoadStartTime.longValue();
          Iterator localIterator = paramConcurrentHashMap.keySet().iterator();
          for (;;)
          {
            l2 = l1;
            if (!localIterator.hasNext()) {
              break;
            }
            QCirclePicDownLoader.PicDownLoadListener localPicDownLoadListener = (QCirclePicDownLoader.PicDownLoadListener)paramConcurrentHashMap.get((Integer)localIterator.next());
            if ((localPicDownLoadListener != null) && (localPicDownLoadListener.mOption != null))
            {
              l2 = l3 - localPicDownLoadListener.mOption.mDownLoadStartTime.longValue();
              int i = RFLog.USR;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("seq = ");
              localStringBuilder.append(paramOption.getSeq());
              localStringBuilder.append(" old seq = ");
              localStringBuilder.append(localPicDownLoadListener.mOption.getSeq());
              localStringBuilder.append(" compute WaitTime:");
              localStringBuilder.append(l2);
              RFLog.i("QCircleFeedPicLoader", i, localStringBuilder.toString());
              if (l2 > l1) {
                l1 = l2;
              }
            }
          }
        }
      }
    }
    return l2;
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
      Object localObject = (ConcurrentHashMap)this.mDownLoadListeners.get(paramOption.getLocalPath());
      if ((localObject != null) && (((ConcurrentHashMap)localObject).size() > 0))
      {
        long l = getMaxWaitTime(paramOption, (ConcurrentHashMap)localObject);
        if (l > 30000L)
        {
          i = RFLog.USR;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("seq = ");
          ((StringBuilder)localObject).append(paramOption.getSeq());
          ((StringBuilder)localObject).append(" cacheKey = ");
          ((StringBuilder)localObject).append(paramOption.getCacheKey());
          ((StringBuilder)localObject).append("over max wait time direct to downloadwaitTime:");
          ((StringBuilder)localObject).append(l);
          RFLog.i("QCircleFeedPicLoader", i, ((StringBuilder)localObject).toString());
          toDownLoad(paramOption, paramPicDownLoadListener);
          return;
        }
        ((ConcurrentHashMap)localObject).put(Integer.valueOf(paramPicDownLoadListener.hashCode()), paramPicDownLoadListener);
        int i = RFLog.USR;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("seq = ");
        localStringBuilder.append(paramOption.getSeq());
        localStringBuilder.append(" cacheKey = ");
        localStringBuilder.append(paramOption.getCacheKey());
        localStringBuilder.append(", is on Downloading ifFromPreload:");
        localStringBuilder.append(paramOption.isFromPreload());
        RFLog.i("QCircleFeedPicLoader", i, localStringBuilder.toString());
        if (((ConcurrentHashMap)localObject).size() == 1)
        {
          if (FileUtils.fileExists(paramOption.getLocalPath()))
          {
            callBackResult(paramOption, true, 0);
            i = RFLog.USR;
            paramPicDownLoadListener = new StringBuilder();
            paramPicDownLoadListener.append("seq = ");
            paramPicDownLoadListener.append(paramOption.getSeq());
            paramPicDownLoadListener.append(" cacheKey = ");
            paramPicDownLoadListener.append(paramOption.getCacheKey());
            paramPicDownLoadListener.append(",lost callback  return success ifFromPreload:");
            paramPicDownLoadListener.append(paramOption.isFromPreload());
            RFLog.i("QCircleFeedPicLoader", i, paramPicDownLoadListener.toString());
            return;
          }
          toDownLoad(paramOption, paramPicDownLoadListener);
          i = RFLog.USR;
          paramPicDownLoadListener = new StringBuilder();
          paramPicDownLoadListener.append("seq = ");
          paramPicDownLoadListener.append(paramOption.getSeq());
          paramPicDownLoadListener.append(" cacheKey = ");
          paramPicDownLoadListener.append(paramOption.getCacheKey());
          paramPicDownLoadListener.append(",lost callback  reDownload ifFromPreload:");
          paramPicDownLoadListener.append(paramOption.isFromPreload());
          RFLog.i("QCircleFeedPicLoader", i, paramPicDownLoadListener.toString());
        }
      }
      else
      {
        toDownLoad(paramOption, paramPicDownLoadListener);
      }
    }
    else
    {
      RFLog.i("QCircleFeedPicLoader", RFLog.USR, "illegal args");
    }
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
    Object localObject = QCircleCommonUtil.getUrlHost(paramOption.getUrl());
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      i = RFLog.USR;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("seq = ");
      ((StringBuilder)localObject).append(paramOption.getSeq());
      ((StringBuilder)localObject).append(" cacheKey = ");
      ((StringBuilder)localObject).append(paramOption.getCacheKey());
      ((StringBuilder)localObject).append(" ifFromPreload:");
      ((StringBuilder)localObject).append(paramOption.isFromPreload());
      ((StringBuilder)localObject).append(" tryGetIp() failed host is np");
      RFLog.i("QCircleFeedPicLoader", i, ((StringBuilder)localObject).toString());
      return;
    }
    try
    {
      paramOption.setIP(InetAddress.getByName((String)localObject).getHostAddress());
      i = RFLog.USR;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("seq = ");
      ((StringBuilder)localObject).append(paramOption.getSeq());
      ((StringBuilder)localObject).append(" cacheKey = ");
      ((StringBuilder)localObject).append(paramOption.getCacheKey());
      ((StringBuilder)localObject).append(" ifFromPreload:");
      ((StringBuilder)localObject).append(paramOption.isFromPreload());
      ((StringBuilder)localObject).append(" tryGetIp() success:");
      ((StringBuilder)localObject).append(paramOption.getIP());
      RFLog.i("QCircleFeedPicLoader", i, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception localException)
    {
      label197:
      break label197;
    }
    int i = RFLog.USR;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("seq = ");
    ((StringBuilder)localObject).append(paramOption.getSeq());
    ((StringBuilder)localObject).append(" cacheKey = ");
    ((StringBuilder)localObject).append(paramOption.getCacheKey());
    ((StringBuilder)localObject).append(" ifFromPreload:");
    ((StringBuilder)localObject).append(paramOption.isFromPreload());
    ((StringBuilder)localObject).append(" tryGetIp() failed exception");
    RFLog.i("QCircleFeedPicLoader", i, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCirclePicDownLoader
 * JD-Core Version:    0.7.0.1
 */