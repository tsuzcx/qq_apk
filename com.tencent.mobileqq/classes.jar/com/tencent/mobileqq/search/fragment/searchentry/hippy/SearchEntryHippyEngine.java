package com.tencent.mobileqq.search.fragment.searchentry.hippy;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener;
import com.tencent.hippy.qq.view.tkd.listview.ResourceUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.hippy.api.ITKDHippyBridge;
import com.tencent.mobileqq.kandian.biz.hippy.entity.AccountInfo;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.base.api.SearchEntryConfigManager;
import com.tencent.mobileqq.search.fragment.searchentry.hotword.SearchHotwordHandler;
import com.tencent.mobileqq.search.fragment.searchentry.nativemethod.RequestHistoryDataMethod;
import com.tencent.mtt.hippy.common.HippyMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class SearchEntryHippyEngine
  extends HippyQQEngine
{
  private static final String SPKEY_IS_HIPPY_DEBUG = "SearchEntryHippyEngine.spkey_is_hippy_debug";
  private static final String SPKEY_IS_HIPPY_ON = "SearchEntryHippyEngine.spkey_is_hippy_ON";
  public static boolean hippyError = false;
  private String VIEW_ID = "";
  @NonNull
  private final SearchHotwordHandler hotwordHandler;
  
  public SearchEntryHippyEngine(@NonNull ViolaFragment paramViolaFragment, @NonNull SearchHotwordHandler paramSearchHotwordHandler, HippyQQEngine.HippyQQEngineListener paramHippyQQEngineListener)
  {
    super(paramViolaFragment, "search", paramViolaFragment.getUrl());
    this.hotwordHandler = paramSearchHotwordHandler;
    this.providers.add(((ITKDHippyBridge)QRoute.api(ITKDHippyBridge.class)).getTKDApiProvider());
    setJsBundleType("react");
    setComponentName("SearchPageView");
    setDebugMode(isHippyDebug());
    setPropsMap(getStartPageInitPropMap(paramViolaFragment.getContentView()));
    setViewCreator(new SearchHippyViewCreator());
    initHippyInContainer((ViewGroup)paramViolaFragment.getContentView().findViewById(2131380915), new JSONObject(), false, paramHippyQQEngineListener);
  }
  
  @NotNull
  private HippyMap getStartPageInitPropMap(ViewGroup paramViewGroup)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append("");
    this.VIEW_ID = ((StringBuilder)localObject).toString();
    localObject = new HippyMap();
    ((HippyMap)localObject).pushString("viewID", this.VIEW_ID);
    ((HippyMap)localObject).pushString("history", RequestHistoryDataMethod.getHistoryListStr());
    ((HippyMap)localObject).pushString("guid", ((ITKDHippyBridge)QRoute.api(ITKDHippyBridge.class)).getCurAccountInfo().qqNum);
    ((HippyMap)localObject).pushString("type", "homePage");
    ((HippyMap)localObject).pushString("hint", ResourceUtil.getString(2131718624));
    ((HippyMap)localObject).pushString("data", SearchHippyEventEmitter.mapToJsonStr(SearchHotwordHandler.getHotwordDataMap(this.hotwordHandler, null)));
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushInt("skinMode", 0);
    localHippyMap.pushBoolean("isFullScreen", false);
    localHippyMap.pushInt("orientation", paramViewGroup.getContext().getResources().getConfiguration().orientation);
    ((HippyMap)localObject).pushMap("qbConfig", localHippyMap);
    return localObject;
  }
  
  public static boolean isHippyDebug()
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getBoolean("SearchEntryHippyEngine.spkey_is_hippy_debug", false);
  }
  
  public static boolean isHippyOn()
  {
    if (iscmdHippyOn()) {
      return true;
    }
    AladdinConfig localAladdinConfig = Aladdin.getConfig(313);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localAladdinConfig != null)
    {
      bool1 = bool2;
      if (localAladdinConfig.getIntegerFromString("SearchPage_HippySwitch", -1) == 1) {
        bool1 = true;
      }
    }
    if (!bool1) {
      SearchEntryConfigManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true);
    }
    return bool1;
  }
  
  public static boolean iscmdHippyOn()
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getBoolean("SearchEntryHippyEngine.spkey_is_hippy_ON", false);
  }
  
  public static void setHippyDebug(boolean paramBoolean)
  {
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putBoolean("SearchEntryHippyEngine.spkey_is_hippy_debug", paramBoolean).apply();
  }
  
  public static void setcmdHippyOn(boolean paramBoolean)
  {
    PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit().putBoolean("SearchEntryHippyEngine.spkey_is_hippy_ON", paramBoolean).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchentry.hippy.SearchEntryHippyEngine
 * JD-Core Version:    0.7.0.1
 */