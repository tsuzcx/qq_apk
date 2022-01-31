package com.tencent.mobileqq.microapp.apkg;

import Wallet.ApkgConfig;
import ajyc;
import android.text.TextUtils;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.FormSimpleItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ApkgDebugConstants
{
  public static Map<String, ApkgConfig> sAppConfigs = new HashMap();
  
  static
  {
    addTestConfig("debug_785853827_1_2103531609", "测试小程序1");
  }
  
  public static void addTestConfig(String paramString1, String paramString2)
  {
    ApkgConfig localApkgConfig = new ApkgConfig();
    localApkgConfig.mini_appid = paramString1;
    localApkgConfig.app_name = paramString2;
    localApkgConfig.mini_version = -1;
    localApkgConfig.icon_url = "https://i.gtimg.cn/channel/imglib/201805/upload_d6e388265a3806c16280b38b9dc3cb51.png";
    localApkgConfig.apkg_url = "https://i.gtimg.cn/channel/imglib/201805/upload_d6e388265a3806c16280b38b9dc3cb51.png";
    sAppConfigs.put(paramString1, localApkgConfig);
  }
  
  public static MiniAppConfig getMiniAppConfig(String paramString, QQAppInterface paramQQAppInterface)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramQQAppInterface != null))
    {
      paramString = (ApkgConfig)sAppConfigs.get(paramString);
      if (paramString != null) {
        return new MiniAppConfig(paramString, ((ApkgConfigManager)paramQQAppInterface.getManager(287)).getBaseLibInfo());
      }
    }
    return null;
  }
  
  public static void handleMiniAppDebugView(LinearLayout paramLinearLayout)
  {
    if ((paramLinearLayout != null) && (paramLinearLayout.getContext() != null) && (sAppConfigs.size() > 0))
    {
      Iterator localIterator = sAppConfigs.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        FormSimpleItem localFormSimpleItem = new FormSimpleItem(paramLinearLayout.getContext());
        localFormSimpleItem.setLeftText(ajyc.a(2131700276) + ((ApkgConfig)localEntry.getValue()).app_name);
        localFormSimpleItem.setOnClickListener(new ApkgDebugConstants.1(paramLinearLayout, localEntry));
        paramLinearLayout.addView(localFormSimpleItem);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.ApkgDebugConstants
 * JD-Core Version:    0.7.0.1
 */