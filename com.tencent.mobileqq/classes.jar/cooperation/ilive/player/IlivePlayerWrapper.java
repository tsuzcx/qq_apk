package cooperation.ilive.player;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnCompletionListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnErrorListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnInfoListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnPreparedListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnSeekCompleteListener;
import com.tencent.thumbplayer.api.ITPPlayerListener.IOnStopAsyncCompleteListener;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPPlayerFactory;
import com.tencent.thumbplayer.api.report.ITPBusinessReportManager;
import java.util.concurrent.atomic.AtomicBoolean;

public class IlivePlayerWrapper
{
  private static int jdField_a_of_type_Int = 1;
  private static IlivePlayerWrapper jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper;
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  public HandlerThread a;
  private ITPPlayer jdField_a_of_type_ComTencentThumbplayerApiITPPlayer;
  private ITPPlayerListener.IOnCompletionListener jdField_a_of_type_ComTencentThumbplayerApiITPPlayerListener$IOnCompletionListener;
  private ITPPlayerListener.IOnErrorListener jdField_a_of_type_ComTencentThumbplayerApiITPPlayerListener$IOnErrorListener;
  private ITPPlayerListener.IOnInfoListener jdField_a_of_type_ComTencentThumbplayerApiITPPlayerListener$IOnInfoListener;
  private ITPPlayerListener.IOnPreparedListener jdField_a_of_type_ComTencentThumbplayerApiITPPlayerListener$IOnPreparedListener;
  private ITPPlayerListener.IOnSeekCompleteListener jdField_a_of_type_ComTencentThumbplayerApiITPPlayerListener$IOnSeekCompleteListener;
  private ITPPlayerListener.IOnStopAsyncCompleteListener jdField_a_of_type_ComTencentThumbplayerApiITPPlayerListener$IOnStopAsyncCompleteListener;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
  private AtomicBoolean b = new AtomicBoolean();
  
  public IlivePlayerWrapper(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = new StringBuilder();
    paramContext.append("TP-player-thread-");
    int i = jdField_a_of_type_Int;
    jdField_a_of_type_Int = i + 1;
    paramContext.append(i);
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread(paramContext.toString());
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    a(new IlivePlayerWrapper.1(this));
  }
  
