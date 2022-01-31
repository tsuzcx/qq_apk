package com.tencent.mobileqq.mini.entry.search.ui;

import android.text.TextUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.EditText;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager;

class MiniAppSearchFragment$2
  implements AbsListView.OnScrollListener
{
  MiniAppSearchFragment$2(MiniAppSearchFragment paramMiniAppSearchFragment) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramAbsListView.getLastVisiblePosition() == MiniAppSearchFragment.access$100(this.this$0).getCount() - 1) && (paramInt == 0))
    {
      paramAbsListView = MiniAppSearchFragment.access$000(this.this$0).getText().toString();
      if (!TextUtils.isEmpty(paramAbsListView)) {
        ((MiniAppSearchDataManager)MiniAppUtils.getAppInterface().getManager(360)).loadMoreSearchAppDataRequest(paramAbsListView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.ui.MiniAppSearchFragment.2
 * JD-Core Version:    0.7.0.1
 */