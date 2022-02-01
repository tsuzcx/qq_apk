package com.tencent.mobileqq.hotpic;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;

class HotPicManager$5
  implements Runnable
{
  HotPicManager$5(HotPicManager paramHotPicManager, int paramInt) {}
  
  public void run()
  {
    MobileQQ localMobileQQ = this.this$0.a.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_hotpic_");
    localStringBuilder.append(this.this$0.a.getCurrentUin());
    localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).edit().putInt("hot_pic_last_click", this.a).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicManager.5
 * JD-Core Version:    0.7.0.1
 */