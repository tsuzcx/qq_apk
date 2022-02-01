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
    b();
  }
  
  public static void a()
  {
    a += 1;
    ThreadManager.getFileThreadHandler().post(new ViewCommandModelCheck.2());
  }
  
  public static boolean a()
  {
    return a < 3;
  }
  
  private int b()
  {
    return AssistantUtils.a().getSharedPreferences("view_command_count_file", 0).getInt("view_command_count", 0);
  }
  
  private void b()
  {
    ThreadManager.getFileThreadHandler().post(new ViewCommandModelCheck.1(this));
  }
  
  private static void b(int paramInt)
  {
    AssistantUtils.a().getSharedPreferences("view_command_count_file", 0).edit().putInt("view_command_count", paramInt).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.core.ViewCommandModelCheck
 * JD-Core Version:    0.7.0.1
 */