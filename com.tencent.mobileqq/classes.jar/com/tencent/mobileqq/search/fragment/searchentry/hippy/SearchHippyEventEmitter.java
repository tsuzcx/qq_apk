package com.tencent.mobileqq.search.fragment.searchentry.hippy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.app.SearchWordHistoryManager;
import com.tencent.mobileqq.app.SearchWordHistoryManager.OnSearchHistoryChangeListener;
import com.tencent.mobileqq.search.fragment.searchentry.hotword.SearchHotwordHandler;
import com.tencent.mtt.hippy.common.HippyMap;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class SearchHippyEventEmitter
  implements SearchWordHistoryManager.OnSearchHistoryChangeListener
{
  private static final String MODULE_KEYBOARD_CHANGE = "@search:keyboardEvent";
  private static final String MODULE_SEARCH_COMMON_EVENT = "@search:commonEvent";
  @NonNull
  private final HippyQQEngine engine;
  @NonNull
  private final SearchHotwordHandler hotwordHandler;
  
  public SearchHippyEventEmitter(@NonNull HippyQQEngine paramHippyQQEngine, @NonNull SearchHotwordHandler paramSearchHotwordHandler)
  {
    this.engine = paramHippyQQEngine;
    this.hotwordHandler = paramSearchHotwordHandler;
    SearchWordHistoryManager.a(this);
  }
  
  public static String mapToJsonStr(Map<String, Object> paramMap)
  {
    String str = "";
    if (paramMap != null) {}
    try
    {
      str = new JSONObject(paramMap).toString();
      return str;
    }
    catch (Exception paramMap)
    {
      paramMap.printStackTrace();
    }
    return "";
  }
  
  private void sendSoftKeyboardEvent(int paramInt, String paramString)
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("action", paramString);
    localHippyMap.pushString("height", paramInt + "");
    this.engine.sendEvent("@search:keyboardEvent", localHippyMap);
  }
  
  public void destroy()
  {
    SearchWordHistoryManager.b(this);
  }
  
  public void onHistoryChanged()
  {
    sendCommonEvent(SearchHippyEventEmitter.CommonEvent.RequestHistory, null);
  }
  
  public void sendActiveEvent(boolean paramBoolean, String paramString, Map<String, Object> paramMap)
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {}
    for (String str = "create";; str = "other")
    {
      localHashMap.put("showType", str);
      localHashMap.put("openFrom", paramString);
      localHashMap.putAll(paramMap);
      sendCommonEvent(SearchHippyEventEmitter.CommonEvent.HomepageShow, localHashMap);
      sendCommonEvent(SearchHippyEventEmitter.CommonEvent.HomepageExpose, localHashMap);
      return;
    }
  }
  
  public void sendCommonEvent(@NonNull SearchHippyEventEmitter.CommonEvent paramCommonEvent, @Nullable Map<String, Object> paramMap)
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("cmd", paramCommonEvent.name());
    if (paramMap == null) {
      localHippyMap.pushString("data", "");
    }
    for (;;)
    {
      this.engine.sendEvent("@search:commonEvent", localHippyMap);
      return;
      localHippyMap.pushString("data", mapToJsonStr(paramMap));
    }
  }
  
  public void sendSoftKeyboardHideEvent()
  {
    sendSoftKeyboardEvent(0, SearchHippyEventEmitter.KeyboardAction.hide.name());
  }
  
  public void sendSoftKeyboardShowEvent(int paramInt)
  {
    sendSoftKeyboardEvent(paramInt, SearchHippyEventEmitter.KeyboardAction.show.name());
  }
  
  public void sendTextChangedEvent(@NonNull String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("word", paramString);
    localHashMap.put("inputTime", Long.valueOf(System.currentTimeMillis()));
    localHashMap.put("type", Integer.valueOf(1));
    sendCommonEvent(SearchHippyEventEmitter.CommonEvent.SmartBoxInput, localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchentry.hippy.SearchHippyEventEmitter
 * JD-Core Version:    0.7.0.1
 */