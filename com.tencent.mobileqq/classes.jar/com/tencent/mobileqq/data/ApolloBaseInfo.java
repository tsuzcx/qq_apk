package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.data.ApolloDress;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApolloBaseInfo
  extends Entity
{
  public static final int MASK_EMOTICON_ACTION = 16;
  public int apolloAISwitch;
  public String apolloDataBuffer;
  @notColumn
  private ApolloDress apolloDress;
  @notColumn
  private ApolloDress apolloHistory;
  public String apolloHistoryDress;
  public long apolloLocalSignTs;
  public long apolloLocalTS;
  @notColumn
  private ApolloDress apolloPetDress;
  public long apolloServerTS;
  public String apolloSignStr;
  public long apolloSignValidTS;
  public int apolloStatus;
  public long apolloUpdateTime;
  public int apolloVipFlag;
  public int apolloVipLevel;
  public String appearAction;
  public boolean hasPet;
  public String petNick;
  @unique
  public String uin;
  public int uinType;
  
  public static int calcSelfMemorySize()
  {
    return 284;
  }
  
  public static void saveSelfApolloDress(AppInterface paramAppInterface, String paramString)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    for (;;)
    {
      Object localObject2;
      ApolloBaseInfo localApolloBaseInfo;
      ApolloDress localApolloDress;
      try
      {
        long l = new JSONObject(paramString).optLong("ts");
        localObject2 = (ApolloManager)paramAppInterface.getManager(152);
        localApolloBaseInfo = ((ApolloManager)localObject2).b(paramAppInterface.getCurrentAccountUin());
        localApolloDress = localApolloBaseInfo.getApolloDress();
        localApolloBaseInfo.setApolloDress(l, paramString);
        localObject1 = localApolloBaseInfo.getApolloDress();
        if (localApolloDress != null) {
          break label218;
        }
        paramString = "";
      }
      catch (Exception paramAppInterface) {}
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.equals(paramString, (CharSequence)localObject1))) {
        localApolloBaseInfo.apolloHistoryDress = paramString;
      }
      localApolloBaseInfo.appearAction = null;
      ((ApolloManager)localObject2).a(localApolloBaseInfo);
      paramAppInterface = (ApolloManager)paramAppInterface.getManager(152);
      if (paramAppInterface != null)
      {
        localObject2 = new ArrayList(1);
        ((List)localObject2).add(localApolloBaseInfo);
        paramAppInterface.a((List)localObject2);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloBaseInfo", 2, "save history self dress: " + paramString + ", new dres: " + (String)localObject1);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("ApolloBaseInfo", 2, paramAppInterface.getMessage());
      return;
      label218:
      paramString = localApolloDress.a();
      while (localObject1 != null)
      {
        localObject1 = ((ApolloDress)localObject1).a();
        break;
      }
      Object localObject1 = "";
    }
  }
  
  public int getAISwitch()
  {
    return this.apolloAISwitch & 0x3;
  }
  
  public ApolloDress getApolloDress()
  {
    if ((this.apolloDress == null) && (!TextUtils.isEmpty(this.apolloDataBuffer))) {
      this.apolloDress = ApolloDress.a(this.apolloDataBuffer);
    }
    return this.apolloDress;
  }
  
  public ApolloDress[] getApolloDress(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(2);
    if ((this.apolloDress == null) && (!TextUtils.isEmpty(this.apolloDataBuffer))) {
      this.apolloDress = ApolloDress.a(this.apolloDataBuffer);
    }
    if (this.apolloDress != null) {
      localArrayList.add(this.apolloDress);
    }
    String[] arrayOfString;
    int i;
    if ((this.apolloDress != null) && (!paramBoolean) && (!TextUtils.isEmpty(this.apolloHistoryDress))) {
      if (this.apolloHistory == null)
      {
        this.apolloHistory = new ApolloDress();
        this.apolloHistory.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        arrayOfString = this.apolloHistoryDress.split("\\|");
        i = 0;
      }
    }
    for (;;)
    {
      try
      {
        if (i < arrayOfString.length)
        {
          Integer localInteger = Integer.valueOf(Integer.parseInt(arrayOfString[i]));
          if (i == 0) {
            this.apolloHistory.jdField_a_of_type_Int = localInteger.intValue();
          } else {
            this.apolloHistory.jdField_a_of_type_JavaUtilHashMap.put(localInteger, null);
          }
        }
      }
      catch (Exception localException)
      {
        this.apolloHistory = null;
      }
      for (;;)
      {
        if (this.apolloHistory != null) {
          localArrayList.add(this.apolloHistory);
        }
        if (localArrayList.size() != 0) {
          break;
        }
        return null;
        localArrayList.add(this.apolloHistory);
      }
      return (ApolloDress[])localArrayList.toArray(new ApolloDress[0]);
      i += 1;
    }
  }
  
  public ApolloDress getApolloPetDress()
  {
    if ((this.apolloPetDress == null) && (!TextUtils.isEmpty(this.apolloDataBuffer))) {
      this.apolloPetDress = ApolloDress.b(this.apolloDataBuffer);
    }
    return this.apolloPetDress;
  }
  
  public boolean isAIWhiteUser()
  {
    return 1 == (this.apolloAISwitch >> 2 & 0x1);
  }
  
  public boolean isApolloEmoticonWhiteUser()
  {
    return (this.apolloAISwitch & 0x10) == 16;
  }
  
  public boolean isApolloGameWhiteUser()
  {
    return 1 == (this.apolloAISwitch >> 8 & 0x1);
  }
  
  public void setApolloDress(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("apollo_pet", 2, "setApolloDress:" + paramString);
    }
    this.apolloServerTS = paramLong;
    this.apolloLocalTS = paramLong;
    this.apolloDataBuffer = paramString;
    this.apolloHistory = null;
    this.apolloDress = null;
    this.apolloUpdateTime = NetConnInfoCenter.getServerTime();
    this.apolloDress = ApolloDress.a(this.apolloDataBuffer);
    this.apolloPetDress = ApolloDress.b(this.apolloDataBuffer);
    try
    {
      paramString = new JSONObject(this.apolloDataBuffer).optJSONArray("petList");
      if ((paramString != null) && (paramString.length() > 0))
      {
        this.hasPet = true;
        this.petNick = paramString.getJSONObject(0).optString("strBrand");
        return;
      }
      this.hasPet = false;
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ApolloBaseInfo", 1, "parse pet nick error:", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.ApolloBaseInfo
 * JD-Core Version:    0.7.0.1
 */