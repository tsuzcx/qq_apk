package com.tencent.mobileqq.doc;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.config.business.tendoc.TencentDocAIOShowGuideDialogBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocAIOShowGuideDialogProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocGrayTipsBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocGrayTipsProcessor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;

public final class TencentDocEntryUtils
{
  public static TencentDocEntryUtils.GrayTipsInfo a(AppInterface paramAppInterface)
  {
    paramAppInterface = new TencentDocEntryUtils.GrayTipsInfo();
    Object localObject = TencentDocGrayTipsProcessor.a();
    paramAppInterface.jdField_a_of_type_Boolean = ((TencentDocGrayTipsBean)localObject).a();
    paramAppInterface.jdField_a_of_type_JavaLangString = ((TencentDocGrayTipsBean)localObject).a();
    paramAppInterface.b = ((TencentDocGrayTipsBean)localObject).b();
    paramAppInterface.jdField_a_of_type_Int = ((TencentDocGrayTipsBean)localObject).a();
    paramAppInterface.c = ((TencentDocGrayTipsBean)localObject).c();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getGrayTipsInfo ");
      ((StringBuilder)localObject).append(paramAppInterface.toString());
      QLog.d("TencentDocEntryUtils", 2, ((StringBuilder)localObject).toString());
    }
    return paramAppInterface;
  }
  
  public static Pair<Boolean, Integer> a(AppInterface paramAppInterface)
  {
    paramAppInterface = TencentDocAIOShowGuideDialogProcessor.a();
    return new Pair(Boolean.valueOf(paramAppInterface.a()), Integer.valueOf(paramAppInterface.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.doc.TencentDocEntryUtils
 * JD-Core Version:    0.7.0.1
 */