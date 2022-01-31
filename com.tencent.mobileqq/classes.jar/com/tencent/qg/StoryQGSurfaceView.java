package com.tencent.qg;

import android.content.Context;
import bdsy;
import bdta;
import bdtb;
import bdtj;
import com.tencent.qg.sdk.QGBitmapLoader;
import com.tencent.qg.sdk.QGGLSurfaceView;
import com.tencent.qg.sdk.QGReporter;
import com.tencent.qg.sdk.invoke.ModuleEngine;
import com.tencent.qg.sdk.log.GLog;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;

public class StoryQGSurfaceView
  extends QGGLSurfaceView
{
  private static String jdField_a_of_type_JavaLangString = "StoryQGSurfaceView";
  private ModuleEngine jdField_a_of_type_ComTencentQgSdkInvokeModuleEngine;
  
  public StoryQGSurfaceView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public StoryQGSurfaceView(Context paramContext, int paramInt1, int paramInt2, EGLContext paramEGLContext, EGLConfig paramEGLConfig, String paramString)
  {
    super(paramContext, paramInt1, paramInt2, paramEGLContext, paramEGLConfig, paramString);
    a();
  }
  
  public void a()
  {
    GLog.init(new bdta());
    QGBitmapLoader.setBitmapLoader(new bdsy());
    QGReporter.setReporter(new bdtb());
    this.jdField_a_of_type_ComTencentQgSdkInvokeModuleEngine = new ModuleEngine();
    this.jdField_a_of_type_ComTencentQgSdkInvokeModuleEngine.registerJsModule(new bdtj());
    setModuleEngin(this.jdField_a_of_type_ComTencentQgSdkInvokeModuleEngine);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.qg.StoryQGSurfaceView
 * JD-Core Version:    0.7.0.1
 */