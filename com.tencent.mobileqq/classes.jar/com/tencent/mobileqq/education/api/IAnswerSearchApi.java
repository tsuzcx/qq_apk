package com.tencent.mobileqq.education.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;

@QAPI(process={"all"})
public abstract interface IAnswerSearchApi
  extends QRouteApi
{
  public abstract void reportEvent(String paramString, Map<String, String> paramMap);
  
  public abstract void showAnswerSearchResultByBase64(Activity paramActivity, int paramInt);
  
  public abstract void showAnswerSearchResultByFile(Activity paramActivity, String paramString, int paramInt);
  
  public abstract void startAnswerSearchPicEditActivity(Activity paramActivity, String paramString, int paramInt);
  
  public abstract void startAnswerSearchPicEditActivity(Activity paramActivity, String paramString, int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.education.api.IAnswerSearchApi
 * JD-Core Version:    0.7.0.1
 */