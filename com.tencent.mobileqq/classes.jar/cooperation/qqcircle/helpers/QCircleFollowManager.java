package cooperation.qqcircle.helpers;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import java.util.concurrent.ConcurrentHashMap;

public class QCircleFollowManager
{
  public static final String TAG = "QCircleFollowManager";
  private static volatile QCircleFollowManager sInstance;
  private ConcurrentHashMap<String, Integer> mFakeUinFollowMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Integer> mUinFollowMap = new ConcurrentHashMap();
  
  public static QCircleFollowManager getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new QCircleFollowManager();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  public void clearAll()
  {
    RFLog.i(TAG, RFLog.USR, "clear all");
    ConcurrentHashMap localConcurrentHashMap = this.mUinFollowMap;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.clear();
    }
    localConcurrentHashMap = this.mFakeUinFollowMap;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.clear();
    }
  }
  
  public void clearFakeUinFollowed(String paramString)
  {
    ConcurrentHashMap localConcurrentHashMap = this.mFakeUinFollowMap;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.remove(paramString);
    }
  }
  
  public Integer getUinFollowed(String paramString)
  {
    Integer localInteger2 = (Integer)this.mFakeUinFollowMap.get(paramString);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = (Integer)this.mUinFollowMap.get(paramString);
    }
    return localInteger1;
  }
  
  public boolean hasUin(String paramString)
  {
    return (paramString != null) && ((this.mFakeUinFollowMap.containsKey(paramString)) || (this.mUinFollowMap.containsKey(paramString)));
  }
  
  public boolean isUinFollowed(String paramString)
  {
    boolean bool3 = hasUin(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramString = getUinFollowed(paramString);
      if (paramString.intValue() != 1)
      {
        bool1 = bool2;
        if (paramString.intValue() != 3) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void setFakeUinFollowed(String paramString, int paramInt)
  {
    ConcurrentHashMap localConcurrentHashMap = this.mFakeUinFollowMap;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.put(paramString, Integer.valueOf(paramInt));
    }
  }
  
  public void setUinFollowed(String paramString, int paramInt)
  {
    ConcurrentHashMap localConcurrentHashMap = this.mUinFollowMap;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.put(paramString, Integer.valueOf(paramInt));
    }
    clearFakeUinFollowed(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.helpers.QCircleFollowManager
 * JD-Core Version:    0.7.0.1
 */