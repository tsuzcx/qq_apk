package cooperation.vip.ar.widget;

import android.content.Context;
import bfxa;
import bfxd;
import bfxl;
import bkex;
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
  private bfxl jdField_a_of_type_Bfxl;
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
    GLog.init(new bkex());
    QGBitmapLoader.setBitmapLoader(new bfxa());
    QGReporter.setReporter(new bfxd());
    this.jdField_a_of_type_ComTencentQgSdkInvokeModuleEngine = new ModuleEngine();
    this.jdField_a_of_type_Bfxl = new bfxl();
    this.jdField_a_of_type_ComTencentQgSdkInvokeModuleEngine.registerJsModule(this.jdField_a_of_type_Bfxl);
    setModuleEngin(this.jdField_a_of_type_ComTencentQgSdkInvokeModuleEngine);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentQgSdkInvokeModuleEngine != null) && (this.jdField_a_of_type_Bfxl != null)) {
      this.jdField_a_of_type_ComTencentQgSdkInvokeModuleEngine.unRegisterJsModule(this.jdField_a_of_type_Bfxl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.vip.ar.widget.VipQGGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */