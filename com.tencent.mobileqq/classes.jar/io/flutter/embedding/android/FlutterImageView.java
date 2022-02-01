package io.flutter.embedding.android;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.ColorSpace.Named;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.RenderSurface;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

@TargetApi(19)
public class FlutterImageView
  extends View
  implements RenderSurface
{
  @Nullable
  private Bitmap currentBitmap;
  @Nullable
  private Image currentImage;
  @Nullable
  private FlutterRenderer flutterRenderer;
  @Nullable
  private Queue<Image> imageQueue;
  @NonNull
  private ImageReader imageReader;
  private boolean isAttachedToFlutterRenderer = false;
  private FlutterImageView.SurfaceKind kind;
  private int pendingImages = 0;
  
  public FlutterImageView(@NonNull Context paramContext)
  {
    this(paramContext, 1, 1, FlutterImageView.SurfaceKind.background);
  }
  
  public FlutterImageView(@NonNull Context paramContext, int paramInt1, int paramInt2, FlutterImageView.SurfaceKind paramSurfaceKind)
  {
    this(paramContext, createImageReader(paramInt1, paramInt2), paramSurfaceKind);
  }
  
  @VisibleForTesting
  FlutterImageView(@NonNull Context paramContext, @NonNull ImageReader paramImageReader, FlutterImageView.SurfaceKind paramSurfaceKind)
  {
    super(paramContext, null);
    this.imageReader = paramImageReader;
    this.kind = paramSurfaceKind;
    this.imageQueue = new LinkedList();
    init();
  }
  
  public FlutterImageView(@NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet)
  {
    this(paramContext, 1, 1, FlutterImageView.SurfaceKind.background);
  }
  
  @TargetApi(19)
  @NonNull
  private static ImageReader createImageReader(int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return ImageReader.newInstance(paramInt1, paramInt2, 1, 3, 768L);
    }
    return ImageReader.newInstance(paramInt1, paramInt2, 1, 3);
  }
  
  private void init()
  {
    setAlpha(0.0F);
  }
  
  @TargetApi(29)
  private void updateCurrentBitmap()
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      localObject = this.currentImage.getHardwareBuffer();
      this.currentBitmap = Bitmap.wrapHardwareBuffer((HardwareBuffer)localObject, ColorSpace.get(ColorSpace.Named.SRGB));
      ((HardwareBuffer)localObject).close();
      return;
    }
    Object localObject = this.currentImage.getPlanes();
    if (localObject.length != 1) {
      return;
    }
    localObject = localObject[0];
    int i = ((Image.Plane)localObject).getRowStride() / ((Image.Plane)localObject).getPixelStride();
    int j = this.currentImage.getHeight();
    Bitmap localBitmap = this.currentBitmap;
    if ((localBitmap == null) || (localBitmap.getWidth() != i) || (this.currentBitmap.getHeight() != j)) {
      this.currentBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    }
    this.currentBitmap.copyPixelsFromBuffer(((Image.Plane)localObject).getBuffer());
  }
  
  @TargetApi(19)
  public boolean acquireLatestImage()
  {
    if (!this.isAttachedToFlutterRenderer) {
      return false;
    }
    int j = this.imageQueue.size();
    int i = j;
    if (this.currentImage != null) {
      i = j + 1;
    }
    if (i < this.imageReader.getMaxImages())
    {
      Image localImage = this.imageReader.acquireLatestImage();
      if (localImage != null) {
        this.imageQueue.add(localImage);
      }
    }
    invalidate();
    return this.imageQueue.isEmpty() ^ true;
  }
  
  public void attachToRenderer(@NonNull FlutterRenderer paramFlutterRenderer)
  {
    if (this.isAttachedToFlutterRenderer) {
      return;
    }
    if (FlutterImageView.1.$SwitchMap$io$flutter$embedding$android$FlutterImageView$SurfaceKind[this.kind.ordinal()] == 1) {
      paramFlutterRenderer.swapSurface(this.imageReader.getSurface());
    }
    setAlpha(1.0F);
    this.flutterRenderer = paramFlutterRenderer;
    this.isAttachedToFlutterRenderer = true;
  }
  
  public void detachFromRenderer()
  {
    if (!this.isAttachedToFlutterRenderer) {
      return;
    }
    setAlpha(0.0F);
    acquireLatestImage();
    this.currentBitmap = null;
    Object localObject = this.imageQueue.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Image)((Iterator)localObject).next()).close();
    }
    this.imageQueue.clear();
    localObject = this.currentImage;
    if (localObject != null)
    {
      ((Image)localObject).close();
      this.currentImage = null;
    }
    invalidate();
    this.isAttachedToFlutterRenderer = false;
  }
  
  @Nullable
  public FlutterRenderer getAttachedRenderer()
  {
    return this.flutterRenderer;
  }
  
  @NonNull
  public Surface getSurface()
  {
    return this.imageReader.getSurface();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!this.imageQueue.isEmpty())
    {
      localObject = this.currentImage;
      if (localObject != null) {
        ((Image)localObject).close();
      }
      this.currentImage = ((Image)this.imageQueue.poll());
      updateCurrentBitmap();
    }
    Object localObject = this.currentBitmap;
    if (localObject != null) {
      paramCanvas.drawBitmap((Bitmap)localObject, 0.0F, 0.0F, null);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 == this.imageReader.getWidth()) && (paramInt2 == this.imageReader.getHeight())) {
      return;
    }
    if ((this.kind == FlutterImageView.SurfaceKind.background) && (this.isAttachedToFlutterRenderer))
    {
      resizeIfNeeded(paramInt1, paramInt2);
      this.flutterRenderer.swapSurface(this.imageReader.getSurface());
    }
  }
  
  public void pause() {}
  
  public void resizeIfNeeded(int paramInt1, int paramInt2)
  {
    if (this.flutterRenderer == null) {
      return;
    }
    if ((paramInt1 == this.imageReader.getWidth()) && (paramInt2 == this.imageReader.getHeight())) {
      return;
    }
    this.imageQueue.clear();
    this.currentImage = null;
    this.imageReader.close();
    this.imageReader = createImageReader(paramInt1, paramInt2);
    this.pendingImages = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.embedding.android.FlutterImageView
 * JD-Core Version:    0.7.0.1
 */