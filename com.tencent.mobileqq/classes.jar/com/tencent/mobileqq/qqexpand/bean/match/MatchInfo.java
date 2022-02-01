package com.tencent.mobileqq.qqexpand.bean.match;

import android.text.TextUtils;
import com.tencent.mobileqq.qqexpand.bean.chat.ChatFriendInfo;
import com.tencent.mobileqq.util.Utils;

public class MatchInfo
{
  public int a;
  public long a;
  public ChatFriendInfo a;
  public String a;
  public byte[] a;
  public int b;
  public String b;
  public String c = "";
  public String d = "";
  public String e = "0";
  public String f = "";
  
  public MatchInfo()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Int = 30;
    this.jdField_b_of_type_Int = 1;
  }
  
  public MatchInfo a()
  {
    MatchInfo localMatchInfo = new MatchInfo();
    localMatchInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localMatchInfo.jdField_a_of_type_ArrayOfByte = ((byte[])this.jdField_a_of_type_ArrayOfByte.clone());
    localMatchInfo.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localMatchInfo.c = this.c;
    localMatchInfo.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    localMatchInfo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localMatchInfo.e = this.e;
    return localMatchInfo;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ArrayOfByte = Utils.a("");
    this.jdField_b_of_type_JavaLangString = "";
    this.c = "";
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Int = -1;
    this.e = "0";
    this.jdField_b_of_type_Int = 0;
    this.f = "";
    this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo = null;
  }
  
  public boolean a()
  {
    String str = Utils.a(this.jdField_a_of_type_ArrayOfByte);
    return (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(str));
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        return false;
      }
      bool1 = bool2;
      if ((paramObject instanceof MatchInfo))
      {
        paramObject = (MatchInfo)paramObject;
        bool1 = bool2;
        if (this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString))
        {
          bool1 = bool2;
          if (this.jdField_b_of_type_JavaLangString.equals(paramObject.jdField_b_of_type_JavaLangString))
          {
            bool1 = bool2;
            if (this.jdField_a_of_type_Long == paramObject.jdField_a_of_type_Long) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{uin: ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("}");
    Object localObject = Utils.a(this.jdField_a_of_type_ArrayOfByte);
    int i;
    if (localObject != null) {
      i = ((String)localObject).length();
    } else {
      i = 0;
    }
    localStringBuilder.append("{sig: ");
    localStringBuilder.append(i);
    localStringBuilder.append("}");
    localStringBuilder.append("{matchUin: ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("}");
    localStringBuilder.append("{tipsWording: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("}");
    localStringBuilder.append("{timeStamp: ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("}");
    localStringBuilder.append("{nickName: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("}");
    localStringBuilder.append("{algorithmID: ");
    localStringBuilder.append(this.e);
    localStringBuilder.append("}");
    localStringBuilder.append("{tagId: ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("}");
    localStringBuilder.append("{tagName: ");
    localStringBuilder.append(this.f);
    localStringBuilder.append("}");
    localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanChatChatFriendInfo;
    if (localObject != null) {
      localStringBuilder.append(((ChatFriendInfo)localObject).toString());
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.bean.match.MatchInfo
 * JD-Core Version:    0.7.0.1
 */