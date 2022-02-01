package me.ele.uetool.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
import me.ele.uetool.util.ImageCapture;
import me.ele.uetool.util.JarResource;
import me.ele.uetool.util.Util;

@RequiresApi(api=21)
public class ColorPickerFloatView
  extends FrameLayout
{
  public static final int PICK_AREA_SIZE = 32;
  public static final int PICK_VIEW_SIZE = 512;
  private static WeakReference<ColorPickerFloatView> instance;
  private ImageView close;
  private int color;
  private ColorPickerView colorPickerView;
  private GestureDetector detector;
  private int downX;
  private int downY;
  GestureDetector.OnGestureListener gestureListener = new ColorPickerFloatView.1(this);
  private int height;
  private boolean isShowing = false;
  private int lastX;
  private int lastY;
  private ImageCapture mImageCapture;
  private WindowManager.LayoutParams params = new WindowManager.LayoutParams();
  private int statuBarHeight;
  private int width;
  WindowManager windowManager;
  
  public ColorPickerFloatView(Context paramContext)
  {
    super(paramContext);
    instance = new WeakReference(this);
    inflate(paramContext, JarResource.getIdByName("layout", "qb_uet_color_picker"), this);
    this.close = ((ImageView)findViewById(JarResource.getIdByName("id", "close")));
    this.close.setOnClickListener(new ColorPickerFloatView.2(this));
    this.windowManager = ((WindowManager)paramContext.getSystemService("window"));
    getWindowLayoutParams();
    this.detector = new GestureDetector(paramContext, this.gestureListener);
    this.colorPickerView = ((ColorPickerView)findViewById(JarResource.getIdByName("id", "picker_view")));
    this.width = Util.getWidth();
    this.height = Util.getRealHeightPixels();
    this.statuBarHeight = Util.getStatusBarHeight();
    paramContext = this.colorPickerView.getLayoutParams();
    paramContext.width = 512;
    paramContext.height = 512;
    this.colorPickerView.setLayoutParams(paramContext);
  }
  
  private void captureInfo(int paramInt)
  {
    getRootView().setVisibility(8);
    getRootView().postDelayed(new ColorPickerFloatView.3(this), paramInt);
  }
  
  private void checkBound(WindowManager.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams.x < -this.colorPickerView.getWidth() / 2) {
      paramLayoutParams.x = (-this.colorPickerView.getWidth() / 2);
    }
    if (paramLayoutParams.x > this.width - this.colorPickerView.getWidth() / 2 - 16) {
      paramLayoutParams.x = (this.width - this.colorPickerView.getWidth() / 2 - 16);
    }
    if (paramLayoutParams.y < -this.colorPickerView.getHeight() / 2 - this.statuBarHeight) {
      paramLayoutParams.y = (-this.colorPickerView.getHeight() / 2 - this.statuBarHeight);
    }
    if (paramLayoutParams.y > this.height - this.colorPickerView.getHeight() / 2 - this.statuBarHeight) {
      paramLayoutParams.y = (this.height - this.colorPickerView.getHeight() / 2 - this.statuBarHeight);
    }
  }
  
  private void getWindowLayoutParams()
  {
    this.params.width = -2;
    this.params.height = -2;
    this.params.flags = 520;
    if (Build.VERSION.SDK_INT < 26) {}
    for (this.params.type = 2003;; this.params.type = 2038)
    {
      this.params.format = -3;
      this.params.gravity = 51;
      this.params.x = 0;
      this.params.y = 0;
      return;
    }
  }
  
  public static boolean removeView()
  {
    if ((instance == null) || (instance.get() == null)) {
      return false;
    }
    return ((ColorPickerFloatView)instance.get()).removeFromWindow();
  }
  
  @RequiresApi(api=21)
  private void showInfo()
  {
    int i = this.params.x;
    int j = this.params.y;
    int k = i + 256 - 16;
    int m = j + 256 - 16 + Util.getStatusBarHeight();
    Bitmap localBitmap = this.mImageCapture.getPartBitmap(k, m, 32, 32);
    if (localBitmap == null) {
      return;
    }
    int n = localBitmap.getPixel(localBitmap.getWidth() / 2, localBitmap.getHeight() / 2);
    this.close.setBackgroundColor(16777215);
    this.color = n;
    this.colorPickerView.setRotation(0);
    if (i < 0) {
      this.colorPickerView.setRotation(90);
    }
    if (i + 512 > this.width) {
      this.colorPickerView.setRotation(270);
    }
    if (j < 0) {
      this.colorPickerView.setRotation(180);
    }
    this.colorPickerView.setBitmap(localBitmap, n, k, m);
  }
  
  public void addToWindow()
  {
    if (!this.isShowing)
    {
      this.windowManager.addView(this, this.params);
      captureInfo(100);
      this.isShowing = true;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.detector.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public boolean removeFromWindow()
  {
    boolean bool = false;
    if (this.isShowing)
    {
      if (this.mImageCapture != null) {
        this.mImageCapture.destroy();
      }
      this.windowManager.removeViewImmediate(this);
      this.isShowing = false;
      bool = true;
    }
    return bool;
  }
  
  public void setmImageCapture(ImageCapture paramImageCapture)
  {
    this.mImageCapture = paramImageCapture;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.view.ColorPickerFloatView
 * JD-Core Version:    0.7.0.1
 */