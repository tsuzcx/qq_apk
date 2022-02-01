package io.flutter.embedding.engine.mutatorsstack;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import io.flutter.embedding.android.AndroidTouchProcessor;
import java.util.Iterator;
import java.util.List;

public class FlutterMutatorView
  extends FrameLayout
{
  private final AndroidTouchProcessor androidTouchProcessor;
  private int left;
  private FlutterMutatorsStack mutatorsStack;
  private int prevLeft;
  private int prevTop;
  private float screenDensity;
  private int top;
  
  public FlutterMutatorView(@NonNull Context paramContext)
  {
    super(paramContext, null);
    this.screenDensity = 1.0F;
    this.androidTouchProcessor = null;
  }
  
  public FlutterMutatorView(@NonNull Context paramContext, float paramFloat, @NonNull AndroidTouchProcessor paramAndroidTouchProcessor)
  {
    super(paramContext, null);
    this.screenDensity = paramFloat;
    this.androidTouchProcessor = paramAndroidTouchProcessor;
  }
  
  private Matrix getPlatformViewMatrix()
  {
    Matrix localMatrix = new Matrix(this.mutatorsStack.getFinalMatrix());
    localMatrix.preScale(1.0F / this.screenDensity, 1.0F / this.screenDensity);
    localMatrix.postTranslate(-this.left, -this.top);
    return localMatrix;
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.concat(getPlatformViewMatrix());
    super.dispatchDraw(paramCanvas);
    paramCanvas.restore();
  }
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.save();
    Iterator localIterator = this.mutatorsStack.getFinalClippingPaths().iterator();
    while (localIterator.hasNext())
    {
      Path localPath = new Path((Path)localIterator.next());
      localPath.offset(-this.left, -this.top);
      paramCanvas.clipPath(localPath);
    }
    super.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.androidTouchProcessor == null) {
      return super.onTouchEvent(paramMotionEvent);
    }
    Matrix localMatrix = new Matrix();
    int i = paramMotionEvent.getAction();
    if (i != 0) {
      if (i != 2) {
        localMatrix.postTranslate(this.left, this.top);
      }
    }
    for (;;)
    {
      return this.androidTouchProcessor.onTouchEvent(paramMotionEvent, localMatrix);
      localMatrix.postTranslate(this.prevLeft, this.prevTop);
      this.prevLeft = this.left;
      this.prevTop = this.top;
      continue;
      this.prevLeft = this.left;
      this.prevTop = this.top;
      localMatrix.postTranslate(this.left, this.top);
    }
  }
  
  public void readyToDisplay(@NonNull FlutterMutatorsStack paramFlutterMutatorsStack, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mutatorsStack = paramFlutterMutatorsStack;
    this.left = paramInt1;
    this.top = paramInt2;
    paramFlutterMutatorsStack = new FrameLayout.LayoutParams(paramInt3, paramInt4);
    paramFlutterMutatorsStack.leftMargin = paramInt1;
    paramFlutterMutatorsStack.topMargin = paramInt2;
    setLayoutParams(paramFlutterMutatorsStack);
    setWillNotDraw(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.engine.mutatorsstack.FlutterMutatorView
 * JD-Core Version:    0.7.0.1
 */