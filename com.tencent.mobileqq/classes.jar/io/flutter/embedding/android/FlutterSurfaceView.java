package io.flutter.embedding.android;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.Log;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.renderer.RenderSurface;

public class FlutterSurfaceView
  extends SurfaceView
  implements RenderSurface
{
  private static final String TAG = "FlutterSurfaceView";
  @Nullable
  private FlutterRenderer flutterRenderer;
  private final FlutterUiDisplayListener flutterUiDisplayListener = new FlutterSurfaceView.2(this);
  private boolean isAttachedToFlutterRenderer = false;
  private boolean isSurfaceAvailableForRendering = false;
  private final boolean renderTransparently;
  private final SurfaceHolder.Callback surfaceCallback = new FlutterSurfaceView.1(this);
  
  public FlutterSurfaceView(@NonNull Context paramContext)
  {
    this(paramContext, null, false);
  }
  
  public FlutterSurfaceView(@NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, false);
  }
  
  private FlutterSurfaceView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet);
    this.renderTransparently = paramBoolean;
    init();
  }
  
  public FlutterSurfaceView(@NonNull Context paramContext, boolean paramBoolean)
  {
    this(paramContext, null, paramBoolean);
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
      Log.v("FlutterSurfaceView", localStringBuilder.toString());
      this.flutterRenderer.surfaceChanged(paramInt1, paramInt2);
      return;
    }
    throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
  }
  
  private void connectSurfaceToRenderer()
  {
    if ((this.flutterRenderer != null) && (getHolder() != null))
    {
      this.flutterRenderer.startRenderingToSurface(getHolder().getSurface());
      return;
    }
    throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
  }
  
  private void disconnectSurfaceFromRenderer()
  {
    if (this.flutterRenderer != null)
    {
      this.flutterRenderer.stopRenderingToSurface();
      return;
    }
    throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
  }
  
  private void init()
  {
    if (this.renderTransparently)
    {
      getHolder().setFormat(-2);
      setZOrderOnTop(true);
    }
    getHolder().addCallback(this.surfaceCallback);
    setAlpha(0.0F);
  }
  
  public void attachToRenderer(@NonNull FlutterRenderer paramFlutterRenderer)
  {
    Log.v("FlutterSurfaceView", "Attaching to FlutterRenderer.");
    if (this.flutterRenderer != null)
    {
      Log.v("FlutterSurfaceView", "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
      this.flutterRenderer.stopRenderingToSurface();
      this.flutterRenderer.removeIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
    }
    this.flutterRenderer = paramFlutterRenderer;
    this.isAttachedToFlutterRenderer = true;
    this.flutterRenderer.addIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
    if (this.isSurfaceAvailableForRendering)
    {
      Log.v("FlutterSurfaceView", "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
      connectSurfaceToRenderer();
    }
  }
  
  public void detachFromRenderer()
  {
    if (this.flutterRenderer != null)
    {
      if (getWindowToken() != null)
      {
        Log.v("FlutterSurfaceView", "Disconnecting FlutterRenderer from Android surface.");
        disconnectSurfaceFromRenderer();
      }
      setAlpha(0.0F);
      this.flutterRenderer.removeIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
      this.flutterRenderer = null;
      this.isAttachedToFlutterRenderer = false;
      return;
    }
    Log.w("FlutterSurfaceView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
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
    Log.w("FlutterSurfaceView", "pause() invoked when no FlutterRenderer was attached.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterSurfaceView
 * JD-Core Version:    0.7.0.1
 */