package cooperation.qqreader.view;

import bmfv;
import bmgm;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.util.ArrayList;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ReaderTabBarView$1
  implements Runnable
{
  ReaderTabBarView$1(ReaderTabBarView paramReaderTabBarView) {}
  
  public void run()
  {
    if (ReaderTabBarView.a(this.this$0).size() == 0) {
      this.this$0.b();
    }
    if (ReaderTabBarView.a(this.this$0) == null)
    {
      ReaderTabBarView.a(this.this$0, (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
      ReaderTabBarView.a(this.this$0, (bmfv)ReaderTabBarView.a(this.this$0).getManager(QQManagerFactory.READER_RED_TOUCH_MANAGER));
    }
    Map localMap = ReaderTabBarView.a(this.this$0).a(ReaderTabBarView.a(this.this$0));
    if (localMap == null)
    {
      bmgm.a("ReaderTabBarView", "RedAppInfoByPathList get map is null");
      return;
    }
    ReaderTabBarView.a(this.this$0).runOnUiThread(new ReaderTabBarView.1.1(this, localMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.view.ReaderTabBarView.1
 * JD-Core Version:    0.7.0.1
 */