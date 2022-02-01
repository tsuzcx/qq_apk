package com.tencent.mobileqq.vip;

import MQQ.VipUserInfo;
import VIP.AIOSendRes;
import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class AioVipDonateHelper
{
  public static int a = 1;
  private static AioVipDonateHelper jdField_a_of_type_ComTencentMobileqqVipAioVipDonateHelper;
  public static String a = "aioVipDonateInfoSpFile_";
  public static int b = 1;
  public static String b = "lastCheckTime_";
  public static String c = "sendDisable";
  public static String d = "checkFreq";
  public static String e = "grayTail";
  public static String f = "sendList";
  public static String g = "popGraytips";
  public static String h = "graytips";
  public static String i = "hightLight";
  public static String j = "jumpUrl";
  public static String k = "";
  private List<String> jdField_a_of_type_JavaUtilList = null;
  private int c;
  private int d;
  private int e;
  private String l = null;
  private String m;
  private String n;
  private String o;
  
  public AioVipDonateHelper()
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
  }
  
  public static AioVipDonateHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqVipAioVipDonateHelper == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqVipAioVipDonateHelper == null) {
          jdField_a_of_type_ComTencentMobileqqVipAioVipDonateHelper = new AioVipDonateHelper();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqVipAioVipDonateHelper;
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences(jdField_a_of_type_JavaLangString, 0).edit();
    paramQQAppInterface.putInt(g, this.jdField_e_of_type_Int);
    if (!TextUtils.isEmpty(this.m)) {
      paramQQAppInterface.putString(h, this.m);
    }
    if (!TextUtils.isEmpty(this.n)) {
      paramQQAppInterface.putString(i, this.n);
    }
    if (!TextUtils.isEmpty(this.o)) {
      paramQQAppInterface.putString(j, this.o);
    }
    paramQQAppInterface.apply();
  }
  
  public long a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return -1L;
    }
    if (this.jdField_d_of_type_Int == -1)
    {
      MobileQQ localMobileQQ = paramQQAppInterface.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
      this.jdField_d_of_type_Int = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).getInt(jdField_d_of_type_JavaLangString, -1);
    }
    return this.jdField_d_of_type_Int * 60 * 1000;
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    if (TextUtils.isEmpty(this.m))
    {
      MobileQQ localMobileQQ = paramQQAppInterface.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
      this.m = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).getString(h, null);
    }
    return this.m;
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    this.jdField_e_of_type_Int = paramInt;
    MobileQQ localMobileQQ = paramQQAppInterface.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    paramQQAppInterface = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).edit();
    paramQQAppInterface.putInt(g, paramInt);
    if (Build.VERSION.SDK_INT < 9)
    {
      paramQQAppInterface.commit();
      return;
    }
    paramQQAppInterface.apply();
  }
  
  @TargetApi(9)
  public void a(QQAppInterface paramQQAppInterface, VipUserInfo paramVipUserInfo)
  {
    if (paramQQAppInterface != null)
    {
      if (paramVipUserInfo == null) {
        return;
      }
      Object localObject1 = paramQQAppInterface.getCurrentAccountUin();
      paramQQAppInterface = paramQQAppInterface.getApplication();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject2).toString();
      int i2 = 0;
      paramQQAppInterface = paramQQAppInterface.getSharedPreferences((String)localObject1, 0).edit();
      this.jdField_c_of_type_Int = paramVipUserInfo.iSendDisable;
      this.jdField_d_of_type_Int = paramVipUserInfo.iCheckFreq;
      if (!TextUtils.isEmpty(paramVipUserInfo.sGrayTail))
      {
        this.l = paramVipUserInfo.sGrayTail;
        paramQQAppInterface.putString(jdField_e_of_type_JavaLangString, paramVipUserInfo.sGrayTail);
      }
      if ((paramVipUserInfo.vSendList != null) && (paramVipUserInfo.vSendList.size() > 0))
      {
        localObject1 = new StringBuilder();
        int i1 = i2;
        if (this.jdField_a_of_type_JavaUtilList == null)
        {
          this.jdField_a_of_type_JavaUtilList = new ArrayList();
          i1 = i2;
        }
        while (i1 < paramVipUserInfo.vSendList.size())
        {
          localObject2 = String.valueOf(paramVipUserInfo.vSendList.get(i1));
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(",");
          this.jdField_a_of_type_JavaUtilList.add(localObject2);
          i1 += 1;
        }
        paramQQAppInterface.putString(f, ((StringBuilder)localObject1).toString());
      }
      paramQQAppInterface.putInt(jdField_c_of_type_JavaLangString, this.jdField_c_of_type_Int);
      paramQQAppInterface.putInt(jdField_d_of_type_JavaLangString, this.jdField_d_of_type_Int);
      if (Build.VERSION.SDK_INT < 9)
      {
        paramQQAppInterface.commit();
        return;
      }
      paramQQAppInterface.apply();
    }
  }
  
  @TargetApi(9)
  public void a(QQAppInterface paramQQAppInterface, AIOSendRes paramAIOSendRes)
  {
    if (paramQQAppInterface != null)
    {
      if (paramAIOSendRes == null) {
        return;
      }
      this.jdField_e_of_type_Int = paramAIOSendRes.iPopGrayStip;
      this.m = paramAIOSendRes.sGrayStipMsg;
      paramAIOSendRes = paramAIOSendRes.mHighLightMap;
      if ((paramAIOSendRes != null) && (paramAIOSendRes.size() > 0))
      {
        this.n = ((String)paramAIOSendRes.keySet().iterator().next());
        if (!TextUtils.isEmpty(this.n)) {
          this.o = ((String)paramAIOSendRes.get(this.n));
        }
      }
      a(paramQQAppInterface);
      if (this.jdField_e_of_type_Int == b)
      {
        paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
        if (paramQQAppInterface != null) {
          paramQQAppInterface.sendMessage(paramQQAppInterface.obtainMessage(58));
        }
      }
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    if (paramQQAppInterface == null) {
      return false;
    }
    if (this.jdField_c_of_type_Int == -1)
    {
      MobileQQ localMobileQQ = paramQQAppInterface.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
      this.jdField_c_of_type_Int = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).getInt(jdField_c_of_type_JavaLangString, -1);
    }
    if (this.jdField_c_of_type_Int == jdField_a_of_type_Int) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      if (this.jdField_a_of_type_JavaUtilList.size() < 1)
      {
        MobileQQ localMobileQQ = paramQQAppInterface.getApplication();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(jdField_a_of_type_JavaLangString);
        localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
        paramQQAppInterface = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).getString(f, null);
        if (!TextUtils.isEmpty(paramQQAppInterface))
        {
          paramQQAppInterface = paramQQAppInterface.split(",");
          int i1 = 0;
          while (i1 < paramQQAppInterface.length)
          {
            localMobileQQ = paramQQAppInterface[i1];
            if (!TextUtils.isEmpty(localMobileQQ)) {
              this.jdField_a_of_type_JavaUtilList.add(localMobileQQ.trim());
            }
            i1 += 1;
          }
        }
      }
      paramQQAppInterface = this.jdField_a_of_type_JavaUtilList;
      if ((paramQQAppInterface != null) && (paramQQAppInterface.contains(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  public String b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    if (TextUtils.isEmpty(this.n))
    {
      MobileQQ localMobileQQ = paramQQAppInterface.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
      this.n = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).getString(i, null);
    }
    return this.n;
  }
  
  public boolean b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    String str = paramQQAppInterface.getCurrentAccountUin();
    MobileQQ localMobileQQ;
    if (TextUtils.isEmpty(this.l))
    {
      localMobileQQ = paramQQAppInterface.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
      this.l = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).getString(jdField_e_of_type_JavaLangString, null);
    }
    if (!TextUtils.isEmpty(this.l))
    {
      paramQQAppInterface = this.l.split(",");
      int i1 = 0;
      while (i1 < paramQQAppInterface.length)
      {
        localMobileQQ = paramQQAppInterface[i1];
        if ((!TextUtils.isEmpty(localMobileQQ)) && (str.endsWith(localMobileQQ.trim()))) {
          return true;
        }
        i1 += 1;
      }
    }
    return false;
  }
  
  public String c(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    if (TextUtils.isEmpty(this.o))
    {
      MobileQQ localMobileQQ = paramQQAppInterface.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
      this.o = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).getString(j, k);
    }
    return this.o;
  }
  
  public boolean c(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    if (paramQQAppInterface == null) {
      return false;
    }
    if (this.jdField_e_of_type_Int == -1)
    {
      MobileQQ localMobileQQ = paramQQAppInterface.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
      this.jdField_e_of_type_Int = localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).getInt(g, 0);
    }
    if (this.jdField_e_of_type_Int == b) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.AioVipDonateHelper
 * JD-Core Version:    0.7.0.1
 */