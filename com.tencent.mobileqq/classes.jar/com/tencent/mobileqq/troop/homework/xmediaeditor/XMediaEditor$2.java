package com.tencent.mobileqq.troop.homework.xmediaeditor;

import android.widget.EditText;
import bacg;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class XMediaEditor$2
  implements Runnable
{
  XMediaEditor$2(XMediaEditor paramXMediaEditor, bacg parambacg) {}
  
  public void run()
  {
    this.a.a.clearFocus();
    ThreadManager.getUIHandler().post(new XMediaEditor.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor.2
 * JD-Core Version:    0.7.0.1
 */