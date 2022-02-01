package cooperation.qqcircle.helpers;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import java.util.concurrent.ConcurrentHashMap;

public class QCircleFollowManager
{
  public static final String TAG = QCircleFollowManager.class.getSimpleName();
  private static volatile QCircleFollowManager sInstance;
  private ConcurrentHashMap<String, Integer> mFakeUinFollowMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Integer> mUinFollowMap = new ConcurrentHashMap();
  
  public static QCircleFollowManager getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new QCircleFollowManager();
      }
      return sInstance;
    }
    finally {}
  }
  
  public void clearAll()
  {
    RFLog.i(TAG, RFLog.USR, "clear all");
    if (this.mUinFollowMap != null) {
      this.mUinFollowMap.clear();
    }
    if (this.mFakeUinFollowMap != null) {
      this.mFakeUinFollowMap.clear();
    }
  }
  
  public void clearFakeUinFollowed(String paramString)
  {
    if (this.mFakeUinFollowMap != null) {
      this.mFakeUinFollowMap.remove(paramString);
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
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (hasUin(paramString))
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
    if (this.mFakeUinFollowMap != null) {
      this.mFakeUinFollowMap.put(paramString, Integer.valueOf(paramInt));
    }
  }
  
  public void setUinFollowed(String paramString, int paramInt)
  {
    if (this.mUinFollowMap != null) {
      this.mUinFollowMap.put(paramString, Integer.valueOf(paramInt));
    }
    clearFakeUinFollowed(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.helpers.QCircleFollowManager
 * JD-Core Version:    0.7.0.1
 */