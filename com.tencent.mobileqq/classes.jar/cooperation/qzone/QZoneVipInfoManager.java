package cooperation.qzone;

import NS_MOBILE_COMM.combine_diamond_info;
import NS_MOBILE_COMM.star_info;
import amcj;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;

public class QZoneVipInfoManager
{
  private static QZoneVipInfoManager jdField_a_of_type_CooperationQzoneQZoneVipInfoManager;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private int jdField_a_of_type_Int = -1;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  
  private QZoneVipInfoManager()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (Build.VERSION.SDK_INT >= 11) {}
    for (int i = 4;; i = 0)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences = localBaseApplicationImpl.getSharedPreferences("QZONE_VIP_INFO", i);
      if (this.jdField_a_of_type_AndroidContentSharedPreferences != null) {
        this.jdField_a_of_type_AndroidContentSharedPreferences.registerOnSharedPreferenceChangeListener(new amcj(this));
      }
      return;
    }
  }
  
  public static int a(int paramInt)
  {
    return a(paramInt, 0, 1);
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 2) {
        i = a(paramInt1, paramInt2, 0, 1);
      }
    }
    return i;
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    switch (paramInt3 - paramInt2 + 1)
    {
    default: 
      paramInt3 = 0;
    }
    while (paramInt3 == 0)
    {
      return 0;
      paramInt3 = 1;
      continue;
      paramInt3 = 3;
      continue;
      paramInt3 = 7;
      continue;
      paramInt3 = 15;
    }
    return paramInt1 >> paramInt2 & paramInt3;
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return -1 << paramInt4 + 1 & paramInt1 | paramInt2 << paramInt3 | (1 << paramInt3) - 1 & paramInt1;
  }
  
  public static int a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return a(paramInt, i, 6, 6);
    }
  }
  
  public static QZoneVipInfoManager a()
  {
    if (jdField_a_of_type_CooperationQzoneQZoneVipInfoManager == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_CooperationQzoneQZoneVipInfoManager == null) {
        jdField_a_of_type_CooperationQzoneQZoneVipInfoManager = new QZoneVipInfoManager();
      }
      return jdField_a_of_type_CooperationQzoneQZoneVipInfoManager;
    }
  }
  
  private String a(String paramString)
  {
    return "key_vip_info_bitmap_pre" + paramString;
  }
  
  private void a()
  {
    a(false);
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Int >= 0) && (!paramBoolean)) {}
    while (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      return;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(a(localAppRuntime.getAccount()), 0);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(b(localAppRuntime.getAccount()), null);
  }
  
  public static boolean a(int paramInt)
  {
    return a(paramInt, 6, 6) != 0;
  }
  
  public static int b(int paramInt)
  {
    return a(paramInt, 2, 5);
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 9) {
        i = a(paramInt1, paramInt2, 2, 5);
      }
    }
    return i;
  }
  
  public static int b(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return a(paramInt, i, 13, 13);
    }
  }
  
  private String b(String paramString)
  {
    return "key_vip_info_personalized_vip_pre" + paramString;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences != null)
    {
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      if (localEditor != null)
      {
        this.jdField_a_of_type_Boolean = true;
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        localEditor.putInt(a(localAppRuntime.getAccount()), this.jdField_a_of_type_Int);
        localEditor.putString(b(localAppRuntime.getAccount()), this.jdField_a_of_type_JavaLangString);
        localEditor.commit();
      }
    }
  }
  
  public static boolean b(int paramInt)
  {
    return a(paramInt, 13, 13) != 0;
  }
  
  public static int c(int paramInt)
  {
    return a(paramInt, 7, 8);
  }
  
  public static int c(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 2) {
        i = a(paramInt1, paramInt2, 7, 8);
      }
    }
    return i;
  }
  
  public static int c(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return a(paramInt, i, 21, 21);
    }
  }
  
  public static boolean c(int paramInt)
  {
    return a(paramInt, 21, 21) != 0;
  }
  
  public static int d(int paramInt)
  {
    return a(paramInt, 9, 12);
  }
  
  public static int d(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 8) {
        i = a(paramInt1, paramInt2, 9, 12);
      }
    }
    return i;
  }
  
  public static int d(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return a(paramInt, i, 22, 22);
    }
  }
  
  public static boolean d(int paramInt)
  {
    return a(paramInt, 22, 22) != 0;
  }
  
  public static int e(int paramInt)
  {
    return a(paramInt, 14, 16);
  }
  
  public static int e(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 6) {
        i = a(paramInt1, paramInt2, 14, 16);
      }
    }
    return i;
  }
  
  public static int e(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0) {
      return a(paramInt, i, 23, 23);
    }
  }
  
  public static boolean e(int paramInt)
  {
    return a(paramInt, 23, 23) != 0;
  }
  
  public static int f(int paramInt)
  {
    return a(paramInt, 17, 20);
  }
  
  public static int f(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 >= 0)
    {
      i = paramInt1;
      if (paramInt2 <= 9) {
        i = a(paramInt1, paramInt2, 17, 20);
      }
    }
    return i;
  }
  
  public int a()
  {
    a();
    return a(this.jdField_a_of_type_Int);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, star_info paramstar_info, combine_diamond_info paramcombine_diamond_info)
  {
    boolean bool2 = true;
    a(true);
    this.jdField_a_of_type_Int = a(this.jdField_a_of_type_Int, paramInt1);
    this.jdField_a_of_type_Int = b(this.jdField_a_of_type_Int, paramInt2);
    paramInt1 = this.jdField_a_of_type_Int;
    if (paramInt3 != 0)
    {
      bool1 = true;
      this.jdField_a_of_type_Int = a(paramInt1, bool1);
      if (paramstar_info != null)
      {
        this.jdField_a_of_type_Int = c(this.jdField_a_of_type_Int, paramstar_info.iStarStatus);
        this.jdField_a_of_type_Int = d(this.jdField_a_of_type_Int, paramstar_info.iStarLevel);
        paramInt1 = this.jdField_a_of_type_Int;
        if (paramstar_info.isAnnualVip == 0) {
          break label302;
        }
        bool1 = true;
        label107:
        this.jdField_a_of_type_Int = b(paramInt1, bool1);
        paramInt1 = this.jdField_a_of_type_Int;
        if (paramstar_info.isHighStarVip == 0) {
          break label308;
        }
        bool1 = true;
        label133:
        this.jdField_a_of_type_Int = e(paramInt1, bool1);
      }
      if (paramcombine_diamond_info != null)
      {
        this.jdField_a_of_type_Int = e(this.jdField_a_of_type_Int, paramcombine_diamond_info.iShowType);
        this.jdField_a_of_type_Int = f(this.jdField_a_of_type_Int, paramcombine_diamond_info.iVipLevel);
        paramInt1 = this.jdField_a_of_type_Int;
        if (paramcombine_diamond_info.isAnnualVip == 0) {
          break label314;
        }
        bool1 = true;
        label196:
        this.jdField_a_of_type_Int = c(paramInt1, bool1);
        paramInt1 = this.jdField_a_of_type_Int;
        if (paramcombine_diamond_info.isAnnualVipEver == 0) {
          break label320;
        }
      }
    }
    label302:
    label308:
    label314:
    label320:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_Int = d(paramInt1, bool1);
      paramstar_info = new Intent("com.tencent.qq.syncQzoneVipInfoAction");
      paramcombine_diamond_info = new Bundle();
      paramcombine_diamond_info.putInt("com.tencent.qq.syncQzoneVipInfoStr", this.jdField_a_of_type_Int);
      paramcombine_diamond_info.putString("com.tencent.qq.syncQzoneVipInfoPersonalized", this.jdField_a_of_type_JavaLangString);
      paramstar_info.putExtras(paramcombine_diamond_info);
      BaseApplicationImpl.getContext().sendBroadcast(paramstar_info);
      b();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label107;
      bool1 = false;
      break label133;
      bool1 = false;
      break label196;
    }
  }
  
  public boolean a()
  {
    a();
    return a(this.jdField_a_of_type_Int);
  }
  
  public int b()
  {
    a();
    return b(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.QZoneVipInfoManager
 * JD-Core Version:    0.7.0.1
 */