package com.tencent.mobileqq.troop.honor.util;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.troop.honor.config.TroopHonor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.troop.honor.troop_honor.GroupUserCardHonor;

public class TroopHonorUtils
{
  public static byte a(PBUInt32Field paramPBUInt32Field)
  {
    if (paramPBUInt32Field.has()) {}
    for (int i = paramPBUInt32Field.get();; i = -96) {
      return (byte)i;
    }
  }
  
  public static int a(int paramInt, byte paramByte)
  {
    if (paramByte == 0) {
      return 0;
    }
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return paramByte >> 0 & 0x3;
    case 2: 
    case 3: 
      return paramByte >> 2 & 0x3;
    }
    return paramByte >> 4 & 0x3;
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    return "https://static-res.qq.com/static-res/groupInteract/vas/a/" + paramInt1 + "_" + paramInt2 + ".png";
  }
  
  public static String a(List<Integer> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = 0;
      while (i < paramList.size())
      {
        localStringBuilder.append(paramList.get(i));
        if (i != paramList.size() - 1) {
          localStringBuilder.append("|");
        }
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    if ((paramAppRuntime == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    return c(((ITroopHonorService)paramAppRuntime.getRuntimeService(ITroopHonorService.class, "")).getTroopHonorList(paramString1, paramString2));
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    localObject = null;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return "";
    }
    try
    {
      troop_honor.GroupUserCardHonor localGroupUserCardHonor = new troop_honor.GroupUserCardHonor();
      localGroupUserCardHonor.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = localObject;
      if (localGroupUserCardHonor.id.has()) {
        paramArrayOfByte = localGroupUserCardHonor.id.get();
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        QLog.d("TroopHonor.utils", 1, "parseRspToHonorList", paramArrayOfByte);
        paramArrayOfByte = localObject;
      }
    }
    return a(paramArrayOfByte);
  }
  
  public static List<Integer> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    ArrayList localArrayList;
    String[] arrayOfString;
    do
    {
      return paramString;
      localArrayList = new ArrayList();
      arrayOfString = paramString.split("\\|");
      paramString = localArrayList;
    } while (arrayOfString.length <= 0);
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      paramString = localArrayList;
      if (i >= j) {
        break;
      }
      paramString = arrayOfString[i];
      try
      {
        localArrayList.add(Integer.valueOf(paramString));
        i += 1;
      }
      catch (NumberFormatException paramString)
      {
        for (;;)
        {
          QLog.d("TroopHonor.utils", 1, "convertStrToHonorList", paramString);
        }
      }
    }
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    if (paramLong1 != 1L) {}
    while ((paramLong2 != 1003L) && (paramLong2 != 1004L) && (paramLong2 != 1005L) && (paramLong2 != 1006L) && (paramLong2 != 1021L)) {
      return false;
    }
    return true;
  }
  
  public static String b(List<TroopHonor> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      localStringBuilder.append(((TroopHonor)paramList.get(i)).jdField_a_of_type_Int);
      if (i != paramList.size() - 1) {
        localStringBuilder.append("|");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String c(List<TroopHonor> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localStringBuilder.append(((TroopHonor)paramList.next()).jdField_a_of_type_JavaLangString);
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.honor.util.TroopHonorUtils
 * JD-Core Version:    0.7.0.1
 */