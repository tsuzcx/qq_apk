package cooperation.vip.ar.controller;

import android.view.ViewGroup;
import bkes;
import bkeu;
import bkew;
import com.tencent.qg.sdk.invoke.ModuleEngine;
import cooperation.qzone.util.QZLog;
import cooperation.vip.ar.widget.VipQGGLSurfaceView;

public class VipQGThreeController$2
  implements Runnable
{
  public VipQGThreeController$2(bkes parambkes) {}
  
  public void run()
  {
    QZLog.e("VipARQGThreeController", 2, new Object[] { "onDrawFrame status CREATE_QGVIEW success next status JS_MODEL_LOAD" });
    QZLog.i("VipARQGThreeController", 1, "createQGView width = " + bkes.a(this.this$0).jdField_a_of_type_Int + " height = " + bkes.a(this.this$0).jdField_b_of_type_Int + " shareContext = " + bkes.a(this.this$0).jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
    bkes.a(this.this$0, new VipQGGLSurfaceView(this.this$0.a, bkes.a(this.this$0).jdField_a_of_type_Int, bkes.a(this.this$0).jdField_b_of_type_Int, bkes.a(this.this$0).jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext, bkes.a(this.this$0).jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig, bkes.a(this.this$0).jdField_b_of_type_JavaLangString));
    bkes.a(this.this$0).setLimitFrame(-1);
    bkes.a(this.this$0).setOnTouchListener(null);
    bkes.a(this.this$0).setQGEventListener(this.this$0);
    bkes.a(this.this$0).addView(bkes.a(this.this$0));
    bkes.a(this.this$0, new bkeu(this.this$0));
    if (bkes.a(this.this$0).getModuleEngine() != null) {
      bkes.a(this.this$0).getModuleEngine().registerJsModule(bkes.a(this.this$0));
    }
    bkes.a(this.this$0, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.vip.ar.controller.VipQGThreeController.2
 * JD-Core Version:    0.7.0.1
 */