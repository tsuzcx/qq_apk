package cooperation.comic.utils;

import biol;
import com.tencent.qphone.base.util.QLog;

public class QQComicRedTouchManager$PluginRedTouchObserver$1
  implements Runnable
{
  public QQComicRedTouchManager$PluginRedTouchObserver$1(biol parambiol) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PluginRedTouchManager", 2, "onReceiveNewRedTouch()");
    }
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.comic.utils.QQComicRedTouchManager.PluginRedTouchObserver.1
 * JD-Core Version:    0.7.0.1
 */