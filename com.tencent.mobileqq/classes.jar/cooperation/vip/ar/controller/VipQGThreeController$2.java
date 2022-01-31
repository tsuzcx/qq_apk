package cooperation.vip.ar.controller;

import android.view.ViewGroup;
import bkal;
import bkan;
import bkap;
import com.tencent.qg.sdk.invoke.ModuleEngine;
import cooperation.qzone.util.QZLog;
import cooperation.vip.ar.widget.VipQGGLSurfaceView;

public class VipQGThreeController$2
  implements Runnable
{
  public VipQGThreeController$2(bkal parambkal) {}
  
  public void run()
  {
    QZLog.e("VipARQGThreeController", 2, new Object[] { "onDrawFrame status CREATE_QGVIEW success next status JS_MODEL_LOAD" });
    QZLog.i("VipARQGThreeController", 1, "createQGView width = " + bkal.a(this.this$0).jdField_a_of_type_Int + " height = " + bkal.a(this.this$0).jdField_b_of_type_Int + " shareContext = " + bkal.a(this.this$0).jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
    bkal.a(this.this$0, new VipQGGLSurfaceView(this.this$0.a, bkal.a(this.this$0).jdField_a_of_type_Int, bkal.a(this.this$0).jdField_b_of_type_Int, bkal.a(this.this$0).jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext, bkal.a(this.this$0).jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig, bkal.a(this.this$0).jdField_b_of_type_JavaLangString));
    bkal.a(this.this$0).setLimitFrame(-1);
    bkal.a(this.this$0).setOnTouchListener(null);
    bkal.a(this.this$0).setQGEventListener(this.this$0);
    bkal.a(this.this$0).addView(bkal.a(this.this$0));
    bkal.a(this.this$0, new bkan(this.this$0));
    if (bkal.a(this.this$0).getModuleEngine() != null) {
      bkal.a(this.this$0).getModuleEngine().registerJsModule(bkal.a(this.this$0));
    }
    bkal.a(this.this$0, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.vip.ar.controller.VipQGThreeController.2
 * JD-Core Version:    0.7.0.1
 */