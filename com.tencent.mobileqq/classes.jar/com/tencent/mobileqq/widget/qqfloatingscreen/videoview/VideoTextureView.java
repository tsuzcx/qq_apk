package com.tencent.mobileqq.widget.qqfloatingscreen.videoview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import beym;
import beyn;
import beyo;
import beyp;
import beyq;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import java.lang.ref.WeakReference;

public class VideoTextureView
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  private static IVideoOuterStatusListener jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenListenerIVideoOuterStatusListener;
  private int jdField_a_of_type_Int;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private beyq jdField_a_of_type_Beyq;
  public final Runnable a;
  private String jdField_a_of_type_JavaLangString = "http://videos.kpie.com.cn/videos/20170526/037DCE54-EECE-4520-AA92-E4002B1F29B0.mp4";
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  
  public VideoTextureView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRunnable = new VideoTextureView.6(this);
    setSurfaceTextureListener(this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_Beyq = new beyq(paramContext);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
      return;
    }
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new beym(this));
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new beyn(this));
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnSeekCompleteListener(new beyo(this));
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(new beyp(this));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidViewSurface = new Surface(paramSurfaceTexture);
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    }
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setSurface(this.jdField_a_of_type_AndroidViewSurface);
    a(this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void setVideoPath(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.videoview.VideoTextureView
 * JD-Core Version:    0.7.0.1
 */