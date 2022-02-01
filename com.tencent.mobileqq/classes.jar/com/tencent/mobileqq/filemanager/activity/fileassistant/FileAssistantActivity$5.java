package com.tencent.mobileqq.filemanager.activity.fileassistant;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.widget.PopupMenuDialog;

class FileAssistantActivity$5
  implements View.OnTouchListener
{
  FileAssistantActivity$5(FileAssistantActivity paramFileAssistantActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 4)
    {
      this.a.a.dismiss();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity.5
 * JD-Core Version:    0.7.0.1
 */