package com.tencent.mobileqq.troop.widget;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ProfileGuideHelper
{
  private Dialog a;
  private QQAppInterface b;
  
  public void a()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      ((Dialog)localObject).dismiss();
      localObject = this.b;
      if (localObject != null) {
        ((QQAppInterface)localObject).getApp().getSharedPreferences(this.b.getCurrentAccountUin(), 0).edit().putBoolean("750_troo_game_guide", false).apply();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ProfileGuideHelper", 2, "750 game guide clicked");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.ProfileGuideHelper
 * JD-Core Version:    0.7.0.1
 */