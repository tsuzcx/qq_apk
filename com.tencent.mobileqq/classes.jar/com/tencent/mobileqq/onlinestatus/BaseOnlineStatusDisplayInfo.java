package com.tencent.mobileqq.onlinestatus;

import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class BaseOnlineStatusDisplayInfo
{
  public long a;
  public BaseActivity a;
  public QQAppInterface a;
  public BaseOnlineStatusDisplayInfo.UpdateUIListener a;
  public String a;
  public boolean a;
  public String b;
  public boolean b = true;
  public String c;
  public String d = "";
  
  public BaseOnlineStatusDisplayInfo(long paramLong, BaseOnlineStatusDisplayInfo.UpdateUIListener paramUpdateUIListener, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusBaseOnlineStatusDisplayInfo$UpdateUIListener = paramUpdateUIListener;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
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
  
  protected void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.BaseOnlineStatusDisplayInfo
 * JD-Core Version:    0.7.0.1
 */