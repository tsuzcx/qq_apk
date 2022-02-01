package cooperation.vip.ar.widget;

import android.content.Context;
import bikw;
import bikz;
import bilh;
import bkzw;
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
  private bilh jdField_a_of_type_Bilh;
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
    GLog.init(new bkzw());
    QGBitmapLoader.setBitmapLoader(new bikw());
    QGReporter.setReporter(new bikz());
    this.jdField_a_of_type_ComTencentQgSdkInvokeModuleEngine = new ModuleEngine();
    this.jdField_a_of_type_Bilh = new bilh();
    this.jdField_a_of_type_ComTencentQgSdkInvokeModuleEngine.registerJsModule(this.jdField_a_of_type_Bilh);
    setModuleEngin(this.jdField_a_of_type_ComTencentQgSdkInvokeModuleEngine);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentQgSdkInvokeModuleEngine != null) && (this.jdField_a_of_type_Bilh != null)) {
      this.jdField_a_of_type_ComTencentQgSdkInvokeModuleEngine.unRegisterJsModule(this.jdField_a_of_type_Bilh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.ar.widget.VipQGGLSurfaceView
 * JD-Core Version:    0.7.0.1
 */