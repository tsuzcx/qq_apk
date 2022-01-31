package cooperation.qzone;

import alud;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import beun;
import biqn;
import biqw;
import bjgc;
import bjgd;
import bjuz;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginTab;
import com.tencent.qphone.base.util.QLog;

public class QzonePluginProxyActivity$4$1
  implements Runnable
{
  public QzonePluginProxyActivity$4$1(bjgc parambjgc, String paramString, boolean paramBoolean1, boolean paramBoolean2, biqw parambiqw) {}
  
  public void run()
  {
    boolean bool = true;
    Object localObject1 = this.this$0.jdField_a_of_type_AndroidContentContext;
    if ((this.this$0.jdField_a_of_type_AndroidContentContext instanceof BasePluginActivity))
    {
      localObject1 = ((BasePluginActivity)this.this$0.jdField_a_of_type_AndroidContentContext).getOutActivity();
      QLog.w("QzonePluginProxyActivity", 1, alud.a(2131712586) + this.jdField_a_of_type_JavaLangString + ",context:" + this.this$0.jdField_a_of_type_AndroidContentContext);
      if ((localObject1 != null) && ((localObject1 instanceof PluginTab))) {
        localObject1 = ((PluginTab)localObject1).getOutActivity();
      }
    }
    for (;;)
    {
      if ((localObject1 == null) || ((localObject1 instanceof BasePluginActivity)))
      {
        QLog.e("QzonePluginProxyActivity", 1, "activity 参数错误，尝试进行兼容失败");
        bjuz.a(new IllegalArgumentException(alud.a(2131712575) + this.jdField_a_of_type_JavaLangString + ",context:" + this.this$0.jdField_a_of_type_AndroidContentContext), alud.a(2131712566));
        return;
      }
      Intent localIntent = null;
      Object localObject2 = localIntent;
      if (this.jdField_a_of_type_Boolean)
      {
        localObject2 = localIntent;
        if (!this.b)
        {
          localObject2 = new beun((Context)localObject1, this.this$0.jdField_a_of_type_AndroidContentIntent);
          ((beun)localObject2).a(alud.a(2131712573));
          ((beun)localObject2).setOnDismissListener(new bjgd(this));
        }
      }
      localIntent = this.this$0.jdField_a_of_type_AndroidContentIntent;
      if (localObject2 != null) {}
      for (;;)
      {
        localIntent.putExtra("QZoneExtra.Plugin.isloading", bool);
        this.jdField_a_of_type_Biqw.a = ((Dialog)localObject2);
        biqn.a((Context)localObject1, this.jdField_a_of_type_Biqw);
        return;
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.QzonePluginProxyActivity.4.1
 * JD-Core Version:    0.7.0.1
 */