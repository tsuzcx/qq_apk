package com.tencent.mobileqq.troop.redpoint;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class RedPointUtils
{
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RedPointUtils", 2, "updateRedPointInfo : uin = " + paramString1 + ", uinType = " + paramString2 + ", redId = " + paramInt1 + ", unReadNum = " + paramInt2);
    }
    ((RedPointInfoManager)paramQQAppInterface.getManager(QQManagerFactory.RED_POINT_INFO_MANAGER)).a(paramString1, paramString2, paramInt1, paramInt2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, View paramView)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RedPointUtils", 2, "notifyRedPointViewClick uin = " + paramString1 + ", uinType = " + paramString2);
    }
    ((RedPointInfoManager)paramQQAppInterface.getManager(QQManagerFactory.RED_POINT_INFO_MANAGER)).a(paramString1, paramString2, paramView);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, List<Integer> paramList)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramList == null) || (paramList.isEmpty())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RedPointUtils", 2, "cleanRedPointInfoByIds : uin = " + paramString1 + ", uinType = " + paramString2 + ", redPointIdList = " + paramList.toString());
    }
    ((RedPointInfoManager)paramQQAppInterface.getManager(QQManagerFactory.RED_POINT_INFO_MANAGER)).a(paramString1, paramString2, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.redpoint.RedPointUtils
 * JD-Core Version:    0.7.0.1
 */