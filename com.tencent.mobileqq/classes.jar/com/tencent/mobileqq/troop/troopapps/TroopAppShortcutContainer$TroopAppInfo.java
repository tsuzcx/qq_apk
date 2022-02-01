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
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    boolean bool1 = bool2;
    if ((paramObject instanceof TroopAppInfo))
    {
      bool1 = bool2;
      if (((TroopAppInfo)paramObject).jdField_b_of_type_Long == this.jdField_b_of_type_Long) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TroopAppInfo{app_showtype='");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append('\'');
    ((StringBuilder)localObject).append(", app_type='");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
    ((StringBuilder)localObject).append('\'');
    ((StringBuilder)localObject).append(", app_appid='");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Long);
    ((StringBuilder)localObject).append('\'');
    ((StringBuilder)localObject).append(", app_removable='");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
    ((StringBuilder)localObject).append('\'');
    ((StringBuilder)localObject).append(", app_source='");
    ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
    ((StringBuilder)localObject).append('\'');
    ((StringBuilder)localObject).append(", app_name='");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append('\'');
    ((StringBuilder)localObject).append(", app_icon='");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject).append('\'');
    ((StringBuilder)localObject).append(", app_url='");
    ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
    ((StringBuilder)localObject).append('\'');
    ((StringBuilder)localObject).append(", app_desc='");
    ((StringBuilder)localObject).append(this.jdField_d_of_type_JavaLangString);
    ((StringBuilder)localObject).append('\'');
    ((StringBuilder)localObject).append(", app_added='");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
    ((StringBuilder)localObject).append('\'');
    ((StringBuilder)localObject).append(", app_redpoint='");
    ((StringBuilder)localObject).append(this.jdField_d_of_type_Int);
    ((StringBuilder)localObject).append('\'');
    ((StringBuilder)localObject).append(", app_trace='");
    ((StringBuilder)localObject).append(this.jdField_e_of_type_JavaLangString);
    ((StringBuilder)localObject).append('\'');
    ((StringBuilder)localObject).append(", app_showframe='");
    ((StringBuilder)localObject).append(this.jdField_e_of_type_Int);
    ((StringBuilder)localObject).append('\'');
    ((StringBuilder)localObject).append(", app_playingnum='");
    ((StringBuilder)localObject).append(this.f);
    ((StringBuilder)localObject).append('\'');
    ((StringBuilder)localObject).append(", app_friend_playingnum='");
    ((StringBuilder)localObject).append(this.g);
    ((StringBuilder)localObject).append('\'');
    ((StringBuilder)localObject).append(", app_total_playingnum='");
    ((StringBuilder)localObject).append(this.h);
    ((StringBuilder)localObject).append('\'');
    localStringBuilder.append(((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_JavaUtilList;
    int j = 0;
    int k;
    int i;
    if (localObject != null)
    {
      localStringBuilder.append(", app_playing_users='");
      k = this.jdField_a_of_type_JavaUtilList.size();
      i = 0;
      while (i < k)
      {
        if (i == k - 1)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append((String)this.jdField_a_of_type_JavaUtilList.get(i));
          ((StringBuilder)localObject).append("'");
          localStringBuilder.append(((StringBuilder)localObject).toString());
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append((String)this.jdField_a_of_type_JavaUtilList.get(i));
          ((StringBuilder)localObject).append("、 ");
          localStringBuilder.append(((StringBuilder)localObject).toString());
        }
        i += 1;
      }
    }
    if (this.jdField_b_of_type_JavaUtilList != null)
    {
      localStringBuilder.append(", app_recommend_tags='");
      k = this.jdField_b_of_type_JavaUtilList.size();
      i = j;
      while (i < k)
      {
        if (i == k - 1)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append((String)this.jdField_b_of_type_JavaUtilList.get(i));
          ((StringBuilder)localObject).append("'");
          localStringBuilder.append(((StringBuilder)localObject).toString());
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append((String)this.jdField_b_of_type_JavaUtilList.get(i));
          ((StringBuilder)localObject).append("、 ");
          localStringBuilder.append(((StringBuilder)localObject).toString());
        }
        i += 1;
      }
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.TroopAppShortcutContainer.TroopAppInfo
 * JD-Core Version:    0.7.0.1
 */