package com.tencent.mobileqq.structmsg;

import android.text.TextUtils;

public class AbsShareMsg$Builder
{
  int jdField_a_of_type_Int = -1;
  long jdField_a_of_type_Long = -1L;
  AbsShareMsg jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
  Class<? extends AbsShareMsg> jdField_a_of_type_JavaLangClass;
  String jdField_a_of_type_JavaLangString = "web";
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int = -1;
  long jdField_b_of_type_Long = 0L;
  String jdField_b_of_type_JavaLangString = null;
  int jdField_c_of_type_Int;
  String jdField_c_of_type_JavaLangString = null;
  int jdField_d_of_type_Int;
  String jdField_d_of_type_JavaLangString = null;
  int jdField_e_of_type_Int;
  String jdField_e_of_type_JavaLangString = null;
  String f = null;
  String g = null;
  String h = null;
  String i = null;
  String j = null;
  String k = null;
  String l = null;
  String m = null;
  String n = null;
  String o = null;
  String p = null;
  String q = null;
  
  public AbsShareMsg$Builder(Class<? extends AbsShareMsg> paramClass)
  {
    this.jdField_a_of_type_JavaLangClass = paramClass;
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_JavaLangString = "web";
    this.jdField_c_of_type_Int = 28;
  }
  
  public Builder a(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
    if ((paramInt & 0x1) == 1) {
      this.jdField_d_of_type_Int = 1;
    }
    return this;
  }
  
  public Builder a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public Builder a(String paramString1, String paramString2)
  {
    this.n = paramString1;
    this.m = paramString2;
    if ((!TextUtils.isEmpty(paramString1)) || (!TextUtils.isEmpty(paramString2))) {
      this.jdField_a_of_type_Boolean = true;
    }
    return this;
  }
  
  public Builder a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_e_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_JavaLangString = paramString3;
    this.jdField_c_of_type_JavaLangString = paramString4;
    this.jdField_d_of_type_JavaLangString = paramString5;
    return this;
  }
  
  public AbsShareMsg a()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg = ((AbsShareMsg)this.jdField_a_of_type_JavaLangClass.newInstance());
    }
    catch (IllegalAccessException|InstantiationException localIllegalAccessException)
    {
      label17:
      AbsShareMsg localAbsShareMsg;
      break label17;
    }
    localAbsShareMsg = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
    if (localAbsShareMsg != null)
    {
      localAbsShareMsg.mMsgTemplateID = this.jdField_a_of_type_Int;
      localAbsShareMsg.mMsgServiceID = this.jdField_b_of_type_Int;
      localAbsShareMsg.mVersion = this.jdField_c_of_type_Int;
      localAbsShareMsg.mMsgAction = this.jdField_a_of_type_JavaLangString;
      localAbsShareMsg.mMsgActionData = this.jdField_b_of_type_JavaLangString;
      localAbsShareMsg.mMsg_A_ActionData = this.jdField_c_of_type_JavaLangString;
      localAbsShareMsg.mMsg_I_ActionData = this.jdField_d_of_type_JavaLangString;
      localAbsShareMsg.mMsgUrl = this.jdField_e_of_type_JavaLangString;
      localAbsShareMsg.mMsgBrief = this.f;
      localAbsShareMsg.mCompatibleText = this.g;
      localAbsShareMsg.mFlag = this.jdField_e_of_type_Int;
      localAbsShareMsg.mSourceAction = this.i;
      localAbsShareMsg.mSourceUrl = this.h;
      localAbsShareMsg.mSourceActionData = this.j;
      localAbsShareMsg.mSource_A_ActionData = this.k;
      localAbsShareMsg.mSource_I_ActionData = this.l;
      localAbsShareMsg.mSourceName = this.n;
      localAbsShareMsg.mSourceIcon = this.m;
      localAbsShareMsg.mHasSource = this.jdField_a_of_type_Boolean;
      localAbsShareMsg.mResid = this.o;
      localAbsShareMsg.mFileName = this.p;
      localAbsShareMsg.mFileSize = this.jdField_b_of_type_Long;
      localAbsShareMsg.mSType = this.q;
    }
    return this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg;
  }
  
  public Builder b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public Builder b(String paramString)
  {
    this.o = paramString;
    return this;
  }
  
  public Builder b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.i = paramString1;
    this.h = paramString2;
    this.j = paramString3;
    this.k = paramString4;
    this.l = paramString5;
    return this;
  }
  
  public Builder c(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public Builder c(String paramString)
  {
    this.p = paramString;
    return this;
  }
  
  public Builder d(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public Builder e(String paramString)
  {
    return a("web", paramString, null, null, null);
  }
  
  public Builder f(String paramString)
  {
    return b("web", paramString, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.AbsShareMsg.Builder
 * JD-Core Version:    0.7.0.1
 */