package com.tencent.mobileqq.data;

import aifg;
import aiju;
import aijv;
import aitw;
import android.text.TextUtils;
import atmo;
import atnz;
import atoc;
import bcdu;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApolloBaseInfo
  extends atmo
{
  public static final int MASK_3D = 1;
  public static final int MASK_3D_WHITELIST = 2;
  public static final int MASK_EMOTICON_ACTION = 16;
  private static final String TAG = "ApolloBaseInfo";
  public int apolloAISwitch;
  public String apolloDataBuffer;
  @atnz
  private aiju apolloDress;
  @atnz
  private aiju apolloHistory;
  public String apolloHistoryDress;
  public long apolloLocalSignTs;
  public long apolloLocalTS;
  @atnz
  private aiju apolloPetDress;
  public long apolloServerTS;
  public String apolloSignStr;
  public long apolloSignValidTS;
  public int apolloStatus;
  public long apolloUpdateTime;
  public int apolloVipFlag;
  public int apolloVipLevel;
  public String appearAction;
  public int cmshow3dFlag;
  public boolean hasPet;
  public String mApollo3DDataBuffer;
  @atnz
  private aiju mApolloDress3D;
  public String petNick;
  @atoc
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
      aiju localaiju;
      try
      {
        long l = new JSONObject(paramString).optLong("ts");
        localObject2 = (aifg)paramAppInterface.getManager(153);
        localApolloBaseInfo = ((aifg)localObject2).b(paramAppInterface.getCurrentAccountUin());
        localaiju = localApolloBaseInfo.getApolloDress();
        localApolloBaseInfo.setApolloDress(l, paramString);
        localObject1 = localApolloBaseInfo.getApolloDress();
        if (localaiju != null) {
          break label218;
        }
        paramString = "";
      }
      catch (Exception paramAppInterface) {}
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.equals(paramString, (CharSequence)localObject1))) {
        localApolloBaseInfo.apolloHistoryDress = paramString;
      }
      localApolloBaseInfo.appearAction = null;
      ((aifg)localObject2).a(localApolloBaseInfo);
      paramAppInterface = (aifg)paramAppInterface.getManager(153);
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
      paramString = localaiju.a();
      while (localObject1 != null)
      {
        localObject1 = ((aiju)localObject1).a();
        break;
      }
      Object localObject1 = "";
    }
  }
  
  public int getAISwitch()
  {
    return this.apolloAISwitch & 0x3;
  }
  
  public aiju getApolloDress()
  {
    if ((this.apolloDress == null) && (!TextUtils.isEmpty(this.apolloDataBuffer))) {
      this.apolloDress = aiju.a(this.apolloDataBuffer);
    }
    return this.apolloDress;
  }
  
  public aiju[] getApolloDress(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(2);
    if ((this.apolloDress == null) && (!TextUtils.isEmpty(this.apolloDataBuffer))) {
      this.apolloDress = aiju.a(this.apolloDataBuffer);
    }
    if (this.apolloDress != null) {
      localArrayList.add(this.apolloDress);
    }
    String[] arrayOfString;
    int i;
    if ((this.apolloDress != null) && (!paramBoolean) && (!TextUtils.isEmpty(this.apolloHistoryDress))) {
      if (this.apolloHistory == null)
      {
        this.apolloHistory = new aiju();
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
      return (aiju[])localArrayList.toArray(new aiju[0]);
      i += 1;
    }
  }
  
  public aiju getApolloDress3D()
  {
    if ((this.mApolloDress3D == null) && (!TextUtils.isEmpty(this.mApollo3DDataBuffer))) {}
    try
    {
      this.mApolloDress3D = aiju.a(new JSONObject(this.mApollo3DDataBuffer));
      return this.mApolloDress3D;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ApolloBaseInfo", 1, "getApolloDress3D " + localException);
      }
    }
  }
  
  public aiju getApolloPetDress()
  {
    if ((this.apolloPetDress == null) && (!TextUtils.isEmpty(this.apolloDataBuffer))) {
      this.apolloPetDress = aiju.b(this.apolloDataBuffer);
    }
    return this.apolloPetDress;
  }
  
  public JSONArray getDress3D(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    Iterator localIterator1 = null;
    getApolloDress3D();
    Object localObject = localIterator1;
    ArrayList localArrayList;
    if (this.mApolloDress3D != null)
    {
      localObject = localIterator1;
      if (this.mApolloDress3D.jdField_a_of_type_JavaUtilHashMap != null)
      {
        localObject = localIterator1;
        if (!this.mApolloDress3D.jdField_a_of_type_JavaUtilHashMap.isEmpty())
        {
          Iterator localIterator2 = this.mApolloDress3D.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
          localObject = new JSONArray();
          localArrayList = new ArrayList();
          while (localIterator2.hasNext())
          {
            aijv localaijv = (aijv)((Map.Entry)localIterator2.next()).getValue();
            ((JSONArray)localObject).put(String.valueOf(localaijv.jdField_a_of_type_Int));
            if (!ApolloUtil.b(localaijv.jdField_a_of_type_Int)) {
              localArrayList.add(Integer.valueOf(localaijv.jdField_a_of_type_Int));
            }
          }
          if (!paramBoolean) {
            break label272;
          }
          if (!localArrayList.isEmpty()) {
            break label176;
          }
        }
      }
    }
    label176:
    do
    {
      return localObject;
      QLog.i("ApolloBaseInfo", 1, "getDress3D checkExistAndDownload but no exist, start download");
      localObject = localIterator1;
    } while (localArrayList.size() <= 0);
    localObject = new int[localArrayList.size()];
    localIterator1 = localArrayList.iterator();
    int i = 0;
    while (localIterator1.hasNext())
    {
      localObject[i] = ((Integer)localIterator1.next()).intValue();
      i += 1;
    }
    aitw.b(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), null, -1, (int[])localObject, -1, -1, true);
    return null;
    label272:
    return localObject;
  }
  
  public JSONObject getFaceModel(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    getApolloDress3D();
    if ((this.mApolloDress3D != null) && (!TextUtils.isEmpty(this.mApolloDress3D.jdField_a_of_type_JavaLangString))) {
      try
      {
        String str = bcdu.d(this.mApolloDress3D.jdField_a_of_type_JavaLangString);
        if (paramBoolean)
        {
          if (ApolloUtil.d(this.mApolloDress3D.jdField_a_of_type_JavaLangString))
          {
            paramQQAppInterface = new JSONObject();
            paramQQAppInterface.put("path", "/face/" + str + File.separator);
            return paramQQAppInterface;
          }
          aitw.a(paramQQAppInterface, this.mApolloDress3D.jdField_a_of_type_JavaLangString, null);
          return null;
        }
        paramQQAppInterface = new JSONObject();
        paramQQAppInterface.put("path", "/face/" + str + File.separator);
        return paramQQAppInterface;
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("ApolloBaseInfo", 1, "getFaceModel e" + paramQQAppInterface);
      }
    }
    return null;
  }
  
  public String getModel()
  {
    if ((this.cmshow3dFlag & 0x1) == 1) {
      return "3D";
    }
    return "2D";
  }
  
  public int getRole3D(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    int j = -1;
    getApolloDress3D();
    int i = j;
    if (this.mApolloDress3D != null)
    {
      i = j;
      if (this.mApolloDress3D.jdField_a_of_type_Int > 0)
      {
        if (!paramBoolean) {
          break label89;
        }
        if (!ApolloUtil.c(this.mApolloDress3D.jdField_a_of_type_Int)) {
          break label58;
        }
        i = this.mApolloDress3D.jdField_a_of_type_Int;
      }
    }
    return i;
    label58:
    QLog.i("ApolloBaseInfo", 1, "getRole3D checkExistAndDownload but no exist, start download");
    aitw.b(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), null, this.mApolloDress3D.jdField_a_of_type_Int, null, -1, -1, true);
    return -1;
    label89:
    return this.mApolloDress3D.jdField_a_of_type_Int;
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
  
  public boolean isApolloStatusOpen()
  {
    return aifg.a(this);
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
    this.apolloDress = aiju.a(this.apolloDataBuffer);
    this.apolloPetDress = aiju.b(this.apolloDataBuffer);
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
  
  public void setApolloDress3D(AppInterface paramAppInterface, JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (paramAppInterface == null)) {
      return;
    }
    if ((QLog.isColorLevel()) || (this.uin.equals(paramAppInterface.getCurrentAccountUin()))) {
      QLog.d("ApolloBaseInfo", 1, "setApolloDress3D:" + paramJSONObject.toString());
    }
    long l = paramJSONObject.optLong("ts");
    if (this.apolloLocalTS <= l)
    {
      this.apolloServerTS = l;
      this.apolloLocalTS = l;
    }
    for (;;)
    {
      this.mApollo3DDataBuffer = paramJSONObject.toString();
      this.mApolloDress3D = aiju.a(paramJSONObject);
      return;
      QLog.e("ApolloBaseInfo", 1, "setApolloDress3D apolloLocalTS > ts apolloLocalTS:" + this.apolloLocalTS + " apolloServerTS:" + this.apolloServerTS + " ts:" + l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.ApolloBaseInfo
 * JD-Core Version:    0.7.0.1
 */