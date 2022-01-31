package cooperation.vip.ar.controller;

import android.view.ViewGroup;
import bhyp;
import bhyr;
import bhyt;
import com.tencent.qg.sdk.invoke.ModuleEngine;
import cooperation.qzone.util.QZLog;
import cooperation.vip.ar.widget.VipQGGLSurfaceView;

public class VipQGThreeController$2
  implements Runnable
{
  public VipQGThreeController$2(bhyp parambhyp) {}
  
  public void run()
  {
    QZLog.e("VipARQGThreeController", 2, new Object[] { "onDrawFrame status CREATE_QGVIEW success next status JS_MODEL_LOAD" });
    QZLog.i("VipARQGThreeController", 1, "createQGView width = " + bhyp.a(this.this$0).jdField_a_of_type_Int + " height = " + bhyp.a(this.this$0).jdField_b_of_type_Int + " shareContext = " + bhyp.a(this.this$0).jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
    bhyp.a(this.this$0, new VipQGGLSurfaceView(this.this$0.a, bhyp.a(this.this$0).jdField_a_of_type_Int, bhyp.a(this.this$0).jdField_b_of_type_Int, bhyp.a(this.this$0).jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext, bhyp.a(this.this$0).jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig, bhyp.a(this.this$0).jdField_b_of_type_JavaLangString));
    bhyp.a(this.this$0).setLimitFrame(-1);
    bhyp.a(this.this$0).setOnTouchListener(null);
    bhyp.a(this.this$0).setQGEventListener(this.this$0);
    bhyp.a(this.this$0).addView(bhyp.a(this.this$0));
    bhyp.a(this.this$0, new bhyr(this.this$0));
    if (bhyp.a(this.this$0).getModuleEngine() != null) {
      bhyp.a(this.this$0).getModuleEngine().registerJsModule(bhyp.a(this.this$0));
    }
    bhyp.a(this.this$0, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.vip.ar.controller.VipQGThreeController.2
 * JD-Core Version:    0.7.0.1
 */