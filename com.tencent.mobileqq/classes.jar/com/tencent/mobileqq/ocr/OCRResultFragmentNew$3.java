package com.tencent.mobileqq.ocr;

import android.text.TextUtils;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.ocr.ui.OCRTextSearchActivity;
import com.tencent.mobileqq.widget.QQToast;

class OCRResultFragmentNew$3
  implements ActionMode.Callback
{
  OCRResultFragmentNew$3(OCRResultFragmentNew paramOCRResultFragmentNew, EditText paramEditText) {}
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131372474)
    {
      paramActionMode = OCRPerformUtil.a(this.jdField_a_of_type_AndroidWidgetEditText);
      if (TextUtils.isEmpty(paramActionMode)) {
        QQToast.a(OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew), 1, HardCodeUtil.a(2131707797), 0).a();
      }
    }
    else
    {
      return false;
    }
    OCRTextSearchActivity.a(OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew), paramActionMode);
    OCRResultFragmentNew.a(this.jdField_a_of_type_ComTencentMobileqqOcrOCRResultFragmentNew).overridePendingTransition(2130771994, 0);
    return true;
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    paramActionMode = paramActionMode.getMenuInflater();
    if (paramActionMode != null) {
      paramActionMode.inflate(2131623939, paramMenu);
    }
    return true;
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode) {}
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew.3
 * JD-Core Version:    0.7.0.1
 */