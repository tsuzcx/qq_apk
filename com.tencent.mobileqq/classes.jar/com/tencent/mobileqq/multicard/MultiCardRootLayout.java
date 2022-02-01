package com.tencent.mobileqq.multicard;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import com.tencent.widget.FitSystemWindowsRelativeLayout.DispatchTouchEventListener;
import com.tencent.widget.FitSystemWindowsRelativeLayout.OnInterceptTouchEventListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class MultiCardRootLayout
  extends FitSystemWindowsRelativeLayout
{
  private static final ArrayList<String> v = new ArrayList();
  private FitSystemWindowsRelativeLayout.OnInterceptTouchEventListener j;
  private FitSystemWindowsRelativeLayout.DispatchTouchEventListener k;
  private Path l;
  private RectF m;
  private float n = ViewUtils.dpToPx(18.0F);
  private boolean o = true;
  private boolean p = true;
  private Paint q = null;
  private Paint r = null;
  private GestureDetector s;
  private boolean t = false;
  private WeakReference<MultiCardRootLayout.MultiCardRootLayoutListener> u;
  
  static
  {
    v.add("HUAWEI;VKY-AL00");
    v.add("Meizu;m3 note");
    v.add("samsung;SM-C7000");
    v.add("HUAWEI;JMM-AL00");
  }
  
  public MultiCardRootLayout(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public MultiCardRootLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
    b();
  }
  
  private void a(Canvas paramCanvas)
  {
    if (paramCanvas == null) {
      return;
    }
    if (this.r == null)
    {
      this.r = new Paint();
      this.r.setColor(getResources().getColor(2131168073));
      this.r.setStyle(Paint.Style.FILL);
    }
    if (this.q == null)
    {
      this.q = new Paint();
      this.q.setColor(getResources().getColor(2131168074));
      this.q.setStyle(Paint.Style.FILL);
    }
    if (this.o)
    {
      this.l.reset();
      this.m.set(0.0F, 0.0F, getWidth(), getHeight());
      Path localPath = this.l;
      RectF localRectF = this.m;
      float f = this.n;
      localPath.addRoundRect(localRectF, f, f, Path.Direction.CW);
      paramCanvas.clipPath(this.l);
    }
    paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.r);
    int i1 = (int)(getHeight() * 0.203704F);
    int i2 = (int)(getWidth() * 0.1034483F);
    int i = 0;
    while (i < 5)
    {
      a(paramCanvas, i2, i1);
      i1 += (int)(getHeight() * 0.139918F);
      i += 1;
    }
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    int i = (int)(getWidth() * 0.6275862F);
    int i1 = (int)(getWidth() * 0.796552F);
    int i2 = (int)(getHeight() * 0.02880658F);
    int i3 = (int)(getHeight() * 0.02469136F);
    int i4 = (int)(getHeight() * 0.02469136F);
    a(paramCanvas, paramInt1, paramInt2, i, i2);
    a(paramCanvas, paramInt1, paramInt2 + i4 + i2, i1, i3);
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Paint localPaint = this.q;
    if ((localPaint != null) && (paramCanvas != null)) {
      paramCanvas.drawRect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4, localPaint);
    }
  }
  
  private boolean a()
  {
    if ((Build.VERSION.SDK_INT == 24) && ("Xiaomi".equals(Build.MANUFACTURER)) && ("MIX".equals(Build.MODEL))) {
      return true;
    }
    if ((Build.VERSION.SDK_INT == 24) && ("HUAWEI".equals(Build.MANUFACTURER)) && ("BND-AL10".equals(Build.MODEL))) {
      return true;
    }
    if ((Build.VERSION.SDK_INT == 24) && ("HUAWEI".equals(Build.MANUFACTURER)) && ("HUAWEI CAZ-AL10".equals(Build.MODEL))) {
      return true;
    }
    if ((Build.VERSION.SDK_INT == 24) && ("Meizu".equals(Build.MANUFACTURER)) && ("M5 Note".equals(Build.MODEL))) {
      return true;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append(";");
    ((StringBuilder)localObject).append(Build.MODEL);
    localObject = ((StringBuilder)localObject).toString();
    return v.contains(localObject);
  }
  
  private void b()
  {
    setWillNotDraw(false);
    if ((Build.VERSION.SDK_INT <= 18) || (a())) {
      setLayerType(1, null);
    }
    this.l = new Path();
    this.m = new RectF();
    if (this.s == null) {
      this.s = new GestureDetector(getContext(), new MultiCardRootLayout.1(this), new Handler(Looper.getMainLooper()));
    }
    this.k = new MultiCardRootLayout.2(this);
    this.j = new MultiCardRootLayout.3(this);
    a(true);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.setOnInterceptTouchEventListener(this.j);
      super.setDispatchTouchEventListener(this.k);
      return;
    }
    super.setOnInterceptTouchEventListener(null);
    super.setDispatchTouchEventListener(null);
  }
  
  public void b(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    if (this.o)
    {
      this.l.reset();
      this.m.set(0.0F, 0.0F, getWidth(), getHeight());
      Path localPath = this.l;
      RectF localRectF = this.m;
      float f = this.n;
      localPath.addRoundRect(localRectF, f, f, Path.Direction.CW);
      paramCanvas.clipPath(this.l);
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (this.p) {
      a(paramCanvas);
    }
    super.onDraw(paramCanvas);
  }
  
  public void setListener(MultiCardRootLayout.MultiCardRootLayoutListener paramMultiCardRootLayoutListener)
  {
    if (paramMultiCardRootLayoutListener == null)
    {
      this.u = null;
      return;
    }
    this.u = new WeakReference(paramMultiCardRootLayoutListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardRootLayout
 * JD-Core Version:    0.7.0.1
 */