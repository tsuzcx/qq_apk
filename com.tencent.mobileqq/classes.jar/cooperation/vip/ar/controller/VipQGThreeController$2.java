package cooperation.vip.ar.controller;

import android.view.ViewGroup;
import bmtc;
import bmte;
import bmtg;
import com.tencent.qg.sdk.invoke.ModuleEngine;
import cooperation.qzone.util.QZLog;
import cooperation.vip.ar.widget.VipQGGLSurfaceView;

public class VipQGThreeController$2
  implements Runnable
{
  public VipQGThreeController$2(bmtc parambmtc) {}
  
  public void run()
  {
    QZLog.e("VipARQGThreeController", 2, new Object[] { "onDrawFrame status CREATE_QGVIEW success next status JS_MODEL_LOAD" });
    QZLog.i("VipARQGThreeController", 1, "createQGView width = " + bmtc.a(this.this$0).jdField_a_of_type_Int + " height = " + bmtc.a(this.this$0).jdField_b_of_type_Int + " shareContext = " + bmtc.a(this.this$0).jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
    bmtc.a(this.this$0, new VipQGGLSurfaceView(this.this$0.a, bmtc.a(this.this$0).jdField_a_of_type_Int, bmtc.a(this.this$0).jdField_b_of_type_Int, bmtc.a(this.this$0).jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext, bmtc.a(this.this$0).jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig, bmtc.a(this.this$0).jdField_b_of_type_JavaLangString));
    bmtc.a(this.this$0).setLimitFrame(-1);
    bmtc.a(this.this$0).setOnTouchListener(null);
    bmtc.a(this.this$0).setQGEventListener(this.this$0);
    bmtc.a(this.this$0).addView(bmtc.a(this.this$0));
    bmtc.a(this.this$0, new bmte(this.this$0));
    if (bmtc.a(this.this$0).getModuleEngine() != null) {
      bmtc.a(this.this$0).getModuleEngine().registerJsModule(bmtc.a(this.this$0));
    }
    bmtc.a(this.this$0, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.ar.controller.VipQGThreeController.2
 * JD-Core Version:    0.7.0.1
 */