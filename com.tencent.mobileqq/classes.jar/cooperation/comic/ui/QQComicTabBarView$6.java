package cooperation.comic.ui;

import bgih;
import bgja;
import bgje;
import com.tencent.qphone.base.util.QLog;

class QQComicTabBarView$6
  implements Runnable
{
  QQComicTabBarView$6(QQComicTabBarView paramQQComicTabBarView) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Bgje != null) {
      this.this$0.jdField_a_of_type_Bgje.deleteObserver(this.this$0.jdField_a_of_type_Bgjg);
    }
    if (bgja.a != null) {
      bgja.a.b(this.this$0.jdField_a_of_type_Bgig);
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