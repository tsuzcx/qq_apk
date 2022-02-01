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
  public ArrayList<Long> d;
  public boolean e;
  
  public String a()
  {
    return "key_for_qzone_group_entrance_cfg";
  }
  
  public void a(String paramString)
  {
    this.d = new ArrayList();
    this.e = false;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      JSONArray localJSONArray = paramString.optJSONArray("troop_types");
      if (localJSONArray != null)
      {
        int i = 0;
        while (i < localJSONArray.length())
        {
          this.d.add(Long.valueOf(localJSONArray.optLong(i)));
          i += 1;
        }
      }
      this.e = paramString.optBoolean("is_show_reddot", false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneManagerImp.QZoneGroupEntranceConfig
 * JD-Core Version:    0.7.0.1
 */