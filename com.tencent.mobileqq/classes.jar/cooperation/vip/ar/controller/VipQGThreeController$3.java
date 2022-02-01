package cooperation.vip.ar.controller;

import android.text.TextUtils;
import bmlv;
import bmlz;
import cooperation.qzone.util.QZLog;
import cooperation.vip.ar.widget.VipQGGLSurfaceView;
import java.io.File;

public class VipQGThreeController$3
  implements Runnable
{
  public VipQGThreeController$3(bmlv parambmlv) {}
  
  public void run()
  {
    if ((bmlv.a(this.this$0) != null) && (!TextUtils.isEmpty(bmlv.a(this.this$0).b)) && (bmlv.a(this.this$0) != null))
    {
      if (QZLog.isColorLevel()) {
        QZLog.i("VipARQGThreeController", 2, "js model runnable path = " + bmlv.a(this.this$0).b);
      }
      bmlv.a(this.this$0).setExtResPath(bmlv.a(this.this$0).b);
      bmlv.a(this.this$0).addJavaScriptFileFromSDCard(bmlv.a(this.this$0).b + File.separator + "qg.js");
      bmlv.a(this.this$0).addJavaScriptFileFromSDCard(bmlv.a(this.this$0).b + File.separator + "index.js");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.ar.controller.VipQGThreeController.3
 * JD-Core Version:    0.7.0.1
 */