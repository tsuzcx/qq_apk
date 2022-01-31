package com.tencent.mobileqq.intervideo.huayang;

import adua;
import adub;
import adul;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.LoginKeyHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;

public class HuayangDowanloadHelper
{
  private static HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private long jdField_a_of_type_Long;
  private adul jdField_a_of_type_Adul = new adua(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private LoginKeyHelper jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper = new LoginKeyHelper();
  private HuayangPluginNewDownloader jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangPluginNewDownloader;
  private String jdField_a_of_type_JavaLangString;
  private Map jdField_a_of_type_JavaUtilMap;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  
  private HuayangDowanloadHelper(Context paramContext, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.d = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangPluginNewDownloader = HuayangPluginNewDownloader.a(paramContext, paramString1, paramString2);
  }
  
  public static HuayangDowanloadHelper a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      String str = paramString2 + paramString1;
      HuayangDowanloadHelper localHuayangDowanloadHelper2 = (HuayangDowanloadHelper)jdField_a_of_type_JavaUtilHashMap.get(str);
      HuayangDowanloadHelper localHuayangDowanloadHelper1 = localHuayangDowanloadHelper2;
      if (localHuayangDowanloadHelper2 == null)
      {
        localHuayangDowanloadHelper1 = new HuayangDowanloadHelper(paramContext, paramString1, paramString2);
        jdField_a_of_type_JavaUtilHashMap.put(str, localHuayangDowanloadHelper1);
      }
      return localHuayangDowanloadHelper1;
    }
    finally {}
  }
  
  private void a(InstalledPlugin paramInstalledPlugin, boolean paramBoolean)
  {
    IVPluginInfo localIVPluginInfo = (IVPluginInfo)this.jdField_a_of_type_JavaUtilMap.get(paramInstalledPlugin.pluginPackageName);
    if (QLog.isColorLevel()) {
      QLog.d("HuayangPluginNewDownloader", 2, "开始拉取AI票据：" + localIVPluginInfo.jdField_a_of_type_Int);
    }
    paramInstalledPlugin = new adub(this, this.d, localIVPluginInfo, paramInstalledPlugin, paramBoolean);
    if (localIVPluginInfo.jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper.a(this.jdField_a_of_type_JavaLangString, localIVPluginInfo.jdField_a_of_type_JavaLangString, localIVPluginInfo.c, localIVPluginInfo.jdField_b_of_type_JavaLangString, paramInstalledPlugin, true, localIVPluginInfo.k);
    }
    while (localIVPluginInfo.jdField_a_of_type_Int != 2) {
      return;
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    AppInterface localAppInterface = (AppInterface)((BaseApplicationImpl)MobileQQ.getContext()).waitAppRuntime(null);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper.a(localAppInterface, localIVPluginInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentContext, localIVPluginInfo.jdField_b_of_type_JavaLangString, paramInstalledPlugin);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangPluginNewDownloader.a(null);
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = null;
    this.c = null;
    if (!NetworkUtil.a(this.jdField_a_of_type_AndroidContentContext)) {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangPluginNewDownloader.a();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, Map paramMap)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangPluginNewDownloader.jdField_a_of_type_JavaLangString = paramString2;
    if (!paramString2.equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoLoginKeyHelper.b();
    }
    Monitor.a = TextUtils.equals(paramString1, "hy_sixgod");
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_JavaLangString = paramString3;
    this.c = paramString4;
    this.e = paramString1;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangPluginNewDownloader.a(this.jdField_a_of_type_Adul);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoHuayangHuayangPluginNewDownloader.a(paramString1, paramString4, this.d, paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangDowanloadHelper
 * JD-Core Version:    0.7.0.1
 */