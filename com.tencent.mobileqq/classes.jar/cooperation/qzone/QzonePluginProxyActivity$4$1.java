package cooperation.qzone;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginTab;
import com.tencent.mobileqq.widget.QzoneProgressDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qzone.util.QZoneExceptionReport;

class QzonePluginProxyActivity$4$1
  implements Runnable
{
  QzonePluginProxyActivity$4$1(QzonePluginProxyActivity.4 param4, String paramString, boolean paramBoolean1, boolean paramBoolean2, IPluginManager.PluginParams paramPluginParams) {}
  
  public void run()
  {
    boolean bool = true;
    Object localObject1 = this.this$0.val$activity;
    if ((this.this$0.val$activity instanceof BasePluginActivity))
    {
      localObject1 = ((BasePluginActivity)this.this$0.val$activity).getOutActivity();
      QLog.w("QzonePluginProxyActivity", 1, HardCodeUtil.a(2131712168) + this.val$activityName + ",context:" + this.this$0.val$activity);
      if ((localObject1 != null) && ((localObject1 instanceof PluginTab))) {
        localObject1 = ((PluginTab)localObject1).getOutActivity();
      }
    }
    for (;;)
    {
      if ((localObject1 == null) || ((localObject1 instanceof BasePluginActivity)))
      {
        QLog.e("QzonePluginProxyActivity", 1, "activity 参数错误，尝试进行兼容失败");
        QZoneExceptionReport.doReport(new IllegalArgumentException(HardCodeUtil.a(2131712157) + this.val$activityName + ",context:" + this.this$0.val$activity), HardCodeUtil.a(2131712148));
        return;
      }
      Intent localIntent = null;
      Object localObject2 = localIntent;
      if (this.val$showProgressDialog)
      {
        localObject2 = localIntent;
        if (!this.val$isQzoneProcessExist)
        {
          localObject2 = new QzoneProgressDialog((Context)localObject1, this.this$0.val$intent);
          ((QzoneProgressDialog)localObject2).a(HardCodeUtil.a(2131712155));
          ((QzoneProgressDialog)localObject2).setOnDismissListener(new QzonePluginProxyActivity.4.1.1(this));
        }
      }
      localIntent = this.this$0.val$intent;
      if (localObject2 != null) {}
      for (;;)
      {
        localIntent.putExtra("QZoneExtra.Plugin.isloading", bool);
        this.val$pp.a = ((Dialog)localObject2);
        IPluginManager.a((Context)localObject1, this.val$pp);
        return;
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.QzonePluginProxyActivity.4.1
 * JD-Core Version:    0.7.0.1
 */