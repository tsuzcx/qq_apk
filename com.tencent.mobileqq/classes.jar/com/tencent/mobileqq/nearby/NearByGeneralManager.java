package com.tencent.mobileqq.nearby;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.manager.Manager;

public class NearByGeneralManager
  implements INearByGeneralManager, Manager
{
  QQAppInterface a;
  SharedPreferences b;
  boolean c = true;
  boolean d = true;
  
  public NearByGeneralManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.b = BaseApplicationImpl.getContext().getSharedPreferences("NearbyGeneralConfig", 0);
    paramQQAppInterface = this.b;
    if (paramQQAppInterface != null)
    {
      this.c = paramQQAppInterface.getBoolean("Notify_on_like", true);
      this.d = this.b.getBoolean("key_allow_nearby_like", true);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    SharedPreferences localSharedPreferences = this.b;
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("Notify_on_like", paramBoolean).commit();
    }
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.d != paramBoolean)
    {
      SharedPreferences localSharedPreferences = this.b;
      if (localSharedPreferences != null)
      {
        this.d = paramBoolean;
        localSharedPreferences.edit().putBoolean("key_allow_nearby_like", paramBoolean).commit();
      }
    }
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearByGeneralManager
 * JD-Core Version:    0.7.0.1
 */