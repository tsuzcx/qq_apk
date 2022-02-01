package com.tencent.mobileqq.qqexpand.bean.chat;

import com.tencent.mobileqq.qqexpand.bean.match.PersonalTag;
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
    localStringBuilder.append("{friendUin: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("}");
    localStringBuilder.append("{age: ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("}");
    localStringBuilder.append("{constellation: ");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("}");
    localStringBuilder.append("{city: ");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append("}");
    localStringBuilder.append("{school: ");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append("}");
    localStringBuilder.append("{constel:");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("}");
    localStringBuilder.append("{company:");
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append("}");
    localStringBuilder.append("{mGender: ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("}");
    localStringBuilder.append("{mDeclaration: ");
    localStringBuilder.append(this.jdField_g_of_type_JavaLangString);
    localStringBuilder.append("}");
    localStringBuilder.append("{mVoiceUrl: ");
    localStringBuilder.append(this.h);
    localStringBuilder.append("}");
    localStringBuilder.append("{mVoiceDuration: ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("}");
    localStringBuilder.append("{signWords: ");
    localStringBuilder.append(this.i);
    localStringBuilder.append("}");
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      localStringBuilder.append("{personalTags: is empty ");
      localStringBuilder.append("}");
    }
    else
    {
      localStringBuilder.append("{personalTags:size  ");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList.size());
      localStringBuilder.append("}");
    }
    localStringBuilder.append("{popular: ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("}");
    if (this.jdField_b_of_type_JavaUtilArrayList == null)
    {
      localStringBuilder.append("{schoolInfo: is empty ");
      localStringBuilder.append("}");
    }
    else
    {
      localStringBuilder.append("{schoolInfo:size  ");
      localStringBuilder.append(this.jdField_b_of_type_JavaUtilArrayList.size());
      localStringBuilder.append("}");
    }
    localStringBuilder.append("{distance: ");
    localStringBuilder.append(this.jdField_f_of_type_Int);
    localStringBuilder.append("}");
    localStringBuilder.append("{signalBombMatchPool: ");
    localStringBuilder.append(this.jdField_g_of_type_Int);
    localStringBuilder.append("}");
    localStringBuilder.append("{strFromCity: ");
    localStringBuilder.append(this.j);
    localStringBuilder.append("}");
    localStringBuilder.append("{strToCity: ");
    localStringBuilder.append(this.k);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.bean.chat.ChatFriendInfo
 * JD-Core Version:    0.7.0.1
 */