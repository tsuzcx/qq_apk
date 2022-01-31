package com.tencent.mobileqq.hotpic;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aqze;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;

public class HotPicManager$5
  implements Runnable
{
  public HotPicManager$5(aqze paramaqze, int paramInt) {}
  
  public void run()
  {
    this.this$0.a.getApplication().getSharedPreferences("sp_hotpic_" + this.this$0.a.c(), 0).edit().putInt("hot_pic_last_click", this.a).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicManager.5
 * JD-Core Version:    0.7.0.1
 */