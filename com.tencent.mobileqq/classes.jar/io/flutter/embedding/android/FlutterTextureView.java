package io.flutter.embedding.android;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.Log;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.RenderSurface;

public class FlutterTextureView
  extends TextureView
  implements RenderSurface
{
  private static final String TAG = "FlutterTextureView";
  @Nullable
  private FlutterRenderer flutterRenderer;
  private boolean isAttachedToFlutterRenderer = false;
  private boolean isSurfaceAvailableForRendering = false;
  @Nullable
  private Surface renderSurface;
  private final TextureView.SurfaceTextureListener surfaceTextureListener = new FlutterTextureView.1(this);
  
  public FlutterTextureView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FlutterTextureView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void changeSurfaceSize(int paramInt1, int paramInt2)
  {
    if (this.flutterRenderer != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Notifying FlutterRenderer that Android surface size has changed to ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" x ");
      localStringBuilder.append(paramInt2);
      Log.v("FlutterTextureView", localStringBuilder.toString());
      this.flutterRenderer.surfaceChanged(paramInt1, paramInt2);
      return;
    }
    throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
  }
  
  private void connectSurfaceToRenderer()
  {
    if ((this.flutterRenderer != null) && (getSurfaceTexture() != null))
    {
      this.renderSurface = new Surface(getSurfaceTexture());
      this.flutterRenderer.startRenderingToSurface(this.renderSurface);
      return;
    }
    throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
  }
  
  private void disconnectSurfaceFromRenderer()
  {
    Object localObject = this.flutterRenderer;
    if (localObject != null)
    {
      ((FlutterRenderer)localObject).stopRenderingToSurface();
      localObject = this.renderSurface;
      if (localObject != null)
      {
        ((Surface)localObject).release();
        this.renderSurface = null;
      }
      return;
    }
    throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
  }
  
  private void init()
  {
    setSurfaceTextureListener(this.surfaceTextureListener);
  }
  
  public void attachToRenderer(@NonNull FlutterRenderer paramFlutterRenderer)
  {
    Log.v("FlutterTextureView", "Attaching to FlutterRenderer.");
    if (this.flutterRenderer != null)
    {
      Log.v("FlutterTextureView", "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
      this.flutterRenderer.stopRenderingToSurface();
    }
    this.flutterRenderer = paramFlutterRenderer;
    this.isAttachedToFlutterRenderer = true;
    if (this.isSurfaceAvailableForRendering)
    {
      Log.v("FlutterTextureView", "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
      connectSurfaceToRenderer();
    }
  }
  
  public void detachFromRenderer()
  {
    if (this.flutterRenderer != null)
    {
      if (getWindowToken() != null)
      {
        Log.v("FlutterTextureView", "Disconnecting FlutterRenderer from Android surface.");
        disconnectSurfaceFromRenderer();
      }
      this.flutterRenderer = null;
      this.isAttachedToFlutterRenderer = false;
      return;
    }
    Log.w("FlutterTextureView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
  }
  
  @Nullable
  public FlutterRenderer getAttachedRenderer()
  {
    return this.flutterRenderer;
  }
  
  public void pause()
  {
    if (this.flutterRenderer != null)
    {
      this.flutterRenderer = null;
      this.isAttachedToFlutterRenderer = false;
      return;
    }
    Log.w("FlutterTextureView", "pause() invoked when no FlutterRenderer was attached.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterTextureView
 * JD-Core Version:    0.7.0.1
 */