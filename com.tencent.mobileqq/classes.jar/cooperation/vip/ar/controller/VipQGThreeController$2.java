package cooperation.vip.ar.controller;

import android.view.ViewGroup;
import bhxy;
import bhya;
import bhyc;
import com.tencent.qg.sdk.invoke.ModuleEngine;
import cooperation.qzone.util.QZLog;
import cooperation.vip.ar.widget.VipQGGLSurfaceView;

public class VipQGThreeController$2
  implements Runnable
{
  public VipQGThreeController$2(bhxy parambhxy) {}
  
  public void run()
  {
    QZLog.e("VipARQGThreeController", 2, new Object[] { "onDrawFrame status CREATE_QGVIEW success next status JS_MODEL_LOAD" });
    QZLog.i("VipARQGThreeController", 1, "createQGView width = " + bhxy.a(this.this$0).jdField_a_of_type_Int + " height = " + bhxy.a(this.this$0).jdField_b_of_type_Int + " shareContext = " + bhxy.a(this.this$0).jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
    bhxy.a(this.this$0, new VipQGGLSurfaceView(this.this$0.a, bhxy.a(this.this$0).jdField_a_of_type_Int, bhxy.a(this.this$0).jdField_b_of_type_Int, bhxy.a(this.this$0).jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext, bhxy.a(this.this$0).jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig, bhxy.a(this.this$0).jdField_b_of_type_JavaLangString));
    bhxy.a(this.this$0).setLimitFrame(-1);
    bhxy.a(this.this$0).setOnTouchListener(null);
    bhxy.a(this.this$0).setQGEventListener(this.this$0);
    bhxy.a(this.this$0).addView(bhxy.a(this.this$0));
    bhxy.a(this.this$0, new bhya(this.this$0));
    if (bhxy.a(this.this$0).getModuleEngine() != null) {
      bhxy.a(this.this$0).getModuleEngine().registerJsModule(bhxy.a(this.this$0));
    }
    bhxy.a(this.this$0, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.vip.ar.controller.VipQGThreeController.2
 * JD-Core Version:    0.7.0.1
 */