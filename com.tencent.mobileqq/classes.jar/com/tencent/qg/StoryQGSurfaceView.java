package com.tencent.qg;

import android.content.Context;
import com.tencent.qg.modules.MqqModule;
import com.tencent.qg.sdk.QGBitmapLoader;
import com.tencent.qg.sdk.QGGLSurfaceView;
import com.tencent.qg.sdk.QGReporter;
import com.tencent.qg.sdk.invoke.ModuleEngine;
import com.tencent.qg.sdk.log.GLog;

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
  
  public void a()
  {
    GLog.init(new QGLoger());
    QGBitmapLoader.setBitmapLoader(new MqqQGBitmapLoader());
    QGReporter.setReporter(new QGReporterImpl());
    this.jdField_a_of_type_ComTencentQgSdkInvokeModuleEngine = new ModuleEngine();
    this.jdField_a_of_type_ComTencentQgSdkInvokeModuleEngine.registerJsModule(new MqqModule());
    setModuleEngin(this.jdField_a_of_type_ComTencentQgSdkInvokeModuleEngine);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qg.StoryQGSurfaceView
 * JD-Core Version:    0.7.0.1
 */