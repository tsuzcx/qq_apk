package com.tencent.mobileqq.qassistant.data;

import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import java.util.List;

public class VoiceDataUtils
{
  public static int[] a = { 2131720599, 2131720598 };
  
  public static String a(int paramInt)
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    String str = localResources.getString(2131720625);
    switch (paramInt)
    {
    default: 
      return str;
    case 1: 
      return localResources.getString(2131720625);
    case 2: 
      return localResources.getString(2131720610);
    }
    return localResources.getString(2131720608);
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
        ((FriendItemInfo)localObject).b = (i + 1);
        ((FriendItemInfo)localObject).c = FriendItemInfo.a(((FriendItemInfo)localObject).b);
        paramString.jdField_a_of_type_ComTencentMobileqqQassistantDataFriendItemInfo = ((FriendItemInfo)localObject);
        localArrayList.add(paramString);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static List<VoiceItemInfo> b(String paramString)
  {
    int i = 0;
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.data.VoiceDataUtils
 * JD-Core Version:    0.7.0.1
 */