package com.tencent.mobileqq.database.corrupt;

import com.tencent.mobileqq.app.BaseActivity;

class DBFixManager$1$1
  implements Runnable
{
  DBFixManager$1$1(DBFixManager.1 param1) {}
  
  public void run()
  {
    if (BaseActivity.sTopActivity != null) {
      this.a.this$0.a(BaseActivity.sTopActivity, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixManager.1.1
 * JD-Core Version:    0.7.0.1
 */