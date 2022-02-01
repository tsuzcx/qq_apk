package com.tencent.mobileqq.troop.jointroopsecuritytips;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.List;

public class JoinTroopSecurityTipsHelper
{
  private static DialogInterface.OnClickListener a(boolean paramBoolean, String paramString, Context paramContext)
  {
    if ((paramBoolean) && (paramContext != null))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getBtnListener, isShow = ");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append(", jumpUrl = ");
        localStringBuilder.append(paramString);
        QLog.d("JoinTroopSecurityTipsHelper", 2, localStringBuilder.toString());
      }
      if (TextUtils.isEmpty(paramString)) {
        return new JoinTroopSecurityTipsHelper.1();
      }
      return new JoinTroopSecurityTipsHelper.2(paramContext, paramString);
    }
    return null;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, long paramLong, Context paramContext)
  {
    if (paramContext != null)
    {
      if (paramQQAppInterface == null) {
        return;
      }
      Object localObject3 = (JoinTroopSecurityTipsConfig)QConfigManager.a().a(669);
      if (localObject3 == null) {
        return;
      }
      Object localObject2 = ((JoinTroopSecurityTipsConfig)localObject3).a(paramInt);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = ((JoinTroopSecurityTipsConfig)localObject3).a(paramContext);
      }
      if ((localObject1 != null) && (((JoinTroopSecurityTipsItem)localObject1).jdField_a_of_type_JavaUtilList != null))
      {
        if (((JoinTroopSecurityTipsItem)localObject1).jdField_a_of_type_JavaUtilList.size() == 0) {
          return;
        }
        String str2 = ((JoinTroopSecurityTipsItem)localObject1).jdField_a_of_type_JavaLangString;
        localObject2 = ((JoinTroopSecurityTipsItem)localObject1).b;
        localObject3 = Calendar.getInstance();
        ((Calendar)localObject3).setTimeInMillis(paramLong);
        int i = ((Calendar)localObject3).get(3);
        int j = ((Calendar)localObject3).get(5);
        String str3 = ((String)localObject2).replace("$M$", String.valueOf(i)).replace("$d$", String.valueOf(j));
        localObject2 = ((JoinTroopSecurityTipsItem)localObject1).jdField_a_of_type_JavaUtilList;
        boolean bool2 = false;
        JoinTroopSecurityTipsItem.JoinTroopSecurityTipsBtn localJoinTroopSecurityTipsBtn = (JoinTroopSecurityTipsItem.JoinTroopSecurityTipsBtn)((List)localObject2).get(0);
        if (localJoinTroopSecurityTipsBtn == null) {
          return;
        }
        boolean bool3 = TextUtils.isEmpty(localJoinTroopSecurityTipsBtn.jdField_a_of_type_JavaLangString) ^ true;
        boolean bool1 = TextUtils.isEmpty(localJoinTroopSecurityTipsBtn.b);
        String str1 = "";
        if ((!bool1) && (!TextUtils.isEmpty(localJoinTroopSecurityTipsBtn.c)) && (localJoinTroopSecurityTipsBtn.b.equals("web"))) {
          localObject2 = localJoinTroopSecurityTipsBtn.c;
        } else {
          localObject2 = "";
        }
        Object localObject4 = null;
        bool1 = bool2;
        localObject3 = str1;
        if (((JoinTroopSecurityTipsItem)localObject1).jdField_a_of_type_JavaUtilList.size() > 1)
        {
          localObject1 = (JoinTroopSecurityTipsItem.JoinTroopSecurityTipsBtn)((JoinTroopSecurityTipsItem)localObject1).jdField_a_of_type_JavaUtilList.get(1);
          bool1 = bool2;
          localObject3 = str1;
          localObject4 = localObject1;
          if (localObject1 != null)
          {
            bool2 = TextUtils.isEmpty(((JoinTroopSecurityTipsItem.JoinTroopSecurityTipsBtn)localObject1).jdField_a_of_type_JavaLangString) ^ true;
            bool1 = bool2;
            localObject3 = str1;
            localObject4 = localObject1;
            if (!TextUtils.isEmpty(((JoinTroopSecurityTipsItem.JoinTroopSecurityTipsBtn)localObject1).b))
            {
              bool1 = bool2;
              localObject3 = str1;
              localObject4 = localObject1;
              if (!TextUtils.isEmpty(((JoinTroopSecurityTipsItem.JoinTroopSecurityTipsBtn)localObject1).c))
              {
                bool1 = bool2;
                localObject3 = str1;
                localObject4 = localObject1;
                if (((JoinTroopSecurityTipsItem.JoinTroopSecurityTipsBtn)localObject1).b.equals("web"))
                {
                  localObject3 = ((JoinTroopSecurityTipsItem.JoinTroopSecurityTipsBtn)localObject1).c;
                  localObject4 = localObject1;
                  bool1 = bool2;
                }
              }
            }
          }
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("JoinTroopSecurityTipsHelper showTips tId = ");
          ((StringBuilder)localObject1).append(paramInt);
          ((StringBuilder)localObject1).append(",time = ");
          ((StringBuilder)localObject1).append(paramLong);
          ((StringBuilder)localObject1).append(",isShowFrist");
          ((StringBuilder)localObject1).append(bool3);
          ((StringBuilder)localObject1).append(",isShowSecond");
          ((StringBuilder)localObject1).append(bool1);
          QLog.d("JoinTroopSecurityTipsHelper", 2, ((StringBuilder)localObject1).toString());
        }
        if ((bool3) && (bool1))
        {
          DialogUtil.a(paramContext, 230, str2, str3, localJoinTroopSecurityTipsBtn.jdField_a_of_type_JavaLangString, localObject4.jdField_a_of_type_JavaLangString, a(bool1, (String)localObject3, paramContext), a(bool3, (String)localObject2, paramContext)).show();
          ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800B340", "0X800B340", 0, 0, "", "", "", "");
          return;
        }
        if (bool3)
        {
          localObject1 = DialogUtil.a(paramContext, 230);
          if (localObject1 != null)
          {
            ((QQCustomDialog)localObject1).setTitle(str2);
            ((QQCustomDialog)localObject1).setMessage(str3);
            ((QQCustomDialog)localObject1).setNegativeButton(localJoinTroopSecurityTipsBtn.jdField_a_of_type_JavaLangString, a(bool3, (String)localObject2, paramContext));
            ((QQCustomDialog)localObject1).show();
            ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800B340", "0X800B340", 0, 0, "", "", "", "");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.jointroopsecuritytips.JoinTroopSecurityTipsHelper
 * JD-Core Version:    0.7.0.1
 */