  private void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new IlivePlayerWrapper.RunnableWrapper(paramRunnable));
  }
  
  private void h()
  {
    QLog.i("CachePlayer", 1, "start createTPPlayer");
    this.jdField_a_of_type_ComTencentThumbplayerApiITPPlayer = TPPlayerFactory.createTPPlayer(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentThumbplayerApiITPPlayer.setOnPreparedListener(new IlivePlayerWrapper.2(this));
    this.jdField_a_of_type_ComTencentThumbplayerApiITPPlayer.setOnInfoListener(new IlivePlayerWrapper.3(this));
    this.jdField_a_of_type_ComTencentThumbplayerApiITPPlayer.setOnErrorListener(new IlivePlayerWrapper.4(this));
    this.jdField_a_of_type_ComTencentThumbplayerApiITPPlayer.setOnSeekCompleteListener(new IlivePlayerWrapper.5(this));
    this.jdField_a_of_type_ComTencentThumbplayerApiITPPlayer.setOnCompletionListener(new IlivePlayerWrapper.6(this));
    this.jdField_a_of_type_ComTencentThumbplayerApiITPPlayer.setOnStopAsyncCompleteListener(new IlivePlayerWrapper.7(this));
    QLog.i("CachePlayer", 1, "finish createTPPlayer");
  }
  
  private void i()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.b.set(false);
    a();
  }
  
  public int a()
  {
    ITPPlayer localITPPlayer = this.jdField_a_of_type_ComTencentThumbplayerApiITPPlayer;
    if (localITPPlayer != null) {
      return localITPPlayer.getVideoWidth();
    }
    return 0;
  }
  
  public long a()
  {
    ITPPlayer localITPPlayer = this.jdField_a_of_type_ComTencentThumbplayerApiITPPlayer;
    if (localITPPlayer != null) {
      return localITPPlayer.getDurationMs();
    }
    return 0L;
  }
  
  public long a(int paramInt)
  {
    ITPPlayer localITPPlayer = this.jdField_a_of_type_ComTencentThumbplayerApiITPPlayer;
    if (localITPPlayer != null) {
      return localITPPlayer.getPropertyLong(paramInt);
    }
    return 0L;
  }
  
  public ITPBusinessReportManager a()
  {
    ITPPlayer localITPPlayer = this.jdField_a_of_type_ComTencentThumbplayerApiITPPlayer;
    if (localITPPlayer != null) {
      return localITPPlayer.getReportManager();
    }
    return null;
  }
  
  public void a()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    if (this.jdField_a_of_type_ComTencentThumbplayerApiITPPlayer != null)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("\nmCallPrepareState = ");
      localStringBuilder2.append(this.b.get());
      localStringBuilder2.append(" mPrepareState = ");
      localStringBuilder2.append(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    else
    {
      localStringBuilder1.append("\nmPlayer = null");
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("logCacheStatus: ");
    localStringBuilder2.append(localStringBuilder1.toString());
    QLog.i("CachePlayer", 1, localStringBuilder2.toString());
  }
  
  public void a(float paramFloat)
  {
    a(new IlivePlayerWrapper.17(this, paramFloat));
  }
  
  public void a(int paramInt)
  {
    a(new IlivePlayerWrapper.14(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(new IlivePlayerWrapper.15(this, paramInt1, paramInt2));
  }
  
  public void a(Surface paramSurface)
  {
    QLog.i("CachePlayer", 1, "start setSurface");
    a(new IlivePlayerWrapper.9(this, paramSurface));
  }
  
  public void a(ITPPlayerListener.IOnCompletionListener paramIOnCompletionListener)
  {
    this.jdField_a_of_type_ComTencentThumbplayerApiITPPlayerListener$IOnCompletionListener = paramIOnCompletionListener;
  }
  
  public void a(ITPPlayerListener.IOnErrorListener paramIOnErrorListener)
  {
    this.jdField_a_of_type_ComTencentThumbplayerApiITPPlayerListener$IOnErrorListener = paramIOnErrorListener;
  }
  
  public void a(ITPPlayerListener.IOnInfoListener paramIOnInfoListener)
  {
    this.jdField_a_of_type_ComTencentThumbplayerApiITPPlayerListener$IOnInfoListener = paramIOnInfoListener;
  }
  
  public void a(ITPPlayerListener.IOnPreparedListener paramIOnPreparedListener)
  {
    this.jdField_a_of_type_ComTencentThumbplayerApiITPPlayerListener$IOnPreparedListener = paramIOnPreparedListener;
  }
  
  public void a(ITPPlayerListener.IOnSeekCompleteListener paramIOnSeekCompleteListener)
  {
    this.jdField_a_of_type_ComTencentThumbplayerApiITPPlayerListener$IOnSeekCompleteListener = paramIOnSeekCompleteListener;
  }
  
  public void a(ITPPlayerListener.IOnStopAsyncCompleteListener paramIOnStopAsyncCompleteListener)
  {
    this.jdField_a_of_type_ComTencentThumbplayerApiITPPlayerListener$IOnStopAsyncCompleteListener = paramIOnStopAsyncCompleteListener;
  }
  
  public void a(TPOptionalParam paramTPOptionalParam)
  {
    a(new IlivePlayerWrapper.21(this, paramTPOptionalParam));
  }
  
  public void a(String paramString)
  {
    if (a())
    {
      QLog.e("CachePlayer", 1, "CachePlayer load url media wait CachePlayer prepare ");
      return;
    }
    QLog.e("CachePlayer", 1, "CachePlayer start loadUrl");
    a(new IlivePlayerWrapper.8(this, paramString));
  }
  
  public void a(boolean paramBoolean)
  {
    a(new IlivePlayerWrapper.16(this, paramBoolean));
  }
  
  public boolean a()
  {
    return this.b.get();
  }
  
  public int b()
  {
    ITPPlayer localITPPlayer = this.jdField_a_of_type_ComTencentThumbplayerApiITPPlayer;
    if (localITPPlayer != null) {
      return localITPPlayer.getVideoHeight();
    }
    return 0;
  }
  
  public long b()
  {
    ITPPlayer localITPPlayer = this.jdField_a_of_type_ComTencentThumbplayerApiITPPlayer;
    if (localITPPlayer != null) {
      return localITPPlayer.getCurrentPositionMs();
    }
    return 0L;
  }
  
  public void b()
  {
    a(new IlivePlayerWrapper.10(this));
  }
  
  public void b(float paramFloat)
  {
    a(new IlivePlayerWrapper.18(this, paramFloat));
  }
  
  public void b(boolean paramBoolean)
  {
    a(new IlivePlayerWrapper.19(this, paramBoolean));
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public int c()
  {
    ITPPlayer localITPPlayer = this.jdField_a_of_type_ComTencentThumbplayerApiITPPlayer;
    if (localITPPlayer != null) {
      return localITPPlayer.getBufferPercent();
    }
    return 0;
  }
  
  public void c()
  {
    i();
    a(new IlivePlayerWrapper.11(this));
    jdField_a_of_type_CooperationIlivePlayerIlivePlayerWrapper = null;
  }
  
  public void d()
  {
    i();
    a(new IlivePlayerWrapper.12(this));
  }
  
  public void e()
  {
    i();
    a(new IlivePlayerWrapper.13(this));
  }
  
  public void f()
  {
    a(new IlivePlayerWrapper.20(this));
  }
  
  public void g()
  {
    a(new IlivePlayerWrapper.22(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.player.IlivePlayerWrapper
 * JD-Core Version:    0.7.0.1
 */