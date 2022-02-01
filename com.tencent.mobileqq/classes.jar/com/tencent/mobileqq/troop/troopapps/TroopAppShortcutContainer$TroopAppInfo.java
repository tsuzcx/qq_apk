package com.tencent.mobileqq.troop.troopapps;

import java.util.ArrayList;
import java.util.List;

public class TroopAppShortcutContainer$TroopAppInfo
{
  public int a;
  public long a;
  public String a;
  List<String> a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  List<String> b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f = 0;
  public int g = 0;
  public int h = 0;
  
  public TroopAppShortcutContainer$TroopAppInfo()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = false;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while ((!(paramObject instanceof TroopAppInfo)) || (((TroopAppInfo)paramObject).jdField_b_of_type_Long != this.jdField_b_of_type_Long)) {
      return false;
    }
    return true;
  }
  
  public String toString()
  {
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TroopAppInfo{app_showtype='" + this.jdField_a_of_type_Int + '\'' + ", app_type='" + this.jdField_a_of_type_Long + '\'' + ", app_appid='" + this.jdField_b_of_type_Long + '\'' + ", app_removable='" + this.jdField_b_of_type_Int + '\'' + ", app_source='" + this.jdField_c_of_type_Int + '\'' + ", app_name='" + this.jdField_a_of_type_JavaLangString + '\'' + ", app_icon='" + this.jdField_b_of_type_JavaLangString + '\'' + ", app_url='" + this.jdField_c_of_type_JavaLangString + '\'' + ", app_desc='" + this.jdField_d_of_type_JavaLangString + '\'' + ", app_added='" + this.jdField_a_of_type_Boolean + '\'' + ", app_redpoint='" + this.jdField_d_of_type_Int + '\'' + ", app_trace='" + this.jdField_e_of_type_JavaLangString + '\'' + ", app_showframe='" + this.jdField_e_of_type_Int + '\'' + ", app_playingnum='" + this.f + '\'' + ", app_friend_playingnum='" + this.g + '\'' + ", app_total_playingnum='" + this.h + '\'');
    int k;
    int i;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localStringBuilder.append(", app_playing_users='");
      k = this.jdField_a_of_type_JavaUtilList.size();
      i = 0;
      if (i < k)
      {
        if (i == k - 1) {
          localStringBuilder.append((String)this.jdField_a_of_type_JavaUtilList.get(i) + "'");
        }
        for (;;)
        {
          i += 1;
          break;
          localStringBuilder.append((String)this.jdField_a_of_type_JavaUtilList.get(i) + "、 ");
        }
      }
    }
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      localStringBuilder.append(", app_recommend_tags='");
      k = this.jdField_b_of_type_JavaUtilList.size();
      i = j;
      if (i < k)
      {
        if (i == k - 1) {
          localStringBuilder.append((String)this.jdField_b_of_type_JavaUtilList.get(i) + "'");
        }
        for (;;)
        {
          i += 1;
          break;
          localStringBuilder.append((String)this.jdField_b_of_type_JavaUtilList.get(i) + "、 ");
        }
      }
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.TroopAppShortcutContainer.TroopAppInfo
 * JD-Core Version:    0.7.0.1
 */