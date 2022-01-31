package io.flutter.view;

import android.support.annotation.NonNull;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.FlutterRenderer.RenderSurface;
import io.flutter.embedding.engine.renderer.OnFirstFrameRenderedListener;
import java.nio.ByteBuffer;

final class FlutterNativeView$RenderSurfaceImpl
  implements FlutterRenderer.RenderSurface
{
  private FlutterNativeView$RenderSurfaceImpl(FlutterNativeView paramFlutterNativeView) {}
  
  public void addOnFirstFrameRenderedListener(@NonNull OnFirstFrameRenderedListener paramOnFirstFrameRenderedListener) {}
  
  public void attachToRenderer(@NonNull FlutterRenderer paramFlutterRenderer) {}
  
  public void detachFromRenderer() {}
  
  public void onFirstFrameRendered()
  {
    if (FlutterNativeView.access$200(this.this$0) == null) {
      return;
    }
    FlutterNativeView.access$200(this.this$0).onFirstFrame();
  }
  
  public void removeOnFirstFrameRenderedListener(@NonNull OnFirstFrameRenderedListener paramOnFirstFrameRenderedListener) {}
  
  public void updateCustomAccessibilityActions(ByteBuffer paramByteBuffer, String[] paramArrayOfString)
  {
    if (FlutterNativeView.access$200(this.this$0) == null) {
      return;
    }
    FlutterNativeView.access$200(this.this$0).updateCustomAccessibilityActions(paramByteBuffer, paramArrayOfString);
  }
  
  public void updateSemantics(ByteBuffer paramByteBuffer, String[] paramArrayOfString)
  {
    if (FlutterNativeView.access$200(this.this$0) == null) {
      return;
    }
    FlutterNativeView.access$200(this.this$0).updateSemantics(paramByteBuffer, paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.view.FlutterNativeView.RenderSurfaceImpl
 * JD-Core Version:    0.7.0.1
 */