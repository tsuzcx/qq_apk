package com.tencent.mobileqq.mini.entry.search.ui;

import android.text.TextUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.EditText;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager;

class MiniAppSearchFragment$3
  implements AbsListView.OnScrollListener
{
  MiniAppSearchFragment$3(MiniAppSearchFragment paramMiniAppSearchFragment) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramAbsListView.getLastVisiblePosition() == MiniAppSearchFragment.access$300(this.this$0).getCount() - 1) && (paramInt == 0))
    {
      paramAbsListView = MiniAppSearchFragment.access$200(this.this$0).getText().toString();
      if (!TextUtils.isEmpty(paramAbsListView)) {
        ((MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(QQManagerFactory.MINI_APP_SEARCH_MANAGER)).loadMoreSearchAppDataRequest(paramAbsListView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment.3
 * JD-Core Version:    0.7.0.1
 */