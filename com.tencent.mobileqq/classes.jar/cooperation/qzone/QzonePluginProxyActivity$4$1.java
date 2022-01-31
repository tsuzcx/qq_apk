package cooperation.qzone;

import ajyc;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import bcqg;
import bgkq;
import bgkz;
import bgzx;
import bgzy;
import bhoq;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginTab;
import com.tencent.qphone.base.util.QLog;

public class QzonePluginProxyActivity$4$1
  implements Runnable
{
  public QzonePluginProxyActivity$4$1(bgzx parambgzx, String paramString, boolean paramBoolean1, boolean paramBoolean2, bgkz parambgkz) {}
  
  public void run()
  {
    boolean bool = true;
    Object localObject1 = this.this$0.jdField_a_of_type_AndroidContentContext;
    if ((this.this$0.jdField_a_of_type_AndroidContentContext instanceof BasePluginActivity))
    {
      localObject1 = ((BasePluginActivity)this.this$0.jdField_a_of_type_AndroidContentContext).getOutActivity();
      QLog.w("QzonePluginProxyActivity", 1, ajyc.a(2131712191) + this.jdField_a_of_type_JavaLangString + ",context:" + this.this$0.jdField_a_of_type_AndroidContentContext);
      if ((localObject1 != null) && ((localObject1 instanceof PluginTab))) {
        localObject1 = ((PluginTab)localObject1).getOutActivity();
      }
    }
    for (;;)
    {
      if ((localObject1 == null) || ((localObject1 instanceof BasePluginActivity)))
      {
        QLog.e("QzonePluginProxyActivity", 1, "activity 参数错误，尝试进行兼容失败");
        bhoq.a(new IllegalArgumentException(ajyc.a(2131712180) + this.jdField_a_of_type_JavaLangString + ",context:" + this.this$0.jdField_a_of_type_AndroidContentContext), ajyc.a(2131712171));
        return;
      }
      Intent localIntent = null;
      Object localObject2 = localIntent;
      if (this.jdField_a_of_type_Boolean)
      {
        localObject2 = localIntent;
        if (!this.b)
        {
          localObject2 = new bcqg((Context)localObject1, this.this$0.jdField_a_of_type_AndroidContentIntent);
          ((bcqg)localObject2).a(ajyc.a(2131712178));
          ((bcqg)localObject2).setOnDismissListener(new bgzy(this));
        }
      }
      localIntent = this.this$0.jdField_a_of_type_AndroidContentIntent;
      if (localObject2 != null) {}
      for (;;)
      {
        localIntent.putExtra("QZoneExtra.Plugin.isloading", bool);
        this.jdField_a_of_type_Bgkz.a = ((Dialog)localObject2);
        bgkq.a((Context)localObject1, this.jdField_a_of_type_Bgkz);
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