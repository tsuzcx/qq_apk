package cooperation.groupvideo;

import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;

@RoutePage(desc="用于打开预埋的全屏透明的web页面", path="/gvideo/translucent/browser")
public class GVideoTranslucentBrowerActivity
  extends QQTranslucentBrowserActivity
{
  public GVideoTranslucentBrowerActivity()
  {
    this.mFragmentClass = GVideoTranslucentBrowerActivity.GVideoBrowserFragment.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.groupvideo.GVideoTranslucentBrowerActivity
 * JD-Core Version:    0.7.0.1
 */