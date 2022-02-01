package com.tencent.mobileqq.troop.util;

import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class TroopSystemMsgUtils
{
  private static HashSet<Integer> a = new HashSet();
  
  static
  {
    a.add(Integer.valueOf(91));
  }
  
  public static int a(int paramInt)
  {
    if ((paramInt != 2) && (paramInt != 3) && (paramInt != 6) && (paramInt != 7) && (paramInt != 15) && (paramInt != 16)) {
      return 2;
    }
    return 1;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 == 11)
    {
      if (paramInt1 != 1) {}
    }
    else {
      do
      {
        return 2;
        if (paramInt2 == 12)
        {
          if (paramInt1 != 1) {
            break;
          }
          return 3;
        }
        if (paramInt2 == 13) {
          return 3;
        }
        if (paramInt2 == 14) {
          return 4;
        }
      } while (paramInt2 == 16);
    }
    return paramInt1;
  }
  
  public static String a(structmsg.StructMsg paramStructMsg, String paramString)
  {
    String str = paramString;
    if (paramString.contains("%req_uin%"))
    {
      str = paramStructMsg.msg.req_uin_nick.get();
      if (TextUtils.isEmpty(str)) {
        return null;
      }
      str = paramString.replace("%req_uin%", str);
    }
    paramString = str;
    if (str.contains("%action_uin%"))
    {
      paramString = paramStructMsg.msg.action_uin_nick.get();
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      paramString = str.replace("%action_uin%", paramString);
    }
    str = paramString;
    if (paramString.contains("%actor_uin%"))
    {
      str = paramStructMsg.msg.actor_uin_nick.get();
      if (TextUtils.isEmpty(str)) {
        return null;
      }
      str = paramString.replace("%actor_uin%", str);
    }
    paramString = str;
    if (str.contains("%group_name%"))
    {
      paramStructMsg = paramStructMsg.msg.group_name.get();
      if (TextUtils.isEmpty(paramStructMsg)) {
        return null;
      }
      paramString = str.replace("%group_name%", paramStructMsg);
    }
    return paramString;
  }
  
  public static void a(structmsg.StructMsg paramStructMsg, int paramInt1, String paramString, int paramInt2)
  {
    if (paramStructMsg == null) {
      return;
    }
    if (2 == paramStructMsg.msg_type.get())
    {
      List localList = paramStructMsg.msg.actions.get();
      if ((localList != null) && (localList.size() > paramInt1) && (a(paramStructMsg.msg.sub_type.get(), paramStructMsg.msg.group_msg_type.get())))
      {
        String str = ((structmsg.SystemMsgAction)localList.get(paramInt1)).result.get();
        paramStructMsg.msg.msg_decided.set(str);
        paramStructMsg.msg.msg_detail.set(paramString);
        paramInt1 = a(paramStructMsg.msg.sub_type.get(), ((structmsg.SystemMsgAction)localList.get(paramInt1)).action_info.type.get(), paramStructMsg.msg.group_msg_type.get());
        paramStructMsg.msg.sub_type.set(paramInt1);
        paramStructMsg.msg.actions.clear();
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    return a.contains(Integer.valueOf(paramInt));
  }
  
  private static boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 != 3) || ((paramInt2 != 10) && (paramInt2 != 11));
  }
  
  public static boolean a(ArrayList<MessageRecord> paramArrayList)
  {
    boolean bool2 = false;
    if (paramArrayList == null) {
      return false;
    }
    paramArrayList = paramArrayList.iterator();
    MessageRecord localMessageRecord;
    do
    {
      bool1 = bool2;
      if (!paramArrayList.hasNext()) {
        break;
      }
      localMessageRecord = (MessageRecord)paramArrayList.next();
    } while ((localMessageRecord.isSend()) || (localMessageRecord.isread));
    boolean bool1 = true;
    return bool1;
  }
  
  public static boolean a(structmsg.StructMsg paramStructMsg, int paramInt, String paramString1, String paramString2)
  {
    boolean bool = false;
    if (paramStructMsg == null) {
      return false;
    }
    if (paramStructMsg.msg_type.get() == 2)
    {
      paramStructMsg.msg.sub_type.set(5);
      paramStructMsg.msg.msg_decided.set(paramString2);
      paramStructMsg.msg.msg_detail.set(paramString1);
      paramStructMsg.msg.actions.clear();
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.util.TroopSystemMsgUtils
 * JD-Core Version:    0.7.0.1
 */