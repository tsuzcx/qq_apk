package com.tencent.mobileqq.qqguildsdk.engine;

import com.tencent.mobileqq.qqguildsdk.callback.ISearchSink;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.manager.UserListMgr;
import com.tencent.mobileqq.qqguildsdk.search.model.UserSearchResultModel;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.ISearchMemberFromServerCallback;
import java.util.ArrayList;
import java.util.List;

class GPSAsynManagerEngine$9$1
  implements ISearchMemberFromServerCallback
{
  GPSAsynManagerEngine$9$1(GPSAsynManagerEngine.9 param9) {}
  
  public void a(int paramInt, String paramString1, String paramString2, boolean paramBoolean, List<IGProUserInfo> paramList)
  {
    if (paramInt == 0)
    {
      new ArrayList();
      this.a.d.onSearchResult(paramInt, paramString1, UserSearchResultModel.a(paramString2, paramList), true);
      return;
    }
    if (this.a.c == 1)
    {
      this.a.this$0.e().a(this.a.a, this.a.b, this.a.d, 4);
      return;
    }
    this.a.d.onSearchResult(paramInt, paramString1, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.engine.GPSAsynManagerEngine.9.1
 * JD-Core Version:    0.7.0.1
 */