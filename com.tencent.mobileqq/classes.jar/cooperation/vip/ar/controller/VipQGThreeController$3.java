package cooperation.vip.ar.controller;

import android.text.TextUtils;
import bmtc;
import bmtg;
import cooperation.qzone.util.QZLog;
import cooperation.vip.ar.widget.VipQGGLSurfaceView;
import java.io.File;

public class VipQGThreeController$3
  implements Runnable
{
  public VipQGThreeController$3(bmtc parambmtc) {}
  
  public void run()
  {
    if ((bmtc.a(this.this$0) != null) && (!TextUtils.isEmpty(bmtc.a(this.this$0).b)) && (bmtc.a(this.this$0) != null))
    {
      if (QZLog.isColorLevel()) {
        QZLog.i("VipARQGThreeController", 2, "js model runnable path = " + bmtc.a(this.this$0).b);
      }
      bmtc.a(this.this$0).setExtResPath(bmtc.a(this.this$0).b);
      bmtc.a(this.this$0).addJavaScriptFileFromSDCard(bmtc.a(this.this$0).b + File.separator + "qg.js");
      bmtc.a(this.this$0).addJavaScriptFileFromSDCard(bmtc.a(this.this$0).b + File.separator + "index.js");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.ar.controller.VipQGThreeController.3
 * JD-Core Version:    0.7.0.1
 */