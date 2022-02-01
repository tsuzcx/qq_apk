package cooperation.qqcircle.picload;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class QCirclePicDownLoader
{
  protected static String LOG_TAG = QCircleFeedPicLoader.TAG;
  private static QCirclePicDownLoader mInstance;
  private ConcurrentHashMap<String, ConcurrentHashMap<Integer, QCirclePicDownLoader.PicDownLoadListener>> mDownLoadListeners = new ConcurrentHashMap();
  
  private void callBackResult(Option paramOption, boolean paramBoolean, int paramInt)
  {
    if (paramOption != null)
    {
      ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.mDownLoadListeners.get(paramOption.getLocalPath());
      if (localConcurrentHashMap != null)
      {
        Iterator localIterator = localConcurrentHashMap.keySet().iterator();
        QLog.i(LOG_TAG, 1, "seq = " + paramOption.getSeq() + " call back size:" + localConcurrentHashMap.size());
        while (localIterator.hasNext())
        {
          QCirclePicDownLoader.PicDownLoadListener localPicDownLoadListener = (QCirclePicDownLoader.PicDownLoadListener)localConcurrentHashMap.remove((Integer)localIterator.next());
          if (localPicDownLoadListener != null) {
            localPicDownLoadListener.onResult(paramBoolean, paramInt);
          }
        }
        QLog.i(LOG_TAG, 1, "seq = " + paramOption.getSeq() + " cacheKey = " + paramOption.getCacheKey() + " ifFromPreload:" + paramOption.isFromPreload() + " callBackResult success = " + paramBoolean + " resultCode = " + paramInt);
      }
    }
  }
  
  public static QCirclePicDownLoader g()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new QCirclePicDownLoader();
      }
      return mInstance;
    }
    finally {}
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
        localConcurrentHashMap.put(Integer.valueOf(paramPicDownLoadListener.hashCode()), paramPicDownLoadListener);
        QLog.i(LOG_TAG, 1, "seq = " + paramOption.getSeq() + " cacheKey = " + paramOption.getCacheKey() + ", is on Downloading ifFromPreload:" + paramOption.isFromPreload());
        if (localConcurrentHashMap.size() == 1)
        {
          if (FileUtil.isFileExists(paramOption.getLocalPath()))
          {
            callBackResult(paramOption, true, 0);
            QLog.i(LOG_TAG, 1, "seq = " + paramOption.getSeq() + " cacheKey = " + paramOption.getCacheKey() + ",lost callback  return success ifFromPreload:" + paramOption.isFromPreload());
          }
        }
        else {
          return;
        }
        toDownLoad(paramOption, paramPicDownLoadListener);
        QLog.i(LOG_TAG, 1, "seq = " + paramOption.getSeq() + " cacheKey = " + paramOption.getCacheKey() + ",lost callback  reDownload ifFromPreload:" + paramOption.isFromPreload());
        return;
      }
      toDownLoad(paramOption, paramPicDownLoadListener);
      return;
    }
    QLog.i(LOG_TAG, 1, "illegal args");
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
      QLog.i(LOG_TAG, 1, "seq = " + paramOption.getSeq() + " cacheKey = " + paramOption.getCacheKey() + " ifFromPreload:" + paramOption.isFromPreload() + " tryGetIp() failed host is np");
      return;
    }
    try
    {
      paramOption.setIP(InetAddress.getByName(str).getHostAddress());
      QLog.i(LOG_TAG, 1, "seq = " + paramOption.getSeq() + " cacheKey = " + paramOption.getCacheKey() + " ifFromPreload:" + paramOption.isFromPreload() + " tryGetIp() success:" + paramOption.getIP());
      return;
    }
    catch (Exception localException)
    {
      QLog.i(LOG_TAG, 1, "seq = " + paramOption.getSeq() + " cacheKey = " + paramOption.getCacheKey() + " ifFromPreload:" + paramOption.isFromPreload() + " tryGetIp() failed exception");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.picload.QCirclePicDownLoader
 * JD-Core Version:    0.7.0.1
 */