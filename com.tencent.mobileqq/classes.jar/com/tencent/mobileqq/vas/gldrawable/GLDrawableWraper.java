package com.tencent.mobileqq.vas.gldrawable;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.qvip.QVipSDKConfig;
import com.tencent.mobileqq.config.business.qvip.QVipSDKProcessor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.jvm.functions.Function0;

public class GLDrawableWraper
{
  private static GLDrawableProxy.GLDrawableLoader jdField_a_of_type_ComTencentMobileqqVasGldrawableGLDrawableProxy$GLDrawableLoader;
  private static GLDrawableWraper jdField_a_of_type_ComTencentMobileqqVasGldrawableGLDrawableWraper = new GLDrawableWraper();
  private static boolean jdField_a_of_type_Boolean;
  private static boolean b;
  private GLDrawableWraper.SimpleFactory jdField_a_of_type_ComTencentMobileqqVasGldrawableGLDrawableWraper$SimpleFactory = new GLDrawableWraper.SimpleFactory(this);
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqVasGldrawableGLDrawableProxy$GLDrawableLoader = new GLDrawableLoaderImpl();
    jdField_a_of_type_Boolean = QVipSDKProcessor.c().a(Build.VERSION.SDK_INT);
    b = true;
    ThreadManagerV2.executeOnSubThread(new GLDrawableWraper.1());
  }
  
  private GLDrawableWraper()
  {
    ThreadManagerV2.executeOnSubThread(new GLDrawableWraper.2(this));
  }
  
  public static GLDrawableProxy.GLDrawableLoader a()
  {
    return jdField_a_of_type_ComTencentMobileqqVasGldrawableGLDrawableProxy$GLDrawableLoader;
  }
  
  public static GLDrawableWraper a()
  {
    return jdField_a_of_type_ComTencentMobileqqVasGldrawableGLDrawableWraper;
  }
  
  private void a()
  {
    if ((!GLDrawableProxy.a()) && (!GLDrawableProxy.b()) && (!jdField_a_of_type_ComTencentMobileqqVasGldrawableGLDrawableProxy$GLDrawableLoader.a()) && (!jdField_a_of_type_ComTencentMobileqqVasGldrawableGLDrawableProxy$GLDrawableLoader.b())) {
      jdField_a_of_type_ComTencentMobileqqVasGldrawableGLDrawableProxy$GLDrawableLoader.a();
    }
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean a(Drawable paramDrawable)
  {
    if (d(paramDrawable)) {
      return true;
    }
    return GLDrawableProxy.a(paramDrawable);
  }
  
  public static boolean b()
  {
    return b;
  }
  
  public static boolean b(Drawable paramDrawable)
  {
    return GLDrawableProxy.a(paramDrawable);
  }
  
  public static boolean c(Drawable paramDrawable)
  {
    return GLDrawableProxy.b(paramDrawable);
  }
  
  private static boolean d(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof URLDrawable))
    {
      paramDrawable = ((URLDrawable)paramDrawable).getExtraInfo();
      if ((paramDrawable instanceof Bundle)) {
        return ((Bundle)paramDrawable).getBoolean("key_use_gldrawable", false);
      }
    }
    return false;
  }
  
  public Drawable a(File paramFile, boolean paramBoolean)
  {
    if (!jdField_a_of_type_Boolean) {
      return null;
    }
    a();
    return GLDrawableProxy.a().a(paramFile, ThreadManagerV2.getFileThreadLooper(), paramBoolean);
  }
  
  public Drawable a(String paramString, Handler paramHandler, boolean paramBoolean)
  {
    if (!jdField_a_of_type_Boolean) {
      return null;
    }
    a();
    return GLDrawableProxy.a().a(paramString, paramHandler, paramBoolean);
  }
  
  public DynamicDrawable a(GLDrawableOptions paramGLDrawableOptions, boolean paramBoolean, Function0<Drawable> paramFunction0)
  {
    if (!jdField_a_of_type_Boolean) {
      return null;
    }
    return GLDrawableProxy.a().a(paramGLDrawableOptions, ThreadManagerV2.getFileThreadLooper(), paramBoolean, paramFunction0);
  }
  
  public DynamicDrawable a(File paramFile, boolean paramBoolean, Function0<Drawable> paramFunction0)
  {
    if (!jdField_a_of_type_Boolean) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("GLDrawable", 1, "use Async-GLDrawable : " + paramFile.getAbsolutePath());
    }
    return GLDrawableProxy.a().a(paramFile, ThreadManagerV2.getFileThreadLooper(), paramBoolean, paramFunction0);
  }
  
  public GLDrawableWraper.SimpleFactory a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqVasGldrawableGLDrawableWraper$SimpleFactory;
  }
  
  public void a(Drawable paramDrawable)
  {
    GLDrawableProxy.a().a(paramDrawable);
  }
  
  public void a(Drawable paramDrawable, boolean paramBoolean)
  {
    GLDrawableProxy.a().a(paramDrawable, paramBoolean);
  }
  
  public boolean a(Drawable paramDrawable, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return GLDrawableProxy.a().a(paramDrawable, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.gldrawable.GLDrawableWraper
 * JD-Core Version:    0.7.0.1
 */