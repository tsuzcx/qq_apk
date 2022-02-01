package com.tencent.mobileqq.qassistant.util;

import android.content.res.Resources;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.data.FriendItemInfo;
import com.tencent.mobileqq.qassistant.data.VoiceItemInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class VoiceDataUtils
{
  public static int[] a = { 2131720314, 2131720313 };
  
  public static String a(int paramInt)
  {
    Resources localResources = AssistantUtils.a().getResources();
    String str = localResources.getString(2131720340);
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return str;
        }
        return localResources.getString(2131720323);
      }
      return localResources.getString(2131720325);
    }
    return localResources.getString(2131720340);
  }
  
  public static List<VoiceItemInfo> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    VoiceItemInfo localVoiceItemInfo = new VoiceItemInfo();
    localVoiceItemInfo.jdField_a_of_type_Int = 7;
    localVoiceItemInfo.b = 40;
    localArrayList.add(localVoiceItemInfo);
    localVoiceItemInfo = new VoiceItemInfo();
    localVoiceItemInfo.jdField_a_of_type_Int = 0;
    localVoiceItemInfo.jdField_a_of_type_JavaLangString = paramString;
    localArrayList.add(localVoiceItemInfo);
    paramString = new VoiceItemInfo();
    paramString.jdField_a_of_type_Int = 7;
    paramString.b = 20;
    localArrayList.add(paramString);
    paramString = new VoiceItemInfo();
    paramString.jdField_a_of_type_Int = 1;
    localArrayList.add(paramString);
    paramString = new VoiceItemInfo();
    paramString.jdField_a_of_type_Int = 7;
    paramString.b = 10;
    localArrayList.add(paramString);
    return localArrayList;
  }
  
  public static List<VoiceItemInfo> a(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    VoiceItemInfo localVoiceItemInfo = new VoiceItemInfo();
    localVoiceItemInfo.jdField_a_of_type_Int = 7;
    localVoiceItemInfo.b = 40;
    localArrayList.add(localVoiceItemInfo);
    localVoiceItemInfo = new VoiceItemInfo();
    localVoiceItemInfo.jdField_a_of_type_Int = 3;
    localVoiceItemInfo.jdField_a_of_type_JavaLangString = paramString1;
    localArrayList.add(localVoiceItemInfo);
    paramString1 = new VoiceItemInfo();
    paramString1.jdField_a_of_type_Int = 7;
    paramString1.b = 12;
    localArrayList.add(paramString1);
    paramString1 = new VoiceItemInfo();
    paramString1.jdField_a_of_type_Int = 4;
    paramString1.jdField_a_of_type_JavaLangString = paramString2;
    localArrayList.add(paramString1);
    paramString1 = new VoiceItemInfo();
    paramString1.jdField_a_of_type_Int = 7;
    paramString1.b = 12;
    localArrayList.add(paramString1);
    paramString1 = new VoiceItemInfo();
    paramString1.jdField_a_of_type_Int = 6;
    localArrayList.add(paramString1);
    paramString1 = new VoiceItemInfo();
    paramString1.jdField_a_of_type_Int = 7;
    paramString1.b = 10;
    localArrayList.add(paramString1);
    return localArrayList;
  }
  
  public static List<VoiceItemInfo> a(String paramString1, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    VoiceItemInfo localVoiceItemInfo = new VoiceItemInfo();
    localVoiceItemInfo.jdField_a_of_type_Int = 7;
    localVoiceItemInfo.b = 40;
    localArrayList.add(localVoiceItemInfo);
    localVoiceItemInfo = new VoiceItemInfo();
    localVoiceItemInfo.jdField_a_of_type_Int = 3;
    localVoiceItemInfo.jdField_a_of_type_JavaLangString = paramString1;
    localArrayList.add(localVoiceItemInfo);
    paramString1 = new VoiceItemInfo();
    paramString1.jdField_a_of_type_Int = 7;
    paramString1.b = 12;
    localArrayList.add(paramString1);
    paramString1 = new VoiceItemInfo();
    paramString1.jdField_a_of_type_Int = 4;
    paramString1.jdField_a_of_type_JavaLangString = paramString2;
    localArrayList.add(paramString1);
    paramString1 = new VoiceItemInfo();
    paramString1.jdField_a_of_type_Int = 7;
    paramString1.b = 12;
    localArrayList.add(paramString1);
    paramString1 = new VoiceItemInfo();
    paramString1.jdField_a_of_type_Int = 5;
    paramString1.jdField_a_of_type_JavaLangString = paramString3;
    localArrayList.add(paramString1);
    paramString1 = new VoiceItemInfo();
    paramString1.jdField_a_of_type_Int = 7;
    paramString1.b = 10;
    localArrayList.add(paramString1);
    return localArrayList;
  }
  
  public static List<VoiceItemInfo> a(String paramString, List<FriendItemInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new VoiceItemInfo();
    ((VoiceItemInfo)localObject).jdField_a_of_type_Int = 7;
    ((VoiceItemInfo)localObject).b = 40;
    localArrayList.add(localObject);
    localObject = new VoiceItemInfo();
    ((VoiceItemInfo)localObject).jdField_a_of_type_Int = 8;
    ((VoiceItemInfo)localObject).jdField_a_of_type_JavaLangString = paramString;
    localArrayList.add(localObject);
    paramString = new VoiceItemInfo();
    paramString.jdField_a_of_type_Int = 7;
    paramString.b = 12;
    localArrayList.add(paramString);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        paramString = new VoiceItemInfo();
        paramString.jdField_a_of_type_Int = 9;
        localObject = (FriendItemInfo)paramList.get(i);
        i += 1;
        ((FriendItemInfo)localObject).b = i;
        ((FriendItemInfo)localObject).c = FriendItemInfo.a(((FriendItemInfo)localObject).b);
        paramString.jdField_a_of_type_ComTencentMobileqqQassistantDataFriendItemInfo = ((FriendItemInfo)localObject);
        localArrayList.add(paramString);
      }
    }
    return localArrayList;
  }
  
  public static List<VoiceItemInfo> b(String paramString)
  {
    Resources localResources = AssistantUtils.a().getResources();
    ArrayList localArrayList = new ArrayList();
    VoiceItemInfo localVoiceItemInfo = new VoiceItemInfo();
    localVoiceItemInfo.jdField_a_of_type_Int = 7;
    localVoiceItemInfo.b = 40;
    localArrayList.add(localVoiceItemInfo);
    localVoiceItemInfo = new VoiceItemInfo();
    int i = 0;
    localVoiceItemInfo.jdField_a_of_type_Int = 0;
    localVoiceItemInfo.jdField_a_of_type_JavaLangString = paramString;
    localArrayList.add(localVoiceItemInfo);
    paramString = new VoiceItemInfo();
    paramString.jdField_a_of_type_Int = 7;
    paramString.b = 20;
    localArrayList.add(paramString);
    while (i < a.length)
    {
      paramString = new VoiceItemInfo();
      paramString.jdField_a_of_type_Int = 2;
      paramString.jdField_a_of_type_JavaLangString = localResources.getString(a[i]);
      localArrayList.add(paramString);
      paramString = new VoiceItemInfo();
      paramString.jdField_a_of_type_Int = 7;
      paramString.b = 4;
      localArrayList.add(paramString);
      i += 1;
    }
    paramString = new VoiceItemInfo();
    paramString.jdField_a_of_type_Int = 7;
    paramString.b = 6;
    localArrayList.add(paramString);
    return localArrayList;
  }
  
  public static List<VoiceItemInfo> c(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    VoiceItemInfo localVoiceItemInfo = new VoiceItemInfo();
    localVoiceItemInfo.jdField_a_of_type_Int = 7;
    localVoiceItemInfo.b = 40;
    localArrayList.add(localVoiceItemInfo);
    localVoiceItemInfo = new VoiceItemInfo();
    localVoiceItemInfo.jdField_a_of_type_Int = 0;
    localVoiceItemInfo.jdField_a_of_type_JavaLangString = paramString;
    localArrayList.add(localVoiceItemInfo);
    paramString = new VoiceItemInfo();
    paramString.jdField_a_of_type_Int = 7;
    paramString.b = 30;
    localArrayList.add(paramString);
    return localArrayList;
  }
  
  public static List<VoiceItemInfo> d(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    VoiceItemInfo localVoiceItemInfo = new VoiceItemInfo();
    localVoiceItemInfo.jdField_a_of_type_Int = 7;
    localVoiceItemInfo.b = 40;
    localArrayList.add(localVoiceItemInfo);
    localVoiceItemInfo = new VoiceItemInfo();
    localVoiceItemInfo.jdField_a_of_type_Int = 0;
    localVoiceItemInfo.jdField_a_of_type_JavaLangString = paramString;
    localArrayList.add(localVoiceItemInfo);
    paramString = new VoiceItemInfo();
    paramString.jdField_a_of_type_Int = 7;
    paramString.b = 12;
    localArrayList.add(paramString);
    paramString = new VoiceItemInfo();
    paramString.jdField_a_of_type_Int = 6;
    localArrayList.add(paramString);
    paramString = new VoiceItemInfo();
    paramString.jdField_a_of_type_Int = 7;
    paramString.b = 10;
    localArrayList.add(paramString);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.util.VoiceDataUtils
 * JD-Core Version:    0.7.0.1
 */