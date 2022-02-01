package cooperation.comic.ui;

import blrn;
import blsg;
import blsk;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class QQComicTabBarView$5
  implements Runnable
{
  QQComicTabBarView$5(QQComicTabBarView paramQQComicTabBarView) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
    this.this$0.jdField_a_of_type_Blsk = ((blsk)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.COMIC_RED_TOUCH_MANAGER));
    if (this.this$0.jdField_a_of_type_Blsk != null) {
      this.this$0.jdField_a_of_type_Blsk.addObserver(this.this$0.jdField_a_of_type_Blsm);
    }
    if (blsg.a != null) {
      blsg.a.a(this.this$0.jdField_a_of_type_Blrm);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebViewTabBarView", 2, "register observers");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.comic.ui.QQComicTabBarView.5
 * JD-Core Version:    0.7.0.1
 */