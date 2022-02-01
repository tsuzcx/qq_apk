package cooperation.groupvideo;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.groupvideo.api.IGroupVideoWrapper;
import cooperation.groupvideo.api.IGroupVideoWrapper.OnGVideoReadyListener;

public class GroupVideoWrapper
{
  private static final IGroupVideoWrapper a = (IGroupVideoWrapper)QRoute.api(IGroupVideoWrapper.class);
  
  public GroupVideoWrapper(AppInterface paramAppInterface)
  {
    a.init(paramAppInterface);
  }
  
  public void a(IGroupVideoWrapper.OnGVideoReadyListener paramOnGVideoReadyListener)
  {
    a.initialize(paramOnGVideoReadyListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.groupvideo.GroupVideoWrapper
 * JD-Core Version:    0.7.0.1
 */