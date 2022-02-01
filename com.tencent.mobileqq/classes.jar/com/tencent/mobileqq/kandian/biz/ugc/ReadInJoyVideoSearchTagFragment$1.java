package com.tencent.mobileqq.kandian.biz.ugc;

import android.widget.ArrayAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.handler.TagInfo;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class ReadInJoyVideoSearchTagFragment$1
  extends ReadInJoyObserver
{
  ReadInJoyVideoSearchTagFragment$1(ReadInJoyVideoSearchTagFragment paramReadInJoyVideoSearchTagFragment) {}
  
  public void c(List<TagInfo> paramList)
  {
    ReadInJoyVideoSearchTagFragment.a(this.a).setNotifyOnChange(false);
    ReadInJoyVideoSearchTagFragment.a(this.a).clear();
    ReadInJoyVideoSearchTagFragment.a(this.a).setNotifyOnChange(true);
    ReadInJoyVideoSearchTagFragment.a(this.a).addAll(paramList);
    if (paramList.isEmpty()) {
      QQToast.makeText(this.a.getQBaseActivity(), 2131915534, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyVideoSearchTagFragment.1
 * JD-Core Version:    0.7.0.1
 */