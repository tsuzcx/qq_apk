package com.tencent.mobileqq.qassistant.util;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qassistant.data.CommandInfo;
import com.tencent.mobileqq.qassistant.data.FriendItemInfo;
import com.tencent.mobileqq.qassistant.data.VoiceItemInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Iterator;
import java.util.List;

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
    return (!TextUtils.isEmpty(paramString)) && (paramString.equals(BaseApplicationImpl.getContext().getString(2131720612)));
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString1))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString2)) {
        bool1 = paramString1.equals(String.format(BaseApplicationImpl.getContext().getString(2131720604), new Object[] { paramString2 }));
      }
    }
    return bool1;
  }
  
  public static boolean a(List<VoiceItemInfo> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        VoiceItemInfo localVoiceItemInfo = (VoiceItemInfo)paramList.next();
        if ((localVoiceItemInfo.jdField_a_of_type_Int == 0) && (!TextUtils.isEmpty(localVoiceItemInfo.jdField_a_of_type_JavaLangString)) && (localVoiceItemInfo.jdField_a_of_type_JavaLangString.equals(BaseApplicationImpl.getContext().getString(2131719034)))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean b(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.equals(BaseApplicationImpl.getContext().getString(2131720613)));
  }
  
  public static boolean c(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.equals(BaseApplicationImpl.getContext().getString(2131720616)));
  }
  
  public static boolean d(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.equals(BaseApplicationImpl.getContext().getString(2131720610)));
  }
  
  public static boolean e(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.equals(BaseApplicationImpl.getContext().getString(2131720609)));
  }
  
  public static boolean f(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.equals(BaseApplicationImpl.getContext().getString(2131719034)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.util.VoiceTextUtils
 * JD-Core Version:    0.7.0.1
 */