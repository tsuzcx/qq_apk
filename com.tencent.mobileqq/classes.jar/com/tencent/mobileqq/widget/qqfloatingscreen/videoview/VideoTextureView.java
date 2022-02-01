package com.tencent.mobileqq.widget.qqfloatingscreen.videoview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import java.lang.ref.WeakReference;

public class VideoTextureView
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  private static IVideoOuterStatusListener jdField_a_of_type_ComTencentMobileqqQqfloatingwindowListenerIVideoOuterStatusListener;
  private int jdField_a_of_type_Int = 0;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private VideoTextureView.WeakHandler jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenVideoviewVideoTextureView$WeakHandler;
  final Runnable jdField_a_of_type_JavaLangRunnable = new VideoTextureView.6(this);
  private String jdField_a_of_type_JavaLangString = "https://www.w3schools.com/html/movie.mp4";
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  
  public VideoTextureView(Context paramContext)
  {
    super(paramContext);
    setSurfaceTextureListener(this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenVideoviewVideoTextureView$WeakHandler = new VideoTextureView.WeakHandler(paramContext);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenVideoviewVideoTextureView$WeakHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenVideoviewVideoTextureView$WeakHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
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
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new VideoTextureView.2(this));
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new VideoTextureView.3(this));
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnSeekCompleteListener(new VideoTextureView.4(this));
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(new VideoTextureView.5(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.videoview.VideoTextureView
 * JD-Core Version:    0.7.0.1
 */