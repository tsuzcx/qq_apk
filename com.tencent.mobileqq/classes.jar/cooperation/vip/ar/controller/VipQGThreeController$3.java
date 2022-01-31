package cooperation.vip.ar.controller;

import android.text.TextUtils;
import bhyp;
import bhyt;
import cooperation.qzone.util.QZLog;
import cooperation.vip.ar.widget.VipQGGLSurfaceView;
import java.io.File;

public class VipQGThreeController$3
  implements Runnable
{
  public VipQGThreeController$3(bhyp parambhyp) {}
  
  public void run()
  {
    if ((bhyp.a(this.this$0) != null) && (!TextUtils.isEmpty(bhyp.a(this.this$0).b)) && (bhyp.a(this.this$0) != null))
    {
      if (QZLog.isColorLevel()) {
        QZLog.i("VipARQGThreeController", 2, "js model runnable path = " + bhyp.a(this.this$0).b);
      }
      bhyp.a(this.this$0).setExtResPath(bhyp.a(this.this$0).b);
      bhyp.a(this.this$0).addJavaScriptFileFromSDCard(bhyp.a(this.this$0).b + File.separator + "qg.js");
      bhyp.a(this.this$0).addJavaScriptFileFromSDCard(bhyp.a(this.this$0).b + File.separator + "index.js");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.vip.ar.controller.VipQGThreeController.3
 * JD-Core Version:    0.7.0.1
 */