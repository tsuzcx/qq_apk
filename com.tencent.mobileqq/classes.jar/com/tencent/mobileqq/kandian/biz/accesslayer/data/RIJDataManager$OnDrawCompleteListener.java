package com.tencent.mobileqq.kandian.biz.accesslayer.data;

import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListView.OnDrawCompleteListener;
import com.tencent.mobileqq.kandian.biz.framework.RIJPreloadImage;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.widget.ListView;

public class RIJDataManager$OnDrawCompleteListener
  implements ReadInJoyBaseListView.OnDrawCompleteListener
{
  RIJDataManager a;
  
  RIJDataManager$OnDrawCompleteListener(RIJDataManager paramRIJDataManager1, RIJDataManager paramRIJDataManager2)
  {
    this.a = paramRIJDataManager2;
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView)
  {
    if (!this.b.a().i()) {
      return;
    }
    this.b.a().e(false);
    this.b.a().v().a(paramReadInJoyBaseListView);
    this.b.a().h().a(this.b.a().v().d().getLastVisiblePosition() + 1, this.b.a().h().a(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.OnDrawCompleteListener
 * JD-Core Version:    0.7.0.1
 */