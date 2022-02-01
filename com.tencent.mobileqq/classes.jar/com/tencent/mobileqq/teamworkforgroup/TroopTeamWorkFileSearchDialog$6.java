package com.tencent.mobileqq.teamworkforgroup;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.rely.CountdownTimeTask;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

class TroopTeamWorkFileSearchDialog$6
  implements TextWatcher
{
  TroopTeamWorkFileSearchDialog$6(TroopTeamWorkFileSearchDialog paramTroopTeamWorkFileSearchDialog) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.a.d)
    {
      this.a.d = false;
      return;
    }
    if (paramEditable == null) {
      paramEditable = "";
    } else {
      paramEditable = paramEditable.toString();
    }
    if (paramEditable.trim().equals(""))
    {
      this.a.c();
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    if (!NetworkUtil.isNetworkAvailable(this.a.jdField_a_of_type_AndroidAppActivity))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqRelyCountdownTimeTask != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqRelyCountdownTimeTask.b();
        this.a.jdField_a_of_type_ComTencentMobileqqRelyCountdownTimeTask = null;
      }
      this.a.b();
      return;
    }
    paramEditable = this.a;
    paramEditable.c = false;
    if (paramEditable.jdField_a_of_type_ComTencentMobileqqRelyCountdownTimeTask == null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqRelyCountdownTimeTask = new CountdownTimeTask(new TroopTeamWorkFileSearchDialog.6.1(this), 800);
      ThreadManager.post(this.a.jdField_a_of_type_ComTencentMobileqqRelyCountdownTimeTask, 5, null, true);
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqRelyCountdownTimeTask.a() > 0L)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqRelyCountdownTimeTask.a();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("TroopTeamWorkFileSearchDialog", 2, "!!!!!! 这是个什么情况,逻辑出错了 !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.a.d) && ((!this.a.d) || (this.a.jdField_b_of_type_Int > 0)))
    {
      this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.TroopTeamWorkFileSearchDialog.6
 * JD-Core Version:    0.7.0.1
 */