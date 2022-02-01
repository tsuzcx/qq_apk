package com.tencent.mobileqq.search.fragment.searchentry.nativemethod;

import android.content.Context;
import com.google.gson.Gson;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SearchWordHistoryManager;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import org.json.JSONArray;

public class RequestHistoryDataMethod
  extends SearchNativeMethodBase
{
  public RequestHistoryDataMethod(Context paramContext, QQAppInterface paramQQAppInterface, INativeMethodHandler paramINativeMethodHandler)
  {
    super(paramContext, paramQQAppInterface, paramINativeMethodHandler);
  }
  
  public static String getHistoryListStr()
  {
    Object localObject = SearchWordHistoryManager.a().a();
    try
    {
      localObject = new Gson().toJson(localObject);
      return localObject;
    }
    catch (Exception localException)
    {
      label21:
      break label21;
    }
    return new JSONArray().toString();
  }
  
  public String getFuncName()
  {
    return "requestHistoryData";
  }
  
  public void onCallBack(HippyMap paramHippyMap, Promise paramPromise)
  {
    paramPromise.resolve(getHistoryListStr());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchentry.nativemethod.RequestHistoryDataMethod
 * JD-Core Version:    0.7.0.1
 */