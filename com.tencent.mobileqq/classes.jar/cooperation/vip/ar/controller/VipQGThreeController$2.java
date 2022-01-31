package cooperation.vip.ar.controller;

import android.view.ViewGroup;
import bgpb;
import bgpd;
import bgpf;
import com.tencent.qg.sdk.invoke.ModuleEngine;
import cooperation.qzone.util.QZLog;
import cooperation.vip.ar.widget.VipQGGLSurfaceView;

public class VipQGThreeController$2
  implements Runnable
{
  public VipQGThreeController$2(bgpb parambgpb) {}
  
  public void run()
  {
    QZLog.e("VipARQGThreeController", 2, new Object[] { "onDrawFrame status CREATE_QGVIEW success next status JS_MODEL_LOAD" });
    QZLog.i("VipARQGThreeController", 1, "createQGView width = " + bgpb.a(this.this$0).jdField_a_of_type_Int + " height = " + bgpb.a(this.this$0).jdField_b_of_type_Int + " shareContext = " + bgpb.a(this.this$0).jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext);
    bgpb.a(this.this$0, new VipQGGLSurfaceView(this.this$0.a, bgpb.a(this.this$0).jdField_a_of_type_Int, bgpb.a(this.this$0).jdField_b_of_type_Int, bgpb.a(this.this$0).jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext, bgpb.a(this.this$0).jdField_a_of_type_JavaxMicroeditionKhronosEglEGLConfig, bgpb.a(this.this$0).jdField_b_of_type_JavaLangString));
    bgpb.a(this.this$0).setLimitFrame(-1);
    bgpb.a(this.this$0).setOnTouchListener(null);
    bgpb.a(this.this$0).setQGEventListener(this.this$0);
    bgpb.a(this.this$0).addView(bgpb.a(this.this$0));
    bgpb.a(this.this$0, new bgpd(this.this$0));
    if (bgpb.a(this.this$0).getModuleEngine() != null) {
      bgpb.a(this.this$0).getModuleEngine().registerJsModule(bgpb.a(this.this$0));
    }
    bgpb.a(this.this$0, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.vip.ar.controller.VipQGThreeController.2
 * JD-Core Version:    0.7.0.1
 */