package com.tencent.mobileqq.mutualmark;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import mqq.util.WeakReference;
import org.xmlpull.v1.XmlPullParser;

public class MutualMarkIconProxyDrawable
  extends Drawable
  implements Handler.Callback, URLDrawable.URLDrawableListener
{
  Drawable a;
  URLDrawable b;
  Drawable c;
  int d = 42;
  Handler e;
  int f = 255;
  int g = 0;
  int h = 0;
  String i = "";
  int j = 102;
  WeakReference<MutualMarkIconProxyDrawable.LoadSuccessCallback> k;
  
  public MutualMarkIconProxyDrawable(Context paramContext, int paramInt)
  {
    this.a = paramContext.getResources().getDrawable(paramInt);
  }
  
  public MutualMarkIconProxyDrawable(Context paramContext, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(0);
    localColorDrawable.setBounds(0, 0, 0, this.d);
    localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
    localURLDrawableOptions.mFailedDrawable = localColorDrawable;
    this.b = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    int m = paramContext.getResources().getDisplayMetrics().densityDpi / 2;
    this.b.setTargetDensity(m);
    this.b.setURLDrawableListener(this);
    if (1 != this.b.getStatus())
    {
      this.b.setAutoDownload(true);
      this.b.startDownload(true);
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("MutualMarkIconProxyDrawable density : ");
      paramContext.append(m);
      QLog.i("MutualMarkIconProxyDrawable", 2, paramContext.toString());
    }
  }
  
  public MutualMarkIconProxyDrawable(Context paramContext, String paramString, View paramView)
  {
    ColorDrawable localColorDrawable = new ColorDrawable(0);
    localColorDrawable.setBounds(0, 0, 0, this.d);
    this.b = VasApngUtil.getApngURLDrawable(paramString, VasApngUtil.VIP_APNG_TAGS, localColorDrawable, null, this);
    int m = paramContext.getResources().getDisplayMetrics().densityDpi / 2;
    this.b.setTargetDensity(m);
    this.b.setCallback(paramView);
    setCallback(paramView);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("MutualMarkIconProxyDrawable density : ");
      paramContext.append(m);
      QLog.i("MutualMarkIconProxyDrawable", 2, paramContext.toString());
    }
  }
  
  private Drawable e()
  {
    Object localObject = this.c;
    if (localObject != null) {
      return localObject;
    }
    localObject = this.b;
    if (localObject != null) {
      return localObject;
    }
    localObject = this.a;
    if (localObject != null) {
      return localObject;
    }
    return null;
  }
  
  public void a(String paramString)
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      b();
      return;
    }
    if (this.e == null) {
      this.e = new Handler(Looper.getMainLooper(), this);
    }
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.i)) && (!paramString.equals(this.i))) {
      c();
    }
    this.i = paramString;
    paramString = this.e;
    if ((paramString != null) && (!paramString.hasMessages(0))) {
      this.e.sendEmptyMessage(0);
    }
  }
  
  public boolean a()
  {
    URLDrawable localURLDrawable = this.b;
    boolean bool = true;
    if (localURLDrawable != null)
    {
      if (localURLDrawable.getStatus() == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public void applyTheme(@NonNull Resources.Theme paramTheme)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (e() != null)) {
      e().applyTheme(paramTheme);
    }
    super.applyTheme(paramTheme);
  }
  
  public void b()
  {
    Handler localHandler = this.e;
    if (localHandler != null)
    {
      localHandler.removeMessages(0);
      this.e.removeMessages(1);
    }
    setAlpha(this.j);
  }
  
  public void c()
  {
    this.f = 255;
    this.g = 0;
    this.h = 0;
    Handler localHandler = this.e;
    if (localHandler != null)
    {
      localHandler.removeMessages(0);
      this.e.removeMessages(1);
    }
    setAlpha(this.f);
  }
  
  public boolean canApplyTheme()
  {
    if ((Build.VERSION.SDK_INT >= 21) && (e() != null)) {
      return e().canApplyTheme();
    }
    return super.canApplyTheme();
  }
  
  public void clearColorFilter()
  {
    if (e() != null) {
      e().clearColorFilter();
    }
    super.clearColorFilter();
  }
  
  public URLDrawable d()
  {
    return this.b;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    if (e() != null)
    {
      Rect localRect = e().getBounds();
      if ((localRect.width() > 0) && (localRect.height() > 0))
      {
        if (Build.VERSION.SDK_INT >= 21) {
          paramCanvas.saveLayerAlpha(localRect.left, localRect.top, localRect.right, localRect.bottom, this.f);
        } else {
          paramCanvas.saveLayerAlpha(localRect.left, localRect.top, localRect.right, localRect.bottom, this.f, 31);
        }
        e().draw(paramCanvas);
        paramCanvas.restore();
      }
    }
  }
  
  public int getAlpha()
  {
    return this.f;
  }
  
  @Nullable
  public Drawable.Callback getCallback()
  {
    if (e() != null)
    {
      Drawable.Callback localCallback = e().getCallback();
      if (localCallback != null) {
        return localCallback;
      }
    }
    return super.getCallback();
  }
  
  public int getChangingConfigurations()
  {
    if (e() != null) {
      return e().getChangingConfigurations();
    }
    return super.getChangingConfigurations();
  }
  
  @Nullable
  public ColorFilter getColorFilter()
  {
    if ((Build.VERSION.SDK_INT >= 21) && (e() != null)) {
      return e().getColorFilter();
    }
    return super.getColorFilter();
  }
  
  @Nullable
  public Drawable.ConstantState getConstantState()
  {
    if (e() != null) {
      return e().getConstantState();
    }
    return super.getConstantState();
  }
  
  @NonNull
  public Drawable getCurrent()
  {
    if (e() != null) {
      return e().getCurrent();
    }
    return super.getCurrent();
  }
  
  @NonNull
  public Rect getDirtyBounds()
  {
    if ((Build.VERSION.SDK_INT >= 21) && (e() != null)) {
      return e().getDirtyBounds();
    }
    return super.getDirtyBounds();
  }
  
  public void getHotspotBounds(@NonNull Rect paramRect)
  {
    if ((Build.VERSION.SDK_INT >= 23) && (e() != null))
    {
      e().getHotspotBounds(paramRect);
      return;
    }
    super.getHotspotBounds(paramRect);
  }
  
  public int getIntrinsicHeight()
  {
    if (e() != null)
    {
      int m = e().getIntrinsicHeight();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getIntrinsicHeight height : ");
        localStringBuilder.append(m);
        localStringBuilder.append(" limitHeight=");
        localStringBuilder.append(this.d);
        QLog.i("MutualMarkIconProxyDrawable", 2, localStringBuilder.toString());
      }
      return this.d;
    }
    return super.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    if (e() != null)
    {
      int n = e().getIntrinsicWidth();
      int i1 = e().getIntrinsicHeight();
      int m = n;
      if (i1 > 0)
      {
        m = n;
        if (n > 0) {
          m = n * this.d / i1;
        }
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getIntrinsicWidth width : ");
        localStringBuilder.append(m);
        QLog.i("MutualMarkIconProxyDrawable", 2, localStringBuilder.toString());
      }
      return m;
    }
    return super.getIntrinsicWidth();
  }
  
  public int getLayoutDirection()
  {
    if ((Build.VERSION.SDK_INT >= 23) && (e() != null)) {
      return e().getLayoutDirection();
    }
    return super.getLayoutDirection();
  }
  
  public int getMinimumHeight()
  {
    if (e() != null)
    {
      int m = e().getMinimumHeight();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getMinimumHeight height : ");
        localStringBuilder.append(m);
        QLog.i("MutualMarkIconProxyDrawable", 2, localStringBuilder.toString());
      }
      return m;
    }
    return super.getMinimumHeight();
  }
  
  public int getMinimumWidth()
  {
    if (e() != null)
    {
      int m = e().getMinimumWidth();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getMinimumWidth width : ");
        localStringBuilder.append(m);
        QLog.i("MutualMarkIconProxyDrawable", 2, localStringBuilder.toString());
      }
      return m;
    }
    return super.getMinimumWidth();
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void getOutline(@NonNull Outline paramOutline)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (e() != null))
    {
      e().getOutline(paramOutline);
      return;
    }
    super.getOutline(paramOutline);
  }
  
  public boolean getPadding(@NonNull Rect paramRect)
  {
    if (e() != null) {
      return e().getPadding(paramRect);
    }
    return super.getPadding(paramRect);
  }
  
  @NonNull
  public int[] getState()
  {
    if (e() != null) {
      return e().getState();
    }
    return super.getState();
  }
  
  @Nullable
  public Region getTransparentRegion()
  {
    if (e() != null) {
      return e().getTransparentRegion();
    }
    return super.getTransparentRegion();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.e == null) {
      return false;
    }
    int m = paramMessage.what;
    if (m != 0)
    {
      if (m != 1) {
        return true;
      }
      setAlpha(102);
      invalidateSelf();
      return true;
    }
    m = this.f;
    if (m <= 0) {
      this.g = 0;
    } else if (m >= 255) {
      this.g = 1;
    }
    if (this.g == 0)
    {
      this.f += 5;
      if (this.f >= 255) {
        this.f = 255;
      }
    }
    else
    {
      this.f -= 5;
      if (this.f <= 0) {
        this.f = 0;
      }
    }
    setAlpha(this.f);
    invalidateSelf();
    if (this.f == 0) {
      this.h += 1;
    }
    if ((this.h >= 3) && (this.f >= this.j))
    {
      this.e.removeMessages(0);
      this.e.sendEmptyMessage(1);
      return true;
    }
    if (this.e.hasMessages(0)) {
      this.e.removeMessages(0);
    }
    this.e.sendEmptyMessageDelayed(0, 20);
    return true;
  }
  
  public void inflate(@NonNull Resources paramResources, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet)
  {
    if (e() != null) {
      e().inflate(paramResources, paramXmlPullParser, paramAttributeSet);
    }
    super.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
  }
  
  public void inflate(@NonNull Resources paramResources, @NonNull XmlPullParser paramXmlPullParser, @NonNull AttributeSet paramAttributeSet, @Nullable Resources.Theme paramTheme)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (e() != null)) {
      e().inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    }
    super.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
  }
  
  public void invalidateSelf()
  {
    if (e() != null) {
      e().invalidateSelf();
    }
    super.invalidateSelf();
  }
  
  public boolean isAutoMirrored()
  {
    if ((Build.VERSION.SDK_INT >= 19) && (e() != null)) {
      return e().isAutoMirrored();
    }
    return super.isAutoMirrored();
  }
  
  public boolean isFilterBitmap()
  {
    if ((Build.VERSION.SDK_INT >= 23) && (e() != null)) {
      return e().isFilterBitmap();
    }
    return super.isFilterBitmap();
  }
  
  public boolean isStateful()
  {
    if (e() != null) {
      return e().isStateful();
    }
    return super.isStateful();
  }
  
  public void jumpToCurrentState()
  {
    if (e() != null) {
      e().jumpToCurrentState();
    }
    super.jumpToCurrentState();
  }
  
  @NonNull
  public Drawable mutate()
  {
    Drawable localDrawable = e();
    if (localDrawable != null)
    {
      if ((localDrawable instanceof SkinnableBitmapDrawable))
      {
        this.c = ((SkinnableBitmapDrawable)e()).mutate2();
        return this;
      }
      if ((localDrawable instanceof URLDrawable)) {
        this.c = localDrawable.mutate();
      }
      return this;
    }
    return super.mutate();
  }
  
  public boolean onLayoutDirectionChanged(int paramInt)
  {
    if ((Build.VERSION.SDK_INT >= 23) && (e() != null)) {
      return e().onLayoutDirectionChanged(paramInt);
    }
    return super.onLayoutDirectionChanged(paramInt);
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    int i1 = paramURLDrawable.getIntrinsicWidth();
    int i2 = paramURLDrawable.getIntrinsicHeight();
    int n = i1;
    int m = i2;
    if (i2 > 0)
    {
      n = i1;
      m = i2;
      if (i1 > 0)
      {
        m = this.d;
        n = i1 * m / i2;
      }
    }
    if (QLog.isColorLevel())
    {
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append("onLoadSuccessed width : ");
      paramURLDrawable.append(n);
      paramURLDrawable.append(" height:");
      paramURLDrawable.append(m);
      QLog.i("MutualMarkIconProxyDrawable", 2, paramURLDrawable.toString());
    }
    if ((n > 0) && (m > 0))
    {
      setBounds(0, 0, n, m);
      invalidateSelf();
      if ((getCallback() != null) && ((getCallback() instanceof View)))
      {
        ((View)getCallback()).invalidate();
        ((View)getCallback()).requestLayout();
      }
      paramURLDrawable = this.k;
      if (paramURLDrawable != null)
      {
        paramURLDrawable = (MutualMarkIconProxyDrawable.LoadSuccessCallback)paramURLDrawable.get();
        if (paramURLDrawable != null) {
          paramURLDrawable.a();
        }
      }
    }
  }
  
  public void scheduleSelf(@NonNull Runnable paramRunnable, long paramLong)
  {
    if (e() != null) {
      e().scheduleSelf(paramRunnable, paramLong);
    }
    super.scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT >= 19) && (e() != null)) {
      e().setAutoMirrored(paramBoolean);
    }
    super.setAutoMirrored(paramBoolean);
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setBounds [left, top right, bottom] : ");
      localStringBuilder.append(new Rect(paramInt1, paramInt2, paramInt3, paramInt4));
      QLog.i("MutualMarkIconProxyDrawable", 2, localStringBuilder.toString());
    }
    if (e() != null) {
      e().setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setBounds(@NonNull Rect paramRect)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setBounds bounds : ");
      localStringBuilder.append(paramRect);
      QLog.i("MutualMarkIconProxyDrawable", 2, localStringBuilder.toString());
    }
    if (e() != null) {
      e().setBounds(paramRect);
    }
    super.setBounds(paramRect);
  }
  
  public void setChangingConfigurations(int paramInt)
  {
    if (e() != null) {
      e().setChangingConfigurations(paramInt);
    }
    super.setChangingConfigurations(paramInt);
  }
  
  public void setColorFilter(int paramInt, @NonNull PorterDuff.Mode paramMode)
  {
    if (e() != null) {
      e().setColorFilter(paramInt, paramMode);
    }
    super.setColorFilter(paramInt, paramMode);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    if (e() != null) {
      e().setColorFilter(paramColorFilter);
    }
  }
  
  public void setDither(boolean paramBoolean)
  {
    if (e() != null) {
      e().setDither(paramBoolean);
    }
    super.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    if (e() != null) {
      e().setFilterBitmap(paramBoolean);
    }
    super.setFilterBitmap(paramBoolean);
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (e() != null)) {
      e().setHotspot(paramFloat1, paramFloat2);
    }
    super.setHotspot(paramFloat1, paramFloat2);
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (e() != null)) {
      e().setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    super.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean setState(@NonNull int[] paramArrayOfInt)
  {
    if (e() != null) {
      return e().setState(paramArrayOfInt);
    }
    return super.setState(paramArrayOfInt);
  }
  
  public void setTint(int paramInt)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (e() != null)) {
      e().setTint(paramInt);
    }
    super.setTint(paramInt);
  }
  
  public void setTintList(@Nullable ColorStateList paramColorStateList)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (e() != null)) {
      e().setTintList(paramColorStateList);
    }
    super.setTintList(paramColorStateList);
  }
  
  public void setTintMode(@NonNull PorterDuff.Mode paramMode)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (e() != null)) {
      e().setTintMode(paramMode);
    }
    super.setTintMode(paramMode);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (e() != null) {
      return e().setVisible(paramBoolean1, paramBoolean2);
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void unscheduleSelf(@NonNull Runnable paramRunnable)
  {
    if (e() != null) {
      e().unscheduleSelf(paramRunnable);
    }
    super.unscheduleSelf(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.MutualMarkIconProxyDrawable
 * JD-Core Version:    0.7.0.1
 */