package com.tencent.mobileqq.mini.utils;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

final class TroopApplicationListUtil$4
  implements Runnable
{
  TroopApplicationListUtil$4(int paramInt, String paramString) {}
  
  public void run()
  {
    QQToast.makeText(BaseApplicationImpl.getApplication(), this.val$iconType, this.val$desc, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.TroopApplicationListUtil.4
 * JD-Core Version:    0.7.0.1
 */