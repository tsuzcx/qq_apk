package cooperation.qzone.video;

import android.graphics.drawable.Drawable;
import cooperation.qzone.webviewwrapper.LiveVideoFeedVipIconListner;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class QzoneLiveVideoInterface$3
  implements InvocationHandler
{
  QzoneLiveVideoInterface$3(LiveVideoFeedVipIconListner paramLiveVideoFeedVipIconListner) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if (paramMethod.getName().equals("onFailed"))
    {
      paramObject = this.val$resourceLoaderListener;
      if (paramObject != null) {
        paramObject.onFailed();
      }
    }
    else if (paramMethod.getName().equals("onLoaded"))
    {
      paramObject = this.val$resourceLoaderListener;
      if (paramObject != null) {
        paramObject.onLoaded((Drawable)paramArrayOfObject[0]);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.video.QzoneLiveVideoInterface.3
 * JD-Core Version:    0.7.0.1
 */