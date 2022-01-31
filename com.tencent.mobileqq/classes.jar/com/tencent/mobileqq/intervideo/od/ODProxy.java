package com.tencent.mobileqq.intervideo.od;

import advm;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.LoginKeyHelper;
import com.tencent.mobileqq.intervideo.LoginKeyHelper.AccountInfo;
import com.tencent.mobileqq.intervideo.LoginKeyHelper.GetLoginKeyListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.txproxy.InitParam;
import com.tencent.txproxy.RunPluginParams;
import com.tencent.txproxy.XPlugin;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class ODProxy
  implements LoginKeyHelper.GetLoginKeyListener, Manager
{
  long jdField_a_of_type_Long = 0L;
  advm jdField_a_of_type_Advm = new advm(this);
  private Context jdField_a_of_type_AndroidContentContext;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  IVPluginInfo jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo;
  LoginKeyHelper jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper = new LoginKeyHelper();
  XPlugin jdField_a_of_type_ComTencentTxproxyXPlugin;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  
  public ODProxy(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentTxproxyXPlugin = XPlugin.getPlugin("Od");
  }
  
  public static Bundle a(IVPluginInfo paramIVPluginInfo, LoginKeyHelper paramLoginKeyHelper)
  {
    int m = 0;
    Bundle localBundle = new Bundle();
    for (;;)
    {
      try
      {
        localObject1 = ((BaseApplicationImpl)MobileQQ.getContext()).waitAppRuntime(null);
        str2 = ((AppRuntime)localObject1).getAccount();
        localObject2 = (FriendsManager)((AppRuntime)localObject1).getManager(50);
        localObject3 = ((FriendsManager)localObject2).c(str2);
        if (localObject3 == null) {
          break label456;
        }
        localObject1 = ((Friends)localObject3).name;
        j = ((Friends)localObject3).gender;
        i = ((Friends)localObject3).age;
        localObject3 = ((FriendsManager)localObject2).a(str2);
        if (localObject3 == null) {
          break label438;
        }
        k = (int)((Card)localObject3).lBirthday;
        localObject2 = ((Card)localObject3).strCountry;
        str1 = ((Card)localObject3).strProvince;
        localObject3 = ((Card)localObject3).strCity;
      }
      catch (Exception paramIVPluginInfo)
      {
        String str2;
        paramIVPluginInfo.printStackTrace();
        return localBundle;
      }
      localBundle.putString("nickname", (String)localObject1);
      localBundle.putLong("roomid", paramIVPluginInfo.jdField_a_of_type_Long);
      localBundle.putInt("authtype", 1);
      localBundle.putString("authid", paramLoginKeyHelper.a().b);
      localBundle.putInt("gender", j);
      localBundle.putInt("vastype", 2);
      localBundle.putLong("hostid", Long.parseLong(str2));
      localBundle.putString("authkey", paramLoginKeyHelper.a().jdField_a_of_type_JavaLangString);
      localBundle.putString("appid", paramIVPluginInfo.b);
      localBundle.putString("vasname", paramIVPluginInfo.g);
      localBundle.putString("userdata", paramIVPluginInfo.d);
      localBundle.putInt("fromid", Integer.parseInt(paramIVPluginInfo.e));
      localBundle.putInt("age", i);
      localBundle.putInt("birthyear", n);
      localBundle.putInt("birthmonth", m);
      localBundle.putInt("birthday", k);
      localBundle.putBoolean("loghost", true);
      localBundle.putBoolean("reporthost", true);
      localBundle.putString("backType", paramIVPluginInfo.h);
      localBundle.putInt("isGroupCode", paramIVPluginInfo.jdField_c_of_type_Int);
      localBundle.putString("openType", paramIVPluginInfo.i);
      localBundle.putString("extra", paramIVPluginInfo.j);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localBundle.putString("addrCountry", (String)localObject2);
      }
      if (!TextUtils.isEmpty(str1)) {
        localBundle.putString("addrProv", str1);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        localBundle.putString("addrCity", (String)localObject3);
      }
      return localBundle;
      int n = k >>> 16;
      m = (0xFF00 & k) >>> 8;
      k &= 0xFF;
      continue;
      label438:
      Object localObject2 = "";
      int k = 0;
      String str1 = "";
      Object localObject3 = "";
      break label467;
      label456:
      int i = 0;
      int j = 0;
      Object localObject1 = "";
      continue;
      label467:
      if (k == 0)
      {
        n = 1995;
        k = 0;
      }
    }
  }
  
  private void c()
  {
    InitParam localInitParam = new InitParam();
    localInitParam.mPluginName = "odapp";
    localInitParam.mChannelId = String.valueOf(2);
    localInitParam.mSourceVersion = String.valueOf(ApkUtils.a(BaseApplicationImpl.getContext()));
    localInitParam.mSourceId = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localInitParam.mDefaultLoadApkActivity = "com.tencent.mobileqq.intervideo.od.ODLoadApkActivity";
    localInitParam.isDownloadInHost = true;
    localInitParam.mLoadApkActivityClazz = ODLoadApkActivity.class;
    this.jdField_a_of_type_ComTencentTxproxyXPlugin.setInitData(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), localInitParam);
  }
  
  public void a() {}
  
  public void a(Context paramContext, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    c();
    paramString1 = new IVPluginInfo();
    int i = (int)(Math.random() * 1.0D + 0.5D);
    paramString1.jdField_a_of_type_Long = paramLong;
    paramString1.e = String.valueOf(paramInt);
    paramString1.b = "1104763709";
    paramString1.jdField_c_of_type_JavaLangString = "com.tencent.mobileqq";
    paramString1.jdField_a_of_type_JavaLangString = "Od";
    paramString1.g = paramString2;
    paramString1.d = paramString3;
    a(paramContext, paramString1, true);
  }
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentTxproxyXPlugin.cancelRunPlugin(paramString);
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    b();
  }
  
  protected boolean a(Context paramContext, IVPluginInfo paramIVPluginInfo, boolean paramBoolean)
  {
    if (paramIVPluginInfo == null) {
      return false;
    }
    paramIVPluginInfo.b = "1104763709";
    paramIVPluginInfo.jdField_c_of_type_JavaLangString = "com.tencent.mobileqq";
    paramIVPluginInfo.jdField_a_of_type_JavaLangString = "Od";
    if (paramBoolean)
    {
      Intent localIntent = new Intent(paramContext, ODLoadingActivity.class);
      localIntent.putExtra("plugininfo", paramIVPluginInfo);
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localIntent.setFlags(268435456);
      paramContext.startActivity(localIntent);
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo = paramIVPluginInfo;
      this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramIVPluginInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentContext, paramIVPluginInfo.b, this);
    }
  }
  
  public void b()
  {
    try
    {
      Bundle localBundle = a(this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo, this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper);
      RunPluginParams localRunPluginParams = new RunPluginParams();
      localRunPluginParams.mRoomId = this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_a_of_type_Long;
      localRunPluginParams.mPackageName = this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.jdField_c_of_type_JavaLangString;
      localRunPluginParams.useDefaultLoading = false;
      localRunPluginParams.vasSchema = this.jdField_a_of_type_ComTencentMobileqqIntervideoIVPluginInfo.f;
      Intent localIntent = new Intent();
      localIntent.putExtras(localBundle);
      localRunPluginParams.intent = localIntent;
      this.jdField_a_of_type_ComTencentTxproxyXPlugin.runPlugin(localRunPluginParams);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("XProxy|ODPROXY", 2, "onDestroy");
    }
    a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.od.ODProxy
 * JD-Core Version:    0.7.0.1
 */