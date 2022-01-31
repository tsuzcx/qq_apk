package cooperation.comic.utils;

import aluk;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;

public abstract class QQComicRedTouchManager$PluginRedTouchObserver
  implements Observer
{
  public abstract void a();
  
  public final void update(Observable paramObservable, Object paramObject)
  {
    ThreadManager.getUIHandler().post(new aluk(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.comic.utils.QQComicRedTouchManager.PluginRedTouchObserver
 * JD-Core Version:    0.7.0.1
 */