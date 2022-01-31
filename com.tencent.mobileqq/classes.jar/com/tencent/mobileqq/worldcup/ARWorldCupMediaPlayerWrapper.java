package com.tencent.mobileqq.worldcup;

import alfq;
import alfr;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ARRenderModel.GreetingYUVProgram;
import com.tencent.mobileqq.ar.online_video.AROnlineVideoUtil;
import com.tencent.mobileqq.ar.online_video.AROnlineVideoView;
import com.tencent.mobileqq.ar.online_video.AROnlineVideoView.DrawCallback;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.TextureRender;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;

public class ARWorldCupMediaPlayerWrapper
  implements SurfaceTexture.OnFrameAvailableListener, AROnlineVideoView.DrawCallback, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnDownloadCallbackListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnSeekCompleteListener, TVK_IMediaPlayer.OnVideoPreparedListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private GreetingYUVProgram jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingYUVProgram = new GreetingYUVProgram(0);
  private AROnlineVideoView jdField_a_of_type_ComTencentMobileqqArOnline_videoAROnlineVideoView;
  private RenderBuffer jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender;
  private ARWorldCupMediaPlayerWrapper.OnPlayMediaStatusListener jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper$OnPlayMediaStatusListener;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private Runnable jdField_a_of_type_JavaLangRunnable = new alfq(this);
  volatile boolean jdField_a_of_type_Boolean = false;
  private float[] jdField_a_of_type_ArrayOfFloat = new float[16];
  private int[] jdField_a_of_type_ArrayOfInt = new int[3];
  private ByteBuffer[] jdField_a_of_type_ArrayOfJavaNioByteBuffer = new ByteBuffer[3];
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean;
  private float[] jdField_b_of_type_ArrayOfFloat = new float[16];
  private volatile boolean c;
  
  public ARWorldCupMediaPlayerWrapper(ARWorldCupMediaPlayerWrapper.OnPlayMediaStatusListener paramOnPlayMediaStatusListener, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper$OnPlayMediaStatusListener = paramOnPlayMediaStatusListener;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if ((this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0] == null) || (this.jdField_a_of_type_ArrayOfInt[0] != paramArrayOfByte1.length)) {}
    try
    {
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0] = ByteBuffer.allocateDirect(paramArrayOfByte1.length);
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0].order(ByteOrder.nativeOrder());
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0].clear();
      this.jdField_a_of_type_ArrayOfInt[0] = paramArrayOfByte1.length;
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0].put(paramArrayOfByte1);
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[0].position(0);
      if (this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1] != null) {
        if (this.jdField_a_of_type_ArrayOfInt[1] == paramArrayOfByte2.length) {
          break label128;
        }
      }
    }
    catch (Throwable localThrowable2)
    {
      try
      {
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1] = ByteBuffer.allocateDirect(paramArrayOfByte1.length);
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1].order(ByteOrder.nativeOrder());
        label128:
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1].clear();
        this.jdField_a_of_type_ArrayOfInt[1] = paramArrayOfByte2.length;
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1].put(paramArrayOfByte2);
        this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[1].position(0);
        if (this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2] != null) {
          if (this.jdField_a_of_type_ArrayOfInt[2] == paramArrayOfByte3.length) {
            break label212;
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        try
        {
          for (;;)
          {
            this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2] = ByteBuffer.allocateDirect(paramArrayOfByte1.length);
            this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2].order(ByteOrder.nativeOrder());
            label212:
            this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2].clear();
            this.jdField_a_of_type_ArrayOfInt[2] = paramArrayOfByte3.length;
            this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2].put(paramArrayOfByte3);
            this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[2].position(0);
            return;
            localThrowable1 = localThrowable1;
            QLog.e("ARWorldCupMediaPlayerWrapper", 1, "textureYUV fail.", localThrowable1);
          }
          localThrowable2 = localThrowable2;
          QLog.e("ARWorldCupMediaPlayerWrapper", 1, "textureYUV fail.", localThrowable2);
        }
        catch (Throwable paramArrayOfByte1)
        {
          for (;;)
          {
            QLog.e("ARWorldCupMediaPlayerWrapper", 1, "textureYUV fail.", paramArrayOfByte1);
          }
        }
      }
    }
  }
  
  private void e()
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 2, String.format("initVideoPlayer mVideoPlayer=%s", new Object[] { this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer }));
    TVK_IProxyFactory localTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if ((localTVK_IProxyFactory != null) && (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture == null))
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenTextures(1, arrayOfInt, 0);
      Matrix.setIdentityM(this.jdField_b_of_type_ArrayOfFloat, 0);
      this.jdField_b_of_type_Int = arrayOfInt[0];
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
      if (this.jdField_a_of_type_ComTencentMobileqqArOnline_videoAROnlineVideoView != null) {
        this.jdField_a_of_type_ComTencentMobileqqArOnline_videoAROnlineVideoView.a(null);
      }
      this.jdField_a_of_type_ComTencentMobileqqArOnline_videoAROnlineVideoView = new AROnlineVideoView(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
      this.jdField_a_of_type_ComTencentMobileqqArOnline_videoAROnlineVideoView.a(this);
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)
      {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = localTVK_IProxyFactory.createMediaPlayer(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqArOnline_videoAROnlineVideoView);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(this);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(this);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(this);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnDownloadCallback(this);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnSeekCompleteListener(this);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.updatePlayerVideoView(this.jdField_a_of_type_ComTencentMobileqqArOnline_videoAROnlineVideoView);
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer == null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getVideoWidth(), this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getVideoHeight(), 33984);
      QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupMediaPlayerWrapper.checkIfNeedUpdateRenderBuffer line1");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender = new TextureRender();
      QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupMediaPlayerWrapper.checkIfNeedUpdateRenderBuffer line2");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer != null) && (!GLES20.glIsTexture(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a()))) {
      QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupMediaPlayerWrapper.checkIfNeedUpdateRenderBuffer error happen,FBO texture ID is released");
    }
  }
  
  public void OnDownloadCallback(String paramString)
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 2, "TVK_IMediaPlayer.OnDownloadCallback");
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
    }
    return -1L;
  }
  
  public void a()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo(0);
        QLog.d("ARWorldCupMediaPlayerWrapper", 2, "mVideoPlayer restart seekTo(0)");
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ARWorldCupMediaPlayerWrapper", 1, "restart mVideoPlayer error happen", localException);
    }
  }
  
  public void a(String paramString, long paramLong, boolean paramBoolean)
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 2, String.format("playVideo videoUrl=%s videoSize=%s", new Object[] { paramString, Long.valueOf(paramLong) }));
    e();
    TVK_PlayerVideoInfo localTVK_PlayerVideoInfo;
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (!this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()))
    {
      localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
      if ((TextUtils.isEmpty(paramString)) || (paramString.startsWith("http"))) {
        break label152;
      }
      localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
      if (!this.jdField_b_of_type_Boolean) {
        break label144;
      }
    }
    label144:
    for (Object localObject = "true";; localObject = "false")
    {
      localTVK_PlayerVideoInfo.setConfigMap("software_play", (String)localObject);
      localTVK_PlayerVideoInfo.setPlayType(4);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setLoopback(paramBoolean);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(BaseApplicationImpl.getContext(), paramString, 0L, 0L, localTVK_PlayerVideoInfo);
      return;
    }
    label152:
    localTVK_PlayerVideoInfo.setConfigMap("file_dir", AROnlineVideoUtil.a(paramString));
    if (this.jdField_b_of_type_Boolean) {}
    for (localObject = "true";; localObject = "false")
    {
      localTVK_PlayerVideoInfo.setConfigMap("software_play", (String)localObject);
      localTVK_PlayerVideoInfo.setConfigMap("cache_servers_type", "20161009");
      localTVK_PlayerVideoInfo.setPlayMode("cache_extend_video");
      localTVK_PlayerVideoInfo.setVid(MD5Utils.d(paramString));
      localObject = new HashMap();
      ((HashMap)localObject).put("shouq_bus_type", "shouq_ar_online_video");
      localTVK_PlayerVideoInfo.setReportInfoMap((Map)localObject);
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(paramBoolean);
    }
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, boolean paramBoolean)
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupMediaPlayerWrapper.drawFrame softWare");
    paramArrayOfByte1 = new alfr(this, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt1, paramInt2);
    if (this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper$OnPlayMediaStatusListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper$OnPlayMediaStatusListener.a(paramArrayOfByte1);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying();
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (!this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()))
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    }
  }
  
  public void c()
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 2, "stopVideo");
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Long = 0L;
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()) {
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
        }
      }
      catch (Exception localException2)
      {
        localException2 = localException2;
        QLog.e("ARWorldCupMediaPlayerWrapper", 2, "playVideo fail.", localException2);
        try
        {
          if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture == null) {
            continue;
          }
          this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(null);
          this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.release();
          this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
          if (this.jdField_b_of_type_Int == -1) {
            continue;
          }
          GLES20.glDeleteTextures(1, new int[] { this.jdField_b_of_type_Int }, 0);
          this.jdField_b_of_type_Int = -1;
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer == null) {
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.d();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = null;
          return;
        }
        catch (Exception localException3)
        {
          QLog.e("ARWorldCupMediaPlayerWrapper", 1, "stopVideo finllay fail." + localException3);
          return;
        }
      }
      finally {}
      try
      {
        if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)
        {
          this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(null);
          this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.release();
          this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
        }
        if (this.jdField_b_of_type_Int != -1)
        {
          GLES20.glDeleteTextures(1, new int[] { this.jdField_b_of_type_Int }, 0);
          this.jdField_b_of_type_Int = -1;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.d();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = null;
        }
        return;
      }
      catch (Exception localException1)
      {
        QLog.e("ARWorldCupMediaPlayerWrapper", 1, "stopVideo finllay fail." + localException1);
        return;
      }
    }
    try
    {
      if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)
      {
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(null);
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.release();
        this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
      }
      if (this.jdField_b_of_type_Int != -1)
      {
        GLES20.glDeleteTextures(1, new int[] { this.jdField_b_of_type_Int }, 0);
        this.jdField_b_of_type_Int = -1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.d();
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = null;
      }
    }
    catch (Exception localException4)
    {
      for (;;)
      {
        QLog.e("ARWorldCupMediaPlayerWrapper", 1, "stopVideo finllay fail." + localException4);
      }
    }
    throw localObject;
  }
  
  public void d()
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 2, String.format("releaseVideoPlayer mVideoPlayer=%s", new Object[] { this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer }));
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper$OnPlayMediaStatusListener = null;
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
      {
        this.c = true;
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
        this.jdField_a_of_type_ComTencentMobileqqArARRenderModelGreetingYUVProgram.c();
        if (this.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)
        {
          this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(null);
          this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.release();
          this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
        }
        if (this.jdField_b_of_type_Int != -1)
        {
          GLES20.glDeleteTextures(1, new int[] { this.jdField_b_of_type_Int }, 0);
          this.jdField_b_of_type_Int = -1;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.d();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = null;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender != null) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a();
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ARWorldCupMediaPlayerWrapper", 1, "release finllay fail.");
    }
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.jdField_a_of_type_Boolean = false;
    QLog.d("ARWorldCupMediaPlayerWrapper", 2, "TVK_IMediaPlayer.onCompletion");
    if ((this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper$OnPlayMediaStatusListener != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer != null)) {
      this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper$OnPlayMediaStatusListener.a(this.jdField_a_of_type_Int, 1, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a());
    }
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    this.jdField_a_of_type_Boolean = false;
    QLog.d("ARWorldCupMediaPlayerWrapper", 2, String.format("TVK_IMediaPlayer.onError model=%s what=%s position=%s detailInfo=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString }));
    return false;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper$OnPlayMediaStatusListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupMediaPlayerWrapper$OnPlayMediaStatusListener.a(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_Boolean = false;
    }
    try
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      return;
    }
    catch (Exception paramTVK_IMediaPlayer)
    {
      QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onSeekComplete fail.", paramTVK_IMediaPlayer);
    }
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    QLog.d("ARWorldCupMediaPlayerWrapper", 2, "TVK_IMediaPlayer.onVideoPrepared");
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      return;
    }
    catch (Exception paramTVK_IMediaPlayer)
    {
      QLog.d("ARWorldCupMediaPlayerWrapper", 1, "TVK_IMediaPlayer.onVideoPrepared fail.", paramTVK_IMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.worldcup.ARWorldCupMediaPlayerWrapper
 * JD-Core Version:    0.7.0.1
 */