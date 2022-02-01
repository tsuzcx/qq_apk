package com.tencent.mobileqq.servlet;

import android.text.TextUtils;
import com.tencent.biz.common.config.CommonConfigBase;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class QZoneManagerImp$QZoneGroupEntranceConfig
  extends CommonConfigBase
{
  public ArrayList<Long> a;
  public boolean a;
  
  public String a()
  {
    return "key_for_qzone_group_entrance_cfg";
  }
  
  public void a(String paramString)
  {
    int i = 0;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      JSONArray localJSONArray = paramString.optJSONArray("troop_types");
      if (localJSONArray != null) {
        while (i < localJSONArray.length())
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(localJSONArray.optLong(i)));
          i += 1;
        }
      }
      this.jdField_a_of_type_Boolean = paramString.optBoolean("is_show_reddot", false);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("CommonConfigBase", 1, "QZoneGroupEntranceConfig initConfig failed!", paramString);
    }
  }
  
  public String b()
  {
    return "key_for_qzone_group_entrance_cfg_version";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneManagerImp.QZoneGroupEntranceConfig
 * JD-Core Version:    0.7.0.1
 */