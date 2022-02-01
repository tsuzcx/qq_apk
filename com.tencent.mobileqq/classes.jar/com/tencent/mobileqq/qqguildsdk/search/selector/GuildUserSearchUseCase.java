package com.tencent.mobileqq.qqguildsdk.search.selector;

import android.text.TextUtils;
import com.tencent.gprosdk.GProUser;
import com.tencent.mobileqq.qqguildsdk.callback.ISearchSink;
import com.tencent.mobileqq.qqguildsdk.data.GProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.search.util.SearchUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GuildUserSearchUseCase
{
  public static GuildUserSearchUseCase.ISearchTask a(String paramString, GuildUserSearchUseCase.AsyncSearchOption paramAsyncSearchOption, ISearchSink<IGProUserInfo> paramISearchSink)
  {
    paramString = new GuildUserSearchUseCase.AsyncSearchTask(paramAsyncSearchOption, paramString, paramISearchSink);
    paramString.a();
    return paramString;
  }
  
  public static List<IGProUserInfo> a(List<GProUser> paramList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      GProUser localGProUser = (GProUser)paramList.next();
      if (a(localGProUser, paramString)) {
        localArrayList.add(new GProUserInfo(localGProUser));
      }
    }
    return localArrayList;
  }
  
  private static boolean a(GProUser paramGProUser, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (!TextUtils.isEmpty(paramGProUser.getMemberName())) {
      return SearchUtils.a(paramGProUser.getMemberName(), paramString);
    }
    if (!TextUtils.isEmpty(paramGProUser.getNickName())) {
      return SearchUtils.a(paramGProUser.getNickName(), paramString);
    }
    return false;
  }
  
  private static String b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return "UNKNOWN";
            }
            return "SEARCH_CANCEL";
          }
          return "SEARCH_FINISH";
        }
        return "SEARCH_DATA";
      }
      return "LOADING_DATA";
    }
    return "TASK_INIT";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.search.selector.GuildUserSearchUseCase
 * JD-Core Version:    0.7.0.1
 */