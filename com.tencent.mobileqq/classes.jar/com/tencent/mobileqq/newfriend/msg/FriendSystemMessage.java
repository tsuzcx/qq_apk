package com.tencent.mobileqq.newfriend.msg;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class FriendSystemMessage
  extends NewFriendMessage
{
  public MessageForSystemMsg a;
  
  public FriendSystemMessage(MessageForSystemMsg paramMessageForSystemMsg)
  {
    this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg = paramMessageForSystemMsg;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg.extStr;
    this.jdField_a_of_type_Long = paramMessageForSystemMsg.time;
    this.b = a(this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg.getSystemMsg());
  }
  
  public FriendSystemMessage(String paramString, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public static String a(Context paramContext, structmsg.StructMsg paramStructMsg)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramContext != null)
    {
      if (paramStructMsg == null) {
        return null;
      }
      boolean bool = a(paramStructMsg.msg_type.get(), paramStructMsg.msg.sub_type.get());
      if (!TextUtils.isEmpty(paramStructMsg.msg.msg_additional.get()))
      {
        if (!TextUtils.isEmpty(paramStructMsg.msg.msg_qna.get())) {
          localObject1 = paramStructMsg.msg.msg_qna.get();
        } else {
          localObject1 = paramStructMsg.msg.msg_additional.get();
        }
        paramStructMsg = (structmsg.StructMsg)localObject1;
        if (bool)
        {
          paramStructMsg = (structmsg.StructMsg)localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            paramStructMsg = new StringBuilder();
            paramStructMsg.append(paramContext.getString(2131693385));
            paramStructMsg.append(paramContext.getString(2131693384));
            paramStructMsg.append((String)localObject1);
            paramStructMsg = paramStructMsg.toString();
          }
        }
      }
      else
      {
        localObject1 = paramStructMsg.msg.msg_describe.get();
        paramStructMsg = (structmsg.StructMsg)localObject1;
        if (bool)
        {
          paramStructMsg = (structmsg.StructMsg)localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            paramStructMsg = new StringBuilder();
            paramStructMsg.append(paramContext.getString(2131693383));
            paramStructMsg.append(paramContext.getString(2131693384));
            paramStructMsg.append((String)localObject1);
            paramStructMsg = paramStructMsg.toString();
          }
        }
      }
      localObject1 = localObject2;
      if (paramStructMsg != null) {
        localObject1 = paramStructMsg.trim();
      }
    }
    return localObject1;
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 1) && ((paramInt2 == 1) || (paramInt2 == 2) || (paramInt2 == 3) || (paramInt2 == 7) || (paramInt2 == 8) || (paramInt2 == 9) || (paramInt2 == 10));
  }
  
  public static boolean a(AppRuntime paramAppRuntime, String paramString, structmsg.StructMsg paramStructMsg, boolean paramBoolean)
  {
    boolean bool6 = false;
    boolean bool3;
    boolean bool5;
    int i;
    boolean bool4;
    if ((paramStructMsg != null) && (paramStructMsg.msg.uint32_source_flag.has()) && (paramAppRuntime != null))
    {
      paramAppRuntime = (IFriendDataService)paramAppRuntime.getRuntimeService(IFriendDataService.class, "");
      boolean bool2;
      if ((paramBoolean) && (paramAppRuntime != null) && (paramAppRuntime.isFriend(paramString))) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      int j = paramStructMsg.msg.uint32_source_flag.get();
      boolean bool1;
      if ((j & 0x10) != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (paramBoolean)
      {
        bool3 = bool6;
        bool5 = bool2;
        i = j;
        bool4 = bool1;
        if (bool1)
        {
          bool3 = bool6;
          bool5 = bool2;
          i = j;
          bool4 = bool1;
          if (!bool2)
          {
            bool3 = true;
            bool5 = bool2;
            i = j;
            bool4 = bool1;
          }
        }
      }
      else
      {
        bool3 = bool1;
        bool5 = bool2;
        i = j;
        bool4 = bool1;
      }
    }
    else
    {
      bool5 = false;
      i = 0;
      bool4 = false;
      bool3 = bool6;
    }
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("result=");
      paramAppRuntime.append(bool3);
      paramAppRuntime.append(",isFromWzry=");
      paramAppRuntime.append(bool4);
      paramAppRuntime.append(",sourceFlag=");
      paramAppRuntime.append(i);
      paramAppRuntime.append(",isFriend=");
      paramAppRuntime.append(bool5);
      paramAppRuntime.append(",checkFriend=");
      paramAppRuntime.append(paramBoolean);
      QLog.d("isMsgFromWZRY", 2, paramAppRuntime.toString());
    }
    return bool3;
  }
  
  public static boolean a(structmsg.StructMsg paramStructMsg)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramStructMsg != null)
    {
      bool1 = bool2;
      if (paramStructMsg.msg != null)
      {
        bool1 = bool2;
        if (paramStructMsg.msg.uint32_doubt_flag.has())
        {
          bool1 = bool2;
          if (paramStructMsg.msg.uint32_doubt_flag.get() > 0) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public String a()
  {
    return String.valueOf(this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg.structMsg.req_uin.get());
  }
  
  public String a(Context paramContext)
  {
    MessageForSystemMsg localMessageForSystemMsg = this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg;
    if (localMessageForSystemMsg != null) {
      return a(paramContext, localMessageForSystemMsg.structMsg);
    }
    return null;
  }
  
  public String a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg;
    if ((paramAppRuntime != null) && (TextUtils.isEmpty(paramAppRuntime.msg)))
    {
      this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg.parse();
      this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg.msg = MessageForSystemMsg.getSysMsgDesc(BaseApplication.getContext().getResources(), this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg.structMsg);
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg.msg;
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg.isread;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg.structMsg.msg.req_uin_nick.has()) {
      return this.jdField_a_of_type_ComTencentMobileqqSystemmsgMessageForSystemMsg.structMsg.msg.req_uin_nick.get();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.msg.FriendSystemMessage
 * JD-Core Version:    0.7.0.1
 */