package com.tencent.mobileqq.qqexpand.match;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqexpand.bean.chat.ChatFriendInfo;
import com.tencent.mobileqq.qqexpand.bean.chat.SchoolInfo;
import com.tencent.mobileqq.qqexpand.bean.match.MatchInfo;
import com.tencent.mobileqq.qqexpand.bean.match.PersonalTag;
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
    if (paramMatchInfo.jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo != null)
    {
      localExtendFriendSignalBombCardData.jdField_b_of_type_Long = paramMatchInfo.jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo.jdField_a_of_type_Long;
      Object localObject;
      if ((paramMatchInfo.jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo.jdField_b_of_type_JavaUtilArrayList != null) && (!paramMatchInfo.jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo.jdField_b_of_type_JavaUtilArrayList.isEmpty()))
      {
        localObject = (SchoolInfo)paramMatchInfo.jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo.jdField_b_of_type_JavaUtilArrayList.get(0);
        localExtendFriendSignalBombCardData.d = ((SchoolInfo)localObject).jdField_a_of_type_JavaLangString;
        localExtendFriendSignalBombCardData.jdField_c_of_type_Long = ((SchoolInfo)localObject).jdField_a_of_type_Long;
        localExtendFriendSignalBombCardData.jdField_c_of_type_JavaLangString = ((SchoolInfo)localObject).jdField_b_of_type_JavaLangString;
      }
      localExtendFriendSignalBombCardData.jdField_a_of_type_Int = paramMatchInfo.jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo.jdField_f_of_type_Int;
      localExtendFriendSignalBombCardData.e = paramMatchInfo.jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo.jdField_b_of_type_JavaLangString;
      localExtendFriendSignalBombCardData.jdField_b_of_type_Int = paramMatchInfo.jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo.jdField_a_of_type_Int;
      if (paramMatchInfo.jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localExtendFriendSignalBombCardData.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramMatchInfo.jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo.jdField_a_of_type_JavaUtilArrayList.size());
        localObject = paramMatchInfo.jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          PersonalTag localPersonalTag = (PersonalTag)((Iterator)localObject).next();
          localExtendFriendSignalBombCardData.jdField_a_of_type_JavaUtilArrayList.add(localPersonalTag.jdField_a_of_type_JavaLangString);
        }
      }
      localExtendFriendSignalBombCardData.jdField_f_of_type_JavaLangString = paramMatchInfo.jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo.g;
      localExtendFriendSignalBombCardData.g = paramMatchInfo.jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo.h;
      localExtendFriendSignalBombCardData.jdField_c_of_type_Int = paramMatchInfo.jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo.jdField_b_of_type_Int;
      localExtendFriendSignalBombCardData.jdField_a_of_type_Int = paramMatchInfo.jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo.jdField_f_of_type_Int;
      localExtendFriendSignalBombCardData.h = paramMatchInfo.jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo.jdField_c_of_type_JavaLangString;
      localExtendFriendSignalBombCardData.i = paramMatchInfo.jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo.jdField_f_of_type_JavaLangString;
    }
    return localExtendFriendSignalBombCardData;
  }
  
  @NonNull
  public String toString()
  {
    return String.format("uin:%s,nick:%s,dis:%d", new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.match.ExtendFriendSignalBombCardData
 * JD-Core Version:    0.7.0.1
 */