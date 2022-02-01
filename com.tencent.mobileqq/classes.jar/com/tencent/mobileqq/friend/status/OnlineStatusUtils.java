package com.tencent.mobileqq.friend.status;

import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.data.Friends;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OnlineStatusUtils
{
  public static int a(int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    Integer localInteger1 = Integer.valueOf(8);
    localHashMap.put(Integer.valueOf(-55), localInteger1);
    localHashMap.put(Integer.valueOf(201), localInteger1);
    localInteger1 = Integer.valueOf(4);
    localHashMap.put(Integer.valueOf(10), localInteger1);
    Integer localInteger2 = Integer.valueOf(0);
    localHashMap.put(Integer.valueOf(-6), localInteger2);
    localHashMap.put(Integer.valueOf(250), localInteger2);
    localHashMap.put(Integer.valueOf(20), localInteger2);
    localHashMap.put(Integer.valueOf(40), localInteger2);
    localHashMap.put(Integer.valueOf(95), localInteger2);
    localHashMap.put(Integer.valueOf(100), localInteger2);
    localHashMap.put(Integer.valueOf(101), localInteger2);
    Integer localInteger3 = Integer.valueOf(1);
    localHashMap.put(Integer.valueOf(30), localInteger3);
    Integer localInteger4 = Integer.valueOf(2);
    localHashMap.put(Integer.valueOf(50), localInteger4);
    Integer localInteger5 = Integer.valueOf(3);
    localHashMap.put(Integer.valueOf(60), localInteger5);
    Integer localInteger6 = Integer.valueOf(7);
    localHashMap.put(Integer.valueOf(70), localInteger6);
    localHashMap.put(Integer.valueOf(90), localInteger1);
    localHashMap.put(Integer.valueOf(91), localInteger1);
    if (localHashMap.containsKey(Integer.valueOf(paramInt1))) {
      paramInt1 = ((Integer)localHashMap.get(Integer.valueOf(paramInt1))).intValue();
    } else {
      paramInt1 = 0;
    }
    if ((paramInt2 != 69378) && (paramInt2 != 73474) && (paramInt2 != 73730)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return 0;
    }
    int i = paramInt1;
    if (!Arrays.asList(new Integer[] { localInteger2, localInteger3, localInteger4, localInteger6, Integer.valueOf(6), localInteger5, localInteger1 }).contains(Integer.valueOf(paramInt1)))
    {
      i = paramInt1;
      if (OnlineStatusIconHelper.a().a(paramInt2)) {
        i = 4;
      }
    }
    return i;
  }
  
  public static int a(Friends paramFriends)
  {
    int j = a(paramFriends.detalStatusFlag, paramFriends.iTermType);
    int i = 2;
    if (j != 1)
    {
      if (j != 2) {
        if ((j != 3) && (j != 4))
        {
          if (j != 7) {
            return (int)paramFriends.getLastLoginType() + 20;
          }
        }
        else {
          return 0;
        }
      }
      i = 1;
    }
    return i;
  }
  
  public static String a()
  {
    int i = HttpUtil.getNetWorkTypeContain5G();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 6) {
              return "";
            }
            return " - 5G";
          }
          return " - 4G";
        }
        return " - 3G";
      }
      return " - 2G";
    }
    return " - WiFi";
  }
  
  public static boolean a(Friends paramFriends)
  {
    return ((paramFriends.iTermType == 0) && (paramFriends.eNetwork == 0)) || ((a(paramFriends.detalStatusFlag, paramFriends.iTermType) == 0) && (!TextUtils.isEmpty(paramFriends.strTermDesc)) && (paramFriends.strTermDesc.contains("TIM")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.friend.status.OnlineStatusUtils
 * JD-Core Version:    0.7.0.1
 */