package com.tencent.mobileqq.search.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.SearchResultItem;
import java.util.List;
import java.util.Map;

@QAPI(process={"all"})
public abstract interface ISearchActivityJumpFetcher
  extends QRouteApi
{
  public abstract void jumpToActiveEntitySearchActivity(Context paramContext, String paramString1, String paramString2, long[] paramArrayOfLong);
  
  public abstract void jumpToContactSearchActivity(Context paramContext, String paramString, int paramInt1, int paramInt2);
  
  public abstract void jumpToContactSearchActivity(Context paramContext, String paramString, int paramInt, boolean paramBoolean);
  
  public abstract void jumpToFavoriteSearchActivity(Context paramContext, String paramString);
  
  public abstract void jumpToFileSearchActivity(Context paramContext, String paramString, List<ISearchResultModel> paramList, boolean paramBoolean, int paramInt);
  
  public abstract void jumpToFunctionSearchActivity(Context paramContext, String paramString);
  
  public abstract void jumpToMessageSearchActivity(Context paramContext, String paramString);
  
  public abstract void jumpToProfileCardActivity(Activity paramActivity, SearchResultItem paramSearchResultItem, AppInterface paramAppInterface, boolean paramBoolean, int paramInt);
  
  public abstract void jumpToPublicAcntSearchActivity(Context paramContext, String paramString, int paramInt);
  
  public abstract void jumpToQQBrowserActivity(Context paramContext, Map<String, String> paramMap);
  
  public abstract void jumpToSearchBaseActivity(Context paramContext, String paramString, int paramInt);
  
  public abstract void jumpToStoryProfileActivity(Context paramContext, int paramInt, long paramLong);
  
  public abstract void jumpToTroopInfoActivity(Context paramContext, Bundle paramBundle, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher
 * JD-Core Version:    0.7.0.1
 */