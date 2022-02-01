package com.tencent.mobileqq.search.api;

import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import org.json.JSONObject;

@QAPI(process={"all"})
public abstract interface ISearchReportFetcher
  extends QRouteApi
{
  public abstract void onActionContactSearchModel(ISearchResultModel paramISearchResultModel, View paramView, String paramString1, int paramInt, String paramString2);
  
  public abstract void onReportClick898(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString1, int paramInt3, int paramInt4, String paramString2, String paramString3);
  
  public abstract void onReportRuntimeDC02528(AppInterface paramAppInterface, long paramLong, String paramString1, String paramString2, JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.api.ISearchReportFetcher
 * JD-Core Version:    0.7.0.1
 */