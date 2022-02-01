package com.tencent.mobileqq.filemanager.util;

import android.app.Activity;
import android.graphics.BitmapFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.smtt.sdk.ValueCallback;
import java.lang.ref.WeakReference;

final class QQFileManagerUtilImpl$6
  implements ValueCallback<String>
{
  QQFileManagerUtilImpl$6(WeakReference paramWeakReference, String paramString, WXShareHelper paramWXShareHelper) {}
  
  public void a(String paramString)
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localActivity != null)
    {
      if (paramString == null) {
        return;
      }
      Object localObject = paramString.split(":");
      if ((localObject != null) && (localObject.length == 2) && (!localObject[0].startsWith("http")))
      {
        paramString = localObject[0];
        localObject = localObject[1];
        String str = QQFileManagerUtilImpl.i(paramString);
        int i = QQFileManagerUtilImpl.f((String)localObject);
        if (str != null) {
          ReportController.b(null, "dc00898", "", "", str, str, i, 0, "", "", "", "");
        }
        if (((paramString.startsWith("userClick")) || (paramString.startsWith("extraMenuEvent"))) && (((String)localObject).equalsIgnoreCase("send_to_wx")) && (QQFileUtilsImpl.a(localActivity, this.jdField_a_of_type_JavaLangString)))
        {
          i = QQFileManagerUtilImpl.c(this.jdField_a_of_type_JavaLangString);
          paramString = BitmapFactory.decodeResource(localActivity.getResources(), i);
          this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper.a(this.jdField_a_of_type_JavaLangString, paramString);
        }
      }
      else if (paramString.startsWith("http"))
      {
        ReportController.b(null, "dc00898", "", "", "0X800AE47", "0X800AE47", 0, 0, "", "", "", "");
        FMDialogUtil.a(localActivity, null, 2131698190, new QQFileManagerUtilImpl.6.1(this, localActivity));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl.6
 * JD-Core Version:    0.7.0.1
 */