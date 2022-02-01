package com.tencent.mobileqq.kandian.biz.fastweb;

import android.view.View;
import com.tencent.qqlive.module.videoreport.page.IScrollReader;
import com.tencent.widget.AbsListView;

class FastWebActivity$8
  implements IScrollReader
{
  FastWebActivity$8(FastWebActivity paramFastWebActivity) {}
  
  public int readScroll(View paramView)
  {
    if ((paramView instanceof AbsListView)) {
      return ((AbsListView)paramView).getLastVisiblePosition();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.8
 * JD-Core Version:    0.7.0.1
 */