package cooperation.comic.ui;

import binm;
import biof;
import bioj;
import com.tencent.common.app.AppInterface;
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
    this.this$0.jdField_a_of_type_Bioj = ((bioj)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(213));
    if (this.this$0.jdField_a_of_type_Bioj != null) {
      this.this$0.jdField_a_of_type_Bioj.addObserver(this.this$0.jdField_a_of_type_Biol);
    }
    if (biof.a != null) {
      biof.a.a(this.this$0.jdField_a_of_type_Binl);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebViewTabBarView", 2, "register observers");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.comic.ui.QQComicTabBarView.5
 * JD-Core Version:    0.7.0.1
 */