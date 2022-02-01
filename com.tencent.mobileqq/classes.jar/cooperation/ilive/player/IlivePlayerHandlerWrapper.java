package cooperation.ilive.player;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;

public class IlivePlayerHandlerWrapper
{
  private Handler a;
  private HandlerThread b;
  
  public IlivePlayerHandlerWrapper(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("create IlivePlayerHandlerWrapper ");
      localStringBuilder.append(paramInt);
      QLog.d("PlayerAsyncHandler", 2, localStringBuilder.toString());
    }
    this.b = new HandlerThread(b(String.valueOf(paramInt)), 10);
    this.b.start();
    this.a = new Handler(this.b.getLooper());
  }
  
  private String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("live-player-thread");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public Looper a()
  {
    HandlerThread localHandlerThread = this.b;
    if (localHandlerThread == null) {
      return null;
    }
    return localHandlerThread.getLooper();
  }
  
  public void a(Runnable paramRunnable)
  {
    Handler localHandler = this.a;
    if (localHandler == null)
    {
      QLog.e("PlayerAsyncHandler", 1, "post mAsync handler is null");
      return;
    }
    localHandler.post(paramRunnable);
  }
  
  public void a(String paramString)
  {
    Object localObject = this.b;
    if (localObject == null)
    {
      QLog.e("PlayerAsyncHandler", 1, "rename mAsync handler is null");
      return;
    }
    localObject = ((HandlerThread)localObject).getName();
    paramString = b(paramString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("rename origin:");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" setName:");
      localStringBuilder.append(paramString);
      QLog.d("PlayerAsyncHandler", 2, localStringBuilder.toString());
    }
    this.b.setName(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.player.IlivePlayerHandlerWrapper
 * JD-Core Version:    0.7.0.1
 */