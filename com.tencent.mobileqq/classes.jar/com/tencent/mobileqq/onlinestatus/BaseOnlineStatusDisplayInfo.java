package com.tencent.mobileqq.onlinestatus;

import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;
import mqq.app.AppRuntime;

public abstract class BaseOnlineStatusDisplayInfo
{
  public long a;
  protected QBaseActivity a;
  protected BaseOnlineStatusDisplayInfo.UpdateUIListener a;
  public String a;
  protected AppRuntime a;
  public boolean a;
  public String b;
  protected boolean b = true;
  public String c;
  public String d = "";
  
  public BaseOnlineStatusDisplayInfo(long paramLong, BaseOnlineStatusDisplayInfo.UpdateUIListener paramUpdateUIListener, AppRuntime paramAppRuntime, QBaseActivity paramQBaseActivity)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBaseOnlineStatusDisplayInfo$UpdateUIListener = paramUpdateUIListener;
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
  }
  
  protected abstract void a();
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public abstract void a(boolean paramBoolean);
  
  public void a(boolean paramBoolean, long paramLong)
  {
    this.b = paramBoolean;
  }
  
  public abstract void a(boolean paramBoolean, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem);
  
  public boolean a()
  {
    return true;
  }
  
  public abstract void b();
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.BaseOnlineStatusDisplayInfo
 * JD-Core Version:    0.7.0.1
 */