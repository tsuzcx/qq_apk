package com.tencent.mobileqq.search.searchengine;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import java.util.ArrayList;
import java.util.List;

class NetSearchEngine$NetSearchRunnalbe$1
  extends FriendListObserver
{
  NetSearchEngine$NetSearchRunnalbe$1(NetSearchEngine.NetSearchRunnalbe paramNetSearchRunnalbe) {}
  
  protected void onSearchFriendResult(boolean paramBoolean1, int paramInt1, Object paramObject, int paramInt2, String paramString, boolean paramBoolean2, long paramLong, int paramInt3, List<ISearchResultGroupModel> paramList)
  {
    if (this.a.a != null) {
      NetSearchEngine.a(this.a.this$0).removeObserver(this.a.a);
    }
    if (NetSearchEngine.NetSearchRunnalbe.a(this.a)) {
      return;
    }
    if (paramInt1 == 86)
    {
      if (paramBoolean2) {
        return;
      }
      if (paramBoolean1)
      {
        if ((paramObject instanceof ArrayList)) {
          ThreadManager.post(new NetSearchEngine.ParseTask(this.a.this$0, NetSearchEngine.NetSearchRunnalbe.a(this.a), (ArrayList)paramObject, NetSearchEngine.NetSearchRunnalbe.a(this.a)), 10, null, true);
        }
      }
      else if (NetSearchEngine.NetSearchRunnalbe.a(this.a) != null) {
        NetSearchEngine.NetSearchRunnalbe.a(this.a).a(null, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.NetSearchEngine.NetSearchRunnalbe.1
 * JD-Core Version:    0.7.0.1
 */