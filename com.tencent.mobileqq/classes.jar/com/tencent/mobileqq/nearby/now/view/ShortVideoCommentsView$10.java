package com.tencent.mobileqq.nearby.now.view;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.nearby.now.model.Comments;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import java.util.List;

class ShortVideoCommentsView$10
  implements AbsListView.OnScrollListener
{
  ShortVideoCommentsView$10(ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0)
    {
      paramAbsListView = ShortVideoCommentsView.access$1800(this.a).getChildAt(0);
      if ((paramAbsListView != null) && (paramAbsListView.getTop() == 0))
      {
        ShortVideoCommentsView.access$2000(this.a, true);
        return;
      }
      ShortVideoCommentsView.access$2000(this.a, false);
      return;
    }
    ShortVideoCommentsView.access$2000(this.a, false);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      if ((paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (this.a.mComments.a.size() > 0) && (!ShortVideoCommentsView.access$1100(this.a)) && (!ShortVideoCommentsView.access$1200(this.a))) {
        ShortVideoCommentsView.access$1300(this.a);
      }
      if (ShortVideoCommentsView.access$000(this.a) != null) {
        paramAbsListView = ShortVideoCommentsView.access$000(this.a).jdField_a_of_type_JavaLangString;
      }
      if (ShortVideoCommentsView.access$000(this.a) != null) {
        long l = ShortVideoCommentsView.access$000(this.a).jdField_a_of_type_Long;
      }
      paramInt = ShortVideoCommentsView.access$1400(this.a);
      if ((paramInt >= ShortVideoCommentsView.access$1500(this.a)) && (paramInt >= UITools.a(this.a.getContext(), 40.0F)))
      {
        if (!ShortVideoCommentsView.access$1600(this.a))
        {
          ShortVideoCommentsView.access$1602(this.a, true);
          int i = ShortVideoCommentsView.access$000(this.a).k;
        }
        this.a.showBottomeArea();
      }
      else if (!ShortVideoCommentsView.access$1700(this.a))
      {
        this.a.hideInputKeyboard();
        ShortVideoCommentsView.access$300(this.a, 2);
      }
      ShortVideoCommentsView.access$1502(this.a, paramInt);
      if ((ShortVideoCommentsView.access$1800(this.a) != null) && (ShortVideoCommentsView.access$1800(this.a).getChildCount() > 0) && (ShortVideoCommentsView.access$1800(this.a).getChildAt(0).getTop() == 0) && (!ShortVideoCommentsView.access$1700(this.a)))
      {
        ShortVideoCommentsView.access$1902(this.a, true);
        this.a.postDelayed(new ShortVideoCommentsView.10.1(this), 100L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView.10
 * JD-Core Version:    0.7.0.1
 */