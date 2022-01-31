package com.tencent.mobileqq.emoticonview;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import ansu;
import answ;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class EmoticonMainPanel$25
  implements Runnable
{
  EmoticonMainPanel$25(EmoticonMainPanel paramEmoticonMainPanel, boolean paramBoolean, SharedPreferences paramSharedPreferences, String paramString) {}
  
  public void run()
  {
    if (this.this$0.a == null) {
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      answ localansw = (answ)this.this$0.a.getManager(149);
      List localList1 = localansw.a();
      if ((localList1 != null) && (localList1.size() > ansu.a))
      {
        List localList2 = localList1.subList(0, localList1.size() - ansu.a);
        if (QLog.isColorLevel()) {
          QLog.d("EmoticonMainPanel", 2, "delListOverflow=" + localList2.toString() + "emolist.size=" + localList1.size());
        }
        localansw.b(localList2);
        this.this$0.p();
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("local_overflow" + this.jdField_a_of_type_JavaLangString, true).apply();
      this.this$0.m();
      return;
    }
    this.this$0.m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonMainPanel.25
 * JD-Core Version:    0.7.0.1
 */