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
  private static String a = "StoryQGSurfaceView";
  private ModuleEngine b;
  
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
    this.b = new ModuleEngine();
    this.b.registerJsModule(new MqqModule());
    setModuleEngin(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.StoryQGSurfaceView
 * JD-Core Version:    0.7.0.1
 */