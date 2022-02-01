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
import biaj;
import biak;
import biam;
import bian;
import biao;
import biap;
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
  private float jdField_a_of_type_Float;
  private Context jdField_a_of_type_AndroidContentContext;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private biak jdField_a_of_type_Biak;
  private bian jdField_a_of_type_Bian;
  private biao jdField_a_of_type_Biao;
  private biap jdField_a_of_type_Biap;
  private URLDrawable.URLDrawableListener jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = new biam(this);
  private Handler b;
  private int i;
  
  public VasResDrawable(AppRuntime paramAppRuntime, int paramInt)
  {
    super(paramAppRuntime.getApplication().getApplicationContext().getResources());
    a(paramAppRuntime, paramInt, new bian(this));
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  }
  
  private Drawable a(String paramString1, String paramString2)
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
          return this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846136);
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
  
  private void a(AppRuntime paramAppRuntime, int paramInt, bian parambian)
  {
    this.i = paramInt;
    this.jdField_a_of_type_Bian = parambian;
    this.jdField_a_of_type_AndroidContentContext = paramAppRuntime.getApplication().getApplicationContext();
    this.b = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Biak = new biak(paramInt, this.b);
  }
  
  public biaj a()
  {
    return this.jdField_a_of_type_Biap;
  }
  
  public biak a()
  {
    return this.jdField_a_of_type_Biak;
  }
  
  public bian a()
  {
    return this.jdField_a_of_type_Bian;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_Biap != null) {
      this.jdField_a_of_type_Biap.c();
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(biao parambiao)
  {
    this.jdField_a_of_type_Biao = parambiao;
  }
  
  public void a(biap parambiap)
  {
    this.jdField_a_of_type_Biap = parambiap;
    if (this.jdField_a_of_type_Biap != null) {
      this.jdField_a_of_type_Biap.b();
    }
    invalidateSelf();
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_Bian.jdField_a_of_type_ArrayOfOrgApacheHttpHeader != null) && (this.jdField_a_of_type_Bian.jdField_a_of_type_ArrayOfOrgApacheHttpHeader.length != 0))
    {
      Header[] arrayOfHeader = new Header[this.jdField_a_of_type_Bian.jdField_a_of_type_ArrayOfOrgApacheHttpHeader.length + 1];
      System.arraycopy(this.jdField_a_of_type_Bian.jdField_a_of_type_ArrayOfOrgApacheHttpHeader, 0, arrayOfHeader, 0, this.jdField_a_of_type_Bian.jdField_a_of_type_ArrayOfOrgApacheHttpHeader.length);
      arrayOfHeader[this.jdField_a_of_type_Bian.jdField_a_of_type_ArrayOfOrgApacheHttpHeader.length] = new BasicHeader(paramString1, paramString2);
      this.jdField_a_of_type_Bian.jdField_a_of_type_ArrayOfOrgApacheHttpHeader = arrayOfHeader;
      return;
    }
    this.jdField_a_of_type_Bian.jdField_a_of_type_ArrayOfOrgApacheHttpHeader = new Header[] { new BasicHeader(paramString1, paramString2) };
  }
  
  public void b(int paramInt)
  {
    if ((a().b > 0) && (this.jdField_a_of_type_AndroidContentContext != null)) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(this.jdField_a_of_type_Bian.b);
    }
    super.a();
    this.jdField_a_of_type_Biak.a(paramInt);
    if (this.jdField_a_of_type_Biap != null) {
      this.jdField_a_of_type_Biap.b();
    }
  }
  
  public void draw(@NonNull Canvas paramCanvas)
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
    if (this.jdField_a_of_type_Biap.a()) {
      super.draw(paramCanvas);
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_Biap == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Biap.a())) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(String.valueOf(this.i), this.jdField_a_of_type_Biap.a());
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
      if (this.jdField_a_of_type_Biao != null) {
        this.jdField_a_of_type_Biao.a();
      }
      return true;
      this.jdField_a_of_type_Biap.a(paramMessage.arg1, (Bundle)paramMessage.obj);
      if (this.jdField_a_of_type_Biao != null) {
        this.jdField_a_of_type_Biao.b();
      }
      return true;
      this.jdField_a_of_type_Biap.b();
      if (this.jdField_a_of_type_Biao != null) {
        this.jdField_a_of_type_Biao.c();
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