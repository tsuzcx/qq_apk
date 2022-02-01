package com.tencent.mobileqq.doc;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.tendoc.TencentDocAIOShowGuideDialogBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocAIOShowGuideDialogProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocGrayTipsBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocGrayTipsProcessor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;

public final class TencentDocEntryUtils
{
  public static TencentDocEntryUtils.GrayTipsInfo a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = new TencentDocEntryUtils.GrayTipsInfo();
    TencentDocGrayTipsBean localTencentDocGrayTipsBean = TencentDocGrayTipsProcessor.a();
    paramQQAppInterface.jdField_a_of_type_Boolean = localTencentDocGrayTipsBean.a();
    paramQQAppInterface.jdField_a_of_type_JavaLangString = localTencentDocGrayTipsBean.a();
    paramQQAppInterface.b = localTencentDocGrayTipsBean.b();
    paramQQAppInterface.jdField_a_of_type_Int = localTencentDocGrayTipsBean.a();
    paramQQAppInterface.c = localTencentDocGrayTipsBean.c();
    if (QLog.isColorLevel()) {
      QLog.d("TencentDocEntryUtils", 2, "getGrayTipsInfo " + paramQQAppInterface.toString());
    }
    return paramQQAppInterface;
  }
  
  public static Pair<Boolean, Integer> a(AppInterface paramAppInterface)
  {
    paramAppInterface = TencentDocAIOShowGuideDialogProcessor.a();
    return new Pair(Boolean.valueOf(paramAppInterface.a()), Integer.valueOf(paramAppInterface.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doc.TencentDocEntryUtils
 * JD-Core Version:    0.7.0.1
 */