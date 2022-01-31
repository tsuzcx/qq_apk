package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;

final class EmoticonMainPanel$6
  implements Runnable
{
  EmoticonMainPanel$6(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    VasQuickUpdateManager.getJSONFromLocal(this.a, "watch_focus.json", true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonMainPanel.6
 * JD-Core Version:    0.7.0.1
 */