package cooperation.comic.ui;

import bioj;
import bion;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

class QQComicTabBarView$7
  implements Runnable
{
  QQComicTabBarView$7(QQComicTabBarView paramQQComicTabBarView) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewTabBarView", 2, "start getRedAppInfo");
    }
    Object localObject = (bioj)((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web")).getManager(213);
    ArrayList localArrayList = new ArrayList();
    if (((bioj)localObject).a(1113)) {
      localArrayList.addAll(this.this$0.a.keySet());
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebViewTabBarView", 2, "isLebaItemOpen=" + bool + ", resId=" + 1113);
      }
      localObject = ((bioj)localObject).a(localArrayList);
      if (QLog.isColorLevel()) {
        QLog.d("WebViewTabBarView", 2, "end getRedAppInfo map is " + localObject);
      }
      if (localObject != null) {
        ThreadManager.getUIHandler().post(new QQComicTabBarView.7.1(this, localArrayList, bool, (Map)localObject));
      }
      return;
      Iterator localIterator = this.this$0.a.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localArrayList.add(this.this$0.b.get(str));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.comic.ui.QQComicTabBarView.7
 * JD-Core Version:    0.7.0.1
 */