import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.av.wtogether.media.WatchTogetherVideoDecodeHelper.3;
import com.tencent.av.wtogether.media.WatchTogetherVideoDecodeHelper.4;
import com.tencent.av.wtogether.media.WatchTogetherVideoDecodeHelper.5;
import com.tencent.av.wtogether.media.WatchTogetherVideoDecodeHelper.6;
import com.tencent.av.wtogether.media.WatchTogetherVideoDecodeHelper.7;
import com.tencent.av.wtogether.media.WatchTogetherVideoDecodeHelper.9;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EglHandlerThread;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.qphone.base.util.QLog;

public class mzm
  implements mzg
{
  private int jdField_a_of_type_Int = -1;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private final EglHandlerThread jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread;
  private myi jdField_a_of_type_Myi;
  private mzf jdField_a_of_type_Mzf;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  
  private mzm(Handler paramHandler, EglHandlerThread paramEglHandlerThread)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread = paramEglHandlerThread;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Int = GlUtil.createTexture(36197);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_Mzf = new mzf(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_Mzf.a(this);
    a(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, new mzn(this), paramHandler);
  }
  
  public static mzm a(String paramString)
  {
    QLog.d("WatchTogetherVideoDecodeHelper", 1, "createWatchTogetherVideoDecodeHelper");
    paramString = new EglHandlerThread(paramString, null);
    paramString.start();
    Handler localHandler = new Handler(paramString.getLooper());
    return (mzm)mzu.a(localHandler, new mzo(localHandler, paramString));
  }
  
  private static void a(SurfaceTexture paramSurfaceTexture, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, Handler paramHandler)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramSurfaceTexture.setOnFrameAvailableListener(paramOnFrameAvailableListener, paramHandler);
      return;
    }
    paramSurfaceTexture.setOnFrameAvailableListener(paramOnFrameAvailableListener);
  }
  
  private void a(String arg1)
  {
    if ((this.jdField_b_of_type_Boolean) || (!this.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_Int == -1) || (this.jdField_b_of_type_Int == -1))
    {
      QLog.d("WatchTogetherVideoDecodeHelper", 1, "tryDeliverTextureFrame from:=" + ??? + ",mIsQuiting:= " + this.jdField_b_of_type_Boolean + ",mHasPendingTexture:=" + this.jdField_c_of_type_Boolean);
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    if ((this.jdField_a_of_type_Myi == null) || (!this.e))
    {
      synchronized (this.jdField_a_of_type_Mzf)
      {
        if (this.jdField_a_of_type_Boolean) {
          break label152;
        }
        if (!this.jdField_a_of_type_Mzf.a())
        {
          this.jdField_c_of_type_Boolean = true;
          QLog.d("WatchTogetherVideoDecodeHelper", 1, "try recycle surfaceTexture later");
          return;
        }
      }
      QLog.d("WatchTogetherVideoDecodeHelper", 1, "recycle image stream");
      label152:
      return;
    }
    this.d = true;
    if (this.jdField_a_of_type_Boolean) {}
    synchronized (this.jdField_a_of_type_Mzf)
    {
      this.jdField_c_of_type_Int = -1;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Mzf.c();
      QLog.d("WatchTogetherVideoDecodeHelper", 1, "release image stream");
      this.jdField_a_of_type_Myi.a(this.jdField_a_of_type_Mzf, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      return;
    }
  }
  
  private void d()
  {
    QLog.d("WatchTogetherVideoDecodeHelper", 1, "release");
    if ((!this.jdField_b_of_type_Boolean) || (this.d)) {
      return;
    }
    if (this.jdField_c_of_type_Int > 0)
    {
      GlUtil.deleteTexture(this.jdField_c_of_type_Int);
      this.jdField_c_of_type_Int = -1;
    }
    if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)
    {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.release();
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
    }
    if (this.jdField_a_of_type_Mzf != null)
    {
      this.jdField_a_of_type_Mzf.b();
      this.jdField_a_of_type_Mzf = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread.quitSafely();
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    QLog.d("WatchTogetherVideoDecodeHelper", 1, "real release");
  }
  
  public SurfaceTexture a()
  {
    return this.jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  }
  
  public void a()
  {
    QLog.d("WatchTogetherVideoDecodeHelper", 1, "onResponsePauseMessage");
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new WatchTogetherVideoDecodeHelper.9(this));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QLog.d("WatchTogetherVideoDecodeHelper", 1, "setSurfaceTextureDefaultSize width:=" + paramInt1 + ",height:=" + paramInt2);
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new WatchTogetherVideoDecodeHelper.3(this, paramInt1, paramInt2));
  }
  
  public void a(Thread paramThread)
  {
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (this.jdField_a_of_type_AndroidOsHandler.getLooper().getThread() != paramThread)) {
      this.jdField_a_of_type_AndroidOsHandler.post(new WatchTogetherVideoDecodeHelper.7(this));
    }
  }
  
  public void a(myi parammyi)
  {
    QLog.d("WatchTogetherVideoDecodeHelper", 1, "startVideoSinkListener");
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new WatchTogetherVideoDecodeHelper.4(this, parammyi));
  }
  
  public void b()
  {
    QLog.d("WatchTogetherVideoDecodeHelper", 1, "stopVideoSinkListener");
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new WatchTogetherVideoDecodeHelper.5(this));
  }
  
  public void c()
  {
    QLog.d("WatchTogetherVideoDecodeHelper", 1, "dispose");
    mzu.a(this.jdField_a_of_type_AndroidOsHandler, new WatchTogetherVideoDecodeHelper.6(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mzm
 * JD-Core Version:    0.7.0.1
 */