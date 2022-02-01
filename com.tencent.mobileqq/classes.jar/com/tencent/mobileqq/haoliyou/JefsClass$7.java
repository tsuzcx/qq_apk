package com.tencent.mobileqq.haoliyou;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

class JefsClass$7
  implements Runnable
{
  JefsClass$7(JefsClass paramJefsClass, Intent paramIntent, JefsClass.CancelableRunnable paramCancelableRunnable, WeakReference paramWeakReference, String paramString1, String paramString2) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Object localObject;
        if ("application/vnd.android.package-archive".equalsIgnoreCase(this.jdField_a_of_type_AndroidContentIntent.getType()))
        {
          localObject = this.jdField_a_of_type_AndroidContentIntent.getData();
          localObject = FileProvider7Helper.getRealPathFromContentURI(MobileQQ.context, (Uri)localObject);
        }
        else
        {
          localObject = Uri.parse(this.jdField_a_of_type_AndroidContentIntent.getStringExtra("yyb_install_url")).getQueryParameter("filepath");
        }
        if (localObject == null)
        {
          QLog.w("TeleScreen|JefsClass", 1, "apk path is null");
          JefsClass.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass$CancelableRunnable);
          return;
        }
        str2 = null;
        if (new File((String)localObject).exists())
        {
          localObject = MobileQQ.context.getPackageManager().getPackageArchiveInfo((String)localObject, 0);
          if (localObject != null)
          {
            localObject = ((PackageInfo)localObject).packageName;
            break label205;
          }
        }
        else
        {
          localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
          if ((str2 != null) && (localObject != null))
          {
            JefsClass.a(this.this$0, (Context)localObject, this.jdField_a_of_type_JavaLangString, this.b, str2, null, this.jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass$CancelableRunnable);
            return;
          }
          QLog.i("TeleScreen|JefsClass", 1, "could not resolve apk file's package");
          JefsClass.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass$CancelableRunnable);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("TeleScreen|JefsClass", 1, localThrowable, new Object[0]);
        JefsClass.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqHaoliyouJefsClass$CancelableRunnable);
        return;
      }
      String str1 = "";
      label205:
      String str2 = str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.haoliyou.JefsClass.7
 * JD-Core Version:    0.7.0.1
 */