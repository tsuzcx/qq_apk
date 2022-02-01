package cooperation.comic.ui;

import com.tencent.qphone.base.util.QLog;
import cooperation.comic.jsp.QQComicDownloadObserverProxy;
import cooperation.comic.utils.QQComicPluginBridge;
import cooperation.comic.utils.QQComicRedTouchManager;

class QQComicTabBarView$6
  implements Runnable
{
  QQComicTabBarView$6(QQComicTabBarView paramQQComicTabBarView) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_CooperationComicUtilsQQComicRedTouchManager != null) {
      this.this$0.jdField_a_of_type_CooperationComicUtilsQQComicRedTouchManager.deleteObserver(this.this$0.jdField_a_of_type_CooperationComicUtilsQQComicRedTouchManager$PluginRedTouchObserver);
    }
    if (QQComicPluginBridge.a != null) {
      QQComicPluginBridge.a.b(this.this$0.jdField_a_of_type_CooperationComicJspQQComicDownloadCountObserver);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebViewTabBarView", 2, "unregister observers");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.ui.QQComicTabBarView.6
 * JD-Core Version:    0.7.0.1
 */