package com.tencent.tkd.topicsdk.ucrop.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/ucrop/view/StaticTextureVideoView;", "Landroid/view/TextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "filePath", "", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "mediaPlayer", "Landroid/media/MediaPlayer;", "onPreparedListener", "Landroid/media/MediaPlayer$OnPreparedListener;", "getOnPreparedListener", "()Landroid/media/MediaPlayer$OnPreparedListener;", "setOnPreparedListener", "(Landroid/media/MediaPlayer$OnPreparedListener;)V", "surface", "Landroid/view/Surface;", "onSurfaceTextureAvailable", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "seekTo", "position", "topicsdk-ucrop_release"}, k=1, mv={1, 1, 16})
public class StaticTextureVideoView
  extends TextureView
  implements TextureView.SurfaceTextureListener
{
  private MediaPlayer a;
  private Surface b;
  @Nullable
  private String c;
  @Nullable
  private MediaPlayer.OnPreparedListener d;
  
  public StaticTextureVideoView(@NotNull Context paramContext)
  {
    super(paramContext);
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
  }
  
  public StaticTextureVideoView(@NotNull Context paramContext, @NotNull AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
  }
  
  public StaticTextureVideoView(@NotNull Context paramContext, @NotNull AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setSurfaceTextureListener((TextureView.SurfaceTextureListener)this);
  }
  
  public final void a(int paramInt)
  {
    MediaPlayer localMediaPlayer = this.a;
    if (localMediaPlayer != null) {
      localMediaPlayer.seekTo(paramInt);
    }
  }
  
  @Nullable
  public final String getFilePath()
  {
    return this.c;
  }
  
  @Nullable
  public final MediaPlayer.OnPreparedListener getOnPreparedListener()
  {
    return this.d;
  }
  
  public void onSurfaceTextureAvailable(@Nullable SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    CharSequence localCharSequence = (CharSequence)this.c;
    if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
      paramInt1 = 0;
    } else {
      paramInt1 = 1;
    }
    if (paramInt1 != 0) {
      return;
    }
    this.b = new Surface(paramSurfaceTexture);
    paramSurfaceTexture = new MediaPlayer();
    paramSurfaceTexture.setDataSource(this.c);
    paramSurfaceTexture.setSurface(this.b);
    paramSurfaceTexture.setOnPreparedListener(this.d);
    paramSurfaceTexture.prepareAsync();
    paramSurfaceTexture.setOnVideoSizeChangedListener((MediaPlayer.OnVideoSizeChangedListener)new StaticTextureVideoView.onSurfaceTextureAvailable..inlined.apply.lambda.1(this));
    this.a = paramSurfaceTexture;
  }
  
  public boolean onSurfaceTextureDestroyed(@Nullable SurfaceTexture paramSurfaceTexture)
  {
    this.b = ((Surface)null);
    paramSurfaceTexture = this.a;
    if (paramSurfaceTexture != null)
    {
      paramSurfaceTexture.stop();
      paramSurfaceTexture.release();
    }
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(@Nullable SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public void onSurfaceTextureUpdated(@Nullable SurfaceTexture paramSurfaceTexture) {}
  
  public final void setFilePath(@Nullable String paramString)
  {
    this.c = paramString;
  }
  
  public final void setOnPreparedListener(@Nullable MediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.d = paramOnPreparedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.view.StaticTextureVideoView
 * JD-Core Version:    0.7.0.1
 */