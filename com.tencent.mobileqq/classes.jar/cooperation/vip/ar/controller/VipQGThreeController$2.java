package cooperation.vip.ar.controller;

import android.view.ViewGroup;
import bnuk;
import bnum;
import bnuo;
import com.tencent.qg.sdk.invoke.ModuleEngine;
import cooperation.qzone.util.QZLog;
import cooperation.vip.ar.widget.VipQGGLSurfaceView;

public class VipQGThreeController$2
  implements Runnable
{
  public VipQGThreeController$2(bnuk parambnuk) {}
  
  public void run()
  {
    QZLog.e("VipARQGThreeController", 2, new Object[] { "onDrawFrame status CREATE_QGVIEW success next status JS_MODEL_LOAD" });
    QZLog.i("VipARQGThreeController", 1, "createQGView width = " + bnuk.a(this.this$0).jdField_a_of_type_Int + " height = " + bnuk.a(this.this$0).jdField_b_of_type_Int + " shareContext = " + bnuk.a(this.this$0).jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
    bnuk.a(this.this$0, new VipQGGLSurfaceView(this.this$0.a, bnuk.a(this.this$0).jdField_a_of_type_Int, bnuk.a(this.this$0).jdField_b_of_type_Int, bnuk.a(this.this$0).jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext, bnuk.a(this.this$0).jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig, bnuk.a(this.this$0).jdField_b_of_type_JavaLangString));
    bnuk.a(this.this$0).setLimitFrame(-1);
    bnuk.a(this.this$0).setOnTouchListener(null);
    bnuk.a(this.this$0).setQGEventListener(this.this$0);
    bnuk.a(this.this$0).addView(bnuk.a(this.this$0));
    bnuk.a(this.this$0, new bnum(this.this$0));
    if (bnuk.a(this.this$0).getModuleEngine() != null) {
      bnuk.a(this.this$0).getModuleEngine().registerJsModule(bnuk.a(this.this$0));
    }
    bnuk.a(this.this$0, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.ar.controller.VipQGThreeController.2
 * JD-Core Version:    0.7.0.1
 */