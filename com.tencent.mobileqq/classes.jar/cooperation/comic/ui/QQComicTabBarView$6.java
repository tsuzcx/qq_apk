package cooperation.comic.ui;

import bezz;
import bfas;
import bfaw;
import com.tencent.qphone.base.util.QLog;

class QQComicTabBarView$6
  implements Runnable
{
  QQComicTabBarView$6(QQComicTabBarView paramQQComicTabBarView) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Bfaw != null) {
      this.this$0.jdField_a_of_type_Bfaw.deleteObserver(this.this$0.jdField_a_of_type_Bfay);
    }
    if (bfas.a != null) {
      bfas.a.b(this.this$0.jdField_a_of_type_Bezy);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebViewTabBarView", 2, "unregister observers");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.comic.ui.QQComicTabBarView.6
 * JD-Core Version:    0.7.0.1
 */