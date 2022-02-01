package com.tencent.mobileqq.ocr;

import android.text.TextUtils;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.ocr.ui.OCRTextSearchActivity;
import com.tencent.mobileqq.widget.QQToast;

class OCRResultFragmentNew$3
  implements ActionMode.Callback
{
  OCRResultFragmentNew$3(OCRResultFragmentNew paramOCRResultFragmentNew, EditText paramEditText) {}
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131439519)
    {
      paramActionMode = OCRPerformUtil.a(this.a);
      if (TextUtils.isEmpty(paramActionMode))
      {
        QQToast.makeText(OCRResultFragmentNew.a(this.b), 1, HardCodeUtil.a(2131905635), 0).show();
        return false;
      }
      OCRTextSearchActivity.a(OCRResultFragmentNew.a(this.b), paramActionMode);
      OCRResultFragmentNew.a(this.b).overridePendingTransition(2130772009, 0);
      return true;
    }
    return false;
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    paramActionMode = paramActionMode.getMenuInflater();
    if (paramActionMode != null) {
      paramActionMode.inflate(2131689475, paramMenu);
    }
    return true;
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode) {}
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRResultFragmentNew.3
 * JD-Core Version:    0.7.0.1
 */