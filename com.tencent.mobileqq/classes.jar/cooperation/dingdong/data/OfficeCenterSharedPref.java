package cooperation.dingdong.data;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.BaseApplication;

public class OfficeCenterSharedPref
{
  private static volatile OfficeCenterSharedPref jdField_a_of_type_CooperationDingdongDataOfficeCenterSharedPref;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences("OfficeCenterAppName", 4);
  
  public static OfficeCenterSharedPref a()
  {
    if (jdField_a_of_type_CooperationDingdongDataOfficeCenterSharedPref == null) {}
    try
    {
      if (jdField_a_of_type_CooperationDingdongDataOfficeCenterSharedPref == null) {
        jdField_a_of_type_CooperationDingdongDataOfficeCenterSharedPref = new OfficeCenterSharedPref();
      }
      return jdField_a_of_type_CooperationDingdongDataOfficeCenterSharedPref;
    }
    finally {}
  }
  
  public int a(String paramString, int paramInt)
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(paramString, paramInt);
  }
  
  public String a(String paramString1, String paramString2)
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString(paramString1, paramString2);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt(paramString, paramInt).commit();
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString(paramString1, paramString2).commit();
      return bool;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(paramString, paramBoolean);
  }
  
  public boolean b(String paramString, boolean paramBoolean)
  {
    try
    {
      paramBoolean = this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(paramString, paramBoolean).commit();
      return paramBoolean;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.dingdong.data.OfficeCenterSharedPref
 * JD-Core Version:    0.7.0.1
 */