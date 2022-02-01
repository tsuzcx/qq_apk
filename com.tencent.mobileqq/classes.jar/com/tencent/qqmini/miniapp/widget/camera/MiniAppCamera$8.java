package com.tencent.qqmini.miniapp.widget.camera;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.ToastView;
import java.lang.ref.WeakReference;

class MiniAppCamera$8
  implements Runnable
{
  MiniAppCamera$8(MiniAppCamera paramMiniAppCamera, String paramString) {}
  
  public void run()
  {
    Activity localActivity;
    if (MiniAppCamera.access$800(this.this$0) != null)
    {
      localActivity = ((IMiniAppContext)MiniAppCamera.access$800(this.this$0).get()).getAttachedActivity();
      if ((localActivity != null) && (!localActivity.isFinishing())) {
        break label53;
      }
      QMLog.w("MiniAppCamera", "showLoading(). Do nothing, activity is null or finishing");
    }
    label53:
    while (MiniAppCamera.access$900(this.this$0) != null)
    {
      return;
      localActivity = null;
      break;
    }
    MiniAppCamera.access$902(this.this$0, new ToastView(localActivity, (ViewGroup)localActivity.findViewById(16908290)));
    MiniAppCamera.access$900(this.this$0).show(1, "loading", null, this.val$content, -1, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.camera.MiniAppCamera.8
 * JD-Core Version:    0.7.0.1
 */