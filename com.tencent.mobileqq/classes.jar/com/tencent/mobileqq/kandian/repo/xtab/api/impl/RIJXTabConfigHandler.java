package com.tencent.mobileqq.kandian.repo.xtab.api.impl;

import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.base.ktx.CacheDelegateKt;
import com.tencent.mobileqq.kandian.base.ktx.CacheLazy;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.xtab.api.IRIJXTabConfigHandler;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/xtab/api/impl/RIJXTabConfigHandler;", "Lcom/tencent/mobileqq/kandian/repo/xtab/api/IRIJXTabConfigHandler;", "()V", "DEFAULT_TAB", "", "RED_DOT_DEFAULT_EXPIRED_TIME_IN_MIN", "", "RED_DOT_EXPIRE_MIN", "TABS_INFO", "TAG", "USER_SETTING_CHANNEL_ID_SP_KEY", "USER_SETTING_FEEDS_STYLE_TYPE_SP_KEY", "USER_SETTING_HAS_SET_SP_KEY", "USE_X_TAB_MODE", "_config", "Lcom/tencent/aladdin/config/AladdinConfig;", "get_config", "()Lcom/tencent/aladdin/config/AladdinConfig;", "_config$delegate", "Lkotlin/Lazy;", "_defaultEnterTabId", "get_defaultEnterTabId", "()I", "_defaultEnterTabId$delegate", "_enableXTab", "", "get_enableXTab", "()Z", "_enableXTab$delegate", "_redDotExpireTimeInMin", "get_redDotExpireTimeInMin", "_redDotExpireTimeInMin$delegate", "_tabsList", "", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/TabChannelCoverInfo;", "get_tabsList", "()Ljava/util/List;", "_tabsList$delegate", "defaultTabID", "defaultTabsList", "defaultUse4Tab", "generateTabInfo", "tabJsonObject", "Lorg/json/JSONObject;", "getDefaultEnterTabId", "getDefaultEnterTabInfo", "getHomeFeedsStyle", "getRedDotExpireTimeInMin", "getTabList", "isBigImageMode", "isXTabMode", "parseTabsInfoFromJson", "json", "toString", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabConfigHandler
  implements IRIJXTabConfigHandler
{
  @NotNull
  public static final String DEFAULT_TAB = "default_tab";
  public static final RIJXTabConfigHandler INSTANCE = new RIJXTabConfigHandler();
  public static final int RED_DOT_DEFAULT_EXPIRED_TIME_IN_MIN = 720;
  @NotNull
  public static final String RED_DOT_EXPIRE_MIN = "red_dot_expire_min";
  @NotNull
  public static final String TABS_INFO = "tabs_info";
  private static final String TAG = "RIJXTabConfigHandler";
  @NotNull
  public static final String USER_SETTING_CHANNEL_ID_SP_KEY = "rij_user_setting_channel_id_sp_key";
  @NotNull
  public static final String USER_SETTING_FEEDS_STYLE_TYPE_SP_KEY = "rij_user_setting_feeds_style_type_sp_key";
  @NotNull
  public static final String USER_SETTING_HAS_SET_SP_KEY = "rij_user_setting_has_set_sp_key";
  @NotNull
  public static final String USE_X_TAB_MODE = "use_4_tab_mode";
  private static final Lazy _config$delegate = (Lazy)new CacheLazy((Function0)RIJXTabConfigHandler._config.2.INSTANCE, CacheDelegateKt.a());
  private static final Lazy _defaultEnterTabId$delegate = (Lazy)new CacheLazy((Function0)RIJXTabConfigHandler._defaultEnterTabId.2.INSTANCE, CacheDelegateKt.a());
  private static final Lazy _enableXTab$delegate = (Lazy)new CacheLazy((Function0)RIJXTabConfigHandler._enableXTab.2.INSTANCE, CacheDelegateKt.a());
  private static final Lazy _redDotExpireTimeInMin$delegate = (Lazy)new CacheLazy((Function0)RIJXTabConfigHandler._redDotExpireTimeInMin.2.INSTANCE, CacheDelegateKt.a());
  private static final Lazy _tabsList$delegate = (Lazy)new CacheLazy((Function0)RIJXTabConfigHandler._tabsList.2.INSTANCE, CacheDelegateKt.a());
  private static final int defaultTabID = 0;
  private static final String defaultTabsList = "{\n    \"tabs_info\":[\n        {\n            \"name\":\"关注\",\n            \"id\":70,\n            \"immersive\":0,\n            \"url\":\"http://viola.qq.com/channel/newFollow.js?_rij_violaUrl=1&v_tid=48&v_bid=4441&v_bundleName=newFollow\"\n        },\n        {\n            \"name\":\"好友\",\n            \"id\":41655,\n            \"immersive\":0,\n            \"url\":\"http://viola.qq.com/js/VideoAccountFeeds.js?_rij_violaUrl=1&v_tid=15&v_bundleName=VideoAccountFeeds&hideNav=1&v_nav_immer=1&statusBarStyle=0&v_bid=3811&_cache_bunle=1&v_content_full=1&channel_id=41655&kandian_mode_new=4\"\n        },\n        {\n            \"name\":\"推荐\",\n            \"id\":0,\n            \"immersive\":0\n        },\n        {\n            \"name\":\"小区\",\n            \"id\":41729,\n            \"immersive\":1,\n            \"url\":\"https://viola.qq.com/js/home.js?_rij_violaUrl=1&v_bid=4636&v_tid=54&v_bundleName=home&hideNav=1&v_nav_immer=1\"\n        }\n    ]\n}";
  private static final int defaultUse4Tab = 1;
  
  private final AladdinConfig get_config()
  {
    return (AladdinConfig)_config$delegate.getValue();
  }
  
  private final int get_defaultEnterTabId()
  {
    return ((Number)_defaultEnterTabId$delegate.getValue()).intValue();
  }
  
  private final boolean get_enableXTab()
  {
    return ((Boolean)_enableXTab$delegate.getValue()).booleanValue();
  }
  
  private final int get_redDotExpireTimeInMin()
  {
    return ((Number)_redDotExpireTimeInMin$delegate.getValue()).intValue();
  }
  
  private final List<TabChannelCoverInfo> get_tabsList()
  {
    return (List)_tabsList$delegate.getValue();
  }
  
  private final List<TabChannelCoverInfo> parseTabsInfoFromJson(String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      return CollectionsKt.emptyList();
    }
    List localList = (List)new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("tabs_info");
        if (paramString != null)
        {
          i = 0;
          int j = paramString.length();
          if (i < j)
          {
            localObject = generateTabInfo(paramString.getJSONObject(i));
            if (localObject == null) {
              break label130;
            }
            localList.add(localObject);
            break label130;
          }
        }
        else
        {
          paramString = CollectionsKt.emptyList();
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("load json error, ");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("RIJXTabConfigHandler", 1, ((StringBuilder)localObject).toString());
      }
      return localList;
      label130:
      i += 1;
    }
  }
  
  @VisibleForTesting
  @Nullable
  public final TabChannelCoverInfo generateTabInfo(@Nullable JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramJSONObject != null)
    {
      String str3 = paramJSONObject.optString("name");
      int i = paramJSONObject.optInt("id", -1);
      String str1 = URLDecoder.decode(paramJSONObject.optString("url", ""), "UTF-8");
      boolean bool3 = false;
      int j = paramJSONObject.optInt("immersive", 0);
      boolean bool1;
      if (paramJSONObject.optInt("redpoint_guide", 0) == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool2;
      if (paramJSONObject.optInt("only_cover", 0) == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      String str2 = URLDecoder.decode(paramJSONObject.optString("cover_url", ""), "UTF-8");
      paramJSONObject = URLDecoder.decode(paramJSONObject.optString("default_cover", ""), "UTF-8");
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)str3))
      {
        if (i == -1) {
          return null;
        }
        localObject1 = new TabChannelCoverInfo(i, str3);
        ((TabChannelCoverInfo)localObject1).mChannelJumpUrl = str1;
        if (j == 1) {
          bool3 = true;
        }
        ((TabChannelCoverInfo)localObject1).isImmersive = bool3;
        ((TabChannelCoverInfo)localObject1).isXTabMode = true;
        ((TabChannelCoverInfo)localObject1).needBadgeGuide = bool1;
        ((TabChannelCoverInfo)localObject1).isIconTab = bool2;
        ((TabChannelCoverInfo)localObject1).iconUrl = str2;
        ((TabChannelCoverInfo)localObject1).defaultIcon = paramJSONObject;
      }
    }
    return localObject1;
  }
  
  public int getDefaultEnterTabId()
  {
    Integer localInteger = (Integer)RIJSPUtils.b("rij_user_setting_channel_id_sp_key", Integer.valueOf(-1));
    if ((localInteger == null) || (localInteger.intValue() != -1))
    {
      Intrinsics.checkExpressionValueIsNotNull(localInteger, "userSetChannelId");
      return localInteger.intValue();
    }
    return get_defaultEnterTabId();
  }
  
  @Nullable
  public TabChannelCoverInfo getDefaultEnterTabInfo()
  {
    Iterator localIterator = ((Iterable)getTabList()).iterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      int i;
      if (((TabChannelCoverInfo)localObject).mChannelCoverId == INSTANCE.getDefaultEnterTabId()) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        break label61;
      }
    }
    Object localObject = null;
    label61:
    return (TabChannelCoverInfo)localObject;
  }
  
  public final int getHomeFeedsStyle()
  {
    Object localObject = (Boolean)RIJSPUtils.b("rij_user_setting_has_set_sp_key", Boolean.valueOf(false));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "userHasSet");
    int i;
    if (((Boolean)localObject).booleanValue())
    {
      localObject = RIJSPUtils.b("rij_user_setting_feeds_style_type_sp_key", Integer.valueOf(1));
      Intrinsics.checkExpressionValueIsNotNull(localObject, "RIJSPUtils.getReadInJoyS…TYPE_NORMAL\n            )");
      i = ((Number)localObject).intValue();
    }
    else if (getDefaultEnterTabId() == 41726)
    {
      i = 3;
    }
    else
    {
      i = 1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[getHomeFeedsStyle] feedsStyleType = ");
    ((StringBuilder)localObject).append(i);
    QLog.i("RIJXTabConfigHandler", 1, ((StringBuilder)localObject).toString());
    return i;
  }
  
  public int getRedDotExpireTimeInMin()
  {
    return get_redDotExpireTimeInMin();
  }
  
  @NotNull
  public List<TabChannelCoverInfo> getTabList()
  {
    return get_tabsList();
  }
  
  public final boolean isBigImageMode()
  {
    Object localObject = (Integer)RIJSPUtils.b("rij_user_setting_feeds_style_type_sp_key", Integer.valueOf(-1));
    boolean bool;
    if ((localObject != null) && (((Integer)localObject).intValue() == 4)) {
      bool = true;
    } else {
      bool = false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[isBigImageMode] == ");
    ((StringBuilder)localObject).append(bool);
    QLog.i("RIJXTabConfigHandler", 1, ((StringBuilder)localObject).toString());
    return bool;
  }
  
  public boolean isXTabMode()
  {
    boolean bool = StudyModeManager.h();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isXTabMode,enableXTab=");
    localStringBuilder.append(get_enableXTab());
    localStringBuilder.append(",isStudyMode=");
    localStringBuilder.append(bool);
    QLog.d("RIJXTabConfigHandler", 2, localStringBuilder.toString());
    return (get_enableXTab()) && (!bool);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enable: ");
    localStringBuilder.append(get_enableXTab());
    localStringBuilder.append(", tabInfo: ");
    localStringBuilder.append(get_tabsList());
    localStringBuilder.append(", defaultEnterTabId: ");
    localStringBuilder.append(getDefaultEnterTabId());
    localStringBuilder.append(", redDotExpireTimeInMin: ");
    localStringBuilder.append(get_redDotExpireTimeInMin());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.xtab.api.impl.RIJXTabConfigHandler
 * JD-Core Version:    0.7.0.1
 */