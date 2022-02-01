package com.tencent.mobileqq.search.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.ISearchResultPositionModel;
import com.tencent.mobileqq.search.model.SearchMatchResult;

@QAPI(process={"all"})
public abstract interface ISearchUtilFetcher
  extends QRouteApi
{
  public abstract Drawable getFaceBitmap(IFaceDecoder paramIFaceDecoder, String paramString, int paramInt);
  
  public abstract CharSequence getHighLightApproximateMatchedMessageForMainTitle(AppInterface paramAppInterface, String paramString1, String paramString2, SearchMatchResult paramSearchMatchResult);
  
  public abstract CharSequence getHighLightMatchedMessage(String paramString1, String paramString2);
  
  public abstract CharSequence getHighLightMatchedMessageForMainTitle(AppInterface paramAppInterface, String paramString1, String paramString2);
  
  public abstract CharSequence getMessageWithParenthese(CharSequence paramCharSequence);
  
  public abstract void handleFeatureJump(Context paramContext, int paramInt1, int paramInt2);
  
  public abstract boolean isEntityGroup(long paramLong);
  
  public abstract boolean isGuildModel(ISearchResultModel paramISearchResultModel);
  
  public abstract boolean isTroopModel(ISearchResultModel paramISearchResultModel);
  
  public abstract boolean isUniteSearchActivity(Context paramContext);
  
  public abstract boolean isValidGroupMask(long paramLong);
  
  public abstract void report(Context paramContext, String paramString1, String paramString2);
  
  public abstract void report(String paramString1, String paramString2, int paramInt1, int paramInt2, String... paramVarArgs);
  
  public abstract void report(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String... paramVarArgs);
  
  public abstract void reportContactResultItemClick(ISearchResultPositionModel paramISearchResultPositionModel, View paramView);
  
  public abstract void reportJumpToAIOorProfile(String paramString, int paramInt, View paramView, boolean paramBoolean);
  
  public abstract void saveSearchHistory(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt);
  
  public abstract void selectContactResult(View paramView, ISearchResultPositionModel paramISearchResultPositionModel);
  
  public abstract void updateItemUsed(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.api.ISearchUtilFetcher
 * JD-Core Version:    0.7.0.1
 */