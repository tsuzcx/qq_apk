package com.tencent.mobileqq.doc;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

public class TencentDocGuideHelper
{
  public static int a(AppInterface paramAppInterface, Context paramContext)
  {
    if ((paramAppInterface != null) && (paramContext != null))
    {
      paramContext = paramContext.getSharedPreferences("tencent_doc", 4);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("shown_");
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      int i = paramContext.getInt(localStringBuilder.toString(), 0);
      if (QLog.isColorLevel())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("getShownTimes ");
        paramAppInterface.append(i);
        QLog.i("TencentDocGuideHelper", 2, paramAppInterface.toString());
      }
      return i;
    }
    QLog.e("TencentDocGuideHelper", 1, "getShownTimes sth is null");
    return 0;
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, int paramInt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setShownTimes ");
      localStringBuilder.append(paramInt);
      QLog.i("TencentDocGuideHelper", 2, localStringBuilder.toString());
    }
    if ((paramAppInterface != null) && (paramContext != null))
    {
      paramContext = paramContext.getSharedPreferences("tencent_doc", 4).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("shown_");
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      paramContext.putInt(localStringBuilder.toString(), paramInt).commit();
      return;
    }
    QLog.e("TencentDocGuideHelper", 1, "setShownTimes sth is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.doc.TencentDocGuideHelper
 * JD-Core Version:    0.7.0.1
 */