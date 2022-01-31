package com.tencent.mobileqq.search.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.olympic.utils.OlympicUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class SearchConfigUtils
{
  public static String a;
  
  public static int a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    return localBaseApplicationImpl.getSharedPreferences("SearchConfigUtils_Switch" + localBaseApplicationImpl.getRuntime().getAccount(), 4).getInt("search_url_config_version" + localBaseApplicationImpl.getRuntime().getAccount(), 0);
  }
  
  public static int a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      return 1;
      paramString = BaseApplicationImpl.getApplication();
      str = paramString.getRuntime().getAccount();
    } while (paramString.getSharedPreferences("SearchConfigUtils_Switch" + paramString.getRuntime().getAccount(), 4).getInt("kFTSEnhanceOnlyNetSearchJumpToWeb" + str, 1) != 1);
    return 2;
  }
  
  public static String a(String paramString1, int paramInt, String paramString2)
  {
    String str1 = null;
    String str2 = null;
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "getNetSearchJumpUrl()  word=" + paramString1 + "  source=" + paramInt);
    }
    if (TextUtils.isEmpty(paramString1))
    {
      paramString2 = str2;
      return paramString2;
    }
    Object localObject = BaseApplicationImpl.getApplication();
    str2 = ((BaseApplicationImpl)localObject).getRuntime().getAccount();
    localObject = ((BaseApplicationImpl)localObject).getSharedPreferences("SearchConfigUtils_Switch" + ((BaseApplicationImpl)localObject).getRuntime().getAccount(), 4);
    int i = ((SharedPreferences)localObject).getInt("kFTSEnhanceOnlyNetSearchJumpToWeb" + str2, 1);
    if (i == 1) {
      str1 = ((SharedPreferences)localObject).getString("kFTSEnhanceNetSearchJumpUrlForOnlyNetSearchJumpToWeb" + str2, "");
    }
    if (!TextUtils.isEmpty(str1)) {}
    for (paramString1 = str1.replace("$KEYWORD$", Uri.encode(paramString1)).replace("$SOURCE$", "" + paramInt).replace("$FROM$", "" + URLEncoder.encode(paramString2));; paramString1 = "https://sou.qq.com/index.html?_bid=2958&_wv=3&_wwv=1293&_wvSb=0&from=$FROM$&keyword=$KEYWORD$".replace("$KEYWORD$", Uri.encode(paramString1)).replace("$SOURCE$", "" + paramInt).replace("$FROM$", "" + URLEncoder.encode(paramString2)))
    {
      paramString2 = paramString1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "isSearchEnhanceEnable() uin=" + str2 + " resultUrl=" + paramString1 + " enhanceEnableForJumpToWeb=" + i);
      return paramString1;
    }
  }
  
  public static void a(ConfigurationService.Config paramConfig)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Object localObject1 = localBaseApplicationImpl.getSharedPreferences("SearchConfigUtils_Switch" + localBaseApplicationImpl.getRuntime().getAccount(), 4);
    int i = paramConfig.version.get();
    int j = ((SharedPreferences)localObject1).getInt("search_url_config_version" + localBaseApplicationImpl.getRuntime().getAccount(), 0);
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "handleSearchEnhanceSwitchConfig. newVersion=" + i + " oldVersion=" + j);
    }
    if (i <= j) {}
    do
    {
      do
      {
        return;
        if (paramConfig.msg_content_list.size() <= 0) {
          break;
        }
        paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      } while (paramConfig == null);
      if (paramConfig.compress.get() == 1)
      {
        paramConfig = OlympicUtil.a(paramConfig.content.get().toByteArray());
        if (paramConfig == null) {}
      }
      for (;;)
      {
        try
        {
          paramConfig = new String(paramConfig, "UTF-8");
          if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "handleSearchEnhanceSwitchConfig,xmlContent:" + paramConfig);
          }
          if (paramConfig == null) {
            break;
          }
          localObject1 = ((SharedPreferences)localObject1).edit();
          ((SharedPreferences.Editor)localObject1).putInt("search_url_config_version" + localBaseApplicationImpl.getRuntime().getAccount(), i);
          ((SharedPreferences.Editor)localObject1).commit();
          try
          {
            Object localObject2 = new JSONObject(paramConfig);
            i = ((JSONObject)localObject2).optInt("kFTSEnhanceOnlyNetSearchJumpToWeb");
            paramConfig = ((JSONObject)localObject2).optString("kFTSEnhanceNetSearchJumpUrlForEnhance");
            localObject2 = ((JSONObject)localObject2).optString("kFTSEnhanceNetSearchJumpUrlForOnlyNetSearchJumpToWeb");
            ((SharedPreferences.Editor)localObject1).putInt("kFTSEnhanceOnlyNetSearchJumpToWeb" + localBaseApplicationImpl.getRuntime().getAccount(), i);
            if (!TextUtils.isEmpty(paramConfig)) {
              ((SharedPreferences.Editor)localObject1).putString("kFTSEnhanceNetSearchJumpUrlForEnhance" + localBaseApplicationImpl.getRuntime().getAccount(), paramConfig);
            }
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              ((SharedPreferences.Editor)localObject1).putString("kFTSEnhanceNetSearchJumpUrlForOnlyNetSearchJumpToWeb" + localBaseApplicationImpl.getRuntime().getAccount(), (String)localObject2);
            }
            a = null;
            ((SharedPreferences.Editor)localObject1).commit();
            return;
          }
          catch (Exception paramConfig) {}
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "handleSearchEnhanceSwitchConfig parseJsonError:" + paramConfig.toString());
          return;
        }
        catch (Throwable paramConfig)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "Throwable:" + paramConfig.getMessage());
          }
          paramConfig = null;
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "inflateConfigString error!");
        }
        paramConfig = null;
        continue;
        paramConfig = paramConfig.content.get().toStringUtf8();
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "handleSearchEnhanceSwitchConfig. config is null or size = 0. config=" + paramConfig);
  }
  
  public static boolean a(String paramString)
  {
    BaseApplicationImpl.getContext();
    String str = "";
    if (!TextUtils.isEmpty(paramString)) {
      str = paramString;
    }
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    int i = localBaseApplicationImpl.getSharedPreferences("SearchConfigUtils_Switch" + localBaseApplicationImpl.getRuntime().getAccount(), 4).getInt("search_enhance_switch" + str, 0);
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "isSearchEnhanceEnable() uin=" + paramString + " enhanceSwitch=" + i);
    }
    return i == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.SearchConfigUtils
 * JD-Core Version:    0.7.0.1
 */