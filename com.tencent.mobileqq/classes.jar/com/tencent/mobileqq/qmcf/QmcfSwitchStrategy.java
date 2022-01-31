package com.tencent.mobileqq.qmcf;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.shortvideo.util.SoLoader;
import com.tencent.sveffects.DpcSwitcher;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import org.json.JSONObject;

public class QmcfSwitchStrategy
{
  private int jdField_a_of_type_Int = -1;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean = true;
  private int c = 0;
  private int d = -1;
  private int e = -1;
  private int f = 0;
  private int g = -1;
  private int h = -1;
  
  public int a()
  {
    if (this.h > -1) {
      return this.h;
    }
    if (Build.VERSION.SDK_INT < 21) {
      this.h = 1;
    }
    for (;;)
    {
      return this.h;
      if (this.jdField_b_of_type_Int == 0) {
        this.h = 2;
      } else if (this.jdField_a_of_type_Int == 0) {
        this.h = 3;
      } else if (this.g >= this.e) {
        this.h = 5;
      } else if (!this.jdField_b_of_type_Boolean) {
        this.h = 6;
      } else if (!SoLoader.b()) {
        this.h = 7;
      } else {
        this.h = 0;
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      int i = paramJSONObject.optInt("svaf_switch", 1);
      int j = paramJSONObject.optInt("svaf_maxCount", -1);
      paramJSONObject = SdkContext.a().a().getSharedPreferences("QmcfConfig", 0).edit();
      paramJSONObject.putInt("qmcf_main_switch", i);
      if (j != -1)
      {
        this.e = j;
        paramJSONObject.putInt("qmcf_exception_max_count", j);
      }
      paramJSONObject.commit();
      if (SLog.a()) {
        SLog.d("QmcfSwitchStrategy", String.format("updateMainSwitch, mainSwitch[%s], maxCount[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2)
    {
      if (!paramBoolean1)
      {
        int i = this.c + 1;
        this.c = i;
        if (i <= 5) {}
      }
    }
    else
    {
      if (!paramBoolean1) {
        break label120;
      }
      this.d = 0;
    }
    for (;;)
    {
      SharedPreferences.Editor localEditor = SdkContext.a().a().getSharedPreferences("QmcfConfig", 0).edit();
      localEditor.putInt("qmcf_exception_curr_count_art", this.d);
      localEditor.commit();
      if (SLog.a()) {
        SLog.d("QmcfSwitchStrategy", String.format("ArtMode: isSuccess[%s], forceUpdate[%s], currCount[%s]", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(this.d) }));
      }
      return;
      label120:
      this.d += 1;
      this.c = 0;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a(paramBoolean1, paramBoolean2);
      return;
    }
    b(paramBoolean1, paramBoolean2);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = SdkContext.a().a().getSharedPreferences("QmcfConfig", 0).getInt("qmcf_main_switch", 1);
    }
    if (this.jdField_b_of_type_Int == -1) {
      if (SdkContext.a().a() != null) {}
    }
    do
    {
      return true;
      this.jdField_b_of_type_Int = SdkContext.a().a().getSharedPreferences("QmcfConfig", 0).getInt("qmcf_mobile_support", 1);
      this.jdField_a_of_type_Boolean = SdkContext.a().a().b();
      if ((this.d == -1) || (this.e == -1))
      {
        SharedPreferences localSharedPreferences = SdkContext.a().a().getSharedPreferences("QmcfConfig", 0);
        this.d = localSharedPreferences.getInt("qmcf_exception_curr_count_art", 0);
        this.e = localSharedPreferences.getInt("qmcf_exception_max_count", 2);
      }
      if (SLog.a()) {
        SLog.d("QmcfSwitchStrategy", String.format("ArtMode: MainSwitch[%s], MobileSupport[%s], DPCSwitch[%s], currCount[%s], maxCount[%s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Boolean.valueOf(this.jdField_a_of_type_Boolean), Integer.valueOf(this.d), Integer.valueOf(this.e) }));
      }
    } while ((this.jdField_a_of_type_Int == 1) && (this.jdField_b_of_type_Int == 1) && (this.jdField_a_of_type_Boolean) && (this.d < this.e));
    return false;
  }
  
  public boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      SLog.d("QmcfSwitchStrategy", "unknown mode:" + paramInt);
      return false;
    case 1: 
      return a();
    }
    return b();
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.jdField_b_of_type_Int = i;
      SharedPreferences.Editor localEditor = SdkContext.a().a().getSharedPreferences("QmcfConfig", 0).edit();
      localEditor.putInt("qmcf_mobile_support", this.jdField_b_of_type_Int);
      localEditor.commit();
      if (SLog.a()) {
        SLog.d("QmcfSwitchStrategy", "setMobileSupport :" + this.jdField_b_of_type_Int);
      }
      return;
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2)
    {
      if (!paramBoolean1)
      {
        int i = this.f + 1;
        this.f = i;
        if (i <= 5) {}
      }
    }
    else
    {
      if (!paramBoolean1) {
        break label120;
      }
      this.g = 0;
    }
    for (;;)
    {
      SharedPreferences.Editor localEditor = SdkContext.a().a().getSharedPreferences("QmcfConfig", 0).edit();
      localEditor.putInt("qmcf_exception_curr_count_dance", this.g);
      localEditor.commit();
      if (SLog.a()) {
        SLog.d("QmcfSwitchStrategy", String.format("DanceMode: isSuccess[%s], forceUpdate[%s], currCount[%s]", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(this.g) }));
      }
      return;
      label120:
      this.g += 1;
      this.f = 0;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Int == -1) {
      this.jdField_a_of_type_Int = SdkContext.a().a().getSharedPreferences("QmcfConfig", 0).getInt("qmcf_main_switch", 1);
    }
    if (this.jdField_b_of_type_Int == -1) {
      if (SdkContext.a().a() != null) {}
    }
    do
    {
      return true;
      this.jdField_b_of_type_Int = SdkContext.a().a().getSharedPreferences("QmcfConfig", 0).getInt("qmcf_mobile_support", 1);
      if ((this.g == -1) || (this.e == -1))
      {
        SharedPreferences localSharedPreferences = SdkContext.a().a().getSharedPreferences("QmcfConfig", 0);
        this.g = localSharedPreferences.getInt("qmcf_exception_curr_count_dance", 0);
        this.e = localSharedPreferences.getInt("qmcf_exception_max_count", 2);
      }
      if (SLog.a()) {
        SLog.d("QmcfSwitchStrategy", String.format("DanceMode: MainSwitch[%s], MobileSupport[%s], currCount[%s], maxCount[%s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.g), Integer.valueOf(this.e) }));
      }
    } while ((this.jdField_a_of_type_Int == 1) && (this.jdField_b_of_type_Int == 1) && (this.g < this.e));
    return false;
  }
  
  public boolean c()
  {
    if (this.jdField_b_of_type_Int == -1) {
      if (SdkContext.a().a() != null) {}
    }
    while (this.jdField_b_of_type_Int == 1)
    {
      return true;
      this.jdField_b_of_type_Int = SdkContext.a().a().getSharedPreferences("QmcfConfig", 0).getInt("qmcf_mobile_support", 1);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.qmcf.QmcfSwitchStrategy
 * JD-Core Version:    0.7.0.1
 */