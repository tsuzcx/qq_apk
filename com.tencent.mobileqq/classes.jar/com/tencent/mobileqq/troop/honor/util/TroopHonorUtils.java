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
    int i;
    if (paramPBUInt32Field.has()) {
      i = paramPBUInt32Field.get();
    } else {
      i = -96;
    }
    return (byte)i;
  }
  
  public static int a(int paramInt, byte paramByte)
  {
    if (paramByte == 0) {
      return 0;
    }
    if (paramInt != 1) {
      if ((paramInt != 2) && (paramInt != 3))
      {
        if (paramInt != 4) {
          return 0;
        }
        paramInt = paramByte >> 4;
      }
    }
    for (;;)
    {
      return paramInt & 0x3;
      paramInt = paramByte >> 2;
      continue;
      paramInt = paramByte >> 0;
    }
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://static-res.qq.com/static-res/groupInteract/vas/a/");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(".png");
    return localStringBuilder.toString();
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
    if ((paramAppRuntime != null) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return "";
      }
      return c(((ITroopHonorService)paramAppRuntime.getRuntimeService(ITroopHonorService.class, "")).getTroopHonorList(paramString1, paramString2));
    }
    return "";
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      Object localObject = null;
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
        paramArrayOfByte.printStackTrace();
        QLog.d("TroopHonor.utils", 1, "parseRspToHonorList", paramArrayOfByte);
        paramArrayOfByte = localObject;
      }
      return a(paramArrayOfByte);
    }
    return "";
  }
  
  public static List<Integer> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramString = paramString.split("\\|");
    if (paramString.length > 0)
    {
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramString[i];
        try
        {
          localArrayList.add(Integer.valueOf(str));
        }
        catch (NumberFormatException localNumberFormatException)
        {
          QLog.d("TroopHonor.utils", 1, "convertStrToHonorList", localNumberFormatException);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    if (paramLong1 != 1L) {
      return false;
    }
    return (paramLong2 == 1003L) || (paramLong2 == 1004L) || (paramLong2 == 1005L) || (paramLong2 == 1006L) || (paramLong2 == 1021L);
  }
  
  public static String b(List<TroopHonor> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
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
    return "";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.honor.util.TroopHonorUtils
 * JD-Core Version:    0.7.0.1
 */