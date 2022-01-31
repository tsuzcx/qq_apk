import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.OfflineUtils;
import com.tencent.common.app.BaseApplicationImpl;

public final class mqy
  implements Runnable
{
  public void run()
  {
    HtmlOffline.b(OfflineUtils.a(), BaseApplicationImpl.getApplication().getRuntime(), true, OfflineUtils.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mqy
 * JD-Core Version:    0.7.0.1
 */