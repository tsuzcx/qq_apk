package cooperation.ilive.player;

import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.api.ITPPlayer;
import java.util.concurrent.atomic.AtomicBoolean;

class IlivePlayerWrapper$8
  implements Runnable
{
  IlivePlayerWrapper$8(IlivePlayerWrapper paramIlivePlayerWrapper, String paramString) {}
  
  public void run()
  {
    if (IlivePlayerWrapper.a(this.this$0) == null)
    {
      QLog.e("CachePlayer", 1, "set loadUrl mPlayer = null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set loadUrl playUrl = ");
    localStringBuilder.append(this.a);
    QLog.i("CachePlayer", 1, localStringBuilder.toString());
    IlivePlayerWrapper.b(this.this$0).set(true);
    try
    {
      IlivePlayerWrapper.a(this.this$0).setDataSource(this.a);
      IlivePlayerWrapper.a(this.this$0).prepareAsync();
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    QLog.i("CachePlayer", 1, "set loadUrl finish");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.player.IlivePlayerWrapper.8
 * JD-Core Version:    0.7.0.1
 */