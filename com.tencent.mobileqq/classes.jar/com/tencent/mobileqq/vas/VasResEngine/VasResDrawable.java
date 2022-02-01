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
  protected float a;
  protected int a;
  protected Context a;
  protected Path a;
  protected RectF a;
  protected Drawable a;
  protected Handler a;
  private URLDrawable.URLDrawableListener a;
  protected VasResController a;
  protected VasResDrawable.Options a;
  protected VasResDrawable.RefreshListener a;
  protected VasResDrawable.VasResDrawableAdapter a;
  
  public VasResDrawable(Context paramContext, int paramInt)
  {
    super(paramContext.getResources());
    this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = new VasResDrawable.1(this);
    a(paramContext, paramInt, new VasResDrawable.Options(this));
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  }
  
  public VasResDrawable(AppRuntime paramAppRuntime, int paramInt)
  {
    super(MobileQQ.getContext().getResources());
    this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = new VasResDrawable.1(this);
    a(paramAppRuntime.getApplication().getApplicationContext(), paramInt, new VasResDrawable.Options(this));
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  }
  
  @org.jetbrains.annotations.Nullable
  private URL a(String paramString1, String paramString2)
  {
    try
    {
      if (!TextUtils.isEmpty(a().jdField_a_of_type_JavaLangString)) {
        return new URL(a().jdField_a_of_type_JavaLangString, paramString2, paramString1);
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
  
  private void a(Context paramContext, int paramInt, VasResDrawable.Options paramOptions)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$Options = paramOptions;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController = new VasResController(paramInt, this.jdField_a_of_type_AndroidOsHandler);
  }
  
  protected Drawable a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = MobileQQ.getContext();
    }
    if (TextUtils.isEmpty(paramString2))
    {
      if (a().b > 0) {
        return this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(a().b);
      }
      return null;
    }
    paramString1 = a(paramString1, paramString2);
    if (paramString1 == null) {
      return this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846313);
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("getBGDrawable url = ");
      paramString2.append(paramString1.toString());
      QLog.d("VasResDrawable", 2, paramString2.toString());
    }
    paramString2 = URLDrawable.URLDrawableOptions.obtain();
    paramString2.mRequestWidth = a().c;
    paramString2.mRequestHeight = a().d;
    if (a().jdField_a_of_type_Int > 0)
    {
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(a().jdField_a_of_type_Int);
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
  
  public VasResAdapter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$VasResDrawableAdapter;
  }
  
  public VasResController a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController;
  }
  
  public VasResDrawable.Options a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$Options;
  }
  
  public void a()
  {
    super.a();
    VasResDrawable.VasResDrawableAdapter localVasResDrawableAdapter = this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$VasResDrawableAdapter;
    if (localVasResDrawableAdapter != null) {
      localVasResDrawableAdapter.b();
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt)
  {
    if (a().b > 0)
    {
      localObject = this.jdField_a_of_type_AndroidContentContext;
      if (localObject != null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Context)localObject).getResources().getDrawable(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$Options.b);
      }
    }
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResController.a(paramInt);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$VasResDrawableAdapter;
    if (localObject != null) {
      ((VasResDrawable.VasResDrawableAdapter)localObject).a();
    }
  }
  
  protected void a(@NonNull Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsRectF.set(getBounds());
    Object localObject = this.jdField_a_of_type_AndroidGraphicsPath;
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    float f = this.jdField_a_of_type_Float;
    ((Path)localObject).addRoundRect(localRectF, f, f, Path.Direction.CW);
    paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
    localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localObject != null)
    {
      ((Drawable)localObject).setBounds(getBounds());
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
  }
  
  public void a(VasResDrawable.RefreshListener paramRefreshListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$RefreshListener = paramRefreshListener;
  }
  
  public void a(VasResDrawable.VasResDrawableAdapter paramVasResDrawableAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$VasResDrawableAdapter = paramVasResDrawableAdapter;
    paramVasResDrawableAdapter = this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$VasResDrawableAdapter;
    if (paramVasResDrawableAdapter != null) {
      paramVasResDrawableAdapter.a();
    }
    invalidateSelf();
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$Options.jdField_a_of_type_ArrayOfOrgApacheHttpHeader != null) && (this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$Options.jdField_a_of_type_ArrayOfOrgApacheHttpHeader.length != 0))
    {
      Header[] arrayOfHeader = new Header[this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$Options.jdField_a_of_type_ArrayOfOrgApacheHttpHeader.length + 1];
      System.arraycopy(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$Options.jdField_a_of_type_ArrayOfOrgApacheHttpHeader, 0, arrayOfHeader, 0, this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$Options.jdField_a_of_type_ArrayOfOrgApacheHttpHeader.length);
      arrayOfHeader[this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$Options.jdField_a_of_type_ArrayOfOrgApacheHttpHeader.length] = new BasicHeader(paramString1, paramString2);
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$Options.jdField_a_of_type_ArrayOfOrgApacheHttpHeader = arrayOfHeader;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$Options.jdField_a_of_type_ArrayOfOrgApacheHttpHeader = new Header[] { new BasicHeader(paramString1, paramString2) };
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    a(paramCanvas);
    if (this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$VasResDrawableAdapter.a()) {
      super.draw(paramCanvas);
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$VasResDrawableAdapter == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 10003: 
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$VasResDrawableAdapter.a();
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$RefreshListener;
      if (paramMessage != null)
      {
        paramMessage.c();
        return true;
      }
      break;
    case 10002: 
      this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$VasResDrawableAdapter.a(paramMessage.arg1, (Bundle)paramMessage.obj);
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$RefreshListener;
      if (paramMessage != null) {
        paramMessage.b();
      }
      return true;
    case 10001: 
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$VasResDrawableAdapter.a())) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(String.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$VasResDrawableAdapter.a());
      }
      paramMessage = paramMessage.getData();
      if (paramMessage.getInt("type") == 1)
      {
        String[] arrayOfString = paramMessage.getStringArray("pngs");
        int i = paramMessage.getInt("interval");
        int j = paramMessage.getInt("repeatTimes");
        a(arrayOfString, i);
        b(a().e);
        this.h = j;
      }
      invalidateSelf();
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqVasVasResEngineVasResDrawable$RefreshListener;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasResEngine.VasResDrawable
 * JD-Core Version:    0.7.0.1
 */