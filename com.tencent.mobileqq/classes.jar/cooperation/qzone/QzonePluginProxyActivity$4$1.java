package cooperation.qzone;

import ajjy;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import bbni;
import bfcz;
import bfdi;
import bfrq;
import bfrr;
import bgfy;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginTab;
import com.tencent.qphone.base.util.QLog;

public class QzonePluginProxyActivity$4$1
  implements Runnable
{
  public QzonePluginProxyActivity$4$1(bfrq parambfrq, String paramString, boolean paramBoolean1, boolean paramBoolean2, bfdi parambfdi) {}
  
  public void run()
  {
    boolean bool = true;
    Object localObject1 = this.this$0.jdField_a_of_type_AndroidAppActivity;
    Object localObject2;
    if ((this.this$0.jdField_a_of_type_AndroidAppActivity instanceof BasePluginActivity))
    {
      localObject2 = ((BasePluginActivity)this.this$0.jdField_a_of_type_AndroidAppActivity).getOutActivity();
      QLog.w("QzonePluginProxyActivity", 1, ajjy.a(2131646403) + this.jdField_a_of_type_JavaLangString + ",context:" + this.this$0.jdField_a_of_type_AndroidAppActivity);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if ((localObject2 instanceof PluginTab)) {
          localObject1 = ((PluginTab)localObject2).getOutActivity();
        }
      }
    }
    for (;;)
    {
      if ((localObject1 == null) || ((localObject1 instanceof BasePluginActivity)))
      {
        QLog.e("QzonePluginProxyActivity", 1, "activity 参数错误，尝试进行兼容失败");
        bgfy.a(new IllegalArgumentException(ajjy.a(2131646392) + this.jdField_a_of_type_JavaLangString + ",context:" + this.this$0.jdField_a_of_type_AndroidAppActivity), ajjy.a(2131646383));
        return;
      }
      Intent localIntent = null;
      localObject2 = localIntent;
      if (this.jdField_a_of_type_Boolean)
      {
        localObject2 = localIntent;
        if (!this.b)
        {
          localObject2 = new bbni((Context)localObject1, this.this$0.jdField_a_of_type_AndroidContentIntent);
          ((bbni)localObject2).a(ajjy.a(2131646390));
          ((bbni)localObject2).setOnDismissListener(new bfrr(this));
        }
      }
      localIntent = this.this$0.jdField_a_of_type_AndroidContentIntent;
      if (localObject2 != null) {}
      for (;;)
      {
        localIntent.putExtra("QZoneExtra.Plugin.isloading", bool);
        this.jdField_a_of_type_Bfdi.a = ((Dialog)localObject2);
        bfcz.a((Context)localObject1, this.jdField_a_of_type_Bfdi);
        return;
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.QzonePluginProxyActivity.4.1
 * JD-Core Version:    0.7.0.1
 */