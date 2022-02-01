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
  public static int[] a = { 2131917949, 2131917948 };
  
  public static String a(int paramInt)
  {
    Resources localResources = AssistantUtils.d().getResources();
    String str = localResources.getString(2131917975);
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return str;
        }
        return localResources.getString(2131917958);
      }
      return localResources.getString(2131917960);
    }
    return localResources.getString(2131917975);
  }
  
  public static List<VoiceItemInfo> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    VoiceItemInfo localVoiceItemInfo = new VoiceItemInfo();
    localVoiceItemInfo.a = 7;
    localVoiceItemInfo.c = 40;
    localArrayList.add(localVoiceItemInfo);
    localVoiceItemInfo = new VoiceItemInfo();
    localVoiceItemInfo.a = 0;
    localVoiceItemInfo.b = paramString;
    localArrayList.add(localVoiceItemInfo);
    paramString = new VoiceItemInfo();
    paramString.a = 7;
    paramString.c = 20;
    localArrayList.add(paramString);
    paramString = new VoiceItemInfo();
    paramString.a = 1;
    localArrayList.add(paramString);
    paramString = new VoiceItemInfo();
    paramString.a = 7;
    paramString.c = 10;
    localArrayList.add(paramString);
    return localArrayList;
  }
  
  public static List<VoiceItemInfo> a(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    VoiceItemInfo localVoiceItemInfo = new VoiceItemInfo();
    localVoiceItemInfo.a = 7;
    localVoiceItemInfo.c = 40;
    localArrayList.add(localVoiceItemInfo);
    localVoiceItemInfo = new VoiceItemInfo();
    localVoiceItemInfo.a = 3;
    localVoiceItemInfo.b = paramString1;
    localArrayList.add(localVoiceItemInfo);
    paramString1 = new VoiceItemInfo();
    paramString1.a = 7;
    paramString1.c = 12;
    localArrayList.add(paramString1);
    paramString1 = new VoiceItemInfo();
    paramString1.a = 4;
    paramString1.b = paramString2;
    localArrayList.add(paramString1);
    paramString1 = new VoiceItemInfo();
    paramString1.a = 7;
    paramString1.c = 12;
    localArrayList.add(paramString1);
    paramString1 = new VoiceItemInfo();
    paramString1.a = 6;
    localArrayList.add(paramString1);
    paramString1 = new VoiceItemInfo();
    paramString1.a = 7;
    paramString1.c = 10;
    localArrayList.add(paramString1);
    return localArrayList;
  }
  
  public static List<VoiceItemInfo> a(String paramString1, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList();
    VoiceItemInfo localVoiceItemInfo = new VoiceItemInfo();
    localVoiceItemInfo.a = 7;
    localVoiceItemInfo.c = 40;
    localArrayList.add(localVoiceItemInfo);
    localVoiceItemInfo = new VoiceItemInfo();
    localVoiceItemInfo.a = 3;
    localVoiceItemInfo.b = paramString1;
    localArrayList.add(localVoiceItemInfo);
    paramString1 = new VoiceItemInfo();
    paramString1.a = 7;
    paramString1.c = 12;
    localArrayList.add(paramString1);
    paramString1 = new VoiceItemInfo();
    paramString1.a = 4;
    paramString1.b = paramString2;
    localArrayList.add(paramString1);
    paramString1 = new VoiceItemInfo();
    paramString1.a = 7;
    paramString1.c = 12;
    localArrayList.add(paramString1);
    paramString1 = new VoiceItemInfo();
    paramString1.a = 5;
    paramString1.b = paramString3;
    localArrayList.add(paramString1);
    paramString1 = new VoiceItemInfo();
    paramString1.a = 7;
    paramString1.c = 10;
    localArrayList.add(paramString1);
    return localArrayList;
  }
  
  public static List<VoiceItemInfo> a(String paramString, List<FriendItemInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new VoiceItemInfo();
    ((VoiceItemInfo)localObject).a = 7;
    ((VoiceItemInfo)localObject).c = 40;
    localArrayList.add(localObject);
    localObject = new VoiceItemInfo();
    ((VoiceItemInfo)localObject).a = 8;
    ((VoiceItemInfo)localObject).b = paramString;
    localArrayList.add(localObject);
    paramString = new VoiceItemInfo();
    paramString.a = 7;
    paramString.c = 12;
    localArrayList.add(paramString);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        paramString = new VoiceItemInfo();
        paramString.a = 9;
        localObject = (FriendItemInfo)paramList.get(i);
        i += 1;
        ((FriendItemInfo)localObject).e = i;
        ((FriendItemInfo)localObject).f = FriendItemInfo.a(((FriendItemInfo)localObject).e);
        paramString.d = ((FriendItemInfo)localObject);
        localArrayList.add(paramString);
      }
    }
    return localArrayList;
  }
  
  public static List<VoiceItemInfo> b(String paramString)
  {
    Resources localResources = AssistantUtils.d().getResources();
    ArrayList localArrayList = new ArrayList();
    VoiceItemInfo localVoiceItemInfo = new VoiceItemInfo();
    localVoiceItemInfo.a = 7;
    localVoiceItemInfo.c = 40;
    localArrayList.add(localVoiceItemInfo);
    localVoiceItemInfo = new VoiceItemInfo();
    int i = 0;
    localVoiceItemInfo.a = 0;
    localVoiceItemInfo.b = paramString;
    localArrayList.add(localVoiceItemInfo);
    paramString = new VoiceItemInfo();
    paramString.a = 7;
    paramString.c = 20;
    localArrayList.add(paramString);
    while (i < a.length)
    {
      paramString = new VoiceItemInfo();
      paramString.a = 2;
      paramString.b = localResources.getString(a[i]);
      localArrayList.add(paramString);
      paramString = new VoiceItemInfo();
      paramString.a = 7;
      paramString.c = 4;
      localArrayList.add(paramString);
      i += 1;
    }
    paramString = new VoiceItemInfo();
    paramString.a = 7;
    paramString.c = 6;
    localArrayList.add(paramString);
    return localArrayList;
  }
  
  public static List<VoiceItemInfo> c(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    VoiceItemInfo localVoiceItemInfo = new VoiceItemInfo();
    localVoiceItemInfo.a = 7;
    localVoiceItemInfo.c = 40;
    localArrayList.add(localVoiceItemInfo);
    localVoiceItemInfo = new VoiceItemInfo();
    localVoiceItemInfo.a = 0;
    localVoiceItemInfo.b = paramString;
    localArrayList.add(localVoiceItemInfo);
    paramString = new VoiceItemInfo();
    paramString.a = 7;
    paramString.c = 30;
    localArrayList.add(paramString);
    return localArrayList;
  }
  
  public static List<VoiceItemInfo> d(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    VoiceItemInfo localVoiceItemInfo = new VoiceItemInfo();
    localVoiceItemInfo.a = 7;
    localVoiceItemInfo.c = 40;
    localArrayList.add(localVoiceItemInfo);
    localVoiceItemInfo = new VoiceItemInfo();
    localVoiceItemInfo.a = 0;
    localVoiceItemInfo.b = paramString;
    localArrayList.add(localVoiceItemInfo);
    paramString = new VoiceItemInfo();
    paramString.a = 7;
    paramString.c = 12;
    localArrayList.add(paramString);
    paramString = new VoiceItemInfo();
    paramString.a = 6;
    localArrayList.add(paramString);
    paramString = new VoiceItemInfo();
    paramString.a = 7;
    paramString.c = 10;
    localArrayList.add(paramString);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.util.VoiceDataUtils
 * JD-Core Version:    0.7.0.1
 */