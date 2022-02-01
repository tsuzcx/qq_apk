package com.tencent.mobileqq.kandian.repo.xtab.api.impl;

import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.AladdinParseUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.xtab.api.IRIJXTabConfigHandler;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Deprecated(message="用 IRIJXTabConfigHandler 代替")
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/xtab/api/impl/RIJXTabConfigHandler;", "Lcom/tencent/aladdin/config/handlers/SimpleConfigHandler;", "Lcom/tencent/mobileqq/kandian/repo/xtab/api/IRIJXTabConfigHandler;", "()V", "account", "", "enableXTab", "", "innerDefaultEnterTabId", "", "redDotExpireTimeInMin", "tabsList", "", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/TabChannelCoverInfo;", "asAladdinConfigHandler", "asClazz", "Lkotlin/reflect/KClass;", "generateTabInfo", "tabJsonObject", "Lorg/json/JSONObject;", "getDefaultEnterTabId", "getRedDotExpireTimeInMin", "getTabList", "", "isXTabMode", "loadTabsInfoFromJson", "", "json", "onReceiveConfig", "id", "version", "content", "onWipeConfig", "setTabList", "list", "toString", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJXTabConfigHandler
  extends SimpleConfigHandler
  implements IRIJXTabConfigHandler
{
  public static final RIJXTabConfigHandler.Companion Companion = new RIJXTabConfigHandler.Companion(null);
  private static final int RED_DOT_DEFAULT_EXPIRED_TIME_IN_MIN = 720;
  @NotNull
  public static final String SP_DEFAULT_TAB_ID = "x_tab_mode_default_tab_id";
  @NotNull
  public static final String SP_RED_DOT_EXPIRE_TIME_IN_MIN = "x_tab_red_dot_expire_time_in_min";
  @NotNull
  public static final String SP_TAB_INFO_JSON = "x_tab_mode_tabs_info_json";
  @NotNull
  public static final String SP_X_TAB_MODE_SWITCH_KEY = "x_tab_switch_key";
  @NotNull
  public static final String TAG = "RIJXTabConfigHandler";
  private static RIJXTabConfigHandler instance;
  private String account;
  private boolean enableXTab;
  private int innerDefaultEnterTabId;
  private int redDotExpireTimeInMin;
  private final List<TabChannelCoverInfo> tabsList = (List)new ArrayList();
  
  private RIJXTabConfigHandler()
  {
    Object localObject1 = RIJQQAppInterfaceUtil.a();
    if (localObject1 == null) {
      localObject1 = "0";
    }
    this.account = ((String)localObject1);
    localObject1 = (String)RIJSPUtils.a("x_tab_mode_tabs_info_json", "");
    Object localObject2 = RIJSPUtils.a("x_tab_mode_default_tab_id", Integer.valueOf(-1));
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "RIJSPUtils.getReadInJoyS…ue(SP_DEFAULT_TAB_ID, -1)");
    this.innerDefaultEnterTabId = ((Number)localObject2).intValue();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "tabsJson");
    loadTabsInfoFromJson((String)localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("parseFromSp: tabJson:");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(", defaultId:");
    ((StringBuilder)localObject2).append(this.innerDefaultEnterTabId);
    QLog.d("RIJXTabConfigHandler", 1, ((StringBuilder)localObject2).toString());
    boolean bool;
    if ((TextUtils.equals((CharSequence)"1", (CharSequence)RIJSPUtils.a("x_tab_switch_key", "0"))) && ((((Collection)this.tabsList).isEmpty() ^ true))) {
      bool = true;
    } else {
      bool = false;
    }
    this.enableXTab = bool;
    if ((this.enableXTab) && (this.innerDefaultEnterTabId == -1)) {
      this.innerDefaultEnterTabId = ((TabChannelCoverInfo)this.tabsList.get(0)).mChannelCoverId;
    }
    localObject1 = RIJSPUtils.a("x_tab_red_dot_expire_time_in_min", Integer.valueOf(720));
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "RIJSPUtils.getReadInJoyS…AULT_EXPIRED_TIME_IN_MIN)");
    this.redDotExpireTimeInMin = ((Number)localObject1).intValue();
    QLog.d("RIJXTabConfigHandler", 1, toString());
  }
  
  @JvmStatic
  @NotNull
  public static final RIJXTabConfigHandler get()
  {
    try
    {
      RIJXTabConfigHandler localRIJXTabConfigHandler = Companion.a();
      return localRIJXTabConfigHandler;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private final void loadTabsInfoFromJson(String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)paramString)) {
      return;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("tabs_info");
      if (paramString != null)
      {
        int i = 0;
        int j = paramString.length();
        while (i < j)
        {
          localObject = generateTabInfo(paramString.getJSONObject(i));
          if (localObject != null) {
            this.tabsList.add(localObject);
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("load json error, ");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("RIJXTabConfigHandler", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  @NotNull
  public SimpleConfigHandler asAladdinConfigHandler()
  {
    return (SimpleConfigHandler)this;
  }
  
  @NotNull
  public KClass<?> asClazz()
  {
    return Reflection.getOrCreateKotlinClass(getClass());
  }
  
  @VisibleForTesting
  @Nullable
  public final TabChannelCoverInfo generateTabInfo(@Nullable JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramJSONObject != null)
    {
      String str2 = paramJSONObject.optString("name");
      int i = paramJSONObject.optInt("id", -1);
      String str1 = URLDecoder.decode(paramJSONObject.optString("url", ""), "UTF-8");
      boolean bool2 = false;
      int j = paramJSONObject.optInt("immersive", 0);
      boolean bool1;
      if (paramJSONObject.optInt("redpoint_guide", 0) == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)str2))
      {
        if (i == -1) {
          return null;
        }
        localObject1 = new TabChannelCoverInfo(i, str2);
        ((TabChannelCoverInfo)localObject1).mChannelJumpUrl = str1;
        if (j == 1) {
          bool2 = true;
        }
        ((TabChannelCoverInfo)localObject1).isImmersive = bool2;
        ((TabChannelCoverInfo)localObject1).isXTabMode = true;
        ((TabChannelCoverInfo)localObject1).needBadgeGuide = bool1;
      }
    }
    return localObject1;
  }
  
  public int getDefaultEnterTabId()
  {
    return this.innerDefaultEnterTabId;
  }
  
  public int getRedDotExpireTimeInMin()
  {
    return this.redDotExpireTimeInMin;
  }
  
  @NotNull
  public List<TabChannelCoverInfo> getTabList()
  {
    return this.tabsList;
  }
  
  public boolean isXTabMode()
  {
    boolean bool = StudyModeManager.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isXTabMode,enableXTab=");
    localStringBuilder.append(this.enableXTab);
    localStringBuilder.append(",isStudyMode=");
    localStringBuilder.append(bool);
    QLog.d("RIJXTabConfigHandler", 2, localStringBuilder.toString());
    return (this.enableXTab) && (!bool);
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, @Nullable String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    try
    {
      paramString = AladdinParseUtils.a(paramString);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "configs");
      localObject1 = paramString.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        String str = (String)((Map.Entry)localObject2).getKey();
        if (str != null)
        {
          paramInt2 = str.hashCode();
          switch (paramInt2)
          {
          default: 
            break;
          case 392919408: 
            if (str.equals("use_4_tab_mode")) {
              RIJSPUtils.a("x_tab_switch_key", ((Map.Entry)localObject2).getValue());
            }
            break;
          case 41313622: 
            if (str.equals("red_dot_expire_min"))
            {
              localObject2 = ((Map.Entry)localObject2).getValue();
              Intrinsics.checkExpressionValueIsNotNull(localObject2, "entry.value");
              RIJSPUtils.a("x_tab_red_dot_expire_time_in_min", Integer.valueOf(Integer.parseInt((String)localObject2)));
            }
            break;
          case -436618089: 
            if (str.equals("default_tab"))
            {
              localObject2 = ((Map.Entry)localObject2).getValue();
              Intrinsics.checkExpressionValueIsNotNull(localObject2, "entry.value");
              RIJSPUtils.a("x_tab_mode_default_tab_id", Integer.valueOf(Integer.parseInt((String)localObject2)));
            }
            break;
          case -1793038129: 
            if (str.equals("tabs_info")) {
              RIJSPUtils.a("x_tab_mode_tabs_info_json", ((Map.Entry)localObject2).getValue());
            }
            break;
          }
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("receive servlet config: ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("RIJXTabConfigHandler", 1, ((StringBuilder)localObject1).toString());
      return true;
    }
    catch (Exception paramString)
    {
      onWipeConfig(paramInt1);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[RIJ4TabConfigHandler]: parse config Error: ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.e("RIJXTabConfigHandler", 2, ((StringBuilder)localObject1).toString());
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    RIJSPUtils.a("x_tab_switch_key", "");
    RIJSPUtils.a("x_tab_mode_default_tab_id", "");
    RIJSPUtils.a("x_tab_mode_tabs_info_json", "");
    RIJSPUtils.a("x_tab_red_dot_expire_time_in_min", "");
  }
  
  public void setTabList(@NotNull List<? extends TabChannelCoverInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "list");
    this.tabsList.clear();
    this.tabsList.addAll((Collection)paramList);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enable: ");
    localStringBuilder.append(this.enableXTab);
    localStringBuilder.append(", tabInfo: ");
    localStringBuilder.append(this.tabsList);
    localStringBuilder.append(", defaultEnterTabId: ");
    localStringBuilder.append(this.innerDefaultEnterTabId);
    localStringBuilder.append(", redDotExpireTimeInMin: ");
    localStringBuilder.append(this.redDotExpireTimeInMin);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.xtab.api.impl.RIJXTabConfigHandler
 * JD-Core Version:    0.7.0.1
 */