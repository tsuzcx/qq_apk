package com.tencent.mobileqq.onlinestatus.utils;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.Friends;
import java.util.HashMap;
import mqq.app.AppRuntime.Status;

public class OnlineStatusTranslateUtils
{
  public static final HashMap<Integer, AppRuntime.Status> a = new HashMap();
  
  static
  {
    a.put(Integer.valueOf(10), AppRuntime.Status.online);
    a.put(Integer.valueOf(20), AppRuntime.Status.offline);
    a.put(Integer.valueOf(30), AppRuntime.Status.away);
    a.put(Integer.valueOf(50), AppRuntime.Status.busy);
    a.put(Integer.valueOf(60), AppRuntime.Status.qme);
    a.put(Integer.valueOf(70), AppRuntime.Status.dnd);
    a.put(Integer.valueOf(-55), AppRuntime.Status.receiveofflinemsg);
    a.put(Integer.valueOf(201), AppRuntime.Status.receiveofflinemsg);
    a.put(Integer.valueOf(-6), AppRuntime.Status.offline);
    a.put(Integer.valueOf(250), AppRuntime.Status.offline);
    a.put(Integer.valueOf(40), AppRuntime.Status.offline);
    a.put(Integer.valueOf(95), AppRuntime.Status.offline);
    a.put(Integer.valueOf(100), AppRuntime.Status.offline);
    a.put(Integer.valueOf(101), AppRuntime.Status.offline);
    a.put(Integer.valueOf(90), AppRuntime.Status.online);
    a.put(Integer.valueOf(91), AppRuntime.Status.online);
  }
  
  public static String a(byte paramByte)
  {
    if (paramByte == 1) {
      return HardCodeUtil.a(2131693128);
    }
    if (paramByte == 2) {
      return HardCodeUtil.a(2131719044);
    }
    return HardCodeUtil.a(2131693128);
  }
  
  public static AppRuntime.Status a(int paramInt)
  {
    if (a.containsKey(Integer.valueOf(paramInt))) {
      return (AppRuntime.Status)a.get(Integer.valueOf(paramInt));
    }
    return AppRuntime.Status.offline;
  }
  
  public static AppRuntime.Status a(Friends paramFriends)
  {
    int i = paramFriends.detalStatusFlag;
    if (a.containsKey(Integer.valueOf(i))) {
      return (AppRuntime.Status)a.get(Integer.valueOf(i));
    }
    return AppRuntime.Status.offline;
  }
  
  public static boolean a(AppRuntime.Status paramStatus)
  {
    return (paramStatus == AppRuntime.Status.away) || (paramStatus == AppRuntime.Status.dnd) || (paramStatus == AppRuntime.Status.busy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.utils.OnlineStatusTranslateUtils
 * JD-Core Version:    0.7.0.1
 */