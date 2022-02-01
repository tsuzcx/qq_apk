package com.tencent.mobileqq.qassistant.core;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.os.MqqHandler;

public class ViewCommandModelCheck
{
  private static int a;
  
  public ViewCommandModelCheck()
  {
    d();
  }
  
  public static boolean a()
  {
    return a < 3;
  }
  
  public static void b()
  {
    a += 1;
    ThreadManager.getFileThreadHandler().post(new ViewCommandModelCheck.2());
  }
  
  private static void c(int paramInt)
  {
    AssistantUtils.d().getSharedPreferences("view_command_count_file", 0).edit().putInt("view_command_count", paramInt).apply();
  }
  
  private void d()
  {
    ThreadManager.getFileThreadHandler().post(new ViewCommandModelCheck.1(this));
  }
  
  private int e()
  {
    return AssistantUtils.d().getSharedPreferences("view_command_count_file", 0).getInt("view_command_count", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.ViewCommandModelCheck
 * JD-Core Version:    0.7.0.1
 */