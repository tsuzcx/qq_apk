package cooperation.qzone.video;

import android.graphics.drawable.Drawable;
import cooperation.qzone.webviewwrapper.LiveVideoFeedVipIconListner;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class QzoneLiveVideoInterface$4
  implements InvocationHandler
{
  QzoneLiveVideoInterface$4(LiveVideoFeedVipIconListner paramLiveVideoFeedVipIconListner) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if (paramMethod.getName().equals("onFailed")) {
      if (this.val$resourceLoaderListener != null) {
        this.val$resourceLoaderListener.onFailed();
      }
    }
    for (;;)
    {
      return null;
      if ((paramMethod.getName().equals("onLoaded")) && (this.val$resourceLoaderListener != null)) {
        this.val$resourceLoaderListener.onLoaded((Drawable)paramArrayOfObject[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.video.QzoneLiveVideoInterface.4
 * JD-Core Version:    0.7.0.1
 */