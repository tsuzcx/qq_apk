package com.tencent.mobileqq.search;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.search.UinSearchConfProcessor.UinSearchConfigBean;
import com.tencent.mobileqq.search.model.GroupBaseNetSearchModelItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

class UinSearcher$1$3
  implements Runnable
{
  UinSearcher$1$3(UinSearcher.1 param1, ActionSheet paramActionSheet, GroupBaseNetSearchModelItem[] paramArrayOfGroupBaseNetSearchModelItem1, GroupBaseNetSearchModelItem[] paramArrayOfGroupBaseNetSearchModelItem2, UinSearchConfProcessor.UinSearchConfigBean paramUinSearchConfigBean, QQAppInterface paramQQAppInterface, GroupBaseNetSearchModelItem[] paramArrayOfGroupBaseNetSearchModelItem3) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    String str1;
    String str2;
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchModelGroupBaseNetSearchModelItem[0] == null) {
      if (this.b[0] == null)
      {
        str1 = "0X800A923";
        if ((this.jdField_a_of_type_ArrayOfComTencentMobileqqSearchModelGroupBaseNetSearchModelItem[0] != null) || (this.b[0] != null)) {
          break label286;
        }
        str2 = "";
        label49:
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", str1, str1, UinSearcher.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, UinSearcher.a(this.jdField_a_of_type_ComTencentMobileqqSearchUinSearcher$1.a), UinSearcher.d(this.jdField_a_of_type_ComTencentMobileqqSearchUinSearcher$1.a)), 0, str2, "", "", "");
        if ((this.c[0] == null) || (TextUtils.isEmpty(this.c[0].n))) {
          break label352;
        }
        if (!this.c[0].m.equals("#808080")) {
          break label346;
        }
        str1 = "0X800B0BD";
        label143:
        if (!str1.equals("0X800B0BD")) {
          break label358;
        }
        str2 = this.c[0].k;
        label162:
        if (!str2.equals("")) {
          break label364;
        }
      }
    }
    label286:
    label346:
    label352:
    label358:
    label364:
    for (String str3 = "";; str3 = this.c[0].l)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UinSearcher", 2, "baoguang TValue r4 r5: " + str1 + ", " + str2 + ", " + str3);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", str1, str1, UinSearcher.a(UinSearcher.a(this.jdField_a_of_type_ComTencentMobileqqSearchUinSearcher$1.a)), 0, "", "", str2, str3);
      return;
      str1 = "0X800A921";
      break;
      if (this.b[0] == null)
      {
        str1 = "0X800A920";
        break;
      }
      str1 = "0X800A922";
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqConfigBusinessSearchUinSearchConfProcessor$UinSearchConfigBean.a())
      {
        str2 = UinSearchConfProcessor.UinSearchConfigBean.a + "";
        break label49;
      }
      str2 = UinSearchConfProcessor.UinSearchConfigBean.b + "";
      break label49;
      str1 = "0X800B0BE";
      break label143;
      str1 = "0X800B0BF";
      break label143;
      str2 = "";
      break label162;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.UinSearcher.1.3
 * JD-Core Version:    0.7.0.1
 */