package com.tencent.mobileqq.search.base.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.ISearchConfigUtilFetcher;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class SearchEntryConfigManager
{
  public static boolean a = false;
  public static String b = "";
  public static String c = "Hot_word";
  public static int d = 8;
  
  public static int a()
  {
    return 1;
  }
  
  public static int a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "";
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("search_net_config_version_code");
    localStringBuilder.append(paramString);
    localStringBuilder.append(AppSetting.h());
    return paramContext.getInt(localStringBuilder.toString(), -1);
  }
  
  public static int a(String paramString, int paramInt)
  {
    String str = ((AppInterface)MobileQQ.sMobileQQ.peekAppRuntime()).getCurrentAccountUin();
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MobileQQ.sMobileQQ);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(str);
    int j = localSharedPreferences.getInt(localStringBuilder.toString(), paramInt);
    int i = j;
    if (j == 0) {
      i = paramInt;
    }
    return i;
  }
  
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "";
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("search_net_config_version_code");
    localStringBuilder.append(paramString);
    localStringBuilder.append(AppSetting.h());
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, ConfigurationService.Config paramConfig, String paramString)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    String str;
    if (!TextUtils.isEmpty(paramString)) {
      str = paramString;
    } else {
      str = "";
    }
    if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
    {
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null)
      {
        if (paramConfig.compress.get() == 1)
        {
          paramConfig = ((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).inflateConfigString(paramConfig.content.get().toByteArray());
          if (paramConfig != null) {
            try
            {
              paramConfig = new String(paramConfig, "UTF-8");
            }
            catch (Throwable paramConfig)
            {
              QLog.i("Q.uniteSearch.SearchEntryConfigManager", 1, "updateNetSearchConfig", paramConfig);
              break label135;
            }
          } else {
            QLog.i("Q.uniteSearch.SearchEntryConfigManager", 1, "updateNetSearchConfig buff != null");
          }
          label135:
          paramConfig = null;
        }
        else
        {
          paramConfig = paramConfig.content.get().toStringUtf8();
        }
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("updateNetSearchConfig jsonContent=");
        ((StringBuilder)localObject1).append(paramConfig);
        QLog.i("Q.uniteSearch.SearchEntryConfigManager", 1, ((StringBuilder)localObject1).toString());
        if (paramConfig != null) {
          try
          {
            localObject1 = new JSONObject(paramConfig);
            Object localObject2 = ((JSONObject)localObject1).optString("kNetSearchEntranceCellSummary");
            int i = ((JSONObject)localObject1).optInt("kFTSNativeContactorMaxNum");
            int j = ((JSONObject)localObject1).optInt("kFTSNativeChatHistoryMaxNum");
            int k = ((JSONObject)localObject1).optInt("kFTSNativeFunctionMaxNum");
            int m = ((JSONObject)localObject1).optInt("kDynamicNeedSearchNative");
            int n = ((JSONObject)localObject1).optInt("kFTSNativePubAccountMaxNum");
            paramConfig = ((JSONObject)localObject1).optString("kFTSNativeFunctionTitleName", HardCodeUtil.a(2131911094));
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("net_search_cell_summary");
            localStringBuilder.append(str);
            localEditor.putString(localStringBuilder.toString(), (String)localObject2);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("fts_search_bar_summary");
            ((StringBuilder)localObject2).append(str);
            localEditor.putString(((StringBuilder)localObject2).toString(), ((JSONObject)localObject1).optString("kFTSSearchBarPlaceHolder"));
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("fts_native_contactor_maxnum");
            ((StringBuilder)localObject2).append(str);
            localEditor.putInt(((StringBuilder)localObject2).toString(), i);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("fts_native_chathistory_maxnum");
            ((StringBuilder)localObject2).append(str);
            localEditor.putInt(((StringBuilder)localObject2).toString(), j);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("fts_native_function_maxnum");
            ((StringBuilder)localObject2).append(str);
            localEditor.putInt(((StringBuilder)localObject2).toString(), k);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("fts_should_show_netsearch_persongroup_tab1");
            ((StringBuilder)localObject2).append(str);
            localEditor.putInt(((StringBuilder)localObject2).toString(), ((JSONObject)localObject1).optInt("kFTSShouldShowNetSearchPersonGroupTab1"));
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("fts_should_show_netsearch_persongroup_tab2");
            ((StringBuilder)localObject2).append(str);
            localEditor.putInt(((StringBuilder)localObject2).toString(), ((JSONObject)localObject1).optInt("kFTSShouldShowNetSearchPersonGroupTab2"));
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("fts_should_show_netsearch_persongroup_tab3");
            ((StringBuilder)localObject2).append(str);
            localEditor.putInt(((StringBuilder)localObject2).toString(), ((JSONObject)localObject1).optInt("kFTSShouldShowNetSearchPersonGroupTab3"));
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("dynamic_need_search_native");
            ((StringBuilder)localObject1).append(str);
            localEditor.putInt(((StringBuilder)localObject1).toString(), m);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("pref_fts_native_search_public_account_max_num");
            ((StringBuilder)localObject1).append(str);
            localEditor.putInt(((StringBuilder)localObject1).toString(), n);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("pref_net_search_function_title");
            ((StringBuilder)localObject1).append(str);
            localEditor.putString(((StringBuilder)localObject1).toString(), paramConfig);
            localEditor.commit();
            ((ISearchConfigUtilFetcher)QRoute.api(ISearchConfigUtilFetcher.class)).setSFtsSearchBarWording(null);
            return;
          }
          catch (Exception paramConfig)
          {
            QLog.i("Q.uniteSearch.SearchEntryConfigManager", 1, "updateNetSearchConfig parseJsonError", paramConfig);
          }
        }
      }
    }
    a(paramContext, -1, paramString);
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(MobileQQ.sMobileQQ);
    if (!paramBoolean2)
    {
      localObject = ((SharedPreferences)localObject).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("search_discovery_sp_prefixrefresh_search_model_list");
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      localStringBuilder.append("_");
      localStringBuilder.append(paramInt);
      ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), paramBoolean1).commit();
      QLog.d("Q.uniteSearch.SearchEntryConfigManager818searchProto_old", 2, "updateNeedRefreshModelList");
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("search_discovery_sp_prefix_unifyrefresh_search_model_list");
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), paramBoolean1).commit();
    QLog.d("Q.uniteSearch.SearchEntryConfigManager818searchProto_new", 2, "updateNeedRefreshModelList");
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt, int[] paramArrayOfInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder1 = new StringBuilder("");
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfInt.length - 1)
      {
        localStringBuilder1.append(paramArrayOfInt[i]);
        localStringBuilder1.append("_");
        i += 1;
      }
      localStringBuilder1.append(paramArrayOfInt[(paramArrayOfInt.length - 1)]);
    }
    paramArrayOfInt = PreferenceManager.getDefaultSharedPreferences(MobileQQ.sMobileQQ);
    StringBuilder localStringBuilder2;
    if (!paramBoolean)
    {
      paramArrayOfInt = paramArrayOfInt.edit();
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("search_discovery_sp_prefixpref_search_model_list");
      localStringBuilder2.append(paramAppInterface.getCurrentAccountUin());
      localStringBuilder2.append("_");
      localStringBuilder2.append(paramInt);
      paramArrayOfInt.putString(localStringBuilder2.toString(), localStringBuilder1.toString()).commit();
      QLog.d("Q.uniteSearch.SearchEntryConfigManager818searchProto_old", 2, "updateModelListByTab");
    }
    else
    {
      paramArrayOfInt = paramArrayOfInt.edit();
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("search_discovery_sp_prefix_unifypref_search_model_list");
      localStringBuilder2.append(paramAppInterface.getCurrentAccountUin());
      localStringBuilder2.append("_");
      localStringBuilder2.append(paramInt);
      paramArrayOfInt.putString(localStringBuilder2.toString(), localStringBuilder1.toString()).commit();
      QLog.d("Q.uniteSearch.SearchEntryConfigManager818searchProto_new", 2, "updateModelListByTab");
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfInt = new StringBuilder();
      paramArrayOfInt.append("setEntryListByTab, result = ");
      paramArrayOfInt.append(localStringBuilder1.toString());
      paramArrayOfInt.append(", uin = ");
      paramArrayOfInt.append(paramAppInterface.getCurrentAccountUin());
      paramArrayOfInt.append(", tabType = ");
      paramArrayOfInt.append(paramInt);
      QLog.e("Q.uniteSearch.SearchEntryConfigManager", 2, paramArrayOfInt.toString());
    }
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString, int paramInt)
  {
    try
    {
      Object localObject = PreferenceManager.getDefaultSharedPreferences(MobileQQ.sMobileQQ);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pref_search_light_show_id");
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      localStringBuilder.append("_");
      localStringBuilder.append(paramString);
      int i = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0);
      paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
      if (paramInt == 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("pref_search_light_show_id");
        ((StringBuilder)localObject).append(paramAppInterface.getCurrentAccountUin());
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(paramString);
        paramContext.putInt(((StringBuilder)localObject).toString(), i + 1).commit();
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pref_search_light_show_id");
      ((StringBuilder)localObject).append(paramAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramString);
      paramContext.putInt(((StringBuilder)localObject).toString(), paramInt).commit();
      return;
    }
    catch (Exception paramAppInterface)
    {
      paramContext = new StringBuilder();
      paramContext.append("updateShowSearchLightByIDError:");
      paramContext.append(paramAppInterface.toString());
      QLog.d("Q.uniteSearch.SearchEntryConfigManager", 2, paramContext.toString());
    }
  }
  
  public static void a(AppInterface paramAppInterface, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(MobileQQ.sMobileQQ).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    localStringBuilder.append("QQ_SEARCH_SHOW_HOTLIST");
    boolean bool = localEditor.putBoolean(localStringBuilder.toString(), paramBoolean).commit();
    paramAppInterface = new StringBuilder();
    paramAppInterface.append("sethidden:");
    paramAppInterface.append(paramBoolean);
    paramAppInterface.append("result:");
    paramAppInterface.append(bool);
    QLog.d("hotwordPreference:", 2, paramAppInterface.toString());
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MobileQQ.sMobileQQ);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    localStringBuilder.append("QQ_SEARCH_SHOW_HOTLIST");
    boolean bool = localSharedPreferences.getBoolean(localStringBuilder.toString(), true);
    paramAppInterface = new StringBuilder();
    paramAppInterface.append("hidden:");
    paramAppInterface.append(bool);
    QLog.d("hotwordPreference:", 2, paramAppInterface.toString());
    return bool;
  }
  
  public static boolean a(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MobileQQ.sMobileQQ);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pref_search_light_show_id");
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    paramAppInterface = localStringBuilder.toString();
    boolean bool = false;
    if (localSharedPreferences.getInt(paramAppInterface, 0) < paramInt) {
      bool = true;
    }
    return bool;
  }
  
  public static int[] a(AppInterface paramAppInterface, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = PreferenceManager.getDefaultSharedPreferences(MobileQQ.sMobileQQ);
    Object localObject2;
    if (!paramBoolean)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("search_discovery_sp_prefixpref_search_model_list");
      ((StringBuilder)localObject2).append(paramAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(paramInt);
      localObject2 = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject2).toString(), "").split("_");
      QLog.d("Q.uniteSearch.SearchEntryConfigManager818searchProto_old", 2, "getModelListByTab");
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("search_discovery_sp_prefix_unifypref_search_model_list");
      ((StringBuilder)localObject2).append(paramAppInterface.getCurrentAccountUin());
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(paramInt);
      localObject2 = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject2).toString(), "").split("_");
      QLog.d("Q.uniteSearch.SearchEntryConfigManager818searchProto_new", 2, "getModelListByTab");
    }
    Object localObject3 = null;
    localObject1 = localObject3;
    if (localObject2 != null)
    {
      localObject1 = localObject3;
      if (localObject2.length > 0) {
        try
        {
          localObject1 = new int[localObject2.length];
          int i = 0;
          while (i < localObject2.length)
          {
            localObject1[i] = Integer.valueOf(localObject2[i]).intValue();
            i += 1;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localObject1 = localObject3;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("getEntryListByTab, NumberFormatException, e = ");
            ((StringBuilder)localObject1).append(localNumberFormatException);
            ((StringBuilder)localObject1).append(", uin = ");
            ((StringBuilder)localObject1).append(paramAppInterface.getCurrentAccountUin());
            ((StringBuilder)localObject1).append(", tabType = ");
            ((StringBuilder)localObject1).append(paramInt);
            QLog.e("Q.uniteSearch.SearchEntryConfigManager", 2, ((StringBuilder)localObject1).toString());
            localObject1 = localObject3;
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getEntryListByTab, result = ");
      localStringBuilder.append(localObject1);
      localStringBuilder.append(", uin = ");
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      localStringBuilder.append(", tabType = ");
      localStringBuilder.append(paramInt);
      QLog.e("Q.uniteSearch.SearchEntryConfigManager", 2, localStringBuilder.toString());
    }
    return localObject1;
  }
  
  public static String b()
  {
    String str = ((AppInterface)MobileQQ.sMobileQQ.peekAppRuntime()).getCurrentAccountUin();
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MobileQQ.sMobileQQ);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pref_net_search_function_title");
    localStringBuilder.append(str);
    return localSharedPreferences.getString(localStringBuilder.toString(), HardCodeUtil.a(2131911093));
  }
  
  public static String b(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "";
    }
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("net_search_cell_summary");
    localStringBuilder.append(paramString);
    return paramContext.getString(localStringBuilder.toString(), "");
  }
  
  public static boolean b(AppInterface paramAppInterface, int paramInt, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MobileQQ.sMobileQQ);
    if (!paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("search_discovery_sp_prefixrefresh_search_model_list");
      localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
      localStringBuilder.append("_");
      localStringBuilder.append(paramInt);
      paramBoolean = localSharedPreferences.getBoolean(localStringBuilder.toString(), true);
      QLog.d("Q.uniteSearch.SearchEntryConfigManager818searchProto_old", 2, "getNeedRefreshModelList");
      return paramBoolean;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("search_discovery_sp_prefix_unifyrefresh_search_model_list");
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    paramBoolean = localSharedPreferences.getBoolean(localStringBuilder.toString(), true);
    QLog.d("Q.uniteSearch.SearchEntryConfigManager818searchProto_new", 2, "getNeedRefreshModelList");
    return paramBoolean;
  }
  
  public static String c()
  {
    Object localObject3 = (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
    Object localObject2 = ((AppInterface)localObject3).getCurrentAccountUin();
    Object localObject1 = HardCodeUtil.a(2131916089);
    if (TextUtils.isEmpty(((ISearchConfigUtilFetcher)QRoute.api(ISearchConfigUtilFetcher.class)).getSFtsSearchBarWording()))
    {
      if (((ISearchConfigUtilFetcher)QRoute.api(ISearchConfigUtilFetcher.class)).isSearchEnhanceEnable(((AppInterface)localObject3).getCurrentAccountUin()))
      {
        localObject3 = MobileQQ.sMobileQQ;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = localObject2;
        } else {
          localObject1 = "";
        }
        localObject2 = PreferenceManager.getDefaultSharedPreferences((Context)localObject3);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("fts_search_bar_summary");
        ((StringBuilder)localObject3).append((String)localObject1);
        localObject1 = ((SharedPreferences)localObject2).getString(((StringBuilder)localObject3).toString(), "");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          ((ISearchConfigUtilFetcher)QRoute.api(ISearchConfigUtilFetcher.class)).setSFtsSearchBarWording((String)localObject1);
        } else {
          localObject1 = HardCodeUtil.a(2131916089);
        }
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getFtsSearchBarWording() cache wording is not null. ");
        ((StringBuilder)localObject1).append(((ISearchConfigUtilFetcher)QRoute.api(ISearchConfigUtilFetcher.class)).getSFtsSearchBarWording());
        QLog.d("Q.uniteSearch.SearchEntryConfigManager", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = ((ISearchConfigUtilFetcher)QRoute.api(ISearchConfigUtilFetcher.class)).getSFtsSearchBarWording();
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getFtsSearchBarWording() searchBarWording=");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("Q.uniteSearch.SearchEntryConfigManager", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  public static int d()
  {
    if (((ISearchPieceFetcher)QRoute.api(ISearchPieceFetcher.class)).isHippyEngineOn()) {
      return 7;
    }
    AladdinConfig localAladdinConfig = Aladdin.getConfig(313);
    if (localAladdinConfig != null)
    {
      c = localAladdinConfig.getString("SBWord_Source", "Hot_word");
      if (TextUtils.equals(c, "Recom_word")) {
        return 7;
      }
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.base.api.SearchEntryConfigManager
 * JD-Core Version:    0.7.0.1
 */