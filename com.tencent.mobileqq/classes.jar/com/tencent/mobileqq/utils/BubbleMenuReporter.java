package com.tencent.mobileqq.utils;

import android.content.res.Resources;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout.IMenuCreateOrClickCallback;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.Map;
import mqq.app.MobileQQ;

public class BubbleMenuReporter
  implements QQCustomMenuNoIconLayout.IMenuCreateOrClickCallback
{
  private static Map<String, Integer> jdField_a_of_type_JavaUtilMap = new BubbleMenuReporter.1();
  private static int b = 100;
  int jdField_a_of_type_Int = -1;
  
  private void a()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (((localBaseActivity instanceof BaseActivity)) && (localBaseActivity.getChatFragment() != null)) {
      i = localBaseActivity.getChatFragment().a().a.jdField_a_of_type_Int;
    } else {
      i = -1;
    }
    int i = Integer.parseInt(ChatActivityUtils.b(i));
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 3)
        {
          this.jdField_a_of_type_Int = 4;
          return;
        }
        this.jdField_a_of_type_Int = 2;
        return;
      }
      this.jdField_a_of_type_Int = 3;
      return;
    }
    this.jdField_a_of_type_Int = 1;
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_Int < 0) {
      a();
    }
    ReportController.b(null, "dc00898", "", "", paramString, paramString, this.jdField_a_of_type_Int, 0, "", "", "", "");
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Int < 0) {
      a();
    }
    Integer localInteger2 = (Integer)jdField_a_of_type_JavaUtilMap.get(paramString2);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(b);
    }
    ReportController.b(null, "dc00898", "", "", paramString1, paramString1, localInteger1.intValue(), 0, String.valueOf(this.jdField_a_of_type_Int), "", "", "");
    if ((paramString2 != null) && (paramString2.equals(MobileQQ.getContext().getResources().getString(2131699668))))
    {
      paramString2 = MobileReportManager.getInstance();
      int i;
      if (paramString1.equals("0X800B3BE")) {
        i = 101;
      } else {
        i = 102;
      }
      paramString2.reportAction("similar_emoji", "4", "platform898", "6", "2", i, 1, System.currentTimeMillis());
    }
  }
  
  public void a(QQCustomMenuItem paramQQCustomMenuItem)
  {
    a("0X800B3BF", paramQQCustomMenuItem.a());
  }
  
  public void a(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "0X800B3C0";
    } else {
      str = "0X800B3C2";
    }
    a(str);
  }
  
  public void b(QQCustomMenuItem paramQQCustomMenuItem)
  {
    a("0X800B3BE", paramQQCustomMenuItem.a());
  }
  
  public void b(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "0X800B3C1";
    } else {
      str = "0X800B3C3";
    }
    a(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.BubbleMenuReporter
 * JD-Core Version:    0.7.0.1
 */