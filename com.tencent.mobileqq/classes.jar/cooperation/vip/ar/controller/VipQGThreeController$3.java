package cooperation.vip.ar.controller;

import android.text.TextUtils;
import bkal;
import bkap;
import cooperation.qzone.util.QZLog;
import cooperation.vip.ar.widget.VipQGGLSurfaceView;
import java.io.File;

public class VipQGThreeController$3
  implements Runnable
{
  public VipQGThreeController$3(bkal parambkal) {}
  
  public void run()
  {
    if ((bkal.a(this.this$0) != null) && (!TextUtils.isEmpty(bkal.a(this.this$0).b)) && (bkal.a(this.this$0) != null))
    {
      if (QZLog.isColorLevel()) {
        QZLog.i("VipARQGThreeController", 2, "js model runnable path = " + bkal.a(this.this$0).b);
      }
      bkal.a(this.this$0).setExtResPath(bkal.a(this.this$0).b);
      bkal.a(this.this$0).addJavaScriptFileFromSDCard(bkal.a(this.this$0).b + File.separator + "qg.js");
      bkal.a(this.this$0).addJavaScriptFileFromSDCard(bkal.a(this.this$0).b + File.separator + "index.js");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.vip.ar.controller.VipQGThreeController.3
 * JD-Core Version:    0.7.0.1
 */