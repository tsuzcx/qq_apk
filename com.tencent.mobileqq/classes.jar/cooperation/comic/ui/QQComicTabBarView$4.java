package cooperation.comic.ui;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class QQComicTabBarView$4
  implements Runnable
{
  QQComicTabBarView$4(QQComicTabBarView paramQQComicTabBarView) {}
  
  public void run()
  {
    Drawable localDrawable = this.this$0.getResources().getDrawable(2130850200);
    ThreadManager.getUIHandler().post(new QQComicTabBarView.4.1(this, localDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.comic.ui.QQComicTabBarView.4
 * JD-Core Version:    0.7.0.1
 */