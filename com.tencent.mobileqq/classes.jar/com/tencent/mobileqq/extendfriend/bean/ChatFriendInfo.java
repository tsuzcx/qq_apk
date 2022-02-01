package com.tencent.mobileqq.extendfriend.bean;

import java.util.ArrayList;

public class ChatFriendInfo
{
  public int a;
  public long a;
  public String a;
  public ArrayList<PersonalTag> a;
  public int b;
  public String b;
  public ArrayList<SchoolInfo> b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public String h;
  public String i;
  public String j = "";
  public String k = "";
  
  public ChatFriendInfo()
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = -1;
    this.jdField_g_of_type_Int = -1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{friendUin: ").append(this.jdField_a_of_type_JavaLangString).append("}");
    localStringBuilder.append("{age: ").append(this.jdField_b_of_type_JavaLangString).append("}");
    localStringBuilder.append("{constellation: ").append(this.jdField_c_of_type_JavaLangString).append("}");
    localStringBuilder.append("{city: ").append(this.jdField_d_of_type_JavaLangString).append("}");
    localStringBuilder.append("{school: ").append(this.jdField_e_of_type_JavaLangString).append("}");
    localStringBuilder.append("{constel:").append(this.jdField_c_of_type_JavaLangString).append("}");
    localStringBuilder.append("{company:").append(this.jdField_f_of_type_JavaLangString).append("}");
    localStringBuilder.append("{mGender: ").append(this.jdField_a_of_type_Int).append("}");
    localStringBuilder.append("{mDeclaration: ").append(this.jdField_g_of_type_JavaLangString).append("}");
    localStringBuilder.append("{mVoiceUrl: ").append(this.h).append("}");
    localStringBuilder.append("{mVoiceDuration: ").append(this.jdField_b_of_type_Int).append("}");
    localStringBuilder.append("{signWords: ").append(this.i).append("}");
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      localStringBuilder.append("{personalTags: is empty ").append("}");
      localStringBuilder.append("{popular: ").append(this.jdField_a_of_type_Long).append("}");
      if (this.jdField_b_of_type_JavaUtilArrayList != null) {
        break label399;
      }
      localStringBuilder.append("{schoolInfo: is empty ").append("}");
    }
    for (;;)
    {
      localStringBuilder.append("{distance: ").append(this.jdField_f_of_type_Int).append("}");
      localStringBuilder.append("{signalBombMatchPool: ").append(this.jdField_g_of_type_Int).append("}");
      localStringBuilder.append("{strFromCity: ").append(this.j).append("}");
      localStringBuilder.append("{strToCity: ").append(this.k).append("}");
      return localStringBuilder.toString();
      localStringBuilder.append("{personalTags:size  ").append(this.jdField_a_of_type_JavaUtilArrayList.size()).append("}");
      break;
      label399:
      localStringBuilder.append("{schoolInfo:size  ").append(this.jdField_b_of_type_JavaUtilArrayList.size()).append("}");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.bean.ChatFriendInfo
 * JD-Core Version:    0.7.0.1
 */