package cooperation.vip.ar.controller;

import android.view.ViewGroup;
import bmlv;
import bmlx;
import bmlz;
import com.tencent.qg.sdk.invoke.ModuleEngine;
import cooperation.qzone.util.QZLog;
import cooperation.vip.ar.widget.VipQGGLSurfaceView;

public class VipQGThreeController$2
  implements Runnable
{
  public VipQGThreeController$2(bmlv parambmlv) {}
  
  public void run()
  {
    QZLog.e("VipARQGThreeController", 2, new Object[] { "onDrawFrame status CREATE_QGVIEW success next status JS_MODEL_LOAD" });
    QZLog.i("VipARQGThreeController", 1, "createQGView width = " + bmlv.a(this.this$0).jdField_a_of_type_Int + " height = " + bmlv.a(this.this$0).jdField_b_of_type_Int + " shareContext = " + bmlv.a(this.this$0).jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
    bmlv.a(this.this$0, new VipQGGLSurfaceView(this.this$0.a, bmlv.a(this.this$0).jdField_a_of_type_Int, bmlv.a(this.this$0).jdField_b_of_type_Int, bmlv.a(this.this$0).jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext, bmlv.a(this.this$0).jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig, bmlv.a(this.this$0).jdField_b_of_type_JavaLangString));
    bmlv.a(this.this$0).setLimitFrame(-1);
    bmlv.a(this.this$0).setOnTouchListener(null);
    bmlv.a(this.this$0).setQGEventListener(this.this$0);
    bmlv.a(this.this$0).addView(bmlv.a(this.this$0));
    bmlv.a(this.this$0, new bmlx(this.this$0));
    if (bmlv.a(this.this$0).getModuleEngine() != null) {
      bmlv.a(this.this$0).getModuleEngine().registerJsModule(bmlv.a(this.this$0));
    }
    bmlv.a(this.this$0, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.ar.controller.VipQGThreeController.2
 * JD-Core Version:    0.7.0.1
 */