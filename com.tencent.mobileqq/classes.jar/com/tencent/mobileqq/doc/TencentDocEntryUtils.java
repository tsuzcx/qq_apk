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
    paramAppInterface.a = ((TencentDocGrayTipsBean)localObject).a();
    paramAppInterface.b = ((TencentDocGrayTipsBean)localObject).b();
    paramAppInterface.c = ((TencentDocGrayTipsBean)localObject).c();
    paramAppInterface.d = ((TencentDocGrayTipsBean)localObject).d();
    paramAppInterface.e = ((TencentDocGrayTipsBean)localObject).e();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getGrayTipsInfo ");
      ((StringBuilder)localObject).append(paramAppInterface.toString());
      QLog.d("TencentDocEntryUtils", 2, ((StringBuilder)localObject).toString());
    }
    return paramAppInterface;
  }
  
  public static Pair<Boolean, Integer> b(AppInterface paramAppInterface)
  {
    paramAppInterface = TencentDocAIOShowGuideDialogProcessor.a();
    return new Pair(Boolean.valueOf(paramAppInterface.b()), Integer.valueOf(paramAppInterface.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doc.TencentDocEntryUtils
 * JD-Core Version:    0.7.0.1
 */