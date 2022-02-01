package cooperation.comic.ui;

import bkgb;
import bkgu;
import bkgy;
import com.tencent.qphone.base.util.QLog;

class QQComicTabBarView$6
  implements Runnable
{
  QQComicTabBarView$6(QQComicTabBarView paramQQComicTabBarView) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Bkgy != null) {
      this.this$0.jdField_a_of_type_Bkgy.deleteObserver(this.this$0.jdField_a_of_type_Bkha);
    }
    if (bkgu.a != null) {
      bkgu.a.b(this.this$0.jdField_a_of_type_Bkga);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebViewTabBarView", 2, "unregister observers");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.comic.ui.QQComicTabBarView.6
 * JD-Core Version:    0.7.0.1
 */