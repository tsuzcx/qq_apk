package dov.com.qq.im.ae.gif.preview;

import android.content.Context;
import android.media.MediaPlayer;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import biuu;
import biuv;

public class VideoPlayView
  extends GLSurfaceView
{
  private static final String jdField_a_of_type_JavaLangString = VideoPlayView.class.getSimpleName();
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private final biuv jdField_a_of_type_Biuv;
  
  public VideoPlayView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 0, 0);
    this.jdField_a_of_type_Biuv = new biuv(this);
    setRenderer(this.jdField_a_of_type_Biuv);
    setRenderMode(0);
  }
  
  public VideoPlayView a(MediaPlayer paramMediaPlayer)
  {
    if (paramMediaPlayer == null) {
      return this;
    }
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
    this.jdField_a_of_type_AndroidMediaMediaPlayer = paramMediaPlayer;
    this.jdField_a_of_type_Biuv.a(paramMediaPlayer);
    return this;
  }
  
  public void a()
  {
    queueEvent(new VideoPlayView.1(this));
  }
  
  public void setFrameRenderCallback(biuu parambiuu)
  {
    if (this.jdField_a_of_type_Biuv != null) {
      this.jdField_a_of_type_Biuv.a(parambiuu);
    }
  }
  
  public void setNeedComposeAlpha(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Biuv != null) {
      this.jdField_a_of_type_Biuv.a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.preview.VideoPlayView
 * JD-Core Version:    0.7.0.1
 */