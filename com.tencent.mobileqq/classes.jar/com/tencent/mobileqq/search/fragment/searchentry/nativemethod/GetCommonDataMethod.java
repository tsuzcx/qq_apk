package com.tencent.mobileqq.search.fragment.searchentry.nativemethod;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.util.SearchConfigUtils;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.util.URLUtil;
import org.json.JSONObject;

public class GetCommonDataMethod
  extends SearchNativeMethodBase
{
  public GetCommonDataMethod(Context paramContext, QQAppInterface paramQQAppInterface, INativeMethodHandler paramINativeMethodHandler)
  {
    super(paramContext, paramQQAppInterface, paramINativeMethodHandler);
  }
  
  private HippyMap getCommonData()
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("seqno", UniteSearchActivity.d);
    localHippyMap.pushString("search_engine", "qb-page");
    localHippyMap.pushString("session_id", UniteSearchActivity.e);
    localHippyMap.pushString("engine_url", URLUtil.a(URLUtil.a(SearchConfigUtils.a(5, SearchConfigUtils.b(10)), "q"), "q", ""));
    localHippyMap.pushString("entryID", new JSONObject().toString());
    return localHippyMap;
  }
  
  public String getFuncName()
  {
    return "getCommonData";
  }
  
  public void onCallBack(HippyMap paramHippyMap, Promise paramPromise)
  {
    paramHippyMap = getCommonData();
    if (paramHippyMap != null)
    {
      paramPromise.resolve(paramHippyMap);
      return;
    }
    paramPromise.resolve("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchentry.nativemethod.GetCommonDataMethod
 * JD-Core Version:    0.7.0.1
 */