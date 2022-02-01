package com.tencent.qzonehub.api.impl;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginTab;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QzoneProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.report.IQzoneExceptionReport;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;

class QzonePluginProxyActivityProxyImpl$4$1
  implements Runnable
{
  QzonePluginProxyActivityProxyImpl$4$1(QzonePluginProxyActivityProxyImpl.4 param4, String paramString, boolean paramBoolean1, boolean paramBoolean2, IPluginManager.PluginParams paramPluginParams) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.f;
    boolean bool2 = this.this$0.f instanceof BasePluginActivity;
    boolean bool1 = true;
    Object localObject2;
    if (bool2)
    {
      localObject2 = ((BasePluginActivity)this.this$0.f).getOutActivity();
      localObject1 = new StringBuilder(HardCodeUtil.a(2131909759));
      ((StringBuilder)localObject1).append(this.a);
      ((StringBuilder)localObject1).append(",context:");
      ((StringBuilder)localObject1).append(this.this$0.f);
      QLog.w("QzonePluginProxyActivity", 1, ((StringBuilder)localObject1).toString());
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if ((localObject2 instanceof PluginTab)) {
          localObject1 = ((PluginTab)localObject2).getOutActivity();
        }
      }
    }
    if ((localObject1 != null) && (!(localObject1 instanceof BasePluginActivity)))
    {
      Object localObject3 = null;
      localObject2 = localObject3;
      if (this.b)
      {
        localObject2 = localObject3;
        if (!this.c)
        {
          localObject2 = new QzoneProgressDialog((Context)localObject1, this.this$0.a);
          ((QzoneProgressDialog)localObject2).a(HardCodeUtil.a(2131909748));
          ((QzoneProgressDialog)localObject2).setOnDismissListener(new QzonePluginProxyActivityProxyImpl.4.1.1(this));
        }
      }
      localObject3 = this.this$0.a;
      if (localObject2 == null) {
        bool1 = false;
      }
      ((Intent)localObject3).putExtra("QZoneExtra.Plugin.isloading", bool1);
      localObject3 = this.d;
      ((IPluginManager.PluginParams)localObject3).l = ((Dialog)localObject2);
      IPluginManager.a((Context)localObject1, (IPluginManager.PluginParams)localObject3);
      return;
    }
    QLog.e("QzonePluginProxyActivity", 1, "activity 参数错误，尝试进行兼容失败");
    localObject1 = new StringBuilder(HardCodeUtil.a(2131909750));
    ((StringBuilder)localObject1).append(this.a);
    ((StringBuilder)localObject1).append(",context:");
    ((StringBuilder)localObject1).append(this.this$0.f);
    ((IQzoneExceptionReport)QRoute.api(IQzoneExceptionReport.class)).doReport(new IllegalArgumentException(((StringBuilder)localObject1).toString()), HardCodeUtil.a(2131909742));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QzonePluginProxyActivityProxyImpl.4.1
 * JD-Core Version:    0.7.0.1
 */