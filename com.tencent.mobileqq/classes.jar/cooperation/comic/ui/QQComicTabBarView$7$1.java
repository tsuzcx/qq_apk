package cooperation.comic.ui;

import android.view.View;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.redtouch.RedTouchUI;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.utils.SimpleBiMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

class QQComicTabBarView$7$1
  implements Runnable
{
  QQComicTabBarView$7$1(QQComicTabBarView.7 param7, ArrayList paramArrayList, boolean paramBoolean, Map paramMap) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewTabBarView", 2, "start show red touch");
    }
    int i = this.jdField_a_of_type_CooperationComicUiQQComicTabBarView$7.this$0.a();
    if ((i >= 0) && (i < QQComicTabBarView.a(this.jdField_a_of_type_CooperationComicUiQQComicTabBarView$7.this$0)))
    {
      localObject = QQComicTabBarView.a(this.jdField_a_of_type_CooperationComicUiQQComicTabBarView$7.this$0, i).getTag(-3);
      if (!(localObject instanceof QQComicTabBarView.ViewHolder)) {}
    }
    for (Object localObject = ((QQComicTabBarView.ViewHolder)localObject).a;; localObject = null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (this.jdField_a_of_type_Boolean) {}
        for (RedTouchUI localRedTouchUI = (RedTouchUI)this.jdField_a_of_type_CooperationComicUiQQComicTabBarView$7.this$0.a.get(str);; localRedTouchUI = (RedTouchUI)this.jdField_a_of_type_CooperationComicUiQQComicTabBarView$7.this$0.a.get(this.jdField_a_of_type_CooperationComicUiQQComicTabBarView$7.this$0.b.a(str)))
        {
          if ((localRedTouchUI == null) || (localRedTouchUI.equals(localObject))) {
            break label208;
          }
          this.jdField_a_of_type_CooperationComicUiQQComicTabBarView$7.this$0.a(localRedTouchUI, (RedAppInfo)this.jdField_a_of_type_JavaUtilMap.get(str), false);
          break;
        }
        label208:
        if (QLog.isColorLevel()) {
          QLog.d("WebViewTabBarView", 2, "cannot find red touch on path: " + str);
        }
      }
      this.jdField_a_of_type_CooperationComicUiQQComicTabBarView$7.this$0.b();
      if (QLog.isColorLevel()) {
        QLog.d("WebViewTabBarView", 2, "end show red touch");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.ui.QQComicTabBarView.7.1
 * JD-Core Version:    0.7.0.1
 */