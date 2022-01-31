package com.tencent.mobileqq.teamworkforgroup;

import android.view.View;
import balm;
import com.tencent.qphone.base.util.QLog;

public class TroopTeamWorkFileSearchDialog$11
  implements Runnable
{
  public TroopTeamWorkFileSearchDialog$11(balm parambalm, View paramView, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setDrawingCacheEnabled(this.jdField_a_of_type_Boolean);
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("mBlurBackground == null :");
      if (balm.a(this.this$0) != null) {
        break label64;
      }
    }
    label64:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("TroopTeamWorkFileSearchDialog", 2, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.TroopTeamWorkFileSearchDialog.11
 * JD-Core Version:    0.7.0.1
 */