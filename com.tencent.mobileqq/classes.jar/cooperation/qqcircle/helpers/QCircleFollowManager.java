package cooperation.qqcircle.helpers;

import com.tencent.TMG.utils.QLog;
import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class QCircleFollowManager
{
  public static final String TAG = QCircleFollowManager.class.getSimpleName();
  private static volatile QCircleFollowManager sInstance;
  private List<SoftReference<QCircleFollowManager.OnFollowListener>> mListenerList = new LinkedList();
  private ConcurrentHashMap<String, Boolean> mUinFollowMap = new ConcurrentHashMap();
  
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
    if (this.mUinFollowMap != null)
    {
      QLog.i(TAG, 1, "clear all");
      this.mUinFollowMap.clear();
    }
  }
  
  public boolean getUinFollowed(String paramString)
  {
    if (hasUin(paramString))
    {
      paramString = (Boolean)this.mUinFollowMap.get(paramString);
      if (paramString == null)
      {
        QLog.e(TAG, 1, "mUinFollowMap getValue uin null");
        return false;
      }
      return paramString.booleanValue();
    }
    return false;
  }
  
  public boolean hasUin(String paramString)
  {
    return (paramString != null) && (this.mUinFollowMap.containsKey(paramString));
  }
  
  public void setUinFollowed(String paramString, boolean paramBoolean)
  {
    if (this.mUinFollowMap != null) {
      this.mUinFollowMap.put(paramString, Boolean.valueOf(paramBoolean));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.helpers.QCircleFollowManager
 * JD-Core Version:    0.7.0.1
 */