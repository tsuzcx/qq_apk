package cooperation.vip.ar.controller;

import android.view.ViewGroup;
import bkzr;
import bkzt;
import bkzv;
import com.tencent.qg.sdk.invoke.ModuleEngine;
import cooperation.qzone.util.QZLog;
import cooperation.vip.ar.widget.VipQGGLSurfaceView;

public class VipQGThreeController$2
  implements Runnable
{
  public VipQGThreeController$2(bkzr parambkzr) {}
  
  public void run()
  {
    QZLog.e("VipARQGThreeController", 2, new Object[] { "onDrawFrame status CREATE_QGVIEW success next status JS_MODEL_LOAD" });
    QZLog.i("VipARQGThreeController", 1, "createQGView width = " + bkzr.a(this.this$0).jdField_a_of_type_Int + " height = " + bkzr.a(this.this$0).jdField_b_of_type_Int + " shareContext = " + bkzr.a(this.this$0).jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
    bkzr.a(this.this$0, new VipQGGLSurfaceView(this.this$0.a, bkzr.a(this.this$0).jdField_a_of_type_Int, bkzr.a(this.this$0).jdField_b_of_type_Int, bkzr.a(this.this$0).jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext, bkzr.a(this.this$0).jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig, bkzr.a(this.this$0).jdField_b_of_type_JavaLangString));
    bkzr.a(this.this$0).setLimitFrame(-1);
    bkzr.a(this.this$0).setOnTouchListener(null);
    bkzr.a(this.this$0).setQGEventListener(this.this$0);
    bkzr.a(this.this$0).addView(bkzr.a(this.this$0));
    bkzr.a(this.this$0, new bkzt(this.this$0));
    if (bkzr.a(this.this$0).getModuleEngine() != null) {
      bkzr.a(this.this$0).getModuleEngine().registerJsModule(bkzr.a(this.this$0));
    }
    bkzr.a(this.this$0, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.ar.controller.VipQGThreeController.2
 * JD-Core Version:    0.7.0.1
 */