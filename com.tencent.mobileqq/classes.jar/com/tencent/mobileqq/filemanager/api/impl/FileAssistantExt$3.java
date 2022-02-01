package com.tencent.mobileqq.filemanager.api.impl;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.widget.PopupMenuDialog;

class FileAssistantExt$3
  implements View.OnTouchListener
{
  FileAssistantExt$3(FileAssistantExt paramFileAssistantExt) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 4)
    {
      FileAssistantExt.a(this.a).dismiss();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.FileAssistantExt.3
 * JD-Core Version:    0.7.0.1
 */