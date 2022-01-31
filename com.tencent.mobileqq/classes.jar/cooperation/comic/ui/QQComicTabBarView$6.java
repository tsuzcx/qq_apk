package cooperation.comic.ui;

import bijf;
import bijy;
import bikc;
import com.tencent.qphone.base.util.QLog;

class QQComicTabBarView$6
  implements Runnable
{
  QQComicTabBarView$6(QQComicTabBarView paramQQComicTabBarView) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Bikc != null) {
      this.this$0.jdField_a_of_type_Bikc.deleteObserver(this.this$0.jdField_a_of_type_Bike);
    }
    if (bijy.a != null) {
      bijy.a.b(this.this$0.jdField_a_of_type_Bije);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebViewTabBarView", 2, "unregister observers");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.comic.ui.QQComicTabBarView.6
 * JD-Core Version:    0.7.0.1
 */