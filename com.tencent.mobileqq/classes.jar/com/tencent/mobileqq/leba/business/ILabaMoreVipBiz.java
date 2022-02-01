package com.tencent.mobileqq.leba.business;

import android.app.Activity;
import com.tencent.mobileqq.leba.entity.LebaMoreViewItem;
import java.util.List;
import mqq.app.AppRuntime;

public abstract class ILabaMoreVipBiz
{
  private Activity a;
  
  public Activity a()
  {
    return this.a;
  }
  
  public void a(int paramInt, boolean paramBoolean, List<LebaMoreViewItem> paramList1, List<LebaMoreViewItem> paramList2) {}
  
  public void a(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  public void a(AppRuntime paramAppRuntime, boolean paramBoolean, LebaMoreViewItem paramLebaMoreViewItem) {}
  
  public boolean a(LebaMoreViewItem paramLebaMoreViewItem)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.ILabaMoreVipBiz
 * JD-Core Version:    0.7.0.1
 */