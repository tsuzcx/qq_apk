package cooperation.qzone;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import anzj;
import bjcj;
import bmgk;
import bmgt;
import bmvl;
import bmvm;
import bnkm;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginTab;
import com.tencent.qphone.base.util.QLog;

public class QzonePluginProxyActivity$4$1
  implements Runnable
{
  public QzonePluginProxyActivity$4$1(bmvl parambmvl, String paramString, boolean paramBoolean1, boolean paramBoolean2, bmgt parambmgt) {}
  
  public void run()
  {
    boolean bool = true;
    Object localObject1 = this.this$0.jdField_a_of_type_AndroidContentContext;
    if ((this.this$0.jdField_a_of_type_AndroidContentContext instanceof BasePluginActivity))
    {
      localObject1 = ((BasePluginActivity)this.this$0.jdField_a_of_type_AndroidContentContext).getOutActivity();
      QLog.w("QzonePluginProxyActivity", 1, anzj.a(2131711074) + this.jdField_a_of_type_JavaLangString + ",context:" + this.this$0.jdField_a_of_type_AndroidContentContext);
      if ((localObject1 != null) && ((localObject1 instanceof PluginTab))) {
        localObject1 = ((PluginTab)localObject1).getOutActivity();
      }
    }
    for (;;)
    {
      if ((localObject1 == null) || ((localObject1 instanceof BasePluginActivity)))
      {
        QLog.e("QzonePluginProxyActivity", 1, "activity 参数错误，尝试进行兼容失败");
        bnkm.a(new IllegalArgumentException(anzj.a(2131711063) + this.jdField_a_of_type_JavaLangString + ",context:" + this.this$0.jdField_a_of_type_AndroidContentContext), anzj.a(2131711054));
        return;
      }
      Intent localIntent = null;
      Object localObject2 = localIntent;
      if (this.jdField_a_of_type_Boolean)
      {
        localObject2 = localIntent;
        if (!this.b)
        {
          localObject2 = new bjcj((Context)localObject1, this.this$0.jdField_a_of_type_AndroidContentIntent);
          ((bjcj)localObject2).a(anzj.a(2131711061));
          ((bjcj)localObject2).setOnDismissListener(new bmvm(this));
        }
      }
      localIntent = this.this$0.jdField_a_of_type_AndroidContentIntent;
      if (localObject2 != null) {}
      for (;;)
      {
        localIntent.putExtra("QZoneExtra.Plugin.isloading", bool);
        this.jdField_a_of_type_Bmgt.a = ((Dialog)localObject2);
        bmgk.a((Context)localObject1, this.jdField_a_of_type_Bmgt);
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