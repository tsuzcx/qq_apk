package cooperation.vip.ar.widget;

import android.content.Context;
import bjvy;
import bjwb;
import bjwj;
import bmma;
import com.tencent.qg.sdk.QGBitmapLoader;
import com.tencent.qg.sdk.QGGLSurfaceView;
import com.tencent.qg.sdk.QGReporter;
import com.tencent.qg.sdk.invoke.ModuleEngine;
import com.tencent.qg.sdk.log.GLog;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;

public class VipQGGLSurfaceView
  extends QGGLSurfaceView
{
  private static String jdField_a_of_type_JavaLangString = "VipQGGLSurfaceView";
  private bjwj jdField_a_of_type_Bjwj;
  private ModuleEngine jdField_a_of_type_ComTencentQgSdkInvokeModuleEngine;
  
  public VipQGGLSurfaceView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public VipQGGLSurfaceView(Context paramContext, int paramInt1, int paramInt2, EGLContext paramEGLContext, EGLConfig paramEGLConfig, String paramString)
  {
    super(paramContext, paramInt1, paramInt2, paramEGLContext, paramEGLConfig, paramString);
    a();
  }
  
  public void a()
  {
    GLog.init(new bmma());
    QGBitmapLoader.setBitmapLoader(new bjvy());
    QGReporter.setReporter(new bjwb());
    this.jdField_a_of_type_ComTencentQgSdkInvokeModuleEngine = new ModuleEngine();
    this.jdField_a_of_type_Bjwj = new bjwj();
    this.jdField_a_of_type_ComTencentQgSdkInvokeModuleEngine.registerJsModule(this.jdField_a_of_type_Bjwj);
    setModuleEngin(this.jdField_a_of_type_ComTencentQgSdkInvokeModuleEngine);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentQgSdkInvokeModuleEngine != null) && (this.jdField_a_of_type_Bjwj != null)) {
      this.jdField_a_of_type_ComTencentQgSdkInvokeModuleEngine.unRegisterJsModule(this.jdField_a_of_type_Bjwj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.ar.widget.VipQGGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */