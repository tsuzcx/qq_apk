package com.tencent.mobileqq.troop.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class TroopBarPublishUtils$UserInvokeAction
{
  SharedPreferences.Editor a;
  private String b;
  private SharedPreferences c;
  
  public void a()
  {
    this.a = this.c.edit();
    this.a.putBoolean(this.b, true);
    this.a.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishUtils.UserInvokeAction
 * JD-Core Version:    0.7.0.1
 */