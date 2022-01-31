package cooperation.comic.ui;

import binm;
import biof;
import bioj;
import com.tencent.qphone.base.util.QLog;

class QQComicTabBarView$6
  implements Runnable
{
  QQComicTabBarView$6(QQComicTabBarView paramQQComicTabBarView) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Bioj != null) {
      this.this$0.jdField_a_of_type_Bioj.deleteObserver(this.this$0.jdField_a_of_type_Biol);
    }
    if (biof.a != null) {
      biof.a.b(this.this$0.jdField_a_of_type_Binl);
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