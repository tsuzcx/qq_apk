package com.tencent.mobileqq.qassistant.util;

import android.text.TextUtils;
import com.tencent.mobileqq.qassistant.data.CommandInfo;
import com.tencent.mobileqq.qassistant.data.FriendItemInfo;
import com.tencent.mobileqq.qassistant.data.VoiceItemInfo;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class VoiceTextUtils
{
  public static FriendItemInfo a(CommandInfo paramCommandInfo)
  {
    if ((paramCommandInfo != null) && (paramCommandInfo.a != null) && (!paramCommandInfo.a.isEmpty()))
    {
      paramCommandInfo = paramCommandInfo.a.iterator();
      while (paramCommandInfo.hasNext())
      {
        FriendItemInfo localFriendItemInfo = (FriendItemInfo)paramCommandInfo.next();
        if (!localFriendItemInfo.a) {
          return localFriendItemInfo;
        }
      }
    }
    return null;
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.equals(MobileQQ.sMobileQQ.getString(2131720327)));
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return paramString1.equals(String.format(MobileQQ.sMobileQQ.getString(2131720319), new Object[] { paramString2 }));
    }
    return false;
  }
  
  public static boolean a(List<VoiceItemInfo> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        VoiceItemInfo localVoiceItemInfo = (VoiceItemInfo)paramList.next();
        if ((localVoiceItemInfo.jdField_a_of_type_Int == 0) && (!TextUtils.isEmpty(localVoiceItemInfo.jdField_a_of_type_JavaLangString)) && (localVoiceItemInfo.jdField_a_of_type_JavaLangString.equals(MobileQQ.sMobileQQ.getString(2131718750)))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean b(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.equals(MobileQQ.sMobileQQ.getString(2131720328)));
  }
  
  public static boolean c(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.equals(MobileQQ.sMobileQQ.getString(2131720331)));
  }
  
  public static boolean d(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.equals(MobileQQ.sMobileQQ.getString(2131720325)));
  }
  
  public static boolean e(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.equals(MobileQQ.sMobileQQ.getString(2131720324)));
  }
  
  public static boolean f(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.equals(MobileQQ.sMobileQQ.getString(2131718750)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.util.VoiceTextUtils
 * JD-Core Version:    0.7.0.1
 */