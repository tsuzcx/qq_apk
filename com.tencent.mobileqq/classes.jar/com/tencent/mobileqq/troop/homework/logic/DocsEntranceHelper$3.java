package com.tencent.mobileqq.troop.homework.logic;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.qphone.base.util.QLog;

class DocsEntranceHelper$3
  implements Runnable
{
  DocsEntranceHelper$3(DocsEntranceHelper paramDocsEntranceHelper, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.this$0.a.getActivity());
    int i = ((SharedPreferences)localObject).getInt(DocsEntranceHelper.a(this.this$0), 0);
    if (QLog.isColorLevel()) {
      QLog.d("DocsEntranceHelper", 2, String.format("onShow guide count: %s", new Object[] { Integer.valueOf(i) }));
    }
    localObject = ((SharedPreferences)localObject).edit();
    if (this.jdField_a_of_type_Boolean) {
      ((SharedPreferences.Editor)localObject).putInt(DocsEntranceHelper.a(this.this$0), i + this.jdField_a_of_type_Int).commit();
    }
    for (;;)
    {
      ((SharedPreferences.Editor)localObject).apply();
      return;
      ((SharedPreferences.Editor)localObject).putInt(DocsEntranceHelper.a(this.this$0), this.jdField_a_of_type_Int).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.logic.DocsEntranceHelper.3
 * JD-Core Version:    0.7.0.1
 */