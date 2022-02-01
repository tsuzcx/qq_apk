package com.tencent.mobileqq.conditionsearch;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XListView;

class SearchResultActivity$1
  implements Handler.Callback
{
  SearchResultActivity$1(SearchResultActivity paramSearchResultActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return true;
            }
            this.a.a.springBackOverScrollHeaderView();
            return true;
          }
          this.a.a.springBackOverScrollHeaderView();
          return true;
        }
        this.a.a.springBackOverScrollHeaderView();
        QQToast.a(this.a, 2131694424, 0).b(this.a.getTitleBarHeight());
        return true;
      }
      SearchResultActivity.b(this.a);
      return true;
    }
    SearchResultActivity.a(this.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.SearchResultActivity.1
 * JD-Core Version:    0.7.0.1
 */