package cooperation.qzone.contentbox;

import android.os.Bundle;
import mqq.observer.BusinessObserver;

public class QZoneMsgObserver
  implements BusinessObserver
{
  public static final int QZONE_LIKE_FEED = 100;
  public static final int QZONE_LOADMORE_MSG = 2;
  public static final int QZONE_PRELOAD_MSG = 0;
  public static final int QZONE_REFRESH_MSG = 1;
  public static final String TAG = "QZoneMsgManager.QZoneMsgObserver";
  
  protected boolean onDataValid(boolean paramBoolean, Bundle paramBundle)
  {
    return false;
  }
  
  protected void onLikeFeed(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onLoadMoreMsg(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onPreloadMsg(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onReFreshMsg(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (!onDataValid(paramBoolean, paramBundle)) {
      return;
    }
    if (paramInt == 0)
    {
      onPreloadMsg(paramBoolean, paramBundle);
      return;
    }
    if (paramInt == 1)
    {
      onReFreshMsg(paramBoolean, paramBundle);
      return;
    }
    if (paramInt == 2)
    {
      onLoadMoreMsg(paramBoolean, paramBundle);
      return;
    }
    if (paramInt == 100) {
      onLikeFeed(paramBoolean, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgObserver
 * JD-Core Version:    0.7.0.1
 */