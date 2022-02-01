package com.tencent.mobileqq.util;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.business.INearbyCardHandler;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.profilecard.utils.ProfileEntryUtils;
import com.tencent.mobileqq.utils.StringUtil;
import tencent.sso.accretion.flower_info.SFlowerInfoRsp;

public class NearbyProfileUtil
{
  public static final int[] a;
  public static final String[] a;
  public static final int[] b;
  public static final String[] b;
  public static final String[] c;
  public static final String[] d;
  public static final String[] e;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "男", "女" };
    jdField_a_of_type_ArrayOfInt = new int[] { 2130845693, 2130845701 };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "保密", "单身", "恋爱中", "已婚" };
    c = new String[] { "", "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座" };
    d = new String[] { "不限", "计算机/互联网/通信", "生产/工艺/制造", "医疗/护理/制药", "金融/银行/投资/保险", "商业/服务业/个体经营", "文化/广告/传媒", "娱乐/艺术/表演", "律师/法务", "教育/培训", "公务员/行政/事业单位", "模特", "空姐", "学生", "其他职业" };
    e = new String[] { "", "IT", "制造", "医疗", "金融", "商业", "文化", "艺术", "法律", "教育", "行政", "模特", "空姐", "学生", "" };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130846082, 2130844925, 2130844925, 2130844925, 2130845809, 2130845809, 2130846100, 2130846100, 2130845593, 2130845593, 2130845593, 2130846082, 2130846082, 2130845873, 2130846082 };
  }
  
  public static final int a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 1)) {
      return jdField_a_of_type_ArrayOfInt[paramInt];
    }
    return 0;
  }
  
  public static final int a(byte[] paramArrayOfByte)
  {
    int j = 0;
    int i = j;
    if (paramArrayOfByte != null)
    {
      flower_info.SFlowerInfoRsp localSFlowerInfoRsp = new flower_info.SFlowerInfoRsp();
      try
      {
        localSFlowerInfoRsp.mergeFrom(paramArrayOfByte);
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
      i = j;
      if (localSFlowerInfoRsp.num.has()) {
        i = localSFlowerInfoRsp.num.get();
      }
    }
    return i;
  }
  
  private static final long a()
  {
    return 38916L;
  }
  
  public static final String a(int paramInt)
  {
    if (paramInt >= 0)
    {
      String[] arrayOfString = jdField_b_of_type_ArrayOfJavaLangString;
      if (paramInt < arrayOfString.length) {
        return arrayOfString[paramInt];
      }
    }
    return "";
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_is_nearby_people_card", true);
    localBundle.putShort("key_new_profile_modified_flag", (short)1);
    localBundle.putShort("key_flower_visible_switch", (short)(paramBoolean ^ true));
    localBundle.putBoolean("key_nearby_people_card_force_update", true);
    INearbyCardHandler localINearbyCardHandler = (INearbyCardHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER);
    if (localINearbyCardHandler != null) {
      paramQQAppInterface.execute(new NearbyProfileUtil.2(localINearbyCardHandler, localBundle));
    }
  }
  
  public static final void a(INearbyCardHandler paramINearbyCardHandler, QQAppInterface paramQQAppInterface, long paramLong1, String paramString, int paramInt1, byte[] paramArrayOfByte, long paramLong2, boolean paramBoolean1, long paramLong3, boolean paramBoolean2, long paramLong4, int paramInt2)
  {
    if (paramLong1 > 0L)
    {
      if (ProfileEntryUtils.isFromFreshNews(paramInt1))
      {
        paramINearbyCardHandler.a(paramQQAppInterface.getCurrentAccountUin(), "0", 45, paramLong2, (byte)0, 0L, 0L, paramArrayOfByte, "", a(), 10004, null, paramLong1, true, paramBoolean1, paramLong3, paramBoolean2, paramLong4, paramInt2);
        return;
      }
      if (ProfileEntryUtils.isFromDating(paramInt1))
      {
        paramINearbyCardHandler.a(paramQQAppInterface.getCurrentAccountUin(), "0", 39, paramLong2, (byte)0, 0L, 0L, paramArrayOfByte, "", a(), 10004, null, paramLong1, true, paramBoolean1, paramLong3, paramBoolean2, paramLong4, paramInt2);
        return;
      }
      if (paramInt1 == 16)
      {
        paramINearbyCardHandler.a(paramQQAppInterface.getCurrentAccountUin(), "0", 46, paramLong2, (byte)0, 0L, 0L, paramArrayOfByte, "", a(), 10004, null, paramLong1, true, paramBoolean1, paramLong3, paramBoolean2, paramLong4, paramInt2);
        return;
      }
      if (paramInt1 == 38)
      {
        paramINearbyCardHandler.a(paramQQAppInterface.getCurrentAccountUin(), "0", 47, paramLong2, (byte)0, 0L, 0L, paramArrayOfByte, "", a(), 10004, null, paramLong1, true, paramBoolean1, paramLong3, paramBoolean2, paramLong4, paramInt2);
        return;
      }
      if (paramInt1 == 100)
      {
        paramINearbyCardHandler.a(paramQQAppInterface.getCurrentAccountUin(), "0", 49, paramLong2, (byte)0, 0L, 0L, paramArrayOfByte, "", a(), 10004, null, paramLong1, true, paramBoolean1, paramLong3, paramBoolean2, paramLong4, paramInt2);
        return;
      }
      if (paramInt1 == 51)
      {
        paramINearbyCardHandler.a(paramQQAppInterface.getCurrentAccountUin(), "0", 51, paramLong2, (byte)0, 0L, 0L, paramArrayOfByte, "", a(), 10004, null, paramLong1, true, paramBoolean1, paramLong3, paramBoolean2, paramLong4, paramInt2);
        return;
      }
      paramINearbyCardHandler.a(paramQQAppInterface.getCurrentAccountUin(), "0", 41, paramLong2, (byte)0, 0L, 0L, paramArrayOfByte, "", a(), 10004, null, paramLong1, true, paramBoolean1, paramLong3, paramBoolean2, paramLong4, paramInt2);
      return;
    }
    if (paramString.equals(paramQQAppInterface.getCurrentAccountUin()))
    {
      paramINearbyCardHandler.a(paramQQAppInterface.getCurrentAccountUin(), paramQQAppInterface.getCurrentAccountUin(), 0, 0L, (byte)0, 0L, 0L, null, "", a(), 10004, null, 0L, true, paramBoolean1, paramLong3, paramBoolean2, paramLong4, paramInt2);
      return;
    }
    if (ProfileEntryUtils.isFromHotChat(paramInt1)) {
      paramInt1 = 42;
    } else if (ProfileEntryUtils.isFromFreshNews(paramInt1)) {
      paramInt1 = 45;
    } else if (ProfileEntryUtils.isFromDating(paramInt1)) {
      paramInt1 = 39;
    } else if (paramInt1 == 16) {
      paramInt1 = 46;
    } else if (paramInt1 == 38) {
      paramInt1 = 47;
    } else if (paramInt1 == 51) {
      paramInt1 = 51;
    } else {
      paramInt1 = 6;
    }
    paramINearbyCardHandler.a(paramQQAppInterface.getCurrentAccountUin(), paramString, paramInt1, paramLong2, (byte)0, 0L, 0L, paramArrayOfByte, "", a(), 10004, null, 0L, true, paramBoolean1, paramLong3, paramBoolean2, paramLong4, paramInt2);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == -1) || ((paramInt >= 0) && (paramInt < d.length));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = true;
    if (paramQQAppInterface == null) {
      return true;
    }
    String str = paramQQAppInterface.getCurrentAccountUin();
    EntityManager localEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramQQAppInterface = null;
    Object localObject = null;
    if (localEntityManager != null)
    {
      paramQQAppInterface = localObject;
      if (!StringUtil.a(str)) {
        paramQQAppInterface = (NearbyPeopleCard)localEntityManager.find(NearbyPeopleCard.class, "uin=?", new String[] { str });
      }
      localEntityManager.close();
    }
    if (paramQQAppInterface != null)
    {
      if (paramQQAppInterface.switchGiftVisible == 0L) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static final int b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 14)) {
      return jdField_b_of_type_ArrayOfInt[paramInt];
    }
    return 0;
  }
  
  public static final String b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 1)) {
      return jdField_a_of_type_ArrayOfJavaLangString[paramInt];
    }
    return "";
  }
  
  public static int c(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 5) {
      return 2;
    }
    if (ProfileEntryUtils.isFromHotChat(paramInt)) {
      return 3;
    }
    if (paramInt == 21) {
      return 4;
    }
    if (ProfileEntryUtils.isFromFreshNews(paramInt)) {
      return 5;
    }
    return 99;
  }
  
  public static final String c(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 12)) {
      return c[paramInt];
    }
    return "";
  }
  
  public static final String d(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 14)) {
      return e[paramInt];
    }
    return "";
  }
  
  public static final String e(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 14)) {
      return d[paramInt];
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.NearbyProfileUtil
 * JD-Core Version:    0.7.0.1
 */