package cooperation.comic.utils;

import com.tencent.qphone.base.util.QLog;

class QQComicRedTouchManager$PluginRedTouchObserver$1
  implements Runnable
{
  QQComicRedTouchManager$PluginRedTouchObserver$1(QQComicRedTouchManager.PluginRedTouchObserver paramPluginRedTouchObserver) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PluginRedTouchManager", 2, "onReceiveNewRedTouch()");
    }
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.utils.QQComicRedTouchManager.PluginRedTouchObserver.1
 * JD-Core Version:    0.7.0.1
 */