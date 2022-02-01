package cooperation.qzone;

import amtj;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import bhik;
import bkkq;
import bkkz;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginTab;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZoneExceptionReport;

class QzonePluginProxyActivity$4$1
  implements Runnable
{
  QzonePluginProxyActivity$4$1(QzonePluginProxyActivity.4 param4, String paramString, boolean paramBoolean1, boolean paramBoolean2, bkkz parambkkz) {}
  
  public void run()
  {
    boolean bool = true;
    Object localObject1 = this.this$0.val$activity;
    if ((this.this$0.val$activity instanceof BasePluginActivity))
    {
      localObject1 = ((BasePluginActivity)this.this$0.val$activity).getOutActivity();
      QLog.w("QzonePluginProxyActivity", 1, amtj.a(2131711306) + this.val$activityName + ",context:" + this.this$0.val$activity);
      if ((localObject1 != null) && ((localObject1 instanceof PluginTab))) {
        localObject1 = ((PluginTab)localObject1).getOutActivity();
      }
    }
    for (;;)
    {
      if ((localObject1 == null) || ((localObject1 instanceof BasePluginActivity)))
      {
        QLog.e("QzonePluginProxyActivity", 1, "activity 参数错误，尝试进行兼容失败");
        QZoneExceptionReport.doReport(new IllegalArgumentException(amtj.a(2131711295) + this.val$activityName + ",context:" + this.this$0.val$activity), amtj.a(2131711286));
        return;
      }
      Intent localIntent = null;
      Object localObject2 = localIntent;
      if (this.val$showProgressDialog)
      {
        localObject2 = localIntent;
        if (!this.val$isQzoneProcessExist)
        {
          localObject2 = new bhik((Context)localObject1, this.this$0.val$intent);
          ((bhik)localObject2).a(amtj.a(2131711293));
          ((bhik)localObject2).setOnDismissListener(new QzonePluginProxyActivity.4.1.1(this));
        }
      }
      localIntent = this.this$0.val$intent;
      if (localObject2 != null) {}
      for (;;)
      {
        localIntent.putExtra("QZoneExtra.Plugin.isloading", bool);
        this.val$pp.a = ((Dialog)localObject2);
        bkkq.a((Context)localObject1, this.val$pp);
        return;
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QzonePluginProxyActivity.4.1
 * JD-Core Version:    0.7.0.1
 */