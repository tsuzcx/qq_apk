package com.tencent.qg;

import android.content.Context;
import bjvy;
import bjwa;
import bjwb;
import bjwj;
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
    GLog.init(new bjwa());
    QGBitmapLoader.setBitmapLoader(new bjvy());
    QGReporter.setReporter(new bjwb());
    this.jdField_a_of_type_ComTencentQgSdkInvokeModuleEngine = new ModuleEngine();
    this.jdField_a_of_type_ComTencentQgSdkInvokeModuleEngine.registerJsModule(new bjwj());
    setModuleEngin(this.jdField_a_of_type_ComTencentQgSdkInvokeModuleEngine);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qg.StoryQGSurfaceView
 * JD-Core Version:    0.7.0.1
 */