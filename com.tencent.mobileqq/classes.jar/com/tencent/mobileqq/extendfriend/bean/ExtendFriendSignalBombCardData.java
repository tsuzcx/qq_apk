package com.tencent.mobileqq.extendfriend.bean;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;

public class ExtendFriendSignalBombCardData
{
  public int a;
  public long a;
  public String a;
  public ArrayList<String> a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  
  public static ExtendFriendSignalBombCardData a(MatchInfo paramMatchInfo)
  {
    ExtendFriendSignalBombCardData localExtendFriendSignalBombCardData = new ExtendFriendSignalBombCardData();
    localExtendFriendSignalBombCardData.jdField_a_of_type_Long = paramMatchInfo.jdField_a_of_type_Long;
    localExtendFriendSignalBombCardData.jdField_a_of_type_JavaLangString = paramMatchInfo.jdField_b_of_type_JavaLangString;
    localExtendFriendSignalBombCardData.jdField_b_of_type_JavaLangString = paramMatchInfo.d;
    if (paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo != null)
    {
      localExtendFriendSignalBombCardData.jdField_b_of_type_Long = paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_a_of_type_Long;
      Object localObject;
      if ((paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_b_of_type_JavaUtilArrayList != null) && (!paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_b_of_type_JavaUtilArrayList.isEmpty()))
      {
        localObject = (SchoolInfo)paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_b_of_type_JavaUtilArrayList.get(0);
        localExtendFriendSignalBombCardData.d = ((SchoolInfo)localObject).jdField_a_of_type_JavaLangString;
        localExtendFriendSignalBombCardData.jdField_c_of_type_Long = ((SchoolInfo)localObject).jdField_a_of_type_Long;
        localExtendFriendSignalBombCardData.jdField_c_of_type_JavaLangString = ((SchoolInfo)localObject).jdField_b_of_type_JavaLangString;
      }
      localExtendFriendSignalBombCardData.jdField_a_of_type_Int = paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_f_of_type_Int;
      localExtendFriendSignalBombCardData.e = paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_b_of_type_JavaLangString;
      localExtendFriendSignalBombCardData.jdField_b_of_type_Int = paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_a_of_type_Int;
      if (paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localExtendFriendSignalBombCardData.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_a_of_type_JavaUtilArrayList.size());
        localObject = paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          PersonalTag localPersonalTag = (PersonalTag)((Iterator)localObject).next();
          localExtendFriendSignalBombCardData.jdField_a_of_type_JavaUtilArrayList.add(localPersonalTag.jdField_a_of_type_JavaLangString);
        }
      }
      localExtendFriendSignalBombCardData.jdField_f_of_type_JavaLangString = paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.g;
      localExtendFriendSignalBombCardData.g = paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.h;
      localExtendFriendSignalBombCardData.jdField_c_of_type_Int = paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_b_of_type_Int;
      localExtendFriendSignalBombCardData.jdField_a_of_type_Int = paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_f_of_type_Int;
      localExtendFriendSignalBombCardData.h = paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_c_of_type_JavaLangString;
      localExtendFriendSignalBombCardData.i = paramMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_f_of_type_JavaLangString;
    }
    return localExtendFriendSignalBombCardData;
  }
  
  public static MatchInfo a(ExtendFriendSignalBombCardData paramExtendFriendSignalBombCardData)
  {
    MatchInfo localMatchInfo = new MatchInfo();
    localMatchInfo.jdField_b_of_type_JavaLangString = paramExtendFriendSignalBombCardData.jdField_a_of_type_JavaLangString;
    localMatchInfo.jdField_b_of_type_Int = 0;
    localMatchInfo.jdField_a_of_type_Long = paramExtendFriendSignalBombCardData.jdField_a_of_type_Long;
    localMatchInfo.d = paramExtendFriendSignalBombCardData.jdField_b_of_type_JavaLangString;
    localMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo = new ChatFriendInfo();
    localMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_a_of_type_Long = paramExtendFriendSignalBombCardData.jdField_b_of_type_Long;
    localMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_b_of_type_JavaUtilArrayList = new ArrayList(1);
    Object localObject = new SchoolInfo(paramExtendFriendSignalBombCardData.jdField_c_of_type_JavaLangString, paramExtendFriendSignalBombCardData.d, paramExtendFriendSignalBombCardData.jdField_c_of_type_Long);
    localMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_b_of_type_JavaUtilArrayList.add(localObject);
    localMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_b_of_type_JavaLangString = paramExtendFriendSignalBombCardData.e;
    localMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_a_of_type_Int = paramExtendFriendSignalBombCardData.jdField_b_of_type_Int;
    if (paramExtendFriendSignalBombCardData.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramExtendFriendSignalBombCardData.jdField_a_of_type_JavaUtilArrayList.size());
      localObject = paramExtendFriendSignalBombCardData.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        PersonalTag localPersonalTag = new PersonalTag();
        localPersonalTag.jdField_a_of_type_JavaLangString = str;
        localMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_a_of_type_JavaUtilArrayList.add(localPersonalTag);
      }
    }
    localMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.g = paramExtendFriendSignalBombCardData.jdField_f_of_type_JavaLangString;
    localMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_b_of_type_Int = paramExtendFriendSignalBombCardData.jdField_c_of_type_Int;
    localMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.h = paramExtendFriendSignalBombCardData.g;
    localMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_f_of_type_Int = paramExtendFriendSignalBombCardData.jdField_a_of_type_Int;
    localMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_c_of_type_JavaLangString = paramExtendFriendSignalBombCardData.h;
    localMatchInfo.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanChatFriendInfo.jdField_f_of_type_JavaLangString = paramExtendFriendSignalBombCardData.i;
    return localMatchInfo;
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Long == 2L;
  }
  
  @NonNull
  public String toString()
  {
    return String.format("uin:%s,nick:%s,dis:%d", new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.bean.ExtendFriendSignalBombCardData
 * JD-Core Version:    0.7.0.1
 */