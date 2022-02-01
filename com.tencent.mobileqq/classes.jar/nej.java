import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.3;
import com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.4;
import com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.5;
import com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.6;
import com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.8;
import com.tencent.avgame.gameroom.video.AVGameMediaPlayerWrapper.9;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnAudioFrameOutputListener;
import com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnDefinitionInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer.OnTVideoNetInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import java.util.ArrayList;

public class nej
  implements SurfaceTexture.OnFrameAvailableListener, SDKInitListener, ISuperPlayer.OnAudioFrameOutputListener, ISuperPlayer.OnCaptureImageListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnDefinitionInfoListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnTVideoNetInfoListener, ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnVideoSizeChangedListener
{
  private int jdField_a_of_type_Int = -1;
  private Point jdField_a_of_type_AndroidGraphicsPoint = new Point();
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private volatile ISuperPlayer jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
  private String jdField_a_of_type_JavaLangString;
  private nek jdField_a_of_type_Nek;
  private nfx jdField_a_of_type_Nfx;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c = true;
  private boolean d;
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidViewSurface != null)
    {
      this.jdField_a_of_type_AndroidViewSurface.release();
      this.jdField_a_of_type_AndroidViewSurface = null;
    }
    if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)
    {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(null);
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.release();
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
    }
    if (this.jdField_a_of_type_Int != -1)
    {
      GlUtil.deleteTexture(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = -1;
    }
  }
  
  private void e()
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "initMediaPlayer");
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer == null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = SuperPlayerFactory.createMediaPlayer(BaseApplicationImpl.getContext(), 107, null);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      d();
      this.jdField_a_of_type_Int = GlUtil.createTexture(36197);
      GLES20.glBindTexture(36197, 0);
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_a_of_type_Int);
      if (Build.VERSION.SDK_INT < 21) {
        break label218;
      }
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this, this.jdField_a_of_type_Nfx);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewSurface = new Surface(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setSurface(this.jdField_a_of_type_AndroidViewSurface);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnVideoPreparedListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnCaptureImageListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnInfoListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnErrorListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnDefinitionInfoListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnTVideoNetInfoUpdateListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnCompletionListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnVideoSizeChangedListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnSeekCompleteListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnAudioFrameOutputListener(this);
      return;
      label218:
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
    }
  }
  
  private void f()
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "releaseMediaPlayer");
    if (this.jdField_a_of_type_Nfx != null) {
      this.jdField_a_of_type_Nfx.post(new AVGameMediaPlayerWrapper.6(this));
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs();
  }
  
  public SurfaceTexture a()
  {
    return this.jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  }
  
  public void a()
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "releaseMgrRes");
    f();
  }
  
  public void a(String paramString, long paramLong)
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "playAudioByUrl url:=" + paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Nfx.post(new AVGameMediaPlayerWrapper.3(this, paramLong));
  }
  
  public void a(nek paramnek, nfx paramnfx)
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "addAVGameMediaPlayerCallBack");
    this.jdField_a_of_type_Nek = paramnek;
    this.jdField_a_of_type_Nfx = paramnfx;
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOutputMute(this.c);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) && (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isPlaying());
  }
  
  public void b()
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "stopVideoPlay");
    if (this.jdField_a_of_type_Nfx != null) {
      this.jdField_a_of_type_Nfx.post(new AVGameMediaPlayerWrapper.5(this));
    }
  }
  
  public void b(String paramString, long paramLong)
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "playVideoByUrl url:=" + paramString);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Nfx.post(new AVGameMediaPlayerWrapper.4(this, paramLong));
  }
  
  public void c()
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "doDestroy");
    f();
  }
  
  public void onAudioFrameOutput(TPAudioFrameBuffer paramTPAudioFrameBuffer)
  {
    if (this.jdField_a_of_type_Nek != null) {
      this.jdField_a_of_type_Nek.a(paramTPAudioFrameBuffer);
    }
  }
  
  public void onCaptureImageFailed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2) {}
  
  public void onCaptureImageSucceed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap) {}
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "onCompletion url:=" + this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Nek != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Nek.d(this.jdField_a_of_type_JavaLangString);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Nek.b(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onDefinitionInfoUpdate(ISuperPlayer paramISuperPlayer, String paramString, ArrayList<String> paramArrayList) {}
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QLog.e("AVGameMediaPlayerWrapper", 1, "PlayerCaptureProxy onError: module = " + paramInt1 + ", errorType = " + paramInt2 + ", errorCode = " + paramInt3 + ", extraInfo = " + paramString);
    if (!this.jdField_a_of_type_Boolean) {
      bdll.b(null, "dc00898", "", "", "0X800B0E7", "0X800B0E7", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      return false;
      bdll.b(null, "dc00898", "", "", "0X800B1F4", "0X800B1F4", 0, 0, "", "", "", "");
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if (this.jdField_a_of_type_Nfx != null)
    {
      if (this.b)
      {
        this.b = false;
        QLog.d("AVGameMediaPlayerWrapper", 1, "onFrameAvailable avalibale:= + " + this.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {}
    }
    else
    {
      return;
    }
    long l = System.currentTimeMillis();
    paramSurfaceTexture = this.jdField_a_of_type_Nfx.obtainMessage(256, this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y, Long.valueOf(l));
    this.jdField_a_of_type_Nfx.sendMessage(paramSurfaceTexture);
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    return false;
  }
  
  public void onSDKInited(boolean paramBoolean)
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "onSDKInited b:=" + paramBoolean);
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "onSeekComplete");
    if (this.jdField_a_of_type_Nfx != null) {
      this.jdField_a_of_type_Nfx.post(new AVGameMediaPlayerWrapper.9(this));
    }
  }
  
  public void onTVideoNetInfoUpdate(ISuperPlayer paramISuperPlayer, TVideoNetInfo paramTVideoNetInfo) {}
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    QLog.d("AVGameMediaPlayerWrapper", 1, "onVideoPrepared");
    if (this.jdField_a_of_type_Nfx != null) {
      this.jdField_a_of_type_Nfx.post(new AVGameMediaPlayerWrapper.8(this));
    }
  }
  
  public void onVideoSizeChanged(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nej
 * JD-Core Version:    0.7.0.1
 */