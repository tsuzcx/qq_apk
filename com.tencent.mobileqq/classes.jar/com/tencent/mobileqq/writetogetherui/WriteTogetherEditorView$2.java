package com.tencent.mobileqq.writetogetherui;

import android.os.Build.VERSION;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.writetogether.client.IEditorController;

class WriteTogetherEditorView$2
  implements ActionMode.Callback
{
  WriteTogetherEditorView$2(WriteTogetherEditorView paramWriteTogetherEditorView) {}
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    if (!WriteTogetherEditorView.c(this.a)) {
      return false;
    }
    if (paramMenuItem.getItemId() == 1)
    {
      WriteTogetherEditorView.d(this.a).a(this.a.getText().toString(), this.a.getSelectionStart(), this.a.getSelectionEnd());
      paramActionMode.finish();
      ReportController.b(null, "dc00898", "", "", "0X800AF34", "0X800AF34", 5, 0, "", "", "", "");
      return true;
    }
    return false;
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    if (!WriteTogetherEditorView.c(this.a)) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      paramMenu.removeItem(16908341);
    }
    if (WriteTogetherEditorView.d(this.a).b()) {
      paramMenu.add(0, 1, 196608, "举报");
    }
    return true;
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode) {}
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.WriteTogetherEditorView.2
 * JD-Core Version:    0.7.0.1
 */