package com.tencent.mobileqq.search.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.search.FileSearchActivity;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.activity.ContactSearchActivity;
import com.tencent.mobileqq.search.activity.FunctionSearchActivity;
import com.tencent.mobileqq.search.activity.MessageSearchActivity;
import com.tencent.mobileqq.search.activity.PublicAcntSearchActivity;
import com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher;
import com.tencent.mobileqq.search.model.ISearchResultModel;
import com.tencent.mobileqq.search.model.SearchResultItem;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import cooperation.qqfav.globalsearch.FavoriteSearchActivity;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SearchActivityJumpFetcherImpl
  implements ISearchActivityJumpFetcher
{
  public void jumpToActiveEntitySearchActivity(Context paramContext, String paramString1, String paramString2, long[] paramArrayOfLong)
  {
    ActiveEntitySearchActivity.a(paramContext, paramString1, paramString2, paramArrayOfLong);
  }
  
  public void jumpToContactSearchActivity(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    ContactSearchActivity.a(paramContext, paramString, paramInt1, 197437, paramInt2);
  }
  
  public void jumpToContactSearchActivity(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    ContactSearchActivity.a(paramContext, paramString, paramInt, 197437, paramBoolean);
  }
  
  public void jumpToFavoriteSearchActivity(Context paramContext, String paramString)
  {
    FavoriteSearchActivity.a(paramContext, paramString);
  }
  
  public void jumpToFileSearchActivity(Context paramContext, String paramString, List<ISearchResultModel> paramList, boolean paramBoolean, int paramInt)
  {
    FileSearchActivity.a(paramContext, paramString, paramList, paramBoolean, paramInt);
  }
  
  public void jumpToFunctionSearchActivity(Context paramContext, String paramString)
  {
    FunctionSearchActivity.a(paramContext, paramString);
  }
  
  public void jumpToMessageSearchActivity(Context paramContext, String paramString)
  {
    MessageSearchActivity.a(paramContext, paramString);
  }
  
  public void jumpToProfileCardActivity(Activity paramActivity, SearchResultItem paramSearchResultItem, AppInterface paramAppInterface, boolean paramBoolean, int paramInt)
  {
    AddFriendActivity.a(paramActivity, paramSearchResultItem, (QQAppInterface)paramAppInterface, paramBoolean, paramInt);
  }
  
  public void jumpToPublicAcntSearchActivity(Context paramContext, String paramString, int paramInt)
  {
    PublicAcntSearchActivity.a(paramContext, paramString, paramInt);
  }
  
  public void jumpToQQBrowserActivity(Context paramContext, Map<String, String> paramMap)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localIntent.putExtra(str, (String)paramMap.get(str));
    }
    paramContext.startActivity(localIntent);
  }
  
  public void jumpToSearchBaseActivity(Context paramContext, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, SearchContactsActivity.class);
    localIntent.putExtra("start_search_key", paramString);
    localIntent.putExtra("jump_src_key", 0);
    localIntent.putExtra("fromType", paramInt);
    paramContext.startActivity(localIntent);
  }
  
  public void jumpToStoryProfileActivity(Context paramContext, int paramInt, long paramLong)
  {
    StoryApi.a(paramContext, paramInt, paramLong);
  }
  
  public void jumpToTroopInfoActivity(Context paramContext, Bundle paramBundle, int paramInt)
  {
    TroopUtils.a(paramContext, paramBundle, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.api.impl.SearchActivityJumpFetcherImpl
 * JD-Core Version:    0.7.0.1
 */