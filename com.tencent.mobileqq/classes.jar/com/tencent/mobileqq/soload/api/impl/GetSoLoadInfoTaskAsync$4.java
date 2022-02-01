package com.tencent.mobileqq.soload.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.soload.biz.OnSoGetPathListener;
import com.tencent.qphone.base.util.QLog;

class GetSoLoadInfoTaskAsync$4
  implements OnSoGetPathListener
{
  GetSoLoadInfoTaskAsync$4(GetSoLoadInfoTaskAsync paramGetSoLoadInfoTaskAsync, String paramString, long paramLong, int paramInt) {}
  
  public void onResult(int paramInt1, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("[downRFiles] download resCode=");
      paramString1.append(paramInt1);
      QLog.i("SoLoadWidget.GetSoTaskAsync", 2, paramString1.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqSoloadApiImplGetSoLoadInfoTaskAsync.jdField_a_of_type_Int = paramInt2;
    if ((paramInt1 == 0) && (!TextUtils.isEmpty(paramString2)))
    {
      GetSoLoadInfoTaskAsync.a(this.jdField_a_of_type_ComTencentMobileqqSoloadApiImplGetSoLoadInfoTaskAsync, paramString2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int);
      return;
    }
    GetSoLoadInfoTaskAsync.a(this.jdField_a_of_type_ComTencentMobileqqSoloadApiImplGetSoLoadInfoTaskAsync, 11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.GetSoLoadInfoTaskAsync.4
 * JD-Core Version:    0.7.0.1
 */