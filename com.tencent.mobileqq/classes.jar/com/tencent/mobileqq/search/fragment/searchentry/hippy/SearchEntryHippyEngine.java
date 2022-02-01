package com.tencent.mobileqq.search.fragment.searchentry.hippy;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import bass;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener;
import com.tencent.hippy.qq.app.TKDApiProvider;
import com.tencent.hippy.qq.module.tkd.TKDAccountModule;
import com.tencent.hippy.qq.module.tkd.TKDAccountModule.AccountInfo;
import com.tencent.hippy.qq.view.tkd.listview.ResourceUtil;
import com.tencent.mobileqq.app.QQAppInterface;
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
  public static boolean hippyError;
  private String VIEW_ID = "";
  @NonNull
  private final SearchHotwordHandler hotwordHandler;
  
  public SearchEntryHippyEngine(@NonNull ViolaFragment paramViolaFragment, @NonNull SearchHotwordHandler paramSearchHotwordHandler, HippyQQEngine.HippyQQEngineListener paramHippyQQEngineListener)
  {
    super(paramViolaFragment, "search", paramViolaFragment.getUrl());
    this.hotwordHandler = paramSearchHotwordHandler;
    this.providers.add(new TKDApiProvider());
    setJsBundleType("react");
    setComponentName("SearchPageView");
    setDebugMode(isHippyDebug());
    setPropsMap(getStartPageInitPropMap(paramViolaFragment.getContentView()));
    setViewCreator(new SearchHippyViewCreator());
    initHippy(paramViolaFragment.getContentView(), new JSONObject(), false, paramHippyQQEngineListener);
  }
  
  @NotNull
  private HippyMap getStartPageInitPropMap(ViewGroup paramViewGroup)
  {
    this.VIEW_ID = (System.currentTimeMillis() + "");
    HippyMap localHippyMap1 = new HippyMap();
    localHippyMap1.pushString("viewID", this.VIEW_ID);
    localHippyMap1.pushString("history", RequestHistoryDataMethod.getHistoryListStr());
    localHippyMap1.pushString("guid", TKDAccountModule.getCurAccountInfo().qqNum);
    localHippyMap1.pushString("type", "homePage");
    localHippyMap1.pushString("hint", ResourceUtil.getString(2131718004));
    localHippyMap1.pushString("data", SearchHippyEventEmitter.mapToJsonStr(SearchHotwordHandler.getHotwordDataMap(this.hotwordHandler, null)));
    HippyMap localHippyMap2 = new HippyMap();
    localHippyMap2.pushInt("skinMode", 0);
    localHippyMap2.pushBoolean("isFullScreen", false);
    localHippyMap2.pushInt("orientation", paramViewGroup.getContext().getResources().getConfiguration().orientation);
    localHippyMap1.pushMap("qbConfig", localHippyMap2);
    return localHippyMap1;
  }
  
  public static boolean isHippyDebug()
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).getBoolean("SearchEntryHippyEngine.spkey_is_hippy_debug", false);
  }
  
  public static boolean isHippyOn()
  {
    boolean bool = false;
    if (iscmdHippyOn()) {
      return true;
    }
    AladdinConfig localAladdinConfig = Aladdin.getConfig(313);
    if (localAladdinConfig != null) {
      if (localAladdinConfig.getIntegerFromString("SearchPage_HippySwitch", -1) != 1) {}
    }
    for (bool = true;; bool = false)
    {
      if (!bool) {
        bass.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true);
      }
      return bool;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchentry.hippy.SearchEntryHippyEngine
 * JD-Core Version:    0.7.0.1
 */