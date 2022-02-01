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
import android.support.annotation.Nullable;
import android.text.TextUtils;
import bhpn;
import bhpo;
import bhpq;
import bhpr;
import bhps;
import bhpt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.anim.VipPngPlayAnimationDrawable;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

public class VasResDrawable
  extends VipPngPlayAnimationDrawable
  implements Handler.Callback
{
  protected float a;
  protected Context a;
  protected Path a;
  protected RectF a;
  public Drawable a;
  protected bhpo a;
  protected bhpr a;
  protected bhps a;
  protected bhpt a;
  private URLDrawable.URLDrawableListener a;
  protected Handler b;
  protected int i;
  
  public VasResDrawable(Context paramContext, int paramInt)
  {
    super(paramContext.getResources());
    this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = new bhpq(this);
    a(paramContext, paramInt, new bhpr(this));
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  }
  
  public VasResDrawable(AppRuntime paramAppRuntime, int paramInt)
  {
    super(paramAppRuntime.getApplication().getApplicationContext().getResources());
    this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = new bhpq(this);
    a(paramAppRuntime.getApplication().getApplicationContext(), paramInt, new bhpr(this));
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  }
  
  private void a(Context paramContext, int paramInt, bhpr parambhpr)
  {
    this.i = paramInt;
    this.jdField_a_of_type_Bhpr = parambhpr;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.b = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Bhpo = new bhpo(paramInt, this.b);
  }
  
  protected Drawable a(String paramString1, String paramString2)
  {
    Drawable localDrawable = null;
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
    }
    if (TextUtils.isEmpty(paramString2))
    {
      if (a().b > 0) {
        return this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(a().b);
      }
    }
    else {
      try
      {
        if (!TextUtils.isEmpty(a().jdField_a_of_type_JavaLangString)) {}
        for (paramString1 = new URL(a().jdField_a_of_type_JavaLangString, paramString2, paramString1); paramString1 == null; paramString1 = new URL("http", paramString2, paramString1)) {
          return this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846115);
        }
      }
      catch (MalformedURLException paramString2)
      {
        for (;;)
        {
          paramString1 = localDrawable;
          if (QLog.isColorLevel())
          {
            QLog.d("VasResDrawable", 2, paramString2.getMessage());
            paramString1 = localDrawable;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("VasResDrawable", 2, "getBGDrawable url = " + paramString1.toString());
        }
        paramString2 = URLDrawable.URLDrawableOptions.obtain();
        paramString2.mRequestWidth = a().c;
        paramString2.mRequestHeight = a().d;
        if (a().jdField_a_of_type_Int > 0)
        {
          localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(a().jdField_a_of_type_Int);
          paramString2.mLoadingDrawable = localDrawable;
          paramString2.mFailedDrawable = localDrawable;
        }
        paramString1 = URLDrawable.getDrawable(paramString1, paramString2);
        if ((a().jdField_a_of_type_ArrayOfOrgApacheHttpHeader != null) && (a().jdField_a_of_type_ArrayOfOrgApacheHttpHeader.length > 0)) {
          paramString1.setHeaders(a().jdField_a_of_type_ArrayOfOrgApacheHttpHeader);
        }
        if (paramString1.getStatus() == 2) {
          paramString1.restartDownload();
        }
        paramString1.setURLDrawableListener(this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener);
        return paramString1;
      }
    }
    return null;
  }
  
  public bhpn a()
  {
    return this.jdField_a_of_type_Bhpt;
  }
  
  public bhpo a()
  {
    return this.jdField_a_of_type_Bhpo;
  }
  
  public bhpr a()
  {
    return this.jdField_a_of_type_Bhpr;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Bhpt != null) {
      this.jdField_a_of_type_Bhpt.c();
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  protected void a(@NonNull Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsRectF.set(getBounds());
    this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_Float, this.jdField_a_of_type_Float, Path.Direction.CW);
    paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(getBounds());
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
  }
  
  public void a(bhps parambhps)
  {
    this.jdField_a_of_type_Bhps = parambhps;
  }
  
  public void a(bhpt parambhpt)
  {
    this.jdField_a_of_type_Bhpt = parambhpt;
    if (this.jdField_a_of_type_Bhpt != null) {
      this.jdField_a_of_type_Bhpt.b();
    }
    invalidateSelf();
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_Bhpr.jdField_a_of_type_ArrayOfOrgApacheHttpHeader != null) && (this.jdField_a_of_type_Bhpr.jdField_a_of_type_ArrayOfOrgApacheHttpHeader.length != 0))
    {
      Header[] arrayOfHeader = new Header[this.jdField_a_of_type_Bhpr.jdField_a_of_type_ArrayOfOrgApacheHttpHeader.length + 1];
      System.arraycopy(this.jdField_a_of_type_Bhpr.jdField_a_of_type_ArrayOfOrgApacheHttpHeader, 0, arrayOfHeader, 0, this.jdField_a_of_type_Bhpr.jdField_a_of_type_ArrayOfOrgApacheHttpHeader.length);
      arrayOfHeader[this.jdField_a_of_type_Bhpr.jdField_a_of_type_ArrayOfOrgApacheHttpHeader.length] = new BasicHeader(paramString1, paramString2);
      this.jdField_a_of_type_Bhpr.jdField_a_of_type_ArrayOfOrgApacheHttpHeader = arrayOfHeader;
      return;
    }
    this.jdField_a_of_type_Bhpr.jdField_a_of_type_ArrayOfOrgApacheHttpHeader = new Header[] { new BasicHeader(paramString1, paramString2) };
  }
  
  public void b(int paramInt)
  {
    if ((a().b > 0) && (this.jdField_a_of_type_AndroidContentContext != null)) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(this.jdField_a_of_type_Bhpr.b);
    }
    super.a();
    this.jdField_a_of_type_Bhpo.a(paramInt);
    if (this.jdField_a_of_type_Bhpt != null) {
      this.jdField_a_of_type_Bhpt.b();
    }
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    a(paramCanvas);
    if (this.jdField_a_of_type_Bhpt.a()) {
      super.draw(paramCanvas);
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_Bhpt == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Bhpt.a())) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(String.valueOf(this.i), this.jdField_a_of_type_Bhpt.a());
      }
      paramMessage = paramMessage.getData();
      if (paramMessage.getInt("type") == 1)
      {
        String[] arrayOfString = paramMessage.getStringArray("pngs");
        int j = paramMessage.getInt("interval");
        int k = paramMessage.getInt("repeatTimes");
        a(arrayOfString, j);
        a(a().e);
        this.f = k;
      }
      invalidateSelf();
      if (this.jdField_a_of_type_Bhps != null) {
        this.jdField_a_of_type_Bhps.a();
      }
      return true;
      this.jdField_a_of_type_Bhpt.a(paramMessage.arg1, (Bundle)paramMessage.obj);
      if (this.jdField_a_of_type_Bhps != null) {
        this.jdField_a_of_type_Bhps.b();
      }
      return true;
      this.jdField_a_of_type_Bhpt.b();
      if (this.jdField_a_of_type_Bhps != null) {
        this.jdField_a_of_type_Bhps.c();
      }
    }
  }
  
  public void setAlpha(int paramInt)
  {
    super.setAlpha(paramInt);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    super.setColorFilter(paramColorFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasResEngine.VasResDrawable
 * JD-Core Version:    0.7.0.1
 */