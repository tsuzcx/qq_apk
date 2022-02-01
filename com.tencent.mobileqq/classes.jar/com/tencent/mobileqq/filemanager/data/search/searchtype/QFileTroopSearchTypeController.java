package com.tencent.mobileqq.filemanager.data.search.searchtype;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop.TroopFileProxyActivity;

public class QFileTroopSearchTypeController
  implements IQFileSearchTypeController
{
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public QFileTroopSearchTypeController(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Long = Long.parseLong(paramString);
  }
  
  private void a()
  {
    Intent localIntent = TroopMemberListActivity.a(this.jdField_a_of_type_AndroidContentContext, String.valueOf(this.jdField_a_of_type_Long), 18);
    localIntent.putExtra("uin", this.jdField_a_of_type_Long);
    localIntent.putExtra("param_from", 23);
    localIntent.putExtra("uintype", 1);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  private void b(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("title_type", paramInt);
    localIntent.putExtra("troop_uin", this.jdField_a_of_type_Long);
    TroopFileProxyActivity.c((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    default: 
      QLog.i("QFileTroopSearchTypeController", 4, "unknown search type.");
      return;
    case 3: 
      b(1);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0C0", "0X800A0C0", 1, 0, "", "", "", "");
      return;
    case 2: 
      b(2);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0C0", "0X800A0C0", 2, 0, "", "", "", "");
      return;
    case 0: 
      b(4);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0C0", "0X800A0C0", 3, 0, "", "", "", "");
      return;
    case 1: 
      b(3);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0C0", "0X800A0C0", 4, 0, "", "", "", "");
      return;
    case 11: 
      b(10000);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A0C0", "0X800A0C0", 5, 0, "", "", "", "");
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.searchtype.QFileTroopSearchTypeController
 * JD-Core Version:    0.7.0.1
 */