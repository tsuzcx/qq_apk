package cooperation.comic.ui;

import bmce;
import bmcx;
import bmdb;
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
    this.this$0.jdField_a_of_type_Bmdb = ((bmdb)this.this$0.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(213));
    if (this.this$0.jdField_a_of_type_Bmdb != null) {
      this.this$0.jdField_a_of_type_Bmdb.addObserver(this.this$0.jdField_a_of_type_Bmdd);
    }
    if (bmcx.a != null) {
      bmcx.a.a(this.this$0.jdField_a_of_type_Bmcd);
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