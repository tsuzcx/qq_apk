package com.tencent.mobileqq.vas.VasResEngine;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.vas.ui.VipPngPlayAnimationDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

public class VasResDrawable
  extends VipPngPlayAnimationDrawable
  implements Handler.Callback, AbsVasRes
{
  protected Drawable a;
  protected VasResController b;
  protected Context c;
  protected Handler d;
  protected int e;
  protected VasResDrawable.Options f;
  protected VasResDrawable.VasResDrawableAdapter g;
  protected VasResDrawable.RefreshListener h;
  protected Path i;
  protected RectF j;
  protected float k;
  private URLDrawable.URLDrawableListener l = new VasResDrawable.1(this);
  
  public VasResDrawable(Context paramContext, int paramInt)
  {
    super(paramContext.getResources());
    a(paramContext, paramInt, new VasResDrawable.Options(this));
    this.i = new Path();
    this.j = new RectF();
  }
  
  public VasResDrawable(AppRuntime paramAppRuntime, int paramInt)
  {
    super(MobileQQ.getContext().getResources());
    a(paramAppRuntime.getApplication().getApplicationContext(), paramInt, new VasResDrawable.Options(this));
    this.i = new Path();
    this.j = new RectF();
  }
  
  private void a(Context paramContext, int paramInt, VasResDrawable.Options paramOptions)
  {
    this.e = paramInt;
    this.f = paramOptions;
    this.c = paramContext;
    this.d = new Handler(Looper.getMainLooper(), this);
    this.b = new VasResController(paramInt, this.d);
  }
  
  @org.jetbrains.annotations.Nullable
  private URL c(String paramString1, String paramString2)
  {
    try
    {
      if (!TextUtils.isEmpty(d().a)) {
        return new URL(d().a, paramString2, paramString1);
      }
      paramString1 = new URL("http", paramString2, paramString1);
      return paramString1;
    }
    catch (MalformedURLException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VasResDrawable", 2, paramString1.getMessage());
      }
    }
    return null;
  }
  
  protected Drawable a(String paramString1, String paramString2)
  {
    if (this.c == null) {
      this.c = MobileQQ.getContext();
    }
    if (TextUtils.isEmpty(paramString2))
    {
      if (d().c > 0) {
        return this.c.getResources().getDrawable(d().c);
      }
      return null;
    }
    paramString1 = c(paramString1, paramString2);
    if (paramString1 == null) {
      return this.c.getResources().getDrawable(2130847784);
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("getBGDrawable url = ");
      paramString2.append(paramString1.toString());
      QLog.d("VasResDrawable", 2, paramString2.toString());
    }
    paramString2 = URLDrawable.URLDrawableOptions.obtain();
    paramString2.mRequestWidth = d().d;
    paramString2.mRequestHeight = d().e;
    if (d().b > 0)
    {
      Drawable localDrawable = this.c.getResources().getDrawable(d().b);
      paramString2.mLoadingDrawable = localDrawable;
      paramString2.mFailedDrawable = localDrawable;
    }
    paramString1 = URLDrawable.getDrawable(paramString1, paramString2);
    if ((d().f != null) && (d().f.length > 0)) {
      paramString1.setHeaders(d().f);
    }
    if (paramString1.getStatus() == 2) {
      paramString1.restartDownload();
    }
    paramString1.setURLDrawableListener(this.l);
    return paramString1;
  }
  
  public VasResController a()
  {
    return this.b;
  }
  
  public void a(float paramFloat)
  {
    this.k = paramFloat;
  }
  
  public void a(int paramInt)
  {
    if (d().c > 0)
    {
      localObject = this.c;
      if (localObject != null) {
        this.a = ((Context)localObject).getResources().getDrawable(this.f.c);
      }
    }
    super.c();
    this.b.a(paramInt);
    Object localObject = this.g;
    if (localObject != null) {
      ((VasResDrawable.VasResDrawableAdapter)localObject).a();
    }
  }
  
  protected void a(@NonNull Canvas paramCanvas)
  {
    this.i.reset();
    this.j.set(getBounds());
    Object localObject = this.i;
    RectF localRectF = this.j;
    float f1 = this.k;
    ((Path)localObject).addRoundRect(localRectF, f1, f1, Path.Direction.CW);
    paramCanvas.clipPath(this.i);
    localObject = this.a;
    if (localObject != null)
    {
      ((Drawable)localObject).setBounds(getBounds());
      this.a.draw(paramCanvas);
    }
  }
  
  public void a(VasResDrawable.RefreshListener paramRefreshListener)
  {
    this.h = paramRefreshListener;
  }
  
  public void a(VasResDrawable.VasResDrawableAdapter paramVasResDrawableAdapter)
  {
    this.g = paramVasResDrawableAdapter;
    paramVasResDrawableAdapter = this.g;
    if (paramVasResDrawableAdapter != null) {
      paramVasResDrawableAdapter.a();
    }
    invalidateSelf();
  }
  
  public VasResAdapter b()
  {
    return this.g;
  }
  
  public void b(String paramString1, String paramString2)
  {
    if ((this.f.f != null) && (this.f.f.length != 0))
    {
      Header[] arrayOfHeader = new Header[this.f.f.length + 1];
      System.arraycopy(this.f.f, 0, arrayOfHeader, 0, this.f.f.length);
      arrayOfHeader[this.f.f.length] = new BasicHeader(paramString1, paramString2);
      this.f.f = arrayOfHeader;
      return;
    }
    this.f.f = new Header[] { new BasicHeader(paramString1, paramString2) };
  }
  
  public void c()
  {
    super.c();
    VasResDrawable.VasResDrawableAdapter localVasResDrawableAdapter = this.g;
    if (localVasResDrawableAdapter != null) {
      localVasResDrawableAdapter.b();
    }
  }
  
  public VasResDrawable.Options d()
  {
    return this.f;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    a(paramCanvas);
    if (this.g.d()) {
      super.draw(paramCanvas);
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.g == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 10003: 
      this.g.a();
      paramMessage = this.h;
      if (paramMessage != null)
      {
        paramMessage.c();
        return true;
      }
      break;
    case 10002: 
      this.g.a(paramMessage.arg1, (Bundle)paramMessage.obj);
      paramMessage = this.h;
      if (paramMessage != null) {
        paramMessage.b();
      }
      return true;
    case 10001: 
      if (!TextUtils.isEmpty(this.g.c())) {
        this.a = a(String.valueOf(this.e), this.g.c());
      }
      paramMessage = paramMessage.getData();
      if (paramMessage.getInt("type") == 1)
      {
        String[] arrayOfString = paramMessage.getStringArray("pngs");
        int m = paramMessage.getInt("interval");
        int n = paramMessage.getInt("repeatTimes");
        a(arrayOfString, m);
        b(d().g);
        this.A = n;
      }
      invalidateSelf();
      paramMessage = this.h;
      if (paramMessage != null) {
        paramMessage.a();
      }
      break;
    }
    return true;
  }
  
  public void setAlpha(int paramInt)
  {
    super.setAlpha(paramInt);
  }
  
  public void setColorFilter(@android.support.annotation.Nullable ColorFilter paramColorFilter)
  {
    super.setColorFilter(paramColorFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasResEngine.VasResDrawable
 * JD-Core Version:    0.7.0.1
 */