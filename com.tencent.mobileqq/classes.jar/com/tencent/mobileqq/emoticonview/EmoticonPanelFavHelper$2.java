package com.tencent.mobileqq.emoticonview;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import apol;
import apon;
import apvd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class EmoticonPanelFavHelper$2
  implements Runnable
{
  public EmoticonPanelFavHelper$2(apvd paramapvd, QQAppInterface paramQQAppInterface, boolean paramBoolean, SharedPreferences paramSharedPreferences, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      apon localapon = (apon)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(149);
      List localList1 = localapon.a();
      if ((localList1 != null) && (localList1.size() > apol.a))
      {
        List localList2 = localList1.subList(0, localList1.size() - apol.a);
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonPanelFavHelper", 2, "delListOverflow=" + localList2.toString() + "emolist.size=" + localList1.size());
        }
        localapon.b(localList2);
        this.this$0.j();
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("local_overflow" + this.jdField_a_of_type_JavaLangString, true).apply();
      this.this$0.l();
      return;
    }
    this.this$0.l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelFavHelper.2
 * JD-Core Version:    0.7.0.1
 */